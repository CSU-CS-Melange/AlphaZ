package org.polymodel.prdg.scheduling.util;

import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.ProjectionFunction;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSpace;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionSet;

/**
 * Builds a ISL union map and union set representing the PRDG and the domains of
 * a given "EMF PRDG".
 * 
 * @author amorvan
 * 
 */
public class JNIUnionMapBuilderFromPRDG {

	private static PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
	
	/**
	 * Structure class for returning the domains and PRDG.
	 * 
	 * @author amorvan
	 *
	 */
	public class Pair {
		public JNIISLUnionSet domains;
		public JNIISLUnionMap prdg;
		public Pair(JNIISLUnionSet domains, JNIISLUnionMap prdg) {
			this.domains = domains;
			this.prdg = prdg;
		}
	}
	
	public static Pair build(PRDG prdg) {
		return (new JNIUnionMapBuilderFromPRDG(prdg)).build();
	}
	
	private PRDG prdg;
	
	public JNIUnionMapBuilderFromPRDG(PRDG prdg) {
		this.prdg = prdg;
	}

	public Pair build() {
		JNIISLUnionSet domains = null;
		for (PRDGNode node : this.prdg.getNodes()) {
			ISLSet islDom = factory.createDomain(node.getDomain());
			JNIISLSet set = ISLNativeBinder.jniIslSetNoString(islDom);
			set = set.setTupleName(node.getName());
			if (domains == null) domains = set.toUnionSet();
			else domains = domains.union(set.toUnionSet());
		}
		if (domains == null) {
			throw new NullPointerException();
		}
		
		
		JNIISLUnionMap islPrdg = JNIISLMap.buildEmpty(JNIISLSpace.copySpaceParamsForMap(domains.getSpace().copy())).toUnionMap();
		for (PRDGEdge edge : prdg.getEdges()) {
			JNIISLMap map1 = ISLNativeBinder.jniIslMapNoString(edge.getFunction().getMapping());
			JNIISLSet set = ISLNativeBinder.jniIslSetNoString(edge.getDomain());
			JNIISLMap map2 = map1.copy().intersectDomain(set.copy());
			
			if (map2 == null) {
				System.out.println("map1 = " + map1);
				System.out.println("set = " + set);
				throw new RuntimeException("Problem while intersecting domain");
			}

			map2 = map2.setTupleName(JNIISLDimType.isl_dim_out, edge.getDestination().getName());
			map2 = map2.setTupleName(JNIISLDimType.isl_dim_in, edge.getSource().getName());
			
			islPrdg = islPrdg.union(map2.toUnionMap());
		}
		
		if (!prdg.getHedges().isEmpty())
			throw new RuntimeException("hedge not managed for Scheduler yet...");
		//for (PRDGSubSystemHyperEdge hedge : prdg.getHedges()) {
		//	throw new RuntimeException("hedge not managed for Scheduler yet...");
		//}
		
		return new Pair(domains, islPrdg);
	}
	
	/* ------------------------- To have a coherent input to plutoScheduler --------------------- */
	
	// Takes a "true-dependence" (aka, non-dataflow) PRDG (obtained directly from PRDGBuilder) and turn it into constraints to be sent to isl
	// Same than build, but reverse the projection function (to make it coherent with the direction of the edge)
	public static Pair buildPluto(PRDG prdg) {
		return (new JNIUnionMapBuilderFromPRDG(prdg)).buildPluto();
	}
	
	public Pair buildPluto() {
		JNIISLUnionSet domains = null;
		for (PRDGNode node : this.prdg.getNodes()) {
			ISLSet islDom = factory.createDomain(node.getDomain());
			JNIISLSet set = ISLNativeBinder.jniIslSetNoString(islDom);
			set = set.setTupleName(node.getName());
			if (domains == null) domains = set.toUnionSet();
			else domains = domains.union(set.toUnionSet());
		}
		if (domains == null) {
			throw new NullPointerException();
		}
		
		JNIISLUnionMap islPrdg = JNIISLMap.buildEmpty(JNIISLSpace.copySpaceParamsForMap(domains.getSpace().copy())).toUnionMap();
		for (PRDGEdge edge : prdg.getEdges()) {
			JNIISLMap map1 = ISLNativeBinder.jniIslMapNoString(edge.getFunction().getMapping());
			JNIISLSet set = ISLNativeBinder.jniIslSetNoString(edge.getDomain());
			JNIISLMap map2 = map1.copy().intersectDomain(set.copy());
			
			if (edge.getFunction() instanceof ProjectionFunction) {
				map2 = map2.copy().reverse();
			}
			
			if (map2 == null) {
				System.out.println("map1 = " + map1);
				System.out.println("set = " + set);
				throw new RuntimeException("Problem while intersecting domain");
			}

			map2 = map2.setTupleName(JNIISLDimType.isl_dim_out, edge.getDestination().getName());
			map2 = map2.setTupleName(JNIISLDimType.isl_dim_in, edge.getSource().getName());
			
			islPrdg = islPrdg.union(map2.toUnionMap());
		}
		
		if (!prdg.getHedges().isEmpty())
			throw new RuntimeException("hedge not managed for Scheduler yet...");
		
		return new Pair(domains, islPrdg);
	}
	
}
