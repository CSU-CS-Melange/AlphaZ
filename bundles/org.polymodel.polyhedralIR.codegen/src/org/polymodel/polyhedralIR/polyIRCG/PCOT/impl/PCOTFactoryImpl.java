/**
 */
package org.polymodel.polyhedralIR.polyIRCG.PCOT.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.*;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTFactory;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PCOTFactoryImpl extends EFactoryImpl implements PCOTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PCOTFactory init() {
		try {
			PCOTFactory thePCOTFactory = (PCOTFactory)EPackage.Registry.INSTANCE.getEFactory(PCOTPackage.eNS_URI);
			if (thePCOTFactory != null) {
				return thePCOTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PCOTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCOTFactoryImpl() {
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
			case PCOTPackage.RECURSION_BODY: return createRecursionBody();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecursionBody createRecursionBody() {
		RecursionBodyImpl recursionBody = new RecursionBodyImpl();
		return recursionBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCOTPackage getPCOTPackage() {
		return (PCOTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PCOTPackage getPackage() {
		return PCOTPackage.eINSTANCE;
	}

} //PCOTFactoryImpl
