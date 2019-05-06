package org.polymodel.prdg.adapter.model;




import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;




/**
 * Interface of the adapted container.
 * Provides methods to find the corresponding adapter to an adapted object.
 * 
 * @author <your name>
 *
 */
public interface IAdaptedContainer {

	public IAdaptedContainer getParent();

	public void setParent(IAdaptedContainer parent);
	
	public IAdaptedContainer getRoot();

	public IPRDGAdapter getAdapterGraph(PRDG graph);
	
	public IPRDGNodeAdapter getAdapterNode(PRDGNode node);

	
	
	
	public IPRDGEdgeAdapter getAdapterEdge(PRDGEdge edge);
	
	
	public void addGraph(IPRDGAdapter adapter);
	
	public void addNode(IPRDGNodeAdapter adapter);
	
	
	
	
	public void addEdge(IPRDGEdgeAdapter adapter);
	
	
	public void removeGraph(PRDG  adapted);
	
	public void removeNode(PRDGNode  adapted);

	
	
	
	public void removeEdge(PRDGEdge  adapted);
	
	
	public void removeGraph(IPRDGAdapter adapter);
	
	public void removeNode(IPRDGNodeAdapter adapter);

	
	
	
	public void removeEdge(IPRDGEdgeAdapter adapter);
	
	
	public boolean containGraph(PRDG adapted);
	
	public boolean containNode(PRDGNode adapted);
	
	
	
	
	public boolean containEdge(PRDGEdge adapted);
	
	
}

