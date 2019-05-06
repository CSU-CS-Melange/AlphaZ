package org.polymodel.polyhedralIR.analysis.verifier;

import org.polymodel.prdg.PRDGEdge;


public class CausalityConditionError extends VerifierEdgeError {
	protected final int voilatingDimension;

	public CausalityConditionError(TYPE type, PRDGEdge edge, int violatingDimension) {
		super(type, edge);
		this.voilatingDimension = violatingDimension;
	}

	public CausalityConditionError(TYPE type, PRDGEdge edge) {
		super(type, edge);
		this.voilatingDimension = -1;
	}

	public String toString(VERBOSITY verbosity) {
		StringBuffer output = new StringBuffer();
		
		output.append(edge.getSource().getName() + " -> " + edge.getDestination().getName() + " , "  + edge.getFunction().getMapping());
		
		if(verbosity == VERBOSITY.MAX) {
			edge.getDomain().simplify();
			output.append(edge.getDomain());	
		}
		output.append(" does not satisfy causality condition");
		if(voilatingDimension > -1)
			output.append(" in dimension "+ voilatingDimension);
		
		return output.toString();
	}

}
