package org.polymodel.polyhedralIR.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.polymodel.AbstractRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.UniformizeWithPipelining;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

/**
 * The analysis implemented in this class is used to uniformize affine dependences.
 * 
 * The analysis is expose with multiple granuralities:
 *  - AffineFunction + Domain; The most fine grained
 *  - List of PRDGEdges; For some subset of dependences to a variable
 *  - StandardEquation; To uniformize all dependences to an equation 
 * 
 * @see UniformizeWithPipelining
 * 
 * @author yuki
 *
 */
public class FindUniformizationVector {

	/**
	 * I
	 * 
	 * @param equation
	 */
	@SuppressWarnings("serial")
	public static AffineFunction find(final Domain domain, AffineFunction ... deps) {
		return findUniformizationVectorSpace(new ArrayList<Domain>(1) { {add(domain);} }, Arrays.asList(deps));
	}
	
	public static AffineFunction find(StandardEquation eq) {
		PRDG prdg = PRDGBuilder.build(eq.getContainerSystem(), true);
		PRDGNode node = prdg.getNode(eq.getVariable().getName());
		
		List<Domain> domains = new LinkedList<Domain>();
		List<AffineFunction> deps = new LinkedList<AffineFunction>();
		
		int dim = -1;
		
		for (PRDGEdge edge : node.getSources()) {
			if (dim == -1) {
				dim = edge.getDomain().getNbIndices();
			} else {
				if (dim != edge.getDomain().getNbIndices()) {
					throw new RuntimeException("All equations that depend on the equation to uniformize must have same number of dimensions.");
				}
			}
			domains.add(PolyhedralIRUserFactory.eINSTANCE.createDomain(edge.getDomain()));
			deps.add(PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(edge.getFunction().getMapping()));
		}
		
		return findUniformizationVectorSpace(domains, deps);
	}
	
	
	private static AffineFunction findUniformizationVectorSpace(List<Domain> domains, List<AffineFunction> deps) {
		for (AffineFunction dep : deps) {
			if (!UniformizationChecks.checkIdempotence(dep)) {
				System.err.println(dep + " fails idempotence check.");
			}
		}
		
		
		//Relevant linearity space is of the union of all domains
		Domain dom = domains.get(0);
		for (int i = 1; i < domains.size(); i++) {
			dom = dom.union(domains.get(i));
		}
		org.polymodel.Domain linD = dom.getPMdomain().affineHull();
		

		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		//Relevant nullspace is the intersection of all nullspaces
		AbstractRelation nullspace =  deps.get(0).getPMmapping().nullspace().buildRelation(manager);
		for (int i = 1; i < deps.size(); i++) {
			nullspace = nullspace.intersection(deps.get(i).getPMmapping().nullspace().buildRelation(manager));
		}
		
		//intersect with linearity space
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(nullspace.intersectDomain(linD).buildFunction());
	}
	
	public static void main(String[] args) {
		ParameterDomain params = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
		AffineFunction f = PolyhedralIRUtility.parseAffineFunction(params, "(i->i)");
		Domain d = PolyhedralIRUtility.parseDomain(params, "{i|0<=i<N}");
		
		System.out.println(find(d, f));
	
	}
}
