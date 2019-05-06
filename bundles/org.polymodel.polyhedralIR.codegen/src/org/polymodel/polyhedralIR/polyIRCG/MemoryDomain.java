/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory Domain</b></em>'.
 * 
 * Memory Domain is designed to be an interface for domains of physical memory,
 * which is not necessarily a polyhedral domain.
 * One implementation is available as PseudoProjection, 
 * a combination of affine projection and mod factors.
 * IntConstraintSystem in integerLinearAlgebra package would also be used
 * to model MemoryDomains.  
 * 
 * 
 * @see org.polymodel.polyhedralIR.polyIRCG.PseudoProjection
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.MemoryDomain#isZeroAligned <em>Zero Aligned</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMemoryDomain()
 * @model abstract="true"
 * @generated
 */
public interface MemoryDomain extends EObject {
	/**
	 * Returns the value of the '<em><b>Zero Aligned</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zero Aligned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zero Aligned</em>' attribute.
	 * @see #setZeroAligned(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMemoryDomain_ZeroAligned()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isZeroAligned();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.MemoryDomain#isZeroAligned <em>Zero Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zero Aligned</em>' attribute.
	 * @see #isZeroAligned()
	 * @generated
	 */
	void setZeroAligned(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getDim();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNParams();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNIndices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getParams();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getIndices();

	/**
	 * <!-- begin-user-doc -->
	 * Returns 2D List that stores the lower and upper bound of the specified dimension as IntExpression of parameters.
	 * First element of the result is LB and the second is UB.
	 * <!-- end-user-doc -->
	 * @model lower="2" upper="2" dimRequired="true"
	 * @generated
	 */
	EList<IntExpression> getBounds(int dim);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the volume of the memory from dimensions start to end.
	 * (start is inclusive starting from 0, end is exclusive starting from 0; following common convention for sublist etc.)
	 * If end is negative, it is interpreted as the volume up to the last dimension.
	 * <!-- end-user-doc -->
	 * @model required="true" startingDimRequired="true" endingDimRequired="true"
	 * @generated
	 */
	IntExpression getVolumeExpression(int startingDim, int endingDim);

} // MemoryDomain
