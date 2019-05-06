package org.polymodel.scop.dtiler.opt;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.annotation.VectorizationAnnotation;
import org.polymodel.scop.dtiler.OptimizationOptions;
import org.polymodel.scop.dtiler.OptimizationOptions.LoopUnrollOptions;
import org.polymodel.scop.dtiler.hierarchy.basic.SubstituteVariable;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;
import org.polymodel.scop.util.ScopLoopInnermostExtraction;

/**
 * Vectorize the innermost loop with the vectorization configuration
 * @author zouyun
 *
 */
public class LoopVectorization{
	/**
	 * Post-processing for generating the vectorization pragma annotation for the innermost loops
	 * When depth == -1, all the innermost loops are attached with vectorization pragma annotation
	 * When depth >= 0, the innermost loops whose depth equal to the specified depth are attached with vectorization pragma
	 * @param root
	 * @return
	 */
	public static AbstractScopNode vectorizeInnermost(AbstractScopNode node, int depth){
		List<ScopFor> innermostFors = ScopLoopInnermostExtraction.extractInnermostScopFors(node);
		for(ScopFor sf: innermostFors){
			if(depth == -1 || (depth >= 0 && depth == sf.getLoopDepth())){
				 VectorizationAnnotation va = ScopUserFactory.vectorizationAnnotation(true);
	    		 sf.getScopAnnotations().add(va);
			}
		}
		return node;
	}
	
	/**
	 * Post-processing for the loop bound for the optimized point loop generated
	 * @param root
	 * @param options
	 * @return
	 */
	public static ScopRoot generate(ScopRoot root, OptimizationOptions options){
		//if((options.buffering && options.vectorization) || (options.optimizedPointLoop != null && options.vectorization)){
		if(options.optimizedPointLoop != null && options.vectorization){
			int innermost = options.numberOfTiledDimensions;
			//System.out.println("innermost " + innermost);
			int[] unrollFactor = new int[options.numberOfTiledDimensions+1];
			for(int i = 0; i <= options.numberOfTiledDimensions; i++)	unrollFactor[i] = 1;
			List<Integer> dims = new LinkedList<Integer>();
			for(LoopUnrollOptions unroll: options.getUnrollOptions()){
				dims.add(unroll.dim);
				unrollFactor[unroll.dim] = unroll.factor;
			}
			VectorizedLoopPostProcessing post = new VectorizedLoopPostProcessing(dims ,unrollFactor, innermost, options.getNElementsPerVec(), "SV");
			root.accept(post);
		}
//		else if(options.vectorization){
//			VectorizeLoops vectorizer = new VectorizeLoops(options.getVecDim(), options.getSimdStmtMap(), options.getNElementsPerVec());
//			root.accept(vectorizer);
//		}
		
		return root;
	}
	
	//post processing for vectorized loops, which modifies the loop stride from 1 to unrollFactor*nElems
	private static class VectorizedLoopPostProcessing extends ScopDepthFirstVisitorImpl{
		private int[] unrollFactor;
		private int nElems;
		private List<Integer> dims;
		private int innermost;
		private String SIMDPrefix;
		private List<ScopFor> processed;
		
		public VectorizedLoopPostProcessing(List<Integer> _dims, int[] _unrollFactor, int _innermost, int _nElems, String _SIMDPrefix){
			dims = _dims;
			unrollFactor = _unrollFactor;
			nElems = _nElems;
			SIMDPrefix = _SIMDPrefix;
			innermost = _innermost;
			processed = new LinkedList<ScopFor>();	
		}
		
		@Override
		public void outScopStatementMacro(ScopStatementMacro a) {
			//check whether it is 
			if(a.getName().startsWith(SIMDPrefix)){	//find the match
				EObject obj = a;
				while(obj != null){
					if(obj instanceof ScopFor){	//get to the innermost loop
							ScopFor s = (ScopFor)obj;
							int depth = s.getLoopDepth();
							if(!processed.contains(s) && dims.contains(depth)){
							List<IntExpression> exps = new LinkedList<IntExpression>();
							exps.add(s.getStride().copy());
							if(depth == innermost){
								exps.add(IntExpressionBuilder.constant(nElems));
							}
							exps.add(IntExpressionBuilder.constant(unrollFactor[depth]));
							IntExpression new_stride = IntExpressionBuilder.prod(exps);
							s.setStride(new_stride);
							processed.add(s);
						}
					}
					obj = obj.eContainer();
				}
			}
		}
		
	}
	///////////////////////////////////Below is for general polyhedral program, and not exposed to anyone
//	//1.traverse the loops until gets to the innermost loops
//	//2.replace all the statements in the loop with SIMD instructions
//	private static class VectorizeLoops extends ScopDepthFirstVisitorImpl{
//		private int dim;	//the dimension for vectorization
//		private SIMDStmtConversion simdStmtConverter;
//		private int nElements; //the number of element in a vector
//		
//		public VectorizeLoops(int _dim, Map<String, EList<String>> _simd_stmts_map, int _nElements){
//			dim = _dim;
//			simdStmtConverter = new SIMDStmtConversion(_simd_stmts_map);
//			nElements = _nElements;
//		}
//		
//		@Override
//		public void outScopFor(ScopFor s) {
//			int depth = s.getLoopDepth();
//			if(depth == dim){	//vectorize the current loop
//				//convert the statement within the loop
//				s.accept(simdStmtConverter);
//				//post processing of the loop, reset the loop stride to s.stride*nElement
//				List<IntExpression> exps = new LinkedList<IntExpression>();
//				exps.add(s.getStride().copy());
//				exps.add(IntExpressionBuilder.constant(nElements));
//				IntExpression new_stride = IntExpressionBuilder.prod(exps);
//				s.setStride(new_stride);
//			}
//		}
//	}
//	
//	//1. For each statement within the loop, replace the statement with the corresponding SIMD Statement
//	private static class SIMDStmtConversion extends ScopDepthFirstVisitorImpl{
//		public Map<String, EList<String>> simd_stmts_map;
//		
//		public SIMDStmtConversion(Map<String, EList<String>> _simd_stmts_map){
//			simd_stmts_map = _simd_stmts_map;
//		}
//		
//		@Override
//		public void outScopStatementMacro(ScopStatementMacro a) {
//			System.out.println("check current statement " + a.getName());
//			List<AbstractScopNode> simd_stmt_macros = new LinkedList<AbstractScopNode>();
//			//For each simd statement create the correspoinding marcors
//			for(String simd_stmt_name: simd_stmts_map.get(a.getName())){
//				ScopStatementMacro macro = EcoreUtil.copy(a);
//				macro.setName(simd_stmt_name);
//				simd_stmt_macros.add(macro);
//			}
//			//create a scop block that includes all the new simd macros
//			ScopBlock spBlock = ScopUserFactory.scopBlock(simd_stmt_macros);
//			EcoreUtil.replace(a, spBlock);
//		}
//	}
}