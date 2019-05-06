/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.scheduling.Dependency;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Single Dimension Dependency</b></em>'.
 * 
 * Introduce a boolean variable to model the dependence satisfaction. If this
 * satisfaction variable is equals to 1 then the dependence is strongly
 * satisfied at the level of the dependence dimension. Else, the variable is
 * equals to 0 and the dependence is weakly satisfied. <br>
 * <br>
 * <i> L.N. Pouchet PhD thesis - p36</i>
 * 
 * 
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getDimension <em>Dimension</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getPreviousDimensionsDependencies <em>Previous Dimensions Dependencies</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getSatisfactionVariable <em>Satisfaction Variable</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getDependency <em>Dependency</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getK <em>K</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getNullifiableDependency()
 * @model
 * @generated
 */
public interface NullifiableDependency extends Dependency {
	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dimension</em>' attribute.
	 * @see #setDimension(int)
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getSingleDimensionDependency_Dimension()
	 * @model
	 * @generated
	 */
	int getDimension();

	/**
	 * Sets the value of the '
	 * {@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getDimension
	 * <em>Dimension</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Dimension</em>' attribute.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(int value);

	/**
	 * Returns the value of the '<em><b>Previous Dimensions Dependencies</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous Dimensions Dependencies</em>'
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Dimensions Dependencies</em>' reference list.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getNullifiableDependency_PreviousDimensionsDependencies()
	 * @model
	 * @generated
	 */
	EList<NullifiableDependency> getPreviousDimensionsDependencies();

	/**
	 * Returns the value of the '<em><b>Satisfaction Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfaction Variable</em>' containment
	 * reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Satisfaction Variable</em>' containment reference.
	 * @see #setSatisfactionVariable(Variable)
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getNullifiableDependency_SatisfactionVariable()
	 * @model containment="true"
	 * @generated
	 */
	Variable getSatisfactionVariable();

	/**
	 * Sets the value of the '
	 * {@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getSatisfactionVariable
	 * <em>Satisfaction Variable</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Satisfaction Variable</em>'
	 *            containment reference.
	 * @see #getSatisfactionVariable()
	 * @generated
	 */
	void setSatisfactionVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' containment reference.
	 * @see #setDependency(Dependency)
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getNullifiableDependency_Dependency()
	 * @model containment="true"
	 * @generated
	 */
	Dependency getDependency();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getDependency <em>Dependency</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Dependency</em>' containment reference.
	 * @see #getDependency()
	 * @generated
	 */
	void setDependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>K</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * K is the nullification constant of the dependency.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>K</em>' attribute.
	 * @see #setK(long)
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage#getSingleDimensionDependency_K()
	 * @model
	 * @generated
	 */
	long getK();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc --> K is the nullification
	 * constant of the dependency.<!-- end-user-doc -->
	 * @param value the new value of the '<em>K</em>' attribute.
	 * @see #getK()
	 * @generated
	 */
	void setK(long value);

	public abstract boolean requireNullification();

} // SingleDimensionDependency
