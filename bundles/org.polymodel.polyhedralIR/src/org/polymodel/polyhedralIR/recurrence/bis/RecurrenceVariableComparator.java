package org.polymodel.polyhedralIR.recurrence.bis;

import java.util.Comparator;

public class RecurrenceVariableComparator implements Comparator<RecurrenceVariable> {
	
	public static final RecurrenceVariableComparator INSTANCE = new RecurrenceVariableComparator();
	
	protected RecurrenceVariableComparator() {}

	@Override
	public int compare(RecurrenceVariable o1,
			RecurrenceVariable o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
