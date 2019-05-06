package org.polymodel.polyhedralIR.factory;

import org.polymodel.DimensionsManager;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.polyhedralIR.util.PolyhedralIRDimensionManager;

public class PolyhedralIRModule extends ISLPolymodelModule {

	public final static PolyhedralIRModule INSTANCE = new PolyhedralIRModule();
	
	protected PolyhedralIRModule(){
		
	}
	
	@Override
	protected Class<? extends DimensionsManager> bindDefaultDimensionsManager() {
		return PolyhedralIRDimensionManager.class;
	}
	
	
}
