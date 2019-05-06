/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.isl.ISLBasicMap;
import org.polymodel.isl.ISLFunction;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.ISLPoint;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.ISLUnionMap;
import org.polymodel.isl.ISLUnionSet;
import org.polymodel.isl.IslFactory;
import org.polymodel.isl.IslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IslFactoryImpl extends EFactoryImpl implements IslFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IslFactory init() {
		try {
			IslFactory theIslFactory = (IslFactory)EPackage.Registry.INSTANCE.getEFactory(IslPackage.eNS_URI);
			if (theIslFactory != null) {
				return theIslFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IslFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IslFactoryImpl() {
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
			case IslPackage.ISL_MAP: return createISLMap();
			case IslPackage.ISL_SET: return createISLSet();
			case IslPackage.ISL_UNION_MAP: return createISLUnionMap();
			case IslPackage.ISL_UNION_SET: return createISLUnionSet();
			case IslPackage.ISL_BASIC_MAP: return createISLBasicMap();
			case IslPackage.ISL_POINT: return createISLPoint();
			case IslPackage.ISL_FUNCTION: return createISLFunction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISLMap createISLMap() {
		ISLMapImpl islMap = new ISLMapImpl();
		return islMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISLSet createISLSet() {
		ISLSetImpl islSet = new ISLSetImpl();
		return islSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISLUnionMap createISLUnionMap() {
		ISLUnionMapImpl islUnionMap = new ISLUnionMapImpl();
		return islUnionMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISLUnionSet createISLUnionSet() {
		ISLUnionSetImpl islUnionSet = new ISLUnionSetImpl();
		return islUnionSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISLBasicMap createISLBasicMap() {
		ISLBasicMapImpl islBasicMap = new ISLBasicMapImpl();
		return islBasicMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISLPoint createISLPoint() {
		ISLPointImpl islPoint = new ISLPointImpl();
		return islPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISLFunction createISLFunction() {
		ISLFunctionImpl islFunction = new ISLFunctionImpl();
		return islFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IslPackage getIslPackage() {
		return (IslPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IslPackage getPackage() {
		return IslPackage.eINSTANCE;
	}

} //IslFactoryImpl
