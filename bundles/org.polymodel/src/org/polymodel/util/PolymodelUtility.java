package org.polymodel.util;

import org.polymodel.Function;
import org.polymodel.IndexDimension;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;

public class PolymodelUtility {

	public static boolean isUniform(Function f) {
		if (f.getDimensions().getIndices().size() != f.getExpressions().size()) {
			return false;
		}
		
		//implemented in 5min. probably not very robust
		for (int i = 0; i < f.getDimensions().getIndices().size(); i++) {
			Variable iv = f.getDimensions().getIndices().get(i);
			//check that index dimension is correct
			if (iv instanceof IndexDimension) {
				if (((IndexDimension)iv).getDimension() != i) {
					throw new RuntimeException("Assumes indices are ordered.");
				}
			}
			//the expression should be affine
			AffineExpression ie = f.getExpression(i).copy().toAffine();
			
			boolean found = false;
			for (AffineTerm term : ie.getTerms()) {
				if (term.getVariable() != null) {
					if ( term.getVariable().equals(iv)) {
						found = true;
					} else if (term.getCoef() != 0) {
						return false;
					}
				}
			}

			//var must be used once
			if (!found) return false;
		}
		return true;
	}
	
	
	
}
