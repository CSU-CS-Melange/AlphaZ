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
import org.polymodel.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PRDG Sub System Hyper Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getSources <em>Sources</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getDestinations <em>Destinations</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getExtDom <em>Ext Dom</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.PrdgPackage#getPRDGSubSystemHyperEdge()
 * @model
 * @generated
 */
public interface PRDGSubSystemHyperEdge extends EObject {
	/**
	 * Returns the value of the '<em><b>Sources</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.prdg.PRDGNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' reference list.
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGSubSystemHyperEdge_Sources()
	 * @model
	 * @generated
	 */
	EList<PRDGNode> getSources();

	/**
	 * Returns the value of the '<em><b>Destinations</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.prdg.PRDGNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destinations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destinations</em>' reference list.
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGSubSystemHyperEdge_Destinations()
	 * @model
	 * @generated
	 */
	EList<PRDGNode> getDestinations();

	/**
	 * Returns the value of the '<em><b>Ext Dom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ext Dom</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ext Dom</em>' reference.
	 * @see #setExtDom(Domain)
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGSubSystemHyperEdge_ExtDom()
	 * @model
	 * @generated
	 */
	Domain getExtDom();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getExtDom <em>Ext Dom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ext Dom</em>' reference.
	 * @see #getExtDom()
	 * @generated
	 */
	void setExtDom(Domain value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' reference.
	 * @see #setParams(Function)
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGSubSystemHyperEdge_Params()
	 * @model
	 * @generated
	 */
	Function getParams();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGSubSystemHyperEdge#getParams <em>Params</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Params</em>' reference.
	 * @see #getParams()
	 * @generated
	 */
	void setParams(Function value);

} // PRDGSubSystemHyperEdge
