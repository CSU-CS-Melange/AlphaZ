/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.*;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.BasicCodeUnitHeader;
import org.polymodel.polyhedralIR.polyIRCG.BasicStatement;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement;
import org.polymodel.polyhedralIR.polyIRCG.DeclareStructs;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.IdentityAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGFactory;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjectiveAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.ScalarMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PolyIRCGFactoryImpl extends EFactoryImpl implements PolyIRCGFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PolyIRCGFactory init() {
		try {
			PolyIRCGFactory thePolyIRCGFactory = (PolyIRCGFactory)EPackage.Registry.INSTANCE.getEFactory(PolyIRCGPackage.eNS_URI);
			if (thePolyIRCGFactory != null) {
				return thePolyIRCGFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PolyIRCGFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyIRCGFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PolyIRCGPackage.COMPILATION_UNIT: return createCompilationUnit();
			case PolyIRCGPackage.CODE_UNIT: return createCodeUnit();
			case PolyIRCGPackage.BASIC_CODE_UNIT_HEADER: return createBasicCodeUnitHeader();
			case PolyIRCGPackage.DECLARE_STRUCTS: return createDeclareStructs();
			case PolyIRCGPackage.FUNCTION: return createFunction();
			case PolyIRCGPackage.FUNCTION_SIGNATURE: return createFunctionSignature();
			case PolyIRCGPackage.STRUCT: return createStruct();
			case PolyIRCGPackage.VARIABLE_FUNCTION_PARAMETER: return createVariableFunctionParameter();
			case PolyIRCGPackage.BASIC_VARIABLE: return createBasicVariable();
			case PolyIRCGPackage.CODE_GEN_VARIABLE: return createCodeGenVariable();
			case PolyIRCGPackage.SCALAR_MEMORY_DOMAIN: return createScalarMemoryDomain();
			case PolyIRCGPackage.MERGED_MEMORY_DOMAIN: return createMergedMemoryDomain();
			case PolyIRCGPackage.PSEUDO_PROJECTION: return createPseudoProjection();
			case PolyIRCGPackage.BASIC_BODY: return createBasicBody();
			case PolyIRCGPackage.VARIABLE_INITIALIZATION: return createVariableInitialization();
			case PolyIRCGPackage.FLAG_VARIABLE_RESET: return createFlagVariableReset();
			case PolyIRCGPackage.VARIABLE_FINALIZATION: return createVariableFinalization();
			case PolyIRCGPackage.PACK_STRUCT: return createPackStruct();
			case PolyIRCGPackage.CUSTOM_PACK_STRUCT: return createCustomPackStruct();
			case PolyIRCGPackage.UNPACK_STRUCT: return createUnpackStruct();
			case PolyIRCGPackage.BASIC_STATEMENT: return createBasicStatement();
			case PolyIRCGPackage.PSEUDO_PROJECTIVE_ACCESS_EXPRESSION: return createPseudoProjectiveAccessExpression();
			case PolyIRCGPackage.IDENTITY_ACCESS_EXPRESSION: return createIdentityAccessExpression();
			case PolyIRCGPackage.MERGED_DOMAIN_ACCESS_EXPRESSION: return createMergedDomainAccessExpression();
			case PolyIRCGPackage.COMPILE_TIME_PARAMETER: return createCompileTimeParameter();
			case PolyIRCGPackage.CUSTOM_PROVIDER_STATEMENT: return createCustomProviderStatement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case PolyIRCGPackage.MACRO_BODY_PROVIDER:
				return createMacroBodyProviderFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case PolyIRCGPackage.MACRO_BODY_PROVIDER:
				return convertMacroBodyProviderToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilationUnit createCompilationUnit() {
		CompilationUnitImpl compilationUnit = new CompilationUnitImpl();
		return compilationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeUnit createCodeUnit() {
		CodeUnitImpl codeUnit = new CodeUnitImpl();
		return codeUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicCodeUnitHeader createBasicCodeUnitHeader() {
		BasicCodeUnitHeaderImpl basicCodeUnitHeader = new BasicCodeUnitHeaderImpl();
		return basicCodeUnitHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclareStructs createDeclareStructs() {
		DeclareStructsImpl declareStructs = new DeclareStructsImpl();
		return declareStructs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicBody createBasicBody() {
		BasicBodyImpl basicBody = new BasicBodyImpl();
		return basicBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableInitialization createVariableInitialization() {
		VariableInitializationImpl variableInitialization = new VariableInitializationImpl();
		return variableInitialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlagVariableReset createFlagVariableReset() {
		FlagVariableResetImpl flagVariableReset = new FlagVariableResetImpl();
		return flagVariableReset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableFinalization createVariableFinalization() {
		VariableFinalizationImpl variableFinalization = new VariableFinalizationImpl();
		return variableFinalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackStruct createPackStruct() {
		PackStructImpl packStruct = new PackStructImpl();
		return packStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomPackStruct createCustomPackStruct() {
		CustomPackStructImpl customPackStruct = new CustomPackStructImpl();
		return customPackStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnpackStruct createUnpackStruct() {
		UnpackStructImpl unpackStruct = new UnpackStructImpl();
		return unpackStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionSignature createFunctionSignature() {
		FunctionSignatureImpl functionSignature = new FunctionSignatureImpl();
		return functionSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Struct createStruct() {
		StructImpl struct = new StructImpl();
		return struct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableFunctionParameter createVariableFunctionParameter() {
		VariableFunctionParameterImpl variableFunctionParameter = new VariableFunctionParameterImpl();
		return variableFunctionParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicVariable createBasicVariable() {
		BasicVariableImpl basicVariable = new BasicVariableImpl();
		return basicVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeGenVariable createCodeGenVariable() {
		CodeGenVariableImpl codeGenVariable = new CodeGenVariableImpl();
		return codeGenVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarMemoryDomain createScalarMemoryDomain() {
		ScalarMemoryDomainImpl scalarMemoryDomain = new ScalarMemoryDomainImpl();
		return scalarMemoryDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergedMemoryDomain createMergedMemoryDomain() {
		MergedMemoryDomainImpl mergedMemoryDomain = new MergedMemoryDomainImpl();
		return mergedMemoryDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PseudoProjection createPseudoProjection() {
		PseudoProjectionImpl pseudoProjection = new PseudoProjectionImpl();
		return pseudoProjection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicStatement createBasicStatement() {
		BasicStatementImpl basicStatement = new BasicStatementImpl();
		return basicStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PseudoProjectiveAccessExpression createPseudoProjectiveAccessExpression() {
		PseudoProjectiveAccessExpressionImpl pseudoProjectiveAccessExpression = new PseudoProjectiveAccessExpressionImpl();
		return pseudoProjectiveAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentityAccessExpression createIdentityAccessExpression() {
		IdentityAccessExpressionImpl identityAccessExpression = new IdentityAccessExpressionImpl();
		return identityAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergedDomainAccessExpression createMergedDomainAccessExpression() {
		MergedDomainAccessExpressionImpl mergedDomainAccessExpression = new MergedDomainAccessExpressionImpl();
		return mergedDomainAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompileTimeParameter createCompileTimeParameter() {
		CompileTimeParameterImpl compileTimeParameter = new CompileTimeParameterImpl();
		return compileTimeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomProviderStatement createCustomProviderStatement() {
		CustomProviderStatementImpl customProviderStatement = new CustomProviderStatementImpl();
		return customProviderStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MacroBodyProvider createMacroBodyProviderFromString(EDataType eDataType, String initialValue) {
		return (MacroBodyProvider)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMacroBodyProviderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyIRCGPackage getPolyIRCGPackage() {
		return (PolyIRCGPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PolyIRCGPackage getPackage() {
		return PolyIRCGPackage.eINSTANCE;
	}

} //PolyIRCGFactoryImpl
