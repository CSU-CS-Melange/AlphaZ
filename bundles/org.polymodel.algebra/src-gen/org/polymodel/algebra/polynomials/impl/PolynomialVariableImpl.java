/**
 */
package org.polymodel.algebra.polynomials.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.polynomials.PolynomialsPackage;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Polynomial Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.polynomials.impl.PolynomialVariableImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.algebra.polynomials.impl.PolynomialVariableImpl#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PolynomialVariableImpl extends EObjectImpl implements PolynomialVariable {
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
	 * The default value of the '{@link #getExponent() <em>Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExponent()
	 * @generated
	 * @ordered
	 */
	protected static final long EXPONENT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getExponent() <em>Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExponent()
	 * @generated
	 * @ordered
	 */
	protected long exponent = EXPONENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolynomialVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolynomialsPackage.Literals.POLYNOMIAL_VARIABLE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolynomialsPackage.POLYNOMIAL_VARIABLE__VARIABLE, oldVariable, variable));
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
	 * @generated
	 */
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolynomialsPackage.POLYNOMIAL_VARIABLE__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getExponent() {
		return exponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExponent(long newExponent) {
		long oldExponent = exponent;
		exponent = newExponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolynomialsPackage.POLYNOMIAL_VARIABLE__EXPONENT, oldExponent, exponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitPolynomialVariable(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEquivalent(PolynomialVariable other) {
		if (other == null || this.getVariable() == null || other.getVariable() == null) {
			throw new RuntimeException("Invalid input to isEquivalent: null variables");
		}
		
		return (other.getVariable().equals(this.getVariable()) && other.getExponent() == this.getExponent()); 
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolynomialsPackage.POLYNOMIAL_VARIABLE__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case PolynomialsPackage.POLYNOMIAL_VARIABLE__EXPONENT:
				return getExponent();
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
			case PolynomialsPackage.POLYNOMIAL_VARIABLE__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case PolynomialsPackage.POLYNOMIAL_VARIABLE__EXPONENT:
				setExponent((Long)newValue);
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
			case PolynomialsPackage.POLYNOMIAL_VARIABLE__VARIABLE:
				setVariable((Variable)null);
				return;
			case PolynomialsPackage.POLYNOMIAL_VARIABLE__EXPONENT:
				setExponent(EXPONENT_EDEFAULT);
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
			case PolynomialsPackage.POLYNOMIAL_VARIABLE__VARIABLE:
				return variable != null;
			case PolynomialsPackage.POLYNOMIAL_VARIABLE__EXPONENT:
				return exponent != EXPONENT_EDEFAULT;
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
			case PolynomialsPackage.POLYNOMIAL_VARIABLE___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
			case PolynomialsPackage.POLYNOMIAL_VARIABLE___IS_EQUIVALENT__POLYNOMIALVARIABLE:
				return isEquivalent((PolynomialVariable)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString(OUTPUT_FORMAT format) {
		return AlgebraPrettyPrinter.print(this, format);
	}

	public String toString() {
		return toString(OUTPUT_FORMAT.C);
	}

} //PolynomialVariableImpl
