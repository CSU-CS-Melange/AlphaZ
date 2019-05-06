package org.polymodel.polyhedralIR.analysis.verifier;


public interface IVerifierMessage {
	
	public static enum TYPE {TIME, MEMORY, PROCESSOR, ORDERING, SPEC, REDUCE, TILING};
	public static enum VERBOSITY {NONE, MIN, MAX};
	
	public TYPE getType();
	public String toString(VERBOSITY verbosity);
	
}
