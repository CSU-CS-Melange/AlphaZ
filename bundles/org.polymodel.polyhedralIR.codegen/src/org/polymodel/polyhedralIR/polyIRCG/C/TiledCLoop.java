/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tiled CLoop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#isOptimize <em>Optimize</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getOrderingDimensions <em>Ordering Dimensions</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getOptimizedPointLoop <em>Optimized Point Loop</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTiledCLoop()
 * @model
 * @generated
 */
public interface TiledCLoop extends CLoop {
	/**
	 * Returns the value of the '<em><b>Optimize</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optimize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimize</em>' attribute.
	 * @see #setOptimize(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTiledCLoop_Optimize()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isOptimize();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#isOptimize <em>Optimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimize</em>' attribute.
	 * @see #isOptimize()
	 * @generated
	 */
	void setOptimize(boolean value);

	/**
	 * Returns the value of the '<em><b>Tiles</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiles</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTiledCLoop_Tiles()
	 * @model containment="true"
	 * @generated
	 */
	EList<TileSpecification> getTiles();

	/**
	 * Returns the value of the '<em><b>Ordering Dimensions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordering Dimensions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordering Dimensions</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTiledCLoop_OrderingDimensions()
	 * @model
	 * @generated
	 */
	EList<Integer> getOrderingDimensions();

	/**
	 * Returns the value of the '<em><b>Optimized Point Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optimized Point Loop</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimized Point Loop</em>' reference.
	 * @see #setOptimizedPointLoop(CLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTiledCLoop_OptimizedPointLoop()
	 * @model
	 * @generated
	 */
	CLoop getOptimizedPointLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop#getOptimizedPointLoop <em>Optimized Point Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimized Point Loop</em>' reference.
	 * @see #getOptimizedPointLoop()
	 * @generated
	 */
	void setOptimizedPointLoop(CLoop value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<String> getTileIndices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	DTiledLoop generateDTiledLoop();

} // TiledCLoop
