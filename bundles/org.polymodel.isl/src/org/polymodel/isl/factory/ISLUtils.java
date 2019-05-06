package org.polymodel.isl.factory;

import org.polymodel.DimensionsManager;
import org.polymodel.isl.ISLFunction;
import org.polymodel.isl.ISLSet;

public class ISLUtils {

	public static ISLFunction createIdentityFunction(ISLSet set, DimensionsManager dim){
		
		
		return null;
		
		
	}

//	//do not work ...
//	public static ISLFunction next(ISLSet set, int depth) {
//		JNIISLSet dom = ISLNativeBinder.jniIslSet(set);
//		JNIISLMap lexNext = ISLLexShiftTools.lexNext(dom, depth);
//		return buildLexShiftFunction(set, lexNext);
//	}
//
//	//do not work ...
//	private static ISLFunction buildLexShiftFunction(ISLSet set,JNIISLMap lexShift) {
//		EList<Variable> indices = set.getDimensions().getIndices();
//		List<InputDimension> inputs = new ArrayList<InputDimension>();
//		List<OutputDimension> outputs = new ArrayList<OutputDimension>();
//
//		for (Variable variable : indices) {
//			OutputDimension odim = set.getDimensionsManager().getOutputDimension(variable);
//			outputs.add(odim);
//			InputDimension idim = set.getDimensionsManager().getInputDimension(variable);
//			inputs.add(idim);
//		}
//		
//		ISLMap res = ISLNativeBinder.islMap(lexShift, inputs,outputs, set.getDimensions().getParameters());
//		ISLFunction buildFunction = res.buildFunction();
//		return buildFunction;
//	}

	public static ISLFunction pred(ISLSet set) {
		return null;
	}

}
