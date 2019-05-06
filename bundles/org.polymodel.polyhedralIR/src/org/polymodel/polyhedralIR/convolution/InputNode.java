package org.polymodel.polyhedralIR.convolution;

import org.polymodel.polyhedralIR.VariableDeclaration;

public class InputNode implements IConvolutionSystemNode {
	
	protected VariableDeclaration variable;
	
	public InputNode(VariableDeclaration variable) {
		this.variable = variable;
	}

	public VariableDeclaration getVariable() {
		return variable;
	}
	
	@Override
	public String getDotID() {
		return variable.getName();
	}
	
	@Override
	public String getDotLabel() {
		return getDotID();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			   return false;
		
		if (obj instanceof InputNode) {
			return variable.getName().contentEquals(((InputNode) obj).getVariable().getName());
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return 3*variable.hashCode();
	}
	
}
