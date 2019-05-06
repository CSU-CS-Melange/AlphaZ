/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.scop.*;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopDepthFirstVisitor;
import org.polymodel.scop.ScopFactory;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUnscannedDomain;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScopFactoryImpl extends EFactoryImpl implements ScopFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScopFactory init() {
		try {
			ScopFactory theScopFactory = (ScopFactory)EPackage.Registry.INSTANCE.getEFactory(ScopPackage.eNS_URI);
			if (theScopFactory != null) {
				return theScopFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScopFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopFactoryImpl() {
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
			case ScopPackage.SCOP_ROOT: return createScopRoot();
			case ScopPackage.SCOP_FOR: return createScopFor();
			case ScopPackage.SCOP_BLOCK: return createScopBlock();
			case ScopPackage.SCOP_GUARD: return createScopGuard();
			case ScopPackage.SCOP_STATEMENT_MACRO: return createScopStatementMacro();
			case ScopPackage.SCOP_ASSIGNMENT: return createScopAssignment();
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR: return createScopDepthFirstVisitor();
			case ScopPackage.SCOP_UNSCANNED_DOMAIN: return createScopUnscannedDomain();
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
			case ScopPackage.JNIISL_UNION_MAP:
				return createJNIISLUnionMapFromString(eDataType, initialValue);
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
			case ScopPackage.JNIISL_UNION_MAP:
				return convertJNIISLUnionMapToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopRoot createScopRoot() {
		ScopRootImpl scopRoot = new ScopRootImpl();
		return scopRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopFor createScopFor() {
		ScopForImpl scopFor = new ScopForImpl();
		return scopFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopBlock createScopBlock() {
		ScopBlockImpl scopBlock = new ScopBlockImpl();
		return scopBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopGuard createScopGuard() {
		ScopGuardImpl scopGuard = new ScopGuardImpl();
		return scopGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopStatementMacro createScopStatementMacro() {
		ScopStatementMacroImpl scopStatementMacro = new ScopStatementMacroImpl();
		return scopStatementMacro;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopAssignment createScopAssignment() {
		ScopAssignmentImpl scopAssignment = new ScopAssignmentImpl();
		return scopAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopDepthFirstVisitor createScopDepthFirstVisitor() {
		ScopDepthFirstVisitorImpl scopDepthFirstVisitor = new ScopDepthFirstVisitorImpl();
		return scopDepthFirstVisitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopUnscannedDomain createScopUnscannedDomain() {
		ScopUnscannedDomainImpl scopUnscannedDomain = new ScopUnscannedDomainImpl();
		return scopUnscannedDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JNIISLUnionMap createJNIISLUnionMapFromString(EDataType eDataType, String initialValue) {
		return (JNIISLUnionMap)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJNIISLUnionMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopPackage getScopPackage() {
		return (ScopPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ScopPackage getPackage() {
		return ScopPackage.eINSTANCE;
	}

} //ScopFactoryImpl
