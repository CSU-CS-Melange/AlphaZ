package org.polymodel.polyhedralIR.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.AccessCollector;
import org.polymodel.polyhedralIR.analysis.AccessCollector.VariableAccess;
import org.polymodel.polyhedralIR.util.DependenceComparator;

public class UOVGuidedSplit {

	public static boolean DEBUG = false;
	
	public static void apply(AffineSystem system) {
		UOVGuidedSplit sb = new UOVGuidedSplit(system);
		sb.apply();
		
	}

	//assumes the given system is normalized
	protected AffineSystem targetSystem;
	protected List<VariableDeclaration> targetVariables;
	protected Map<VariableDeclaration, Domain> boundaries;
	

	private static void debug(String message) {
		if (DEBUG) System.out.println("[UOV Guided Split] " + message);
	}
	
	public UOVGuidedSplit(AffineSystem targetSystem) {
		this.targetSystem = targetSystem;
		targetVariables = new ArrayList<VariableDeclaration>(targetSystem.getEquations().size());
		for (StandardEquation eq : targetSystem.getEquations()) {
			targetVariables.add(eq.getVariable());
		}
		boundaries = new HashMap<VariableDeclaration, Domain>();
	}
	
	private void apply() {
		findBoundaries();
		split();
	}
	
	private void findBoundaries() {
		debug("Collecting Boundaries");
		
		AccessCollector collector = AccessCollector.collect(targetSystem);
		
		for (VariableDeclaration v : targetVariables) {
			Map<AffineFunction, Domain> equalities = new TreeMap<AffineFunction, Domain>(DependenceComparator.INSTANCE);
			Set<AffineFunction> bodyDeps = new TreeSet<AffineFunction>(DependenceComparator.INSTANCE);
			
			//separate into two sets Ib (equalities) and Im (bodyDeps)
			for (AffineFunction dep : collector.getUniqueDependences(v)) {
				if (dep.isIdentity()) continue;
				
				for (VariableAccess va : collector.getAccessByDependence(v, dep)) {
					Domain hull = va.context.image(va.accessFunc).affineHull();
					
					//check if the equalities actually restricts the domain.
					final boolean superset = v.getDomain().equivalence(v.getDomain().intersection(hull));
					
					if (superset || hull.isUniverse()) {
						bodyDeps.add(va.accessFunc);
					} else {
						if (equalities.containsKey(va.accessFunc)) {
							equalities.put(va.accessFunc, hull.union(equalities.get(va.accessFunc)));
						} else {
							equalities.put(va.accessFunc, hull);
						}
					}
				}
			}
			
			//eliminate equivalent functions from Ib
			for (AffineFunction f : bodyDeps) {
				equalities.remove(f);
			}
			
			Domain splitDom = null;
			for (AffineFunction eq : equalities.keySet()) {
				if (splitDom == null) {
					splitDom = equalities.get(eq);
				} else {
					splitDom = splitDom.union(equalities.get(eq));
				}
			}
			if (splitDom != null) {
				splitDom.simplify();
				boundaries.put(v, splitDom);
			}
		}
		
		
		for (VariableDeclaration v : boundaries.keySet()) {
			debug(v.getName() + " " + boundaries.get(v));
		}
		
	}
	
	private void split() {
		for (VariableDeclaration v : boundaries.keySet()) {
			String baseName = v.getName();
			String postfix = "_bound";
			String name = baseName+postfix;
			int count = 0;
			
			while (targetSystem.containsVariable(name)) {
				name = baseName + postfix + count;
				count++;
			}
			
			debug("Splitting:" + v.getName() + " newVar: " + name);
			Split.transform(targetSystem, v, boundaries.get(v), name);
		}
		Normalize.normalize(targetSystem);
	}
}
