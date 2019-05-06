/**
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.common.util.EList;
import org.polymodel.DomainDimensions;
import org.polymodel.matrix.Matrix;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fast ISL Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.FastISLDomain#getIslSet <em>Isl Set</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.FastISLDomain#getDomDims <em>Dom Dims</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getFastISLDomain()
 * @model
 * @generated NOT
 */
public interface FastISLDomain extends Domain, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Isl Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Isl Set</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Isl Set</em>' attribute.
	 * @see #setIslSet(Object)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getFastISLDomain_IslSet()
	 * @model dataType="org.polymodel.polyhedralIR.JNIISLSet"
	 * @generated
	 */
	JNIISLSet getIslSet();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.FastISLDomain#getIslSet <em>Isl Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Isl Set</em>' attribute.
	 * @see #getIslSet()
	 * @generated
	 */
	void setIslSet(JNIISLSet value);

	/**
	 * Returns the value of the '<em><b>Dom Dims</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dom Dims</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dom Dims</em>' reference.
	 * @see #setDomDims(DomainDimensions)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getFastISLDomain_DomDims()
	 * @model
	 * @generated
	 */
	DomainDimensions getDomDims();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.FastISLDomain#getDomDims <em>Dom Dims</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dom Dims</em>' reference.
	 * @see #getDomDims()
	 * @generated
	 */
	void setDomDims(DomainDimensions value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Matrix> toMatrix();
	
	/**
	 * Faster version of toMatrix()
	 * @return
	 */
	EList<long[][]> toLongMatrix();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitFastISLDomain(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // FastISLDomain
