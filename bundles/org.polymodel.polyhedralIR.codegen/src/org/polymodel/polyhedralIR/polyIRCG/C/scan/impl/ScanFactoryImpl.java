/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.*;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScanFactoryImpl extends EFactoryImpl implements ScanFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScanFactory init() {
		try {
			ScanFactory theScanFactory = (ScanFactory)EPackage.Registry.INSTANCE.getEFactory(ScanPackage.eNS_URI);
			if (theScanFactory != null) {
				return theScanFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScanFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScanFactoryImpl() {
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
			case ScanPackage.BOUND_COMPUTATION: return createBoundComputation();
			case ScanPackage.VOLUME_FUNCTION: return createVolumeFunction();
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE: return createVolumeFunctionDerivative();
			case ScanPackage.SCAN_BODY: return createScanBody();
			case ScanPackage.ORIGIN_DOMAIN_VOLUME: return createOriginDomainVolume();
			case ScanPackage.SCAN_REDUCTION_BODY: return createScanReductionBody();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundComputation createBoundComputation() {
		BoundComputationImpl boundComputation = new BoundComputationImpl();
		return boundComputation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeFunction createVolumeFunction() {
		VolumeFunctionImpl volumeFunction = new VolumeFunctionImpl();
		return volumeFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeFunctionDerivative createVolumeFunctionDerivative() {
		VolumeFunctionDerivativeImpl volumeFunctionDerivative = new VolumeFunctionDerivativeImpl();
		return volumeFunctionDerivative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScanBody createScanBody() {
		ScanBodyImpl scanBody = new ScanBodyImpl();
		return scanBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OriginDomainVolume createOriginDomainVolume() {
		OriginDomainVolumeImpl originDomainVolume = new OriginDomainVolumeImpl();
		return originDomainVolume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScanReductionBody createScanReductionBody() {
		ScanReductionBodyImpl scanReductionBody = new ScanReductionBodyImpl();
		return scanReductionBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScanPackage getScanPackage() {
		return (ScanPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ScanPackage getPackage() {
		return ScanPackage.eINSTANCE;
	}

} //ScanFactoryImpl
