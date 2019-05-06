package org.polymodel.polyhedralIR.analysis.verifier;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.prdg.PRDGNode;

public class NonNegativityError extends VerifierNodeError {
	protected final AffineFunction affineFunction_;
	protected final int violatingDimension_;
	
	public NonNegativityError(TYPE type, org.polymodel.Domain violatingDomain,
			PRDGNode node, AffineFunction affineFunction, int violatingDimension) {
		super(type, node);
		this.affineFunction_ = affineFunction;
		this.violatingDimension_ = violatingDimension;
	}
	
	public String toString(VERBOSITY verbosity) {
		StringBuffer output = new StringBuffer();
		
				
		if((this.type == TYPE.TIME) || (this.type == TYPE.PROCESSOR)) {
			output.append("For ");
			output.append(node.getName());
			output.append(" ");
			output.append(affineFunction_.getPMmapping().getExpressions().get(violatingDimension_)); 
			output.append(" is not non-negative in the domain ");
			output.append(violatingDimension_);
		}
		
		return output.toString();
	}
}
