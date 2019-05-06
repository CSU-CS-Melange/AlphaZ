/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.AbstractRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.matrix.Matrix;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Domain</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.impl.DomainImpl#getPolyhedra <em>Polyhedra</em>}</li>
 *   <li>{@link org.polymodel.impl.DomainImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.polymodel.impl.DomainImpl#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainImpl extends EObjectImpl implements Domain {
	/**
	 * The cached value of the '{@link #getPolyhedra() <em>Polyhedra</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPolyhedra()
	 * @generated
	 * @ordered
	 */
	protected EList<IntConstraintSystem> polyhedra;

	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected DomainDimensions dimensions;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected Label label;

	private PolymodelDefaultFactory factory;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected DomainImpl() {
		factory = new PolymodelDefaultFactory();
	}

	public PolymodelDefaultFactory getFactory() {
		return factory;
	}

	public void setFactory(PolymodelDefaultFactory factory) {
		this.factory = factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.DOMAIN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntConstraintSystem> getPolyhedra() {
		if (polyhedra == null) {
			polyhedra = new EObjectContainmentEList<IntConstraintSystem>(IntConstraintSystem.class, this, PolymodelPackage.DOMAIN__POLYHEDRA);
		}
		return polyhedra;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DomainDimensions getDimensions() {
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDimensions(DomainDimensions newDimensions,
			NotificationChain msgs) {
		DomainDimensions oldDimensions = dimensions;
		dimensions = newDimensions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.DOMAIN__DIMENSIONS, oldDimensions, newDimensions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimensions(DomainDimensions newDimensions) {
		if (newDimensions != dimensions) {
			NotificationChain msgs = null;
			if (dimensions != null)
				msgs = ((InternalEObject)dimensions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.DOMAIN__DIMENSIONS, null, msgs);
			if (newDimensions != null)
				msgs = ((InternalEObject)newDimensions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.DOMAIN__DIMENSIONS, null, msgs);
			msgs = basicSetDimensions(newDimensions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.DOMAIN__DIMENSIONS, newDimensions, newDimensions));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabel(Label newLabel, NotificationChain msgs) {
		Label oldLabel = label;
		label = newLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.DOMAIN__LABEL, oldLabel, newLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(Label newLabel) {
		if (newLabel != label) {
			NotificationChain msgs = null;
			if (label != null)
				msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.DOMAIN__LABEL, null, msgs);
			if (newLabel != null)
				msgs = ((InternalEObject)newLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.DOMAIN__LABEL, null, msgs);
			msgs = basicSetLabel(newLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.DOMAIN__LABEL, newLabel, newLabel));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public <T extends Domain> T union(Domain domain) {
		checkDimensions(domain);
		return factory.createDomain(dimensions.copy(), applyUnion(domain));
	}

	/**
	 * Call to a library for the union of two domains.
	 * 
	 * @param domain
	 * @return
	 */
	protected IntConstraintSystem[] applyUnion(Domain domain) {
		throw new RuntimeException(
				"No library has been binded to this operation");
	}

	/**
	 * Assertion to check that domains have the same dimensions. Don't forget to
	 * enable the assertions if you want to check that property.
	 * 
	 * @param d
	 */
	protected void checkDimensions(Domain d) {
		assert (hasCompatibleDimensions(d)) : "Domains doesn't have the same dimensions.";
	}

	protected boolean hasCompatibleDimensions(Domain d) {
		DomainDimensions otherDimensions = d.getDimensions();
		if (getDimensions() != null && otherDimensions != null) {
			if (!areEquivalents(dimensions.getIndices(),
					otherDimensions.getIndices()))
				return false;
			if (!areEquivalents(dimensions.getParameters(),
					otherDimensions.getParameters()))
				return false;
//			if (!areEquivalents(dimensions.getExistential(),
//					otherDimensions.getExistential()))
//				return false;
		}
		return true;
	}

	private boolean areEquivalents(List<? extends Variable> vars1,
			List<? extends Variable> vars2) {
		if (vars1 != null) {
			if (vars2 == null)
				return false;
		} else if (vars2 != null)
			return false;

		if (vars1.size() != vars2.size())
			return false;
		
		for (Variable v1 : vars1) {
			boolean containsV1=false;
			for (Variable v2 : vars2) {
				if (v1.equals(v2))
					containsV1=true;
			}
			if(!containsV1)
				return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public <T extends Domain> T image(AbstractRelation relation) {
		assert (isCompatible(relation)) : "Relation can't be applied on this domain.";
		assert(relation.getBasicRelations().size()==1):"More than one basic relation for image";
		// Find all referenced output dimensions
		List<Variable> dimensionsOfOutputDomain = new ArrayList<Variable>();
		for (OutputDimension outDim : relation.getDimensions().getOutputs()) {
			dimensionsOfOutputDomain.add(outDim.getDimension());
		}
		DomainDimensions imageDims = factory.createDomainDimensions(
				dimensionsOfOutputDomain, dimensions.getParameters());
		relation.getDimensions().getOutputs();
				
		// Create the image domain
		IntConstraintSystem[] applyImage = applyImage(imageDims, relation);
		T image = getFactory().createDomain(imageDims, applyImage);
		
		// Set label
		if (relation.getBasicRelations().get(0).getOut() != null) {
			image.setLabel(relation.getBasicRelations().get(0).getOut());
		}
		
		return image;
	}

	/**
	 * Call a library to build images of domain polyhedra by a relation
	 * 
	 * @param relation
	 * @return
	 */
	protected IntConstraintSystem[] applyImage(DomainDimensions dims, AbstractRelation relation) {
		throw new RuntimeException(
				"No library has been binded to this operation");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public <T extends Domain> T difference(Domain domain) {
		checkDimensions(domain);
		return getFactory().createDomain(dimensions.copy(), applyDifference(domain));
	}

	/**
	 * Call to a library for the difference of two domains.
	 * 
	 * @param domain
	 * @return
	 */
	protected IntConstraintSystem[] applyDifference(Domain domain) {
		throw new RuntimeException(
				"No library has been binded to this operation");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public <T extends Domain> T intersection(Domain domain) {
		checkDimensions(domain);
		T d = getFactory().createDomain(dimensions.copy(),
				applyIntersection(domain));
		
		if (this.getLabel() != null) {
			d.setLabel(this.getLabel().copy());
		}
		
		return d;
	}

	/**
	 * Call to a library for the intersection of two domains.
	 * 
	 * @param domain
	 * @return
	 */
	protected IntConstraintSystem[] applyIntersection(Domain domain) {
		throw new RuntimeException(
				"No library has been binded to this operation");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isEmpty() {
		throw new RuntimeException(
				"No library has been binded to this operation");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public <T extends Domain> T simplify(Domain context) {
		throw new RuntimeException("Not implemented yet.");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public <T extends Domain> T simplify() {
		T createDomain = getFactory().createDomain(this);
		
		IntConstraintSystem[] applySimplify = createDomain.applySimplify();
		createDomain.getPolyhedra().clear();
		createDomain.getPolyhedra().addAll(Arrays.asList(applySimplify));
		
		return createDomain;
	}

	/**
	 * Call to a library for the simplification of a domain.
	 * 
	 * @param domain
	 * @return
	 */
	public IntConstraintSystem[] applySimplify() {
		throw new RuntimeException(
				"No library has been binded to this operation");
	}

	/**
	 * <!-- begin-user-doc --> Find the bounding box of a domain using
	 * projections.<!-- end-user-doc -->
	 * 
	 * 
	 * @generated NOT
	 */
	public Domain boundingBox() {
		IntConstraintSystem polyhedron = IntExpressionBuilder.factory.createIntConstraintSystem();
		Domain boundingBox = getFactory().createDomain(dimensions.copy(),
				polyhedron);
		for (Variable v : getDimensions().getIndices()) {
			Domain boundingDomain = projection(findProjectedDimensions(v));
			polyhedron.getConstraints().addAll(boundingDomain.getPolyhedra().get(0).getConstraints());		// TODO: bounding box =>
																											//		only first polyhedra considered
		}
		return boundingBox.simplify();
	}

	private Variable[] findProjectedDimensions(Variable d) {
		EList<Variable> indices = getDimensions().getIndices();
		Variable projected[] = new Variable[indices.size() - 1];
		int i = 0;
		for (Variable dim : indices) {
			if (dim != d) {
				projected[i] = dim;
				i++;
			}
		}
		return projected;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equivalence(Domain domain) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolymodelVisitor visitor) {
		visitor.visitDomain(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUniverse() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Domain> T lexMin() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Domain> T lexMax() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Domain> T detectEqualities() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Domain> T affineHull() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Domain> T polyhedralHull() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	private boolean isCompatible(AbstractRelation d) {
		RelationDimensions otherDimensions = d.getDimensions();
		if (getDimensions() != null && otherDimensions != null) {
			if (!areEquivalents(dimensions.getParameters(),
					otherDimensions.getParameters()))
				return false;
			if (!areEquivalents(dimensions.getExistential(),
					otherDimensions.getExistential()))
				return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolymodelPackage.DOMAIN__POLYHEDRA:
				return ((InternalEList<?>)getPolyhedra()).basicRemove(otherEnd, msgs);
			case PolymodelPackage.DOMAIN__DIMENSIONS:
				return basicSetDimensions(null, msgs);
			case PolymodelPackage.DOMAIN__LABEL:
				return basicSetLabel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolymodelPackage.DOMAIN__POLYHEDRA:
				return getPolyhedra();
			case PolymodelPackage.DOMAIN__DIMENSIONS:
				return getDimensions();
			case PolymodelPackage.DOMAIN__LABEL:
				return getLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolymodelPackage.DOMAIN__POLYHEDRA:
				getPolyhedra().clear();
				getPolyhedra().addAll((Collection<? extends IntConstraintSystem>)newValue);
				return;
			case PolymodelPackage.DOMAIN__DIMENSIONS:
				setDimensions((DomainDimensions)newValue);
				return;
			case PolymodelPackage.DOMAIN__LABEL:
				setLabel((Label)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PolymodelPackage.DOMAIN__POLYHEDRA:
				getPolyhedra().clear();
				return;
			case PolymodelPackage.DOMAIN__DIMENSIONS:
				setDimensions((DomainDimensions)null);
				return;
			case PolymodelPackage.DOMAIN__LABEL:
				setLabel((Label)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PolymodelPackage.DOMAIN__POLYHEDRA:
				return polyhedra != null && !polyhedra.isEmpty();
			case PolymodelPackage.DOMAIN__DIMENSIONS:
				return dimensions != null;
			case PolymodelPackage.DOMAIN__LABEL:
				return label != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PolymodelPackage.DOMAIN___UNION__DOMAIN:
				return union((Domain)arguments.get(0));
			case PolymodelPackage.DOMAIN___IMAGE__ABSTRACTRELATION:
				return image((AbstractRelation)arguments.get(0));
			case PolymodelPackage.DOMAIN___DIFFERENCE__DOMAIN:
				return difference((Domain)arguments.get(0));
			case PolymodelPackage.DOMAIN___INTERSECTION__DOMAIN:
				return intersection((Domain)arguments.get(0));
			case PolymodelPackage.DOMAIN___IS_EMPTY:
				return isEmpty();
			case PolymodelPackage.DOMAIN___SIMPLIFY__DOMAIN:
				return simplify((Domain)arguments.get(0));
			case PolymodelPackage.DOMAIN___SIMPLIFY:
				return simplify();
			case PolymodelPackage.DOMAIN___BOUNDING_BOX:
				return boundingBox();
			case PolymodelPackage.DOMAIN___EQUIVALENCE__DOMAIN:
				return equivalence((Domain)arguments.get(0));
			case PolymodelPackage.DOMAIN___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
			case PolymodelPackage.DOMAIN___IS_UNIVERSE:
				return isUniverse();
			case PolymodelPackage.DOMAIN___LEX_MIN:
				return lexMin();
			case PolymodelPackage.DOMAIN___LEX_MAX:
				return lexMax();
			case PolymodelPackage.DOMAIN___DETECT_EQUALITIES:
				return detectEqualities();
			case PolymodelPackage.DOMAIN___AFFINE_HULL:
				return affineHull();
			case PolymodelPackage.DOMAIN___POLYHEDRAL_HULL:
				return polyhedralHull();
			case PolymodelPackage.DOMAIN___TO_MATRICES:
				return toMatrices();
			case PolymodelPackage.DOMAIN___COMPLEMENT:
				return complement();
			case PolymodelPackage.DOMAIN___CARTESIAN_PRODUCT__DOMAIN:
				return cartesianProduct((Domain)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public String toString() {
		List<String> polyhedra = new LinkedList<String>();

		EList<Variable> params = dimensions.getParameters();
		String lhsP = toStringList(params, ",");
		EList<Variable> indices = dimensions.getIndices();
		String lhsI = toStringList(indices, ",");
		String lhs = null;
		if (params.size() > 0 && indices.size() > 0) {
			lhs = lhsP + "," + lhsI;
		} else {
			lhs = lhsP + lhsI;
		}
		if (this.polyhedra == null) {
			return "{" + lhs + "|" + "}";
		}
		for (IntConstraintSystem poly : getPolyhedra()) {
			polyhedra.add("{" + lhs + "|" + poly + "}");
		}
		return toStringList(polyhedra, "||");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected String toStringList(List<?> list, String separator) {
		StringBuffer buff = new StringBuffer();
		if (list == null)
			return "";
		boolean first = true;
		for (Object obj : list) {
			if (first) {
				first = false;
				buff.append(obj.toString());
			} else {
				buff.append(separator + obj.toString());

			}
		}
		return buff.toString();
	}

	public <T extends Domain> T projection(Variable... dimensions) {
		DomainDimensions projectionDimensions = getDimensions().copy();
//		for (Variable d : dimensions) {
//			projectionDimensions.getIndices().remove(d);
//		}
		return getFactory().createDomain(projectionDimensions, applyProjection(dimensions));
	}

	/**
	 * Call to a library for the simplification of a domain.
	 * 
	 * @param domain
	 * @return
	 */
	protected IntConstraintSystem[] applyProjection(Variable dimensions[]) {
		throw new RuntimeException(
				"No library has been binded to this operation");
	}

	/**
	 * Get the domain instance compatible with the used polyhedral library.
	 * 
	 * @param <D>
	 * @param d
	 * @param type
	 *            domain type of the library
	 * @return d if the domain is already an instance of the library domain,
	 *         else it returns a new domain of type D
	 */
	@SuppressWarnings("unchecked")
	protected <D extends Domain> D getLibraryDomain(Domain d, Class<D> type) {
		if (type.isInstance(d)) {
			return (D) d;
		} else {
			D res = getFactory().createDomain(d);
			return res;
		}
	}

	public void addConstraint(IntConstraint c) {
		for(IntConstraintSystem p: getPolyhedra()){
			p.getConstraints().add(EcoreUtil.copy(c));
		}
		
	}

	/**
	 * Either use PolymodelComponent.INSTANCE.getDefaultDimensionsManager()
	 * or manage dimension management at higher level.
	 */
	@Deprecated
	public DimensionsManager getDimensionsManager() {
		
		DimensionsManager paramDM = null;
		for (Variable param : dimensions.getParameters()) {
			DimensionsManager DM = (DimensionsManager)param.eContainer();
			if (paramDM == null) {
				paramDM = DM;
			} else {
				assert(paramDM.equals(DM));
			}
		}

		DimensionsManager indicesDM = null;
		for (Variable index : dimensions.getIndices()) {
			DimensionsManager DM = (DimensionsManager)index.eContainer();
			if (indicesDM == null) {
				indicesDM = DM;
			} else {
				assert(indicesDM.equals(DM));
			}
		}
		
		if (paramDM != null && indicesDM != null) {
			assert(paramDM.equals(indicesDM));
		}
		
		if (paramDM == null) {
			return indicesDM;
		} else {
			return paramDM;
		}
	}

	public EList<Variable> getParams() {
		return getDimensions().getParameters();
	}
	public EList<Variable>  getIndices() {
		return getDimensions().getIndices();
	}
	public int getNbParams() {
		return getDimensions().getParameters().size();
	}
	
	public int getNbIndices() {
		return getDimensions().getIndices().size();
	}
	public String toString(OUTPUT_FORMAT format) {
		return PolymodelPrettyPrinter.print(this, format);
	}
	public EList<Matrix> toMatrices() {

		EList<Matrix> mats = new BasicEList<Matrix>();
		List<Variable> vars = new ArrayList<Variable>(getNbIndices() + getNbParams());
		vars.addAll(getParams());
		vars.addAll(getIndices());
		for (IntConstraintSystem poly :getPolyhedra()) {
			mats.add(PolymodelComponent.INSTANCE.getFactory().createMatrix(poly, vars));
		}

		return mats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T extends Domain> T complement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T extends Domain> T cartesianProduct(Domain domain) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T extends Domain> T copy() {
		return (T) EcoreUtil.copy(this);
	}
} // DomainImpl
