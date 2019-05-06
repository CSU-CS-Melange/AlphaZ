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
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.InputDimension;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.Relation;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Relation</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RelationImpl extends AbstractRelationImpl implements Relation {
	private PolymodelDefaultFactory factory;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.RELATION;
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
	public void accept(final PolymodelVisitor visitor) {
		visitor.visitRelation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PolymodelPackage.RELATION___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * relation instance compatible with the used polyhedral library.
	 * 
	 * @param <D>
	 * @param d
	 * @param type
	 *            relation type of the library
	 * @return d if the relation is already an instance of the library relation,
	 *         else it returns a new relation of type D
	 */
	@SuppressWarnings("unchecked")
	protected <D extends Relation> D getLibraryRelation(Relation d,
			Class<D> type) {
		if (type.isInstance(d)) {
			return (D) d;
		} else {
			D res = getFactory().createRelation(d);
			return res;
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

		DimensionsManager inputDM = null;
		for (InputDimension input : dimensions.getInputs()) {
			DimensionsManager DM = (DimensionsManager)input.getDimension().eContainer();
			if (inputDM == null) {
				inputDM = DM;
			} else {
				assert(inputDM.equals(DM));
			}
		}
		
		DimensionsManager outputDM = null;
		for (OutputDimension output : dimensions.getOutputs()) {
			DimensionsManager DM = (DimensionsManager)output.getDimension().eContainer();
			if (outputDM == null) {
				outputDM = DM;
			} else {
				assert(outputDM.equals(DM));
			}
		}
		
		if (inputDM != null && outputDM != null) {
			assert(inputDM.equals(outputDM));
		}
		
		DimensionsManager indicesDM = inputDM;
		if (inputDM == null) indicesDM = outputDM;
		
		if (paramDM != null && indicesDM != null) {
			assert(paramDM.equals(indicesDM));
		}
		
		if (paramDM == null) {
			return indicesDM;
		} else {
			return paramDM;
		}
	}

	public int getNbParams() {
		return getDimensions().getParameters().size();
	}

	public int getNbInputs() {
		return getDimensions().getInputs().size();
	}

	public int getNbOutputs() {
		return getDimensions().getOutputs().size();
	}
	

	public void setInputLabel(Label label) {
		for (BasicRelation br : getBasicRelations()) {
			br.setIn(label.copy());
		}
	}
	
	public void setOutputLabel(Label label) {
		for (BasicRelation br : getBasicRelations()) {
			br.setOut(label.copy());
		}
	}

	public String toString(OUTPUT_FORMAT format) {
		return PolymodelPrettyPrinter.print(this, format);
	}

} // RelationImpl
