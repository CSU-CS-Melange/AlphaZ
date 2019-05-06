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
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Schedule Prototype</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.SchedulePrototype#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.SchedulePrototype#getCoeficients <em>Coeficients</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getSchedulePrototype()
 * @model abstract="true"
 * @generated
 */
public interface SchedulePrototype extends EObject {
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.ScheduleTerm}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Terms</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getSchedulePrototype_Terms()
	 * @model containment="true"
	 * @generated
	 */
	EList<ScheduleTerm> getTerms();

	/**
	 * Returns the value of the '<em><b>Coeficients</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.ScheduleCoefficient}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.prdg.scheduling.ScheduleCoefficient#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coeficients</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coeficients</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getSchedulePrototype_Coeficients()
	 * @see org.polymodel.prdg.scheduling.ScheduleCoefficient#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ScheduleCoefficient> getCoeficients();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ScheduleTerm> distribute();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ScheduleTerm getConstantTerm();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ScheduleTerm> apply(Function mapping);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getScheduleIndices();

	Map<Variable, Variable> getScheduleIndicesMap();

	Variable getScheduleIndex(Variable index);

	String getName();

	String toLatex();
	
	IntExpression applyScheduling(Domain scheduledDomain);

} // SchedulePrototype
