package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;

/**
 * Utility functions used for the optimization preprocessing for DTiler
 * @author zouyun
 *
 */
public class DTilerProcessUtility{
	public final static PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;
	
	/**
	 * Create a full tile domain with ndims {c1, c2, ...cd|t1<= c1 < t1 + ts1, t2 <= c2 < t2 + ts2, ... td <= cd < td+tsd}
	 * @param paramDom: parameter domain of the original program
	 * @param ndims: number of tiled dimensions
	 * @param tileSizes: the tile size name for each dimension
	 * @return
	 */
	public static Domain constructFullTileDomain(ParameterDomain paramDom, int ndims, List<String> tileIndices, List<String> tileSizes){
		//construct the parameter list for the full tile domain
		List<String> params = new LinkedList<String>();
		params.addAll(tileIndices);
		params.addAll(tileSizes);
		//add the rest of parameters
		for(String name: paramDom.getParamNames()){
			if(!params.contains(name)){
				params.add(name);
			}
		}
		
		//construct the indices list
		List<String> indices = new LinkedList<String>();
		for(int i = 0; i < ndims; i++){
			String index = "c"+i;
			indices.add(index);
		}
		
		//construct an ndims-dimensional universal domain
		Domain tileDom = PolyhedralIRUtility.parseDomainFromString(params, indices, new ArrayList<String>());
		List<Variable> tileIndexVars = tileDom.getParams().subList(0, ndims-1);
		List<Variable> tileSizeVars = tileDom.getParams().subList(ndims, 2*ndims-1);
		List<Variable> indexVars = tileDom.getIndices();
		//add the constrains inside
		for(int i = 0; i < ndims; i++){
			//ci < ti + tsi
			tileDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(indexVars.get(i)), 
					binaryAddExpression(tileIndexVars.get(i), tileSizeVars.get(i)), 
					ComparisonOperator.LT));
			
			//ti <= ci
			tileDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileIndexVars.get(i)), 
					IntExpressionBuilder.affine(indexVars.get(i)), 
					ComparisonOperator.LE));
			
			//tsi >= 1
			tileDom.getPMdomain().addConstraint(IntExpressionBuilder.constraint(IntExpressionBuilder.affine(tileSizeVars.get(i)), 
					IntExpressionBuilder.constant(1), 
					ComparisonOperator.GE));
		}
		
		return tileDom;
	}
	
	public static IntExpression binaryAddExpression(Variable var1, Variable var2){
		List<IntExpression> plus_terms = new LinkedList<IntExpression>();
		plus_terms.add(IntExpressionBuilder.affine(var1));
		plus_terms.add(IntExpressionBuilder.affine(var2));
		
		return IntExpressionBuilder.sum(plus_terms);
	}
	
	public static IntExpression binaryAddExpression(Variable var1, int scalar){
		return IntExpressionBuilder.add(IntExpressionBuilder.affine(var1), scalar);
	}
	/**
	 * Get the min and max distance for a given set of uniform dependence vectors along each dimension d
	 * LIST 0: the min value, LIST 1: the max value
	 * @param dep_vecs: the set of uniform dependences
	 * @param ndim:	number of dimensions
	 * @return
	 */
	public static List<List<Integer>> getRanges(int ndim, List<List<Integer>> dep_vecs){
		List<List<Integer>> ranges = new LinkedList<List<Integer>>();
		
		for(int i = 0; i < ndim; i++){
			int min = dep_vecs.get(0).get(i);
			int max = dep_vecs.get(0).get(i);
			
			for(int j = 1; j < dep_vecs.size(); j++){
				if(dep_vecs.get(j).get(i) < min){
					min = dep_vecs.get(j).get(i);
				}else if(dep_vecs.get(j).get(i) > max){
					max = dep_vecs.get(j).get(i);
				}
			}
			
			List<Integer> range = new LinkedList<Integer>();
			range.add(min);
			range.add(max);
			
			ranges.add(range);
		}
		
		
		return ranges;
	}
	
	public static List<Integer> getRegionSize(List<List<Integer>> ranges){
		List<Integer> region = new LinkedList<Integer>();
		int ndim = ranges.size();
		for(int i = 0; i < ndim; i++){
			region.add(ranges.get(i).get(1));
		}
		
		return region;
	}
	
	public static List<List<Integer>> getUnrolledRanges(List<List<Integer>> ori_ranges, int[] unrollFactor, boolean unrollInner){
		List<List<Integer>> unrolledRanges = new LinkedList<List<Integer>>();
		int unrollDim = unrollFactor.length - ori_ranges.size();
		for(int i = 0; i < ori_ranges.size() - 1; i++){
			List<Integer> temp_range = new LinkedList<Integer>();
			temp_range.addAll(ori_ranges.get(i));
			int range_0 = temp_range.get(0) - unrollFactor[i+unrollDim] + 1;
			temp_range.set(0, range_0);
			unrolledRanges.add(temp_range);
		}
		
		List<Integer> temp_range = new LinkedList<Integer>();
		temp_range.addAll(ori_ranges.get(ori_ranges.size() - 1));
		if(unrollInner){
			int range_0 = temp_range.get(0) - unrollFactor[ori_ranges.size() - 1 + unrollDim] + 1;
			temp_range.set(0, range_0);
		}
		unrolledRanges.add(temp_range);
		
		return unrolledRanges;
 	}
	
	/**
	 * Extract the maximum halo as the offset along each dimension
	 * @param var_halos
	 * @return
	 */

	public static List<Integer> getFullTileOffsets(List<VariableDeclaration> bufferVars, Map<VariableDeclaration, List<Integer>> var_halo_map){
		List<Integer> offsets = new LinkedList<Integer>();
		offsets.addAll(var_halo_map.get(bufferVars.get(0)));
		
		for(int i = 1; i < bufferVars.size(); i++){
			List<Integer> var_halo = var_halo_map.get(bufferVars.get(i));
			for(int j = 0; j < var_halo.size(); j++){
				if(var_halo.get(j) > offsets.get(j)){
					offsets.set(j, var_halo.get(j));
				}
			}
		}
		
		return offsets;
	}
	
	/**
	 * Extract the integer vector out of the uniform dependence
	 * @param dep_func
	 * @return
	 */
	public static List<Integer> extractDepVec(AffineFunction dep_func){
		List<Integer> vec = new LinkedList<Integer>();
		
		//extract the integer along each dimension
		for(AffineExpression exp: dep_func.getExpressions()){
			if(exp.getConstantTerm() == null){
				vec.add(0);
			}else{
				vec.add((int)(-exp.getConstantTerm().getCoef()));
			}
		}
		return vec;
	}
	
	/**
	 * Extract the uniform dependences for each variable accessed in the statements
	 * @param candidtates
	 * @return
	 */
	public static class UniformDependenceExtraction extends PolyhedralIRDepthFirstVisitorImpl{
		private Map<VariableDeclaration, List<List<Integer>>> var_dep_map;
		
		protected UniformDependenceExtraction(){
			var_dep_map = new HashMap<VariableDeclaration, List<List<Integer>>>();
		}
		
		public static Map<VariableDeclaration, List<List<Integer>>> extractDependeceFromStmts(List<EquationAsStatement> stmts){
			UniformDependenceExtraction extract = new UniformDependenceExtraction();
			for(EquationAsStatement stmt: stmts){
				stmt.getRhs().accept(extract);
			}
			
			return extract.var_dep_map;
		}
		
		@Override
		public void inDependenceExpression(DependenceExpression d) {
			if(d.getExpr() instanceof VariableExpression){	//found candidate
				VariableDeclaration var = ((VariableExpression)d.getExpr()).getVarDecl();
				if(var_dep_map.get(var) != null){
					List<Integer> dep_vec = extractDepVec(d.getDep().copy());
					var_dep_map.get(var).add(dep_vec);
				}else{
					List<List<Integer>> deps = new LinkedList<List<Integer>>();
					List<Integer> dep_vec = extractDepVec(d.getDep().copy());
					deps.add(dep_vec);
					var_dep_map.put(var, deps);
				}
			}
		}
	}


	public static class DependenceConversion extends PolyhedralIRDepthFirstVisitorImpl{
		protected int[] iter;
		
		private DependenceConversion(int[] _iter){
			iter = _iter;
		}
		
		public static Expression ConvertDependence(Expression expr, int[] _iter){
			DependenceConversion depConverter = new DependenceConversion(_iter);
			expr.accept(depConverter);
			return expr;
		}
		
		@Override
		public void inDependenceExpression(DependenceExpression d) {
			AffineFunction ori_dep = d.getDep().copy();
			AffineFunction iter_dep = PolyhedralIRUtility.createUniformFunction(ori_dep.getParams(), ori_dep.getIndices(), iter);
			AffineFunction new_dep = d.getDep().compose(iter_dep);
			d.setDep(new_dep);
		}
		
		@Override
		public void inVariableExpression(VariableExpression v) {
			if(!(v.eContainer() instanceof DependenceExpression)){
				AffineFunction new_dep = PolyhedralIRUtility.createUniformFunction(v.getVarDecl().getDomain(), iter);
				DependenceExpression dep_expr = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(new_dep, EcoreUtil.copy(v));
				EcoreUtil.replace(v, dep_expr);
			}
		}
		
	}
	
	/**
	 * Extract the candidate statement for the optimized loop
	 * When Domain is specified, extract all the statement that intersects with the domain, and without any equality in the statement domain
	 */
	public static List<EquationAsStatement> extractCandidateStmts(List<TiledCLoop> tiledLoops, VariableDeclaration var){
		List<EquationAsStatement> candidates = new LinkedList<EquationAsStatement>();
		Domain varDom = null;
		for(TiledCLoop tiledLoop: tiledLoops){
			for(Statement stmt: tiledLoop.getStatements()){
				if((stmt instanceof EquationAsStatement) && ((EquationAsStatement)stmt).getVarDecl().equals(var)){
					if(varDom == null){
						varDom = ((EquationAsStatement)stmt).getVarDecl().getDomain();
					}
					candidates.add((EquationAsStatement)stmt);
				}
			}
		}
		//extract the dependences for the current variable
		List<List<Integer>> var_deps = UniformDependenceExtraction.extractDependeceFromStmts(candidates).get(var);
		//extract the main domain with the boundary domain peeled off
		Domain oriDom = var.getDomain().copy();
		Domain resultDom = oriDom.copy();
		for(List<Integer> var_dep: var_deps){
			//for each dependence 
			int[] dep_vec = new int[var_dep.size()];
			for(int i = 0; i < var_dep.size(); i++){
				dep_vec[i] = var_dep.get(i);
			}
			AffineFunction function = PolyhedralIRUtility.createUniformFunction(oriDom, dep_vec);
			resultDom = resultDom.intersection(oriDom.image(function));
		}
		resultDom.simplify();
		
		//extract the statement that intersects with the extracted domain
		List<EquationAsStatement> extracted = new LinkedList<EquationAsStatement>();
		for(EquationAsStatement stmt: candidates){
			if(!stmt.getDomain().intersection(resultDom).isEmpty()){
				extracted.add(stmt);
			}
		}
		
		return extracted;
	}
	
	public static List<EquationAsStatement> extractCandidateStmts(List<TiledCLoop> tiledLoops, List<VariableDeclaration> vars){
		List<EquationAsStatement> extracted = new LinkedList<EquationAsStatement>();
		
		for(VariableDeclaration var: vars){
			extracted.addAll(extractCandidateStmts(tiledLoops, var));
		}
		
		return extracted;
	}
	
	public static List<EquationAsStatement> extractCandidateStmts(List<TiledCLoop> tiledLoops, VariableDeclaration var, Domain domain){
		List<EquationAsStatement> extracted = new LinkedList<EquationAsStatement>();
		for(TiledCLoop tiledLoop: tiledLoops){
			for(Statement stmt: tiledLoop.getStatements()){
				if((stmt instanceof EquationAsStatement) && ((EquationAsStatement)stmt).getVarDecl().equals(var) && !((EquationAsStatement)stmt).getDomain().intersection(domain).isEmpty()){
					extracted.add((EquationAsStatement)stmt);
				}
			}
		}
		
		return extracted;
	}
	
	public static List<EquationAsStatement> extractCandidateStmts(List<TiledCLoop> tiledLoops, Map<VariableDeclaration, Domain> var_dom_map){
		List<EquationAsStatement> extracted = new LinkedList<EquationAsStatement>();
		
		for(Map.Entry<VariableDeclaration, Domain> var_dom_entry: var_dom_map.entrySet()){
			extracted.addAll(extractCandidateStmts(tiledLoops, var_dom_entry.getKey(), var_dom_entry.getValue()));
		}
		
		return extracted;
	}
}