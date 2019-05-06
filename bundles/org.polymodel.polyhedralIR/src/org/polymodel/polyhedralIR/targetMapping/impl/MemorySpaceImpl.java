/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.util.PolymodelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl#isZeroAligned <em>Zero Aligned</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.MemorySpaceImpl#getContainerTM <em>Container TM</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemorySpaceImpl extends EObjectImpl implements MemorySpace {
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
	 * The default value of the '{@link #isZeroAligned() <em>Zero Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isZeroAligned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ZERO_ALIGNED_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isZeroAligned() <em>Zero Aligned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isZeroAligned()
	 * @generated
	 * @ordered
	 */
	protected boolean zeroAligned = ZERO_ALIGNED_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemorySpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.MEMORY_SPACE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.MEMORY_SPACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		Type type = basicGetType();
		return type != null && type.eIsProxy() ? (Type)eResolveProxy((InternalEObject)type) : type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Type basicGetType() {
		Type type = null;
		for (MemoryMap mmap : getMemoryMaps()) {
			//First variable
			if (type == null) {
				type = mmap.getVariable().getType();
			//Enforce strictly equal types for now
			} else if (!type.toString().contentEquals(mmap.getVariable().getType().toString())) {
				throw new RuntimeException("Multiple variables mapped to the same memory space must shared the same type.");
			}
//			} else if (!type.equals(mmap.getVariable().getType())) {
//				throw new RuntimeException("Multiple variables mapped to the same memory space must shared the same type.");
//			}
		}
		
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDomain() {
		Domain domain = basicGetDomain();
		return domain != null && domain.eIsProxy() ? (Domain)eResolveProxy((InternalEObject)domain) : domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain basicGetDomain() {
		Domain res = null;
		String nameVarCorrespondingToRes = null;

		for (MemoryMap mmap : getMemoryMaps()) {
			AffineFunction inv;
			try {
				//inv = tm.getSpaceTimeMap(map.getVariable()).getMapping().inverse();
				//TODO: FIX here, we are assuming there is only 1 level for now
				inv = getContainerTM().getSpaceTimeLevel(0).getSpaceTimeMaps().get(mmap.getVariable().getName()).getInverseOfMapping();
				//This shouldn't be done for Wrapper TODO
				//System.out.println("check mapping for variable: " + mmap.getVariable().getName());
				//System.out.println("domain before: " +mmap.getVariable().getDomain());
				//System.out.println("the inverse function: " + inv);
				//System.out.println("mapping: " + mmap.getMapping());
				
				Domain dom = mmap.getVariable().getDomain().image(mmap.getMapping().compose(inv));
//				System.out.println("domain after: " + dom);
				if (res == null) {
					res = dom;
					nameVarCorrespondingToRes = mmap.getVariable().getName();
				} else {
					if (res.getDim() != dom.getDim()) {
						
						throw new RuntimeException("Multiple memory maps for the same memory space must share the same number of dimensions. "
								+ "Conflicting variables are " + mmap.getVariable().getName() + " (domain : " + dom + ") and "
								+ nameVarCorrespondingToRes + " (domain = " + res + ")");
					}
					res = dom.union(res);
				}
			} catch (PolymodelException e) {
				throw new RuntimeException("SpaceTimeMap given for " + mmap.getVariable() + " does not admit an Inverse");
			}	
		}
		
		if (res == null) {
			throw new RuntimeException("No variable is mapped to memory space : " + getName());
		} else {
			return res;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isZeroAligned() {
		return zeroAligned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZeroAligned(boolean newZeroAligned) {
		boolean oldZeroAligned = zeroAligned;
		zeroAligned = newZeroAligned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.MEMORY_SPACE__ZERO_ALIGNED, oldZeroAligned, zeroAligned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetMapping getContainerTM() {
		if (eContainerFeatureID() != TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM) return null;
		return (TargetMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerTM(TargetMapping newContainerTM, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainerTM, TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerTM(TargetMapping newContainerTM) {
		if (newContainerTM != eInternalContainer() || (eContainerFeatureID() != TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM && newContainerTM != null)) {
			if (EcoreUtil.isAncestor(this, newContainerTM))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainerTM != null)
				msgs = ((InternalEObject)newContainerTM).eInverseAdd(this, TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES, TargetMapping.class, msgs);
			msgs = basicSetContainerTM(newContainerTM, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM, newContainerTM, newContainerTM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<IntExpression> getModFactors() {
		List<MemoryMap> mmaps = getMemoryMaps();
		if (mmaps.size() == 0) {
			throw new RuntimeException("No MemoryMap maps to MemorySpace: " + getName());
		}
		
		//easy case
		if (mmaps.size() == 1) {
			return mmaps.get(0).getModFactors();
		}

		//with multiple mappings, max of the mod factors are used
		EList<IntExpression> combined = null;
		for (MemoryMap mmap : getMemoryMaps()) {
			if (combined == null) {
				combined = new BasicEList<IntExpression>(EcoreUtil.copyAll(mmap.getModFactors()));
			} else {
				if(combined.size() != mmap.getModFactors().size()){
					new RuntimeException("Mod factors must have the same size in MemorySpace : " + getName());
				}
				//take component-wise max
				for(int i = 0; i < combined.size(); i++){
					combined.set(i, IntExpressionBuilder.max(combined.get(i), mmap.getModFactors().get(i).copy()).simplify());
				}
			}
		}
				
		return combined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<MemoryMap> getMemoryMaps() {
		EList<MemoryMap> memoryMaps = new BasicEList<MemoryMap>();
		for (MemoryMap map : getContainerTM().getMemoryMaps().values()) {
			if (map.getSpace() == this) {
				memoryMaps.add(map);
			}
		}
		
		return memoryMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitMemorySpace(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainerTM((TargetMapping)otherEnd, msgs);
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
			case TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM:
				return basicSetContainerTM(null, msgs);
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
			case TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM:
				return eInternalContainer().eInverseRemove(this, TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES, TargetMapping.class, msgs);
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
			case TargetMappingPackage.MEMORY_SPACE__NAME:
				return getName();
			case TargetMappingPackage.MEMORY_SPACE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case TargetMappingPackage.MEMORY_SPACE__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case TargetMappingPackage.MEMORY_SPACE__ZERO_ALIGNED:
				return isZeroAligned();
			case TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM:
				return getContainerTM();
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
			case TargetMappingPackage.MEMORY_SPACE__NAME:
				setName((String)newValue);
				return;
			case TargetMappingPackage.MEMORY_SPACE__ZERO_ALIGNED:
				setZeroAligned((Boolean)newValue);
				return;
			case TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM:
				setContainerTM((TargetMapping)newValue);
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
			case TargetMappingPackage.MEMORY_SPACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TargetMappingPackage.MEMORY_SPACE__ZERO_ALIGNED:
				setZeroAligned(ZERO_ALIGNED_EDEFAULT);
				return;
			case TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM:
				setContainerTM((TargetMapping)null);
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
			case TargetMappingPackage.MEMORY_SPACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TargetMappingPackage.MEMORY_SPACE__TYPE:
				return basicGetType() != null;
			case TargetMappingPackage.MEMORY_SPACE__DOMAIN:
				return basicGetDomain() != null;
			case TargetMappingPackage.MEMORY_SPACE__ZERO_ALIGNED:
				return zeroAligned != ZERO_ALIGNED_EDEFAULT;
			case TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM:
				return getContainerTM() != null;
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
		result.append(", zeroAligned: ");
		result.append(zeroAligned);
		result.append(')');
		return result.toString();
	}

} //MemorySpaceImpl
