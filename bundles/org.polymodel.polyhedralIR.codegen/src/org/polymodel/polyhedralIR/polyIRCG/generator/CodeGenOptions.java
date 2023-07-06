package org.polymodel.polyhedralIR.polyIRCG.generator;

public class CodeGenOptions {

	public boolean DEBUG = false;
	//Pre/Post fix for function signature of generated code
	public String funcPrefix = "";
	public String funcPostfix = "";
	//Flatten multi-dimensional variable to 1D
	public boolean flattenArrays = false;
	
	//For Hybrid schedules
	public boolean isHybridSchedule = false;
	public TARGET target = TARGET.CPU;
	public int dimToAddChecks;
	
	public static CodeGenOptions writeCDefault() {
		CodeGenOptions options = new CodeGenOptions();
		options.flattenArrays = false;
		return options;
	}
	
	public static CodeGenOptions scheduledCDefault() {
		CodeGenOptions options = new CodeGenOptions();
		options.flattenArrays = false;
		return options;
	}
	
	public static CodeGenOptions scheduledABFTCDefault() {
		ABFTCodeGenOptions options = new ABFTCodeGenOptions();
		return options;
	}
	
	public static CodeGenOptions scheduledCHybridGPUDefault(int dimToAddChecks) {
		CodeGenOptions options = new CodeGenOptions();
		options.flattenArrays = false;
		options.isHybridSchedule = true;
		options.target = TARGET.GPU;
		options.dimToAddChecks = dimToAddChecks;
		return options;
	}
	
	public static CodeGenOptions scheduledCHybridDefault(int dimToAddChecks) {
		CodeGenOptions options = new CodeGenOptions();
		options.flattenArrays = false;
		options.isHybridSchedule = true;
		options.target = TARGET.CPU;
		options.dimToAddChecks = dimToAddChecks;
		return options;
	}
	
	public CodeGenOptions copy() {
		CodeGenOptions newOp = new CodeGenOptions();
		newOp.DEBUG = this.DEBUG;
		newOp.flattenArrays = this.flattenArrays;
		newOp.funcPostfix = this.funcPostfix;
		newOp.funcPrefix = this.funcPrefix;
		newOp.isHybridSchedule= this.isHybridSchedule;
		newOp.target = this.target;
		
		return newOp;
	}
	
	public enum TARGET {
		CPU,
		GPU,
		X10
	}

}
