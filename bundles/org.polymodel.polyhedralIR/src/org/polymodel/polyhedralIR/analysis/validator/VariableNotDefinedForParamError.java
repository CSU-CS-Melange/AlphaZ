package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;

public class VariableNotDefinedForParamError implements IValidatorMessage {
	protected final TYPE type;
	protected final Domain param_domain;
	protected final VariableDeclaration var;
	protected final Domain domain; 
	
	public VariableNotDefinedForParamError(TYPE type, Domain param_domain, VariableDeclaration var, Domain domain) {
		this.type = type;
		this.param_domain = param_domain;
		this.var = var;
		this.domain = domain;
	}
	public TYPE getType() {	
		return type;
	}

	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + " For Parameters " + param_domain + " Variable " + var.getName() 
		+  " is not defined over the domain : " + domain;
	}

}
