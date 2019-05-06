package org.polymodel.prdg.scheduling.pouchet;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.impl.StatementSchedulePrototypeImpl;

/**
 * Pluto schedule prototype is of the form: <br>
 * T(S,is,js,N) = mu_0+ mu_1.is + mu_2.js + mu_3.N <br>
 * <br>
 * Each original dimension of the statement domain has been replaced by a new
 * variable dedicated to the statement.
 * 
 * @author antoine
 * 
 */
public class PouchetSchedulePrototype extends StatementSchedulePrototypeImpl {
	private List<PrototypeIndexVariable> variables = new BasicEList<PrototypeIndexVariable>();

	public PouchetSchedulePrototype(PRDGNode statement) {
		this.statement = statement;

		List<Variable> indices = statement.getDomain().getDimensions()
				.getIndices();
		for (Variable index : indices) {
			PrototypeIndexVariable scheduleIndexVariable = new PrototypeIndexVariable(
					index, this);
			variables.add(scheduleIndexVariable);
			varsMap.put(index, scheduleIndexVariable);
		}
	}

	@Override
	public Domain getDomain() {
		if (domain == null) {
			// Domain of the prototype
			domain = PolymodelComponent.INSTANCE.getFactory().createDomain(
					statement.getDomain());
			for (IntConstraintSystem pol : domain.getPolyhedra()) {
				for (IntConstraint c : pol.getConstraints()) {
					substituteWithScheduledVariables(c);
				}
			}
			domain.getDimensions().getIndices().clear();
			domain.getDimensions().getIndices().addAll(variables);

		}
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public List<PrototypeIndexVariable> getVariables() {
		return variables;
	}

	/**
	 * Update all original dimensions of the prototype to their
	 * {@link PrototypeIndexVariable} in an expression.
	 * 
	 * @param exp
	 */
	public void substituteWithScheduledVariables(AffineExpression exp) {
		for (AffineTerm term : exp.getTerms()) {
			Variable var = term.getVariable();
			if (var != null) {
				Variable scheduleVariable = getScheduleIndex(var);
				if (scheduleVariable != null)
					term.setVariable(scheduleVariable);
			}
		}
	}

	/**
	 * Update all original dimensions of the prototype to their
	 * {@link PrototypeIndexVariable} in an constraint.
	 * 
	 * @param exp
	 */
	public void substituteWithScheduledVariables(IntConstraint c) {
		substituteWithScheduledVariables((AffineExpression) c.getLhs());
		substituteWithScheduledVariables((AffineExpression) c.getRhs());
	}
}
