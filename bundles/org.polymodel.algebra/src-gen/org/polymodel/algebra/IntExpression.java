/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra;

import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.reductions.ReductionExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.algebra.AlgebraPackage#getIntExpression()
 * @model abstract="true"
 * @generated
 */
public interface IntExpression extends AlgebraVisitable {
	/**
	 * <!-- begin-user-doc -->
	 * Returns true if the two expressions are equivalent.
	 * Currently, it is NOT guaranteed to detect all cases where two expressions are equivalent.
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	FuzzyBoolean isEquivalent(IntExpression other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	IntExpression simplify();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" substitutedRequired="true" newVarRequired="true"
	 * @generated
	 */
	IntExpression substitute(Variable substituted, Variable newVar);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" substitutedRequired="true" newExprRequired="true"
	 * @generated
	 */
	IntExpression substitute(Variable substituted, IntExpression newExpr);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	AffineExpression toAffine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	QuasiAffineExpression toQuasiAffine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	PolynomialExpression toPolynomial();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ReductionExpression toReduction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	<T extends IntExpression> T copy();

	FuzzyBoolean isZero();

	FuzzyBoolean isConstant();


} // IntExpression
