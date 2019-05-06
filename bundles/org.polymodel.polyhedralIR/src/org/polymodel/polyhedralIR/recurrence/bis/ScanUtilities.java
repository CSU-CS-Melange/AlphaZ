package org.polymodel.polyhedralIR.recurrence.bis;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.eclipse.xtext.xbase.lib.Pair;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

public class ScanUtilities {

	public static List<Long> getDepVector(AffineFunction af){
		assert(af.isUniform());
		
		List<Long> depVec = new Vector<Long>();
		
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

	public static long getGCD(List<Long> vec){
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
	
	public static AffineFunction retrieveDependence(Domain domain, List<Long> primitiveVector, Long gcd) {
		List<Long> constants = new ArrayList<Long>(primitiveVector.size());
		for (Long val : primitiveVector) {
			constants.add(val*gcd);
		}
		return PolyhedralIRUtility.createUniformFunction(domain, constants);
	}
	
	/**
	 * Returns a pair of primitive vector and gcd.
	 * Primitive vector is the input vector divided by the gcd.
	 * 
	 * @param depVector
	 * @return
	 */
	public static Pair<List<Long>, Long> getPrimitiveVector(List<Long> depVector) {
		List<Long> pVec = new ArrayList<>();
		long gcd = getGCD(depVector);
		
		for (Long val : depVector) {
			pVec.add(val / gcd);
		}
		
		return new Pair<>(pVec, gcd);
	}

	public static boolean isEquivalent(List<Long> vec1, List<Long> vec2){
		if(vec1.size() != vec2.size()) return false;
		for(int i = 0; i < vec1.size(); i++){
			if(vec1.get(i) != vec2.get(i))	return false;
		}
		
		return true;
	}
}
