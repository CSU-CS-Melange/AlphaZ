/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.Domain;

/**
 * <!-- begin-user-doc -->
 * PseudoProjection is a specialization of MemoryDomain with the following convention.
 * The domain in this class is the projected domain resulting from some projective mapping applied to iteration space.
 * 
 * The mod factors makes it a pseudo projective allocation. If a projection (i,j->i,j) is given, the domain would have
 * 2D space equal to the iteration space, which is also the domain stored in this class. However, if mod factor of 2 is given
 * to the i dimension, the actual memory allocated for the i-dimension becomes 2, and projection along j is reused every 2 iterations of the i dimension.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PseudoProjection#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PseudoProjection#getModFactors <em>Mod Factors</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getPseudoProjection()
 * @model
 * @generated
 */
public interface PseudoProjection extends MemoryDomain {
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
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getPseudoProjection_Domain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.PseudoProjection#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Mod Factors</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mod Factors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mod Factors</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getPseudoProjection_ModFactors()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntExpression> getModFactors();
	
	boolean isModFactorInEffect();
	
	boolean isModFactorInEffect(int dim);

} // PseudoProjection
