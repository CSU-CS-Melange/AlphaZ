/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.annotation.*;
import org.polymodel.scop.annotation.AnnotationPackage;
import org.polymodel.scop.annotation.BarrierAnnotation;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.annotation.ParallelBlockAnnotation;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.annotation.PolyhedralDomainAnnotation;
import org.polymodel.scop.annotation.SingleAnnotation;
import org.polymodel.scop.annotation.TileLoopAnnotation;
import org.polymodel.scop.annotation.VectorizationAnnotation;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.scop.annotation.AnnotationPackage
 * @generated
 */
public class AnnotationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnnotationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AnnotationPackage.eINSTANCE;
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
	protected AnnotationSwitch<Adapter> modelSwitch =
		new AnnotationSwitch<Adapter>() {
			@Override
			public Adapter caseParallelLoopAnnotation(ParallelLoopAnnotation object) {
				return createParallelLoopAnnotationAdapter();
			}
			@Override
			public Adapter caseDescriptionAnnotation(DescriptionAnnotation object) {
				return createDescriptionAnnotationAdapter();
			}
			@Override
			public Adapter caseTileLoopAnnotation(TileLoopAnnotation object) {
				return createTileLoopAnnotationAdapter();
			}
			@Override
			public Adapter caseParallelBlockAnnotation(ParallelBlockAnnotation object) {
				return createParallelBlockAnnotationAdapter();
			}
			@Override
			public Adapter casePolyhedralDomainAnnotation(PolyhedralDomainAnnotation object) {
				return createPolyhedralDomainAnnotationAdapter();
			}
			@Override
			public Adapter caseBarrierAnnotation(BarrierAnnotation object) {
				return createBarrierAnnotationAdapter();
			}
			@Override
			public Adapter caseVectorizationAnnotation(VectorizationAnnotation object) {
				return createVectorizationAnnotationAdapter();
			}
			@Override
			public Adapter caseSingleAnnotation(SingleAnnotation object) {
				return createSingleAnnotationAdapter();
			}
			@Override
			public Adapter caseScopVisitable(ScopVisitable object) {
				return createScopVisitableAdapter();
			}
			@Override
			public Adapter caseIScopAnnotation(IScopAnnotation object) {
				return createIScopAnnotationAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.annotation.ParallelLoopAnnotation <em>Parallel Loop Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.annotation.ParallelLoopAnnotation
	 * @generated
	 */
	public Adapter createParallelLoopAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.annotation.DescriptionAnnotation <em>Description Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.annotation.DescriptionAnnotation
	 * @generated
	 */
	public Adapter createDescriptionAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.annotation.TileLoopAnnotation <em>Tile Loop Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.annotation.TileLoopAnnotation
	 * @generated
	 */
	public Adapter createTileLoopAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.annotation.ParallelBlockAnnotation <em>Parallel Block Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.annotation.ParallelBlockAnnotation
	 * @generated
	 */
	public Adapter createParallelBlockAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.annotation.PolyhedralDomainAnnotation <em>Polyhedral Domain Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.annotation.PolyhedralDomainAnnotation
	 * @generated
	 */
	public Adapter createPolyhedralDomainAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.annotation.BarrierAnnotation <em>Barrier Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.annotation.BarrierAnnotation
	 * @generated
	 */
	public Adapter createBarrierAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.annotation.VectorizationAnnotation <em>Vectorization Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.annotation.VectorizationAnnotation
	 * @generated
	 */
	public Adapter createVectorizationAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.annotation.SingleAnnotation <em>Single Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.annotation.SingleAnnotation
	 * @generated
	 */
	public Adapter createSingleAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopVisitable
	 * @generated
	 */
	public Adapter createScopVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.IScopAnnotation <em>IScop Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.IScopAnnotation
	 * @generated
	 */
	public Adapter createIScopAnnotationAdapter() {
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

} //AnnotationAdapterFactory
