package org.polymodel.algebra.prettyprinter.algebra;

import org.polymodel.algebra.Variable;

public class DefaultVariableResolver implements IVariableResolver {

	public String resolve(Variable variable) {
		return variable.getName();
	}

}
