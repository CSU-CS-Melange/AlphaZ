/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.PolymodelPackage#getPolymodelVisitor()
 * @model abstract="true"
 * @generated
 */
public interface PolymodelVisitor extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(d.getDimensions()!=null)\n\td.getDimensions().accept(this);\n'"
	 * @generated
	 */
	void visitDomain(Domain d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(InputDimension o: d.getInputsDimensions())\n\t o.accept(this);\nfor(OutputDimension o: d.getOutputsDimensions())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitDimensionsManager(DimensionsManager d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(e.getDomain()!=null)\n\te.getDomain().accept(this);\n'"
	 * @generated
	 */
	void visitExistentialVariable(ExistentialVariable e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(ExistentialVariable o: d.getExistential())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitDomainDimensions(DomainDimensions d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitIndexDimension(IndexDimension i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(ExistentialVariable o: r.getExistential())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitRelationDimensions(RelationDimensions r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitBasicRelation(BasicRelation b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitFunction(Function f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitRelation(Relation r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitLabel(Label l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitInputDimension(InputDimension i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitOutputDimension(OutputDimension o);

} // PolymodelVisitor
