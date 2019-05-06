/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineFactory;
import org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
import org.polymodel.algebra.quasiAffine.QuasiAffinePackage;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QuasiAffineFactoryImpl extends EFactoryImpl implements QuasiAffineFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QuasiAffineFactory init() {
		try {
			QuasiAffineFactory theQuasiAffineFactory = (QuasiAffineFactory)EPackage.Registry.INSTANCE.getEFactory(QuasiAffinePackage.eNS_URI);
			if (theQuasiAffineFactory != null) {
				return theQuasiAffineFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QuasiAffineFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuasiAffineFactoryImpl() {
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
			case QuasiAffinePackage.QUASI_AFFINE_EXPRESSION: return createQuasiAffineExpression();
			case QuasiAffinePackage.SIMPLE_QUASI_AFFINE_TERM: return createSimpleQuasiAffineTerm();
			case QuasiAffinePackage.NESTED_QUASI_AFFINE_TERM: return createNestedQuasiAffineTerm();
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
			case QuasiAffinePackage.QUASI_AFFINE_OPERATOR:
				return createQuasiAffineOperatorFromString(eDataType, initialValue);
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
			case QuasiAffinePackage.QUASI_AFFINE_OPERATOR:
				return convertQuasiAffineOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuasiAffineExpression createQuasiAffineExpression() {
		QuasiAffineExpressionImpl quasiAffineExpression = new QuasiAffineExpressionImpl();
		return quasiAffineExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleQuasiAffineTerm createSimpleQuasiAffineTerm() {
		SimpleQuasiAffineTermImpl simpleQuasiAffineTerm = new SimpleQuasiAffineTermImpl();
		return simpleQuasiAffineTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedQuasiAffineTerm createNestedQuasiAffineTerm() {
		NestedQuasiAffineTermImpl nestedQuasiAffineTerm = new NestedQuasiAffineTermImpl();
		return nestedQuasiAffineTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuasiAffineOperator createQuasiAffineOperatorFromString(EDataType eDataType, String initialValue) {
		QuasiAffineOperator result = QuasiAffineOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQuasiAffineOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuasiAffinePackage getQuasiAffinePackage() {
		return (QuasiAffinePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QuasiAffinePackage getPackage() {
		return QuasiAffinePackage.eINSTANCE;
	}

} //QuasiAffineFactoryImpl
