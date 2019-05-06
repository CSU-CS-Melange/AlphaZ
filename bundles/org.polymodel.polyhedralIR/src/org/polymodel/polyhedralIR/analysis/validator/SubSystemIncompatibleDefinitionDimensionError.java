package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.UseEquation;

public class SubSystemIncompatibleDefinitionDimensionError implements IValidatorMessage {
	protected final TYPE type;
	protected final UseEquation ueq;
	protected final String outName;
	protected final int dGlob;
	protected final int dSs;
	
	
	public SubSystemIncompatibleDefinitionDimensionError(TYPE type, UseEquation u, String strOut, int dimGlob, int dimEdSs) {
		this.type = type;
		this.ueq = u;
		this.outName = strOut;
		this.dGlob = dimGlob;
		this.dSs = dimEdSs;
	}
	
	public TYPE getType() {	
		return type;
	}
	
	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + " inside the use equation calling \"" + ueq.getSubSystem().getName() + "\" for the output \"" + outName +
				"\", the dimensions mismatch (" + dGlob + " for " + dSs + " expected)";			
	}
	
} // SubSystemIncompatibleDefinitionDimensionError
