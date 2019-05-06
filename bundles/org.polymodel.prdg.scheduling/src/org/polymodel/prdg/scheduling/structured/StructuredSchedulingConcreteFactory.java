package org.polymodel.prdg.scheduling.structured;

import static org.polymodel.algebra.factory.IntExpressionBuilder.var;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;

public final class StructuredSchedulingConcreteFactory extends
		SchedulingConcreteFactory {
	public final static StructuredSchedulingConcreteFactory INSTANCE = new StructuredSchedulingConcreteFactory();
	public final static String SUBSCRIPT_PREFIX = "x";
	public final static String BOUND_COEFFICIENT_PREFIX = "b";

	private StructuredFactory structuredFactory = StructuredFactory.eINSTANCE;

	public ChannelReadDependency createChannelReadDependency(
			ChannelSchedulePrototype channel,
			StatementSchedulePrototype statement, PRDGEdge e) {
		ChannelReadDependency d = structuredFactory
				.createChannelReadDependency();
		d.setSource(channel);
		d.setReference(statement);
		d.setEdge(e);
		d.setChannel(channel.getChannel());
		return d;
	}

	public ChannelLinearReadDependency createChannelLinearReadDependency(
			ChannelSchedulePrototype channel,
			StatementSchedulePrototype statement, PRDGEdge e,
			IntExpression subscript) {
		ChannelLinearReadDependency d = structuredFactory
				.createChannelLinearReadDependency();
		d.setSource(channel);
		d.setReference(statement);
		d.setEdge(e);
		d.setChannel(channel.getChannel());
		d.setSubscript(subscript);
		return d;
	}

	public ChannelWriteDependency createChannelWriteDependency(
			ChannelSchedulePrototype channel,
			StatementSchedulePrototype statement) {
		ChannelWriteDependency d = structuredFactory
				.createChannelWriteDependency();
		d.setSource(statement);
		d.setReference(channel);
		d.setChannel(channel.getChannel());
		return d;
	}

	public ChannelLinearWriteDependency createChannelLinearWriteDependency(
			ChannelSchedulePrototype channel,
			StatementSchedulePrototype statement, IntExpression subscript) {
		ChannelLinearWriteDependency d = structuredFactory
				.createChannelLinearWriteDependency();
		d.setSource(statement);
		d.setReference(channel);
		d.setChannel(channel.getChannel());
		d.setSubscript(subscript);
		return d;
	}

	/**
	 * Create a limited size memory write dependency to linearized memory
	 * access.
	 * 
	 * @param channel
	 * @param statement
	 * @return
	 */
	public LinearMemoryWriteDependency createLinearMemoryWriteDependency(
			BoundedChannel channel, StatementSchedulePrototype statement,
			ChannelSchedulePrototype allocation, IntExpression subscript) {
		LinearMemoryWriteDependency d = structuredFactory
				.createLinearMemoryWriteDependency();
		d.setSource(statement);
		d.setReference(allocation);
		d.setChannel(channel);
		d.setSubscript(subscript);
		return d;
	}

	public CompositeDependency createCompositeDependency(
			Dependency... dependencies) {
		CompositeDependency d = structuredFactory.createCompositeDependency();
		for (int i = 0; i < dependencies.length; i++) {
			d.getDependencies().add(dependencies[i]);
		}
		return d;
	}

	public CompositeDependency createCompositeDependency(
			List<Dependency> dependencies) {
		CompositeDependency d = structuredFactory.createCompositeDependency();
		d.getDependencies().addAll(dependencies);
		return d;
	}

	public MemoryWriteDependency createMemoryWriteDependency(
			BoundedChannel channel, StatementSchedulePrototype statement,
			ChannelSchedulePrototype allocation) {
		MemoryWriteDependency d = structuredFactory
				.createMemoryWriteDependency();
		d.setSource(statement);
		d.setReference(allocation);
		d.setChannel(channel);
		return d;
	}

	/**
	 * Create a limited size memory read dependency to linearized memory access.
	 * 
	 * @param channel
	 * @param statement
	 * @param e
	 * @param subscript
	 * @return
	 */
	public LinearMemoryReadDependency createLinearMemoryReadDependency(
			BoundedChannel channel, ChannelSchedulePrototype allocation,
			StatementSchedulePrototype statement, PRDGEdge e,
			IntExpression subscript) {
		LinearMemoryReadDependency d = structuredFactory
				.createLinearMemoryReadDependency();
		d.setReference(statement);
		d.setSource(allocation);
		d.setSubscript(subscript);
		d.setChannel(channel);
		d.setEdge(e);
		return d;
	}

	public MemoryReadDependency createMemoryReadDependency(
			BoundedChannel channel, ChannelSchedulePrototype allocation,
			StatementSchedulePrototype statement, PRDGEdge e,
			List<Long> linearizationFactors) {
		MemoryReadDependency d = structuredFactory.createMemoryReadDependency();
		d.setReference(statement);
		d.setSource(allocation);
		d.setChannel(channel);
		d.setEdge(e);
		d.getDimensionSizes().addAll(linearizationFactors);
		return d;
	}

	public LinearMemoryAllocationDependency createLinearMemoryAllocationDependency(
			BoundedChannel channel, ChannelSchedulePrototype allocation,
			SchedulePrototype statement, PRDGEdge e, IntExpression subscript) {
		LinearMemoryAllocationDependency d = structuredFactory
				.createLinearMemoryAllocationDependency();
		d.setReference(statement);
		d.setSource(allocation);
		d.setSubscript(subscript);
		d.setChannel(channel);
		d.setEdge(e);
		return d;
	}

	public MemoryAllocationDependency createMemoryAllocationDependency(
			BoundedChannel channel, ChannelSchedulePrototype allocation,
			StatementSchedulePrototype reference, PRDGEdge edge) {
		MemoryAllocationDependency d = structuredFactory
				.createMemoryAllocationDependency();
		d.setReference(reference);
		d.setSource(allocation);
		d.setChannel(channel);
		d.setEdge(edge);
		return d;
	}

	public MemoryDeallocationDependency createMemoryDeallocationDependency(
			BoundedChannel channel, ChannelSchedulePrototype allocation,
			List<Long> linearizationFactors) {
		MemoryDeallocationDependency d = structuredFactory
				.createMemoryDeallocationDependency();
		d.setReference(allocation);
		d.setSource(allocation);
		d.setChannel(channel);
		d.getDimensionSizes().addAll(linearizationFactors);
		return d;
	}
	
	public LinearMemoryDeallocationDependency createLinearMemoryDeallocationDependency(
			BoundedChannel channel, ChannelSchedulePrototype allocation,
			IntExpression subscript) {
		LinearMemoryDeallocationDependency d = structuredFactory
				.createLinearMemoryDeallocationDependency();
		d.setReference(allocation);
		d.setSource(allocation);
		d.setChannel(channel);
		d.setSubscript(subscript);
		return d;
	}
	

	public Process createProcess() {
		Process process = structuredFactory.createProcess();
		return process;
	}

	public Channel createChannel(String name, Domain domain, OutputPort source,
			InputPort destination) {
		Channel channel = structuredFactory.createChannel();
		channel.setName(name);
		channel.setDomain(domain);
		channel.setSource(source);
		channel.setDestination(destination);
		return channel;
	}

	public Channel createChannel(String name, Domain domain) {
		return createChannel(name, domain, createOutputPort(),
				createIntputPort());
	}

	public BoundedChannel createBoundedChannel(String name, int size,
			Domain domain) {
		return createBoundedChannel(name, size, domain, createOutputPort(),
				createIntputPort());
	}

	public BoundedChannel createBoundedChannel(String name, int size,
			Domain domain, OutputPort source, InputPort destination) {
		BoundedChannel channel = structuredFactory.createBoundedChannel();
		channel.setName(name);
		channel.setDomain(domain);
		channel.setSource(source);
		channel.setDestination(destination);
		channel.setMaximalChannelSize(size);
		channel.setSubscriptDimension(var(SUBSCRIPT_PREFIX + "_" + name));
		for (int i = 0; i < domain.getNbIndices(); ++i) {
			BoundingCoefficient bcoef = createBoundingCoefficient(name, i);
			channel.getBoundingCoefficients().add(bcoef);
		}
		return channel;
	}

	public BoundingCoefficient createBoundingCoefficient(String name, int i) {
		return createBoundingCoefficient(name, i, 0);
	}

	public BoundingCoefficient createBoundingCoefficient(String name, int i,
			int dim) {
		BoundingCoefficient c = structuredFactory.createBoundingCoefficient();
		c.setName(BOUND_COEFFICIENT_PREFIX + "__" + dim + "_" + name + "_" + i);
		c.setIndex(i);
		c.setDimension(dim);
		return c;
	}

	public InputPort createIntputPort() {
		InputPort input = structuredFactory.createInputPort();
		return input;
	}

	public OutputPort createOutputPort() {
		OutputPort output = structuredFactory.createOutputPort();
		return output;
	}

	public ProcessNetwork createProcessNetwork(PRDG prdg) {
		ProcessNetwork pn = structuredFactory.createProcessNetwork();
		pn.setPrdg(prdg);
		return pn;
	}

	public MultidimMemoryReadDependencyComponent createMemoryReadDependencyComponent(
			ChannelSchedulePrototype source,
			StatementSchedulePrototype reference, int dimension, PRDGEdge edge) {
		MultidimMemoryReadDependencyComponent d = structuredFactory
				.createMultidimMemoryReadDependencyComponent();
		d.setDimension(dimension);
		d.setChannel(source.getChannel());
		d.setEdge(edge);
		d.setSource(source);
		d.setReference(reference);
		return d;
	}

	public MultidimDependency createMultidimensionalReadDependency(
			MemoryReadDependency dependency, int dims, long K,
			Map<SchedulePrototype, MultidimSchedulePrototype> map,
			boolean scalars,List<Long> dimensionsSizes) {
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
				Dependency scalarInstanceAtDim = instantiateScalarReadDependencyAt(
						i, dependency, msource, mreference, dimensionsSizes);
				NullifiableDependency ndep = createNullifiableDependency(
						mulitdimID, sdim, scalarInstanceAtDim, K);
				nullifiableDependencies.add(ndep);
			}
			Dependency instanceAtDim = instantiateReadDependencyAt(i,
					dependency, msource, mreference, dimensionsSizes);
			NullifiableDependency ndep = createNullifiableDependency(
					mulitdimID, dim, instanceAtDim, K);
			nullifiableDependencies.add(ndep);
		}
		if (hasScalars) {
			int sdim = 2 * dims;
			Dependency scalarInstanceAtDim = instantiateScalarReadDependencyAt(
					dims, dependency, msource, mreference, dimensionsSizes);
			NullifiableDependency ndep = createNullifiableDependency(
					mulitdimID, sdim, scalarInstanceAtDim, K);
			nullifiableDependencies.add(ndep);
		}
		MultidimDeallocationDependency mdep = structuredFactory.createMultidimDeallocationDependency();
		mdep.getDependencies().addAll(nullifiableDependencies);
		mdep.getDimensionSizes().addAll(dimensionsSizes);
		return mdep;
	}

	private Dependency instantiateReadDependencyAt(int index,
			MemoryReadDependency dependency, MultidimSchedulePrototype msource,
			MultidimSchedulePrototype mreference,List<Long> dimensionsSizes) {
		MultidimMemoryReadDependencyComponent instanceAtDim = createMemoryReadDependencyComponent(
				(ChannelSchedulePrototype) msource.getPrototypes().get(index),
				(StatementSchedulePrototype) mreference.getPrototypes().get(
						index), index, dependency.getEdge());
		instanceAtDim.getDimensionSizes().addAll(dimensionsSizes);
		return instanceAtDim;
	}

	private Dependency instantiateScalarReadDependencyAt(int index,
			MemoryReadDependency dependency, MultidimSchedulePrototype msource,
			MultidimSchedulePrototype mreference,List<Long> dimensionsSizes) {
		MultidimMemoryReadDependencyComponent instanceAtDim = createMemoryReadDependencyComponent(
				(ChannelSchedulePrototype) msource.getScalars().get(index),
				(StatementSchedulePrototype) mreference.getScalars().get(index),
				index, dependency.getEdge());
		instanceAtDim.getDimensionSizes().addAll(dimensionsSizes);
		return instanceAtDim;
	}

}
