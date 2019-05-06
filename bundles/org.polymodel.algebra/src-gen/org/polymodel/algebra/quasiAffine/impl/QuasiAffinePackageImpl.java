/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine.impl;

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
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineFactory;
import org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
import org.polymodel.algebra.quasiAffine.QuasiAffinePackage;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionsPackage;
import org.polymodel.algebra.reductions.impl.ReductionsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QuasiAffinePackageImpl extends EPackageImpl implements QuasiAffinePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quasiAffineExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quasiAffineTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleQuasiAffineTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nestedQuasiAffineTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum quasiAffineOperatorEEnum = null;

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
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QuasiAffinePackageImpl() {
		super(eNS_URI, QuasiAffineFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QuasiAffinePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QuasiAffinePackage init() {
		if (isInited) return (QuasiAffinePackage)EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI);

		// Obtain or create and register package
		QuasiAffinePackageImpl theQuasiAffinePackage = (QuasiAffinePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QuasiAffinePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QuasiAffinePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AlgebraPackageImpl theAlgebraPackage = (AlgebraPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI) instanceof AlgebraPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI) : AlgebraPackage.eINSTANCE);
		AffinePackageImpl theAffinePackage = (AffinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI) instanceof AffinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI) : AffinePackage.eINSTANCE);
		PolynomialsPackageImpl thePolynomialsPackage = (PolynomialsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI) instanceof PolynomialsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI) : PolynomialsPackage.eINSTANCE);
		ReductionsPackageImpl theReductionsPackage = (ReductionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI) instanceof ReductionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI) : ReductionsPackage.eINSTANCE);

		// Create package meta-data objects
		theQuasiAffinePackage.createPackageContents();
		theAlgebraPackage.createPackageContents();
		theAffinePackage.createPackageContents();
		thePolynomialsPackage.createPackageContents();
		theReductionsPackage.createPackageContents();

		// Initialize created meta-data
		theQuasiAffinePackage.initializePackageContents();
		theAlgebraPackage.initializePackageContents();
		theAffinePackage.initializePackageContents();
		thePolynomialsPackage.initializePackageContents();
		theReductionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQuasiAffinePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QuasiAffinePackage.eNS_URI, theQuasiAffinePackage);
		return theQuasiAffinePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuasiAffineExpression() {
		return quasiAffineExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuasiAffineExpression_Terms() {
		return (EReference)quasiAffineExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQuasiAffineExpression__Accept__AlgebraVisitor() {
		return quasiAffineExpressionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuasiAffineTerm() {
		return quasiAffineTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuasiAffineTerm_Operator() {
		return (EAttribute)quasiAffineTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getQuasiAffineTerm__Accept__AlgebraVisitor() {
		return quasiAffineTermEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleQuasiAffineTerm() {
		return simpleQuasiAffineTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleQuasiAffineTerm_Expression() {
		return (EReference)simpleQuasiAffineTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNestedQuasiAffineTerm() {
		return nestedQuasiAffineTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNestedQuasiAffineTerm_Expression() {
		return (EReference)nestedQuasiAffineTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQuasiAffineOperator() {
		return quasiAffineOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuasiAffineFactory getQuasiAffineFactory() {
		return (QuasiAffineFactory)getEFactoryInstance();
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
		quasiAffineExpressionEClass = createEClass(QUASI_AFFINE_EXPRESSION);
		createEReference(quasiAffineExpressionEClass, QUASI_AFFINE_EXPRESSION__TERMS);
		createEOperation(quasiAffineExpressionEClass, QUASI_AFFINE_EXPRESSION___ACCEPT__ALGEBRAVISITOR);

		quasiAffineTermEClass = createEClass(QUASI_AFFINE_TERM);
		createEAttribute(quasiAffineTermEClass, QUASI_AFFINE_TERM__OPERATOR);
		createEOperation(quasiAffineTermEClass, QUASI_AFFINE_TERM___ACCEPT__ALGEBRAVISITOR);

		simpleQuasiAffineTermEClass = createEClass(SIMPLE_QUASI_AFFINE_TERM);
		createEReference(simpleQuasiAffineTermEClass, SIMPLE_QUASI_AFFINE_TERM__EXPRESSION);

		nestedQuasiAffineTermEClass = createEClass(NESTED_QUASI_AFFINE_TERM);
		createEReference(nestedQuasiAffineTermEClass, NESTED_QUASI_AFFINE_TERM__EXPRESSION);

		// Create enums
		quasiAffineOperatorEEnum = createEEnum(QUASI_AFFINE_OPERATOR);
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
		AffinePackage theAffinePackage = (AffinePackage)EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		quasiAffineExpressionEClass.getESuperTypes().add(theAlgebraPackage.getIntExpression());
		quasiAffineExpressionEClass.getESuperTypes().add(theAlgebraPackage.getAlgebraVisitable());
		quasiAffineTermEClass.getESuperTypes().add(theAlgebraPackage.getIntTerm());
		quasiAffineTermEClass.getESuperTypes().add(theAlgebraPackage.getAlgebraVisitable());
		simpleQuasiAffineTermEClass.getESuperTypes().add(this.getQuasiAffineTerm());
		nestedQuasiAffineTermEClass.getESuperTypes().add(this.getQuasiAffineTerm());

		// Initialize classes, features, and operations; add parameters
		initEClass(quasiAffineExpressionEClass, QuasiAffineExpression.class, "QuasiAffineExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuasiAffineExpression_Terms(), this.getQuasiAffineTerm(), null, "terms", null, 0, -1, QuasiAffineExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getQuasiAffineExpression__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(quasiAffineTermEClass, QuasiAffineTerm.class, "QuasiAffineTerm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuasiAffineTerm_Operator(), this.getQuasiAffineOperator(), "operator", null, 1, 1, QuasiAffineTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getQuasiAffineTerm__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(simpleQuasiAffineTermEClass, SimpleQuasiAffineTerm.class, "SimpleQuasiAffineTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleQuasiAffineTerm_Expression(), theAffinePackage.getAffineExpression(), null, "expression", null, 1, 1, SimpleQuasiAffineTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nestedQuasiAffineTermEClass, NestedQuasiAffineTerm.class, "NestedQuasiAffineTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNestedQuasiAffineTerm_Expression(), this.getQuasiAffineExpression(), null, "expression", null, 1, 1, NestedQuasiAffineTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(quasiAffineOperatorEEnum, QuasiAffineOperator.class, "QuasiAffineOperator");
		addEEnumLiteral(quasiAffineOperatorEEnum, QuasiAffineOperator.MOD);
		addEEnumLiteral(quasiAffineOperatorEEnum, QuasiAffineOperator.FLOOR);
		addEEnumLiteral(quasiAffineOperatorEEnum, QuasiAffineOperator.CEIL);
		addEEnumLiteral(quasiAffineOperatorEEnum, QuasiAffineOperator.MUL);
		addEEnumLiteral(quasiAffineOperatorEEnum, QuasiAffineOperator.DIV);
	}

} //QuasiAffinePackageImpl
