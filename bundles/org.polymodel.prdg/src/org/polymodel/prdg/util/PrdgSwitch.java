/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.prdg.DependenceFunction;
import org.polymodel.prdg.EdgeFunction;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.PrdgPackage;
import org.polymodel.prdg.ProjectionFunction;

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
 * @see org.polymodel.prdg.PrdgPackage
 * @generated
 */
public class PrdgSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PrdgPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrdgSwitch() {
		if (modelPackage == null) {
			modelPackage = PrdgPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case PrdgPackage.PRDG_NODE: {
				PRDGNode prdgNode = (PRDGNode)theEObject;
				T result = casePRDGNode(prdgNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrdgPackage.PRDG_EDGE: {
				PRDGEdge prdgEdge = (PRDGEdge)theEObject;
				T result = casePRDGEdge(prdgEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrdgPackage.PRDG: {
				PRDG prdg = (PRDG)theEObject;
				T result = casePRDG(prdg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrdgPackage.EDGE_FUNCTION: {
				EdgeFunction edgeFunction = (EdgeFunction)theEObject;
				T result = caseEdgeFunction(edgeFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrdgPackage.PROJECTION_FUNCTION: {
				ProjectionFunction projectionFunction = (ProjectionFunction)theEObject;
				T result = caseProjectionFunction(projectionFunction);
				if (result == null) result = caseEdgeFunction(projectionFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrdgPackage.DEPENDENCE_FUNCTION: {
				DependenceFunction dependenceFunction = (DependenceFunction)theEObject;
				T result = caseDependenceFunction(dependenceFunction);
				if (result == null) result = caseEdgeFunction(dependenceFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE: {
				PRDGSubSystemHyperEdge prdgSubSystemHyperEdge = (PRDGSubSystemHyperEdge)theEObject;
				T result = casePRDGSubSystemHyperEdge(prdgSubSystemHyperEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PRDG Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PRDG Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePRDGNode(PRDGNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PRDG Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PRDG Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePRDGEdge(PRDGEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PRDG</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PRDG</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePRDG(PRDG object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeFunction(EdgeFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Projection Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Projection Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectionFunction(ProjectionFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependence Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependence Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependenceFunction(DependenceFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PRDG Sub System Hyper Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PRDG Sub System Hyper Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePRDGSubSystemHyperEdge(PRDGSubSystemHyperEdge object) {
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

} //PrdgSwitch
