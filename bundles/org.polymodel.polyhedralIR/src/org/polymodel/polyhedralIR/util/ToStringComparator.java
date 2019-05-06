package org.polymodel.polyhedralIR.util;

import java.util.Comparator;

public class ToStringComparator<T> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		return o1.toString().compareTo(o2.toString());
	}


}
