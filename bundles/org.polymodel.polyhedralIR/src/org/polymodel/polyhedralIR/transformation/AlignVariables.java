package org.polymodel.polyhedralIR.transformation;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constant;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

public class AlignVariables {
	
	public static boolean DEBUG = false;
	
	private void debug(Object content) {
		if (DEBUG)
			System.out.println("[AlignVariables] " + content);
	}
	
	public static void apply(AffineSystem system) {
		AlignVariables av = new AlignVariables(system);
		av.align();
	}
	

	protected final AffineSystem targetSystem;
	
	protected AlignVariables(AffineSystem targetSystem) {
		this.targetSystem = targetSystem;
	}
	
	private void align() {
		FindEmbeddingTransforms fet = new FindEmbeddingTransforms();
		fet.find();
	}
	
	protected class FindEmbeddingTransforms {
		protected Map<PRDGNode, AffineFunction> transforms = new HashMap<>();
		protected int maxDim;
		protected Map<PRDGNode, Integer> maxTrueDim = new HashMap<>();
		protected Map<PRDGEdge, Integer> numEqualities = new HashMap<>();
		
		protected FindEmbeddingTransforms() {
		}
		
		protected void find() {
			PRDG prdg = PRDGBuilder.build(targetSystem, true);
			
			List<PRDGNode> nodes = new ArrayList<PRDGNode>(prdg.getNodes().size());
			nodes.addAll(prdg.getNodes());
			assert(nodes.size() > 0);
			
			//sort by descending order of number of dimensions
			Collections.sort(nodes, new Comparator<PRDGNode>() {
				@Override
				public int compare(PRDGNode o1, PRDGNode o2) {
					return o2.getDomain().getNbIndices() - o1.getDomain().getNbIndices();
				}
			
			});
			
			maxDim = nodes.get(0).getDomain().getNbIndices();
			
			for (PRDGNode node : prdg.getNodes()) {
				int minNbEq = 999;
				for (PRDGEdge edge : node.getDestinations()) {
					//edge.getDomain().detectEqualities().getDimensions()
					org.polymodel.Domain affineHull = edge.getDomain().affineHull();
					int nbEq = affineHull.getPolyhedra().get(0).getConstraints().size();
					if (nbEq < minNbEq) {
						minNbEq = nbEq;
					}
					numEqualities.put(edge, nbEq);
				}
				maxTrueDim.put(node, node.getDomain().getIndices().size() - minNbEq);
			}
			
			debug("===Filling Transforms Using Dataflow===");
						
			//fill transforms that can be deduced from look at variables that depend on the maximum deps first
			for (PRDGNode node : nodes) {
				if (node.getDomain().getNbIndices() == maxDim) {
					fillTransformUsingDataflow(node, new LinkedList<PRDGNode>());	
				}
			}

			debug("===Filling Transforms Using Dependence===");
			
			//then consider other variables where the edges must be followed in the other direction (higher dimensional -> lower dimensional)
			for (PRDGNode node : nodes) {
				if (node.getDomain().getNbIndices() == maxDim) {
					fillTransformUsingDependence(node, new LinkedList<PRDGNode>());	
				}
			}

			debug("===Filling Remaining Nodes===");
			
			//then consider other variables where the edges must be followed in the other direction (higher dimensional -> lower dimensional)
			for (PRDGNode node : nodes) {
				if (transforms.get(node) == null) {
					fillTransformOfRemainingNode(node);	
				}
			}
			
		
			
			for (PRDGNode node : nodes) {
				if (transforms.get(node) != null) {
					ChangeOfBasis.CoB(targetSystem, node.getName(), transforms.get(node), true);
				}
			}
			
			Normalize.normalize(targetSystem);
			UniformizeInContext.apply(targetSystem);
//			System.out.println(AShow.toSimplifiedString(targetSystem));
		}
		
		/**
		 * If an affine transform is already found for the node, returns the number of dimensions in its RHS.
		 * Returns the number of dimensions of the domain otherwise.
		 * 
		 * @param node
		 * @return
		 */
		private int nodeEffectiveDim(PRDGNode node) {
			//if no transform is found of the target node yet, use its domain
			if (transforms.get(node) == null) {
				return node.getDomain().getNbIndices();
			//otherwise use RHS of the transform
			} else {
				return transforms.get(node).getDimRHS();
			}
		}
		
		/**
		 * Fills transforms for all nodes that depend on the given node.
		 * This method should be invoked for the nodes with highest dimensions only.
		 * 
		 * @param producer
		 */
		protected void fillTransformUsingDataflow(PRDGNode producer, List<PRDGNode> visitedNodes) {
			//base case
			if (visitedNodes.contains(producer)) return;
			visitedNodes.add(producer);
			
			
			//get all nodes that depend on this node
			for (PRDGEdge edge : producer.getSources()) {
				int trueDim = maxTrueDim.get(edge.getSource());
				int edgeEqs = numEqualities.get(edge);
				
				if (trueDim > edge.getDomain().getNbIndices() - edgeEqs) continue;
				
				PRDGNode consumer = edge.getSource();
				
				//skip self dependence
				if (consumer.equals(producer)) continue;
								
				//ignore node that already has a transform
				if (transforms.get(consumer) != null) continue;

				//ignore other nodes with the same or higher dimension
				if (consumer.getDomain().getNbIndices() > producer.getDomain().getNbIndices()) continue;
				
				debug(producer.getName() +" <- " + consumer.getName() +": ") ;

				AffineFunction edgeFunc =  PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(edge.getFunction().getMapping().uniformizeInContext(edge.getDomain()));
				
				if (transforms.get(producer) == null) {
					transforms.put(consumer, edgeFunc);
					
					debug(edgeFunc);
				} else {
					AffineFunction transitive = transforms.get(producer).compose(edgeFunc);
					transforms.put(consumer, transitive);

					debug(transitive + " = " + transforms.get(producer) + " o " + edgeFunc);
				}
				
				//Recurse
				fillTransformUsingDataflow(consumer, visitedNodes);
			}
		}
		

		protected void fillTransformUsingDependence(PRDGNode consumer, List<PRDGNode> visitedNodes) {
			//base case
			if (visitedNodes.contains(consumer)) return;
			visitedNodes.add(consumer);
			
//			DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);

			int targetDim = consumer.getDomain().getNbIndices();
			
			//get all nodes that this node depends on
			for (PRDGEdge edge : consumer.getDestinations()) {
				PRDGNode producer = edge.getDestination();
				
				//skip self dependence
				if (producer.equals(consumer)) continue;
				
				//ignore node that already has a transform
				if (transforms.get(producer) != null) continue;

				//ignore other nodes with the same or higher dimension
				if (producer.getDomain().getNbIndices() > consumer.getDomain().getNbIndices()) continue;

				debug(consumer.getName() + " -> " + producer.getName()+": ");
				
				AffineFunction transform = guessTransformForProducer(producer);
			
				if (transforms.get(consumer) == null) {
					transforms.put(producer, transform);
					
					debug(transform);
				} else {
					AffineFunction transitive = transforms.get(consumer).compose(transform);
					transforms.put(producer, transitive);

					debug(transitive + " = " + transforms.get(edge.getSource()) + " o " + transform);
				}

				//Recurse
				fillTransformUsingDependence(producer, visitedNodes);
			}
		}
		
		protected void fillTransformOfRemainingNode(PRDGNode node) {
			//nothing to do with the highest dim nodes
			if (node.getDomain().getNbIndices() == maxDim) return;
			
			
			
			//currently, fill with 0s
			List<AffineExpression> exprs = new ArrayList<AffineExpression>(maxDim);
			for (int i = 0; i < node.getDomain().getNbIndices(); i++) {
				exprs.add(affine(term(node.getDomain().getIndices().get(i))));
			}
			for (int i = node.getDomain().getNbIndices(); i < maxDim; i++) {
				exprs.add(constant(0).toAffine());
			}
			AffineFunction transform = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(
					node.getDomain().getParams(), node.getDomain().getIndices(), exprs);
			
			transforms.put(node, transform);

			debug(node.getName() +": " + transform);
		}
		
		protected AffineFunction guessTransformForProducer(PRDGNode producer) {
			final int targetDim;
			List<PRDGEdge> targetDimEdges = new LinkedList<PRDGEdge>();
			{
				int maxD = 0;
				for (PRDGEdge edge : producer.getSources()) {
					maxD = Math.max(maxD, edge.getSource().getDomain().getNbIndices());
				}
				targetDim = maxD;
				for (PRDGEdge edge : producer.getSources()) {
					if (edge.getSource().getDomain().getNbIndices() == targetDim) {
						targetDimEdges.add(edge);
					}
				}
			}
			
			//compute permutations
			{

				for (PRDGEdge edge : targetDimEdges) {
					Matrix mat = edge.getFunction().getMapping().linearPart();

//					System.out.println(edge);
//					System.out.println(mat);
					List<double[][]> gauss = MatrixOperations.gaussRow(MatrixOperations.toDoubleMatrix(mat.toLongArray()));
					
					double[][] G = gauss.get(0);
					double[][] U = gauss.get(1);
					int rank = gauss.get(2)[0].length;
//					MatrixOperations.printMatrix(U);
//					System.out.println();
//					MatrixOperations.printMatrix(G);
//					System.out.println();
				}
			}
			
			//compute the common ns
			Matrix nsbasis;
			{
				Matrix functions = null;
				for (PRDGEdge edge : targetDimEdges) {
					Matrix mat = edge.getFunction().getMapping().linearPart();
					if (functions == null) {
						functions = mat;
					} else {
						functions.getRows().addAll(mat.getRows());
					}
				}
				nsbasis = functions.nullspace();
				if (nsbasis.getNbCols() != 0) {
					nsbasis = nsbasis.transpose();
				}
			}
			
			Set<Integer> invariantDims = new TreeSet<Integer>();
			for (MatrixRow basis : nsbasis.getRows()) {
				int nonZeroIndex = -1;
				//check if there is only one non-zero and then also find its index
				for (int i = 0; i < basis.getSize(); i++) {
					if (basis.get(i) != 0) {
						if (nonZeroIndex == -1) {
							nonZeroIndex = i;
						} else {
							nonZeroIndex = -1;
							break;
						}
					}
				}
				if (nonZeroIndex != -1) {
					//subtract params, since the basis vector contains them
					invariantDims.add(nonZeroIndex - producer.getDomain().getNbParams());
				}
			}
			
			List<AffineExpression> exprs = new ArrayList<AffineExpression>(targetDim);
			int currentProducerDim = 0;
			//skip invariant dimes and use the index for the rest
			for (int i = 0; i < targetDim; i++) {
				if (invariantDims.contains(i) || currentProducerDim >= producer.getDomain().getNbIndices()) {
					exprs.add(constant(0).toAffine());
				} else {
					exprs.add(affine(term(producer.getDomain().getIndices().get(currentProducerDim))));
					currentProducerDim++;
				}
			}
			AffineFunction transform = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(
					producer.getDomain().getParams(), producer.getDomain().getIndices(), exprs);
			
			return transform;
		}
		
//		/**
//		 * Finds an affine transform for embedding the given node.
//		 * 
//		 * @param embedNode
//		 * @return
//		 */
//		protected AffineFunction find(PRDGNode embedNode) {
//			int destMax = -1;
//			for (PRDGEdge edge : embedNode.getDestinations()) {
//				destMax = Math.max(destMax, nodeEffectiveDim(edge.getDestination()));
//			}
//			//if the destination node is not higher than the node to embed, then no need for embedding
//			if (destMax == -1 || destMax <= embedNode.getDomain().getNbIndices()) {
//				return null;
//			}
//			
//			//otherwise, embed to match dependent nodes with highest dimension
//			List<PRDGEdge> embedTargets = new LinkedList<PRDGEdge>();
//
//			for (PRDGEdge edge : embedNode.getDestinations()) {
//				if (nodeEffectiveDim(edge.getDestination()) == destMax) {
//					embedTargets.add(edge);
//				}
//			}
//			
//			PRDGEdge cand = embedTargets.get(0);
//			AffineFunction edgeFunc =  PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(cand.getFunction().getMapping());
//			
//			if (transforms.get(cand.getDestination()) == null) {
//				return edgeFunc;
//			} else {
//				return transforms.get(cand.getDestination()).compose(edgeFunc);
//			}
//		}
	}
}
