/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.polynomials.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.algebra.affine.impl.AffinePackageImpl;
import org.polymodel.algebra.impl.AlgebraPackageImpl;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.polynomials.PolynomialsFactory;
import org.polymodel.algebra.polynomials.PolynomialsPackage;
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
public class PolynomialsPackageImpl extends EPackageImpl implements PolynomialsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polynomialExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polynomialVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polynomialTermEClass = null;

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
	 * @see org.polymodel.algebra.polynomials.PolynomialsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PolynomialsPackageImpl() {
		super(eNS_URI, PolynomialsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PolynomialsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PolynomialsPackage init() {
		if (isInited) return (PolynomialsPackage)EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI);

		// Obtain or create and register package
		PolynomialsPackageImpl thePolynomialsPackage = (PolynomialsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PolynomialsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PolynomialsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AlgebraPackageImpl theAlgebraPackage = (AlgebraPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI) instanceof AlgebraPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI) : AlgebraPackage.eINSTANCE);
		AffinePackageImpl theAffinePackage = (AffinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI) instanceof AffinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI) : AffinePackage.eINSTANCE);
		QuasiAffinePackageImpl theQuasiAffinePackage = (QuasiAffinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI) instanceof QuasiAffinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI) : QuasiAffinePackage.eINSTANCE);
		ReductionsPackageImpl theReductionsPackage = (ReductionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI) instanceof ReductionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI) : ReductionsPackage.eINSTANCE);

		// Create package meta-data objects
		thePolynomialsPackage.createPackageContents();
		theAlgebraPackage.createPackageContents();
		theAffinePackage.createPackageContents();
		theQuasiAffinePackage.createPackageContents();
		theReductionsPackage.createPackageContents();

		// Initialize created meta-data
		thePolynomialsPackage.initializePackageContents();
		theAlgebraPackage.initializePackageContents();
		theAffinePackage.initializePackageContents();
		theQuasiAffinePackage.initializePackageContents();
		theReductionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePolynomialsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PolynomialsPackage.eNS_URI, thePolynomialsPackage);
		return thePolynomialsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolynomialExpression() {
		return polynomialExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolynomialExpression_Terms() {
		return (EReference)polynomialExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolynomialExpression__Accept__AlgebraVisitor() {
		return polynomialExpressionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolynomialExpression__IsAffine() {
		return polynomialExpressionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolynomialExpression__IsQuasiAffine() {
		return polynomialExpressionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolynomialVariable() {
		return polynomialVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolynomialVariable_Variable() {
		return (EReference)polynomialVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolynomialVariable_Exponent() {
		return (EAttribute)polynomialVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolynomialVariable__Accept__AlgebraVisitor() {
		return polynomialVariableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolynomialVariable__IsEquivalent__PolynomialVariable() {
		return polynomialVariableEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolynomialTerm() {
		return polynomialTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolynomialTerm_Numerator() {
		return (EAttribute)polynomialTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolynomialTerm_Denominator() {
		return (EAttribute)polynomialTermEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolynomialTerm_Variables() {
		return (EReference)polynomialTermEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolynomialTerm__Accept__AlgebraVisitor() {
		return polynomialTermEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolynomialTerm__IsAffine() {
		return polynomialTermEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolynomialTerm__IsQuasiAffine() {
		return polynomialTermEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolynomialsFactory getPolynomialsFactory() {
		return (PolynomialsFactory)getEFactoryInstance();
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
		polynomialExpressionEClass = createEClass(POLYNOMIAL_EXPRESSION);
		createEReference(polynomialExpressionEClass, POLYNOMIAL_EXPRESSION__TERMS);
		createEOperation(polynomialExpressionEClass, POLYNOMIAL_EXPRESSION___ACCEPT__ALGEBRAVISITOR);
		createEOperation(polynomialExpressionEClass, POLYNOMIAL_EXPRESSION___IS_AFFINE);
		createEOperation(polynomialExpressionEClass, POLYNOMIAL_EXPRESSION___IS_QUASI_AFFINE);

		polynomialVariableEClass = createEClass(POLYNOMIAL_VARIABLE);
		createEReference(polynomialVariableEClass, POLYNOMIAL_VARIABLE__VARIABLE);
		createEAttribute(polynomialVariableEClass, POLYNOMIAL_VARIABLE__EXPONENT);
		createEOperation(polynomialVariableEClass, POLYNOMIAL_VARIABLE___ACCEPT__ALGEBRAVISITOR);
		createEOperation(polynomialVariableEClass, POLYNOMIAL_VARIABLE___IS_EQUIVALENT__POLYNOMIALVARIABLE);

		polynomialTermEClass = createEClass(POLYNOMIAL_TERM);
		createEAttribute(polynomialTermEClass, POLYNOMIAL_TERM__NUMERATOR);
		createEAttribute(polynomialTermEClass, POLYNOMIAL_TERM__DENOMINATOR);
		createEReference(polynomialTermEClass, POLYNOMIAL_TERM__VARIABLES);
		createEOperation(polynomialTermEClass, POLYNOMIAL_TERM___ACCEPT__ALGEBRAVISITOR);
		createEOperation(polynomialTermEClass, POLYNOMIAL_TERM___IS_AFFINE);
		createEOperation(polynomialTermEClass, POLYNOMIAL_TERM___IS_QUASI_AFFINE);
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
		polynomialExpressionEClass.getESuperTypes().add(theAlgebraPackage.getIntExpression());
		polynomialExpressionEClass.getESuperTypes().add(theAlgebraPackage.getAlgebraVisitable());
		polynomialVariableEClass.getESuperTypes().add(theAlgebraPackage.getAlgebraVisitable());
		polynomialTermEClass.getESuperTypes().add(theAlgebraPackage.getAlgebraVisitable());

		// Initialize classes, features, and operations; add parameters
		initEClass(polynomialExpressionEClass, PolynomialExpression.class, "PolynomialExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPolynomialExpression_Terms(), this.getPolynomialTerm(), null, "terms", null, 0, -1, PolynomialExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getPolynomialExpression__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPolynomialExpression__IsAffine(), ecorePackage.getEBoolean(), "isAffine", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPolynomialExpression__IsQuasiAffine(), ecorePackage.getEBoolean(), "isQuasiAffine", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polynomialVariableEClass, PolynomialVariable.class, "PolynomialVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPolynomialVariable_Variable(), theAlgebraPackage.getVariable(), null, "variable", null, 0, 1, PolynomialVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolynomialVariable_Exponent(), theAlgebraPackage.getValue(), "exponent", null, 0, 1, PolynomialVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPolynomialVariable__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolynomialVariable__IsEquivalent__PolynomialVariable(), ecorePackage.getEBoolean(), "isEquivalent", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolynomialVariable(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polynomialTermEClass, PolynomialTerm.class, "PolynomialTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolynomialTerm_Numerator(), theAlgebraPackage.getValue(), "numerator", null, 0, 1, PolynomialTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPolynomialTerm_Denominator(), theAlgebraPackage.getValue(), "denominator", null, 0, 1, PolynomialTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPolynomialTerm_Variables(), this.getPolynomialVariable(), null, "variables", null, 0, -1, PolynomialTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPolynomialTerm__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPolynomialTerm__IsAffine(), ecorePackage.getEBoolean(), "isAffine", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPolynomialTerm__IsQuasiAffine(), ecorePackage.getEBoolean(), "isQuasiAffine", 1, 1, IS_UNIQUE, IS_ORDERED);
	}

} //PolynomialsPackageImpl
