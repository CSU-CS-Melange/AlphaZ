package org.polymodel.polyhedralIR.analysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.util.DependenceComparator;


/**
 * AccessCollector collects all dependencies for each variable declared.
 * 
 * @author yuki
 *
 */
public class AccessCollector extends PolyhedralIRDepthFirstVisitorImpl {
	
	public static boolean DEBUG = false;
	
	private static void debug(String message) {
		if (DEBUG) System.out.println("[Access Collector] " + message);
	}

	protected Map<VariableDeclaration, AccessCollection> accessCollections = new HashMap<VariableDeclaration, AccessCollection>();
	protected AffineSystem targetSystem;
	
	protected AccessCollector(AffineSystem system) {
		targetSystem = system;
	}
	
	protected void collect() {
		//initialize map entries
		for (VariableDeclaration varDecl : targetSystem.getLocals()) {
			if (!accessCollections.containsKey(varDecl)) {
				accessCollections.put(varDecl, new AccessCollection());
			}
		}
		targetSystem.accept(this);
	}
	
	public static AccessCollector collect(AffineSystem system) {
		AccessCollector ac = new AccessCollector(system);
		ac.collect();
		return ac;
	}
	
	public List<VariableAccess> getAccesses(VariableDeclaration varDecl) {
		return accessCollections.get(varDecl).accesses;
	}
	
	public SortedSet<AffineFunction> getUniqueDependences(VariableDeclaration varDecl) {
		return accessCollections.get(varDecl).uniqueDependences;
	}
	
	public List<VariableAccess> getAccessByDependence(VariableDeclaration varDecl, AffineFunction dep) {
		return accessCollections.get(varDecl).accessByFunction.get(dep);
	}
	
	public Set<VariableDeclaration> getKeySet() {
		return accessCollections.keySet();
	}

	@Override
	public void inVariableExpression(VariableExpression v) {
		if (v.getVarDecl().isLocal()) {
			final VariableAccess vaccess;
			
			// TODO: implement that for Subsystems
			if (v.getContainerEquation() instanceof UseEquation)
				throw new RuntimeException("Operation Unimplemented for Subsystems");
			
			if (v.eContainer() instanceof DependenceExpression) {
				vaccess = new VariableAccess(
						((StandardEquation) v.getContainerEquation()).getVariable(),
						((DependenceExpression)v.eContainer()).getContextDomain(),
						((DependenceExpression)v.eContainer()).getDep());
			} else {
				vaccess = new VariableAccess(
						((StandardEquation) v.getContainerEquation()).getVariable(),
						v.getContextDomain(),
						PolyhedralIRUtility.createIdentityFunction(v.getContextDomain()));
			}
			
			accessCollections.get(v.getVarDecl()).add(vaccess);
			
			debug("Collected access to " + v.getVarDecl().getName() +": " + vaccess);
		}
	}
	
	public class VariableAccess {
		public final VariableDeclaration source;
		public final Domain context;
		public final AffineFunction accessFunc;
		
		public VariableAccess(VariableDeclaration source, Domain context, AffineFunction access) {
			this.source = source;
			this.context = context;
			this.accessFunc  = access;
		}
		
		@Override
		public String toString() {
			return source.getName() + " @ " + accessFunc;
		}
	}
	
	private class AccessCollection {
		private List<VariableAccess> accesses;
		private SortedSet<AffineFunction> uniqueDependences;
		private Map<AffineFunction, List<VariableAccess>> accessByFunction;
		
		private AccessCollection() {
			accesses = new LinkedList<VariableAccess>();
			uniqueDependences = new TreeSet<AffineFunction>(DependenceComparator.INSTANCE);
			accessByFunction = new TreeMap<AffineFunction, List<VariableAccess>>(DependenceComparator.INSTANCE);
		}
		
		private void add(VariableAccess access) {
			accesses.add(access);
			uniqueDependences.add(access.accessFunc);
			if (!accessByFunction.containsKey(access.accessFunc)) {
				accessByFunction.put(access.accessFunc, new LinkedList<VariableAccess>());
			}
			accessByFunction.get(access.accessFunc).add(access);	
		}
	}
}
