package org.polymodel.polyhedralIR.analysis.validator;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.UseEquation;

public class SubSystemIncompatibleParameterDomainError implements IValidatorMessage {
	protected final TYPE type;
	protected final UseEquation ueq;
	protected final Domain diff;
	
	public SubSystemIncompatibleParameterDomainError(TYPE type, UseEquation u, Domain diff) {
		this.type = type;
		this.ueq = u;
		this.diff = diff;
	}
	
	public TYPE getType() {	
		return type;
	}
	
	public String toString(VERBOSITY verbosity) {
		return  type + ":: " + " the use equation using the subsystem \"" + ueq.getSubSystem().getName() + 
				"\", defines as parameters " + ueq.getParameters().toString() + ",\n \t but is incompatible inside the polyhedron:" + diff.toString() +
				"\n \t (however, this might be due to a rationnal approximation done during the test)";			
	}
	
}
