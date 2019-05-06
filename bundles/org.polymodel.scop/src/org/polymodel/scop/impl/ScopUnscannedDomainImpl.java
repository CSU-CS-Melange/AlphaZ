/**
 */
package org.polymodel.scop.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopUnscannedDomain;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unscanned Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.impl.ScopUnscannedDomainImpl#getMacroParams <em>Macro Params</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopUnscannedDomainImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.scop.impl.ScopUnscannedDomainImpl#getSchedule <em>Schedule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopUnscannedDomainImpl extends AbstractScopStatementImpl implements ScopUnscannedDomain {
	/**
	 * The cached value of the '{@link #getMacroParams() <em>Macro Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMacroParams()
	 * @generated
	 * @ordered
	 */
	protected EList<IntExpression> macroParams;

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
	 * The default value of the '{@link #getSchedule() <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedule()
	 * @generated
	 * @ordered
	 */
	protected static final JNIISLUnionMap SCHEDULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedule() <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedule()
	 * @generated
	 * @ordered
	 */
	protected JNIISLUnionMap schedule = SCHEDULE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopUnscannedDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopPackage.Literals.SCOP_UNSCANNED_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntExpression> getMacroParams() {
		if (macroParams == null) {
			macroParams = new EObjectContainmentEList<IntExpression>(IntExpression.class, this, ScopPackage.SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS);
		}
		return macroParams;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_UNSCANNED_DOMAIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JNIISLUnionMap getSchedule() {
		return schedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedule(JNIISLUnionMap newSchedule) {
		JNIISLUnionMap oldSchedule = schedule;
		schedule = newSchedule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopPackage.SCOP_UNSCANNED_DOMAIN__SCHEDULE, oldSchedule, schedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitScopUnscannedDomain(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS:
				return ((InternalEList<?>)getMacroParams()).basicRemove(otherEnd, msgs);
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
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS:
				return getMacroParams();
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__NAME:
				return getName();
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__SCHEDULE:
				return getSchedule();
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
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS:
				getMacroParams().clear();
				getMacroParams().addAll((Collection<? extends IntExpression>)newValue);
				return;
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__NAME:
				setName((String)newValue);
				return;
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__SCHEDULE:
				setSchedule((JNIISLUnionMap)newValue);
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
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS:
				getMacroParams().clear();
				return;
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__SCHEDULE:
				setSchedule(SCHEDULE_EDEFAULT);
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
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS:
				return macroParams != null && !macroParams.isEmpty();
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ScopPackage.SCOP_UNSCANNED_DOMAIN__SCHEDULE:
				return SCHEDULE_EDEFAULT == null ? schedule != null : !SCHEDULE_EDEFAULT.equals(schedule);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ScopVisitable.class) {
			switch (baseOperationID) {
				case ScopPackage.SCOP_VISITABLE___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_UNSCANNED_DOMAIN___ACCEPT__SCOPVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AbstractScopNode.class) {
			switch (baseOperationID) {
				case ScopPackage.ABSTRACT_SCOP_NODE___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_UNSCANNED_DOMAIN___ACCEPT__SCOPVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AbstractScopStatement.class) {
			switch (baseOperationID) {
				case ScopPackage.ABSTRACT_SCOP_STATEMENT___ACCEPT__SCOPVISITOR: return ScopPackage.SCOP_UNSCANNED_DOMAIN___ACCEPT__SCOPVISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScopPackage.SCOP_UNSCANNED_DOMAIN___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();
		
		return getName() + " (" + getMacroParams() + ") @ " + getSchedule();
	}

} //ScopUnscannedDomainImpl
