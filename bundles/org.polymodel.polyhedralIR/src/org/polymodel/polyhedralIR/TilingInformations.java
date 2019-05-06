/**
 */
package org.polymodel.polyhedralIR;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tiling Informations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.TilingInformations#getRatios <em>Ratios</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.TilingInformations#getMinParamValues <em>Min Param Values</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.TilingInformations#getTileGroups <em>Tile Groups</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.TilingInformations#getCobPreprocess <em>Cob Preprocess</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getTilingInformations()
 * @model
 * @generated
 */
public interface TilingInformations extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Ratios</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ratios</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ratios</em>' attribute.
	 * @see #setRatios(Map)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getTilingInformations_Ratios()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, EList<Integer>> getRatios();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.TilingInformations#getRatios <em>Ratios</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ratios</em>' attribute.
	 * @see #getRatios()
	 * @generated
	 */
	void setRatios(Map<String, EList<Integer>> value);

	/**
	 * Returns the value of the '<em><b>Min Param Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Param Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Param Values</em>' attribute.
	 * @see #setMinParamValues(Map)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getTilingInformations_MinParamValues()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, Integer> getMinParamValues();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.TilingInformations#getMinParamValues <em>Min Param Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Param Values</em>' attribute.
	 * @see #getMinParamValues()
	 * @generated
	 */
	void setMinParamValues(Map<String, Integer> value);

	/**
	 * Returns the value of the '<em><b>Tile Groups</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Groups</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Groups</em>' attribute.
	 * @see #setTileGroups(Map)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getTilingInformations_TileGroups()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, List<String>> getTileGroups();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.TilingInformations#getTileGroups <em>Tile Groups</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Groups</em>' attribute.
	 * @see #getTileGroups()
	 * @generated
	 */
	void setTileGroups(Map<String, List<String>> value);

	/**
	 * Returns the value of the '<em><b>Cob Preprocess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cob Preprocess</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cob Preprocess</em>' attribute.
	 * @see #setCobPreprocess(Map)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getTilingInformations_CobPreprocess()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, AffineFunction> getCobPreprocess();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.TilingInformations#getCobPreprocess <em>Cob Preprocess</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cob Preprocess</em>' attribute.
	 * @see #getCobPreprocess()
	 * @generated
	 */
	void setCobPreprocess(Map<String, AffineFunction> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitTilingInformations(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // TilingInformations
