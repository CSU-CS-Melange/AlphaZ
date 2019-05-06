package org.polymodel.scop.dtiler.hierarchy;

import java.util.HashMap;
import java.util.Map;

import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTiler.TilableBlock;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTiler.HierarchyTiledBlock;

public class HierarchyDTilingOutput {

	public final ScopRoot tiledScop;
	public final Map<TilableBlock, HierarchyTiledBlock> tilingBlocks;
	
	public HierarchyDTilingOutput(ScopRoot tiledScop) {
		this.tiledScop = tiledScop;
		this.tilingBlocks = new HashMap<TilableBlock, HierarchyTiledBlock>();
	}

}
