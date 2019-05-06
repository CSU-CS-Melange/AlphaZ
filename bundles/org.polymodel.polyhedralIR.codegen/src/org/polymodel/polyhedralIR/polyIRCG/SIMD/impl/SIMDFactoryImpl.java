/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.*;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFactory;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SIMDFactoryImpl extends EFactoryImpl implements SIMDFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SIMDFactory init() {
		try {
			SIMDFactory theSIMDFactory = (SIMDFactory)EPackage.Registry.INSTANCE.getEFactory(SIMDPackage.eNS_URI);
			if (theSIMDFactory != null) {
				return theSIMDFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SIMDFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDFactoryImpl() {
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
			case SIMDPackage.VTYPE: return createVType();
			case SIMDPackage.VREGISTER: return createVRegister();
			case SIMDPackage.VREGISTER_INITIALIZATION: return createVRegisterInitialization();
			case SIMDPackage.SIMD_STATEMENT: return createSIMDStatement();
			case SIMDPackage.VREG_FUNCTION_PARAMETER: return createVRegFunctionParameter();
			case SIMDPackage.SIMD_FUNCTION: return createSIMDFunction();
			case SIMDPackage.TILED_SIMDC_LOOP: return createTiledSIMDCLoop();
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
			case SIMDPackage.SIMD_WIDTH:
				return createSIMD_WIDTHFromString(eDataType, initialValue);
			case SIMDPackage.SIMD_INS:
				return createSIMD_INSFromString(eDataType, initialValue);
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
			case SIMDPackage.SIMD_WIDTH:
				return convertSIMD_WIDTHToString(eDataType, instanceValue);
			case SIMDPackage.SIMD_INS:
				return convertSIMD_INSToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType createVType() {
		VTypeImpl vType = new VTypeImpl();
		return vType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRegister createVRegister() {
		VRegisterImpl vRegister = new VRegisterImpl();
		return vRegister;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRegisterInitialization createVRegisterInitialization() {
		VRegisterInitializationImpl vRegisterInitialization = new VRegisterInitializationImpl();
		return vRegisterInitialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDStatement createSIMDStatement() {
		SIMDStatementImpl simdStatement = new SIMDStatementImpl();
		return simdStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VRegFunctionParameter createVRegFunctionParameter() {
		VRegFunctionParameterImpl vRegFunctionParameter = new VRegFunctionParameterImpl();
		return vRegFunctionParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDFunction createSIMDFunction() {
		SIMDFunctionImpl simdFunction = new SIMDFunctionImpl();
		return simdFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TiledSIMDCLoop createTiledSIMDCLoop() {
		TiledSIMDCLoopImpl tiledSIMDCLoop = new TiledSIMDCLoopImpl();
		return tiledSIMDCLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMD_WIDTH createSIMD_WIDTHFromString(EDataType eDataType, String initialValue) {
		SIMD_WIDTH result = SIMD_WIDTH.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSIMD_WIDTHToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMD_INS createSIMD_INSFromString(EDataType eDataType, String initialValue) {
		SIMD_INS result = SIMD_INS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSIMD_INSToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDPackage getSIMDPackage() {
		return (SIMDPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SIMDPackage getPackage() {
		return SIMDPackage.eINSTANCE;
	}

} //SIMDFactoryImpl
