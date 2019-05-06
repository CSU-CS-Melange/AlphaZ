/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.util;

import edu.csu.melange.alphabets.xtext.alphabets.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage
 * @generated
 */
public class AlphabetsAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AlphabetsPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlphabetsAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AlphabetsPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlphabetsSwitch<Adapter> modelSwitch =
    new AlphabetsSwitch<Adapter>()
    {
      @Override
      public Adapter caseAProgram(AProgram object)
      {
        return createAProgramAdapter();
      }
      @Override
      public Adapter caseAExternalFunctionDeclaration(AExternalFunctionDeclaration object)
      {
        return createAExternalFunctionDeclarationAdapter();
      }
      @Override
      public Adapter caseAExternalFunctionIdentifier(AExternalFunctionIdentifier object)
      {
        return createAExternalFunctionIdentifierAdapter();
      }
      @Override
      public Adapter caseAAffineSystem(AAffineSystem object)
      {
        return createAAffineSystemAdapter();
      }
      @Override
      public Adapter caseAOutputDeclaration(AOutputDeclaration object)
      {
        return createAOutputDeclarationAdapter();
      }
      @Override
      public Adapter caseAInputDeclaration(AInputDeclaration object)
      {
        return createAInputDeclarationAdapter();
      }
      @Override
      public Adapter caseALocalDeclaration(ALocalDeclaration object)
      {
        return createALocalDeclarationAdapter();
      }
      @Override
      public Adapter caseAIdentifierList(AIdentifierList object)
      {
        return createAIdentifierListAdapter();
      }
      @Override
      public Adapter caseADomain(ADomain object)
      {
        return createADomainAdapter();
      }
      @Override
      public Adapter caseAPolyhedron(APolyhedron object)
      {
        return createAPolyhedronAdapter();
      }
      @Override
      public Adapter caseAStandardEquation(AStandardEquation object)
      {
        return createAStandardEquationAdapter();
      }
      @Override
      public Adapter caseAAlphabetsExpression(AAlphabetsExpression object)
      {
        return createAAlphabetsExpressionAdapter();
      }
      @Override
      public Adapter caseANotExpression(ANotExpression object)
      {
        return createANotExpressionAdapter();
      }
      @Override
      public Adapter caseANegateExpression(ANegateExpression object)
      {
        return createANegateExpressionAdapter();
      }
      @Override
      public Adapter caseACaseExpression(ACaseExpression object)
      {
        return createACaseExpressionAdapter();
      }
      @Override
      public Adapter caseADependenceExpression(ADependenceExpression object)
      {
        return createADependenceExpressionAdapter();
      }
      @Override
      public Adapter caseADependenceInArrayNotation(ADependenceInArrayNotation object)
      {
        return createADependenceInArrayNotationAdapter();
      }
      @Override
      public Adapter caseAIfExpression(AIfExpression object)
      {
        return createAIfExpressionAdapter();
      }
      @Override
      public Adapter caseAIndexExpression(AIndexExpression object)
      {
        return createAIndexExpressionAdapter();
      }
      @Override
      public Adapter caseAReduceExpression(AReduceExpression object)
      {
        return createAReduceExpressionAdapter();
      }
      @Override
      public Adapter caseARestrictExpression(ARestrictExpression object)
      {
        return createARestrictExpressionAdapter();
      }
      @Override
      public Adapter caseAVariableExpression(AVariableExpression object)
      {
        return createAVariableExpressionAdapter();
      }
      @Override
      public Adapter caseAConstantExpression(AConstantExpression object)
      {
        return createAConstantExpressionAdapter();
      }
      @Override
      public Adapter caseABooleanExpression(ABooleanExpression object)
      {
        return createABooleanExpressionAdapter();
      }
      @Override
      public Adapter caseAIntegerExpression(AIntegerExpression object)
      {
        return createAIntegerExpressionAdapter();
      }
      @Override
      public Adapter caseARealExpression(ARealExpression object)
      {
        return createARealExpressionAdapter();
      }
      @Override
      public Adapter caseAMultiArgExpression(AMultiArgExpression object)
      {
        return createAMultiArgExpressionAdapter();
      }
      @Override
      public Adapter caseAMultiArgArithmeticExpression(AMultiArgArithmeticExpression object)
      {
        return createAMultiArgArithmeticExpressionAdapter();
      }
      @Override
      public Adapter caseAMultiArgLogicalExpression(AMultiArgLogicalExpression object)
      {
        return createAMultiArgLogicalExpressionAdapter();
      }
      @Override
      public Adapter caseAExternalFunctionCall(AExternalFunctionCall object)
      {
        return createAExternalFunctionCallAdapter();
      }
      @Override
      public Adapter caseAIndexList(AIndexList object)
      {
        return createAIndexListAdapter();
      }
      @Override
      public Adapter caseAIndexAffineExpressionList(AIndexAffineExpressionList object)
      {
        return createAIndexAffineExpressionListAdapter();
      }
      @Override
      public Adapter caseAFunction(AFunction object)
      {
        return createAFunctionAdapter();
      }
      @Override
      public Adapter caseAFunctionInArrayNotation(AFunctionInArrayNotation object)
      {
        return createAFunctionInArrayNotationAdapter();
      }
      @Override
      public Adapter caseAType(AType object)
      {
        return createATypeAdapter();
      }
      @Override
      public Adapter caseAOrExpression(AOrExpression object)
      {
        return createAOrExpressionAdapter();
      }
      @Override
      public Adapter caseAAndExpression(AAndExpression object)
      {
        return createAAndExpressionAdapter();
      }
      @Override
      public Adapter caseARelationalExpression(ARelationalExpression object)
      {
        return createARelationalExpressionAdapter();
      }
      @Override
      public Adapter caseAAdditiveExpression(AAdditiveExpression object)
      {
        return createAAdditiveExpressionAdapter();
      }
      @Override
      public Adapter caseAMultiplicativeExpression(AMultiplicativeExpression object)
      {
        return createAMultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter caseAMinMaxExpression(AMinMaxExpression object)
      {
        return createAMinMaxExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AProgram <em>AProgram</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AProgram
   * @generated
   */
  public Adapter createAProgramAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration <em>AExternal Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration
   * @generated
   */
  public Adapter createAExternalFunctionDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier <em>AExternal Function Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier
   * @generated
   */
  public Adapter createAExternalFunctionIdentifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem <em>AAffine System</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem
   * @generated
   */
  public Adapter createAAffineSystemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration <em>AOutput Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration
   * @generated
   */
  public Adapter createAOutputDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration <em>AInput Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration
   * @generated
   */
  public Adapter createAInputDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration <em>ALocal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration
   * @generated
   */
  public Adapter createALocalDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList <em>AIdentifier List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList
   * @generated
   */
  public Adapter createAIdentifierListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ADomain <em>ADomain</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADomain
   * @generated
   */
  public Adapter createADomainAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.APolyhedron <em>APolyhedron</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.APolyhedron
   * @generated
   */
  public Adapter createAPolyhedronAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation <em>AStandard Equation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation
   * @generated
   */
  public Adapter createAStandardEquationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression <em>AAlphabets Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression
   * @generated
   */
  public Adapter createAAlphabetsExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ANotExpression <em>ANot Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ANotExpression
   * @generated
   */
  public Adapter createANotExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression <em>ANegate Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression
   * @generated
   */
  public Adapter createANegateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression <em>ACase Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression
   * @generated
   */
  public Adapter createACaseExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression <em>ADependence Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression
   * @generated
   */
  public Adapter createADependenceExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation <em>ADependence In Array Notation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation
   * @generated
   */
  public Adapter createADependenceInArrayNotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIfExpression <em>AIf Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIfExpression
   * @generated
   */
  public Adapter createAIfExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression <em>AIndex Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression
   * @generated
   */
  public Adapter createAIndexExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression <em>AReduce Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression
   * @generated
   */
  public Adapter createAReduceExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression <em>ARestrict Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression
   * @generated
   */
  public Adapter createARestrictExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression <em>AVariable Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression
   * @generated
   */
  public Adapter createAVariableExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AConstantExpression <em>AConstant Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AConstantExpression
   * @generated
   */
  public Adapter createAConstantExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression <em>ABoolean Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression
   * @generated
   */
  public Adapter createABooleanExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression <em>AInteger Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression
   * @generated
   */
  public Adapter createAIntegerExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ARealExpression <em>AReal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARealExpression
   * @generated
   */
  public Adapter createARealExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgExpression <em>AMulti Arg Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgExpression
   * @generated
   */
  public Adapter createAMultiArgExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression <em>AMulti Arg Arithmetic Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression
   * @generated
   */
  public Adapter createAMultiArgArithmeticExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression <em>AMulti Arg Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression
   * @generated
   */
  public Adapter createAMultiArgLogicalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall <em>AExternal Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall
   * @generated
   */
  public Adapter createAExternalFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexList <em>AIndex List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexList
   * @generated
   */
  public Adapter createAIndexListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList <em>AIndex Affine Expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList
   * @generated
   */
  public Adapter createAIndexAffineExpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunction <em>AFunction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AFunction
   * @generated
   */
  public Adapter createAFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation <em>AFunction In Array Notation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation
   * @generated
   */
  public Adapter createAFunctionInArrayNotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AType <em>AType</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AType
   * @generated
   */
  public Adapter createATypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AOrExpression <em>AOr Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AOrExpression
   * @generated
   */
  public Adapter createAOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AAndExpression <em>AAnd Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAndExpression
   * @generated
   */
  public Adapter createAAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression <em>ARelational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression
   * @generated
   */
  public Adapter createARelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression <em>AAdditive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression
   * @generated
   */
  public Adapter createAAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression <em>AMultiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression
   * @generated
   */
  public Adapter createAMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression <em>AMin Max Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression
   * @generated
   */
  public Adapter createAMinMaxExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AlphabetsAdapterFactory
