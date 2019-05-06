/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.Variable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bounded Channel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getMaximalChannelSize <em>Maximal Channel Size</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getSizeVariable <em>Size Variable</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getBoundingCoefficients <em>Bounding Coefficients</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getBoundedChannel()
 * @model
 * @generated
 */
public interface BoundedChannel extends Channel {
	/**
	 * Returns the value of the '<em><b>Maximal Channel Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximal Channel Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximal Channel Size</em>' attribute.
	 * @see #setMaximalChannelSize(int)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getBoundedChannel_MaximalChannelSize()
	 * @model
	 * @generated
	 */
	int getMaximalChannelSize();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getMaximalChannelSize <em>Maximal Channel Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximal Channel Size</em>' attribute.
	 * @see #getMaximalChannelSize()
	 * @generated
	 */
	void setMaximalChannelSize(int value);

	/**
	 * Returns the value of the '<em><b>Size Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Variable</em>' containment reference.
	 * @see #setSizeVariable(Variable)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getBoundedChannel_SizeVariable()
	 * @model containment="true"
	 * @generated
	 */
	Variable getSizeVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getSizeVariable <em>Size Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Variable</em>' containment reference.
	 * @see #getSizeVariable()
	 * @generated
	 */
	void setSizeVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Bounding Coefficients</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.structured.BoundingCoefficient}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounding Coefficients</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounding Coefficients</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getBoundedChannel_BoundingCoefficients()
	 * @model containment="true"
	 * @generated
	 */
	EList<BoundingCoefficient> getBoundingCoefficients();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	BoundingCoefficient getBoundingCoefficient(int index, int dimension);

} // BoundedChannel
