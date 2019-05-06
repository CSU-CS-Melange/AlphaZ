/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.BoundingCoefficient;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;
import org.polymodel.prdg.scheduling.structured.StructuredSchedulingConcreteFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Bounded Channel</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.BoundedChannelImpl#getMaximalChannelSize <em>Maximal Channel Size</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.BoundedChannelImpl#getSizeVariable <em>Size Variable</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.BoundedChannelImpl#getBoundingCoefficients <em>Bounding Coefficients</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundedChannelImpl extends ChannelImpl implements BoundedChannel {
	/**
	 * The default value of the '{@link #getMaximalChannelSize() <em>Maximal Channel Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMaximalChannelSize()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMAL_CHANNEL_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaximalChannelSize() <em>Maximal Channel Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMaximalChannelSize()
	 * @generated
	 * @ordered
	 */
	protected int maximalChannelSize = MAXIMAL_CHANNEL_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSizeVariable() <em>Size Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable sizeVariable;

	/**
	 * The cached value of the '{@link #getBoundingCoefficients()
	 * <em>Bounding Coefficients</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBoundingCoefficients()
	 * @generated
	 * @ordered
	 */
	protected EList<BoundingCoefficient> boundingCoefficients;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundedChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.BOUNDED_CHANNEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximalChannelSize() {
		return maximalChannelSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setMaximalChannelSize(int newMaximalChannelSize) {
		if (newMaximalChannelSize == 0)
			throw new IllegalArgumentException(
					"Size of a bounded channel can't be null (write once condition violated)");
		int oldMaximalChannelSize = maximalChannelSize;
		maximalChannelSize = newMaximalChannelSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StructuredPackage.BOUNDED_CHANNEL__MAXIMAL_CHANNEL_SIZE,
					oldMaximalChannelSize, maximalChannelSize));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getSizeVariable() {
		return sizeVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSizeVariable(Variable newSizeVariable,
			NotificationChain msgs) {
		Variable oldSizeVariable = sizeVariable;
		sizeVariable = newSizeVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE, oldSizeVariable, newSizeVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeVariable(Variable newSizeVariable) {
		if (newSizeVariable != sizeVariable) {
			NotificationChain msgs = null;
			if (sizeVariable != null)
				msgs = ((InternalEObject)sizeVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE, null, msgs);
			if (newSizeVariable != null)
				msgs = ((InternalEObject)newSizeVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE, null, msgs);
			msgs = basicSetSizeVariable(newSizeVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE, newSizeVariable, newSizeVariable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BoundingCoefficient> getBoundingCoefficients() {
		if (boundingCoefficients == null) {
			boundingCoefficients = new EObjectContainmentEList<BoundingCoefficient>(BoundingCoefficient.class, this, StructuredPackage.BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS);
		}
		return boundingCoefficients;
	}

	private BoundingCoefficientMap boundingCoefficientMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public BoundingCoefficient getBoundingCoefficient(int index, int dimension) {
		if (boundingCoefficientMap == null) {
			boundingCoefficientMap = new BoundingCoefficientMap(name);
			for (BoundingCoefficient b : getBoundingCoefficients()) {
				boundingCoefficientMap.addBoundingCoefficient(b);
			}
		}
		return boundingCoefficientMap.getBoundingCoefficient(index, dimension);
	}

	public  class BoundingCoefficientMap {
		private String name;
		private Map<Integer, Map<Integer, BoundingCoefficient>> indexToDimsMap = new HashMap<Integer, Map<Integer, BoundingCoefficient>>();

		public BoundingCoefficientMap(String name) {
			super();
			this.name = name;
		}

		public void addBoundingCoefficient(BoundingCoefficient b) {
			getMapForIndex(b.getIndex()).put(b.getDimension(), b);
		}

		public BoundingCoefficient getBoundingCoefficient(int index, int dim) {
			Map<Integer, BoundingCoefficient> map = getMapForIndex(index);
			BoundingCoefficient coef = map.get(dim);
			if (coef == null) {
				coef = StructuredSchedulingConcreteFactory.INSTANCE
						.createBoundingCoefficient(name, index, dim);
				map.put(dim, coef);
				boundingCoefficients.add(coef);
			}
			return coef;
		}

		private Map<Integer, BoundingCoefficient> getMapForIndex(int index) {
			Map<Integer, BoundingCoefficient> map = indexToDimsMap.get(index);
			if (map == null) {
				map = new HashMap<Integer, BoundingCoefficient>();
				indexToDimsMap.put(index, map);
			}
			return map;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE:
				return basicSetSizeVariable(null, msgs);
			case StructuredPackage.BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS:
				return ((InternalEList<?>)getBoundingCoefficients()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructuredPackage.BOUNDED_CHANNEL__MAXIMAL_CHANNEL_SIZE:
				return getMaximalChannelSize();
			case StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE:
				return getSizeVariable();
			case StructuredPackage.BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS:
				return getBoundingCoefficients();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StructuredPackage.BOUNDED_CHANNEL__MAXIMAL_CHANNEL_SIZE:
				setMaximalChannelSize((Integer)newValue);
				return;
			case StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE:
				setSizeVariable((Variable)newValue);
				return;
			case StructuredPackage.BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS:
				getBoundingCoefficients().clear();
				getBoundingCoefficients().addAll((Collection<? extends BoundingCoefficient>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StructuredPackage.BOUNDED_CHANNEL__MAXIMAL_CHANNEL_SIZE:
				setMaximalChannelSize(MAXIMAL_CHANNEL_SIZE_EDEFAULT);
				return;
			case StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE:
				setSizeVariable((Variable)null);
				return;
			case StructuredPackage.BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS:
				getBoundingCoefficients().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StructuredPackage.BOUNDED_CHANNEL__MAXIMAL_CHANNEL_SIZE:
				return maximalChannelSize != MAXIMAL_CHANNEL_SIZE_EDEFAULT;
			case StructuredPackage.BOUNDED_CHANNEL__SIZE_VARIABLE:
				return sizeVariable != null;
			case StructuredPackage.BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS:
				return boundingCoefficients != null && !boundingCoefficients.isEmpty();
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
			case StructuredPackage.BOUNDED_CHANNEL___GET_BOUNDING_COEFFICIENT__INT_INT:
				return getBoundingCoefficient((Integer)arguments.get(0), (Integer)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (maximalChannelSize: ");
		result.append(maximalChannelSize);
		result.append(')');
		return result.toString();
	}

} // BoundedChannelImpl
