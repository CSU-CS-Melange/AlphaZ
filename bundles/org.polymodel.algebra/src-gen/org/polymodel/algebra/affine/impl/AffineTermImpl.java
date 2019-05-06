/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.affine.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.impl.IntTermImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.affine.impl.AffineTermImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AffineTermImpl extends IntTermImpl implements AffineTerm {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AffineTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AffinePackage.Literals.AFFINE_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (Variable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AffinePackage.AFFINE_TERM__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setVariable(Variable newVariable) {
//		assert(newVariable == null || newVariable.getName() != null);
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AffinePackage.AFFINE_TERM__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitAffineTerm(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AffinePackage.AFFINE_TERM__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AffinePackage.AFFINE_TERM__VARIABLE:
				setVariable((Variable)newValue);
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
			case AffinePackage.AFFINE_TERM__VARIABLE:
				setVariable((Variable)null);
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
			case AffinePackage.AFFINE_TERM__VARIABLE:
				return variable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == AlgebraVisitable.class) {
			switch (baseOperationID) {
				case AlgebraPackage.ALGEBRA_VISITABLE___ACCEPT__ALGEBRAVISITOR: return AffinePackage.AFFINE_TERM___ACCEPT__ALGEBRAVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == IntTerm.class) {
			switch (baseOperationID) {
				case AlgebraPackage.INT_TERM___ACCEPT__ALGEBRAVISITOR: return AffinePackage.AFFINE_TERM___ACCEPT__ALGEBRAVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AffinePackage.AFFINE_TERM___ACCEPT__ALGEBRAVISITOR:
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
		if (variable==null)
			return String.valueOf(getCoef());
		else if (getCoef() == 1)
			return variable.toString();
		else if (getCoef() == -1)
			return "-"+variable.toString();
		else
			return getCoef() + "*" + variable.toString();
	}
	
	@Override
	public boolean isEquivalent(IntTerm other) {
		if (!(other instanceof AffineTerm)) {
			return false;
		}
		
		AffineTerm otherAffine = (AffineTerm) other;
		
		//check if one is null, both are null
		if ((this.getVariable() == null && otherAffine.getVariable() != null) ||
				(this.getVariable() != null && otherAffine.getVariable() == null)) {
			return false;
		}

		//check name
		if ((this.getVariable() != null && otherAffine.getVariable() != null)) {
			if (this.getVariable().getName().compareTo(otherAffine.getVariable().getName()) != 0) {
				return false;
			}
		}
		
		//check coefficients
		return this.coef == otherAffine.getCoef();
	}

	@Override
	public int compareTo(IntTerm o) {
		if (o instanceof AffineTerm) {
			AffineTerm affineOther = (AffineTerm)o;
			
			//both are null
			if (this.getVariable() == null && affineOther.getVariable() == null) {
				return super.compareTo(affineOther);
			//when one is null
			} else if (this.getVariable() == null && affineOther.getVariable() != null) {
				return 1;
			} else if (this.getVariable() != null && affineOther.getVariable() == null) {
				return -1;
			//both are variables
			} else {
				int var = this.getVariable().getName().compareTo(affineOther.getVariable().getName());
				if (var == 0) {
					return super.compareTo(o);
				} else {
					//Positive term before negative term
					if(getCoef()<0 && o.getCoef()>0){
						return 1;
					}
					return var;
				}
			}
			
		} else {
			return super.compareTo(o);
		}
	}
} //AffineTermImpl
