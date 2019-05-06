package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;

public class VariableNotDefinedError implements IValidatorMessage {
	protected final TYPE type;
	protected final VariableDeclaration var;
	protected final Domain domain; 
	
	public VariableNotDefinedError(TYPE type, VariableDeclaration var, Domain domain) {
		this.type = type;
		this.var = var;
		this.domain = domain;
	}
	public TYPE getType() {	
		return type;
	}

	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + " Variable " + var.getName() +" is not defined over the domain : " + domain;			
	}

}
