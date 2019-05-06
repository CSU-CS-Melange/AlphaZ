package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.VariableDeclaration;

public class VariableNotUsedWarning implements IValidatorMessage {

	protected final TYPE type;
	protected final VariableDeclaration var;
	
	public VariableNotUsedWarning(TYPE type, VariableDeclaration var) {
		this.type = type;
		this.var = var;
	}
	public TYPE getType() {	
		return type;
	}
	
	public VariableDeclaration getUnusedVariable() {
		return var;
	}

	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + "Variable " + var.getName() +" not used in any equation ";			
	}
}
