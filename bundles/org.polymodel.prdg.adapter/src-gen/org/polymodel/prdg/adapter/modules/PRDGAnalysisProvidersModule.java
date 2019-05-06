package org.polymodel.prdg.adapter.modules;

import org.polymodel.prdg.adapter.providers.PRDGCloner;
import org.polymodel.prdg.adapter.providers.PRDGCommutativityProvider;
import org.polymodel.prdg.adapter.providers.PRDGEquivalenceProvider;
import org.polymodel.prdg.adapter.providers.PRDGLatencyProvider;

import com.google.inject.Singleton;

import fr.irisa.cairn.graph.guice.modules.providersbinding.AnalysisProviderModule;
import fr.irisa.cairn.graph.providers.ICloneProvider;
import fr.irisa.cairn.graph.providers.ICommutativityProvider;
import fr.irisa.cairn.graph.providers.IEquivalenceProvider;
import fr.irisa.cairn.graph.providers.ILatencyProvider;

public class PRDGAnalysisProvidersModule extends AnalysisProviderModule {

	@Override
	protected void bindICloneProvider() {
		bind(ICloneProvider.class).to(PRDGCloner.class).in(Singleton.class);
	}

	@Override
	protected void bindILatencyProvider() {
		bind(ILatencyProvider.class).to(PRDGLatencyProvider.class).in(Singleton.class);
	}

	@Override
	protected void bindIEquivalenceProvider() {
		bind(IEquivalenceProvider.class).to(PRDGEquivalenceProvider.class).in(Singleton.class);
	}

	@Override
	protected void bindICommutativityProvider() {
		bind(ICommutativityProvider.class).to(PRDGCommutativityProvider.class).in(Singleton.class);
	}


}
