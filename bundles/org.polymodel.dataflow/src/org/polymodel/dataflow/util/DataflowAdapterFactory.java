/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADASolution;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.Access;
import org.polymodel.dataflow.DataflowPackage;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.ResolvedAccess;
import org.polymodel.dataflow.WriteAccess;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.dataflow.DataflowPackage
 * @generated
 */
public class DataflowAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataflowPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataflowAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DataflowPackage.eINSTANCE;
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
	protected DataflowSwitch<Adapter> modelSwitch =
		new DataflowSwitch<Adapter>() {
			@Override
			public Adapter caseADAInput(ADAInput object) {
				return createADAInputAdapter();
			}
			@Override
			public Adapter caseADAStatement(ADAStatement object) {
				return createADAStatementAdapter();
			}
			@Override
			public Adapter caseAccess(Access object) {
				return createAccessAdapter();
			}
			@Override
			public Adapter caseReadAccess(ReadAccess object) {
				return createReadAccessAdapter();
			}
			@Override
			public Adapter caseWriteAccess(WriteAccess object) {
				return createWriteAccessAdapter();
			}
			@Override
			public Adapter caseADASolution(ADASolution object) {
				return createADASolutionAdapter();
			}
			@Override
			public Adapter caseResolvedAccess(ResolvedAccess object) {
				return createResolvedAccessAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.polymodel.dataflow.ADAInput <em>ADA Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.dataflow.ADAInput
	 * @generated
	 */
	public Adapter createADAInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.dataflow.ADAStatement <em>ADA Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.dataflow.ADAStatement
	 * @generated
	 */
	public Adapter createADAStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.dataflow.ReadAccess <em>Read Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.dataflow.ReadAccess
	 * @generated
	 */
	public Adapter createReadAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.dataflow.WriteAccess <em>Write Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.dataflow.WriteAccess
	 * @generated
	 */
	public Adapter createWriteAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.dataflow.ADASolution <em>ADA Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.dataflow.ADASolution
	 * @generated
	 */
	public Adapter createADASolutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.dataflow.Access <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.dataflow.Access
	 * @generated
	 */
	public Adapter createAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.dataflow.ResolvedAccess <em>Resolved Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.dataflow.ResolvedAccess
	 * @generated
	 */
	public Adapter createResolvedAccessAdapter() {
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

} //DataflowAdapterFactory
