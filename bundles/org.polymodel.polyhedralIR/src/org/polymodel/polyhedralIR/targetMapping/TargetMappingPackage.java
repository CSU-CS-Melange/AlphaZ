/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingFactory
 * @model kind="package"
 * @generated
 */
public interface TargetMappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "targetMapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "polyhedralIR.targetMapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "polyhedralIR.targetMapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TargetMappingPackage eINSTANCE = org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl <em>Target Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getTargetMapping()
	 * @generated
	 */
	int TARGET_MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Container System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_MAPPING__CONTAINER_SYSTEM = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Space Time Levels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_MAPPING__SPACE_TIME_LEVELS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Memory Maps</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_MAPPING__MEMORY_MAPS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Memory Spaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_MAPPING__MEMORY_SPACES = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Statement Orderings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_MAPPING__STATEMENT_ORDERINGS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Use Equation Optimizations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Target Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_MAPPING_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl <em>Space Time Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getSpaceTimeLevel()
	 * @generated
	 */
	int SPACE_TIME_LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Space Time Maps</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_LEVEL__SPACE_TIME_MAPS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ordering Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_LEVEL__ORDERING_DIMENSIONS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tiling Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_LEVEL__TILING_SPECIFICATIONS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Loop Unrolling Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Vectorization Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parallelization Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Container TM</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_LEVEL__CONTAINER_TM = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Space Time Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_LEVEL_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeMapImpl <em>Space Time Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeMapImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getSpaceTimeMap()
	 * @generated
	 */
	int SPACE_TIME_MAP = 2;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_MAP__MAPPING = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inverse Of Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_MAP__INVERSE_OF_MAPPING = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_MAP__LABEL = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Space Time Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_TIME_MAP_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.FeatureSpecificationImpl <em>Feature Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.FeatureSpecificationImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getFeatureSpecification()
	 * @generated
	 */
	int FEATURE_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Ordering Prefix</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SPECIFICATION__ORDERING_PREFIX = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SPECIFICATION_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl <em>Tiling Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getTilingSpecification()
	 * @generated
	 */
	int TILING_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Ordering Prefix</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_SPECIFICATION__ORDERING_PREFIX = FEATURE_SPECIFICATION__ORDERING_PREFIX;

	/**
	 * The feature id for the '<em><b>Start Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_SPECIFICATION__START_DIM = FEATURE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_SPECIFICATION__END_DIM = FEATURE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_SPECIFICATION__LEVELS = FEATURE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Tiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_SPECIFICATION__SUB_TILES = FEATURE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Identification Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_SPECIFICATION__IDENTIFICATION_NAME = FEATURE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Tiling Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_SPECIFICATION_FEATURE_COUNT = FEATURE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.LoopUnrollingSpecificationImpl <em>Loop Unrolling Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.LoopUnrollingSpecificationImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getLoopUnrollingSpecification()
	 * @generated
	 */
	int LOOP_UNROLLING_SPECIFICATION = 5;

	/**
	 * The feature id for the '<em><b>Ordering Prefix</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_UNROLLING_SPECIFICATION__ORDERING_PREFIX = FEATURE_SPECIFICATION__ORDERING_PREFIX;

	/**
	 * The feature id for the '<em><b>Unrolling Factors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_UNROLLING_SPECIFICATION__UNROLLING_FACTORS = FEATURE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Unrolling Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_UNROLLING_SPECIFICATION_FEATURE_COUNT = FEATURE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.VectorizationSpecificationImpl <em>Vectorization Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.VectorizationSpecificationImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getVectorizationSpecification()
	 * @generated
	 */
	int VECTORIZATION_SPECIFICATION = 6;

	/**
	 * The feature id for the '<em><b>Ordering Prefix</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTORIZATION_SPECIFICATION__ORDERING_PREFIX = FEATURE_SPECIFICATION__ORDERING_PREFIX;

	/**
	 * The number of structural features of the '<em>Vectorization Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTORIZATION_SPECIFICATION_FEATURE_COUNT = FEATURE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.ParallelizationSpecificationImpl <em>Parallelization Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.ParallelizationSpecificationImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getParallelizationSpecification()
	 * @generated
	 */
	int PARALLELIZATION_SPECIFICATION = 7;

	/**
	 * The feature id for the '<em><b>Ordering Prefix</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZATION_SPECIFICATION__ORDERING_PREFIX = FEATURE_SPECIFICATION__ORDERING_PREFIX;

	/**
	 * The feature id for the '<em><b>Parallel Dims</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZATION_SPECIFICATION__PARALLEL_DIMS = FEATURE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parallelization Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLELIZATION_SPECIFICATION_FEATURE_COUNT = FEATURE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.MemoryMapImpl <em>Memory Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.MemoryMapImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getMemoryMap()
	 * @generated
	 */
	int MEMORY_MAP = 8;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_MAP__VARIABLE = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_MAP__MAPPING = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mod Factors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_MAP__MOD_FACTORS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_MAP__SPACE = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Memory Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_MAP_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl <em>Memory Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getMemorySpace()
	 * @generated
	 */
	int MEMORY_SPACE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_SPACE__NAME = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_SPACE__TYPE = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_SPACE__DOMAIN = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Zero Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_SPACE__ZERO_ALIGNED = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Container TM</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_SPACE__CONTAINER_TM = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Memory Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_SPACE_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.StatementPartialOrderImpl <em>Statement Partial Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.StatementPartialOrderImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getStatementPartialOrder()
	 * @generated
	 */
	int STATEMENT_PARTIAL_ORDER = 10;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_PARTIAL_ORDER__PREDECESSOR = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_PARTIAL_ORDER__SUCCESSOR = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Statement Partial Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_PARTIAL_ORDER_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl <em>Use Equation Optimization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getUseEquationOptimization()
	 * @generated
	 */
	int USE_EQUATION_OPTIMIZATION = 11;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION__LABEL = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION__INPUT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION__NUM = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Memory Mapping For Temporary Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Memory Space Namefor Temporary Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION__MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Memory Allocation Space Time Map</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Value Copy Space Time Map</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Memory Free Space Time Map</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Use Equation Optimization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_OPTIMIZATION_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.CommunicationMappingForTiledSpaceImpl <em>Communication Mapping For Tiled Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.CommunicationMappingForTiledSpaceImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getCommunicationMappingForTiledSpace()
	 * @generated
	 */
	int COMMUNICATION_MAPPING_FOR_TILED_SPACE = 12;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MAPPING_FOR_TILED_SPACE__VARIABLES = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication Mapping For Tiled Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MAPPING_FOR_TILED_SPACE_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.CommunicatedVariableForTiledSpaceImpl <em>Communicated Variable For Tiled Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.CommunicatedVariableForTiledSpaceImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getCommunicatedVariableForTiledSpace()
	 * @generated
	 */
	int COMMUNICATED_VARIABLE_FOR_TILED_SPACE = 13;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Communication Depths</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATED_VARIABLE_FOR_TILED_SPACE__COMMUNICATION_DEPTHS = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Communicated Variable For Tiled Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATED_VARIABLE_FOR_TILED_SPACE_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl <em>Sub Tiling Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getSubTilingSpecification()
	 * @generated
	 */
	int SUB_TILING_SPECIFICATION = 14;

	/**
	 * The feature id for the '<em><b>Tile Sizes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILING_SPECIFICATION__TILE_SIZES = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tile Size Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILING_SPECIFICATION__TILE_SIZE_TYPE = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tiling Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILING_SPECIFICATION__TILING_TYPE = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILING_SPECIFICATION__START_DIM = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILING_SPECIFICATION__LEVEL = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Communication Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>End Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILING_SPECIFICATION__END_DIM = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Sub Tiling Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TILING_SPECIFICATION_FEATURE_COUNT = PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.TILING_TYPE <em>TILING TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.TILING_TYPE
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getTILING_TYPE()
	 * @generated
	 */
	int TILING_TYPE = 15;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE <em>TILE SIZE TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getTILE_SIZE_TYPE()
	 * @generated
	 */
	int TILE_SIZE_TYPE = 16;


	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE <em>MEMORY TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE
	 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getMEMORY_TYPE()
	 * @generated
	 */
	int MEMORY_TYPE = 17;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping <em>Target Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Mapping</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping
	 * @generated
	 */
	EClass getTargetMapping();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getContainerSystem <em>Container System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container System</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getContainerSystem()
	 * @see #getTargetMapping()
	 * @generated
	 */
	EReference getTargetMapping_ContainerSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getSpaceTimeLevels <em>Space Time Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Space Time Levels</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getSpaceTimeLevels()
	 * @see #getTargetMapping()
	 * @generated
	 */
	EReference getTargetMapping_SpaceTimeLevels();

	/**
	 * Returns the meta object for the map '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getMemoryMaps <em>Memory Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Memory Maps</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getMemoryMaps()
	 * @see #getTargetMapping()
	 * @generated
	 */
	EReference getTargetMapping_MemoryMaps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getMemorySpaces <em>Memory Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Memory Spaces</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getMemorySpaces()
	 * @see #getTargetMapping()
	 * @generated
	 */
	EReference getTargetMapping_MemorySpaces();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getStatementOrderings <em>Statement Orderings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statement Orderings</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getStatementOrderings()
	 * @see #getTargetMapping()
	 * @generated
	 */
	EReference getTargetMapping_StatementOrderings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping#getUseEquationOptimizations <em>Use Equation Optimizations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Equation Optimizations</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping#getUseEquationOptimizations()
	 * @see #getTargetMapping()
	 * @generated
	 */
	EReference getTargetMapping_UseEquationOptimizations();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel <em>Space Time Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Space Time Level</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel
	 * @generated
	 */
	EClass getSpaceTimeLevel();

	/**
	 * Returns the meta object for the map '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getSpaceTimeMaps <em>Space Time Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Space Time Maps</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getSpaceTimeMaps()
	 * @see #getSpaceTimeLevel()
	 * @generated
	 */
	EReference getSpaceTimeLevel_SpaceTimeMaps();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getOrderingDimensions <em>Ordering Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ordering Dimensions</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getOrderingDimensions()
	 * @see #getSpaceTimeLevel()
	 * @generated
	 */
	EAttribute getSpaceTimeLevel_OrderingDimensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getTilingSpecifications <em>Tiling Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tiling Specifications</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getTilingSpecifications()
	 * @see #getSpaceTimeLevel()
	 * @generated
	 */
	EReference getSpaceTimeLevel_TilingSpecifications();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getLoopUnrollingSpecifications <em>Loop Unrolling Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Loop Unrolling Specifications</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getLoopUnrollingSpecifications()
	 * @see #getSpaceTimeLevel()
	 * @generated
	 */
	EReference getSpaceTimeLevel_LoopUnrollingSpecifications();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getVectorizationSpecifications <em>Vectorization Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vectorization Specifications</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getVectorizationSpecifications()
	 * @see #getSpaceTimeLevel()
	 * @generated
	 */
	EReference getSpaceTimeLevel_VectorizationSpecifications();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getParallelizationSpecifications <em>Parallelization Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parallelization Specifications</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getParallelizationSpecifications()
	 * @see #getSpaceTimeLevel()
	 * @generated
	 */
	EReference getSpaceTimeLevel_ParallelizationSpecifications();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getContainerTM <em>Container TM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container TM</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel#getContainerTM()
	 * @see #getSpaceTimeLevel()
	 * @generated
	 */
	EReference getSpaceTimeLevel_ContainerTM();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap <em>Space Time Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Space Time Map</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap
	 * @generated
	 */
	EClass getSpaceTimeMap();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getMapping()
	 * @see #getSpaceTimeMap()
	 * @generated
	 */
	EReference getSpaceTimeMap_Mapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getInverseOfMapping <em>Inverse Of Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inverse Of Mapping</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getInverseOfMapping()
	 * @see #getSpaceTimeMap()
	 * @generated
	 */
	EReference getSpaceTimeMap_InverseOfMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap#getLabel()
	 * @see #getSpaceTimeMap()
	 * @generated
	 */
	EAttribute getSpaceTimeMap_Label();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.FeatureSpecification <em>Feature Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Specification</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.FeatureSpecification
	 * @generated
	 */
	EClass getFeatureSpecification();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.targetMapping.FeatureSpecification#getOrderingPrefix <em>Ordering Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ordering Prefix</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.FeatureSpecification#getOrderingPrefix()
	 * @see #getFeatureSpecification()
	 * @generated
	 */
	EAttribute getFeatureSpecification_OrderingPrefix();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification <em>Tiling Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tiling Specification</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TilingSpecification
	 * @generated
	 */
	EClass getTilingSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getStartDim <em>Start Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Dim</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getStartDim()
	 * @see #getTilingSpecification()
	 * @generated
	 */
	EAttribute getTilingSpecification_StartDim();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getEndDim <em>End Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Dim</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getEndDim()
	 * @see #getTilingSpecification()
	 * @generated
	 */
	EAttribute getTilingSpecification_EndDim();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getLevels <em>Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Levels</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getLevels()
	 * @see #getTilingSpecification()
	 * @generated
	 */
	EAttribute getTilingSpecification_Levels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getSubTiles <em>Sub Tiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Tiles</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getSubTiles()
	 * @see #getTilingSpecification()
	 * @generated
	 */
	EReference getTilingSpecification_SubTiles();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getIdentificationName <em>Identification Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identification Name</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getIdentificationName()
	 * @see #getTilingSpecification()
	 * @generated
	 */
	EAttribute getTilingSpecification_IdentificationName();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification <em>Loop Unrolling Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Unrolling Specification</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification
	 * @generated
	 */
	EClass getLoopUnrollingSpecification();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification#getUnrollingFactors <em>Unrolling Factors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Unrolling Factors</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification#getUnrollingFactors()
	 * @see #getLoopUnrollingSpecification()
	 * @generated
	 */
	EAttribute getLoopUnrollingSpecification_UnrollingFactors();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification <em>Vectorization Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vectorization Specification</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification
	 * @generated
	 */
	EClass getVectorizationSpecification();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification <em>Parallelization Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallelization Specification</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification
	 * @generated
	 */
	EClass getParallelizationSpecification();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification#getParallelDims <em>Parallel Dims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parallel Dims</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification#getParallelDims()
	 * @see #getParallelizationSpecification()
	 * @generated
	 */
	EAttribute getParallelizationSpecification_ParallelDims();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap <em>Memory Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Map</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemoryMap
	 * @generated
	 */
	EClass getMemoryMap();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemoryMap#getVariable()
	 * @see #getMemoryMap()
	 * @generated
	 */
	EReference getMemoryMap_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemoryMap#getMapping()
	 * @see #getMemoryMap()
	 * @generated
	 */
	EReference getMemoryMap_Mapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getModFactors <em>Mod Factors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mod Factors</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemoryMap#getModFactors()
	 * @see #getMemoryMap()
	 * @generated
	 */
	EReference getMemoryMap_ModFactors();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap#getSpace <em>Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Space</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemoryMap#getSpace()
	 * @see #getMemoryMap()
	 * @generated
	 */
	EReference getMemoryMap_Space();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace <em>Memory Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Space</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemorySpace
	 * @generated
	 */
	EClass getMemorySpace();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemorySpace#getName()
	 * @see #getMemorySpace()
	 * @generated
	 */
	EAttribute getMemorySpace_Name();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemorySpace#getType()
	 * @see #getMemorySpace()
	 * @generated
	 */
	EReference getMemorySpace_Type();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemorySpace#getDomain()
	 * @see #getMemorySpace()
	 * @generated
	 */
	EReference getMemorySpace_Domain();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#isZeroAligned <em>Zero Aligned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zero Aligned</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemorySpace#isZeroAligned()
	 * @see #getMemorySpace()
	 * @generated
	 */
	EAttribute getMemorySpace_ZeroAligned();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace#getContainerTM <em>Container TM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container TM</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemorySpace#getContainerTM()
	 * @see #getMemorySpace()
	 * @generated
	 */
	EReference getMemorySpace_ContainerTM();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder <em>Statement Partial Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement Partial Order</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder
	 * @generated
	 */
	EClass getStatementPartialOrder();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder#getPredecessor()
	 * @see #getStatementPartialOrder()
	 * @generated
	 */
	EReference getStatementPartialOrder_Predecessor();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder#getSuccessor()
	 * @see #getStatementPartialOrder()
	 * @generated
	 */
	EReference getStatementPartialOrder_Successor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization <em>Use Equation Optimization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Equation Optimization</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization
	 * @generated
	 */
	EClass getUseEquationOptimization();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getLabel()
	 * @see #getUseEquationOptimization()
	 * @generated
	 */
	EAttribute getUseEquationOptimization_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#isInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#isInput()
	 * @see #getUseEquationOptimization()
	 * @generated
	 */
	EAttribute getUseEquationOptimization_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getNum <em>Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getNum()
	 * @see #getUseEquationOptimization()
	 * @generated
	 */
	EAttribute getUseEquationOptimization_Num();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryMappingForTemporaryVariable <em>Memory Mapping For Temporary Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Memory Mapping For Temporary Variable</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryMappingForTemporaryVariable()
	 * @see #getUseEquationOptimization()
	 * @generated
	 */
	EReference getUseEquationOptimization_MemoryMappingForTemporaryVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemorySpaceNameforTemporaryVariable <em>Memory Space Namefor Temporary Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Space Namefor Temporary Variable</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemorySpaceNameforTemporaryVariable()
	 * @see #getUseEquationOptimization()
	 * @generated
	 */
	EAttribute getUseEquationOptimization_MemorySpaceNameforTemporaryVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryAllocationSpaceTimeMap <em>Memory Allocation Space Time Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Memory Allocation Space Time Map</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryAllocationSpaceTimeMap()
	 * @see #getUseEquationOptimization()
	 * @generated
	 */
	EReference getUseEquationOptimization_MemoryAllocationSpaceTimeMap();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getValueCopySpaceTimeMap <em>Value Copy Space Time Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Copy Space Time Map</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getValueCopySpaceTimeMap()
	 * @see #getUseEquationOptimization()
	 * @generated
	 */
	EReference getUseEquationOptimization_ValueCopySpaceTimeMap();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryFreeSpaceTimeMap <em>Memory Free Space Time Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Memory Free Space Time Map</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization#getMemoryFreeSpaceTimeMap()
	 * @see #getUseEquationOptimization()
	 * @generated
	 */
	EReference getUseEquationOptimization_MemoryFreeSpaceTimeMap();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace <em>Communication Mapping For Tiled Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Mapping For Tiled Space</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace
	 * @generated
	 */
	EClass getCommunicationMappingForTiledSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace#getVariables()
	 * @see #getCommunicationMappingForTiledSpace()
	 * @generated
	 */
	EReference getCommunicationMappingForTiledSpace_Variables();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace <em>Communicated Variable For Tiled Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communicated Variable For Tiled Space</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace
	 * @generated
	 */
	EClass getCommunicatedVariableForTiledSpace();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace#getVariable()
	 * @see #getCommunicatedVariableForTiledSpace()
	 * @generated
	 */
	EReference getCommunicatedVariableForTiledSpace_Variable();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace#getCommunicationDepths <em>Communication Depths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Communication Depths</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace#getCommunicationDepths()
	 * @see #getCommunicatedVariableForTiledSpace()
	 * @generated
	 */
	EAttribute getCommunicatedVariableForTiledSpace_CommunicationDepths();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification <em>Sub Tiling Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Tiling Specification</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification
	 * @generated
	 */
	EClass getSubTilingSpecification();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTileSizes <em>Tile Sizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tile Sizes</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTileSizes()
	 * @see #getSubTilingSpecification()
	 * @generated
	 */
	EAttribute getSubTilingSpecification_TileSizes();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTileSizeType <em>Tile Size Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tile Size Type</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTileSizeType()
	 * @see #getSubTilingSpecification()
	 * @generated
	 */
	EAttribute getSubTilingSpecification_TileSizeType();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTilingType <em>Tiling Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tiling Type</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTilingType()
	 * @see #getSubTilingSpecification()
	 * @generated
	 */
	EAttribute getSubTilingSpecification_TilingType();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getStartDim <em>Start Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Dim</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getStartDim()
	 * @see #getSubTilingSpecification()
	 * @generated
	 */
	EAttribute getSubTilingSpecification_StartDim();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getLevel()
	 * @see #getSubTilingSpecification()
	 * @generated
	 */
	EAttribute getSubTilingSpecification_Level();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getCommunicationMapping <em>Communication Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Communication Mapping</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getCommunicationMapping()
	 * @see #getSubTilingSpecification()
	 * @generated
	 */
	EReference getSubTilingSpecification_CommunicationMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getEndDim <em>End Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Dim</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getEndDim()
	 * @see #getSubTilingSpecification()
	 * @generated
	 */
	EAttribute getSubTilingSpecification_EndDim();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.targetMapping.TILING_TYPE <em>TILING TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TILING TYPE</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TILING_TYPE
	 * @generated
	 */
	EEnum getTILING_TYPE();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE <em>TILE SIZE TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TILE SIZE TYPE</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE
	 * @generated
	 */
	EEnum getTILE_SIZE_TYPE();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE <em>MEMORY TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>MEMORY TYPE</em>'.
	 * @see org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE
	 * @generated
	 */
	EEnum getMEMORY_TYPE();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TargetMappingFactory getTargetMappingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl <em>Target Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getTargetMapping()
		 * @generated
		 */
		EClass TARGET_MAPPING = eINSTANCE.getTargetMapping();

		/**
		 * The meta object literal for the '<em><b>Container System</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_MAPPING__CONTAINER_SYSTEM = eINSTANCE.getTargetMapping_ContainerSystem();

		/**
		 * The meta object literal for the '<em><b>Space Time Levels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_MAPPING__SPACE_TIME_LEVELS = eINSTANCE.getTargetMapping_SpaceTimeLevels();

		/**
		 * The meta object literal for the '<em><b>Memory Maps</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_MAPPING__MEMORY_MAPS = eINSTANCE.getTargetMapping_MemoryMaps();

		/**
		 * The meta object literal for the '<em><b>Memory Spaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_MAPPING__MEMORY_SPACES = eINSTANCE.getTargetMapping_MemorySpaces();

		/**
		 * The meta object literal for the '<em><b>Statement Orderings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_MAPPING__STATEMENT_ORDERINGS = eINSTANCE.getTargetMapping_StatementOrderings();

		/**
		 * The meta object literal for the '<em><b>Use Equation Optimizations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS = eINSTANCE.getTargetMapping_UseEquationOptimizations();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl <em>Space Time Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getSpaceTimeLevel()
		 * @generated
		 */
		EClass SPACE_TIME_LEVEL = eINSTANCE.getSpaceTimeLevel();

		/**
		 * The meta object literal for the '<em><b>Space Time Maps</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_TIME_LEVEL__SPACE_TIME_MAPS = eINSTANCE.getSpaceTimeLevel_SpaceTimeMaps();

		/**
		 * The meta object literal for the '<em><b>Ordering Dimensions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPACE_TIME_LEVEL__ORDERING_DIMENSIONS = eINSTANCE.getSpaceTimeLevel_OrderingDimensions();

		/**
		 * The meta object literal for the '<em><b>Tiling Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_TIME_LEVEL__TILING_SPECIFICATIONS = eINSTANCE.getSpaceTimeLevel_TilingSpecifications();

		/**
		 * The meta object literal for the '<em><b>Loop Unrolling Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS = eINSTANCE.getSpaceTimeLevel_LoopUnrollingSpecifications();

		/**
		 * The meta object literal for the '<em><b>Vectorization Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS = eINSTANCE.getSpaceTimeLevel_VectorizationSpecifications();

		/**
		 * The meta object literal for the '<em><b>Parallelization Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS = eINSTANCE.getSpaceTimeLevel_ParallelizationSpecifications();

		/**
		 * The meta object literal for the '<em><b>Container TM</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_TIME_LEVEL__CONTAINER_TM = eINSTANCE.getSpaceTimeLevel_ContainerTM();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeMapImpl <em>Space Time Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeMapImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getSpaceTimeMap()
		 * @generated
		 */
		EClass SPACE_TIME_MAP = eINSTANCE.getSpaceTimeMap();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_TIME_MAP__MAPPING = eINSTANCE.getSpaceTimeMap_Mapping();

		/**
		 * The meta object literal for the '<em><b>Inverse Of Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_TIME_MAP__INVERSE_OF_MAPPING = eINSTANCE.getSpaceTimeMap_InverseOfMapping();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPACE_TIME_MAP__LABEL = eINSTANCE.getSpaceTimeMap_Label();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.FeatureSpecificationImpl <em>Feature Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.FeatureSpecificationImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getFeatureSpecification()
		 * @generated
		 */
		EClass FEATURE_SPECIFICATION = eINSTANCE.getFeatureSpecification();

		/**
		 * The meta object literal for the '<em><b>Ordering Prefix</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_SPECIFICATION__ORDERING_PREFIX = eINSTANCE.getFeatureSpecification_OrderingPrefix();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl <em>Tiling Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TilingSpecificationImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getTilingSpecification()
		 * @generated
		 */
		EClass TILING_SPECIFICATION = eINSTANCE.getTilingSpecification();

		/**
		 * The meta object literal for the '<em><b>Start Dim</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILING_SPECIFICATION__START_DIM = eINSTANCE.getTilingSpecification_StartDim();

		/**
		 * The meta object literal for the '<em><b>End Dim</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILING_SPECIFICATION__END_DIM = eINSTANCE.getTilingSpecification_EndDim();

		/**
		 * The meta object literal for the '<em><b>Levels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILING_SPECIFICATION__LEVELS = eINSTANCE.getTilingSpecification_Levels();

		/**
		 * The meta object literal for the '<em><b>Sub Tiles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILING_SPECIFICATION__SUB_TILES = eINSTANCE.getTilingSpecification_SubTiles();

		/**
		 * The meta object literal for the '<em><b>Identification Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILING_SPECIFICATION__IDENTIFICATION_NAME = eINSTANCE.getTilingSpecification_IdentificationName();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.LoopUnrollingSpecificationImpl <em>Loop Unrolling Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.LoopUnrollingSpecificationImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getLoopUnrollingSpecification()
		 * @generated
		 */
		EClass LOOP_UNROLLING_SPECIFICATION = eINSTANCE.getLoopUnrollingSpecification();

		/**
		 * The meta object literal for the '<em><b>Unrolling Factors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_UNROLLING_SPECIFICATION__UNROLLING_FACTORS = eINSTANCE.getLoopUnrollingSpecification_UnrollingFactors();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.VectorizationSpecificationImpl <em>Vectorization Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.VectorizationSpecificationImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getVectorizationSpecification()
		 * @generated
		 */
		EClass VECTORIZATION_SPECIFICATION = eINSTANCE.getVectorizationSpecification();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.ParallelizationSpecificationImpl <em>Parallelization Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.ParallelizationSpecificationImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getParallelizationSpecification()
		 * @generated
		 */
		EClass PARALLELIZATION_SPECIFICATION = eINSTANCE.getParallelizationSpecification();

		/**
		 * The meta object literal for the '<em><b>Parallel Dims</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARALLELIZATION_SPECIFICATION__PARALLEL_DIMS = eINSTANCE.getParallelizationSpecification_ParallelDims();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.MemoryMapImpl <em>Memory Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.MemoryMapImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getMemoryMap()
		 * @generated
		 */
		EClass MEMORY_MAP = eINSTANCE.getMemoryMap();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_MAP__VARIABLE = eINSTANCE.getMemoryMap_Variable();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_MAP__MAPPING = eINSTANCE.getMemoryMap_Mapping();

		/**
		 * The meta object literal for the '<em><b>Mod Factors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_MAP__MOD_FACTORS = eINSTANCE.getMemoryMap_ModFactors();

		/**
		 * The meta object literal for the '<em><b>Space</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_MAP__SPACE = eINSTANCE.getMemoryMap_Space();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl <em>Memory Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getMemorySpace()
		 * @generated
		 */
		EClass MEMORY_SPACE = eINSTANCE.getMemorySpace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY_SPACE__NAME = eINSTANCE.getMemorySpace_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_SPACE__TYPE = eINSTANCE.getMemorySpace_Type();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_SPACE__DOMAIN = eINSTANCE.getMemorySpace_Domain();

		/**
		 * The meta object literal for the '<em><b>Zero Aligned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY_SPACE__ZERO_ALIGNED = eINSTANCE.getMemorySpace_ZeroAligned();

		/**
		 * The meta object literal for the '<em><b>Container TM</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_SPACE__CONTAINER_TM = eINSTANCE.getMemorySpace_ContainerTM();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.StatementPartialOrderImpl <em>Statement Partial Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.StatementPartialOrderImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getStatementPartialOrder()
		 * @generated
		 */
		EClass STATEMENT_PARTIAL_ORDER = eINSTANCE.getStatementPartialOrder();

		/**
		 * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMENT_PARTIAL_ORDER__PREDECESSOR = eINSTANCE.getStatementPartialOrder_Predecessor();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMENT_PARTIAL_ORDER__SUCCESSOR = eINSTANCE.getStatementPartialOrder_Successor();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl <em>Use Equation Optimization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.UseEquationOptimizationImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getUseEquationOptimization()
		 * @generated
		 */
		EClass USE_EQUATION_OPTIMIZATION = eINSTANCE.getUseEquationOptimization();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_EQUATION_OPTIMIZATION__LABEL = eINSTANCE.getUseEquationOptimization_Label();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_EQUATION_OPTIMIZATION__INPUT = eINSTANCE.getUseEquationOptimization_Input();

		/**
		 * The meta object literal for the '<em><b>Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_EQUATION_OPTIMIZATION__NUM = eINSTANCE.getUseEquationOptimization_Num();

		/**
		 * The meta object literal for the '<em><b>Memory Mapping For Temporary Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE = eINSTANCE.getUseEquationOptimization_MemoryMappingForTemporaryVariable();

		/**
		 * The meta object literal for the '<em><b>Memory Space Namefor Temporary Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_EQUATION_OPTIMIZATION__MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE = eINSTANCE.getUseEquationOptimization_MemorySpaceNameforTemporaryVariable();

		/**
		 * The meta object literal for the '<em><b>Memory Allocation Space Time Map</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP = eINSTANCE.getUseEquationOptimization_MemoryAllocationSpaceTimeMap();

		/**
		 * The meta object literal for the '<em><b>Value Copy Space Time Map</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP = eINSTANCE.getUseEquationOptimization_ValueCopySpaceTimeMap();

		/**
		 * The meta object literal for the '<em><b>Memory Free Space Time Map</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP = eINSTANCE.getUseEquationOptimization_MemoryFreeSpaceTimeMap();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.CommunicationMappingForTiledSpaceImpl <em>Communication Mapping For Tiled Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.CommunicationMappingForTiledSpaceImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getCommunicationMappingForTiledSpace()
		 * @generated
		 */
		EClass COMMUNICATION_MAPPING_FOR_TILED_SPACE = eINSTANCE.getCommunicationMappingForTiledSpace();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION_MAPPING_FOR_TILED_SPACE__VARIABLES = eINSTANCE.getCommunicationMappingForTiledSpace_Variables();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.CommunicatedVariableForTiledSpaceImpl <em>Communicated Variable For Tiled Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.CommunicatedVariableForTiledSpaceImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getCommunicatedVariableForTiledSpace()
		 * @generated
		 */
		EClass COMMUNICATED_VARIABLE_FOR_TILED_SPACE = eINSTANCE.getCommunicatedVariableForTiledSpace();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE = eINSTANCE.getCommunicatedVariableForTiledSpace_Variable();

		/**
		 * The meta object literal for the '<em><b>Communication Depths</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATED_VARIABLE_FOR_TILED_SPACE__COMMUNICATION_DEPTHS = eINSTANCE.getCommunicatedVariableForTiledSpace_CommunicationDepths();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl <em>Sub Tiling Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.SubTilingSpecificationImpl
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getSubTilingSpecification()
		 * @generated
		 */
		EClass SUB_TILING_SPECIFICATION = eINSTANCE.getSubTilingSpecification();

		/**
		 * The meta object literal for the '<em><b>Tile Sizes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILING_SPECIFICATION__TILE_SIZES = eINSTANCE.getSubTilingSpecification_TileSizes();

		/**
		 * The meta object literal for the '<em><b>Tile Size Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILING_SPECIFICATION__TILE_SIZE_TYPE = eINSTANCE.getSubTilingSpecification_TileSizeType();

		/**
		 * The meta object literal for the '<em><b>Tiling Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILING_SPECIFICATION__TILING_TYPE = eINSTANCE.getSubTilingSpecification_TilingType();

		/**
		 * The meta object literal for the '<em><b>Start Dim</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILING_SPECIFICATION__START_DIM = eINSTANCE.getSubTilingSpecification_StartDim();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILING_SPECIFICATION__LEVEL = eINSTANCE.getSubTilingSpecification_Level();

		/**
		 * The meta object literal for the '<em><b>Communication Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING = eINSTANCE.getSubTilingSpecification_CommunicationMapping();

		/**
		 * The meta object literal for the '<em><b>End Dim</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_TILING_SPECIFICATION__END_DIM = eINSTANCE.getSubTilingSpecification_EndDim();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.TILING_TYPE <em>TILING TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.TILING_TYPE
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getTILING_TYPE()
		 * @generated
		 */
		EEnum TILING_TYPE = eINSTANCE.getTILING_TYPE();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE <em>TILE SIZE TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getTILE_SIZE_TYPE()
		 * @generated
		 */
		EEnum TILE_SIZE_TYPE = eINSTANCE.getTILE_SIZE_TYPE();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE <em>MEMORY TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE
		 * @see org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl#getMEMORY_TYPE()
		 * @generated
		 */
		EEnum MEMORY_TYPE = eINSTANCE.getMEMORY_TYPE();

	}

} //TargetMappingPackage
