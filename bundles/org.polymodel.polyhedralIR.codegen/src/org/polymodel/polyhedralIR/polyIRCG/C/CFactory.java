/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage
 * @generated
 */
public interface CFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.impl.CFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Equation As Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation As Statement</em>'.
	 * @generated
	 */
	EquationAsStatement createEquationAsStatement();

	/**
	 * Returns a new object of class '<em>Parameter Check</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Check</em>'.
	 * @generated
	 */
	ParameterCheck createParameterCheck();

	/**
	 * Returns a new object of class '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop</em>'.
	 * @generated
	 */
	CLoop createCLoop();

	/**
	 * Returns a new object of class '<em>Tiled CLoop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tiled CLoop</em>'.
	 * @generated
	 */
	TiledCLoop createTiledCLoop();

	/**
	 * Returns a new object of class '<em>Parallelized CLoop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallelized CLoop</em>'.
	 * @generated
	 */
	ParallelizedCLoop createParallelizedCLoop();

	/**
	 * Returns a new object of class '<em>Scop Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scop Loop</em>'.
	 * @generated
	 */
	ScopLoop createScopLoop();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	CVariable createCVariable();

	/**
	 * Returns a new object of class '<em>DTiled Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DTiled Loop</em>'.
	 * @generated
	 */
	DTiledLoop createDTiledLoop();

	/**
	 * Returns a new object of class '<em>DTiled Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DTiled Block</em>'.
	 * @generated
	 */
	DTiledBlock createDTiledBlock();

	/**
	 * Returns a new object of class '<em>Sub Tile Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Tile Specification</em>'.
	 * @generated
	 */
	SubTileSpecification createSubTileSpecification();

	/**
	 * Returns a new object of class '<em>Tile Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tile Specification</em>'.
	 * @generated
	 */
	TileSpecification createTileSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CPackage getCPackage();

} //CFactory
