/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF.impl;

import commandIF.Category;
import commandIF.Command;
import commandIF.CommandIFPackage;
import commandIF.Overloading;

import commandIF.Type;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link commandIF.impl.CommandImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link commandIF.impl.CommandImpl#getOverloads <em>Overloads</em>}</li>
 *   <li>{@link commandIF.impl.CommandImpl#isUserCommand <em>User Command</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CommandImpl extends EObjectImpl implements Command {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "TODO : add description (to the model)";

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverloads() <em>Overloads</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverloads()
	 * @generated
	 * @ordered
	 */
	protected EList<Overloading> overloads;

	/**
	 * The default value of the '{@link #isUserCommand() <em>User Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserCommand()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USER_COMMAND_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUserCommand() <em>User Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserCommand()
	 * @generated
	 * @ordered
	 */
	protected boolean userCommand = USER_COMMAND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandIFPackage.Literals.COMMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandIFPackage.COMMAND__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Overloading> getOverloads() {
		if (overloads == null) {
			overloads = new EObjectContainmentEList<Overloading>(Overloading.class, this, CommandIFPackage.COMMAND__OVERLOADS);
		}
		return overloads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUserCommand() {
		return userCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserCommand(boolean newUserCommand) {
		boolean oldUserCommand = userCommand;
		userCommand = newUserCommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandIFPackage.COMMAND__USER_COMMAND, oldUserCommand, userCommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getOutput() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category getCategory() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isExposedToUser() {
		if (this.eContainer instanceof Category) {
			return userCommand;
		} else {
			return ((Command)(this.eContainer)).isExposedToUser() && userCommand;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommandIFPackage.COMMAND__OVERLOADS:
				return ((InternalEList<?>)getOverloads()).basicRemove(otherEnd, msgs);
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
			case CommandIFPackage.COMMAND__DESCRIPTION:
				return getDescription();
			case CommandIFPackage.COMMAND__OVERLOADS:
				return getOverloads();
			case CommandIFPackage.COMMAND__USER_COMMAND:
				return isUserCommand();
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
			case CommandIFPackage.COMMAND__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CommandIFPackage.COMMAND__OVERLOADS:
				getOverloads().clear();
				getOverloads().addAll((Collection<? extends Overloading>)newValue);
				return;
			case CommandIFPackage.COMMAND__USER_COMMAND:
				setUserCommand((Boolean)newValue);
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
			case CommandIFPackage.COMMAND__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CommandIFPackage.COMMAND__OVERLOADS:
				getOverloads().clear();
				return;
			case CommandIFPackage.COMMAND__USER_COMMAND:
				setUserCommand(USER_COMMAND_EDEFAULT);
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
			case CommandIFPackage.COMMAND__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CommandIFPackage.COMMAND__OVERLOADS:
				return overloads != null && !overloads.isEmpty();
			case CommandIFPackage.COMMAND__USER_COMMAND:
				return userCommand != USER_COMMAND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (description: ");
		result.append(description);
		result.append(", userCommand: ");
		result.append(userCommand);
		result.append(')');
		return result.toString();
	}

} //CommandImpl
