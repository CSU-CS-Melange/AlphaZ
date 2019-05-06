/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Scop Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.AbstractScopNode#getScopAnnotations <em>Scop Annotations</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.ScopPackage#getAbstractScopNode()
 * @model abstract="true"
 * @generated
 */
public interface AbstractScopNode extends ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.scop.IScopAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scop Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scop Annotations</em>' containment reference list.
	 * @see org.polymodel.scop.ScopPackage#getAbstractScopNode_ScopAnnotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<IScopAnnotation> getScopAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getSurroundingIterators();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the list of loops surrounding the node, not including its own in case of ScopFor.
	 * The list is in the order of outer-most loop to the inner-most.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ScopFor> getSurroundingScopFors();
	
	/**
	 * Returns the ScopFor immediately surrounding this node.
	 * When no ScopFor surrounds this node, returns null.
	 * 
	 * @return
	 */
	ScopFor getSurroundingScopFor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<IntConstraintSystem> getDerivedConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	AbstractScopNode simplify();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the depth of the current loop the node is in, including its own in case of ScopFor.
	 * The loop depth is counted from 1.
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getLoopDepth();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAbstractScopNode(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAbstractScopNode(this);'"
	 * @generated NOT
	 */
	<T extends ScopRoot> T getScopRoot();

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAbstractScopNode(this);'"
//	 * @generated NOT
//	 */
//	EList<IntConstraintSystem> getConstraints();

} // AbstractScopNode
