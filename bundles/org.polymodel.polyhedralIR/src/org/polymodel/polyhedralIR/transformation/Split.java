package org.polymodel.polyhedralIR.transformation;


import java.util.LinkedList;
import java.util.List;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.transformation.helper.ReplaceVariableExpression;

/**
 * Split takes a variable and a domain and transforms the program s.t. the variable is split into two.
 * The two variables have disjoint domains, where their union is equivalent to the original domain of the variable.
 * 
 * 
 * @author yuki
 *
 */
public class Split {
	
	protected static final String TEMP_PREFIX = "_temp_for_split_";
	protected static final PolyhedralIRUserFactory fact = PolyhedralIRUserFactory.eINSTANCE;
	
	public static boolean DEBUG = false;

	public static void transform(AffineSystem system, VariableDeclaration targetVar, Domain newDomain){

		String newVarPostfix = "_split";
		while (system.containsVariable(targetVar.getName()+newVarPostfix)) {
			newVarPostfix = "_" + newVarPostfix; 
		}
		
		transform(system, targetVar, newDomain, targetVar.getName()+newVarPostfix);
	}

	public static void transform(AffineSystem system, VariableDeclaration targetVar, Domain newDomain, String newVarName ){
		//Check for duplicate variable
		if (system.containsVariable(newVarName)) {
			throw new RuntimeException("Variable : " + newVarName + " already exists.");
		}
		
		//check dimensionality of the given domain
		if (newDomain.getDim() != targetVar.getDomain().getDim()) {
			throw new RuntimeException("Dimension of the given domain does not match the original domain.");
		}
		
		//Make sure the given domain splits variable into two
		Domain splitDom = targetVar.getDomain().intersection(newDomain);
		Domain stayDom = targetVar.getDomain().difference(newDomain);
		
		if (DEBUG) {
			System.out.println("===Split===");
			System.out.println("Split Domain: " + splitDom);
			System.out.println("Stay Domain: " + stayDom);
		}
		
		if (splitDom.isEmpty()) {
			throw new RuntimeException("Given new domain does not intersect with the domain of target variable.");
		}
		if (stayDom.isEmpty()) {
			throw new RuntimeException("Given new domain is a super set of the domain of target variable.");
		}
		
		//Create new variable
		VariableDeclaration newVar = fact.createVariableDeclaration(newVarName, targetVar.getType(), splitDom);
		
		//Create a temporary variable+equation for later substitute
		VariableDeclaration tempVar = fact.createVariableDeclaration(TEMP_PREFIX+newVarName, targetVar.getType(), targetVar.getDomain().copy());
		//add it as local
		system.getLocals().add(tempVar);
		// Equation is of the form
		// case
		//   splitDomain : newVar;
		//   stayDomain : oldVar;
		// esac;
		List<Expression> tempCaseExprs = new LinkedList<Expression>();
		tempCaseExprs.add(fact.createRestrictExpression(stayDom.copy(), fact.createVariableExpression(targetVar)));
		tempCaseExprs.add(fact.createRestrictExpression(splitDom.copy(), fact.createVariableExpression(newVar)));
		CaseExpression tempEqCase = fact.createCaseExpression(tempCaseExprs);
		StandardEquation tempEq = fact.createStandardEquation(tempVar, tempEqCase);
		
		//Change the domain of target variable to the domain after cut
		targetVar.setDomain(stayDom);
		
		//Add the new variable to the system
		if (targetVar.isInput()) {
			system.getInputs().add(newVar);
		} else {
			//If its not input, equation should be copied as well
			StandardEquation newEq = fact.createStandardEquation(newVar, system.getEquation(targetVar.getName()).getExpression().copy());
			system.getEquations().add(newEq);
			
			if (targetVar.isOutput()) {
				system.getOutputs().add(newVar);
			} else if (targetVar.isLocal()) {
				system.getLocals().add(newVar);
			} else {
				throw new RuntimeException("Target variable is not any of input/output/local");
			}
		}
		
		if (DEBUG) {
			System.out.println(" - temp variable created");
		}
		
		//Replace all occurrences of target variable in VariableExpression with tempVar
		ReplaceVariableExpression.transform(targetVar, tempVar);

		if (DEBUG) {
			System.out.println(" - replaced with temp variable");
		}
		
		//Add equation for tempVar
		system.getEquations().add(tempEq);
		
		int count=1;
		int max = system.getEquations().size()-1;
		
		//For all equations in the system, inline tempVar once
		for (StandardEquation eq : system.getEquations()) {
			if (eq.equals(tempEq)) continue;
			if (DEBUG) {
				System.out.println(" - inlining temp variable " + count + "/" + max);
				count++;
			}
			Inline.transform(eq, tempEq, true);
		}
		
		if (DEBUG) {
			System.out.println(" - inline complete");
		}

		
		//Remove temp since its no longer in use
		system.getEquations().remove(tempEq);
		system.getLocals().remove(tempVar);
		
		if (DEBUG) {
			System.out.println(" - done");
		}

	}

	
}