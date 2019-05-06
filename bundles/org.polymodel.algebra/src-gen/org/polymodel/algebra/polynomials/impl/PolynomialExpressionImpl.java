/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.polynomials.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.impl.IntExpressionImpl;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.polynomials.PolynomialsPackage;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Polynomial Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.polynomials.impl.PolynomialExpressionImpl#getTerms <em>Terms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PolynomialExpressionImpl extends IntExpressionImpl implements PolynomialExpression {
	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	protected EList<PolynomialTerm> terms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolynomialExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolynomialsPackage.Literals.POLYNOMIAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PolynomialTerm> getTerms() {
		if (terms == null) {
			terms = new EObjectContainmentEList<PolynomialTerm>(PolynomialTerm.class, this, PolynomialsPackage.POLYNOMIAL_EXPRESSION__TERMS);
		}
		return terms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitPolynomialExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isAffine() {
		boolean isAffine = true;
		for (PolynomialTerm term : getTerms()) {
			isAffine &= term.isAffine();
		}
		return isAffine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isQuasiAffine() {
		boolean isQAffine = true;
		for (PolynomialTerm term : getTerms()) {
			isQAffine &= term.isQuasiAffine();
		}
		return isQAffine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION__TERMS:
				return ((InternalEList<?>)getTerms()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION__TERMS:
				return getTerms();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends PolynomialTerm>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION__TERMS:
				getTerms().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION__TERMS:
				return terms != null && !terms.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION___IS_AFFINE:
				return isAffine();
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION___IS_QUASI_AFFINE:
				return isQuasiAffine();
		}
		return super.eInvoke(operationID, arguments);
	}

	public String toString(OUTPUT_FORMAT format) {
		return AlgebraPrettyPrinter.print(this, format);
	}

	public String toString() {
		return toString(OUTPUT_FORMAT.C);
	}
	
	@Override
	public AffineExpression toAffine() {
		PolynomialExpression simplified = (PolynomialExpression)this.simplify();
		if (simplified.isAffine()) {
			List<AffineTerm> affineTerms = new ArrayList<AffineTerm>(simplified.getTerms().size());
			for (PolynomialTerm term : getTerms()) {
				Variable variable = null;
				for (PolynomialVariable var : term.getVariables()) {
					if (var.getExponent() == 1) {
						variable = var.getVariable();
						break;
					}
				}
				long coef = term.getNumerator() / term.getDenominator();
				affineTerms.add(IntExpressionBuilder.term(coef, variable));
			}
			if (affineTerms.size() == 0) {
				return IntExpressionBuilder.constant(0).toAffine();
			} else {
				return IntExpressionBuilder.affine(affineTerms);
			}
		}
		
		return null;
	}
	
//	private b
	
//	public IntExpression substitute(Variable substituted, Variable newVar) {
//		PolynomialExpression polynomialExpression = (PolynomialExpression) this.copy();
//		for(PolynomialTerm polynomialTerm : polynomialExpression.getTerms()) {
//			if (polynomialTerm instanceof NestedPolynomialTerm)
//				((NestedPolynomialTerm)polynomialTerm).setExpression(((NestedPolynomialTerm)polynomialTerm).getExpression().substitute(substituted, newVar));
//			else if (polynomialTerm instanceof SimplePolynomialTerm && ((SimplePolynomialTerm)polynomialTerm).getVariable() == substituted)
//				((SimplePolynomialTerm)polynomialTerm).setVariable(newVar);
//		}
//		return polynomialExpression.simplify();
//	}
//	
//	@Override
//	public IntExpression substitute(Variable substituted, IntExpression newExpr) {
//		PolynomialExpression polynomialExpression = (PolynomialExpression) this.copy();
//		List<PolynomialTerm> polynomialTermsToRemove = new ArrayList<PolynomialTerm>();
//		List<PolynomialTerm> polynomialTermsToAdd = new ArrayList<PolynomialTerm>();
//		for(PolynomialTerm polynomialTerm : polynomialExpression.getTerms()) {
//			if (polynomialTerm instanceof NestedPolynomialTerm)
//				((NestedPolynomialTerm)polynomialTerm).setExpression(((NestedPolynomialTerm)polynomialTerm).getExpression().substitute(substituted, newExpr));
//			else if (polynomialTerm instanceof SimplePolynomialTerm && ((SimplePolynomialTerm)polynomialTerm).getVariable() == substituted) {
//				polynomialTermsToAdd.add(IntExpressionBuilder.pterm(newExpr, polynomialTerm.getCoef()));
//				polynomialTermsToRemove.add(polynomialTerm);
//			}
//		}
//		polynomialExpression.getTerms().removeAll(polynomialTermsToRemove);
//		polynomialExpression.getTerms().addAll(polynomialTermsToAdd);
//		return polynomialExpression.simplify();
//	}
} //PolynomialExpressionImpl