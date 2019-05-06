package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd;


import java.util.List;

import org.polymodel.polyhedralIR.VariableDeclaration;


public class VRegNameConstruction{
	public VRegNameConstruction(){}
	
	public static String getVRegNamePrefix(VariableDeclaration var, String stmtGroup){
		return SIMDCodeGenConstant.SIMDRegNamePrefix + stmtGroup + var.getName();
	}
	
	public String getVRegName(String name_prefix, List<Integer> dep, List<Integer> offset){
		String regName = name_prefix;
		for(int i = 0; i < dep.size() ;i++){
			regName += "_"+ (-dep.get(i) + offset.get(i));
		}
		return regName;
	}
	
	public String getVRegName(VariableDeclaration var, String stmtGroup, List<Integer> dep, List<Integer> offset){
		return getVRegName(getVRegNamePrefix(var, stmtGroup), dep, offset);
	}
	
	/**
	 * This function has to be override for different register name construction strategy
	 * @param var
	 * @param stmtGroup
	 * @param dep
	 * @param offset
	 * @return
	 */
	public String getVRegisterName(VariableDeclaration var, String stmtGroup, List<Integer> dep, List<Integer> offset){
		return getVRegName(var, stmtGroup, dep, offset);
	}
}
