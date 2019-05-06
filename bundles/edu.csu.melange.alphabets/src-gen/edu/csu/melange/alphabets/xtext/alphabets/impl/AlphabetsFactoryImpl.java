/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlphabetsFactoryImpl extends EFactoryImpl implements AlphabetsFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static AlphabetsFactory init()
  {
		try {
			AlphabetsFactory theAlphabetsFactory = (AlphabetsFactory)EPackage.Registry.INSTANCE.getEFactory(AlphabetsPackage.eNS_URI);
			if (theAlphabetsFactory != null) {
				return theAlphabetsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AlphabetsFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AlphabetsFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case AlphabetsPackage.APROGRAM: return createAProgram();
			case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION: return createAExternalFunctionDeclaration();
			case AlphabetsPackage.AEXTERNAL_FUNCTION_IDENTIFIER: return createAExternalFunctionIdentifier();
			case AlphabetsPackage.AAFFINE_SYSTEM: return createAAffineSystem();
			case AlphabetsPackage.AVARIABLE_DECLARATION: return createAVariableDeclaration();
			case AlphabetsPackage.AOUTPUT_DECLARATION: return createAOutputDeclaration();
			case AlphabetsPackage.AINPUT_DECLARATION: return createAInputDeclaration();
			case AlphabetsPackage.ALOCAL_DECLARATION: return createALocalDeclaration();
			case AlphabetsPackage.AWHILE_DECLARATION: return createAWhileDeclaration();
			case AlphabetsPackage.AIDENTIFIER_LIST: return createAIdentifierList();
			case AlphabetsPackage.ADOMAIN: return createADomain();
			case AlphabetsPackage.APOLYHEDRON: return createAPolyhedron();
			case AlphabetsPackage.AEQUATION: return createAEquation();
			case AlphabetsPackage.ASTANDARD_EQUATION: return createAStandardEquation();
			case AlphabetsPackage.AUSE_EQUATION: return createAUseEquation();
			case AlphabetsPackage.AALPHABETS_EXPRESSION: return createAAlphabetsExpression();
			case AlphabetsPackage.ANOT_EXPRESSION: return createANotExpression();
			case AlphabetsPackage.ANEGATE_EXPRESSION: return createANegateExpression();
			case AlphabetsPackage.ACASE_EXPRESSION: return createACaseExpression();
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION: return createADependenceExpression();
			case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION: return createADependenceInArrayNotation();
			case AlphabetsPackage.AIF_EXPRESSION: return createAIfExpression();
			case AlphabetsPackage.AINDEX_EXPRESSION: return createAIndexExpression();
			case AlphabetsPackage.AREDUCE_EXPRESSION: return createAReduceExpression();
			case AlphabetsPackage.ARESTRICT_EXPRESSION: return createARestrictExpression();
			case AlphabetsPackage.AVARIABLE_EXPRESSION: return createAVariableExpression();
			case AlphabetsPackage.ACONSTANT_EXPRESSION: return createAConstantExpression();
			case AlphabetsPackage.ABOOLEAN_EXPRESSION: return createABooleanExpression();
			case AlphabetsPackage.AINTEGER_EXPRESSION: return createAIntegerExpression();
			case AlphabetsPackage.AREAL_EXPRESSION: return createARealExpression();
			case AlphabetsPackage.AMULTI_ARG_EXPRESSION: return createAMultiArgExpression();
			case AlphabetsPackage.AMULTI_ARG_ARITHMETIC_EXPRESSION: return createAMultiArgArithmeticExpression();
			case AlphabetsPackage.AMULTI_ARG_LOGICAL_EXPRESSION: return createAMultiArgLogicalExpression();
			case AlphabetsPackage.AEXTERNAL_FUNCTION_CALL: return createAExternalFunctionCall();
			case AlphabetsPackage.AINDEX_LIST: return createAIndexList();
			case AlphabetsPackage.AINDEX_AFFINE_EXPRESSION_LIST: return createAIndexAffineExpressionList();
			case AlphabetsPackage.AFUNCTION: return createAFunction();
			case AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION: return createAFunctionInArrayNotation();
			case AlphabetsPackage.ATYPE: return createAType();
			case AlphabetsPackage.AOR_EXPRESSION: return createAOrExpression();
			case AlphabetsPackage.AAND_EXPRESSION: return createAAndExpression();
			case AlphabetsPackage.ARELATIONAL_EXPRESSION: return createARelationalExpression();
			case AlphabetsPackage.AADDITIVE_EXPRESSION: return createAAdditiveExpression();
			case AlphabetsPackage.AMODULO_EXPRESSION: return createAModuloExpression();
			case AlphabetsPackage.AMULTIPLICATIVE_EXPRESSION: return createAMultiplicativeExpression();
			case AlphabetsPackage.AMIN_MAX_EXPRESSION: return createAMinMaxExpression();
			case AlphabetsPackage.ALPHABETS_DEPTH_FIRST_VISITOR: return createAlphabetsDepthFirstVisitor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AProgram createAProgram()
  {
		AProgramImpl aProgram = new AProgramImpl();
		return aProgram;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AExternalFunctionDeclaration createAExternalFunctionDeclaration()
  {
		AExternalFunctionDeclarationImpl aExternalFunctionDeclaration = new AExternalFunctionDeclarationImpl();
		return aExternalFunctionDeclaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AExternalFunctionIdentifier createAExternalFunctionIdentifier()
  {
		AExternalFunctionIdentifierImpl aExternalFunctionIdentifier = new AExternalFunctionIdentifierImpl();
		return aExternalFunctionIdentifier;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AAffineSystem createAAffineSystem()
  {
		AAffineSystemImpl aAffineSystem = new AAffineSystemImpl();
		return aAffineSystem;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AVariableDeclaration createAVariableDeclaration()
  {
		AVariableDeclarationImpl aVariableDeclaration = new AVariableDeclarationImpl();
		return aVariableDeclaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AOutputDeclaration createAOutputDeclaration()
  {
		AOutputDeclarationImpl aOutputDeclaration = new AOutputDeclarationImpl();
		return aOutputDeclaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AInputDeclaration createAInputDeclaration()
  {
		AInputDeclarationImpl aInputDeclaration = new AInputDeclarationImpl();
		return aInputDeclaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ALocalDeclaration createALocalDeclaration()
  {
		ALocalDeclarationImpl aLocalDeclaration = new ALocalDeclarationImpl();
		return aLocalDeclaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AWhileDeclaration createAWhileDeclaration()
  {
		AWhileDeclarationImpl aWhileDeclaration = new AWhileDeclarationImpl();
		return aWhileDeclaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AIdentifierList createAIdentifierList()
  {
		AIdentifierListImpl aIdentifierList = new AIdentifierListImpl();
		return aIdentifierList;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ADomain createADomain()
  {
		ADomainImpl aDomain = new ADomainImpl();
		return aDomain;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public APolyhedron createAPolyhedron()
  {
		APolyhedronImpl aPolyhedron = new APolyhedronImpl();
		return aPolyhedron;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AEquation createAEquation()
  {
		AEquationImpl aEquation = new AEquationImpl();
		return aEquation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AStandardEquation createAStandardEquation()
  {
		AStandardEquationImpl aStandardEquation = new AStandardEquationImpl();
		return aStandardEquation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AUseEquation createAUseEquation()
  {
		AUseEquationImpl aUseEquation = new AUseEquationImpl();
		return aUseEquation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AAlphabetsExpression createAAlphabetsExpression()
  {
		AAlphabetsExpressionImpl aAlphabetsExpression = new AAlphabetsExpressionImpl();
		return aAlphabetsExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ANotExpression createANotExpression()
  {
		ANotExpressionImpl aNotExpression = new ANotExpressionImpl();
		return aNotExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ANegateExpression createANegateExpression()
  {
		ANegateExpressionImpl aNegateExpression = new ANegateExpressionImpl();
		return aNegateExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ACaseExpression createACaseExpression()
  {
		ACaseExpressionImpl aCaseExpression = new ACaseExpressionImpl();
		return aCaseExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ADependenceExpression createADependenceExpression()
  {
		ADependenceExpressionImpl aDependenceExpression = new ADependenceExpressionImpl();
		return aDependenceExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ADependenceInArrayNotation createADependenceInArrayNotation()
  {
		ADependenceInArrayNotationImpl aDependenceInArrayNotation = new ADependenceInArrayNotationImpl();
		return aDependenceInArrayNotation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AIfExpression createAIfExpression()
  {
		AIfExpressionImpl aIfExpression = new AIfExpressionImpl();
		return aIfExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AIndexExpression createAIndexExpression()
  {
		AIndexExpressionImpl aIndexExpression = new AIndexExpressionImpl();
		return aIndexExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AReduceExpression createAReduceExpression()
  {
		AReduceExpressionImpl aReduceExpression = new AReduceExpressionImpl();
		return aReduceExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ARestrictExpression createARestrictExpression()
  {
		ARestrictExpressionImpl aRestrictExpression = new ARestrictExpressionImpl();
		return aRestrictExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AVariableExpression createAVariableExpression()
  {
		AVariableExpressionImpl aVariableExpression = new AVariableExpressionImpl();
		return aVariableExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AConstantExpression createAConstantExpression()
  {
		AConstantExpressionImpl aConstantExpression = new AConstantExpressionImpl();
		return aConstantExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ABooleanExpression createABooleanExpression()
  {
		ABooleanExpressionImpl aBooleanExpression = new ABooleanExpressionImpl();
		return aBooleanExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AIntegerExpression createAIntegerExpression()
  {
		AIntegerExpressionImpl aIntegerExpression = new AIntegerExpressionImpl();
		return aIntegerExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ARealExpression createARealExpression()
  {
		ARealExpressionImpl aRealExpression = new ARealExpressionImpl();
		return aRealExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AMultiArgExpression createAMultiArgExpression()
  {
		AMultiArgExpressionImpl aMultiArgExpression = new AMultiArgExpressionImpl();
		return aMultiArgExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AMultiArgArithmeticExpression createAMultiArgArithmeticExpression()
  {
		AMultiArgArithmeticExpressionImpl aMultiArgArithmeticExpression = new AMultiArgArithmeticExpressionImpl();
		return aMultiArgArithmeticExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AMultiArgLogicalExpression createAMultiArgLogicalExpression()
  {
		AMultiArgLogicalExpressionImpl aMultiArgLogicalExpression = new AMultiArgLogicalExpressionImpl();
		return aMultiArgLogicalExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AExternalFunctionCall createAExternalFunctionCall()
  {
		AExternalFunctionCallImpl aExternalFunctionCall = new AExternalFunctionCallImpl();
		return aExternalFunctionCall;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AIndexList createAIndexList()
  {
		AIndexListImpl aIndexList = new AIndexListImpl();
		return aIndexList;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AIndexAffineExpressionList createAIndexAffineExpressionList()
  {
		AIndexAffineExpressionListImpl aIndexAffineExpressionList = new AIndexAffineExpressionListImpl();
		return aIndexAffineExpressionList;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AFunction createAFunction()
  {
		AFunctionImpl aFunction = new AFunctionImpl();
		return aFunction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AFunctionInArrayNotation createAFunctionInArrayNotation()
  {
		AFunctionInArrayNotationImpl aFunctionInArrayNotation = new AFunctionInArrayNotationImpl();
		return aFunctionInArrayNotation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AType createAType()
  {
		ATypeImpl aType = new ATypeImpl();
		return aType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AOrExpression createAOrExpression()
  {
		AOrExpressionImpl aOrExpression = new AOrExpressionImpl();
		return aOrExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AAndExpression createAAndExpression()
  {
		AAndExpressionImpl aAndExpression = new AAndExpressionImpl();
		return aAndExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ARelationalExpression createARelationalExpression()
  {
		ARelationalExpressionImpl aRelationalExpression = new ARelationalExpressionImpl();
		return aRelationalExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AAdditiveExpression createAAdditiveExpression()
  {
		AAdditiveExpressionImpl aAdditiveExpression = new AAdditiveExpressionImpl();
		return aAdditiveExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AModuloExpression createAModuloExpression()
  {
		AModuloExpressionImpl aModuloExpression = new AModuloExpressionImpl();
		return aModuloExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AMultiplicativeExpression createAMultiplicativeExpression()
  {
		AMultiplicativeExpressionImpl aMultiplicativeExpression = new AMultiplicativeExpressionImpl();
		return aMultiplicativeExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AMinMaxExpression createAMinMaxExpression()
  {
		AMinMaxExpressionImpl aMinMaxExpression = new AMinMaxExpressionImpl();
		return aMinMaxExpression;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlphabetsDepthFirstVisitor createAlphabetsDepthFirstVisitor() {
		AlphabetsDepthFirstVisitorImpl alphabetsDepthFirstVisitor = new AlphabetsDepthFirstVisitorImpl();
		return alphabetsDepthFirstVisitor;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AlphabetsPackage getAlphabetsPackage()
  {
		return (AlphabetsPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static AlphabetsPackage getPackage()
  {
		return AlphabetsPackage.eINSTANCE;
	}

} //AlphabetsFactoryImpl
