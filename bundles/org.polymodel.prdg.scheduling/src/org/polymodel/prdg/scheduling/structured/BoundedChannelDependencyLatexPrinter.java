package org.polymodel.prdg.scheduling.structured;

import static org.polymodel.prdg.scheduling.util.LatexHelper.equation;

import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.util.ALatexDependencyPrinter;

public class BoundedChannelDependencyLatexPrinter extends
		ALatexDependencyPrinter {

	@Override
	protected void appendBody(Dependency dependency) {
		if (dependency instanceof MemoryDependency) {
			MemoryDependency mdep = (MemoryDependency) dependency;
			appendDomains(mdep);
			appendAllocationFunction(mdep);
			appendConstaints(mdep);
		}

	}

	protected void appendDomains(MemoryDependency dependency) {
		throw new RuntimeException("not implemented");
	}

	protected void appendAllocationFunction(MemoryDependency dependency) {
		sb.append("\nAssuming that allocation and deallocation take one clock cycle:\n");
		StringBuffer allocation = new StringBuffer("\\alpha(");
		allocation.append(dependency.getChannel().getName()).append(",X_1+")
				.append(dependency.getChannel().getMaximalChannelSize());
		allocation.append(")+1 = \\Psi(")
				.append(dependency.getChannel().getName()).append(",x_1)");
		sb.append(equation(allocation.toString()));
	}

	protected void appendConstaints(MemoryDependency dependency) {
		if (dependency instanceof LinearMemoryWriteDependency) {
			appendWriteConstraints((LinearMemoryWriteDependency) dependency);
		} else {
			appendReadConstraints((LinearMemoryReadDependency) dependency);
		}
	}

	protected void appendWriteConstraints(LinearMemoryWriteDependency dependency) {
		sb.append("\nWrite once in the channel has to respect:\n");
		StringBuffer allocation = new StringBuffer("\\alpha(");
		allocation.append(dependency.getChannel().getName()).append(",f_W");
		allocation.append(") \\leq").append("\\Theta(")
				.append(dependency.getSource().getName()).append(")");

	}

	protected void appendReadConstraints(LinearMemoryReadDependency dependency) {
		throw new RuntimeException("not implemented");
	}

}
