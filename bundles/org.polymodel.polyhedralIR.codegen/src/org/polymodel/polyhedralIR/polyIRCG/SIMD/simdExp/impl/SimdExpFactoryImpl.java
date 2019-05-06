/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.*;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpFactory;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimdExpFactoryImpl extends EFactoryImpl implements SimdExpFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimdExpFactory init() {
		try {
			SimdExpFactory theSimdExpFactory = (SimdExpFactory)EPackage.Registry.INSTANCE.getEFactory(SimdExpPackage.eNS_URI);
			if (theSimdExpFactory != null) {
				return theSimdExpFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimdExpFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimdExpFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SimdExpPackage.BASIC_MEMORY_ADDRESS: return createBasicMemoryAddress();
			case SimdExpPackage.VLOAD_EXPRESSION: return createVLoadExpression();
			case SimdExpPackage.VSTORE_EXPRESSION: return createVStoreExpression();
			case SimdExpPackage.VBINARY_EXPRESSION: return createVBinaryExpression();
			case SimdExpPackage.VSHIFT_EXPRESSION: return createVShiftExpression();
			case SimdExpPackage.VREGISTER_EXPRESSION: return createVRegisterExpression();
			case SimdExpPackage.VASSIGN_EXPRESSION: return createVAssignExpression();
			case SimdExpPackage.VSET_EXPRESSION: return createVSetExpression();
			case SimdExpPackage.VPERMUTE_EXPRESSION: return createVPermuteExpression();
			case SimdExpPackage.VSHUFFLE_EXPRESSION: return createVShuffleExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SimdExpPackage.VOP:
				return createVOPFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SimdExpPackage.VOP:
				return convertVOPToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicMemoryAddress createBasicMemoryAddress() {
		BasicMemoryAddressImpl basicMemoryAddress = new BasicMemoryAddressImpl();
		return basicMemoryAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VLoadExpression createVLoadExpression() {
		VLoadExpressionImpl vLoadExpression = new VLoadExpressionImpl();
		return vLoadExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VStoreExpression createVStoreExpression() {
		VStoreExpressionImpl vStoreExpression = new VStoreExpressionImpl();
		return vStoreExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VBinaryExpression createVBinaryExpression() {
		VBinaryExpressionImpl vBinaryExpression = new VBinaryExpressionImpl();
		return vBinaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VShiftExpression createVShiftExpression() {
		VShiftExpressionImpl vShiftExpression = new VShiftExpressionImpl();
		return vShiftExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRegisterExpression createVRegisterExpression() {
		VRegisterExpressionImpl vRegisterExpression = new VRegisterExpressionImpl();
		return vRegisterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VAssignExpression createVAssignExpression() {
		VAssignExpressionImpl vAssignExpression = new VAssignExpressionImpl();
		return vAssignExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VSetExpression createVSetExpression() {
		VSetExpressionImpl vSetExpression = new VSetExpressionImpl();
		return vSetExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VPermuteExpression createVPermuteExpression() {
		VPermuteExpressionImpl vPermuteExpression = new VPermuteExpressionImpl();
		return vPermuteExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VShuffleExpression createVShuffleExpression() {
		VShuffleExpressionImpl vShuffleExpression = new VShuffleExpressionImpl();
		return vShuffleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VOP createVOPFromString(EDataType eDataType, String initialValue) {
		VOP result = VOP.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVOPToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimdExpPackage getSimdExpPackage() {
		return (SimdExpPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimdExpPackage getPackage() {
		return SimdExpPackage.eINSTANCE;
	}

} //SimdExpFactoryImpl
