/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getType <em>Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#isZeroAligned <em>Zero Aligned</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getContainerTM <em>Container TM</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemorySpace()
 * @model
 * @generated
 */
public interface MemorySpace extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemorySpace_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemorySpace_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemorySpace_Domain()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Returns the value of the '<em><b>Zero Aligned</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zero Aligned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zero Aligned</em>' attribute.
	 * @see #setZeroAligned(boolean)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemorySpace_ZeroAligned()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isZeroAligned();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#isZeroAligned <em>Zero Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zero Aligned</em>' attribute.
	 * @see #isZeroAligned()
	 * @generated
	 */
	void setZeroAligned(boolean value);

	/**
	 * Returns the value of the '<em><b>Container TM</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getMemorySpaces <em>Memory Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container TM</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container TM</em>' container reference.
	 * @see #setContainerTM(TargetMapping)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getMemorySpace_ContainerTM()
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getMemorySpaces
	 * @model opposite="memorySpaces" required="true" transient="false"
	 * @generated
	 */
	TargetMapping getContainerTM();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getContainerTM <em>Container TM</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container TM</em>' container reference.
	 * @see #getContainerTM()
	 * @generated
	 */
	void setContainerTM(TargetMapping value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<IntExpression> getModFactors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<MemoryMap> getMemoryMaps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitMemorySpace(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // MemorySpace
