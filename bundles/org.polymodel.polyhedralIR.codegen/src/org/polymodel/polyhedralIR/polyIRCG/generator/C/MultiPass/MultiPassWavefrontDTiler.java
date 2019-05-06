package org.polymodel.polyhedralIR.polyIRCG.generator.C.MultiPass;

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
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.annotation.TileLoopAnnotation;
import org.polymodel.scop.dtiler.DTiler;
import org.polymodel.scop.dtiler.DTiler.TilableBlock;
import org.polymodel.scop.dtiler.OptimizationOptions;
import org.polymodel.scop.dtiler.basic.DTilingTools;



/**
 * MultiPass DTiler: tile sizes are parameterized
 * 
 * @author yun
 * 
 */
public class MultiPassWavefrontDTiler{
	protected static final PolyhedralIRUserFactory _polyIRfact = PolyhedralIRUserFactory.eINSTANCE;
	
	protected final MultiPassDTilerOptions multiPassDTilerOptions;
	protected final OptimizationOptions dtilerOptimizationOptions;
	
	protected static boolean DEBUG = false;
	
	protected MultiPassWavefrontDTiler(MultiPassDTilerOptions _options){
		this.multiPassDTilerOptions = _options;
		this.dtilerOptimizationOptions = null;
	}
	
	protected MultiPassWavefrontDTiler(MultiPassDTilerOptions _options, OptimizationOptions _optOptions){
		this.multiPassDTilerOptions = _options;
		this.dtilerOptimizationOptions = _optOptions;
	}
	
	public static ScopRoot generateSope(ScopRoot scop, ParameterDomain paramDom, MultiPassDTilerOptions multiPassOptions){
		//reinitialize the total number of dimensions for the scop
		int total_dim = MultiPassDTilingTools.getMaxDimensions(scop);
		multiPassOptions.total_dim = total_dim;
				
		MultiPassWavefrontDTiler multiPassWavefrontDTiler = new MultiPassWavefrontDTiler(multiPassOptions);
				
		return multiPassWavefrontDTiler.tileMultiPassWavefront(scop, paramDom);
	}
	
	public static ScopRoot generateSope(ScopRoot scop, ParameterDomain paramDom, MultiPassDTilerOptions multiPassOptions, OptimizationOptions _optOptions){
		//reinitialize the total number of dimensions for the scop
		int total_dim = MultiPassDTilingTools.getMaxDimensions(scop);
		multiPassOptions.total_dim = total_dim;
				
		MultiPassWavefrontDTiler multiPassWavefrontDTiler = new MultiPassWavefrontDTiler(multiPassOptions, _optOptions);
				
		return multiPassWavefrontDTiler.tileMultiPassWavefront(scop, paramDom);
	}
	
	/**
	 * Generate loops for the flattened multi-pass tiling strategy.
	 * 
	 * @param clast
	 * @param options
	 * @return
	 */
	private ScopRoot tileMultiPassWavefront(ScopRoot scop, ParameterDomain paramDom){
		//make a copy of the origial scop
		ScopRoot copy = EcoreUtil.copy(scop);
		
		ParameterDomain paramDomCopy = paramDom.copy().toParameterDomain();//make a copy of the original domain
		//extract tilable block from the whole program
		List<TilableBlock> blocks = DTiler.extractTilableBlock(copy);
		for(TilableBlock block: blocks){
			tileMultiPassWaveFrontForTilableBlock(paramDomCopy, block);
		}
		
		return copy;
	}
	
	private MultiPassTiledLoop tileMultiPassWaveFrontForTilableBlock(ParameterDomain paramDom, TilableBlock block){
		MultiPassDTiler multiPassDTiler = new MultiPassDTiler(this.multiPassDTilerOptions, this.dtilerOptimizationOptions);
		MultiPassTiledLoop multiPassLoop= multiPassDTiler.tileMultiPassForTilableBlock(paramDom, block);
		
		//System.out.println("finish generating the sequential code");
		List<String> privates = collectPrivateVariables(multiPassLoop);
		if(this.dtilerOptimizationOptions != null && this.dtilerOptimizationOptions.specialVariables != null && this.dtilerOptimizationOptions.specialVariables.size() > 0){
			for(String variable: this.dtilerOptimizationOptions.specialVariables){
				if(!privates.contains(variable)){
					privates.add(variable);
				}
			}
		}
		//extract the tiled loop from one of the guard
//		AbstractScopNode body = multiPassLoop.innerMost.entrySet().iterator().next().getKey().getThenBody();
//		List<ScopFor> loops = DTilingTools.extractTiledLoops((ScopFor)body);	//the body of the guard must be a scop for loop
		
		List<AbstractScopNode> nodes = new LinkedList<AbstractScopNode>();		
		//add the statement to compute the number of total wavefront
		nodes.addAll(nWave());
		
		//add guards for the innermost tiled loop
		Map<ScopGuard, AbstractScopNode> innerGuards = addGuardForInnerMostTiledLoop(multiPassLoop.innerMost);
		//add the wavefront time loop
		ScopFor timeloop = timeLoop();
		
//		//add parallel guard to the flattened loop
//		ParallelLoopAnnotation pla = ScopUserFactory.parallelLoopAnnotation(privates); 
//		multiPassLoop.flattenLoop.getScopAnnotations().add(pla);
		
		ScopBlock timeBody = timeLoopBody(privates, (ScopFor)EcoreUtil.copy(multiPassLoop.flattenLoop));
		//add the flattened loop as the body of the time loop
		timeloop.setBody(timeBody);
		
		nodes.add(timeloop);
		//create a block since the tile loop n ow contains assignments
		ScopBlock sblock = ScopUserFactory.scopBlock(nodes);
		
		//replace the original flatten loop with the new time loop
		EcoreUtil.replace(multiPassLoop.flattenLoop, sblock);
	
		return new MultiPassTiledLoop(multiPassLoop.start, timeloop, innerGuards, multiPassLoop.lastLevelOffset);
	}
	
	/**
	 * Create an assignment to compute the total number of wavefronts
	 * @param options
	 * @return
	 */
	private List<ScopAssignment> nWave(){
		List<ScopAssignment> waveAssigns = new LinkedList<ScopAssignment>();
	
		List<IntExpression> sub_sum_exprs = new LinkedList<IntExpression>();
		
		sub_sum_exprs.add(IntExpressionBuilder.symbolicCeil(IntExpressionBuilder.affine(this.multiPassDTilerOptions.getPassSizeVariable(1, 1)), 
				IntExpressionBuilder.affine(this.multiPassDTilerOptions.getTileSizeVariable(1, 3))));
		for(int i = 2; i <= this.multiPassDTilerOptions.total_dim - 1; i++){
			sub_sum_exprs.add(IntExpressionBuilder.symbolicCeil(IntExpressionBuilder.affine(this.multiPassDTilerOptions.getPassSizeVariable(i, 2)), 
					IntExpressionBuilder.affine(this.multiPassDTilerOptions.getTileSizeVariable(i, 3))));
		}
		
		ScopAssignment subWaveAssign = ScopUserFactory.assignment(this.multiPassDTilerOptions.getSubWaveFrontName(), IntExpressionBuilder.sum(sub_sum_exprs));
		ScopAssignment nwaveAssign = ScopUserFactory.assignment(this.multiPassDTilerOptions.getTotalWaveFrontName(), IntExpressionBuilder.sum(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getFlattenPassUpperBound())), 
				IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getSubWaveFrontName()))));
		
		waveAssigns.add(subWaveAssign);
		waveAssigns.add(nwaveAssign);
		
		return waveAssigns;
	}
	
	private ScopBlock timeLoopBody(List<String> privates, ScopFor flattenLoop){
		List<AbstractScopNode> body = new LinkedList<AbstractScopNode>();
		
		//compute the start and end for the starting loop
		IntExpression start_exp = IntExpressionBuilder.max(flattenLoop.getLB().copy(), IntExpressionBuilder.sub(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getWaveFrontTimeName())), 
				IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getSubWaveFrontName()))));
		body.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getWaveFrontStartName(), start_exp));
		IntExpression end_exp = IntExpressionBuilder.min(flattenLoop.getUB().copy(), IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getWaveFrontTimeName())));
		body.add(ScopUserFactory.assignment(this.multiPassDTilerOptions.getWaveFrontEndName(), end_exp));
		
		//add parallel guard to the flattened loop
		ParallelLoopAnnotation pla = ScopUserFactory.parallelLoopAnnotation(privates, "static", 1); 
		flattenLoop.getScopAnnotations().add(pla);
		flattenLoop.setLB(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getWaveFrontStartName())));
		flattenLoop.setUB(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getWaveFrontEndName())));
		
		body.add(flattenLoop);
		
		ScopBlock sblock = ScopUserFactory.scopBlock(body);
		
		return sblock;
	}
	
	private ScopFor timeLoop(){
		IntExpression lb_exp = IntExpressionBuilder.constant(0);
		IntExpression ub_exp = IntExpressionBuilder.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getTotalWaveFrontName())), -1);
		IntExpression stride = IntExpressionBuilder.constant(1);
		
		ScopFor loop = ScopUserFactory.loop(this.multiPassDTilerOptions.getWaveFrontTimeName(), lb_exp, ub_exp, stride, null);
		return  loop; 
	}

	private Map<ScopGuard, AbstractScopNode> addGuardForInnerMostTiledLoop(Map<ScopGuard, AbstractScopNode> guardedLoops){
		Map<ScopGuard, AbstractScopNode> innerGuards = new HashMap<ScopGuard, AbstractScopNode>();
		for(Map.Entry<ScopGuard, AbstractScopNode> guardedLoop: guardedLoops.entrySet()){
			//for each if condition, add guard for the innermost loop
			AbstractScopNode innermost = addGuardForInnerMostTiledLoop(guardedLoop.getKey(), guardedLoop.getValue());
			innerGuards.put(guardedLoop.getKey(), innermost);
		}
		
		return innerGuards;
	}
	
	private AbstractScopNode addGuardForInnerMostTiledLoop(ScopGuard guard, AbstractScopNode innermost){
		//extract the tiled loops out of the guard
		List<ScopFor> loops = DTilingTools.extractTiledLoops((ScopFor)guard.getThenBody());
		
		ScopAssignment innerTid = innerTidAssignment(loops);
		
		//create guard constraint
		ScopFor last_for = loops.get(loops.size() - 1);
		IntExpression var_exp = IntExpressionBuilder.affine(EcoreUtil.copy(last_for.getIterator()));
		IntConstraint lb_con = IntExpressionBuilder.constraint(last_for.getLB().copy(), var_exp, ComparisonOperator.LE);
		IntConstraint ub_con = IntExpressionBuilder.constraint(last_for.getUB().copy(), var_exp, ComparisonOperator.GE);
		IntConstraintSystem system = IntExpressionBuilder.constraintSystem(lb_con, ub_con);
		
		List<IntConstraintSystem> cnstList = new ArrayList<IntConstraintSystem>(1);
		cnstList.add(system);
		
		//inside the guard is the body of the last loop
		ScopGuard innerGuard = ScopUserFactory.guardNoElse(cnstList, EcoreUtil.copy(last_for.getBody()));
		
		//create one block that 
		List<AbstractScopNode> nodes = new LinkedList<AbstractScopNode>();
		nodes.add(innerTid);
		nodes.add(innerGuard);
		EcoreUtil.replace(last_for, ScopUserFactory.block(nodes));
		
		return innerGuard;
	}
	
	private ScopAssignment innerTidAssignment(List<ScopFor> loops){
		int size = loops.size();
		
		List<IntExpression> sum_exprs = new LinkedList<IntExpression>();
	
		sum_exprs.add(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getFlattenedLoopIndexVariable())));
		//create assignment to compute for the innermost tiled loop
		for(int i = 0; i < size - 1; i++){
			ScopFor cur_for = loops.get(i);
			IntExpression offset = null;
			for(IScopAnnotation annot : cur_for.getScopAnnotations()){
				if(annot instanceof TileLoopAnnotation){
					offset = ((TileLoopAnnotation)annot).getOffset();
					break;
				}
			}
			//IntExpression expr = IntExpressionBuilder.sub(IntExpressionBuilder.affine(EcoreUtil.copy(cur_for.getIterator())), offsets.get(i).copy());
			IntExpression expr = IntExpressionBuilder.sub(IntExpressionBuilder.affine(EcoreUtil.copy(cur_for.getIterator())), offset.copy());
			sum_exprs.add(IntExpressionBuilder.symbolicDiv(expr, IntExpressionBuilder.affine(EcoreUtil.copy(cur_for.getStride()))));
		}
		
		ScopFor last_for = loops.get(size - 1);
		IntExpression coordinate = IntExpressionBuilder.sub(IntExpressionBuilder.affine(EcoreUtil.copy(this.multiPassDTilerOptions.getWaveFrontTimeName())), IntExpressionBuilder.sum(sum_exprs));
		IntExpression inner_offset = null;
		for(IScopAnnotation annot : last_for.getScopAnnotations()){
			if(annot instanceof TileLoopAnnotation){
				inner_offset = ((TileLoopAnnotation)annot).getOffset();
				break;
			}
		}
		//IntExpression inner_tid = IntExpressionBuilder.sum(IntExpressionBuilder.prod(coordinate, last_for.getStride().copy()), offsets.get(size-1).copy());
		IntExpression inner_tid = IntExpressionBuilder.sum(IntExpressionBuilder.prod(coordinate, last_for.getStride().copy()), inner_offset.copy());
		ScopAssignment inner_tid_assignment = ScopUserFactory.assignment(EcoreUtil.copy(last_for.getIterator()),  inner_tid);
		
		return inner_tid_assignment;
	}
	
	/**
	 * Collect all the variable that is declared within the flattened loop
	 * @param options
	 * @return
	 */
	private List<String> collectPrivateVariables(MultiPassTiledLoop tiledLoop){
		List<String> vars = new LinkedList<String>();
		//add tile indices
		vars.addAll(this.multiPassDTilerOptions.getTileIndicesForMultiPass());
		vars.addAll(collectLoopIndices((ScopFor)tiledLoop.innerMost.entrySet().iterator().next().getValue()));
		//add the other multipass special variables
		vars.addAll(this.multiPassDTilerOptions.getPrivateSpecilVariablesForWavefront());
		
		return vars;
	}
	
	private static List<String> collectLoopIndices(ScopFor loop){
		List<String> pointIters = new LinkedList<String>();
		ScopFor cur = loop;
		while(cur != null){
			if (cur.getBody() == null) break;
			if ((cur.getBody() instanceof ScopFor)) {
				cur = (ScopFor)cur.getBody();
			} else if (cur.getBody() instanceof ScopBlock) {
				ScopBlock block = (ScopBlock)cur.getBody();
				for(AbstractScopNode stmt : block.getStatements()){
					cur = null;
					if(stmt instanceof ScopFor){
						cur = (ScopFor)stmt;
						break;
					}
				}
				if(cur == null)	break;
			} else {
				break;
			}
			
			pointIters.add(cur.getIterator().getName() );
		}
		
		return pointIters;
	}
}
