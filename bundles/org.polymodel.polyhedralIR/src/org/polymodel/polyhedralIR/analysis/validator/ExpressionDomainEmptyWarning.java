package org.polymodel.polyhedralIR.analysis.validator;

public class ExpressionDomainEmptyWarning implements IValidatorMessage {

	protected final TYPE type;
	protected String expression;
	
	public ExpressionDomainEmptyWarning(TYPE type, String expression) {
		this.type = type;
		this.expression = expression;
	}
	public TYPE getType() {
		return type;
	}

	public String toString(VERBOSITY verbosity) {
		return type + ":: " + " This expression has empty domain : " + expression;
	}

}
