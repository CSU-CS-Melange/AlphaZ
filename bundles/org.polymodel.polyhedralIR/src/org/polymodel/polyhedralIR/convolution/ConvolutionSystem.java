package org.polymodel.polyhedralIR.convolution;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.util.VariableComparator;

/**
 * System of convolutions is a collection of convolutions combined by
 * composition and addition (merge). This class represents such system
 * as a graph of convolutions. 
 * 
 * Primary nodes are those that correspond to the final computation of
 * the given variable. When the equation is a single convolution, this
 * convolution becomes the primary node. Otherwise, it is the merge
 * node that combines the sub-convolutions found in an equation. 
 * 
 * 
 * - The direction of arrow is dataflow.
 * - ConvolutionSystemDetection ignores many boundary conditions, and
 * the constructed system is not semantically equivalent. 
 * 
 * @author tyuki
 *
 */
public class ConvolutionSystem extends DefaultDirectedGraph<IConvolutionSystemNode, ConvolutionSystemEdge> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5221677574356281256L;
	
	protected Set<InputNode> inputNodes;
	protected Map<VariableDeclaration, IConvolutionSystemNode> equationToNode;

	public ConvolutionSystem() {
		super(ConvolutionSystemEdge.class);
		
		inputNodes = new TreeSet<>( new Comparator<InputNode>() {
			@Override
			public int compare(InputNode o1, InputNode o2) {
				return o1.getVariable().getName().compareTo(o2.getVariable().getName());
			}});
		
		equationToNode = new TreeMap<>(VariableComparator.INSTANCE);
	}
	
	@Override
	public boolean addVertex(IConvolutionSystemNode arg0) {
		if (arg0 instanceof InputNode) {
			inputNodes.add((InputNode)arg0);
		}
		
		return super.addVertex(arg0);
	}
	
	public void setPrimaryNode(VariableDeclaration var, IConvolutionSystemNode node) {
		assert(this.containsVertex(node));
		equationToNode.put(var, node);
	}
	
	public IConvolutionSystemNode getPrimaryNode(VariableDeclaration var) {
		return equationToNode.get(var);
	}
	

	public Set<VariableDeclaration> getPrimaryNodeSet() {
		return equationToNode.keySet();
	}

	public String toDotStringDetailed() {
		return toDotString(true);
	}

	public String toDotString() {
		return toDotString(false);
//		StringBuffer sb = new StringBuffer();
//	
//		sb.append("digraph {\n");
//		
//		for (IConvolutionSystemNode node : vertexSet()) {
//			sb.append("\t");
//			sb.append(node.getDotID() + " [label=\""+node.getDotLabel()+"\"]" + ";");
//			sb.append("\n");
//		}
//		
//		for (VariableDeclaration var : getPrimaryNodeSet()) {
//			IConvolutionSystemNode node = getPrimaryNode(var);
//			if (node instanceof MergeNode) {
//				StringBuffer externalEdges = new StringBuffer();
//				sb.append("\tsubgraph cluster_" + var.getName() + "{\n");
//				sb.append("\t\tlabel = \""+var.getName()+"\";\n");
//				//sb.append("\t\t"+node.getDottyID()+" [label=\""+node.getDottyLabel()+"\"];\n");
//				
//				for (ConvolutionSystemEdge edge : incomingEdgesOf(node)) {
//					IConvolutionSystemNode edgeSrc = getEdgeSource(edge);
//					IConvolutionSystemNode edgeTgt = getEdgeTarget(edge);
//					sb.append("\t\t");
//					sb.append(edgeSrc.getDotID() + " -> " + edgeTgt.getDotID() + ";");
//					sb.append("\n");
//	
//					//Second hop; not needed for
//					if (edgeSrc instanceof ConvolutionNode) {
//						//second hops are not part of the subgraph
//						for (ConvolutionSystemEdge edge2 : incomingEdgesOf(edgeSrc)) {
//							IConvolutionSystemNode edge2Src = getEdgeSource(edge2);
//							IConvolutionSystemNode edge2Tgt = getEdgeTarget(edge2);
//							externalEdges.append("\t");
//							externalEdges.append(edge2Src.getDotID() + " -> " + edge2Tgt.getDotID() + ";");
//							externalEdges.append("\n");
//						}
//					}
//				}
//				sb.append("\t}\n");
//				sb.append(externalEdges);
//			} else {
//				if (var.isInput()) {
//					sb.append("\t");
//					sb.append(node.getDotID() +";");
//					sb.append("\n");
//				} else {
//					sb.append("\tsubgraph cluster_" + var.getName() + "{\n");
//					sb.append("\t\tlabel = \""+var.getName()+"\";\n");
//					for (ConvolutionSystemEdge edge : incomingEdgesOf(node)) {
//						sb.append("\t\t");
//						sb.append(getEdgeSource(edge).getDotID() + " -> " + getEdgeTarget(edge).getDotID() + ";");
//						sb.append("\n");
//					}	
//					sb.append("\t}\n");
//				}
//			}
//		}
//		
//		sb.append("}");
//		
//		return sb.toString();
	}
	
	private String toDotString(boolean detailed) {
		StringBuffer sb = new StringBuffer();
	
		sb.append("digraph {\n");
		
		for (IConvolutionSystemNode node : vertexSet()) {
			sb.append("\t");
			if (detailed && node instanceof ConvolutionNode) {
				Convolution conv = ((ConvolutionNode)node).getConvolution();
				sb.append(node.getDotID() + " [label=\"");
				if (!conv.isIdentity()) {
					sb.append(conv.toCoefficientString().replaceAll("\n", "\\\\n"));
					sb.append("conv\\n");
				}
				sb.append(conv.toDataAccessString().replaceAll("\n", "\\\\n"));
				sb.append("\"]" + ";");
			} else {
				sb.append(node.getDotID() + " [label=\""+node.getDotLabel()+"\"]" + ";");
			}
			sb.append("\n");
		}
		
		for (VariableDeclaration var : getPrimaryNodeSet()) {
			IConvolutionSystemNode node = getPrimaryNode(var);
			if (node instanceof MergeNode) {
				StringBuffer externalEdges = new StringBuffer();
				sb.append("\tsubgraph cluster_" + var.getName() + "{\n");
				sb.append("\t\tlabel = \""+var.getName()+"\";\n");
				//sb.append("\t\t"+node.getDottyID()+" [label=\""+node.getDottyLabel()+"\"];\n");
				
				for (ConvolutionSystemEdge edge : incomingEdgesOf(node)) {
					IConvolutionSystemNode edgeSrc = getEdgeSource(edge);
					IConvolutionSystemNode edgeTgt = getEdgeTarget(edge);
					sb.append("\t\t");
					sb.append(edgeSrc.getDotID() + " -> " + edgeTgt.getDotID() + ";");
					sb.append("\n");
	
					//Second hop; not needed for
					if (edgeSrc instanceof ConvolutionNode) {
						//second hops are not part of the subgraph
						for (ConvolutionSystemEdge edge2 : incomingEdgesOf(edgeSrc)) {
							IConvolutionSystemNode edge2Src = getEdgeSource(edge2);
							IConvolutionSystemNode edge2Tgt = getEdgeTarget(edge2);
							externalEdges.append("\t");
							externalEdges.append(edge2Src.getDotID() + " -> " + edge2Tgt.getDotID() + ";");
							externalEdges.append("\n");
						}
					}
				}
				sb.append("\t}\n");
				sb.append(externalEdges);
			} else {
				if (var.isInput()) {
					sb.append("\t");
					sb.append(node.getDotID() +";");
					sb.append("\n");
				} else {
					sb.append("\tsubgraph cluster_" + var.getName() + "{\n");
					sb.append("\t\tlabel = \""+var.getName()+"\";\n");
					for (ConvolutionSystemEdge edge : incomingEdgesOf(node)) {
						sb.append("\t\t");
						sb.append(getEdgeSource(edge).getDotID() + " -> " + getEdgeTarget(edge).getDotID() + ";");
						sb.append("\n");
					}	
					sb.append("\t}\n");
				}
			}
		}
		
		sb.append("}");
		
		return sb.toString();
	}
}
