package org.polymodel.polyhedralIR.analysis.validator;

public interface IValidatorMessage {
	
	public static enum TYPE {ERROR, WARNING};
	public static enum VERBOSITY {NONE, MIN, MAX};
	
	public TYPE getType();
	public String toString(VERBOSITY verbosity);
	
	
}