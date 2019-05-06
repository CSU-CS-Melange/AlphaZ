/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getContainerSystem <em>Container System</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getSpaceTimeLevels <em>Space Time Levels</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getMemoryMaps <em>Memory Maps</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getMemorySpaces <em>Memory Spaces</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getStatementOrderings <em>Statement Orderings</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getUseEquationOptimizations <em>Use Equation Optimizations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTargetMapping()
 * @model
 * @generated
 */
public interface TargetMapping extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Container System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.AffineSystem#getTargetMapping <em>Target Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container System</em>' container reference.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTargetMapping_ContainerSystem()
	 * @see org.polymodel.polyhedralIR.AffineSystem#getTargetMapping
	 * @model opposite="targetMapping" unsettable="true" required="true" transient="false" changeable="false"
	 * @generated
	 */
	AffineSystem getContainerSystem();

	/**
	 * Returns the value of the '<em><b>Space Time Levels</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getContainerTM <em>Container TM</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Space Time Levels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Space Time Levels</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTargetMapping_SpaceTimeLevels()
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getContainerTM
	 * @model opposite="containerTM" containment="true"
	 * @generated
	 */
	EList<SpaceTimeLevel> getSpaceTimeLevels();

	/**
	 * Returns the value of the '<em><b>Memory Maps</b></em>' map.
	 * The key is of type {@link K},
	 * and the value is of type {@link V},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Maps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Maps</em>' map.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTargetMapping_MemoryMaps()
	 * @model mapType="org.polymodel.ValueContainedMap<K, V>"
	 * @generated
	 */
	EMap<VariableDeclaration, MemoryMap> getMemoryMaps();

	/**
	 * Returns the value of the '<em><b>Memory Spaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.MemorySpace}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getContainerTM <em>Container TM</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Spaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Spaces</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTargetMapping_MemorySpaces()
	 * @see org.polymodel.polyhedralIR.targetMapping.MemorySpace#getContainerTM
	 * @model opposite="containerTM" containment="true"
	 * @generated
	 */
	EList<MemorySpace> getMemorySpaces();

	/**
	 * Returns the value of the '<em><b>Statement Orderings</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement Orderings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement Orderings</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTargetMapping_StatementOrderings()
	 * @model containment="true"
	 * @generated
	 */
	EList<StatementPartialOrder> getStatementOrderings();

	/**
	 * Returns the value of the '<em><b>Use Equation Optimizations</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Equation Optimizations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Equation Optimizations</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTargetMapping_UseEquationOptimizations()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseEquationOptimization> getUseEquationOptimizations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model levelRequired="true"
	 * @generated
	 */
	SpaceTimeLevel getSpaceTimeLevel(int level);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Equation> getStatementTotalOrder();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isTiled();

	/**
	 * <!-- begin-user-doc -->
	 * Returns MemorySpace with the speceified name. Creates one if its does not exist.
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	MemorySpace getMemorySpace(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model labelRequired="true"
	 * @generated
	 */
	EList<UseEquationOptimization> getUseEquationOptimizations(String label);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model labelRequired="true" numRequired="true" isInputRequired="true"
	 * @generated
	 */
	UseEquationOptimization getUseEquationOptimization(String label, int num, boolean isInput);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isParallelized();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitTargetMapping(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

	TilingSpecification getTilingSpecification(int level, String name);

} // TargetMapping
