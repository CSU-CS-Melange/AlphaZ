package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.VariableDeclaration;

public class VariableShouldNotBeDefinedError implements IValidatorMessage {
	protected final TYPE type;
	protected final VariableDeclaration var;
	
	public VariableShouldNotBeDefinedError(TYPE type, VariableDeclaration var) {
		this.type = type;
		this.var = var;
	}
	public TYPE getType() {	
		return type;
	}

	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + " Input Variable " + var.getName() +" cannot have an equation.";			
	}

}
