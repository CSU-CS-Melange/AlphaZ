package org.polymodel.prdg.adapter.modules;

import org.polymodel.prdg.adapter.providers.PRDGDotAttributsProvider;
import org.polymodel.prdg.adapter.providers.PRDGEdgeLabelProvider;
import org.polymodel.prdg.adapter.providers.PRDGNodeLabelProvider;

import com.google.inject.Singleton;

import fr.irisa.cairn.graph.guice.modules.providersbinding.LabelProviderModule;
import fr.irisa.cairn.graph.providers.IAttributsProvider;
import fr.irisa.cairn.graph.providers.IEdgeLabelProvider;
import fr.irisa.cairn.graph.providers.INodeLabelProvider;

public class PRDGLabelProvidersModule extends LabelProviderModule {

	@Override
	protected void bindINodeLabelProvider() {
		bind(INodeLabelProvider.class).to(PRDGNodeLabelProvider.class).in(Singleton.class);
	}
	

	@Override
	protected void bindIEdgeLabelProvider() {
		bind(IEdgeLabelProvider.class).to(PRDGEdgeLabelProvider.class).in(Singleton.class);
	}
	
	protected void bindIAttributeProvider() {
		this.bind(IAttributsProvider.class).to(PRDGDotAttributsProvider.class);
	}

}
