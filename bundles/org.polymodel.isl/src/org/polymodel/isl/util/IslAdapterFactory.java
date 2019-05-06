/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.PolymodelVisitable;
import org.polymodel.Relation;
import org.polymodel.isl.ISLBasicMap;
import org.polymodel.isl.ISLFunction;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.ISLPoint;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.ISLUnionMap;
import org.polymodel.isl.ISLUnionSet;
import org.polymodel.isl.IslPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.isl.IslPackage
 * @generated
 */
public class IslAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IslPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IslAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = IslPackage.eINSTANCE;
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
	protected IslSwitch<Adapter> modelSwitch =
		new IslSwitch<Adapter>() {
			@Override
			public Adapter caseISLMap(ISLMap object) {
				return createISLMapAdapter();
			}
			@Override
			public Adapter caseISLSet(ISLSet object) {
				return createISLSetAdapter();
			}
			@Override
			public Adapter caseISLUnionMap(ISLUnionMap object) {
				return createISLUnionMapAdapter();
			}
			@Override
			public Adapter caseISLUnionSet(ISLUnionSet object) {
				return createISLUnionSetAdapter();
			}
			@Override
			public Adapter caseISLBasicMap(ISLBasicMap object) {
				return createISLBasicMapAdapter();
			}
			@Override
			public Adapter caseISLPoint(ISLPoint object) {
				return createISLPointAdapter();
			}
			@Override
			public Adapter caseISLFunction(ISLFunction object) {
				return createISLFunctionAdapter();
			}
			@Override
			public Adapter casePolymodelVisitable(PolymodelVisitable object) {
				return createPolymodelVisitableAdapter();
			}
			@Override
			public Adapter caseAbstractRelation(AbstractRelation object) {
				return createAbstractRelationAdapter();
			}
			@Override
			public Adapter caseRelation(Relation object) {
				return createRelationAdapter();
			}
			@Override
			public Adapter caseDomain(Domain object) {
				return createDomainAdapter();
			}
			@Override
			public Adapter caseBasicRelation(BasicRelation object) {
				return createBasicRelationAdapter();
			}
			@Override
			public Adapter caseFunction(Function object) {
				return createFunctionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.polymodel.isl.ISLMap <em>ISL Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.isl.ISLMap
	 * @generated
	 */
	public Adapter createISLMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.isl.ISLSet <em>ISL Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.isl.ISLSet
	 * @generated
	 */
	public Adapter createISLSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.isl.ISLUnionMap <em>ISL Union Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.isl.ISLUnionMap
	 * @generated
	 */
	public Adapter createISLUnionMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.isl.ISLUnionSet <em>ISL Union Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.isl.ISLUnionSet
	 * @generated
	 */
	public Adapter createISLUnionSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.isl.ISLBasicMap <em>ISL Basic Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.isl.ISLBasicMap
	 * @generated
	 */
	public Adapter createISLBasicMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.isl.ISLPoint <em>ISL Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.isl.ISLPoint
	 * @generated
	 */
	public Adapter createISLPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.isl.ISLFunction <em>ISL Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.isl.ISLFunction
	 * @generated
	 */
	public Adapter createISLFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.PolymodelVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.PolymodelVisitable
	 * @generated
	 */
	public Adapter createPolymodelVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.BasicRelation <em>Basic Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.BasicRelation
	 * @generated
	 */
	public Adapter createBasicRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.AbstractRelation <em>Abstract Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.AbstractRelation
	 * @generated
	 */
	public Adapter createAbstractRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.Relation
	 * @generated
	 */
	public Adapter createRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.Domain
	 * @generated
	 */
	public Adapter createDomainAdapter() {
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

} //IslAdapterFactory
