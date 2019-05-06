package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;

public class VariableNotDefinedWarning implements IValidatorMessage {

	protected final TYPE type;
	protected final VariableDeclaration var;
	protected final Domain param_domain; 
	
	public VariableNotDefinedWarning(TYPE type, VariableDeclaration var, Domain param_domain) {
		this.type = type;
		this.var = var;
		this.param_domain = param_domain;
	}
	public TYPE getType() {	
		return type;
	}

	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + " Variable " + var.getName() +" is not defined over the domain : " + param_domain;			
	}

}
