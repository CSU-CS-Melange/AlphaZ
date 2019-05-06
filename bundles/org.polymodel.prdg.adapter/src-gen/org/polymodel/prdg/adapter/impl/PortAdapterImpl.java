package org.polymodel.prdg.adapter.impl;
import java.util.Set;

import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;
import org.polymodel.prdg.adapter.model.IPortAdapter;



/**
 * implementation of a node adapter.
 * This graph adapt a Port
 * @author <your name>
 *
 */
public class  PortAdapterImpl extends fr.irisa.cairn.graph.implement.Port implements IPortAdapter {

	
	public PortAdapterImpl(	){
		super();
		
	}
	
	
	
	/** Get the port node */
	/**
	 * @model default=""
	 */
	 @Override
	 public IPRDGNodeAdapter getNode() {
	     return (IPRDGNodeAdapter) super.getNode();
	 }

	/** Get all connected edges */
	/**
	 * @model default=""
	 */
	 @Override
	 @SuppressWarnings("unchecked")
	public Set<IPRDGEdgeAdapter> getEdges() {
		return (Set<IPRDGEdgeAdapter>)super.getEdges();
	}
	

	

}
