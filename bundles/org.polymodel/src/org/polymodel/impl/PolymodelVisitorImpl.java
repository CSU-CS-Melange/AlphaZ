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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.ExistentialVariable;
import org.polymodel.Function;
import org.polymodel.IndexDimension;
import org.polymodel.InputDimension;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.Relation;
import org.polymodel.RelationDimensions;

/**
 * <!-- begin-user-doc --> An implementation of the ' <em><b>Visitor</b></em>.
 * All visitable containments of visited objects are also visited '. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PolymodelVisitorImpl extends EObjectImpl implements
		PolymodelVisitor {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected PolymodelVisitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.POLYMODEL_VISITOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitDomain(Domain d) {
		if (d.getDimensions() != null)
			d.getDimensions().accept(this);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitDimensionsManager(DimensionsManager d) {
		for (InputDimension o : d.getInputsDimensions())
			o.accept(this);
		for (OutputDimension o : d.getOutputsDimensions())
			o.accept(this);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitExistentialVariable(ExistentialVariable e) {
		if (e.getDomain() != null)
			e.getDomain().accept(this);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitDomainDimensions(DomainDimensions d) {
		for (ExistentialVariable o : d.getExistential())
			o.accept(this);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitIndexDimension(IndexDimension i) {

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitRelationDimensions(RelationDimensions r) {
		for (ExistentialVariable o : r.getExistential())
			o.accept(this);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitBasicRelation(BasicRelation b) {

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitFunction(Function f) {

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitRelation(Relation r) {

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitLabel(Label l) {

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitInputDimension(InputDimension i) {

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitOutputDimension(OutputDimension o) {

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_DOMAIN__DOMAIN:
				visitDomain((Domain)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_DIMENSIONS_MANAGER__DIMENSIONSMANAGER:
				visitDimensionsManager((DimensionsManager)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_EXISTENTIAL_VARIABLE__EXISTENTIALVARIABLE:
				visitExistentialVariable((ExistentialVariable)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_DOMAIN_DIMENSIONS__DOMAINDIMENSIONS:
				visitDomainDimensions((DomainDimensions)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_INDEX_DIMENSION__INDEXDIMENSION:
				visitIndexDimension((IndexDimension)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_RELATION_DIMENSIONS__RELATIONDIMENSIONS:
				visitRelationDimensions((RelationDimensions)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_BASIC_RELATION__BASICRELATION:
				visitBasicRelation((BasicRelation)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_FUNCTION__FUNCTION:
				visitFunction((Function)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_RELATION__RELATION:
				visitRelation((Relation)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_LABEL__LABEL:
				visitLabel((Label)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_INPUT_DIMENSION__INPUTDIMENSION:
				visitInputDimension((InputDimension)arguments.get(0));
				return null;
			case PolymodelPackage.POLYMODEL_VISITOR___VISIT_OUTPUT_DIMENSION__OUTPUTDIMENSION:
				visitOutputDimension((OutputDimension)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} // PolymodelVisitorImpl
