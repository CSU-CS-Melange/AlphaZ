package org.polymodel.prdg.scheduling;

import org.polymodel.Domain;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.factory.ISLPolymodelModule;

public class LexminSchedulingStrategy implements ISchedulingStrategy {

	@Override
	public Domain solve(Domain schedulingDomain)
			throws SchedulingException {
		ISLSet isl = PolymodelComponent.INSTANCE.getFactory(
				ISLPolymodelModule.INSTANCE).createDomain(schedulingDomain);
		Domain lexMin;
		try {
			lexMin = isl.lexMin();
		} catch (Exception e) {
			throw new SchedulingException(
					"Unable to find the minimal monodimensionnal schedule.");
		}
		return lexMin;
	}

}
