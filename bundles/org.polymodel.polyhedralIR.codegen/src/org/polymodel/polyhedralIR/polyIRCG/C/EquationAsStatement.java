/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;


import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Statement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation As Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getAccessFunction <em>Access Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getRhs <em>Rhs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getVarDecl <em>Var Decl</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getEquationAsStatement()
 * @model
 * @generated
 */
public interface EquationAsStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(CodeGenVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getEquationAsStatement_Variable()
	 * @model
	 * @generated
	 */
	CodeGenVariable getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(CodeGenVariable value);

	/**
	 * Returns the value of the '<em><b>Access Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Function</em>' containment reference.
	 * @see #setAccessFunction(AffineFunction)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getEquationAsStatement_AccessFunction()
	 * @model containment="true"
	 * @generated
	 */
	AffineFunction getAccessFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getAccessFunction <em>Access Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Function</em>' containment reference.
	 * @see #getAccessFunction()
	 * @generated
	 */
	void setAccessFunction(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' reference.
	 * @see #setRhs(Expression)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getEquationAsStatement_Rhs()
	 * @model required="true"
	 * @generated
	 */
	Expression getRhs();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getRhs <em>Rhs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(Expression value);

	/**
	 * Returns the value of the '<em><b>Var Decl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Decl</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Decl</em>' reference.
	 * @see #setVarDecl(VariableDeclaration)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getEquationAsStatement_VarDecl()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclaration getVarDecl();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement#getVarDecl <em>Var Decl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Decl</em>' reference.
	 * @see #getVarDecl()
	 * @generated
	 */
	void setVarDecl(VariableDeclaration value);

} // EquationAsStatement
