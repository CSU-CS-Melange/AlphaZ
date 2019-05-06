package alphaz.mde.transformation;

/*PROTECTED REGION ID(Reduction_imports) ENABLED START*/
//PROTECTED IMPORTS
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.reduction.FactorOutFromReduction;
import org.polymodel.polyhedralIR.transformation.reduction.NormalizeReduction;
import org.polymodel.polyhedralIR.transformation.reduction.PermutationCaseReduce;
import org.polymodel.polyhedralIR.transformation.reduction.ReductionComposition;
import org.polymodel.polyhedralIR.transformation.reduction.ReductionDecomposition;
import org.polymodel.polyhedralIR.transformation.reduction.SimplifyingReduction;
import org.polymodel.polyhedralIR.transformation.reduction.SplitReductionBody;
import org.polymodel.polyhedralIR.transformation.reduction.TransformReductionBody;
import org.polymodel.polyhedralIR.util.ExpressionFinder;
/*PROTECTED REGION END*/
/**
Transformations involving reduce expressions.
**/
public class Reduction {

	/**
	Takes case expression inside reductions out side of the reduction.
This transformation can be applied to three different targets, 
the entire program, an affine system, or an equation.
	**/
	public static void PermutationCaseReduce(  Program program , String systemName , String targetVar ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.PermutationCaseReduce) ENABLED START*/
		PermutationCaseReduce.caseReduce(program.getSystem(systemName).getEquation(targetVar));
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void PermutationCaseReduce( Program program) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.PermutationCaseReduce_0) ENABLED START*/
		PermutationCaseReduce.caseReduce(program);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void PermutationCaseReduce( Program program, String systemName) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.PermutationCaseReduce_1) ENABLED START*/
		PermutationCaseReduce.caseReduce(program.getSystem(systemName));
		/*PROTECTED REGION END*/
	}


	/**
	Decomposes a reduction spanning more than one dimensions to two reductions.
Function f1 composed with f2 should match the original projection function.

The target reduction is specified as the n-th occurrence in the rhs of an equation indexed from 0.
	**/
	public static void ReductionDecomposition(  Program program , String nodeID , String f1 , String f2 ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.ReductionDecomposition) ENABLED START*/
		Expression expr = ExpressionFinder.getExpression(program, nodeID);
		if (expr instanceof ReduceExpression) {
			ParameterDomain params;
			if (expr.getContainerEquation() instanceof StandardEquation)
				params = ((StandardEquation) expr.getContainerEquation()).getContainerSystem().getParameters();
			else
				params = ((UseEquation) expr.getContainerEquation()).getContainerSystem().getParameters();
			ReductionDecomposition.transform((ReduceExpression)expr, 
					PolyhedralIRUtility.parseAffineFunction(params, f1), 
					PolyhedralIRUtility.parseAffineFunction(params, f2));
		} else {
			throw new RuntimeException("Given nodeID does not correspond to a ReduceExpression");
		}
		/*PROTECTED REGION END*/
	}


	/**
	Simplifies the specified reduction using the reuse specified. It does not check if the given reuse is correct.
	**/
	public static void SimplifyingReduction(  Program program , String system , String varName , String reuseVector ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.SimplifyingReduction) ENABLED START*/
		ReduceExpression reduce = (ReduceExpression)program.getSystem(system).getEquation(varName).getExpression();
		org.polymodel.polyhedralIR.transformation.reduction.SimplifyingReduction.simplify(reduce, 
				PolyhedralIRUtility.createUniformFunction(reduce.getExpr().getExpressionDomain(), reuseVector));
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void SimplifyingReduction( Program program,  String nodeID, String reuseVector) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.SimplifyingReduction_0) ENABLED START*/
		ReduceExpression reduce = (ReduceExpression)ExpressionFinder.getExpression(program, nodeID);
		SimplifyingReduction.simplify(reduce, 
				PolyhedralIRUtility.createUniformFunction(reduce.getExpr().getExpressionDomain(), reuseVector));
		/*PROTECTED REGION END*/
	}


	/**
	Transforms reductions specified into normal form.
The normal form of a reduction is when a reduce expression is the direct child of an equation.
	**/
	public static void NormalizeReduction(  Program program , String nodeID ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.NormalizeReduction) ENABLED START*/
		if (nodeID == null) {
			NormalizeReduction.apply(program);
		} else {
			NormalizeReduction.apply((ReduceExpression)ExpressionFinder.getExpression(program, nodeID));
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void NormalizeReduction( Program program) {
		NormalizeReduction( program, null );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void NormalizeReduction( Program program,  String system, String equationName) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.NormalizeReduction_1) ENABLED START*/
		NormalizeReduction.apply(program.getSystem(system).getEquation(equationName));
		/*PROTECTED REGION END*/
	}


	/**
	Factors out an operand of point-wise operations (specified with nodeID) from the reduction body.
It checks if the operator is distributive over the reduction operator, but does not verify that the given expression is constant in context.
	**/
	public static void FactorOutFromReduction(  Program program , String nodeID ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.FactorOutFromReduction) ENABLED START*/
		FactorOutFromReduction.apply(ExpressionFinder.getExpression(program, nodeID));
		/*PROTECTED REGION END*/
	}


	/**
	Takes a nodeID of a reduce expression, reduce(op, f, expr), and transform it in to two reductions;
reduce(op, f, D1 : expr) op reduce(op, f, D2 : expr) where D1 is the splitDomain, and D2 is the difference between the original expression domain of the reduction body and the splitDomain.
	**/
	public static void SplitReductionBody(  Program program , String nodeID , String splitDomain ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.SplitReductionBody) ENABLED START*/
		ReduceExpression reduce = (ReduceExpression)ExpressionFinder.getExpression(program, nodeID);
		ParameterDomain param;
		if (reduce.getContainerEquation() instanceof StandardEquation)
			param = ((StandardEquation) reduce.getContainerEquation()).getContainerSystem().getParameters();
		else
			param = ((UseEquation) reduce.getContainerEquation()).getContainerSystem().getParameters();
		SplitReductionBody.apply(reduce, PolyhedralIRUtility.parseDomain(param, splitDomain));
		/*PROTECTED REGION END*/
	}


	/**
	Given a transformation T, and (the node id of a) reduce expression, reduce(op, f, expr), it transforms the reduction body by T.  Specifically, it first computes T’, the left-inverse of T in “the context of expr,” and then replaces the reduction by reduce(op, T'@f, T'@expr).
	**/
	public static void TransformReductionBody(  Program program , String nodeID , String T ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.TransformReductionBody) ENABLED START*/
		ReduceExpression reduce = (ReduceExpression)ExpressionFinder.getExpression(program, nodeID);
		ParameterDomain param;
		if (reduce.getContainerEquation() instanceof StandardEquation)
			param = ((StandardEquation) reduce.getContainerEquation()).getContainerSystem().getParameters();
		else
			param = ((UseEquation) reduce.getContainerEquation()).getContainerSystem().getParameters();
		TransformReductionBody.apply(reduce, PolyhedralIRUtility.parseAffineFunction(param, T));
		/*PROTECTED REGION END*/
	}


	/**
	Serializes a reduction using the dependencies inferred from the given schedule.
	**/
	public static void SerializeReduction(  Program program , String nodeID , String schedule ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.SerializeReduction) ENABLED START*/
		ReduceExpression reduce = (ReduceExpression)ExpressionFinder.getExpression(program, nodeID);
		ParameterDomain param;
		if (reduce.getContainerEquation() instanceof StandardEquation)
			param = ((StandardEquation) reduce.getContainerEquation()).getContainerSystem().getParameters();
		else
			param = ((UseEquation) reduce.getContainerEquation()).getContainerSystem().getParameters();
		org.polymodel.polyhedralIR.transformation.reduction.SerializeReduction.transform(reduce, PolyhedralIRUtility.parseAffineFunction(param, schedule));
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void SerializeReduction( Program program,  String system, String var, String schedule) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.SerializeReduction_0) ENABLED START*/
		ReduceExpression reduce = (ReduceExpression)program.getSystem(system).getEquation(var).getExpression();
		ParameterDomain param;
		if (reduce.getContainerEquation() instanceof StandardEquation)
			param = ((StandardEquation) reduce.getContainerEquation()).getContainerSystem().getParameters();
		else
			param = ((UseEquation) reduce.getContainerEquation()).getContainerSystem().getParameters();
		org.polymodel.polyhedralIR.transformation.reduction.SerializeReduction.transform(reduce, PolyhedralIRUtility.parseAffineFunction(param, schedule));
		/*PROTECTED REGION END*/
	}


	/**
	Merges two reductions combined by a binary operator into one reduction (with case branches) if possible.
It is possible if all the operators are the same and the projection functions matches.
	**/
	public static void MergeReductions(  Program program , String nodeID ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.MergeReductions) ENABLED START*/
		BinaryExpression binExp = (BinaryExpression)ExpressionFinder.getExpression(program, nodeID);
		org.polymodel.polyhedralIR.transformation.reduction.MergeReductions.apply(binExp);
		/*PROTECTED REGION END*/
	}


	/**
	Composes the given reduction (represented by the nodeID) with its immediate child assuming that it is also a reduction with the same operator. this transformation implements the following reduce(op, f1, reduce(op, f2, body)); => reduce(op, f1 o f2, body); and is the reverse of ReductionDecomposition. Added support for the case when there is a restrict expression surrounding the inner reduction.
	**/
	public static void ReductionComposition(  Program program , String nodeID ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduction.ReductionComposition) ENABLED START*/
		ReduceExpression re = (ReduceExpression) ExpressionFinder.getExpression(program, nodeID);
		ReductionComposition.transform(re);
		/*PROTECTED REGION END*/
	}

}//end Reduction
