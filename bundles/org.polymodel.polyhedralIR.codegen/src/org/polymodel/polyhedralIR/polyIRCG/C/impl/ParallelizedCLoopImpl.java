/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.PolymodelPackage;
import org.polymodel.impl.ValueContainedMapImpl;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.SubSystemCodeGenUtilityForC;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.util.ScopLoopIteratorUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallelized CLoop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ParallelizedCLoopImpl#getParallelizedDims <em>Parallelized Dims</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ParallelizedCLoopImpl#getOrderingDims <em>Ordering Dims</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.ParallelizedCLoopImpl#getSubsystemVariables <em>Subsystem Variables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParallelizedCLoopImpl extends CLoopImpl implements ParallelizedCLoop {
	/**
	 * The cached value of the '{@link #getParallelizedDims() <em>Parallelized Dims</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParallelizedDims()
	 * @generated
	 * @ordered
	 */
	protected EList<ParallelizationSpecification> parallelizedDims;

	/**
	 * The cached value of the '{@link #getOrderingDims() <em>Ordering Dims</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderingDims()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> orderingDims;

	/**
	 * The cached value of the '{@link #getSubsystemVariables() <em>Subsystem Variables</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystemVariables()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, VariableDeclaration> subsystemVariables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParallelizedCLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.PARALLELIZED_CLOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParallelizationSpecification> getParallelizedDims() {
		if (parallelizedDims == null) {
			parallelizedDims = new EObjectContainmentEList<ParallelizationSpecification>(ParallelizationSpecification.class, this, CPackage.PARALLELIZED_CLOOP__PARALLELIZED_DIMS);
		}
		return parallelizedDims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getOrderingDims() {
		if (orderingDims == null) {
			orderingDims = new EDataTypeUniqueEList<Integer>(Integer.class, this, CPackage.PARALLELIZED_CLOOP__ORDERING_DIMS);
		}
		return orderingDims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, VariableDeclaration> getSubsystemVariables() {
		if (subsystemVariables == null) {
			subsystemVariables = new EcoreEMap<String,VariableDeclaration>(PolymodelPackage.Literals.VALUE_CONTAINED_MAP, ValueContainedMapImpl.class, this, CPackage.PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES);
		}
		return subsystemVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CPackage.PARALLELIZED_CLOOP__PARALLELIZED_DIMS:
				return ((InternalEList<?>)getParallelizedDims()).basicRemove(otherEnd, msgs);
			case CPackage.PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES:
				return ((InternalEList<?>)getSubsystemVariables()).basicRemove(otherEnd, msgs);
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
			case CPackage.PARALLELIZED_CLOOP__PARALLELIZED_DIMS:
				return getParallelizedDims();
			case CPackage.PARALLELIZED_CLOOP__ORDERING_DIMS:
				return getOrderingDims();
			case CPackage.PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES:
				if (coreType) return getSubsystemVariables();
				else return getSubsystemVariables().map();
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
			case CPackage.PARALLELIZED_CLOOP__PARALLELIZED_DIMS:
				getParallelizedDims().clear();
				getParallelizedDims().addAll((Collection<? extends ParallelizationSpecification>)newValue);
				return;
			case CPackage.PARALLELIZED_CLOOP__ORDERING_DIMS:
				getOrderingDims().clear();
				getOrderingDims().addAll((Collection<? extends Integer>)newValue);
				return;
			case CPackage.PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES:
				((EStructuralFeature.Setting)getSubsystemVariables()).set(newValue);
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
			case CPackage.PARALLELIZED_CLOOP__PARALLELIZED_DIMS:
				getParallelizedDims().clear();
				return;
			case CPackage.PARALLELIZED_CLOOP__ORDERING_DIMS:
				getOrderingDims().clear();
				return;
			case CPackage.PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES:
				getSubsystemVariables().clear();
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
			case CPackage.PARALLELIZED_CLOOP__PARALLELIZED_DIMS:
				return parallelizedDims != null && !parallelizedDims.isEmpty();
			case CPackage.PARALLELIZED_CLOOP__ORDERING_DIMS:
				return orderingDims != null && !orderingDims.isEmpty();
			case CPackage.PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES:
				return subsystemVariables != null && !subsystemVariables.isEmpty();
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
		result.append(" (orderingDims: ");
		result.append(orderingDims);
		result.append(')');
		return result.toString();
	}

	@Override
	public ScopRoot generateScop() {
		ScopRoot root = super.generateScop();
		
		Map<String, VariableDeclaration> special_vars = new HashMap<String, VariableDeclaration>();
		for(Map.Entry<String, VariableDeclaration> var: getSubsystemVariables().entrySet()){
			special_vars.put(var.getKey(), var.getValue());
		}
		
		//add the parallelization annotation into it the scop
		for(ParallelizationSpecification parallel : getParallelizedDims()){//for each parallel specification add the parallel annotation
			//find the for loop to be parallelized
			EList<ScopFor> scops = ScopLoopIteratorUtil.getScopFors(root,getOrderingDims(), parallel.getOrderingPrefix(), parallel.getParallelDims());
			//for each for loop add the parallelization annotation
			for(ScopFor scop : scops){
				//get the private iterator names
				Set<String> privates = ScopLoopIteratorUtil.getInnerScopInterationNames(scop);
				//get the private special variables
				List<String> vars = SubSystemCodeGenUtilityForC.getSepcialVariablesWithinForLoop(scop, special_vars);
				
				privates.addAll(vars);
				ParallelLoopAnnotation pla = ScopUserFactory.parallelLoopAnnotation(privates); 
				scop.getScopAnnotations().add(pla);
			}
		}
		return root;
	}
} //ParallelizedCLoopImpl
