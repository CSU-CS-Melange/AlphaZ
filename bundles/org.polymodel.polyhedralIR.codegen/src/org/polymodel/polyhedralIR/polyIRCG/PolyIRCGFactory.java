/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage
 * @generated
 */
public interface PolyIRCGFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PolyIRCGFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compilation Unit</em>'.
	 * @generated
	 */
	CompilationUnit createCompilationUnit();

	/**
	 * Returns a new object of class '<em>Code Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Unit</em>'.
	 * @generated
	 */
	CodeUnit createCodeUnit();

	/**
	 * Returns a new object of class '<em>Basic Code Unit Header</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Code Unit Header</em>'.
	 * @generated
	 */
	BasicCodeUnitHeader createBasicCodeUnitHeader();

	/**
	 * Returns a new object of class '<em>Declare Structs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declare Structs</em>'.
	 * @generated
	 */
	DeclareStructs createDeclareStructs();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>Basic Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Body</em>'.
	 * @generated
	 */
	BasicBody createBasicBody();

	/**
	 * Returns a new object of class '<em>Variable Initialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Initialization</em>'.
	 * @generated
	 */
	VariableInitialization createVariableInitialization();

	/**
	 * Returns a new object of class '<em>Flag Variable Reset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flag Variable Reset</em>'.
	 * @generated
	 */
	FlagVariableReset createFlagVariableReset();

	/**
	 * Returns a new object of class '<em>Variable Finalization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Finalization</em>'.
	 * @generated
	 */
	VariableFinalization createVariableFinalization();

	/**
	 * Returns a new object of class '<em>Pack Struct</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pack Struct</em>'.
	 * @generated
	 */
	PackStruct createPackStruct();

	/**
	 * Returns a new object of class '<em>Custom Pack Struct</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Pack Struct</em>'.
	 * @generated
	 */
	CustomPackStruct createCustomPackStruct();

	/**
	 * Returns a new object of class '<em>Unpack Struct</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unpack Struct</em>'.
	 * @generated
	 */
	UnpackStruct createUnpackStruct();

	/**
	 * Returns a new object of class '<em>Function Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Signature</em>'.
	 * @generated
	 */
	FunctionSignature createFunctionSignature();

	/**
	 * Returns a new object of class '<em>Struct</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Struct</em>'.
	 * @generated
	 */
	Struct createStruct();

	/**
	 * Returns a new object of class '<em>Variable Function Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Function Parameter</em>'.
	 * @generated
	 */
	VariableFunctionParameter createVariableFunctionParameter();

	/**
	 * Returns a new object of class '<em>Basic Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Variable</em>'.
	 * @generated
	 */
	BasicVariable createBasicVariable();

	/**
	 * Returns a new object of class '<em>Code Gen Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Gen Variable</em>'.
	 * @generated
	 */
	CodeGenVariable createCodeGenVariable();

	/**
	 * Returns a new object of class '<em>Scalar Memory Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Memory Domain</em>'.
	 * @generated
	 */
	ScalarMemoryDomain createScalarMemoryDomain();

	/**
	 * Returns a new object of class '<em>Merged Memory Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Merged Memory Domain</em>'.
	 * @generated
	 */
	MergedMemoryDomain createMergedMemoryDomain();

	/**
	 * Returns a new object of class '<em>Pseudo Projection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pseudo Projection</em>'.
	 * @generated
	 */
	PseudoProjection createPseudoProjection();

	/**
	 * Returns a new object of class '<em>Basic Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Statement</em>'.
	 * @generated
	 */
	BasicStatement createBasicStatement();

	/**
	 * Returns a new object of class '<em>Pseudo Projective Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pseudo Projective Access Expression</em>'.
	 * @generated
	 */
	PseudoProjectiveAccessExpression createPseudoProjectiveAccessExpression();

	/**
	 * Returns a new object of class '<em>Identity Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identity Access Expression</em>'.
	 * @generated
	 */
	IdentityAccessExpression createIdentityAccessExpression();

	/**
	 * Returns a new object of class '<em>Merged Domain Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Merged Domain Access Expression</em>'.
	 * @generated
	 */
	MergedDomainAccessExpression createMergedDomainAccessExpression();

	/**
	 * Returns a new object of class '<em>Compile Time Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compile Time Parameter</em>'.
	 * @generated
	 */
	CompileTimeParameter createCompileTimeParameter();

	/**
	 * Returns a new object of class '<em>Custom Provider Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Provider Statement</em>'.
	 * @generated
	 */
	CustomProviderStatement createCustomProviderStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PolyIRCGPackage getPolyIRCGPackage();

} //PolyIRCGFactory
