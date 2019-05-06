package org.polymodel.polyhedralIR.analysis.verifier;


public class UnNormalizedAffineSystem implements IVerifierMessage {

	String affineSystem_;
	public UnNormalizedAffineSystem(String affineSystem) {
		affineSystem_ = affineSystem;
	}

	public TYPE getType() {
		return TYPE.REDUCE;
	}
	public String toString(VERBOSITY verbosity) {
		StringBuffer output = new StringBuffer();
		
		output.append("The System '" + affineSystem_ + "' has reductions which have not been normalized. ");
		output.append("Do 'NormalizeReductions' on the system and then specify Target Mapping.");
		
		return output.toString();
	}
	
}
