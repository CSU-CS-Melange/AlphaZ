/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;
import org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype;

import fr.irisa.cairn.graph.observer.IObservable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage
 * @generated
 */
public class MultidimAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MultidimPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MultidimPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultidimSwitch<Adapter> modelSwitch =
		new MultidimSwitch<Adapter>() {
			@Override
			public Adapter caseNullifiableDependency(NullifiableDependency object) {
				return createNullifiableDependencyAdapter();
			}
			@Override
			public Adapter caseMultidimDependency(MultidimDependency object) {
				return createMultidimDependencyAdapter();
			}
			@Override
			public Adapter caseMultidimSchedulePrototype(MultidimSchedulePrototype object) {
				return createMultidimSchedulePrototypeAdapter();
			}
			@Override
			public Adapter caseScalarSchedulePrototype(ScalarSchedulePrototype object) {
				return createScalarSchedulePrototypeAdapter();
			}
			@Override
			public Adapter caseStatementScalarSchedulePrototype(StatementScalarSchedulePrototype object) {
				return createStatementScalarSchedulePrototypeAdapter();
			}
			@Override
			public Adapter caseChannelScalarSchedulePrototype(ChannelScalarSchedulePrototype object) {
				return createChannelScalarSchedulePrototypeAdapter();
			}
			@Override
			public Adapter caseIObservable(IObservable object) {
				return createIObservableAdapter();
			}
			@Override
			public Adapter caseDependency(Dependency object) {
				return createDependencyAdapter();
			}
			@Override
			public Adapter caseSchedulePrototype(SchedulePrototype object) {
				return createSchedulePrototypeAdapter();
			}
			@Override
			public Adapter caseStatementSchedulePrototype(StatementSchedulePrototype object) {
				return createStatementSchedulePrototypeAdapter();
			}
			@Override
			public Adapter caseChannelSchedulePrototype(ChannelSchedulePrototype object) {
				return createChannelSchedulePrototypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency <em>Nullifiable Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.multidim.NullifiableDependency
	 * @generated
	 */
	public Adapter createNullifiableDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency
	 * @generated
	 */
	public Adapter createMultidimDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype <em>Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype
	 * @generated
	 */
	public Adapter createMultidimSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype <em>Scalar Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype
	 * @generated
	 */
	public Adapter createScalarSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype <em>Statement Scalar Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype
	 * @generated
	 */
	public Adapter createStatementScalarSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype <em>Channel Scalar Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype
	 * @generated
	 */
	public Adapter createChannelScalarSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.irisa.cairn.graph.observer.IObservable <em>IObservable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.irisa.cairn.graph.observer.IObservable
	 * @generated
	 */
	public Adapter createIObservableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.Dependency
	 * @generated
	 */
	public Adapter createDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.SchedulePrototype <em>Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.SchedulePrototype
	 * @generated
	 */
	public Adapter createSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.StatementSchedulePrototype <em>Statement Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.StatementSchedulePrototype
	 * @generated
	 */
	public Adapter createStatementSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype <em>Channel Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype
	 * @generated
	 */
	public Adapter createChannelSchedulePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MultidimAdapterFactory
