package org.polymodel.polyhedralIR.transformation;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.polymodel.DimensionsManager;
import org.polymodel.Function;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.analysis.UniformizationChecks;
import org.polymodel.polyhedralIR.analysis.UniformnessCheck;
import org.polymodel.polyhedralIR.analysis.UniformnessResult;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

/**
 * A push-button transformation that attempts to uniformize everything in a system.
 * 
 * @author yuki
 *
 */
public class Uniformize {
	
	public static boolean DEBUG = false;
	private static final String DEBUG_OUT_HEADER = "[Uniformize] ";
	
	private void debug(String message) {
		if (DEBUG) System.out.println(DEBUG_OUT_HEADER + message);
	}

	public static void apply(AffineSystem system) {
		Uniformize uniformize = new Uniformize(system);
		uniformize.run();
	}

	protected final AffineSystem targetSystem;
	protected final UniformnessResult uniformness;
	
	protected Uniformize(AffineSystem system) {
		targetSystem = system;
		uniformness = UniformnessCheck.apply(targetSystem);
	}
	
	private void run() {
		//tries to uniformize each variable in sequence
		for (PRDGNode targetNode : uniformness.getNonUniformEdgeByProducer().keySet()) {
			uniformizeOneNode(targetNode);
		}
	}
	
	private void uniformizeOneNode(PRDGNode node) {
		PolymodelDefaultFactory fact = PolymodelComponent.INSTANCE.getFactory(PolyhedralIRModule.INSTANCE);
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		int maxRank = 0;
		for (PRDGEdge edge : uniformness.getNonUniformEdgeByProducer().get(node)) {
			maxRank = Math.max(maxRank, uniformness.getDependenceRanks().get(edge));
			boolean idempotent = UniformizationChecks.checkIdempotence(edge.getFunction().getMapping());
			if (!idempotent) {
				throw new RuntimeException("Failed idempotence check on PRDGEdge:" + edge);
			}
		}
		
		//straight forward nullspace pipelining works
		if (maxRank == 1) {
			//collect common linear parts
			//use string since hashes does not work for functions
			Map<Function, List<PRDGEdge>> commonLinearParts = new TreeMap<Function, List<PRDGEdge>>(new Comparator<Function>() {
				@Override
				public int compare(Function o1, Function o2) {
					return o1.toString(OUTPUT_FORMAT.ALPHABETS).compareTo(o2.toString(OUTPUT_FORMAT.ALPHABETS));
				}
			});
			for (PRDGEdge edge : uniformness.getNonUniformEdgeByProducer().get(node)) {
				Function edgeFunc = edge.getFunction().getMapping();
				Function lp = edgeFunc.linearPartAsFunction();
				if (!commonLinearParts.containsKey(lp)) {
					commonLinearParts.put(lp, new LinkedList<PRDGEdge>());
				}
				commonLinearParts.get(lp).add(edge);
			}
			
			//Iterate over each linear part and uniformize the set of edges
			for (Function lp : commonLinearParts.keySet()) {
				Function ns = lp.nullspace();
				debug("common linear part: " + lp + " nullspace: " + ns);
				MatrixRow row = ns.linearPart().getRows().get(0);
				int[] vec = new int[row.getSize()];
				for (int i = 0; i < vec.length; i++) {
					vec[i] = (int)row.get(i);
				}
 				UniformizeWithPipelining.apply(targetSystem, uniformness.getPRDG(), vec, commonLinearParts.get(lp));
			}
			
			
		}
	}
}
