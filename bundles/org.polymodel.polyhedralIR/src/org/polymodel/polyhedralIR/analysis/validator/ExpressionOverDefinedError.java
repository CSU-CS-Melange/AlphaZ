package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.CaseExpression;

public class ExpressionOverDefinedError implements IValidatorMessage {
	protected final TYPE type;

	protected final CaseExpression caseExpr;
	protected final Domain dom1;
	protected final Domain dom2;
	
	public ExpressionOverDefinedError (TYPE type, CaseExpression caseExpr, Domain dom1, Domain dom2) {
		this.type = type;
		this.caseExpr = caseExpr;
		this.dom1 = dom1;
		this.dom2 = dom2;
	}
	
	@Override
	public TYPE getType() {
		return type;
	}

	@Override
	public String toString(VERBOSITY verbosity) {
		String name = "";
		if (caseExpr.getContainerEquation() instanceof StandardEquation)
			name = ((StandardEquation) caseExpr.getContainerEquation()).getVariable().getName();
		else
			name = " (UseEq defining " + ((UseEquation) caseExpr.getContainerEquation()).getOutputs().get(0) + ")";
			
		return type + ":: " + " in the case expression of statement "
				+ name
//				" ("
//				+ dom1 + " , " + dom2
				//+ ") "
				+ ", domains of subexpressions overlap at: "
				+ dom1.intersection(dom2)
				+ ". (Intersection of " + dom1 + " and " + dom2 + " )";
	}

}
