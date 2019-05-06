/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialized Overloading</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link commandIF.SpecializedOverloading#getAdditionalInputs <em>Additional Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see commandIF.CommandIFPackage#getSpecializedOverloading()
 * @model
 * @generated
 */
public interface SpecializedOverloading extends Overloading {
	/**
	 * Returns the value of the '<em><b>Additional Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link commandIF.Input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Inputs</em>' containment reference list.
	 * @see commandIF.CommandIFPackage#getSpecializedOverloading_AdditionalInputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Input> getAdditionalInputs();

} // SpecializedOverloading
