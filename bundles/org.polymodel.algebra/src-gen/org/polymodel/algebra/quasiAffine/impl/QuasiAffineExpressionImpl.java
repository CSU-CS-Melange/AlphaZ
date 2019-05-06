/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.impl.IntExpressionImpl;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
import org.polymodel.algebra.quasiAffine.QuasiAffinePackage;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.quasiAffine.impl.QuasiAffineExpressionImpl#getTerms <em>Terms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuasiAffineExpressionImpl extends IntExpressionImpl implements QuasiAffineExpression {
	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	protected EList<QuasiAffineTerm> terms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuasiAffineExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QuasiAffinePackage.Literals.QUASI_AFFINE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QuasiAffineTerm> getTerms() {
		if (terms == null) {
			terms = new EObjectContainmentEList<QuasiAffineTerm>(QuasiAffineTerm.class, this, QuasiAffinePackage.QUASI_AFFINE_EXPRESSION__TERMS);
		}
		return terms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitQuasiAffineExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QuasiAffinePackage.QUASI_AFFINE_EXPRESSION__TERMS:
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
			case QuasiAffinePackage.QUASI_AFFINE_EXPRESSION__TERMS:
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
			case QuasiAffinePackage.QUASI_AFFINE_EXPRESSION__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends QuasiAffineTerm>)newValue);
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
			case QuasiAffinePackage.QUASI_AFFINE_EXPRESSION__TERMS:
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
			case QuasiAffinePackage.QUASI_AFFINE_EXPRESSION__TERMS:
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
			case QuasiAffinePackage.QUASI_AFFINE_EXPRESSION___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return getTerms().toString();
	}
	
	@Override
	public IntExpression substitute(Variable substituted, Variable newVar) {
		QuasiAffineExpression expr = EcoreUtil.copy(this);
		for (QuasiAffineTerm term : expr.getTerms()) {
			IntExpression e = term.getExpression();
			e = e.substitute(substituted, newVar);
			if (term instanceof SimpleQuasiAffineTerm) {
				((SimpleQuasiAffineTerm) term).setExpression((AffineExpression)e);
			} else if (term instanceof NestedQuasiAffineTerm) {
				((NestedQuasiAffineTerm) term).setExpression((QuasiAffineExpression)e);
			} else {
				throw new RuntimeException();
			}
		}
		return expr;
	}

	@Override
	public IntExpression substitute(Variable substituted, IntExpression newExpr) {
		QuasiAffineExpression expr = EcoreUtil.copy(this);
	    List<QuasiAffineTerm> termsToRemove = new LinkedList<QuasiAffineTerm>();
	    List<QuasiAffineTerm> termsToAdd = new LinkedList<QuasiAffineTerm>();
	    for (QuasiAffineTerm term : expr.getTerms()) {
	        IntExpression e = term.getExpression();
	        e = e.substitute(substituted, newExpr);
	        if (term instanceof SimpleQuasiAffineTerm) {
	            if ( e instanceof AffineExpression ) { 
	            	((SimpleQuasiAffineTerm) term).setExpression((AffineExpression) e);
	            } else if ( e instanceof QuasiAffineExpression){
	            	NestedQuasiAffineTerm newTerm = IntExpressionBuilder.qterm(term.getOperator(), (QuasiAffineExpression)e, term.getCoef());
		            termsToRemove.add(term);
		            termsToAdd.add(newTerm);
	             }  else {
	            	 throw new RuntimeException("Cannot handle expression " + e + " in substitute");
	             }
	        } else if (term instanceof NestedQuasiAffineTerm) {
	        	if ( e instanceof AffineExpression ) {
	        		QuasiAffineExpression qe = IntExpressionBuilder.qaffine(
	        				IntExpressionBuilder.qterm(QuasiAffineOperator.MUL, (AffineExpression) e, 1));
	        		((NestedQuasiAffineTerm) term).setExpression(qe);
	        	} else if ( e instanceof QuasiAffineExpression ) {
	        		((NestedQuasiAffineTerm) term).setExpression((QuasiAffineExpression)e);
	        	} else {
	            	 throw new RuntimeException("Cannot handle expression " + e + " in substitute");
	             }
	        } else {
	            throw new RuntimeException();
	        }   
	    }   
	    expr.getTerms().removeAll(termsToRemove);
	    expr.getTerms().addAll(termsToAdd);
	    return expr;

		//throw new UnsupportedOperationException("Not yet Implemented");
		//return SubstitutionManager.substitute(substituted, this, newExpr);
	}

	public String toString(OUTPUT_FORMAT format) {
		return AlgebraPrettyPrinter.print(this, format);
	}

} //QuasiAffineExpressionImpl
