/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.reductions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.algebra.affine.impl.AffinePackageImpl;
import org.polymodel.algebra.impl.AlgebraPackageImpl;
import org.polymodel.algebra.polynomials.PolynomialsPackage;
import org.polymodel.algebra.polynomials.impl.PolynomialsPackageImpl;
import org.polymodel.algebra.quasiAffine.QuasiAffinePackage;
import org.polymodel.algebra.quasiAffine.impl.QuasiAffinePackageImpl;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;
import org.polymodel.algebra.reductions.ReductionsFactory;
import org.polymodel.algebra.reductions.ReductionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReductionsPackageImpl extends EPackageImpl implements ReductionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reductionExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reductionOperatorEEnum = null;

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
	 * @see org.polymodel.algebra.reductions.ReductionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ReductionsPackageImpl() {
		super(eNS_URI, ReductionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ReductionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ReductionsPackage init() {
		if (isInited) return (ReductionsPackage)EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI);

		// Obtain or create and register package
		ReductionsPackageImpl theReductionsPackage = (ReductionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ReductionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ReductionsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AlgebraPackageImpl theAlgebraPackage = (AlgebraPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI) instanceof AlgebraPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI) : AlgebraPackage.eINSTANCE);
		AffinePackageImpl theAffinePackage = (AffinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI) instanceof AffinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI) : AffinePackage.eINSTANCE);
		QuasiAffinePackageImpl theQuasiAffinePackage = (QuasiAffinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI) instanceof QuasiAffinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI) : QuasiAffinePackage.eINSTANCE);
		PolynomialsPackageImpl thePolynomialsPackage = (PolynomialsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI) instanceof PolynomialsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI) : PolynomialsPackage.eINSTANCE);

		// Create package meta-data objects
		theReductionsPackage.createPackageContents();
		theAlgebraPackage.createPackageContents();
		theAffinePackage.createPackageContents();
		theQuasiAffinePackage.createPackageContents();
		thePolynomialsPackage.createPackageContents();

		// Initialize created meta-data
		theReductionsPackage.initializePackageContents();
		theAlgebraPackage.initializePackageContents();
		theAffinePackage.initializePackageContents();
		theQuasiAffinePackage.initializePackageContents();
		thePolynomialsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theReductionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ReductionsPackage.eNS_URI, theReductionsPackage);
		return theReductionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReductionExpression() {
		return reductionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReductionExpression_Expressions() {
		return (EReference)reductionExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReductionExpression_Operator() {
		return (EAttribute)reductionExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReductionExpression__Accept__AlgebraVisitor() {
		return reductionExpressionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReductionOperator() {
		return reductionOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReductionsFactory getReductionsFactory() {
		return (ReductionsFactory)getEFactoryInstance();
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
		reductionExpressionEClass = createEClass(REDUCTION_EXPRESSION);
		createEReference(reductionExpressionEClass, REDUCTION_EXPRESSION__EXPRESSIONS);
		createEAttribute(reductionExpressionEClass, REDUCTION_EXPRESSION__OPERATOR);
		createEOperation(reductionExpressionEClass, REDUCTION_EXPRESSION___ACCEPT__ALGEBRAVISITOR);

		// Create enums
		reductionOperatorEEnum = createEEnum(REDUCTION_OPERATOR);
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
		reductionExpressionEClass.getESuperTypes().add(theAlgebraPackage.getIntExpression());
		reductionExpressionEClass.getESuperTypes().add(theAlgebraPackage.getAlgebraVisitable());

		// Initialize classes, features, and operations; add parameters
		initEClass(reductionExpressionEClass, ReductionExpression.class, "ReductionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReductionExpression_Expressions(), theAlgebraPackage.getIntExpression(), null, "expressions", null, 0, -1, ReductionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReductionExpression_Operator(), this.getReductionOperator(), "operator", null, 1, 1, ReductionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getReductionExpression__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(reductionOperatorEEnum, ReductionOperator.class, "ReductionOperator");
		addEEnumLiteral(reductionOperatorEEnum, ReductionOperator.MIN);
		addEEnumLiteral(reductionOperatorEEnum, ReductionOperator.MAX);
		addEEnumLiteral(reductionOperatorEEnum, ReductionOperator.SUM);
		addEEnumLiteral(reductionOperatorEEnum, ReductionOperator.PROD);
	}

} //ReductionsPackageImpl
