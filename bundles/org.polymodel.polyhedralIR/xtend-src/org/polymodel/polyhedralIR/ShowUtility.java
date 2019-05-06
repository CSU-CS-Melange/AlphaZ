package org.polymodel.polyhedralIR;

import java.util.List;

import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.isl.ISLSet;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;

public class ShowUtility {

	public static List<IntConstraintSystem> simplifyDomain(Domain domain, boolean simplify) {
		List<IntConstraintSystem> target = domain.getPMdomain().getPolyhedra();

		//Simplify in context before printing if possible
		if (domain.getPMdomain() instanceof ISLSet && simplify) {
			domain.simplify();
			//When it is a domain of an expression
			if (domain.eContainer() instanceof Expression) {
				//When the parent is also an expression
				if (domain.eContainer().eContainer() instanceof Expression) {
					Domain context = ((Expression)(domain.eContainer().eContainer())).getContextDomain().copy();
					//Special case 1 : when the parent is Reduce, take pre-image by the projection
					if (domain.eContainer().eContainer() instanceof ReduceExpression) {
						context = context.preimage(((ReduceExpression)domain.eContainer().eContainer()).getProjection());
					}
					//Special case 2 : when the parent is Dependence, take image by the function
					if (domain.eContainer().eContainer() instanceof DependenceExpression) {
						context = context.image(((DependenceExpression)domain.eContainer().eContainer()).getDep());
					}
					
					//check number of dimensions
					if (context.getDim() != domain.getDim()) {
						throw new RuntimeException("Number of dimensions do not match the surrounding context.");
					}
					org.polymodel.Domain simplified = ((ISLSet)domain.getPMdomain()).simplify(context.getPMdomain());
					simplified.simplify();
					target = simplified.getPolyhedra();
				//When parent is an equation
				} else if (domain.eContainer().eContainer() instanceof StandardEquation) {
					Domain context = ((AffineSystem)(domain.eContainer().eContainer().eContainer())).getParameters().copy();
					//Match number of dimensions
					for (Variable iv : domain.getIndices()) {
						context.addDimension(iv.getName());
					}
					org.polymodel.Domain simplified = ((ISLSet)domain.getPMdomain()).simplify(context.getPMdomain());
					simplified.simplify();
					target = simplified.getPolyhedra();
				}
			//If its a domain of a variable
			} else if (domain.eContainer() instanceof VariableDeclaration) {
				Domain context = ((AffineSystem)domain.eContainer().eContainer()).getParameters().copy();
				//Match number of dimensions
				for (Variable iv : domain.getIndices()) {
					context.addDimension(iv.getName());
				}
				org.polymodel.Domain simplified = ((ISLSet)domain.getPMdomain()).simplify(context.getPMdomain());
				simplified.simplify();
				target = simplified.getPolyhedra();
			}
		}
		
		return target;
	}
}
