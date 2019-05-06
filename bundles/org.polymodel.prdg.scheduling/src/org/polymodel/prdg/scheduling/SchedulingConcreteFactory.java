package org.polymodel.prdg.scheduling;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.DimensionsManager;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.impl.EdgeDependencyImpl;
import org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl;
import org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.multidim.MultidimFactory;
import org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;
import org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl;
import org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype;

public class SchedulingConcreteFactory {
	/**
	 * Default prefix of schedule coeficients.
	 */
	public final static String SCHEDULE_COEF = "mu";
	public final static String SCALAR_SCHEDULE_COEF = "beta";
	public final static String SATISFACTION_VAR = "delta";

	/**
	 * Naming prefix of all schedule coeficients. Default is "mu".
	 */
	public String prefix = SCHEDULE_COEF;

	public EdgeDependency createEdgeDependency(
			StatementSchedulePrototype source,
			StatementSchedulePrototype reference, PRDGEdge e) {
		EdgeDependency dep = SchedulingFactory.eINSTANCE.createEdgeDependency();
		dep.setSource(source);
		dep.setReference(reference);
		dep.setEdge(e);
		return dep;
	}

	public EdgeDependency createEdgeDependency(
			StatementSchedulePrototype source,
			StatementSchedulePrototype reference, PRDGEdge e,
			PolymodelDefaultFactory polymodelFactory,
			DimensionsManager dimensionsManager) {
		EdgeDependencyImpl dep = (EdgeDependencyImpl) createEdgeDependency(
				source, reference, e);
		dep.initialize(polymodelFactory, dimensionsManager);
		return dep;
	}

	public ScheduleTerm createScheduleTerm(Variable var, AffineExpression exp) {
		ScheduleTerm term = SchedulingFactory.eINSTANCE.createScheduleTerm();
		term.setVar(var);
		term.setExp(exp);

		return term;
	}

	public ScheduleTerm createScheduleConstantTerm(AffineExpression exp) {
		ScheduleTerm term = SchedulingFactory.eINSTANCE.createScheduleTerm();
		term.setExp(exp);
		return term;
	}

	public ScheduledStatement createScheduledStatement(PRDGNode n,
			List<IntExpression> schedule) {
		ScheduledStatement s = SchedulingFactory.eINSTANCE
				.createScheduledStatement();
		s.getSchedule().addAll(schedule);
		s.setStatement(n);
		return s;
	}

	// /**
	// * Create a new schedule coefficient using a name after the prefix of the
	// * factory
	// *
	// * @param name
	// * @param id
	// * @return
	// */
	// public Variable createScheduleCoeficientVariable(String name, int id) {
	// Variable lambdac = IntExpressionBuilder.var(this.prefix + "_" + name
	// + "_" + id);
	// return lambdac;
	// }

	public ScheduleCoefficient createScheduleCoefficient(String name) {
		return createScheduleCoefficient(name, 1);
	}

	public ScheduleCoefficient createScheduleCoefficient(String name, int dim) {
		ScheduleCoefficient c = SchedulingFactory.eINSTANCE
				.createScheduleCoefficient();
		c.setName(name);
		c.setDimension(dim);
		return c;
	}

	protected static int MULTIDIM_DEP_ID;

	/**
	 * Create a multidimensional dependency (without scalar dimensions) from a
	 * monodimensional dependency. It creates a new nullifiable instance of the
	 * dependency for each dimension.
	 * 
	 * @param dependency
	 * @param dims
	 * @param K
	 * @param map
	 *            map the original schedule prototype to their multidimensional
	 *            version (if no mapping exist then the appropriate multidim
	 *            prototype is created and mapped)
	 * @return
	 */
	public MultidimDependency createMultidimensionalDependency(
			Dependency dependency, int dims, long K,
			Map<SchedulePrototype, MultidimSchedulePrototype> map) {
		return createMultidimensionalDependency(dependency, dims, K, map, false);
	}

	/**
	 * Create a multidimensional dependency from a monodimensional dependency.
	 * It creates a new nullifiable instance of the dependency for each
	 * dimension.
	 * 
	 * @param dependency
	 * @param dims
	 * @param K
	 * @param map
	 *            map the original schedule prototype to their multidimensional
	 *            version (if no mapping exist then the appropriate multidim
	 *            prototype is created and mapped)
	 * @param scalars
	 *            true if scalars dimensions are added
	 * @return
	 */
	public MultidimDependency createMultidimensionalDependency(
			Dependency dependency, int dims, long K,
			Map<SchedulePrototype, MultidimSchedulePrototype> map,
			boolean scalars) {
		List<NullifiableDependency> nullifiableDependencies = new ArrayList<NullifiableDependency>();

		MultidimSchedulePrototype msource = getMultidimSchedulePrototype(
				dependency.getSource(), dims, map, scalars);
		MultidimSchedulePrototype mreference = getMultidimSchedulePrototype(
				dependency.getReference(), dims, map, scalars);

		if (msource.getScalars().size() != mreference.getScalars().size()) {
			throw new IllegalArgumentException(
					"Prototypes of the dependency don't have the same number of scalar dimensions");
		}
		int mulitdimID = MULTIDIM_DEP_ID++;
		boolean hasScalars = msource.getScalars().size() > 0;
		for (int i = 0; i < dims; i++) {
			int dim = i;
			if (hasScalars) {
				int sdim = 2 * i;
				dim = 2 * i + 1;
				Dependency scalarInstanceAtDim = instantiateScalarDependencyAt(
						i, dependency, msource, mreference);
				NullifiableDependency ndep = createNullifiableDependency(
						mulitdimID, sdim, scalarInstanceAtDim, K);
				nullifiableDependencies.add(ndep);
			}
			Dependency instanceAtDim = instantiateDependencyAt(i, dependency,
					msource, mreference);
			NullifiableDependency ndep = createNullifiableDependency(
					mulitdimID, dim, instanceAtDim, K);
			nullifiableDependencies.add(ndep);
		}
		if (hasScalars) {
			int sdim = 2 * dims;
			Dependency scalarInstanceAtDim = instantiateScalarDependencyAt(
					dims, dependency, msource, mreference);
			NullifiableDependency ndep = createNullifiableDependency(
					mulitdimID, sdim, scalarInstanceAtDim, K);
			nullifiableDependencies.add(ndep);
		}
		return createMultidimensionalDependency(nullifiableDependencies);
	}

	private Dependency instantiateDependencyAt(int index,
			Dependency dependency, MultidimSchedulePrototype msource,
			MultidimSchedulePrototype mreference) {
		Dependency instanceAtDim = EcoreUtil.copy(dependency);
		SchedulePrototype source = msource.getPrototypes().get(index);
		SchedulePrototype reference = mreference.getPrototypes().get(index);
		instanceAtDim.setSource(source);
		instanceAtDim.setReference(reference);
		return instanceAtDim;
	}

	private Dependency instantiateScalarDependencyAt(int index,
			Dependency dependency, MultidimSchedulePrototype msource,
			MultidimSchedulePrototype mreference) {
		Dependency instanceAtDim = EcoreUtil.copy(dependency);
		SchedulePrototype source = msource.getScalars().get(index);
		SchedulePrototype reference = mreference.getScalars().get(index);
		instanceAtDim.setSource(source);
		instanceAtDim.setReference(reference);
		return instanceAtDim;
	}

	protected MultidimSchedulePrototype getMultidimSchedulePrototype(
			SchedulePrototype s, int dims,
			Map<SchedulePrototype, MultidimSchedulePrototype> map,
			boolean scalars) {
		MultidimSchedulePrototype multidimSchedulePrototype = map.get(s);
		if (multidimSchedulePrototype == null) {
			if (scalars) {
				multidimSchedulePrototype = createMultidimSchedulePrototypeWithScalarDimensions(
						s, dims);
			} else
				multidimSchedulePrototype = createMultidimSchedulePrototype(s,
						dims);
			map.put(s, multidimSchedulePrototype);
		}
		return multidimSchedulePrototype;
	}

	/**
	 * Create a {@link MultidimSchedulePrototype} from a base
	 * {@link SchedulePrototype} for multiple dimensions.
	 * 
	 * @param prototype
	 *            base prototype
	 * @param nbDims
	 *            number of dimensions
	 * @return
	 */
	public MultidimSchedulePrototype createMultidimSchedulePrototype(
			SchedulePrototype prototype, int nbDims) {
		MultidimSchedulePrototype mPrototype = MultidimFactory.eINSTANCE
				.createMultidimSchedulePrototype();

		for (int i = 0; i < nbDims; i++) {
			SchedulePrototypeImpl protoAtDim = (SchedulePrototypeImpl) EcoreUtil.copy(prototype);
			for (ScheduleCoefficient coef : protoAtDim.getCoeficients()) {
				String newNam = formatVariableNameAt(coef.getName(), i + 1);
				coef.setName(newNam);
				coef.setDimension(i + 1);
			}
			protoAtDim.setFactory(PolymodelComponent.INSTANCE.getFactory());
			mPrototype.getPrototypes().add(protoAtDim);
		}
		mPrototype.setReference(prototype);
		return mPrototype;
	}

	/**
	 * Create a {@link MultidimSchedulePrototype} with a nbDims+1 scalar
	 * dimensions for fusion/distributions.
	 * 
	 * @param prototype
	 * @param nbDims
	 * @return
	 */
	public MultidimSchedulePrototype createMultidimSchedulePrototypeWithScalarDimensions(
			SchedulePrototype prototype, int nbDims) {
		MultidimSchedulePrototype mPrototype = MultidimFactory.eINSTANCE
				.createMultidimSchedulePrototype();

		for (int i = 0; i < nbDims; i++) {
			SchedulePrototypeImpl protoAtDim = (SchedulePrototypeImpl) EcoreUtil.copy(prototype);
			for (ScheduleCoefficient coef : protoAtDim.getCoeficients()) {
				int dim = 2 * i + 1;
				String newNam = formatVariableNameAt(coef.getName(), dim);
				coef.setName(newNam);
				coef.setDimension(dim);
			}
			protoAtDim.setFactory(PolymodelComponent.INSTANCE.getFactory());
			mPrototype.getPrototypes().add(protoAtDim);

		}
		for (int i = 0; i < nbDims + 1; i++) {
			int dim = 2 * i;
			ScalarSchedulePrototype scalar = createScalarSchedulePrototype(
					prototype, dim);
			mPrototype.getScalars().add(scalar);
		}
		mPrototype.setReference(prototype);
		return mPrototype;
	}

	private ScalarSchedulePrototype createScalarSchedulePrototype(
			SchedulePrototype p, int dim) {
		// XXX: dirty dispatch
		if (p instanceof StatementSchedulePrototype) {
			return createStatementScalarSchedulePrototype(
					(StatementSchedulePrototype) p, dim);
		}
		if (p instanceof ChannelSchedulePrototype) {
			return createChannelScalarSchedulePrototype(
					(ChannelSchedulePrototype) p, dim);
		}
		throw new UnsupportedOperationException(p.getName() + ":"
				+ p.getClass().getName());
	}

	public StatementScalarSchedulePrototype createStatementScalarSchedulePrototype(
			StatementSchedulePrototype p, int dim) {
		StatementScalarSchedulePrototype prototype = MultidimFactory.eINSTANCE
				.createStatementScalarSchedulePrototype();
		prototype.setStatement(p.getStatement());
		ScheduleCoefficient lambda = createScheduleCoefficient(
				SCALAR_SCHEDULE_COEF + "__" + dim + "_" + p.getName(), dim);
		ScheduleTerm term = createScheduleTerm(lambda, affine(term(1)));
		prototype.getTerms().add(term);
		prototype.getCoeficients().add(lambda);
		return prototype;
	}

	public ChannelScalarSchedulePrototype createChannelScalarSchedulePrototype(
			ChannelSchedulePrototype p, int dim) {
		ChannelScalarSchedulePrototype prototype = MultidimFactory.eINSTANCE
				.createChannelScalarSchedulePrototype();
		prototype.setChannel(p.getChannel());
		ScheduleCoefficient lambda = createScheduleCoefficient(
				SCALAR_SCHEDULE_COEF + "__" + dim + "_" + p.getName(), dim);
		ScheduleTerm term = createScheduleTerm(lambda, affine(term(1)));
		prototype.getTerms().add(term);
		prototype.getCoeficients().add(lambda);
		return prototype;
	}

	private String formatVariableNameAt(String name, int d) {
		String[] split = name.split("_");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < split.length; i++) {
			sb.append(split[i]);
			if (i == 0) {
				sb.append("__" + d);
			}
			if (i < split.length - 1)
				sb.append("_");
		}
		return sb.toString();
	}

	/**
	 * Create a multidimensional dependency container from a list nullifiable
	 * dependencies.
	 * 
	 * @param dependencies
	 *            nullifiable dependencies for each dimension
	 * @return
	 */
	public MultidimDependency createMultidimensionalDependency(
			List<NullifiableDependency> dependencies) {
		MultidimDependency d = MultidimFactory.eINSTANCE
				.createMultidimDependency();
		for (int i = 0; i < dependencies.size(); i++) {
			NullifiableDependency depAtDim = dependencies.get(i);
			d.getDependencies().add(depAtDim);
			for (int j = 0; j < i; j++) {
				depAtDim.getPreviousDimensionsDependencies().add(
						dependencies.get(j));
			}
		}
		return d;
	}

	/**
	 * Create a K-nullifiable multidimensional dependency at a dimension from an
	 * existing monodimensional dependency.
	 * 
	 * @param dim
	 * @param dependency
	 * @param K
	 * @return
	 */
	public NullifiableDependency createNullifiableDependency(int id, int dim,
			Dependency dependency, long K) {
		ScheduleCoefficient sat = createScheduleCoefficient(SATISFACTION_VAR
				+ "_e" + id + "__" + dim, dim);
		NullifiableDependency d = new NullifiableDependencyImpl(dim, sat,
				dependency, K);
		return d;
	}

	public Variable createVariable(String name) {
		return IntExpressionBuilder.var(name);
	}
}
