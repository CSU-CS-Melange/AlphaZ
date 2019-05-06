/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communicated Variable For Tiled Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.CommunicatedVariableForTiledSpaceImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.CommunicatedVariableForTiledSpaceImpl#getCommunicationDepths <em>Communication Depths</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicatedVariableForTiledSpaceImpl extends EObjectImpl implements CommunicatedVariableForTiledSpace {
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
	 * The cached value of the '{@link #getCommunicationDepths() <em>Communication Depths</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationDepths()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> communicationDepths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicatedVariableForTiledSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.COMMUNICATED_VARIABLE_FOR_TILED_SPACE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE, oldVariable, variable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getCommunicationDepths() {
		if (communicationDepths == null) {
			communicationDepths = new EDataTypeUniqueEList<Integer>(Integer.class, this, TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__COMMUNICATION_DEPTHS);
		}
		return communicationDepths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitCommunicatedVariableForTiledSpace(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__COMMUNICATION_DEPTHS:
				return getCommunicationDepths();
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
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE:
				setVariable((VariableDeclaration)newValue);
				return;
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__COMMUNICATION_DEPTHS:
				getCommunicationDepths().clear();
				getCommunicationDepths().addAll((Collection<? extends Integer>)newValue);
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
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE:
				setVariable((VariableDeclaration)null);
				return;
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__COMMUNICATION_DEPTHS:
				getCommunicationDepths().clear();
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
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE:
				return variable != null;
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE__COMMUNICATION_DEPTHS:
				return communicationDepths != null && !communicationDepths.isEmpty();
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
		result.append(" (communicationDepths: ");
		result.append(communicationDepths);
		result.append(')');
		return result.toString();
	}

} //CommunicatedVariableForTiledSpaceImpl
