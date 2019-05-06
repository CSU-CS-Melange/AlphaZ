/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.affine.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineFactory;
import org.polymodel.algebra.affine.AffinePackage;
import org.polymodel.algebra.affine.AffineTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AffineFactoryImpl extends EFactoryImpl implements AffineFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AffineFactory init() {
		try {
			AffineFactory theAffineFactory = (AffineFactory)EPackage.Registry.INSTANCE.getEFactory(AffinePackage.eNS_URI);
			if (theAffineFactory != null) {
				return theAffineFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AffineFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFactoryImpl() {
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
			case AffinePackage.AFFINE_EXPRESSION: return createAffineExpression();
			case AffinePackage.AFFINE_TERM: return createAffineTerm();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineExpression createAffineExpression() {
		AffineExpressionImpl affineExpression = new AffineExpressionImpl();
		return affineExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineTerm createAffineTerm() {
		AffineTermImpl affineTerm = new AffineTermImpl();
		return affineTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffinePackage getAffinePackage() {
		return (AffinePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AffinePackage getPackage() {
		return AffinePackage.eINSTANCE;
	}

} //AffineFactoryImpl
