/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.prdg.scheduling.EdgeDependency;
import org.polymodel.prdg.scheduling.ScheduleCoefficient;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.SchedulingFactory;
import org.polymodel.prdg.scheduling.SchedulingPackage;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulingFactoryImpl extends EFactoryImpl implements SchedulingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SchedulingFactory init() {
		try {
			SchedulingFactory theSchedulingFactory = (SchedulingFactory)EPackage.Registry.INSTANCE.getEFactory(SchedulingPackage.eNS_URI);
			if (theSchedulingFactory != null) {
				return theSchedulingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SchedulingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingFactoryImpl() {
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
			case SchedulingPackage.SCHEDULED_STATEMENT: return createScheduledStatement();
			case SchedulingPackage.SCHEDULE_TERM: return createScheduleTerm();
			case SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE: return createStatementSchedulePrototype();
			case SchedulingPackage.EDGE_DEPENDENCY: return createEdgeDependency();
			case SchedulingPackage.SCHEDULE_COEFFICIENT: return createScheduleCoefficient();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduledStatement createScheduledStatement() {
		ScheduledStatementImpl scheduledStatement = new ScheduledStatementImpl();
		return scheduledStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleTerm createScheduleTerm() {
		ScheduleTermImpl scheduleTerm = new ScheduleTermImpl();
		return scheduleTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementSchedulePrototype createStatementSchedulePrototype() {
		StatementSchedulePrototypeImpl statementSchedulePrototype = new StatementSchedulePrototypeImpl();
		return statementSchedulePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeDependency createEdgeDependency() {
		EdgeDependencyImpl edgeDependency = new EdgeDependencyImpl();
		return edgeDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleCoefficient createScheduleCoefficient() {
		ScheduleCoefficientImpl scheduleCoefficient = new ScheduleCoefficientImpl();
		return scheduleCoefficient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPackage getSchedulingPackage() {
		return (SchedulingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SchedulingPackage getPackage() {
		return SchedulingPackage.eINSTANCE;
	}

} //SchedulingFactoryImpl
