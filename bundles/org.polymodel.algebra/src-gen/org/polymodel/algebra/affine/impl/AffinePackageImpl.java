/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.affine.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineFactory;
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.impl.AlgebraPackageImpl;
import org.polymodel.algebra.polynomials.PolynomialsPackage;
import org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl;
import org.polymodel.algebra.quasiAffine.QuasiAffinePackage;
import org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl;
import org.polymodel.algebra.reductions.ReductionsPackage;
import org.polymodel.algebra.reductions.impl.ReductionsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AffinePackageImpl extends EPackageImpl implements AffinePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass affineExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass affineTermEClass = null;

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
	 * @see org.polymodel.algebra.affine.AffinePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AffinePackageImpl() {
		super(eNS_URI, AffineFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AffinePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AffinePackage init() {
		if (isInited) return (AffinePackage)EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI);

		// Obtain or create and register package
		AffinePackageImpl theAffinePackage = (AffinePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AffinePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AffinePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AlgebraPackageImpl theAlgebraPackage = (AlgebraPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI) instanceof AlgebraPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI) : AlgebraPackage.eINSTANCE);
		QuasiAffinePackageImpl theQuasiAffinePackage = (QuasiAffinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI) instanceof QuasiAffinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI) : QuasiAffinePackage.eINSTANCE);
		PolynomialsPackageImpl thePolynomialsPackage = (PolynomialsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI) instanceof PolynomialsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI) : PolynomialsPackage.eINSTANCE);
		ReductionsPackageImpl theReductionsPackage = (ReductionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI) instanceof ReductionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI) : ReductionsPackage.eINSTANCE);

		// Create package meta-data objects
		theAffinePackage.createPackageContents();
		theAlgebraPackage.createPackageContents();
		theQuasiAffinePackage.createPackageContents();
		thePolynomialsPackage.createPackageContents();
		theReductionsPackage.createPackageContents();

		// Initialize created meta-data
		theAffinePackage.initializePackageContents();
		theAlgebraPackage.initializePackageContents();
		theQuasiAffinePackage.initializePackageContents();
		thePolynomialsPackage.initializePackageContents();
		theReductionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAffinePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AffinePackage.eNS_URI, theAffinePackage);
		return theAffinePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAffineExpression() {
		return affineExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineExpression_Terms() {
		return (EReference)affineExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAffineExpression__Accept__AlgebraVisitor() {
		return affineExpressionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAffineTerm() {
		return affineTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineTerm_Variable() {
		return (EReference)affineTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAffineTerm__Accept__AlgebraVisitor() {
		return affineTermEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFactory getAffineFactory() {
		return (AffineFactory)getEFactoryInstance();
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
		affineExpressionEClass = createEClass(AFFINE_EXPRESSION);
		createEReference(affineExpressionEClass, AFFINE_EXPRESSION__TERMS);
		createEOperation(affineExpressionEClass, AFFINE_EXPRESSION___ACCEPT__ALGEBRAVISITOR);

		affineTermEClass = createEClass(AFFINE_TERM);
		createEReference(affineTermEClass, AFFINE_TERM__VARIABLE);
		createEOperation(affineTermEClass, AFFINE_TERM___ACCEPT__ALGEBRAVISITOR);
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
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		affineExpressionEClass.getESuperTypes().add(theAlgebraPackage.getIntExpression());
		affineExpressionEClass.getESuperTypes().add(theAlgebraPackage.getAlgebraVisitable());
		affineTermEClass.getESuperTypes().add(theAlgebraPackage.getIntTerm());
		affineTermEClass.getESuperTypes().add(theAlgebraPackage.getAlgebraVisitable());

		// Initialize classes, features, and operations; add parameters
		initEClass(affineExpressionEClass, AffineExpression.class, "AffineExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAffineExpression_Terms(), this.getAffineTerm(), null, "terms", null, 0, -1, AffineExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getAffineExpression__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(affineTermEClass, AffineTerm.class, "AffineTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAffineTerm_Variable(), theAlgebraPackage.getVariable(), null, "variable", null, 0, 1, AffineTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAffineTerm__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
	}

} //AffinePackageImpl
