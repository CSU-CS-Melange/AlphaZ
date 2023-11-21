/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.CLoopImpl#isUseMacros <em>Use Macros</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CLoopImpl extends LoopImpl implements CLoop {
	/**
	 * The default value of the '{@link #isUseMacros() <em>Use Macros</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseMacros()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_MACROS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUseMacros() <em>Use Macros</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseMacros()
	 * @generated
	 * @ordered
	 */
	protected boolean useMacros = USE_MACROS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.CLOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseMacros() {
		return useMacros;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseMacros(boolean newUseMacros) {
		boolean oldUseMacros = useMacros;
		useMacros = newUseMacros;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.CLOOP__USE_MACROS, oldUseMacros, useMacros));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CPackage.CLOOP__USE_MACROS:
				return isUseMacros();
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
			case CPackage.CLOOP__USE_MACROS:
				setUseMacros((Boolean)newValue);
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
			case CPackage.CLOOP__USE_MACROS:
				setUseMacros(USE_MACROS_EDEFAULT);
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
			case CPackage.CLOOP__USE_MACROS:
				return useMacros != USE_MACROS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (useMacros: ");
		result.append(useMacros);
		result.append(')');
		return result.toString();
	}
	
	public boolean isABFTLoop() {
		if (!(this.eContainer instanceof Function))
			return false;
		Function f = (Function)this.eContainer;
		return f.getName().contains("scc_abft");
	}

} //CLoopImpl
