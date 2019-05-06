package org.polymodel.prdg.adapter.impl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.model.IAdaptedContainer;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;




/**
 * implementation of the container.
 * @author <your name>
 *
 */
public class  AdaptedContainerImpl implements IAdaptedContainer {

	private Map<PRDG, IPRDGAdapter>	graphsMap;
	
	private Map<PRDGNode, IPRDGNodeAdapter>	nodesMap;
	private Map<PRDGEdge, IPRDGEdgeAdapter>	edgesMap;
	
	
	private IAdaptedContainer parent;
	
	public AdaptedContainerImpl() {
		super();
		this.graphsMap =  new HashMap<PRDG, IPRDGAdapter>();
		this.nodesMap =  new HashMap<PRDGNode, IPRDGNodeAdapter>();
		
		this.edgesMap =  new HashMap<PRDGEdge, IPRDGEdgeAdapter>();
		this.parent = null;
	}
	
	public IAdaptedContainer getParent() {
		return this.parent;
	}
	
	
	public void setParent(IAdaptedContainer parent) {
		this.parent = parent;
		for (Iterator<IPRDGAdapter> iterator = this.graphsMap.values().iterator(); iterator.hasNext();) {
			IPRDGAdapter graphAdapter = iterator.next();
			parent.addGraph(graphAdapter);
		}
		this.graphsMap.clear();
		for (Iterator<IPRDGNodeAdapter> iterator = this.nodesMap.values().iterator(); iterator.hasNext();) {
			IPRDGNodeAdapter nodeAdapter = iterator.next();
			parent.addNode(nodeAdapter);
		}
		this.nodesMap.clear();
		
		
		
		for (Iterator<IPRDGEdgeAdapter> iterator = this.edgesMap.values().iterator(); iterator.hasNext();) {
			IPRDGEdgeAdapter edgeAdapter = iterator.next();
			parent.addEdge(edgeAdapter);
		}
		this.edgesMap.clear();
		
	}
	
	public IAdaptedContainer getRoot() {
		IAdaptedContainer root;
		if (this.isRoot()) {
			root =  this;
		} else {
			root = this.getParent().getRoot();
		}
		return root;
	}
	
	private boolean isRoot() {
		return this.parent == null;
	}
	
	public IPRDGAdapter getAdapterGraph(PRDG graph) {
		if (isRoot()) {
			return this.graphsMap.get(graph);
		} else {
			return getRoot().getAdapterGraph(graph);
		}
	}
		
	public IPRDGNodeAdapter getAdapterNode(PRDGNode node) {
		if (isRoot()) {
			return nodesMap.get(node);
		} else {
			return getRoot().getAdapterNode(node);
		}
	}
	
	
	
	
	public IPRDGEdgeAdapter getAdapterEdge(PRDGEdge edge){
		if (isRoot()) {
			return edgesMap.get(edge);
		} else {
			return getRoot().getAdapterEdge(edge);
		}
	}
	
	
	public void addGraph(IPRDGAdapter adapter) {
		if (isRoot()) {
			PRDG adapted = adapter.getAdaptedGraph();
			if (!graphsMap.containsKey(adapted)) {
				graphsMap.put(adapted, adapter);
			}
		} else {
			getRoot().addGraph(adapter);
		}
	}
	
	public void addNode(IPRDGNodeAdapter adapter){
		if (isRoot()) {
			PRDGNode adapted = adapter.getAdaptedNode();
			if (!nodesMap.containsKey(adapted)) {
				nodesMap.put(adapted, adapter);
			}
		} else {
			getRoot().addNode(adapter);
		}
	}
	
	
	
	
	public void addEdge(IPRDGEdgeAdapter adapter){
		if (isRoot()) {
			PRDGEdge adapted = adapter.getAdaptedEdge();
			if (!edgesMap.containsKey(adapted)) {
				edgesMap.put(adapted, adapter);
			}
		} else {
			getRoot().addEdge(adapter);
		}
	}
	
	
	public void removeGraph(PRDG  adapted){
		if (isRoot()) {
			this.graphsMap.remove(adapted);
		} else {
			getRoot().removeGraph(adapted);
		}
	}
	
	public void removeGraph(IPRDGAdapter adapter) {
		if (isRoot()) {
			this.graphsMap.remove(adapter.getAdaptedGraph());
		} else {
			getRoot().removeGraph(adapter);
		}
	}
	
	
	public void removeEdge(PRDGEdge adapted) {
		if (isRoot()) {
			edgesMap.remove(adapted);
		} else {
			getRoot().removeEdge(adapted);
		}
	}
	
	
	
	public void removeEdge(IPRDGEdgeAdapter adapter) {
		if (isRoot()) {
			removeEdge(adapter.getAdaptedEdge());
		} else {
			getRoot().removeEdge(adapter);
		}
		
	}
	

	public void removeNode(PRDGNode adapted) {
		if (isRoot()) {
			nodesMap.remove(adapted);
		} else {
			getRoot().removeNode(adapted);
		}
		
	}

	public void removeNode(IPRDGNodeAdapter adapter) {
		if (isRoot()) {
			removeNode(adapter.getAdaptedNode());
		} else {
			getRoot().removeNode(adapter);
		}
		
	}
	
	
	
		
	
	public boolean containGraph(PRDG adapted) {
		if (isRoot()) {
			return this.graphsMap.containsKey(adapted);
		} else {
			return getRoot().containGraph(adapted);
		}
	}
	
	
	public boolean containEdge(PRDGEdge adapted) {
		if (isRoot()) {
			return edgesMap.containsKey(adapted);
		} else {
			return getRoot().containEdge(adapted);
		}
	}
		

	public boolean containNode(PRDGNode adapted) {
		if (isRoot()) {
			return nodesMap.containsKey(adapted);
		} else {
			return getRoot().containNode(adapted);
		}
	}
	

		

}
