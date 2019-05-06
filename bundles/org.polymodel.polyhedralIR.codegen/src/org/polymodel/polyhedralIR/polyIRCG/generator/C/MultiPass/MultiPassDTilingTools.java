package org.polymodel.polyhedralIR.polyIRCG.generator.C.MultiPass;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.dtiler.DTiler.TilableBlock;
import org.polymodel.scop.dtiler.basic.DTilingTools;
import org.polymodel.scop.dtiler.hierarchy.basic.SubstituteVariable;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

public class MultiPassDTilingTools {
	
	/**
	 * Get the maximum number of dimensions for a given scop
	 * @param root
	 * @return
	 */
	public static int getMaxDimensions(ScopRoot root){
		FindMaxForDepth maxForDepth = new FindMaxForDepth();
		root.accept(maxForDepth);
		
		return maxForDepth.depth;
	}
	
	public static int getMaxDimensions(TilableBlock tilableBlock){
		int max_depth = 0;
		
		for(ScopFor scop_for: tilableBlock.loops){
			FindMaxForDepth maxForDepth = new FindMaxForDepth();
			scop_for.accept(maxForDepth);
			if(max_depth < maxForDepth.depth){
				max_depth = maxForDepth.depth;
			}
		}
		
		return max_depth;
	}
	
	private static class FindMaxForDepth extends ScopDepthFirstVisitorImpl {
		private int depth;
		
		public FindMaxForDepth(){
			depth = 0;
		}
		
		@Override
		public void inScopFor(ScopFor s) {
			if(s.getLoopDepth() > depth){
				depth = s.getLoopDepth();
			}
		}
	}
	
	/**
	 * Extract the list of surrounding for loops for each statement within a vistited scop
	 */
	public static Map<ScopStatementMacro,List<ScopFor>> getSurroundingLoopforStatements(AbstractScopNode node){
		
		findSurroundingLoopsWithinNodes findLoops = new findSurroundingLoopsWithinNodes();
		node.accept(findLoops);
		
		return findLoops.loops; 
	}
	
	private static class findSurroundingLoopsWithinNodes extends ScopDepthFirstVisitorImpl{
		private Map<ScopStatementMacro, List<ScopFor>> loops;
		
		public findSurroundingLoopsWithinNodes(){
			loops = new HashMap<ScopStatementMacro, List<ScopFor>>();
		}
		
		@Override
		public void inScopStatementMacro(ScopStatementMacro s) {
			loops.put(s, s.getSurroundingScopFors());
		}
	}
	
	////////////////////////////////Other functions
	/**
	 * Extract the first iteration point out of a loop nest
	 * @param loopNest
	 * @return
	 */
	public static List<IntExpression> extractOffsets(ScopFor loopNest){
		List<ScopFor> loops = DTilingTools.extractLoops(loopNest);
		List<IntExpression> offsets = new LinkedList<IntExpression>();
		Map<Variable, IntExpression> varOffsetMap = new HashMap<Variable, IntExpression>();
		
		for(int i = 0; i < loops.size();i++){
			IntExpression lb_exp = loops.get(i).getLB().copy();
			//sub stitute the existing variable
			for(Map.Entry<Variable, IntExpression> varOffset: varOffsetMap.entrySet()){
				//System.out.println("substitute variable " + varOffset.getKey().getName() + " With expression " + varOffset.getValue().copy());
				lb_exp = SubstituteVariable.substitute(lb_exp, varOffset.getKey(), varOffset.getValue().copy());
			}
			offsets.add(lb_exp.simplify());
			varOffsetMap.put(loops.get(i).getIterator(), lb_exp.copy().simplify());
		}
	
		return offsets;
	}
	
	
	public static List<List<IntConstraint>> constraintsProduct(List<List<IntConstraint>> consList1, List<List<IntConstraint>> consList2){
		List<List<IntConstraint>> constraintsList = new LinkedList<List<IntConstraint>>();
		
		if(consList1 == null || consList1.size() <= 0){
			return consList2;
		}
		
		if(consList2 == null || consList2.size() <= 0){
			return consList1;
		}
		
		for(int i = 0; i < consList1.size(); i++){
			for(int j = 0; j < consList2.size(); j++){
				List<IntConstraint> constraints = new LinkedList<IntConstraint>();
				constraints.addAll(consList1.get(i));
				constraints.addAll(consList2.get(j));
				constraintsList.add(constraints);
			}
		}
		
		return constraintsList;
	}
	/**
	 * Create constraint expr op var_expr
	 * @param expr
	 * @param var_expr
	 * @param OP
	 * @return
	 */
	public static List<List<IntConstraint>> createConstraints(IntExpression expr, IntExpression var_expr, ComparisonOperator op, ReductionOperator red_op){
		List<List<IntConstraint>> constraintList = new LinkedList<List<IntConstraint>>();
		
		if(expr instanceof ReductionExpression){
			//check the top level reduction operation
			if(((ReductionExpression)expr).getOperator() == red_op){
				List<Map<List<IntConstraint>, IntExpression>> maps = new LinkedList<Map<List<IntConstraint>, IntExpression>>();
				for(IntExpression subexpr: ((ReductionExpression)expr).getExpressions()){
					if(subexpr instanceof ReductionExpression){
						maps.add(reductionExpressionConstraint((ReductionExpression)subexpr));
					}else{
						Map<List<IntConstraint>, IntExpression> temp_map = new HashMap<List<IntConstraint>, IntExpression>();
						temp_map.put(new LinkedList<IntConstraint>(), subexpr.copy());
						maps.add(temp_map);
					}
				}
				constraintList.add(new LinkedList<IntConstraint>());
				for(int i = 0; i < maps.size(); i++){
					List<List<IntConstraint>> temp_list = new LinkedList<List<IntConstraint>>();
					for(int j = 0; j < constraintList.size(); j++){
						for(Map.Entry<List<IntConstraint>, IntExpression> submap: maps.get(i).entrySet()){
							List<IntConstraint> cons = new LinkedList<IntConstraint>();
							cons.addAll(constraintList.get(j));
							cons.addAll(submap.getKey());
							cons.add(IntExpressionBuilder.constraint(submap.getValue(), var_expr, op));
							
							temp_list.add(cons);
						}
					}
					constraintList = temp_list;
				}
				
			}else{
				Map<List<IntConstraint>, IntExpression> redconsts = reductionExpressionConstraint((ReductionExpression)expr);
				for(Map.Entry<List<IntConstraint>, IntExpression> consts: redconsts.entrySet()){
					List<IntConstraint> constraints =new LinkedList<IntConstraint>();
					constraints.addAll(consts.getKey());
					constraints.add(IntExpressionBuilder.constraint(consts.getValue().copy(), var_expr, op));
					constraintList.add(constraints);
				}
			}
		}else{
			List<IntConstraint> constraints = new LinkedList<IntConstraint>();
			IntConstraint ub_cons = IntExpressionBuilder.constraint(expr, var_expr, op);
			constraints.add(ub_cons);
			constraintList.add(constraints);
		}
		
		return constraintList;
	}
	
	public static Map<List<IntConstraint>, IntExpression> reductionExpressionConstraint(ReductionExpression red){
		Map<List<IntConstraint>, IntExpression> redconsts = new HashMap<List<IntConstraint>, IntExpression>();
		List<Map<List<IntConstraint>, IntExpression>> maps = new LinkedList<Map<List<IntConstraint>, IntExpression>>();
		
		for(IntExpression expr: red.getExpressions()){
			if(expr instanceof ReductionExpression){
				maps.add(reductionExpressionConstraint((ReductionExpression)expr));
			}else{
				Map<List<IntConstraint>, IntExpression> map = new HashMap<List<IntConstraint>, IntExpression>();
				map.put(new LinkedList<IntConstraint>(), expr.copy());
				maps.add(map);
			}
		}
		
		//try all the two way combination for the comparison operator
		if((red.getOperator() == ReductionOperator.MAX) || (red.getOperator() == ReductionOperator.MIN)){
			redconsts.putAll(maps.get(0));
			for(int i = 1; i < maps.size(); i++){
				Map<List<IntConstraint>, IntExpression> cur_map = maps.get(i);
				Map<List<IntConstraint>, IntExpression> temp_map = new HashMap<List<IntConstraint>, IntExpression>();
				for(Map.Entry<List<IntConstraint>, IntExpression> sublmap: redconsts.entrySet()){
					for(Map.Entry<List<IntConstraint>, IntExpression> subrmap: cur_map.entrySet()){
						List<IntConstraint> lcons = new LinkedList<IntConstraint>();
						lcons.addAll(sublmap.getKey());
						lcons.addAll(subrmap.getKey());
						IntConstraint lcon;
						
						if(red.getOperator() == ReductionOperator.MAX){	//left hand is larger
							lcon = IntExpressionBuilder.constraint(sublmap.getValue().copy().simplify(), subrmap.getValue().copy().simplify(), ComparisonOperator.GE);
						}else{
							lcon = IntExpressionBuilder.constraint(sublmap.getValue().copy().simplify(), subrmap.getValue().copy().simplify(), ComparisonOperator.LE);
						}
						lcons.add(lcon);
						temp_map.put(lcons, sublmap.getValue().copy().simplify());
						
						List<IntConstraint> rcons = new LinkedList<IntConstraint>();
						rcons.addAll(sublmap.getKey());
						rcons.addAll(subrmap.getKey());
						IntConstraint rcon;
						
						if(red.getOperator() == ReductionOperator.MAX){	//right hand side is larger
							rcon = IntExpressionBuilder.constraint(sublmap.getValue().copy().simplify(), subrmap.getValue().copy().simplify(), ComparisonOperator.LT);
						}else{
							rcon = IntExpressionBuilder.constraint(sublmap.getValue().copy().simplify(), subrmap.getValue().copy().simplify(), ComparisonOperator.GT);
						}
						rcons.add(rcon);
						temp_map.put(rcons, subrmap.getValue().copy().simplify());
					}
				}
				redconsts = temp_map;
			}
		}else{//sum up all possible values
			redconsts.putAll(maps.get(0));	//add the constraint maps for the first expression
			for(int i = 1; i < maps.size(); i++){
				//combine the current map and the redconsts
				Map<List<IntConstraint>, IntExpression> cur_map = maps.get(i);
				Map<List<IntConstraint>, IntExpression> temp_map = new HashMap<List<IntConstraint>, IntExpression>();
				for(Map.Entry<List<IntConstraint>, IntExpression> sublmap: redconsts.entrySet()){
					for(Map.Entry<List<IntConstraint>, IntExpression> subrmap: cur_map.entrySet()){
						List<IntConstraint> cons = new LinkedList<IntConstraint>();
						cons.addAll(sublmap.getKey());
						cons.addAll(subrmap.getKey());
						IntExpression expr;
						if(red.getOperator() == ReductionOperator.PROD){	
							expr = IntExpressionBuilder.prod(sublmap.getValue().copy().simplify(),subrmap.getValue().copy().simplify());
						}else{
							expr = IntExpressionBuilder.sum(sublmap.getValue().copy().simplify(),subrmap.getValue().copy().simplify());
						}
						temp_map.put(cons, expr);
					}
				}
				redconsts = temp_map;
			}
		}
		
		return redconsts;
	}
	
	
	public static Domain createDomainWithConstraintsList(ParameterDomain paramDom, List<Variable> indices, List<List<IntConstraint>> constraintsList){
		Domain domain = null;
		for(int i = 0; i < constraintsList.size(); i++){
			Domain temp_domain = createDomain(paramDom, indices, constraintsList.get(i));
			if(!temp_domain.isEmpty()){
				if(domain == null){
					domain = temp_domain;
				}else{
					if(!temp_domain.isEmpty()){
						domain = domain.union(temp_domain);
					}
				}
			}
		}
		
		domain.simplify();
		
		return domain;
	}
	
	
	public static Domain createDomain(ParameterDomain paramDom, List<Variable> indices, List<IntConstraint> constraints){
		List<IntConstraintSystem> systems = new LinkedList<IntConstraintSystem>();
		//construct the constriant systems
		for(IntConstraintSystem paramsystem: paramDom.getPMdomain().getPolyhedra()){
			List<IntConstraint> sys_constraint = new LinkedList<IntConstraint>();
			for(IntConstraint cons : paramsystem.getConstraints()){
				sys_constraint.add(cons);
			}
			for(IntConstraint cons: constraints){
				sys_constraint.add(cons.copy());
			}
		
			IntConstraintSystem system = IntExpressionBuilder.constraintSystem(sys_constraint);
			systems.add(system);
		}
		
		//construct a domain with the constrains
		Domain domain = PolyhedralIRUserFactory.eINSTANCE.createDomain(paramDom.getParams(), indices, systems);
		//reparse it for now
		domain = PolyhedralIRUtility.parseDomain(domain.getParamNames(), domain.toString());
		domain.simplify();
		
		return domain;
	}
}