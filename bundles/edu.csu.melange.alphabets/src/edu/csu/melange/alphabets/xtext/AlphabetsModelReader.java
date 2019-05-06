package edu.csu.melange.alphabets.xtext;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import edu.csu.melange.alphabets.xtext.alphabets.AProgram;


public class AlphabetsModelReader {

	public static AProgram loadModel(String filename) throws IOException {
		
        final Injector injector = new AlphabetsStandaloneSetup().createInjectorAndDoEMFRegistration();

        final ResourceSet set = injector.getInstance(XtextResourceSet.class);
        final Resource res = set.getResource(URI.createURI (filename), true);

 		EObject root = res.getContents().get(0);
 		AProgram toplevel= (AProgram) root;
 		return toplevel;
	}
	
	public static void formatFile(String filename) throws IOException {
		AProgram prog = loadModel(filename);

        final Injector injector = new AlphabetsStandaloneSetup().createInjectorAndDoEMFRegistration();
        final XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
 
        set.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
		 injector.getInstance(XtextResourceFactory.class));
        
        SaveOptions opt = SaveOptions.newBuilder().format().getOptions();
        
        XtextResource resource = (XtextResource)set.createResource(URI.createFileURI(filename));
		resource.getContents().add(prog);
		resource.save(opt.toOptionsMap());
	}

	public static void saveAsXML(AProgram seq,String modelfilename) throws IOException {
        final Injector injector = new AlphabetsStandaloneSetup().createInjectorAndDoEMFRegistration();
        final ResourceSet set = injector.getInstance(XtextResourceSet.class);
        
        set.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
		 new XMIResourceFactoryImpl());
        
        Resource resource = set.createResource(URI.createFileURI(modelfilename));
		resource.getContents().add(seq);
		resource.save(null);
        
		/*ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
			 new XMIResourceFactoryImpl());

		resourceSet.getPackageRegistry().put
				(SystemModelPackage.eNS_URI, 
						SystemModelPackage.eINSTANCE);

		Resource resource = resourceSet.createResource(URI.createFileURI(modelfilename));
		resource.getContents().add(seq);
		resource.save(null);*/
	}
}