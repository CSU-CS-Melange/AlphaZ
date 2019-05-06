package org.polymodel.polyhedralIR.analysis.verifier;

import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.prdg.PRDGEdge;

public class MemoryMapError extends VerifierEdgeError {

	MemoryMap _mem_map;
	public MemoryMapError(TYPE type, PRDGEdge edge, MemoryMap mem_map) {
		super(type, edge);
		_mem_map = mem_map;
	}

	public String toString(VERBOSITY verbosity) {
		StringBuffer output = new StringBuffer();
		
		output.append(_mem_map + " results in over-write conflict for ");
		output.append(edge.getSource().getName() + " -> " + edge.getDestination().getName() + " , "  + edge.getFunction().getMapping());
		
		return output.toString();
	}

}
