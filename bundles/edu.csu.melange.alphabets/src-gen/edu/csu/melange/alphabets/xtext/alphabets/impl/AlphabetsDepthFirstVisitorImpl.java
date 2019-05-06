/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Depth First Visitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AlphabetsDepthFirstVisitorImpl extends MinimalEObjectImpl.Container implements AlphabetsDepthFirstVisitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlphabetsDepthFirstVisitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlphabetsPackage.Literals.ALPHABETS_DEPTH_FIRST_VISITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void defaultIn(final AlphabetsVisitable node) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void defaultOut(final AlphabetsVisitable node) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAProgram(final AProgram a) {
		inAProgram(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAProgram(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAProgram(final AProgram a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAProgram(final AProgram a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAExternalFunctionDeclaration(final AExternalFunctionDeclaration a) {
		inAExternalFunctionDeclaration(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAExternalFunctionDeclaration(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAExternalFunctionDeclaration(final AExternalFunctionDeclaration a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAExternalFunctionDeclaration(final AExternalFunctionDeclaration a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAExternalFunctionIdentifier(final AExternalFunctionIdentifier a) {
		inAExternalFunctionIdentifier(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAExternalFunctionIdentifier(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAExternalFunctionIdentifier(final AExternalFunctionIdentifier a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAExternalFunctionIdentifier(final AExternalFunctionIdentifier a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAAffineSystem(final AAffineSystem a) {
		inAAffineSystem(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAAffineSystem(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAAffineSystem(final AAffineSystem a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAAffineSystem(final AAffineSystem a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAVariableDeclaration(final AVariableDeclaration a) {
		inAVariableDeclaration(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAVariableDeclaration(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAVariableDeclaration(final AVariableDeclaration a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAVariableDeclaration(final AVariableDeclaration a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAOutputDeclaration(final AOutputDeclaration a) {
		inAOutputDeclaration(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAOutputDeclaration(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAOutputDeclaration(final AOutputDeclaration a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAOutputDeclaration(final AOutputDeclaration a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAInputDeclaration(final AInputDeclaration a) {
		inAInputDeclaration(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAInputDeclaration(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAInputDeclaration(final AInputDeclaration a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAInputDeclaration(final AInputDeclaration a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitALocalDeclaration(final ALocalDeclaration a) {
		inALocalDeclaration(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outALocalDeclaration(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inALocalDeclaration(final ALocalDeclaration a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outALocalDeclaration(final ALocalDeclaration a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAWhileDeclaration(final AWhileDeclaration a) {
		inAWhileDeclaration(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAWhileDeclaration(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAWhileDeclaration(final AWhileDeclaration a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAWhileDeclaration(final AWhileDeclaration a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAIdentifierList(final AIdentifierList a) {
		inAIdentifierList(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAIdentifierList(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAIdentifierList(final AIdentifierList a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAIdentifierList(final AIdentifierList a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitADomain(final ADomain a) {
		inADomain(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outADomain(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inADomain(final ADomain a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outADomain(final ADomain a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAPolyhedron(final APolyhedron a) {
		inAPolyhedron(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAPolyhedron(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAPolyhedron(final APolyhedron a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAPolyhedron(final APolyhedron a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAEquation(final AEquation a) {
		inAEquation(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAEquation(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAEquation(final AEquation a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAEquation(final AEquation a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAStandardEquation(final AStandardEquation a) {
		inAStandardEquation(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAStandardEquation(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAStandardEquation(final AStandardEquation a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAStandardEquation(final AStandardEquation a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAUseEquation(final AUseEquation a) {
		inAUseEquation(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAUseEquation(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAUseEquation(final AUseEquation a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAUseEquation(final AUseEquation a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAAlphabetsExpression(final AAlphabetsExpression a) {
		inAAlphabetsExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAAlphabetsExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAAlphabetsExpression(final AAlphabetsExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAAlphabetsExpression(final AAlphabetsExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitANotExpression(final ANotExpression a) {
		inANotExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outANotExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inANotExpression(final ANotExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outANotExpression(final ANotExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitANegateExpression(final ANegateExpression a) {
		inANegateExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outANegateExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inANegateExpression(final ANegateExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outANegateExpression(final ANegateExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitACaseExpression(final ACaseExpression a) {
		inACaseExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outACaseExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inACaseExpression(final ACaseExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outACaseExpression(final ACaseExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitADependenceExpression(final ADependenceExpression a) {
		inADependenceExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outADependenceExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inADependenceExpression(final ADependenceExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outADependenceExpression(final ADependenceExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitADependenceInArrayNotation(final ADependenceInArrayNotation a) {
		inADependenceInArrayNotation(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outADependenceInArrayNotation(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inADependenceInArrayNotation(final ADependenceInArrayNotation a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outADependenceInArrayNotation(final ADependenceInArrayNotation a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAIfExpression(final AIfExpression a) {
		inAIfExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAIfExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAIfExpression(final AIfExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAIfExpression(final AIfExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAIndexExpression(final AIndexExpression a) {
		inAIndexExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAIndexExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAIndexExpression(final AIndexExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAIndexExpression(final AIndexExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAReduceExpression(final AReduceExpression a) {
		inAReduceExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAReduceExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAReduceExpression(final AReduceExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAReduceExpression(final AReduceExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitARestrictExpression(final ARestrictExpression a) {
		inARestrictExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outARestrictExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inARestrictExpression(final ARestrictExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outARestrictExpression(final ARestrictExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAVariableExpression(final AVariableExpression a) {
		inAVariableExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAVariableExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAVariableExpression(final AVariableExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAVariableExpression(final AVariableExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAConstantExpression(final AConstantExpression a) {
		inAConstantExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAConstantExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAConstantExpression(final AConstantExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAConstantExpression(final AConstantExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitABooleanExpression(final ABooleanExpression a) {
		inABooleanExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outABooleanExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inABooleanExpression(final ABooleanExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outABooleanExpression(final ABooleanExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAIntegerExpression(final AIntegerExpression a) {
		inAIntegerExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAIntegerExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAIntegerExpression(final AIntegerExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAIntegerExpression(final AIntegerExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitARealExpression(final ARealExpression a) {
		inARealExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outARealExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inARealExpression(final ARealExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outARealExpression(final ARealExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAMultiArgExpression(final AMultiArgExpression a) {
		inAMultiArgExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAMultiArgExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAMultiArgExpression(final AMultiArgExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAMultiArgExpression(final AMultiArgExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAMultiArgArithmeticExpression(final AMultiArgArithmeticExpression a) {
		inAMultiArgArithmeticExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAMultiArgArithmeticExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAMultiArgArithmeticExpression(final AMultiArgArithmeticExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAMultiArgArithmeticExpression(final AMultiArgArithmeticExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAMultiArgLogicalExpression(final AMultiArgLogicalExpression a) {
		inAMultiArgLogicalExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAMultiArgLogicalExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAMultiArgLogicalExpression(final AMultiArgLogicalExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAMultiArgLogicalExpression(final AMultiArgLogicalExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAExternalFunctionCall(final AExternalFunctionCall a) {
		inAExternalFunctionCall(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAExternalFunctionCall(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAExternalFunctionCall(final AExternalFunctionCall a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAExternalFunctionCall(final AExternalFunctionCall a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAIndexList(final AIndexList a) {
		inAIndexList(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAIndexList(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAIndexList(final AIndexList a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAIndexList(final AIndexList a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAIndexAffineExpressionList(final AIndexAffineExpressionList a) {
		inAIndexAffineExpressionList(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAIndexAffineExpressionList(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAIndexAffineExpressionList(final AIndexAffineExpressionList a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAIndexAffineExpressionList(final AIndexAffineExpressionList a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAFunction(final AFunction a) {
		inAFunction(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAFunction(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAFunction(final AFunction a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAFunction(final AFunction a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAFunctionInArrayNotation(final AFunctionInArrayNotation a) {
		inAFunctionInArrayNotation(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAFunctionInArrayNotation(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAFunctionInArrayNotation(final AFunctionInArrayNotation a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAFunctionInArrayNotation(final AFunctionInArrayNotation a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAType(final AType a) {
		inAType(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAType(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAType(final AType a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAType(final AType a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAOrExpression(final AOrExpression a) {
		inAOrExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAOrExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAOrExpression(final AOrExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAOrExpression(final AOrExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAAndExpression(final AAndExpression a) {
		inAAndExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAAndExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAAndExpression(final AAndExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAAndExpression(final AAndExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitARelationalExpression(final ARelationalExpression a) {
		inARelationalExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outARelationalExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inARelationalExpression(final ARelationalExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outARelationalExpression(final ARelationalExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAAdditiveExpression(final AAdditiveExpression a) {
		inAAdditiveExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAAdditiveExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAAdditiveExpression(final AAdditiveExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAAdditiveExpression(final AAdditiveExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAModuloExpression(final AModuloExpression a) {
		inAModuloExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAModuloExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAModuloExpression(final AModuloExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAModuloExpression(final AModuloExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAMultiplicativeExpression(final AMultiplicativeExpression a) {
		inAMultiplicativeExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAMultiplicativeExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAMultiplicativeExpression(final AMultiplicativeExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAMultiplicativeExpression(final AMultiplicativeExpression a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAMinMaxExpression(final AMinMaxExpression a) {
		inAMinMaxExpression(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);
		outAMinMaxExpression(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAMinMaxExpression(final AMinMaxExpression a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAMinMaxExpression(final AMinMaxExpression a) {
		defaultOut(a);
	}

} //AlphabetsDepthFirstVisitorImpl
