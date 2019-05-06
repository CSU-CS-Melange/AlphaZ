package org.polymodel.parser.internal;

import java.util.HashMap;

import org.polymodel.algebra.Variable;
import org.polymodel.algebra.impl.VariableImpl;

public class VariableScopeManager {
	private boolean verbose = false;
	private static VariableScopeManager singleton;

	public static VariableScopeManager getInstance() {

		if (singleton == null) {
			singleton = new VariableScopeManager();
		}
		return singleton;

	}

	/** Map variable name to Integer object holding value */
	HashMap<String, Variable> symTable;

	private VariableScopeManager() {
		symTable = new HashMap<String, Variable>();
	}

	public class NamedVariable extends VariableImpl {
		String id;

		public NamedVariable(String id) {
			this.id = id;
			this.name = id;
		}

		@Override
		public String toString() {
			return id;
		}
	}

	private boolean createIfNotdefined = false;

	public Variable getVariable(String txt) {
		if (symTable.get(txt) != null) {
			return symTable.get(txt);
		} else {
			if (createIfNotdefined) {
				NamedVariable v = new NamedVariable(txt);
				symTable.put(txt, v);
				return v;
			} else {
				throw new RuntimeException("Unknown symbol " + txt);
			}
		}
	}

	public void clear() {
		symTable.clear();
	}

	public Variable addVariable(String txt) {
		NamedVariable v = new NamedVariable(txt);
		symTable.put(txt, v);
		if (verbose)
			System.out.println("Adding variable " + v + " to " + symTable);
		return v;
	}

}
