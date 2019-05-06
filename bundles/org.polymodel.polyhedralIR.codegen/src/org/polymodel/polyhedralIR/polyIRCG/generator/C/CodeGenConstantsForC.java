package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenConstants;



public class CodeGenConstantsForC extends CodeGenConstants {
	
	//external function
	public static final String EXTERNAL_FUNCTION_HEADER_NAME = "external_functions.h";

	//Malloc
	public static final String MALLOC_LOOP_INDEX = "mz";
	public static final String LINEARIZED_ARRAY_PREFIX = "_lin_";
	
	//prefix for variables to be assigned to global
	public static final String TEMP_LOCAL_PREFIX = "_local_";
	
	//For WriteC Flags
	public static final String FLAG_LOOP_INDEX = "fz";
	public static final String FLAG_PREFIX = "_flag_";
	//Prefix for function to evaluate RHS of expressions
	public static final String WRITEC_EVAL_PREFIX = "eval_";
	//Name for function to evaluate reduction 
	//reduction number corresponds to the i-th occurrence while visiting the IR
	public static final String getReductionFunctionName(StandardEquation eq, int reductionNumber) {
		return "reduce_"+eq.getContainerSystem().getName() + "_" + eq.getVariable().getName() +"_"+reductionNumber;
	}
	
	public static final String REDUCE_VAR_NAME = "reduceVar";
//	public static final String REDUCTION_PARAM_PREFIX = "p";
	
	//For Wrapper
	public static final String VERIFY_FLAG = "VERIFY";
	public static final String TIMING_FLAG = "TIMING";
	public static final String CHECKING_FLAG = "CHECKING";
	public static final String RANDOM_FLAG = "RANDOM";
	public static final String NO_PROMT_FLAG = "NO_PROMPT";
	//post fix for everything that is specific to verification
	public static final String VERIFY_POSTFIX = "_verify";
	
	//tile size prefix in wrapper
	public static final String WRAPPER_TILESIZE_PREFIX = "tilesize";
}
