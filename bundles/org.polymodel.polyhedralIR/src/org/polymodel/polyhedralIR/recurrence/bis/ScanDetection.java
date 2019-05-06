package org.polymodel.polyhedralIR.recurrence.bis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.transformation.Inline;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.PRDGAdapterComponent;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;

import fr.irisa.cairn.graph.INode;
import fr.irisa.cairn.graph.analysis.GraphAnalysis;

/**
 * ScanDetection using Yun's method based on State-Vector Update form.
 * This class implements pre-processing and analysis of the PRDG to
 * identify recurrences (SCCs) in PRDGs. The conversion is performed
 * in MatrixFormTransform class.
 * 
 * The original implementation had support for lexicographic scans,
 * but it is not implemented in this version.
 * 
 * @see MatrixFormTransform
 * 
 * @author tyuki
 *
 */
public class ScanDetection {
	public static boolean DEBUG = false;
	
//	/private static final PolyhedralIRUserFactory polyIRfact = PolyhedralIRUserFactory.eINSTANCE;
	
	protected AffineSystem _system;
	protected List<StateVectorUpdateForm> _scans;
	protected List<List<PRDGNode>> _sccs;
	
	protected ScanDetection(AffineSystem system){
		_system = system;
	}
	
	public static List<StateVectorUpdateForm> detect(AffineSystem s){
		ScanDetection sd = new ScanDetection(s);
		return sd.detect();
	}
	
	private static void debug(Object content) {
		if (DEBUG) {
			System.out.println("[ScanDetection] " + content);
		}
	}
	
	protected List<StateVectorUpdateForm> detect() {
		//pre-processing
		preProcessing();
		
		debug("SCCs found: " + _sccs.size());
		
		_scans = new LinkedList<StateVectorUpdateForm>();
		
		//For each component
		for (List<PRDGNode> scc : _sccs) {
			
			debug("Computing scan domain of SCC: " + sccToString(scc));
			
			Domain scanDom = computeScanDomain(scc);
			
			//null if it is obviously not a scan 
			if (scanDom == null)
				continue;
			
			debug("Sending to MatrixFormTransformation");
			
//			//For each component do scan detection
			StateVectorUpdateForm scan = MatrixFormTransformation.extract(_system, scc, scanDom);
			if (scan != null) {
				_scans.add(scan);

				debug("Successfuly extracted matrix form");
				if (DEBUG)
					scan.ScanInfoPrint("[ScanInfo] ", System.out);
			}

		}
		
		return _scans;
	}
	
	/**
	 * Compute scan domain (not sure what it is) FIXME
	 * 
	 * @param scc
	 * @return null if SCC cannot be a scan
	 */
	protected Domain computeScanDomain(List<PRDGNode> scc) {
		
		List<PRDGEdge> sccEdges = new LinkedList<PRDGEdge>();
		for (PRDGNode node : scc) {
			sccEdges.addAll(restrictEdgesToSCC(node.getDestinations(), scc));
		}
		
		//single node SCC case
		if (scc.size() == 1) {
			PRDGNode node = scc.get(0);
			VariableDeclaration var = _system.getVariableDeclaration(node.getName());
			
			//an input variable, no need for checking
			if(_system.getInputs().contains(var)){
				debug("   single node SCC of input variable; not a scan");
				return null;
			}
			
			if (sccEdges.size() == 0) {
				debug("   single node SCC of output variable; not a scan");
				return null;
			}

//=======================================
//  replaced by the code outside if
//=======================================
//			scanDomain = PolyhedralIRUserFactory.eINSTANCE.createDomain(EcoreUtil.copy(prev.get(0).getDomain()));
//=======================================
		} else {
			//check if multi-node SCC share the same dependence direction
			//This check is done in MatrixFormTransform, should be no reason to do it here
			// FIXME confirm and delete the following
//			List<Long> commonDir = null;
//			
//			for (PRDGNode node : scc) {
//				for (PRDGEdge edge : node.getDestinations()) {
//					if (scc.contains(edge.getDestination())) {
//						if (!edge.getFunction().getMapping().isUniform()) {
//							debug("   non-uniform recurrence; not a scan");
//							return null;
//						}
//						List<Long> dVec = ScanUtilities.getDepVector(PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(edge.getFunction().getMapping()));
//						List<Long> pVec = ScanUtilities.getPrimitiveVector(dVec).getKey();
//						if (commonDir == null) {
//							commonDir = pVec;
//						} else {
//							if (!ScanUtilities.isEquivalent(pVec, commonDir)) {
//								debug("   dependences are not uni-directional; not a scan");
//								return null;
//							}
//						}
//					}
//							
//				}
//			}
//			
			

//=======================================
//  replaced by the code outside if
//=======================================
//			//construct the new edge list 
//			Map<PRDGNode, List<PRDGEdge>> srcEdgeMap = new HashMap<PRDGNode, List<PRDGEdge>>();
//			//get the dependence edges for each node
//			for (PRDGNode srcNode : scc) {
//				List<PRDGEdge> prev = ScanUtilities.getSourceEdgeInSCC(srcNode, scc);
//				srcEdgeMap.put(srcNode, prev);
//			}
//			
//			//FIXME not sure why this works
//			scanDomain = PolyhedralIRUserFactory.eINSTANCE.createDomain(EcoreUtil.copy(srcEdgeMap.get(scc.get(0)).get(0).getDomain()));
//=======================================
		}
		
		List<PRDGEdge> edgeNoEq = removeEdgesWithEqualities(sccEdges);
		
		if (edgeNoEq.size() == 0) {
			debug("   all domains have equalities; no scan domain found");
			return null;
		}
		
		org.polymodel.Domain scanDomain = null;
		for (PRDGEdge edge : edgeNoEq) {
			if (scanDomain == null) {
				scanDomain = edge.getDomain();
			} else {
				if (!scanDomain.equivalence(scanDomain)) {
					debug("   umbiguous scanDomains: " + scanDomain + " " + edge.getDomain());
				}
			}
		}
		
		return  PolyhedralIRUserFactory.eINSTANCE.createDomain(EcoreUtil.copy(scanDomain));
	}
	
	/**
	 * Initialize the main data structures used in detection.
	 * Builds PRDG and SCCs.
	 * 
	 */
	protected void computeSCC() {
		PRDG prdg = PRDGBuilder.build(_system);
		IPRDGAdapter adaptedprdg = PRDGAdapterComponent.INSTANCE.build(prdg);
		List<Set<INode>> sccs = GraphAnalysis.findStronglyConnectedSets(adaptedprdg);
	
		_sccs = new ArrayList<List<PRDGNode>>(sccs.size());
		for (Set<INode> scc : sccs) {
			//retrieve the adapted nodes
			List<PRDGNode> sccNodes = new ArrayList<PRDGNode>(scc.size());
			for (INode node : scc) {
				sccNodes.add(((IPRDGNodeAdapter)node).getAdaptedNode());
			}
			
			//Sort by name
			Collections.sort(sccNodes, new Comparator<PRDGNode>(){
				@Override
				public int compare(PRDGNode o1, PRDGNode o2) {
					return o1.getName().compareTo(o2.getName());
				}}
			);
			
			_sccs.add(sccNodes);
		}
		
	}

	/**
	 * PreProcessing stage: used to remove the dependence edges with non-uniform dependence with each SCC
	 * @return
	 */
	protected void preProcessing(){
		//Build PRDG and SCCs
		computeSCC();

		//TODO do not understand why the following is OK
		//shouldn't affine dependences on input still show up in the coefficient matrix?
		//  when re-introduced, it has to be repated after each call to computeSCC
		//  should be made part of it perhaps
		
		//Process each SCC found
//		for (List<PRDGNode> scc : _sccs) {
//			for (PRDGNode node : scc) {
//				//dependence on input variable can be ignored
//				if(_system.getInputs().contains(_system.getVariableDeclaration(node.getName()))){
//					continue;
//				}
//				List<PRDGEdge> dstEdges = ScanUtilities.getDestinationEdgeInSCC(node, scc);
//				List<PRDGEdge> rmEdges = new LinkedList<>();
//				for (PRDGEdge dstEdge : dstEdges) {
//					if (!dstEdge.getFunction().getMapping().isUniform()) {
//						rmEdges.add(dstEdge);
//					}
//				}
//				_prdg.getEdges().removeAll(rmEdges);
//			
//			}
//		}
		boolean transformed = false;
		for (List<PRDGNode> scc : _sccs) {
			if (scc.size() > 1)
				transformed |= normalizeMultiNodeSCC(scc);
		}
		
		//recompute PRDG and SCC if necessary
		if (transformed)
			computeSCC();
	}

	/**
	 * When SCC involves multiple nodes, this method is used to inline
	 * statements to remove identity dependence among the nodes in SCC.
	 * This is a pre-processing step to ensure all dependences are 
	 * uni-directional, which is necessary for it to be a recurrence.
	 * 
	 * The method first populates a boolean matrix M where i,j-th element
	 * is true if node i depends on j with identity dependence. Then
	 * Inline transformation is called to inline j into i if 
	 * M[i,j] is true and M[j,i] is false.
	 * 
	 * @see Inline
	 * 
	 * @param scc
	 */
	private boolean normalizeMultiNodeSCC(List<PRDGNode> scc){
		
		final int N = scc.size();
		boolean[][] dependsByIdentity = new boolean[N][N];
		
		for (int a=0; a<N; a++) {
			for (int b=a+1; b<N; b++) {
				PRDGNode nodeA = scc.get(a);
				PRDGNode nodeB = scc.get(b);
				
				for (PRDGEdge a2b : nodeA.getDestinations()) {
					if (a2b.getDestination().equals(nodeB) && 
						a2b.getFunction().getMapping().isIdentity()) {
						dependsByIdentity[a][b] = true;	
						break;
					}
				}
				
				for (PRDGEdge b2a : nodeB.getDestinations()) {
					if (b2a.getDestination().equals(nodeA) && 
						b2a.getFunction().getMapping().isIdentity()) {
						dependsByIdentity[b][a] = true;
						break;
					}
				}
			}
		}
		
		boolean transformed = false;
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				if (a == b) continue;
				
				if (dependsByIdentity[a][b] && !dependsByIdentity[b][a]) {
					StandardEquation targetEq = _system.getEquation(scc.get(a).getName());
					StandardEquation inlineEq = _system.getEquation(scc.get(b).getName());
					Inline.transform(targetEq, inlineEq, true);
					transformed = true;
				}
			}
		}
		
		if (transformed)
			Normalize.normalize(_system);
		
		return transformed;
	}
	

	
	/**
	 * Restricts the list of edges to edges within the SCC
	 * 
	 * @param dst
	 * @param nodes
	 * @return
	 */
	public static List<PRDGEdge> restrictEdgesToSCC(List<PRDGEdge> edges, List<PRDGNode> scc) {
		List<PRDGEdge> restricted = new LinkedList<PRDGEdge>();
		
		for (PRDGEdge edge : edges) {
			if (scc.contains(edge.getDestination()) && scc.contains(edge.getSource())) {
				restricted.add(edge);
			}
		}
		
		return restricted;
	}

	private static String sccToString(List<PRDGNode> scc) {
		List<String> sccNames = new ArrayList<String>(scc.size());
		
		for (PRDGNode node : scc) {
			sccNames.add(node.getName());
		}
		
		return sccNames.toString();
	}
	
	private static List<PRDGEdge> removeEdgesWithEqualities(List<PRDGEdge> edges) {
		List<PRDGEdge> noEqEdges = new LinkedList<PRDGEdge>();
		
		for (PRDGEdge edge : edges) {
			if (edge.getDomain().affineHull().isUniverse()) {
				noEqEdges.add(edge);
			}
		}
		
		return noEqEdges;
	}
}
