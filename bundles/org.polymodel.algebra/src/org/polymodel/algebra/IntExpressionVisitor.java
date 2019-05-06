package org.polymodel.algebra;

import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.reductions.ReductionExpression;

public interface IntExpressionVisitor {

	public void visitAffineExpression(AffineExpression e);
	public void visitQuasiAffineExpression(QuasiAffineExpression e);
	public void visitReductionExpression(ReductionExpression e);
	public void visitPolynomialExpression(PolynomialExpression e);
}
