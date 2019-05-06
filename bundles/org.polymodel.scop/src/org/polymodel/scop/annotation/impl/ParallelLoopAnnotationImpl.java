/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.annotation.AnnotationPackage;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallel Loop Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.impl.ParallelLoopAnnotationImpl#getPrivates <em>Privates</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.impl.ParallelLoopAnnotationImpl#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.impl.ParallelLoopAnnotationImpl#getChunksize <em>Chunksize</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParallelLoopAnnotationImpl extends EObjectImpl implements ParallelLoopAnnotation {
	/**
	 * The cached value of the '{@link #getPrivates() <em>Privates</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrivates()
	 * @generated
	 * @ordered
	 */
	protected EList<String> privates;

	/**
	 * The default value of the '{@link #getSchedule() <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedule()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEDULE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSchedule() <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedule()
	 * @generated
	 * @ordered
	 */
	protected String schedule = SCHEDULE_EDEFAULT;
	/**
	 * The default value of the '{@link #getChunksize() <em>Chunksize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChunksize()
	 * @generated
	 * @ordered
	 */
	protected static final int CHUNKSIZE_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getChunksize() <em>Chunksize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChunksize()
	 * @generated
	 * @ordered
	 */
	protected int chunksize = CHUNKSIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParallelLoopAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnotationPackage.Literals.PARALLEL_LOOP_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPrivates() {
		if (privates == null) {
			privates = new EDataTypeUniqueEList<String>(String.class, this, AnnotationPackage.PARALLEL_LOOP_ANNOTATION__PRIVATES);
		}
		return privates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedule(String newSchedule) {
		String oldSchedule = schedule;
		schedule = newSchedule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotationPackage.PARALLEL_LOOP_ANNOTATION__SCHEDULE, oldSchedule, schedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getChunksize() {
		return chunksize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChunksize(int newChunksize) {
		int oldChunksize = chunksize;
		chunksize = newChunksize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotationPackage.PARALLEL_LOOP_ANNOTATION__CHUNKSIZE, oldChunksize, chunksize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitParallelLoopAnnotation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__PRIVATES:
				return getPrivates();
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__SCHEDULE:
				return getSchedule();
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__CHUNKSIZE:
				return getChunksize();
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
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__PRIVATES:
				getPrivates().clear();
				getPrivates().addAll((Collection<? extends String>)newValue);
				return;
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__SCHEDULE:
				setSchedule((String)newValue);
				return;
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__CHUNKSIZE:
				setChunksize((Integer)newValue);
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
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__PRIVATES:
				getPrivates().clear();
				return;
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__SCHEDULE:
				setSchedule(SCHEDULE_EDEFAULT);
				return;
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__CHUNKSIZE:
				setChunksize(CHUNKSIZE_EDEFAULT);
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
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__PRIVATES:
				return privates != null && !privates.isEmpty();
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__SCHEDULE:
				return SCHEDULE_EDEFAULT == null ? schedule != null : !SCHEDULE_EDEFAULT.equals(schedule);
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION__CHUNKSIZE:
				return chunksize != CHUNKSIZE_EDEFAULT;
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
			case AnnotationPackage.PARALLEL_LOOP_ANNOTATION___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (privates: ");
		result.append(privates);
		result.append(", schedule: ");
		result.append(schedule);
		result.append(", chunksize: ");
		result.append(chunksize);
		result.append(')');
		return result.toString();
	}

} //ParallelLoopAnnotationImpl
