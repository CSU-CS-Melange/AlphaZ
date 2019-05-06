/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.*;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExFactory;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlgebraExFactoryImpl extends EFactoryImpl implements AlgebraExFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AlgebraExFactory init() {
		try {
			AlgebraExFactory theAlgebraExFactory = (AlgebraExFactory)EPackage.Registry.INSTANCE.getEFactory(AlgebraExPackage.eNS_URI);
			if (theAlgebraExFactory != null) {
				return theAlgebraExFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AlgebraExFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgebraExFactoryImpl() {
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
			case AlgebraExPackage.MODULO_EXPRESSION: return createModuloExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuloExpression createModuloExpression() {
		ModuloExpressionImpl moduloExpression = new ModuloExpressionImpl();
		return moduloExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgebraExPackage getAlgebraExPackage() {
		return (AlgebraExPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AlgebraExPackage getPackage() {
		return AlgebraExPackage.eINSTANCE;
	}

} //AlgebraExFactoryImpl
