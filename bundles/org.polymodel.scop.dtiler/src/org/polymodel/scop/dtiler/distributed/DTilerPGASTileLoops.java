package org.polymodel.scop.dtiler.distributed;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.prod;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.basic.DTilerTileLoops;
import org.polymodel.scop.dtiler.basic.DTilerWaveFrontTileLoops;
import org.polymodel.scop.dtiler.basic.TileLoop;

public class DTilerPGASTileLoops extends DTilerWaveFrontTileLoops {
	
	public DTilerPGASTileLoops(DTilingOptions options) {
		super(options);
	}
	
	public TileLoop generate(ScopFor perfectNest) {
		Set<String> privates = collectIteratorNames(perfectNest);
		//also add start/end/time
		privates.add(options.getWFstart().getName());
		privates.add(options.getWFend().getName());
		privates.add(options.getWFtime().getName());
		
		//Get tile loop
		TileLoop tileLoop = (new DTilerTileLoops(options)).generate(perfectNest);
		
		//loop generated by the default tile loop generator should be ScopFor
		ScopFor tiles = (ScopFor)tileLoop.start;
		
		//get list of loops
		List<ScopFor> loops = extractLoops(tiles);
		
		List<AbstractScopNode> nodes = new LinkedList<AbstractScopNode>();
		//since library calls cannot be expressed as IntExpressions, define it as macro, and use the inline feature of code gen later
		nodes.add(ScopUserFactory.scopStatementMacro(options.forDist.PIDInitMacroName, new LinkedList<IntExpression>()));
		privates.add(options.forDist.getPID().getName());
		privates.add(options.forDist.getPartitioningChunkID().getName());
		privates.add(options.forDist.getPartitioningChunkMemoryID().getName());
		
		//create start and end assignments
		nodes.addAll(start(loops));
		nodes.addAll(end(loops));
		
		//add calls to getTileID
		addCallsToGetTileID(tileLoop);
		
		//create time loop
		ScopFor timeLoop = timeLoop(tileLoop);
		nodes.add(timeLoop);
		
		//add a guard of the innermost loop
		AbstractScopNode innermost = addGuardForInnerMostLoop(loops);
		
		//partition the outermost tile loop
		addLoopsForPartitioning(tileLoop);
		privates.add(options.forDist.getChunkOrigin().getName());
		
		//create a block since the tile loop now contains assignments
		ScopBlock block = ScopUserFactory.scopBlock(nodes);
		block.getScopAnnotations().add(ScopUserFactory.parallelBlockAnnotation(privates));
		
		return new TileLoop(block, innermost);
	}
	
	protected void addCallsToGetTileID(TileLoop tileLoop) {
		List<ScopFor> loops = tileLoop.innerMost.getSurroundingScopFors();
		for (int i = 0; i < loops.size(); i++) {
			//add initialization of tile ID
			ScopBlock block = ScopUserFactory.scopBlock(new ArrayList<AbstractScopNode>(0));
			block.getStatements().add(ScopUserFactory.scopStatementMacro(options.forDist.getTileMIDMacroName(i+1), new ArrayList<IntExpression>(0)));
			block.getStatements().add(loops.get(i).getBody());
			loops.get(i).setBody(block);
		}
	}
	
	/**
	 * Create a new loop and modify the fist tile loop so that different subsets of the first tile loop is visited by each processor. 
	 * 
	 * @param tileLoop
	 */
	protected void addLoopsForPartitioning(TileLoop tileLoop) {
		ScopFor firstTileLoop = (ScopFor)tileLoop.start;
		
		ScopBlock ploopBlock = ScopUserFactory.scopBlock(new ArrayList<AbstractScopNode>());
		ScopFor ploop = ScopUserFactory.scopFor(options.forDist.getChunkOrigin(), firstTileLoop.getLB().copy(), firstTileLoop.getUB().copy(), 
				affine(options.getTileSize(1)), ploopBlock);
		
		//add tiled annotation so that up transformation (up(t,s) = ceild(t,s)*s) is applied
		ploop.getScopAnnotations().add(ScopUserFactory.tileLoopAnnotation(options.getTileIndex(1), affine(options.getTileSize(1))));
		//this loop also needs a barrier after completing
		ploop.getScopAnnotations().add(ScopUserFactory.barrierAnnotation(false));
		
		//add offset to the start of the partitioning loop. offset = coef*pid*ts1 
		IntExpression offset = IntExpressionBuilder.prod(
								affine(term(options.forDist.getNumTilesPerChunk())),
								affine(term(options.forDist.getPID())),
								affine(options.getTileSize(1)));
		ploop.setLB(IntExpressionBuilder.sum(ploop.getLB(), offset));
		
		//change the stride to skip other processors range
		IntExpression stride = IntExpressionBuilder.prod(
									affine(term(options.forDist.getNumTilesPerChunk())),
									affine(term(options.forDist.getPCount())),
									affine(options.getTileSize(1)));
		ploop.setStride(stride);
		
		EcoreUtil.replace(firstTileLoop, ploop);
		//add 1 to chunkID each iteration FIXME
		//ceild(firstTileLoop.getIterator()
		//  -
		//firstTileLoop.getLB()
		//  - chunkSize*pid
		//, firstTileLoop.getStride())
		ploopBlock.getStatements().add(ScopUserFactory.scopStatementMacro(options.forDist.getChunkIDMacroName, new ArrayList<IntExpression>(0)));
		ploopBlock.getStatements().add(ScopUserFactory.scopStatementMacro(options.forDist.getChunkMemoryIDMacroName, new ArrayList<IntExpression>(0)));
//		ploop.getStatements().add(ScopUserFactory.assignment(options.forPGAS.getPartitioningChunkID(), 
//				affine(term(options.forPGAS.getPartitioningChunkID()), term(1))));
		ploopBlock.getStatements().add(firstTileLoop);
		
		//modify the first tile loop so that partitioned block is visited
		firstTileLoop.getScopAnnotations().clear();//remove tile loop annotation
		//ti1 = pstart; ti1 < pstart+poffsetCoef*ts1; ti1+=ts1
		firstTileLoop.setLB(affine(term(options.forDist.getChunkOrigin())));
		firstTileLoop.setStride(affine(options.getTileSize(1)));
		IntExpression UB = IntExpressionBuilder.sum(
								affine(term(options.forDist.getChunkOrigin())),
									IntExpressionBuilder.prod(
										affine(term(options.forDist.getNumTilesPerChunk())),
										affine(options.getTileSize(1))
									),
								affine(term(-1))
							);
		//take the min with the original UB
		firstTileLoop.setUB(IntExpressionBuilder.min(UB, firstTileLoop.getUB()));
		
//		for(pstart=ceild(xxx+poffsetcoef*ts1*pid, ts1); pstart <= M; pstart+=ts1*poffsetcoef*numP)
//			for (ti1=pstart; ti1 <= pstart+poffsetcoef*ts1; ti1+=ts1)
		
	}
	
	@Override
	protected AbstractScopNode addGuardForInnerMostLoop(List<ScopFor> loops) {
		ScopGuard llguard = (ScopGuard)super.addGuardForInnerMostLoop(loops);
		
		//add macros for copying in and copying out
		ScopStatementMacro mid = ScopUserFactory.scopStatementMacro(options.forDist.getTileMIDMacroName(loops.size()), new ArrayList<IntExpression>(0));
		ScopStatementMacro copyIn  = ScopUserFactory.scopStatementMacro(options.forDist.recvStartFunctionName, new ArrayList<IntExpression>());
		ScopStatementMacro copyOut = ScopUserFactory.scopStatementMacro(options.forDist.sendFunctionName, new ArrayList<IntExpression>());
		ScopBlock points = ScopUserFactory.scopBlock(new ArrayList<AbstractScopNode>());
		ScopBlock thenBlock = ScopUserFactory.scopBlock(new ArrayList<AbstractScopNode>());
		thenBlock.getStatements().add(mid);
		thenBlock.getStatements().add(copyIn);
		thenBlock.getStatements().add(points);
		thenBlock.getStatements().add(copyOut);
		llguard.setThenBody(thenBlock);
		
		return points;
	}
	
	@Override
	protected IntExpression getTileSizeExpression(int dim) {
//		return super.getTileSizeExpression(dim);
		if (dim > 1) {
			return super.getTileSizeExpression(dim);
		//t1 is multiplied by chunksize
		} else {
			return prod(super.getTileSizeExpression(dim), affine(term(options.forDist.getNumTilesPerChunk())));
		}
	}
}
