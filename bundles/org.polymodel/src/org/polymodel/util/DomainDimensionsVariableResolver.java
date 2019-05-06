package org.polymodel.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.DomainDimensions;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.IVariableResolver;

public class DomainDimensionsVariableResolver implements IVariableResolver {
	
	protected Map<Variable, String> mapping = new HashMap<Variable, String>();
	
	public DomainDimensionsVariableResolver(DomainDimensions currentDims, List<String> indices) {
		assert(currentDims.getIndices().size() == indices.size());
		
		for (int i = 0; i < currentDims.getParameters().size(); i++) {
			mapping.put(currentDims.getParameters().get(i), currentDims.getParameters().get(i).getName());
		}
		
		for (int i = 0; i < currentDims.getIndices().size(); i++) {
			mapping.put(currentDims.getIndices().get(i), indices.get(i));
		}
	}
	
	
	public DomainDimensionsVariableResolver(DomainDimensions currentDims, DomainDimensions printedDims) {
		assert(currentDims.getIndices().size() == printedDims.getIndices().size());
		assert(currentDims.getParameters().size() == printedDims.getParameters().size());
		
		for (int i = 0; i < currentDims.getParameters().size(); i++) {
			mapping.put(currentDims.getParameters().get(i), printedDims.getParameters().get(i).getName());
		}
		
		for (int i = 0; i < currentDims.getIndices().size(); i++) {
			mapping.put(currentDims.getIndices().get(i), printedDims.getIndices().get(i).getName());
		}
	}

	@Override
	public String resolve(Variable variable) {
		return mapping.get(variable);
	}

}
