/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.PrdgPackage;
import org.polymodel.prdg.util.PRDGPrettyPrinter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PRDG</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.impl.PRDGImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.polymodel.prdg.impl.PRDGImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.polymodel.prdg.impl.PRDGImpl#getHedges <em>Hedges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PRDGImpl extends EObjectImpl implements PRDG {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<PRDGNode> nodes;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<PRDGEdge> edges;

	/**
	 * The cached value of the '{@link #getHedges() <em>Hedges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHedges()
	 * @generated
	 * @ordered
	 */
	protected EList<PRDGSubSystemHyperEdge> hedges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PRDGImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrdgPackage.Literals.PRDG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PRDGNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<PRDGNode>(PRDGNode.class, this, PrdgPackage.PRDG__NODES, PrdgPackage.PRDG_NODE__PRDG);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PRDGEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentEList<PRDGEdge>(PRDGEdge.class, this, PrdgPackage.PRDG__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PRDGSubSystemHyperEdge> getHedges() {
		if (hedges == null) {
			hedges = new EObjectResolvingEList<PRDGSubSystemHyperEdge>(PRDGSubSystemHyperEdge.class, this, PrdgPackage.PRDG__HEDGES);
		}
		return hedges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PRDGNode getNode(String name) {
		for (PRDGNode node : getNodes()) {
			if (node.getName().compareTo(name) == 0) {
				return node;
			}
		}
		
		throw new RuntimeException("RDGNode with name : " + name + " does not exist.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrdgPackage.PRDG__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrdgPackage.PRDG__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case PrdgPackage.PRDG__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PrdgPackage.PRDG__NODES:
				return getNodes();
			case PrdgPackage.PRDG__EDGES:
				return getEdges();
			case PrdgPackage.PRDG__HEDGES:
				return getHedges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PrdgPackage.PRDG__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends PRDGNode>)newValue);
				return;
			case PrdgPackage.PRDG__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends PRDGEdge>)newValue);
				return;
			case PrdgPackage.PRDG__HEDGES:
				getHedges().clear();
				getHedges().addAll((Collection<? extends PRDGSubSystemHyperEdge>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PrdgPackage.PRDG__NODES:
				getNodes().clear();
				return;
			case PrdgPackage.PRDG__EDGES:
				getEdges().clear();
				return;
			case PrdgPackage.PRDG__HEDGES:
				getHedges().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PrdgPackage.PRDG__NODES:
				return nodes != null && !nodes.isEmpty();
			case PrdgPackage.PRDG__EDGES:
				return edges != null && !edges.isEmpty();
			case PrdgPackage.PRDG__HEDGES:
				return hedges != null && !hedges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PrdgPackage.PRDG___GET_NODE__STRING:
				return getNode((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public String toString() {
		return PRDGPrettyPrinter.pretty(this);
	}
} //PRDGImpl
