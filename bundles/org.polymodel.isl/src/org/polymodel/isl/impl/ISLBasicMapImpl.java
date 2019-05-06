/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.impl;

import org.eclipse.emf.ecore.EClass;
import org.polymodel.Function;
import org.polymodel.impl.BasicRelationImpl;
import org.polymodel.isl.ISLBasicMap;
import org.polymodel.isl.IslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ISL Basic Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ISLBasicMapImpl extends BasicRelationImpl implements ISLBasicMap {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISLBasicMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IslPackage.Literals.ISL_BASIC_MAP;
	}

	public Function lexmin() {
	
//		JNIISLBasicMap m = ISLNativeBinder.jniIslBasicMap(this);
//		
//		JNIISLMap r = m.lexMin();
//		
//		Function f = null;ISLNativeBinder.islFunction(r, inputs, outputs, parameters);
//		
//		
//		
//		return f;
//=======
//		//TODO
		throw new UnsupportedOperationException("Not implemented yet.");

	}

} //ISLBasicMapImpl
