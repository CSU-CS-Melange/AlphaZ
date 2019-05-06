/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.ExistentialVariable;
import org.polymodel.Function;
import org.polymodel.IndexDimension;
import org.polymodel.InputDimension;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitable;
import org.polymodel.PolymodelVisitor;
import org.polymodel.Relation;
import org.polymodel.RelationDimension;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.Variable;

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
 * @see org.polymodel.PolymodelPackage
 * @generated
 */
public class PolymodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PolymodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolymodelSwitch() {
		if (modelPackage == null) {
			modelPackage = PolymodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case PolymodelPackage.DOMAIN: {
				Domain domain = (Domain)theEObject;
				T result = caseDomain(domain);
				if (result == null) result = casePolymodelVisitable(domain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.DIMENSIONS_MANAGER: {
				DimensionsManager dimensionsManager = (DimensionsManager)theEObject;
				T result = caseDimensionsManager(dimensionsManager);
				if (result == null) result = casePolymodelVisitable(dimensionsManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.ABSTRACT_RELATION: {
				AbstractRelation abstractRelation = (AbstractRelation)theEObject;
				T result = caseAbstractRelation(abstractRelation);
				if (result == null) result = casePolymodelVisitable(abstractRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.EXISTENTIAL_VARIABLE: {
				ExistentialVariable existentialVariable = (ExistentialVariable)theEObject;
				T result = caseExistentialVariable(existentialVariable);
				if (result == null) result = caseVariable(existentialVariable);
				if (result == null) result = casePolymodelVisitable(existentialVariable);
				if (result == null) result = caseAlgebraVisitable(existentialVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.DOMAIN_DIMENSIONS: {
				DomainDimensions domainDimensions = (DomainDimensions)theEObject;
				T result = caseDomainDimensions(domainDimensions);
				if (result == null) result = casePolymodelVisitable(domainDimensions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.INDEX_DIMENSION: {
				IndexDimension indexDimension = (IndexDimension)theEObject;
				T result = caseIndexDimension(indexDimension);
				if (result == null) result = caseVariable(indexDimension);
				if (result == null) result = casePolymodelVisitable(indexDimension);
				if (result == null) result = caseAlgebraVisitable(indexDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.RELATION_DIMENSIONS: {
				RelationDimensions relationDimensions = (RelationDimensions)theEObject;
				T result = caseRelationDimensions(relationDimensions);
				if (result == null) result = casePolymodelVisitable(relationDimensions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.BASIC_RELATION: {
				BasicRelation basicRelation = (BasicRelation)theEObject;
				T result = caseBasicRelation(basicRelation);
				if (result == null) result = casePolymodelVisitable(basicRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.RELATION: {
				Relation relation = (Relation)theEObject;
				T result = caseRelation(relation);
				if (result == null) result = caseAbstractRelation(relation);
				if (result == null) result = casePolymodelVisitable(relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.FUNCTION: {
				Function function = (Function)theEObject;
				T result = caseFunction(function);
				if (result == null) result = casePolymodelVisitable(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.VALUE_CONTAINED_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<?, ?> valueContainedMap = (Map.Entry<?, ?>)theEObject;
				T result = caseValueContainedMap(valueContainedMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.LABEL: {
				Label label = (Label)theEObject;
				T result = caseLabel(label);
				if (result == null) result = casePolymodelVisitable(label);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.RELATION_DIMENSION: {
				RelationDimension relationDimension = (RelationDimension)theEObject;
				T result = caseRelationDimension(relationDimension);
				if (result == null) result = caseVariable(relationDimension);
				if (result == null) result = casePolymodelVisitable(relationDimension);
				if (result == null) result = caseAlgebraVisitable(relationDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.INPUT_DIMENSION: {
				InputDimension inputDimension = (InputDimension)theEObject;
				T result = caseInputDimension(inputDimension);
				if (result == null) result = caseRelationDimension(inputDimension);
				if (result == null) result = caseVariable(inputDimension);
				if (result == null) result = casePolymodelVisitable(inputDimension);
				if (result == null) result = caseAlgebraVisitable(inputDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.OUTPUT_DIMENSION: {
				OutputDimension outputDimension = (OutputDimension)theEObject;
				T result = caseOutputDimension(outputDimension);
				if (result == null) result = caseRelationDimension(outputDimension);
				if (result == null) result = caseVariable(outputDimension);
				if (result == null) result = casePolymodelVisitable(outputDimension);
				if (result == null) result = caseAlgebraVisitable(outputDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.POLYMODEL_VISITOR: {
				PolymodelVisitor polymodelVisitor = (PolymodelVisitor)theEObject;
				T result = casePolymodelVisitor(polymodelVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolymodelPackage.POLYMODEL_VISITABLE: {
				PolymodelVisitable polymodelVisitable = (PolymodelVisitable)theEObject;
				T result = casePolymodelVisitable(polymodelVisitable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomain(Domain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimensions Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimensions Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDimensionsManager(DimensionsManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRelation(AbstractRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Existential Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Existential Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExistentialVariable(ExistentialVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Dimensions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Dimensions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainDimensions(DomainDimensions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexDimension(IndexDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Dimensions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Dimensions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationDimensions(RelationDimensions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicRelation(BasicRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunction(Function object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Contained Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Contained Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <K, V> T caseValueContainedMap(Map.Entry<K, V> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelation(Relation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationDimension(RelationDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputDimension(InputDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputDimension(OutputDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolymodelVisitor(PolymodelVisitor object) {
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
	public T casePolymodelVisitable(PolymodelVisitable object) {
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
	public T caseAlgebraVisitable(AlgebraVisitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
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

} //PolymodelSwitch
