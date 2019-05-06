package org.polymodel.prdg.scheduling.pouchet;

import org.polymodel.algebra.Variable;
import org.polymodel.algebra.impl.VariableImpl;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;

/**
 * An index variable for a single {@link SchedulePrototype}.
 * 
 * @author antoine
 * 
 */
public class PrototypeIndexVariable extends VariableImpl {
	private Variable index;
	private SchedulePrototype prototype;

	public PrototypeIndexVariable(Variable index, StatementSchedulePrototype prototype) {
		this.index = index;
		this.prototype = prototype;
		this.name = index.getName() + "_"
				+ prototype.getStatement().getName();
	}

	public Variable getIndex() {
		return index;
	}

	public SchedulePrototype getPrototype() {
		return prototype;
	}

}