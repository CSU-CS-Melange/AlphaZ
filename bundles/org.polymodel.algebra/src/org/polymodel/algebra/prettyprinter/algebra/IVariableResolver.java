package org.polymodel.algebra.prettyprinter.algebra;

import org.polymodel.algebra.Variable;

/**
 * Used to resolve the name of a variable.
 * This class can be used to customize how variables are printed.
 * For example, you may want to use a common naming scheme (like i0, i1, i2)
 * ignoring the names given to the variable object at times.
 * 
 * @author yuki
 *
 */
public interface IVariableResolver {

	public String resolve(Variable variable);
}
