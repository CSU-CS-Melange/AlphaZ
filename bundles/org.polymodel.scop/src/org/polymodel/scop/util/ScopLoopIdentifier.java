package org.polymodel.scop.util;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.polymodel.scop.ScopFor;

/**
 * Data structure for storing loop identifier and its associated utility methods.
 * 
 * @author yuki
 *
 */
public class ScopLoopIdentifier implements Comparator<ScopFor> {
	
	protected final Map<ScopFor, int[]> identifiers;
	
	public ScopLoopIdentifier(Map<ScopFor, int[]> identifiers) {
		this.identifiers = identifiers;
	}
	
	public Set<ScopFor> keySet() {
		return identifiers.keySet();
	}
	
	public int[] get(ScopFor loop) {
		return identifiers.get(loop);
	}
	
	public int lastCommonDimension(ScopFor loopA, ScopFor loopB) {
		int[] idA = identifiers.get(loopA);
		int[] idB = identifiers.get(loopB);
		
		if (idA == null || idB == null) {
			throw new RuntimeException("Unexpected error");
		}
		
		for (int i = 0; i < Math.min(idA.length, idB.length); i++) {
			if (idA[i] != idB[i]) return i-1;
		}
		
		return Math.min(idA.length, idB.length)-1;
	}
	
	public String toStringID( ScopFor loop) {
		int[] loopID = identifiers.get(loop);
		return toStringIDupToDepth(loop, loopID.length);
	}
	
	public String toStringIDupToDepth(ScopFor loop, int depth) {
		int[] loopID = identifiers.get(loop);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			if (sb.length() > 0) sb.append(",");
			
			sb.append(loopID[i]);
		}
		
		return sb.toString();
	}

	public int compare(ScopFor o1, ScopFor o2) {
		int[] loopIDA = identifiers.get(o1);
		int[] loopIDB = identifiers.get(o2);
		
		for (int i = 0; i < Math.min(loopIDA.length, loopIDB.length); i++) {
			if (loopIDA[i] > loopIDB[i]) {
				return 1;
			} else if (loopIDA[i] < loopIDB[i]) {
				return -1;
			}
		}
		
		return loopIDA.length - loopIDB.length;
	}
}
