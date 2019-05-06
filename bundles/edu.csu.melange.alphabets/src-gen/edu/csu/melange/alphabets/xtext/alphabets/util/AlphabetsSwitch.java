/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.util;

import edu.csu.melange.alphabets.xtext.alphabets.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage
 * @generated
 */
public class AlphabetsSwitch<T> extends Switch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static AlphabetsPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AlphabetsSwitch()
  {
		if (modelPackage == null) {
			modelPackage = AlphabetsPackage.eINSTANCE;
		}
	}

  /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
		return ePackage == modelPackage;
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
		switch (classifierID) {
			case AlphabetsPackage.APROGRAM: {
				AProgram aProgram = (AProgram)theEObject;
				T result = caseAProgram(aProgram);
				if (result == null) result = caseAlphabetsVisitable(aProgram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION: {
				AExternalFunctionDeclaration aExternalFunctionDeclaration = (AExternalFunctionDeclaration)theEObject;
				T result = caseAExternalFunctionDeclaration(aExternalFunctionDeclaration);
				if (result == null) result = caseAlphabetsVisitable(aExternalFunctionDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AEXTERNAL_FUNCTION_IDENTIFIER: {
				AExternalFunctionIdentifier aExternalFunctionIdentifier = (AExternalFunctionIdentifier)theEObject;
				T result = caseAExternalFunctionIdentifier(aExternalFunctionIdentifier);
				if (result == null) result = caseAlphabetsVisitable(aExternalFunctionIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AAFFINE_SYSTEM: {
				AAffineSystem aAffineSystem = (AAffineSystem)theEObject;
				T result = caseAAffineSystem(aAffineSystem);
				if (result == null) result = caseAlphabetsVisitable(aAffineSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AVARIABLE_DECLARATION: {
				AVariableDeclaration aVariableDeclaration = (AVariableDeclaration)theEObject;
				T result = caseAVariableDeclaration(aVariableDeclaration);
				if (result == null) result = caseAlphabetsVisitable(aVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AOUTPUT_DECLARATION: {
				AOutputDeclaration aOutputDeclaration = (AOutputDeclaration)theEObject;
				T result = caseAOutputDeclaration(aOutputDeclaration);
				if (result == null) result = caseAVariableDeclaration(aOutputDeclaration);
				if (result == null) result = caseAlphabetsVisitable(aOutputDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AINPUT_DECLARATION: {
				AInputDeclaration aInputDeclaration = (AInputDeclaration)theEObject;
				T result = caseAInputDeclaration(aInputDeclaration);
				if (result == null) result = caseAVariableDeclaration(aInputDeclaration);
				if (result == null) result = caseAlphabetsVisitable(aInputDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ALOCAL_DECLARATION: {
				ALocalDeclaration aLocalDeclaration = (ALocalDeclaration)theEObject;
				T result = caseALocalDeclaration(aLocalDeclaration);
				if (result == null) result = caseAVariableDeclaration(aLocalDeclaration);
				if (result == null) result = caseAlphabetsVisitable(aLocalDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AWHILE_DECLARATION: {
				AWhileDeclaration aWhileDeclaration = (AWhileDeclaration)theEObject;
				T result = caseAWhileDeclaration(aWhileDeclaration);
				if (result == null) result = caseAlphabetsVisitable(aWhileDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AIDENTIFIER_LIST: {
				AIdentifierList aIdentifierList = (AIdentifierList)theEObject;
				T result = caseAIdentifierList(aIdentifierList);
				if (result == null) result = caseAlphabetsVisitable(aIdentifierList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ADOMAIN: {
				ADomain aDomain = (ADomain)theEObject;
				T result = caseADomain(aDomain);
				if (result == null) result = caseAlphabetsVisitable(aDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.APOLYHEDRON: {
				APolyhedron aPolyhedron = (APolyhedron)theEObject;
				T result = caseAPolyhedron(aPolyhedron);
				if (result == null) result = caseAlphabetsVisitable(aPolyhedron);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AEQUATION: {
				AEquation aEquation = (AEquation)theEObject;
				T result = caseAEquation(aEquation);
				if (result == null) result = caseAlphabetsVisitable(aEquation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ASTANDARD_EQUATION: {
				AStandardEquation aStandardEquation = (AStandardEquation)theEObject;
				T result = caseAStandardEquation(aStandardEquation);
				if (result == null) result = caseAEquation(aStandardEquation);
				if (result == null) result = caseAlphabetsVisitable(aStandardEquation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AUSE_EQUATION: {
				AUseEquation aUseEquation = (AUseEquation)theEObject;
				T result = caseAUseEquation(aUseEquation);
				if (result == null) result = caseAEquation(aUseEquation);
				if (result == null) result = caseAlphabetsVisitable(aUseEquation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AALPHABETS_EXPRESSION: {
				AAlphabetsExpression aAlphabetsExpression = (AAlphabetsExpression)theEObject;
				T result = caseAAlphabetsExpression(aAlphabetsExpression);
				if (result == null) result = caseAlphabetsVisitable(aAlphabetsExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ANOT_EXPRESSION: {
				ANotExpression aNotExpression = (ANotExpression)theEObject;
				T result = caseANotExpression(aNotExpression);
				if (result == null) result = caseAAlphabetsExpression(aNotExpression);
				if (result == null) result = caseAlphabetsVisitable(aNotExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ANEGATE_EXPRESSION: {
				ANegateExpression aNegateExpression = (ANegateExpression)theEObject;
				T result = caseANegateExpression(aNegateExpression);
				if (result == null) result = caseAAlphabetsExpression(aNegateExpression);
				if (result == null) result = caseAlphabetsVisitable(aNegateExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ACASE_EXPRESSION: {
				ACaseExpression aCaseExpression = (ACaseExpression)theEObject;
				T result = caseACaseExpression(aCaseExpression);
				if (result == null) result = caseAAlphabetsExpression(aCaseExpression);
				if (result == null) result = caseAlphabetsVisitable(aCaseExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION: {
				ADependenceExpression aDependenceExpression = (ADependenceExpression)theEObject;
				T result = caseADependenceExpression(aDependenceExpression);
				if (result == null) result = caseAAlphabetsExpression(aDependenceExpression);
				if (result == null) result = caseAlphabetsVisitable(aDependenceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION: {
				ADependenceInArrayNotation aDependenceInArrayNotation = (ADependenceInArrayNotation)theEObject;
				T result = caseADependenceInArrayNotation(aDependenceInArrayNotation);
				if (result == null) result = caseAAlphabetsExpression(aDependenceInArrayNotation);
				if (result == null) result = caseAlphabetsVisitable(aDependenceInArrayNotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AIF_EXPRESSION: {
				AIfExpression aIfExpression = (AIfExpression)theEObject;
				T result = caseAIfExpression(aIfExpression);
				if (result == null) result = caseAAlphabetsExpression(aIfExpression);
				if (result == null) result = caseAlphabetsVisitable(aIfExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AINDEX_EXPRESSION: {
				AIndexExpression aIndexExpression = (AIndexExpression)theEObject;
				T result = caseAIndexExpression(aIndexExpression);
				if (result == null) result = caseAAlphabetsExpression(aIndexExpression);
				if (result == null) result = caseAlphabetsVisitable(aIndexExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AREDUCE_EXPRESSION: {
				AReduceExpression aReduceExpression = (AReduceExpression)theEObject;
				T result = caseAReduceExpression(aReduceExpression);
				if (result == null) result = caseAAlphabetsExpression(aReduceExpression);
				if (result == null) result = caseAlphabetsVisitable(aReduceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ARESTRICT_EXPRESSION: {
				ARestrictExpression aRestrictExpression = (ARestrictExpression)theEObject;
				T result = caseARestrictExpression(aRestrictExpression);
				if (result == null) result = caseAAlphabetsExpression(aRestrictExpression);
				if (result == null) result = caseAlphabetsVisitable(aRestrictExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AVARIABLE_EXPRESSION: {
				AVariableExpression aVariableExpression = (AVariableExpression)theEObject;
				T result = caseAVariableExpression(aVariableExpression);
				if (result == null) result = caseAAlphabetsExpression(aVariableExpression);
				if (result == null) result = caseAlphabetsVisitable(aVariableExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ACONSTANT_EXPRESSION: {
				AConstantExpression aConstantExpression = (AConstantExpression)theEObject;
				T result = caseAConstantExpression(aConstantExpression);
				if (result == null) result = caseAAlphabetsExpression(aConstantExpression);
				if (result == null) result = caseAlphabetsVisitable(aConstantExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ABOOLEAN_EXPRESSION: {
				ABooleanExpression aBooleanExpression = (ABooleanExpression)theEObject;
				T result = caseABooleanExpression(aBooleanExpression);
				if (result == null) result = caseAConstantExpression(aBooleanExpression);
				if (result == null) result = caseAAlphabetsExpression(aBooleanExpression);
				if (result == null) result = caseAlphabetsVisitable(aBooleanExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AINTEGER_EXPRESSION: {
				AIntegerExpression aIntegerExpression = (AIntegerExpression)theEObject;
				T result = caseAIntegerExpression(aIntegerExpression);
				if (result == null) result = caseAConstantExpression(aIntegerExpression);
				if (result == null) result = caseAAlphabetsExpression(aIntegerExpression);
				if (result == null) result = caseAlphabetsVisitable(aIntegerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AREAL_EXPRESSION: {
				ARealExpression aRealExpression = (ARealExpression)theEObject;
				T result = caseARealExpression(aRealExpression);
				if (result == null) result = caseAConstantExpression(aRealExpression);
				if (result == null) result = caseAAlphabetsExpression(aRealExpression);
				if (result == null) result = caseAlphabetsVisitable(aRealExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AMULTI_ARG_EXPRESSION: {
				AMultiArgExpression aMultiArgExpression = (AMultiArgExpression)theEObject;
				T result = caseAMultiArgExpression(aMultiArgExpression);
				if (result == null) result = caseAAlphabetsExpression(aMultiArgExpression);
				if (result == null) result = caseAlphabetsVisitable(aMultiArgExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AMULTI_ARG_ARITHMETIC_EXPRESSION: {
				AMultiArgArithmeticExpression aMultiArgArithmeticExpression = (AMultiArgArithmeticExpression)theEObject;
				T result = caseAMultiArgArithmeticExpression(aMultiArgArithmeticExpression);
				if (result == null) result = caseAMultiArgExpression(aMultiArgArithmeticExpression);
				if (result == null) result = caseAAlphabetsExpression(aMultiArgArithmeticExpression);
				if (result == null) result = caseAlphabetsVisitable(aMultiArgArithmeticExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AMULTI_ARG_LOGICAL_EXPRESSION: {
				AMultiArgLogicalExpression aMultiArgLogicalExpression = (AMultiArgLogicalExpression)theEObject;
				T result = caseAMultiArgLogicalExpression(aMultiArgLogicalExpression);
				if (result == null) result = caseAMultiArgExpression(aMultiArgLogicalExpression);
				if (result == null) result = caseAAlphabetsExpression(aMultiArgLogicalExpression);
				if (result == null) result = caseAlphabetsVisitable(aMultiArgLogicalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AEXTERNAL_FUNCTION_CALL: {
				AExternalFunctionCall aExternalFunctionCall = (AExternalFunctionCall)theEObject;
				T result = caseAExternalFunctionCall(aExternalFunctionCall);
				if (result == null) result = caseAMultiArgExpression(aExternalFunctionCall);
				if (result == null) result = caseAAlphabetsExpression(aExternalFunctionCall);
				if (result == null) result = caseAlphabetsVisitable(aExternalFunctionCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AINDEX_LIST: {
				AIndexList aIndexList = (AIndexList)theEObject;
				T result = caseAIndexList(aIndexList);
				if (result == null) result = caseAlphabetsVisitable(aIndexList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AINDEX_AFFINE_EXPRESSION_LIST: {
				AIndexAffineExpressionList aIndexAffineExpressionList = (AIndexAffineExpressionList)theEObject;
				T result = caseAIndexAffineExpressionList(aIndexAffineExpressionList);
				if (result == null) result = caseAlphabetsVisitable(aIndexAffineExpressionList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AFUNCTION: {
				AFunction aFunction = (AFunction)theEObject;
				T result = caseAFunction(aFunction);
				if (result == null) result = caseAlphabetsVisitable(aFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION: {
				AFunctionInArrayNotation aFunctionInArrayNotation = (AFunctionInArrayNotation)theEObject;
				T result = caseAFunctionInArrayNotation(aFunctionInArrayNotation);
				if (result == null) result = caseAlphabetsVisitable(aFunctionInArrayNotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ATYPE: {
				AType aType = (AType)theEObject;
				T result = caseAType(aType);
				if (result == null) result = caseAlphabetsVisitable(aType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AOR_EXPRESSION: {
				AOrExpression aOrExpression = (AOrExpression)theEObject;
				T result = caseAOrExpression(aOrExpression);
				if (result == null) result = caseAAlphabetsExpression(aOrExpression);
				if (result == null) result = caseAlphabetsVisitable(aOrExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AAND_EXPRESSION: {
				AAndExpression aAndExpression = (AAndExpression)theEObject;
				T result = caseAAndExpression(aAndExpression);
				if (result == null) result = caseAAlphabetsExpression(aAndExpression);
				if (result == null) result = caseAlphabetsVisitable(aAndExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ARELATIONAL_EXPRESSION: {
				ARelationalExpression aRelationalExpression = (ARelationalExpression)theEObject;
				T result = caseARelationalExpression(aRelationalExpression);
				if (result == null) result = caseAAlphabetsExpression(aRelationalExpression);
				if (result == null) result = caseAlphabetsVisitable(aRelationalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AADDITIVE_EXPRESSION: {
				AAdditiveExpression aAdditiveExpression = (AAdditiveExpression)theEObject;
				T result = caseAAdditiveExpression(aAdditiveExpression);
				if (result == null) result = caseAAlphabetsExpression(aAdditiveExpression);
				if (result == null) result = caseAlphabetsVisitable(aAdditiveExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AMODULO_EXPRESSION: {
				AModuloExpression aModuloExpression = (AModuloExpression)theEObject;
				T result = caseAModuloExpression(aModuloExpression);
				if (result == null) result = caseAAlphabetsExpression(aModuloExpression);
				if (result == null) result = caseAlphabetsVisitable(aModuloExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AMULTIPLICATIVE_EXPRESSION: {
				AMultiplicativeExpression aMultiplicativeExpression = (AMultiplicativeExpression)theEObject;
				T result = caseAMultiplicativeExpression(aMultiplicativeExpression);
				if (result == null) result = caseAAlphabetsExpression(aMultiplicativeExpression);
				if (result == null) result = caseAlphabetsVisitable(aMultiplicativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.AMIN_MAX_EXPRESSION: {
				AMinMaxExpression aMinMaxExpression = (AMinMaxExpression)theEObject;
				T result = caseAMinMaxExpression(aMinMaxExpression);
				if (result == null) result = caseAAlphabetsExpression(aMinMaxExpression);
				if (result == null) result = caseAlphabetsVisitable(aMinMaxExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ALPHABETS_VISITOR: {
				AlphabetsVisitor alphabetsVisitor = (AlphabetsVisitor)theEObject;
				T result = caseAlphabetsVisitor(alphabetsVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ALPHABETS_VISITABLE: {
				AlphabetsVisitable alphabetsVisitable = (AlphabetsVisitable)theEObject;
				T result = caseAlphabetsVisitable(alphabetsVisitable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlphabetsPackage.ALPHABETS_DEPTH_FIRST_VISITOR: {
				AlphabetsDepthFirstVisitor alphabetsDepthFirstVisitor = (AlphabetsDepthFirstVisitor)theEObject;
				T result = caseAlphabetsDepthFirstVisitor(alphabetsDepthFirstVisitor);
				if (result == null) result = caseAlphabetsVisitor(alphabetsDepthFirstVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AProgram</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AProgram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAProgram(AProgram object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AExternal Function Declaration</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AExternal Function Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAExternalFunctionDeclaration(AExternalFunctionDeclaration object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AExternal Function Identifier</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AExternal Function Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAExternalFunctionIdentifier(AExternalFunctionIdentifier object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AAffine System</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AAffine System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAAffineSystem(AAffineSystem object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AVariable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAVariableDeclaration(AVariableDeclaration object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AOutput Declaration</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AOutput Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAOutputDeclaration(AOutputDeclaration object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AInput Declaration</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AInput Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAInputDeclaration(AInputDeclaration object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ALocal Declaration</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ALocal Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseALocalDeclaration(ALocalDeclaration object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AWhile Declaration</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AWhile Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAWhileDeclaration(AWhileDeclaration object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AIdentifier List</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIdentifier List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAIdentifierList(AIdentifierList object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ADomain</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ADomain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseADomain(ADomain object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>APolyhedron</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>APolyhedron</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAPolyhedron(APolyhedron object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AEquation</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AEquation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAEquation(AEquation object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AStandard Equation</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AStandard Equation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAStandardEquation(AStandardEquation object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AUse Equation</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AUse Equation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAUseEquation(AUseEquation object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AAlphabets Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AAlphabets Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAAlphabetsExpression(AAlphabetsExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ANot Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ANot Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseANotExpression(ANotExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ANegate Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ANegate Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseANegateExpression(ANegateExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ACase Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ACase Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseACaseExpression(ACaseExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ADependence Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ADependence Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseADependenceExpression(ADependenceExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ADependence In Array Notation</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ADependence In Array Notation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseADependenceInArrayNotation(ADependenceInArrayNotation object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AIf Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIf Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAIfExpression(AIfExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AIndex Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIndex Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAIndexExpression(AIndexExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AReduce Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AReduce Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAReduceExpression(AReduceExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ARestrict Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ARestrict Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseARestrictExpression(ARestrictExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AVariable Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AVariable Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAVariableExpression(AVariableExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AConstant Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AConstant Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAConstantExpression(AConstantExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ABoolean Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ABoolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseABooleanExpression(ABooleanExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AInteger Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AInteger Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAIntegerExpression(AIntegerExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AReal Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AReal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseARealExpression(ARealExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AMulti Arg Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AMulti Arg Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAMultiArgExpression(AMultiArgExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AMulti Arg Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AMulti Arg Arithmetic Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAMultiArgArithmeticExpression(AMultiArgArithmeticExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AMulti Arg Logical Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AMulti Arg Logical Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAMultiArgLogicalExpression(AMultiArgLogicalExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AExternal Function Call</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AExternal Function Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAExternalFunctionCall(AExternalFunctionCall object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AIndex List</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIndex List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAIndexList(AIndexList object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AIndex Affine Expression List</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AIndex Affine Expression List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAIndexAffineExpressionList(AIndexAffineExpressionList object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AFunction</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AFunction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAFunction(AFunction object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AFunction In Array Notation</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AFunction In Array Notation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAFunctionInArrayNotation(AFunctionInArrayNotation object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AType</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AType</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAType(AType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AOr Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AOr Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAOrExpression(AOrExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AAnd Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AAnd Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAAndExpression(AAndExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ARelational Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ARelational Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseARelationalExpression(ARelationalExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AAdditive Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AAdditive Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAAdditiveExpression(AAdditiveExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AModulo Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AModulo Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAModuloExpression(AModuloExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AMultiplicative Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AMultiplicative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAMultiplicativeExpression(AMultiplicativeExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>AMin Max Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AMin Max Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAMinMaxExpression(AMinMaxExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlphabetsVisitor(AlphabetsVisitor object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlphabetsVisitable(AlphabetsVisitable object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Depth First Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depth First Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlphabetsDepthFirstVisitor(AlphabetsDepthFirstVisitor object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  @Override
  public T defaultCase(EObject object)
  {
		return null;
	}

} //AlphabetsSwitch
