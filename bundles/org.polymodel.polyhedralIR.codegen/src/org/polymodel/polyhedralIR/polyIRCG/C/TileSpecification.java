/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tile Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getStartDim <em>Start Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getEndDim <em>End Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getSubTiles <em>Sub Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getOrderingPrefix <em>Ordering Prefix</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileSpecification()
 * @model
 * @generated
 */
public interface TileSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Levels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Levels</em>' attribute.
	 * @see #setLevels(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileSpecification_Levels()
	 * @model required="true"
	 * @generated
	 */
	int getLevels();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getLevels <em>Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Levels</em>' attribute.
	 * @see #getLevels()
	 * @generated
	 */
	void setLevels(int value);

	/**
	 * Returns the value of the '<em><b>Start Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Dim</em>' attribute.
	 * @see #setStartDim(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileSpecification_StartDim()
	 * @model required="true"
	 * @generated
	 */
	int getStartDim();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getStartDim <em>Start Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Dim</em>' attribute.
	 * @see #getStartDim()
	 * @generated
	 */
	void setStartDim(int value);

	/**
	 * Returns the value of the '<em><b>End Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Dim</em>' attribute.
	 * @see #setEndDim(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileSpecification_EndDim()
	 * @model required="true"
	 * @generated
	 */
	int getEndDim();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification#getEndDim <em>End Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Dim</em>' attribute.
	 * @see #getEndDim()
	 * @generated
	 */
	void setEndDim(int value);

	/**
	 * Returns the value of the '<em><b>Sub Tiles</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Tiles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Tiles</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileSpecification_SubTiles()
	 * @model
	 * @generated
	 */
	EList<SubTileSpecification> getSubTiles();

	/**
	 * Returns the value of the '<em><b>Ordering Prefix</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordering Prefix</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordering Prefix</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileSpecification_OrderingPrefix()
	 * @model
	 * @generated
	 */
	EList<Integer> getOrderingPrefix();

} // TileSpecification
