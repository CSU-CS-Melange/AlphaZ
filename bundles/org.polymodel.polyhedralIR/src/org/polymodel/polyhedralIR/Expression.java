/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.Expression#getContextDomain <em>Context Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.Expression#getExpressionDomain <em>Expression Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.Expression#getExpressionType <em>Expression Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Domain</em>' containment reference.
	 * @see #setContextDomain(Domain)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getExpression_ContextDomain()
	 * @model containment="true" required="true" transient="true" derived="true"
	 * @generated
	 */
	Domain getContextDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.Expression#getContextDomain <em>Context Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Domain</em>' containment reference.
	 * @see #getContextDomain()
	 * @generated
	 */
	void setContextDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Domain</em>' containment reference.
	 * @see #setExpressionDomain(Domain)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getExpression_ExpressionDomain()
	 * @model containment="true" required="true" transient="true" derived="true"
	 * @generated
	 */
	Domain getExpressionDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.Expression#getExpressionDomain <em>Expression Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Domain</em>' containment reference.
	 * @see #getExpressionDomain()
	 * @generated
	 */
	void setExpressionDomain(Domain value);

/**
	 * Returns the value of the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Type</em>' reference.
	 * @see #isSetExpressionType()
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getExpression_ExpressionType()
	 * @model unsettable="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Type getExpressionType();

	/**
	 * Returns whether the value of the '{@link org.polymodel.polyhedralIR.Expression#getExpressionType <em>Expression Type</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression Type</em>' reference is set.
	 * @see #getExpressionType()
	 * @generated
	 */
	boolean isSetExpressionType();

	//	/**
//	 * <!-- begin-user-doc -->
//	 * Computes the expression domain of an Expression. The parameter domain is not necessary for most expressions.
//	 * Only expressions that require parameter domain to compute expression domains are ConstantExpressions.
//	 * <!-- end-user-doc -->
//	 * @model parameterDomainRequired="true"
//	 * @generated
//	 */
//	void computeExpressionDomain(ParameterDomain parameterDomain);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Expression copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Equation getContainerEquation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean equivalence(Expression expr);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // Expression
