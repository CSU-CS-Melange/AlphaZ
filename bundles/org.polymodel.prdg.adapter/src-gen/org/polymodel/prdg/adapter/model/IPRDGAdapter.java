package org.polymodel.prdg.adapter.model;
import java.util.Set;

import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;



/**
 * Interface of a graph adapter.
 * This graph adapt a PRDG
 * @author <your name>
 *
 */
public interface  IPRDGAdapter extends fr.irisa.cairn.graph.IGraph, fr.irisa.cairn.graph.observer.IObservable {
	
	/**
	* Get the adapted graph.
	*
	* @return the adapted graph
	*/
	PRDG getAdaptedGraph();
	
	/**
	* Get the container of all adapter/adapted Objects.
	*
	* @return the container
	*/ 
	IAdaptedContainer getContainer();
	
	
	Set<IPRDGNodeAdapter> getNodes();

	Set<IPRDGEdgeAdapter> getEdges();
	
	
	
	
	IPRDGAdapter getAdapterGraph(PRDG graph);
	
	IPRDGNodeAdapter getAdapterNode(PRDGNode node);
	
	
	IPRDGEdgeAdapter getAdapterEdge(PRDGEdge edge);
	
	
	

}
