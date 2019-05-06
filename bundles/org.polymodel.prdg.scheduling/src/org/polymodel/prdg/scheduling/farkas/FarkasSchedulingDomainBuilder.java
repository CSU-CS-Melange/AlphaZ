package org.polymodel.prdg.scheduling.farkas;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.Domain;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototypeBuilder;
import org.polymodel.prdg.scheduling.SchedulingDomainBuilder;
import org.polymodel.prdg.scheduling.SchedulingException;
import org.polymodel.prdg.scheduling.notifications.FarkasNotification;

/**
 * A {@link SchedulingDomainBuilder} implementation usinfg Farkas lemma to build
 * constraints related to a {@link Dependency}.
 * 
 * @author antoine
 * 
 */
public class FarkasSchedulingDomainBuilder extends
		SchedulingDomainBuilder {
	public FarkasSchedulingDomainBuilder(
			SchedulePrototypeBuilder prototypeBuilder) {
		super(prototypeBuilder);
	}

	/**
	 * Store the farkas dependencies (for log purpose)
	 */
	private List<FarkasDependencyConstraints> farkasDependencies;

	/**
	 * Lower bounds of schedule coefficients
	 */
	private Integer lb;
	/**
	 * Upper bounds of schedule coefficients
	 */
	private Integer ub;

	@Override
	protected void initialize() {
		super.initialize();
		this.farkasDependencies = new ArrayList<FarkasDependencyConstraints>();
	}

	@Override
	public Domain buildSchedulingDomainFor(List<PRDGNode> nodes,
			List<PRDGEdge> edges) throws SchedulingException {
		Domain schedulingDomain = super.buildSchedulingDomainFor(nodes, edges);
		return schedulingDomain;
	}

	@Override
	protected Domain findDependencyConstraints(Dependency dependency) {
		FarkasDependencyConstraints farkas = new FarkasDependencyConstraints(
				dependency);
		farkas.setScheduleCoeficientsLowerBound(lb);
		farkas.setScheduleCoeficientsUpperBound(ub);
		farkasDependencies.add(farkas);
		notify(new FarkasNotification(this, farkas));
		if (farkas.getApplied().getPolyhedra().size() > 1)
			throw new UnsupportedOperationException("Non convex domain");
		return farkas.getApplied();
	}

	public void setScheduleCoeficientsLowerBound(Integer lb) {
		this.lb = lb;
	}

	public void setScheduleCoeficientsUpperBound(Integer ub) {
		this.ub = ub;
	}

}
