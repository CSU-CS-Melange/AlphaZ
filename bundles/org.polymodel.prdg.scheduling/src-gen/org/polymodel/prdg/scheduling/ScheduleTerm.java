/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.Function;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedule Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.ScheduleTerm#getVar <em>Var</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.ScheduleTerm#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduleTerm()
 * @model
 * @generated
 */
public interface ScheduleTerm extends EObject {
	/**
	 * Returns the value of the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var</em>' reference.
	 * @see #setVar(Variable)
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduleTerm_Var()
	 * @model
	 * @generated
	 */
	Variable getVar();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.ScheduleTerm#getVar <em>Var</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' reference.
	 * @see #getVar()
	 * @generated
	 */
	void setVar(Variable value);

	/**
	 * Returns the value of the '<em><b>Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' reference.
	 * @see #setExp(AffineExpression)
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduleTerm_Exp()
	 * @model
	 * @generated
	 */
	AffineExpression getExp();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.ScheduleTerm#getExp <em>Exp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' reference.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(AffineExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isConstant();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ScheduleTerm> distribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ScheduleTerm apply(Function mapping);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ScheduleTerm negate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void simplify();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isNull();

	public abstract String toLatex();
	
	ScheduleTerm apply(Map<Variable, IntExpression> mapping);

	public abstract IntExpression applyScheduleCoeficients(Map<Variable, IntExpression> mapping);

} // ScheduleTerm
