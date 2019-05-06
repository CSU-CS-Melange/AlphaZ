package org.polymodel.prdg.adapter;




import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.adapter.builder.AdapterBuilder;
import org.polymodel.prdg.adapter.builder.AdapterFactory;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.modules.AdapterBuilderModule;
import org.polymodel.prdg.adapter.modules.AdapterFactoryModule;
import org.polymodel.prdg.adapter.modules.PRDGAnalysisProvidersModule;
import org.polymodel.prdg.adapter.modules.PRDGLabelProvidersModule;

import fr.irisa.cairn.componentElement.ServiceModule;
import fr.irisa.cairn.graph.guice.GraphComponent;
import fr.irisa.cairn.graph.guice.analysis.IGraphAnalysisService;
import fr.irisa.cairn.graph.guice.export.IGraphExportService;
import fr.irisa.cairn.graph.guice.modules.providersbinding.AnalysisProviderModule;
import fr.irisa.cairn.graph.guice.modules.providersbinding.LabelProviderModule;
import fr.irisa.cairn.graph.guice.modules.servicesBinding.FactoryServiceModule;

/**
 * Abstract component injecting basic services (factory and builder).
 * For manual modifications go to {@link org.polymodel.prdg.adapter.PRDGAdapterComponent}
 */
public abstract class  AbstractPRDGAdapterComponent  {
	private GraphComponent graphComponent;

	protected AbstractPRDGAdapterComponent() {
		graphComponent = GraphComponent.getINSTANCE();
		configure();
	}
	
	/**
	 * Configure the {@link GraphComponent}. Install the
	 * {@link AdapterBuilderModule} and {@link AdapterFactoryModule}.
	 */
	protected void configure() {
		replaceModule(FactoryServiceModule.class, new AdapterFactoryModule());
		installModule(new AdapterBuilderModule());
		replaceModule(LabelProviderModule.class, new PRDGLabelProvidersModule());
		replaceModule(AnalysisProviderModule.class, new PRDGAnalysisProvidersModule());
	}

	public void installModule(ServiceModule serviceModule) {
		graphComponent.installModule(serviceModule);

	}

	/**
	 * Get the object in charge of a service in the component.
	 * @param <T> service type
	 * @param serviceClassName
	 * @return 
	 */
	public <T> T getService(Class<T> serviceClassName) {
		return graphComponent.getService(serviceClassName);
	}

	public void installModules(Iterable<ServiceModule> servicesModules) {
		graphComponent.installModules(servicesModules);

	}

	public void installModules(ServiceModule... servicesModules) {
		graphComponent.installModules(servicesModules);

	}

	public void replaceModule(ServiceModule oldServiceModule,
			ServiceModule newServiceModule) {
		graphComponent.replaceModule(oldServiceModule, newServiceModule);

	}

	public void replaceModule(Class<? extends ServiceModule> oldServiceModuleClass,
			ServiceModule newServiceModule) {
		graphComponent.replaceModule(oldServiceModuleClass, newServiceModule);

	}

	public void unInstallModule(ServiceModule serviceModule) {
		graphComponent.unInstallService(serviceModule);

	}

	public void unInstallModules(ServiceModule... serviceModules) {
		graphComponent.unInstallServices(serviceModules);

	}
	
	/**
	 * Get the injected {@link AdapterFactory} of the component.
	 * 
	 * @return the factory in charge of adapters creations
	 */
	public AdapterFactory getAdapterFactory() {
		return getService(AdapterFactory.class);
	}

	
	/**
	 * Create and initialize the adapter of an {@link PRDG}.
	 * @param adaptedGraph
	 * @return 
	 */
	public IPRDGAdapter build(PRDG adaptedGraph) {
		AdapterBuilder buider = GraphComponent.getINSTANCE().getService(
				AdapterBuilder.class);
		return buider.buildGraphAdapter(adaptedGraph);
	}

	public IGraphAnalysisService getGraphAnalysisService() {
		return this.getService(IGraphAnalysisService.class);
	}

	public IGraphExportService getGraphExportService() {
		return this.getService(IGraphExportService.class);
	}


	
}

