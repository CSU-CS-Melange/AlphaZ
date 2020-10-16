/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getVolumeFunction <em>Volume Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getBoundComputationFunction <em>Bound Computation Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getOriginDomainVolume <em>Origin Domain Volume</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getLocalReductionFunction <em>Local Reduction Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getLocalScanFunction <em>Local Scan Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getLocalReductionVariables <em>Local Reduction Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getLocalScanReductionVariables <em>Local Scan Reduction Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getLocalInitialVariables <em>Local Initial Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getNthreadVariableName <em>Nthread Variable Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getThreadNumVariableName <em>Thread Num Variable Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getBeginVariableName <em>Begin Variable Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getEndVariableName <em>End Variable Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl#getScanReductionBody <em>Scan Reduction Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScanBodyImpl extends EObjectImpl implements ScanBody {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain domain;

	/**
	 * The cached value of the '{@link #getVolumeFunction() <em>Volume Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolumeFunction()
	 * @generated
	 * @ordered
	 */
	protected VolumeFunction volumeFunction;

	/**
	 * The cached value of the '{@link #getBoundComputationFunction() <em>Bound Computation Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundComputationFunction()
	 * @generated
	 * @ordered
	 */
	protected BoundComputation boundComputationFunction;

	/**
	 * The cached value of the '{@link #getOriginDomainVolume() <em>Origin Domain Volume</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginDomainVolume()
	 * @generated
	 * @ordered
	 */
	protected OriginDomainVolume originDomainVolume;

	/**
	 * The cached value of the '{@link #getLocalReductionFunction() <em>Local Reduction Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalReductionFunction()
	 * @generated
	 * @ordered
	 */
	protected Function localReductionFunction;

	/**
	 * The cached value of the '{@link #getLocalScanFunction() <em>Local Scan Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalScanFunction()
	 * @generated
	 * @ordered
	 */
	protected Function localScanFunction;

	/**
	 * The cached value of the '{@link #getLocalReductionVariables() <em>Local Reduction Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalReductionVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeGenVariable> localReductionVariables;

	/**
	 * The cached value of the '{@link #getLocalScanReductionVariables() <em>Local Scan Reduction Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalScanReductionVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeGenVariable> localScanReductionVariables;

	/**
	 * The cached value of the '{@link #getLocalInitialVariables() <em>Local Initial Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalInitialVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeGenVariable> localInitialVariables;

	/**
	 * The default value of the '{@link #getNthreadVariableName() <em>Nthread Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNthreadVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String NTHREAD_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNthreadVariableName() <em>Nthread Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNthreadVariableName()
	 * @generated
	 * @ordered
	 */
	protected String nthreadVariableName = NTHREAD_VARIABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getThreadNumVariableName() <em>Thread Num Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadNumVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String THREAD_NUM_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThreadNumVariableName() <em>Thread Num Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadNumVariableName()
	 * @generated
	 * @ordered
	 */
	protected String threadNumVariableName = THREAD_NUM_VARIABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBeginVariableName() <em>Begin Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String BEGIN_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBeginVariableName() <em>Begin Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginVariableName()
	 * @generated
	 * @ordered
	 */
	protected String beginVariableName = BEGIN_VARIABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndVariableName() <em>End Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String END_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndVariableName() <em>End Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndVariableName()
	 * @generated
	 * @ordered
	 */
	protected String endVariableName = END_VARIABLE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScanReductionBody() <em>Scan Reduction Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScanReductionBody()
	 * @generated
	 * @ordered
	 */
	protected ScanReductionBody scanReductionBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScanBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScanPackage.Literals.SCAN_BODY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != ScanPackage.SCAN_BODY__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, ScanPackage.SCAN_BODY__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != ScanPackage.SCAN_BODY__FUNCTION && newFunction != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (Domain)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_BODY__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Domain newDomain) {
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeFunction getVolumeFunction() {
		if (volumeFunction != null && volumeFunction.eIsProxy()) {
			InternalEObject oldVolumeFunction = (InternalEObject)volumeFunction;
			volumeFunction = (VolumeFunction)eResolveProxy(oldVolumeFunction);
			if (volumeFunction != oldVolumeFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_BODY__VOLUME_FUNCTION, oldVolumeFunction, volumeFunction));
			}
		}
		return volumeFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeFunction basicGetVolumeFunction() {
		return volumeFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolumeFunction(VolumeFunction newVolumeFunction) {
		VolumeFunction oldVolumeFunction = volumeFunction;
		volumeFunction = newVolumeFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__VOLUME_FUNCTION, oldVolumeFunction, volumeFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundComputation getBoundComputationFunction() {
		if (boundComputationFunction != null && boundComputationFunction.eIsProxy()) {
			InternalEObject oldBoundComputationFunction = (InternalEObject)boundComputationFunction;
			boundComputationFunction = (BoundComputation)eResolveProxy(oldBoundComputationFunction);
			if (boundComputationFunction != oldBoundComputationFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_BODY__BOUND_COMPUTATION_FUNCTION, oldBoundComputationFunction, boundComputationFunction));
			}
		}
		return boundComputationFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundComputation basicGetBoundComputationFunction() {
		return boundComputationFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundComputationFunction(BoundComputation newBoundComputationFunction) {
		BoundComputation oldBoundComputationFunction = boundComputationFunction;
		boundComputationFunction = newBoundComputationFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__BOUND_COMPUTATION_FUNCTION, oldBoundComputationFunction, boundComputationFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OriginDomainVolume getOriginDomainVolume() {
		if (originDomainVolume != null && originDomainVolume.eIsProxy()) {
			InternalEObject oldOriginDomainVolume = (InternalEObject)originDomainVolume;
			originDomainVolume = (OriginDomainVolume)eResolveProxy(oldOriginDomainVolume);
			if (originDomainVolume != oldOriginDomainVolume) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_BODY__ORIGIN_DOMAIN_VOLUME, oldOriginDomainVolume, originDomainVolume));
			}
		}
		return originDomainVolume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OriginDomainVolume basicGetOriginDomainVolume() {
		return originDomainVolume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginDomainVolume(OriginDomainVolume newOriginDomainVolume) {
		OriginDomainVolume oldOriginDomainVolume = originDomainVolume;
		originDomainVolume = newOriginDomainVolume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__ORIGIN_DOMAIN_VOLUME, oldOriginDomainVolume, originDomainVolume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getLocalReductionFunction() {
		if (localReductionFunction != null && localReductionFunction.eIsProxy()) {
			InternalEObject oldLocalReductionFunction = (InternalEObject)localReductionFunction;
			localReductionFunction = (Function)eResolveProxy(oldLocalReductionFunction);
			if (localReductionFunction != oldLocalReductionFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_BODY__LOCAL_REDUCTION_FUNCTION, oldLocalReductionFunction, localReductionFunction));
			}
		}
		return localReductionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetLocalReductionFunction() {
		return localReductionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalReductionFunction(Function newLocalReductionFunction) {
		Function oldLocalReductionFunction = localReductionFunction;
		localReductionFunction = newLocalReductionFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__LOCAL_REDUCTION_FUNCTION, oldLocalReductionFunction, localReductionFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getLocalScanFunction() {
		if (localScanFunction != null && localScanFunction.eIsProxy()) {
			InternalEObject oldLocalScanFunction = (InternalEObject)localScanFunction;
			localScanFunction = (Function)eResolveProxy(oldLocalScanFunction);
			if (localScanFunction != oldLocalScanFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_BODY__LOCAL_SCAN_FUNCTION, oldLocalScanFunction, localScanFunction));
			}
		}
		return localScanFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetLocalScanFunction() {
		return localScanFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalScanFunction(Function newLocalScanFunction) {
		Function oldLocalScanFunction = localScanFunction;
		localScanFunction = newLocalScanFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__LOCAL_SCAN_FUNCTION, oldLocalScanFunction, localScanFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeGenVariable> getLocalReductionVariables() {
		if (localReductionVariables == null) {
			localReductionVariables = new EObjectResolvingEList<CodeGenVariable>(CodeGenVariable.class, this, ScanPackage.SCAN_BODY__LOCAL_REDUCTION_VARIABLES);
		}
		return localReductionVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeGenVariable> getLocalScanReductionVariables() {
		if (localScanReductionVariables == null) {
			localScanReductionVariables = new EObjectResolvingEList<CodeGenVariable>(CodeGenVariable.class, this, ScanPackage.SCAN_BODY__LOCAL_SCAN_REDUCTION_VARIABLES);
		}
		return localScanReductionVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeGenVariable> getLocalInitialVariables() {
		if (localInitialVariables == null) {
			localInitialVariables = new EObjectResolvingEList<CodeGenVariable>(CodeGenVariable.class, this, ScanPackage.SCAN_BODY__LOCAL_INITIAL_VARIABLES);
		}
		return localInitialVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNthreadVariableName() {
		return nthreadVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNthreadVariableName(String newNthreadVariableName) {
		String oldNthreadVariableName = nthreadVariableName;
		nthreadVariableName = newNthreadVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__NTHREAD_VARIABLE_NAME, oldNthreadVariableName, nthreadVariableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThreadNumVariableName() {
		return threadNumVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreadNumVariableName(String newThreadNumVariableName) {
		String oldThreadNumVariableName = threadNumVariableName;
		threadNumVariableName = newThreadNumVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__THREAD_NUM_VARIABLE_NAME, oldThreadNumVariableName, threadNumVariableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBeginVariableName() {
		return beginVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeginVariableName(String newBeginVariableName) {
		String oldBeginVariableName = beginVariableName;
		beginVariableName = newBeginVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__BEGIN_VARIABLE_NAME, oldBeginVariableName, beginVariableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndVariableName() {
		return endVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndVariableName(String newEndVariableName) {
		String oldEndVariableName = endVariableName;
		endVariableName = newEndVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__END_VARIABLE_NAME, oldEndVariableName, endVariableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScanReductionBody getScanReductionBody() {
		if (scanReductionBody != null && scanReductionBody.eIsProxy()) {
			InternalEObject oldScanReductionBody = (InternalEObject)scanReductionBody;
			scanReductionBody = (ScanReductionBody)eResolveProxy(oldScanReductionBody);
			if (scanReductionBody != oldScanReductionBody) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScanPackage.SCAN_BODY__SCAN_REDUCTION_BODY, oldScanReductionBody, scanReductionBody));
			}
		}
		return scanReductionBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScanReductionBody basicGetScanReductionBody() {
		return scanReductionBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScanReductionBody(ScanReductionBody newScanReductionBody) {
		ScanReductionBody oldScanReductionBody = scanReductionBody;
		scanReductionBody = newScanReductionBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScanPackage.SCAN_BODY__SCAN_REDUCTION_BODY, oldScanReductionBody, scanReductionBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScanPackage.SCAN_BODY__FUNCTION:
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
			case ScanPackage.SCAN_BODY__FUNCTION:
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
			case ScanPackage.SCAN_BODY__FUNCTION:
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
			case ScanPackage.SCAN_BODY__FUNCTION:
				return getFunction();
			case ScanPackage.SCAN_BODY__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case ScanPackage.SCAN_BODY__VOLUME_FUNCTION:
				if (resolve) return getVolumeFunction();
				return basicGetVolumeFunction();
			case ScanPackage.SCAN_BODY__BOUND_COMPUTATION_FUNCTION:
				if (resolve) return getBoundComputationFunction();
				return basicGetBoundComputationFunction();
			case ScanPackage.SCAN_BODY__ORIGIN_DOMAIN_VOLUME:
				if (resolve) return getOriginDomainVolume();
				return basicGetOriginDomainVolume();
			case ScanPackage.SCAN_BODY__LOCAL_REDUCTION_FUNCTION:
				if (resolve) return getLocalReductionFunction();
				return basicGetLocalReductionFunction();
			case ScanPackage.SCAN_BODY__LOCAL_SCAN_FUNCTION:
				if (resolve) return getLocalScanFunction();
				return basicGetLocalScanFunction();
			case ScanPackage.SCAN_BODY__LOCAL_REDUCTION_VARIABLES:
				return getLocalReductionVariables();
			case ScanPackage.SCAN_BODY__LOCAL_SCAN_REDUCTION_VARIABLES:
				return getLocalScanReductionVariables();
			case ScanPackage.SCAN_BODY__LOCAL_INITIAL_VARIABLES:
				return getLocalInitialVariables();
			case ScanPackage.SCAN_BODY__NTHREAD_VARIABLE_NAME:
				return getNthreadVariableName();
			case ScanPackage.SCAN_BODY__THREAD_NUM_VARIABLE_NAME:
				return getThreadNumVariableName();
			case ScanPackage.SCAN_BODY__BEGIN_VARIABLE_NAME:
				return getBeginVariableName();
			case ScanPackage.SCAN_BODY__END_VARIABLE_NAME:
				return getEndVariableName();
			case ScanPackage.SCAN_BODY__SCAN_REDUCTION_BODY:
				if (resolve) return getScanReductionBody();
				return basicGetScanReductionBody();
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
			case ScanPackage.SCAN_BODY__FUNCTION:
				setFunction((Function)newValue);
				return;
			case ScanPackage.SCAN_BODY__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case ScanPackage.SCAN_BODY__VOLUME_FUNCTION:
				setVolumeFunction((VolumeFunction)newValue);
				return;
			case ScanPackage.SCAN_BODY__BOUND_COMPUTATION_FUNCTION:
				setBoundComputationFunction((BoundComputation)newValue);
				return;
			case ScanPackage.SCAN_BODY__ORIGIN_DOMAIN_VOLUME:
				setOriginDomainVolume((OriginDomainVolume)newValue);
				return;
			case ScanPackage.SCAN_BODY__LOCAL_REDUCTION_FUNCTION:
				setLocalReductionFunction((Function)newValue);
				return;
			case ScanPackage.SCAN_BODY__LOCAL_SCAN_FUNCTION:
				setLocalScanFunction((Function)newValue);
				return;
			case ScanPackage.SCAN_BODY__LOCAL_REDUCTION_VARIABLES:
				getLocalReductionVariables().clear();
				getLocalReductionVariables().addAll((Collection<? extends CodeGenVariable>)newValue);
				return;
			case ScanPackage.SCAN_BODY__LOCAL_SCAN_REDUCTION_VARIABLES:
				getLocalScanReductionVariables().clear();
				getLocalScanReductionVariables().addAll((Collection<? extends CodeGenVariable>)newValue);
				return;
			case ScanPackage.SCAN_BODY__LOCAL_INITIAL_VARIABLES:
				getLocalInitialVariables().clear();
				getLocalInitialVariables().addAll((Collection<? extends CodeGenVariable>)newValue);
				return;
			case ScanPackage.SCAN_BODY__NTHREAD_VARIABLE_NAME:
				setNthreadVariableName((String)newValue);
				return;
			case ScanPackage.SCAN_BODY__THREAD_NUM_VARIABLE_NAME:
				setThreadNumVariableName((String)newValue);
				return;
			case ScanPackage.SCAN_BODY__BEGIN_VARIABLE_NAME:
				setBeginVariableName((String)newValue);
				return;
			case ScanPackage.SCAN_BODY__END_VARIABLE_NAME:
				setEndVariableName((String)newValue);
				return;
			case ScanPackage.SCAN_BODY__SCAN_REDUCTION_BODY:
				setScanReductionBody((ScanReductionBody)newValue);
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
			case ScanPackage.SCAN_BODY__FUNCTION:
				setFunction((Function)null);
				return;
			case ScanPackage.SCAN_BODY__DOMAIN:
				setDomain((Domain)null);
				return;
			case ScanPackage.SCAN_BODY__VOLUME_FUNCTION:
				setVolumeFunction((VolumeFunction)null);
				return;
			case ScanPackage.SCAN_BODY__BOUND_COMPUTATION_FUNCTION:
				setBoundComputationFunction((BoundComputation)null);
				return;
			case ScanPackage.SCAN_BODY__ORIGIN_DOMAIN_VOLUME:
				setOriginDomainVolume((OriginDomainVolume)null);
				return;
			case ScanPackage.SCAN_BODY__LOCAL_REDUCTION_FUNCTION:
				setLocalReductionFunction((Function)null);
				return;
			case ScanPackage.SCAN_BODY__LOCAL_SCAN_FUNCTION:
				setLocalScanFunction((Function)null);
				return;
			case ScanPackage.SCAN_BODY__LOCAL_REDUCTION_VARIABLES:
				getLocalReductionVariables().clear();
				return;
			case ScanPackage.SCAN_BODY__LOCAL_SCAN_REDUCTION_VARIABLES:
				getLocalScanReductionVariables().clear();
				return;
			case ScanPackage.SCAN_BODY__LOCAL_INITIAL_VARIABLES:
				getLocalInitialVariables().clear();
				return;
			case ScanPackage.SCAN_BODY__NTHREAD_VARIABLE_NAME:
				setNthreadVariableName(NTHREAD_VARIABLE_NAME_EDEFAULT);
				return;
			case ScanPackage.SCAN_BODY__THREAD_NUM_VARIABLE_NAME:
				setThreadNumVariableName(THREAD_NUM_VARIABLE_NAME_EDEFAULT);
				return;
			case ScanPackage.SCAN_BODY__BEGIN_VARIABLE_NAME:
				setBeginVariableName(BEGIN_VARIABLE_NAME_EDEFAULT);
				return;
			case ScanPackage.SCAN_BODY__END_VARIABLE_NAME:
				setEndVariableName(END_VARIABLE_NAME_EDEFAULT);
				return;
			case ScanPackage.SCAN_BODY__SCAN_REDUCTION_BODY:
				setScanReductionBody((ScanReductionBody)null);
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
			case ScanPackage.SCAN_BODY__FUNCTION:
				return getFunction() != null;
			case ScanPackage.SCAN_BODY__DOMAIN:
				return domain != null;
			case ScanPackage.SCAN_BODY__VOLUME_FUNCTION:
				return volumeFunction != null;
			case ScanPackage.SCAN_BODY__BOUND_COMPUTATION_FUNCTION:
				return boundComputationFunction != null;
			case ScanPackage.SCAN_BODY__ORIGIN_DOMAIN_VOLUME:
				return originDomainVolume != null;
			case ScanPackage.SCAN_BODY__LOCAL_REDUCTION_FUNCTION:
				return localReductionFunction != null;
			case ScanPackage.SCAN_BODY__LOCAL_SCAN_FUNCTION:
				return localScanFunction != null;
			case ScanPackage.SCAN_BODY__LOCAL_REDUCTION_VARIABLES:
				return localReductionVariables != null && !localReductionVariables.isEmpty();
			case ScanPackage.SCAN_BODY__LOCAL_SCAN_REDUCTION_VARIABLES:
				return localScanReductionVariables != null && !localScanReductionVariables.isEmpty();
			case ScanPackage.SCAN_BODY__LOCAL_INITIAL_VARIABLES:
				return localInitialVariables != null && !localInitialVariables.isEmpty();
			case ScanPackage.SCAN_BODY__NTHREAD_VARIABLE_NAME:
				return NTHREAD_VARIABLE_NAME_EDEFAULT == null ? nthreadVariableName != null : !NTHREAD_VARIABLE_NAME_EDEFAULT.equals(nthreadVariableName);
			case ScanPackage.SCAN_BODY__THREAD_NUM_VARIABLE_NAME:
				return THREAD_NUM_VARIABLE_NAME_EDEFAULT == null ? threadNumVariableName != null : !THREAD_NUM_VARIABLE_NAME_EDEFAULT.equals(threadNumVariableName);
			case ScanPackage.SCAN_BODY__BEGIN_VARIABLE_NAME:
				return BEGIN_VARIABLE_NAME_EDEFAULT == null ? beginVariableName != null : !BEGIN_VARIABLE_NAME_EDEFAULT.equals(beginVariableName);
			case ScanPackage.SCAN_BODY__END_VARIABLE_NAME:
				return END_VARIABLE_NAME_EDEFAULT == null ? endVariableName != null : !END_VARIABLE_NAME_EDEFAULT.equals(endVariableName);
			case ScanPackage.SCAN_BODY__SCAN_REDUCTION_BODY:
				return scanReductionBody != null;
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
		result.append(" (nthreadVariableName: ");
		result.append(nthreadVariableName);
		result.append(", threadNumVariableName: ");
		result.append(threadNumVariableName);
		result.append(", beginVariableName: ");
		result.append(beginVariableName);
		result.append(", endVariableName: ");
		result.append(endVariableName);
		result.append(')');
		return result.toString();
	}

} //ScanBodyImpl
