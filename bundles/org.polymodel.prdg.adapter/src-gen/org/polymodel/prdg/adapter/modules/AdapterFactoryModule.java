package org.polymodel.prdg.adapter.modules;

import org.polymodel.prdg.adapter.builder.AdapterFactory;

import com.google.inject.Singleton;

import fr.irisa.cairn.componentElement.ServiceModule;

public class  AdapterFactoryModule extends ServiceModule {

	@Override
	protected void configure() {
		this.bindFactory();
	}
	
	protected void bindFactory() {
		this.bind(AdapterFactory.class).in(Singleton.class);
	}	
}

