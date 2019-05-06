/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.AbstractRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PRDG Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.PRDGEdge#getSource <em>Source</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDGEdge#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDGEdge#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDGEdge#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.PrdgPackage#getPRDGEdge()
 * @model
 * @generated
 */
public interface PRDGEdge extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(PRDGNode)
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGEdge_Source()
	 * @model
	 * @generated
	 */
	PRDGNode getSource();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGEdge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PRDGNode value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(PRDGNode)
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGEdge_Destination()
	 * @model
	 * @generated
	 */
	PRDGNode getDestination();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGEdge#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(PRDGNode value);

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
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGEdge_Domain()
	 * @model containment="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGEdge#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference.
	 * @see #setFunction(EdgeFunction)
	 * @see org.polymodel.prdg.PrdgPackage#getPRDGEdge_Function()
	 * @model containment="true"
	 * @generated
	 */
	EdgeFunction getFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.PRDGEdge#getFunction <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' containment reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(EdgeFunction value);

	/**
	 * <!-- begin-user-doc -->
	 * Creates an relation where its domain is the edge domain, and relation is the edge function.
	 * Produces dependence relation if edge is a dependence function.
	 * <!-- end-user-doc -->
	 * @model required="true" managerRequired="true"
	 * @generated
	 */
	<T extends AbstractRelation> T toEdgeRelation(DimensionsManager manager);
	
} // PRDGEdge
