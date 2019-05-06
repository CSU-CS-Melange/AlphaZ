package org.polymodel.polyhedralIR.util;

import java.util.Comparator;

import org.polymodel.polyhedralIR.VariableDeclaration;

public class VariableComparator implements Comparator<VariableDeclaration> {

	public static final VariableComparator INSTANCE = new VariableComparator();
	
	protected VariableComparator() {}

	@Override
	public int compare(VariableDeclaration o1, VariableDeclaration o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
