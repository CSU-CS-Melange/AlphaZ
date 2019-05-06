/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.scop.ScopPackage;

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
 * @see org.polymodel.scop.annotation.AnnotationFactory
 * @model kind="package"
 * @generated
 */
public interface AnnotationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "annotation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://polymodel/scop/annotation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "annotation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnnotationPackage eINSTANCE = org.polymodel.scop.annotation.impl.AnnotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.scop.annotation.impl.ParallelLoopAnnotationImpl <em>Parallel Loop Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.annotation.impl.ParallelLoopAnnotationImpl
	 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getParallelLoopAnnotation()
	 * @generated
	 */
	int PARALLEL_LOOP_ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Privates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_LOOP_ANNOTATION__PRIVATES = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_LOOP_ANNOTATION__SCHEDULE = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Chunksize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_LOOP_ANNOTATION__CHUNKSIZE = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Parallel Loop Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_LOOP_ANNOTATION_FEATURE_COUNT = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 3;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_LOOP_ANNOTATION___ACCEPT__SCOPVISITOR = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parallel Loop Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_LOOP_ANNOTATION_OPERATION_COUNT = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.annotation.impl.DescriptionAnnotationImpl <em>Description Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.annotation.impl.DescriptionAnnotationImpl
	 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getDescriptionAnnotation()
	 * @generated
	 */
	int DESCRIPTION_ANNOTATION = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_ANNOTATION__DESCRIPTION = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Description Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_ANNOTATION_FEATURE_COUNT = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 1;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_ANNOTATION___ACCEPT__SCOPVISITOR = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Description Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_ANNOTATION_OPERATION_COUNT = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.annotation.impl.TileLoopAnnotationImpl <em>Tile Loop Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.annotation.impl.TileLoopAnnotationImpl
	 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getTileLoopAnnotation()
	 * @generated
	 */
	int TILE_LOOP_ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Tile Index</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_LOOP_ANNOTATION__TILE_INDEX = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tile Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_LOOP_ANNOTATION__TILE_SIZE = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_LOOP_ANNOTATION__OFFSET = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tile Loop Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_LOOP_ANNOTATION_FEATURE_COUNT = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 3;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_LOOP_ANNOTATION___ACCEPT__SCOPVISITOR = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tile Loop Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_LOOP_ANNOTATION_OPERATION_COUNT = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.annotation.impl.ParallelBlockAnnotationImpl <em>Parallel Block Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.annotation.impl.ParallelBlockAnnotationImpl
	 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getParallelBlockAnnotation()
	 * @generated
	 */
	int PARALLEL_BLOCK_ANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>Privates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_BLOCK_ANNOTATION__PRIVATES = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parallel Block Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_BLOCK_ANNOTATION_FEATURE_COUNT = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_BLOCK_ANNOTATION___ACCEPT__SCOPVISITOR = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parallel Block Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_BLOCK_ANNOTATION_OPERATION_COUNT = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.annotation.impl.PolyhedralDomainAnnotationImpl <em>Polyhedral Domain Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.annotation.impl.PolyhedralDomainAnnotationImpl
	 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getPolyhedralDomainAnnotation()
	 * @generated
	 */
	int POLYHEDRAL_DOMAIN_ANNOTATION = 4;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYHEDRAL_DOMAIN_ANNOTATION__DOMAIN = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Polyhedral Domain Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYHEDRAL_DOMAIN_ANNOTATION_FEATURE_COUNT = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 1;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYHEDRAL_DOMAIN_ANNOTATION___ACCEPT__SCOPVISITOR = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Polyhedral Domain Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYHEDRAL_DOMAIN_ANNOTATION_OPERATION_COUNT = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.annotation.impl.BarrierAnnotationImpl <em>Barrier Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.annotation.impl.BarrierAnnotationImpl
	 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getBarrierAnnotation()
	 * @generated
	 */
	int BARRIER_ANNOTATION = 5;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_ANNOTATION__BEFORE = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_ANNOTATION__TYPE = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Barrier Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_ANNOTATION_FEATURE_COUNT = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 2;


	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_ANNOTATION___ACCEPT__SCOPVISITOR = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Barrier Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_ANNOTATION_OPERATION_COUNT = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.polymodel.scop.annotation.impl.VectorizationAnnotationImpl <em>Vectorization Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.annotation.impl.VectorizationAnnotationImpl
	 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getVectorizationAnnotation()
	 * @generated
	 */
	int VECTORIZATION_ANNOTATION = 6;

	/**
	 * The feature id for the '<em><b>Ivdep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTORIZATION_ANNOTATION__IVDEP = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Vectorization Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTORIZATION_ANNOTATION_FEATURE_COUNT = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTORIZATION_ANNOTATION___ACCEPT__SCOPVISITOR = ScopPackage.ISCOP_ANNOTATION___ACCEPT__SCOPVISITOR;

	/**
	 * The number of operations of the '<em>Vectorization Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTORIZATION_ANNOTATION_OPERATION_COUNT = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.polymodel.scop.annotation.impl.SingleAnnotationImpl <em>Single Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.annotation.impl.SingleAnnotationImpl
	 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getSingleAnnotation()
	 * @generated
	 */
	int SINGLE_ANNOTATION = 7;

	/**
	 * The number of structural features of the '<em>Single Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ANNOTATION_FEATURE_COUNT = ScopPackage.ISCOP_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ANNOTATION___ACCEPT__SCOPVISITOR = ScopPackage.ISCOP_ANNOTATION___ACCEPT__SCOPVISITOR;

	/**
	 * The number of operations of the '<em>Single Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ANNOTATION_OPERATION_COUNT = ScopPackage.ISCOP_ANNOTATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.annotation.ParallelLoopAnnotation <em>Parallel Loop Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Loop Annotation</em>'.
	 * @see org.polymodel.scop.annotation.ParallelLoopAnnotation
	 * @generated
	 */
	EClass getParallelLoopAnnotation();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#getPrivates <em>Privates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Privates</em>'.
	 * @see org.polymodel.scop.annotation.ParallelLoopAnnotation#getPrivates()
	 * @see #getParallelLoopAnnotation()
	 * @generated
	 */
	EAttribute getParallelLoopAnnotation_Privates();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schedule</em>'.
	 * @see org.polymodel.scop.annotation.ParallelLoopAnnotation#getSchedule()
	 * @see #getParallelLoopAnnotation()
	 * @generated
	 */
	EAttribute getParallelLoopAnnotation_Schedule();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#getChunksize <em>Chunksize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chunksize</em>'.
	 * @see org.polymodel.scop.annotation.ParallelLoopAnnotation#getChunksize()
	 * @see #getParallelLoopAnnotation()
	 * @generated
	 */
	EAttribute getParallelLoopAnnotation_Chunksize();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.annotation.ParallelLoopAnnotation#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.annotation.ParallelLoopAnnotation#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getParallelLoopAnnotation__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.annotation.DescriptionAnnotation <em>Description Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Annotation</em>'.
	 * @see org.polymodel.scop.annotation.DescriptionAnnotation
	 * @generated
	 */
	EClass getDescriptionAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.annotation.DescriptionAnnotation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.polymodel.scop.annotation.DescriptionAnnotation#getDescription()
	 * @see #getDescriptionAnnotation()
	 * @generated
	 */
	EAttribute getDescriptionAnnotation_Description();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.annotation.DescriptionAnnotation#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.annotation.DescriptionAnnotation#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getDescriptionAnnotation__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.annotation.TileLoopAnnotation <em>Tile Loop Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tile Loop Annotation</em>'.
	 * @see org.polymodel.scop.annotation.TileLoopAnnotation
	 * @generated
	 */
	EClass getTileLoopAnnotation();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.scop.annotation.TileLoopAnnotation#getTileIndex <em>Tile Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tile Index</em>'.
	 * @see org.polymodel.scop.annotation.TileLoopAnnotation#getTileIndex()
	 * @see #getTileLoopAnnotation()
	 * @generated
	 */
	EReference getTileLoopAnnotation_TileIndex();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.scop.annotation.TileLoopAnnotation#getTileSize <em>Tile Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tile Size</em>'.
	 * @see org.polymodel.scop.annotation.TileLoopAnnotation#getTileSize()
	 * @see #getTileLoopAnnotation()
	 * @generated
	 */
	EReference getTileLoopAnnotation_TileSize();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.scop.annotation.TileLoopAnnotation#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Offset</em>'.
	 * @see org.polymodel.scop.annotation.TileLoopAnnotation#getOffset()
	 * @see #getTileLoopAnnotation()
	 * @generated
	 */
	EReference getTileLoopAnnotation_Offset();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.annotation.TileLoopAnnotation#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.annotation.TileLoopAnnotation#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getTileLoopAnnotation__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.annotation.ParallelBlockAnnotation <em>Parallel Block Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Block Annotation</em>'.
	 * @see org.polymodel.scop.annotation.ParallelBlockAnnotation
	 * @generated
	 */
	EClass getParallelBlockAnnotation();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.scop.annotation.ParallelBlockAnnotation#getPrivates <em>Privates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Privates</em>'.
	 * @see org.polymodel.scop.annotation.ParallelBlockAnnotation#getPrivates()
	 * @see #getParallelBlockAnnotation()
	 * @generated
	 */
	EAttribute getParallelBlockAnnotation_Privates();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.annotation.ParallelBlockAnnotation#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.annotation.ParallelBlockAnnotation#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getParallelBlockAnnotation__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.annotation.PolyhedralDomainAnnotation <em>Polyhedral Domain Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Polyhedral Domain Annotation</em>'.
	 * @see org.polymodel.scop.annotation.PolyhedralDomainAnnotation
	 * @generated
	 */
	EClass getPolyhedralDomainAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.annotation.PolyhedralDomainAnnotation#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see org.polymodel.scop.annotation.PolyhedralDomainAnnotation#getDomain()
	 * @see #getPolyhedralDomainAnnotation()
	 * @generated
	 */
	EAttribute getPolyhedralDomainAnnotation_Domain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.annotation.PolyhedralDomainAnnotation#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.annotation.PolyhedralDomainAnnotation#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getPolyhedralDomainAnnotation__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.annotation.BarrierAnnotation <em>Barrier Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Barrier Annotation</em>'.
	 * @see org.polymodel.scop.annotation.BarrierAnnotation
	 * @generated
	 */
	EClass getBarrierAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.annotation.BarrierAnnotation#isBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Before</em>'.
	 * @see org.polymodel.scop.annotation.BarrierAnnotation#isBefore()
	 * @see #getBarrierAnnotation()
	 * @generated
	 */
	EAttribute getBarrierAnnotation_Before();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.annotation.BarrierAnnotation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polymodel.scop.annotation.BarrierAnnotation#getType()
	 * @see #getBarrierAnnotation()
	 * @generated
	 */
	EAttribute getBarrierAnnotation_Type();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.annotation.BarrierAnnotation#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.annotation.BarrierAnnotation#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getBarrierAnnotation__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.annotation.VectorizationAnnotation <em>Vectorization Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vectorization Annotation</em>'.
	 * @see org.polymodel.scop.annotation.VectorizationAnnotation
	 * @generated
	 */
	EClass getVectorizationAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.annotation.VectorizationAnnotation#isIvdep <em>Ivdep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ivdep</em>'.
	 * @see org.polymodel.scop.annotation.VectorizationAnnotation#isIvdep()
	 * @see #getVectorizationAnnotation()
	 * @generated
	 */
	EAttribute getVectorizationAnnotation_Ivdep();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.annotation.SingleAnnotation <em>Single Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Annotation</em>'.
	 * @see org.polymodel.scop.annotation.SingleAnnotation
	 * @generated
	 */
	EClass getSingleAnnotation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnnotationFactory getAnnotationFactory();

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
		 * The meta object literal for the '{@link org.polymodel.scop.annotation.impl.ParallelLoopAnnotationImpl <em>Parallel Loop Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.annotation.impl.ParallelLoopAnnotationImpl
		 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getParallelLoopAnnotation()
		 * @generated
		 */
		EClass PARALLEL_LOOP_ANNOTATION = eINSTANCE.getParallelLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Privates</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARALLEL_LOOP_ANNOTATION__PRIVATES = eINSTANCE.getParallelLoopAnnotation_Privates();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARALLEL_LOOP_ANNOTATION__SCHEDULE = eINSTANCE.getParallelLoopAnnotation_Schedule();

		/**
		 * The meta object literal for the '<em><b>Chunksize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARALLEL_LOOP_ANNOTATION__CHUNKSIZE = eINSTANCE.getParallelLoopAnnotation_Chunksize();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARALLEL_LOOP_ANNOTATION___ACCEPT__SCOPVISITOR = eINSTANCE.getParallelLoopAnnotation__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.annotation.impl.DescriptionAnnotationImpl <em>Description Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.annotation.impl.DescriptionAnnotationImpl
		 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getDescriptionAnnotation()
		 * @generated
		 */
		EClass DESCRIPTION_ANNOTATION = eINSTANCE.getDescriptionAnnotation();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION_ANNOTATION__DESCRIPTION = eINSTANCE.getDescriptionAnnotation_Description();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_ANNOTATION___ACCEPT__SCOPVISITOR = eINSTANCE.getDescriptionAnnotation__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.annotation.impl.TileLoopAnnotationImpl <em>Tile Loop Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.annotation.impl.TileLoopAnnotationImpl
		 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getTileLoopAnnotation()
		 * @generated
		 */
		EClass TILE_LOOP_ANNOTATION = eINSTANCE.getTileLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Tile Index</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILE_LOOP_ANNOTATION__TILE_INDEX = eINSTANCE.getTileLoopAnnotation_TileIndex();

		/**
		 * The meta object literal for the '<em><b>Tile Size</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILE_LOOP_ANNOTATION__TILE_SIZE = eINSTANCE.getTileLoopAnnotation_TileSize();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILE_LOOP_ANNOTATION__OFFSET = eINSTANCE.getTileLoopAnnotation_Offset();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TILE_LOOP_ANNOTATION___ACCEPT__SCOPVISITOR = eINSTANCE.getTileLoopAnnotation__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.annotation.impl.ParallelBlockAnnotationImpl <em>Parallel Block Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.annotation.impl.ParallelBlockAnnotationImpl
		 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getParallelBlockAnnotation()
		 * @generated
		 */
		EClass PARALLEL_BLOCK_ANNOTATION = eINSTANCE.getParallelBlockAnnotation();

		/**
		 * The meta object literal for the '<em><b>Privates</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARALLEL_BLOCK_ANNOTATION__PRIVATES = eINSTANCE.getParallelBlockAnnotation_Privates();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARALLEL_BLOCK_ANNOTATION___ACCEPT__SCOPVISITOR = eINSTANCE.getParallelBlockAnnotation__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.annotation.impl.PolyhedralDomainAnnotationImpl <em>Polyhedral Domain Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.annotation.impl.PolyhedralDomainAnnotationImpl
		 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getPolyhedralDomainAnnotation()
		 * @generated
		 */
		EClass POLYHEDRAL_DOMAIN_ANNOTATION = eINSTANCE.getPolyhedralDomainAnnotation();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLYHEDRAL_DOMAIN_ANNOTATION__DOMAIN = eINSTANCE.getPolyhedralDomainAnnotation_Domain();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POLYHEDRAL_DOMAIN_ANNOTATION___ACCEPT__SCOPVISITOR = eINSTANCE.getPolyhedralDomainAnnotation__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.annotation.impl.BarrierAnnotationImpl <em>Barrier Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.annotation.impl.BarrierAnnotationImpl
		 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getBarrierAnnotation()
		 * @generated
		 */
		EClass BARRIER_ANNOTATION = eINSTANCE.getBarrierAnnotation();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BARRIER_ANNOTATION__BEFORE = eINSTANCE.getBarrierAnnotation_Before();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BARRIER_ANNOTATION__TYPE = eINSTANCE.getBarrierAnnotation_Type();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BARRIER_ANNOTATION___ACCEPT__SCOPVISITOR = eINSTANCE.getBarrierAnnotation__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.annotation.impl.VectorizationAnnotationImpl <em>Vectorization Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.annotation.impl.VectorizationAnnotationImpl
		 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getVectorizationAnnotation()
		 * @generated
		 */
		EClass VECTORIZATION_ANNOTATION = eINSTANCE.getVectorizationAnnotation();

		/**
		 * The meta object literal for the '<em><b>Ivdep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTORIZATION_ANNOTATION__IVDEP = eINSTANCE.getVectorizationAnnotation_Ivdep();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.annotation.impl.SingleAnnotationImpl <em>Single Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.annotation.impl.SingleAnnotationImpl
		 * @see org.polymodel.scop.annotation.impl.AnnotationPackageImpl#getSingleAnnotation()
		 * @generated
		 */
		EClass SINGLE_ANNOTATION = eINSTANCE.getSingleAnnotation();

	}

} //AnnotationPackage
