/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Int Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.impl.IntTermImpl#getCoef <em>Coef</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntTermImpl extends EObjectImpl implements IntTerm {
	/**
	 * The default value of the '{@link #getCoef() <em>Coef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoef()
	 * @generated
	 * @ordered
	 */
	protected static final long COEF_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCoef() <em>Coef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoef()
	 * @generated
	 * @ordered
	 */
	protected long coef = COEF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgebraPackage.Literals.INT_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCoef() {
		return coef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoef(long newCoef) {
		long oldCoef = coef;
		coef = newCoef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgebraPackage.INT_TERM__COEF, oldCoef, coef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitIntTerm(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEquivalent(IntTerm other) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AlgebraPackage.INT_TERM__COEF:
				return getCoef();
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
			case AlgebraPackage.INT_TERM__COEF:
				setCoef((Long)newValue);
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
			case AlgebraPackage.INT_TERM__COEF:
				setCoef(COEF_EDEFAULT);
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
			case AlgebraPackage.INT_TERM__COEF:
				return coef != COEF_EDEFAULT;
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
			case AlgebraPackage.INT_TERM___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
			case AlgebraPackage.INT_TERM___IS_EQUIVALENT__INTTERM:
				return isEquivalent((IntTerm)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (coef: ");
		result.append(coef);
		result.append(')');
		return result.toString();
	}

	public int compareTo(IntTerm o) {
		return (int)(getCoef() - o.getCoef());
	}

	public String toString(OUTPUT_FORMAT format) {
		return AlgebraPrettyPrinter.print(this, format);
	}

} //IntTermImpl
