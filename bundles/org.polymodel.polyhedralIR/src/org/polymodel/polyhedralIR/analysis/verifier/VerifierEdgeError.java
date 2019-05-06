package org.polymodel.polyhedralIR.analysis.verifier;

import org.polymodel.prdg.PRDGEdge;

public abstract class VerifierEdgeError implements IVerifierMessage {
	protected final TYPE type;
	protected final PRDGEdge edge;

	
	public VerifierEdgeError(TYPE type, PRDGEdge edge) {
		this.type = type;
		this.edge = edge;

	}
	
	@Override
	public TYPE getType() {
		return type;
	}
	
	public PRDGEdge getEdge() {
		return edge;
	}
}
