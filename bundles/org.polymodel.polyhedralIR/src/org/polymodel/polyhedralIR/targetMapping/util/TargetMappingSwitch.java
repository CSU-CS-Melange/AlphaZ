/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.FeatureSpecification;
import org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage
 * @generated
 */
public class TargetMappingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TargetMappingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetMappingSwitch() {
		if (modelPackage == null) {
			modelPackage = TargetMappingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TargetMappingPackage.TARGET_MAPPING: {
				TargetMapping targetMapping = (TargetMapping)theEObject;
				T result = caseTargetMapping(targetMapping);
				if (result == null) result = casePolyhedralIRVisitable(targetMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.SPACE_TIME_LEVEL: {
				SpaceTimeLevel spaceTimeLevel = (SpaceTimeLevel)theEObject;
				T result = caseSpaceTimeLevel(spaceTimeLevel);
				if (result == null) result = casePolyhedralIRVisitable(spaceTimeLevel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.SPACE_TIME_MAP: {
				SpaceTimeMap spaceTimeMap = (SpaceTimeMap)theEObject;
				T result = caseSpaceTimeMap(spaceTimeMap);
				if (result == null) result = casePolyhedralIRVisitable(spaceTimeMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.FEATURE_SPECIFICATION: {
				FeatureSpecification featureSpecification = (FeatureSpecification)theEObject;
				T result = caseFeatureSpecification(featureSpecification);
				if (result == null) result = casePolyhedralIRVisitable(featureSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.TILING_SPECIFICATION: {
				TilingSpecification tilingSpecification = (TilingSpecification)theEObject;
				T result = caseTilingSpecification(tilingSpecification);
				if (result == null) result = caseFeatureSpecification(tilingSpecification);
				if (result == null) result = casePolyhedralIRVisitable(tilingSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.LOOP_UNROLLING_SPECIFICATION: {
				LoopUnrollingSpecification loopUnrollingSpecification = (LoopUnrollingSpecification)theEObject;
				T result = caseLoopUnrollingSpecification(loopUnrollingSpecification);
				if (result == null) result = caseFeatureSpecification(loopUnrollingSpecification);
				if (result == null) result = casePolyhedralIRVisitable(loopUnrollingSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.VECTORIZATION_SPECIFICATION: {
				VectorizationSpecification vectorizationSpecification = (VectorizationSpecification)theEObject;
				T result = caseVectorizationSpecification(vectorizationSpecification);
				if (result == null) result = caseFeatureSpecification(vectorizationSpecification);
				if (result == null) result = casePolyhedralIRVisitable(vectorizationSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.PARALLELIZATION_SPECIFICATION: {
				ParallelizationSpecification parallelizationSpecification = (ParallelizationSpecification)theEObject;
				T result = caseParallelizationSpecification(parallelizationSpecification);
				if (result == null) result = caseFeatureSpecification(parallelizationSpecification);
				if (result == null) result = casePolyhedralIRVisitable(parallelizationSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.MEMORY_MAP: {
				MemoryMap memoryMap = (MemoryMap)theEObject;
				T result = caseMemoryMap(memoryMap);
				if (result == null) result = casePolyhedralIRVisitable(memoryMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.MEMORY_SPACE: {
				MemorySpace memorySpace = (MemorySpace)theEObject;
				T result = caseMemorySpace(memorySpace);
				if (result == null) result = casePolyhedralIRVisitable(memorySpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.STATEMENT_PARTIAL_ORDER: {
				StatementPartialOrder statementPartialOrder = (StatementPartialOrder)theEObject;
				T result = caseStatementPartialOrder(statementPartialOrder);
				if (result == null) result = casePolyhedralIRVisitable(statementPartialOrder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION: {
				UseEquationOptimization useEquationOptimization = (UseEquationOptimization)theEObject;
				T result = caseUseEquationOptimization(useEquationOptimization);
				if (result == null) result = casePolyhedralIRVisitable(useEquationOptimization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.COMMUNICATION_MAPPING_FOR_TILED_SPACE: {
				CommunicationMappingForTiledSpace communicationMappingForTiledSpace = (CommunicationMappingForTiledSpace)theEObject;
				T result = caseCommunicationMappingForTiledSpace(communicationMappingForTiledSpace);
				if (result == null) result = casePolyhedralIRVisitable(communicationMappingForTiledSpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE: {
				CommunicatedVariableForTiledSpace communicatedVariableForTiledSpace = (CommunicatedVariableForTiledSpace)theEObject;
				T result = caseCommunicatedVariableForTiledSpace(communicatedVariableForTiledSpace);
				if (result == null) result = casePolyhedralIRVisitable(communicatedVariableForTiledSpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetMappingPackage.SUB_TILING_SPECIFICATION: {
				SubTilingSpecification subTilingSpecification = (SubTilingSpecification)theEObject;
				T result = caseSubTilingSpecification(subTilingSpecification);
				if (result == null) result = casePolyhedralIRVisitable(subTilingSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetMapping(TargetMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Space Time Level</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Space Time Level</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpaceTimeLevel(SpaceTimeLevel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Space Time Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Space Time Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpaceTimeMap(SpaceTimeMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureSpecification(FeatureSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tiling Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tiling Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTilingSpecification(TilingSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Unrolling Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Unrolling Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopUnrollingSpecification(LoopUnrollingSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vectorization Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vectorization Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVectorizationSpecification(VectorizationSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parallelization Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parallelization Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParallelizationSpecification(ParallelizationSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryMap(MemoryMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemorySpace(MemorySpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement Partial Order</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement Partial Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatementPartialOrder(StatementPartialOrder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Equation Optimization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Equation Optimization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseEquationOptimization(UseEquationOptimization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Mapping For Tiled Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Mapping For Tiled Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationMappingForTiledSpace(CommunicationMappingForTiledSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communicated Variable For Tiled Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communicated Variable For Tiled Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicatedVariableForTiledSpace(CommunicatedVariableForTiledSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Tiling Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Tiling Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubTilingSpecification(SubTilingSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolyhedralIRVisitable(PolyhedralIRVisitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TargetMappingSwitch
