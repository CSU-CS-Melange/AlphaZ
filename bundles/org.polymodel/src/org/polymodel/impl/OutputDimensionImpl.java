/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Dimension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OutputDimensionImpl extends RelationDimensionImpl implements OutputDimension {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputDimensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.OUTPUT_DIMENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolymodelVisitor visitor) {
		visitor.visitOutputDimension(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PolymodelPackage.OUTPUT_DIMENSION___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public String toString() {
		return getDimension().getName()+"(out)";
	}
	

	public String toString(OUTPUT_FORMAT format) {
		return PolymodelPrettyPrinter.print(this, format);
	}

} //OutputDimensionImpl
