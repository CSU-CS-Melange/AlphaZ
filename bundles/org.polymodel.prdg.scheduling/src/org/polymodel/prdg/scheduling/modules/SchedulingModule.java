package org.polymodel.prdg.scheduling.modules;

import org.polymodel.factory.PolymodelModule;
import org.polymodel.prdg.scheduling.ISchedulingStrategy;
import org.polymodel.prdg.scheduling.LexminSchedulingStrategy;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;

import com.google.inject.Singleton;

/**
 * A {@link PolymodelModule} that bind scheduling factory and default scheduling
 * solver.
 * 
 * @author antoine
 * 
 */
public class SchedulingModule extends PolymodelModule {

	@Override
	protected void configure() {
		super.configure();
		Class<? extends SchedulingConcreteFactory> bindSchedulingConcreteFactory = bindSchedulingConcreteFactory();
		if (bindSchedulingConcreteFactory != SchedulingConcreteFactory.class) {
			bind(SchedulingConcreteFactory.class).to(
					bindSchedulingConcreteFactory).in(Singleton.class);
		}
		bind(ISchedulingStrategy.class).to(bindISchedulingSolver()).in(
				Singleton.class);
	}

	protected Class<? extends SchedulingConcreteFactory> bindSchedulingConcreteFactory() {
		return SchedulingConcreteFactory.class;
	}

	protected Class<? extends ISchedulingStrategy> bindISchedulingSolver() {
		return LexminSchedulingStrategy.class;
	}

}
