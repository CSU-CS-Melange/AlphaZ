/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.wrapper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Special Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable#getVarDecl <em>Var Decl</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable#getAccess <em>Access</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage#getSpecialVariable()
 * @model
 * @generated
 */
public interface SpecialVariable extends EObject {
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
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage#getSpecialVariable_VarDecl()
	 * @model
	 * @generated
	 */
	VariableDeclaration getVarDecl();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable#getVarDecl <em>Var Decl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Decl</em>' reference.
	 * @see #getVarDecl()
	 * @generated
	 */
	void setVarDecl(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access</em>' reference.
	 * @see #setAccess(AffineFunction)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage#getSpecialVariable_Access()
	 * @model
	 * @generated
	 */
	AffineFunction getAccess();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable#getAccess <em>Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access</em>' reference.
	 * @see #getAccess()
	 * @generated
	 */
	void setAccess(AffineFunction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<AffineExpression> getMemoryAccessExpressions();

} // SpecialVariable
