package org.polymodel.polyhedralIR.codegen.xtend2;

import org.polymodel.PolymodelVisitable;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;

public class Utility {

	public static boolean isScalar(AbstractVariable v) {
		if (v instanceof BasicVariable) return true;
		
		if (v instanceof CodeGenVariable) {
			return ((CodeGenVariable)v).getDomain().getNIndices() == 0;
		}
		
		throw new UnsupportedOperationException("Unhandled subclass of AbstractVariable");
	}
	
	public static boolean isInput(AbstractVariable v, Function f) {
		return f.getInputs().contains(v);
	}
	public static boolean isLocal(AbstractVariable v, Function f) {
		return f.getLocals().contains(v);
	}
	public static boolean isOutput(AbstractVariable v, Function f) {
		return f.getOutputs().contains(v);
	}

	
	public static String pointerType(CodeGenVariable v) {
		if (v instanceof CVariable) {
			return ((CVariable)v).getPointerType();
		} else {
			throw new RuntimeException("Non-CVariable used in C code generation.");
		}
	}
	public static String toCString(IntExpression ie) {
		return ie.simplify().toString(OUTPUT_FORMAT.C);
	}
	public static String toCString(AlgebraVisitable a) {
		return a.toString(OUTPUT_FORMAT.C);
	}
	public static String toCString(PolymodelVisitable a) {
		return a.toString(OUTPUT_FORMAT.C);
	}
	

	//returns true if the variable involves mallocs for MD array, which first allocates linearlized array
	public static boolean isMDallocation(CodeGenVariable v) {
		return !v.isFlattened() && v.getDomain().getNIndices() > 1;
	}
}
