package org.polymodel.prdg.adapter.model;

import java.util.List;

import org.polymodel.prdg.PRDGNode;



/**
 * Interface of a node adapter.
 * This node adapt a PRDGNode
 * @author <your name>
 *
 */
public interface  IPRDGNodeAdapter extends fr.irisa.cairn.graph.INode,fr.irisa.cairn.graph.observer.IObservable  {

	/**
	* Get the adapted node.
	*
	* @return the adapted node
	*/
	PRDGNode getAdaptedNode();
	
	
	/**
	 * Get the graph containing the node.
	 * 
	 * @model default=""
	 * 
	 * @return the node graph or <code>null</code> if graph hasn't been set
	 */
	public IPRDGAdapter getGraph();
	
	
	
	

	/**
	 * Get a list of all incoming edges to the node.
	 * 
	 * @model default=""
	 * 
	 * @return
	 */
	 List<IPRDGEdgeAdapter> getIncomingEdges();

	/**
	 * Get a list of all outgoing edges from the node.
	 * 
	 * @model default=""
	 * 
	 * @return
	 */
	 List<IPRDGEdgeAdapter> getOutgoingEdges();

	/**
	 * Get the list of all input ports.
	 * 
	 * @model default=""
	 * 
	 * @return
	 */
	 List<IPortAdapter> getInputPorts();

	/**
	 * Get the list of all output ports.
	 * 
	 * @model default=""
	 * 
	 * @return
	 */
	 List<IPortAdapter> getOutputPorts();

	/**
	 * Get predecessors of this node in its graph.
	 * 
	 * @model default=""
	 */
	 List<IPRDGNodeAdapter> getPredecessors();

	/**
	 * Get successors of this node in its graph.
	 * 
	 * @model default=""
	 */
	 List<IPRDGNodeAdapter> getSuccessors();
	 
	 
	 
	

	
}

