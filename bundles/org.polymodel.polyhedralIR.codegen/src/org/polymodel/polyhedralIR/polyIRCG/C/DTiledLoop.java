/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTilingOptions;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DTiled Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getScop <em>Scop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getTiledBlocks <em>Tiled Blocks</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getDtilingOptions <em>Dtiling Options</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getGeneratorLoop <em>Generator Loop</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledLoop()
 * @model
 * @generated
 */
public interface DTiledLoop extends EObject {
	/**
	 * Returns the value of the '<em><b>Scop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scop</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scop</em>' containment reference.
	 * @see #setScop(ScopRoot)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledLoop_Scop()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ScopRoot getScop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getScop <em>Scop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scop</em>' containment reference.
	 * @see #getScop()
	 * @generated
	 */
	void setScop(ScopRoot value);

	/**
	 * Returns the value of the '<em><b>Tiled Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getContainerLoop <em>Container Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiled Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiled Blocks</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledLoop_TiledBlocks()
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getContainerLoop
	 * @model opposite="containerLoop" containment="true"
	 * @generated
	 */
	EList<DTiledBlock> getTiledBlocks();

	/**
	 * Returns the value of the '<em><b>Dtiling Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dtiling Options</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dtiling Options</em>' attribute.
	 * @see #setDtilingOptions(DTilingOptions)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledLoop_DtilingOptions()
	 * @model dataType="org.polymodel.polyhedralIR.polyIRCG.C.DTilingOptions"
	 * @generated
	 */
	DTilingOptions getDtilingOptions();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getDtilingOptions <em>Dtiling Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dtiling Options</em>' attribute.
	 * @see #getDtilingOptions()
	 * @generated
	 */
	void setDtilingOptions(DTilingOptions value);

	/**
	 * Returns the value of the '<em><b>Generator Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator Loop</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generator Loop</em>' reference.
	 * @see #setGeneratorLoop(TiledCLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledLoop_GeneratorLoop()
	 * @model required="true"
	 * @generated
	 */
	TiledCLoop getGeneratorLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getGeneratorLoop <em>Generator Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator Loop</em>' reference.
	 * @see #getGeneratorLoop()
	 * @generated
	 */
	void setGeneratorLoop(TiledCLoop value);

} // DTiledLoop
