/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage
 * @generated
 */
public interface PolyhedralIRFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PolyhedralIRFactory eINSTANCE = org.polymodel.polyhedralIR.impl.PolyhedralIRFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Program</em>'.
	 * @generated
	 */
	Program createProgram();

	/**
	 * Returns a new object of class '<em>External Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Function Declaration</em>'.
	 * @generated
	 */
	ExternalFunctionDeclaration createExternalFunctionDeclaration();

	/**
	 * Returns a new object of class '<em>Affine System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Affine System</em>'.
	 * @generated
	 */
	AffineSystem createAffineSystem();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	Type createType();

	/**
	 * Returns a new object of class '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration</em>'.
	 * @generated
	 */
	VariableDeclaration createVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Variable Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Identifier</em>'.
	 * @generated
	 */
	VariableIdentifier createVariableIdentifier();

	/**
	 * Returns a new object of class '<em>Use Equation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Equation</em>'.
	 * @generated
	 */
	UseEquation createUseEquation();

	/**
	 * Returns a new object of class '<em>Standard Equation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Standard Equation</em>'.
	 * @generated
	 */
	StandardEquation createStandardEquation();

	/**
	 * Returns a new object of class '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain</em>'.
	 * @generated
	 */
	Domain createDomain();

	/**
	 * Returns a new object of class '<em>Parameter Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Domain</em>'.
	 * @generated
	 */
	ParameterDomain createParameterDomain();

	/**
	 * Returns a new object of class '<em>Affine Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Affine Function</em>'.
	 * @generated
	 */
	AffineFunction createAffineFunction();

	/**
	 * Returns a new object of class '<em>Fast ISL Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fast ISL Domain</em>'.
	 * @generated
	 */
	FastISLDomain createFastISLDomain();

	/**
	 * Returns a new object of class '<em>Fast ISL Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fast ISL Map</em>'.
	 * @generated
	 */
	FastISLMap createFastISLMap();

	/**
	 * Returns a new object of class '<em>While Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Info</em>'.
	 * @generated
	 */
	WhileInfo createWhileInfo();

	/**
	 * Returns a new object of class '<em>Tiling Informations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tiling Informations</em>'.
	 * @generated
	 */
	TilingInformations createTilingInformations();

	/**
	 * Returns a new object of class '<em>Depth First Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Depth First Visitor</em>'.
	 * @generated
	 */
	PolyhedralIRDepthFirstVisitor createPolyhedralIRDepthFirstVisitor();

	/**
	 * Returns a new object of class '<em>Inherited Depth First Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inherited Depth First Visitor</em>'.
	 * @generated
	 */
	PolyhedralIRInheritedDepthFirstVisitor createPolyhedralIRInheritedDepthFirstVisitor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PolyhedralIRPackage getPolyhedralIRPackage();

} //PolyhedralIRFactory
