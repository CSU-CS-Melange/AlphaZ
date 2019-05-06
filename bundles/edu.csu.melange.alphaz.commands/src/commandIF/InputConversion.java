/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Conversion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link commandIF.InputConversion#getConvertingInput <em>Converting Input</em>}</li>
 *   <li>{@link commandIF.InputConversion#getConversionCode <em>Conversion Code</em>}</li>
 *   <li>{@link commandIF.InputConversion#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see commandIF.CommandIFPackage#getInputConversion()
 * @model
 * @generated
 */
public interface InputConversion extends EObject {
	/**
	 * Returns the value of the '<em><b>Converting Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Converting Input</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Converting Input</em>' reference.
	 * @see #setConvertingInput(Input)
	 * @see commandIF.CommandIFPackage#getInputConversion_ConvertingInput()
	 * @model required="true"
	 * @generated
	 */
	Input getConvertingInput();

	/**
	 * Sets the value of the '{@link commandIF.InputConversion#getConvertingInput <em>Converting Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Converting Input</em>' reference.
	 * @see #getConvertingInput()
	 * @generated
	 */
	void setConvertingInput(Input value);

	/**
	 * Returns the value of the '<em><b>Conversion Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversion Code</em>' attribute.
	 * @see #setConversionCode(String)
	 * @see commandIF.CommandIFPackage#getInputConversion_ConversionCode()
	 * @model required="true"
	 * @generated
	 */
	String getConversionCode();

	/**
	 * Sets the value of the '{@link commandIF.InputConversion#getConversionCode <em>Conversion Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversion Code</em>' attribute.
	 * @see #getConversionCode()
	 * @generated
	 */
	void setConversionCode(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link commandIF.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see commandIF.Type
	 * @see #setType(Type)
	 * @see commandIF.CommandIFPackage#getInputConversion_Type()
	 * @model required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link commandIF.InputConversion#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see commandIF.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // InputConversion
