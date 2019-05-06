package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.VariableDeclaration;

public class VariableMultipleDefinitionError implements IValidatorMessage {
	protected final TYPE type;
	protected final VariableDeclaration var;
	
	public VariableMultipleDefinitionError(TYPE type, VariableDeclaration var) {
		this.type = type;
		this.var = var;
	}
	
	public TYPE getType() {	
		return type;
	}

	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + " Variable " + var.getName() +" has multiple definitions (equations) ";
	}

}
