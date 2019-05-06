/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.annotation.AnnotationFactory;
import org.polymodel.scop.annotation.AnnotationPackage;
import org.polymodel.scop.annotation.BarrierAnnotation;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.annotation.ParallelBlockAnnotation;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.annotation.PolyhedralDomainAnnotation;
import org.polymodel.scop.annotation.SingleAnnotation;
import org.polymodel.scop.annotation.TileLoopAnnotation;
import org.polymodel.scop.annotation.VectorizationAnnotation;
import org.polymodel.scop.impl.ScopPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnnotationPackageImpl extends EPackageImpl implements AnnotationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelLoopAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tileLoopAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelBlockAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polyhedralDomainAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass barrierAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vectorizationAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleAnnotationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polymodel.scop.annotation.AnnotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnnotationPackageImpl() {
		super(eNS_URI, AnnotationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AnnotationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnnotationPackage init() {
		if (isInited) return (AnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI);

		// Obtain or create and register package
		AnnotationPackageImpl theAnnotationPackage = (AnnotationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AnnotationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AnnotationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AlgebraPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ScopPackageImpl theScopPackage = (ScopPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScopPackage.eNS_URI) instanceof ScopPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScopPackage.eNS_URI) : ScopPackage.eINSTANCE);

		// Create package meta-data objects
		theAnnotationPackage.createPackageContents();
		theScopPackage.createPackageContents();

		// Initialize created meta-data
		theAnnotationPackage.initializePackageContents();
		theScopPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnnotationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AnnotationPackage.eNS_URI, theAnnotationPackage);
		return theAnnotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelLoopAnnotation() {
		return parallelLoopAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParallelLoopAnnotation_Privates() {
		return (EAttribute)parallelLoopAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParallelLoopAnnotation_Schedule() {
		return (EAttribute)parallelLoopAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParallelLoopAnnotation_Chunksize() {
		return (EAttribute)parallelLoopAnnotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParallelLoopAnnotation__Accept__ScopVisitor() {
		return parallelLoopAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionAnnotation() {
		return descriptionAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptionAnnotation_Description() {
		return (EAttribute)descriptionAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionAnnotation__Accept__ScopVisitor() {
		return descriptionAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTileLoopAnnotation() {
		return tileLoopAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTileLoopAnnotation_TileIndex() {
		return (EReference)tileLoopAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTileLoopAnnotation_TileSize() {
		return (EReference)tileLoopAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTileLoopAnnotation_Offset() {
		return (EReference)tileLoopAnnotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTileLoopAnnotation__Accept__ScopVisitor() {
		return tileLoopAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelBlockAnnotation() {
		return parallelBlockAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParallelBlockAnnotation_Privates() {
		return (EAttribute)parallelBlockAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParallelBlockAnnotation__Accept__ScopVisitor() {
		return parallelBlockAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolyhedralDomainAnnotation() {
		return polyhedralDomainAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolyhedralDomainAnnotation_Domain() {
		return (EAttribute)polyhedralDomainAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolyhedralDomainAnnotation__Accept__ScopVisitor() {
		return polyhedralDomainAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBarrierAnnotation() {
		return barrierAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBarrierAnnotation_Before() {
		return (EAttribute)barrierAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBarrierAnnotation_Type() {
		return (EAttribute)barrierAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBarrierAnnotation__Accept__ScopVisitor() {
		return barrierAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVectorizationAnnotation() {
		return vectorizationAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVectorizationAnnotation_Ivdep() {
		return (EAttribute)vectorizationAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleAnnotation() {
		return singleAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationFactory getAnnotationFactory() {
		return (AnnotationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		parallelLoopAnnotationEClass = createEClass(PARALLEL_LOOP_ANNOTATION);
		createEAttribute(parallelLoopAnnotationEClass, PARALLEL_LOOP_ANNOTATION__PRIVATES);
		createEAttribute(parallelLoopAnnotationEClass, PARALLEL_LOOP_ANNOTATION__SCHEDULE);
		createEAttribute(parallelLoopAnnotationEClass, PARALLEL_LOOP_ANNOTATION__CHUNKSIZE);
		createEOperation(parallelLoopAnnotationEClass, PARALLEL_LOOP_ANNOTATION___ACCEPT__SCOPVISITOR);

		descriptionAnnotationEClass = createEClass(DESCRIPTION_ANNOTATION);
		createEAttribute(descriptionAnnotationEClass, DESCRIPTION_ANNOTATION__DESCRIPTION);
		createEOperation(descriptionAnnotationEClass, DESCRIPTION_ANNOTATION___ACCEPT__SCOPVISITOR);

		tileLoopAnnotationEClass = createEClass(TILE_LOOP_ANNOTATION);
		createEReference(tileLoopAnnotationEClass, TILE_LOOP_ANNOTATION__TILE_INDEX);
		createEReference(tileLoopAnnotationEClass, TILE_LOOP_ANNOTATION__TILE_SIZE);
		createEReference(tileLoopAnnotationEClass, TILE_LOOP_ANNOTATION__OFFSET);
		createEOperation(tileLoopAnnotationEClass, TILE_LOOP_ANNOTATION___ACCEPT__SCOPVISITOR);

		parallelBlockAnnotationEClass = createEClass(PARALLEL_BLOCK_ANNOTATION);
		createEAttribute(parallelBlockAnnotationEClass, PARALLEL_BLOCK_ANNOTATION__PRIVATES);
		createEOperation(parallelBlockAnnotationEClass, PARALLEL_BLOCK_ANNOTATION___ACCEPT__SCOPVISITOR);

		polyhedralDomainAnnotationEClass = createEClass(POLYHEDRAL_DOMAIN_ANNOTATION);
		createEAttribute(polyhedralDomainAnnotationEClass, POLYHEDRAL_DOMAIN_ANNOTATION__DOMAIN);
		createEOperation(polyhedralDomainAnnotationEClass, POLYHEDRAL_DOMAIN_ANNOTATION___ACCEPT__SCOPVISITOR);

		barrierAnnotationEClass = createEClass(BARRIER_ANNOTATION);
		createEAttribute(barrierAnnotationEClass, BARRIER_ANNOTATION__BEFORE);
		createEAttribute(barrierAnnotationEClass, BARRIER_ANNOTATION__TYPE);
		createEOperation(barrierAnnotationEClass, BARRIER_ANNOTATION___ACCEPT__SCOPVISITOR);

		vectorizationAnnotationEClass = createEClass(VECTORIZATION_ANNOTATION);
		createEAttribute(vectorizationAnnotationEClass, VECTORIZATION_ANNOTATION__IVDEP);

		singleAnnotationEClass = createEClass(SINGLE_ANNOTATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ScopPackage theScopPackage = (ScopPackage)EPackage.Registry.INSTANCE.getEPackage(ScopPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		parallelLoopAnnotationEClass.getESuperTypes().add(theScopPackage.getIScopAnnotation());
		parallelLoopAnnotationEClass.getESuperTypes().add(theScopPackage.getScopVisitable());
		descriptionAnnotationEClass.getESuperTypes().add(theScopPackage.getIScopAnnotation());
		descriptionAnnotationEClass.getESuperTypes().add(theScopPackage.getScopVisitable());
		tileLoopAnnotationEClass.getESuperTypes().add(theScopPackage.getIScopAnnotation());
		tileLoopAnnotationEClass.getESuperTypes().add(theScopPackage.getScopVisitable());
		parallelBlockAnnotationEClass.getESuperTypes().add(theScopPackage.getIScopAnnotation());
		parallelBlockAnnotationEClass.getESuperTypes().add(theScopPackage.getScopVisitable());
		polyhedralDomainAnnotationEClass.getESuperTypes().add(theScopPackage.getIScopAnnotation());
		polyhedralDomainAnnotationEClass.getESuperTypes().add(theScopPackage.getScopVisitable());
		barrierAnnotationEClass.getESuperTypes().add(theScopPackage.getIScopAnnotation());
		barrierAnnotationEClass.getESuperTypes().add(theScopPackage.getScopVisitable());
		vectorizationAnnotationEClass.getESuperTypes().add(theScopPackage.getIScopAnnotation());
		vectorizationAnnotationEClass.getESuperTypes().add(theScopPackage.getScopVisitable());
		singleAnnotationEClass.getESuperTypes().add(theScopPackage.getIScopAnnotation());
		singleAnnotationEClass.getESuperTypes().add(theScopPackage.getScopVisitable());

		// Initialize classes, features, and operations; add parameters
		initEClass(parallelLoopAnnotationEClass, ParallelLoopAnnotation.class, "ParallelLoopAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParallelLoopAnnotation_Privates(), ecorePackage.getEString(), "privates", null, 0, -1, ParallelLoopAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParallelLoopAnnotation_Schedule(), ecorePackage.getEString(), "schedule", null, 0, 1, ParallelLoopAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParallelLoopAnnotation_Chunksize(), ecorePackage.getEInt(), "chunksize", null, 0, 1, ParallelLoopAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getParallelLoopAnnotation__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theScopPackage.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(descriptionAnnotationEClass, DescriptionAnnotation.class, "DescriptionAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptionAnnotation_Description(), ecorePackage.getEString(), "description", null, 1, 1, DescriptionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDescriptionAnnotation__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theScopPackage.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tileLoopAnnotationEClass, TileLoopAnnotation.class, "TileLoopAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTileLoopAnnotation_TileIndex(), theAlgebraPackage.getVariable(), null, "tileIndex", null, 1, 1, TileLoopAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTileLoopAnnotation_TileSize(), theAlgebraPackage.getIntExpression(), null, "tileSize", null, 1, 1, TileLoopAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTileLoopAnnotation_Offset(), theAlgebraPackage.getIntExpression(), null, "offset", null, 0, 1, TileLoopAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTileLoopAnnotation__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theScopPackage.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(parallelBlockAnnotationEClass, ParallelBlockAnnotation.class, "ParallelBlockAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParallelBlockAnnotation_Privates(), ecorePackage.getEString(), "privates", null, 0, -1, ParallelBlockAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getParallelBlockAnnotation__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theScopPackage.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polyhedralDomainAnnotationEClass, PolyhedralDomainAnnotation.class, "PolyhedralDomainAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolyhedralDomainAnnotation_Domain(), ecorePackage.getEString(), "domain", null, 0, 1, PolyhedralDomainAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPolyhedralDomainAnnotation__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theScopPackage.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(barrierAnnotationEClass, BarrierAnnotation.class, "BarrierAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBarrierAnnotation_Before(), ecorePackage.getEBoolean(), "before", null, 1, 1, BarrierAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBarrierAnnotation_Type(), ecorePackage.getEInt(), "type", null, 1, 1, BarrierAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getBarrierAnnotation__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theScopPackage.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(vectorizationAnnotationEClass, VectorizationAnnotation.class, "VectorizationAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVectorizationAnnotation_Ivdep(), ecorePackage.getEBoolean(), "ivdep", null, 1, 1, VectorizationAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleAnnotationEClass, SingleAnnotation.class, "SingleAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //AnnotationPackageImpl
