package org.polymodel.polyhedralIR.util;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.polymodel.PolymodelVisitor;
import org.polymodel.algebra.Variable;
import org.polymodel.impl.DimensionsManagerImpl;
import org.polymodel.polyhedralIR.util.PolyhedralIRVariable.TYPE;

public class PolyhedralIRDimensionManager extends DimensionsManagerImpl {

	protected Map<Integer, Map<String, Variable>> indices = new TreeMap<Integer, Map<String, Variable>>();
	protected Map<Integer, Map<String, Variable>> params  = new TreeMap<Integer, Map<String, Variable>>(); 

//	@Override
//	public EList<InputDimension> getInputsDimensions() {
//		throw new RuntimeException("Operation not allowed in PolyhedralIR");
//	}
//
//	@Override
//	public EList<OutputDimension> getOutputsDimensions() {
//		throw new RuntimeException("Operation not allowed in PolyhedralIR");
//	}


//	@Override
//	public InputDimension getInputDimension(Variable var) {
//		throw new RuntimeException("Operation not allowed in PolyhedralIR");
//	}
//
//	@Override
//	public OutputDimension getOutputDimension(Variable var) {
//		throw new RuntimeException("Operation not allowed in PolyhedralIR");
//	}

	@Override
	public Variable getParameter(int position) {
		String name = "p"+position;
		return getParameter(position, name);
	}

	@Override
	public Variable getParameter(int position, String name) {
		if (!params.containsKey(position)) {
			params.put(position, new TreeMap<String, Variable>());
		}
		Map<String, Variable> posParams = params.get(position);
		if (posParams.containsKey(name)) {
			return posParams.get(name);
		} else {
			PolyhedralIRVariable newVar = new PolyhedralIRVariable(TYPE.PARAM, position, name, this);
			getParameters().add(newVar);
			posParams.put(name, newVar);
			return newVar;
		}
	}
	
	@Override
	public Variable getDimension(int position) {
		String name = "i"+position;
		return getDimension(position, name);
	}

	@Override
	public Variable getDimension(int position, String name) {
		if (!indices.containsKey(position)) {
			indices.put(position, new TreeMap<String, Variable>());
		}
		Map<String, Variable> posIndices = indices.get(position);
		if (posIndices.containsKey(name)) {
			return posIndices.get(name);
		} else {
			PolyhedralIRVariable newVar = new PolyhedralIRVariable(TYPE.INDEX, position, name, this);
			getDimensions().add(newVar);
			posIndices.put(name, newVar);
			return newVar;
		}
	}

	@Override
	public void accept(PolymodelVisitor visitor) {
		throw new RuntimeException("Operation not allowed in PolyhedralIR");
	}

//	@Override
//	public List<OutputDimension> getOutputsDimensionsFor(List<? extends Variable> dims) {
//		throw new RuntimeException("Operation not allowed in PolyhedralIR");
//	}
//
//	@Override
//	public List<InputDimension> getInputsDimensionsFor(List<? extends Variable> dims) {
//		throw new RuntimeException("Operation not allowed in PolyhedralIR");
//	}

	@Override
	public List<Variable> getAllVariables() {
		throw new RuntimeException("Operation not allowed in PolyhedralIR");
	}

}
