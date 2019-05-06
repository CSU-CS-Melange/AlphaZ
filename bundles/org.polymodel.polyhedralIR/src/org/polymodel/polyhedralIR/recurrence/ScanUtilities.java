package org.polymodel.polyhedralIR.recurrence;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

public class ScanUtilities {

	public static Vector<Long> GetDepVector(AffineFunction af){
		assert(af.isUniform());
		
		System.out.println("get dependence vector for affine function: " + af);
		Vector<Long> depVec = new Vector<Long>();
		
		for (int d = 0; d < af.getDimRHS(); d++) {
			//get the d-th term
			//AffineTerm term = af.getExpressions().get(d).getTerm(af.getIndices().get(d));
			AffineTerm term = af.getExpressions().get(d).getConstantTerm();
			if (term != null) {
				long val = -term.getCoef();
				depVec.add(val);
			} else {
				depVec.add(0L);
			}
		}
		
		return depVec;
	}

	public static long GetGcd(Vector<Long> vec){
		long vec_gcd = 0;
		
		if(vec.size() == 1){
			vec_gcd = vec.get(0);
		}else if(vec.size() > 1){
			vec_gcd = ScanUtilities.gcd(vec.get(0), vec.get(1));
			for(int i = 2; i < vec.size(); i++){
				vec_gcd = ScanUtilities.gcd(vec_gcd, vec.get(i));
			}
		}
		
		return vec_gcd;
	}

	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
	public static boolean VectorEqual(Vector<Long> vec1, Vector<Long> vec2){
		if(vec1.size() != vec2.size()) return false;
		for(int i = 0; i < vec1.size(); i++){
			if(vec1.get(i) != vec2.get(i))	return false;
		}
		
		return true;
	}
	
	/**
	 * Get the the list of prdg edges whose destination is dst for a strongly connected component, edges and nodes are the edges and nodes in the SCC.
	 * @param dst
	 * @param edges
	 * @param nodes
	 * @return
	 */
	public static List<PRDGEdge> getDestinationEdgeInSCC(PRDGNode dst, List<PRDGEdge> edges, List<PRDGNode> nodes){
		if(edges == null){
			System.out.println("There is no such edge ends with node " + dst);
			return null;
		}
		
		List<PRDGEdge> dstEdges = new BasicEList<PRDGEdge>();
		
		for(int i = 0; i < edges.size(); i++){
			PRDGEdge edge = edges.get(i);
			if(edge.getDestination().equals(dst)){
				if(nodes.contains(edge.getSource())){
					dstEdges.add(edge);
				}
			}
		}
		
		return dstEdges;
	}
	
	/**
	 * get the list of prdg edges whose source is src for a strongly connected component.
	 * @param src
	 * @param edges: The edges in the strongly connected component (SCC)
	 * @param nodes: The nodes in the strongly connected component (SCC)
	 * @return
	 */
	public static List<PRDGEdge> getSourceEdgeInSCC(PRDGNode src, List<PRDGEdge> edges, List<PRDGNode> nodes){
		if(edges == null){
			System.out.println("There is no such edge starts with node " + src);
			return null;
		}
		
		List<PRDGEdge> srcEdges = new BasicEList<PRDGEdge>();
		
		for(int i = 0; i < edges.size(); i++){
			PRDGEdge edge = edges.get(i);
			if(edge.getSource().getName().contentEquals(src.getName())){
				if(nodes.contains(edge.getDestination())){
					srcEdges.add(edge);
				}
			}
		}
		
		return srcEdges;
	}

}
