/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Tile Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getLevel <em>Level</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getStart <em>Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getEnd <em>End</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileSizes <em>Tile Sizes</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileType <em>Tile Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileIndexPrefix <em>Tile Index Prefix</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileSizePrefix <em>Tile Size Prefix</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getSubTileSpecification()
 * @model
 * @generated
 */
public interface SubTileSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getSubTileSpecification_Level()
	 * @model required="true"
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(int value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getSubTileSpecification_Start()
	 * @model required="true"
	 * @generated
	 */
	int getStart();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(int value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getSubTileSpecification_End()
	 * @model required="true"
	 * @generated
	 */
	int getEnd();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(int value);

	/**
	 * Returns the value of the '<em><b>Tile Sizes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Sizes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Sizes</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getSubTileSpecification_TileSizes()
	 * @model required="true"
	 * @generated
	 */
	EList<Integer> getTileSizes();

	/**
	 * Returns the value of the '<em><b>Tile Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.targetMapping.TILING_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Type</em>' attribute.
	 * @see org.polymodel.polyhedralIR.targetMapping.TILING_TYPE
	 * @see #setTileType(TILING_TYPE)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getSubTileSpecification_TileType()
	 * @model required="true"
	 * @generated
	 */
	TILING_TYPE getTileType();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileType <em>Tile Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Type</em>' attribute.
	 * @see org.polymodel.polyhedralIR.targetMapping.TILING_TYPE
	 * @see #getTileType()
	 * @generated
	 */
	void setTileType(TILING_TYPE value);

	/**
	 * Returns the value of the '<em><b>Tile Index Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Index Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Index Prefix</em>' attribute.
	 * @see #setTileIndexPrefix(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getSubTileSpecification_TileIndexPrefix()
	 * @model required="true"
	 * @generated
	 */
	String getTileIndexPrefix();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileIndexPrefix <em>Tile Index Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Index Prefix</em>' attribute.
	 * @see #getTileIndexPrefix()
	 * @generated
	 */
	void setTileIndexPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Tile Size Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Size Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Size Prefix</em>' attribute.
	 * @see #setTileSizePrefix(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getSubTileSpecification_TileSizePrefix()
	 * @model required="true"
	 * @generated
	 */
	String getTileSizePrefix();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification#getTileSizePrefix <em>Tile Size Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Size Prefix</em>' attribute.
	 * @see #getTileSizePrefix()
	 * @generated
	 */
	void setTileSizePrefix(String value);

} // SubTileSpecification
