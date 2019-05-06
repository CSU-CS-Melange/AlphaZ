package org.polymodel.algebra.util;

import java.util.HashSet;
import java.util.Set;

import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.impl.AlgebraVisitorImpl;

/**
 * Collects variables used in an algebra expression.
 * 
 * @author yuki
 *
 */
public class VariableCollector extends AlgebraVisitorImpl {

	private Set<Variable> variables;
	
	public static Set<Variable> collect(AlgebraVisitable a) {
		VariableCollector vc = new VariableCollector();
		a.accept(vc);
		return vc.variables;
	}
	
	protected VariableCollector() {
		variables = new HashSet<Variable>();
	}
	
	@Override
	public void visitVariable(Variable v) {
		variables.add(v);
	}
}
