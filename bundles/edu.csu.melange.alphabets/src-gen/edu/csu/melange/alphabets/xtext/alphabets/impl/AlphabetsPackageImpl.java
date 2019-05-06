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
import edu.csu.melange.alphabets.xtext.alphabets.AEquation;
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
import edu.csu.melange.alphabets.xtext.alphabets.AModuloExpression;
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
import edu.csu.melange.alphabets.xtext.alphabets.AUseEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AVariableDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AWhileDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsDepthFirstVisitor;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsFactory;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitable;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
  private EClass aVariableDeclarationEClass = null;

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
  private EClass aWhileDeclarationEClass = null;

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
  private EClass aEquationEClass = null;

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
  private EClass aUseEquationEClass = null;

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
  private EClass aModuloExpressionEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alphabetsVisitorEClass = null;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alphabetsVisitableEClass = null;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alphabetsDepthFirstVisitorEClass = null;

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
  public EReference getAAffineSystem_WhileDeclaration()
  {
		return (EReference)aAffineSystemEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAAffineSystem_Equations()
  {
		return (EReference)aAffineSystemEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAVariableDeclaration()
  {
		return aVariableDeclarationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAVariableDeclaration_Type()
  {
		return (EReference)aVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAVariableDeclaration_IdentifierList()
  {
		return (EReference)aVariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAVariableDeclaration_Domain()
  {
		return (EReference)aVariableDeclarationEClass.getEStructuralFeatures().get(2);
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
  public EClass getAInputDeclaration()
  {
		return aInputDeclarationEClass;
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
  public EClass getAWhileDeclaration()
  {
		return aWhileDeclarationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAWhileDeclaration_TimeDomain()
  {
		return (EReference)aWhileDeclarationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAWhileDeclaration_Cond()
  {
		return (EReference)aWhileDeclarationEClass.getEStructuralFeatures().get(1);
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
  public EClass getAEquation()
  {
		return aEquationEClass;
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
  public EClass getAUseEquation()
  {
		return aUseEquationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAUseEquation_ExtDom()
  {
		return (EReference)aUseEquationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getAUseEquation_NameSubSys()
  {
		return (EAttribute)aUseEquationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAUseEquation_Param()
  {
		return (EReference)aUseEquationEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAUseEquation_Inputs()
  {
		return (EReference)aUseEquationEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAUseEquation_Outputs()
  {
		return (EReference)aUseEquationEClass.getEStructuralFeatures().get(4);
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
  public EClass getAModuloExpression()
  {
		return aModuloExpressionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAModuloExpression_Left()
  {
		return (EReference)aModuloExpressionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getAModuloExpression_Op()
  {
		return (EAttribute)aModuloExpressionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAModuloExpression_Right()
  {
		return (EReference)aModuloExpressionEClass.getEStructuralFeatures().get(2);
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
	public EClass getAlphabetsVisitor() {
		return alphabetsVisitorEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlphabetsVisitable() {
		return alphabetsVisitableEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlphabetsDepthFirstVisitor() {
		return alphabetsDepthFirstVisitorEClass;
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
		createEReference(aAffineSystemEClass, AAFFINE_SYSTEM__WHILE_DECLARATION);
		createEReference(aAffineSystemEClass, AAFFINE_SYSTEM__EQUATIONS);

		aVariableDeclarationEClass = createEClass(AVARIABLE_DECLARATION);
		createEReference(aVariableDeclarationEClass, AVARIABLE_DECLARATION__TYPE);
		createEReference(aVariableDeclarationEClass, AVARIABLE_DECLARATION__IDENTIFIER_LIST);
		createEReference(aVariableDeclarationEClass, AVARIABLE_DECLARATION__DOMAIN);

		aOutputDeclarationEClass = createEClass(AOUTPUT_DECLARATION);

		aInputDeclarationEClass = createEClass(AINPUT_DECLARATION);

		aLocalDeclarationEClass = createEClass(ALOCAL_DECLARATION);

		aWhileDeclarationEClass = createEClass(AWHILE_DECLARATION);
		createEReference(aWhileDeclarationEClass, AWHILE_DECLARATION__TIME_DOMAIN);
		createEReference(aWhileDeclarationEClass, AWHILE_DECLARATION__COND);

		aIdentifierListEClass = createEClass(AIDENTIFIER_LIST);
		createEAttribute(aIdentifierListEClass, AIDENTIFIER_LIST__IDENTIFIERS);

		aDomainEClass = createEClass(ADOMAIN);
		createEReference(aDomainEClass, ADOMAIN__POLYHEDRA);

		aPolyhedronEClass = createEClass(APOLYHEDRON);
		createEReference(aPolyhedronEClass, APOLYHEDRON__INDEXES);
		createEAttribute(aPolyhedronEClass, APOLYHEDRON__CONSTRAINTS);

		aEquationEClass = createEClass(AEQUATION);

		aStandardEquationEClass = createEClass(ASTANDARD_EQUATION);
		createEAttribute(aStandardEquationEClass, ASTANDARD_EQUATION__VAR);
		createEReference(aStandardEquationEClass, ASTANDARD_EQUATION__INDEXES);
		createEReference(aStandardEquationEClass, ASTANDARD_EQUATION__EXPR);

		aUseEquationEClass = createEClass(AUSE_EQUATION);
		createEReference(aUseEquationEClass, AUSE_EQUATION__EXT_DOM);
		createEAttribute(aUseEquationEClass, AUSE_EQUATION__NAME_SUB_SYS);
		createEReference(aUseEquationEClass, AUSE_EQUATION__PARAM);
		createEReference(aUseEquationEClass, AUSE_EQUATION__INPUTS);
		createEReference(aUseEquationEClass, AUSE_EQUATION__OUTPUTS);

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

		aModuloExpressionEClass = createEClass(AMODULO_EXPRESSION);
		createEReference(aModuloExpressionEClass, AMODULO_EXPRESSION__LEFT);
		createEAttribute(aModuloExpressionEClass, AMODULO_EXPRESSION__OP);
		createEReference(aModuloExpressionEClass, AMODULO_EXPRESSION__RIGHT);

		aMultiplicativeExpressionEClass = createEClass(AMULTIPLICATIVE_EXPRESSION);
		createEReference(aMultiplicativeExpressionEClass, AMULTIPLICATIVE_EXPRESSION__LEFT);
		createEAttribute(aMultiplicativeExpressionEClass, AMULTIPLICATIVE_EXPRESSION__OP);
		createEReference(aMultiplicativeExpressionEClass, AMULTIPLICATIVE_EXPRESSION__RIGHT);

		aMinMaxExpressionEClass = createEClass(AMIN_MAX_EXPRESSION);
		createEReference(aMinMaxExpressionEClass, AMIN_MAX_EXPRESSION__LEFT);
		createEAttribute(aMinMaxExpressionEClass, AMIN_MAX_EXPRESSION__OP);
		createEReference(aMinMaxExpressionEClass, AMIN_MAX_EXPRESSION__RIGHT);

		alphabetsVisitorEClass = createEClass(ALPHABETS_VISITOR);

		alphabetsVisitableEClass = createEClass(ALPHABETS_VISITABLE);

		alphabetsDepthFirstVisitorEClass = createEClass(ALPHABETS_DEPTH_FIRST_VISITOR);
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
		aProgramEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aExternalFunctionDeclarationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aExternalFunctionIdentifierEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aAffineSystemEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aVariableDeclarationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aOutputDeclarationEClass.getESuperTypes().add(this.getAVariableDeclaration());
		aOutputDeclarationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aInputDeclarationEClass.getESuperTypes().add(this.getAVariableDeclaration());
		aInputDeclarationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aLocalDeclarationEClass.getESuperTypes().add(this.getAVariableDeclaration());
		aLocalDeclarationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aWhileDeclarationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aIdentifierListEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aDomainEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aPolyhedronEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aEquationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aStandardEquationEClass.getESuperTypes().add(this.getAEquation());
		aStandardEquationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aUseEquationEClass.getESuperTypes().add(this.getAEquation());
		aUseEquationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aAlphabetsExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aNotExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aNotExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aNegateExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aNegateExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aCaseExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aCaseExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aDependenceExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aDependenceExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aDependenceInArrayNotationEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aDependenceInArrayNotationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aIfExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aIfExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aIndexExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aIndexExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aReduceExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aReduceExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aRestrictExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aRestrictExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aVariableExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aVariableExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aConstantExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aConstantExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aBooleanExpressionEClass.getESuperTypes().add(this.getAConstantExpression());
		aBooleanExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aIntegerExpressionEClass.getESuperTypes().add(this.getAConstantExpression());
		aIntegerExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aRealExpressionEClass.getESuperTypes().add(this.getAConstantExpression());
		aRealExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aMultiArgExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aMultiArgExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aMultiArgArithmeticExpressionEClass.getESuperTypes().add(this.getAMultiArgExpression());
		aMultiArgArithmeticExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aMultiArgLogicalExpressionEClass.getESuperTypes().add(this.getAMultiArgExpression());
		aMultiArgLogicalExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aExternalFunctionCallEClass.getESuperTypes().add(this.getAMultiArgExpression());
		aExternalFunctionCallEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aIndexListEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aIndexAffineExpressionListEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aFunctionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aFunctionInArrayNotationEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aTypeEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aOrExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aOrExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aAndExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aAndExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aRelationalExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aRelationalExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aAdditiveExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aAdditiveExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aModuloExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aModuloExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aMultiplicativeExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aMultiplicativeExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		aMinMaxExpressionEClass.getESuperTypes().add(this.getAAlphabetsExpression());
		aMinMaxExpressionEClass.getESuperTypes().add(this.getAlphabetsVisitable());
		alphabetsDepthFirstVisitorEClass.getESuperTypes().add(this.getAlphabetsVisitor());

		// Initialize classes and features; add operations and parameters
		initEClass(aProgramEClass, AProgram.class, "AProgram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAProgram_ExternalFunctions(), this.getAExternalFunctionDeclaration(), null, "externalFunctions", null, 0, -1, AProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAProgram_Systems(), this.getAAffineSystem(), null, "systems", null, 0, -1, AProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(aProgramEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aExternalFunctionDeclarationEClass, AExternalFunctionDeclaration.class, "AExternalFunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAExternalFunctionDeclaration_Output(), this.getAType(), null, "output", null, 0, 1, AExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAExternalFunctionDeclaration_Name(), this.getAExternalFunctionIdentifier(), null, "name", null, 0, 1, AExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAExternalFunctionDeclaration_Inputs(), this.getAType(), null, "inputs", null, 0, -1, AExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aExternalFunctionDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aExternalFunctionIdentifierEClass, AExternalFunctionIdentifier.class, "AExternalFunctionIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAExternalFunctionIdentifier_Name(), ecorePackage.getEString(), "name", null, 0, 1, AExternalFunctionIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aExternalFunctionIdentifierEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aAffineSystemEClass, AAffineSystem.class, "AAffineSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAAffineSystem_Name(), ecorePackage.getEString(), "name", null, 0, 1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAAffineSystem_Parameters(), this.getADomain(), null, "parameters", null, 0, 1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAAffineSystem_InputDeclarations(), this.getAInputDeclaration(), null, "inputDeclarations", null, 0, -1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAAffineSystem_OutputDeclarations(), this.getAOutputDeclaration(), null, "outputDeclarations", null, 0, -1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAAffineSystem_LocalvarDeclarations(), this.getALocalDeclaration(), null, "localvarDeclarations", null, 0, -1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAAffineSystem_WhileDeclaration(), this.getAWhileDeclaration(), null, "whileDeclaration", null, 0, 1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAAffineSystem_Equations(), this.getAEquation(), null, "equations", null, 0, -1, AAffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aAffineSystemEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aVariableDeclarationEClass, AVariableDeclaration.class, "AVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAVariableDeclaration_Type(), this.getAType(), null, "type", null, 0, 1, AVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAVariableDeclaration_IdentifierList(), this.getAIdentifierList(), null, "identifierList", null, 0, 1, AVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAVariableDeclaration_Domain(), this.getADomain(), null, "domain", null, 0, 1, AVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aVariableDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aOutputDeclarationEClass, AOutputDeclaration.class, "AOutputDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(aOutputDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aInputDeclarationEClass, AInputDeclaration.class, "AInputDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(aInputDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aLocalDeclarationEClass, ALocalDeclaration.class, "ALocalDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(aLocalDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aWhileDeclarationEClass, AWhileDeclaration.class, "AWhileDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAWhileDeclaration_TimeDomain(), this.getADomain(), null, "timeDomain", null, 0, 1, AWhileDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAWhileDeclaration_Cond(), this.getAAlphabetsExpression(), null, "cond", null, 0, 1, AWhileDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aWhileDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aIdentifierListEClass, AIdentifierList.class, "AIdentifierList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAIdentifierList_Identifiers(), ecorePackage.getEString(), "identifiers", null, 0, -1, AIdentifierList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aIdentifierListEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aDomainEClass, ADomain.class, "ADomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getADomain_Polyhedra(), this.getAPolyhedron(), null, "polyhedra", null, 0, -1, ADomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aDomainEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aPolyhedronEClass, APolyhedron.class, "APolyhedron", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAPolyhedron_Indexes(), this.getAIndexList(), null, "indexes", null, 0, 1, APolyhedron.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAPolyhedron_Constraints(), ecorePackage.getEString(), "constraints", null, 0, -1, APolyhedron.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aPolyhedronEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aEquationEClass, AEquation.class, "AEquation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(aEquationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aStandardEquationEClass, AStandardEquation.class, "AStandardEquation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAStandardEquation_Var(), ecorePackage.getEString(), "var", null, 0, 1, AStandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAStandardEquation_Indexes(), this.getAIndexList(), null, "indexes", null, 0, 1, AStandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAStandardEquation_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, AStandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aStandardEquationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aUseEquationEClass, AUseEquation.class, "AUseEquation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAUseEquation_ExtDom(), this.getADomain(), null, "extDom", null, 0, 1, AUseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAUseEquation_NameSubSys(), ecorePackage.getEString(), "nameSubSys", null, 0, 1, AUseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAUseEquation_Param(), this.getAIndexAffineExpressionList(), null, "param", null, 0, 1, AUseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAUseEquation_Inputs(), this.getAAlphabetsExpression(), null, "inputs", null, 0, -1, AUseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAUseEquation_Outputs(), this.getAIdentifierList(), null, "outputs", null, 0, 1, AUseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aUseEquationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aAlphabetsExpressionEClass, AAlphabetsExpression.class, "AAlphabetsExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(aAlphabetsExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aNotExpressionEClass, ANotExpression.class, "ANotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getANotExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, ANotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getANotExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, ANotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aNotExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aNegateExpressionEClass, ANegateExpression.class, "ANegateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getANegateExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, ANegateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getANegateExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, ANegateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aNegateExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aCaseExpressionEClass, ACaseExpression.class, "ACaseExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getACaseExpression_Exprs(), this.getAAlphabetsExpression(), null, "exprs", null, 0, -1, ACaseExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aCaseExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aDependenceExpressionEClass, ADependenceExpression.class, "ADependenceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getADependenceExpression_Func(), this.getAFunction(), null, "func", null, 0, 1, ADependenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getADependenceExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, ADependenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aDependenceExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aDependenceInArrayNotationEClass, ADependenceInArrayNotation.class, "ADependenceInArrayNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getADependenceInArrayNotation_Var(), ecorePackage.getEString(), "var", null, 0, 1, ADependenceInArrayNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getADependenceInArrayNotation_Dep(), this.getAIndexAffineExpressionList(), null, "dep", null, 0, 1, ADependenceInArrayNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aDependenceInArrayNotationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aIfExpressionEClass, AIfExpression.class, "AIfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAIfExpression_Cond(), this.getAAlphabetsExpression(), null, "cond", null, 0, 1, AIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAIfExpression_Then(), this.getAAlphabetsExpression(), null, "then", null, 0, 1, AIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAIfExpression_Else(), this.getAAlphabetsExpression(), null, "else", null, 0, 1, AIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aIfExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aIndexExpressionEClass, AIndexExpression.class, "AIndexExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAIndexExpression_Func(), ecorePackage.getEString(), "func", null, 0, 1, AIndexExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAIndexExpression_Indexes(), this.getAIndexList(), null, "indexes", null, 0, 1, AIndexExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aIndexExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aReduceExpressionEClass, AReduceExpression.class, "AReduceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAReduceExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AReduceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAReduceExpression_Projection(), ecorePackage.getEObject(), null, "projection", null, 0, 1, AReduceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAReduceExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, AReduceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aReduceExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aRestrictExpressionEClass, ARestrictExpression.class, "ARestrictExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getARestrictExpression_Domain(), this.getADomain(), null, "domain", null, 0, 1, ARestrictExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getARestrictExpression_Expr(), this.getAAlphabetsExpression(), null, "expr", null, 0, 1, ARestrictExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aRestrictExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aVariableExpressionEClass, AVariableExpression.class, "AVariableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAVariableExpression_Var(), ecorePackage.getEString(), "var", null, 0, 1, AVariableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aVariableExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aConstantExpressionEClass, AConstantExpression.class, "AConstantExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(aConstantExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aBooleanExpressionEClass, ABooleanExpression.class, "ABooleanExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getABooleanExpression_Value(), ecorePackage.getEString(), "value", null, 0, 1, ABooleanExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aBooleanExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aIntegerExpressionEClass, AIntegerExpression.class, "AIntegerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAIntegerExpression_Value(), ecorePackage.getEInt(), "value", null, 0, 1, AIntegerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aIntegerExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aRealExpressionEClass, ARealExpression.class, "ARealExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getARealExpression_Value(), ecorePackage.getEString(), "value", null, 0, 1, ARealExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aRealExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aMultiArgExpressionEClass, AMultiArgExpression.class, "AMultiArgExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAMultiArgExpression_Exprs(), this.getAAlphabetsExpression(), null, "exprs", null, 0, -1, AMultiArgExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aMultiArgExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aMultiArgArithmeticExpressionEClass, AMultiArgArithmeticExpression.class, "AMultiArgArithmeticExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAMultiArgArithmeticExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AMultiArgArithmeticExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aMultiArgArithmeticExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aMultiArgLogicalExpressionEClass, AMultiArgLogicalExpression.class, "AMultiArgLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAMultiArgLogicalExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AMultiArgLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aMultiArgLogicalExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aExternalFunctionCallEClass, AExternalFunctionCall.class, "AExternalFunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAExternalFunctionCall_Func(), ecorePackage.getEString(), "func", null, 0, 1, AExternalFunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aExternalFunctionCallEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aIndexListEClass, AIndexList.class, "AIndexList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAIndexList_Ids(), ecorePackage.getEString(), "ids", null, 0, -1, AIndexList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aIndexListEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aIndexAffineExpressionListEClass, AIndexAffineExpressionList.class, "AIndexAffineExpressionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAIndexAffineExpressionList_Exprs(), ecorePackage.getEString(), "exprs", null, 0, -1, AIndexAffineExpressionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aIndexAffineExpressionListEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aFunctionEClass, AFunction.class, "AFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAFunction_Indexes(), this.getAIndexList(), null, "indexes", null, 0, 1, AFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAFunction_Func(), this.getAIndexAffineExpressionList(), null, "func", null, 0, 1, AFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aFunctionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aFunctionInArrayNotationEClass, AFunctionInArrayNotation.class, "AFunctionInArrayNotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAFunctionInArrayNotation_NewIds(), this.getAIndexAffineExpressionList(), null, "newIds", null, 0, 1, AFunctionInArrayNotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aFunctionInArrayNotationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aTypeEClass, AType.class, "AType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAType_Unsigned(), ecorePackage.getEString(), "unsigned", null, 0, 1, AType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAType_Type(), ecorePackage.getEString(), "type", null, 0, 1, AType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aTypeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aOrExpressionEClass, AOrExpression.class, "AOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAOrExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAOrExpression_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, AOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAOrExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aOrExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aAndExpressionEClass, AAndExpression.class, "AAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAAndExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAAndExpression_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, AAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAAndExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aAndExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aRelationalExpressionEClass, ARelationalExpression.class, "ARelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getARelationalExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, ARelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getARelationalExpression_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, ARelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getARelationalExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, ARelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aRelationalExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aAdditiveExpressionEClass, AAdditiveExpression.class, "AAdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAAdditiveExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AAdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAAdditiveExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AAdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAAdditiveExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AAdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aAdditiveExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aModuloExpressionEClass, AModuloExpression.class, "AModuloExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAModuloExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AModuloExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAModuloExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AModuloExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAModuloExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AModuloExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aModuloExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aMultiplicativeExpressionEClass, AMultiplicativeExpression.class, "AMultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAMultiplicativeExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AMultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAMultiplicativeExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AMultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAMultiplicativeExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AMultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aMultiplicativeExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aMinMaxExpressionEClass, AMinMaxExpression.class, "AMinMaxExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAMinMaxExpression_Left(), this.getAAlphabetsExpression(), null, "left", null, 0, 1, AMinMaxExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAMinMaxExpression_Op(), ecorePackage.getEString(), "op", null, 0, 1, AMinMaxExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAMinMaxExpression_Right(), this.getAAlphabetsExpression(), null, "right", null, 0, 1, AMinMaxExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(aMinMaxExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(alphabetsVisitorEClass, AlphabetsVisitor.class, "AlphabetsVisitor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(alphabetsVisitorEClass, null, "defaultIn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "defaultOut", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAProgram(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAProgram(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAProgram(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAExternalFunctionIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionIdentifier(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAExternalFunctionIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionIdentifier(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAExternalFunctionIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionIdentifier(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAOutputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOutputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAOutputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOutputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAOutputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOutputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAInputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAInputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAInputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAInputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAInputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAInputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitALocalDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getALocalDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inALocalDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getALocalDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outALocalDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getALocalDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAWhileDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAWhileDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAWhileDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAWhileDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAWhileDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAWhileDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAIdentifierList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIdentifierList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAIdentifierList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIdentifierList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAIdentifierList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIdentifierList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitADomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADomain(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inADomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADomain(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outADomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADomain(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAPolyhedron", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAPolyhedron(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAPolyhedron", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAPolyhedron(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAPolyhedron", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAPolyhedron(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAStandardEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAStandardEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAStandardEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAUseEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAUseEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAUseEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAAlphabetsExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAlphabetsExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAAlphabetsExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAlphabetsExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAAlphabetsExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAlphabetsExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitANotExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANotExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inANotExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANotExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outANotExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANotExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitANegateExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANegateExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inANegateExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANegateExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outANegateExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANegateExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitACaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getACaseExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inACaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getACaseExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outACaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getACaseExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitADependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inADependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outADependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitADependenceInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inADependenceInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outADependenceInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIfExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIfExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIfExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAReduceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAReduceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAReduceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitARestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARestrictExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inARestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARestrictExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outARestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARestrictExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAConstantExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAConstantExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAConstantExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitABooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getABooleanExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inABooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getABooleanExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outABooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getABooleanExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIntegerExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIntegerExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIntegerExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitARealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARealExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inARealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARealExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outARealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARealExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAMultiArgArithmeticExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgArithmeticExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAMultiArgArithmeticExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgArithmeticExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAMultiArgArithmeticExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgArithmeticExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAMultiArgLogicalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgLogicalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAMultiArgLogicalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgLogicalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAMultiArgLogicalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgLogicalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionCall(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionCall(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionCall(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAIndexList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAIndexList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAIndexList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAIndexAffineExpressionList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexAffineExpressionList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAIndexAffineExpressionList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexAffineExpressionList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAIndexAffineExpressionList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexAffineExpressionList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAFunctionInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunctionInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAFunctionInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunctionInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAFunctionInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunctionInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAType(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAType(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAType(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAOrExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOrExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAOrExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOrExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAOrExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOrExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAAndExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAndExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAAndExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAndExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAAndExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAndExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitARelationalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARelationalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inARelationalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARelationalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outARelationalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARelationalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAAdditiveExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAdditiveExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAAdditiveExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAdditiveExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAAdditiveExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAdditiveExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAModuloExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAModuloExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAModuloExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAModuloExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAModuloExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAModuloExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAMultiplicativeExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiplicativeExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAMultiplicativeExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiplicativeExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAMultiplicativeExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiplicativeExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "visitAMinMaxExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMinMaxExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "inAMinMaxExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMinMaxExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsVisitorEClass, null, "outAMinMaxExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMinMaxExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(alphabetsVisitableEClass, AlphabetsVisitable.class, "AlphabetsVisitable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(alphabetsVisitableEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(alphabetsDepthFirstVisitorEClass, AlphabetsDepthFirstVisitor.class, "AlphabetsDepthFirstVisitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "defaultIn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "defaultOut", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAlphabetsVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAProgram(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAProgram(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAProgram(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAExternalFunctionIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionIdentifier(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAExternalFunctionIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionIdentifier(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAExternalFunctionIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionIdentifier(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAOutputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOutputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAOutputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOutputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAOutputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOutputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAInputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAInputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAInputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAInputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAInputDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAInputDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitALocalDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getALocalDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inALocalDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getALocalDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outALocalDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getALocalDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAWhileDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAWhileDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAWhileDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAWhileDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAWhileDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAWhileDeclaration(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAIdentifierList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIdentifierList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAIdentifierList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIdentifierList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAIdentifierList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIdentifierList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitADomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADomain(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inADomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADomain(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outADomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADomain(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAPolyhedron", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAPolyhedron(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAPolyhedron", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAPolyhedron(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAPolyhedron", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAPolyhedron(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAStandardEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAStandardEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAStandardEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAUseEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAUseEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAUseEquation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAAlphabetsExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAlphabetsExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAAlphabetsExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAlphabetsExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAAlphabetsExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAlphabetsExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitANotExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANotExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inANotExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANotExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outANotExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANotExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitANegateExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANegateExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inANegateExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANegateExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outANegateExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getANegateExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitACaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getACaseExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inACaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getACaseExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outACaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getACaseExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitADependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inADependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outADependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitADependenceInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inADependenceInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outADependenceInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getADependenceInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIfExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIfExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIfExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAReduceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAReduceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAReduceExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitARestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARestrictExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inARestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARestrictExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outARestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARestrictExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAVariableExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAConstantExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAConstantExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAConstantExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitABooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getABooleanExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inABooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getABooleanExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outABooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getABooleanExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIntegerExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIntegerExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIntegerExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitARealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARealExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inARealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARealExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outARealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARealExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAMultiArgArithmeticExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgArithmeticExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAMultiArgArithmeticExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgArithmeticExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAMultiArgArithmeticExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgArithmeticExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAMultiArgLogicalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgLogicalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAMultiArgLogicalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgLogicalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAMultiArgLogicalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiArgLogicalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionCall(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionCall(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAExternalFunctionCall(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAIndexList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAIndexList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAIndexList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAIndexAffineExpressionList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexAffineExpressionList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAIndexAffineExpressionList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexAffineExpressionList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAIndexAffineExpressionList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAIndexAffineExpressionList(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAFunctionInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunctionInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAFunctionInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunctionInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAFunctionInArrayNotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAFunctionInArrayNotation(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAType(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAType(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAType(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAOrExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOrExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAOrExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOrExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAOrExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAOrExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAAndExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAndExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAAndExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAndExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAAndExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAndExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitARelationalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARelationalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inARelationalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARelationalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outARelationalExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getARelationalExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAAdditiveExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAdditiveExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAAdditiveExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAdditiveExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAAdditiveExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAAdditiveExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAModuloExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAModuloExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAModuloExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAModuloExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAModuloExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAModuloExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAMultiplicativeExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiplicativeExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAMultiplicativeExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiplicativeExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAMultiplicativeExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMultiplicativeExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "visitAMinMaxExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMinMaxExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "inAMinMaxExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMinMaxExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(alphabetsDepthFirstVisitorEClass, null, "outAMinMaxExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAMinMaxExpression(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AlphabetsPackageImpl
