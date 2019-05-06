package org.polymodel.prdg.scheduling.farkas;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.Domain;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.matrix.Matrix;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;

public class FarkasBuilder {
	private PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE
			.getFactory();
	public final static String FARKAS_COEF = "lambda";
	private SchedulingConcreteFactory schedulingConcreteFactory = PolymodelComponent.INSTANCE
			.getInstance(SchedulingConcreteFactory.class);

	public List<ScheduleTerm> buildFarkasTerms(Domain d) {
		assert (d.getPolyhedra().size() == 1);
		List<Variable> allVariables = new ArrayList<Variable>();
		allVariables.addAll(d.getDimensions().getIndices());
		allVariables.addAll(d.getDimensions().getParameters());
		IntConstraintSystem polyhedron = d.getPolyhedra().get(0);
		polyhedron = transformToInequationsSystem(polyhedron);
		return buildFarkasTerms(polyhedron, allVariables);
	}

	public List<ScheduleTerm> buildFarkasTerms(IntConstraintSystem polyhedron,
			List<Variable> allVariables) {
		// assert (checkComplianceWithFarkas(polyhedron)) :
		// "There are some EQ/NE constraints, unable to apply farkas lemma.";
		List<ScheduleTerm> sterms = new ArrayList<ScheduleTerm>();
		// polyhedron = transformToInequationsSystem(polyhedron);
		Matrix matrix = factory.createMatrix(polyhedron, allVariables);

		// Constant farkas multiplier
		Variable constantMult = schedulingConcreteFactory
				.createVariable(FARKAS_COEF + "_" + "0");
		ScheduleTerm cterm = schedulingConcreteFactory.createScheduleTerm(null,
				affine(term(constantMult)));
		sterms.add(cterm);

		// Other farkas multipliers
		Variable farkasMultipliers[] = new Variable[matrix.getNbRows()];
		for (int i = 0; i < farkasMultipliers.length; i++) {
			farkasMultipliers[i] = schedulingConcreteFactory
					.createVariable(FARKAS_COEF + "_" + (i + 1));
		}

		for (int i = 1; i < matrix.getNbCols(); i++) {
			List<Long> column = matrix.getColumn(i);
			List<AffineTerm> terms = new ArrayList<AffineTerm>();
			for (int j = 0; j < column.size(); j++) {
				Long value = column.get(j);
				if (value != 0) {
					Variable farkasMultiplier = farkasMultipliers[j];
					terms.add(term(value, farkasMultiplier));
				}
			}
			if ((i - 1) < allVariables.size()) {
				// Variable term
				Variable variable = allVariables.get(i - 1);
				AffineExpression expressionForVariable = affine(terms);
				ScheduleTerm sterm = schedulingConcreteFactory
						.createScheduleTerm(variable, expressionForVariable);
				if (!sterm.isNull())
					sterms.add(sterm);
			} else {
				// Constant term
				AffineExpression expressionForVariable = affine(terms);
				ScheduleTerm sterm = schedulingConcreteFactory
						.createScheduleTerm(null, expressionForVariable);
				if (!sterm.isNull())
					sterms.add(sterm);
			}

		}
		return sterms;
	}

	public static IntConstraintSystem transformToInequationsSystem(
			IntConstraintSystem s) {
		IntConstraintSystem sys = IntExpressionBuilder.constraintSystem();
		for (IntConstraint c : s.getConstraints()) {
			transformToInequations(sys.getConstraints(), c);
		}
		return sys;
	}

	private static void transformToInequations(List<IntConstraint> constraints,
			IntConstraint constraint) {
		if (constraint.getComparisonOperator() == ComparisonOperator.EQ) {
			// Build two constraints for the equivalence
			IntConstraint c1 = constraint.copy();
			c1.setComparisonOperator(ComparisonOperator.GE);
			IntConstraint c2 = constraint.copy();
			c2.setComparisonOperator(ComparisonOperator.LE);
			constraints.add(c1);
			constraints.add(c2);
		} else {
			constraints.add(constraint.copy());
		}
	}
	//
	// private static boolean checkComplianceWithFarkas(IntConstraintSystem s) {
	// for (IntConstraint c : s.getConstraints()) {
	// if (c.getComparisonOperator() == ComparisonOperator.EQ
	// || c.getComparisonOperator() == ComparisonOperator.NE)
	// return false;
	// }
	// return true;
	// }
}
