/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;

import org.eclipse.emf.ecore.EClass;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ParameterDomainImpl extends DomainImpl implements ParameterDomain {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getParameterDomain();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitParameterDomain(this);
	}

	@Override
	public Domain copy() {
		return PolyhedralIRUtility.parseParameterDomain(PolyhedralIRToAlphabets.toString(this));
//		Domain dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(getParams(), getIndices(), getPMdomain().getConstraintList(FORMAT.ALPHABETS));
//		return PolyhedralIRUserFactory.eINSTANCE.createParameterDomain(dom.getPMdomain());
	}
} //ParameterDomainImpl
