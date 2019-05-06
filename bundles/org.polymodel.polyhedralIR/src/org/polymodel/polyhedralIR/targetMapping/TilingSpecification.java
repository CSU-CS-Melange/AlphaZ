/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tiling Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getStartDim <em>Start Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getEndDim <em>End Dim</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getSubTiles <em>Sub Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getIdentificationName <em>Identification Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTilingSpecification()
 * @model
 * @generated
 */
public interface TilingSpecification extends FeatureSpecification, PolyhedralIRVisitable {
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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTilingSpecification_StartDim()
	 * @model required="true"
	 * @generated
	 */
	int getStartDim();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getStartDim <em>Start Dim</em>}' attribute.
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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTilingSpecification_EndDim()
	 * @model required="true"
	 * @generated
	 */
	int getEndDim();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getEndDim <em>End Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Dim</em>' attribute.
	 * @see #getEndDim()
	 * @generated
	 */
	void setEndDim(int value);

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
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTilingSpecification_Levels()
	 * @model required="true"
	 * @generated
	 */
	int getLevels();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getLevels <em>Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Levels</em>' attribute.
	 * @see #getLevels()
	 * @generated
	 */
	void setLevels(int value);

	/**
	 * Returns the value of the '<em><b>Sub Tiles</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Tiles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Tiles</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTilingSpecification_SubTiles()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubTilingSpecification> getSubTiles();

	/**
	 * Returns the value of the '<em><b>Identification Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification Name</em>' attribute.
	 * @see #setIdentificationName(String)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getTilingSpecification_IdentificationName()
	 * @model required="true"
	 * @generated
	 */
	String getIdentificationName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification#getIdentificationName <em>Identification Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification Name</em>' attribute.
	 * @see #getIdentificationName()
	 * @generated
	 */
	void setIdentificationName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" levelRequired="true"
	 * @generated
	 */
	SubTilingSpecification getSubTile(int level);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitTilingSpecification(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // TilingSpecification
