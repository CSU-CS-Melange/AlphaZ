/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpFactory
 * @model kind="package"
 * @generated
 */
public interface SimdExpPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simdExp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "simdExp";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simdExp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimdExpPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SIMDExpressionImpl <em>SIMD Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SIMDExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getSIMDExpression()
	 * @generated
	 */
	int SIMD_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_EXPRESSION__VTYPE = 0;

	/**
	 * The number of structural features of the '<em>SIMD Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.BasicMemoryAddressImpl <em>Basic Memory Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.BasicMemoryAddressImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getBasicMemoryAddress()
	 * @generated
	 */
	int BASIC_MEMORY_ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MEMORY_ADDRESS__VAR = 0;

	/**
	 * The feature id for the '<em><b>Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MEMORY_ADDRESS__ACCESS = 1;

	/**
	 * The feature id for the '<em><b>Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MEMORY_ADDRESS__ALIGNED = 2;

	/**
	 * The feature id for the '<em><b>Is Pointer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MEMORY_ADDRESS__IS_POINTER = 3;

	/**
	 * The number of structural features of the '<em>Basic Memory Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MEMORY_ADDRESS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VLoadExpressionImpl <em>VLoad Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VLoadExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVLoadExpression()
	 * @generated
	 */
	int VLOAD_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VLOAD_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Dst</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VLOAD_EXPRESSION__DST = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VLOAD_EXPRESSION__SRC = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VLoad Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VLOAD_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VStoreExpressionImpl <em>VStore Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VStoreExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVStoreExpression()
	 * @generated
	 */
	int VSTORE_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSTORE_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSTORE_EXPRESSION__SRC = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dst</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSTORE_EXPRESSION__DST = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VStore Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSTORE_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VBinaryExpressionImpl <em>VBinary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VBinaryExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVBinaryExpression()
	 * @generated
	 */
	int VBINARY_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VBINARY_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VBINARY_EXPRESSION__OP = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lreg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VBINARY_EXPRESSION__LREG = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rreg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VBINARY_EXPRESSION__RREG = SIMD_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VBinary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VBINARY_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShiftExpressionImpl <em>VShift Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShiftExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVShiftExpression()
	 * @generated
	 */
	int VSHIFT_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHIFT_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Reg1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHIFT_EXPRESSION__REG1 = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reg2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHIFT_EXPRESSION__REG2 = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHIFT_EXPRESSION__DIS = SIMD_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VShift Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHIFT_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VRegisterExpressionImpl <em>VRegister Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VRegisterExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVRegisterExpression()
	 * @generated
	 */
	int VREGISTER_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Reg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_EXPRESSION__REG = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VRegister Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VAssignExpressionImpl <em>VAssign Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VAssignExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVAssignExpression()
	 * @generated
	 */
	int VASSIGN_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VASSIGN_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Lreg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VASSIGN_EXPRESSION__LREG = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rexp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VASSIGN_EXPRESSION__REXP = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VAssign Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VASSIGN_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VSetExpressionImpl <em>VSet Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VSetExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVSetExpression()
	 * @generated
	 */
	int VSET_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSET_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSET_EXPRESSION__VALUES = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VSet Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSET_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VPermuteExpressionImpl <em>VPermute Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VPermuteExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVPermuteExpression()
	 * @generated
	 */
	int VPERMUTE_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPERMUTE_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Reg1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPERMUTE_EXPRESSION__REG1 = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reg2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPERMUTE_EXPRESSION__REG2 = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Imm8</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPERMUTE_EXPRESSION__IMM8 = SIMD_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VPermute Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VPERMUTE_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShuffleExpressionImpl <em>VShuffle Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShuffleExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVShuffleExpression()
	 * @generated
	 */
	int VSHUFFLE_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHUFFLE_EXPRESSION__VTYPE = SIMD_EXPRESSION__VTYPE;

	/**
	 * The feature id for the '<em><b>Reg1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHUFFLE_EXPRESSION__REG1 = SIMD_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reg2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHUFFLE_EXPRESSION__REG2 = SIMD_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Imm8</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHUFFLE_EXPRESSION__IMM8 = SIMD_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VShuffle Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VSHUFFLE_EXPRESSION_FEATURE_COUNT = SIMD_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP <em>VOP</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVOP()
	 * @generated
	 */
	int VOP = 11;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression <em>SIMD Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIMD Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression
	 * @generated
	 */
	EClass getSIMDExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression#getVtype <em>Vtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vtype</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression#getVtype()
	 * @see #getSIMDExpression()
	 * @generated
	 */
	EReference getSIMDExpression_Vtype();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress <em>Basic Memory Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Memory Address</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress
	 * @generated
	 */
	EClass getBasicMemoryAddress();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#getVar()
	 * @see #getBasicMemoryAddress()
	 * @generated
	 */
	EReference getBasicMemoryAddress_Var();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Access</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#getAccess()
	 * @see #getBasicMemoryAddress()
	 * @generated
	 */
	EReference getBasicMemoryAddress_Access();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#isAligned <em>Aligned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aligned</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#isAligned()
	 * @see #getBasicMemoryAddress()
	 * @generated
	 */
	EAttribute getBasicMemoryAddress_Aligned();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#isIsPointer <em>Is Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pointer</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress#isIsPointer()
	 * @see #getBasicMemoryAddress()
	 * @generated
	 */
	EAttribute getBasicMemoryAddress_IsPointer();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression <em>VLoad Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VLoad Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression
	 * @generated
	 */
	EClass getVLoadExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression#getDst <em>Dst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dst</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression#getDst()
	 * @see #getVLoadExpression()
	 * @generated
	 */
	EReference getVLoadExpression_Dst();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression#getSrc()
	 * @see #getVLoadExpression()
	 * @generated
	 */
	EReference getVLoadExpression_Src();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression <em>VStore Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VStore Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression
	 * @generated
	 */
	EClass getVStoreExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression#getSrc()
	 * @see #getVStoreExpression()
	 * @generated
	 */
	EReference getVStoreExpression_Src();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression#getDst <em>Dst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dst</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression#getDst()
	 * @see #getVStoreExpression()
	 * @generated
	 */
	EReference getVStoreExpression_Dst();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression <em>VBinary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VBinary Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression
	 * @generated
	 */
	EClass getVBinaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getOp()
	 * @see #getVBinaryExpression()
	 * @generated
	 */
	EAttribute getVBinaryExpression_Op();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getLreg <em>Lreg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lreg</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getLreg()
	 * @see #getVBinaryExpression()
	 * @generated
	 */
	EReference getVBinaryExpression_Lreg();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getRreg <em>Rreg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rreg</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression#getRreg()
	 * @see #getVBinaryExpression()
	 * @generated
	 */
	EReference getVBinaryExpression_Rreg();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression <em>VShift Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VShift Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression
	 * @generated
	 */
	EClass getVShiftExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getReg1 <em>Reg1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reg1</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getReg1()
	 * @see #getVShiftExpression()
	 * @generated
	 */
	EReference getVShiftExpression_Reg1();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getReg2 <em>Reg2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reg2</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getReg2()
	 * @see #getVShiftExpression()
	 * @generated
	 */
	EReference getVShiftExpression_Reg2();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getDis <em>Dis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dis</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression#getDis()
	 * @see #getVShiftExpression()
	 * @generated
	 */
	EAttribute getVShiftExpression_Dis();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression <em>VRegister Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VRegister Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression
	 * @generated
	 */
	EClass getVRegisterExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression#getReg <em>Reg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reg</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression#getReg()
	 * @see #getVRegisterExpression()
	 * @generated
	 */
	EReference getVRegisterExpression_Reg();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression <em>VAssign Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VAssign Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression
	 * @generated
	 */
	EClass getVAssignExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression#getLreg <em>Lreg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lreg</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression#getLreg()
	 * @see #getVAssignExpression()
	 * @generated
	 */
	EReference getVAssignExpression_Lreg();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression#getRexp <em>Rexp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rexp</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression#getRexp()
	 * @see #getVAssignExpression()
	 * @generated
	 */
	EReference getVAssignExpression_Rexp();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression <em>VSet Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VSet Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression
	 * @generated
	 */
	EClass getVSetExpression();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression#getValues()
	 * @see #getVSetExpression()
	 * @generated
	 */
	EAttribute getVSetExpression_Values();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression <em>VPermute Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VPermute Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression
	 * @generated
	 */
	EClass getVPermuteExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression#getReg1 <em>Reg1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reg1</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression#getReg1()
	 * @see #getVPermuteExpression()
	 * @generated
	 */
	EReference getVPermuteExpression_Reg1();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression#getReg2 <em>Reg2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reg2</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression#getReg2()
	 * @see #getVPermuteExpression()
	 * @generated
	 */
	EReference getVPermuteExpression_Reg2();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression#getImm8 <em>Imm8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imm8</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression#getImm8()
	 * @see #getVPermuteExpression()
	 * @generated
	 */
	EAttribute getVPermuteExpression_Imm8();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression <em>VShuffle Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VShuffle Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression
	 * @generated
	 */
	EClass getVShuffleExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getReg1 <em>Reg1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reg1</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getReg1()
	 * @see #getVShuffleExpression()
	 * @generated
	 */
	EReference getVShuffleExpression_Reg1();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getReg2 <em>Reg2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reg2</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getReg2()
	 * @see #getVShuffleExpression()
	 * @generated
	 */
	EReference getVShuffleExpression_Reg2();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getImm8 <em>Imm8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imm8</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression#getImm8()
	 * @see #getVShuffleExpression()
	 * @generated
	 */
	EAttribute getVShuffleExpression_Imm8();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP <em>VOP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>VOP</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP
	 * @generated
	 */
	EEnum getVOP();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimdExpFactory getSimdExpFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SIMDExpressionImpl <em>SIMD Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SIMDExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getSIMDExpression()
		 * @generated
		 */
		EClass SIMD_EXPRESSION = eINSTANCE.getSIMDExpression();

		/**
		 * The meta object literal for the '<em><b>Vtype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMD_EXPRESSION__VTYPE = eINSTANCE.getSIMDExpression_Vtype();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.BasicMemoryAddressImpl <em>Basic Memory Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.BasicMemoryAddressImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getBasicMemoryAddress()
		 * @generated
		 */
		EClass BASIC_MEMORY_ADDRESS = eINSTANCE.getBasicMemoryAddress();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_MEMORY_ADDRESS__VAR = eINSTANCE.getBasicMemoryAddress_Var();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_MEMORY_ADDRESS__ACCESS = eINSTANCE.getBasicMemoryAddress_Access();

		/**
		 * The meta object literal for the '<em><b>Aligned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_MEMORY_ADDRESS__ALIGNED = eINSTANCE.getBasicMemoryAddress_Aligned();

		/**
		 * The meta object literal for the '<em><b>Is Pointer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_MEMORY_ADDRESS__IS_POINTER = eINSTANCE.getBasicMemoryAddress_IsPointer();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VLoadExpressionImpl <em>VLoad Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VLoadExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVLoadExpression()
		 * @generated
		 */
		EClass VLOAD_EXPRESSION = eINSTANCE.getVLoadExpression();

		/**
		 * The meta object literal for the '<em><b>Dst</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VLOAD_EXPRESSION__DST = eINSTANCE.getVLoadExpression_Dst();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VLOAD_EXPRESSION__SRC = eINSTANCE.getVLoadExpression_Src();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VStoreExpressionImpl <em>VStore Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VStoreExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVStoreExpression()
		 * @generated
		 */
		EClass VSTORE_EXPRESSION = eINSTANCE.getVStoreExpression();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSTORE_EXPRESSION__SRC = eINSTANCE.getVStoreExpression_Src();

		/**
		 * The meta object literal for the '<em><b>Dst</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSTORE_EXPRESSION__DST = eINSTANCE.getVStoreExpression_Dst();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VBinaryExpressionImpl <em>VBinary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VBinaryExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVBinaryExpression()
		 * @generated
		 */
		EClass VBINARY_EXPRESSION = eINSTANCE.getVBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VBINARY_EXPRESSION__OP = eINSTANCE.getVBinaryExpression_Op();

		/**
		 * The meta object literal for the '<em><b>Lreg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VBINARY_EXPRESSION__LREG = eINSTANCE.getVBinaryExpression_Lreg();

		/**
		 * The meta object literal for the '<em><b>Rreg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VBINARY_EXPRESSION__RREG = eINSTANCE.getVBinaryExpression_Rreg();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShiftExpressionImpl <em>VShift Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShiftExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVShiftExpression()
		 * @generated
		 */
		EClass VSHIFT_EXPRESSION = eINSTANCE.getVShiftExpression();

		/**
		 * The meta object literal for the '<em><b>Reg1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSHIFT_EXPRESSION__REG1 = eINSTANCE.getVShiftExpression_Reg1();

		/**
		 * The meta object literal for the '<em><b>Reg2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSHIFT_EXPRESSION__REG2 = eINSTANCE.getVShiftExpression_Reg2();

		/**
		 * The meta object literal for the '<em><b>Dis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VSHIFT_EXPRESSION__DIS = eINSTANCE.getVShiftExpression_Dis();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VRegisterExpressionImpl <em>VRegister Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VRegisterExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVRegisterExpression()
		 * @generated
		 */
		EClass VREGISTER_EXPRESSION = eINSTANCE.getVRegisterExpression();

		/**
		 * The meta object literal for the '<em><b>Reg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREGISTER_EXPRESSION__REG = eINSTANCE.getVRegisterExpression_Reg();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VAssignExpressionImpl <em>VAssign Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VAssignExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVAssignExpression()
		 * @generated
		 */
		EClass VASSIGN_EXPRESSION = eINSTANCE.getVAssignExpression();

		/**
		 * The meta object literal for the '<em><b>Lreg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VASSIGN_EXPRESSION__LREG = eINSTANCE.getVAssignExpression_Lreg();

		/**
		 * The meta object literal for the '<em><b>Rexp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VASSIGN_EXPRESSION__REXP = eINSTANCE.getVAssignExpression_Rexp();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VSetExpressionImpl <em>VSet Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VSetExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVSetExpression()
		 * @generated
		 */
		EClass VSET_EXPRESSION = eINSTANCE.getVSetExpression();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VSET_EXPRESSION__VALUES = eINSTANCE.getVSetExpression_Values();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VPermuteExpressionImpl <em>VPermute Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VPermuteExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVPermuteExpression()
		 * @generated
		 */
		EClass VPERMUTE_EXPRESSION = eINSTANCE.getVPermuteExpression();

		/**
		 * The meta object literal for the '<em><b>Reg1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VPERMUTE_EXPRESSION__REG1 = eINSTANCE.getVPermuteExpression_Reg1();

		/**
		 * The meta object literal for the '<em><b>Reg2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VPERMUTE_EXPRESSION__REG2 = eINSTANCE.getVPermuteExpression_Reg2();

		/**
		 * The meta object literal for the '<em><b>Imm8</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VPERMUTE_EXPRESSION__IMM8 = eINSTANCE.getVPermuteExpression_Imm8();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShuffleExpressionImpl <em>VShuffle Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.VShuffleExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVShuffleExpression()
		 * @generated
		 */
		EClass VSHUFFLE_EXPRESSION = eINSTANCE.getVShuffleExpression();

		/**
		 * The meta object literal for the '<em><b>Reg1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSHUFFLE_EXPRESSION__REG1 = eINSTANCE.getVShuffleExpression_Reg1();

		/**
		 * The meta object literal for the '<em><b>Reg2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VSHUFFLE_EXPRESSION__REG2 = eINSTANCE.getVShuffleExpression_Reg2();

		/**
		 * The meta object literal for the '<em><b>Imm8</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VSHUFFLE_EXPRESSION__IMM8 = eINSTANCE.getVShuffleExpression_Imm8();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP <em>VOP</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl#getVOP()
		 * @generated
		 */
		EEnum VOP = eINSTANCE.getVOP();

	}

} //SimdExpPackage
