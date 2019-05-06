/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.util;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.polyhedralIR.polyIRCG.*;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.BasicCodeUnitHeader;
import org.polymodel.polyhedralIR.polyIRCG.BasicStatement;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnitHeader;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement;
import org.polymodel.polyhedralIR.polyIRCG.DeclareStructs;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.IdentityAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjectiveAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.ScalarMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.StructManagement;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage
 * @generated
 */
public class PolyIRCGSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PolyIRCGPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyIRCGSwitch() {
		if (modelPackage == null) {
			modelPackage = PolyIRCGPackage.eINSTANCE;
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
			case PolyIRCGPackage.COMPILATION_UNIT: {
				CompilationUnit compilationUnit = (CompilationUnit)theEObject;
				T result = caseCompilationUnit(compilationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.CODE_UNIT: {
				CodeUnit codeUnit = (CodeUnit)theEObject;
				T result = caseCodeUnit(codeUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.CODE_UNIT_HEADER: {
				CodeUnitHeader codeUnitHeader = (CodeUnitHeader)theEObject;
				T result = caseCodeUnitHeader(codeUnitHeader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.BASIC_CODE_UNIT_HEADER: {
				BasicCodeUnitHeader basicCodeUnitHeader = (BasicCodeUnitHeader)theEObject;
				T result = caseBasicCodeUnitHeader(basicCodeUnitHeader);
				if (result == null) result = caseCodeUnitHeader(basicCodeUnitHeader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.DECLARE_STRUCTS: {
				DeclareStructs declareStructs = (DeclareStructs)theEObject;
				T result = caseDeclareStructs(declareStructs);
				if (result == null) result = caseCodeUnitHeader(declareStructs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.FUNCTION: {
				Function function = (Function)theEObject;
				T result = caseFunction(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.FUNCTION_SIGNATURE: {
				FunctionSignature functionSignature = (FunctionSignature)theEObject;
				T result = caseFunctionSignature(functionSignature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.STRUCT: {
				Struct struct = (Struct)theEObject;
				T result = caseStruct(struct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.VARIABLE_FUNCTION_PARAMETER: {
				VariableFunctionParameter variableFunctionParameter = (VariableFunctionParameter)theEObject;
				T result = caseVariableFunctionParameter(variableFunctionParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.ABSTRACT_VARIABLE: {
				AbstractVariable abstractVariable = (AbstractVariable)theEObject;
				T result = caseAbstractVariable(abstractVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.BASIC_VARIABLE: {
				BasicVariable basicVariable = (BasicVariable)theEObject;
				T result = caseBasicVariable(basicVariable);
				if (result == null) result = caseAbstractVariable(basicVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.CODE_GEN_VARIABLE: {
				CodeGenVariable codeGenVariable = (CodeGenVariable)theEObject;
				T result = caseCodeGenVariable(codeGenVariable);
				if (result == null) result = caseAbstractVariable(codeGenVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.MEMORY_DOMAIN: {
				MemoryDomain memoryDomain = (MemoryDomain)theEObject;
				T result = caseMemoryDomain(memoryDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.SCALAR_MEMORY_DOMAIN: {
				ScalarMemoryDomain scalarMemoryDomain = (ScalarMemoryDomain)theEObject;
				T result = caseScalarMemoryDomain(scalarMemoryDomain);
				if (result == null) result = caseMemoryDomain(scalarMemoryDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.MERGED_MEMORY_DOMAIN: {
				MergedMemoryDomain mergedMemoryDomain = (MergedMemoryDomain)theEObject;
				T result = caseMergedMemoryDomain(mergedMemoryDomain);
				if (result == null) result = caseMemoryDomain(mergedMemoryDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.PSEUDO_PROJECTION: {
				PseudoProjection pseudoProjection = (PseudoProjection)theEObject;
				T result = casePseudoProjection(pseudoProjection);
				if (result == null) result = caseMemoryDomain(pseudoProjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.BODY: {
				Body body = (Body)theEObject;
				T result = caseBody(body);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.BASIC_BODY: {
				BasicBody basicBody = (BasicBody)theEObject;
				T result = caseBasicBody(basicBody);
				if (result == null) result = caseBody(basicBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.VARIABLE_INITIALIZATION: {
				VariableInitialization variableInitialization = (VariableInitialization)theEObject;
				T result = caseVariableInitialization(variableInitialization);
				if (result == null) result = caseBody(variableInitialization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.FLAG_VARIABLE_RESET: {
				FlagVariableReset flagVariableReset = (FlagVariableReset)theEObject;
				T result = caseFlagVariableReset(flagVariableReset);
				if (result == null) result = caseBody(flagVariableReset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.VARIABLE_FINALIZATION: {
				VariableFinalization variableFinalization = (VariableFinalization)theEObject;
				T result = caseVariableFinalization(variableFinalization);
				if (result == null) result = caseBody(variableFinalization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.STRUCT_MANAGEMENT: {
				StructManagement structManagement = (StructManagement)theEObject;
				T result = caseStructManagement(structManagement);
				if (result == null) result = caseBody(structManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.PACK_STRUCT: {
				PackStruct packStruct = (PackStruct)theEObject;
				T result = casePackStruct(packStruct);
				if (result == null) result = caseStructManagement(packStruct);
				if (result == null) result = caseBody(packStruct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.CUSTOM_PACK_STRUCT: {
				CustomPackStruct customPackStruct = (CustomPackStruct)theEObject;
				T result = caseCustomPackStruct(customPackStruct);
				if (result == null) result = caseStructManagement(customPackStruct);
				if (result == null) result = caseBody(customPackStruct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.UNPACK_STRUCT: {
				UnpackStruct unpackStruct = (UnpackStruct)theEObject;
				T result = caseUnpackStruct(unpackStruct);
				if (result == null) result = caseStructManagement(unpackStruct);
				if (result == null) result = caseBody(unpackStruct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.LOOP: {
				Loop loop = (Loop)theEObject;
				T result = caseLoop(loop);
				if (result == null) result = caseBody(loop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.BASIC_STATEMENT: {
				BasicStatement basicStatement = (BasicStatement)theEObject;
				T result = caseBasicStatement(basicStatement);
				if (result == null) result = caseStatement(basicStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.MEMORY_ACCESS_EXPRESSION: {
				MemoryAccessExpression memoryAccessExpression = (MemoryAccessExpression)theEObject;
				T result = caseMemoryAccessExpression(memoryAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.PSEUDO_PROJECTIVE_ACCESS_EXPRESSION: {
				PseudoProjectiveAccessExpression pseudoProjectiveAccessExpression = (PseudoProjectiveAccessExpression)theEObject;
				T result = casePseudoProjectiveAccessExpression(pseudoProjectiveAccessExpression);
				if (result == null) result = caseMemoryAccessExpression(pseudoProjectiveAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.IDENTITY_ACCESS_EXPRESSION: {
				IdentityAccessExpression identityAccessExpression = (IdentityAccessExpression)theEObject;
				T result = caseIdentityAccessExpression(identityAccessExpression);
				if (result == null) result = caseMemoryAccessExpression(identityAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION: {
				MergedDomainAccessExpression mergedDomainAccessExpression = (MergedDomainAccessExpression)theEObject;
				T result = caseMergedDomainAccessExpression(mergedDomainAccessExpression);
				if (result == null) result = caseMemoryAccessExpression(mergedDomainAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.COMPILE_TIME_PARAMETER: {
				CompileTimeParameter compileTimeParameter = (CompileTimeParameter)theEObject;
				T result = caseCompileTimeParameter(compileTimeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PolyIRCGPackage.CUSTOM_PROVIDER_STATEMENT: {
				CustomProviderStatement customProviderStatement = (CustomProviderStatement)theEObject;
				T result = caseCustomProviderStatement(customProviderStatement);
				if (result == null) result = caseStatement(customProviderStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compilation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompilationUnit(CompilationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeUnit(CodeUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Unit Header</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Unit Header</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeUnitHeader(CodeUnitHeader object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Code Unit Header</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Code Unit Header</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicCodeUnitHeader(BasicCodeUnitHeader object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declare Structs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declare Structs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclareStructs(DeclareStructs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryDomain(MemoryDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Memory Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Memory Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarMemoryDomain(ScalarMemoryDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merged Memory Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merged Memory Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergedMemoryDomain(MergedMemoryDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pseudo Projection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pseudo Projection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePseudoProjection(PseudoProjection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBody(Body object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicBody(BasicBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Initialization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Initialization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableInitialization(VariableInitialization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flag Variable Reset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flag Variable Reset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlagVariableReset(FlagVariableReset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Finalization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Finalization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableFinalization(VariableFinalization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructManagement(StructManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pack Struct</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pack Struct</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackStruct(PackStruct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Pack Struct</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Pack Struct</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomPackStruct(CustomPackStruct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unpack Struct</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unpack Struct</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnpackStruct(UnpackStruct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoop(Loop object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Function Signature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionSignature(FunctionSignature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStruct(Struct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Function Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Function Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableFunctionParameter(VariableFunctionParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractVariable(AbstractVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicVariable(BasicVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Gen Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Gen Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeGenVariable(CodeGenVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicStatement(BasicStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryAccessExpression(MemoryAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pseudo Projective Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pseudo Projective Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePseudoProjectiveAccessExpression(PseudoProjectiveAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identity Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identity Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentityAccessExpression(IdentityAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merged Domain Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merged Domain Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergedDomainAccessExpression(MergedDomainAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compile Time Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compile Time Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompileTimeParameter(CompileTimeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Provider Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Provider Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomProviderStatement(CustomProviderStatement object) {
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

} //PolyIRCGSwitch
