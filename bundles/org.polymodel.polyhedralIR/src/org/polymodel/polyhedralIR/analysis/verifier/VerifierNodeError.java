package org.polymodel.polyhedralIR.analysis.verifier;

import org.polymodel.prdg.PRDGNode;

public abstract class VerifierNodeError implements IVerifierMessage {
	protected final TYPE type;
	protected PRDGNode node;

	public VerifierNodeError(TYPE type, PRDGNode node) {
		this.type = type;
		this.node = node;
	}
	
	@Override
	public TYPE getType() {
		return type;
	}
}
