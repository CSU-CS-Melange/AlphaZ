/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.dataflow.ADASolution;
import org.polymodel.dataflow.DataflowFactory;
import org.polymodel.dataflow.DataflowPackage;
import org.polymodel.dataflow.ResolvedAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataflowFactoryImpl extends EFactoryImpl implements DataflowFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataflowFactory init() {
		try {
			DataflowFactory theDataflowFactory = (DataflowFactory)EPackage.Registry.INSTANCE.getEFactory(DataflowPackage.eNS_URI);
			if (theDataflowFactory != null) {
				return theDataflowFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataflowFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataflowFactoryImpl() {
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
			case DataflowPackage.ADA_SOLUTION: return createADASolution();
			case DataflowPackage.RESOLVED_ACCESS: return createResolvedAccess();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ADASolution createADASolution() {
		ADASolutionImpl adaSolution = new ADASolutionImpl();
		return adaSolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolvedAccess createResolvedAccess() {
		ResolvedAccessImpl resolvedAccess = new ResolvedAccessImpl();
		return resolvedAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataflowPackage getDataflowPackage() {
		return (DataflowPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataflowPackage getPackage() {
		return DataflowPackage.eINSTANCE;
	}

} //DataflowFactoryImpl
