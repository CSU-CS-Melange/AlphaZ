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
 * A representation of the model object '<em><b>Use Equation Optimization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getLabel <em>Label</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#isInput <em>Input</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getNum <em>Num</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryMappingForTemporaryVariable <em>Memory Mapping For Temporary Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemorySpaceNameforTemporaryVariable <em>Memory Space Namefor Temporary Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryAllocationSpaceTimeMap <em>Memory Allocation Space Time Map</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getValueCopySpaceTimeMap <em>Value Copy Space Time Map</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryFreeSpaceTimeMap <em>Memory Free Space Time Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization()
 * @model
 * @generated
 */
public interface UseEquationOptimization extends PolyhedralIRVisitable {
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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(boolean)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization_Input()
	 * @model required="true"
	 * @generated
	 */
	boolean isInput();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#isInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #isInput()
	 * @generated
	 */
	void setInput(boolean value);

	/**
	 * Returns the value of the '<em><b>Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num</em>' attribute.
	 * @see #setNum(int)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization_Num()
	 * @model required="true"
	 * @generated
	 */
	int getNum();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getNum <em>Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num</em>' attribute.
	 * @see #getNum()
	 * @generated
	 */
	void setNum(int value);

	/**
	 * Returns the value of the '<em><b>Memory Mapping For Temporary Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Mapping For Temporary Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Mapping For Temporary Variable</em>' containment reference.
	 * @see #setMemoryMappingForTemporaryVariable(AffineFunction)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization_MemoryMappingForTemporaryVariable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AffineFunction getMemoryMappingForTemporaryVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryMappingForTemporaryVariable <em>Memory Mapping For Temporary Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Mapping For Temporary Variable</em>' containment reference.
	 * @see #getMemoryMappingForTemporaryVariable()
	 * @generated
	 */
	void setMemoryMappingForTemporaryVariable(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Memory Space Namefor Temporary Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Space Namefor Temporary Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Space Namefor Temporary Variable</em>' attribute.
	 * @see #setMemorySpaceNameforTemporaryVariable(String)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization_MemorySpaceNameforTemporaryVariable()
	 * @model required="true"
	 * @generated
	 */
	String getMemorySpaceNameforTemporaryVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemorySpaceNameforTemporaryVariable <em>Memory Space Namefor Temporary Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Space Namefor Temporary Variable</em>' attribute.
	 * @see #getMemorySpaceNameforTemporaryVariable()
	 * @generated
	 */
	void setMemorySpaceNameforTemporaryVariable(String value);

	/**
	 * Returns the value of the '<em><b>Memory Allocation Space Time Map</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Allocation Space Time Map</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Allocation Space Time Map</em>' containment reference.
	 * @see #setMemoryAllocationSpaceTimeMap(AffineFunction)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization_MemoryAllocationSpaceTimeMap()
	 * @model containment="true"
	 * @generated
	 */
	AffineFunction getMemoryAllocationSpaceTimeMap();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryAllocationSpaceTimeMap <em>Memory Allocation Space Time Map</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Allocation Space Time Map</em>' containment reference.
	 * @see #getMemoryAllocationSpaceTimeMap()
	 * @generated
	 */
	void setMemoryAllocationSpaceTimeMap(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Value Copy Space Time Map</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Copy Space Time Map</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Copy Space Time Map</em>' containment reference.
	 * @see #setValueCopySpaceTimeMap(AffineFunction)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization_ValueCopySpaceTimeMap()
	 * @model containment="true"
	 * @generated
	 */
	AffineFunction getValueCopySpaceTimeMap();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getValueCopySpaceTimeMap <em>Value Copy Space Time Map</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Copy Space Time Map</em>' containment reference.
	 * @see #getValueCopySpaceTimeMap()
	 * @generated
	 */
	void setValueCopySpaceTimeMap(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Memory Free Space Time Map</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Free Space Time Map</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Free Space Time Map</em>' containment reference.
	 * @see #setMemoryFreeSpaceTimeMap(AffineFunction)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getUseEquationOptimization_MemoryFreeSpaceTimeMap()
	 * @model containment="true"
	 * @generated
	 */
	AffineFunction getMemoryFreeSpaceTimeMap();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryFreeSpaceTimeMap <em>Memory Free Space Time Map</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Free Space Time Map</em>' containment reference.
	 * @see #getMemoryFreeSpaceTimeMap()
	 * @generated
	 */
	void setMemoryFreeSpaceTimeMap(AffineFunction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitUseEquationOptimization(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // UseEquationOptimization
