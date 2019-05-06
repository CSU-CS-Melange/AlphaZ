package org.polymodel.prdg.adapter.providers;

import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;

import fr.irisa.cairn.graph.providers.ICommutativityProvider;

public class PRDGCommutativityProvider implements ICommutativityProvider<IPRDGNodeAdapter> {

	public boolean isCommutative(IPRDGNodeAdapter n) {
		return true;
	}
}

	