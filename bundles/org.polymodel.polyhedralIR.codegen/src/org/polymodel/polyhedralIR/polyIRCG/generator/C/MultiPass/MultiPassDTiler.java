package org.polymodel.polyhedralIR.polyIRCG.generator.C.MultiPass;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.ScopGenerator;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.cgenerator2.CGenerator;
import org.polymodel.scop.dtiler.DTiler;
import org.polymodel.scop.dtiler.DTiler.TilableBlock;
import org.polymodel.scop.dtiler.DTiler.TiledBlock;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.OptimizationOptions;
import org.polymodel.scop.dtiler.basic.DTilerOptimizedPointLoops;
import org.polymodel.scop.dtiler.basic.DTilerWaveFrontTileLoops;
import org.polymodel.scop.dtiler.basic.DTilingTools;
import org.polymodel.scop.dtiler.basic.TileLoop;

import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;



/** 
 * MultiPass DTiler
 * points loops. Sizes of the tiles are parametric. 
 * 
 * @author yun
 * 
 */
public class MultiPassDTiler{
	protected static final PolyIRCGUserFactory _polyIRCGfact = PolyIRCGUserFactory.INSTANCE;
	protected static final PolyhedralIRUserFactory _polyIRfact = PolyhedralIRUserFactory.eINSTANCE;
	
	protected final MultiPassDTilerOptions multiPassDTilerOptions;
	protected final OptimizationOptions dtilerOptimizationOptions;
	
	protected static boolean DEBUG = false;
	
	protected MultiPassDTiler(MultiPassDTilerOptions _options){
		this.multiPassDTilerOptions = _options;
		this.dtilerOptimizationOptions = null;
	}
	
	protected MultiPassDTiler(MultiPassDTilerOptions _options, OptimizationOptions _optOptions){
		this.multiPassDTilerOptions = _options;
		this.dtilerOptimizationOptions = _optOptions;
	}
	
	///////CURRENT HACKING FOR DTILER, HAS TO BE REMOVED//////
	public static ScopRoot tileDTiling(ScopRoot scop, ParameterDomain paramDom, DTilingOptions options) {

		ScopRoot copy = EcoreUtil.copy(scop);
	
		//extract loop nests
		List<TilableBlock> blocks = DTiler.extractTilableBlock(copy);
	
		//Tile each loop nest
		for (TilableBlock block : blocks) { 
			TiledBlock tiled = tile(block, paramDom, options);
			//replace with the TilableBlock
			for (int i = 1; i < block.loops.size(); i++) {
				EcoreUtil.remove(block.loops.get(i));
			}
			EcoreUtil.replace(block.loops.get(0), tiled.tiledLoopStart);
		}
		
		return copy;
	}
	
	public static ScopRoot tileDTiling(ScopRoot scop, ParameterDomain paramDom, DTilingOptions options, OptimizationOptions optOptions) {
		ScopRoot copy = EcoreUtil.copy(scop);
		
		//extract loop nests
		List<TilableBlock> blocks = DTiler.extractTilableBlock(copy);
	
		//Tile each loop nest
		for (TilableBlock block : blocks) { 
			TiledBlock tiled = tile(block, paramDom, options);
			
			//replace with the TilableBlock
			for (int i = 1; i < block.loops.size(); i++) {
				EcoreUtil.remove(block.loops.get(i));
			}
			EcoreUtil.replace(block.loops.get(0), tiled.tiledLoopStart);
		}
		return copy;
	}
	
	public static TiledBlock tile(TilableBlock block, ParameterDomain paramDom, DTilingOptions options) {
		TilableBlock perfectBlock = createBoundingConvexBlock(paramDom, block);
		ScopFor perfectNest =DTiler.createPerfectlyNestedLoop(perfectBlock);
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
	}
	////////////////////////////
	public static ScopRoot generateScop(ScopRoot scop, ParameterDomain paramDom, MultiPassDTilerOptions multiPassOptions){
		//reinitialize the total number of dimensions for the scop
		int total_dim = MultiPassDTilingTools.getMaxDimensions(scop);
		multiPassOptions.total_dim = total_dim;
		
		MultiPassDTiler multiPassDTiler = new MultiPassDTiler(multiPassOptions);
		
		return multiPassDTiler.tileMultiPassFlattened(scop, paramDom);
	}
	
	public static ScopRoot generateScop(ScopRoot scop, ParameterDomain paramDom, MultiPassDTilerOptions multiPassOptions, OptimizationOptions optOptions){
		//reinitialize the total number of dimensions for the scop
		int total_dim = MultiPassDTilingTools.getMaxDimensions(scop);
		multiPassOptions.total_dim = total_dim;
		
		MultiPassDTiler multiPassDTiler = new MultiPassDTiler(multiPassOptions, optOptions);
		
		return multiPassDTiler.tileMultiPassFlattened(scop, paramDom);
	}
	
	/**
	 * Generate sequential flattened multi-pass (FMP) code for the whole scop
	 * @param scop
	 * @param paramDom
	 * @return the scop root
	 */
	private ScopRoot tileMultiPassFlattened(ScopRoot scop, ParameterDomain paramDom){
		//make a copy of the original scop
		ScopRoot copy = EcoreUtil.copy(scop);
		
		ParameterDomain paramDomCopy = paramDom.copy().toParameterDomain();//make a copy of the original domain
	
		//extract tilable block from the whole program
		List<TilableBlock> blocks = DTiler.extractTilableBlock(copy);
		for(TilableBlock block: blocks){
			tileMultiPassForTilableBlock(paramDomCopy, block);
		}
		
		return copy;
	}
	
	/**
	 * generate the sequential FMP for a tilable block
	 * @param paramDom
	 * @param block
	 * @return
	 */
	protected MultiPassTiledLoop tileMultiPassForTilableBlock(ParameterDomain paramDom, TilableBlock block){
		int total_dim = MultiPassDTilingTools.getMaxDimensions(block);	
		//save a copy of the original block for the point loop generation
		TilableBlock tilable_block_copy = new TilableBlock();
		List<ScopFor> loops = new LinkedList<ScopFor>();
		for(ScopFor loop: block.loops){
			loops.add(EcoreUtil.copy(loop));
		}
		tilable_block_copy.loops = loops;
		
		//create a tilable block with single convex polyhedron for all the statements in the block
		TilableBlock convexBlock = createBoundingConvexBlock(paramDom, block);
		//get the tiled loops
		MultiPassTiledBlock multiPassBlock = generateMultiPassTiledLoops(paramDom, convexBlock);
	
		//get the point loops
		AbstractScopNode points = tilePointLoops(paramDom, tilable_block_copy);
		List<ScopFor> tiledLoops = DTilingTools.extractTiledLoops((ScopFor)multiPassBlock.permutedLastLevel.tiledLoopStart);
		tiledLoops.get(total_dim - 1).setBody(points);
	
		//fusing the fist level passes with the the first tiled loop
		MultiPassTiledLoop tiledLoop = fusePasses(multiPassBlock);
		
		//replace the tiled start of the first block with the current tiledloop start
		EcoreUtil.replace(multiPassBlock.pass1.tiledLoopStart, tiledLoop.start);
		
		//replace the old block with the new loop
		for (int k = 1; k < block.loops.size(); k++) {
			EcoreUtil.remove(block.loops.get(k));
		}
		EcoreUtil.replace(block.loops.get(0), tiledLoop.start);
				
		return tiledLoop;
	}
	
	/**
	 * Generate the tiled loops for the multi-pass strategy without flattening
	 * @param paramDom
	 * @param block
	 * @return a perfectly nest loop with tiled loop for passes and tiled loop for each pass
	 */
	private MultiPassTiledBlock generateMultiPassTiledLoops(ParameterDomain paramDom, TilableBlock block){		
		int total_dim = MultiPassDTilingTools.getMaxDimensions(block);	
		DTilerTiledBlock prevPassBlock = null;
		
		/*Apply first level tiling to the outermost loop for the outermost pass loop*/
		DTilerTiledBlock firstPassBlock = tileOutermostPass(paramDom, block);
		prevPassBlock = firstPassBlock;
			
		//extend the parameter domain with the tiled loop bounds
		paramDom = extendParamerterDomainWithTiledLoops(paramDom, firstPassBlock.tiledBlock, firstPassBlock.options.tilingBand.offsets);
		if(DEBUG)
			System.out.println("current parameter domain: " + paramDom);
		
		/*Apply second level tiling for the inner pass loop*/
		DTilerTiledBlock secondPassBlock = null;
		if(total_dim - 2 > 0){	//if further tiling is needed
			//extract the point loop for the second level tiling
			TilableBlock point_block_pass = extractPointBlockFromTiledBlock(firstPassBlock.tiledBlock);
			secondPassBlock = tileInnerPass(paramDom, point_block_pass);
			prevPassBlock = secondPassBlock;
			//extend the parameter domain
			List<IntExpression> offsets = new LinkedList<IntExpression>();
			for(int i = 1; i < total_dim - 1; i++){
				offsets.add(secondPassBlock.options.tilingBand.getOffset(i));
			}
			paramDom = extendParamerterDomainWithTiledLoops(paramDom, secondPassBlock.tiledBlock, offsets);
			//attach the second level pass loop inside the outermost pass loop
			for(int i = 0; i < point_block_pass.loops.size(); i++){
				EcoreUtil.remove(point_block_pass.loops.get(i));
			}
			((ScopFor)firstPassBlock.tiledBlock.tiledLoopStart).setBody(secondPassBlock.tiledBlock.tiledLoopStart);
		}

		/*Apply last level tiling to the whole point loops*/
		//extract the tilable block
		TilableBlock point_block = extractPointBlockFromTiledBlock(prevPassBlock.tiledBlock);
		LastLevelTiledBlock lastLevelBlock =  tileLastLevel(paramDom, point_block);
		
		//replace the point loops start of the previous pass with the permuted tiled loops of the last level
		EcoreUtil.replace(prevPassBlock.tiledBlock.pointLoopStart, lastLevelBlock.permutedLastLevel.tiledLoopStart);
		
		//construct the output
		TiledBlock secondBlock = null;
		if(secondPassBlock != null)		secondBlock = secondPassBlock.tiledBlock;
		MultiPassTiledBlock multiPassBlock = new MultiPassTiledBlock(firstPassBlock.tiledBlock, secondBlock, lastLevelBlock.oriLastLevel,  lastLevelBlock.permutedLastLevel, lastLevelBlock.lastLevelOffsets);
		
		return multiPassBlock;
	}
	
	private static ParameterDomain extendParamerterDomainWithTiledLoops(ParameterDomain paramDom, TiledBlock tiledBlock, List<IntExpression> lower_bounds){
		//extract the tiled loops
		List<ScopFor> tiledLoops = DTilingTools.extractTiledLoops((ScopFor)tiledBlock.tiledLoopStart);
		//extract the constraint from the tiled loop
		List<List<IntConstraint>> loopConstraints = new LinkedList<List<IntConstraint>>();
		List<Variable> indices = new LinkedList<Variable>();
		for(int i = 0; i < tiledLoops.size(); i++){
			ScopFor cur_for = tiledLoops.get(i);
			Variable cur_var = cur_for.getIterator();
			indices.add(cur_var);
			//add constraints for the current loop
			IntExpression var_exp = IntExpressionBuilder.affine(cur_var);
			IntExpression lb_exp = lower_bounds.get(i).simplify();
			List<List<IntConstraint>> lb_constraints = new LinkedList<List<IntConstraint>>();
			if(!(lb_exp instanceof ReductionExpression) || (((ReductionExpression)lb_exp).getOperator() != ReductionOperator.MIN)){
				lb_constraints = MultiPassDTilingTools.createConstraints(lb_exp, var_exp, ComparisonOperator.LE, ReductionOperator.MAX);
			}
			IntExpression ub_exp = cur_for.getUB().copy();
			List<List<IntConstraint>> ub_constraints = MultiPassDTilingTools.createConstraints(ub_exp, var_exp, ComparisonOperator.GE, ReductionOperator.MIN);
//			System.out.println("lb constraint size " + lb_constraints.size() + "ub constraint size " + ub_constratints.size());
			List<List<IntConstraint>> cur_for_constraints = MultiPassDTilingTools.constraintsProduct(lb_constraints, ub_constraints);
//			
//			System.out.println("current for constraint size " + cur_for_constraints.size());
			//product the constraints for current level with the previous levels
			loopConstraints = MultiPassDTilingTools.constraintsProduct(loopConstraints, cur_for_constraints);
		}
	
		Domain domain = MultiPassDTilingTools.createDomainWithConstraintsList(paramDom, indices, loopConstraints);
		domain.simplify();
		
		return domain.toParameterDomain();
	}
	
	/////////////////////////////////////Functions for MultiPass Tilings ////////////////////////////////////////
	/**
	 * Tile the outermost loop for the outermost pass loop
	 * @param paramDom
	 * @param block
	 * @return
	 */
	private DTilerTiledBlock tileOutermostPass(ParameterDomain paramDom, TilableBlock block){
		//save the body of the outermost loop
		Map<String, AbstractScopNode> stmt_body_map = DTilingTools.replaceForBodyWithStatement(block, 1, "tiling_stmt");
		
		//create the DTiling Option for the first level tiling
		DTilingOptions options = initialDTilingOptions(paramDom, block, 1, 1, 1, true);
		
		TiledBlock tiledBlock = DTiler.tile(block, options);
		
		//replace the tilable block with tiled block
		for (int k = 1; k < block.loops.size(); k++) {
			EcoreUtil.remove(block.loops.get(k));
		}
		
		//attach back the body of the first loop
		DTilingTools.replaceStatementWithBody((ScopFor)tiledBlock.tiledLoopStart, stmt_body_map, "tiling_stmt");
		EcoreUtil.replace(block.loops.get(0), tiledBlock.tiledLoopStart);
		
		return new DTilerTiledBlock(options, tiledBlock);
	}
	
	/**
	 * Tile the inner loops for the inner pass loops
	 * We tile all the outer total_dim - 1 dimensions for the point loops of the first level tiling 
	 * with the same tile index and tile size name, and then peel out the outermost tiled loop
	 * @param paramDom
	 * @param block
	 * @param total_dim
	 * @param multiPassOptions
	 * @return
	 */
	private DTilerTiledBlock tileInnerPass(ParameterDomain paramDom, TilableBlock block){
		//save the innermost statement block
		Map<String, AbstractScopNode> stmt_body_map = DTilingTools.replaceForBodyWithStatement(block, this.multiPassDTilerOptions.total_dim, "tiling_stmt");
		
		//apply tiling on the loop set
		DTilingOptions options = initialDTilingOptionsForSecondPass(paramDom, block);
		TiledBlock tiledBlock = DTiler.tile(block, options);
		
		//peel out the outer most tiled loop
		ScopFor tiledLoop = null;
		if(((ScopFor)tiledBlock.tiledLoopStart).getBody() instanceof ScopFor){
			tiledLoop = (ScopFor)((ScopFor)tiledBlock.tiledLoopStart).getBody();
		}else{	//must be a scopBlock
			for(AbstractScopNode stmt: ((ScopBlock)((ScopFor)tiledBlock.tiledLoopStart).getBody()).getStatements()){
				if(stmt instanceof ScopFor){
					tiledLoop = (ScopFor) stmt;
					break;
				}
			}
		}
		((ScopFor)tiledBlock.tiledLoopStart).setBody(null);
		
		//attach back the Body
		DTilingTools.replaceStatementWithBody(tiledLoop, stmt_body_map, "tiling_stmt");
		TiledBlock finalTiledBlock = new TiledBlock(tiledBlock.tilableBlock, tiledBlock.perfectNest, tiledLoop, tiledBlock.pointLoopStart);
		return new DTilerTiledBlock(options, finalTiledBlock);
	}
	
	/**
	 * generate tiled loops for each pass
	 * First create a loop nest that scans exactly the points for each pass, whose first iteration point is leximin of the pass domain
	 * TODO: The first iteration point should be figured out from the leximin of the domain, leximin currently is not doing correct thing
	 * @param paramDom
	 * @param block
	 * @param total_dim
	 * @return
	 */
	private LastLevelTiledBlock tileLastLevel(ParameterDomain paramDom, TilableBlock block){
		//extract domain for the current tilable block
		Domain domain = extractBoundingDomainForTilableBlock(paramDom, block);
		
		//generate scop for the original domain
		ScopRoot ori_scop = generateScopForDomain(paramDom, domain.copy(), null);
		//extract tilable block
		TilableBlock ori_block = DTiler.extractTilableBlock(ori_scop).get(0);
		
		DTilingOptions ori_options = initialDTilingOptions(paramDom, ori_block, 3, 1, this.multiPassDTilerOptions.total_dim, false);
		TiledBlock oriTiledBlock = DTiler.tile(ori_block, ori_options);
		
		//permuted the domain
		//construct a permutation function to permute the innermost loop to the outermost (i,...,j,k ->k,i,...j)
		List<AffineExpression> exprs = new LinkedList<AffineExpression>();
		List<Variable> vars = domain.getIndices();
		int size = vars.size();
		if(size > 0){	//add the last indices
			AffineExpression expr = IntExpressionBuilder.affine(vars.get(size - 1));
			exprs.add(expr);
		}
		for(int i = 0; i < size - 1; i++){
			AffineExpression expr = IntExpressionBuilder.affine(vars.get(i));
			exprs.add(expr);
		}
		AffineFunction function = _polyIRfact.createAffineFunction(domain.getParams(), domain.getIndices(), exprs);
		ScopRoot permuted_scop = generateScopForDomain(paramDom, domain.copy(), function);
		TilableBlock permuted_block = DTiler.extractTilableBlock(permuted_scop).get(0);

		//apply tiling to the permuted block with the same offset of the original block
		DTilingOptions permuted_options = initialDTilingOPtionsForPermutedLastLevel(paramDom, permuted_block, ori_options.tilingBand.offsets);
		TiledBlock permutedtiledBlock = DTiler.tile(permuted_block, permuted_options);
		
		return new LastLevelTiledBlock(oriTiledBlock, permutedtiledBlock, ori_options.tilingBand.offsets);
	}
	
	/**
	 * Get the point loops using the original loop nest
	 * @param paramDom
	 * @param block
	 * @param total_dim
	 * @return
	 */
	private AbstractScopNode tilePointLoops(ParameterDomain paramDom, TilableBlock block){
		//get the point loops for the first level tiling
		//save the last loop and  statement block
		Map<String, AbstractScopNode> stmt_body_map = DTilingTools.replaceForBodyWithStatement(block, this.multiPassDTilerOptions.total_dim - 1, "tiling_stmt");
		//Initialize dtiling options
		DTilingOptions l1_options = new DTilingOptions(1, new LinkedList<Integer>(), 1, this.multiPassDTilerOptions.total_dim - 1);
		//set pass prefix
		l1_options.setTileIndexPrefix(this.multiPassDTilerOptions.passIndexPrefix);
		l1_options.setTileSizePrefix(this.multiPassDTilerOptions.passSizePrefix);
		List<String> tileIndices = new LinkedList<String>();
		List<String> tileSizes = new LinkedList<String>();
		//set the pass index name and pass size name 
		String firstPassIndex = this.multiPassDTilerOptions.getPassIndexName(1, 1);
		String firstPassSize = this.multiPassDTilerOptions.getPassSizeName(1, 1);
		tileIndices.add(firstPassIndex);
		tileSizes.add(firstPassSize);
		for(int i = 2; i <= this.multiPassDTilerOptions.total_dim - 1; i++){  
			tileIndices.add(this.multiPassDTilerOptions.getPassIndexName(i, 2));
			tileSizes.add(this.multiPassDTilerOptions.getPassSizeName(i, 2));
		}
		l1_options.tilingBand.setTileIndexName(tileIndices);
		l1_options.tilingBand.setTileSizeName(tileSizes);
		
		//create a scop block
		List<AbstractScopNode> nodes = new ArrayList<AbstractScopNode>(block.loops.size());
		for (ScopFor loop : block.loops) {
			nodes.add(loop);
		}
		ScopBlock sblock = ScopUserFactory.scopBlock(nodes);
		ScopBlock l1_points = (ScopBlock)l1_options.pointLoopGenerator.generate(sblock);
		
		//Attach black the last loop
		DTilingTools.replaceStatementWithBody(l1_points, stmt_body_map, "tiling_stmt");
		
		//apply the second level tiling to all the loops to get the final point loops
		DTilingOptions l2_options = new DTilingOptions(3, new LinkedList<Integer>(), 1, this.multiPassDTilerOptions.total_dim);
		if(this.multiPassDTilerOptions.vectorizable || (this.dtilerOptimizationOptions != null && this.dtilerOptimizationOptions.optimizedPointLoop != null)){
			l2_options.vectorizable = true;
		}
		if(this.dtilerOptimizationOptions != null && this.dtilerOptimizationOptions.optimizedPointLoop != null){
			l2_options.numberOfTiledDimensions = this.dtilerOptimizationOptions.numberOfTiledDimensions;
			l2_options.pointLoopGenerator = new DTilerOptimizedPointLoops(l2_options, this.dtilerOptimizationOptions);
		}
		AbstractScopNode points = l2_options.pointLoopGenerator.generate(l1_points);
		
		return points;
	}

	////////////////////////////////////////////Functions for initializing DTiling Options for the multi-pass strategy
	private DTilingOptions initialDTilingOptions(ParameterDomain paramDom, TilableBlock tilableBlock, int level, int start, int end, boolean isPass){
		DTilingOptions options = new DTilingOptions(level, new LinkedList<Integer>(), start, end);
		
		if(isPass){	//set the prefix for the pass index and pass size
			options.setTileIndexPrefix(this.multiPassDTilerOptions.passIndexPrefix);
			options.setTileSizePrefix(this.multiPassDTilerOptions.passSizePrefix);
		}else{
			options.setTileIndexPrefix(this.multiPassDTilerOptions.tileIndexPrefix);
			options.setTileSizePrefix(this.multiPassDTilerOptions.tileSizePrefix);
		}
		
		//extract the perfectly nested loops 
		ScopFor perfectNest = DTiler.createPerfectlyNestedLoop(tilableBlock);
		List<IntExpression> offsets = MultiPassDTilingTools.extractOffsets(perfectNest);

		options.tilingBand.setOffsets(offsets);
		
		return options;
	}
	
	private DTilingOptions initialDTilingOPtionsForPermutedLastLevel(ParameterDomain paramDom, TilableBlock tilableBlock, List<IntExpression> offsets){
		int level = 3;
		DTilingOptions options = initialDTilingOptions(paramDom, tilableBlock, level, 1, this.multiPassDTilerOptions.total_dim, false);
		
		//create tile index and tile size names for the band
		List<String> tileIndexName = new LinkedList<String>();
		List<String> tileSizeName = new LinkedList<String>();
		//add the title size for the first dim
		String firstIndexName = this.multiPassDTilerOptions.getTileIndexName(this.multiPassDTilerOptions.total_dim, level);
		String firstSizeName = this.multiPassDTilerOptions.getTileSizeName(this.multiPassDTilerOptions.total_dim, level);
		tileIndexName.add(firstIndexName);
		tileSizeName.add(firstSizeName);
		for(int i = 1; i <= this.multiPassDTilerOptions.total_dim - 1; i++){
			String indexName = this.multiPassDTilerOptions.getTileIndexName(i, level);
			String sizeName = this.multiPassDTilerOptions.getTileSizeName(i, level);
			tileIndexName.add(indexName);
			tileSizeName.add(sizeName);
		}
		
		options.tilingBand.setTileIndexName(tileIndexName);
		options.tilingBand.setTileSizeName(tileSizeName);
		
		//reset the offsets with the original offsets
		List<IntExpression> permuted_offsets = new LinkedList<IntExpression>();
		permuted_offsets.add(offsets.get(this.multiPassDTilerOptions.total_dim - 1));
		for(int i = 0; i < this.multiPassDTilerOptions.total_dim - 1; i++){
			permuted_offsets.add(offsets.get(i));
		}
		
		options.tilingBand.setOffsets(permuted_offsets);
		
		return options;
	}
	
	private DTilingOptions initialDTilingOptionsForSecondPass(ParameterDomain paramDom, TilableBlock tilableBlock){
		int level = 2;
		DTilingOptions options = initialDTilingOptions(paramDom, tilableBlock, level, 1, this.multiPassDTilerOptions.total_dim-1, true);
		
		//create tile index and tiles size names for the band
		List<String> tileIndexName = new LinkedList<String>();
		List<String> tileSizeName = new LinkedList<String>();
		//use the same tile index and tile size for the first dimension for the first level
		String firstIndex = this.multiPassDTilerOptions.getPassIndexName(1, 1);
		String firstSize = this.multiPassDTilerOptions.getPassSizeName(1, 1);
		tileIndexName.add(firstIndex);
		tileSizeName.add(firstSize);
		for(int i = 2; i <= this.multiPassDTilerOptions.total_dim - 1; i++){
			String indexName = this.multiPassDTilerOptions.getPassIndexName(i, level);
			String sizeName = this.multiPassDTilerOptions.getPassSizeName(i, level);
			tileIndexName.add(indexName);
			tileSizeName.add(sizeName);
		}
		
		options.tilingBand.setTileIndexName(tileIndexName);
		options.tilingBand.setTileSizeName(tileSizeName);
		
		return options;
	}
	////////////////////////////////////Functions for flattening the passes
	/**
	 * Fuse the outer passes, generate a loop that visits all the columns
	 * @param firstPassBlock
	 * @param secondPassBlock
	 * @param lastLevelTiledBlock
	 */
	private MultiPassTiledLoop fusePasses(MultiPassTiledBlock tiledBlock){
		//get list of loops in the tiled loops, the tiled loop is perfectly nested
		List<ScopFor> loops = DTilingTools.extractTiledLoops((ScopFor)tiledBlock.pass1.tiledLoopStart);
		List<ScopFor> ori_loops = DTilerWaveFrontTileLoops.extractLoops((ScopFor)tiledBlock.lastLevel.tiledLoopStart);
		
		List<AbstractScopNode> nodes = new LinkedList<AbstractScopNode>();		
		//flatten all the passes
		nodes.addAll(npasses(loops, this.multiPassDTilerOptions.total_dim));
		nodes.addAll(nCols(ori_loops, loops));
		
		ScopFor flattenLoop = flattenedLoop();
		ColVisitingBlock colBlock = getPassVisitingBlock(loops);
		flattenLoop.setBody(ScopUserFactory.scopBlock(colBlock.block));
		
 		//create the loop for the vistiting tiles along the flatttened direction
		nodes.add(flattenLoop);
		
		//create a block since the tile loop now contains assignments
		ScopBlock block = ScopUserFactory.scopBlock(nodes);
		
		return new MultiPassTiledLoop(block, flattenLoop, colBlock.innerMost, tiledBlock.lastLevelOffsets);
	}
	
	/**
	 * Construct total_dim - 1 statement for computing the number of passes
	 * @param tileLoops
	 * @param total_dim
	 * @return
	 */
	private List<AbstractScopStatement> npasses(List<ScopFor> tileLoops, int total_dim){
		List<AbstractScopStatement> npassStatements = new ArrayList<AbstractScopStatement>();
		List<IntExpression> pass_exprs = new LinkedList<IntExpression>();
		
		//construct statements that computes the index value for the first pass
		for(int i = 0; i < total_dim - 1;i++){
			npassStatements.add(ScopUserFactory.assignment(EcoreUtil.copy(tileLoops.get(i).getIterator()), tileLoops.get(i).getLB().copy()));
		}
		
		for(int i = 0; i < total_dim - 1; i++){
			ScopFor cur_pass = tileLoops.get(i);
			
			//create the intExpression for computing the number of tiles in the current loop
			IntExpression pass_expr = nIter(cur_pass);
			
			npassStatements.add(ScopUserFactory.scopAssignment(this.multiPassDTilerOptions.getNPassVariable(i+1), pass_expr));
			pass_exprs.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getNPassVariable(i+1))));
		}
	
		//add a statement to compute the total number of passes
		npassStatements.add(ScopUserFactory.scopAssignment(this.multiPassDTilerOptions.getTotalPassVariable(), IntExpressionBuilder.prod(pass_exprs)));
		return npassStatements;
	}
	
	/**
	 * Construct a list of statement to compute the total number of steps has to be visited along the flattened direction
	 * @param innerTileLoop for the original pass domain
	 * @param permutedInnerTileLoop for the permuted pass domain
	 * @return
	 */
	private List<AbstractScopStatement> nCols(List<ScopFor> ori_loops, List<ScopFor> loops){
		List<AbstractScopStatement> nColStatements = new ArrayList<AbstractScopStatement>();

		//add statement to compute the tile per pass
		//add the index value for the first iteration for the outer tiled loop
		nColStatements.add(ScopUserFactory.assignment(EcoreUtil.copy(ori_loops.get(0).getIterator()), ori_loops.get(0).getLB().copy()));
		IntExpression tile_per_pass_expr = nIter(ori_loops.get(this.multiPassDTilerOptions.total_dim - 1));
		nColStatements.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getTilePerPassVariable(), tile_per_pass_expr));
		
		//add statement to compute the tile for the last pass
		//add statement to compute the starting origin of the last pass
		for(int i =0; i < this.multiPassDTilerOptions.total_dim - 1; i++){
			ScopFor cur_for = loops.get(i);
			IntExpression pass_expr =  IntExpressionBuilder.prod(IntExpressionBuilder.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getNPassVariable(i+1))), -1),
					cur_for.getStride().copy());
			nColStatements.add(ScopUserFactory.assignment(EcoreUtil.copy(cur_for.getIterator()),IntExpressionBuilder.sum(cur_for.getLB().copy(), pass_expr)));
		}
		IntExpression tile_last_pass_expr = nIter(loops.get(this.multiPassDTilerOptions.total_dim-1));
		nColStatements.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getTileLastPassName(), tile_last_pass_expr));
		
		//add statement to compute the total number of cols
		List<IntExpression> mul_exprs = new LinkedList<IntExpression>();
		mul_exprs.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTilePerPassVariable())));
		mul_exprs.add(IntExpressionBuilder.sub(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTotalPassVariable())), IntExpressionBuilder.constant(1)));
		List<IntExpression> sum_exprs = new LinkedList<IntExpression>();
		sum_exprs.add(IntExpressionBuilder.prod(mul_exprs));
		sum_exprs.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTileLastPassName())));
		nColStatements.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getFlattenPassUpperBound(), IntExpressionBuilder.sum(sum_exprs)));
		
		return nColStatements;
	}
	
	/**
	 * Generate the loop that visits the tile along the flattening direction
	 * @return
	 */
	private ScopFor flattenedLoop(){
		IntExpression lb = IntExpressionBuilder.constant(0);
		IntExpression ub = IntExpressionBuilder.sub(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getFlattenPassUpperBound())), IntExpressionBuilder.constant(1));
		
		return ScopUserFactory.scopFor(this.multiPassDTilerOptions.getFlattenedLoopIndexVariable(), lb, ub, affine(term(1)), null);
	}
	
	/**
	 * Get the loops that visits the tiles for the visited col index 
	 * @param loops
	 * @return
	 */
	private ColVisitingBlock getPassVisitingBlock(List<ScopFor> loops){
		List<AbstractScopNode> visitingBlock = new ArrayList<AbstractScopNode>();
		Map<ScopGuard, AbstractScopNode> guardedLoops = new HashMap<ScopGuard, AbstractScopNode>();
		
		//add assignment statement to compute the current pass number and the current inner tile number 
		visitingBlock.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getCurPassNumber(), IntExpressionBuilder.symbolicDiv(
				IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getFlattenedLoopIndexVariable())), 
				IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTilePerPassVariable())))));
		
		visitingBlock.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getCurTileIndex(this.multiPassDTilerOptions.total_dim), IntExpressionBuilder.symbolicMod(
				IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getFlattenedLoopIndexVariable())),
				IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTilePerPassVariable())))));
		
		
		//add visiting loop for the current pass
		visitingBlock.addAll(getPassIndexComputationBlock(loops));
		ScopGuard guard_cur_pass = getTileLoopsWithGuard(loops);
		visitingBlock.add(guard_cur_pass);
		//extract the innermost tiled loop out of the guard body
		List<ScopFor> tiledLoop = DTilerWaveFrontTileLoops.extractLoops((ScopFor)guard_cur_pass.getThenBody());
		guardedLoops.put(guard_cur_pass, tiledLoop.get(this.multiPassDTilerOptions.total_dim - 2));
		
		//add checking for the previous pass
		visitingBlock.add(ScopUserFactory.assignment(EcoreUtil.copy(this.multiPassDTilerOptions.getCurPassNumber()), IntExpressionBuilder.sub(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getCurPassNumber())), 
				IntExpressionBuilder.constant(1))));
		List<IntExpression> sums = new LinkedList<IntExpression>();
		sums.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getCurTileIndex(this.multiPassDTilerOptions.total_dim))));
		sums.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTilePerPassVariable())));
		visitingBlock.add(ScopUserFactory.assignment(EcoreUtil.copy(this.multiPassDTilerOptions.getCurTileIndex(this.multiPassDTilerOptions.total_dim)), IntExpressionBuilder.sum(sums)));
		
		//add visiting loop for the previous pass
		visitingBlock.addAll(getPassIndexComputationBlock(loops));
		ScopGuard guard_prev_pass = getTileLoopsWithGuard(loops);
		visitingBlock.add(guard_prev_pass);
		//extract the innermost tiled loop out of the current guard body
		tiledLoop = DTilerWaveFrontTileLoops.extractLoops((ScopFor)guard_prev_pass.getThenBody());
		guardedLoops.put(guard_prev_pass, tiledLoop.get(this.multiPassDTilerOptions.total_dim - 2));
		
		return new ColVisitingBlock(visitingBlock, guardedLoops);
	}

	/**
	 * Generate computations for the pass numbers for each visited col
	 * @param loops
	 * @return
	 */
	private List<AbstractScopStatement> getPassIndexComputationBlock(List<ScopFor> loops){
		List<AbstractScopStatement> passStatements = new LinkedList<AbstractScopStatement>();
		
		//add statement to compute the total_dim - 1 pass index value
		passStatements.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getDivVariable(), IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTotalPassVariable()))));
		passStatements.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getTempPassNumber(), IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getCurPassNumber()))));
		for(int i = 1; i <= this.multiPassDTilerOptions.total_dim - 1; i++){
			ScopFor cur_pass_for = loops.get(i - 1);
			
			passStatements.add(ScopUserFactory.assignment(EcoreUtil.copy(this.multiPassDTilerOptions.getDivVariable()), IntExpressionBuilder.symbolicDiv(
					IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getDivVariable())), 
					IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getNPassVariable(i))))));
			
			//compute the current pass index
			IntExpression distance = IntExpressionBuilder.prod(IntExpressionBuilder.symbolicDiv(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTempPassNumber())),
					IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getDivVariable()))), 
					cur_pass_for.getStride().copy());
			IntExpression lb_exp = IntExpressionBuilder.sum(cur_pass_for.getLB().copy(), distance);
			passStatements.add(ScopUserFactory.assignment(EcoreUtil.copy(cur_pass_for.getIterator()), lb_exp));
//			passStatements.add(ScopUserFactory.assignment(options.getCurPassIndex(i), IntExpressionBuilder.symbolicDiv(IntExpressionBuilder.affine(EcoreUtil.copy(options.getTempPassNumber())),
//					IntExpressionBuilder.affine(EcoreUtil.copy(options.getDivVariable())))));
			
			passStatements.add(ScopUserFactory.assignment(EcoreUtil.copy(this.multiPassDTilerOptions.getTempPassNumber()), IntExpressionBuilder.symbolicMod(
					IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTempPassNumber())), IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getDivVariable())))));
		}
				
		//add statement for translating the cooradinate to tile origin for the first tiled loop in the last level
		ScopFor tile_loop = loops.get(this.multiPassDTilerOptions.total_dim - 1);
		List<IntExpression> muls = new LinkedList<IntExpression>();
		muls.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getCurTileIndex(this.multiPassDTilerOptions.total_dim))));
		muls.add(tile_loop.getStride().copy());
		List<IntExpression> sums = new LinkedList<IntExpression>();
		sums.add(tile_loop.getLB().copy());
		sums.add(IntExpressionBuilder.prod(muls));
		passStatements.add(ScopUserFactory.assignment(EcoreUtil.copy(tile_loop.getIterator()), IntExpressionBuilder.sum(sums)));
		
		return passStatements;
	}
	
	/**
	 * Generate guards with all the loop bounds
	 * @param loops
	 * @return
	 */
	private ScopGuard getTileLoopsWithGuard(List<ScopFor> loops){
		List<IntConstraint> constraints = new LinkedList<IntConstraint>();
		for(int i = 0; i < this.multiPassDTilerOptions.total_dim; i++){
			ScopFor cur_for = loops.get(i);
			IntExpression var_exp = IntExpressionBuilder.affine(EcoreUtil.copy(cur_for.getIterator()));
			IntConstraint lb_exp = IntExpressionBuilder.constraint(cur_for.getLB().copy(), var_exp, ComparisonOperator.LE);
			IntConstraint ub_exp = IntExpressionBuilder.constraint(var_exp, cur_for.getUB().copy(), ComparisonOperator.LE);
			constraints.add(lb_exp);
			constraints.add(ub_exp);
		}
		
		IntConstraintSystem system = IntExpressionBuilder.constraintSystem(constraints);
		List<IntConstraintSystem> systems = new LinkedList<IntConstraintSystem>();
		systems.add(system);
		
		ScopGuard guard = ScopUserFactory.guardNoElse(systems, EcoreUtil.copy(loops.get(this.multiPassDTilerOptions.total_dim)));
		
		return guard;
	}
	
	/**
	 * Generate the computation for the number of iterations in a loop
	 * @param loop
	 * @return
	 */
	private IntExpression nIter(ScopFor loop){
		IntExpression expr = IntExpressionBuilder.add(IntExpressionBuilder.sub(loop.getUB().copy(), loop.getLB().copy()), 1);
		IntExpression niter_expr = IntExpressionBuilder.symbolicCeil(expr, IntExpressionBuilder.affine((Variable)loop.getStride().copy()));
		
		return niter_expr;
	}
	////////////////////////////////////Other functions/////////////////////////////
	private static Domain extractBoundingDomainForTilableBlock(ParameterDomain paramDom, TilableBlock block){
		Domain boundingDomain = null;
		
		Map<ScopStatementMacro, Domain> stmtDomains = extractDomainsForTilableBlock(paramDom, block);
		for(Map.Entry<ScopStatementMacro, Domain> stmt: stmtDomains.entrySet()){
			if(boundingDomain == null){
				boundingDomain = stmt.getValue().copy();
			}else{
				boundingDomain = boundingDomain.union(stmt.getValue());
				boundingDomain.simplify();
			}
		}
		
		return boundingDomain;
	}
	
	/**
	 * Extract domain from a given scop node from the for loops 
	 * @param paramDom
	 * @param block
	 * @return
	 */
	private static Map<ScopStatementMacro, Domain> extractDomainsForTilableBlock(ParameterDomain paramDom, TilableBlock block){
		//construct a separate scopblock for all the loops in the block
		List<AbstractScopNode> nodes = new ArrayList<AbstractScopNode>(block.loops.size());
		for (ScopFor loop : block.loops) {
			nodes.add(EcoreUtil.copy(loop));
		}
		ScopBlock sblock = ScopUserFactory.scopBlock(nodes);
		Map<ScopStatementMacro, List<ScopFor>> statementLoops = MultiPassDTilingTools.getSurroundingLoopforStatements(sblock);
		
		Map<ScopStatementMacro, Domain>  statementDomains = new HashMap<ScopStatementMacro, Domain>();
		for(Map.Entry<ScopStatementMacro, List<ScopFor>> loops: statementLoops.entrySet()){
			Domain domain = extractDomainFromLoopSet(paramDom, loops.getValue());
			if(DEBUG)
				System.out.println("domain extracted for " + loops.getKey().getName() + " Domain " + domain);
			statementDomains.put(loops.getKey(), domain);
		}
		
		return statementDomains;
	}
	
	
	private static Domain extractDomainFromLoopSet(ParameterDomain paramDom, List<ScopFor> loopset){
		//make a copy of the original paramDom
		ParameterDomain paramDomCopy = paramDom.copy().toParameterDomain();
		
		List<Variable> indices = new LinkedList<Variable>();
		//add the constraint of the parameters first
		List<List<IntConstraint>> constraints = new LinkedList<List<IntConstraint>>();
		//Construct an IntConstraintSystem from the loop set
		for(int i = 0; i < loopset.size(); i++){
			ScopFor cur_for = loopset.get(i);
			Variable cur_var = EcoreUtil.copy(cur_for.getIterator());
			indices.add(cur_var);
			
			//construct a constraint with the lower bound and upper bound of the current loop
			IntExpression var_exp = IntExpressionBuilder.affine(cur_var);
			
			IntExpression lb_exp = cur_for.getLB().copy().simplify();
			List<List<IntConstraint>> lb_constraints = MultiPassDTilingTools.createConstraints(lb_exp, var_exp, ComparisonOperator.LE, ReductionOperator.MAX);
			IntExpression ub_exp = cur_for.getUB().copy().simplify();
			List<List<IntConstraint>> ub_constraints = MultiPassDTilingTools.createConstraints(ub_exp, var_exp, ComparisonOperator.GE, ReductionOperator.MIN);
			List<List<IntConstraint>> cur_for_constraints = MultiPassDTilingTools.constraintsProduct(lb_constraints, ub_constraints);
			
			//product the constraints for current level with the previous levels
			constraints = MultiPassDTilingTools.constraintsProduct(constraints, cur_for_constraints);
		}
		
		return MultiPassDTilingTools.createDomainWithConstraintsList(paramDomCopy, indices, constraints);
	}
	
	private static TilableBlock extractPointBlockFromTiledBlock(TiledBlock tiledBlock){
		TilableBlock point_block = null;
		
		if(tiledBlock.pointLoopStart instanceof ScopBlock){
			List<TilableBlock> temp_blocks = DTiler.extractTilableBlock((ScopBlock)tiledBlock.pointLoopStart);
			point_block = temp_blocks.get(0);	//there can be only one tiled block for the point loops from a tiled block
		}else if(tiledBlock.pointLoopStart instanceof ScopFor){
			List<ScopFor> loops = new LinkedList<ScopFor>();
			loops.add((ScopFor)tiledBlock.pointLoopStart);
			point_block = new TilableBlock();
			point_block.loops = loops;
		}
		
		return point_block;
	}
	
	/**
	 * Generate a scop root for a given statement domain list, the domain for each statement has to be permuted first using the given function
	 * If the permutation function is null then the original domain is used
	 * @param paramDomain
	 * @param statementDomains
	 * @param function
	 * @return
	 */
	private static ScopRoot generateScopForDomain(ParameterDomain paramDomain, Domain statementDomain, AffineFunction function){
		Map<ScopStatementMacro, Domain> statementDomains = new HashMap<ScopStatementMacro, Domain>();
		ScopStatementMacro scopStmt = ScopUserFactory.scopStatementMacro("S", new LinkedList<IntExpression>());
		statementDomains.put(scopStmt, statementDomain);
		
		return generateScopForDomain(paramDomain, statementDomains, function);
	}
	
	private static ScopRoot generateScopForDomain(ParameterDomain paramDomain, Map<ScopStatementMacro, Domain> statementDomains, AffineFunction function){
		List<Statement> stmts = new LinkedList<Statement>();
		for(Map.Entry<ScopStatementMacro, Domain> statement: statementDomains.entrySet()){
			Domain permuted_domain = statement.getValue().copy();
			ScopStatementMacro scopStmt = statement.getKey();
			if(function != null)	permuted_domain = permuted_domain.image(function);
			permuted_domain.simplify();
			
			Statement stmt = _polyIRCGfact.createStatement(scopStmt.getName(), permuted_domain, scopStmt.toString());
			stmts.add(stmt);
		}

		Domain temp_domain = statementDomains.entrySet().iterator().next().getValue();
		//generate the loop nest for the permuted domain
		CloogOptionSpecifier cloogOptions = CloogOptionSpecifier.optionForFullyNestedLoop(temp_domain.getNIndices());
		ScopRoot permuted_point = ScopGenerator.generateScop(paramDomain, temp_domain.getIndexNames(), stmts, cloogOptions);
		
		if(DEBUG){
			System.out.println("The generated scop"); 
			System.out.println(CGenerator.generate(permuted_point));
		}
		return permuted_point;
	}
	
	
	/**
	 * Create a single convex polyhedron for all the loops in the block
	 * @param paramDom
	 * @param block
	 * @return a scop that scans the convex polyhedron
	 */
	private static TilableBlock createBoundingConvexBlock(ParameterDomain paramDom, TilableBlock block){
		Domain boundingDomain = extractBoundingDomainForTilableBlock(paramDom, block);
	
		//generate a scop that visits the convex polyhedral of the domain
		if(DEBUG)
			System.out.println("The original domain: " + boundingDomain);
		boundingDomain = boundingDomain.polyhedralHull();
		//System.out.println("The convext domain: " + boundingDomain);
		ScopRoot convexScop = generateScopForDomain(paramDom, boundingDomain, null);
		//there must be one single nested loop that scans the whole polyhedral
		TilableBlock convexblock = DTiler.extractTilableBlock(convexScop).get(0);
		
		return convexblock;
	}
		
	private static ScopFor innermostLoop(ScopFor loopNest){
		ScopFor innermost = loopNest;
		//get list of loops
		ScopFor loop = loopNest;
		while (true) {
			if (!(loop.getBody() != null && (loop.getBody() instanceof ScopFor || loop.getBody() instanceof ScopBlock))) {
				break;
			}
			if (loop.getBody() instanceof ScopBlock) {
				if(((ScopBlock)loop.getBody()).getStatements().get(0) instanceof ScopFor){
					loop = (ScopFor)((ScopBlock)loop.getBody()).getStatements().get(0);
					innermost = loop;
				}else{
					break;
				}
			} else {
				loop = (ScopFor)loop.getBody();
				innermost = loop;
			}
		}
		
		return innermost;
	}
	
	public static class LastLevelTiledBlock{
		public TiledBlock oriLastLevel;
		public TiledBlock permutedLastLevel;
		public List<IntExpression> lastLevelOffsets;
		
		public LastLevelTiledBlock(TiledBlock _oriLastLevel, TiledBlock _permutedLastLevel, List<IntExpression> _lastLevelOffsets){
			oriLastLevel = _oriLastLevel;
			permutedLastLevel = _permutedLastLevel;
			lastLevelOffsets = _lastLevelOffsets;
		}
		
	}
	public static class MultiPassTiledBlock{
		public TiledBlock pass1;
		public TiledBlock pass2;
		public TiledBlock lastLevel;
		public TiledBlock permutedLastLevel;
		public List<IntExpression> lastLevelOffsets;
		
		public MultiPassTiledBlock(TiledBlock _pass1, TiledBlock _pass2, TiledBlock _lastLevel, TiledBlock _permutedLastLevel, List<IntExpression> _lastLevelOffsets){
			pass1 = _pass1;
			pass2 = _pass2;
			lastLevel = _lastLevel;
			permutedLastLevel = _permutedLastLevel;
			lastLevelOffsets = _lastLevelOffsets;
		}
	}
	
	
	public static class DTilerTiledBlock{
		public DTilingOptions options;
		public TiledBlock tiledBlock;
		
		public DTilerTiledBlock(DTilingOptions _options, TiledBlock _tiledBlock){
			options = _options;
			tiledBlock = _tiledBlock;
		}
	}
	
	public static class ColVisitingBlock{
		public List<AbstractScopNode> block;
		public Map<ScopGuard, AbstractScopNode> innerMost;
		
		public ColVisitingBlock(List<AbstractScopNode> _block, Map<ScopGuard, AbstractScopNode> _innerMost){
			block = _block;
			innerMost = _innerMost;
		}
	}
	
}
