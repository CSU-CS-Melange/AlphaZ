package org.polymodel.prdg.adapter.providers;
	
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;

import fr.irisa.cairn.graph.ISubGraphNode;
import fr.irisa.cairn.graph.implement.providers.NodeLabelProvider;
    
public class PRDGNodeLabelProvider extends NodeLabelProvider<IPRDGNodeAdapter, ISubGraphNode>  {

	@Override
	public String getNodeLabel(IPRDGNodeAdapter n) {
		return n.getAdaptedNode().getName();
	}
}
	