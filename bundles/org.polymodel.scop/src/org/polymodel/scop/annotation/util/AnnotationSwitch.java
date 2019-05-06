/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polymodel.scop.annotation.AnnotationPackage
 * @generated
 */
public class AnnotationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnnotationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationSwitch() {
		if (modelPackage == null) {
			modelPackage = AnnotationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION: {
				ParallelLoopAnnotation parallelLoopAnnotation = (ParallelLoopAnnotation)theEObject;
				T result = caseParallelLoopAnnotation(parallelLoopAnnotation);
				if (result == null) result = caseIScopAnnotation(parallelLoopAnnotation);
				if (result == null) result = caseScopVisitable(parallelLoopAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotationPackage.DESCRIPTION_ANNOTATION: {
				DescriptionAnnotation descriptionAnnotation = (DescriptionAnnotation)theEObject;
				T result = caseDescriptionAnnotation(descriptionAnnotation);
				if (result == null) result = caseIScopAnnotation(descriptionAnnotation);
				if (result == null) result = caseScopVisitable(descriptionAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotationPackage.TILE_LOOP_ANNOTATION: {
				TileLoopAnnotation tileLoopAnnotation = (TileLoopAnnotation)theEObject;
				T result = caseTileLoopAnnotation(tileLoopAnnotation);
				if (result == null) result = caseIScopAnnotation(tileLoopAnnotation);
				if (result == null) result = caseScopVisitable(tileLoopAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotationPackage.PARALLEL_BLOCK_ANNOTATION: {
				ParallelBlockAnnotation parallelBlockAnnotation = (ParallelBlockAnnotation)theEObject;
				T result = caseParallelBlockAnnotation(parallelBlockAnnotation);
				if (result == null) result = caseIScopAnnotation(parallelBlockAnnotation);
				if (result == null) result = caseScopVisitable(parallelBlockAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotationPackage.POLYHEDRAL_DOMAIN_ANNOTATION: {
				PolyhedralDomainAnnotation polyhedralDomainAnnotation = (PolyhedralDomainAnnotation)theEObject;
				T result = casePolyhedralDomainAnnotation(polyhedralDomainAnnotation);
				if (result == null) result = caseIScopAnnotation(polyhedralDomainAnnotation);
				if (result == null) result = caseScopVisitable(polyhedralDomainAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotationPackage.BARRIER_ANNOTATION: {
				BarrierAnnotation barrierAnnotation = (BarrierAnnotation)theEObject;
				T result = caseBarrierAnnotation(barrierAnnotation);
				if (result == null) result = caseIScopAnnotation(barrierAnnotation);
				if (result == null) result = caseScopVisitable(barrierAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotationPackage.VECTORIZATION_ANNOTATION: {
				VectorizationAnnotation vectorizationAnnotation = (VectorizationAnnotation)theEObject;
				T result = caseVectorizationAnnotation(vectorizationAnnotation);
				if (result == null) result = caseIScopAnnotation(vectorizationAnnotation);
				if (result == null) result = caseScopVisitable(vectorizationAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnnotationPackage.SINGLE_ANNOTATION: {
				SingleAnnotation singleAnnotation = (SingleAnnotation)theEObject;
				T result = caseSingleAnnotation(singleAnnotation);
				if (result == null) result = caseIScopAnnotation(singleAnnotation);
				if (result == null) result = caseScopVisitable(singleAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parallel Loop Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parallel Loop Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParallelLoopAnnotation(ParallelLoopAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionAnnotation(DescriptionAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tile Loop Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tile Loop Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTileLoopAnnotation(TileLoopAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parallel Block Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parallel Block Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParallelBlockAnnotation(ParallelBlockAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Polyhedral Domain Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Polyhedral Domain Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolyhedralDomainAnnotation(PolyhedralDomainAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Barrier Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Barrier Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBarrierAnnotation(BarrierAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vectorization Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vectorization Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVectorizationAnnotation(VectorizationAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleAnnotation(SingleAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopVisitable(ScopVisitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IScop Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IScop Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIScopAnnotation(IScopAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AnnotationSwitch
