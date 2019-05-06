/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

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
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemoryMapImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemoryMapImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemoryMapImpl#getModFactors <em>Mod Factors</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemoryMapImpl#getSpace <em>Space</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemoryMapImpl extends EObjectImpl implements MemoryMap {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration variable;

	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction mapping;

	/**
	 * The cached value of the '{@link #getModFactors() <em>Mod Factors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModFactors()
	 * @generated
	 * @ordered
	 */
	protected EList<IntExpression> modFactors;

	/**
	 * The cached value of the '{@link #getSpace() <em>Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpace()
	 * @generated
	 * @ordered
	 */
	protected MemorySpace space;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.MEMORY_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (VariableDeclaration)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetMappingPackage.MEMORY_MAP__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(VariableDeclaration newVariable) {
		VariableDeclaration oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.MEMORY_MAP__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getMapping() {
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapping(AffineFunction newMapping, NotificationChain msgs) {
		AffineFunction oldMapping = mapping;
		mapping = newMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetMappingPackage.MEMORY_MAP__MAPPING, oldMapping, newMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(AffineFunction newMapping) {
		if (newMapping != mapping) {
			NotificationChain msgs = null;
			if (mapping != null)
				msgs = ((InternalEObject)mapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.MEMORY_MAP__MAPPING, null, msgs);
			if (newMapping != null)
				msgs = ((InternalEObject)newMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetMappingPackage.MEMORY_MAP__MAPPING, null, msgs);
			msgs = basicSetMapping(newMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.MEMORY_MAP__MAPPING, newMapping, newMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntExpression> getModFactors() {
		if (modFactors == null) {
			modFactors = new EObjectContainmentEList<IntExpression>(IntExpression.class, this, TargetMappingPackage.MEMORY_MAP__MOD_FACTORS);
		}
		return modFactors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemorySpace getSpace() {
		if (space != null && space.eIsProxy()) {
			InternalEObject oldSpace = (InternalEObject)space;
			space = (MemorySpace)eResolveProxy(oldSpace);
			if (space != oldSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetMappingPackage.MEMORY_MAP__SPACE, oldSpace, space));
			}
		}
		return space;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemorySpace basicGetSpace() {
		return space;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpace(MemorySpace newSpace) {
		MemorySpace oldSpace = space;
		space = newSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.MEMORY_MAP__SPACE, oldSpace, space));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitMemoryMap(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetMappingPackage.MEMORY_MAP__MAPPING:
				return basicSetMapping(null, msgs);
			case TargetMappingPackage.MEMORY_MAP__MOD_FACTORS:
				return ((InternalEList<?>)getModFactors()).basicRemove(otherEnd, msgs);
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
			case TargetMappingPackage.MEMORY_MAP__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case TargetMappingPackage.MEMORY_MAP__MAPPING:
				return getMapping();
			case TargetMappingPackage.MEMORY_MAP__MOD_FACTORS:
				return getModFactors();
			case TargetMappingPackage.MEMORY_MAP__SPACE:
				if (resolve) return getSpace();
				return basicGetSpace();
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
			case TargetMappingPackage.MEMORY_MAP__VARIABLE:
				setVariable((VariableDeclaration)newValue);
				return;
			case TargetMappingPackage.MEMORY_MAP__MAPPING:
				setMapping((AffineFunction)newValue);
				return;
			case TargetMappingPackage.MEMORY_MAP__MOD_FACTORS:
				getModFactors().clear();
				getModFactors().addAll((Collection<? extends IntExpression>)newValue);
				return;
			case TargetMappingPackage.MEMORY_MAP__SPACE:
				setSpace((MemorySpace)newValue);
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
			case TargetMappingPackage.MEMORY_MAP__VARIABLE:
				setVariable((VariableDeclaration)null);
				return;
			case TargetMappingPackage.MEMORY_MAP__MAPPING:
				setMapping((AffineFunction)null);
				return;
			case TargetMappingPackage.MEMORY_MAP__MOD_FACTORS:
				getModFactors().clear();
				return;
			case TargetMappingPackage.MEMORY_MAP__SPACE:
				setSpace((MemorySpace)null);
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
			case TargetMappingPackage.MEMORY_MAP__VARIABLE:
				return variable != null;
			case TargetMappingPackage.MEMORY_MAP__MAPPING:
				return mapping != null;
			case TargetMappingPackage.MEMORY_MAP__MOD_FACTORS:
				return modFactors != null && !modFactors.isEmpty();
			case TargetMappingPackage.MEMORY_MAP__SPACE:
				return space != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String toString() {
		return getVariable().getName() + " " + mapping + " @ " + modFactors + " "  + space.getName();
	}

} //MemoryMapImpl
