package org.polymodel.prdg.adapter.impl;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.model.IAdaptedContainer;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;

import fr.irisa.cairn.graph.IEdge;
import fr.irisa.cairn.graph.INode;



/**
 * implementation of a graph adapter.
 * This graph adapt a PRDG
 * @author <your name>
 *
 */
public class  PRDGAdapterImpl extends fr.irisa.cairn.graph.implement.Graph implements IPRDGAdapter {
	
	private IAdaptedContainer container;
	private final PRDG adapted;
	
	public PRDGAdapterImpl(PRDG adapted, boolean directed)  {
		super(directed);
		this.adapted = adapted;
		this.container = new AdaptedContainerImpl();
	}
	
	
	public PRDG getAdaptedGraph() {
		return this.adapted;
	}
	
	public IAdaptedContainer getContainer() {
		return this.container;
	}
	
	
	/**
	 * Add an edge to this graph
	 *
	 * @model default=""
	 * 
	 * @param e
	 *            an Edge
	 */
	@Override
	public void addEdge(IEdge edge) {
		super.addEdge(edge);
		
		if ( edge instanceof IPRDGEdgeAdapter) {
			this.container.addEdge((IPRDGEdgeAdapter)edge);
		}
		
	}

	/**
	 * Add a node to this graph
	 *
	 * @model default=""
	 * 
	 * @param e
	 *            a node
	 */
	@Override
	public void addNode(INode node){
		super.addNode(node);
		
		if (node instanceof  IPRDGNodeAdapter) {
			this.container.addNode((IPRDGNodeAdapter)node);
		}
	}
	
	
	
	@Override
	public void removeEdge(IEdge edge) {
		super.removeEdge(edge);
		
		if (edge instanceof  IPRDGEdgeAdapter) {
			this.container.removeEdge((IPRDGEdgeAdapter)edge);
		}
		
	}
	
	@Override
	public void removeNode(INode node) {
		super.removeNode(node);
		if ( node instanceof IPRDGNodeAdapter) {
			this.container.removeNode((IPRDGNodeAdapter)node);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public java.util.Set<IPRDGNodeAdapter> getNodes(){
		return (java.util.Set<IPRDGNodeAdapter>) super.getNodes();
	}

	@SuppressWarnings("unchecked")
	@Override
	public java.util.Set<IPRDGEdgeAdapter> getEdges(){
		return (java.util.Set<IPRDGEdgeAdapter>) super.getEdges();
	}
	
	
	
	
	
	
	
	public IPRDGAdapter getAdapterGraph(PRDG graph) {
		IPRDGAdapter graphAdapter;
		graphAdapter = this.container.getAdapterGraph(graph);
		return graphAdapter;
	}
	
	public IPRDGNodeAdapter getAdapterNode(PRDGNode node)  {
		IPRDGNodeAdapter nodeAdapter;
		nodeAdapter = this.container.getAdapterNode(node);
		return nodeAdapter;
	}
	
	
	public IPRDGEdgeAdapter getAdapterEdge(PRDGEdge edge) {
		IPRDGEdgeAdapter edgeAdapter;
		edgeAdapter = this.container.getAdapterEdge(edge);
		return edgeAdapter;
	}
	
	

	
	
}
