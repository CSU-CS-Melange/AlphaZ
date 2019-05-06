package org.polymodel.polyhedralIR.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.Program;




public class PolyhedralIRReader {

	public static Program loadModel(String filename) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
		 new XMIResourceFactoryImpl());

		resourceSet.getPackageRegistry().put
				(PolyhedralIRPackage.eNS_URI, 
						PolyhedralIRPackage.eINSTANCE);
		
        Resource res = resourceSet.getResource(URI.createURI (filename), true);

 		EObject root = res.getContents().get(0);
 		Program toplevel= (Program) root;
 		return toplevel;
	}

	public static void saveAsXML(Program seq,String modelfilename) throws IOException {
        ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
			 new XMIResourceFactoryImpl());

		resourceSet.getPackageRegistry().put
				(PolyhedralIRPackage.eNS_URI, 
						PolyhedralIRPackage.eINSTANCE);

		Resource resource = resourceSet.createResource(URI.createFileURI(modelfilename));
		resource.getContents().add(seq);
		resource.save(null);
	}
}
