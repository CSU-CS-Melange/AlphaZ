package org.polymodel.prdg.adapter.model;

import java.util.Set;



/**
 * Interface of a port adapter.
 
 * @author <your name>
 *
 */
public interface  IPortAdapter extends fr.irisa.cairn.graph.IPort,fr.irisa.cairn.graph.observer.IObservable   {

	
	/** Get the port node */
	/**
	 * @model default=""
	 */
	 IPRDGNodeAdapter getNode();

	/** Get all connected edges */
	/**
	 * @model default=""
	 */
	 Set<IPRDGEdgeAdapter> getEdges();

}

