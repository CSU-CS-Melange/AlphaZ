/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Space Time Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getSpaceTimeMaps <em>Space Time Maps</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getOrderingDimensions <em>Ordering Dimensions</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getTilingSpecifications <em>Tiling Specifications</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getLoopUnrollingSpecifications <em>Loop Unrolling Specifications</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getVectorizationSpecifications <em>Vectorization Specifications</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getParallelizationSpecifications <em>Parallelization Specifications</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getContainerTM <em>Container TM</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeLevel()
 * @model
 * @generated
 */
public interface SpaceTimeLevel extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Space Time Maps</b></em>' map.
	 * The key is of type {@link K},
	 * and the value is of type {@link V},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Space Time Maps</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Space Time Maps</em>' map.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeLevel_SpaceTimeMaps()
	 * @model mapType="org.polymodel.ValueContainedMap<K, V>"
	 * @generated
	 */
	EMap<String, SpaceTimeMap> getSpaceTimeMaps();

	/**
	 * Returns the value of the '<em><b>Ordering Dimensions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordering Dimensions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordering Dimensions</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeLevel_OrderingDimensions()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getOrderingDimensions();

	/**
	 * Returns the value of the '<em><b>Tiling Specifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Specifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Specifications</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeLevel_TilingSpecifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<TilingSpecification> getTilingSpecifications();

	/**
	 * Returns the value of the '<em><b>Loop Unrolling Specifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Unrolling Specifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Unrolling Specifications</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeLevel_LoopUnrollingSpecifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<LoopUnrollingSpecification> getLoopUnrollingSpecifications();

	/**
	 * Returns the value of the '<em><b>Vectorization Specifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vectorization Specifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vectorization Specifications</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeLevel_VectorizationSpecifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<VectorizationSpecification> getVectorizationSpecifications();

	/**
	 * Returns the value of the '<em><b>Parallelization Specifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallelization Specifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallelization Specifications</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeLevel_ParallelizationSpecifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParallelizationSpecification> getParallelizationSpecifications();

	/**
	 * Returns the value of the '<em><b>Container TM</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getSpaceTimeLevels <em>Space Time Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container TM</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container TM</em>' container reference.
	 * @see #setContainerTM(TargetMapping)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSpaceTimeLevel_ContainerTM()
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getSpaceTimeLevels
	 * @model opposite="spaceTimeLevels" required="true" transient="false"
	 * @generated
	 */
	TargetMapping getContainerTM();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getContainerTM <em>Container TM</em>}' container reference.
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
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNumberOfOrderingDimensions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNumberOfTiledDimensions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNumberOfParallelDimensions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNumberOfSequentialDimensions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNumberOfDimensions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" variableRequired="true"
	 * @generated
	 */
	AffineFunction getAccessFunction(VariableDeclaration variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" bandNameRequired="true"
	 * @generated
	 */
	TilingSpecification getTilingSpecification(String bandName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitSpaceTimeLevel(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // SpaceTimeLevel
