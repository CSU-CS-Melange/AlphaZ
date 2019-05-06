package org.polymodel.parser;

import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.EList;
import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.parser.internal.IntExpressionANTLRParser;

import fr.irisa.cairn.tools.ecore.EcoreUpdater;

public class PolymodelParser {
//	private DimensionsManager dimensionsManager;
//
//	public PolymodelDefaultParser(DimensionsManager dimensionsManager) {
//		super();
//		this.dimensionsManager = dimensionsManager;
//	}

	/**
	 * Parse a domain using given indices and parameters.
	 * 
	 * @param input
	 * @param indices
	 * @param parameters
	 * @return
	 */
	public Domain parseDomain(String input, List<Variable> indices,
			List<Variable> parameters) {
		try {
			Domain parseDomain = org.polymodel.parser.internal.PolymodelParser
					.parseDomain(input);
			normalize(parseDomain,indices, parseDomain.getDimensions().getIndices());
			normalize(parseDomain,parameters, parseDomain.getDimensions().getParameters());
			return parseDomain;
		} catch (RecognitionException e) {
			throw new RuntimeException(e);
		}
	}

	public IntExpression parseExpression(String input, List<Variable> variables) {
		return parseExpression(input,
				variables.toArray(new Variable[variables.size()]));
	}
	

	public IntExpression parseExpression(String input, Variable... variables) {
		try {
			IntExpression parseExpression = IntExpressionANTLRParser
					.parseIntExpression(input, variables);
			return parseExpression;
		} catch (RecognitionException e) {
			throw new RuntimeException(e);
		}
	}
	
	public IntConstraint parseConstraint(String input, Variable... variables){
		try {
			IntConstraint parsed = IntExpressionANTLRParser
					.parseIntConstraint(input, variables);
			return parsed;
		} catch (RecognitionException e) {
			throw new RuntimeException(e);
		}
	}
	
	public IntConstraint parseConstraint(String input, List<Variable> variables){
		return parseConstraint(input,
				variables.toArray(new Variable[variables.size()]));
	}

	private void normalize(Domain d,List<Variable> references, EList<Variable> variables) {
		for (int i = 0; i < variables.size(); ++i) {
			Variable dvar = variables.get(i);
			Variable nvar = normalize(dvar, references);
			EcoreUpdater.updateCrossReferencesInHierarchy(d,dvar, nvar);
		}
	}

	private Variable normalize(Variable v, List<Variable> refs) {
		for (Variable r : refs) {
			if (r.getName().equals(v.getName()))
				return r;
		}
		throw new IllegalArgumentException(
				"Unable to find the variable for " + v);
	}

}
