package org.polymodel.polyhedralIR.polyIRCG.generator.C.MultiPass;

import java.util.List;
import java.util.Map;

import org.polymodel.algebra.IntExpression;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopGuard;


/**
 * Class to store information for composing tile loop with point loops.
 * The node given as innerMost must be able to have a child for point loop.
 * 
 * @author yuki
 *
 */
public class MultiPassTiledLoop {

	public final AbstractScopNode start;
	public final AbstractScopNode flattenLoop;
	public final Map<ScopGuard, AbstractScopNode> innerMost;
	public final List<IntExpression> lastLevelOffset;
	
	public MultiPassTiledLoop(AbstractScopNode _start, AbstractScopNode _flattenLoop, Map<ScopGuard, AbstractScopNode> _innerMost, List<IntExpression> _lastLevelOffset) {
		this.start = _start;
		this.flattenLoop = _flattenLoop;
		this.innerMost = _innerMost;
		this.lastLevelOffset = _lastLevelOffset;
	}
}
