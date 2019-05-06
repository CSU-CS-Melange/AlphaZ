/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multidim Memory Read Dependency Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent#getDimension <em>Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getMultidimMemoryReadDependencyComponent()
 * @model
 * @generated
 */
public interface MultidimMemoryReadDependencyComponent extends MemoryReadDependency {

	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' attribute.
	 * @see #setDimension(int)
	 * @see org.polymodel.prdg.scheduling.structured.StructuredPackage#getMultidimMemoryReadDependencyComponent_Dimension()
	 * @model
	 * @generated
	 */
	int getDimension();

	/**
	 * Sets the value of the '{@link org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent#getDimension <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' attribute.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(int value);
} // MultidimMemoryReadDependencyComponent
