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
 * A representation of the model object '<em><b>Communicated Variable For Tiled Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace#getCommunicationDepths <em>Communication Depths</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getCommunicatedVariableForTiledSpace()
 * @model
 * @generated
 */
public interface CommunicatedVariableForTiledSpace extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(VariableDeclaration)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getCommunicatedVariableForTiledSpace_Variable()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclaration getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Communication Depths</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communication Depths</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication Depths</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getCommunicatedVariableForTiledSpace_CommunicationDepths()
	 * @model
	 * @generated
	 */
	EList<Integer> getCommunicationDepths();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitCommunicatedVariableForTiledSpace(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // CommunicatedVariableForTiledSpace
