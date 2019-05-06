package org.polymodel.prdg.scheduling;

import java.util.List;

import org.polymodel.prdg.PRDGEdge;

/**
 * Provider for all dependencies that are related to a {@link PRDGEdge}.
 * 
 * @author antoine
 * 
 */
public interface IDependenciesProvider {

	/**
	 * Get all dependencies for a given {@link PRDGEdge}.
	 * 
	 * @param e
	 * @return
	 */
	List<Dependency> getDependenciesFor(PRDGEdge e);
}
