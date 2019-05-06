/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage
 * @generated
 */
public interface TargetMappingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TargetMappingFactory eINSTANCE = org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Target Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Mapping</em>'.
	 * @generated
	 */
	TargetMapping createTargetMapping();

	/**
	 * Returns a new object of class '<em>Space Time Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Space Time Level</em>'.
	 * @generated
	 */
	SpaceTimeLevel createSpaceTimeLevel();

	/**
	 * Returns a new object of class '<em>Space Time Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Space Time Map</em>'.
	 * @generated
	 */
	SpaceTimeMap createSpaceTimeMap();

	/**
	 * Returns a new object of class '<em>Tiling Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tiling Specification</em>'.
	 * @generated
	 */
	TilingSpecification createTilingSpecification();

	/**
	 * Returns a new object of class '<em>Loop Unrolling Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Unrolling Specification</em>'.
	 * @generated
	 */
	LoopUnrollingSpecification createLoopUnrollingSpecification();

	/**
	 * Returns a new object of class '<em>Vectorization Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vectorization Specification</em>'.
	 * @generated
	 */
	VectorizationSpecification createVectorizationSpecification();

	/**
	 * Returns a new object of class '<em>Parallelization Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallelization Specification</em>'.
	 * @generated
	 */
	ParallelizationSpecification createParallelizationSpecification();

	/**
	 * Returns a new object of class '<em>Memory Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Map</em>'.
	 * @generated
	 */
	MemoryMap createMemoryMap();

	/**
	 * Returns a new object of class '<em>Memory Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Space</em>'.
	 * @generated
	 */
	MemorySpace createMemorySpace();

	/**
	 * Returns a new object of class '<em>Statement Partial Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement Partial Order</em>'.
	 * @generated
	 */
	StatementPartialOrder createStatementPartialOrder();

	/**
	 * Returns a new object of class '<em>Use Equation Optimization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Equation Optimization</em>'.
	 * @generated
	 */
	UseEquationOptimization createUseEquationOptimization();

	/**
	 * Returns a new object of class '<em>Communication Mapping For Tiled Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Mapping For Tiled Space</em>'.
	 * @generated
	 */
	CommunicationMappingForTiledSpace createCommunicationMappingForTiledSpace();

	/**
	 * Returns a new object of class '<em>Communicated Variable For Tiled Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communicated Variable For Tiled Space</em>'.
	 * @generated
	 */
	CommunicatedVariableForTiledSpace createCommunicatedVariableForTiledSpace();

	/**
	 * Returns a new object of class '<em>Sub Tiling Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Tiling Specification</em>'.
	 * @generated
	 */
	SubTilingSpecification createSubTilingSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TargetMappingPackage getTargetMappingPackage();

} //TargetMappingFactory
