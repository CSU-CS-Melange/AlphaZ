/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.MemoryDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bounded Channel Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class MemoryDependencyImpl extends ChannelDependencyImpl implements MemoryDependency {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.MEMORY_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BoundedChannel getChannel() {
		return (BoundedChannel) super.channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StructuredPackage.MEMORY_DEPENDENCY___GET_CHANNEL:
				return getChannel();
		}
		return super.eInvoke(operationID, arguments);
	}
	

} //BoundedChannelDependencyImpl
