package org.polymodel.polyhedralIR.transformation.helper;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.sub;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.DimensionsManager;
import org.polymodel.IndexDimension;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

/**
 * This class contains some operations on polyhedral domains that are specific
 * to constructing domains that serves as tests of some desired properties on
 * domains.
 * 
 * @author yuki
 * 
 */
public class DomainOperations {

	/**
	 * Extends the domain given with new indices mapped from original domain
	 * with the mapping given.
	 * 
	 * @param originalDomain
	 * @param mappingToNewIndices
	 * @param newNames
	 * @return
	 */
	public static Domain extendDomainWithMapping(Domain originalDomain, AffineFunction mappingToNewIndices, List<String> newNames) {

		if (newNames == null || newNames.size() != mappingToNewIndices.getDimRHS()) {
			throw new RuntimeException("Size of the given list of names for new indices do not match the number of new indices");
		}

		Domain probDom = originalDomain.copy();

		// add new indices for RHS of the mapping
		for (int i = 0; i < mappingToNewIndices.getDimRHS(); i++) {
			probDom.addDimension(newNames.get(i));
		}

		// create equalities that maps indices in original domain to new indices
		for (int i = 0; i < mappingToNewIndices.getDimRHS(); i++) {
			AffineExpression ile = (AffineExpression) mappingToNewIndices.getExpressions().get(i).copy();
			AffineTerm newId = term(probDom.getIndices().get(originalDomain.getNIndices() + i));
			// create equality using the RHS of mapping and the new index
			probDom.getPMdomain().addConstraint(constraint(ile, affine(newId), ComparisonOperator.EQ));
		}

		return probDom;
	}

	/**
	 * Extends the domain given with new indices mapped from original domain
	 * with the mapping given.
	 * 
	 * zp0, zp1, ... is used as the names of new indices.
	 * 
	 * @param originalDomain
	 * @param mappingToNewIndices
	 * @return
	 */
	public static Domain extendDomainWithMapping(Domain originalDomain, AffineFunction mappingToNewIndices) {
		List<String> newNames = new LinkedList<String>();
		for (int i = 0; i < mappingToNewIndices.getDimRHS(); i++) {
			newNames.add("zp" + i);
		}

		return extendDomainWithMapping(originalDomain, mappingToNewIndices, newNames);
	}

	/**
	 * Expects an inputDomain for two sets of indices and parameter : P, z, z'
	 * and add constraints of the following form f1(z) op f2(z')
	 * 
	 * @param inputDom
	 * @param f1
	 * @param f2
	 * @param op
	 * @return
	 */
	public static void addConstraintsRelatingTwoSetsOfIndices(Domain inputDom, Constraint constraint) {
		// check on inputs
		if (constraint.f1.getDimRHS() != constraint.f2.getDimRHS()) {
			throw new RuntimeException("Dimensionality of RHS of the two functions given must be equal.");
		}
		if (constraint.f1.getIndices().size() + constraint.f2.getIndices().size() != inputDom.getNIndices()) {
			throw new RuntimeException("Number of indices used in two functions given must match the number of indices in input domain.");
		}

		// create two functions to relate indices on input domain with the two
		// functions given
		// Input domain has dimensions for P + z + z', so we need :
		// fa(z+z') = z and fb(z+z') = z', so that it can be composed with the
		// two functions given, which is :
		// f1(z) = ? and f2(z') = ?

		// First function, sublist of 0 to numIndices(f1) -- sublist is
		// inclusive to exclusive
		List<String> sublistA = inputDom.getIndexNames().subList(0, constraint.f1.getIndices().size());
		AffineFunction fa = PolyhedralIRUtility.parseAffineFunction(inputDom.getParams(), inputDom.getIndices(), sublistA);

		// Second function, sublist of numIndices(f1) to numIndices(f2)
		List<String> sublistB = inputDom.getIndexNames().subList(constraint.f1.getIndices().size(),
				constraint.f1.getIndices().size() + constraint.f2.getIndices().size());
		AffineFunction fb = PolyhedralIRUtility.parseAffineFunction(inputDom.getParams(), inputDom.getIndices(), sublistB);

		AffineFunction domToZ = constraint.f1.compose(fa);
		AffineFunction domToZp = constraint.f2.compose(fb);

		// Create IntLinearConstraint for each dimension on the RHS
		// relate the result of the compose functions to each other using the
		// given operator
		for (int d = 0; d < constraint.f1.getDimRHS(); d++) {
			inputDom.getPMdomain().addConstraint(
					constraint(sub(domToZ.getExpressions().get(d), domToZp.getExpressions().get(d)), affine(term(0)), constraint.op));
		}
	}

	/**
	 * Given two domains, domA {P,z|constraints(z)} and
	 * domB{P,z'|constraints(z')}, returns a new domain : {P,z,z'|constraints(z)
	 * + constraints(z')}
	 * 
	 * 
	 * @param domA
	 * @param domB
	 * @return
	 */
	public static Domain mergeDomains(Domain domA, Domain domB) {
		Domain domRes = domA.copy();
		// Copy domA add dim(z') new dimensions
		for (int i = 0; i < domB.getNIndices(); i++) {
			domRes.addDimension("zp" + i);
		}

		// Copy domB add dim(z) new dimensions
		Domain domBex = domB.copy();
		for (int i = 0; i < domA.getNIndices(); i++) {
			domBex.addDimension("zp" + i);
		}
		// Create function that takes z'+z to z+z' space
		List<String> exprs = new LinkedList<String>();
		for (int i = 0; i < domA.getNIndices(); i++) {
			exprs.add("zp" + i);
		}
		for (String iv : domB.getIndexNames()) {
			exprs.add(iv);
		}

		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(domRes.getParams(), domBex.getIndices(), exprs);
		domBex = domBex.image(func);

		// take intersection of the two
		return domRes.intersection(domBex);
	}

	/**
	 * Given two domains, origDomain {P,z|constraints(z)} and
	 * asParamDomain{P,z'|constraints(z')} returns
	 * {P,z',z|constraints(z)+constraints(z')} where parameters are P AND z'
	 * 
	 * Use when constructing domains where indices of the original domain (z)
	 * are expressed as some function of indices from another (possibly same)
	 * domain (z') ex. Slices of reductions parameterized with indices of the
	 * answer variable - extend domain of reduction expression with domain of
	 * reduction as new parameters - relate the two sets of indices through
	 * projection function using another method in this class
	 * 
	 * @param origDomain
	 * @param asParamDomain
	 * @return
	 */
	public static Domain extendParameterDomain(Domain origDomain, Domain asParamDomain) {
		List<String> existingIndexNames = new ArrayList<String>();
		existingIndexNames.addAll(asParamDomain.getIndexNames());
		existingIndexNames.addAll(asParamDomain.getParamNames());
		
		return extendParameterDomain(origDomain, asParamDomain, existingIndexNames);
	}
	
	
	/**
	 * This method is similar to {@link DomainOperations#extendParameterDomain(Domain, Domain)} 
	 * except that an explicit list of index and param names can be provided, 
	 * therefore any name in this list is avoided while renaming
	 * 
	 * @param origDomain
	 * @param asParamDomain
	 * @param existingIndexNames
	 * @return
	 */
	public static Domain extendParameterDomain(Domain origDomain, Domain asParamDomain, List<String> existingIndexNames) {
		// Convert the asParamDomain to be ParameterDomain
		ParameterDomain exDom = asParamDomain.toParameterDomain();
		// rename parameters
		for (int i = origDomain.getNParams(); i < exDom.getNParams(); i++) {
			IndexDimension id = (IndexDimension) exDom.getParams().get(i);
			StringBuffer postFix = new StringBuffer("p");
			while (origDomain.getParamNames().contains(id.getName() + postFix) || origDomain.getIndexNames().contains(id.getName() + postFix) || existingIndexNames.contains(id.getName() + postFix)) {	
				postFix.append("p");
			}
			//new var
			Variable newVar = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getParameter(i, id.getName() + postFix);
			exDom.getParams().set(i, newVar);
			exDom = DomainOperations.substitute(exDom, id, affine(term(newVar))).toParameterDomain();
		}
		// Add new indices for free variables
		for (int i = 0; i < origDomain.getNIndices(); i++) {
			exDom.addDimension(origDomain.getIndexNames().get(i));
		}
		// NOTE : at this point, exDom is no longer ParameterDomain

		// Copy the original domain and add new parameter indices
		Domain freeDom = origDomain.copy();
		for (int i = 0; i < asParamDomain.getNIndices(); i++) {
			freeDom.addParameterDimension(exDom.getParamNames().get(origDomain.getNParams() + i));
		}
		// Intersect the two to get the result
		return exDom.intersection(freeDom);
	}

	/**
	 * Given original parameter domain, and an input domain with parameters
	 * extended with additional indices (using extendParameter method in this
	 * class), add constraints relating the additional parameter indices and the
	 * original indices. The input domain is in the form {P,z,z'|constraints},
	 * where P and z are both parameter indices. The constraints added are fp(z)
	 * op fi(z'), and thus fp and fi should have the same dimensionality on the
	 * RHS.
	 * 
	 * @param originalParam
	 * @param inputDom
	 * @param f1
	 * @param f2
	 * @param op
	 */
	public static void addConstraintsRelatingExtendedParameterIndicesAndIndices(ParameterDomain originalParam, Domain inputDom, Constraint constraint) {

		// check on inputs
		if (constraint.f1.getDimRHS() != constraint.f2.getDimRHS()) {
			throw new RuntimeException("Dimensionality of RHS of the two functions given must be equal.");
		}
		if (constraint.f1.getDimLHS() + constraint.f2.getIndices().size() != inputDom.getDim()) {
			throw new RuntimeException("Number of indices used in two functions given must match the number of indices in input domain.");
		}
		if (constraint.f1.getDimLHS() != inputDom.getNParams()) {
			throw new RuntimeException("Number of indices in LHS of fp does not match number of parameters in the input domain.");
		}
		if (constraint.f2.getDimLHS() != inputDom.getNIndices() + originalParam.getNParams()) {
			throw new RuntimeException("Number of indices in LHS of fi does not match the oridinal indices.");
		}

		// create two functions to relate indices on input domain with the two
		// functions given
		// Input domain has dimensions for P + z + z', so we need :
		// fa(z+z') = z and fb(z+z') = z', so that it can be composed with the
		// two functions given, which is :
		// fp(z) = ? and fi(z') = ?
		// Twist added to the other function with similar name is that z is
		// indices of the parameters now

		// First function, sublist of 0 to numIndices(f1) -- sublist is
		// inclusive to exclusive
		List<String> sublistA = inputDom.getParamNames().subList(originalParam.getNParams(), inputDom.getNParams());
		AffineFunction fa = PolyhedralIRUtility.parseAffineFunction(inputDom.getParams(), inputDom.getIndices(), sublistA);

		// Second function, sublist of numIndices(f1) to numIndices(f2)
		AffineFunction fb = PolyhedralIRUtility.parseAffineFunction(inputDom.getParams(), inputDom.getIndices(), inputDom.getIndexNames());

		// Extend the input functions with extended parameters
		// First, copy, add new parameters
		AffineFunction fpEx = constraint.f1.copy();
		AffineFunction fiEx = constraint.f2.copy();
		for (int i = 0; i < inputDom.getNParams() - originalParam.getNParams(); i++) {
			fpEx.addParameterDimension(inputDom.getParams().get(i + originalParam.getNParams()).getName());
			fiEx.addParameterDimension(inputDom.getParams().get(i + originalParam.getNParams()).getName());
		}
		// //Next, re-set dimension numbers
		// {//For fpEx
		// int dim = 0;
		// List<Variable> pVars = new LinkedList<Variable>();
		// pVars.addAll(fpEx.getParams());
		// pVars.addAll(fpEx.getIndices());
		// for (Variable iv : pVars) {
		// if (iv instanceof IndexDimension) {
		// ((IndexDimension)iv).setDimension(dim);
		// dim++;
		// } else {
		// throw new RuntimeException("Expecting IndexDimension");
		// }
		// }
		// }
		// {//For fiEx
		// int dim = 0;
		// List<Variable> pVars = new LinkedList<Variable>();
		// pVars.addAll(fiEx.getParams());
		// pVars.addAll(fiEx.getIndices());
		// for (Variable iv : pVars) {
		// if (iv instanceof IndexDimension) {
		// ((IndexDimension)iv).setDimension(dim);
		// dim++;
		// } else {
		// throw new RuntimeException("Expecting IndexDimension");
		// }
		// }
		// }
		// Finally, compose the functions to get the desired expressions
		AffineFunction domToZ = fpEx.compose(fa);
		AffineFunction domToZp = fiEx.compose(fb);
		
		// Create IntLinearConstraint for each dimension on the RHS
		// relate the result of the compose functions to each other using the
		// given operator
		for (int d = 0; d < constraint.f1.getDimRHS(); d++) {
			inputDom.getPMdomain().addConstraint(
					constraint(affine(
							sub(domToZ.getExpressions().get(d), domToZp.getExpressions().get(d))), affine(term(0)), constraint.op));
		}
	}

	/**
	 * Copies all constraints on paramDomain into the domain given.
	 * 
	 * @param domain
	 * @param paramDomain
	 */
	public static Domain copyParameterConstraints(Domain domain, ParameterDomain paramDomain) {
		Domain res = PolyhedralIRUtility.createUniverseDomain(domain.getParams(), domain.getIndices());
		res.getPMdomain().getPolyhedra().clear();

		for (IntConstraintSystem ilcsOrig : domain.getPMdomain().getPolyhedra()) {
			for (IntConstraintSystem ilcsParam : paramDomain.getPMdomain().getPolyhedra()) {
				IntConstraintSystem ilcs = ilcsOrig.copy();
				ilcs.getConstraints().addAll(ilcsParam.copy().getConstraints());
				res.getPMdomain().getPolyhedra().add(ilcs);
			}
		}

		return res;
	}

	/**
	 * Sub class for specifying list of constraints of the form f1(z) op f2(z')
	 * What z and z' are is different for each method using this class.
	 * 
	 * @author yuki
	 * 
	 */
	public static class Constraint {
		public final AffineFunction f1;
		public final AffineFunction f2;
		public final ComparisonOperator op;

		public Constraint(AffineFunction f1, AffineFunction f2, ComparisonOperator op) {
			this.f1 = f1;
			this.f2 = f2;
			this.op = op;

			if (f1.getDimRHS() != f2.getDimRHS()) {
				throw new RuntimeException("Dimensionality of RHS of the two functions given must be equal.");
			}
		}

		@Override
		public String toString() {
			return f1 + " " + op + " " + f2;
		}
	}

	/**
	 * Overloading of the main implementation for convenience.
	 * 
	 * @param param
	 * @param fromDomain
	 * @param toDomain
	 * @param constraint
	 * @param schedule
	 * @return
	 */
	public static Map<Domain, AffineFunction> findDependencies(ParameterDomain param, Domain fromDomain, Domain toDomain, Constraint constraint,
			Constraint schedule) {

		List<Constraint> constraints = new LinkedList<Constraint>();
		constraints.add(constraint);
		return findDependencies(param, fromDomain, toDomain, constraints, schedule);
	}

	/**
	 * Finds affine functions that map fromDomain to toDomain under the
	 * constraints given. The first set of constraints specified as
	 * List<Constraint> are treated as regular constraint, and the expected use
	 * to specify conflicting indices through this. The second constraint is to
	 * specify schedule for each of the domain, which can be optionally
	 * specified to find indices in the toDomain that was last computed before
	 * indices in fromDomain under some schedule. For the scheduling constraint,
	 * Operator given in the Constraint object is ignored. (always GT and GE)
	 * 
	 * @param param
	 * @param fromDomain
	 * @param toDomain
	 * @param constraints
	 * @param schedule
	 * @return
	 */
	public static Map<Domain, AffineFunction> findDependencies(ParameterDomain param, Domain fromDomain, Domain toDomain, List<Constraint> constraints,
			Constraint schedule) {
		// extend
		Domain exDomain = extendParameterDomain(toDomain, fromDomain);
		// add constraints for conflicting indices
		for (Constraint constraint : constraints) {
			addConstraintsRelatingExtendedParameterIndicesAndIndices(param, exDomain, constraint);
		}
		// add scheduling constraints
		Domain probDomain = null;
		// no scheduling constraints
		if (schedule == null) {
			probDomain = exDomain;
			// one dimensional case is simple
		} else if (schedule.f1.getDimRHS() == 1) {
			probDomain = exDomain;
			addConstraintsRelatingExtendedParameterIndicesAndIndices(param, exDomain, schedule);
			// multi-dimensional case requires union for lex-max
		} else {
			Domain prevDim = null;
			//create a new name space for the values
			List<String> indexName = new LinkedList<String>();
			for(int d = 0; d < schedule.f1.getDimRHS(); d++){
				String name = "t"+d;
				indexName.add(name);
			}
			// for each dimension
			for (int d = 0; d < schedule.f1.getDimRHS(); d++) {
				Domain curDim = exDomain.copy();
				// compose function to restrict the schedule to one dimension
				AffineFunction proj = PolyhedralIRUtility.parseAffineFunctionFromString(schedule.f1.getParamNames(),
						indexName.subList(0, schedule.f1.getDimRHS()), indexName.subList(d, d + 1));
				Constraint schedConst = new Constraint(proj.compose(schedule.f1), proj.compose(schedule.f2), ComparisonOperator.GT);

				// restrict currently dimension with strict inequalities
				addConstraintsRelatingExtendedParameterIndicesAndIndices(param, curDim, schedConst);
				// take intersection with previous dimensions relaxed
				// constraints
				if (prevDim != null) {
					curDim = curDim.intersection(prevDim);
				}
				// take union with the current problem domain
				if (probDomain != null) {
					probDomain = probDomain.union(curDim);
				} else {
					probDomain = curDim;
				}

				// Create new prevDim for next dimension
				if (prevDim == null) {
					prevDim = exDomain.copy();
				}
				// Add relaxed constraint for this dimension
				Constraint schedConstRelaxed = new Constraint(proj.compose(schedule.f1), proj.compose(schedule.f2), ComparisonOperator.GE);
				addConstraintsRelatingExtendedParameterIndicesAndIndices(param, prevDim, schedConstRelaxed);
			}
		}
		
		//The problem domain get the set of points that executes before a given point ip
		//get the point that executes most recently, we get the points with the latest time stamp
		//create the mapping function from the domain to time stamp
		AffineFunction fb = PolyhedralIRUtility.parseAffineFunction(probDomain.getParams(), probDomain.getIndices(), probDomain.getIndexNames());
		if(schedule != null){
			//add extra parameters to the schedule function
			AffineFunction to_schedule = schedule.f2.copy();
			for(int i = param.getNParams(); i < probDomain.getNParams(); i++){
				to_schedule.addParameterDimension(probDomain.getParamNames().get(i));
			}
			fb = to_schedule.compose(fb);
		}
		
		Map<Domain, AffineFunction> quast = new HashMap<Domain, AffineFunction>();
		probDomain = probDomain.image(fb);
		Domain result = PolyhedralIRUserFactory.eINSTANCE.createDomain((org.polymodel.Domain)(probDomain.getPMdomain()).lexMax());
		//get the original points
		result = result.preimage(fb);
		
		// get list of parameter/index
		EList<String> names = result.getParamNames();
		names.addAll(result.getIndexNames());
		List<Variable> params = result.getParams();
		List<Variable> indices = result.getIndices();

		// Domain for bottom
		Domain bottom = fromDomain.copy();
//		for (int i = 0; i < bottom.getNIndices(); i++) {
//			IndexDimension iv = (IndexDimension) bottom.getIndices().get(i);
//			iv.setName(exDomain.getParamNames().get(i + param.getNParams()));
//		}
		// Iterate over each polyhedron
		List<Matrix> matrices = result.getPMdomain().toMatrices();
		for (Matrix mat : matrices) {
			// Separate the constraints to those that express the function, and
			// those that express the domain
			List<String> depFunc = new Vector<String>(result.getNIndices());
			// initialize dependence expr vector with empty string, since which
			// element to store the expression determines the dimension
			for (int i = 0; i < result.getNIndices(); i++) {
				depFunc.add("");
			}
			List<String> domainConstraints = new ArrayList<String>(mat.getNbRows());
			int __c = 0;
			for (MatrixRow row : mat.getRows()) {
				// Equality has a chance that it is about the dependence
				if (row.get(0) == 0) { // FIXME 1/0 is swapped vs actual polylib
										// syntax
					// Check the dimensions corresponding to the new indices
					// these dimensions are non-zero for dependence equalities
					// only (I think)
					boolean wasDep = false;
					// offset by one for eq/ineq
					for (int d = result.getNParams() + 1; d < result.getDim() + 1; d++) {
						// Dependence expression for dimension d if the column
						// is non-zero
						if (row.get(d) != 0) {
							// Need to negate the other terms if the coefficient
							// on this term is positive
							boolean negate = row.get(d) > 0;
							if (Math.abs(row.get(d)) != 1) {
								throw new RuntimeException("Unexpected coefficient for dimension :" + d);
							}
							StringBuffer expr = new StringBuffer();
							// constant part
							long cpart = row.get(row.getSize() - 1);
							// Other expressions
							boolean first = true;
							for (int dp = 0; dp < result.getNParams(); dp++) {
								// offset by 1 for eq/ineq
								long coef = row.get(dp + 1);
								if (coef != 0) {
									if (negate) {
										coef = -coef;
									}
									if (!first && coef>0) {
										expr.append("+");
									}
									first = false;
									expr.append(coef + "" + result.getParams().get(dp));
								}
							}
							// add constant to the end
							if (negate && cpart != 0) {
								if(cpart < 0){
									long negCpart = -cpart;
									expr.append("+" + negCpart);
								}else{
									expr.append("-" +  cpart);
								}
							} else if (cpart != 0) {
								if(cpart < 0){
									long negCpart = -cpart;
									expr.append("-" + negCpart);
								}else{
									expr.append("+" + cpart);
								}
							}
							// when its mapped to zero
							if (expr.length() == 0) {
								expr.append("0");
							}
							depFunc.set(d - 1 - result.getNParams(), expr.toString());
							wasDep = true;
							break;
						}
					}
					if (!wasDep) {
						domainConstraints.add(PolyhedralIRUtility.toConstraint(row, params, indices).toString(OUTPUT_FORMAT.ALPHABETS));
						System.out.println(__c++ + "  XX  " + domainConstraints.get(domainConstraints.size()-1));
					}
				} else {
					if (__c == 7)
						System.out.println("hey");
					IntConstraint constraint = PolyhedralIRUtility.toConstraint(row, params, indices);
					domainConstraints.add(constraint.toString(OUTPUT_FORMAT.ALPHABETS));
					System.out.println(__c++ + "  YY  " + domainConstraints.get(domainConstraints.size()-1));
				}
			}

			Domain dom = PolyhedralIRUtility.parseDomainFromString(param.getParamNames(),
					exDomain.getParamNames().subList(param.getNParams(), exDomain.getNParams()), domainConstraints);
			AffineFunction dep = PolyhedralIRUtility.parseAffineFunction(param, exDomain.getParamNames().subList(param.getNParams(), exDomain.getNParams()),
					depFunc);
			quast.put(dom, dep);
			bottom = bottom.difference(dom);
		}

		// If bottom is not empty, add it with null dependence
		if (!bottom.isEmpty()) {
			quast.put(bottom, null);
		}

		return quast;
	}
	
	/**
	 * Creates a projection that removes the dimensions in the given list, and returns
	 * the result of taking the image with the created projection.
	 * 
	 *  The intended use is to reason about all but the ordering dimensions during
	 *  code generation.
	 * 
	 * @param domain
	 * @param orderingDims
	 * @return
	 */
	public static Domain removeOrderingDimensions(Domain domain, List<Integer> orderingDims) {
		List<Variable> nonOrdering = new ArrayList<Variable>();
		for (int i = 0; i < domain.getNIndices(); i++) {
			if (orderingDims.contains(i)) continue;
			
			nonOrdering.add(domain.getIndices().get(i));
		}
		AffineFunction proj = PolyhedralIRUtility.createProjection(domain, nonOrdering);
		return domain.image(proj);
	}
	
	/**
	 * Removes constraints on a dimension of the given domain.
	 * This method first takes a projection to a d-1 dimensional space
	 * with the target dimension removed.
	 * Then the removed dimension is re-added so that the dimension is unconstrained.
	 * 
	 * @param dom
	 * @param dim
	 * @return
	 */
	public static Domain removeConstraintsOnADimension(Domain dom, int dim) {
		//First project to a space with the target dimension removed
		List<Variable> targets = new ArrayList<Variable>();
		for (int i = 0; i < dom.getNIndices(); i++) {
			if (i == dim) continue;
			targets.add(dom.getIndices().get(i));
		}
		AffineFunction proj = PolyhedralIRUtility.createProjection(dom, targets);
		dom = dom.image(proj);
		
		//Then add a new dimension, which is now unconstrained
		dom.addDimension("dim");
		
		//Create a function to shift the indices so that the new dimension is shifted back to the original position.
		List<AffineExpression> shiftExprs = new ArrayList<AffineExpression>();
		for (int i = 0; i < dim; i++) {
			shiftExprs.add(affine(term(dom.getIndices().get(i))));
		}
		//insert as dim-th
		shiftExprs.add(affine(term(dom.getIndices().get(dom.getNIndices()-1))));
		//later dimensions
		for (int i = dim; i < dom.getNIndices()-1; i++) {
			shiftExprs.add(affine(term(dom.getIndices().get(i))));
		}
		//take the image and return
		AffineFunction shift = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(dom.getParams(), dom.getIndices(), shiftExprs);
		return dom.image(shift);
	}
	
	/**
	 * Removes all constraints on indices, and returns a domain with only constraints on the parameters.
	 * 
	 * The implementation is based on projecting to 0D space and then re-adding all the indices
	 * 
	 * @param dom
	 * @return
	 */
	public static Domain removeConstraintsOnIndices(Domain dom) {

		List<Variable> targets = new ArrayList<Variable>();
		AffineFunction proj = PolyhedralIRUtility.createProjection(dom, targets);
		Domain ret = dom.image(proj);

		//Then add original dimensions, which is now unconstrained		
		ret.getPMdomain().getIndices().addAll(dom.getIndices());
		
		return ret;
	}

	/**
	 * Substitute a variable with an expression. Assumes that the expression only uses variables already in the given domain.
	 * 
	 * @param dom
	 * @param var
	 * @param substituteWith
	 * @return
	 */
	public static Domain substitute(Domain dom, Variable var, IntExpression substituteWith) {
		List<IntConstraintSystem> polyhedra = new ArrayList<IntConstraintSystem>(dom.getPMdomain().getPolyhedra().size());
		
		for (IntConstraintSystem poly : dom.getPMdomain().getPolyhedra()) {
			poly = poly.substitute(var, substituteWith);
			polyhedra.add(poly);
		}
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(dom.getParams(), dom.getIndices(), polyhedra);
	}

	public static void main(String[] args) {
		findDependenceEx();
	}

	public static void findDependenceEx() {
		ParameterDomain param = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
		// domA = domain of reduction body
		Domain domA = PolyhedralIRUtility.parseDomain(param, "{i,j|0<=i<N && 0<=j<i}");
		Domain domB = PolyhedralIRUtility.parseDomain(param, "{i|0<=i<N}");
		AffineFunction projA = PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i)");
		AffineFunction projB = PolyhedralIRUtility.parseAffineFunction(param, "(i->i)");
		AffineFunction schedA = PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i,j+2)");
		AffineFunction schedB = PolyhedralIRUtility.parseAffineFunction(param, "(i->i,i)");
		List<Constraint> constraints = new LinkedList<Constraint>();
		constraints.add(new Constraint(projA, projB, ComparisonOperator.EQ));
		Map<Domain, AffineFunction> quast = findDependencies(param, domA, domB, constraints, new Constraint(schedA, schedB, ComparisonOperator.GT));
		// Map<Domain, AffineFunction> quast = findDependencies(param, domA,
		// domB, constraints, null);
		// Map<Domain, AffineFunction> quast = findDependencies(param, domB,
		// domA, schedB, schedA);
		for (Domain key : quast.keySet()) {
			System.out.println(key + " : " + quast.get(key));
		}
	}

	public static void reductionSliceEx() {
		ParameterDomain param = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
		// domA = domain of reduction body
		Domain domA = PolyhedralIRUtility.parseDomain(param, "{i,j|0<=i<N && 0<=j<i}");
		// domB = answer space
		Domain domB = PolyhedralIRUtility.parseDomain(param, "{i|0<=i<N}");
		// projection function
		AffineFunction proj = PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i)");
		// identity function in the answer space for using the generic function
		AffineFunction id = PolyhedralIRUtility.parseAffineFunction(param, "(i->i)");

		// First extend domA with domB as new parameters
		Domain exDom = extendParameterDomain(domA, domB);
		System.out.println(exDom);
		// Then equate indices in domA with indices of domB, that are now
		// parameters
		addConstraintsRelatingExtendedParameterIndicesAndIndices(param, exDom, new Constraint(id, proj, ComparisonOperator.EQ));
		System.out.println(exDom);
	}

	public static void serializeReductionEx() {
		ParameterDomain param = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
		// dom = domain of reduction body
		Domain dom = PolyhedralIRUtility.parseDomain(param, "{i,j|0<=i<N && 0<=j<i}");
		// projection function
		AffineFunction proj = PolyhedralIRUtility.parseAffineFunction(param, "(i,j->i)");
		// scheduling function
		AffineFunction sched = PolyhedralIRUtility.parseAffineFunction(param, "(i,j->j)");

		// First extend dom with itself as parameters
		Domain exDom = extendParameterDomain(dom, dom);
		System.out.println(exDom);
		// Then equate two sets of indices with the projection to restrict the
		// set that are contributing to the same answer
		addConstraintsRelatingExtendedParameterIndicesAndIndices(param, exDom, new Constraint(proj, proj, ComparisonOperator.EQ));
		System.out.println(exDom);
		// Then add scheduling constraints so that dependencies can be found
		addConstraintsRelatingExtendedParameterIndicesAndIndices(param, exDom, new Constraint(sched, sched, ComparisonOperator.GT));
		System.out.println(exDom);
	}
	
	/**
	 * Translate parameters from one domain to another (used with sub-systems).
	 * Gives back the set (ExtDom \times translated_origDom)
	 * 
	 * @param origDom
	 * @param mapping : mapping from the parameters of origDom to the new ones (cf the AffineFunction from the parameters of a UseEquation)
	 * @param extDom  : extension domain (indexes are used in the mapping + its indexes must be the first dimensions of the final set)
	 */
	public static Domain old_translateParams(Domain origDom, AffineFunction mapping, Domain extDom) {
		if (mapping.getExpressions().size()!=origDom.getNParams())
			throw new RuntimeException("Mapping incompatible with the parameter of the original domain (mapping: " + mapping.getExpressions().size()
					+ " | nparams_orig = " + origDom.getNParams() +" )");
		
		// Moreover, the indices of the mapping and the extension domain should be the same.
		List<Variable> paramMain = mapping.getParams();		// New parameters (those from the main system)
		
		Domain origDomCopy = origDom.copy();
		//check the indices name for the original domain make sure it is not conflicting with the extDom
		for(int k = 0; k < origDomCopy.getNIndices(); k++){
			IndexDimension id = (IndexDimension) origDomCopy.getIndices().get(k);
			StringBuffer postFix = new StringBuffer("");
			while(extDom.getIndexNames().contains(id.getName() + postFix) || extDom.getParamNames().contains(id.getName() + postFix)){
				postFix.append("p");
			}
			if(!postFix.toString().equals("")){
				Variable newVar = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getDimension(k, id.getName() + postFix);
				origDomCopy.getIndices().set(k, newVar);
				origDomCopy = DomainOperations.substitute(origDomCopy, id, affine(term(newVar)));
			}
		}
		
		// Before doing anything on the parameters, we shift the indexes of origDom, so we have room for the extension domain indexes
		Domain origDomextended = origDomCopy.copy();
		
		// We add the extension domain dimensions at the end...
		for (int k=0; k<extDom.getNIndices(); k++)
			origDomextended.addDimension(extDom.getIndices().get(k).getName());
		
		// ... before shifting them at the beginning.
		int nShift = origDomCopy.getNIndices();
		EList<AffineExpression> lexpafShift = new BasicEList<AffineExpression>();
		for (int k=nShift; k<origDomextended.getNIndices(); k++)
			lexpafShift.add(affine(origDomextended.getIndices().get(k)));
		for (int k=0; k<nShift; k++)
			lexpafShift.add(affine(origDomextended.getIndices().get(k)));
		AffineFunction afshift = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(origDomextended.getParams(),
				origDomextended.getIndices(), lexpafShift);
		Domain origDomShifted = origDomextended.image(afshift);
		
		//System.out.println("	* origDomShifted = " + origDomShifted.toString());
		
		// Getting the new constraints: to avoid to translate twice a parameter, we do it in 2 steps
		List<Variable> dummy_params = new BasicEList<Variable>();
		for (int k=0; k<origDomShifted.getNParams(); k++)
			dummy_params.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getParameter(k, "__dummyParams_" + k));
		
		// a) First step: from subsystem to dummy parameters (which do not appear in the context domain)
		List<IntConstraintSystem> dummy_lpoly = new BasicEList<IntConstraintSystem>();
		for (IntConstraintSystem poly : origDomShifted.getPMdomain().getPolyhedra()) {
			IntConstraintSystem npoly = poly.copy();
			for (int i=0; i<mapping.getExpressions().size(); i++) {
				npoly = npoly.substitute(origDomShifted.getParams().get(i), dummy_params.get(i));
			}
			dummy_lpoly.add(npoly);
		}
		
		// b) Second step: from dummy parameters to main system (without risk of interference between the translation of 2 parameters)
		List<IntConstraintSystem> nlpoly = new BasicEList<IntConstraintSystem>();
		for (IntConstraintSystem poly : dummy_lpoly) {
			IntConstraintSystem npoly = poly.copy();
			for (int i=0; i<mapping.getExpressions().size(); i++) {
				npoly = npoly.substitute(dummy_params.get(i), mapping.getExpressions().get(i));
			}
			nlpoly.add(npoly);
		}
		
		Domain extendedExtDom = extDom.copy();
		for (int k=0; k<origDomCopy.getNIndices(); k++)
			extendedExtDom.addDimension(origDomCopy.getIndices().get(k).getName());
		List<Variable> nlInd = extendedExtDom.getIndices();
		Domain translOrigDom = PolyhedralIRUserFactory.eINSTANCE.createDomain(paramMain, nlInd, nlpoly);
		translOrigDom.simplify();
		
		// We create (ExtDom \times translOrigDom)
		Domain resDom =  extendedExtDom.intersection(translOrigDom);
		resDom.simplify();
		
		return resDom;
	}
	
	public static Domain translateParams(Domain origDom, AffineFunction mapping, Domain extDom) {
		// DEBUG
		//System.out.println("origDom = " + origDom.toString());
		
		DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		// 1) Managing the parameters
		
		// a) Translate origDom into a domain without parameters
		List<Matrix> lMatOrigDom = origDom.getPMdomain().toMatrices();
		
		EList<Variable> lParInds = new BasicEList<Variable>();
		for (int i=0; i<origDom.getNParams(); i++)
			lParInds.add(_dimMana.getDimension(i, origDom.getParamNames().get(i)));
		for (int i=0; i<origDom.getNIndices(); i++)
			lParInds.add(_dimMana.getDimension(i+origDom.getNParams(), origDom.getIndexNames().get(i)));
		
		List<IntConstraintSystem> lSystOrigNoParam = new BasicEList<IntConstraintSystem>();
		for (Matrix mat : lMatOrigDom)
			lSystOrigNoParam.add(mat.toDomain(new BasicEList<Variable>(), lParInds));
		Domain origDomNoParam = PolyhedralIRUserFactory.eINSTANCE.createDomain(new BasicEList<Variable>(), lParInds, lSystOrigNoParam);
		
		// DEBUG
		//System.out.println("origDomNoParam = " + origDomNoParam.toString());
		
		// b) Applying the mapping (as a preimage) to this domain
		List<Variable> lIndMappingExt = new BasicEList<Variable>();
		
		for (int i=0; i<extDom.getNParams(); i++)
			lIndMappingExt.add(_dimMana.getDimension(i, extDom.getParamNames().get(i)));
		for (int i=0; i<mapping.getNIndices(); i++)
			lIndMappingExt.add(_dimMana.getDimension(i+extDom.getNParams(), mapping.getIndexNames().get(i)));
		for (int i=0; i<origDom.getNIndices(); i++)
			lIndMappingExt.add(_dimMana.getDimension(i+mapping.getNIndices()+extDom.getNParams()));
		
		
		List<AffineExpression> lAffExpr = new BasicEList<AffineExpression>();
		lAffExpr.addAll(mapping.getExpressions());
		for (int i=0; i<origDom.getNIndices(); i++)
			lAffExpr.add(IntExpressionBuilder.affine(lIndMappingExt.get(i+extDom.getNParams()+mapping.getNIndices())));
		
		AffineFunction mappingExtended = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(
				new BasicEList<Variable>(), lIndMappingExt, lAffExpr);
		Domain origDomNoParamTrans = origDomNoParam.preimage(mappingExtended);
		
		// DEBUG
		//System.out.println("mappingExtended = " + mappingExtended.toString());
		//System.out.println("origDomNoParamTrans = " + origDomNoParamTrans.toString());
		
		
		// 2) Managing the extension domain (giving back extdom \times translated_origDom)
		List<Matrix> lMatOrigDomParamTrans = origDomNoParamTrans.getPMdomain().toMatrices();
		
		EList<Variable> lIndTranslated = new BasicEList<Variable>();
		for (int i=0; i<extDom.getNIndices(); i++)
			lIndTranslated.add(extDom.getIndices().get(i));
		for (int i=0; i<origDom.getNIndices(); i++)
			lIndTranslated.add(_dimMana.getDimension(i+extDom.getNIndices(), origDom.getIndexNames().get(i)));
		
		List<IntConstraintSystem> lSystTranslated = new BasicEList<IntConstraintSystem>();
		for (Matrix matOrig : lMatOrigDomParamTrans)
			lSystTranslated.add(matOrig.toDomain(extDom.getParams(), lIndTranslated));
		Domain domTranslated = PolyhedralIRUserFactory.eINSTANCE.createDomain(extDom.getParams(), lIndTranslated, lSystTranslated);
		
		// DomTranslated contains the index from the extension domain because of the mapping
		//			=> We just need to extend extDom and interesect them to get the final set
		Domain extDomExtended = extDom.copy();
		for (int i=extDom.getNIndices(); i<domTranslated.getNIndices(); i++)
			extDomExtended.addDimension(domTranslated.getIndexNames().get(i));
		
		Domain retDom = extDomExtended.intersection(domTranslated);
		retDom.simplify();
		return retDom;
	}
	
	/**
	 * Set the indexes of the first few dimensions of the origDom to be indexes,
	 * Also check to make sure that the rest of the indices does not conflict with the rest of the indices
	 * @param origDom
	 * @param indexs
	 * @return
	 */
	public static Domain setFirstFewDimensions(Domain origDom, List<Variable> indexs){
		Domain tempDom = origDom.copy();
		//make sure the rest of the index is not conflict with the indexs
		List<String> index_names = new LinkedList<String>();
		for(int i = 0; i < indexs.size(); i++){
			index_names.add(indexs.get(i).getName());
		}
		//check the index not conflict with the new set of indexs
		for(int i = indexs.size(); i < origDom.getNIndices(); i++){
			IndexDimension id = (IndexDimension) tempDom.getIndices().get(i);
			StringBuffer postFix = new StringBuffer("");
			while(index_names.contains(id.getName() + postFix) || tempDom.getParamNames().contains(id.getName() + postFix)){
				postFix.append("p");
			}
			if(!postFix.toString().equals("")){
				Variable newVar = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getParameter(i, id.getName() + postFix);
				tempDom.getIndices().set(i, newVar);
				tempDom = DomainOperations.substitute(tempDom, id, affine(term(newVar)));
			}
		}
		
		// DEBUG
		//System.out.println("indexs = " + indexs.toString());
		//System.out.println("origDom = " + origDom.toString());
		//System.out.println("tempDom = " + tempDom.toString());
		
		
		//substitute the first few dimensions with the new indexs
		for(int i = 0; i < indexs.size(); i++){
			Variable var = tempDom.getIndices().get(i);
			tempDom = DomainOperations.substitute(tempDom, var, affine(term(indexs.get(i))));
			tempDom.getIndices().set(i, indexs.get(i));
		}
		
		//reparse the domain
		//get the list of parameter variables
		List<Variable> paramVars = tempDom.getParams();
		List<Variable> indices = tempDom.getIndices();
		//get th list of constriants
		List<List<String>> constraints = new LinkedList<List<String>>();
		for(IntConstraintSystem conSystem : tempDom.getPMdomain().getPolyhedra()){
			List<String> constraint = new LinkedList<String>();
			for(IntConstraint cons: conSystem.getConstraints()){
				constraint.add(cons.toString(OUTPUT_FORMAT.ALPHABETS));
			}
			constraints.add(constraint);
		}
				
				
		Domain domain = PolyhedralIRUtility.parseDomainUnion(paramVars, indices, constraints);
		
		return domain;
	}
	/**
	 * Construct a domain for each instance  of the useEquation
	 * The new domain: parameter domain is {paraDom, extDom}
	 * keep the original domain index from origDom.getNIndex - extDom.getNIndex
	 * @param paramDom
	 * @param origDom
	 * @param extDom
	 * @return
	 */
	public static Domain subSystemInstanceDomain(ParameterDomain paramDom, Domain origDom, Domain extDom){
		
//		System.out.println("get the sub system instance domain");
//		System.out.println("The parameter domain: " + paramDom);
//		System.out.println("The original domain: " + origDom);
//		System.out.println("The extension domain: " + extDom);
		//get a copy of the original domain
		Domain tempDom = origDom.copy();
		//substitute the first few dimensions with the parameter indices
		for(int i = paramDom.getNParams() - extDom.getNIndices(); i < paramDom.getNParams(); i++){
			Variable var = paramDom.getParams().get(i);
			tempDom = DomainOperations.substitute(tempDom, tempDom.getIndices().get(i-(paramDom.getNParams() - extDom.getNIndices())), affine(term(var)));
			tempDom.getIndices().set(i - (paramDom.getNParams() - extDom.getNIndices()), var);
		}
		
		/*
		 *check the indices for the domain do not conflict with the parameter domain indices 
		 */
		for(int i = extDom.getNIndices(); i < origDom.getNIndices(); i++){
			IndexDimension id = (IndexDimension) origDom.getIndices().get(i);
			StringBuffer postFix = new StringBuffer("");
			while(paramDom.getParamNames().contains(id.getName()+postFix)){
				postFix.append("p");
			}
			//if the name conflicts with the other index
			if(!postFix.toString().equals("")){
				Variable newVar = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getParameter(i, id.getName() + postFix);
				tempDom.getIndices().set(i, newVar);
				tempDom = DomainOperations.substitute(tempDom, id, affine(term(newVar)));
			}
		}
		
		//get the list of parameter variables
		List<Variable> paramVars = paramDom.getParams();
		List<Variable> indices = tempDom.getIndices().subList(extDom.getNIndices(), tempDom.getNIndices());
		//get th list of constriants
		List<List<String>> constraints = new LinkedList<List<String>>();
		for(IntConstraintSystem conSystem : tempDom.getPMdomain().getPolyhedra()){
			List<String> constraint = new LinkedList<String>();
			for(IntConstraint cons: conSystem.getConstraints()){
				constraint.add(cons.toString(OUTPUT_FORMAT.ALPHABETS));
			}
			constraints.add(constraint);
		}
		
		
		Domain domain = PolyhedralIRUtility.parseDomainUnion(paramVars, indices, constraints);
		
//		System.out.println("The final domain: " + domain);
		
		return domain;
	}
	
	/**
	 * Computes ({k} \times dom), dom being a domain of syst
	 * scalVar is the dimension to be included in the first position (scalar dimension)
	 * 
	 * @param dom
	 * @param syst
	 * @param k
	 * @return
	 */
	public static Domain addkFirstDim(Domain dom, AffineSystem syst, int k, Variable scalVar) {
		
		// We get the new variables for the future domain
		List<Variable> domInds = dom.getIndices();
		List<Variable> nlInds = new BasicEList<Variable>();
		nlInds.add(scalVar);
		for (Variable var: domInds)
			nlInds.add(var);
		
		// We get the new constraints for the future domain
		List<IntConstraintSystem> domllConstr = dom.getPMdomain().getPolyhedra();
		IntConstraint constr = IntExpressionBuilder.constraint(
				IntExpressionBuilder.affine(scalVar), IntExpressionBuilder.constant(k), ComparisonOperator.EQ);
		List<IntConstraintSystem> nllConstr = new BasicEList<IntConstraintSystem>();
		for (IntConstraintSystem constSyst : domllConstr) {
			IntConstraintSystem nconstSyst = constSyst.copy();
			nconstSyst.getConstraints().add(constr);
			nllConstr.add(nconstSyst);
		}
		
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(dom.getParams(), nlInds, nllConstr);
	}
	
	/**
	 * Add nZeroDim "{0}" dimensions at the beginning of dom
	 * Manage the case where dom=null (~ quickly-implemented empty domain)
	 * 
	 * @param dom
	 * @param syst
	 * @param nZeroDim
	 * @param lVarRes
	 * @return
	 */
	public static Domain addZeroDims(Domain dom, AffineSystem syst, int nZeroDim, List<Variable> lVarRes) {
		
		// New variables list of the future domain
		List<Variable> nlInds = new BasicEList<Variable>();
		for (Variable var : lVarRes)
			nlInds.add(var);
		
		// Constraints to add to the current polyhedra
		List<IntConstraint> lConstrToBeAdded = new BasicEList<IntConstraint>();
		for (int i=0; i<nZeroDim; i++)
			lConstrToBeAdded.add(IntExpressionBuilder.constraint(
					IntExpressionBuilder.affine(lVarRes.get(i)), IntExpressionBuilder.constant(0), ComparisonOperator.EQ));
		
		// Getting the constraints of the polyhedra
		List<IntConstraintSystem> domllConstr;
		if (dom==null) {
			domllConstr = new BasicEList<IntConstraintSystem>();
			domllConstr.add(IntExpressionBuilder.constraintSystem());
		} else
			domllConstr = dom.getPMdomain().getPolyhedra();
		
		List<IntConstraintSystem> nllConstr = new BasicEList<IntConstraintSystem>();
		for (IntConstraintSystem contrSyst : domllConstr) {
			IntConstraintSystem nconstrSyst = contrSyst.copy();
			nconstrSyst.getConstraints().addAll(lConstrToBeAdded);
			nllConstr.add(nconstrSyst);
		}
		
		Domain domRet = PolyhedralIRUserFactory.eINSTANCE.createDomain(syst.getParameters().getParams(), nlInds, nllConstr);
		return domRet;
	}
	
	
} // Domain Operations
