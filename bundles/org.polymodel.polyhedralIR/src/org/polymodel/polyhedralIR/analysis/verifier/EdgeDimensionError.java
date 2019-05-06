package org.polymodel.polyhedralIR.analysis.verifier;

import org.polymodel.prdg.PRDGEdge;

public class EdgeDimensionError extends VerifierEdgeError {
	protected final int violatingDimension;
	
	public EdgeDimensionError(TYPE type, PRDGEdge edge, int violatingDimension) {
		super(type, edge);
		this.violatingDimension = violatingDimension;
	}

	public String toString(VERBOSITY verbosity) {
		StringBuffer output = new StringBuffer();
		
		output.append(edge.getSource().getName() + " -> " + edge.getDestination().getName());
		
		output.append(" voilates the condition that a dependence should have same dimension type when comparing " + violatingDimension);
		
		return output.toString();
	}

}
