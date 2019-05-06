package org.polymodel.factory;

import org.polymodel.DimensionsManager;
import org.polymodel.PolymodelFactory;
import org.polymodel.impl.DimensionsManagerImpl;
import org.polymodel.impl.PolymodelFactoryImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class PolymodelModule extends AbstractModule {

	@Override
	protected void configure() {
		Class<? extends PolymodelFactory> bindPolymodelFactory = bindPolymodelFactory();
		bind(PolymodelFactory.class).to(bindPolymodelFactory).in(Singleton.class);
		Class<? extends PolymodelDefaultFactory> bindPolymodelDefaultFactory = bindPolymodelDefaultFactory();
		if (bindPolymodelDefaultFactory != PolymodelDefaultFactory.class) {
			bind(PolymodelDefaultFactory.class).to(bindPolymodelDefaultFactory).in(Singleton.class);
		}
		bind(DimensionsManager.class).to(bindDefaultDimensionsManager()).in(Singleton.class);
	}

	protected Class<? extends PolymodelFactory> bindPolymodelFactory() {
		return PolymodelFactoryImpl.class;
	}

	protected Class<? extends PolymodelDefaultFactory> bindPolymodelDefaultFactory() {
		return PolymodelDefaultFactory.class;
	}

	protected Class<? extends DimensionsManager> bindDefaultDimensionsManager() {
		return DimensionsManagerImpl.class;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == this.getClass())
			return true;
		return false;
	}
}
