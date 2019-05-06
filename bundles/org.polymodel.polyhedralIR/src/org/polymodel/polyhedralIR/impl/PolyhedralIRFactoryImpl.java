/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;


import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRDepthFirstVisitor;
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
import org.polymodel.polyhedralIR.PolyhedralIRInheritedDepthFirstVisitor;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.TilingInformations;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.WhileInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PolyhedralIRFactoryImpl extends EFactoryImpl implements PolyhedralIRFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PolyhedralIRFactory init() {
		try {
			PolyhedralIRFactory thePolyhedralIRFactory = (PolyhedralIRFactory)EPackage.Registry.INSTANCE.getEFactory(PolyhedralIRPackage.eNS_URI);
			if (thePolyhedralIRFactory != null) {
				return thePolyhedralIRFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PolyhedralIRFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyhedralIRFactoryImpl() {
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
			case PolyhedralIRPackage.PROGRAM: return createProgram();
			case PolyhedralIRPackage.EXTERNAL_FUNCTION_DECLARATION: return createExternalFunctionDeclaration();
			case PolyhedralIRPackage.AFFINE_SYSTEM: return createAffineSystem();
			case PolyhedralIRPackage.TYPE: return createType();
			case PolyhedralIRPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case PolyhedralIRPackage.VARIABLE_IDENTIFIER: return createVariableIdentifier();
			case PolyhedralIRPackage.USE_EQUATION: return createUseEquation();
			case PolyhedralIRPackage.STANDARD_EQUATION: return createStandardEquation();
			case PolyhedralIRPackage.DOMAIN: return createDomain();
			case PolyhedralIRPackage.PARAMETER_DOMAIN: return createParameterDomain();
			case PolyhedralIRPackage.AFFINE_FUNCTION: return createAffineFunction();
			case PolyhedralIRPackage.FAST_ISL_DOMAIN: return createFastISLDomain();
			case PolyhedralIRPackage.FAST_ISL_MAP: return createFastISLMap();
			case PolyhedralIRPackage.WHILE_INFO: return createWhileInfo();
			case PolyhedralIRPackage.TILING_INFORMATIONS: return createTilingInformations();
			case PolyhedralIRPackage.POLYHEDRAL_IR_DEPTH_FIRST_VISITOR: return createPolyhedralIRDepthFirstVisitor();
			case PolyhedralIRPackage.POLYHEDRAL_IR_INHERITED_DEPTH_FIRST_VISITOR: return createPolyhedralIRInheritedDepthFirstVisitor();
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
			case PolyhedralIRPackage.SIGNED:
				return createSIGNEDFromString(eDataType, initialValue);
			case PolyhedralIRPackage.DATATYPE:
				return createDATATYPEFromString(eDataType, initialValue);
			case PolyhedralIRPackage.OP:
				return createOPFromString(eDataType, initialValue);
			case PolyhedralIRPackage.JNIISL_SET:
				return createJNIISLSetFromString(eDataType, initialValue);
			case PolyhedralIRPackage.JNIISL_BASIC_MAP:
				return createJNIISLBasicMapFromString(eDataType, initialValue);
			case PolyhedralIRPackage.LONG_MATRIX:
				return createlongMatrixFromString(eDataType, initialValue);
			case PolyhedralIRPackage.LIST_STRING:
				return createListStringFromString(eDataType, initialValue);
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
			case PolyhedralIRPackage.SIGNED:
				return convertSIGNEDToString(eDataType, instanceValue);
			case PolyhedralIRPackage.DATATYPE:
				return convertDATATYPEToString(eDataType, instanceValue);
			case PolyhedralIRPackage.OP:
				return convertOPToString(eDataType, instanceValue);
			case PolyhedralIRPackage.JNIISL_SET:
				return convertJNIISLSetToString(eDataType, instanceValue);
			case PolyhedralIRPackage.JNIISL_BASIC_MAP:
				return convertJNIISLBasicMapToString(eDataType, instanceValue);
			case PolyhedralIRPackage.LONG_MATRIX:
				return convertlongMatrixToString(eDataType, instanceValue);
			case PolyhedralIRPackage.LIST_STRING:
				return convertListStringToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalFunctionDeclaration createExternalFunctionDeclaration() {
		ExternalFunctionDeclarationImpl externalFunctionDeclaration = new ExternalFunctionDeclarationImpl();
		return externalFunctionDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem createAffineSystem() {
		AffineSystemImpl affineSystem = new AffineSystemImpl();
		return affineSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableIdentifier createVariableIdentifier() {
		VariableIdentifierImpl variableIdentifier = new VariableIdentifierImpl();
		return variableIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseEquation createUseEquation() {
		UseEquationImpl useEquation = new UseEquationImpl();
		return useEquation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardEquation createStandardEquation() {
		StandardEquationImpl standardEquation = new StandardEquationImpl();
		return standardEquation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain createDomain() {
		DomainImpl domain = new DomainImpl();
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDomain createParameterDomain() {
		ParameterDomainImpl parameterDomain = new ParameterDomainImpl();
		return parameterDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction createAffineFunction() {
		AffineFunctionImpl affineFunction = new AffineFunctionImpl();
		return affineFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FastISLDomain createFastISLDomain() {
		FastISLDomainImpl fastISLDomain = new FastISLDomainImpl();
		return fastISLDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FastISLMap createFastISLMap() {
		FastISLMapImpl fastISLMap = new FastISLMapImpl();
		return fastISLMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileInfo createWhileInfo() {
		WhileInfoImpl whileInfo = new WhileInfoImpl();
		return whileInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TilingInformations createTilingInformations() {
		TilingInformationsImpl tilingInformations = new TilingInformationsImpl();
		return tilingInformations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyhedralIRDepthFirstVisitor createPolyhedralIRDepthFirstVisitor() {
		PolyhedralIRDepthFirstVisitorImpl polyhedralIRDepthFirstVisitor = new PolyhedralIRDepthFirstVisitorImpl();
		return polyhedralIRDepthFirstVisitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyhedralIRInheritedDepthFirstVisitor createPolyhedralIRInheritedDepthFirstVisitor() {
		PolyhedralIRInheritedDepthFirstVisitorImpl polyhedralIRInheritedDepthFirstVisitor = new PolyhedralIRInheritedDepthFirstVisitorImpl();
		return polyhedralIRInheritedDepthFirstVisitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIGNED createSIGNEDFromString(EDataType eDataType, String initialValue) {
		SIGNED result = SIGNED.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSIGNEDToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DATATYPE createDATATYPEFromString(EDataType eDataType, String initialValue) {
		DATATYPE result = DATATYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDATATYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OP createOPFromString(EDataType eDataType, String initialValue) {
		OP result = OP.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOPToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createJNIISLSetFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJNIISLSetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createJNIISLBasicMapFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJNIISLBasicMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long[][] createlongMatrixFromString(EDataType eDataType, String initialValue) {
		return (long[][])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertlongMatrixToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<String> createListStringFromString(EDataType eDataType, String initialValue) {
		return (List<String>) super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyhedralIRPackage getPolyhedralIRPackage() {
		return (PolyhedralIRPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PolyhedralIRPackage getPackage() {
		return PolyhedralIRPackage.eINSTANCE;
	}

} //PolyhedralIRFactoryImpl
