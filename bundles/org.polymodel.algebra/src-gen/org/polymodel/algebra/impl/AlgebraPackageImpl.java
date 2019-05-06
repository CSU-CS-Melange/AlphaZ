/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.algebra.AlgebraFactory;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.CompositeIntExpression;
import org.polymodel.algebra.CompositeOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.SelectExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.algebra.affine.impl.AffinePackageImpl;
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
public class AlgebraPackageImpl extends EPackageImpl implements AlgebraPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intConstraintSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass algebraVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass algebraVisitableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeIntExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum comparisonOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fuzzyBooleanEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compositeOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType valueEDataType = null;

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
	 * @see org.polymodel.algebra.AlgebraPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AlgebraPackageImpl() {
		super(eNS_URI, AlgebraFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AlgebraPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AlgebraPackage init() {
		if (isInited) return (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Obtain or create and register package
		AlgebraPackageImpl theAlgebraPackage = (AlgebraPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AlgebraPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AlgebraPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AffinePackageImpl theAffinePackage = (AffinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI) instanceof AffinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI) : AffinePackage.eINSTANCE);
		QuasiAffinePackageImpl theQuasiAffinePackage = (QuasiAffinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI) instanceof QuasiAffinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI) : QuasiAffinePackage.eINSTANCE);
		PolynomialsPackageImpl thePolynomialsPackage = (PolynomialsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI) instanceof PolynomialsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI) : PolynomialsPackage.eINSTANCE);
		ReductionsPackageImpl theReductionsPackage = (ReductionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI) instanceof ReductionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI) : ReductionsPackage.eINSTANCE);

		// Create package meta-data objects
		theAlgebraPackage.createPackageContents();
		theAffinePackage.createPackageContents();
		theQuasiAffinePackage.createPackageContents();
		thePolynomialsPackage.createPackageContents();
		theReductionsPackage.createPackageContents();

		// Initialize created meta-data
		theAlgebraPackage.initializePackageContents();
		theAffinePackage.initializePackageContents();
		theQuasiAffinePackage.initializePackageContents();
		thePolynomialsPackage.initializePackageContents();
		theReductionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAlgebraPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AlgebraPackage.eNS_URI, theAlgebraPackage);
		return theAlgebraPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntExpression() {
		return intExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__IsEquivalent__IntExpression() {
		return intExpressionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__Simplify() {
		return intExpressionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__Substitute__Variable_Variable() {
		return intExpressionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__Substitute__Variable_IntExpression() {
		return intExpressionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__ToAffine() {
		return intExpressionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__ToQuasiAffine() {
		return intExpressionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__ToPolynomial() {
		return intExpressionEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__ToReduction() {
		return intExpressionEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__Accept__AlgebraVisitor() {
		return intExpressionEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntExpression__Copy() {
		return intExpressionEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntTerm() {
		return intTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntTerm_Coef() {
		return (EAttribute)intTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntTerm__Accept__AlgebraVisitor() {
		return intTermEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntTerm__IsEquivalent__IntTerm() {
		return intTermEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Name() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVariable__Accept__AlgebraVisitor() {
		return variableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntConstraint() {
		return intConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntConstraint_Lhs() {
		return (EReference)intConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntConstraint_Rhs() {
		return (EReference)intConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntConstraint_ComparisonOperator() {
		return (EAttribute)intConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraint__IsAffine() {
		return intConstraintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraint__IsQuasiAffine() {
		return intConstraintEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraint__IsPolynomial() {
		return intConstraintEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraint__Accept__AlgebraVisitor() {
		return intConstraintEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraint__Substitute__Variable_Variable() {
		return intConstraintEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraint__Substitute__Variable_IntExpression() {
		return intConstraintEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraint__Simplify() {
		return intConstraintEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraint__IsEquivalent__IntConstraint() {
		return intConstraintEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntConstraintSystem() {
		return intConstraintSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntConstraintSystem_Constraints() {
		return (EReference)intConstraintSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraintSystem__Accept__AlgebraVisitor() {
		return intConstraintSystemEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraintSystem__Substitute__Variable_Variable() {
		return intConstraintSystemEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraintSystem__Substitute__Variable_IntExpression() {
		return intConstraintSystemEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraintSystem__Simplify() {
		return intConstraintSystemEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIntConstraintSystem__Copy() {
		return intConstraintSystemEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlgebraVisitor() {
		return algebraVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitIntTerm__IntTerm() {
		return algebraVisitorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitVariable__Variable() {
		return algebraVisitorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitIntConstraint__IntConstraint() {
		return algebraVisitorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitIntConstraintSystem__IntConstraintSystem() {
		return algebraVisitorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitAffineExpression__AffineExpression() {
		return algebraVisitorEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitAffineTerm__AffineTerm() {
		return algebraVisitorEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitQuasiAffineExpression__QuasiAffineExpression() {
		return algebraVisitorEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitQuasiAffineTerm__QuasiAffineTerm() {
		return algebraVisitorEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitSimpleQuasiAffineTerm__SimpleQuasiAffineTerm() {
		return algebraVisitorEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitNestedQuasiAffineTerm__NestedQuasiAffineTerm() {
		return algebraVisitorEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitPolynomialExpression__PolynomialExpression() {
		return algebraVisitorEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitPolynomialTerm__PolynomialTerm() {
		return algebraVisitorEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitPolynomialVariable__PolynomialVariable() {
		return algebraVisitorEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitReductionExpression__ReductionExpression() {
		return algebraVisitorEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitIntExpression__IntExpression() {
		return algebraVisitorEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitCompositeIntExpression__CompositeIntExpression() {
		return algebraVisitorEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitor__VisitSelectExpression__SelectExpression() {
		return algebraVisitorEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlgebraVisitable() {
		return algebraVisitableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAlgebraVisitable__Accept__AlgebraVisitor() {
		return algebraVisitableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeIntExpression() {
		return compositeIntExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeIntExpression_Left() {
		return (EReference)compositeIntExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeIntExpression_Right() {
		return (EReference)compositeIntExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeIntExpression_Operator() {
		return (EAttribute)compositeIntExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCompositeIntExpression__Accept__AlgebraVisitor() {
		return compositeIntExpressionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectExpression() {
		return selectExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectExpression_Condition() {
		return (EReference)selectExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectExpression_Then() {
		return (EReference)selectExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectExpression_Else() {
		return (EReference)selectExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getComparisonOperator() {
		return comparisonOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFuzzyBoolean() {
		return fuzzyBooleanEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompositeOperator() {
		return compositeOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getValue() {
		return valueEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgebraFactory getAlgebraFactory() {
		return (AlgebraFactory)getEFactoryInstance();
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
		intExpressionEClass = createEClass(INT_EXPRESSION);
		createEOperation(intExpressionEClass, INT_EXPRESSION___IS_EQUIVALENT__INTEXPRESSION);
		createEOperation(intExpressionEClass, INT_EXPRESSION___SIMPLIFY);
		createEOperation(intExpressionEClass, INT_EXPRESSION___SUBSTITUTE__VARIABLE_VARIABLE);
		createEOperation(intExpressionEClass, INT_EXPRESSION___SUBSTITUTE__VARIABLE_INTEXPRESSION);
		createEOperation(intExpressionEClass, INT_EXPRESSION___TO_AFFINE);
		createEOperation(intExpressionEClass, INT_EXPRESSION___TO_QUASI_AFFINE);
		createEOperation(intExpressionEClass, INT_EXPRESSION___TO_POLYNOMIAL);
		createEOperation(intExpressionEClass, INT_EXPRESSION___TO_REDUCTION);
		createEOperation(intExpressionEClass, INT_EXPRESSION___ACCEPT__ALGEBRAVISITOR);
		createEOperation(intExpressionEClass, INT_EXPRESSION___COPY);

		intTermEClass = createEClass(INT_TERM);
		createEAttribute(intTermEClass, INT_TERM__COEF);
		createEOperation(intTermEClass, INT_TERM___ACCEPT__ALGEBRAVISITOR);
		createEOperation(intTermEClass, INT_TERM___IS_EQUIVALENT__INTTERM);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);
		createEOperation(variableEClass, VARIABLE___ACCEPT__ALGEBRAVISITOR);

		intConstraintEClass = createEClass(INT_CONSTRAINT);
		createEReference(intConstraintEClass, INT_CONSTRAINT__LHS);
		createEReference(intConstraintEClass, INT_CONSTRAINT__RHS);
		createEAttribute(intConstraintEClass, INT_CONSTRAINT__COMPARISON_OPERATOR);
		createEOperation(intConstraintEClass, INT_CONSTRAINT___IS_AFFINE);
		createEOperation(intConstraintEClass, INT_CONSTRAINT___IS_QUASI_AFFINE);
		createEOperation(intConstraintEClass, INT_CONSTRAINT___IS_POLYNOMIAL);
		createEOperation(intConstraintEClass, INT_CONSTRAINT___ACCEPT__ALGEBRAVISITOR);
		createEOperation(intConstraintEClass, INT_CONSTRAINT___SUBSTITUTE__VARIABLE_VARIABLE);
		createEOperation(intConstraintEClass, INT_CONSTRAINT___SUBSTITUTE__VARIABLE_INTEXPRESSION);
		createEOperation(intConstraintEClass, INT_CONSTRAINT___SIMPLIFY);
		createEOperation(intConstraintEClass, INT_CONSTRAINT___IS_EQUIVALENT__INTCONSTRAINT);

		intConstraintSystemEClass = createEClass(INT_CONSTRAINT_SYSTEM);
		createEReference(intConstraintSystemEClass, INT_CONSTRAINT_SYSTEM__CONSTRAINTS);
		createEOperation(intConstraintSystemEClass, INT_CONSTRAINT_SYSTEM___ACCEPT__ALGEBRAVISITOR);
		createEOperation(intConstraintSystemEClass, INT_CONSTRAINT_SYSTEM___SUBSTITUTE__VARIABLE_VARIABLE);
		createEOperation(intConstraintSystemEClass, INT_CONSTRAINT_SYSTEM___SUBSTITUTE__VARIABLE_INTEXPRESSION);
		createEOperation(intConstraintSystemEClass, INT_CONSTRAINT_SYSTEM___SIMPLIFY);
		createEOperation(intConstraintSystemEClass, INT_CONSTRAINT_SYSTEM___COPY);

		algebraVisitorEClass = createEClass(ALGEBRA_VISITOR);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_INT_TERM__INTTERM);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_VARIABLE__VARIABLE);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_INT_CONSTRAINT__INTCONSTRAINT);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_INT_CONSTRAINT_SYSTEM__INTCONSTRAINTSYSTEM);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_AFFINE_EXPRESSION__AFFINEEXPRESSION);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_AFFINE_TERM__AFFINETERM);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_QUASI_AFFINE_EXPRESSION__QUASIAFFINEEXPRESSION);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_QUASI_AFFINE_TERM__QUASIAFFINETERM);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_SIMPLE_QUASI_AFFINE_TERM__SIMPLEQUASIAFFINETERM);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_NESTED_QUASI_AFFINE_TERM__NESTEDQUASIAFFINETERM);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_POLYNOMIAL_EXPRESSION__POLYNOMIALEXPRESSION);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_POLYNOMIAL_TERM__POLYNOMIALTERM);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_POLYNOMIAL_VARIABLE__POLYNOMIALVARIABLE);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_REDUCTION_EXPRESSION__REDUCTIONEXPRESSION);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_INT_EXPRESSION__INTEXPRESSION);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_COMPOSITE_INT_EXPRESSION__COMPOSITEINTEXPRESSION);
		createEOperation(algebraVisitorEClass, ALGEBRA_VISITOR___VISIT_SELECT_EXPRESSION__SELECTEXPRESSION);

		algebraVisitableEClass = createEClass(ALGEBRA_VISITABLE);
		createEOperation(algebraVisitableEClass, ALGEBRA_VISITABLE___ACCEPT__ALGEBRAVISITOR);

		compositeIntExpressionEClass = createEClass(COMPOSITE_INT_EXPRESSION);
		createEReference(compositeIntExpressionEClass, COMPOSITE_INT_EXPRESSION__LEFT);
		createEReference(compositeIntExpressionEClass, COMPOSITE_INT_EXPRESSION__RIGHT);
		createEAttribute(compositeIntExpressionEClass, COMPOSITE_INT_EXPRESSION__OPERATOR);
		createEOperation(compositeIntExpressionEClass, COMPOSITE_INT_EXPRESSION___ACCEPT__ALGEBRAVISITOR);

		selectExpressionEClass = createEClass(SELECT_EXPRESSION);
		createEReference(selectExpressionEClass, SELECT_EXPRESSION__CONDITION);
		createEReference(selectExpressionEClass, SELECT_EXPRESSION__THEN);
		createEReference(selectExpressionEClass, SELECT_EXPRESSION__ELSE);

		// Create enums
		comparisonOperatorEEnum = createEEnum(COMPARISON_OPERATOR);
		fuzzyBooleanEEnum = createEEnum(FUZZY_BOOLEAN);
		compositeOperatorEEnum = createEEnum(COMPOSITE_OPERATOR);

		// Create data types
		valueEDataType = createEDataType(VALUE);
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
		AffinePackage theAffinePackage = (AffinePackage)EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI);
		QuasiAffinePackage theQuasiAffinePackage = (QuasiAffinePackage)EPackage.Registry.INSTANCE.getEPackage(QuasiAffinePackage.eNS_URI);
		PolynomialsPackage thePolynomialsPackage = (PolynomialsPackage)EPackage.Registry.INSTANCE.getEPackage(PolynomialsPackage.eNS_URI);
		ReductionsPackage theReductionsPackage = (ReductionsPackage)EPackage.Registry.INSTANCE.getEPackage(ReductionsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theAffinePackage);
		getESubpackages().add(theQuasiAffinePackage);
		getESubpackages().add(thePolynomialsPackage);
		getESubpackages().add(theReductionsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		intExpressionEClass.getESuperTypes().add(this.getAlgebraVisitable());
		intTermEClass.getESuperTypes().add(this.getAlgebraVisitable());
		variableEClass.getESuperTypes().add(this.getAlgebraVisitable());
		intConstraintEClass.getESuperTypes().add(this.getAlgebraVisitable());
		intConstraintSystemEClass.getESuperTypes().add(this.getAlgebraVisitable());
		compositeIntExpressionEClass.getESuperTypes().add(this.getIntExpression());
		selectExpressionEClass.getESuperTypes().add(this.getIntExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(intExpressionEClass, IntExpression.class, "IntExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getIntExpression__IsEquivalent__IntExpression(), this.getFuzzyBoolean(), "isEquivalent", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntExpression(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntExpression__Simplify(), this.getIntExpression(), "simplify", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntExpression__Substitute__Variable_Variable(), this.getIntExpression(), "substitute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "substituted", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "newVar", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntExpression__Substitute__Variable_IntExpression(), this.getIntExpression(), "substitute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "substituted", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntExpression(), "newExpr", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntExpression__ToAffine(), theAffinePackage.getAffineExpression(), "toAffine", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntExpression__ToQuasiAffine(), theQuasiAffinePackage.getQuasiAffineExpression(), "toQuasiAffine", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntExpression__ToPolynomial(), thePolynomialsPackage.getPolynomialExpression(), "toPolynomial", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntExpression__ToReduction(), theReductionsPackage.getReductionExpression(), "toReduction", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntExpression__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntExpression__Copy(), null, "copy", 1, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		EGenericType g1 = createEGenericType(this.getIntExpression());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(intTermEClass, IntTerm.class, "IntTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntTerm_Coef(), this.getValue(), "coef", null, 0, 1, IntTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getIntTerm__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntTerm__IsEquivalent__IntTerm(), ecorePackage.getEBoolean(), "isEquivalent", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntTerm(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVariable__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(intConstraintEClass, IntConstraint.class, "IntConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntConstraint_Lhs(), this.getIntExpression(), null, "lhs", null, 1, 1, IntConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntConstraint_Rhs(), this.getIntExpression(), null, "rhs", null, 1, 1, IntConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntConstraint_ComparisonOperator(), this.getComparisonOperator(), "comparisonOperator", null, 1, 1, IntConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIntConstraint__IsAffine(), ecorePackage.getEBoolean(), "isAffine", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntConstraint__IsQuasiAffine(), ecorePackage.getEBoolean(), "isQuasiAffine", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntConstraint__IsPolynomial(), ecorePackage.getEBoolean(), "isPolynomial", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntConstraint__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntConstraint__Substitute__Variable_Variable(), this.getIntConstraint(), "substitute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "substituted", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "newVar", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntConstraint__Substitute__Variable_IntExpression(), this.getIntConstraint(), "substitute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "substituted", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntExpression(), "newExpr", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntConstraint__Simplify(), this.getIntConstraint(), "simplify", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntConstraint__IsEquivalent__IntConstraint(), this.getFuzzyBoolean(), "isEquivalent", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntConstraint(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(intConstraintSystemEClass, IntConstraintSystem.class, "IntConstraintSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntConstraintSystem_Constraints(), this.getIntConstraint(), null, "constraints", null, 0, -1, IntConstraintSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getIntConstraintSystem__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntConstraintSystem__Substitute__Variable_Variable(), this.getIntConstraintSystem(), "substitute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "substituted", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "newVar", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIntConstraintSystem__Substitute__Variable_IntExpression(), this.getIntConstraintSystem(), "substitute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "substituted", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntExpression(), "newExpr", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntConstraintSystem__Simplify(), this.getIntConstraintSystem(), "simplify", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIntConstraintSystem__Copy(), this.getIntConstraintSystem(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(algebraVisitorEClass, AlgebraVisitor.class, "AlgebraVisitor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getAlgebraVisitor__VisitIntTerm__IntTerm(), null, "visitIntTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntTerm(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitVariable__Variable(), null, "visitVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariable(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitIntConstraint__IntConstraint(), null, "visitIntConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntConstraint(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitIntConstraintSystem__IntConstraintSystem(), null, "visitIntConstraintSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntConstraintSystem(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitAffineExpression__AffineExpression(), null, "visitAffineExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAffinePackage.getAffineExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitAffineTerm__AffineTerm(), null, "visitAffineTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAffinePackage.getAffineTerm(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitQuasiAffineExpression__QuasiAffineExpression(), null, "visitQuasiAffineExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theQuasiAffinePackage.getQuasiAffineExpression(), "q", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitQuasiAffineTerm__QuasiAffineTerm(), null, "visitQuasiAffineTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theQuasiAffinePackage.getQuasiAffineTerm(), "q", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitSimpleQuasiAffineTerm__SimpleQuasiAffineTerm(), null, "visitSimpleQuasiAffineTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theQuasiAffinePackage.getSimpleQuasiAffineTerm(), "q", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitNestedQuasiAffineTerm__NestedQuasiAffineTerm(), null, "visitNestedQuasiAffineTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theQuasiAffinePackage.getNestedQuasiAffineTerm(), "q", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitPolynomialExpression__PolynomialExpression(), null, "visitPolynomialExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolynomialsPackage.getPolynomialExpression(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitPolynomialTerm__PolynomialTerm(), null, "visitPolynomialTerm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolynomialsPackage.getPolynomialTerm(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitPolynomialVariable__PolynomialVariable(), null, "visitPolynomialVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolynomialsPackage.getPolynomialVariable(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitReductionExpression__ReductionExpression(), null, "visitReductionExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theReductionsPackage.getReductionExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitIntExpression__IntExpression(), null, "visitIntExpression", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntExpression(), "ie", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitCompositeIntExpression__CompositeIntExpression(), null, "visitCompositeIntExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCompositeIntExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAlgebraVisitor__VisitSelectExpression__SelectExpression(), null, "visitSelectExpression", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSelectExpression(), "ie", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(algebraVisitableEClass, AlgebraVisitable.class, "AlgebraVisitable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getAlgebraVisitable__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(compositeIntExpressionEClass, CompositeIntExpression.class, "CompositeIntExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeIntExpression_Left(), this.getIntExpression(), null, "left", null, 1, 1, CompositeIntExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeIntExpression_Right(), this.getIntExpression(), null, "right", null, 1, 1, CompositeIntExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeIntExpression_Operator(), this.getCompositeOperator(), "operator", null, 1, 1, CompositeIntExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCompositeIntExpression__Accept__AlgebraVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlgebraVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(selectExpressionEClass, SelectExpression.class, "SelectExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectExpression_Condition(), this.getIntConstraintSystem(), null, "condition", null, 0, -1, SelectExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectExpression_Then(), this.getIntExpression(), null, "then", null, 1, 1, SelectExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectExpression_Else(), this.getIntExpression(), null, "else", null, 1, 1, SelectExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(comparisonOperatorEEnum, ComparisonOperator.class, "ComparisonOperator");
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.EQ);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.NE);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.GT);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.GE);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.LT);
		addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.LE);

		initEEnum(fuzzyBooleanEEnum, FuzzyBoolean.class, "FuzzyBoolean");
		addEEnumLiteral(fuzzyBooleanEEnum, FuzzyBoolean.YES);
		addEEnumLiteral(fuzzyBooleanEEnum, FuzzyBoolean.NO);
		addEEnumLiteral(fuzzyBooleanEEnum, FuzzyBoolean.MAYBE);

		initEEnum(compositeOperatorEEnum, CompositeOperator.class, "CompositeOperator");
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.DIV);
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.MOD);
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.CEIL);
		addEEnumLiteral(compositeOperatorEEnum, CompositeOperator.FLOOR);

		// Initialize data types
		initEDataType(valueEDataType, long.class, "Value", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AlgebraPackageImpl
