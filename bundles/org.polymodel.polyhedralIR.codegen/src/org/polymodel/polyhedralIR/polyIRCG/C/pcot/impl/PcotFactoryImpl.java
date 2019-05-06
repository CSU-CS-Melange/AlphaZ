/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polymodel.polyhedralIR.polyIRCG.C.pcot.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PcotFactoryImpl extends EFactoryImpl implements PcotFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PcotFactory init() {
		try {
			PcotFactory thePcotFactory = (PcotFactory)EPackage.Registry.INSTANCE.getEFactory(PcotPackage.eNS_URI);
			if (thePcotFactory != null) {
				return thePcotFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PcotFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcotFactoryImpl() {
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
			case PcotPackage.PCO_TRECURSION: return createPCOTrecursion();
			case PcotPackage.PCO_TBASE: return createPCOTbase();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCOTrecursion createPCOTrecursion() {
		PCOTrecursionImpl pcoTrecursion = new PCOTrecursionImpl();
		return pcoTrecursion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCOTbase createPCOTbase() {
		PCOTbaseImpl pcoTbase = new PCOTbaseImpl();
		return pcoTbase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PcotPackage getPcotPackage() {
		return (PcotPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PcotPackage getPackage() {
		return PcotPackage.eINSTANCE;
	}

} //PcotFactoryImpl
