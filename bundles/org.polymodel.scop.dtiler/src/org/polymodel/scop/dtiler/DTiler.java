package org.polymodel.scop.dtiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.dtiler.basic.TileLoop;
import org.polymodel.scop.dtiler.opt.LoopUnrollAndJam;

/**
 * DTiler. After tiling, each {@link AbstractScopStatement} is surrounded by tiles and
 * points loops. Sizes of the tiles are parametric. (cf.
 * http://doi.acm.org/10.1145/1250734.1250780)
 * 
 * @author antoine
 * 
 */
public class DTiler {
	
	/**
	 * DTiling for the entire SCoP. Extracts loop nests before applying DTiling.
	 * Does not alter the SCoP given.
	 * 
	 * @param clast
	 * @param options
	 * @return
	 */
	public static ScopRoot tile(ScopRoot scop, DTilingOptions options) {
		return tileWithDTilingOutput(scop, options).tiledScop;
	}
	
	public static ScopRoot tile(ScopRoot scop, DTilingOptions options, OptimizationOptions optopt){
		DTilingOutput output = tileWithDTilingOutput(scop, options);
		return LoopUnrollAndJam.generate(output.tiledScop, optopt);
	}
	
	public static DTilingOutput tileWithDTilingOutput(ScopRoot scop, DTilingOptions options) {

		ScopRoot copy = EcoreUtil.copy(scop);
		DTilingOutput output = new DTilingOutput(copy);
		
		//extract loop nests
		List<TilableBlock> blocks = extractTilableBlock(copy);
	
		//Tile each loop nest
		for (TilableBlock block : blocks) { 
			TiledBlock tiled = tile(block, options);
			//replace with the TilableBlock
			for (int i = 1; i < block.loops.size(); i++) {
				EcoreUtil.remove(block.loops.get(i));
			}
			EcoreUtil.replace(block.loops.get(0), tiled.tiledLoopStart);
			output.tilingBlocks.put(block, tiled);
		}
		
		return output;
	}
	
	/*
	 * untiledPointloopIterators contain the iterator names of loops which are 
	 * not tiled and is in the body of the tile. These iterator names should be 
	 * added to the private list of omp for pragma. Otherwise, generated code is 
	 * incorrect.
	 */
	public static TiledBlock tile(TilableBlock block, DTilingOptions options, 
			Set<String> untiledPointloopIterators) {
		ScopFor perfectNest = createPerfectlyNestedLoop(block);
		//The macro up(t; s) in the loop lower bound gives an integer p such that p = ceil(t/s) * s;
		
		//Then generate tile loop from the perfect loop nest
		TileLoop tileloop = options.tileLoopGenerator.generate(perfectNest, 
				untiledPointloopIterators);
		//generate point loops for the the perfect loop nest
		//Point loop
		AbstractScopNode points = null;
		{
			List<AbstractScopNode> nodes = new ArrayList<AbstractScopNode>(block.loops.size());
			for (ScopFor loop : block.loops) {
				nodes.add(EcoreUtil.copy(loop));
			}
			ScopBlock sblock = ScopUserFactory.scopBlock(nodes);
			points = options.pointLoopGenerator.generate(sblock);
		}
		//attach the point loops inside the tiled loop
		if (tileloop.innerMost instanceof ScopFor) {
			((ScopFor)tileloop.innerMost).setBody(ScopUserFactory.scopBlock(points));
		} else if (tileloop.innerMost instanceof ScopGuard) {
			((ScopGuard)tileloop.innerMost).setThenBody(points);
		} else if (tileloop.innerMost instanceof ScopBlock) {
			((ScopBlock)tileloop.innerMost).getStatements().add(points);
		}
		
		TiledBlock tiled = new TiledBlock(block, perfectNest, tileloop.start, points);
		

		return tiled;
	}
	
	public static TiledBlock tile(TilableBlock block, DTilingOptions options) {
		// IF there are no untiled loops in the body of the tile, then we create
		// an empty set for the loop iterator names and call the function with 
		// set of loop iterators.
		
		return tile(block, options, Collections.<String>emptySet());
		
		/*
		ScopFor perfectNest = createPerfectlyNestedLoop(block);
		//The macro up(t; s) in the loop lower bound gives an integer p such that p = ceil(t/s) * s;
		
		//Then generate tile loop from the perfect loop nest
		TileLoop tileloop = options.tileLoopGenerator.generate(perfectNest);
		//generate point loops for the the perfect loop nest
		//Point loop
		AbstractScopNode points = null;
		{
			List<AbstractScopNode> nodes = new ArrayList<AbstractScopNode>(block.loops.size());
			for (ScopFor loop : block.loops) {
				nodes.add(EcoreUtil.copy(loop));
			}
			ScopBlock sblock = ScopUserFactory.scopBlock(nodes);
			points = options.pointLoopGenerator.generate(sblock);
		}
		//attach the point loops inside the tiled loop
		if (tileloop.innerMost instanceof ScopFor) {
			((ScopFor)tileloop.innerMost).setBody(ScopUserFactory.scopBlock(points));
		} else if (tileloop.innerMost instanceof ScopGuard) {
			((ScopGuard)tileloop.innerMost).setThenBody(points);
		} else if (tileloop.innerMost instanceof ScopBlock) {
			((ScopBlock)tileloop.innerMost).getStatements().add(points);
		}
		
		TiledBlock tiled = new TiledBlock(block, perfectNest, tileloop.start, points);
		

		return tiled;
		*/
	}
	

	/**
	 * Extract a loop nest from a perfect loop nest (loopNest), which starts from start and ends at end
	 * @param start
	 * @param end
	 * @param loopNest
	 * @return
	 */
	public static ScopFor extractLoopNest(int start, int end, ScopFor loopNest){
		ScopFor extractedLoop = null;
		ScopFor currentDepth = null;
	
		//System.out.println("extract loop from " + start + "to " + end);
		int count = 0;
		ScopFor obj = loopNest;
		while(obj != null){
			count++;
			//System.out.println("current count: " + count);
			if((count >= start) && (count <= end)){
				ScopFor loop = ScopUserFactory.scopFor(((ScopFor) obj).getIterator(), ((ScopFor) obj).getLB(), ((ScopFor) obj).getUB(), ((ScopFor) obj).getStride(), null);
				if (extractedLoop == null) {
					extractedLoop = loop;
					currentDepth = extractedLoop;
				} else {
					currentDepth.setBody(ScopUserFactory.scopBlock(loop));
					currentDepth = loop;
				}
			}else if(count > end){
					break;
			}
			if(obj.getBody() instanceof ScopFor){
				obj = (ScopFor)obj.getBody();
			}else if(obj.getBody() instanceof ScopBlock){
				for(int i = 0; i < ((ScopBlock)obj.getBody()).getStatements().size(); i++){
					if(((ScopBlock)obj.getBody()).getStatements().get(i) instanceof ScopFor){
						obj = (ScopFor)((ScopBlock)obj.getBody()).getStatements().get(i);
						break;
					}
				}
			}
		}
		
		return extractedLoop;
	}
	
	
	public static List<TilableBlock> extractTilableBlock(ScopBlock block){
		return extractTilableBlock(block.getStatements());
	}
	
	
	public static List<TilableBlock> extractTilableBlock(ScopRoot root){
		return extractTilableBlock(root.getStatements());
	}
	/**
	 * Simple implementation that assumes a number of things in the input Scop.
	 * could/should be made more general by using Tom.
	 * - No ScopBlock
	 * - No nested ScopGuard
	 * - Every statement is contained by ScopFor
	 * - Every loop nest has the same depth 
	 * @param root
	 * @return
	 */
	public static List<TilableBlock> extractTilableBlock(List<AbstractScopNode> statements){
		List<TilableBlock> list = new LinkedList<TilableBlock>();
		
		TilableBlock currentBlock = new TilableBlock();
		for(AbstractScopNode stmt : statements){
			//For Loop
			if(stmt instanceof ScopFor){	//add for loop into the current tilable block
				currentBlock.loops.add((ScopFor)stmt);
			//Guard
			}else if(stmt instanceof ScopGuard){
				//use a loop of size 2 to avoid code duplication
				for (int i = 0; i < 2; i++) {
					AbstractScopNode node;
					if (i == 0) {
						//then case
						node = ((ScopGuard) stmt).getThenBody();
					} else {
						//else case
						node = ((ScopGuard) stmt).getElseBody();
					}
					//in a guard, it becomes a different block
					if (currentBlock.loops.size() > 0) {
						list.add(currentBlock);
						currentBlock = new TilableBlock();
					}
					if(node == null) continue;
					if (node instanceof ScopFor) {
						currentBlock.loops.add((ScopFor)node);
					} else if (node instanceof ScopBlock) {
						for (AbstractScopNode cnode : ((ScopBlock) node).getStatements()) {
							if (cnode instanceof ScopFor) {
								currentBlock.loops.add((ScopFor)cnode);
							} else {
								throw new RuntimeException("Failed to extract tilable blocks. The input scop must not have ScopBlock or AbstractScopStatements not surrounded by ScopFor");
							}
						}
					} else {
						throw new RuntimeException("Failed to extract tilable blocks. The input scop must not have ScopBlock or AbstractScopStatements not surrounded by ScopFor");
					}
				} 
			}
		}
		
		if (currentBlock.loops.size() > 0) {
			list.add(currentBlock);
		}
		
		return list;
	}
	
	/**
	 * Creates perfectly nested loop nest from a tilable block.
	 * For each depth, LB and UB are computed as min of LBs / max of UBs from different nests.
	 * It was written as Tom in the previous implementation, but was not really a good use of Tom. 
	 * 
	 * @param block
	 * @return
	 */
	public static ScopFor createPerfectlyNestedLoop(TilableBlock block) {
		
		ScopFor perfectlyNested = null; 
		ScopFor currentDepth = null;
		
		List<List<ScopFor>> loops = new LinkedList<List<ScopFor>>();
		loops.add(block.loops);
		
		while (true) {
			List<List<ScopFor>> next = new LinkedList<List<ScopFor>>();
			
			Variable iterator = null;
			IntExpression lb = null;
			IntExpression ub = null;
			IntExpression stride = IntExpressionBuilder.affine(IntExpressionBuilder.term(1));
			//iterate over each set of loops
			for (List<ScopFor> loopSet : loops) {
				//iterate over each loop
				for (int i = 0; i < loopSet.size(); i++) {
					//iterator
					if (iterator == null) {
						iterator = loopSet.get(i).getIterator();
					}
					//lower bound
					if (i == 0) {
						if (lb == null) {
							lb = loopSet.get(i).getLB().copy();
						} else {
							lb = IntExpressionBuilder.min(lb, loopSet.get(i).getLB().copy());
						}
					}
					//upper bound
					if (i == loopSet.size()-1) {
						if (ub == null) {
							ub = loopSet.get(i).getUB().copy();
						} else {
							ub = IntExpressionBuilder.max(ub, loopSet.get(i).getUB().copy());
						}
					}
					//collect all its child for next depth
					List<ScopFor> child = new LinkedList<ScopFor>();
					if (loopSet.get(i).getBody() instanceof ScopFor) {
						child.add((ScopFor)loopSet.get(i).getBody());
					} else if (loopSet.get(i).getBody() instanceof ScopBlock) {
						for (AbstractScopNode node : ((ScopBlock)(loopSet.get(i).getBody())).getStatements()) {
							if (node instanceof ScopFor) {
								child.add((ScopFor)node);
							}
						}	
					}
					if (child.size() > 0) {
						next.add(child);
					}
				}
			}
			//create loop for the current depth
			ScopFor loop = ScopUserFactory.scopFor(iterator, lb, ub, stride, null);
			if (perfectlyNested == null) {
				perfectlyNested = loop;
				currentDepth = perfectlyNested;
			} else {
				currentDepth.setBody(ScopUserFactory.scopBlock(loop));
				currentDepth = loop;
			}
			if (next.size() == 0) {
				break;
			}
			loops = next;
		}
		
		
		return (ScopFor)perfectlyNested.simplify();
	}
	
	public static class TilableBlock {
		public List<ScopFor> loops = new LinkedList<ScopFor>();
	}
	
	public static class TiledBlock {
		public final TilableBlock tilableBlock;
		public final AbstractScopNode perfectNest;
		public final AbstractScopNode tiledLoopStart;
		public final AbstractScopNode pointLoopStart;
		
		public TiledBlock(TilableBlock tilableBlock,  AbstractScopNode perfectNest, AbstractScopNode tiledLoopStart,AbstractScopNode pointLoopStart) {
			this.tilableBlock = tilableBlock;
			this.perfectNest = perfectNest;
			this.tiledLoopStart = tiledLoopStart;
			this.pointLoopStart = pointLoopStart;
		}
		
	}
}
