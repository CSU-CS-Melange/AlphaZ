package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.LinkedList;
import java.util.List;

import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

public class ExpressionPrinterForScheduledC extends ExpressionPrinterForC {

	public static String print(Expression expr, Boolean mainFunction) {
		AffineSystem syst;
		if (expr.getContainerEquation() instanceof StandardEquation)
			syst = ((StandardEquation) expr.getContainerEquation()).getContainerSystem();
		else
			syst = ((UseEquation) expr.getContainerEquation()).getContainerSystem();
		
		return new ExpressionPrinterForScheduledC(syst.getTargetMapping(), mainFunction).start(expr);
	}

	protected ExpressionPrinterForScheduledC(TargetMapping tm, boolean mainFunction) {
		super(tm, mainFunction);
	}

	@Override
	public String caseReduceExpression(ReduceExpression node) {
		if (node.getContainerEquation() instanceof UseEquation)
			throw new RuntimeException("TODO: implement this method for UseEquation");
		
		StringBuffer sbody = new StringBuffer();
		String name = CodeGenConstantsForC.getReductionFunctionName((StandardEquation)node.getContainerEquation(), reductionNumbers.getReductionNumber(node));
		sbody.append(name);
		
		//Call evaluation function of the reduce
		//function parameters are program parameters + indices of the result space
		sbody.append("(");
		List<String> fparams = new LinkedList<String>(); 
		//Get program parameters from the domain
		for (Variable iv : node.getContextDomain().getParams()) {
			fparams.add(iv.toString());
		}
		
		//pretty print the dependence function to pass the indices	
		for (AffineExpression ile : _currentDep.getExpressions()) {
			fparams.add(ile.toString());
		}
		
		GetVariablesInExpression expressionVars = new GetVariablesInExpression(targetMapping);
		List<VariableDeclaration> vars = expressionVars.getVars(node.getExpr().copy());	//get the list of variables with distinct memory space used in the expression
		//add the name of all the variables needed for the computation
		for(VariableDeclaration t_var: vars){
			MemorySpace ms = targetMapping.getMemoryMaps().get(t_var).getSpace();
			if(ms.getDomain().getNIndices() == 0){
				String var_param = "&" + ms.getName();
				fparams.add(var_param);
			}else{
				fparams.add(ms.getName());
			}
		}
		
		sbody.append(CodeGenUtility.toStringList(fparams, ","));
		sbody.append(")");

		return sbody.toString();
	}
	
	
}
