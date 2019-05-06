/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.tom.ConstantIntExpression;
import org.polymodel.algebra.tom.EquivalentIntExpression;
import org.polymodel.algebra.tom.SimplifyIntExpression;
import org.polymodel.algebra.tom.ZeroIntExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Int Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class IntExpressionImpl extends EObjectImpl implements IntExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgebraPackage.Literals.INT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FuzzyBoolean isEquivalent(IntExpression other) {
		return EquivalentIntExpression.isEquivalent(this.simplify(), other.simplify());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FuzzyBoolean isConstant() {
		return ConstantIntExpression.isConstant(this.simplify());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FuzzyBoolean isZero() {
		return ZeroIntExpression.isZero(this.simplify());
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */ 
	public IntExpression simplify() {
		return SimplifyIntExpression.simplify(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression substitute(Variable substituted, Variable newVar) {
		throw new UnsupportedOperationException("Cannot (yet) substitute "+substituted+" by "+newVar+" in "+this+" (of type "+this.getClass().getSimpleName()+")");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression substitute(Variable substituted, IntExpression newExpr) {
		throw new UnsupportedOperationException("Cannot (yet) substitute "+substituted+" by "+newExpr+" in "+this+" (of type "+this.getClass().getSimpleName()+")");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineExpression toAffine() {
		IntExpression res=  SimplifyIntExpression.simplify(this.copy());
		if(res instanceof AffineExpression) return (AffineExpression) res;
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public QuasiAffineExpression toQuasiAffine() {
		IntExpression res=  this.simplify();
		if(res instanceof QuasiAffineExpression) return (QuasiAffineExpression) res;
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PolynomialExpression toPolynomial() {
		IntExpression res=  this.simplify();
		if(res instanceof PolynomialExpression) return (PolynomialExpression) res;
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ReductionExpression toReduction() {
		IntExpression res=  this.simplify();
		if(res instanceof ReductionExpression) return (ReductionExpression) res;
		return null;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void accept(AlgebraVisitor visitor); 

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlgebraPackage.INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION:
				return isEquivalent((IntExpression)arguments.get(0));
			case AlgebraPackage.INT_EXPRESSION___SIMPLIFY:
				return simplify();
			case AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE:
				return substitute((Variable)arguments.get(0), (Variable)arguments.get(1));
			case AlgebraPackage.INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION:
				return substitute((Variable)arguments.get(0), (IntExpression)arguments.get(1));
			case AlgebraPackage.INT_EXPRESSION___TO_AFFINE:
				return toAffine();
			case AlgebraPackage.INT_EXPRESSION___TO_QUASI_AFFINE:
				return toQuasiAffine();
			case AlgebraPackage.INT_EXPRESSION___TO_POLYNOMIAL:
				return toPolynomial();
			case AlgebraPackage.INT_EXPRESSION___TO_REDUCTION:
				return toReduction();
			case AlgebraPackage.INT_EXPRESSION___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
			case AlgebraPackage.INT_EXPRESSION___COPY:
				return copy();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T extends IntExpression> T copy() {
		Copier copier = new Copier();
		@SuppressWarnings("unchecked")
		T  res = (T) copier.copy(this);
		copier.copyReferences();
		return res;
	}

} //IntExpressionImpl
