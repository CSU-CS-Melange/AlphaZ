package org.polymodel.prdg.adapter.builder;

import java.util.Comparator;

import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.impl.PRDGAdapterImpl;
import org.polymodel.prdg.adapter.impl.PRDGEdgeAdapterImpl;
import org.polymodel.prdg.adapter.impl.PRDGNodeAdapterImpl;
import org.polymodel.prdg.adapter.impl.PortAdapterImpl;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;
import org.polymodel.prdg.adapter.model.IPortAdapter;

import com.google.inject.Inject;

import fr.irisa.cairn.graph.IEdge;
import fr.irisa.cairn.graph.INode;
import fr.irisa.cairn.graph.IPort;

/**
 * Factory of the graph adapter. Nodes, edges and ports may be ordered if 
 * an adapted Comparator is injected.
 
 * @author <your name>
 *
 */
public class  AdapterFactory {


	@Inject
	Comparator<INode> nodeComparator;
	@Inject
	Comparator<IEdge> edgeComparator;
	@Inject
	Comparator<IPort> portComparator;
	
	
	@Inject
	protected AdapterFactory() {}
	
	
   	public IPRDGAdapter createGraphAdapter(PRDG adapted, boolean directed) {
   	 	PRDGAdapterImpl graph =  new PRDGAdapterImpl(adapted, directed);
		if (this.nodeComparator != null) {
			graph.setNodeComparator(this.nodeComparator);
		}
		if (this.edgeComparator != null) {
			graph.setEdgeComparator(this.edgeComparator);
		}
		return graph;
   	}
   	
   	public IPRDGNodeAdapter createNodeAdapter(PRDGNode adapted) {
   		PRDGNodeAdapterImpl node = new PRDGNodeAdapterImpl(adapted);
   		if (this.portComparator != null) {
			node.setPortComparator(portComparator);
		}
   		return node;
   	}
   	
   	
   	
   	public IPortAdapter createPortAdapter() {
		PortAdapterImpl port = new PortAdapterImpl();;
		return port;
   	}
   	
   	public IPRDGEdgeAdapter createEdgeAdapter( PRDGEdge adapted,  IPortAdapter source, IPortAdapter sink) {
   		return new PRDGEdgeAdapterImpl(adapted, source, sink);
   	}
   	
   
   	
   	/**
	 * Connect two ports and add the link to the nodes' graphs
	 * 
	 * @param source
	 * @param sink
	 * @return the created edge
	 */
   	public IPRDGEdgeAdapter connect( PRDGEdge adapted,  IPortAdapter source, IPortAdapter sink) {
   		IPRDGEdgeAdapter  e = createEdgeAdapter( adapted,  source, sink);
		IPRDGAdapter gSource = source.getNode().getGraph();
		IPRDGAdapter gSink = sink.getNode().getGraph();
		gSource.addEdge(e);
		if (gSource != gSink) {
			gSink.addEdge(e);
		}
		return e;
   	}
   	/**
	 * Connect two nodes and add the link to the nodes' graphs
	 * 
	 * @param source
	 * @param sink
	 * @return the created edge
	 */
   	public IPRDGEdgeAdapter connect( PRDGEdge adapted, IPRDGNodeAdapter source, IPRDGNodeAdapter sink) {
	   	IPortAdapter sourcePort;
	   	IPortAdapter sinkPort;   
   			sourcePort = createPortAdapter();
   			source.addOutputPort(sourcePort);
   			sinkPort = createPortAdapter();
   			sink.addInputPort(sinkPort);
   		return connect( adapted,  sourcePort, sinkPort);
   		
   	}
   	
   	
   	
   	

}

