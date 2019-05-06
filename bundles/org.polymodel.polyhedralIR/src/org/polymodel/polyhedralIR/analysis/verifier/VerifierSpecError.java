package org.polymodel.polyhedralIR.analysis.verifier;

public abstract class VerifierSpecError implements IVerifierMessage {
	protected final TYPE type;
	
	public VerifierSpecError(TYPE type) {
		this.type = type;
	}
	
	@Override
	public TYPE getType() {
		return type;
	}
}
