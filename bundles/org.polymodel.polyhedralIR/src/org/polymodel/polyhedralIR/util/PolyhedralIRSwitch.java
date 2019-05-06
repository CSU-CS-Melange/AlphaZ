/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRDepthFirstVisitor;
import org.polymodel.polyhedralIR.PolyhedralIRInheritedDepthFirstVisitor;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.TilingInformations;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.WhileInfo;

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
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage
 * @generated
 */
public class PolyhedralIRSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PolyhedralIRPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyhedralIRSwitch() {
		if (modelPackage == null) {
			modelPackage = PolyhedralIRPackage.eINSTANCE;
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
			case PolyhedralIRPackage.PROGRAM: {
				Program program = (Program)theEObject;
				T result = caseProgram(program);
				if (result == null) result = casePolyhedralIRVisitable(program);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.EXTERNAL_FUNCTION_DECLARATION: {
				ExternalFunctionDeclaration externalFunctionDeclaration = (ExternalFunctionDeclaration)theEObject;
				T result = caseExternalFunctionDeclaration(externalFunctionDeclaration);
				if (result == null) result = casePolyhedralIRVisitable(externalFunctionDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.AFFINE_SYSTEM: {
				AffineSystem affineSystem = (AffineSystem)theEObject;
				T result = caseAffineSystem(affineSystem);
				if (result == null) result = casePolyhedralIRVisitable(affineSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = casePolyhedralIRVisitable(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.VARIABLE_IDENTIFIER: {
				VariableIdentifier variableIdentifier = (VariableIdentifier)theEObject;
				T result = caseVariableIdentifier(variableIdentifier);
				if (result == null) result = casePolyhedralIRVisitable(variableIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.EQUATION: {
				Equation equation = (Equation)theEObject;
				T result = caseEquation(equation);
				if (result == null) result = casePolyhedralIRVisitable(equation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.USE_EQUATION: {
				UseEquation useEquation = (UseEquation)theEObject;
				T result = caseUseEquation(useEquation);
				if (result == null) result = caseEquation(useEquation);
				if (result == null) result = casePolyhedralIRVisitable(useEquation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.STANDARD_EQUATION: {
				StandardEquation standardEquation = (StandardEquation)theEObject;
				T result = caseStandardEquation(standardEquation);
				if (result == null) result = caseEquation(standardEquation);
				if (result == null) result = casePolyhedralIRVisitable(standardEquation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.DOMAIN: {
				Domain domain = (Domain)theEObject;
				T result = caseDomain(domain);
				if (result == null) result = casePolyhedralIRVisitable(domain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.PARAMETER_DOMAIN: {
				ParameterDomain parameterDomain = (ParameterDomain)theEObject;
				T result = caseParameterDomain(parameterDomain);
				if (result == null) result = caseDomain(parameterDomain);
				if (result == null) result = casePolyhedralIRVisitable(parameterDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.AFFINE_FUNCTION: {
				AffineFunction affineFunction = (AffineFunction)theEObject;
				T result = caseAffineFunction(affineFunction);
				if (result == null) result = casePolyhedralIRVisitable(affineFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = casePolyhedralIRVisitable(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.FAST_ISL_DOMAIN: {
				FastISLDomain fastISLDomain = (FastISLDomain)theEObject;
				T result = caseFastISLDomain(fastISLDomain);
				if (result == null) result = caseDomain(fastISLDomain);
				if (result == null) result = casePolyhedralIRVisitable(fastISLDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.FAST_ISL_MAP: {
				FastISLMap fastISLMap = (FastISLMap)theEObject;
				T result = caseFastISLMap(fastISLMap);
				if (result == null) result = caseAffineFunction(fastISLMap);
				if (result == null) result = casePolyhedralIRVisitable(fastISLMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.WHILE_INFO: {
				WhileInfo whileInfo = (WhileInfo)theEObject;
				T result = caseWhileInfo(whileInfo);
				if (result == null) result = casePolyhedralIRVisitable(whileInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.TILING_INFORMATIONS: {
				TilingInformations tilingInformations = (TilingInformations)theEObject;
				T result = caseTilingInformations(tilingInformations);
				if (result == null) result = casePolyhedralIRVisitable(tilingInformations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.POLYHEDRAL_IR_VISITOR: {
				PolyhedralIRVisitor polyhedralIRVisitor = (PolyhedralIRVisitor)theEObject;
				T result = casePolyhedralIRVisitor(polyhedralIRVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.POLYHEDRAL_IR_VISITABLE: {
				PolyhedralIRVisitable polyhedralIRVisitable = (PolyhedralIRVisitable)theEObject;
				T result = casePolyhedralIRVisitable(polyhedralIRVisitable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.POLYHEDRAL_IR_DEPTH_FIRST_VISITOR: {
				PolyhedralIRDepthFirstVisitor polyhedralIRDepthFirstVisitor = (PolyhedralIRDepthFirstVisitor)theEObject;
				T result = casePolyhedralIRDepthFirstVisitor(polyhedralIRDepthFirstVisitor);
				if (result == null) result = casePolyhedralIRVisitor(polyhedralIRDepthFirstVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyhedralIRPackage.POLYHEDRAL_IR_INHERITED_DEPTH_FIRST_VISITOR: {
				PolyhedralIRInheritedDepthFirstVisitor polyhedralIRInheritedDepthFirstVisitor = (PolyhedralIRInheritedDepthFirstVisitor)theEObject;
				T result = casePolyhedralIRInheritedDepthFirstVisitor(polyhedralIRInheritedDepthFirstVisitor);
				if (result == null) result = casePolyhedralIRVisitor(polyhedralIRInheritedDepthFirstVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Function Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalFunctionDeclaration(ExternalFunctionDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Affine System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Affine System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAffineSystem(AffineSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableIdentifier(VariableIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquation(Equation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Equation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Equation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseEquation(UseEquation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Standard Equation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Standard Equation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStandardEquation(StandardEquation object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDomain(ParameterDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Affine Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Affine Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAffineFunction(AffineFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fast ISL Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fast ISL Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFastISLDomain(FastISLDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fast ISL Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fast ISL Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFastISLMap(FastISLMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileInfo(WhileInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tiling Informations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tiling Informations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTilingInformations(TilingInformations object) {
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
	public T casePolyhedralIRVisitor(PolyhedralIRVisitor object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Depth First Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depth First Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolyhedralIRDepthFirstVisitor(PolyhedralIRDepthFirstVisitor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inherited Depth First Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inherited Depth First Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolyhedralIRInheritedDepthFirstVisitor(PolyhedralIRInheritedDepthFirstVisitor object) {
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

} //PolyhedralIRSwitch
