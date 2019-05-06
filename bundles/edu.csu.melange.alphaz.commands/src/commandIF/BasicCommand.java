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
 * A representation of the model object '<em><b>Basic Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link commandIF.BasicCommand#getName <em>Name</em>}</li>
 *   <li>{@link commandIF.BasicCommand#getInputs <em>Inputs</em>}</li>
 *   <li>{@link commandIF.BasicCommand#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see commandIF.CommandIFPackage#getBasicCommand()
 * @model
 * @generated
 */
public interface BasicCommand extends Command {
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
	 * @see commandIF.CommandIFPackage#getBasicCommand_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link commandIF.BasicCommand#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link commandIF.Input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see commandIF.CommandIFPackage#getBasicCommand_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Input> getInputs();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * The default value is <code>"void"</code>.
	 * The literals are from the enumeration {@link commandIF.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see commandIF.Type
	 * @see #setOutput(Type)
	 * @see commandIF.CommandIFPackage#getBasicCommand_Output()
	 * @model default="void" required="true"
	 * @generated
	 */
	Type getOutput();

	/**
	 * Sets the value of the '{@link commandIF.BasicCommand#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see commandIF.Type
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Type value);

} // BasicCommand
