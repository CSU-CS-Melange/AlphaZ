/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.C.*;
import org.polymodel.polyhedralIR.polyIRCG.C.CFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.scop.dtiler.DTilingOptions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CFactoryImpl extends EFactoryImpl implements CFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CFactory init() {
		try {
			CFactory theCFactory = (CFactory)EPackage.Registry.INSTANCE.getEFactory(CPackage.eNS_URI);
			if (theCFactory != null) {
				return theCFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CFactoryImpl() {
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
			case CPackage.EQUATION_AS_STATEMENT: return createEquationAsStatement();
			case CPackage.PARAMETER_CHECK: return createParameterCheck();
			case CPackage.CLOOP: return createCLoop();
			case CPackage.TILED_CLOOP: return createTiledCLoop();
			case CPackage.PARALLELIZED_CLOOP: return createParallelizedCLoop();
			case CPackage.SCOP_LOOP: return createScopLoop();
			case CPackage.CVARIABLE: return createCVariable();
			case CPackage.DTILED_LOOP: return createDTiledLoop();
			case CPackage.DTILED_BLOCK: return createDTiledBlock();
			case CPackage.SUB_TILE_SPECIFICATION: return createSubTileSpecification();
			case CPackage.TILE_SPECIFICATION: return createTileSpecification();
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
			case CPackage.DTILING_OPTIONS:
				return createDTilingOptionsFromString(eDataType, initialValue);
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
			case CPackage.DTILING_OPTIONS:
				return convertDTilingOptionsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationAsStatement createEquationAsStatement() {
		EquationAsStatementImpl equationAsStatement = new EquationAsStatementImpl();
		return equationAsStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterCheck createParameterCheck() {
		ParameterCheckImpl parameterCheck = new ParameterCheckImpl();
		return parameterCheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop createCLoop() {
		CLoopImpl cLoop = new CLoopImpl();
		return cLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TiledCLoop createTiledCLoop() {
		TiledCLoopImpl tiledCLoop = new TiledCLoopImpl();
		return tiledCLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelizedCLoop createParallelizedCLoop() {
		ParallelizedCLoopImpl parallelizedCLoop = new ParallelizedCLoopImpl();
		return parallelizedCLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopLoop createScopLoop() {
		ScopLoopImpl scopLoop = new ScopLoopImpl();
		return scopLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVariable createCVariable() {
		CVariableImpl cVariable = new CVariableImpl();
		return cVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTiledLoop createDTiledLoop() {
		DTiledLoopImpl dTiledLoop = new DTiledLoopImpl();
		return dTiledLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTiledBlock createDTiledBlock() {
		DTiledBlockImpl dTiledBlock = new DTiledBlockImpl();
		return dTiledBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubTileSpecification createSubTileSpecification() {
		SubTileSpecificationImpl subTileSpecification = new SubTileSpecificationImpl();
		return subTileSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TileSpecification createTileSpecification() {
		TileSpecificationImpl tileSpecification = new TileSpecificationImpl();
		return tileSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTilingOptions createDTilingOptionsFromString(EDataType eDataType, String initialValue) {
		return (DTilingOptions)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDTilingOptionsToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPackage getCPackage() {
		return (CPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CPackage getPackage() {
		return CPackage.eINSTANCE;
	}

} //CFactoryImpl
