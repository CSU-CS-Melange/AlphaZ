package org.polymodel.scop.dtiler;

import java.util.HashMap;
import java.util.Map;

import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTiler.TilableBlock;
import org.polymodel.scop.dtiler.DTiler.TiledBlock;

public class DTilingOutput {

	public final ScopRoot tiledScop;
	public final Map<TilableBlock, TiledBlock> tilingBlocks;
	
	public DTilingOutput(ScopRoot tiledScop) {
		this.tiledScop = tiledScop;
		this.tilingBlocks = new HashMap<TilableBlock, TiledBlock>();
	}

}
