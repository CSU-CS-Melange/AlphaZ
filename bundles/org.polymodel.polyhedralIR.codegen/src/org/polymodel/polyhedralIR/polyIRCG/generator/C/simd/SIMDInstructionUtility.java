package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd;

import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP;

/**
 * Enumeration the SIMD instruction supported in the framework
 * Our framework currently support the load, store, shift, mul, add, sub instructions 
 * SIMD instruction sets : SSE, SSE2, AVX, AVX2
 * The data types supported are int, float and double
 * 
 * @author zouyun
 *
 */
public class SIMDInstructionUtility {
	//TODO: has to be extended to support more instructions
	
	//register type
	public static String int128 = "__m128i";
	public static String int256 = "__m256i";
	public static String float128 = "__m128";
	public static String float256 = "__m256";
	public static String double128 = "__m128d";
	public static String double256 = "__m256d";
	
	//instruction prefix/postfix 
	public static String sse128prefix = "_mm";
	public static String avx256prefix = "_mm256";
	
	public static String int128MemPostfix = "_si128";
	public static String int256MemPostfix = "_si256";
	public static String int32Postfix = "_epi32";
	
	public static String floatPostfix = "_ps";
	public static String doublePostfix = "_pd";
	
	
	public static String getPrefix(VType type){
		String prefix = "";
		
		if(type.getIns() == SIMD_INS.SSE) {
			if(type.getWidth() == SIMD_WIDTH.M128){
				prefix=sse128prefix;
			}
		}else if(type.getIns() == SIMD_INS.AVX){
			if(type.getWidth() == SIMD_WIDTH.M256){
				prefix=avx256prefix;
			}
		}
		
		return prefix;
	}
	
	public static String getPostfix(VType type, boolean isMem){
		String postfix = "";
		
		String datatype = type.getType().getCName();
		if(datatype == "int"){
			if(isMem){	//postfix for load/store instruction
				if(type.getWidth() == SIMD_WIDTH.M128){
					postfix = int128MemPostfix;
				}else if(type.getWidth() == SIMD_WIDTH.M256){
					postfix = int256MemPostfix;
				}
			}else{
				postfix = int32Postfix;
			}
		}else if(datatype == "float"){
			postfix = floatPostfix;
		}else if(datatype == "double"){
			postfix = doublePostfix;
		}

		return postfix;
	}

	public static String getLoadInstruction(VType type, boolean aligned){
		String ins = getPrefix(type);
		
		//check use alingned or unalinged instruction
		if(aligned){
			ins += "_load";
		}else{
			ins += "_loadu";
		}
		
		//get the correct postfix
		ins += getPostfix(type, true);
		
		return ins;
	}
	
	public static String getStoreInstruction(VType type, boolean aligned){
		String ins = getPrefix(type);
				
		//check use alingned or unalinged instruction
		if(aligned){
			ins += "_store";
		}else{
			ins += "_storeu";
		}
		
		//get the correct postfix
		ins += getPostfix(type, true);
		
		return ins;
	}
	
	public static String getSetInstruction(VType type, boolean single){
		String ins = getPrefix(type);
		if(single)
			ins += "_set1";
		else 
			ins += "_set";
		ins += getPostfix(type, false);
		
		return ins;
	}
	
	public static String getArchimethicInstruction(VType type, VOP op){
		String ins = getPrefix(type);
		
		String op_str = "";
		switch(op.getValue()){
		case VOP.ADD_VALUE:
			op_str = "_add";
			break;
		case VOP.MUL_VALUE:
			op_str = "_mul";
			break;
		case VOP.SUB_VALUE:
			op_str = "_sub";
			break;
		default:
			break;
		}
		
		ins += op_str;
		ins += getPostfix(type, false);
		return ins;
	}
	
	public static String getAVXPermuteInstruction(VType type){
		String ins = getPrefix(type);
		ins += "_permute2f128";
		ins += getPostfix(type, true);
		
		return ins;
		
	}
	
	public static String getAVXShuffleInstruction(VType type){
		String ins = getPrefix(type);
		ins += "_shuffle";
		ins += getPostfix(type, true);
		return ins;
	}
	
	/**
	 * Get the number of elements in a cache line
	 * With data type specified in vType
	 * @param type
	 * @return
	 */
	public static int getCacheLineSize(VType type){
		String dataType = type.getType().getCName();
		int element_size = 4;
		if(dataType == "double")	element_size = 8;
		
		return SIMDCodeGenConstant.CacheLineSize/element_size;
	}
}