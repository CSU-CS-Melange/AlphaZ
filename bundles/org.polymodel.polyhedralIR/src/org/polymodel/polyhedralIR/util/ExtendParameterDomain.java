package org.polymodel.polyhedralIR.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;

/**
 * Class with a transformation to extend the parameter domain of the full system.
 * 
 * @author yuki
 *
 */
public class ExtendParameterDomain extends PolyhedralIRDepthFirstVisitorImpl {

	protected final List<String> names;
	
	protected ExtendParameterDomain(List<String> names) {
		this.names = names;
	}
	
	public static List<Variable> addParameters(AffineSystem system, String...names) {
		return addParameters(system, Arrays.asList(names));
	}
	
	public static List<Variable> addParameters(AffineSystem system, List<String> names) {
		List<Variable> addedParams = new ArrayList<Variable>(names.size());
		//add to the parameter domain
		for (String name : names) {
			system.getParameters().addParameterDimension(name);
			addedParams.add(system.getParameters().getParams().get(system.getParameters().getNParams()-1));
		}
		ExtendParameterDomain extender = new ExtendParameterDomain(names);
		system.accept(extender);
		//re-compute domains
		ExpressionDomainCalculator.computeExpressionDomain(system);
		ContextDomainCalculator.computeContextDomain(system);
		
		return addedParams;
	}

	
	@Override
	public void inAffineFunction(AffineFunction a) {
		for (String name : names) {
			a.addParameterDimension(name);
		}
	}
	
	@Override
	public void inDomain(Domain d) {
		for (String name : names) {
			d.addParameterDimension(name);
		}
	}
}
