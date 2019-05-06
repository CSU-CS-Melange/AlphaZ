/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.PolymodelPackage;
import org.polymodel.impl.ValueContainedMapImpl;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingFactory;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;

import fr.irisa.cairn.graph.INode;
import fr.irisa.cairn.graph.analysis.GraphAnalysis;
import fr.irisa.cairn.graph.implement.Edge;
import fr.irisa.cairn.graph.implement.Graph;
import fr.irisa.cairn.graph.implement.Node;
import fr.irisa.cairn.graph.implement.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl#getContainerSystem <em>Container System</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl#getSpaceTimeLevels <em>Space Time Levels</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl#getMemoryMaps <em>Memory Maps</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl#getMemorySpaces <em>Memory Spaces</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl#getStatementOrderings <em>Statement Orderings</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingImpl#getUseEquationOptimizations <em>Use Equation Optimizations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetMappingImpl extends EObjectImpl implements TargetMapping {
	/**
	 * The cached value of the '{@link #getSpaceTimeLevels() <em>Space Time Levels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpaceTimeLevels()
	 * @generated
	 * @ordered
	 */
	protected EList<SpaceTimeLevel> spaceTimeLevels;

	/**
	 * The cached value of the '{@link #getMemoryMaps() <em>Memory Maps</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryMaps()
	 * @generated
	 * @ordered
	 */
	protected EMap<VariableDeclaration, MemoryMap> memoryMaps;

	/**
	 * The cached value of the '{@link #getMemorySpaces() <em>Memory Spaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySpaces()
	 * @generated
	 * @ordered
	 */
	protected EList<MemorySpace> memorySpaces;

	/**
	 * The cached value of the '{@link #getStatementOrderings() <em>Statement Orderings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatementOrderings()
	 * @generated
	 * @ordered
	 */
	protected EList<StatementPartialOrder> statementOrderings;

	/**
	 * The cached value of the '{@link #getUseEquationOptimizations() <em>Use Equation Optimizations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseEquationOptimizations()
	 * @generated
	 * @ordered
	 */
	protected EList<UseEquationOptimization> useEquationOptimizations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetMappingPackage.Literals.TARGET_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem getContainerSystem() {
		if (eContainerFeatureID() != TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM) return null;
		return (AffineSystem)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpaceTimeLevel> getSpaceTimeLevels() {
		if (spaceTimeLevels == null) {
			spaceTimeLevels = new EObjectContainmentWithInverseEList<SpaceTimeLevel>(SpaceTimeLevel.class, this, TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS, TargetMappingPackage.SPACE_TIME_LEVEL__CONTAINER_TM);
		}
		return spaceTimeLevels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<VariableDeclaration, MemoryMap> getMemoryMaps() {
		if (memoryMaps == null) {
			memoryMaps = new EcoreEMap<VariableDeclaration,MemoryMap>(PolymodelPackage.Literals.VALUE_CONTAINED_MAP, ValueContainedMapImpl.class, this, TargetMappingPackage.TARGET_MAPPING__MEMORY_MAPS);
		}
		return memoryMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemorySpace> getMemorySpaces() {
		if (memorySpaces == null) {
			memorySpaces = new EObjectContainmentWithInverseEList<MemorySpace>(MemorySpace.class, this, TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES, TargetMappingPackage.MEMORY_SPACE__CONTAINER_TM);
		}
		return memorySpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StatementPartialOrder> getStatementOrderings() {
		if (statementOrderings == null) {
			statementOrderings = new EObjectContainmentEList<StatementPartialOrder>(StatementPartialOrder.class, this, TargetMappingPackage.TARGET_MAPPING__STATEMENT_ORDERINGS);
		}
		return statementOrderings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseEquationOptimization> getUseEquationOptimizations() {
		if (useEquationOptimizations == null) {
			useEquationOptimizations = new EObjectContainmentEList<UseEquationOptimization>(UseEquationOptimization.class, this, TargetMappingPackage.TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS);
		}
		return useEquationOptimizations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SpaceTimeLevel getSpaceTimeLevel(int level) {
		if (getSpaceTimeLevels().size() > level) {
			return getSpaceTimeLevels().get(level);
		} else {
			throw new RuntimeException("SpaceTimeLevel " + level + " does not exist.");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MemoryMap getMemoryMap(VariableDeclaration variable) {
		for(MemoryMap mmap : getMemoryMaps().values()){
			if(mmap.getVariable().getVarID().equilvalence(variable.getVarID())){
				return mmap;
			}
		}
		return null;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MemorySpace getMemorySpace(String memorySpaceName) {
		for(MemorySpace mspace : getMemorySpaces()){
			if(mspace.getName().compareTo(memorySpaceName) == 0){
				return mspace;
			}
		}
		
		MemorySpace space = TargetMappingFactory.eINSTANCE.createMemorySpace();
		space.setName(memorySpaceName);
		
		getMemorySpaces().add(space);
		
		return space;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<UseEquationOptimization> getUseEquationOptimizations(String label) {
		EList<UseEquationOptimization> optims = new BasicEList<UseEquationOptimization>();
		for(UseEquationOptimization opt : getUseEquationOptimizations()){
			if(opt.getLabel().contentEquals(label)){
				optims.add(opt);
			}
		}
	
		return optims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public UseEquationOptimization getUseEquationOptimization(String label, int num, boolean isInput) {
		for(UseEquationOptimization opt : getUseEquationOptimizations()){
			if((opt.getLabel().contentEquals(label)) && (opt.getNum() == num) && (isInput == opt.isInput())){
				return opt;
			}
		}
			
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isParallelized() {
		if(getSpaceTimeLevels() != null){
			for(SpaceTimeLevel stlevel : getSpaceTimeLevels()){
				if(stlevel.getParallelizationSpecifications() != null && stlevel.getParallelizationSpecifications().size() > 0){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Equation> getStatementTotalOrder() {
		Graph graph = new Graph(true);

		Map<String, Node> equationToNode = new HashMap<String, Node>();
		Map<Node, Equation> nodeToEquation = new HashMap<Node, Equation>();
		
		//create node for all the equations
		for(StandardEquation eq : getContainerSystem().getEquations()){
			Node node = new Node();
			node.setLabel(eq.getVariable().getName());
			graph.addNode(node);
			equationToNode.put(eq.getVariable().getName(), node);
			nodeToEquation.put(node, eq);
		}
		
		for(UseEquation eq : getContainerSystem().getUseEquations()){
			Node node = new Node();
			node.setLabel(eq.getLabel());
			graph.addNode(node);
			equationToNode.put(eq.getLabel(), node);
			nodeToEquation.put(node, eq);
		}
		
		//add edges for all the partial orderings
		for(StatementPartialOrder pso : getStatementOrderings()){
			String srcName;
			if(pso.getPredecessor() instanceof StandardEquation){
				srcName = ((StandardEquation)pso.getPredecessor()).getVariable().getName();
			}else{
				srcName = ((UseEquation)pso.getPredecessor()).getLabel();
			}
			//get the src node
			Node src = equationToNode.get(srcName);
			
			String dstName;
			if(pso.getSuccessor() instanceof StandardEquation){
				dstName = ((StandardEquation) pso.getSuccessor()).getVariable().getName();
			}else{
				dstName = ((UseEquation) pso.getSuccessor()).getLabel();
			}
			//get the destination ndoe
			Node dst = equationToNode.get(dstName);
			
			
			Port srcp = new Port();
			Port dstp = new Port();
			src.addOutputPort(srcp);
			dst.addInputPort(dstp);
			Edge edge = new Edge(srcp, dstp);
			graph.addEdge(edge);
		}

		List<INode> torder = GraphAnalysis.topologicalSort(graph);
				
		//Convert the result to list of StandardEquations
		EList<Equation> res = new BasicEList<Equation>();
		for (INode node : torder) {
			res.add(nodeToEquation.get(node));
		}
				
		return res;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isTiled() {
		if(getSpaceTimeLevels() != null){
			for(SpaceTimeLevel stlevel : getSpaceTimeLevels()){
				if(stlevel.getTilingSpecifications() != null && stlevel.getTilingSpecifications().size() > 0){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitTargetMapping(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM, msgs);
			case TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpaceTimeLevels()).basicAdd(otherEnd, msgs);
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMemorySpaces()).basicAdd(otherEnd, msgs);
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
			case TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM:
				return eBasicSetContainer(null, TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM, msgs);
			case TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS:
				return ((InternalEList<?>)getSpaceTimeLevels()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_MAPS:
				return ((InternalEList<?>)getMemoryMaps()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES:
				return ((InternalEList<?>)getMemorySpaces()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.TARGET_MAPPING__STATEMENT_ORDERINGS:
				return ((InternalEList<?>)getStatementOrderings()).basicRemove(otherEnd, msgs);
			case TargetMappingPackage.TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS:
				return ((InternalEList<?>)getUseEquationOptimizations()).basicRemove(otherEnd, msgs);
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
			case TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM:
				return eInternalContainer().eInverseRemove(this, PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING, AffineSystem.class, msgs);
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
			case TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM:
				return getContainerSystem();
			case TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS:
				return getSpaceTimeLevels();
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_MAPS:
				if (coreType) return getMemoryMaps();
				else return getMemoryMaps().map();
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES:
				return getMemorySpaces();
			case TargetMappingPackage.TARGET_MAPPING__STATEMENT_ORDERINGS:
				return getStatementOrderings();
			case TargetMappingPackage.TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS:
				return getUseEquationOptimizations();
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
			case TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS:
				getSpaceTimeLevels().clear();
				getSpaceTimeLevels().addAll((Collection<? extends SpaceTimeLevel>)newValue);
				return;
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_MAPS:
				((EStructuralFeature.Setting)getMemoryMaps()).set(newValue);
				return;
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES:
				getMemorySpaces().clear();
				getMemorySpaces().addAll((Collection<? extends MemorySpace>)newValue);
				return;
			case TargetMappingPackage.TARGET_MAPPING__STATEMENT_ORDERINGS:
				getStatementOrderings().clear();
				getStatementOrderings().addAll((Collection<? extends StatementPartialOrder>)newValue);
				return;
			case TargetMappingPackage.TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS:
				getUseEquationOptimizations().clear();
				getUseEquationOptimizations().addAll((Collection<? extends UseEquationOptimization>)newValue);
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
			case TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS:
				getSpaceTimeLevels().clear();
				return;
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_MAPS:
				getMemoryMaps().clear();
				return;
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES:
				getMemorySpaces().clear();
				return;
			case TargetMappingPackage.TARGET_MAPPING__STATEMENT_ORDERINGS:
				getStatementOrderings().clear();
				return;
			case TargetMappingPackage.TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS:
				getUseEquationOptimizations().clear();
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
			case TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM:
				return getContainerSystem() != null;
			case TargetMappingPackage.TARGET_MAPPING__SPACE_TIME_LEVELS:
				return spaceTimeLevels != null && !spaceTimeLevels.isEmpty();
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_MAPS:
				return memoryMaps != null && !memoryMaps.isEmpty();
			case TargetMappingPackage.TARGET_MAPPING__MEMORY_SPACES:
				return memorySpaces != null && !memorySpaces.isEmpty();
			case TargetMappingPackage.TARGET_MAPPING__STATEMENT_ORDERINGS:
				return statementOrderings != null && !statementOrderings.isEmpty();
			case TargetMappingPackage.TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS:
				return useEquationOptimizations != null && !useEquationOptimizations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public TilingSpecification getTilingSpecification(int level, String name) {
		return getSpaceTimeLevel(level).getTilingSpecification(name);
	}
} //TargetMappingImpl
