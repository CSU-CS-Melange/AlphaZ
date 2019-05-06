/**
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Tiling Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTileSizes <em>Tile Sizes</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTileSizeType <em>Tile Size Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTilingType <em>Tiling Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getStartDim <em>Start Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getLevel <em>Level</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getCommunicationMapping <em>Communication Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getEndDim <em>End Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSubTilingSpecification()
 * @model
 * @generated
 */
public interface SubTilingSpecification extends PolyhedralIRVisitable {
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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSubTilingSpecification_TileSizes()
	 * @model
	 * @generated
	 */
	EList<Integer> getTileSizes();

	/**
	 * Returns the value of the '<em><b>Tile Size Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Size Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Size Type</em>' attribute.
	 * @see org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE
	 * @see #setTileSizeType(TILE_SIZE_TYPE)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSubTilingSpecification_TileSizeType()
	 * @model required="true"
	 * @generated
	 */
	TILE_SIZE_TYPE getTileSizeType();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTileSizeType <em>Tile Size Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Size Type</em>' attribute.
	 * @see org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE
	 * @see #getTileSizeType()
	 * @generated
	 */
	void setTileSizeType(TILE_SIZE_TYPE value);

	/**
	 * Returns the value of the '<em><b>Tiling Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.targetMapping.TILING_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Type</em>' attribute.
	 * @see org.polymodel.polyhedralIR.targetMapping.TILING_TYPE
	 * @see #setTilingType(TILING_TYPE)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSubTilingSpecification_TilingType()
	 * @model required="true"
	 * @generated
	 */
	TILING_TYPE getTilingType();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getTilingType <em>Tiling Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Type</em>' attribute.
	 * @see org.polymodel.polyhedralIR.targetMapping.TILING_TYPE
	 * @see #getTilingType()
	 * @generated
	 */
	void setTilingType(TILING_TYPE value);

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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSubTilingSpecification_StartDim()
	 * @model required="true"
	 * @generated
	 */
	int getStartDim();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getStartDim <em>Start Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Dim</em>' attribute.
	 * @see #getStartDim()
	 * @generated
	 */
	void setStartDim(int value);

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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSubTilingSpecification_Level()
	 * @model required="true"
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(int value);

	/**
	 * Returns the value of the '<em><b>Communication Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communication Mapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication Mapping</em>' containment reference.
	 * @see #setCommunicationMapping(CommunicationMappingForTiledSpace)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSubTilingSpecification_CommunicationMapping()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CommunicationMappingForTiledSpace getCommunicationMapping();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getCommunicationMapping <em>Communication Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communication Mapping</em>' containment reference.
	 * @see #getCommunicationMapping()
	 * @generated
	 */
	void setCommunicationMapping(CommunicationMappingForTiledSpace value);

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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getSubTilingSpecification_EndDim()
	 * @model required="true"
	 * @generated
	 */
	int getEndDim();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification#getEndDim <em>End Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Dim</em>' attribute.
	 * @see #getEndDim()
	 * @generated
	 */
	void setEndDim(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitSubTilingSpecification(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // SubTilingSpecification
