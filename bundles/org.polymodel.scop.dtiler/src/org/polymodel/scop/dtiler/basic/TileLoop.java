package org.polymodel.scop.dtiler.basic;

import org.polymodel.scop.AbstractScopNode;


/**
 * Class to store information for composing tile loop with point loops.
 * The node given as innerMost must be able to have a child for point loop.
 * 
 * @author yuki
 *
 */
public class TileLoop {

	public final AbstractScopNode start;
	public final AbstractScopNode innerMost;
	
	public TileLoop(AbstractScopNode start, AbstractScopNode innerMost) {
		this.start = start;
		this.innerMost = innerMost;
	}
}
