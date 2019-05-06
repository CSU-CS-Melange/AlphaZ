/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.polynomials.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.polynomials.PolynomialsFactory;
import org.polymodel.algebra.polynomials.PolynomialsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PolynomialsFactoryImpl extends EFactoryImpl implements PolynomialsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PolynomialsFactory init() {
		try {
			PolynomialsFactory thePolynomialsFactory = (PolynomialsFactory)EPackage.Registry.INSTANCE.getEFactory(PolynomialsPackage.eNS_URI);
			if (thePolynomialsFactory != null) {
				return thePolynomialsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PolynomialsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolynomialsFactoryImpl() {
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
			case PolynomialsPackage.POLYNOMIAL_EXPRESSION: return createPolynomialExpression();
			case PolynomialsPackage.POLYNOMIAL_VARIABLE: return createPolynomialVariable();
			case PolynomialsPackage.POLYNOMIAL_TERM: return createPolynomialTerm();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolynomialExpression createPolynomialExpression() {
		PolynomialExpressionImpl polynomialExpression = new PolynomialExpressionImpl();
		return polynomialExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolynomialVariable createPolynomialVariable() {
		PolynomialVariableImpl polynomialVariable = new PolynomialVariableImpl();
		return polynomialVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolynomialTerm createPolynomialTerm() {
		PolynomialTermImpl polynomialTerm = new PolynomialTermImpl();
		return polynomialTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolynomialsPackage getPolynomialsPackage() {
		return (PolynomialsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PolynomialsPackage getPackage() {
		return PolynomialsPackage.eINSTANCE;
	}

} //PolynomialsFactoryImpl
