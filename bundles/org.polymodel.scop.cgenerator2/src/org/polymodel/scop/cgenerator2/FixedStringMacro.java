package org.polymodel.scop.cgenerator2;

import java.util.List;

import org.polymodel.algebra.IntExpression;

public class FixedStringMacro implements MacroBodyProvider {

	private final String body;
	
	public FixedStringMacro(String body) {
		this.body = body;
	}

	@Override
	public String getBody(List<IntExpression> macroParameters) {
		return body;
	}
}
