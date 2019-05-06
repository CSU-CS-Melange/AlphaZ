/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.*;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CWrapperFactoryImpl extends EFactoryImpl implements CWrapperFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CWrapperFactory init() {
		try {
			CWrapperFactory theCWrapperFactory = (CWrapperFactory)EPackage.Registry.INSTANCE.getEFactory(CWrapperPackage.eNS_URI);
			if (theCWrapperFactory != null) {
				return theCWrapperFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CWrapperFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CWrapperFactoryImpl() {
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
			case CWrapperPackage.INPUT_INITIALIZATION: return createInputInitialization();
			case CWrapperPackage.OUTPUT_PRINTING: return createOutputPrinting();
			case CWrapperPackage.OUTPUT_VERIFICATION: return createOutputVerification();
			case CWrapperPackage.SPECIAL_VARIABLE: return createSpecialVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputInitialization createInputInitialization() {
		InputInitializationImpl inputInitialization = new InputInitializationImpl();
		return inputInitialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPrinting createOutputPrinting() {
		OutputPrintingImpl outputPrinting = new OutputPrintingImpl();
		return outputPrinting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVerification createOutputVerification() {
		OutputVerificationImpl outputVerification = new OutputVerificationImpl();
		return outputVerification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialVariable createSpecialVariable() {
		SpecialVariableImpl specialVariable = new SpecialVariableImpl();
		return specialVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CWrapperPackage getCWrapperPackage() {
		return (CWrapperPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CWrapperPackage getPackage() {
		return CWrapperPackage.eINSTANCE;
	}

} //CWrapperFactoryImpl
