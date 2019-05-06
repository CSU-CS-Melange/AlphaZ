/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link commandIF.Command#getDescription <em>Description</em>}</li>
 *   <li>{@link commandIF.Command#getOverloads <em>Overloads</em>}</li>
 *   <li>{@link commandIF.Command#isUserCommand <em>User Command</em>}</li>
 * </ul>
 * </p>
 *
 * @see commandIF.CommandIFPackage#getCommand()
 * @model abstract="true"
 * @generated
 */
public interface Command extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * The default value is <code>"TODO : add description (to the model)"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see commandIF.CommandIFPackage#getCommand_Description()
	 * @model default="TODO : add description (to the model)" required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link commandIF.Command#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Overloads</b></em>' containment reference list.
	 * The list contents are of type {@link commandIF.Overloading}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overloads</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overloads</em>' containment reference list.
	 * @see commandIF.CommandIFPackage#getCommand_Overloads()
	 * @model containment="true"
	 * @generated
	 */
	EList<Overloading> getOverloads();

	/**
	 * Returns the value of the '<em><b>User Command</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Command</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Command</em>' attribute.
	 * @see #setUserCommand(boolean)
	 * @see commandIF.CommandIFPackage#getCommand_UserCommand()
	 * @model default="true"
	 * @generated
	 */
	boolean isUserCommand();

	/**
	 * Sets the value of the '{@link commandIF.Command#isUserCommand <em>User Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Command</em>' attribute.
	 * @see #isUserCommand()
	 * @generated
	 */
	void setUserCommand(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Type getOutput();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Category getCategory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isExposedToUser();

} // Command
