/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.scop.annotation.*;
import org.polymodel.scop.annotation.AnnotationFactory;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnnotationFactoryImpl extends EFactoryImpl implements AnnotationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotationFactory init() {
		try {
			AnnotationFactory theAnnotationFactory = (AnnotationFactory)EPackage.Registry.INSTANCE.getEFactory(AnnotationPackage.eNS_URI);
			if (theAnnotationFactory != null) {
				return theAnnotationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnnotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationFactoryImpl() {
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
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION: return createParallelLoopAnnotation();
			case AnnotationPackage.DESCRIPTION_ANNOTATION: return createDescriptionAnnotation();
			case AnnotationPackage.TILE_LOOP_ANNOTATION: return createTileLoopAnnotation();
			case AnnotationPackage.PARALLEL_BLOCK_ANNOTATION: return createParallelBlockAnnotation();
			case AnnotationPackage.POLYHEDRAL_DOMAIN_ANNOTATION: return createPolyhedralDomainAnnotation();
			case AnnotationPackage.BARRIER_ANNOTATION: return createBarrierAnnotation();
			case AnnotationPackage.VECTORIZATION_ANNOTATION: return createVectorizationAnnotation();
			case AnnotationPackage.SINGLE_ANNOTATION: return createSingleAnnotation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelLoopAnnotation createParallelLoopAnnotation() {
		ParallelLoopAnnotationImpl parallelLoopAnnotation = new ParallelLoopAnnotationImpl();
		return parallelLoopAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionAnnotation createDescriptionAnnotation() {
		DescriptionAnnotationImpl descriptionAnnotation = new DescriptionAnnotationImpl();
		return descriptionAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TileLoopAnnotation createTileLoopAnnotation() {
		TileLoopAnnotationImpl tileLoopAnnotation = new TileLoopAnnotationImpl();
		return tileLoopAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelBlockAnnotation createParallelBlockAnnotation() {
		ParallelBlockAnnotationImpl parallelBlockAnnotation = new ParallelBlockAnnotationImpl();
		return parallelBlockAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyhedralDomainAnnotation createPolyhedralDomainAnnotation() {
		PolyhedralDomainAnnotationImpl polyhedralDomainAnnotation = new PolyhedralDomainAnnotationImpl();
		return polyhedralDomainAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BarrierAnnotation createBarrierAnnotation() {
		BarrierAnnotationImpl barrierAnnotation = new BarrierAnnotationImpl();
		return barrierAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VectorizationAnnotation createVectorizationAnnotation() {
		VectorizationAnnotationImpl vectorizationAnnotation = new VectorizationAnnotationImpl();
		return vectorizationAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleAnnotation createSingleAnnotation() {
		SingleAnnotationImpl singleAnnotation = new SingleAnnotationImpl();
		return singleAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationPackage getAnnotationPackage() {
		return (AnnotationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnnotationPackage getPackage() {
		return AnnotationPackage.eINSTANCE;
	}

} //AnnotationFactoryImpl
