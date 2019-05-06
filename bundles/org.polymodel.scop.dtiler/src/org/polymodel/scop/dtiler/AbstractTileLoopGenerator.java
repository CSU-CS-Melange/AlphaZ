package org.polymodel.scop.dtiler;

import java.util.Set;

import org.polymodel.scop.ScopFor;
import org.polymodel.scop.dtiler.basic.TileLoop;

public abstract class AbstractTileLoopGenerator {
	
	protected final DTilingOptions options;
	
	protected AbstractTileLoopGenerator(DTilingOptions options) {
		this.options = options;
	}

	public abstract TileLoop generate(ScopFor perfectNest);
	
	/* untiledPointLoopIterators set contains the 
	 loop iterator variables of the loops that are not tiled.
	 These vars should added to the list of private variables 
	 when generating omp wavefront parallel code. Otherwise
	 code is not correct.
	 */
	public abstract TileLoop generate(ScopFor perfectNest, Set<String> untiledPointLoopIterators);
}
