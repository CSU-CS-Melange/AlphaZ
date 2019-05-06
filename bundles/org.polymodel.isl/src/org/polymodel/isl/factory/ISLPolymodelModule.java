package org.polymodel.isl.factory;

import org.polymodel.BasicRelation;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.PolymodelFactory;
import org.polymodel.Relation;
import org.polymodel.factory.PolymodelModule;
import org.polymodel.impl.PolymodelFactoryImpl;
import org.polymodel.isl.IslFactory;

public class ISLPolymodelModule extends PolymodelModule {
	public final static ISLPolymodelModule INSTANCE = new ISLPolymodelModule();
	protected ISLPolymodelModule(){
		
	}
	
	@Override
	protected Class<? extends PolymodelFactory> bindPolymodelFactory() {
		return ISLPolymodelFactoryProxy.class;
	}

	public static class ISLPolymodelFactoryProxy extends PolymodelFactoryImpl {

		@Override
		public Domain createDomain() {
			return IslFactory.eINSTANCE.createISLSet();
		}

		@Override
		public Relation createRelation() {
			return IslFactory.eINSTANCE.createISLMap();
		}

		@Override
		public BasicRelation createBasicRelation() {
			return IslFactory.eINSTANCE.createISLBasicMap();
		}
		
		@Override
		public Function createFunction() {
			return IslFactory.eINSTANCE.createISLFunction();
		}
	}

}
