/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polymodel.scop.ScopPackage
 * @generated
 */
public class ScopSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScopPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopSwitch() {
		if (modelPackage == null) {
			modelPackage = ScopPackage.eINSTANCE;
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
			case ScopPackage.ABSTRACT_SCOP_NODE: {
				AbstractScopNode abstractScopNode = (AbstractScopNode)theEObject;
				T result = caseAbstractScopNode(abstractScopNode);
				if (result == null) result = caseScopVisitable(abstractScopNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.ISCOP_ANNOTATION: {
				IScopAnnotation iScopAnnotation = (IScopAnnotation)theEObject;
				T result = caseIScopAnnotation(iScopAnnotation);
				if (result == null) result = caseScopVisitable(iScopAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_ROOT: {
				ScopRoot scopRoot = (ScopRoot)theEObject;
				T result = caseScopRoot(scopRoot);
				if (result == null) result = caseScopVisitable(scopRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_FOR: {
				ScopFor scopFor = (ScopFor)theEObject;
				T result = caseScopFor(scopFor);
				if (result == null) result = caseAbstractScopNode(scopFor);
				if (result == null) result = caseScopVisitable(scopFor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_BLOCK: {
				ScopBlock scopBlock = (ScopBlock)theEObject;
				T result = caseScopBlock(scopBlock);
				if (result == null) result = caseAbstractScopNode(scopBlock);
				if (result == null) result = caseScopVisitable(scopBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_GUARD: {
				ScopGuard scopGuard = (ScopGuard)theEObject;
				T result = caseScopGuard(scopGuard);
				if (result == null) result = caseAbstractScopNode(scopGuard);
				if (result == null) result = caseScopVisitable(scopGuard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_STATEMENT_MACRO: {
				ScopStatementMacro scopStatementMacro = (ScopStatementMacro)theEObject;
				T result = caseScopStatementMacro(scopStatementMacro);
				if (result == null) result = caseAbstractScopStatement(scopStatementMacro);
				if (result == null) result = caseAbstractScopNode(scopStatementMacro);
				if (result == null) result = caseScopVisitable(scopStatementMacro);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_ASSIGNMENT: {
				ScopAssignment scopAssignment = (ScopAssignment)theEObject;
				T result = caseScopAssignment(scopAssignment);
				if (result == null) result = caseAbstractScopStatement(scopAssignment);
				if (result == null) result = caseAbstractScopNode(scopAssignment);
				if (result == null) result = caseScopVisitable(scopAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.ABSTRACT_SCOP_STATEMENT: {
				AbstractScopStatement abstractScopStatement = (AbstractScopStatement)theEObject;
				T result = caseAbstractScopStatement(abstractScopStatement);
				if (result == null) result = caseAbstractScopNode(abstractScopStatement);
				if (result == null) result = caseScopVisitable(abstractScopStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_VISITOR: {
				ScopVisitor scopVisitor = (ScopVisitor)theEObject;
				T result = caseScopVisitor(scopVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_VISITABLE: {
				ScopVisitable scopVisitable = (ScopVisitable)theEObject;
				T result = caseScopVisitable(scopVisitable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR: {
				ScopDepthFirstVisitor scopDepthFirstVisitor = (ScopDepthFirstVisitor)theEObject;
				T result = caseScopDepthFirstVisitor(scopDepthFirstVisitor);
				if (result == null) result = caseScopVisitor(scopDepthFirstVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScopPackage.SCOP_UNSCANNED_DOMAIN: {
				ScopUnscannedDomain scopUnscannedDomain = (ScopUnscannedDomain)theEObject;
				T result = caseScopUnscannedDomain(scopUnscannedDomain);
				if (result == null) result = caseAbstractScopStatement(scopUnscannedDomain);
				if (result == null) result = caseAbstractScopNode(scopUnscannedDomain);
				if (result == null) result = caseScopVisitable(scopUnscannedDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Scop Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Scop Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractScopNode(AbstractScopNode object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopRoot(ScopRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopFor(ScopFor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopBlock(ScopBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopGuard(ScopGuard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement Macro</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement Macro</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopStatementMacro(ScopStatementMacro object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopAssignment(ScopAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Scop Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Scop Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractScopStatement(AbstractScopStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopVisitor(ScopVisitor object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Depth First Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depth First Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopDepthFirstVisitor(ScopDepthFirstVisitor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unscanned Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unscanned Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopUnscannedDomain(ScopUnscannedDomain object) {
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

} //ScopSwitch
