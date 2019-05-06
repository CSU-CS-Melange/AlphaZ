/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling;

import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedule Coefficient</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.ScheduleCoefficient#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.ScheduleCoefficient#getDimension <em>Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduleCoefficient()
 * @model
 * @generated
 */
public interface ScheduleCoefficient extends Variable {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.prdg.scheduling.SchedulePrototype#getCoeficients <em>Coeficients</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(SchedulePrototype)
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduleCoefficient_Owner()
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype#getCoeficients
	 * @model opposite="coeficients" transient="false"
	 * @generated
	 */
	SchedulePrototype getOwner();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.ScheduleCoefficient#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(SchedulePrototype value);

	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' attribute.
	 * @see #setDimension(int)
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getScheduleCoefficient_Dimension()
	 * @model
	 * @generated
	 */
	int getDimension();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.ScheduleCoefficient#getDimension <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' attribute.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(int value);

} // ScheduleCoefficient
