/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depth First Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAlphabetsDepthFirstVisitor()
 * @model
 * @generated
 */
public interface AlphabetsDepthFirstVisitor extends AlphabetsVisitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void defaultIn(AlphabetsVisitable node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void defaultOut(AlphabetsVisitable node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAProgram(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAProgram(a);\n'"
	 * @generated
	 */
	void visitAProgram(AProgram a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAProgram(AProgram a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAProgram(AProgram a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAExternalFunctionDeclaration(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAExternalFunctionDeclaration(a);\n'"
	 * @generated
	 */
	void visitAExternalFunctionDeclaration(AExternalFunctionDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAExternalFunctionDeclaration(AExternalFunctionDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAExternalFunctionDeclaration(AExternalFunctionDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAExternalFunctionIdentifier(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAExternalFunctionIdentifier(a);\n'"
	 * @generated
	 */
	void visitAExternalFunctionIdentifier(AExternalFunctionIdentifier a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAExternalFunctionIdentifier(AExternalFunctionIdentifier a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAExternalFunctionIdentifier(AExternalFunctionIdentifier a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAAffineSystem(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAAffineSystem(a);\n'"
	 * @generated
	 */
	void visitAAffineSystem(AAffineSystem a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAAffineSystem(AAffineSystem a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAAffineSystem(AAffineSystem a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAVariableDeclaration(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAVariableDeclaration(a);\n'"
	 * @generated
	 */
	void visitAVariableDeclaration(AVariableDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAVariableDeclaration(AVariableDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAVariableDeclaration(AVariableDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAOutputDeclaration(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAOutputDeclaration(a);\n'"
	 * @generated
	 */
	void visitAOutputDeclaration(AOutputDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAOutputDeclaration(AOutputDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAOutputDeclaration(AOutputDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAInputDeclaration(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAInputDeclaration(a);\n'"
	 * @generated
	 */
	void visitAInputDeclaration(AInputDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAInputDeclaration(AInputDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAInputDeclaration(AInputDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inALocalDeclaration(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutALocalDeclaration(a);\n'"
	 * @generated
	 */
	void visitALocalDeclaration(ALocalDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inALocalDeclaration(ALocalDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outALocalDeclaration(ALocalDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAWhileDeclaration(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAWhileDeclaration(a);\n'"
	 * @generated
	 */
	void visitAWhileDeclaration(AWhileDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAWhileDeclaration(AWhileDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAWhileDeclaration(AWhileDeclaration a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAIdentifierList(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAIdentifierList(a);\n'"
	 * @generated
	 */
	void visitAIdentifierList(AIdentifierList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAIdentifierList(AIdentifierList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAIdentifierList(AIdentifierList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inADomain(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutADomain(a);\n'"
	 * @generated
	 */
	void visitADomain(ADomain a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inADomain(ADomain a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outADomain(ADomain a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAPolyhedron(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAPolyhedron(a);\n'"
	 * @generated
	 */
	void visitAPolyhedron(APolyhedron a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAPolyhedron(APolyhedron a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAPolyhedron(APolyhedron a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAEquation(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAEquation(a);\n'"
	 * @generated
	 */
	void visitAEquation(AEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAEquation(AEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAEquation(AEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAStandardEquation(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAStandardEquation(a);\n'"
	 * @generated
	 */
	void visitAStandardEquation(AStandardEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAStandardEquation(AStandardEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAStandardEquation(AStandardEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAUseEquation(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAUseEquation(a);\n'"
	 * @generated
	 */
	void visitAUseEquation(AUseEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAUseEquation(AUseEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAUseEquation(AUseEquation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAAlphabetsExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAAlphabetsExpression(a);\n'"
	 * @generated
	 */
	void visitAAlphabetsExpression(AAlphabetsExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAAlphabetsExpression(AAlphabetsExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAAlphabetsExpression(AAlphabetsExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inANotExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutANotExpression(a);\n'"
	 * @generated
	 */
	void visitANotExpression(ANotExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inANotExpression(ANotExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outANotExpression(ANotExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inANegateExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutANegateExpression(a);\n'"
	 * @generated
	 */
	void visitANegateExpression(ANegateExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inANegateExpression(ANegateExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outANegateExpression(ANegateExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inACaseExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutACaseExpression(a);\n'"
	 * @generated
	 */
	void visitACaseExpression(ACaseExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inACaseExpression(ACaseExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outACaseExpression(ACaseExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inADependenceExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutADependenceExpression(a);\n'"
	 * @generated
	 */
	void visitADependenceExpression(ADependenceExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inADependenceExpression(ADependenceExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outADependenceExpression(ADependenceExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inADependenceInArrayNotation(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutADependenceInArrayNotation(a);\n'"
	 * @generated
	 */
	void visitADependenceInArrayNotation(ADependenceInArrayNotation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inADependenceInArrayNotation(ADependenceInArrayNotation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outADependenceInArrayNotation(ADependenceInArrayNotation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAIfExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAIfExpression(a);\n'"
	 * @generated
	 */
	void visitAIfExpression(AIfExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAIfExpression(AIfExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAIfExpression(AIfExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAIndexExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAIndexExpression(a);\n'"
	 * @generated
	 */
	void visitAIndexExpression(AIndexExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAIndexExpression(AIndexExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAIndexExpression(AIndexExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAReduceExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAReduceExpression(a);\n'"
	 * @generated
	 */
	void visitAReduceExpression(AReduceExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAReduceExpression(AReduceExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAReduceExpression(AReduceExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inARestrictExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutARestrictExpression(a);\n'"
	 * @generated
	 */
	void visitARestrictExpression(ARestrictExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inARestrictExpression(ARestrictExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outARestrictExpression(ARestrictExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAVariableExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAVariableExpression(a);\n'"
	 * @generated
	 */
	void visitAVariableExpression(AVariableExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAVariableExpression(AVariableExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAVariableExpression(AVariableExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAConstantExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAConstantExpression(a);\n'"
	 * @generated
	 */
	void visitAConstantExpression(AConstantExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAConstantExpression(AConstantExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAConstantExpression(AConstantExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inABooleanExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutABooleanExpression(a);\n'"
	 * @generated
	 */
	void visitABooleanExpression(ABooleanExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inABooleanExpression(ABooleanExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outABooleanExpression(ABooleanExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAIntegerExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAIntegerExpression(a);\n'"
	 * @generated
	 */
	void visitAIntegerExpression(AIntegerExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAIntegerExpression(AIntegerExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAIntegerExpression(AIntegerExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inARealExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutARealExpression(a);\n'"
	 * @generated
	 */
	void visitARealExpression(ARealExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inARealExpression(ARealExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outARealExpression(ARealExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAMultiArgExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAMultiArgExpression(a);\n'"
	 * @generated
	 */
	void visitAMultiArgExpression(AMultiArgExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAMultiArgExpression(AMultiArgExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAMultiArgExpression(AMultiArgExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAMultiArgArithmeticExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAMultiArgArithmeticExpression(a);\n'"
	 * @generated
	 */
	void visitAMultiArgArithmeticExpression(AMultiArgArithmeticExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAMultiArgArithmeticExpression(AMultiArgArithmeticExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAMultiArgArithmeticExpression(AMultiArgArithmeticExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAMultiArgLogicalExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAMultiArgLogicalExpression(a);\n'"
	 * @generated
	 */
	void visitAMultiArgLogicalExpression(AMultiArgLogicalExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAMultiArgLogicalExpression(AMultiArgLogicalExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAMultiArgLogicalExpression(AMultiArgLogicalExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAExternalFunctionCall(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAExternalFunctionCall(a);\n'"
	 * @generated
	 */
	void visitAExternalFunctionCall(AExternalFunctionCall a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAExternalFunctionCall(AExternalFunctionCall a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAExternalFunctionCall(AExternalFunctionCall a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAIndexList(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAIndexList(a);\n'"
	 * @generated
	 */
	void visitAIndexList(AIndexList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAIndexList(AIndexList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAIndexList(AIndexList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAIndexAffineExpressionList(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAIndexAffineExpressionList(a);\n'"
	 * @generated
	 */
	void visitAIndexAffineExpressionList(AIndexAffineExpressionList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAIndexAffineExpressionList(AIndexAffineExpressionList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAIndexAffineExpressionList(AIndexAffineExpressionList a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAFunction(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAFunction(a);\n'"
	 * @generated
	 */
	void visitAFunction(AFunction a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAFunction(AFunction a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAFunction(AFunction a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAFunctionInArrayNotation(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAFunctionInArrayNotation(a);\n'"
	 * @generated
	 */
	void visitAFunctionInArrayNotation(AFunctionInArrayNotation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAFunctionInArrayNotation(AFunctionInArrayNotation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAFunctionInArrayNotation(AFunctionInArrayNotation a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAType(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAType(a);\n'"
	 * @generated
	 */
	void visitAType(AType a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAType(AType a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAType(AType a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAOrExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAOrExpression(a);\n'"
	 * @generated
	 */
	void visitAOrExpression(AOrExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAOrExpression(AOrExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAOrExpression(AOrExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAAndExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAAndExpression(a);\n'"
	 * @generated
	 */
	void visitAAndExpression(AAndExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAAndExpression(AAndExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAAndExpression(AAndExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inARelationalExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutARelationalExpression(a);\n'"
	 * @generated
	 */
	void visitARelationalExpression(ARelationalExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inARelationalExpression(ARelationalExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outARelationalExpression(ARelationalExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAAdditiveExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAAdditiveExpression(a);\n'"
	 * @generated
	 */
	void visitAAdditiveExpression(AAdditiveExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAAdditiveExpression(AAdditiveExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAAdditiveExpression(AAdditiveExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAModuloExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAModuloExpression(a);\n'"
	 * @generated
	 */
	void visitAModuloExpression(AModuloExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAModuloExpression(AModuloExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAModuloExpression(AModuloExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAMultiplicativeExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAMultiplicativeExpression(a);\n'"
	 * @generated
	 */
	void visitAMultiplicativeExpression(AMultiplicativeExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAMultiplicativeExpression(AMultiplicativeExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAMultiplicativeExpression(AMultiplicativeExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAMinMaxExpression(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof AlphabetsVisitable) ((AlphabetsVisitable)obj).accept(this);\noutAMinMaxExpression(a);\n'"
	 * @generated
	 */
	void visitAMinMaxExpression(AMinMaxExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAMinMaxExpression(AMinMaxExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAMinMaxExpression(AMinMaxExpression a);

} // AlphabetsDepthFirstVisitor
