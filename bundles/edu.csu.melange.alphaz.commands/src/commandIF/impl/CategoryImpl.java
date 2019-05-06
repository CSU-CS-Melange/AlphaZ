/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF.impl;

import commandIF.BasicCommand;
import commandIF.Category;
import commandIF.CommandIFPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link commandIF.impl.CategoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link commandIF.impl.CategoryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link commandIF.impl.CategoryImpl#getCommandPrefix <em>Command Prefix</em>}</li>
 *   <li>{@link commandIF.impl.CategoryImpl#getSubcategories <em>Subcategories</em>}</li>
 *   <li>{@link commandIF.impl.CategoryImpl#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CategoryImpl extends EObjectImpl implements Category {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getCommandPrefix() <em>Command Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandPrefix() <em>Command Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandPrefix()
	 * @generated
	 * @ordered
	 */
	protected String commandPrefix = COMMAND_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubcategories() <em>Subcategories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubcategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> subcategories;

	/**
	 * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommands()
	 * @generated
	 * @ordered
	 */
	protected EList<BasicCommand> commands;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandIFPackage.Literals.CATEGORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandIFPackage.CATEGORY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommandIFPackage.CATEGORY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandPrefix() {
		return commandPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandPrefix(String newCommandPrefix) {
		String oldCommandPrefix = commandPrefix;
		commandPrefix = newCommandPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandIFPackage.CATEGORY__COMMAND_PREFIX, oldCommandPrefix, commandPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Category> getSubcategories() {
		if (subcategories == null) {
			subcategories = new EObjectContainmentEList<Category>(Category.class, this, CommandIFPackage.CATEGORY__SUBCATEGORIES);
		}
		return subcategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BasicCommand> getCommands() {
		if (commands == null) {
			commands = new EObjectContainmentEList<BasicCommand>(BasicCommand.class, this, CommandIFPackage.CATEGORY__COMMANDS);
		}
		return commands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommandIFPackage.CATEGORY__SUBCATEGORIES:
				return ((InternalEList<?>)getSubcategories()).basicRemove(otherEnd, msgs);
			case CommandIFPackage.CATEGORY__COMMANDS:
				return ((InternalEList<?>)getCommands()).basicRemove(otherEnd, msgs);
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
			case CommandIFPackage.CATEGORY__NAME:
				return getName();
			case CommandIFPackage.CATEGORY__DESCRIPTION:
				return getDescription();
			case CommandIFPackage.CATEGORY__COMMAND_PREFIX:
				return getCommandPrefix();
			case CommandIFPackage.CATEGORY__SUBCATEGORIES:
				return getSubcategories();
			case CommandIFPackage.CATEGORY__COMMANDS:
				return getCommands();
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
			case CommandIFPackage.CATEGORY__NAME:
				setName((String)newValue);
				return;
			case CommandIFPackage.CATEGORY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CommandIFPackage.CATEGORY__COMMAND_PREFIX:
				setCommandPrefix((String)newValue);
				return;
			case CommandIFPackage.CATEGORY__SUBCATEGORIES:
				getSubcategories().clear();
				getSubcategories().addAll((Collection<? extends Category>)newValue);
				return;
			case CommandIFPackage.CATEGORY__COMMANDS:
				getCommands().clear();
				getCommands().addAll((Collection<? extends BasicCommand>)newValue);
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
			case CommandIFPackage.CATEGORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CommandIFPackage.CATEGORY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CommandIFPackage.CATEGORY__COMMAND_PREFIX:
				setCommandPrefix(COMMAND_PREFIX_EDEFAULT);
				return;
			case CommandIFPackage.CATEGORY__SUBCATEGORIES:
				getSubcategories().clear();
				return;
			case CommandIFPackage.CATEGORY__COMMANDS:
				getCommands().clear();
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
			case CommandIFPackage.CATEGORY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CommandIFPackage.CATEGORY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CommandIFPackage.CATEGORY__COMMAND_PREFIX:
				return COMMAND_PREFIX_EDEFAULT == null ? commandPrefix != null : !COMMAND_PREFIX_EDEFAULT.equals(commandPrefix);
			case CommandIFPackage.CATEGORY__SUBCATEGORIES:
				return subcategories != null && !subcategories.isEmpty();
			case CommandIFPackage.CATEGORY__COMMANDS:
				return commands != null && !commands.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", commandPrefix: ");
		result.append(commandPrefix);
		result.append(')');
		return result.toString();
	}

} //CategoryImpl
