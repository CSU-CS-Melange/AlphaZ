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
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link commandIF.Category#getName <em>Name</em>}</li>
 *   <li>{@link commandIF.Category#getDescription <em>Description</em>}</li>
 *   <li>{@link commandIF.Category#getCommandPrefix <em>Command Prefix</em>}</li>
 *   <li>{@link commandIF.Category#getSubcategories <em>Subcategories</em>}</li>
 *   <li>{@link commandIF.Category#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @see commandIF.CommandIFPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see commandIF.CommandIFPackage#getCategory_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link commandIF.Category#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see commandIF.CommandIFPackage#getCategory_Description()
	 * @model default="TODO : add description (to the model)" required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link commandIF.Category#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Command Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Prefix</em>' attribute.
	 * @see #setCommandPrefix(String)
	 * @see commandIF.CommandIFPackage#getCategory_CommandPrefix()
	 * @model
	 * @generated
	 */
	String getCommandPrefix();

	/**
	 * Sets the value of the '{@link commandIF.Category#getCommandPrefix <em>Command Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Prefix</em>' attribute.
	 * @see #getCommandPrefix()
	 * @generated
	 */
	void setCommandPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Subcategories</b></em>' containment reference list.
	 * The list contents are of type {@link commandIF.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subcategories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subcategories</em>' containment reference list.
	 * @see commandIF.CommandIFPackage#getCategory_Subcategories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Category> getSubcategories();

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link commandIF.BasicCommand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see commandIF.CommandIFPackage#getCategory_Commands()
	 * @model containment="true"
	 * @generated
	 */
	EList<BasicCommand> getCommands();

} // Category
