/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.*;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage
 * @generated
 */
public class SimdExpAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SimdExpPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimdExpAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SimdExpPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimdExpSwitch<Adapter> modelSwitch =
		new SimdExpSwitch<Adapter>() {
			@Override
			public Adapter caseSIMDExpression(SIMDExpression object) {
				return createSIMDExpressionAdapter();
			}
			@Override
			public Adapter caseBasicMemoryAddress(BasicMemoryAddress object) {
				return createBasicMemoryAddressAdapter();
			}
			@Override
			public Adapter caseVLoadExpression(VLoadExpression object) {
				return createVLoadExpressionAdapter();
			}
			@Override
			public Adapter caseVStoreExpression(VStoreExpression object) {
				return createVStoreExpressionAdapter();
			}
			@Override
			public Adapter caseVBinaryExpression(VBinaryExpression object) {
				return createVBinaryExpressionAdapter();
			}
			@Override
			public Adapter caseVShiftExpression(VShiftExpression object) {
				return createVShiftExpressionAdapter();
			}
			@Override
			public Adapter caseVRegisterExpression(VRegisterExpression object) {
				return createVRegisterExpressionAdapter();
			}
			@Override
			public Adapter caseVAssignExpression(VAssignExpression object) {
				return createVAssignExpressionAdapter();
			}
			@Override
			public Adapter caseVSetExpression(VSetExpression object) {
				return createVSetExpressionAdapter();
			}
			@Override
			public Adapter caseVPermuteExpression(VPermuteExpression object) {
				return createVPermuteExpressionAdapter();
			}
			@Override
			public Adapter caseVShuffleExpression(VShuffleExpression object) {
				return createVShuffleExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression <em>SIMD Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression
	 * @generated
	 */
	public Adapter createSIMDExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress <em>Basic Memory Address</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress
	 * @generated
	 */
	public Adapter createBasicMemoryAddressAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression <em>VLoad Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression
	 * @generated
	 */
	public Adapter createVLoadExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression <em>VStore Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression
	 * @generated
	 */
	public Adapter createVStoreExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression <em>VBinary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression
	 * @generated
	 */
	public Adapter createVBinaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression <em>VShift Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression
	 * @generated
	 */
	public Adapter createVShiftExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression <em>VRegister Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression
	 * @generated
	 */
	public Adapter createVRegisterExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression <em>VAssign Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression
	 * @generated
	 */
	public Adapter createVAssignExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression <em>VSet Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression
	 * @generated
	 */
	public Adapter createVSetExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression <em>VPermute Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression
	 * @generated
	 */
	public Adapter createVPermuteExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression <em>VShuffle Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression
	 * @generated
	 */
	public Adapter createVShuffleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SimdExpAdapterFactory
