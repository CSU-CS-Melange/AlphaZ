/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffinePackage;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage
 * @generated
 */
public class QuasiAffineAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QuasiAffinePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuasiAffineAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QuasiAffinePackage.eINSTANCE;
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
	protected QuasiAffineSwitch<Adapter> modelSwitch =
		new QuasiAffineSwitch<Adapter>() {
			@Override
			public Adapter caseQuasiAffineExpression(QuasiAffineExpression object) {
				return createQuasiAffineExpressionAdapter();
			}
			@Override
			public Adapter caseQuasiAffineTerm(QuasiAffineTerm object) {
				return createQuasiAffineTermAdapter();
			}
			@Override
			public Adapter caseSimpleQuasiAffineTerm(SimpleQuasiAffineTerm object) {
				return createSimpleQuasiAffineTermAdapter();
			}
			@Override
			public Adapter caseNestedQuasiAffineTerm(NestedQuasiAffineTerm object) {
				return createNestedQuasiAffineTermAdapter();
			}
			@Override
			public Adapter caseAlgebraVisitable(AlgebraVisitable object) {
				return createAlgebraVisitableAdapter();
			}
			@Override
			public Adapter caseIntExpression(IntExpression object) {
				return createIntExpressionAdapter();
			}
			@Override
			public Adapter caseIntTerm(IntTerm object) {
				return createIntTermAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.quasiAffine.QuasiAffineExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineExpression
	 * @generated
	 */
	public Adapter createQuasiAffineExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.quasiAffine.QuasiAffineTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineTerm
	 * @generated
	 */
	public Adapter createQuasiAffineTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm <em>Simple Quasi Affine Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm
	 * @generated
	 */
	public Adapter createSimpleQuasiAffineTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm <em>Nested Quasi Affine Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm
	 * @generated
	 */
	public Adapter createNestedQuasiAffineTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.AlgebraVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.AlgebraVisitable
	 * @generated
	 */
	public Adapter createAlgebraVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.IntExpression <em>Int Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.IntExpression
	 * @generated
	 */
	public Adapter createIntExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.algebra.IntTerm <em>Int Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.algebra.IntTerm
	 * @generated
	 */
	public Adapter createIntTermAdapter() {
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

} //QuasiAffineAdapterFactory
