/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Gen Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getType <em>Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isAligned <em>Aligned</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isFlattened <em>Flattened</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getAccessExpression <em>Access Expression</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isIsfrontpadded <em>Isfrontpadded</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getForntpaddingValue <em>Forntpadding Value</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeGenVariable()
 * @model
 * @generated
 */
public interface CodeGenVariable extends AbstractVariable {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeGenVariable_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference.
	 * @see #setDomain(MemoryDomain)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeGenVariable_Domain()
	 * @model containment="true"
	 * @generated
	 */
	MemoryDomain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(MemoryDomain value);

	/**
	 * Returns the value of the '<em><b>Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aligned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aligned</em>' attribute.
	 * @see #setAligned(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeGenVariable_Aligned()
	 * @model required="true"
	 * @generated
	 */
	boolean isAligned();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isAligned <em>Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aligned</em>' attribute.
	 * @see #isAligned()
	 * @generated
	 */
	void setAligned(boolean value);

	/**
	 * Returns the value of the '<em><b>Flattened</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flattened</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flattened</em>' attribute.
	 * @see #setFlattened(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeGenVariable_Flattened()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isFlattened();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isFlattened <em>Flattened</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flattened</em>' attribute.
	 * @see #isFlattened()
	 * @generated
	 */
	void setFlattened(boolean value);

	/**
	 * Returns the value of the '<em><b>Access Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Expression</em>' containment reference.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeGenVariable_AccessExpression()
	 * @model containment="true" required="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	MemoryAccessExpression getAccessExpression();

	/**
	 * Returns the value of the '<em><b>Isfrontpadded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Isfrontpadded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Isfrontpadded</em>' attribute.
	 * @see #setIsfrontpadded(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeGenVariable_Isfrontpadded()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsfrontpadded();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isIsfrontpadded <em>Isfrontpadded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Isfrontpadded</em>' attribute.
	 * @see #isIsfrontpadded()
	 * @generated
	 */
	void setIsfrontpadded(boolean value);

	/**
	 * Returns the value of the '<em><b>Forntpadding Value</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forntpadding Value</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forntpadding Value</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeGenVariable_ForntpaddingValue()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getForntpaddingValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getMPITypeString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" startingDimRequired="true" endingDimRequired="true"
	 * @generated
	 */
	IntExpression getVolumeExpression(int startingDim, int endingDim);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" dimRequired="true"
	 * @generated
	 */
	IntExpression getModFactor(int dim);
	

} // CodeGenVariable
