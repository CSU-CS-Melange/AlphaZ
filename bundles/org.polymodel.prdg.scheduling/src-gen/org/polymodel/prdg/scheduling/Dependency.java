/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Dependency</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.Dependency#getSource <em>Source</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.Dependency#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getDependency()
 * @model abstract="true"
 * @generated
 */
public interface Dependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(SchedulePrototype)
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getDependency_Source()
	 * @model required="true"
	 * @generated
	 */
	SchedulePrototype getSource();

	/**
	 * Sets the value of the '
	 * {@link org.polymodel.prdg.scheduling.Dependency#getSource
	 * <em>Source</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SchedulePrototype value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(SchedulePrototype)
	 * @see org.polymodel.prdg.scheduling.SchedulingPackage#getDependency_Reference()
	 * @model required="true"
	 * @generated
	 */
	SchedulePrototype getReference();

	/**
	 * Sets the value of the '
	 * {@link org.polymodel.prdg.scheduling.Dependency#getReference
	 * <em>Reference</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(SchedulePrototype value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ScheduleTerm> getTerms(boolean constantPart);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<IntConstraint> getCoefficientsContext();

	Domain getDependencyDomain();

	/**
	 * Build the difference of the reference {@link ScheduleTerm}s with the
	 * source {@link ScheduleTerm}s.
	 * 
	 * @param sourceTerms
	 * @param referenceTerms
	 * @return
	 */
	public abstract EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> sourceTerms, List<ScheduleTerm> referenceTerms);

	public abstract ScheduleTerm getCausalityTerm();

	public abstract EList<Variable> getAllVariables();

} // Dependency
