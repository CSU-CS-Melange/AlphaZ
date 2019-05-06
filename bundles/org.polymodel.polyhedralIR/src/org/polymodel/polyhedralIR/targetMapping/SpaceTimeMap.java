/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Space Time Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getInverseOfMapping <em>Inverse Of Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeMap()
 * @model
 * @generated
 */
public interface SpaceTimeMap extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' containment reference.
	 * @see #setMapping(AffineFunction)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeMap_Mapping()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AffineFunction getMapping();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getMapping <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' containment reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Inverse Of Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse Of Mapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inverse Of Mapping</em>' containment reference.
	 * @see #setInverseOfMapping(AffineFunction)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeMap_InverseOfMapping()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AffineFunction getInverseOfMapping();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getInverseOfMapping <em>Inverse Of Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse Of Mapping</em>' containment reference.
	 * @see #getInverseOfMapping()
	 * @generated
	 */
	void setInverseOfMapping(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeMap_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitSpaceTimeMap(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // SpaceTimeMap
