/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.PolymodelPackage;
import org.polymodel.impl.ValueContainedMapImpl;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification;
import org.polymodel.util.PolymodelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Space Time Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl#getSpaceTimeMaps <em>Space Time Maps</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl#getOrderingDimensions <em>Ordering Dimensions</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl#getTilingSpecifications <em>Tiling Specifications</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl#getLoopUnrollingSpecifications <em>Loop Unrolling Specifications</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl#getVectorizationSpecifications <em>Vectorization Specifications</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl#getParallelizationSpecifications <em>Parallelization Specifications</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.SpaceTimeLevelImpl#getContainerTM <em>Container TM</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpaceTimeLevelImpl extends EObjectImpl implements SpaceTimeLevel {
	/**
	 * The cached value of the '{@link #getSpaceTimeMaps() <em>Space Time Maps</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpaceTimeMaps()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, SpaceTimeMap> spaceTimeMaps;

	/**
	 * The cached value of the '{@link #getOrderingDimensions() <em>Ordering Dimensions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderingDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> orderingDimensions;

	/**
	 * The cached value of the '{@link #getTilingSpecifications() <em>Tiling Specifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTilingSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<TilingSpecification> tilingSpecifications;

	/**
	 * The cached value of the '{@link #getLoopUnrollingSpecifications() <em>Loop Unrolling Specifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopUnrollingSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<LoopUnrollingSpecification> loopUnrollingSpecifications;

	/**
	 * The cached value of the '{@link #getVectorizationSpecifications() <em>Vectorization Specifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVectorizationSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<VectorizationSpecification> vectorizationSpecifications;

	/**
	 * The cached value of the '{@link #getParallelizationSpecifications() <em>Parallelization Specifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParallelizationSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<ParallelizationSpecification> parallelizationSpecifications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpaceTimeLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.SPACE_TIME_LEVEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, SpaceTimeMap> getSpaceTimeMaps() {
		if (spaceTimeMaps == null) {
			spaceTimeMaps = new EcoreEMap<String,SpaceTimeMap>(PolymodelPackage.Literals.VALUE_CONTAINED_MAP, ValueContainedMapImpl.class, this, TargetMappingPackage.SPACE_TIME_LEVEL__SPACE_TIME_MAPS);
		}
		return spaceTimeMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getOrderingDimensions() {
		if (orderingDimensions == null) {
			orderingDimensions = new EDataTypeEList<Integer>(Integer.class, this, TargetMappingPackage.SPACE_TIME_LEVEL__ORDERING_DIMENSIONS);
		}
		return orderingDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TilingSpecification> getTilingSpecifications() {
		if (tilingSpecifications == null) {
			tilingSpecifications = new EObjectContainmentEList<TilingSpecification>(TilingSpecification.class, this, TargetMappingPackage.SPACE_TIME_LEVEL__TILING_SPECIFICATIONS);
		}
		return tilingSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LoopUnrollingSpecification> getLoopUnrollingSpecifications() {
		if (loopUnrollingSpecifications == null) {
			loopUnrollingSpecifications = new EObjectContainmentEList<LoopUnrollingSpecification>(LoopUnrollingSpecification.class, this, TargetMappingPackage.SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS);
		}
		return loopUnrollingSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VectorizationSpecification> getVectorizationSpecifications() {
		if (vectorizationSpecifications == null) {
			vectorizationSpecifications = new EObjectContainmentEList<VectorizationSpecification>(VectorizationSpecification.class, this, TargetMappingPackage.SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS);
		}
		return vectorizationSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParallelizationSpecification> getParallelizationSpecifications() {
		if (parallelizationSpecifications == null) {
			parallelizationSpecifications = new EObjectContainmentEList<ParallelizationSpecification>(ParallelizationSpecification.class, this, TargetMappingPackage.SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS);
		}
		return parallelizationSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetMapping getContainerTM() {
		if (eContainerFeatureID() != TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM) return null;
		return (TargetMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerTM(TargetMapping newContainerTM, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainerTM, TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerTM(TargetMapping newContainerTM) {
		if (newContainerTM != eInternalContainer() || (eContainerFeatureID() != TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM && newContainerTM != null)) {
			if (EcoreUtil.isAncestor(this, newContainerTM))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainerTM != null)
				msgs = ((InternalEObject)newContainerTM).eInverseAdd(this, TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS, TargetMapping.class, msgs);
			msgs = basicSetContainerTM(newContainerTM, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM, newContainerTM, newContainerTM));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNumberOfOrderingDimensions() {
		return getOrderingDimensions().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNumberOfTiledDimensions() {
		int tiled = 0;
		
		for (TilingSpecification ts : getTilingSpecifications()) {
			int tiledCount = 0;
			for (int i = ts.getStartDim(); i <= ts.getEndDim(); i++) {
				if (getOrderingDimensions().contains(i)) continue;
				tiledCount++;
			}
			tiled = Math.max(tiled, tiledCount);
		}
		
		if(tiled == 0){	//when no specific tiling information specified, assume all the dimensions are tiled
			tiled = getNumberOfDimensions() - getNumberOfOrderingDimensions();
		}
		
		return tiled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNumberOfParallelDimensions() {
		boolean[] parallel = new boolean[getNumberOfDimensions()];
		for(ParallelizationSpecification ps : getParallelizationSpecifications()){
			for (int dim : ps.getParallelDims()) {
				parallel[dim] = true;
			}
		}
		//get the number of tiled dimensions
		int parallelDims = 0;
		for(boolean p : parallel){
			if(p) parallelDims++;
		}
		
		return parallelDims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNumberOfSequentialDimensions() {
		return getNumberOfDimensions() - getNumberOfOrderingDimensions() - getNumberOfParallelDimensions();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNumberOfDimensions() {
		int num = -1;
		String varCorrespondingToValueOfNum = "";
		AffineFunction mappingCorrToValueOfNum = null;
		//get all the output variables of the useEquation
		List<VariableDeclaration> vars = new LinkedList<VariableDeclaration>();
		for(UseEquation eq : getContainerTM().getContainerSystem().getUseEquations()){
			vars.addAll(eq.getOutputs());
		}
		
		for (SpaceTimeMap stmap : getSpaceTimeMaps().values()) {
			//check whether the space time map is specified for the variable or use equation
			if(getContainerTM().getContainerSystem().getVariableDeclaration(stmap.getLabel()) != null){	//space time map for variable
				VariableDeclaration var = getContainerTM().getContainerSystem().getVariableDeclaration(stmap.getLabel());
				//skip the inputs
				if(var.isInput()) continue;
				//skip the outputs of the useEquation
				if (vars.contains(var)) continue;
				//first map initializes the boolean array
				if (num == -1) {
					num = stmap.getMapping().getDimRHS();
					varCorrespondingToValueOfNum = stmap.getLabel();
					mappingCorrToValueOfNum = stmap.getMapping().copy();
				} else if (num != stmap.getMapping().getDimRHS()) {
					throw new RuntimeException("RHS of SpaceTimeMap must be have the same number of dimensions for all variables and use equations. "
							+ "Conflicting variables are " + stmap.getLabel() + " (mapping: " + stmap.getMapping() + ")"
							+ " and " + varCorrespondingToValueOfNum + " (mapping: " + mappingCorrToValueOfNum + ")");
				}
			}else if(getContainerTM().getContainerSystem().getUseEquation(stmap.getLabel()) != null){// space time map for use equation
				//first map initializes the boolean array
				if (num == -1) {
					num = stmap.getMapping().getDimRHS();
					varCorrespondingToValueOfNum = stmap.getLabel();
					mappingCorrToValueOfNum = stmap.getMapping().copy();
				} else if (num != stmap.getMapping().getDimRHS()) {
					throw new RuntimeException("RHS of SpaceTimeMap must be have the same number of dimensions for all variables and use equations. "
							+ "Conflicting variables are " + stmap.getLabel() + " (mapping: " + stmap.getMapping() + ")"
							+ " and " + varCorrespondingToValueOfNum + " (mapping: " + mappingCorrToValueOfNum + ")");
				}
			}else{	//throw exception
				throw new RuntimeException("There is no variable or use equation whose name or lable is " + stmap.getLabel() + ".");
			}		
		}
		
		return num;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineFunction getAccessFunction(VariableDeclaration variable) {
		//Check memory
		if (getContainerTM().getMemoryMaps().get(variable) == null) {
			throw new RuntimeException("Memory map is not specified for variable : " + variable.getName());
		}
		
		//Check ST
		if (getSpaceTimeMaps().get(variable.getName()) == null) {
			throw new RuntimeException("Space Time map is not specified for variable : " + variable.getName());
		}
		
		//Compute Access Function
		AffineFunction access = getContainerTM().getMemoryMaps().get(variable).getMapping();
		AffineFunction invST;
		try {
			//invST = getSpaceTimeMap(var).getMapping().inverse(null);
			invST = getSpaceTimeMaps().get(variable.getName()).getInverseOfMapping();
		} catch (PolymodelException pme) {
			throw new RuntimeException("No inverse found for schedule given to " + variable.getName() + "(" + getSpaceTimeMaps().get(variable.getName()).getMapping()+")");
		}
				
		return  access.compose(invST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TilingSpecification getTilingSpecification(String bandName) {
		for(TilingSpecification spec: getTilingSpecifications()){
			if(spec.getIdentificationName().contentEquals(bandName)){
				return spec;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitSpaceTimeLevel(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM:
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
			case TargetMappingPackage.SPACE_TIME_LEVEL__SPACE_TIME_MAPS:
				return ((InternalEList<?>)getSpaceTimeMaps()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.SPACE_TIME_LEVEL__TILING_SPECIFICATIONS:
				return ((InternalEList<?>)getTilingSpecifications()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS:
				return ((InternalEList<?>)getLoopUnrollingSpecifications()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS:
				return ((InternalEList<?>)getVectorizationSpecifications()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS:
				return ((InternalEList<?>)getParallelizationSpecifications()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM:
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
			case TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM:
				return eInternalContainer().eInverseRemove(this, TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS, TargetMapping.class, msgs);
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
			case TargetMappingPackage.SPACE_TIME_LEVEL__SPACE_TIME_MAPS:
				if (coreType) return getSpaceTimeMaps();
				else return getSpaceTimeMaps().map();
			case TargetMappingPackage.SPACE_TIME_LEVEL__ORDERING_DIMENSIONS:
				return getOrderingDimensions();
			case TargetMappingPackage.SPACE_TIME_LEVEL__TILING_SPECIFICATIONS:
				return getTilingSpecifications();
			case TargetMappingPackage.SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS:
				return getLoopUnrollingSpecifications();
			case TargetMappingPackage.SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS:
				return getVectorizationSpecifications();
			case TargetMappingPackage.SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS:
				return getParallelizationSpecifications();
			case TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM:
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
			case TargetMappingPackage.SPACE_TIME_LEVEL__SPACE_TIME_MAPS:
				((EStructuralFeature.Setting)getSpaceTimeMaps()).set(newValue);
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__ORDERING_DIMENSIONS:
				getOrderingDimensions().clear();
				getOrderingDimensions().addAll((Collection<? extends Integer>)newValue);
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__TILING_SPECIFICATIONS:
				getTilingSpecifications().clear();
				getTilingSpecifications().addAll((Collection<? extends TilingSpecification>)newValue);
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS:
				getLoopUnrollingSpecifications().clear();
				getLoopUnrollingSpecifications().addAll((Collection<? extends LoopUnrollingSpecification>)newValue);
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS:
				getVectorizationSpecifications().clear();
				getVectorizationSpecifications().addAll((Collection<? extends VectorizationSpecification>)newValue);
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS:
				getParallelizationSpecifications().clear();
				getParallelizationSpecifications().addAll((Collection<? extends ParallelizationSpecification>)newValue);
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM:
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
			case TargetMappingPackage.SPACE_TIME_LEVEL__SPACE_TIME_MAPS:
				getSpaceTimeMaps().clear();
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__ORDERING_DIMENSIONS:
				getOrderingDimensions().clear();
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__TILING_SPECIFICATIONS:
				getTilingSpecifications().clear();
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS:
				getLoopUnrollingSpecifications().clear();
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS:
				getVectorizationSpecifications().clear();
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS:
				getParallelizationSpecifications().clear();
				return;
			case TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM:
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
			case TargetMappingPackage.SPACE_TIME_LEVEL__SPACE_TIME_MAPS:
				return spaceTimeMaps != null && !spaceTimeMaps.isEmpty();
			case TargetMappingPackage.SPACE_TIME_LEVEL__ORDERING_DIMENSIONS:
				return orderingDimensions != null && !orderingDimensions.isEmpty();
			case TargetMappingPackage.SPACE_TIME_LEVEL__TILING_SPECIFICATIONS:
				return tilingSpecifications != null && !tilingSpecifications.isEmpty();
			case TargetMappingPackage.SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS:
				return loopUnrollingSpecifications != null && !loopUnrollingSpecifications.isEmpty();
			case TargetMappingPackage.SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS:
				return vectorizationSpecifications != null && !vectorizationSpecifications.isEmpty();
			case TargetMappingPackage.SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS:
				return parallelizationSpecifications != null && !parallelizationSpecifications.isEmpty();
			case TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM:
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
		result.append(" (orderingDimensions: ");
		result.append(orderingDimensions);
		result.append(')');
		return result.toString();
	}

} //SpaceTimeLevelImpl
