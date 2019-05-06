package org.polymodel.scop.dtiler;

import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;

public abstract class AbstractPointLoopGenerator {
	
	protected final DTilingOptions options;
	
	protected AbstractPointLoopGenerator(DTilingOptions options) {
		this.options = options;
	}
	
	public abstract AbstractScopNode generate(ScopFor fullyEmbeddedLoopNest);
	public abstract AbstractScopNode generate(ScopBlock fullyEmbeddedLoopNests);

}
