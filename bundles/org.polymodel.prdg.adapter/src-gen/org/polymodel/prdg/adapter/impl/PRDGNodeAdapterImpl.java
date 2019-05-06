package org.polymodel.prdg.adapter.impl;
import java.util.List;

import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;
import org.polymodel.prdg.adapter.model.IPortAdapter;

import fr.irisa.cairn.graph.IPort;



/**
 * implementation of a node adapter.
 * This graph adapt a PRDGNode
 * @author <your name>
 *
 */
public class  PRDGNodeAdapterImpl  extends fr.irisa.cairn.graph.implement.Node implements IPRDGNodeAdapter {
	
	private final PRDGNode	adapted;
	
	public PRDGNodeAdapterImpl(PRDGNode adapted){
		super();
		this.adapted = adapted;
	}
	
	public PRDGNode getAdaptedNode() {
		return this.adapted;
	}
	
	
	
	/**
	 * Add an input port to the node.
	 * 
	 * @model default=""
	 * 
	 * @return created port
	 */
	 @Override
	 public void addInputPort(IPort p) {
	 	super.addInputPort(p);
	 	
	 }

	@Override
	public void removeInputPort(IPort p) {
		super.removeInputPort(p);
		
	}

	/**
	 * Add an output port to the node.
	 * 
	 * @model default=""
	 * 
	 * @return created port
	 */
	 @Override
	 public void addOutputPort(IPort p) {
		super.addOutputPort(p);
		
	}

	@Override
	public void removeOutputPort(IPort p) {
		super.removeOutputPort(p);
		
	}
	
	/**
	 * Get the graph containing the node.
	 * 
	 * @model default=""
	 * 
	 * @return the node graph or <code>null</code> if graph hasn't been set
	 */
	 @Override
	public IPRDGAdapter getGraph() {
		return (IPRDGAdapter)super.getGraph();
	}

	/**
	 * Get a list of all incoming edges to the node.
	 * 
	 * @model default=""
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	 public List<IPRDGEdgeAdapter> getIncomingEdges() {
	    return ( List<IPRDGEdgeAdapter>)super.getIncomingEdges();
	 }

	/**
	 * Get a list of all outgoing edges from the node.
	 * 
	 * @model default=""
	 * 
	 * @return
	 */
	 @SuppressWarnings("unchecked")
	@Override
	 public List<IPRDGEdgeAdapter> getOutgoingEdges() {
	    return ( List<IPRDGEdgeAdapter>)super.getOutgoingEdges();
	 }

	/**
	 * Get the list of all input ports.
	 * 
	 * @model default=""
	 * 
	 * @return
	 */
	 @SuppressWarnings("unchecked")
	@Override
	 public List<IPortAdapter> getInputPorts() {
	 	return (List<IPortAdapter>) super.getInputPorts();
	 }

	/**
	 * Get the list of all output ports.
	 * 
	 * @model default=""
	 * 
	 * @return
	 */
	 @SuppressWarnings("unchecked")
	@Override
	public  List<IPortAdapter> getOutputPorts() {
	 	return (List<IPortAdapter>) super.getOutputPorts();
	 }

	
	
	/**
	 * Get predecessors of this node in its graph.
	 * 
	 * @model default=""
	 */
	 @SuppressWarnings("unchecked")
	@Override
	public  List<IPRDGNodeAdapter> getPredecessors() {
	 	return (List<IPRDGNodeAdapter>)super.getPredecessors();
	 }

	/**
	 * Get successors of this node in its graph.
	 * 
	 * @model default=""
	 */
	 @SuppressWarnings("unchecked")
	@Override
	public  List<IPRDGNodeAdapter> getSuccessors() {
	 	return (List<IPRDGNodeAdapter>)super.getSuccessors();
	 }

	 @Override
	public String toString() {
		return getAdaptedNode().getName();
	}
	
	
}
