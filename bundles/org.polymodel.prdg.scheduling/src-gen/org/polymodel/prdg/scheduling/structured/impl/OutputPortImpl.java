/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.structured.Channel;
import org.polymodel.prdg.scheduling.structured.OutputPort;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Output Port</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.OutputPortImpl#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputPortImpl extends DataPortImpl implements OutputPort {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.OUTPUT_PORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Channel getChannel() {
		if (eContainerFeatureID() != StructuredPackage.OUTPUT_PORT__CHANNEL) return null;
		return (Channel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public PRDGNode getSourceNode() {
		if(getChannel().getEdges().size()==0)
			throw new RuntimeException("Unable to find the source node: channel hasn't any connected edge.");
		return getChannel().getEdges().get(0).getSource();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.OUTPUT_PORT__CHANNEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, StructuredPackage.OUTPUT_PORT__CHANNEL, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.OUTPUT_PORT__CHANNEL:
				return eBasicSetContainer(null, StructuredPackage.OUTPUT_PORT__CHANNEL, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case StructuredPackage.OUTPUT_PORT__CHANNEL:
				return eInternalContainer().eInverseRemove(this, StructuredPackage.CHANNEL__SOURCE, Channel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructuredPackage.OUTPUT_PORT__CHANNEL:
				return getChannel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StructuredPackage.OUTPUT_PORT__CHANNEL:
				return getChannel() != null;
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
			case StructuredPackage.OUTPUT_PORT___GET_SOURCE_NODE:
				return getSourceNode();
		}
		return super.eInvoke(operationID, arguments);
	}

} // OutputPortImpl
