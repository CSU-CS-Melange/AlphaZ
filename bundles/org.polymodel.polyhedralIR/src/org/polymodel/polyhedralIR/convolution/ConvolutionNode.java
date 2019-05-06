package org.polymodel.polyhedralIR.convolution;


public class ConvolutionNode implements IConvolutionSystemNode {

	private final Convolution convolution;
	
	public ConvolutionNode(Convolution conv) {
		this.convolution = conv;
	}

	public Convolution getConvolution() {
		return convolution;
	}
	
	@Override
	public String getDotID() {
		return convolution.getEquation().getVariable().getName() + "_conv_" + convolution.getDataVariable().getName();
	}
	
	@Override
	public String getDotLabel() {
		if (convolution.isIdentity()) {
			return "1";
		}
		return "conv(" + convolution.getDataVariable().getName() +")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if (obj instanceof ConvolutionNode)
			return convolution.equals(((ConvolutionNode) obj).convolution);
		
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return 7*convolution.hashCode();
	}
}
