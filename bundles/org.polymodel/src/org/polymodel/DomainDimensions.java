/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Dimensions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.DomainDimensions#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.polymodel.DomainDimensions#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.DomainDimensions#getExistential <em>Existential</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.PolymodelPackage#getDomainDimensions()
 * @model
 * @generated
 */
public interface DomainDimensions extends PolymodelVisitable {
	/**
	 * Returns the value of the '<em><b>Indices</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.algebra.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indices</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indices</em>' reference list.
	 * @see org.polymodel.PolymodelPackage#getDomainDimensions_Indices()
	 * @model
	 * @generated
	 */
	EList<Variable> getIndices();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.algebra.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.polymodel.PolymodelPackage#getDomainDimensions_Parameters()
	 * @model
	 * @generated
	 */
	EList<Variable> getParameters();

	/**
	 * Returns the value of the '<em><b>Existential</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.ExistentialVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Existential</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Existential</em>' containment reference list.
	 * @see org.polymodel.PolymodelPackage#getDomainDimensions_Existential()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExistentialVariable> getExistential();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DomainDimensions copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitDomainDimensions(this);'"
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getParameterDimensionOf(Variable variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getDimensionOf(Variable variable);

} // DomainDimensions
