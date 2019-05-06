/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tiled SIMDC Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop#getSimdStatements <em>Simd Statements</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getTiledSIMDCLoop()
 * @model
 * @generated
 */
public interface TiledSIMDCLoop extends TiledCLoop {
	/**
	 * Returns the value of the '<em><b>Simd Statements</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simd Statements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simd Statements</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getTiledSIMDCLoop_SimdStatements()
	 * @model
	 * @generated
	 */
	EList<SIMDStatement> getSimdStatements();

} // TiledSIMDCLoop
