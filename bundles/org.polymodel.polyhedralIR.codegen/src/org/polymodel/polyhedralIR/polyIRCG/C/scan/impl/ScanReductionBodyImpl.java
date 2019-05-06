/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reduction Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getPreProcessLoop <em>Pre Process Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getScanLoop <em>Scan Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getPostProcessLoop <em>Post Process Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getMatrixTempVariables <em>Matrix Temp Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getInitTempVariables <em>Init Temp Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getAssignmentLoop <em>Assignment Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getInitValueUpdate <em>Init Value Update</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getInitValueCopy <em>Init Value Copy</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl#getMatrixInitLoop <em>Matrix Init Loop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScanReductionBodyImpl extends EObjectImpl implements ScanReductionBody {
	/**
	 * The cached value of the '{@link #getPreProcessLoop() <em>Pre Process Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreProcessLoop()
	 * @generated
	 * @ordered
	 */
	protected CLoop preProcessLoop;

	/**
	 * The cached value of the '{@link #getScanLoop() <em>Scan Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScanLoop()
	 * @generated
	 * @ordered
	 */
	protected CLoop scanLoop;

	/**
	 * The cached value of the '{@link #getPostProcessLoop() <em>Post Process Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostProcessLoop()
	 * @generated
	 * @ordered
	 */
	protected CLoop postProcessLoop;

	/**
	 * The cached value of the '{@link #getMatrixTempVariables() <em>Matrix Temp Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatrixTempVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeGenVariable> matrixTempVariables;

	/**
	 * The cached value of the '{@link #getInitTempVariables() <em>Init Temp Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitTempVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeGenVariable> initTempVariables;

	/**
	 * The cached value of the '{@link #getAssignmentLoop() <em>Assignment Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignmentLoop()
	 * @generated
	 * @ordered
	 */
	protected CLoop assignmentLoop;

	/**
	 * The cached value of the '{@link #getInitValueUpdate() <em>Init Value Update</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitValueUpdate()
	 * @generated
	 * @ordered
	 */
	protected CLoop initValueUpdate;

	/**
	 * The cached value of the '{@link #getInitValueCopy() <em>Init Value Copy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitValueCopy()
	 * @generated
	 * @ordered
	 */
	protected CLoop initValueCopy;

	/**
	 * The cached value of the '{@link #getMatrixInitLoop() <em>Matrix Init Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatrixInitLoop()
	 * @generated
	 * @ordered
	 */
	protected CLoop matrixInitLoop;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScanReductionBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScanPackage.Literals.SCAN_REDUCTION_BODY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != ScanPackage.SCAN_REDUCTION_BODY__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, ScanPackage.SCAN_REDUCTION_BODY__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != ScanPackage.SCAN_REDUCTION_BODY__FUNCTION && newFunction != null)) {
			if (EcoreUtil.isAncestor(this, newFunction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_REDUCTION_BODY__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop getPreProcessLoop() {
		if (preProcessLoop != null && preProcessLoop.eIsProxy()) {
			InternalEObject oldPreProcessLoop = (InternalEObject)preProcessLoop;
			preProcessLoop = (CLoop)eResolveProxy(oldPreProcessLoop);
			if (preProcessLoop != oldPreProcessLoop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP, oldPreProcessLoop, preProcessLoop));
			}
		}
		return preProcessLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop basicGetPreProcessLoop() {
		return preProcessLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreProcessLoop(CLoop newPreProcessLoop) {
		CLoop oldPreProcessLoop = preProcessLoop;
		preProcessLoop = newPreProcessLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP, oldPreProcessLoop, preProcessLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop getScanLoop() {
		if (scanLoop != null && scanLoop.eIsProxy()) {
			InternalEObject oldScanLoop = (InternalEObject)scanLoop;
			scanLoop = (CLoop)eResolveProxy(oldScanLoop);
			if (scanLoop != oldScanLoop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_REDUCTION_BODY__SCAN_LOOP, oldScanLoop, scanLoop));
			}
		}
		return scanLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop basicGetScanLoop() {
		return scanLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScanLoop(CLoop newScanLoop) {
		CLoop oldScanLoop = scanLoop;
		scanLoop = newScanLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_REDUCTION_BODY__SCAN_LOOP, oldScanLoop, scanLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop getPostProcessLoop() {
		if (postProcessLoop != null && postProcessLoop.eIsProxy()) {
			InternalEObject oldPostProcessLoop = (InternalEObject)postProcessLoop;
			postProcessLoop = (CLoop)eResolveProxy(oldPostProcessLoop);
			if (postProcessLoop != oldPostProcessLoop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_REDUCTION_BODY__POST_PROCESS_LOOP, oldPostProcessLoop, postProcessLoop));
			}
		}
		return postProcessLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop basicGetPostProcessLoop() {
		return postProcessLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostProcessLoop(CLoop newPostProcessLoop) {
		CLoop oldPostProcessLoop = postProcessLoop;
		postProcessLoop = newPostProcessLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_REDUCTION_BODY__POST_PROCESS_LOOP, oldPostProcessLoop, postProcessLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeGenVariable> getMatrixTempVariables() {
		if (matrixTempVariables == null) {
			matrixTempVariables = new EObjectResolvingEList<CodeGenVariable>(CodeGenVariable.class, this, ScanPackage.SCAN_REDUCTION_BODY__MATRIX_TEMP_VARIABLES);
		}
		return matrixTempVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeGenVariable> getInitTempVariables() {
		if (initTempVariables == null) {
			initTempVariables = new EObjectResolvingEList<CodeGenVariable>(CodeGenVariable.class, this, ScanPackage.SCAN_REDUCTION_BODY__INIT_TEMP_VARIABLES);
		}
		return initTempVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop getAssignmentLoop() {
		if (assignmentLoop != null && assignmentLoop.eIsProxy()) {
			InternalEObject oldAssignmentLoop = (InternalEObject)assignmentLoop;
			assignmentLoop = (CLoop)eResolveProxy(oldAssignmentLoop);
			if (assignmentLoop != oldAssignmentLoop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP, oldAssignmentLoop, assignmentLoop));
			}
		}
		return assignmentLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop basicGetAssignmentLoop() {
		return assignmentLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignmentLoop(CLoop newAssignmentLoop) {
		CLoop oldAssignmentLoop = assignmentLoop;
		assignmentLoop = newAssignmentLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP, oldAssignmentLoop, assignmentLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop getInitValueUpdate() {
		if (initValueUpdate != null && initValueUpdate.eIsProxy()) {
			InternalEObject oldInitValueUpdate = (InternalEObject)initValueUpdate;
			initValueUpdate = (CLoop)eResolveProxy(oldInitValueUpdate);
			if (initValueUpdate != oldInitValueUpdate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE, oldInitValueUpdate, initValueUpdate));
			}
		}
		return initValueUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop basicGetInitValueUpdate() {
		return initValueUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitValueUpdate(CLoop newInitValueUpdate) {
		CLoop oldInitValueUpdate = initValueUpdate;
		initValueUpdate = newInitValueUpdate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE, oldInitValueUpdate, initValueUpdate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop getInitValueCopy() {
		if (initValueCopy != null && initValueCopy.eIsProxy()) {
			InternalEObject oldInitValueCopy = (InternalEObject)initValueCopy;
			initValueCopy = (CLoop)eResolveProxy(oldInitValueCopy);
			if (initValueCopy != oldInitValueCopy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_COPY, oldInitValueCopy, initValueCopy));
			}
		}
		return initValueCopy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop basicGetInitValueCopy() {
		return initValueCopy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitValueCopy(CLoop newInitValueCopy) {
		CLoop oldInitValueCopy = initValueCopy;
		initValueCopy = newInitValueCopy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_COPY, oldInitValueCopy, initValueCopy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop getMatrixInitLoop() {
		if (matrixInitLoop != null && matrixInitLoop.eIsProxy()) {
			InternalEObject oldMatrixInitLoop = (InternalEObject)matrixInitLoop;
			matrixInitLoop = (CLoop)eResolveProxy(oldMatrixInitLoop);
			if (matrixInitLoop != oldMatrixInitLoop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP, oldMatrixInitLoop, matrixInitLoop));
			}
		}
		return matrixInitLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop basicGetMatrixInitLoop() {
		return matrixInitLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatrixInitLoop(CLoop newMatrixInitLoop) {
		CLoop oldMatrixInitLoop = matrixInitLoop;
		matrixInitLoop = newMatrixInitLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP, oldMatrixInitLoop, matrixInitLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScanPackage.SCAN_REDUCTION_BODY__FUNCTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunction((Function)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScanPackage.SCAN_REDUCTION_BODY__FUNCTION:
				return basicSetFunction(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ScanPackage.SCAN_REDUCTION_BODY__FUNCTION:
				return eInternalContainer().eInverseRemove(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScanPackage.SCAN_REDUCTION_BODY__FUNCTION:
				return getFunction();
			case ScanPackage.SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP:
				if (resolve) return getPreProcessLoop();
				return basicGetPreProcessLoop();
			case ScanPackage.SCAN_REDUCTION_BODY__SCAN_LOOP:
				if (resolve) return getScanLoop();
				return basicGetScanLoop();
			case ScanPackage.SCAN_REDUCTION_BODY__POST_PROCESS_LOOP:
				if (resolve) return getPostProcessLoop();
				return basicGetPostProcessLoop();
			case ScanPackage.SCAN_REDUCTION_BODY__MATRIX_TEMP_VARIABLES:
				return getMatrixTempVariables();
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_TEMP_VARIABLES:
				return getInitTempVariables();
			case ScanPackage.SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP:
				if (resolve) return getAssignmentLoop();
				return basicGetAssignmentLoop();
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE:
				if (resolve) return getInitValueUpdate();
				return basicGetInitValueUpdate();
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_COPY:
				if (resolve) return getInitValueCopy();
				return basicGetInitValueCopy();
			case ScanPackage.SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP:
				if (resolve) return getMatrixInitLoop();
				return basicGetMatrixInitLoop();
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
			case ScanPackage.SCAN_REDUCTION_BODY__FUNCTION:
				setFunction((Function)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP:
				setPreProcessLoop((CLoop)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__SCAN_LOOP:
				setScanLoop((CLoop)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__POST_PROCESS_LOOP:
				setPostProcessLoop((CLoop)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__MATRIX_TEMP_VARIABLES:
				getMatrixTempVariables().clear();
				getMatrixTempVariables().addAll((Collection<? extends CodeGenVariable>)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_TEMP_VARIABLES:
				getInitTempVariables().clear();
				getInitTempVariables().addAll((Collection<? extends CodeGenVariable>)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP:
				setAssignmentLoop((CLoop)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE:
				setInitValueUpdate((CLoop)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_COPY:
				setInitValueCopy((CLoop)newValue);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP:
				setMatrixInitLoop((CLoop)newValue);
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
			case ScanPackage.SCAN_REDUCTION_BODY__FUNCTION:
				setFunction((Function)null);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP:
				setPreProcessLoop((CLoop)null);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__SCAN_LOOP:
				setScanLoop((CLoop)null);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__POST_PROCESS_LOOP:
				setPostProcessLoop((CLoop)null);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__MATRIX_TEMP_VARIABLES:
				getMatrixTempVariables().clear();
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_TEMP_VARIABLES:
				getInitTempVariables().clear();
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP:
				setAssignmentLoop((CLoop)null);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE:
				setInitValueUpdate((CLoop)null);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_COPY:
				setInitValueCopy((CLoop)null);
				return;
			case ScanPackage.SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP:
				setMatrixInitLoop((CLoop)null);
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
			case ScanPackage.SCAN_REDUCTION_BODY__FUNCTION:
				return getFunction() != null;
			case ScanPackage.SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP:
				return preProcessLoop != null;
			case ScanPackage.SCAN_REDUCTION_BODY__SCAN_LOOP:
				return scanLoop != null;
			case ScanPackage.SCAN_REDUCTION_BODY__POST_PROCESS_LOOP:
				return postProcessLoop != null;
			case ScanPackage.SCAN_REDUCTION_BODY__MATRIX_TEMP_VARIABLES:
				return matrixTempVariables != null && !matrixTempVariables.isEmpty();
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_TEMP_VARIABLES:
				return initTempVariables != null && !initTempVariables.isEmpty();
			case ScanPackage.SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP:
				return assignmentLoop != null;
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE:
				return initValueUpdate != null;
			case ScanPackage.SCAN_REDUCTION_BODY__INIT_VALUE_COPY:
				return initValueCopy != null;
			case ScanPackage.SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP:
				return matrixInitLoop != null;
		}
		return super.eIsSet(featureID);
	}

} //ScanReductionBodyImpl
