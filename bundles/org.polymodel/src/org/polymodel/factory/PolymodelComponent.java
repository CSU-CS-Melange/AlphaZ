package org.polymodel.factory;

import java.util.HashMap;
import java.util.Map;

import org.polymodel.DimensionsManager;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Polymodel google guice component. It maps {@link PolymodelModule} to their
 * injectors and has a default module used to get default instances of services.
 * 
 * @author antoine
 * 
 */
public class PolymodelComponent {
	private Map<PolymodelModule, Injector> injectorsMap;
	private Injector defaultInjector;
	public final static PolymodelComponent INSTANCE = new PolymodelComponent();

	private PolymodelComponent() {
		this.injectorsMap = new HashMap<PolymodelModule, Injector>();
		setDefaultModule(new PolymodelModule());
	}

	protected Injector getInjector(PolymodelModule module) {
		Injector injector = injectorsMap.get(module);
		if (injector == null) {
			injector = Guice.createInjector(module);
			injectorsMap.put(module, injector);
		}
		return injector;
	}

	/**
	 * Get default injected instance of a service type.
	 * 
	 * @param <T>
	 * @param type
	 *            service type
	 * @return
	 */
	public <T> T getInstance(Class<T> type) {
		return defaultInjector.getInstance(type);
	}

	/**
	 * Get injected instance of a service type for a specific module.
	 * 
	 * @param <T>
	 * @param type
	 *            service type
	 * @param module
	 *            module used for the injector
	 * @return
	 */
	public <T> T getInstance(Class<T> type, PolymodelModule module) {
		return getInjector(module).getInstance(type);
	}

	/**
	 * Set the default module of the component.
	 * 
	 * @param module
	 *            default module to set
	 */
	public void setDefaultModule(PolymodelModule module) {
		this.defaultInjector = getInjector(module);
	}

	/**
	 * Get the polymodel default factory of the component.
	 * 
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends PolymodelDefaultFactory> T getFactory() {
		return (T) getInstance(PolymodelDefaultFactory.class);
	}

	/**
	 * Get the polymodel factory for a specific module.
	 * 
	 * @param <T>
	 * @param module
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends PolymodelDefaultFactory> T getFactory(
			PolymodelModule module) {
		return (T) getInstance(PolymodelDefaultFactory.class, module);
	}

	/**
	 * Get the default dimensions manager.
	 * 
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends DimensionsManager> T getDefaultDimensionsManager() {
		return (T) getInstance(DimensionsManager.class);
	}

	/**
	 * Get the default dimensions manager for a specific module.
	 * 
	 * @param <T>
	 * @param module
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends DimensionsManager> T getDefaultDimensionsManager(
			PolymodelModule module) {
		return (T) getInstance(DimensionsManager.class, module);
	}

}
