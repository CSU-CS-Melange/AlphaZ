/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getModFactors <em>Mod Factors</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getSpace <em>Space</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemoryMap()
 * @model
 * @generated
 */
public interface MemoryMap extends PolyhedralIRVisitable {
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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemoryMap_Variable()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclaration getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariableDeclaration value);

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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemoryMap_Mapping()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AffineFunction getMapping();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getMapping <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' containment reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Mod Factors</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mod Factors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mod Factors</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemoryMap_ModFactors()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntExpression> getModFactors();

	/**
	 * Returns the value of the '<em><b>Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Space</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Space</em>' reference.
	 * @see #setSpace(MemorySpace)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemoryMap_Space()
	 * @model required="true"
	 * @generated
	 */
	MemorySpace getSpace();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getSpace <em>Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Space</em>' reference.
	 * @see #getSpace()
	 * @generated
	 */
	void setSpace(MemorySpace value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitMemoryMap(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // MemoryMap
