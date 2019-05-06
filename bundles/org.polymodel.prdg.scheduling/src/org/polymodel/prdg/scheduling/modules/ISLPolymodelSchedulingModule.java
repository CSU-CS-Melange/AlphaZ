package org.polymodel.prdg.scheduling.modules;

import org.polymodel.PolymodelFactory;
import org.polymodel.isl.factory.ISLPolymodelModule.ISLPolymodelFactoryProxy;

public class ISLPolymodelSchedulingModule extends SchedulingModule {

	
	@Override
	protected Class<? extends PolymodelFactory> bindPolymodelFactory() {
		return ISLPolymodelFactoryProxy.class;
	}
}
