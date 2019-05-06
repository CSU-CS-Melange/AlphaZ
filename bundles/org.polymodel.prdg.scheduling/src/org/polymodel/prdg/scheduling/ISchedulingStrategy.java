package org.polymodel.prdg.scheduling;

import org.polymodel.Domain;

/**
 * Strategy interface for the scheduling problem.
 * 
 * @author antoine
 * 
 */
public interface ISchedulingStrategy {
	/**
	 * Solve the scheduling domain.
	 * 
	 * @param schedulingDomain
	 * @return scheduled domain
	 * @throws SchedulingException
	 *             if the domain can't be scheduled
	 */
	Domain solve(Domain schedulingDomain) throws SchedulingException;
}
