package org.polymodel.prdg.scheduling.structured;

import org.polymodel.prdg.PRDGNode;

public interface InternalChannelSizeProvider {

	int getOutputSize(PRDGNode n);

}
