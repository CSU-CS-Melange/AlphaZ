/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.ScopStatementMacro#getMacroParams <em>Macro Params</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopStatementMacro#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.ScopPackage#getScopStatementMacro()
 * @model
 * @generated
 */
public interface ScopStatementMacro extends AbstractScopStatement, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Macro Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Macro Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Macro Params</em>' containment reference list.
	 * @see org.polymodel.scop.ScopPackage#getScopStatementMacro_MacroParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntExpression> getMacroParams();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polymodel.scop.ScopPackage#getScopStatementMacro_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopStatementMacro#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitScopStatementMacro(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // ScopStatementMacro
