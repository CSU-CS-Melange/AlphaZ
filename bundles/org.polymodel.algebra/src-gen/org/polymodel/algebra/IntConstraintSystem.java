/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int Constraint System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.IntConstraintSystem#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.AlgebraPackage#getIntConstraintSystem()
 * @model
 * @generated
 */
public interface IntConstraintSystem extends AlgebraVisitable {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.polymodel.algebra.AlgebraPackage#getIntConstraintSystem_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntConstraint> getConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitIntConstraintSystem(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" substitutedRequired="true" newVarRequired="true"
	 * @generated
	 */
	IntConstraintSystem substitute(Variable substituted, Variable newVar);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" substitutedRequired="true" newExprRequired="true"
	 * @generated
	 */
	IntConstraintSystem substitute(Variable substituted, IntExpression newExpr);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	IntConstraintSystem simplify();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	IntConstraintSystem copy();

	/**
	 * Returns upper bound expression derived from this system for the specified variable.
	 * 
	 * @param var
	 * @return
	 */
	IntExpression getUB(Variable var);

	/**
	 * Returns lower bound expression derived from this system for the specified variable.
	 * 
	 * @param var
	 * @return
	 */
	IntExpression getLB(Variable var);

} // IntConstraintSystem
