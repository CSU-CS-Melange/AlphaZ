package org.polymodel.polyhedralIR.polyIRCG.generator;

public class ABFTCodeGenOptions extends CodeGenOptions {

	public String weightsVar;
	public String dataType;
	public String patchVar;
	public String patchSize;
	public String cT;
	public String cJx;
	public String kernel;
	public int numDims;
	
	
	public void set(String key, String value) {
		switch (key) {
			case "weightsVar":	weightsVar = value;
			case "dataType":	dataType = value;
			case "patchVar":	patchVar = value;
			case "patchSize":	patchSize = value;
			case "cT":			cT = value;
			case "cJx":			cJx = value;
			case "kernel":		kernel = value;
			case "numDims":		numDims = Integer.parseInt(value);
			
			default: // do nothing
		}
	}
}
