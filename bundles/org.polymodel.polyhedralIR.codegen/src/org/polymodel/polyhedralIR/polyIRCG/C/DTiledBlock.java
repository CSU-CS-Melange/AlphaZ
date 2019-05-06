/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DTiled Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getBlockStart <em>Block Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getPointLoopStart <em>Point Loop Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getTileLoopStart <em>Tile Loop Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getPerfectLoopNest <em>Perfect Loop Nest</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getContainerLoop <em>Container Loop</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledBlock()
 * @model
 * @generated
 */
public interface DTiledBlock extends EObject {
	/**
	 * Returns the value of the '<em><b>Block Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Start</em>' reference.
	 * @see #setBlockStart(AbstractScopNode)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledBlock_BlockStart()
	 * @model
	 * @generated
	 */
	AbstractScopNode getBlockStart();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getBlockStart <em>Block Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Start</em>' reference.
	 * @see #getBlockStart()
	 * @generated
	 */
	void setBlockStart(AbstractScopNode value);

	/**
	 * Returns the value of the '<em><b>Point Loop Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Loop Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Loop Start</em>' reference.
	 * @see #setPointLoopStart(AbstractScopNode)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledBlock_PointLoopStart()
	 * @model required="true"
	 * @generated
	 */
	AbstractScopNode getPointLoopStart();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getPointLoopStart <em>Point Loop Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Loop Start</em>' reference.
	 * @see #getPointLoopStart()
	 * @generated
	 */
	void setPointLoopStart(AbstractScopNode value);

	/**
	 * Returns the value of the '<em><b>Tile Loop Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Loop Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Loop Start</em>' reference.
	 * @see #setTileLoopStart(AbstractScopNode)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledBlock_TileLoopStart()
	 * @model required="true"
	 * @generated
	 */
	AbstractScopNode getTileLoopStart();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getTileLoopStart <em>Tile Loop Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Loop Start</em>' reference.
	 * @see #getTileLoopStart()
	 * @generated
	 */
	void setTileLoopStart(AbstractScopNode value);

	/**
	 * Returns the value of the '<em><b>Perfect Loop Nest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perfect Loop Nest</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perfect Loop Nest</em>' containment reference.
	 * @see #setPerfectLoopNest(ScopFor)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledBlock_PerfectLoopNest()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ScopFor getPerfectLoopNest();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock#getPerfectLoopNest <em>Perfect Loop Nest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Perfect Loop Nest</em>' containment reference.
	 * @see #getPerfectLoopNest()
	 * @generated
	 */
	void setPerfectLoopNest(ScopFor value);

	/**
	 * Returns the value of the '<em><b>Container Loop</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getTiledBlocks <em>Tiled Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Loop</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Loop</em>' container reference.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getDTiledBlock_ContainerLoop()
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop#getTiledBlocks
	 * @model opposite="tiledBlocks" transient="false" changeable="false"
	 * @generated
	 */
	DTiledLoop getContainerLoop();

} // DTiledBlock
