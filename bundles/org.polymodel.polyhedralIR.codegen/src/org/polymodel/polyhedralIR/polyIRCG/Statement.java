/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;


import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getContainerLoop <em>Container Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Statement#isInlined <em>Inlined</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getScattering <em>Scattering</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStatement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Statement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStatement_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference.
	 * @see #setDomain(Domain)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStatement_Domain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Container Loop</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Loop</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Loop</em>' container reference.
	 * @see #setContainerLoop(Loop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStatement_ContainerLoop()
	 * @see org.polymodel.polyhedralIR.polyIRCG.Loop#getStatements
	 * @model opposite="statements" required="true" transient="false"
	 * @generated
	 */
	Loop getContainerLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getContainerLoop <em>Container Loop</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Loop</em>' container reference.
	 * @see #getContainerLoop()
	 * @generated
	 */
	void setContainerLoop(Loop value);

	/**
	 * Returns the value of the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inlined</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inlined</em>' attribute.
	 * @see #setInlined(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStatement_Inlined()
	 * @model required="true"
	 * @generated
	 */
	boolean isInlined();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#isInlined <em>Inlined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inlined</em>' attribute.
	 * @see #isInlined()
	 * @generated
	 */
	void setInlined(boolean value);

	/**
	 * Returns the value of the '<em><b>Scattering</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * If no scattering function is given to a statement, identity scattering is used.
	 * RHS of the scattering function must have the same dimensionality for all statements in a loop.
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scattering</em>' containment reference.
	 * @see #setScattering(AffineFunction)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getStatement_Scattering()
	 * @model containment="true"
	 * @generated
	 */
	AffineFunction getScattering();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getScattering <em>Scattering</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scattering</em>' containment reference.
	 * @see #getScattering()
	 * @generated
	 */
	void setScattering(AffineFunction value);

	/**
	 * <!-- begin-user-doc -->
	 * MacroBodyProvider is an interface defined in org.polymodel.scop.cgenerator2
	 * This method must be implemented in order to use the inlined option for statements.
	 * The body provider is used to generate statements using macro parameters at generation time
	 * so that the macros are inlined.
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.polymodel.polyhedralIR.polyIRCG.MacroBodyProvider" required="true"
	 * @generated
	 */
	MacroBodyProvider getMacroBodyProvider();

} // Statement
