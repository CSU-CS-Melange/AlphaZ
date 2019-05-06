package org.polymodel.scop.dtiler.opt;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.dtiler.OptimizationOptions;
import org.polymodel.scop.dtiler.OptimizationOptions.LoopUnrollOptions;
import org.polymodel.scop.dtiler.hierarchy.basic.SubstituteVariable;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

public class LoopUnrollAndJam{

	public static ScopRoot generate(ScopRoot root, OptimizationOptions options){
		//make a copy
		ScopRoot root_copy = EcoreUtil.copy(root);
		if(options.unrollAndJam){
			for(LoopUnrollOptions unroll_options : options.getUnrollOptions()){
				UnrollAndJamLoops loop_unroll_jam;
				if(unroll_options.noPeeling){
					loop_unroll_jam = new UnrollAndJamLoops(unroll_options.dim, unroll_options.factor);
				}else{
					int dim = unroll_options.dim;
					loop_unroll_jam = new UnrollAndJamLoops(unroll_options.dim, unroll_options.factor, unroll_options.noPeeling, options.getPeelingLB(dim), options.getPeelingUB(dim), options.getPeelingMidBound(dim));
				}
				root_copy.accept(loop_unroll_jam);
			}
		}
		return root_copy;
	}	
	
	private static class UnrollAndJamLoops extends ScopDepthFirstVisitorImpl{
		private int unrollDims;
		private int unrollFactors;
		private boolean noPeeling;

		///////reserve variables for bound variable for peeling
		private Variable lbVar;
		private Variable ubVar;
		private Variable midVar;
		
		public UnrollAndJamLoops(int _unrollDims, int _unrollFactors){
			unrollDims = _unrollDims;
			unrollFactors = _unrollFactors;
			noPeeling = true;
		}
		
		public UnrollAndJamLoops(int _unrollDims, int _unrollFactors, boolean _noPeeling, Variable _lbVar, Variable _ubVar, Variable _midVar){
			unrollDims = _unrollDims;
			unrollFactors = _unrollFactors;
			noPeeling = _noPeeling;
			lbVar = _lbVar;
			ubVar = _ubVar;
			midVar = _midVar;
		}
		
		@Override
		public void outScopFor(ScopFor s) {
			//boolean loopForUnroll = false;
			int depth = s.getLoopDepth();
			System.out.println("current loop visited " + s + " at depth: " + depth);
			
			if(depth == unrollDims){
				//construct new loop stride
				List<IntExpression> exps = new LinkedList<IntExpression>();
				exps.add(s.getStride().copy());
				exps.add(IntExpressionBuilder.constant(unrollFactors));
				IntExpression new_stride = IntExpressionBuilder.prod(exps);
				if(!noPeeling)	//peel the loop first
				{
					List<AbstractScopNode> nodes = new LinkedList<AbstractScopNode>();
					nodes.addAll(getBounds(s, new_stride));
					ScopFor mainLoop = getMainLoop(s);
					DuplicateStatements stmt_dup = new DuplicateStatements(mainLoop.getIterator(), unrollFactors);
					mainLoop.accept(stmt_dup);
					mainLoop.setStride(new_stride);
					nodes.add(mainLoop);
					nodes.add(getPeeledLoop(s));
					ScopBlock block = ScopUserFactory.scopBlock(nodes);
					EcoreUtil.replace(s, block);
				}else{
					DuplicateStatements stmt_dup = new DuplicateStatements(s.getIterator(), unrollFactors);
					s.accept(stmt_dup);
					//reset loop stride to be original stride * unroll factor
					s.setStride(new_stride);
				}
			}
		}
		
		//////////////////////////////////////////Utility function for peeling the loops
		/*
		 * create assignemnt for new loop bounds
		 * lbVar = loop.lb()
		 * ubVar = loop.ub()
		 * midVar = ((ubVar - lbVar + 1)/stride)*stride + lb
		 */
		private List<AbstractScopStatement> getBounds(ScopFor loop, IntExpression stride){
			List<AbstractScopStatement> stmts = new LinkedList<AbstractScopStatement>();
			//add lb expression
			stmts.add(ScopUserFactory.scopAssignment(lbVar, loop.getLB().copy()));
			//add ub expression
			stmts.add(ScopUserFactory.scopAssignment(ubVar, loop.getUB().copy()));
			
			//construct expression to compute the mid bound
			IntExpression num = IntExpressionBuilder.add(IntExpressionBuilder.sub(IntExpressionBuilder.affine(ubVar), IntExpressionBuilder.affine(lbVar)), 1);
			IntExpression div = IntExpressionBuilder.symbolicDiv(num, stride.copy());
			List<IntExpression> mul_sub_exprs = new LinkedList<IntExpression>();
			mul_sub_exprs.add(div);
			mul_sub_exprs.add(stride.copy());
			IntExpression sub_expr = IntExpressionBuilder.prod(mul_sub_exprs);
			List<IntExpression> sum_sub_exprs = new LinkedList<IntExpression>();
			sum_sub_exprs.add(sub_expr);
			sum_sub_exprs.add(IntExpressionBuilder.affine(lbVar));
			IntExpression mid_bound_expr = IntExpressionBuilder.sum(sum_sub_exprs);
			stmts.add(ScopUserFactory.assignment(midVar, mid_bound_expr));
			
			return stmts;
		}
		
		/**
		 * Get the main loop for peeling
		 * Set the loop lower bound to lbVar
		 * Set the loop upper bound to midVar - 1
		 * @param loop
		 * @return
		 */
		private ScopFor getMainLoop(ScopFor loop){
			ScopFor mainLoop = EcoreUtil.copy(loop);
			//upate the lower bound
			mainLoop.setLB(IntExpressionBuilder.affine(lbVar));
			//update the upper bound
			mainLoop.setUB(IntExpressionBuilder.sub(IntExpressionBuilder.affine(midVar), IntExpressionBuilder.constant(1)));
			
			return mainLoop;
		}
		
		/**
		 * Get the loop that is peeled off
		 * Set the loop lower bound to midVar
		 * Set the loop upper bound to ubVar
		 * @param loop
		 * @return
		 */
		private ScopFor getPeeledLoop(ScopFor loop) {
			ScopFor peeledLoop = EcoreUtil.copy(loop);
			//update the lower bound
			peeledLoop.setLB(IntExpressionBuilder.affine(midVar));
			//update the upper bound
			peeledLoop.setUB(IntExpressionBuilder.affine(ubVar));
			
			return peeledLoop;
		}
	}
	
	/**
	 * For each statement encountered, duplicate it duFactors times, with the iteration expression iter, iter + 1, iter + 2, ....iter + duFactors - 1
	 * @author zouyun
	 *
	 */
	private static class DuplicateStatements extends ScopDepthFirstVisitorImpl {
		  private static boolean DEBUG = true;
		  private Variable iter;
		  private int duFactors;
		  
		  public DuplicateStatements(Variable _iter, int _duFactors){
			  iter = _iter;
			  duFactors = _duFactors;
			  if(DEBUG){
				  System.out.println("duplicate statement with index " + iter.getName() + " " + duFactors + " times");
			  }
		  }	
		  
		  @Override
		  public void outScopStatementMacro(ScopStatementMacro a) {
			  //coming out of a statement and replace it with a set of duplicated statement statement 
			  //and reconstruct a scop block to include all the duplicated statements
			  List<AbstractScopNode> stmts = new LinkedList<AbstractScopNode>();
			  stmts.add(EcoreUtil.copy(a));
			  for(int i = 1; i < duFactors; i++){
				  ScopStatementMacro stmt_copy = EcoreUtil.copy(a);
				  //construct exrepssion iter + i
				  IntExpression exp = IntExpressionBuilder.add(IntExpressionBuilder.affine(iter), i);
				  //iterate over all the parameter expression in the macro and substitute 
				  //all the variable iter with new exp
				  for(int j = 0; j < stmt_copy.getMacroParams().size(); j++){
					  IntExpression new_exp = SubstituteVariable.substitute(stmt_copy.getMacroParams().get(j), iter, exp);
					  stmt_copy.getMacroParams().set(j, new_exp);
				  }
				  stmts.add(stmt_copy);
			  } 
			  //create a scopBlock
			  ScopBlock spBlock = ScopUserFactory.scopBlock(stmts);
			  EcoreUtil.replace(a, spBlock);
		  }
	  }
}