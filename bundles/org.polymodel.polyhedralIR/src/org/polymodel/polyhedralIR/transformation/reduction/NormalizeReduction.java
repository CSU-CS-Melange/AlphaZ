package org.polymodel.polyhedralIR.transformation.reduction;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;

public class NormalizeReduction {
	
	private static final PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;

	public static List<StandardEquation> apply(Program program) {
		List<StandardEquation> newEqs = new LinkedList<StandardEquation>();
		for (AffineSystem system : program.getSystems()) {
			newEqs.addAll(apply(system));
		}
		return newEqs;
	}
	
	public static List<StandardEquation> apply(AffineSystem system) {
		List<StandardEquation> cList = new LinkedList<StandardEquation>();
		for (StandardEquation eq : system.getEquations()) {
			cList.add(eq);
		}

		List<StandardEquation> newEqs = new LinkedList<StandardEquation>();
		for (StandardEquation eq : cList) {
			newEqs.addAll(apply(eq));
		}
		return newEqs;
	}
	
	public static List<StandardEquation> apply(StandardEquation eq) {
		List<StandardEquation> newEqs = new LinkedList<StandardEquation>();
		ReduceExpression rexpr = findReduce(eq.getExpression());
		while (rexpr != null) {
			newEqs.add(apply(rexpr));
			rexpr = findReduce(eq.getExpression());
		}
		return newEqs;
	}
	
	private static ReduceExpression findReduce(Expression expr) {
		//base case
		if (expr instanceof ReduceExpression && !(expr.eContainer() instanceof StandardEquation)) {
			return (ReduceExpression)expr;
		}
		for (EObject obj : expr.eContents()) {
			if (obj instanceof Expression) {
				ReduceExpression res = findReduce((Expression)obj);
				if (res != null) return res;
			}
		}
		return null;
	}
	
	public static StandardEquation apply(ReduceExpression reduce) {
		String nameContEq;
		AffineSystem system;
		if (reduce.getContainerEquation() instanceof StandardEquation) {
			nameContEq = ((StandardEquation)reduce.getContainerEquation()).getVariable().getName();
			system = ((StandardEquation)reduce.getContainerEquation()).getContainerSystem();
		} else {
			nameContEq = ((UseEquation) reduce.getContainerEquation()).getOutputs().get(0).getName();
			system = ((UseEquation) reduce.getContainerEquation()).getContainerSystem();
		}
		
		String varName = "NR_" + nameContEq;
		if (system.containsVariable(varName)) {
			varName = varName + "_";
			int num = 1;
			while (system.containsVariable(varName+num)) {
				num++;
			}
			return apply(reduce, varName+num);
		} else {
			return apply(reduce, varName);
		}
	}
	
	/**
	 * Returns the reference to the new equation created
	 * 
	 * @param reduce
	 * @param varName
	 * @return
	 */
	public static StandardEquation apply(ReduceExpression reduce, String varName) {
		//base check
		if (reduce.eContainer() instanceof StandardEquation) {
			throw new RuntimeException("This reduction is already normalized.");
		}
		AffineSystem system;
		if (reduce.getContainerEquation() instanceof StandardEquation)
			system = ((StandardEquation)reduce.getContainerEquation()).getContainerSystem();
		else
			system = ((UseEquation)reduce.getContainerEquation()).getContainerSystem();
		
		//check name
		if (system.containsVariable(varName)) {
			throw new RuntimeException("Duplicated variable : " + varName);
		}
		//var 
		VariableDeclaration newVar = _fact.createVariableDeclaration(varName, reduce.getExpressionType(), reduce.getContextDomain().copy());
		system.getLocals().add(newVar);
		
		//Replace reduction with variable expression
		EcoreUtil.replace(reduce, _fact.createVariableExpression(newVar));
		
		//Equation becomes the reduction
		StandardEquation newEq = _fact.createStandardEquation(newVar, reduce);
		system.getEquations().add(newEq);
		
		return newEq;
	}
}
