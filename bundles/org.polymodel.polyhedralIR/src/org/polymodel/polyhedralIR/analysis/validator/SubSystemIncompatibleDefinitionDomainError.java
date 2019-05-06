package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.Domain;

public class SubSystemIncompatibleDefinitionDomainError implements IValidatorMessage {
	protected final TYPE type;
	protected final String varSs;
	protected final String varGlob;
	protected final String varOutput;
	protected final Domain diff;
	
	public SubSystemIncompatibleDefinitionDomainError(TYPE type, String vglob, String vss, String vout, Domain diff) {
		this.type = type;
		this.varSs = vss;
		this.varGlob = vglob;
		this.varOutput = vout;
		this.diff = diff;
	}
	
	public TYPE getType() {	
		return type;
	}
	
	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + varGlob +" in the use equation whose first output is " + varOutput + ", corresponding to " + varSs +
				" in the subsystem is not defined over " + diff.toString();			
	}
	
}
