/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.affine;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.affine.AffineExpression#getTerms <em>Terms</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.affine.AffinePackage#getAffineExpression()
 * @model
 * @generated
 */
public interface AffineExpression extends IntExpression, AlgebraVisitable {
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.affine.AffineTerm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see org.polymodel.algebra.affine.AffinePackage#getAffineExpression_Terms()
	 * @model containment="true"
	 * @generated
	 */
	EList<AffineTerm> getTerms();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAffineExpression(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);
	
	AffineTerm getTerm(Variable v);

	AffineTerm getConstantTerm();

} // AffineExpression
