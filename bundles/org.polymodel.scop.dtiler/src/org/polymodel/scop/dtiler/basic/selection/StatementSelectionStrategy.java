package org.polymodel.scop.dtiler.basic.selection;

import java.util.List;

import org.polymodel.scop.AbstractScopStatement;

/**
 * Strategy to select the most computed statement in a loop nest.
 * 
 * @author antoine
 * 
 */
public interface StatementSelectionStrategy {

	public AbstractScopStatement select(List<AbstractScopStatement> statements);
}
