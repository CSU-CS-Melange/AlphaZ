/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.gt;
import static org.polymodel.algebra.factory.IntExpressionBuilder.lt;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;
import static org.polymodel.prdg.scheduling.util.SchedulingToolFunctions.intersection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.ScheduleCoefficient;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.SchedulingFactory;
import org.polymodel.prdg.scheduling.farkas.FarkasDependencyConstraints;
import org.polymodel.prdg.scheduling.impl.DependencyImpl;
import org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;
import org.polymodel.prdg.scheduling.multidim.impl.MultidimDependencyImpl;
import org.polymodel.prdg.scheduling.notifications.FarkasNotification;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.BoundingCoefficient;
import org.polymodel.prdg.scheduling.structured.MemoryReadDependency;
import org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency;
import org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Multidim Memory Read Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.MultidimDeallocationDependencyImpl#getDimensionSizes <em>Dimension Sizes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultidimDeallocationDependencyImpl extends MultidimDependencyImpl
		implements MultidimDeallocationDependency {
	/**
	 * The cached value of the '{@link #getDimensionSizes() <em>Dimension Sizes</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDimensionSizes()
	 * @generated
	 * @ordered
	 */
	protected EList<Long> dimensionSizes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MultidimDeallocationDependencyImpl() {
		super();
	}

	@Override
	public Domain computeConstraints() {
		Domain result = super.computeConstraints();
		BoundedChannel channel = getFirstReadDependency().getChannel();
		PRDGEdge edge = getEdge();
		List<ScheduleTerm> allDimsTerms = new ArrayList<ScheduleTerm>();
		for (Dependency d : getDependencies()) {
			EList<ScheduleTerm> terms = d.buildAllDependencyTerms(d.getSource()
					.getTerms(), d.getReference().getTerms());

			allDimsTerms.addAll(terms);
		}

		ConstantBoundScheduleProtoype memorySize = new ConstantBoundScheduleProtoype(
				"B_" + channel.getName(), channel.getDomain(),channel.getMaximalChannelSize());

		MemoryLinearizationPrototype linearizationPrototype = new MemoryLinearizationPrototype(
				"L_" + channel.getName(), channel, allDimsTerms, dimensionSizes);

		// Use Farkas on the first inequality of the modulo allocation
		// equality
		MultidimensionnalBoundedDependency d1 = new MultidimensionnalBoundedDependency(
				edge, channel, dimensionSizes, memorySize,
				linearizationPrototype);
		FarkasDependencyConstraints farkas1 = new FarkasDependencyConstraints(
				d1);
		notify(new FarkasNotification(this, farkas1));
		Domain applied1 = farkas1.getApplied();
		result = intersection(result, applied1);

		// Use Farkas on the second inequality of the modulo allocation
		// equality
		MultidimensionnalBoundedDependency d2 = new MultidimensionnalBoundedDependency(
				edge, channel, dimensionSizes, linearizationPrototype,
				memorySize);
		FarkasDependencyConstraints farkas2 = new FarkasDependencyConstraints(
				d2);
		notify(new FarkasNotification(this, farkas2));
		Domain applied2 = farkas2.getApplied();
		result = intersection(result, applied2);

		return result;
	}

	private PRDGEdge getEdge() {
		MultidimMemoryReadDependencyComponent dependency = getFirstReadDependency();
		return dependency.getEdge();
	}

	private MultidimMemoryReadDependencyComponent getFirstReadDependency() {
		NullifiableDependency nullifiableDependency = getDependencies().get(0);
		MultidimMemoryReadDependencyComponent dependency = (MultidimMemoryReadDependencyComponent) nullifiableDependency
				.getDependency();
		return dependency;
	}

	public static class MultidimensionnalBoundedDependency extends
			DependencyImpl {
		private PRDGEdge edge;
		// private int dimension;
		private BoundedChannel channel;
		private EList<Long> dimensionSizes;

		public MultidimensionnalBoundedDependency(PRDGEdge edge,
				BoundedChannel channel, EList<Long> dimensionSizes,
				SchedulePrototype left, SchedulePrototype right) {
			this.edge = edge;
			// this.dimension = dimension;
			this.channel = channel;
			this.dimensionSizes = dimensionSizes;
			setSource(left);
			setReference(right);
		}

		@Override
		public EList<ScheduleTerm> buildAllDependencyTerms(
				List<ScheduleTerm> sourceTerms,
				List<ScheduleTerm> referenceTerms) {
			EList<ScheduleTerm> allTerms = new BasicEList<ScheduleTerm>();

			// Add distributed reference terms
			for (ScheduleTerm refTerm : referenceTerms) {
				allTerms.addAll(refTerm.distribute());
			}

			// Apply dependency mapping and distribute negated source terms
			Function sourceDependencyMapping = buildSourceDependencyMapping(edge
					.getFunction().getMapping());
			for (ScheduleTerm sourceTerm : sourceTerms) {
				ScheduleTerm appliedTerm = sourceTerm.apply(
						sourceDependencyMapping).negate();
				allTerms.addAll(appliedTerm.distribute());
			}
			return allTerms;
		}
		
		@Override
		public ScheduleTerm getCausalityTerm() {
			return schedulingConcreteFactory
					.createScheduleConstantTerm(affine(term(0)));
		}

		@Override
		public EList<Variable> getAllVariables() {
			return new BasicEList<Variable>(channel.getBoundingCoefficients());
		}
		private Domain dependencyDomain;

		@Override
		public Domain getDependencyDomain() {
			if (dependencyDomain == null) {
				dependencyDomain = factory.createDomain(new ArrayList<Variable>(),constraintSystem());
	
				// Upper and lower bounds of bounding coefficients

				for (BoundingCoefficient boundingCoefficient : channel
						.getBoundingCoefficients()) {
					dependencyDomain.getDimensions().getIndices()
							.add(boundingCoefficient);
					long max = dimensionSizes.get(boundingCoefficient
							.getIndex());
					dependencyDomain.addConstraint(gt(
							affine(term(boundingCoefficient)),
							affine(term(-max))));
					dependencyDomain.addConstraint(lt(
							affine(term(boundingCoefficient)),
							affine(term(max))));
				}
			}
			return dependencyDomain.simplify();
		}
	}

	public static class MemoryLinearizationPrototype extends
			SchedulePrototypeImpl {
		private String name;
		private BoundedChannel channel;
		private EList<Long> dimensionSizes;

		public MemoryLinearizationPrototype(String name,
				BoundedChannel channel, List<ScheduleTerm> allDimsTerms,
				EList<Long> dimensionSizes) {
			super();
			this.name = name;
			this.channel = channel;
			this.dimensionSizes = dimensionSizes;
			for (ScheduleTerm scheduleTerm : allDimsTerms) {
				AffineExpression exp = scheduleTerm.getExp();
				if (exp.getTerms().size() > 1)
					throw new RuntimeException(
							"Distributed prototype should only have primitives expressions ");
			
				Variable variable = exp.getTerms().get(0).getVariable();
				if (channel.getBoundingCoefficients().contains(variable)) {
					BoundingCoefficient b = (BoundingCoefficient) variable;
					if(!scheduleTerm.isConstant())
						getCoeficients().add((ScheduleCoefficient) scheduleTerm.getVar());
					int k = findLinearizationFactor(b);
					AffineExpression linearizationExpression = affine(term(k, b));
					ScheduleTerm linearizedTerm = SchedulingFactory.eINSTANCE
							.createScheduleTerm();
					linearizedTerm.setExp(linearizationExpression);
					linearizedTerm.setVar(scheduleTerm.getVar());
					getTerms().add(linearizedTerm);
				}

			}
		}

		private int findLinearizationFactor(BoundingCoefficient b) {
			int size = 1;
		
			for (int i = b.getDimension(); i < getDomain().getNbIndices()-1; i++) {
				size*=dimensionSizes.get(i);
			}
			return size;

		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public Domain getDomain() {
			return channel.getDomain();
		}

	}

	public static class ConstantBoundScheduleProtoype extends
			SchedulePrototypeImpl {
		private String name;
		private Domain domain;

		public ConstantBoundScheduleProtoype(String name,Domain domain, int value) {
			super();
			this.name = name;
			this.domain = domain;
			ScheduleTerm term = SchedulingFactory.eINSTANCE
					.createScheduleTerm();
			term.setExp(affine(term(value)));
			getTerms().add(term);
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public Domain getDomain() {
			return domain;
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.MULTIDIM_DEALLOCATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Long> getDimensionSizes() {
		if (dimensionSizes == null) {
			dimensionSizes = new EDataTypeEList<Long>(Long.class, this, StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES);
		}
		return dimensionSizes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getMemorySize() {
		return getChannel().getMaximalChannelSize();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Domain getDomain() {
		NullifiableDependency nullifiableDependency = getDependencies().get(0);
		return nullifiableDependency.getDependencyDomain();
	}

	public BoundedChannel getChannel() {
		NullifiableDependency nullifiableDependency = getDependencies().get(0);
		MemoryReadDependency dependency = (MemoryReadDependency) nullifiableDependency
				.getDependency();
		return dependency.getChannel();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES:
				return getDimensionSizes();
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
			case StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES:
				getDimensionSizes().clear();
				getDimensionSizes().addAll((Collection<? extends Long>)newValue);
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
			case StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES:
				getDimensionSizes().clear();
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
			case StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES:
				return dimensionSizes != null && !dimensionSizes.isEmpty();
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
			case StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY___GET_DOMAIN:
				return getDomain();
			case StructuredPackage.MULTIDIM_DEALLOCATION_DEPENDENCY___GET_CHANNEL:
				return getChannel();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dimensionSizes: ");
		result.append(dimensionSizes);
		result.append(')');
		return result.toString();
	}

} // MultidimMemoryReadDependencyImpl
