package org.polymodel.prdg.adapter.modules;

import org.polymodel.prdg.adapter.builder.AdapterBuilder;

import com.google.inject.Singleton;

import fr.irisa.cairn.componentElement.ServiceModule;

public class  AdapterBuilderModule extends ServiceModule {

	@Override
	protected void configure() {
		this.bindBuilder();
	}
	
	protected void bindBuilder() {
		this.bind(AdapterBuilder.class).in(Singleton.class);
	}	
}

