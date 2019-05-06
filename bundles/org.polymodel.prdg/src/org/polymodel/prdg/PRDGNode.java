/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.Domain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PRDG Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.PRDGNode#getPrdg <em>Prdg</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDGNode#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDGNode#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.PrdgPackage#getPRDGNode()
 * @model
 * @generated
 */
public interface PRDGNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Prdg</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.prdg.PRDG#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prdg</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prdg</em>' container reference.
	 * @see #setPrdg(PRDG)
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGNode_Prdg()
	 * @see org.polymodel.prdg.PRDG#getNodes
	 * @model opposite="nodes" transient="false"
	 * @generated
	 */
	PRDG getPrdg();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGNode#getPrdg <em>Prdg</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prdg</em>' container reference.
	 * @see #getPrdg()
	 * @generated
	 */
	void setPrdg(PRDG value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference.
	 * @see #setDomain(Domain)
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGNode_Domain()
	 * @model containment="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGNode#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

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
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<PRDGEdge> getDestinations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<PRDGEdge> getSources();

} // PRDGNode
