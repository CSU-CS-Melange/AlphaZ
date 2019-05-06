package org.polymodel.polyhedralIR.util;

import java.util.Comparator;

import org.polymodel.polyhedralIR.AffineFunction;

public class DependenceComparator implements Comparator<AffineFunction> {
	
	public static final DependenceComparator INSTANCE = new DependenceComparator();

	@Override
	public int compare(AffineFunction o1, AffineFunction o2) {
		if (o1.equivalence(o2)) {
			return 0;
		}
		return PolyhedralIRToAlphabets.toString(o1).compareTo(PolyhedralIRToAlphabets.toString(o2));
	}
	
}