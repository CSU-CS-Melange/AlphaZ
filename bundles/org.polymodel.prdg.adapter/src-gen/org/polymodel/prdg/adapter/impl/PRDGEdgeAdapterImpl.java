package org.polymodel.prdg.adapter.impl;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPortAdapter;



/**
 * implementation of a node adapter.
 * This graph adapt a PRDGEdge
 * @author <your name>
 *
 */
public class  PRDGEdgeAdapterImpl extends fr.irisa.cairn.graph.implement.Edge implements IPRDGEdgeAdapter {

	private final PRDGEdge	adapted;
	
	public PRDGEdgeAdapterImpl(PRDGEdge adapted, IPortAdapter source, IPortAdapter sink){
		super(source, sink);
		this.adapted = adapted;
	}
	
	public PRDGEdge getAdaptedEdge() {
		return this.adapted;
	}
	
	
	/**
	 * @model
	 */
	 @Override
	public IPortAdapter getSourcePort() {
		return (IPortAdapter)super.getSourcePort();
	}

	/**
	 * @model
	 */
	 @Override
	public IPortAdapter getSinkPort() {
		return (IPortAdapter)super.getSinkPort();
	}
	
	

}
