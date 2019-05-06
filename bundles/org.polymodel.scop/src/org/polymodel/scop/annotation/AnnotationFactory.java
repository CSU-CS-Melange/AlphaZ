/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.scop.annotation.AnnotationPackage
 * @generated
 */
public interface AnnotationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnnotationFactory eINSTANCE = org.polymodel.scop.annotation.impl.AnnotationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Parallel Loop Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel Loop Annotation</em>'.
	 * @generated
	 */
	ParallelLoopAnnotation createParallelLoopAnnotation();

	/**
	 * Returns a new object of class '<em>Description Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description Annotation</em>'.
	 * @generated
	 */
	DescriptionAnnotation createDescriptionAnnotation();

	/**
	 * Returns a new object of class '<em>Tile Loop Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tile Loop Annotation</em>'.
	 * @generated
	 */
	TileLoopAnnotation createTileLoopAnnotation();

	/**
	 * Returns a new object of class '<em>Parallel Block Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel Block Annotation</em>'.
	 * @generated
	 */
	ParallelBlockAnnotation createParallelBlockAnnotation();

	/**
	 * Returns a new object of class '<em>Polyhedral Domain Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Polyhedral Domain Annotation</em>'.
	 * @generated
	 */
	PolyhedralDomainAnnotation createPolyhedralDomainAnnotation();

	/**
	 * Returns a new object of class '<em>Barrier Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Barrier Annotation</em>'.
	 * @generated
	 */
	BarrierAnnotation createBarrierAnnotation();

	/**
	 * Returns a new object of class '<em>Vectorization Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vectorization Annotation</em>'.
	 * @generated
	 */
	VectorizationAnnotation createVectorizationAnnotation();

	/**
	 * Returns a new object of class '<em>Single Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Annotation</em>'.
	 * @generated
	 */
	SingleAnnotation createSingleAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnnotationPackage getAnnotationPackage();

} //AnnotationFactory
