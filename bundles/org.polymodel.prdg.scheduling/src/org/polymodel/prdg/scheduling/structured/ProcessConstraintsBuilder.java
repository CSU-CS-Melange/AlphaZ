package org.polymodel.prdg.scheduling.structured;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.ge;
import static org.polymodel.algebra.factory.IntExpressionBuilder.le;
import static org.polymodel.algebra.factory.IntExpressionBuilder.mul;
import static org.polymodel.algebra.factory.IntExpressionBuilder.qaffine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;
import static org.polymodel.prdg.scheduling.util.SchedulingToolFunctions.intersection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.OutputDimension;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.EdgeDependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;
import org.polymodel.prdg.scheduling.SchedulingException;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.farkas.FarkasDependencyConstraints;
import org.polymodel.prdg.scheduling.farkas.FarkasMultipleDependenciesConstraints;
import org.polymodel.prdg.scheduling.internal.FastJNIIslSet;
import org.polymodel.prdg.scheduling.notifications.FarkasNotification;

import fr.irisa.cairn.graph.observer.Observable;

/**
 * Builder for input and output constraints of process channels. <br>
 * <br>
 * <i>P. Feautrier. Scalable and structured scheduling. Int. J. Parallel
 * Program., 34(5):459-487, 2006.</i>
 * 
 * @author antoine
 * 
 */
public class ProcessConstraintsBuilder extends Observable {
	protected boolean verbose = true;

	protected void verbose(String message) {

		verbose(0, message);
	}

	protected void verbose(int indentation, String message) {
		if (verbose) {
			System.out.print("\n[Process Constraints] \t");
			for (int i = 0; i < indentation; i++) {
				System.out.print("\t");
			}
			System.out.print(message);
		}
	}

	/**
	 * All schedule coefficients of the analyzed process that are projected out
	 * of the modular process constraints.
	 */
	protected List<Variable> projectedVariables;
	/**
	 * All schedule coefficients that are variables of the modular process
	 * constraints. They are not projected out.
	 */
	protected List<Variable> modularVariables;
	/**
	 * Factory used for polymodel
	 */
	protected PolymodelDefaultFactory polymodelFactory;
	/**
	 * Factory of scheduling entities
	 */
	protected SchedulingConcreteFactory schedulingConcreteFactory;

	/**
	 * Cache map of constraints built for an edge (external input of one or many
	 * processes).
	 */
	private Map<PRDGEdge, Domain> inputConstraintsCache = new CacheMap<PRDGEdge, Domain>(
			1000);
	/**
	 * Cache map of constraints built for output port of a channel (external
	 * output of one or many processes).
	 */
	private Map<OutputPort, Domain> outputConstraintsCache = new CacheMap<OutputPort, Domain>(
			1000);

	private Integer lb;
	private Integer ub;

	public ProcessConstraintsBuilder() {
		this.polymodelFactory = PolymodelComponent.INSTANCE.getFactory();
		this.schedulingConcreteFactory = new SchedulingConcreteFactory();
	}

	protected void initialize() {
		this.projectedVariables = new UniqueEList<Variable>();
		this.modularVariables = new UniqueEList<Variable>();
	}

	public Integer getLb() {
		return lb;
	}

	public void setLb(Integer lb) {
		this.lb = lb;
	}

	public Integer getUb() {
		return ub;
	}

	public void setUb(Integer ub) {
		this.ub = ub;
	}

	/**
	 * Find the list of in/out channel constraints of process. Output domain may
	 * not be a convex polyhedron.
	 * 
	 * @param process
	 * @return
	 * @throws SchedulingException
	 */
	public Domain findChannelConstraints(Process process,
			StructuredScheduler scheduler,
			Map<Variable, Long> linearizationFactorsMap)
			throws SchedulingException {
		this.dimensionsLinearizationFactor = linearizationFactorsMap;
		initialize();
		ISLSet constraints = (ISLSet) buildProcessConstraints(process,
				scheduler);
		if (constraints != null && constraints.isEmpty())
			throw new SchedulingException(
					"Unable to build legal scheduling constraints for "
							+ process.getName() + " (Empty domain).");
		// Elimination of statements schedule coefficients
		if (constraints != null) {
			// Upper and lower bounds context
			List<IntConstraint> context = new ArrayList<IntConstraint>();
			if (lb != null) {
				for (Variable v : getAllVariables()) {
					context.add(ge(affine(term(v)), affine(term(lb))));
				}
			}

			if (ub != null) {
				for (Variable v : getAllVariables()) {
					context.add(le(affine(term(v)), affine(term(ub))));
				}
			}
			if (context.size() > 0) {
				ISLSet contextDomain = polymodelFactory.createDomain(
						constraints.getDimensions().copy(),
						constraintSystem(context));
				constraints = intersection(constraints, contextDomain);
			}
			verbose("> Scheduling contraints for process are: "
					+ constraints.toString());
			if (constraints.isEmpty())
				throw new SchedulingException(
						"Unable to build legal scheduling constraints for "
								+ process.getName() + " (Empty domain).");
			// Set the internal constraints of a process
			process.setConstraints(constraints);

			// Build external constraints
			ISLSet projection = scheduleCoeficientsElimination(constraints);
			// ISLSet projection = constraints;
			verbose("> Modular contraints for process are: "
					+ projection.toString());
			return projection;
		}
		return polymodelFactory.createDomain(modularVariables);
	}

	/**
	 * Find the constraints of process for a given context. It doesn't project
	 * out the coefficients of the internal nodes.
	 * 
	 * @param process
	 * @param context
	 * @param scheduler
	 * @param linearizationFactorsMap
	 * @return
	 * @throws SchedulingException
	 */
	public Domain findProcessConstraintsInContext(Process process,
			Domain context, StructuredScheduler scheduler,
			Map<Variable, Long> linearizationFactorsMap)
			throws SchedulingException {
		this.dimensionsLinearizationFactor = linearizationFactorsMap;
		initialize();

		Domain constraints = process.getConstraints();
		if (constraints == null) {
			throw new IllegalArgumentException("Process " + process.getName()
					+ " has no constraints.");
		}

		Domain result = intersection(constraints, context);

		return result;
	}

	public ISLSet scheduleCoeficientsElimination(ISLSet constraints) {
		List<Variable> allVariables = getAllVariables();
		DomainDimensions dimensions = polymodelFactory.createDomainDimensions(
				allVariables, new ArrayList<Variable>());
		FastJNIIslSet domain = FastJNIIslSet.buildFrom(constraints);
		domain = domain.normalize(dimensions);
		domain = domain.computeExistentialVariables().simplify();
		int size = getAllProjectionVariables().size();
		int start = allVariables.size() - size;
		ISLSet projected = domain.project(start, size);

		return projected;
	}

	/*
	 * **************************************
	 * 
	 * Constraints Building
	 * 
	 * **************************************
	 */

	/**
	 * Build internal constraints and channel constraints of a process.
	 * Scheduler is used to access to the schedule prototypes.
	 * 
	 * @param process
	 * @param scheduler
	 * @return
	 * @throws SchedulingException
	 */
	protected Domain buildProcessConstraints(Process process,
			StructuredScheduler scheduler) throws SchedulingException {
		Domain channelConstraintsDomain = buildChannelConstraints(process,
				scheduler, modularVariables);
		Domain internalConstraintsDomain = buildInternalConstraints(process,
				scheduler);
		Domain processConstraints = intersection(channelConstraintsDomain,
				internalConstraintsDomain);
		return processConstraints;
	}

	/**
	 * Build legal schedule constraints for internal dependencies of a process.
	 * 
	 * @param process
	 * @param scheduler
	 * @param constraints
	 */

	protected Domain buildInternalConstraints(Process process,
			StructuredScheduler scheduler) {
		verbose(1, "** Internal dependencies");
		Domain result = null;
		for (PRDGNode n : process.getInternalNodes()) {
			StatementSchedulePrototype source = scheduler
					.getSchedulePrototype(n);
			for (PRDGEdge out : n.getDestinations()) {
				if (isInternalEdge(out, process)) {
					PRDGNode destination = out.getDestination();

					StatementSchedulePrototype reference = scheduler
							.getSchedulePrototype(destination);
					EdgeDependency dependency = schedulingConcreteFactory
							.createEdgeDependency(source, reference, out);

					Domain depConstraints = buildConstraintsFor(dependency);
					result = intersection(result, depConstraints);

				}
			}
		}
		return result;
	}

	private boolean isInternalEdge(PRDGEdge e, Process p) {
		for (InputPort pin : p.getInputs()) {
			for (PRDGEdge in : pin.getChannel().getEdges()) {
				if (in == e)
					return false;
			}
		}

		for (OutputPort pout : p.getOutputs()) {
			for (PRDGEdge out : pout.getChannel().getEdges()) {
				if (out == e)
					return false;
			}
		}
		EList<PRDGNode> internalNodes = p.getInternalNodes();
		return internalNodes.contains(e.getSource())
				&& internalNodes.contains(e.getDestination());
	}

	/**
	 * Build the channel constraints for inputs and outputs of a process.
	 * 
	 * @param process
	 *            analyzed process
	 * @param scheduler
	 *            structured scheduler instance that map all nodes to their
	 *            schedule prototypes
	 * @param constraints
	 *            list of constraints that will be updated
	 * @param channelScheduleCoeficients
	 *            list of schedule coefficients that will be updated
	 * @throws SchedulingException
	 */

	protected Domain buildChannelConstraints(Process process,
			StructuredScheduler scheduler,
			List<Variable> channelScheduleCoeficients)
			throws SchedulingException {
		verbose(1, "** External Channel dependencies");
		Domain constraints = null;
		for (InputPort in : process.getInputs()) {
			Domain inDomain = buildInputConstraints(scheduler, in, process,
					inputConstraintsCache);
			constraints = intersection(constraints, inDomain);

		}
		for (OutputPort out : process.getOutputs()) {
			Domain outDomain = buildOutputConstraints(scheduler, out,
					outputConstraintsCache);
			constraints = intersection(constraints, outDomain);

		}
		return constraints;
	}

	/**
	 * Build input constraints of a channel. For each edge of the channel,
	 * constraints are built or obtained from the cache.
	 * 
	 * @param scheduler
	 * @param constraints
	 * @param channelScheduleCoeficients
	 * @param in
	 * @param process
	 * @param cache
	 */
	protected Domain buildInputConstraints(StructuredScheduler scheduler,
			InputPort in, Process process, Map<PRDGEdge, Domain> cache) {

		verbose(2, "* Input dependencies for channel "
				+ in.getChannel().getName());
		Domain result = null;

		List<Dependency> dependencies = getInputDependencies(in.getChannel(),
				process, scheduler);
		for (Dependency dep : dependencies) {
			Domain cachedConstraints = getConstraintsFor(dep, cache);
			result = intersection(result, cachedConstraints);
		}
		return result;
	}

	private Domain getConstraintsFor(Dependency d, Map<PRDGEdge, Domain> cache) {
		// XXX: should use the cache here
		return buildConstraintsFor(d);
	}

	/**
	 * Get all dependencies of input channel of a process.
	 * 
	 * @param channel
	 * @param process
	 * @param scheduler
	 * @return
	 */
	protected List<Dependency> getInputDependencies(Channel channel,
			Process process, StructuredScheduler scheduler) {

		ChannelSchedulePrototype channelSchedulePrototype = scheduler
				.getSchedulePrototype(channel);
		List<Dependency> dependencies = new ArrayList<Dependency>();
		for (PRDGEdge edge : channel.getEdges()) {
			if (process.getInternalNodes().contains(edge.getDestination())) {
				EdgeDependency edgeDependency = scheduler.getDependency(edge);
				dependencies.addAll(getInputEdgeDependencies(
						channelSchedulePrototype, edge, edgeDependency,
						scheduler));
			}
		}
		return dependencies;
	}

	/**
	 * Get all dependencies for an input edge of a process.
	 * 
	 * @param channelSchedulePrototype
	 * @param edge
	 * @param edgeDependency
	 * @return
	 */
	protected List<Dependency> getInputEdgeDependencies(
			ChannelSchedulePrototype channelSchedulePrototype, PRDGEdge edge,
			EdgeDependency edgeDependency, StructuredScheduler scheduler) {
		List<Dependency> dependencies = new ArrayList<Dependency>();
		ChannelReadDependency readDependency = buildReadDependency(
				channelSchedulePrototype, edge, edgeDependency);
		verbose(3,
				"> " + edge.getSource().getName() + "->"
						+ edge.getDestination().getName() + " for data["
						+ edge.getFunction().getMapping() + "] : "
						+ readDependency.getTerms(true) + " >= 0");
		dependencies.add(readDependency);
		return dependencies;
	}

	/**
	 * Build output constraints of a channel. Constraints are built or obtained
	 * from the cache.
	 * 
	 * @param scheduler
	 * @param constraints
	 * @param channelScheduleCoeficients
	 * @param out
	 * @param cache
	 */
	protected Domain buildOutputConstraints(StructuredScheduler scheduler,
			OutputPort out, Map<OutputPort, Domain> cache) {
		Domain cachedConstraints = cache.get(out);
		ChannelSchedulePrototype channelSchedulePrototype = scheduler
				.getSchedulePrototype(out.getChannel());
		verbose(2, "* Output dependency for channel "
				+ out.getChannel().getName());

		if (cachedConstraints == null) {
			StatementSchedulePrototype sourceSchedulePrototype = scheduler
					.getSchedulePrototype(out.getSourceNode());

			IntExpression producerSubscript = findProducerSubscript(out
					.getSourceNode());
			ChannelWriteDependency writeDependency = buildWriteDependency(
					channelSchedulePrototype, sourceSchedulePrototype,
					producerSubscript);
			verbose(3, "> Produced data[" + producerSubscript + "] : "
					+ writeDependency.getTerms(true) + " >= 0");
			cachedConstraints = buildConstraintsFor(writeDependency);
			cache.put(out, cachedConstraints);
		} else {
			verbose(3, "Constraints are already in cache");
		}
		return cachedConstraints;
	}

	// private static int counter;

	/**
	 * Find all the constraints related to a {@link Dependency}. It also update
	 * the sets of variables that are kept or projected out. Constraints are
	 * found using Farkas lemma. Constraints involved source and reference
	 * coefficients that may be eliminated by projection for each process. Lower
	 * bounds and upper bounds of the builder are used as additional context in
	 * projection of the Farkas polyhedron.
	 * 
	 * @param dependency
	 * @return
	 */
	protected Domain buildConstraintsFor(Dependency dependency) {
		Domain result = null;
		if (dependency instanceof CompositeDependency) {
			return buildConstraintsForComposite((CompositeDependency) dependency);
		} else {
			manageVariables(dependency.getSource());
			manageVariables(dependency.getReference());
			FarkasDependencyConstraints farkas = new FarkasDependencyConstraints(
					dependency, getBoundedContext(dependency));
			notify(new FarkasNotification(this, farkas));
			result = farkas.getApplied();
			verbose(3, "Constraints for " + dependency + ": " + result);

		}
		return result;
	}

	static int COUNTER;

	protected Domain buildConstraintsForComposite(CompositeDependency composite) {
		Domain result = null;
		for (Dependency d : composite.getDependencies()) {
			Domain domain = buildConstraintsFor(d);
			result = intersection(result, domain);
			System.out
					.println("Counter processConstraintsBUilder " + COUNTER++);
		}
		return result;
	}

	/**
	 * Find all the constraints related to dependencies that can be merged.
	 * 
	 * @param dependencies
	 * @return
	 */
	protected Domain buildMergedConstraintsFor(Dependency... dependencies) {
		FarkasMultipleDependenciesConstraints farkas = new FarkasMultipleDependenciesConstraints(
				dependencies[0]);
		for (int i = 0; i < dependencies.length; i++) {
			Dependency dependency = dependencies[i];
			manageVariables(dependency.getSource());
			manageVariables(dependency.getReference());
			farkas.addDependency(dependency);
		}

		notify(new FarkasNotification(this, farkas));
		return farkas.getApplied();
	}

	private List<IntConstraint> getBoundedContext(Dependency d) {
		SchedulePrototype source = d.getSource();
		SchedulePrototype reference = d.getReference();

		// Upper and lower bounds context
		List<IntConstraint> context = new ArrayList<IntConstraint>();

		if (source instanceof StatementSchedulePrototype) {
			for (Variable v : source.getCoeficients()) {
				if (source.getConstantTerm().getVar() != v) {
					if (lb != null)
						context.add(ge(affine(term(v)), affine(term(lb))));
					if (ub != null)
						context.add(le(affine(term(v)), affine(term(ub))));
				}
			}
		}
		if (reference instanceof StatementSchedulePrototype) {
			for (Variable v : reference.getCoeficients()) {
				if (reference.getConstantTerm().getVar() != v) {
					if (lb != null)
						context.add(ge(affine(term(v)), affine(term(lb))));
					if (ub != null)
						context.add(le(affine(term(v)), affine(term(ub))));
				}
			}
		}

		return context;

	}

	/**
	 * Updates the kept or projected sets of variables from
	 * {@link SchedulePrototype}. Inheriting classes should override this
	 * function to add
	 * 
	 * @param p
	 */
	protected void manageVariables(SchedulePrototype p) {
		if (p instanceof ChannelSchedulePrototype) {
			modularVariables.addAll(p.getCoeficients());
		} else {
			projectedVariables.addAll(p.getCoeficients());
		}
	}

	protected FarkasDependencyConstraints buildFarkas(Dependency d) {
		return new FarkasDependencyConstraints(d);
	}

	/*
	 * **************************************
	 * 
	 * Tools functions
	 * 
	 * **************************************
	 */

	/**
	 * Get all variables that will be projected out.
	 * 
	 * @return
	 */
	private List<Variable> getAllProjectionVariables() {
		return projectedVariables;
	}

	/**
	 * Eliminate a set of variables from a constraint set using projection.
	 * 
	 * @param constraints
	 *            constraints to project
	 * @param variables
	 *            keeped after projection variables
	 * @param projectedVaribles
	 *            variables that are eliminated
	 * @return
	 */
	public static ISLSet scheduleCoeficientsElimination(
			List<IntConstraint> constraints, List<Variable> variables,
			List<Variable> projectedVaribles) {
		List<Variable> allVariables = new ArrayList<Variable>();
		allVariables.addAll(variables);
		allVariables.addAll(projectedVaribles);

		ISLSet domain = PolymodelComponent.INSTANCE.getFactory(
				ISLPolymodelModule.INSTANCE).createDomain(allVariables,
				IntExpressionBuilder.constraintSystem(constraints));
		int size = projectedVaribles.size();
		int start = allVariables.size() - size;
		ISLSet projection = domain.project(start, size);
		return projection;
	}

	/**
	 * Get all variables related to the process (include projected ones)
	 * 
	 * @return
	 */
	protected List<Variable> getAllVariables() {
		List<Variable> allVariables = new UniqueEList<Variable>(
				modularVariables);
		allVariables.addAll(projectedVariables);
		return allVariables;
	}

	/**
	 * Create the channel schedule dependency for an output channel.
	 * 
	 * @param channelSchedulePrototype
	 * @param sourceSchedulePrototype
	 * @param subscript
	 *            subscript of the written data
	 * @return
	 */
	protected ChannelWriteDependency buildWriteDependency(
			ChannelSchedulePrototype channelSchedulePrototype,
			StatementSchedulePrototype sourceSchedulePrototype,
			IntExpression subscript) {
		ChannelWriteDependency writeDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createChannelWriteDependency(channelSchedulePrototype,
						sourceSchedulePrototype);
		return writeDependency;
	}

	/**
	 * Create the channel schedule dependency for an input channel.
	 * 
	 * @param channelSchedulePrototype
	 * @param edge
	 * @param edgeDependency
	 * @param subscript
	 *            subscript of the read data
	 * @return
	 */

	protected ChannelReadDependency buildReadDependency(
			ChannelSchedulePrototype channelSchedulePrototype, PRDGEdge edge,
			EdgeDependency edgeDependency) {
		ChannelReadDependency readDependency = StructuredSchedulingConcreteFactory.INSTANCE
				.createChannelReadDependency(channelSchedulePrototype,
						edgeDependency.getReference(), edge);
		return readDependency;
	}

	/**
	 * Find the linearized subscript function of a producer.
	 * 
	 * @param producer
	 *            data producer
	 * @return
	 */
	protected IntExpression findProducerSubscript(PRDGNode producer) {
		EList<Variable> indices = producer.getDomain().getDimensions()
				.getIndices();
		if (requireLinearization(producer.getDomain())) {
			int size = indices.size();
			List<AffineTerm> terms = new ArrayList<AffineTerm>();
			for (int i = 0; i < size; i++) {
				Variable dim = indices.get(i);
				AffineExpression expression = affine(term(dim));

				QuasiAffineTerm mul = mul(expression, bound(dim));
				terms.addAll(qaffine(mul).toAffine().getTerms());

			}
			return affine(terms);
		} else {
			return affine(term(indices.get(0)));
		}
	}

	/**
	 * Test if the domain of a data producer require a linearization. It
	 * requires a linearization if this domain has more than one dimension.
	 * 
	 * @param d
	 * @return
	 */
	private boolean requireLinearization(Domain d) {
		return d.getDimensions().getIndices().size() > 1;
	}

	private boolean requireLinearization(Function d) {
		return d.getDimensions().getIndices().size() > 1;
	}

	/**
	 * Find the linearized subscript function of a data consumer from the
	 * dependency function of the edge.
	 * 
	 * @param e
	 *            data consuming edge
	 * @return
	 */
	protected IntExpression findConsumerSubscript(PRDGEdge e) {
		Function mapping = e.getFunction().getMapping();

		if (requireLinearization(mapping)) {
			List<AffineTerm> terms = new ArrayList<AffineTerm>();
			for (Entry<OutputDimension, IntExpression> entry : mapping
					.getExpressionsMap().entrySet()) {
				AffineExpression expression = entry.getValue().toAffine();
				QuasiAffineTerm mul = mul(expression, bound(entry.getKey()
						.getDimension()));
				terms.addAll(qaffine(mul).toAffine().getTerms());
			}

			return affine(terms);
		} else {
			return mapping.getExpression(0).toAffine();
		}
	}

	/**
	 * Map a dimension to its linearization factor.
	 */
	protected Map<Variable, Long> dimensionsLinearizationFactor;

	protected int bound(Variable v) {
		Long b = dimensionsLinearizationFactor.get(v);
		if (b == null)
			throw new IllegalArgumentException(
					"Unable to find the linearization factor of " + v);
		else
			return b.intValue();
	}

	@SuppressWarnings("serial")
	/**
	 * Cache Map that drop out eldest entries after maximal size is achieved.
	 * @author antoine
	 *
	 * @param <K>
	 * @param <V>
	 */
	public static class CacheMap<K, V> extends LinkedHashMap<K, V> {
		private int cacheSize;

		public CacheMap(int size) {
			super(size + 1, .75F, true);
			this.cacheSize = size;
		}

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
			return size() > cacheSize;
		}

	}
}
