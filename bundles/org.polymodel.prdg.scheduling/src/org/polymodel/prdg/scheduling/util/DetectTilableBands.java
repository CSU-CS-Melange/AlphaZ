package org.polymodel.prdg.scheduling.util;

import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Function;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.ProjectionFunction;

public class DetectTilableBands {
	
	public static boolean DEBUG = false;
	private static final String DEBUG_OUT_HEADER = "[Detect Tilable Bands] ";
	
	private final void debug(String msg) {
		if (DEBUG) System.out.println(DEBUG_OUT_HEADER + msg);
	}
	
	public static List<TilableBand> detect(PRDG prdg, Map<PRDGNode, Function> schedules) {
		DetectTilableBands dtb = new DetectTilableBands(prdg, schedules);
		return dtb.detect();
	}

	protected final PRDG prdg;
	protected final Map<PRDGNode, Function> schedules;
	protected int scheduleDims;
	protected Map<PRDGNode, List<Long>> orderings;
	protected List<Integer> orderingDims;
	protected Map<PRDGEdge, boolean[]> edgeTilability;
	protected List<OrderingPrefixPartition> orderingPartitions;
	
	protected DetectTilableBands(PRDG prdg, Map<PRDGNode, Function> schedules) {
		this.prdg = prdg;
		this.schedules = schedules;
		
		if (DEBUG) {
			debug("PRDG:\n" + prdg);
			debug("Schedules:");
			for (PRDGNode node : schedules.keySet()) {
				debug(node.getName() + ": " + schedules.get(node).toString(OUTPUT_FORMAT.ALPHABETS));
			}
		}
	}
	
	private List<TilableBand> detect() {
		//check input validity
		{
			StringBuffer inputErrors = new StringBuffer();
			if (!checkInputValidity(inputErrors)) {
				throw new RuntimeException("Input validity check failed: " + inputErrors);
			}
		}
		
		findOrderingDimensions();
		
		createOrderingPrefixPartition();
		
		computeEdgeTilability();
		
		if (DEBUG) {
			for (PRDGEdge edge : edgeTilability.keySet()) {
				boolean[] tilability = edgeTilability.get(edge);
				debug(toConciseString(edge) + ": tilable[" + toStringList(tilability)+"]");	
			}
		}
		
		computePartitionTilability();
		
		return createTilableBands();
	}
	
	/**
	 * Performs basic validity check of the inputs.
	 *  - Schedules must be given to all nodes in the PRDG.
	 *  - Schedules must have the same number of dimensions (in the RHS).
	 * 
	 * @param message
	 * @return
	 */
	private boolean checkInputValidity(StringBuffer message) {
		int dim = -1;
		for (PRDGNode node : prdg.getNodes()) {
			if (!schedules.containsKey(node) || schedules.get(node) == null) {
				message.append("Schedule not given for node: " + node.getName() + "\n");
			}
			Function sch = schedules.get(node);
			if (dim == -1) {
				dim = sch.getExpressions().size();
			} else if (dim != sch.getExpressions().size()) {
				message.append("RHS dimensions of the given schedule for " + node.getName() + " do not match others.\n");
			}
		}
		
		scheduleDims = dim;
		
		return true;
	}

	/**
	 * Detects ordering dimensions; the dimensions with only constants.
	 * 
	 * The results are store in class member variables:
	 *   - orderings; Map from PRDGNode to the subset of the schedule given to the node 
	 *                corresponding to ordering dimensions, represented as list of longs.
	 *   - orderingDims; An integer list containing the ordering dimensions.
	 * 
	 */
	private void findOrderingDimensions() {
		orderings = new HashMap<PRDGNode, List<Long>>();
		for (PRDGNode node : prdg.getNodes()) {
			Function sch = schedules.get(node);
			List<Long> order = new ArrayList<Long>(sch.getExpressions().size());
			for (int d = 0; d < sch.getExpressions().size(); d++) {
				 if (sch.getExpression(d).isConstant() == FuzzyBoolean.YES) {
					 long coef = sch.getExpression(d).toAffine().getConstantTerm().getCoef();
					 order.add(coef);
				 } else {
					 order.add(null);
				 }
			}
			orderings.put(node, order);
		}
		
		orderingDims = new ArrayList<Integer>();
		{
			boolean first = true;
			for (PRDGNode node : prdg.getNodes()) {
				List<Long> order = orderings.get(node);
				List<Integer> orderingDim = new ArrayList<Integer>(order.size());
				for (int d = 0; d < order.size(); d++) {
					if (order.get(d) != null) {
						orderingDim.add(d);
					}
				}
				if (first) {
					orderingDims.addAll(orderingDim);
				} else {
					orderingDims.retainAll(orderingDim);
				}
				first = false;
			}
		}
	}
	
	/**
	 * Computes partitions of schedules based on prefixes of ordering.
	 * The result is stored in member variable orderingPartitions,
	 *  as a list of OrderingPrefixPartition instances.
	 *  
	 *  All possible partitions (all possible prefix of the ordering) are created.
	 */
	private void createOrderingPrefixPartition() {
		orderingPartitions = new LinkedList<OrderingPrefixPartition>();
		
		//default partition---the entire graph
		orderingPartitions.add(new OrderingPrefixPartition(new long[0], prdg.getNodes()));
		
		Map<long[], List<PRDGNode>> commonPrefixes = new TreeMap<long[], List<PRDGNode>>(new PrefixComparator());
		for (int d = 0; d < orderingDims.size(); d++) {
			for (PRDGNode node : orderings.keySet()) {
				List<Long> ordering = orderings.get(node);
				long[] prefix = new long[d+1];
				for (int i = 0; i <= d; i++) {
					prefix[i] = ordering.get(orderingDims.get(i)).longValue();
				}
				if (!commonPrefixes.containsKey(prefix)) {
					commonPrefixes.put(prefix, new LinkedList<PRDGNode>());
				}
				commonPrefixes.get(prefix).add(node);
			}
		}
		
		for (long[] prefix : commonPrefixes.keySet()) {
			orderingPartitions.add(new OrderingPrefixPartition(prefix, commonPrefixes.get(prefix)));
		}
	}
	
	/**
	 * Checks if an edge violates the condition for tiling.
	 * The result is stored in a member variable edgeTilability;
	 *  a Map from PRDGNode  to boolean vector.
	 * The boolean vector represents "tilability" of each dimension of the schedule.
	 * A dimension of the schedule is tilable with respect to an edge in the PRDG if
	 * the causality condition is weakly satisfied.
	 * 
	 */
	private void computeEdgeTilability() {
		edgeTilability = new HashMap<PRDGEdge, boolean[]>();

		//check sch_src(z) >= sch_dst(z') for each dimension of the schedule for every dependence edge E, src -> dst
		for (PRDGEdge edge : prdg.getEdges()) {
			//projection edges are ignored
			if (edge.getFunction() instanceof ProjectionFunction) continue;
			
			boolean[] tilable = new boolean[scheduleDims];
			//set every dimension to true in the beginning
			for (int d = 0; d < scheduleDims; d++) tilable[d] = true;
			
			for (int d = 0; d < scheduleDims; d++) {
				//ordering dimensions of the preceding 
				if (d> 0 && orderingDims.contains(d-1) && tilable[d-1]) {
					tilable[d] = true;
				} else {
					//sch_src(dom(E))@d < sch_dst(I(dom(E)))@d
					AbstractRelation rel = formulateIllegalCondition(edge, d);
					rel = rel.simplify();
	
					tilable[d] = rel.isEmpty();
					
					if (DEBUG && !tilable[d]) {
						debug("!empty: " + rel.toString(OUTPUT_FORMAT.ALPHABETS));
					}
				}
			}
			
			edgeTilability.put(edge, tilable);
		}
	}
	
	/**
	 * Computes tilability of each partition.
	 * A dimension of a schedule is tilable for a partition if
	 * all edges involving the nodes participating in the partition
	 * are tilable in the given dimension.
	 * 
	 */
	private void computePartitionTilability() {
		for (OrderingPrefixPartition partition : orderingPartitions) {
			partition.tilabile = new boolean[scheduleDims];
			for (int i = 0; i < scheduleDims; i++) {
				partition.tilabile[i] = true;
			}
			int partitionStartDim = (partition.prefix.length == 0)?0:orderingDims.get(partition.prefix.length-1)+1;
			if (partition.prefix.length > 0) {
				for (int i = 0; i < partitionStartDim; i++) {
					partition.tilabile[i] = false;
				}
			}
			
			for (PRDGNode node : partition.nodes) {
				for (PRDGEdge edge : node.getDestinations()) {
					if (partition.nodes.contains(edge.getDestination())) {
						for (int d = partitionStartDim; d < scheduleDims; d++) {
							partition.tilabile[d] &= edgeTilability.get(edge)[d];
						}
					}
				}
			}
		}
	}
	
	/**
	 * Constructs a relation formulating when tiling is not legal for a dimension of the schedule, with respect to an edge.
	 * 
	 * Given PRDGEdge E where dom(E) is the domain of the dependence (at source node),
	 * I is the dependence function, constructs a relation: 
	 *   dom(E) -> I(dom(E))
	 * then adds a constraint of the form:
	 *   schS(z)[dim] < schD(z')[dim] where schS and schD are respective schedules given to source and destination nodes, 
	 * z and z' are points in dom(E) and I(dom(E)) respectively,
	 * and [dim] denotes the dim-th dimension of the schedule.
	 * 
	 * @param edge
	 * @param dim
	 * @return
	 */
	private AbstractRelation formulateIllegalCondition(PRDGEdge edge, int dim) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
		
		AbstractRelation rel = edge.getFunction().getMapping().buildRelation(manager);
		rel = rel.intersectDomain(edge.getDomain());

		Function scheduleA = schedules.get(edge.getSource());
		Function scheduleB = schedules.get(edge.getDestination());
		IntExpression exprA = scheduleA.getExpression(dim);
		IntExpression exprB = scheduleB.getExpression(dim);
		

		for (int i = 0 ; i < rel.getNbInputs(); i++) {
			exprA = exprA.substitute(scheduleA.getDimensions().getIndices().get(i), rel.getDimensions().getInputs().get(i));
		}
		for (int i = 0 ; i < rel.getNbOutputs(); i++) {
			exprB = exprB.substitute(scheduleB.getDimensions().getIndices().get(i), rel.getDimensions().getOutputs().get(i));
		}

		
		if (DEBUG && dim == 0) {
			System.out.println(DEBUG_OUT_HEADER + toConciseString(edge) + " dependence relation: " + rel);
		}
		
		for (BasicRelation br : rel.getBasicRelations()) {
			IntConstraint constraint = constraint(exprA, exprB, ComparisonOperator.LT);
			br.getRelation().getConstraints().add(constraint);
		}

		
		if (DEBUG) {
			System.out.println(DEBUG_OUT_HEADER + toConciseString(edge) + " illegal condition@"+dim + ": " + rel);
		}
		
		return rel;
	}
	
	private List<TilableBand> createTilableBands() {
		List<TilableBand> bands = new ArrayList<TilableBand>(orderingPartitions.size());
		
		for (OrderingPrefixPartition partition : orderingPartitions) {
			//skip non-tilable partitions
			int num = 0;
			for (boolean b : partition.tilabile) {
				if (b) num++;
			}
			if (num == 0) continue;
			
			if (partition.prefix.length > 0) {
				bands.add(new TilableBand(orderingDims.get(partition.prefix.length-1)+1, partition.prefix, partition.tilabile));
			} else {
				bands.add(new TilableBand(0, partition.prefix, partition.tilabile));
			}
		}
		
		return bands;
	}
	

	private class OrderingPrefixPartition {
		private final long[] prefix;
		private final List<PRDGNode> nodes;
		private boolean[] tilabile;
		
		public OrderingPrefixPartition(long[] prefix, List<PRDGNode> nodes) {
			this.prefix = prefix;
			this.nodes = nodes;
		}
	}
	
	private class PrefixComparator implements Comparator<long[]> {
		@Override
		public int compare(long[] arg0, long[] arg1) {
			if (arg0.length != arg1.length) {
				return arg0.length - arg1.length;
			}
			
			int diff = 0;
			for (int i = 0; i < arg0.length; i++) {
				diff += (arg0[i] - arg1[i]) * ((i+1) * 10);
			}
			return diff;
		}
	}
	
	private String toConciseString(PRDGEdge edge) {
		return String.format("%s -> %s; %s", 
				edge.getSource().getName(), edge.getDestination().getName(), 
				edge.getFunction().getMapping().toString(OUTPUT_FORMAT.ALPHABETS));
	}

	String toStringList(long[] vec) {
		StringBuffer sb = new StringBuffer();
		
		for (long e : vec) {
			if (sb.length() > 0) sb.append(",");
			sb.append(e);
		}
		return sb.toString();
	}

	private String toStringList(boolean[] vec) {
		StringBuffer sb = new StringBuffer();
		
		for (boolean e : vec) {
			if (sb.length() > 0) sb.append(",");
			sb.append(e);
		}
		return sb.toString();
	}
}
