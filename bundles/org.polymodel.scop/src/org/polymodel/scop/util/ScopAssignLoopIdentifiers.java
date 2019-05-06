package org.polymodel.scop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

public class ScopAssignLoopIdentifiers extends ScopDepthFirstVisitorImpl {

	protected int currentDepth;
	
	protected List<Integer> currentID;
	protected Map<ScopFor, int[]> identifiers;
	
	
	public static ScopLoopIdentifier assign(ScopRoot scop) {
		ScopAssignLoopIdentifiers sali = new ScopAssignLoopIdentifiers();
		scop.accept(sali);
		
		return new ScopLoopIdentifier(sali.identifiers);
	}
	
	protected ScopAssignLoopIdentifiers() {
		currentDepth = -1;
		currentID = new ArrayList<Integer>(20);
		identifiers = new HashMap<ScopFor, int[]>();
	}
	
	@Override
	public void inScopFor(ScopFor s) {
		currentDepth++;
		//if there are other loops in the same nesting, increment the id of this dimension by 1
		if (currentDepth < currentID.size()) {
			currentID.set(currentDepth, currentID.get(currentDepth)+1);
		//otherwise initialize to 0
		} else {
			currentID.add(0);
		}
		int[] array = new int[currentID.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = currentID.get(i);
		}
		identifiers.put(s, array);
	}
	
	@Override
	public void outScopFor(ScopFor s) {
		//remove the dimension one after this because now its going to be in a different loop nest
		if (currentID.size() > currentDepth+1) {
			currentID.remove(currentDepth+1);
		}
		currentDepth--;
	}

}
