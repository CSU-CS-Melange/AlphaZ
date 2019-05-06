/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Equation Optimization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl#isInput <em>Input</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl#getNum <em>Num</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl#getMemoryMappingForTemporaryVariable <em>Memory Mapping For Temporary Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl#getMemorySpaceNameforTemporaryVariable <em>Memory Space Namefor Temporary Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl#getMemoryAllocationSpaceTimeMap <em>Memory Allocation Space Time Map</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl#getValueCopySpaceTimeMap <em>Value Copy Space Time Map</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl#getMemoryFreeSpaceTimeMap <em>Memory Free Space Time Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseEquationOptimizationImpl extends EObjectImpl implements UseEquationOptimization {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #isInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInput()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INPUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInput()
	 * @generated
	 * @ordered
	 */
	protected boolean input = INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getNum() <em>Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNum()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNum() <em>Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNum()
	 * @generated
	 * @ordered
	 */
	protected int num = NUM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMemoryMappingForTemporaryVariable() <em>Memory Mapping For Temporary Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryMappingForTemporaryVariable()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction memoryMappingForTemporaryVariable;

	/**
	 * The default value of the '{@link #getMemorySpaceNameforTemporaryVariable() <em>Memory Space Namefor Temporary Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySpaceNameforTemporaryVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemorySpaceNameforTemporaryVariable() <em>Memory Space Namefor Temporary Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySpaceNameforTemporaryVariable()
	 * @generated
	 * @ordered
	 */
	protected String memorySpaceNameforTemporaryVariable = MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMemoryAllocationSpaceTimeMap() <em>Memory Allocation Space Time Map</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryAllocationSpaceTimeMap()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction memoryAllocationSpaceTimeMap;

	/**
	 * The cached value of the '{@link #getValueCopySpaceTimeMap() <em>Value Copy Space Time Map</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueCopySpaceTimeMap()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction valueCopySpaceTimeMap;

	/**
	 * The cached value of the '{@link #getMemoryFreeSpaceTimeMap() <em>Memory Free Space Time Map</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryFreeSpaceTimeMap()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction memoryFreeSpaceTimeMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseEquationOptimizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.USE_EQUATION_OPTIMIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(boolean newInput) {
		boolean oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNum() {
		return num;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNum(int newNum) {
		int oldNum = num;
		num = newNum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__NUM, oldNum, num));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getMemoryMappingForTemporaryVariable() {
		return memoryMappingForTemporaryVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMemoryMappingForTemporaryVariable(AffineFunction newMemoryMappingForTemporaryVariable, NotificationChain msgs) {
		AffineFunction oldMemoryMappingForTemporaryVariable = memoryMappingForTemporaryVariable;
		memoryMappingForTemporaryVariable = newMemoryMappingForTemporaryVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE, oldMemoryMappingForTemporaryVariable, newMemoryMappingForTemporaryVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemoryMappingForTemporaryVariable(AffineFunction newMemoryMappingForTemporaryVariable) {
		if (newMemoryMappingForTemporaryVariable != memoryMappingForTemporaryVariable) {
			NotificationChain msgs = null;
			if (memoryMappingForTemporaryVariable != null)
				msgs = ((InternalEObject)memoryMappingForTemporaryVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE, null, msgs);
			if (newMemoryMappingForTemporaryVariable != null)
				msgs = ((InternalEObject)newMemoryMappingForTemporaryVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE, null, msgs);
			msgs = basicSetMemoryMappingForTemporaryVariable(newMemoryMappingForTemporaryVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE, newMemoryMappingForTemporaryVariable, newMemoryMappingForTemporaryVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemorySpaceNameforTemporaryVariable() {
		return memorySpaceNameforTemporaryVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemorySpaceNameforTemporaryVariable(String newMemorySpaceNameforTemporaryVariable) {
		String oldMemorySpaceNameforTemporaryVariable = memorySpaceNameforTemporaryVariable;
		memorySpaceNameforTemporaryVariable = newMemorySpaceNameforTemporaryVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE, oldMemorySpaceNameforTemporaryVariable, memorySpaceNameforTemporaryVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getMemoryAllocationSpaceTimeMap() {
		return memoryAllocationSpaceTimeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMemoryAllocationSpaceTimeMap(AffineFunction newMemoryAllocationSpaceTimeMap, NotificationChain msgs) {
		AffineFunction oldMemoryAllocationSpaceTimeMap = memoryAllocationSpaceTimeMap;
		memoryAllocationSpaceTimeMap = newMemoryAllocationSpaceTimeMap;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP, oldMemoryAllocationSpaceTimeMap, newMemoryAllocationSpaceTimeMap);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemoryAllocationSpaceTimeMap(AffineFunction newMemoryAllocationSpaceTimeMap) {
		if (newMemoryAllocationSpaceTimeMap != memoryAllocationSpaceTimeMap) {
			NotificationChain msgs = null;
			if (memoryAllocationSpaceTimeMap != null)
				msgs = ((InternalEObject)memoryAllocationSpaceTimeMap).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP, null, msgs);
			if (newMemoryAllocationSpaceTimeMap != null)
				msgs = ((InternalEObject)newMemoryAllocationSpaceTimeMap).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP, null, msgs);
			msgs = basicSetMemoryAllocationSpaceTimeMap(newMemoryAllocationSpaceTimeMap, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP, newMemoryAllocationSpaceTimeMap, newMemoryAllocationSpaceTimeMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getValueCopySpaceTimeMap() {
		return valueCopySpaceTimeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueCopySpaceTimeMap(AffineFunction newValueCopySpaceTimeMap, NotificationChain msgs) {
		AffineFunction oldValueCopySpaceTimeMap = valueCopySpaceTimeMap;
		valueCopySpaceTimeMap = newValueCopySpaceTimeMap;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP, oldValueCopySpaceTimeMap, newValueCopySpaceTimeMap);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueCopySpaceTimeMap(AffineFunction newValueCopySpaceTimeMap) {
		if (newValueCopySpaceTimeMap != valueCopySpaceTimeMap) {
			NotificationChain msgs = null;
			if (valueCopySpaceTimeMap != null)
				msgs = ((InternalEObject)valueCopySpaceTimeMap).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP, null, msgs);
			if (newValueCopySpaceTimeMap != null)
				msgs = ((InternalEObject)newValueCopySpaceTimeMap).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP, null, msgs);
			msgs = basicSetValueCopySpaceTimeMap(newValueCopySpaceTimeMap, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP, newValueCopySpaceTimeMap, newValueCopySpaceTimeMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getMemoryFreeSpaceTimeMap() {
		return memoryFreeSpaceTimeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMemoryFreeSpaceTimeMap(AffineFunction newMemoryFreeSpaceTimeMap, NotificationChain msgs) {
		AffineFunction oldMemoryFreeSpaceTimeMap = memoryFreeSpaceTimeMap;
		memoryFreeSpaceTimeMap = newMemoryFreeSpaceTimeMap;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP, oldMemoryFreeSpaceTimeMap, newMemoryFreeSpaceTimeMap);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemoryFreeSpaceTimeMap(AffineFunction newMemoryFreeSpaceTimeMap) {
		if (newMemoryFreeSpaceTimeMap != memoryFreeSpaceTimeMap) {
			NotificationChain msgs = null;
			if (memoryFreeSpaceTimeMap != null)
				msgs = ((InternalEObject)memoryFreeSpaceTimeMap).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP, null, msgs);
			if (newMemoryFreeSpaceTimeMap != null)
				msgs = ((InternalEObject)newMemoryFreeSpaceTimeMap).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP, null, msgs);
			msgs = basicSetMemoryFreeSpaceTimeMap(newMemoryFreeSpaceTimeMap, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP, newMemoryFreeSpaceTimeMap, newMemoryFreeSpaceTimeMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitUseEquationOptimization(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE:
				return basicSetMemoryMappingForTemporaryVariable(null, msgs);
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP:
				return basicSetMemoryAllocationSpaceTimeMap(null, msgs);
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP:
				return basicSetValueCopySpaceTimeMap(null, msgs);
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP:
				return basicSetMemoryFreeSpaceTimeMap(null, msgs);
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
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__LABEL:
				return getLabel();
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__INPUT:
				return isInput();
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__NUM:
				return getNum();
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE:
				return getMemoryMappingForTemporaryVariable();
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE:
				return getMemorySpaceNameforTemporaryVariable();
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP:
				return getMemoryAllocationSpaceTimeMap();
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP:
				return getValueCopySpaceTimeMap();
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP:
				return getMemoryFreeSpaceTimeMap();
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
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__LABEL:
				setLabel((String)newValue);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__INPUT:
				setInput((Boolean)newValue);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__NUM:
				setNum((Integer)newValue);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE:
				setMemoryMappingForTemporaryVariable((AffineFunction)newValue);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE:
				setMemorySpaceNameforTemporaryVariable((String)newValue);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP:
				setMemoryAllocationSpaceTimeMap((AffineFunction)newValue);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP:
				setValueCopySpaceTimeMap((AffineFunction)newValue);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP:
				setMemoryFreeSpaceTimeMap((AffineFunction)newValue);
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
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__INPUT:
				setInput(INPUT_EDEFAULT);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__NUM:
				setNum(NUM_EDEFAULT);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE:
				setMemoryMappingForTemporaryVariable((AffineFunction)null);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE:
				setMemorySpaceNameforTemporaryVariable(MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE_EDEFAULT);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP:
				setMemoryAllocationSpaceTimeMap((AffineFunction)null);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP:
				setValueCopySpaceTimeMap((AffineFunction)null);
				return;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP:
				setMemoryFreeSpaceTimeMap((AffineFunction)null);
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
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__INPUT:
				return input != INPUT_EDEFAULT;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__NUM:
				return num != NUM_EDEFAULT;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE:
				return memoryMappingForTemporaryVariable != null;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE:
				return MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE_EDEFAULT == null ? memorySpaceNameforTemporaryVariable != null : !MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE_EDEFAULT.equals(memorySpaceNameforTemporaryVariable);
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP:
				return memoryAllocationSpaceTimeMap != null;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP:
				return valueCopySpaceTimeMap != null;
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP:
				return memoryFreeSpaceTimeMap != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (label: ");
		result.append(label);
		result.append(", input: ");
		result.append(input);
		result.append(", num: ");
		result.append(num);
		result.append(", MemorySpaceNameforTemporaryVariable: ");
		result.append(memorySpaceNameforTemporaryVariable);
		result.append(')');
		return result.toString();
	}

} //UseEquationOptimizationImpl
