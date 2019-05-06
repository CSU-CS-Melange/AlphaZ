package org.polymodel.polyhedralIR.util;

import java.util.Comparator;

import org.polymodel.polyhedralIR.Domain;

public class DomainComparator implements Comparator<Domain> {
	
	public static final DomainComparator INSTANCE = new DomainComparator();

	@Override
	public int compare(Domain o1, Domain o2) {
		if (o1.equivalence(o2)) {
			return 0;
		}
		return PolyhedralIRToAlphabets.toString(o1).compareTo(PolyhedralIRToAlphabets.toString(o2));
	}
	
}