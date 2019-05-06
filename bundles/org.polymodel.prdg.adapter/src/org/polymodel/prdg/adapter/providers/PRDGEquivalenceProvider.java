package org.polymodel.prdg.adapter.providers;

import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;
import org.polymodel.prdg.adapter.model.IPortAdapter;

import fr.irisa.cairn.graph.implement.providers.EquivalenceProvider;

public class PRDGEquivalenceProvider extends
		EquivalenceProvider<IPRDGEdgeAdapter, IPRDGNodeAdapter, IPortAdapter> {

	@Override
	public boolean nodesEquivalence(IPRDGNodeAdapter n1, IPRDGNodeAdapter n2) {

		return n1.getAdaptedNode().getClass() == n2.getAdaptedNode().getClass();
	}
}
