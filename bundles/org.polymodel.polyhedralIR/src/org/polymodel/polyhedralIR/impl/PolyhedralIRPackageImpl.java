/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.matrix.MatrixPackage;
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
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
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
import org.polymodel.polyhedralIR.expression.ExpressionPackage;
import org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.impl.TargetMappingPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PolyhedralIRPackageImpl extends EPackageImpl implements PolyhedralIRPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalFunctionDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass affineSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useEquationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardEquationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass affineFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fastISLDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fastISLMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tilingInformationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polyhedralIRVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polyhedralIRVisitableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polyhedralIRDepthFirstVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polyhedralIRInheritedDepthFirstVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum signedEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum datatypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum opEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jniislSetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jniislBasicMapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType longMatrixEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listStringEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PolyhedralIRPackageImpl() {
		super(eNS_URI, PolyhedralIRFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PolyhedralIRPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PolyhedralIRPackage init() {
		if (isInited) return (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);

		// Obtain or create and register package
		PolyhedralIRPackageImpl thePolyhedralIRPackage = (PolyhedralIRPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PolyhedralIRPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PolyhedralIRPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolymodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) instanceof ExpressionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) : ExpressionPackage.eINSTANCE);
		TargetMappingPackageImpl theTargetMappingPackage = (TargetMappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TargetMappingPackage.eNS_URI) instanceof TargetMappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TargetMappingPackage.eNS_URI) : TargetMappingPackage.eINSTANCE);

		// Create package meta-data objects
		thePolyhedralIRPackage.createPackageContents();
		theExpressionPackage.createPackageContents();
		theTargetMappingPackage.createPackageContents();

		// Initialize created meta-data
		thePolyhedralIRPackage.initializePackageContents();
		theExpressionPackage.initializePackageContents();
		theTargetMappingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePolyhedralIRPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PolyhedralIRPackage.eNS_URI, thePolyhedralIRPackage);
		return thePolyhedralIRPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProgram() {
		return programEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_ExternalFunctionDeclarations() {
		return (EReference)programEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_Systems() {
		return (EReference)programEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_Types() {
		return (EReference)programEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalFunctionDeclaration() {
		return externalFunctionDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalFunctionDeclaration_Name() {
		return (EAttribute)externalFunctionDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalFunctionDeclaration_Inputs() {
		return (EReference)externalFunctionDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalFunctionDeclaration_Output() {
		return (EReference)externalFunctionDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAffineSystem() {
		return affineSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_ContainerProgram() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAffineSystem_Name() {
		return (EAttribute)affineSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_Parameters() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_Inputs() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_Outputs() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_Locals() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_Equations() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_UseEquations() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_TargetMapping() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_WhileInfo() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineSystem_TilingInfo() {
		return (EReference)affineSystemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Signed() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_TypeID() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Width() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclaration_VarID() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclaration_Type() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclaration_Domain() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableIdentifier() {
		return variableIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableIdentifier_Name() {
		return (EAttribute)variableIdentifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquation() {
		return equationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseEquation() {
		return useEquationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquation_ExtensionDomain() {
		return (EReference)useEquationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquation_Parameters() {
		return (EReference)useEquationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquation_Inputs() {
		return (EReference)useEquationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquation_Outputs() {
		return (EReference)useEquationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquation_ContainerSystem() {
		return (EReference)useEquationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseEquation_Label() {
		return (EAttribute)useEquationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquation_SubSystem() {
		return (EReference)useEquationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardEquation() {
		return standardEquationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardEquation_Variable() {
		return (EReference)standardEquationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardEquation_Expression() {
		return (EReference)standardEquationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardEquation_ContainerSystem() {
		return (EReference)standardEquationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomain_PMdomain() {
		return (EReference)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDomain() {
		return parameterDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAffineFunction() {
		return affineFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAffineFunction_PMmapping() {
		return (EReference)affineFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_ContextDomain() {
		return (EReference)expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_ExpressionDomain() {
		return (EReference)expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_ExpressionType() {
		return (EReference)expressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFastISLDomain() {
		return fastISLDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFastISLDomain_IslSet() {
		return (EAttribute)fastISLDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFastISLDomain_DomDims() {
		return (EReference)fastISLDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFastISLMap() {
		return fastISLMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFastISLMap_IslMap() {
		return (EAttribute)fastISLMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFastISLMap_DomDims() {
		return (EReference)fastISLMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFastISLMap_LabelIn() {
		return (EReference)fastISLMapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFastISLMap_LabelOut() {
		return (EReference)fastISLMapEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileInfo() {
		return whileInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileInfo_TimeDomain() {
		return (EReference)whileInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileInfo_Condition() {
		return (EReference)whileInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileInfo_ContainerSystem() {
		return (EReference)whileInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTilingInformations() {
		return tilingInformationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTilingInformations_Ratios() {
		return (EAttribute)tilingInformationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTilingInformations_MinParamValues() {
		return (EAttribute)tilingInformationsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTilingInformations_TileGroups() {
		return (EAttribute)tilingInformationsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTilingInformations_CobPreprocess() {
		return (EAttribute)tilingInformationsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolyhedralIRVisitor() {
		return polyhedralIRVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolyhedralIRVisitable() {
		return polyhedralIRVisitableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolyhedralIRDepthFirstVisitor() {
		return polyhedralIRDepthFirstVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolyhedralIRInheritedDepthFirstVisitor() {
		return polyhedralIRInheritedDepthFirstVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSIGNED() {
		return signedEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDATATYPE() {
		return datatypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOP() {
		return opEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJNIISLSet() {
		return jniislSetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJNIISLBasicMap() {
		return jniislBasicMapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getlongMatrix() {
		return longMatrixEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getListString() {
		return listStringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyhedralIRFactory getPolyhedralIRFactory() {
		return (PolyhedralIRFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		programEClass = createEClass(PROGRAM);
		createEReference(programEClass, PROGRAM__EXTERNAL_FUNCTION_DECLARATIONS);
		createEReference(programEClass, PROGRAM__SYSTEMS);
		createEReference(programEClass, PROGRAM__TYPES);

		externalFunctionDeclarationEClass = createEClass(EXTERNAL_FUNCTION_DECLARATION);
		createEAttribute(externalFunctionDeclarationEClass, EXTERNAL_FUNCTION_DECLARATION__NAME);
		createEReference(externalFunctionDeclarationEClass, EXTERNAL_FUNCTION_DECLARATION__INPUTS);
		createEReference(externalFunctionDeclarationEClass, EXTERNAL_FUNCTION_DECLARATION__OUTPUT);

		affineSystemEClass = createEClass(AFFINE_SYSTEM);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__CONTAINER_PROGRAM);
		createEAttribute(affineSystemEClass, AFFINE_SYSTEM__NAME);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__PARAMETERS);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__INPUTS);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__OUTPUTS);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__LOCALS);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__EQUATIONS);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__USE_EQUATIONS);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__TARGET_MAPPING);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__WHILE_INFO);
		createEReference(affineSystemEClass, AFFINE_SYSTEM__TILING_INFO);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__SIGNED);
		createEAttribute(typeEClass, TYPE__TYPE_ID);
		createEAttribute(typeEClass, TYPE__WIDTH);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__VAR_ID);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TYPE);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__DOMAIN);

		variableIdentifierEClass = createEClass(VARIABLE_IDENTIFIER);
		createEAttribute(variableIdentifierEClass, VARIABLE_IDENTIFIER__NAME);

		equationEClass = createEClass(EQUATION);

		useEquationEClass = createEClass(USE_EQUATION);
		createEReference(useEquationEClass, USE_EQUATION__EXTENSION_DOMAIN);
		createEReference(useEquationEClass, USE_EQUATION__PARAMETERS);
		createEReference(useEquationEClass, USE_EQUATION__INPUTS);
		createEReference(useEquationEClass, USE_EQUATION__OUTPUTS);
		createEReference(useEquationEClass, USE_EQUATION__SUB_SYSTEM);
		createEReference(useEquationEClass, USE_EQUATION__CONTAINER_SYSTEM);
		createEAttribute(useEquationEClass, USE_EQUATION__LABEL);

		standardEquationEClass = createEClass(STANDARD_EQUATION);
		createEReference(standardEquationEClass, STANDARD_EQUATION__VARIABLE);
		createEReference(standardEquationEClass, STANDARD_EQUATION__EXPRESSION);
		createEReference(standardEquationEClass, STANDARD_EQUATION__CONTAINER_SYSTEM);

		domainEClass = createEClass(DOMAIN);
		createEReference(domainEClass, DOMAIN__PMDOMAIN);

		parameterDomainEClass = createEClass(PARAMETER_DOMAIN);

		affineFunctionEClass = createEClass(AFFINE_FUNCTION);
		createEReference(affineFunctionEClass, AFFINE_FUNCTION__PMMAPPING);

		expressionEClass = createEClass(EXPRESSION);
		createEReference(expressionEClass, EXPRESSION__CONTEXT_DOMAIN);
		createEReference(expressionEClass, EXPRESSION__EXPRESSION_DOMAIN);
		createEReference(expressionEClass, EXPRESSION__EXPRESSION_TYPE);

		fastISLDomainEClass = createEClass(FAST_ISL_DOMAIN);
		createEAttribute(fastISLDomainEClass, FAST_ISL_DOMAIN__ISL_SET);
		createEReference(fastISLDomainEClass, FAST_ISL_DOMAIN__DOM_DIMS);

		fastISLMapEClass = createEClass(FAST_ISL_MAP);
		createEAttribute(fastISLMapEClass, FAST_ISL_MAP__ISL_MAP);
		createEReference(fastISLMapEClass, FAST_ISL_MAP__DOM_DIMS);
		createEReference(fastISLMapEClass, FAST_ISL_MAP__LABEL_IN);
		createEReference(fastISLMapEClass, FAST_ISL_MAP__LABEL_OUT);

		whileInfoEClass = createEClass(WHILE_INFO);
		createEReference(whileInfoEClass, WHILE_INFO__TIME_DOMAIN);
		createEReference(whileInfoEClass, WHILE_INFO__CONDITION);
		createEReference(whileInfoEClass, WHILE_INFO__CONTAINER_SYSTEM);

		tilingInformationsEClass = createEClass(TILING_INFORMATIONS);
		createEAttribute(tilingInformationsEClass, TILING_INFORMATIONS__RATIOS);
		createEAttribute(tilingInformationsEClass, TILING_INFORMATIONS__MIN_PARAM_VALUES);
		createEAttribute(tilingInformationsEClass, TILING_INFORMATIONS__TILE_GROUPS);
		createEAttribute(tilingInformationsEClass, TILING_INFORMATIONS__COB_PREPROCESS);

		polyhedralIRVisitorEClass = createEClass(POLYHEDRAL_IR_VISITOR);

		polyhedralIRVisitableEClass = createEClass(POLYHEDRAL_IR_VISITABLE);

		polyhedralIRDepthFirstVisitorEClass = createEClass(POLYHEDRAL_IR_DEPTH_FIRST_VISITOR);

		polyhedralIRInheritedDepthFirstVisitorEClass = createEClass(POLYHEDRAL_IR_INHERITED_DEPTH_FIRST_VISITOR);

		// Create enums
		signedEEnum = createEEnum(SIGNED);
		datatypeEEnum = createEEnum(DATATYPE);
		opEEnum = createEEnum(OP);

		// Create data types
		jniislSetEDataType = createEDataType(JNIISL_SET);
		jniislBasicMapEDataType = createEDataType(JNIISL_BASIC_MAP);
		longMatrixEDataType = createEDataType(LONG_MATRIX);
		listStringEDataType = createEDataType(LIST_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ExpressionPackage theExpressionPackage = (ExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI);
		TargetMappingPackage theTargetMappingPackage = (TargetMappingPackage)EPackage.Registry.INSTANCE.getEPackage(TargetMappingPackage.eNS_URI);
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);
		AffinePackage theAffinePackage = (AffinePackage)EPackage.Registry.INSTANCE.getEPackage(AffinePackage.eNS_URI);
		MatrixPackage theMatrixPackage = (MatrixPackage)EPackage.Registry.INSTANCE.getEPackage(MatrixPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theExpressionPackage);
		getESubpackages().add(theTargetMappingPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		programEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		externalFunctionDeclarationEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		affineSystemEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		variableDeclarationEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		variableIdentifierEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		equationEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		useEquationEClass.getESuperTypes().add(this.getEquation());
		useEquationEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		standardEquationEClass.getESuperTypes().add(this.getEquation());
		standardEquationEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		domainEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		parameterDomainEClass.getESuperTypes().add(this.getDomain());
		parameterDomainEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		affineFunctionEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		expressionEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		fastISLDomainEClass.getESuperTypes().add(this.getDomain());
		fastISLDomainEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		fastISLMapEClass.getESuperTypes().add(this.getAffineFunction());
		fastISLMapEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		whileInfoEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		tilingInformationsEClass.getESuperTypes().add(this.getPolyhedralIRVisitable());
		polyhedralIRDepthFirstVisitorEClass.getESuperTypes().add(this.getPolyhedralIRVisitor());
		polyhedralIRInheritedDepthFirstVisitorEClass.getESuperTypes().add(this.getPolyhedralIRVisitor());

		// Initialize classes and features; add operations and parameters
		initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProgram_ExternalFunctionDeclarations(), this.getExternalFunctionDeclaration(), null, "externalFunctionDeclarations", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Systems(), this.getAffineSystem(), this.getAffineSystem_ContainerProgram(), "systems", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Types(), this.getType(), null, "types", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(programEClass, this.getType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSIGNED(), "signed", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDATATYPE(), "type", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "width", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(programEClass, this.getOP(), "getBinaryOperator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "op", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(programEClass, this.getOP(), "getUnaryOperator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "op", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(programEClass, this.getOP(), "getMultiArgOperator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "op", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(programEClass, this.getOP(), "getExternalFunctionOperator", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(programEClass, this.getExternalFunctionDeclaration(), "getExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getType(), "output", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getType(), "inputs", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(programEClass, this.getAffineSystem(), "getSystem", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "systemName", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(programEClass, this.getParameterDomain(), "getParameterDomain", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "systemName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(programEClass, this.getProgram(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(programEClass, ecorePackage.getEBoolean(), "isContainingSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(programEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(externalFunctionDeclarationEClass, ExternalFunctionDeclaration.class, "ExternalFunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalFunctionDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, ExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalFunctionDeclaration_Inputs(), this.getType(), null, "inputs", null, 0, -1, ExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalFunctionDeclaration_Output(), this.getType(), null, "output", null, 0, 1, ExternalFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(externalFunctionDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(affineSystemEClass, AffineSystem.class, "AffineSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAffineSystem_ContainerProgram(), this.getProgram(), this.getProgram_Systems(), "containerProgram", null, 0, 1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAffineSystem_Name(), ecorePackage.getEString(), "name", null, 0, 1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_Parameters(), this.getParameterDomain(), null, "parameters", null, 1, 1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_Inputs(), this.getVariableDeclaration(), null, "inputs", null, 0, -1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_Outputs(), this.getVariableDeclaration(), null, "outputs", null, 0, -1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_Locals(), this.getVariableDeclaration(), null, "locals", null, 0, -1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_Equations(), this.getStandardEquation(), this.getStandardEquation_ContainerSystem(), "equations", null, 0, -1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_UseEquations(), this.getUseEquation(), this.getUseEquation_ContainerSystem(), "useEquations", null, 0, -1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_TargetMapping(), theTargetMappingPackage.getTargetMapping(), theTargetMappingPackage.getTargetMapping_ContainerSystem(), "targetMapping", null, 1, 1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_WhileInfo(), this.getWhileInfo(), null, "whileInfo", null, 0, 1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAffineSystem_TilingInfo(), this.getTilingInformations(), null, "tilingInfo", null, 0, 1, AffineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(affineSystemEClass, this.getVariableDeclaration(), "getVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineSystemEClass, this.getStandardEquation(), "getEquation", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineSystemEClass, this.getUseEquation(), "getUseEquation", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineSystemEClass, ecorePackage.getEBoolean(), "containsVariable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "varName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineSystemEClass, this.getAffineSystem(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineSystemEClass, this.getUseEquation(), "findLabel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "label", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineSystemEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_Signed(), this.getSIGNED(), "signed", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_TypeID(), this.getDATATYPE(), "typeID", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_Width(), ecorePackage.getEInt(), "width", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(typeEClass, ecorePackage.getEString(), "getCName", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDeclaration_VarID(), this.getVariableIdentifier(), null, "varID", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_Type(), this.getType(), null, "type", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_Domain(), this.getDomain(), null, "domain", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(variableDeclarationEClass, ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(variableDeclarationEClass, ecorePackage.getEBoolean(), "isInput", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(variableDeclarationEClass, ecorePackage.getEBoolean(), "isOutput", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(variableDeclarationEClass, ecorePackage.getEBoolean(), "isLocal", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(variableDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableIdentifierEClass, VariableIdentifier.class, "VariableIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableIdentifier_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(variableIdentifierEClass, ecorePackage.getEBoolean(), "equilvalence", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(variableIdentifierEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equationEClass, Equation.class, "Equation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(equationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(useEquationEClass, UseEquation.class, "UseEquation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseEquation_ExtensionDomain(), this.getDomain(), null, "extensionDomain", null, 0, 1, UseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquation_Parameters(), this.getAffineFunction(), null, "parameters", null, 1, 1, UseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquation_Inputs(), this.getExpression(), null, "inputs", null, 0, -1, UseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquation_Outputs(), this.getVariableDeclaration(), null, "outputs", null, 0, -1, UseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquation_SubSystem(), this.getAffineSystem(), null, "subSystem", null, 1, 1, UseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquation_ContainerSystem(), this.getAffineSystem(), this.getAffineSystem_UseEquations(), "containerSystem", null, 0, 1, UseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseEquation_Label(), ecorePackage.getEString(), "label", "", 0, 1, UseEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(useEquationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(standardEquationEClass, StandardEquation.class, "StandardEquation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStandardEquation_Variable(), this.getVariableDeclaration(), null, "variable", null, 0, 1, StandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStandardEquation_Expression(), this.getExpression(), null, "expression", null, 0, 1, StandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStandardEquation_ContainerSystem(), this.getAffineSystem(), this.getAffineSystem_Equations(), "containerSystem", null, 0, 1, StandardEquation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(standardEquationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomain_PMdomain(), thePolymodelPackage.getDomain(), null, "PMdomain", null, 1, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(domainEClass, this.getDomain(), "union", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, this.getDomain(), "intersection", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, this.getDomain(), "difference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, ecorePackage.getEBoolean(), "equivalence", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, ecorePackage.getEBoolean(), "isUniverse", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, ecorePackage.getEBoolean(), "isEmpty", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, this.getDomain(), "image", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "T", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, this.getDomain(), "preimage", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "T", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, theAlgebraPackage.getVariable(), "getParams", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, theAlgebraPackage.getVariable(), "getIndices", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, ecorePackage.getEInt(), "getDim", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, ecorePackage.getEInt(), "getNParams", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, ecorePackage.getEInt(), "getNIndices", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, null, "addDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, null, "addParameterDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, null, "simplify", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, null, "simplifyInContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "context", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, this.getDomain(), "boundingBox", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, this.getDomain(), "affineHull", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, theAlgebraPackage.getIntExpression(), "getBounds", 2, 2, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "dim", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(domainEClass, this.getDomain(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, this.getDomain(), "transitiveClosure", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "f", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "range", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, this.getDomain(), "exactTransitiveClosure", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "f", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "range", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(domainEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(parameterDomainEClass, ParameterDomain.class, "ParameterDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(parameterDomainEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(affineFunctionEClass, AffineFunction.class, "AffineFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAffineFunction_PMmapping(), thePolymodelPackage.getFunction(), null, "PMmapping", null, 1, 1, AffineFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(affineFunctionEClass, ecorePackage.getEBoolean(), "equivalence", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "func", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineFunctionEClass, this.getAffineFunction(), "compose", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "f2", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, theAlgebraPackage.getVariable(), "getParams", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, theAlgebraPackage.getVariable(), "getIndices", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, ecorePackage.getEInt(), "getDimLHS", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, ecorePackage.getEInt(), "getDimRHS", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, theAffinePackage.getAffineExpression(), "getExpressions", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, this.getAffineFunction(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineFunctionEClass, this.getAffineFunction(), "inverse", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "names", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineFunctionEClass, this.getAffineFunction(), "inverseInContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "names", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, ecorePackage.getEBoolean(), "isUniform", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, ecorePackage.getEBoolean(), "isBijective", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, ecorePackage.getEBoolean(), "isIdentity", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, ecorePackage.getEInt(), "getNParams", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(affineFunctionEClass, ecorePackage.getEInt(), "getNIndices", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(affineFunctionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpression_ContextDomain(), this.getDomain(), null, "contextDomain", null, 1, 1, Expression.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExpression_ExpressionDomain(), this.getDomain(), null, "expressionDomain", null, 1, 1, Expression.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExpression_ExpressionType(), this.getType(), null, "expressionType", null, 0, 1, Expression.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(expressionEClass, this.getExpression(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expressionEClass, this.getEquation(), "getContainerEquation", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expressionEClass, ecorePackage.getEBoolean(), "equivalence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "expr", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fastISLDomainEClass, FastISLDomain.class, "FastISLDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFastISLDomain_IslSet(), this.getJNIISLSet(), "islSet", null, 0, 1, FastISLDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFastISLDomain_DomDims(), thePolymodelPackage.getDomainDimensions(), null, "domDims", null, 0, 1, FastISLDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(fastISLDomainEClass, theMatrixPackage.getMatrix(), "toMatrix", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(fastISLDomainEClass, this.getlongMatrix(), "toLongMatrix", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fastISLDomainEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fastISLMapEClass, FastISLMap.class, "FastISLMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFastISLMap_IslMap(), this.getJNIISLBasicMap(), "islMap", null, 0, 1, FastISLMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFastISLMap_DomDims(), thePolymodelPackage.getDomainDimensions(), null, "domDims", null, 0, 1, FastISLMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFastISLMap_LabelIn(), thePolymodelPackage.getLabel(), null, "labelIn", null, 0, 1, FastISLMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFastISLMap_LabelOut(), thePolymodelPackage.getLabel(), null, "labelOut", null, 0, 1, FastISLMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(fastISLMapEClass, theMatrixPackage.getMatrix(), "toMatrix", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(fastISLMapEClass, this.getlongMatrix(), "toLongMatrix", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fastISLMapEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(whileInfoEClass, WhileInfo.class, "WhileInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileInfo_TimeDomain(), this.getDomain(), null, "timeDomain", null, 1, 1, WhileInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileInfo_Condition(), this.getExpression(), null, "condition", null, 1, 1, WhileInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileInfo_ContainerSystem(), this.getAffineSystem(), null, "containerSystem", null, 1, 1, WhileInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(whileInfoEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tilingInformationsEClass, TilingInformations.class, "TilingInformations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEEList());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(ecorePackage.getEIntegerObject());
		g2.getETypeArguments().add(g3);
		initEAttribute(getTilingInformations_Ratios(), g1, "ratios", null, 0, 1, TilingInformations.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEIntegerObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getTilingInformations_MinParamValues(), g1, "minParamValues", null, 0, 1, TilingInformations.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getListString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getTilingInformations_TileGroups(), g1, "tileGroups", null, 0, 1, TilingInformations.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getAffineFunction());
		g1.getETypeArguments().add(g2);
		initEAttribute(getTilingInformations_CobPreprocess(), g1, "cobPreprocess", null, 0, 1, TilingInformations.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(tilingInformationsEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polyhedralIRVisitorEClass, PolyhedralIRVisitor.class, "PolyhedralIRVisitor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(polyhedralIRVisitorEClass, null, "defaultIn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "defaultOut", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "visitSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "inSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRVisitorEClass, null, "outSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polyhedralIRVisitableEClass, PolyhedralIRVisitable.class, "PolyhedralIRVisitable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(polyhedralIRVisitableEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polyhedralIRDepthFirstVisitorEClass, PolyhedralIRDepthFirstVisitor.class, "PolyhedralIRDepthFirstVisitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "defaultIn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "defaultOut", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "visitSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "inSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRDepthFirstVisitorEClass, null, "outSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polyhedralIRInheritedDepthFirstVisitorEClass, PolyhedralIRInheritedDepthFirstVisitor.class, "PolyhedralIRInheritedDepthFirstVisitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "defaultIn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "defaultOut", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolyhedralIRVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outProgram", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgram(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outExternalFunctionDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExternalFunctionDeclaration(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outAffineSystem", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineSystem(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outVariableDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableDeclaration(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outVariableIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVariableIdentifier(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEquation(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outUseEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUseEquation(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outStandardEquation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStandardEquation(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outParameterDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getParameterDomain(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outAffineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAffineFunction(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outFastISLDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLDomain(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outFastISLMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFastISLMap(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outWhileInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWhileInfo(), "w", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outTilingInformations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTilingInformations(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outCaseExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getCaseExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outDependenceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getDependenceExpression(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outIfExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIfExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outIndexExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIndexExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outReduceExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getReduceExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outRestrictExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRestrictExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outVariableExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getVariableExpression(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outBinaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBinaryExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outConstantExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getConstantExpression(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outBooleanExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getBooleanExpression(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outIntegerExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getIntegerExpression(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outRealExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getRealExpression(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outMultiArgExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getMultiArgExpression(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outExternalFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getExternalFunctionCall(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outUnaryExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theExpressionPackage.getUnaryExpression(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outTargetMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTargetMapping(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeLevel(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outSpaceTimeMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSpaceTimeMap(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outFeatureSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getFeatureSpecification(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getTilingSpecification(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outLoopUnrollingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getLoopUnrollingSpecification(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outVectorizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getVectorizationSpecification(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outParallelizationSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getParallelizationSpecification(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outMemoryMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemoryMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outMemorySpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getMemorySpace(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outStatementPartialOrder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getStatementPartialOrder(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getUseEquationOptimization(), "u", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outCommunicationMappingForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicationMappingForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outCommunicatedVariableForTiledSpace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getCommunicatedVariableForTiledSpace(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "visitSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "inSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(polyhedralIRInheritedDepthFirstVisitorEClass, null, "outSubTilingSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetMappingPackage.getSubTilingSpecification(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(signedEEnum, org.polymodel.polyhedralIR.SIGNED.class, "SIGNED");
		addEEnumLiteral(signedEEnum, org.polymodel.polyhedralIR.SIGNED.SIGNED);
		addEEnumLiteral(signedEEnum, org.polymodel.polyhedralIR.SIGNED.UNSIGNED);

		initEEnum(datatypeEEnum, org.polymodel.polyhedralIR.DATATYPE.class, "DATATYPE");
		addEEnumLiteral(datatypeEEnum, org.polymodel.polyhedralIR.DATATYPE.INTEGER);
		addEEnumLiteral(datatypeEEnum, org.polymodel.polyhedralIR.DATATYPE.FLOATING_POINT);
		addEEnumLiteral(datatypeEEnum, org.polymodel.polyhedralIR.DATATYPE.CHAR);
		addEEnumLiteral(datatypeEEnum, org.polymodel.polyhedralIR.DATATYPE.BOOL);

		initEEnum(opEEnum, org.polymodel.polyhedralIR.OP.class, "OP");
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.ADD);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.SUB);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.MUL);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.DIV);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.MOD);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.MAX);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.MIN);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.AND);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.OR);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.NAND);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.NOR);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.XOR);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.EQ);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.NE);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.LT);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.LE);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.GT);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.GE);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.NOT);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.NEG);
		addEEnumLiteral(opEEnum, org.polymodel.polyhedralIR.OP.EXTERNAL_FUNCTION);

		// Initialize data types
		initEDataType(jniislSetEDataType, Object.class, "JNIISLSet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(jniislBasicMapEDataType, Object.class, "JNIISLBasicMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(longMatrixEDataType, long[][].class, "longMatrix", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listStringEDataType, Object.class, "ListString", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "List<String>");

		// Create resource
		createResource(eNS_URI);
	}

} //PolyhedralIRPackageImpl
