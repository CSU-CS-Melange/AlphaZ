package org.polymodel.scop.cgenerator2;

import java.util.List;

import org.polymodel.algebra.IntExpression;

public interface MacroBodyProvider {

	public String getBody(List<IntExpression> macroParameters);
}
