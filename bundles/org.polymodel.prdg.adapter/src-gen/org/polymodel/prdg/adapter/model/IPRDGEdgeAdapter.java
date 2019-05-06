package org.polymodel.prdg.adapter.model;





import org.polymodel.prdg.PRDGEdge;



/**
 * Interface of an edge adapter.
 
 * This edge adapt a PRDGEdge
 
 * @author <your name>
 *
 */
public interface  IPRDGEdgeAdapter extends fr.irisa.cairn.graph.IEdge,fr.irisa.cairn.graph.observer.IObservable {

	/**
	* get the adapted edge
	*
	* @return the adapted edge
	*/
	PRDGEdge getAdaptedEdge();
	

	
	/**
	 * @model
	 */
	IPortAdapter getSourcePort();

	/**
	 * @model
	 */
	IPortAdapter getSinkPort();


}

