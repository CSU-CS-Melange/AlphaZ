/**
 */
package org.polymodel.polyhedralIR.polyIRCG.PCOT.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recursion Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#isParallel <em>Parallel</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#getBaseFunction <em>Base Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#getBandStart <em>Band Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#getBandEnd <em>Band End</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#getParamStruct <em>Param Struct</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#getLocalStruct <em>Local Struct</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#getRecurStructs <em>Recur Structs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl#getTileSizes <em>Tile Sizes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecursionBodyImpl extends EObjectImpl implements RecursionBody {
	/**
	 * The default value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParallel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARALLEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParallel()
	 * @generated
	 * @ordered
	 */
	protected boolean parallel = PARALLEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseFunction() <em>Base Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseFunction()
	 * @generated
	 * @ordered
	 */
	protected Function baseFunction;

	/**
	 * The default value of the '{@link #getBandStart() <em>Band Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBandStart()
	 * @generated
	 * @ordered
	 */
	protected static final int BAND_START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBandStart() <em>Band Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBandStart()
	 * @generated
	 * @ordered
	 */
	protected int bandStart = BAND_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getBandEnd() <em>Band End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBandEnd()
	 * @generated
	 * @ordered
	 */
	protected static final int BAND_END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBandEnd() <em>Band End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBandEnd()
	 * @generated
	 * @ordered
	 */
	protected int bandEnd = BAND_END_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParamStruct() <em>Param Struct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamStruct()
	 * @generated
	 * @ordered
	 */
	protected Struct paramStruct;

	/**
	 * The cached value of the '{@link #getLocalStruct() <em>Local Struct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalStruct()
	 * @generated
	 * @ordered
	 */
	protected Struct localStruct;

	/**
	 * The cached value of the '{@link #getRecurStructs() <em>Recur Structs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecurStructs()
	 * @generated
	 * @ordered
	 */
	protected EList<Struct> recurStructs;

	/**
	 * The cached value of the '{@link #getTileSizes() <em>Tile Sizes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileSizes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tileSizes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecursionBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCOTPackage.Literals.RECURSION_BODY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != PCOTPackage.RECURSION_BODY__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, PCOTPackage.RECURSION_BODY__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != PCOTPackage.RECURSION_BODY__FUNCTION && newFunction != null)) {
			if (EcoreUtil.isAncestor(this, newFunction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCOTPackage.RECURSION_BODY__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParallel() {
		return parallel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParallel(boolean newParallel) {
		boolean oldParallel = parallel;
		parallel = newParallel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCOTPackage.RECURSION_BODY__PARALLEL, oldParallel, parallel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getBaseFunction() {
		if (baseFunction != null && baseFunction.eIsProxy()) {
			InternalEObject oldBaseFunction = (InternalEObject)baseFunction;
			baseFunction = (Function)eResolveProxy(oldBaseFunction);
			if (baseFunction != oldBaseFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCOTPackage.RECURSION_BODY__BASE_FUNCTION, oldBaseFunction, baseFunction));
			}
		}
		return baseFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetBaseFunction() {
		return baseFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseFunction(Function newBaseFunction) {
		Function oldBaseFunction = baseFunction;
		baseFunction = newBaseFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCOTPackage.RECURSION_BODY__BASE_FUNCTION, oldBaseFunction, baseFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBandStart() {
		return bandStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBandStart(int newBandStart) {
		int oldBandStart = bandStart;
		bandStart = newBandStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCOTPackage.RECURSION_BODY__BAND_START, oldBandStart, bandStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBandEnd() {
		return bandEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBandEnd(int newBandEnd) {
		int oldBandEnd = bandEnd;
		bandEnd = newBandEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCOTPackage.RECURSION_BODY__BAND_END, oldBandEnd, bandEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Struct getParamStruct() {
		if (paramStruct != null && paramStruct.eIsProxy()) {
			InternalEObject oldParamStruct = (InternalEObject)paramStruct;
			paramStruct = (Struct)eResolveProxy(oldParamStruct);
			if (paramStruct != oldParamStruct) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCOTPackage.RECURSION_BODY__PARAM_STRUCT, oldParamStruct, paramStruct));
			}
		}
		return paramStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Struct basicGetParamStruct() {
		return paramStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParamStruct(Struct newParamStruct) {
		Struct oldParamStruct = paramStruct;
		paramStruct = newParamStruct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCOTPackage.RECURSION_BODY__PARAM_STRUCT, oldParamStruct, paramStruct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Struct getLocalStruct() {
		if (localStruct != null && localStruct.eIsProxy()) {
			InternalEObject oldLocalStruct = (InternalEObject)localStruct;
			localStruct = (Struct)eResolveProxy(oldLocalStruct);
			if (localStruct != oldLocalStruct) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCOTPackage.RECURSION_BODY__LOCAL_STRUCT, oldLocalStruct, localStruct));
			}
		}
		return localStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Struct basicGetLocalStruct() {
		return localStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalStruct(Struct newLocalStruct) {
		Struct oldLocalStruct = localStruct;
		localStruct = newLocalStruct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCOTPackage.RECURSION_BODY__LOCAL_STRUCT, oldLocalStruct, localStruct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Struct> getRecurStructs() {
		if (recurStructs == null) {
			recurStructs = new EObjectResolvingEList<Struct>(Struct.class, this, PCOTPackage.RECURSION_BODY__RECUR_STRUCTS);
		}
		return recurStructs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTileSizes() {
		if (tileSizes == null) {
			tileSizes = new EDataTypeUniqueEList<String>(String.class, this, PCOTPackage.RECURSION_BODY__TILE_SIZES);
		}
		return tileSizes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PCOTPackage.RECURSION_BODY__FUNCTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunction((Function)otherEnd, msgs);
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
			case PCOTPackage.RECURSION_BODY__FUNCTION:
				return basicSetFunction(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case PCOTPackage.RECURSION_BODY__FUNCTION:
				return eInternalContainer().eInverseRemove(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PCOTPackage.RECURSION_BODY__FUNCTION:
				return getFunction();
			case PCOTPackage.RECURSION_BODY__PARALLEL:
				return isParallel();
			case PCOTPackage.RECURSION_BODY__BASE_FUNCTION:
				if (resolve) return getBaseFunction();
				return basicGetBaseFunction();
			case PCOTPackage.RECURSION_BODY__BAND_START:
				return getBandStart();
			case PCOTPackage.RECURSION_BODY__BAND_END:
				return getBandEnd();
			case PCOTPackage.RECURSION_BODY__PARAM_STRUCT:
				if (resolve) return getParamStruct();
				return basicGetParamStruct();
			case PCOTPackage.RECURSION_BODY__LOCAL_STRUCT:
				if (resolve) return getLocalStruct();
				return basicGetLocalStruct();
			case PCOTPackage.RECURSION_BODY__RECUR_STRUCTS:
				return getRecurStructs();
			case PCOTPackage.RECURSION_BODY__TILE_SIZES:
				return getTileSizes();
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
			case PCOTPackage.RECURSION_BODY__FUNCTION:
				setFunction((Function)newValue);
				return;
			case PCOTPackage.RECURSION_BODY__PARALLEL:
				setParallel((Boolean)newValue);
				return;
			case PCOTPackage.RECURSION_BODY__BASE_FUNCTION:
				setBaseFunction((Function)newValue);
				return;
			case PCOTPackage.RECURSION_BODY__BAND_START:
				setBandStart((Integer)newValue);
				return;
			case PCOTPackage.RECURSION_BODY__BAND_END:
				setBandEnd((Integer)newValue);
				return;
			case PCOTPackage.RECURSION_BODY__PARAM_STRUCT:
				setParamStruct((Struct)newValue);
				return;
			case PCOTPackage.RECURSION_BODY__LOCAL_STRUCT:
				setLocalStruct((Struct)newValue);
				return;
			case PCOTPackage.RECURSION_BODY__RECUR_STRUCTS:
				getRecurStructs().clear();
				getRecurStructs().addAll((Collection<? extends Struct>)newValue);
				return;
			case PCOTPackage.RECURSION_BODY__TILE_SIZES:
				getTileSizes().clear();
				getTileSizes().addAll((Collection<? extends String>)newValue);
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
			case PCOTPackage.RECURSION_BODY__FUNCTION:
				setFunction((Function)null);
				return;
			case PCOTPackage.RECURSION_BODY__PARALLEL:
				setParallel(PARALLEL_EDEFAULT);
				return;
			case PCOTPackage.RECURSION_BODY__BASE_FUNCTION:
				setBaseFunction((Function)null);
				return;
			case PCOTPackage.RECURSION_BODY__BAND_START:
				setBandStart(BAND_START_EDEFAULT);
				return;
			case PCOTPackage.RECURSION_BODY__BAND_END:
				setBandEnd(BAND_END_EDEFAULT);
				return;
			case PCOTPackage.RECURSION_BODY__PARAM_STRUCT:
				setParamStruct((Struct)null);
				return;
			case PCOTPackage.RECURSION_BODY__LOCAL_STRUCT:
				setLocalStruct((Struct)null);
				return;
			case PCOTPackage.RECURSION_BODY__RECUR_STRUCTS:
				getRecurStructs().clear();
				return;
			case PCOTPackage.RECURSION_BODY__TILE_SIZES:
				getTileSizes().clear();
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
			case PCOTPackage.RECURSION_BODY__FUNCTION:
				return getFunction() != null;
			case PCOTPackage.RECURSION_BODY__PARALLEL:
				return parallel != PARALLEL_EDEFAULT;
			case PCOTPackage.RECURSION_BODY__BASE_FUNCTION:
				return baseFunction != null;
			case PCOTPackage.RECURSION_BODY__BAND_START:
				return bandStart != BAND_START_EDEFAULT;
			case PCOTPackage.RECURSION_BODY__BAND_END:
				return bandEnd != BAND_END_EDEFAULT;
			case PCOTPackage.RECURSION_BODY__PARAM_STRUCT:
				return paramStruct != null;
			case PCOTPackage.RECURSION_BODY__LOCAL_STRUCT:
				return localStruct != null;
			case PCOTPackage.RECURSION_BODY__RECUR_STRUCTS:
				return recurStructs != null && !recurStructs.isEmpty();
			case PCOTPackage.RECURSION_BODY__TILE_SIZES:
				return tileSizes != null && !tileSizes.isEmpty();
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (parallel: ");
		result.append(parallel);
		result.append(", bandStart: ");
		result.append(bandStart);
		result.append(", bandEnd: ");
		result.append(bandEnd);
		result.append(", tileSizes: ");
		result.append(tileSizes);
		result.append(')');
		return result.toString();
	}

} //RecursionBodyImpl
