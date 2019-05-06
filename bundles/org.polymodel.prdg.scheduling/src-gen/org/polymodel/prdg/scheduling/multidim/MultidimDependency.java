/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.Domain;
import org.polymodel.algebra.Variable;

import fr.irisa.cairn.graph.observer.IObservable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getMultidimDependency()
 * @model superTypes="org.polymodel.prdg.scheduling.multidim.IObservable"
 * @generated
 */
public interface MultidimDependency extends EObject,IObservable {
	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getMultidimDependency_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<NullifiableDependency> getDependencies();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Domain computeConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getAllScheduleCoefficients();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getAllSatisfactionVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getAllSourceCoefficients();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getAllReferenceCoefficients();

	public abstract void setUb(Integer ub);

	public abstract Integer getUb();

	public abstract void setLb(Integer lb);

	public abstract Integer getLb();
	
	
	

} // MultidimDependency
