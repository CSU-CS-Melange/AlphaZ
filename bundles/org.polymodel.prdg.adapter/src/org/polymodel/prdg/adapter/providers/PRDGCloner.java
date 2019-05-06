package org.polymodel.prdg.adapter.providers;


import static fr.irisa.cairn.graph.tools.GraphTools.getInputPort;
import static fr.irisa.cairn.graph.tools.GraphTools.getOutputPort;
import static fr.irisa.cairn.graph.tools.GraphTools.getSinkPortNumber;
import static fr.irisa.cairn.graph.tools.GraphTools.getSourcePortNumber;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.builder.AdapterFactory;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;
import org.polymodel.prdg.adapter.model.IPortAdapter;
import org.polymodel.prdg.factory.PRDGUserFactory;

import com.google.inject.Inject;

import fr.irisa.cairn.graph.GraphException;
import fr.irisa.cairn.graph.IPort;
import fr.irisa.cairn.graph.providers.ICloneProvider;




/**
 * Default IPRDGAdapter Adapter cloner with an Injected factory.
 * 
 * XXX: This is a generated cloner. You certainly need to customize it to your adapted graph.
 *
 * 
 */
public class PRDGCloner
		implements
		ICloneProvider<IPRDGAdapter, IPRDGNodeAdapter, IPRDGEdgeAdapter, IPortAdapter> {
		
	@Inject
	private AdapterFactory factory;

	public IPRDGAdapter createGraph(boolean directed) {
		PRDG prdg = PRDGUserFactory.createPRDG();
		IPRDGAdapter adapter = factory.createGraphAdapter(prdg, directed);
		return adapter;
	}

	public IPRDGNodeAdapter cloneNode(IPRDGNodeAdapter n) {
	
		PRDGNode content = EcoreUtil.copy(n.getAdaptedNode());
		IPRDGNodeAdapter copy = factory.createNodeAdapter(content);
	
		for (IPortAdapter port : n.getInputPorts()) {
			copy.addInputPort(clonePort(port));
		}
		for (IPortAdapter port : n.getOutputPorts()) {
			copy.addOutputPort(clonePort(port));
		}
		return copy;
	}

	public IPRDGEdgeAdapter cloneEdge(IPRDGEdgeAdapter e) {
		
		PRDGEdge content = EcoreUtil.copy(e.getAdaptedEdge());
		IPRDGEdgeAdapter copy = factory.createEdgeAdapter(content,
				e.getSourcePort(), e.getSinkPort());
	 	
		return copy;
	}

	public IPortAdapter clonePort(IPortAdapter p) {
		
		IPortAdapter copy = factory.createPortAdapter();
		
		return copy;
	}

	public void reconnectClone(IPRDGEdgeAdapter clone, IPRDGEdgeAdapter edge,
			IPRDGNodeAdapter newSource, IPRDGNodeAdapter newSink)
			throws GraphException {
		int pSource = getSourcePortNumber(edge);
		int pSink = getSinkPortNumber(edge);

		IPort out = getOutputPort(newSource, pSource);
		clone.reconnectSourcePort(out);
		IPort inputPort = getInputPort(newSink, pSink);
		clone.reconnectSinkPort(inputPort);

	}

}		
