/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Mapping For Tiled Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getCommunicationMappingForTiledSpace()
 * @model
 * @generated
 */
public interface CommunicationMappingForTiledSpace extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getCommunicationMappingForTiledSpace_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommunicatedVariableForTiledSpace> getVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" variableRequired="true"
	 * @generated
	 */
	CommunicatedVariableForTiledSpace getCommunicatedVariable(VariableDeclaration variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitCommunicationMappingForTiledSpace(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // CommunicationMappingForTiledSpace
