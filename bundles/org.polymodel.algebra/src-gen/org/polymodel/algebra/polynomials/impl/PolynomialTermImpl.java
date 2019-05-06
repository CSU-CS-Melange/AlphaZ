/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.polynomials.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.polynomials.PolynomialsPackage;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Polynomial Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.polynomials.impl.PolynomialTermImpl#getNumerator <em>Numerator</em>}</li>
 *   <li>{@link org.polymodel.algebra.polynomials.impl.PolynomialTermImpl#getDenominator <em>Denominator</em>}</li>
 *   <li>{@link org.polymodel.algebra.polynomials.impl.PolynomialTermImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PolynomialTermImpl extends EObjectImpl implements PolynomialTerm {
	/**
	 * The default value of the '{@link #getNumerator() <em>Numerator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumerator()
	 * @generated
	 * @ordered
	 */
	protected static final long NUMERATOR_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getNumerator() <em>Numerator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumerator()
	 * @generated
	 * @ordered
	 */
	protected long numerator = NUMERATOR_EDEFAULT;
	/**
	 * The default value of the '{@link #getDenominator() <em>Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDenominator()
	 * @generated
	 * @ordered
	 */
	protected static final long DENOMINATOR_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getDenominator() <em>Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDenominator()
	 * @generated
	 * @ordered
	 */
	protected long denominator = DENOMINATOR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<PolynomialVariable> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolynomialTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolynomialsPackage.Literals.POLYNOMIAL_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getNumerator() {
		return numerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumerator(long newNumerator) {
		long oldNumerator = numerator;
		numerator = newNumerator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolynomialsPackage.POLYNOMIAL_TERM__NUMERATOR, oldNumerator, numerator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDenominator() {
		return denominator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDenominator(long newDenominator) {
		long oldDenominator = denominator;
		denominator = newDenominator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolynomialsPackage.POLYNOMIAL_TERM__DENOMINATOR, oldDenominator, denominator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PolynomialVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<PolynomialVariable>(PolynomialVariable.class, this, PolynomialsPackage.POLYNOMIAL_TERM__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitPolynomialTerm(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isAffine() {
		return isQuasiAffine() && (getNumerator() % getDenominator() == 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isQuasiAffine() {
		boolean isQAffine = true;
		
		int exponents = 0;
		for (PolynomialVariable var : getVariables()) {
			isQAffine &= (var.getExponent() == 0 || var.getExponent() == 1);
			exponents += var.getExponent();
		}
		
		return isQAffine && (exponents == 0 || exponents == 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolynomialsPackage.POLYNOMIAL_TERM__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case PolynomialsPackage.POLYNOMIAL_TERM__NUMERATOR:
				return getNumerator();
			case PolynomialsPackage.POLYNOMIAL_TERM__DENOMINATOR:
				return getDenominator();
			case PolynomialsPackage.POLYNOMIAL_TERM__VARIABLES:
				return getVariables();
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
			case PolynomialsPackage.POLYNOMIAL_TERM__NUMERATOR:
				setNumerator((Long)newValue);
				return;
			case PolynomialsPackage.POLYNOMIAL_TERM__DENOMINATOR:
				setDenominator((Long)newValue);
				return;
			case PolynomialsPackage.POLYNOMIAL_TERM__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends PolynomialVariable>)newValue);
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
			case PolynomialsPackage.POLYNOMIAL_TERM__NUMERATOR:
				setNumerator(NUMERATOR_EDEFAULT);
				return;
			case PolynomialsPackage.POLYNOMIAL_TERM__DENOMINATOR:
				setDenominator(DENOMINATOR_EDEFAULT);
				return;
			case PolynomialsPackage.POLYNOMIAL_TERM__VARIABLES:
				getVariables().clear();
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
			case PolynomialsPackage.POLYNOMIAL_TERM__NUMERATOR:
				return numerator != NUMERATOR_EDEFAULT;
			case PolynomialsPackage.POLYNOMIAL_TERM__DENOMINATOR:
				return denominator != DENOMINATOR_EDEFAULT;
			case PolynomialsPackage.POLYNOMIAL_TERM__VARIABLES:
				return variables != null && !variables.isEmpty();
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
			case PolynomialsPackage.POLYNOMIAL_TERM___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
			case PolynomialsPackage.POLYNOMIAL_TERM___IS_AFFINE:
				return isAffine();
			case PolynomialsPackage.POLYNOMIAL_TERM___IS_QUASI_AFFINE:
				return isQuasiAffine();
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

} //PolynomialTermImpl
