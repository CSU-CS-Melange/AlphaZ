/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PRDG</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.PRDG#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDG#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.polymodel.prdg.PRDG#getHedges <em>Hedges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.PrdgPackage#getPRDG()
 * @model
 * @generated
 */
public interface PRDG extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.PRDGNode}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.prdg.PRDGNode#getPrdg <em>Prdg</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.polymodel.prdg.PrdgPackage#getPRDG_Nodes()
	 * @see org.polymodel.prdg.PRDGNode#getPrdg
	 * @model opposite="prdg" containment="true"
	 * @generated
	 */
	EList<PRDGNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.PRDGEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.polymodel.prdg.PrdgPackage#getPRDG_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<PRDGEdge> getEdges();

	/**
	 * Returns the value of the '<em><b>Hedges</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.prdg.PRDGSubSystemHyperEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hedges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hedges</em>' reference list.
	 * @see org.polymodel.prdg.PrdgPackage#getPRDG_Hedges()
	 * @model
	 * @generated
	 */
	EList<PRDGSubSystemHyperEdge> getHedges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	PRDGNode getNode(String name);

} // PRDG
