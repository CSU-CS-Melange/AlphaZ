/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.affine.impl;

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
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.impl.IntExpressionImpl;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.algebra.tom.Replace;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Expression</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.affine.impl.AffineExpressionImpl#getTerms <em>Terms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AffineExpressionImpl extends IntExpressionImpl implements
		AffineExpression {
	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	protected EList<AffineTerm> terms;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AffineExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AffinePackage.Literals.AFFINE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AffineTerm> getTerms() {
		if (terms == null) {
			terms = new EObjectContainmentEList<AffineTerm>(AffineTerm.class, this, AffinePackage.AFFINE_EXPRESSION__TERMS);
		}
		return terms;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitAffineExpression(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AffinePackage.AFFINE_EXPRESSION__TERMS:
				return ((InternalEList<?>)getTerms()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AffinePackage.AFFINE_EXPRESSION__TERMS:
				return getTerms();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AffinePackage.AFFINE_EXPRESSION__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends AffineTerm>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AffinePackage.AFFINE_EXPRESSION__TERMS:
				getTerms().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AffinePackage.AFFINE_EXPRESSION__TERMS:
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
			case AffinePackage.AFFINE_EXPRESSION___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public String toString() {
		return AlgebraPrettyPrinter.print(this, OUTPUT_FORMAT.ISL);
	}

	@Override
	public IntExpression substitute(Variable substituted, Variable newVar) {
		AffineExpression expr = EcoreUtil.copy(this);
		for (AffineTerm term : expr.getTerms()) {
			if (term.getVariable() != null
					&& term.getVariable().getName().contentEquals(substituted.getName())) {
				term.setVariable(newVar);
			}
		}
		return expr;
	}

	@Override
	public IntExpression substitute(Variable substituted, IntExpression newExpr) {
		AffineExpression affineExpression = (AffineExpression) this.copy();
		if (newExpr instanceof AffineExpression) {
			if (substituted == null) {
				return affineExpression;
			}
			List<AffineTerm> substituteList = new LinkedList<AffineTerm>();
			for (AffineTerm term : affineExpression.getTerms()) {
				// when names are not null, it must be equal
				if (term.getVariable() != null && substituted != null) {
					if (term.getVariable().getName().contentEquals(substituted.getName())) {	//check whether the name is equal or not
						substituteList.add(term);
					}
				}
			}
			// remove terms that contains the variables to be replaced
			affineExpression.getTerms().removeAll(substituteList);

			// create new term based on the coefficient of the original term and
			// new expression
			for (AffineTerm term : substituteList) {
				for (AffineTerm newTerm : ((AffineExpression) newExpr)
						.getTerms()) {
					affineExpression.getTerms().add(
							IntExpressionBuilder.term(
									term.getCoef() * newTerm.getCoef(),
									newTerm.getVariable()));
				}
			}

			return affineExpression;
		} else {
			return Replace.replace(affineExpression, substituted, newExpr);
		}
	}

	public AffineTerm getTerm(Variable v) {
		for (AffineTerm t : terms) {
			if (t.getVariable() == v)
				return t;
		}
		return null;
	}
	
	public String toString(OUTPUT_FORMAT format) {
		return AlgebraPrettyPrinter.print(this, format);
	}

	public AffineTerm getConstantTerm() {
		for(AffineTerm t : ((AffineExpression)this.simplify()).getTerms()) {
			if(t.getVariable()==null) {
				return t;
			}
		}
		return null;
	}
} // AffineExpressionImpl