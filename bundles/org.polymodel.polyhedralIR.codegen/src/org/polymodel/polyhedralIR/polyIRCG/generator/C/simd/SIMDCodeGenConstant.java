package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd;

public class SIMDCodeGenConstant{
	public static String SIMDStmtNamePrefix = "SV";
	public static String SIMDRegNamePrefix = "v";
	public static int CacheLineSize = 64;
	
	public static String getStmtName(int stmtCount){
		String stmtName = SIMDStmtNamePrefix + stmtCount;
		return stmtName;
	}
	
	public static String getRegName(int regCount) {
		String regName = SIMDRegNamePrefix + regCount;;
		return regName;
	}
	
	public static String getStmtName(String prefix, int stmtCount){
		String stmtName = prefix + stmtCount;
		return stmtName;
	}
	
	public static String getRegName(String prefix, int regCount){
		String regName = prefix + regCount;
		return regName;
	}
}