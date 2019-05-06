/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.ScopFor#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopFor#getLB <em>LB</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopFor#getUB <em>UB</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopFor#getStride <em>Stride</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopFor#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.ScopPackage#getScopFor()
 * @model
 * @generated
 */
public interface ScopFor extends AbstractScopNode, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' reference.
	 * @see #setIterator(Variable)
	 * @see org.polymodel.scop.ScopPackage#getScopFor_Iterator()
	 * @model required="true"
	 * @generated
	 */
	Variable getIterator();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopFor#getIterator <em>Iterator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(Variable value);

	/**
	 * Returns the value of the '<em><b>LB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LB</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LB</em>' containment reference.
	 * @see #setLB(IntExpression)
	 * @see org.polymodel.scop.ScopPackage#getScopFor_LB()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getLB();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopFor#getLB <em>LB</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LB</em>' containment reference.
	 * @see #getLB()
	 * @generated
	 */
	void setLB(IntExpression value);

	/**
	 * Returns the value of the '<em><b>UB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UB</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UB</em>' containment reference.
	 * @see #setUB(IntExpression)
	 * @see org.polymodel.scop.ScopPackage#getScopFor_UB()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getUB();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopFor#getUB <em>UB</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UB</em>' containment reference.
	 * @see #getUB()
	 * @generated
	 */
	void setUB(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Stride</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stride</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stride</em>' containment reference.
	 * @see #setStride(IntExpression)
	 * @see org.polymodel.scop.ScopPackage#getScopFor_Stride()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getStride();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopFor#getStride <em>Stride</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stride</em>' containment reference.
	 * @see #getStride()
	 * @generated
	 */
	void setStride(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(AbstractScopNode)
	 * @see org.polymodel.scop.ScopPackage#getScopFor_Body()
	 * @model containment="true"
	 * @generated
	 */
	AbstractScopNode getBody();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopFor#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(AbstractScopNode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitScopFor(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // ScopFor
