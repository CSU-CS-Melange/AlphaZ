package org.polymodel.polyhedralIR.analysis.verifier;

import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.prdg.PRDGNode;

public class WriteConflictsError extends VerifierNodeError {
	MemoryMap _mem_map;
	
	public WriteConflictsError(TYPE type, PRDGNode node, MemoryMap mem_map) {
		super(type, node);
		_mem_map = mem_map;
	}

	public String toString(VERBOSITY verbosity) {
		StringBuffer output = new StringBuffer();
		
		output.append(_mem_map + " results in write conflicts");
		
		return output.toString();
	}


}
