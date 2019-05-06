/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.prdg.scheduling.SchedulePrototype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedule Prototype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getPrototypes <em>Prototypes</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getScalars <em>Scalars</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getMultidimSchedulePrototype()
 * @model
 * @generated
 */
public interface MultidimSchedulePrototype extends EObject {
	/**
	 * Returns the value of the '<em><b>Prototypes</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.SchedulePrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prototypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prototypes</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getMultidimSchedulePrototype_Prototypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<SchedulePrototype> getPrototypes();

	/**
	 * Returns the value of the '<em><b>Scalars</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalars</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getMultidimSchedulePrototype_Scalars()
	 * @model containment="true"
	 * @generated
	 */
	EList<ScalarSchedulePrototype> getScalars();

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(SchedulePrototype)
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getMultidimSchedulePrototype_Reference()
	 * @model required="true"
	 * @generated
	 */
	SchedulePrototype getReference();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(SchedulePrototype value);

} // MultidimSchedulePrototype
