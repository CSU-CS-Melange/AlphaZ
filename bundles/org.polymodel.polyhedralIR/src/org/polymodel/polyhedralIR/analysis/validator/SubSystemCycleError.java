package org.polymodel.polyhedralIR.analysis.validator;

public class SubSystemCycleError implements IValidatorMessage {
	
	protected final TYPE type;
	protected final String str;
	
	public SubSystemCycleError(TYPE type, String cycle) {
		this.type = type;
		this.str = cycle;
	}
	
	public TYPE getType() {	
		return type;
	}
	
	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + " cycle in the sub-system calls : \"" + str +"\"";			
	}
	
} // SubSystemCycleError
