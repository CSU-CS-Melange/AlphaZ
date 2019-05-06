/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage
 * @generated
 */
public interface AlphabetsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AlphabetsFactory eINSTANCE = edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>AProgram</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AProgram</em>'.
   * @generated
   */
  AProgram createAProgram();

  /**
   * Returns a new object of class '<em>AExternal Function Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AExternal Function Declaration</em>'.
   * @generated
   */
  AExternalFunctionDeclaration createAExternalFunctionDeclaration();

  /**
   * Returns a new object of class '<em>AExternal Function Identifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AExternal Function Identifier</em>'.
   * @generated
   */
  AExternalFunctionIdentifier createAExternalFunctionIdentifier();

  /**
   * Returns a new object of class '<em>AAffine System</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AAffine System</em>'.
   * @generated
   */
  AAffineSystem createAAffineSystem();

  /**
   * Returns a new object of class '<em>AOutput Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AOutput Declaration</em>'.
   * @generated
   */
  AOutputDeclaration createAOutputDeclaration();

  /**
   * Returns a new object of class '<em>AInput Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AInput Declaration</em>'.
   * @generated
   */
  AInputDeclaration createAInputDeclaration();

  /**
   * Returns a new object of class '<em>ALocal Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ALocal Declaration</em>'.
   * @generated
   */
  ALocalDeclaration createALocalDeclaration();

  /**
   * Returns a new object of class '<em>AIdentifier List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AIdentifier List</em>'.
   * @generated
   */
  AIdentifierList createAIdentifierList();

  /**
   * Returns a new object of class '<em>ADomain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ADomain</em>'.
   * @generated
   */
  ADomain createADomain();

  /**
   * Returns a new object of class '<em>APolyhedron</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>APolyhedron</em>'.
   * @generated
   */
  APolyhedron createAPolyhedron();

  /**
   * Returns a new object of class '<em>AStandard Equation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AStandard Equation</em>'.
   * @generated
   */
  AStandardEquation createAStandardEquation();

  /**
   * Returns a new object of class '<em>AAlphabets Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AAlphabets Expression</em>'.
   * @generated
   */
  AAlphabetsExpression createAAlphabetsExpression();

  /**
   * Returns a new object of class '<em>ANot Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ANot Expression</em>'.
   * @generated
   */
  ANotExpression createANotExpression();

  /**
   * Returns a new object of class '<em>ANegate Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ANegate Expression</em>'.
   * @generated
   */
  ANegateExpression createANegateExpression();

  /**
   * Returns a new object of class '<em>ACase Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ACase Expression</em>'.
   * @generated
   */
  ACaseExpression createACaseExpression();

  /**
   * Returns a new object of class '<em>ADependence Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ADependence Expression</em>'.
   * @generated
   */
  ADependenceExpression createADependenceExpression();

  /**
   * Returns a new object of class '<em>ADependence In Array Notation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ADependence In Array Notation</em>'.
   * @generated
   */
  ADependenceInArrayNotation createADependenceInArrayNotation();

  /**
   * Returns a new object of class '<em>AIf Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AIf Expression</em>'.
   * @generated
   */
  AIfExpression createAIfExpression();

  /**
   * Returns a new object of class '<em>AIndex Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AIndex Expression</em>'.
   * @generated
   */
  AIndexExpression createAIndexExpression();

  /**
   * Returns a new object of class '<em>AReduce Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AReduce Expression</em>'.
   * @generated
   */
  AReduceExpression createAReduceExpression();

  /**
   * Returns a new object of class '<em>ARestrict Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ARestrict Expression</em>'.
   * @generated
   */
  ARestrictExpression createARestrictExpression();

  /**
   * Returns a new object of class '<em>AVariable Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AVariable Expression</em>'.
   * @generated
   */
  AVariableExpression createAVariableExpression();

  /**
   * Returns a new object of class '<em>AConstant Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AConstant Expression</em>'.
   * @generated
   */
  AConstantExpression createAConstantExpression();

  /**
   * Returns a new object of class '<em>ABoolean Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ABoolean Expression</em>'.
   * @generated
   */
  ABooleanExpression createABooleanExpression();

  /**
   * Returns a new object of class '<em>AInteger Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AInteger Expression</em>'.
   * @generated
   */
  AIntegerExpression createAIntegerExpression();

  /**
   * Returns a new object of class '<em>AReal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AReal Expression</em>'.
   * @generated
   */
  ARealExpression createARealExpression();

  /**
   * Returns a new object of class '<em>AMulti Arg Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AMulti Arg Expression</em>'.
   * @generated
   */
  AMultiArgExpression createAMultiArgExpression();

  /**
   * Returns a new object of class '<em>AMulti Arg Arithmetic Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AMulti Arg Arithmetic Expression</em>'.
   * @generated
   */
  AMultiArgArithmeticExpression createAMultiArgArithmeticExpression();

  /**
   * Returns a new object of class '<em>AMulti Arg Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AMulti Arg Logical Expression</em>'.
   * @generated
   */
  AMultiArgLogicalExpression createAMultiArgLogicalExpression();

  /**
   * Returns a new object of class '<em>AExternal Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AExternal Function Call</em>'.
   * @generated
   */
  AExternalFunctionCall createAExternalFunctionCall();

  /**
   * Returns a new object of class '<em>AIndex List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AIndex List</em>'.
   * @generated
   */
  AIndexList createAIndexList();

  /**
   * Returns a new object of class '<em>AIndex Affine Expression List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AIndex Affine Expression List</em>'.
   * @generated
   */
  AIndexAffineExpressionList createAIndexAffineExpressionList();

  /**
   * Returns a new object of class '<em>AFunction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AFunction</em>'.
   * @generated
   */
  AFunction createAFunction();

  /**
   * Returns a new object of class '<em>AFunction In Array Notation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AFunction In Array Notation</em>'.
   * @generated
   */
  AFunctionInArrayNotation createAFunctionInArrayNotation();

  /**
   * Returns a new object of class '<em>AType</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AType</em>'.
   * @generated
   */
  AType createAType();

  /**
   * Returns a new object of class '<em>AOr Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AOr Expression</em>'.
   * @generated
   */
  AOrExpression createAOrExpression();

  /**
   * Returns a new object of class '<em>AAnd Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AAnd Expression</em>'.
   * @generated
   */
  AAndExpression createAAndExpression();

  /**
   * Returns a new object of class '<em>ARelational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ARelational Expression</em>'.
   * @generated
   */
  ARelationalExpression createARelationalExpression();

  /**
   * Returns a new object of class '<em>AAdditive Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AAdditive Expression</em>'.
   * @generated
   */
  AAdditiveExpression createAAdditiveExpression();

  /**
   * Returns a new object of class '<em>AMultiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AMultiplicative Expression</em>'.
   * @generated
   */
  AMultiplicativeExpression createAMultiplicativeExpression();

  /**
   * Returns a new object of class '<em>AMin Max Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AMin Max Expression</em>'.
   * @generated
   */
  AMinMaxExpression createAMinMaxExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AlphabetsPackage getAlphabetsPackage();

} //AlphabetsFactory
