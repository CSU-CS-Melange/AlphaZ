package org.polymodel.polyhedralIR.recurrence.bis;

import java.util.Comparator;

public class SemiringComparator implements Comparator<Semiring> {

	public static final SemiringComparator INSTANCE = new SemiringComparator();
	
	protected SemiringComparator() {}

	@Override
	public int compare(Semiring o1, Semiring o2) {
		return o1.toString().compareTo(o2.toString());
	}
}
