package org.polymodel.prdg.factory;

import java.util.List;

import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.prdg.DependenceFunction;
import org.polymodel.prdg.EdgeFunction;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.PrdgFactory;
import org.polymodel.prdg.ProjectionFunction;

public class PRDGUserFactory {

	protected static final PrdgFactory fact = PrdgFactory.eINSTANCE;
	
	public static PRDG createPRDG() {
		return fact.createPRDG();
	}
	
	public static PRDGNode createPRDGNode(String name, Domain domain) {
		PRDGNode node = fact.createPRDGNode();
		node.setName(name);
		node.setDomain(domain);
		return node;
	}
	
	public static PRDGEdge createPRDGEdge(PRDGNode source, PRDGNode dest, Domain domain, Function func) {
		PRDGEdge edge = fact.createPRDGEdge();
		edge.setSource(source);
		edge.setDestination(dest);
		edge.setDomain(domain);
		edge.setFunction(createDependenceFunction(func));
		return edge;
	}
	
	public static PRDGEdge createPRDGEdge(PRDGNode source, PRDGNode dest, Domain domain, EdgeFunction func) {
		PRDGEdge edge = fact.createPRDGEdge();
		edge.setSource(source);
		edge.setDestination(dest);
		edge.setDomain(domain);
		edge.setFunction(func);
		return edge;
	}
	
	public static PRDGSubSystemHyperEdge createPRDGHEdge(List<PRDGNode> sources, List<PRDGNode> dests, Domain extDomain, Function params) {
		PRDGSubSystemHyperEdge hedge = fact.createPRDGSubSystemHyperEdge();
		hedge.getSources().addAll(sources);
		hedge.getDestinations().addAll(dests);
		hedge.setExtDom(extDomain);
		hedge.setParams(params);
		return hedge;
	}
	
	
	public static DependenceFunction createDependenceFunction(Function func) {
		DependenceFunction f = fact.createDependenceFunction();
		f.setMapping(func);
		return f;
	}
	
	public static ProjectionFunction createProjectionFunction(Function func) {
		ProjectionFunction f = fact.createProjectionFunction();
		f.setMapping(func);
		return f;
	}
}
