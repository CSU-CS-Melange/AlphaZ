package org.polymodel.polyhedralIR.convolution;

import org.polymodel.polyhedralIR.StandardEquation;


public class MergeNode implements IConvolutionSystemNode {
	
	private StandardEquation equationName;

	public MergeNode(StandardEquation equationName) {
		this.equationName = equationName;
	}
	
	@Override
	public String getDotID() {
		return equationName.getVariable().getName();
	}
	
	@Override
	public String getDotLabel() {
		return "+";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if (obj instanceof MergeNode) {
			return ((MergeNode) obj).equationName.equals(equationName);
		}
		
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return 13 * equationName.hashCode();
	}
}
