/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem;
import edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AAndExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AConstantExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation;
import edu.csu.melange.alphabets.xtext.alphabets.ADomain;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier;
import edu.csu.melange.alphabets.xtext.alphabets.AFunction;
import edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation;
import edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList;
import edu.csu.melange.alphabets.xtext.alphabets.AIfExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexList;
import edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiArgExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ANotExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AOrExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.APolyhedron;
import edu.csu.melange.alphabets.xtext.alphabets.AProgram;
import edu.csu.melange.alphabets.xtext.alphabets.ARealExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AType;
import edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsFactory;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlphabetsPackageImpl extends EPackageImpl implements AlphabetsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aProgramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aExternalFunctionDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aExternalFunctionIdentifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aAffineSystemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aOutputDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aInputDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aLocalDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aIdentifierListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aDomainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aPolyhedronEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aStandardEquationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aAlphabetsExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aNotExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aNegateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aCaseExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aDependenceExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aDependenceInArrayNotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aIfExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aIndexExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aReduceExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aRestrictExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aVariableExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aConstantExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aBooleanExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aIntegerExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aRealExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aMultiArgExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aMultiArgArithmeticExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aMultiArgLogicalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aExternalFunctionCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aIndexListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aIndexAffineExpressionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aFunctionInArrayNotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aAndExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aRelationalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aAdditiveExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aMultiplicativeExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aMinMaxExpressionEClass = null;

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
   * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AlphabetsPackageImpl()
  {
    super(eNS_URI, AlphabetsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link AlphabetsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AlphabetsPackage init()
  {
    if (isInited) return (AlphabetsPackage)EPackage.Registry.INSTANCE.getEPackage(AlphabetsPackage.eNS_URI);

    // Obtain or create and register package
    AlphabetsPackageImpl theAlphabetsPackage = (AlphabetsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AlphabetsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AlphabetsPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theAlphabetsPackage.createPackageContents();

    // Initialize created meta-data
    theAlphabetsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAlphabetsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AlphabetsPackage.eNS_URI, theAlphabetsPackage);
    return theAlphabetsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAProgram()
  {
    return aProgramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAProgram_ExternalFunctions()
  {
    return (EReference)aProgramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAProgram_Systems()
  {
    return (EReference)aProgramEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAExternalFunctionDeclaration()
  {
    return aExternalFunctionDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAExternalFunctionDeclaration_Output()
  {
    return (EReference)aExternalFunctionDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAExternalFunctionDeclaration_Name()
  {
    return (EReference)aExternalFunctionDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAExternalFunctionDeclaration_Inputs()
  {
    return (EReference)aExternalFunctionDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAExternalFunctionIdentifier()
  {
    return aExternalFunctionIdentifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAExternalFunctionIdentifier_Name()
  {
    return (EAttribute)aExternalFunctionIdentifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAAffineSystem()
  {
    return aAffineSystemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAAffineSystem_Name()
  {
    return (EAttribute)aAffineSystemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAffineSystem_Parameters()
  {
    return (EReference)aAffineSystemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAffineSystem_InputDeclarations()
  {
    return (EReference)aAffineSystemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAffineSystem_OutputDeclarations()
  {
    return (EReference)aAffineSystemEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAffineSystem_LocalvarDeclarations()
  {
    return (EReference)aAffineSystemEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAffineSystem_Equations()
  {
    return (EReference)aAffineSystemEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAOutputDeclaration()
  {
    return aOutputDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAOutputDeclaration_Type()
  {
    return (EReference)aOutputDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAOutputDeclaration_IdentifierList()
  {
    return (EReference)aOutputDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAOutputDeclaration_Domain()
  {
    return (EReference)aOutputDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAInputDeclaration()
  {
    return aInputDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAInputDeclaration_Type()
  {
    return (EReference)aInputDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAInputDeclaration_IdentifierList()
  {
    return (EReference)aInputDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAInputDeclaration_Domain()
  {
    return (EReference)aInputDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getALocalDeclaration()
  {
    return aLocalDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getALocalDeclaration_Type()
  {
    return (EReference)aLocalDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getALocalDeclaration_IdentifierList()
  {
    return (EReference)aLocalDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getALocalDeclaration_Domain()
  {
    return (EReference)aLocalDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAIdentifierList()
  {
    return aIdentifierListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAIdentifierList_Identifiers()
  {
    return (EAttribute)aIdentifierListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getADomain()
  {
    return aDomainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getADomain_Polyhedra()
  {
    return (EReference)aDomainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAPolyhedron()
  {
    return aPolyhedronEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAPolyhedron_Indexes()
  {
    return (EReference)aPolyhedronEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAPolyhedron_Constraints()
  {
    return (EAttribute)aPolyhedronEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAStandardEquation()
  {
    return aStandardEquationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAStandardEquation_Var()
  {
    return (EAttribute)aStandardEquationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAStandardEquation_Indexes()
  {
    return (EReference)aStandardEquationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAStandardEquation_Expr()
  {
    return (EReference)aStandardEquationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAAlphabetsExpression()
  {
    return aAlphabetsExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getANotExpression()
  {
    return aNotExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getANotExpression_Op()
  {
    return (EAttribute)aNotExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getANotExpression_Expr()
  {
    return (EReference)aNotExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getANegateExpression()
  {
    return aNegateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getANegateExpression_Op()
  {
    return (EAttribute)aNegateExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getANegateExpression_Expr()
  {
    return (EReference)aNegateExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getACaseExpression()
  {
    return aCaseExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getACaseExpression_Exprs()
  {
    return (EReference)aCaseExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getADependenceExpression()
  {
    return aDependenceExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getADependenceExpression_Func()
  {
    return (EReference)aDependenceExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getADependenceExpression_Expr()
  {
    return (EReference)aDependenceExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getADependenceInArrayNotation()
  {
    return aDependenceInArrayNotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getADependenceInArrayNotation_Var()
  {
    return (EAttribute)aDependenceInArrayNotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getADependenceInArrayNotation_Dep()
  {
    return (EReference)aDependenceInArrayNotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAIfExpression()
  {
    return aIfExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAIfExpression_Cond()
  {
    return (EReference)aIfExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAIfExpression_Then()
  {
    return (EReference)aIfExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAIfExpression_Else()
  {
    return (EReference)aIfExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAIndexExpression()
  {
    return aIndexExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAIndexExpression_Func()
  {
    return (EAttribute)aIndexExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAIndexExpression_Indexes()
  {
    return (EReference)aIndexExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAReduceExpression()
  {
    return aReduceExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAReduceExpression_Op()
  {
    return (EAttribute)aReduceExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAReduceExpression_Projection()
  {
    return (EReference)aReduceExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAReduceExpression_Expr()
  {
    return (EReference)aReduceExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getARestrictExpression()
  {
    return aRestrictExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getARestrictExpression_Domain()
  {
    return (EReference)aRestrictExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getARestrictExpression_Expr()
  {
    return (EReference)aRestrictExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAVariableExpression()
  {
    return aVariableExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAVariableExpression_Var()
  {
    return (EAttribute)aVariableExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAConstantExpression()
  {
    return aConstantExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getABooleanExpression()
  {
    return aBooleanExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getABooleanExpression_Value()
  {
    return (EAttribute)aBooleanExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAIntegerExpression()
  {
    return aIntegerExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAIntegerExpression_Value()
  {
    return (EAttribute)aIntegerExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getARealExpression()
  {
    return aRealExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getARealExpression_Value()
  {
    return (EAttribute)aRealExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAMultiArgExpression()
  {
    return aMultiArgExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAMultiArgExpression_Exprs()
  {
    return (EReference)aMultiArgExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAMultiArgArithmeticExpression()
  {
    return aMultiArgArithmeticExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAMultiArgArithmeticExpression_Op()
  {
    return (EAttribute)aMultiArgArithmeticExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAMultiArgLogicalExpression()
  {
    return aMultiArgLogicalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAMultiArgLogicalExpression_Op()
  {
    return (EAttribute)aMultiArgLogicalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAExternalFunctionCall()
  {
    return aExternalFunctionCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAExternalFunctionCall_Func()
  {
    return (EAttribute)aExternalFunctionCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAIndexList()
  {
    return aIndexListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAIndexList_Ids()
  {
    return (EAttribute)aIndexListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAIndexAffineExpressionList()
  {
    return aIndexAffineExpressionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAIndexAffineExpressionList_Exprs()
  {
    return (EAttribute)aIndexAffineExpressionListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAFunction()
  {
    return aFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAFunction_Indexes()
  {
    return (EReference)aFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAFunction_Func()
  {
    return (EReference)aFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAFunctionInArrayNotation()
  {
    return aFunctionInArrayNotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAFunctionInArrayNotation_NewIds()
  {
    return (EReference)aFunctionInArrayNotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAType()
  {
    return aTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAType_Unsigned()
  {
    return (EAttribute)aTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAType_Type()
  {
    return (EAttribute)aTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAOrExpression()
  {
    return aOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAOrExpression_Left()
  {
    return (EReference)aOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAOrExpression_Operator()
  {
    return (EAttribute)aOrExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAOrExpression_Right()
  {
    return (EReference)aOrExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAAndExpression()
  {
    return aAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAndExpression_Left()
  {
    return (EReference)aAndExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAAndExpression_Operator()
  {
    return (EAttribute)aAndExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAndExpression_Right()
  {
    return (EReference)aAndExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getARelationalExpression()
  {
    return aRelationalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getARelationalExpression_Left()
  {
    return (EReference)aRelationalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getARelationalExpression_Operator()
  {
    return (EAttribute)aRelationalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getARelationalExpression_Right()
  {
    return (EReference)aRelationalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAAdditiveExpression()
  {
    return aAdditiveExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAdditiveExpression_Left()
  {
    return (EReference)aAdditiveExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAAdditiveExpression_Op()
  {
    return (EAttribute)aAdditiveExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAAdditiveExpression_Right()
  {
    return (EReference)aAdditiveExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAMultiplicativeExpression()
  {
    return aMultiplicativeExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAMultiplicativeExpression_Left()
  {
    return (EReference)aMultiplicativeExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAMultiplicativeExpression_Op()
  {
    return (EAttribute)aMultiplicativeExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAMultiplicativeExpression_Right()
  {
    return (EReference)aMultiplicativeExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAMinMaxExpression()
  {
    return aMinMaxExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAMinMaxExpression_Left()
  {
    return (EReference)aMinMaxExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAMinMaxExpression_Op()
  {
    return (EAttribute)aMinMaxExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAMinMaxExpression_Right()
  {
    return (EReference)aMinMaxExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlphabetsFactory getAlphabetsFactory()
  {
    return (AlphabetsFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    aProgramEClass = createEClass(APROGRAM);
    createEReference(aProgramEClass, APROGRAM__EXTERNAL_FUNCTIONS);
    createEReference(aProgramEClass, APROGRAM__SYSTEMS);

    aExternalFunctionDeclarationEClass = createEClass(AEXTERNAL_FUNCTION_DECLARATION);
    createEReference(aExternalFunctionDeclarationEClass, AEXTERNAL_FUNCTION_DECLARATION__OUTPUT);
    createEReference(aExternalFunctionDeclarationEClass, AEXTERNAL_FUNCTION_DECLARATION__NAME);
    createEReference(aExternalFunctionDeclarationEClass, AEXTERNAL_FUNCTION_DECLARATION__INPUTS);

    aExternalFunctionIdentifierEClass = createEClass(AEXTERNAL_FUNCTION_IDENTIFIER);
    createEAttribute(aExternalFunctionIdentifierEClass, AEXTERNAL_FUNCTION_IDENTIFIER__NAME);

    aAffineSystemEClass = createEClass(AAFFINE_SYSTEM);
    createEAttribute(aAffineSystemEClass, AAFFINE_SYSTEM__NAME);
    createEReference(aAffineSystemEClass, AAFFINE_SYSTEM__PARAMETERS);
    createEReference(aAffineSystemEClass, AAFFINE_SYSTEM__INPUT_DECLARATIONS);
    createEReference(aAffineSystemEClass, AAFFINE_SYSTEM__OUTPUT_DECLARATIONS);
    createEReference(aAffineSystemEClass, AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS);
    createEReference(aAffineSystemEClass, AAFFINE_SYSTEM__EQUATIONS);

    aOutputDeclarationEClass = createEClass(AOUTPUT_DECLARATION);
    createEReference(aOutputDeclarationEClass, AOUTPUT_DECLARATION__TYPE);
    createEReference(aOutputDeclarationEClass, AOUTPUT_DECLARATION__IDENTIFIER_LIST);
    createEReference(aOutputDeclarationEClass, AOUTPUT_DECLARATION__DOMAIN);

    aInputDeclarationEClass = createEClass(AINPUT_DECLARATION);
    createEReference(aInputDeclarationEClass, AINPUT_DECLARATION__TYPE);
    createEReference(aInputDeclarationEClass, AINPUT_DECLARATION__IDENTIFIER_LIST);
    createEReference(aInputDeclarationEClass, AINPUT_DECLARATION__DOMAIN);

    aLocalDeclarationEClass = createEClass(ALOCAL_DECLARATION);
    createEReference(aLocalDeclarationEClass, ALOCAL_DECLARATION__TYPE);
    createEReference(aLocalDeclarationEClass, ALOCAL_DECLARATION__IDENTIFIER_LIST);
    createEReference(aLocalDeclarationEClass, ALOCAL_DECLARATION__DOMAIN);

    aIdentifierListEClass = createEClass(AIDENTIFIER_LIST);
    createEAttribute(aIdentifierListEClass, AIDENTIFIER_LIST__IDENTIFIERS);

    aDomainEClass = createEClass(ADOMAIN);
    createEReference(aDomainEClass, ADOMAIN__POLYHEDRA);

    aPolyhedronEClass = createEClass(APOLYHEDRON);
    createEReference(aPolyhedronEClass, APOLYHEDRON__INDEXES);
    createEAttribute(aPolyhedronEClass, APOLYHEDRON__CONSTRAINTS);

    aStandardEquationEClass = createEClass(ASTANDARD_EQUATION);
    createEAttribute(aStandardEquationEClass, ASTANDARD_EQUATION__VAR);
    createEReference(aStandardEquationEClass, ASTANDARD_EQUATION__INDEXES);
    createEReference(aStandardEquationEClass, ASTANDARD_EQUATION__EXPR);

    aAlphabetsExpressionEClass = createEClass(AALPHABETS_EXPRESSION);

    aNotExpressionEClass = createEClass(ANOT_EXPRESSION);
    createEAttribute(aNotExpressionEClass, ANOT_EXPRESSION__OP);
    createEReference(aNotExpressionEClass, ANOT_EXPRESSION__EXPR);

    aNegateExpressionEClass = createEClass(ANEGATE_EXPRESSION);
    createEAttribute(aNegateExpressionEClass, ANEGATE_EXPRESSION__OP);
    createEReference(aNegateExpressionEClass, ANEGATE_EXPRESSION__EXPR);

    aCaseExpressionEClass = createEClass(ACASE_EXPRESSION);
    createEReference(aCaseExpressionEClass, ACASE_EXPRESSION__EXPRS);

    aDependenceExpressionEClass = createEClass(ADEPENDENCE_EXPRESSION);
    createEReference(aDependenceExpressionEClass, ADEPENDENCE_EXPRESSION__FUNC);
    createEReference(aDependenceExpressionEClass, ADEPENDENCE_EXPRESSION__EXPR);

    aDependenceInArrayNotationEClass = createEClass(ADEPENDENCE_IN_ARRAY_NOTATION);
    createEAttribute(aDependenceInArrayNotationEClass, ADEPENDENCE_IN_ARRAY_NOTATION__VAR);
    createEReference(aDependenceInArrayNotationEClass, ADEPENDENCE_IN_ARRAY_NOTATION__DEP);

    aIfExpressionEClass = createEClass(AIF_EXPRESSION);
    createEReference(aIfExpressionEClass, AIF_EXPRESSION__COND);
    createEReference(aIfExpressionEClass, AIF_EXPRESSION__THEN);
    createEReference(aIfExpressionEClass, AIF_EXPRESSION__ELSE);

    aIndexExpressionEClass = createEClass(AINDEX_EXPRESSION);
    createEAttribute(aIndexExpressionEClass, AINDEX_EXPRESSION__FUNC);
    createEReference(aIndexExpressionEClass, AINDEX_EXPRESSION__INDEXES);

    aReduceExpressionEClass = createEClass(AREDUCE_EXPRESSION);
    createEAttribute(aReduceExpressionEClass, AREDUCE_EXPRESSION__OP);
    createEReference(aReduceExpressionEClass, AREDUCE_EXPRESSION__PROJECTION);
    createEReference(aReduceExpressionEClass, AREDUCE_EXPRESSION__EXPR);

    aRestrictExpressionEClass = createEClass(ARESTRICT_EXPRESSION);
    createEReference(aRestrictExpressionEClass, ARESTRICT_EXPRESSION__DOMAIN);
    createEReference(aRestrictExpressionEClass, ARESTRICT_EXPRESSION__EXPR);

    aVariableExpressionEClass = createEClass(AVARIABLE_EXPRESSION);
    createEAttribute(aVariableExpressionEClass, AVARIABLE_EXPRESSION__VAR);

    aConstantExpressionEClass = createEClass(ACONSTANT_EXPRESSION);

    aBooleanExpressionEClass = createEClass(ABOOLEAN_EXPRESSION);
    createEAttribute(aBooleanExpressionEClass, ABOOLEAN_EXPRESSION__VALUE);

    aIntegerExpressionEClass = createEClass(AINTEGER_EXPRESSION);
    createEAttribute(aIntegerExpressionEClass, AINTEGER_EXPRESSION__VALUE);

    aRealExpressionEClass = createEClass(AREAL_EXPRESSION);
    createEAttribute(aRealExpressionEClass, AREAL_EXPRESSION__VALUE);

    aMultiArgExpressionEClass = createEClass(AMULTI_ARG_EXPRESSION);
    createEReference(aMultiArgExpressionEClass, AMULTI_ARG_EXPRESSION__EXPRS);

    aMultiArgArithmeticExpressionEClass = createEClass(AMULTI_ARG_ARITHMETIC_EXPRESSION);
    createEAttribute(aMultiArgArithmeticExpressionEClass, AMULTI_ARG_ARITHMETIC_EXPRESSION__OP);

    aMultiArgLogicalExpressionEClass = createEClass(AMULTI_ARG_LOGICAL_EXPRESSION);
    createEAttribute(aMultiArgLogicalExpressionEClass, AMULTI_ARG_LOGICAL_EXPRESSION__OP);

    aExternalFunctionCallEClass = createEClass(AEXTERNAL_FUNCTION_CALL);
    createEAttribute(aExternalFunctionCallEClass, AEXTERNAL_FUNCTION_CALL__FUNC);

    aIndexListEClass = createEClass(AINDEX_LIST);
    createEAttribute(aIndexListEClass, AINDEX_LIST__IDS);

    aIndexAffineExpressionListEClass = createEClass(AINDEX_AFFINE_EXPRESSION_LIST);
    createEAttribute(aIndexAffineExpressionListEClass, AINDEX_AFFINE_EXPRESSION_LIST__EXPRS);

    aFunctionEClass = createEClass(AFUNCTION);
    createEReference(aFunctionEClass, AFUNCTION__INDEXES);
    createEReference(aFunctionEClass, AFUNCTION__FUNC);

    aFunctionInArrayNotationEClass = createEClass(AFUNCTION_IN_ARRAY_NOTATION);
    createEReference(aFunctionInArrayNotationEClass, AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS);

    aTypeEClass = createEClass(ATYPE);
    createEAttribute(aTypeEClass, ATYPE__UNSIGNED);
    createEAttribute(aTypeEClass, ATYPE__TYPE);

    aOrExpressionEClass = createEClass(AOR_EXPRESSION);
    createEReference(aOrExpressionEClass, AOR_EXPRESSION__LEFT);
    createEAttribute(aOrExpressionEClass, AOR_EXPRESSION__OPERATOR);
    createEReference(aOrExpressionEClass, AOR_EXPRESSION__RIGHT);

    aAndExpressionEClass = createEClass(AAND_EXPRESSION);
    createEReference(aAndExpressionEClass, AAND_EXPRESSION__LEFT);
    createEAttribute(aAndExpressionEClass, AAND_EXPRESSION__OPERATOR);
    createEReference(aAndExpressionEClass, AAND_EXPRESSION__RIGHT);

    aRelationalExpressionEClass = createEClass(ARELATIONAL_EXPRESSION);
    createEReference(aRelationalExpressionEClass, ARELATIONAL_EXPRESSION__LEFT);
    createEAttribute(aRelationalExpressionEClass, ARELATIONAL_EXPRESSION__OPERATOR);
    createEReference(aRelationalExpressionEClass, ARELATIONAL_EXPRESSION__RIGHT);

    aAdditiveExpressionEClass = createEClass(AADDITIVE_EXPRESSION);
    createEReference(aAdditiveExpressionEClass, AADDITIVE_EXPRESSION__LEFT);
    createEAttribute(aAdditiveExpressionEClass, AADDITIVE_EXPRESSION__OP);
    createEReference(aAdditiveExpressionEClass, AADDITIVE_EXPRESSION__RIGHT);

    aMultiplicativeExpressionEClass = createEClass(AMULTIPLICATIVE_EXPRESSION);
    createEReference(aMultiplicativeExpressionEClass, AMULTIPLICATIVE_EXPRESSION__LEFT);
    createEAttribute(aMultiplicativeExpressionEClass, AMULTIPLICATIVE_EXPRESSION__OP);
    createEReference(aMultiplicativeExpressionEClass, AMULTIPLICATIVE_EXPRESSION__RIGHT);

    aMinMaxExpressionEClass = createEClass(AMIN_MAX_EXPRESSION);
    createEReference(aMinMaxExpressionEClass, AMIN_MAX_EXPRESSION__LEFT);
    createEAttribute(aMinMaxExpressionEClass, AMIN_MAX_EXPRESSION__OP);
    createEReference(aMinMaxExpressionEClass, AMIN_MAX_EXPRESSION__RIGHT);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    aNotExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aNegateExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aCaseExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aDependenceExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aDependenceInArrayNotationEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aIfExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aIndexExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aReduceExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aRestrictExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aVariableExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aConstantExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aBooleanExpressionEClass.getESuperTypes().add(this.getAConstantExpression());
    aIntegerExpressionEClass.getESuperTypes().add(this.getAConstantExpression());
    aRealExpressionEClass.getESuperTypes().add(this.getAConstantExpression());
    aMultiArgExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aMultiArgArithmeticExpressionEClass.getESuperTypes().add(this.getAMultiArgExpression());
    aMultiArgLogicalExpressionEClass.getESuperTypes().add(this.getAMultiArgExpression());
    aExternalFunctionCallEClass.getESuperTypes().add(this.getAMultiArgExpression());
    aOrExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aAndExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aRelationalExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aAdditiveExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aMultiplicativeExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
    aMinMaxExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(aProgramEClass, AProgram.class, "AProgram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAProgram_ExternalFunctions(), this.getAExternalFunctionDeclaration(), null, "externalFunctions", null, 0, -1, AProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAProgram_Systems(), this.getAAffineSystem(), null, "systems", null, 0, -1, AProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aExternalFunctionDeclarationEClass, AExternalFunctionDeclaration.class, "AExternalFunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAExternalFunctionDeclaration_Output(), this.getAType(), null, "output", null, 0, 1, AExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAExternalFunctionDeclaration_Name(), this.getAExternalFunctionIdentifier(), null, "name", null, 0, 1, AExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAExternalFunctionDeclaration_Inputs(), this.getAType(), null, "inputs", null, 0, -1, AExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aExternalFunctionIdentifierEClass, AExternalFunctionIdentifier.class, "AExternalFunctionIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAExternalFunctionIdentifier_Name(), ecorePackage.getEString(), "name", null, 0, 1, AExternalFunctionIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aAffineSystemEClass, AAffineSystem.class, "AAffineSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAAffineSystem_Name(), ecorePackage.getEString(), "name", null, 0, 1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAAffineSystem_Parameters(), this.getADomain(), null, "parameters", null, 0, 1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAAffineSystem_InputDeclarations(), this.getAInputDeclaration(), null, "inputDeclarations", null, 0, -1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAAffineSystem_OutputDeclarations(), this.getAOutputDeclaration(), null, "outputDeclarations", null, 0, -1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAAffineSystem_LocalvarDeclarations(), this.getALocalDeclaration(), null, "localvarDeclarations", null, 0, -1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAAffineSystem_Equations(), this.getAStandardEquation(), null, "equations", null, 0, -1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aOutputDeclarationEClass, AOutputDeclaration.class, "AOutputDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAOutputDeclaration_Type(), this.getAType(), null, "type", null, 0, 1, AOutputDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAOutputDeclaration_IdentifierList(), this.getAIdentifierList(), null, "identifierList", null, 0, 1, AOutputDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAOutputDeclaration_Domain(), this.getADomain(), null, "domain", null, 0, 1, AOutputDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aInputDeclarationEClass, AInputDeclaration.class, "AInputDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAInputDeclaration_Type(), this.getAType(), null, "type", null, 0, 1, AInputDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAInputDeclaration_IdentifierList(), this.getAIdentifierList(), null, "identifierList", null, 0, 1, AInputDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAInputDeclaration_Domain(), this.getADomain(), null, "domain", null, 0, 1, AInputDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aLocalDeclarationEClass, ALocalDeclaration.class, "ALocalDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getALocalDeclaration_Type(), this.getAType(), null, "type", null, 0, 1, ALocalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getALocalDeclaration_IdentifierList(), this.getAIdentifierList(), null, "identifierList", null, 0, 1, ALocalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getALocalDeclaration_Domain(), this.getADomain(), null, "domain", null, 0, 1, ALocalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aIdentifierListEClass, AIdentifierList.class, "AIdentifierList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAIdentifierList_Identifiers(), ecorePackage.getEString(), "identifiers", null, 0, -1, AIdentifierList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aDomainEClass, ADomain.class, "ADomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getADomain_Polyhedra(), this.getAPolyhedron(), null, "polyhedra", null, 0, -1, ADomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aPolyhedronEClass, APolyhedron.class, "APolyhedron", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAPolyhedron_Indexes(), this.getAIndexList(), null, "indexes", null, 0, 1, APolyhedron.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAPolyhedron_Constraints(), ecorePackage.getEString(), "constraints", null, 0, -1, APolyhedron.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aStandardEquationEClass, AStandardEquation.class, "AStandardEquation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAStandardEquation_Var(), ecorePackage.getEString(), "var", null, 0, 1, AStandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAStandardEquation_Indexes(), this.getAIndexList(), null, "indexes", null, 0, 1, AStandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAStandardEquation_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, AStandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aAlphabetsExpressionEClass, AAlphabetsExpression.class, "AAlphabetsExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(aNotExpressionEClass, ANotExpression.class, "ANotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getANotExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, ANotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getANotExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, ANotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aNegateExpressionEClass, ANegateExpression.class, "ANegateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getANegateExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, ANegateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getANegateExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, ANegateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aCaseExpressionEClass, ACaseExpression.class, "ACaseExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getACaseExpression_Exprs(), this.getAAlphabetsExpression(), null, "exprs", null, 0, -1, ACaseExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aDependenceExpressionEClass, ADependenceExpression.class, "ADependenceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getADependenceExpression_Func(), this.getAFunction(), null, "func", null, 0, 1, ADependenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getADependenceExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, ADependenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aDependenceInArrayNotationEClass, ADependenceInArrayNotation.class, "ADependenceInArrayNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getADependenceInArrayNotation_Var(), ecorePackage.getEString(), "var", null, 0, 1, ADependenceInArrayNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getADependenceInArrayNotation_Dep(), this.getAIndexAffineExpressionList(), null, "dep", null, 0, 1, ADependenceInArrayNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aIfExpressionEClass, AIfExpression.class, "AIfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAIfExpression_Cond(), this.getAAlphabetsExpression(), null, "cond", null, 0, 1, AIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAIfExpression_Then(), this.getAAlphabetsExpression(), null, "then", null, 0, 1, AIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAIfExpression_Else(), this.getAAlphabetsExpression(), null, "else", null, 0, 1, AIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aIndexExpressionEClass, AIndexExpression.class, "AIndexExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAIndexExpression_Func(), ecorePackage.getEString(), "func", null, 0, 1, AIndexExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAIndexExpression_Indexes(), this.getAIndexList(), null, "indexes", null, 0, 1, AIndexExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aReduceExpressionEClass, AReduceExpression.class, "AReduceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAReduceExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AReduceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAReduceExpression_Projection(), ecorePackage.getEObject(), null, "projection", null, 0, 1, AReduceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAReduceExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, AReduceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aRestrictExpressionEClass, ARestrictExpression.class, "ARestrictExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getARestrictExpression_Domain(), this.getADomain(), null, "domain", null, 0, 1, ARestrictExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getARestrictExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, ARestrictExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aVariableExpressionEClass, AVariableExpression.class, "AVariableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAVariableExpression_Var(), ecorePackage.getEString(), "var", null, 0, 1, AVariableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aConstantExpressionEClass, AConstantExpression.class, "AConstantExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(aBooleanExpressionEClass, ABooleanExpression.class, "ABooleanExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getABooleanExpression_Value(), ecorePackage.getEString(), "value", null, 0, 1, ABooleanExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aIntegerExpressionEClass, AIntegerExpression.class, "AIntegerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAIntegerExpression_Value(), ecorePackage.getEInt(), "value", null, 0, 1, AIntegerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aRealExpressionEClass, ARealExpression.class, "ARealExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getARealExpression_Value(), ecorePackage.getEString(), "value", null, 0, 1, ARealExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aMultiArgExpressionEClass, AMultiArgExpression.class, "AMultiArgExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAMultiArgExpression_Exprs(), this.getAAlphabetsExpression(), null, "exprs", null, 0, -1, AMultiArgExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aMultiArgArithmeticExpressionEClass, AMultiArgArithmeticExpression.class, "AMultiArgArithmeticExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAMultiArgArithmeticExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AMultiArgArithmeticExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aMultiArgLogicalExpressionEClass, AMultiArgLogicalExpression.class, "AMultiArgLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAMultiArgLogicalExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AMultiArgLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aExternalFunctionCallEClass, AExternalFunctionCall.class, "AExternalFunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAExternalFunctionCall_Func(), ecorePackage.getEString(), "func", null, 0, 1, AExternalFunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aIndexListEClass, AIndexList.class, "AIndexList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAIndexList_Ids(), ecorePackage.getEString(), "ids", null, 0, -1, AIndexList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aIndexAffineExpressionListEClass, AIndexAffineExpressionList.class, "AIndexAffineExpressionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAIndexAffineExpressionList_Exprs(), ecorePackage.getEString(), "exprs", null, 0, -1, AIndexAffineExpressionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aFunctionEClass, AFunction.class, "AFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAFunction_Indexes(), this.getAIndexList(), null, "indexes", null, 0, 1, AFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAFunction_Func(), this.getAIndexAffineExpressionList(), null, "func", null, 0, 1, AFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aFunctionInArrayNotationEClass, AFunctionInArrayNotation.class, "AFunctionInArrayNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAFunctionInArrayNotation_NewIds(), this.getAIndexAffineExpressionList(), null, "newIds", null, 0, 1, AFunctionInArrayNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aTypeEClass, AType.class, "AType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAType_Unsigned(), ecorePackage.getEString(), "unsigned", null, 0, 1, AType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAType_Type(), ecorePackage.getEString(), "type", null, 0, 1, AType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aOrExpressionEClass, AOrExpression.class, "AOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAOrExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAOrExpression_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, AOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAOrExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aAndExpressionEClass, AAndExpression.class, "AAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAAndExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAAndExpression_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, AAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAAndExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aRelationalExpressionEClass, ARelationalExpression.class, "ARelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getARelationalExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, ARelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getARelationalExpression_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, ARelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getARelationalExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, ARelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aAdditiveExpressionEClass, AAdditiveExpression.class, "AAdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAAdditiveExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AAdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAAdditiveExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AAdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAAdditiveExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AAdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aMultiplicativeExpressionEClass, AMultiplicativeExpression.class, "AMultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAMultiplicativeExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AMultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAMultiplicativeExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AMultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAMultiplicativeExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AMultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aMinMaxExpressionEClass, AMinMaxExpression.class, "AMinMaxExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAMinMaxExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AMinMaxExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAMinMaxExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AMinMaxExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAMinMaxExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AMinMaxExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //AlphabetsPackageImpl
