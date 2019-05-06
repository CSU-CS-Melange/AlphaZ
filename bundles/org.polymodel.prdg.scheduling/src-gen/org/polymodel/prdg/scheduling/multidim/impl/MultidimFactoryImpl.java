/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.multidim.MultidimFactory;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;
import org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultidimFactoryImpl extends EFactoryImpl implements MultidimFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MultidimFactory init() {
		try {
			MultidimFactory theMultidimFactory = (MultidimFactory)EPackage.Registry.INSTANCE.getEFactory(MultidimPackage.eNS_URI);
			if (theMultidimFactory != null) {
				return theMultidimFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MultidimFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimFactoryImpl() {
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
			case MultidimPackage.NULLIFIABLE_DEPENDENCY: return createNullifiableDependency();
			case MultidimPackage.MULTIDIM_DEPENDENCY: return createMultidimDependency();
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE: return createMultidimSchedulePrototype();
			case MultidimPackage.STATEMENT_SCALAR_SCHEDULE_PROTOTYPE: return createStatementScalarSchedulePrototype();
			case MultidimPackage.CHANNEL_SCALAR_SCHEDULE_PROTOTYPE: return createChannelScalarSchedulePrototype();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullifiableDependency createNullifiableDependency() {
		NullifiableDependencyImpl nullifiableDependency = new NullifiableDependencyImpl();
		return nullifiableDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimDependency createMultidimDependency() {
		MultidimDependencyImpl multidimDependency = new MultidimDependencyImpl();
		return multidimDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimSchedulePrototype createMultidimSchedulePrototype() {
		MultidimSchedulePrototypeImpl multidimSchedulePrototype = new MultidimSchedulePrototypeImpl();
		return multidimSchedulePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementScalarSchedulePrototype createStatementScalarSchedulePrototype() {
		StatementScalarSchedulePrototypeImpl statementScalarSchedulePrototype = new StatementScalarSchedulePrototypeImpl();
		return statementScalarSchedulePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelScalarSchedulePrototype createChannelScalarSchedulePrototype() {
		ChannelScalarSchedulePrototypeImpl channelScalarSchedulePrototype = new ChannelScalarSchedulePrototypeImpl();
		return channelScalarSchedulePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimPackage getMultidimPackage() {
		return (MultidimPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MultidimPackage getPackage() {
		return MultidimPackage.eINSTANCE;
	}

} //MultidimFactoryImpl
