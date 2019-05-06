/**
 */
package org.polymodel.polyhedralIR;

import org.polymodel.DomainDimensions;
import org.polymodel.Label;
import org.polymodel.matrix.Matrix;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fast ISL Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.FastISLMap#getIslMap <em>Isl Map</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.FastISLMap#getDomDims <em>Dom Dims</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.FastISLMap#getLabelIn <em>Label In</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.FastISLMap#getLabelOut <em>Label Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getFastISLMap()
 * @model
 * @generated NOT
 */
public interface FastISLMap extends AffineFunction, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Isl Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Isl Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Isl Map</em>' attribute.
	 * @see #setIslMap(Object)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getFastISLMap_IslMap()
	 * @model dataType="org.polymodel.polyhedralIR.JNIISLBasicMap"
	 * @generated
	 */
	JNIISLBasicMap getIslMap();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.FastISLMap#getIslMap <em>Isl Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Isl Map</em>' attribute.
	 * @see #getIslMap()
	 * @generated
	 */
	void setIslMap(JNIISLBasicMap value);

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
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getFastISLMap_DomDims()
	 * @model
	 * @generated
	 */
	DomainDimensions getDomDims();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.FastISLMap#getDomDims <em>Dom Dims</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dom Dims</em>' reference.
	 * @see #getDomDims()
	 * @generated
	 */
	void setDomDims(DomainDimensions value);

	/**
	 * Returns the value of the '<em><b>Label In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label In</em>' reference.
	 * @see #setLabelIn(Label)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getFastISLMap_LabelIn()
	 * @model
	 * @generated
	 */
	Label getLabelIn();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.FastISLMap#getLabelIn <em>Label In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label In</em>' reference.
	 * @see #getLabelIn()
	 * @generated
	 */
	void setLabelIn(Label value);

	/**
	 * Returns the value of the '<em><b>Label Out</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Out</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Out</em>' reference.
	 * @see #setLabelOut(Label)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getFastISLMap_LabelOut()
	 * @model
	 * @generated
	 */
	Label getLabelOut();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.FastISLMap#getLabelOut <em>Label Out</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Out</em>' reference.
	 * @see #getLabelOut()
	 * @generated
	 */
	void setLabelOut(Label value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix toMatrix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.polymodel.polyhedralIR.longMatrix"
	 * @generated
	 */
	long[][] toLongMatrix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitFastISLMap(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // FastISLMap
