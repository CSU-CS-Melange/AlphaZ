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
 * A representation of the model object '<em><b>Overloading</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link commandIF.Overloading#getOverLoadedInputs <em>Over Loaded Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see commandIF.CommandIFPackage#getOverloading()
 * @model
 * @generated
 */
public interface Overloading extends Command {
	/**
	 * Returns the value of the '<em><b>Over Loaded Inputs</b></em>' reference list.
	 * The list contents are of type {@link commandIF.Input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Over Loaded Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Over Loaded Inputs</em>' reference list.
	 * @see commandIF.CommandIFPackage#getOverloading_OverLoadedInputs()
	 * @model
	 * @generated
	 */
	EList<Input> getOverLoadedInputs();

} // Overloading
