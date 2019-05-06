/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getVolumeFunction <em>Volume Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getBoundComputationFunction <em>Bound Computation Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getOriginDomainVolume <em>Origin Domain Volume</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalReductionFunction <em>Local Reduction Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalScanFunction <em>Local Scan Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalReductionVariables <em>Local Reduction Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalScanReductionVariables <em>Local Scan Reduction Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalInitialVariables <em>Local Initial Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getNthreadVariableName <em>Nthread Variable Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getThreadNumVariableName <em>Thread Num Variable Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getBeginVariableName <em>Begin Variable Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getEndVariableName <em>End Variable Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getScanReductionBody <em>Scan Reduction Body</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody()
 * @model
 * @generated
 */
public interface ScanBody extends Body {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(Domain)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_Domain()
	 * @model required="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Volume Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume Function</em>' reference.
	 * @see #setVolumeFunction(VolumeFunction)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_VolumeFunction()
	 * @model required="true"
	 * @generated
	 */
	VolumeFunction getVolumeFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getVolumeFunction <em>Volume Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume Function</em>' reference.
	 * @see #getVolumeFunction()
	 * @generated
	 */
	void setVolumeFunction(VolumeFunction value);

	/**
	 * Returns the value of the '<em><b>Bound Computation Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Computation Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Computation Function</em>' reference.
	 * @see #setBoundComputationFunction(BoundComputation)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_BoundComputationFunction()
	 * @model required="true"
	 * @generated
	 */
	BoundComputation getBoundComputationFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getBoundComputationFunction <em>Bound Computation Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Computation Function</em>' reference.
	 * @see #getBoundComputationFunction()
	 * @generated
	 */
	void setBoundComputationFunction(BoundComputation value);

	/**
	 * Returns the value of the '<em><b>Origin Domain Volume</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin Domain Volume</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Domain Volume</em>' reference.
	 * @see #setOriginDomainVolume(OriginDomainVolume)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_OriginDomainVolume()
	 * @model required="true"
	 * @generated
	 */
	OriginDomainVolume getOriginDomainVolume();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getOriginDomainVolume <em>Origin Domain Volume</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Domain Volume</em>' reference.
	 * @see #getOriginDomainVolume()
	 * @generated
	 */
	void setOriginDomainVolume(OriginDomainVolume value);

	/**
	 * Returns the value of the '<em><b>Local Reduction Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Reduction Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Reduction Function</em>' reference.
	 * @see #setLocalReductionFunction(Function)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_LocalReductionFunction()
	 * @model required="true"
	 * @generated
	 */
	Function getLocalReductionFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalReductionFunction <em>Local Reduction Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Reduction Function</em>' reference.
	 * @see #getLocalReductionFunction()
	 * @generated
	 */
	void setLocalReductionFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Local Scan Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Scan Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Scan Function</em>' reference.
	 * @see #setLocalScanFunction(Function)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_LocalScanFunction()
	 * @model required="true"
	 * @generated
	 */
	Function getLocalScanFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalScanFunction <em>Local Scan Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Scan Function</em>' reference.
	 * @see #getLocalScanFunction()
	 * @generated
	 */
	void setLocalScanFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Local Reduction Variables</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Reduction Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Reduction Variables</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_LocalReductionVariables()
	 * @model
	 * @generated
	 */
	EList<CodeGenVariable> getLocalReductionVariables();

	/**
	 * Returns the value of the '<em><b>Local Scan Reduction Variables</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Scan Reduction Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Scan Reduction Variables</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_LocalScanReductionVariables()
	 * @model
	 * @generated
	 */
	EList<CodeGenVariable> getLocalScanReductionVariables();

	/**
	 * Returns the value of the '<em><b>Local Initial Variables</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Initial Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Initial Variables</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_LocalInitialVariables()
	 * @model
	 * @generated
	 */
	EList<CodeGenVariable> getLocalInitialVariables();

	/**
	 * Returns the value of the '<em><b>Nthread Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nthread Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nthread Variable Name</em>' attribute.
	 * @see #setNthreadVariableName(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_NthreadVariableName()
	 * @model required="true"
	 * @generated
	 */
	String getNthreadVariableName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getNthreadVariableName <em>Nthread Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nthread Variable Name</em>' attribute.
	 * @see #getNthreadVariableName()
	 * @generated
	 */
	void setNthreadVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Thread Num Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread Num Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Num Variable Name</em>' attribute.
	 * @see #setThreadNumVariableName(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_ThreadNumVariableName()
	 * @model required="true"
	 * @generated
	 */
	String getThreadNumVariableName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getThreadNumVariableName <em>Thread Num Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Num Variable Name</em>' attribute.
	 * @see #getThreadNumVariableName()
	 * @generated
	 */
	void setThreadNumVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Begin Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin Variable Name</em>' attribute.
	 * @see #setBeginVariableName(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_BeginVariableName()
	 * @model required="true"
	 * @generated
	 */
	String getBeginVariableName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getBeginVariableName <em>Begin Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin Variable Name</em>' attribute.
	 * @see #getBeginVariableName()
	 * @generated
	 */
	void setBeginVariableName(String value);

	/**
	 * Returns the value of the '<em><b>End Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Variable Name</em>' attribute.
	 * @see #setEndVariableName(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_EndVariableName()
	 * @model required="true"
	 * @generated
	 */
	String getEndVariableName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getEndVariableName <em>End Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Variable Name</em>' attribute.
	 * @see #getEndVariableName()
	 * @generated
	 */
	void setEndVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Scan Reduction Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scan Reduction Body</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scan Reduction Body</em>' reference.
	 * @see #setScanReductionBody(ScanReductionBody)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanBody_ScanReductionBody()
	 * @model required="true"
	 * @generated
	 */
	ScanReductionBody getScanReductionBody();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getScanReductionBody <em>Scan Reduction Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scan Reduction Body</em>' reference.
	 * @see #getScanReductionBody()
	 * @generated
	 */
	void setScanReductionBody(ScanReductionBody value);

} // ScanBody
