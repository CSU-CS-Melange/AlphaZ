package org.polymodel.polyhedralIR.util;

import java.util.List;

import org.polymodel.Domain;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.DefaultVariableResolver;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.util.PolyhedralIRVariable.TYPE;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

public class PolyModelToAlphabets {
	
	public final static String print(final Domain domain, final OUTPUT_FORMAT format, List<String> paramNames, List<String> indexNames) {
				
		RenamedVariableResolver resolver = new RenamedVariableResolver(paramNames, indexNames);
		String str = PolymodelPrettyPrinter.print(domain, format, resolver);
		
		return str;
	}
	

	public final static String print(final AlgebraVisitable expr, final OUTPUT_FORMAT format, List<String> paramNames, List<String> indexNames) {

		RenamedVariableResolver resolver = new RenamedVariableResolver(paramNames, indexNames);
		String str = AlgebraPrettyPrinter.print(expr, format, resolver);
		
		return str;
	}
	
	private static class RenamedVariableResolver extends DefaultVariableResolver {

		private final List<String> parameters;
		private final List<String> indices;

		private RenamedVariableResolver(List<String> parameters, List<String> indices) {
			this.parameters = parameters;
			this.indices = indices;
		}

		@Override
		public String resolve(Variable variable) {
			if (variable instanceof PolyhedralIRVariable) {
				PolyhedralIRVariable polyV = (PolyhedralIRVariable)variable;
				//params
				if (polyV.type == TYPE.PARAM) {
					if (polyV.getDimension() < parameters.size()) {
						return parameters.get(polyV.getDimension());
					} else {
						return "p"+polyV.getDimension();
					}
				//indices
				} else {
					if (polyV.getDimension() < indices.size()) {
						return indices.get(polyV.getDimension());
					} else {
						return "i"+polyV.getDimension();
					}
				}
				
			} else {
				return super.resolve(variable);
			}
		}
		
	}
}
