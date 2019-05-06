/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.matrix.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixFactory;
import org.polymodel.matrix.MatrixPackage;
import org.polymodel.matrix.MatrixRow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MatrixFactoryImpl extends EFactoryImpl implements MatrixFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MatrixFactory init() {
		try {
			MatrixFactory theMatrixFactory = (MatrixFactory)EPackage.Registry.INSTANCE.getEFactory(MatrixPackage.eNS_URI);
			if (theMatrixFactory != null) {
				return theMatrixFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MatrixFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatrixFactoryImpl() {
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
			case MatrixPackage.MATRIX: return createMatrix();
			case MatrixPackage.MATRIX_ROW: return createMatrixRow();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Matrix createMatrix() {
		MatrixImpl matrix = new MatrixImpl();
		return matrix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatrixRow createMatrixRow() {
		MatrixRowImpl matrixRow = new MatrixRowImpl();
		return matrixRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatrixPackage getMatrixPackage() {
		return (MatrixPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MatrixPackage getPackage() {
		return MatrixPackage.eINSTANCE;
	}

} //MatrixFactoryImpl
