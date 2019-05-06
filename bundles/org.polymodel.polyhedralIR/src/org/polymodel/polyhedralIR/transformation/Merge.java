package org.polymodel.polyhedralIR.transformation;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.transformation.helper.AddLocal;


/**
 * Merge takes 2 variables of disjoint domains and merge them into a single variable.
 * This transformation is the inverse of the Split transformation.
 * 
 * @author Guillaume
 */
public class Merge {
	
	protected static final PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	
	public static void transform(AffineSystem syst, VariableDeclaration var1, VariableDeclaration var2) {
		
		// Pick a fresh name
		String prefixMerge = "merge_" + var1.getName() + "_" + var2.getName() + "_";
		int k=0;
		while (syst.containsVariable(prefixMerge + k))
			k++;
		String newName = prefixMerge + k;
		
		transform(syst, var1, var2, newName);
	}
	
	public static void transform(AffineSystem syst, VariableDeclaration var1, VariableDeclaration var2, String newName) {
		// *** Checking the conditions for the transformation
		
		// Check if the types of the variables match
		if ((var1.getType().getTypeID()!=var2.getType().getTypeID()) || (var1.getType().getSigned()!=var2.getType().getSigned()))
			throw new RuntimeException("Merge: the type of variables " + var1.getName() + " and " + var2.getName() +
					" do not match");
		
		// Check that none of the 2 variables are inputs or outputs
		assert(!(syst.getInputs().contains(var1)) && !(syst.getInputs().contains(var2)));
		assert(!(syst.getOutputs().contains(var1)) && !(syst.getOutputs().contains(var2)));
		
		// Check if the domain of the 2 variables are disjoints
		Domain domVar1 = var1.getDomain();
		Domain domVar2 = var2.getDomain();
		Domain domInter = domVar1.intersection(domVar2);
		if (!domInter.isEmpty())
			throw new RuntimeException("Merge: the variables " + var1.getName() + " and " + var2.getName() +
					" do not have a disjoint domain / Intersection is: " + domInter.toString());
		
		// Check if none of these variable are output of UseEquation
		for (UseEquation ueq: syst.getUseEquations())
			for (VariableDeclaration varOut : ueq.getOutputs()) {
				if (varOut.equals(var1))
					throw new RuntimeException("Merge: the variable " + var1.getName() + " is the output of a subsystem");
				if (varOut.equals(var2))
					throw new RuntimeException("Merge: the variable " + var2.getName() + " is the output of a subsystem");
			}
		
		// *** Computation part
		
		// Get the StandardEquation for var1 and var2
		StandardEquation var1Eq = syst.getEquation(var1.getName());
		StandardEquation var2Eq = syst.getEquation(var2.getName());
		
		// Create the new VariableDeclaration
		Domain domUnion = domVar1.union(domVar2);
		VariableDeclaration varMerge = _polyIRFact.createVariableDeclaration(newName, var1.getType(), domUnion);
		syst.getLocals().add(varMerge);
		
		// Create the new Equation Merge:
		// varMerge = case							[caseExpr]
		//				domVar1 : (var1Expr)		[restrExpr1]
		//				domVar2 : (var2Expr)		[restrExpr2]
		//			  esac
		RestrictExpression restrExpr1 = _polyIRFact.createRestrictExpression(domVar1.copy(), var1Eq.getExpression().copy());
		RestrictExpression restrExpr2 = _polyIRFact.createRestrictExpression(domVar2.copy(), var2Eq.getExpression().copy());
		
		List<Expression> lexpr = new BasicEList<Expression>();
		lexpr.add(restrExpr1);
		lexpr.add(restrExpr2);
		CaseExpression caseExpr = _polyIRFact.createCaseExpression(lexpr);
		
		StandardEquation stEqMerge = _polyIRFact.createStandardEquation(varMerge, caseExpr);
		syst.getEquations().add(stEqMerge);
		syst.getEquations().remove(var1Eq);
		syst.getEquations().remove(var2Eq);
		
		// Replace the occurences of "var1" and "var2" by "domVar1:varMerge" and "domVar2:varMerge" respectively
		// (to avoid change of the computation in the case of reductions)
		VariableExpression varexpr1 = _polyIRFact.createVariableExpression(var1);
		VariableExpression varexpr2 = _polyIRFact.createVariableExpression(var2);
		RestrictExpression restexprMerge1 = _polyIRFact.createRestrictExpression(domVar1.copy(),
				_polyIRFact.createVariableExpression(varMerge));
		RestrictExpression restexprMerge2 = _polyIRFact.createRestrictExpression(domVar2.copy(),
				_polyIRFact.createVariableExpression(varMerge));
		AddLocal.AddLocalTom.replace(syst, varexpr1, restexprMerge1);
		AddLocal.AddLocalTom.replace(syst, varexpr2, restexprMerge2);
		
		// Remove the last VariableDeclaration
		syst.getLocals().remove(var1);
		syst.getLocals().remove(var2);
		
	}
	
} // Merge
