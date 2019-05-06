/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedFactory
 * @model kind="package"
 * @generated
 */
public interface CDistributedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "distributed";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "distributed";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "distributed";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CDistributedPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.PartitioningComputationImpl <em>Partitioning Computation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.PartitioningComputationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getPartitioningComputation()
	 * @generated
	 */
	int PARTITIONING_COMPUTATION = 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONING_COMPUTATION__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Partitioned Tile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONING_COMPUTATION__PARTITIONED_TILE = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Partitioning Computation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONING_COMPUTATION_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.DistributedPseudoProjectionImpl <em>Distributed Pseudo Projection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.DistributedPseudoProjectionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getDistributedPseudoProjection()
	 * @generated
	 */
	int DISTRIBUTED_PSEUDO_PROJECTION = 1;

	/**
	 * The feature id for the '<em><b>Zero Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PSEUDO_PROJECTION__ZERO_ALIGNED = PolyIRCGPackage.PSEUDO_PROJECTION__ZERO_ALIGNED;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PSEUDO_PROJECTION__DOMAIN = PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN;

	/**
	 * The feature id for the '<em><b>Mod Factors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PSEUDO_PROJECTION__MOD_FACTORS = PolyIRCGPackage.PSEUDO_PROJECTION__MOD_FACTORS;

	/**
	 * The feature id for the '<em><b>Distributed Dims</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIMS = PolyIRCGPackage.PSEUDO_PROJECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Distributed Dim Sizes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES = PolyIRCGPackage.PSEUDO_PROJECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Distributed Pseudo Projection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PSEUDO_PROJECTION_FEATURE_COUNT = PolyIRCGPackage.PSEUDO_PROJECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.MPICLoopImpl <em>MPIC Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.MPICLoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getMPICLoop()
	 * @generated
	 */
	int MPIC_LOOP = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__FUNCTION = CPackage.TILED_CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__PARAMETER_DOMAIN = CPackage.TILED_CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__STATEMENTS = CPackage.TILED_CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__DECLARE_ITERATORS = CPackage.TILED_CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__ITERATOR_NAMES = CPackage.TILED_CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__NUM_CONSTANT_DIMENSIONS = CPackage.TILED_CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__USE_MACROS = CPackage.TILED_CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Optimize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__OPTIMIZE = CPackage.TILED_CLOOP__OPTIMIZE;

	/**
	 * The feature id for the '<em><b>Tiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__TILES = CPackage.TILED_CLOOP__TILES;

	/**
	 * The feature id for the '<em><b>Ordering Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__ORDERING_DIMENSIONS = CPackage.TILED_CLOOP__ORDERING_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Optimized Point Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__OPTIMIZED_POINT_LOOP = CPackage.TILED_CLOOP__OPTIMIZED_POINT_LOOP;

	/**
	 * The feature id for the '<em><b>Buffers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP__BUFFERS = CPackage.TILED_CLOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MPIC Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPIC_LOOP_FEATURE_COUNT = CPackage.TILED_CLOOP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMappingImpl <em>Buffer Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMappingImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getBufferMapping()
	 * @generated
	 */
	int BUFFER_MAPPING = 3;

	/**
	 * The feature id for the '<em><b>Value Access</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MAPPING__VALUE_ACCESS = 0;

	/**
	 * The feature id for the '<em><b>Buffer Access</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MAPPING__BUFFER_ACCESS = 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MAPPING__DOMAIN = 2;

	/**
	 * The feature id for the '<em><b>Communicated Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MAPPING__COMMUNICATED_VARIABLE = 3;

	/**
	 * The number of structural features of the '<em>Buffer Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MAPPING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 4;

	/**
	 * The feature id for the '<em><b>Buffer Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__BUFFER_MAPPINGS = 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__VARIABLE = 1;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMemoryDomainImpl <em>Buffer Memory Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMemoryDomainImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getBufferMemoryDomain()
	 * @generated
	 */
	int BUFFER_MEMORY_DOMAIN = 5;

	/**
	 * The feature id for the '<em><b>Zero Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY_DOMAIN__ZERO_ALIGNED = PolyIRCGPackage.MERGED_MEMORY_DOMAIN__ZERO_ALIGNED;

	/**
	 * The feature id for the '<em><b>Memory Domains</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY_DOMAIN__MEMORY_DOMAINS = PolyIRCGPackage.MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS;

	/**
	 * The feature id for the '<em><b>Buffering Factor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR = PolyIRCGPackage.MERGED_MEMORY_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Buffer ID</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY_DOMAIN__BUFFER_ID = PolyIRCGPackage.MERGED_MEMORY_DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Buffer Memory Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY_DOMAIN_FEATURE_COUNT = PolyIRCGPackage.MERGED_MEMORY_DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferAccessExpressionImpl <em>Buffer Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferAccessExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getBufferAccessExpression()
	 * @generated
	 */
	int BUFFER_ACCESS_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_EXPRESSION__VARIABLE = PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__VARIABLE;

	/**
	 * The feature id for the '<em><b>Access Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_EXPRESSION__ACCESS_EXPRESSION = PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_EXPRESSION__IDENTIFIER = PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Buffering Factor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR = PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Buffer ID</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_EXPRESSION__BUFFER_ID = PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Buffer Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_EXPRESSION_FEATURE_COUNT = PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation <em>Partitioning Computation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partitioning Computation</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation
	 * @generated
	 */
	EClass getPartitioningComputation();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation#getPartitionedTile <em>Partitioned Tile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Partitioned Tile</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation#getPartitionedTile()
	 * @see #getPartitioningComputation()
	 * @generated
	 */
	EReference getPartitioningComputation_PartitionedTile();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection <em>Distributed Pseudo Projection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distributed Pseudo Projection</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection
	 * @generated
	 */
	EClass getDistributedPseudoProjection();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection#getDistributedDims <em>Distributed Dims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Distributed Dims</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection#getDistributedDims()
	 * @see #getDistributedPseudoProjection()
	 * @generated
	 */
	EAttribute getDistributedPseudoProjection_DistributedDims();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection#getDistributedDimSizes <em>Distributed Dim Sizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Distributed Dim Sizes</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection#getDistributedDimSizes()
	 * @see #getDistributedPseudoProjection()
	 * @generated
	 */
	EReference getDistributedPseudoProjection_DistributedDimSizes();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop <em>MPIC Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MPIC Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop
	 * @generated
	 */
	EClass getMPICLoop();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffers</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop#getBuffers()
	 * @see #getMPICLoop()
	 * @generated
	 */
	EReference getMPICLoop_Buffers();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping <em>Buffer Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Mapping</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping
	 * @generated
	 */
	EClass getBufferMapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getValueAccess <em>Value Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Access</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getValueAccess()
	 * @see #getBufferMapping()
	 * @generated
	 */
	EReference getBufferMapping_ValueAccess();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getBufferAccess <em>Buffer Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer Access</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getBufferAccess()
	 * @see #getBufferMapping()
	 * @generated
	 */
	EReference getBufferMapping_BufferAccess();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getDomain()
	 * @see #getBufferMapping()
	 * @generated
	 */
	EReference getBufferMapping_Domain();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getCommunicatedVariable <em>Communicated Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Communicated Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping#getCommunicatedVariable()
	 * @see #getBufferMapping()
	 * @generated
	 */
	EReference getBufferMapping_CommunicatedVariable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer#getBufferMappings <em>Buffer Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffer Mappings</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer#getBufferMappings()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_BufferMappings();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer#getVariable()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_Variable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain <em>Buffer Memory Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Memory Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain
	 * @generated
	 */
	EClass getBufferMemoryDomain();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain#getBufferingFactor <em>Buffering Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffering Factor</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain#getBufferingFactor()
	 * @see #getBufferMemoryDomain()
	 * @generated
	 */
	EReference getBufferMemoryDomain_BufferingFactor();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain#getBufferID <em>Buffer ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer ID</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain#getBufferID()
	 * @see #getBufferMemoryDomain()
	 * @generated
	 */
	EReference getBufferMemoryDomain_BufferID();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression <em>Buffer Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Access Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression
	 * @generated
	 */
	EClass getBufferAccessExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression#getBufferingFactor <em>Buffering Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffering Factor</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression#getBufferingFactor()
	 * @see #getBufferAccessExpression()
	 * @generated
	 */
	EReference getBufferAccessExpression_BufferingFactor();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression#getBufferID <em>Buffer ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer ID</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression#getBufferID()
	 * @see #getBufferAccessExpression()
	 * @generated
	 */
	EReference getBufferAccessExpression_BufferID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CDistributedFactory getCDistributedFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.PartitioningComputationImpl <em>Partitioning Computation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.PartitioningComputationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getPartitioningComputation()
		 * @generated
		 */
		EClass PARTITIONING_COMPUTATION = eINSTANCE.getPartitioningComputation();

		/**
		 * The meta object literal for the '<em><b>Partitioned Tile</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITIONING_COMPUTATION__PARTITIONED_TILE = eINSTANCE.getPartitioningComputation_PartitionedTile();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.DistributedPseudoProjectionImpl <em>Distributed Pseudo Projection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.DistributedPseudoProjectionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getDistributedPseudoProjection()
		 * @generated
		 */
		EClass DISTRIBUTED_PSEUDO_PROJECTION = eINSTANCE.getDistributedPseudoProjection();

		/**
		 * The meta object literal for the '<em><b>Distributed Dims</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIMS = eINSTANCE.getDistributedPseudoProjection_DistributedDims();

		/**
		 * The meta object literal for the '<em><b>Distributed Dim Sizes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTRIBUTED_PSEUDO_PROJECTION__DISTRIBUTED_DIM_SIZES = eINSTANCE.getDistributedPseudoProjection_DistributedDimSizes();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.MPICLoopImpl <em>MPIC Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.MPICLoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getMPICLoop()
		 * @generated
		 */
		EClass MPIC_LOOP = eINSTANCE.getMPICLoop();

		/**
		 * The meta object literal for the '<em><b>Buffers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPIC_LOOP__BUFFERS = eINSTANCE.getMPICLoop_Buffers();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMappingImpl <em>Buffer Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMappingImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getBufferMapping()
		 * @generated
		 */
		EClass BUFFER_MAPPING = eINSTANCE.getBufferMapping();

		/**
		 * The meta object literal for the '<em><b>Value Access</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_MAPPING__VALUE_ACCESS = eINSTANCE.getBufferMapping_ValueAccess();

		/**
		 * The meta object literal for the '<em><b>Buffer Access</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_MAPPING__BUFFER_ACCESS = eINSTANCE.getBufferMapping_BufferAccess();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_MAPPING__DOMAIN = eINSTANCE.getBufferMapping_Domain();

		/**
		 * The meta object literal for the '<em><b>Communicated Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_MAPPING__COMMUNICATED_VARIABLE = eINSTANCE.getBufferMapping_CommunicatedVariable();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferImpl <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getBuffer()
		 * @generated
		 */
		EClass BUFFER = eINSTANCE.getBuffer();

		/**
		 * The meta object literal for the '<em><b>Buffer Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER__BUFFER_MAPPINGS = eINSTANCE.getBuffer_BufferMappings();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER__VARIABLE = eINSTANCE.getBuffer_Variable();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMemoryDomainImpl <em>Buffer Memory Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferMemoryDomainImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getBufferMemoryDomain()
		 * @generated
		 */
		EClass BUFFER_MEMORY_DOMAIN = eINSTANCE.getBufferMemoryDomain();

		/**
		 * The meta object literal for the '<em><b>Buffering Factor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_MEMORY_DOMAIN__BUFFERING_FACTOR = eINSTANCE.getBufferMemoryDomain_BufferingFactor();

		/**
		 * The meta object literal for the '<em><b>Buffer ID</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_MEMORY_DOMAIN__BUFFER_ID = eINSTANCE.getBufferMemoryDomain_BufferID();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferAccessExpressionImpl <em>Buffer Access Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferAccessExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl#getBufferAccessExpression()
		 * @generated
		 */
		EClass BUFFER_ACCESS_EXPRESSION = eINSTANCE.getBufferAccessExpression();

		/**
		 * The meta object literal for the '<em><b>Buffering Factor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_ACCESS_EXPRESSION__BUFFERING_FACTOR = eINSTANCE.getBufferAccessExpression_BufferingFactor();

		/**
		 * The meta object literal for the '<em><b>Buffer ID</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_ACCESS_EXPRESSION__BUFFER_ID = eINSTANCE.getBufferAccessExpression_BufferID();

	}

} //CDistributedPackage
