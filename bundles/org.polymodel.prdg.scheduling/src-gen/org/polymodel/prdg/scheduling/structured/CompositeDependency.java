/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.common.util.EList;
import org.polymodel.Domain;
import org.polymodel.prdg.scheduling.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.CompositeDependency#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.CompositeDependency#getDependencyDomain <em>Dependency Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getCompositeDependency()
 * @model
 * @generated
 */
public interface CompositeDependency extends Dependency {
	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.Dependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getCompositeDependency_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Dependency Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency Domain</em>' reference.
	 * @see #setDependencyDomain(Domain)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getCompositeDependency_DependencyDomain()
	 * @model
	 * @generated
	 */
	Domain getDependencyDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.CompositeDependency#getDependencyDomain <em>Dependency Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency Domain</em>' reference.
	 * @see #getDependencyDomain()
	 * @generated
	 */
	void setDependencyDomain(Domain value);

} // CompositeDependency
