/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.impl.CLoopImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Printing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputPrintingImpl#getSpecialVar <em>Special Var</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutputPrintingImpl extends CLoopImpl implements OutputPrinting {
	/**
	 * The cached value of the '{@link #getSpecialVar() <em>Special Var</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialVar()
	 * @generated
	 * @ordered
	 */
	protected SpecialVariable specialVar;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputPrintingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CWrapperPackage.Literals.OUTPUT_PRINTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialVariable getSpecialVar() {
		if (specialVar != null && specialVar.eIsProxy()) {
			InternalEObject oldSpecialVar = (InternalEObject)specialVar;
			specialVar = (SpecialVariable)eResolveProxy(oldSpecialVar);
			if (specialVar != oldSpecialVar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CWrapperPackage.OUTPUT_PRINTING__SPECIAL_VAR, oldSpecialVar, specialVar));
			}
		}
		return specialVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialVariable basicGetSpecialVar() {
		return specialVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecialVar(SpecialVariable newSpecialVar) {
		SpecialVariable oldSpecialVar = specialVar;
		specialVar = newSpecialVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CWrapperPackage.OUTPUT_PRINTING__SPECIAL_VAR, oldSpecialVar, specialVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CWrapperPackage.OUTPUT_PRINTING__SPECIAL_VAR:
				if (resolve) return getSpecialVar();
				return basicGetSpecialVar();
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
			case CWrapperPackage.OUTPUT_PRINTING__SPECIAL_VAR:
				setSpecialVar((SpecialVariable)newValue);
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
			case CWrapperPackage.OUTPUT_PRINTING__SPECIAL_VAR:
				setSpecialVar((SpecialVariable)null);
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
			case CWrapperPackage.OUTPUT_PRINTING__SPECIAL_VAR:
				return specialVar != null;
		}
		return super.eIsSet(featureID);
	}

} //OutputPrintingImpl
