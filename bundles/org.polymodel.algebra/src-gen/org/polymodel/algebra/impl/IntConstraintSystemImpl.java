/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Int Constraint System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.impl.IntConstraintSystemImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntConstraintSystemImpl extends EObjectImpl implements IntConstraintSystem {
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<IntConstraint> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntConstraintSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgebraPackage.Literals.INT_CONSTRAINT_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<IntConstraint>(IntConstraint.class, this, AlgebraPackage.INT_CONSTRAINT_SYSTEM__CONSTRAINTS);
		}
		return constraints;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i < getConstraints().size(); i++) {
			stringBuffer.append((i == getConstraints().size()-1) ? getConstraints().get(i) : getConstraints().get(i) + " and ");
		}
		return stringBuffer.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitIntConstraintSystem(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntConstraintSystem substitute(Variable substituted, Variable newVar) {
		List<IntConstraint> constraints = new ArrayList<IntConstraint>(getConstraints().size());
		
		for (IntConstraint constraint : getConstraints()) {
			constraints.add(constraint.substitute(substituted, newVar));
		}
		
		return IntExpressionBuilder.constraintSystem(constraints);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntConstraintSystem substitute(Variable substituted, IntExpression newExpr) {
		List<IntConstraint> constraints = new ArrayList<IntConstraint>(getConstraints().size());
		
		for (IntConstraint constraint : getConstraints()) {
			constraints.add(constraint.substitute(substituted, newExpr));
		}
		
		return IntExpressionBuilder.constraintSystem(constraints);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntConstraintSystem simplify() {
		List<IntConstraint> constraints = new ArrayList<IntConstraint>(getConstraints().size());
		
		for (IntConstraint constraint : getConstraints()) {
			constraints.add(constraint.simplify());
		}
		
		List<IntConstraint> redundant = new ArrayList<IntConstraint>();
		//O(n^2) comparison
		for (int i = 0; i < constraints.size(); i++) {
			for (int j = i+1; j < constraints.size(); j++) {
				IntConstraint c1 = constraints.get(i);
				IntConstraint c2 = constraints.get(j);
				if (c1.isEquivalent(c2) == FuzzyBoolean.YES) {
					if (redundant.contains(c1) || redundant.contains(c2)) continue;
					
					redundant.add(c1);
				}
			}
		} 
		
		constraints.removeAll(redundant);
		
		return IntExpressionBuilder.constraintSystem(constraints);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM__CONSTRAINTS:
				return getConstraints();
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
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends IntConstraint>)newValue);
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
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM__CONSTRAINTS:
				getConstraints().clear();
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
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
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
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM___SUBSTITUTE__VARIABLE_VARIABLE:
				return substitute((Variable)arguments.get(0), (Variable)arguments.get(1));
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM___SUBSTITUTE__VARIABLE_INTEXPRESSION:
				return substitute((Variable)arguments.get(0), (IntExpression)arguments.get(1));
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM___SIMPLIFY:
				return simplify();
			case AlgebraPackage.INT_CONSTRAINT_SYSTEM___COPY:
				return copy();
		}
		return super.eInvoke(operationID, arguments);
	}

	public IntConstraintSystem copy() {
		IntConstraintSystemImpl res = new IntConstraintSystemImpl();
		for (IntConstraint c : getConstraints()) {
			res.getConstraints().add(c.copy());
		}
		return res;
	}

	public String toString(OUTPUT_FORMAT format) {
		return AlgebraPrettyPrinter.print(this, format);
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getUB(Variable var) {
		List<IntExpression> ubs = new LinkedList<IntExpression>();
		//Get bounds from each constraint
		for (IntConstraint ic : getConstraints()) {
			IntExpression ub = ic.getUB(var);
			if (ub != null) {
				ubs.add(ub);
			}
		}
		
		//When no bounds were found, return null
		if (ubs.size() == 0) {
			return null;
		//If only one bound is found, use that
		} else if (ubs.size() == 1) {
			return ubs.get(0);
		}
		
		//Otherwise
		//Take the max
		return IntExpressionBuilder.max(ubs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getLB(Variable var) {
		List<IntExpression> lbs = new LinkedList<IntExpression>();
		//Get bounds from each constraint
		for (IntConstraint ic : getConstraints()) {
			IntExpression lb = ic.getLB(var);
			if (lb != null) {
				lbs.add(lb);
			}
		}
		
		//When no bounds were found, return null
		if (lbs.size() == 0) {
			return null;
		//If only one bound is found, use that
		} else if (lbs.size() == 1) {
			return lbs.get(0);
		}
		
		//Otherwise
		//Take the min
		return IntExpressionBuilder.min(lbs);
	}

} //IntConstraintSystemImpl
