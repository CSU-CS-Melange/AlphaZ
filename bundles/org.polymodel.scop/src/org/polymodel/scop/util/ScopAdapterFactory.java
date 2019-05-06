/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.scop.*;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopDepthFirstVisitor;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUnscannedDomain;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.scop.ScopPackage
 * @generated
 */
public class ScopAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScopPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ScopPackage.eINSTANCE;
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
	protected ScopSwitch<Adapter> modelSwitch =
		new ScopSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractScopNode(AbstractScopNode object) {
				return createAbstractScopNodeAdapter();
			}
			@Override
			public Adapter caseIScopAnnotation(IScopAnnotation object) {
				return createIScopAnnotationAdapter();
			}
			@Override
			public Adapter caseScopRoot(ScopRoot object) {
				return createScopRootAdapter();
			}
			@Override
			public Adapter caseScopFor(ScopFor object) {
				return createScopForAdapter();
			}
			@Override
			public Adapter caseScopBlock(ScopBlock object) {
				return createScopBlockAdapter();
			}
			@Override
			public Adapter caseScopGuard(ScopGuard object) {
				return createScopGuardAdapter();
			}
			@Override
			public Adapter caseScopStatementMacro(ScopStatementMacro object) {
				return createScopStatementMacroAdapter();
			}
			@Override
			public Adapter caseScopAssignment(ScopAssignment object) {
				return createScopAssignmentAdapter();
			}
			@Override
			public Adapter caseAbstractScopStatement(AbstractScopStatement object) {
				return createAbstractScopStatementAdapter();
			}
			@Override
			public Adapter caseScopVisitor(ScopVisitor object) {
				return createScopVisitorAdapter();
			}
			@Override
			public Adapter caseScopVisitable(ScopVisitable object) {
				return createScopVisitableAdapter();
			}
			@Override
			public Adapter caseScopDepthFirstVisitor(ScopDepthFirstVisitor object) {
				return createScopDepthFirstVisitorAdapter();
			}
			@Override
			public Adapter caseScopUnscannedDomain(ScopUnscannedDomain object) {
				return createScopUnscannedDomainAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.AbstractScopNode <em>Abstract Scop Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.AbstractScopNode
	 * @generated
	 */
	public Adapter createAbstractScopNodeAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopRoot
	 * @generated
	 */
	public Adapter createScopRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopFor <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopFor
	 * @generated
	 */
	public Adapter createScopForAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopBlock
	 * @generated
	 */
	public Adapter createScopBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopGuard
	 * @generated
	 */
	public Adapter createScopGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopStatementMacro <em>Statement Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopStatementMacro
	 * @generated
	 */
	public Adapter createScopStatementMacroAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopAssignment
	 * @generated
	 */
	public Adapter createScopAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.AbstractScopStatement <em>Abstract Scop Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.AbstractScopStatement
	 * @generated
	 */
	public Adapter createAbstractScopStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopVisitor
	 * @generated
	 */
	public Adapter createScopVisitorAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopDepthFirstVisitor <em>Depth First Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor
	 * @generated
	 */
	public Adapter createScopDepthFirstVisitorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.scop.ScopUnscannedDomain <em>Unscanned Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.scop.ScopUnscannedDomain
	 * @generated
	 */
	public Adapter createScopUnscannedDomainAdapter() {
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

} //ScopAdapterFactory
