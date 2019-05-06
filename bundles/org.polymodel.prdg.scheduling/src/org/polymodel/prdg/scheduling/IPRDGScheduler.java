package org.polymodel.prdg.scheduling;

import org.eclipse.emf.common.util.EList;
import org.polymodel.prdg.PRDG;

public interface IPRDGScheduler {
	public EList<ScheduledStatement> schedule(PRDG prdg)
			throws SchedulingException;
}
