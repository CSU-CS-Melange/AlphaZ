package org.polymodel.polyhedralIR.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

public class UniformnessResult {
	protected final PRDG prdg;
	protected final boolean embedded;
	protected final int maxDim;
	protected List<PRDGEdge> nonUniformEdges = new LinkedList<PRDGEdge>();
	protected List<PRDGEdge> nonIdempotentEdges = new LinkedList<PRDGEdge>();
	protected Map<PRDGEdge, Integer> dependenceRanks = new HashMap<PRDGEdge, Integer>();
	protected Map<PRDGEdge, List<Boolean>> uniformDimensionByEdges = new HashMap<PRDGEdge, List<Boolean>>();
	protected Map<PRDGNode, Set<PRDGEdge>> nonUniformEdgesByProducer = new HashMap<PRDGNode, Set<PRDGEdge>>();
	protected int maxDepRank = 0;
	protected List<Boolean> uniformDimensions;
	
	public static UniformnessResult create(PRDG prdg) {
		UniformnessResult res = new UniformnessResult(prdg);
		
		for (PRDGEdge edge : prdg.getEdges()) {
			res.registerDependence(edge);
		}

		return res;
	}
	
	public UniformnessResult(PRDG prdg) {
		this.prdg = prdg;
		
		if (prdg == null) {
			maxDim = 0;
			embedded = false;
		} else {
			int dim = -1;
			boolean isEmbedded = true;
			for (PRDGNode node : prdg.getNodes()) {
				if (dim == -1) {
					dim = node.getDomain().getNbIndices();
				} else {
					isEmbedded &= (dim == node.getDomain().getNbIndices());
					dim = Math.max(dim, node.getDomain().getNbIndices());
				}
			}
			maxDim = dim;
			embedded = isEmbedded;
		}

		uniformDimensions = new ArrayList<Boolean>(maxDim);
		for (int i = 0; i < maxDim; i++) {
			uniformDimensions.add(true);
		}
	}

	public boolean isUniform() {
		return embedded && nonUniformEdges.size() == 0;
	}

	public PRDG getPRDG() {
		return prdg;
	}
	
	public boolean isEmbedded() {
		return embedded;
	}
	
	public List<PRDGEdge> getNonUniformEdges() {
		return Collections.unmodifiableList(nonUniformEdges);
	}
	
	public Map<PRDGNode, Set<PRDGEdge>> getNonUniformEdgeByProducer() {
		return Collections.unmodifiableMap(nonUniformEdgesByProducer);
	}
	
	
	public Map<PRDGEdge, Integer> getDependenceRanks() {
		return Collections.unmodifiableMap(dependenceRanks);
	}
	
	private void registerDependence(PRDGEdge edge) {
		AffineFunction f = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(EcoreUtil.copy(edge.getFunction().getMapping()));
		int rank = UniformizationChecks.getDependenceRank(f);
		dependenceRanks.put(edge, rank);
		
		if (rank > 0) {
			nonUniformEdges.add(edge);
			maxDepRank = Math.max(maxDepRank, rank);
			
			//check for idempotence
			if (!UniformizationChecks.checkIdempotence(edge.getFunction().getMapping())) {
				nonIdempotentEdges.add(edge);
			}
			//check uniformness of each dimension
			{
				Matrix mat = edge.getFunction().getMapping().toMatrix();
				List<Boolean> uniformness = new ArrayList<Boolean>(maxDim);
				for (int r = 0; r < mat.getNbRows(); r++) {
					MatrixRow row = mat.getRows().get(r);
					boolean uniform = true;
					int targetColumn = r + edge.getDomain().getNbParams();
					for (int c = 0; c < row.getValues().size()-1; c++) {
						if (c == targetColumn && row.get(c) != 1) {
							uniform = false;
							break;
						} else if (c != targetColumn && row.get(c) != 0) {
							uniform = false;
							break;
						}
					}
					uniformness.add(uniform);
				}
				uniformDimensionByEdges.put(edge, uniformness);
				
				//take element-wise and with the global uniformness
				for (int d = 0 ; d < uniformDimensions.size(); d++) {
					boolean uniform = uniformDimensions.get(d) && uniformness.get(d);
					uniformDimensions.set(d, uniform);
				}
			}

			//edges
			{
				if (!nonUniformEdgesByProducer.containsKey(edge.getDestination())) {
					nonUniformEdgesByProducer.put(edge.getDestination(), new HashSet<PRDGEdge>());
				}
				Set<PRDGEdge> edges = nonUniformEdgesByProducer.get(edge.getDestination());
				edges.add(edge);
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("UniformnessResult\n");
		sb.append("\tembedded: " + embedded + "\n");
		
		if (embedded) {
			sb.append("\tuniform dimensions: " + uniformDimensions + "\n");
			sb.append("\t#non-uniform edges: " + nonUniformEdges.size() + "\n");
			sb.append("\t#Q != Q.Q edges: " + nonIdempotentEdges.size() + "\n");
			sb.append("\tmaximum dependence rank: " + maxDepRank + "\n");
			for (PRDGEdge edge : nonUniformEdges) {
				final String idempotence = (nonIdempotentEdges.contains(edge))?"Q!=Q.Q":"Q=Q.Q";
				sb.append("\t"+ String.format("%s->%s %s rank:%d %s, %s, @ %s ", 
						edge.getSource().getName(), edge.getDestination().getName(),
						uniformDimensionByEdges.get(edge),
						dependenceRanks.get(edge), idempotence,
						edge.getFunction().getMapping(), edge.getDomain()) + "\n");
			}
		}
		
		return sb.toString();
	}
	
}