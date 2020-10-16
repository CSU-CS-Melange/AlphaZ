package org.polymodel.polyhedralIR.factory;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.DimensionsManager;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.OutputDimension;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.util.PolymodelRegexParser;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.WhileInfo;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;

/**
 * This class contains static methods for creating various objects for
 * PolyhedralIR. The methods in this class and those in PolyhedralIRUserFactory
 * is distinguished by putting all methods that does more than a factory (such
 * as parsing) into this class.
 * 
 * Read comments on the following methods before adding additional methods for
 * parsing: - parseConstraints - parseFunctionString
 * 
 * @author yuki
 * 
 */
public class PolyhedralIRUtility {
	//
//	protected static PolymodelParser parser = new PolymodelParser();

	// public static DimensionsManager manager =
	// PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
	protected static final DimensionsManager mainDims = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
	protected static final PolymodelDefaultFactory polyFact = PolyhedralIRUserFactory._polyFact;

	private static String toStringList(List<String> list, String separator) {
		StringBuffer buffer = new StringBuffer();

		boolean first = true;
		for (String str : list) {
			if (!first)
				buffer.append(separator);
			buffer.append(str);
			first = false;
		}

		return buffer.toString();
	}

	private static String toISLString(List<String> params, List<String> ids, List<String> constraints) {
		StringBuffer sb = new StringBuffer();

		// params
		sb.append("[");
		sb.append(toStringList(params, ","));
		sb.append("]->{");
		// indices
		sb.append("[");
		sb.append(toStringList(ids, ","));
		sb.append("]");
		sb.append(" : ");
		// constraints
		sb.append(toStringList(constraints, " and "));
		sb.append("}");

		return sb.toString();
	}

	/**
	 * Method that should be used to parse all constraints used for AlphaZ so
	 * that dimensions are handled correctly. The DimensionsManager keeps track
	 * of all dimensions as the x-th dimension for each parameter and indices.
	 * Although each dimensions can have different names, the manager only keeps
	 * track of the first name given. Thus, for correct use of parsing, a new
	 * dimension manager should be created for each set of names, and then later
	 * replaced with the variables that corresponds to the common dimension.
	 * 
	 * @param params
	 * @param ids
	 * @param constraints
	 * @return
	 */
	private static IntConstraintSystem parseConstraintsAndMapToMainDimensions(List<String> params, List<String> ids, List<String> constraints) {
		List<String> ppconsts = new ArrayList<String>(constraints.size());
		for (String constraint : constraints) {
			ppconsts.addAll(constraintPreProcessing(constraint));
		}

		// Since the parse is not at all working, using ILS
		String ISLstr = toISLString(params, ids, ppconsts);

		List<Variable> parameters = new ArrayList<Variable>(params.size());
		List<Variable> indices = new ArrayList<Variable>(ids.size());

		for (int d = 0; d < params.size(); d++) {
			// Also add any new params/variables to the main space
			parameters.add(mainDims.getParameter(d, params.get(d)));
		}
		// same for indices
		for (int d = 0; d < ids.size(); d++) {
			indices.add(mainDims.getDimension(d, ids.get(d)));
		}
		ISLSet set = ISLNativeBinder.createSetFromIslString(ISLstr, indices, parameters);
		if (set.getPolyhedra().size() > 1)
			throw new RuntimeException("ISL returned union of sets for a single polyhedron.");

		IntConstraintSystem system = (set.getPolyhedra().size() == 0) ? IntExpressionBuilder.constraintSystem() : set.getPolyhedra().get(0);

		// //then substitute all parsed variables with that of the main
		// dimensions
		// for (int d = 0; d < dm.getParameters().size(); d++) {
		// system = system.substitute(dm.getParameter(d),
		// mainDims.getParameter(d));
		// }
		// for (int d = 0; d < dm.getDimensions().size(); d++) {
		// system = system.substitute(dm.getDimension(d),
		// mainDims.getDimension(d));
		// }

		// IntConstraintSystem system = IntExpressionBuilder.constraintSystem();
		//
		//
		// List<Variable> vars = new
		// ArrayList<Variable>(dm.getDimensions().size()+dm.getParameters().size());
		// vars.addAll(dm.getParameters());
		// vars.addAll(dm.getDimensions());
		//
		// //parse constraints using the new dimensions, so that the names match
		// for (String constraint : constraints) {
		// for (String ppconst : constraintPreProcessing(constraint)) {
		// System.out.println(ppconst);
		// system.getConstraints().add(parser.parseConstraint(ppconst, vars));
		// }
		// }
		//
		// // for (IntConstraint constraint : system.getConstraints()) {
		// // for (AffineTerm term :
		// constraint.simplify().getRhs().toAffine().getTerms()) {
		// // Variable v = term.getVariable();
		// // if (v != null) {
		// // System.out.println(v + " " + dm.getDimensions().indexOf(v));
		// // System.out.println(v + " " + mainDims.getDimensions().indexOf(v));
		// // }
		// // }
		// // }

		return system;
	}

	/**
	 * Moves all indices in the given domain to parameters
	 * 
	 * @param domain
	 * @return
	 */
	public static org.polymodel.Domain toParameters(org.polymodel.Domain domain) {
		Map<Variable, Variable> varToParamMap = new HashMap<Variable, Variable>();

		List<Variable> newParams = new ArrayList<Variable>(domain.getNbParams() + domain.getNbIndices());
		newParams.addAll(domain.getParams());

		int pIndex = domain.getNbParams();
		for (Variable v : domain.getDimensions().getIndices()) {
			Variable param = mainDims.getParameter(pIndex, v.getName());
			varToParamMap.put(v, param);
			newParams.add(param);
			pIndex++;
		}

		org.polymodel.Domain newDom = polyFact.createDomain(new ArrayList<Variable>(), newParams);
		for (IntConstraintSystem poly : domain.getPolyhedra()) {
			IntConstraintSystem p = poly.copy();
			for (Variable key : varToParamMap.keySet()) {
				p = p.substitute(key, varToParamMap.get(key));
			}
			newDom.getPolyhedra().add(p);
		}

		return newDom;
	}

	private static org.polymodel.Domain polymodelDomain(List<String> params, List<String> ids, List<String> constraints) {

		// Constraints
		IntConstraintSystem system = parseConstraintsAndMapToMainDimensions(params, ids, constraints);

		// Params
		List<Variable> parameters = new ArrayList<Variable>(ids.size());
		for (int i = 0; i < params.size(); i++) {
			parameters.add(mainDims.getParameter(i, params.get(i)));
		}

		// Indices
		List<Variable> vars = new ArrayList<Variable>(ids.size());
		for (int i = 0; i < ids.size(); i++) {
			vars.add(mainDims.getDimension(i, ids.get(i)));
		}
		DomainDimensions dims = polyFact.createDomainDimensions(vars, parameters);

		return polyFact.createDomain(dims, system);
	}

	private static org.polymodel.Domain polymodelDomainUnion(List<String> params, List<List<String>> ids, List<List<String>> constraints) {

		if (ids.size() != constraints.size()) {
			throw new RuntimeException("ids.size() != constraints.size() : for parsing unions, indices and constraints must be given for each polyhedron.");
		}

		List<IntConstraintSystem> polyhedra = new ArrayList<IntConstraintSystem>(ids.size());
		// Constraints
		for (int p = 0; p < ids.size(); p++) {
			IntConstraintSystem system = parseConstraintsAndMapToMainDimensions(params, ids.get(p), constraints.get(p));
			polyhedra.add(system);
		}
		
		// Params
		List<Variable> parameters = new ArrayList<Variable>(ids.size());
		for (int i = 0; i < params.size(); i++) {
			parameters.add(mainDims.getParameter(i, params.get(i)));
		}

		// Indices
		List<Variable> vars = new ArrayList<Variable>(ids.size());
		if (ids.size() > 0) {
			for (int i = 0; i < ids.get(0).size(); i++) {
				vars.add(mainDims.getDimension(i, ids.get(0).get(i)));
			}
		}
		DomainDimensions dims = polyFact.createDomainDimensions(vars, parameters);

		return polyFact.createDomain(dims, polyhedra);
	}

	private static org.polymodel.Domain polymodelDomain(ParameterDomain param, List<String> ids, List<String> constraints) {
		List<String> params = new ArrayList<String>();
		if (param != null) {
			params.addAll(param.getParamNames());
		}

		org.polymodel.Domain dom = polymodelDomain(params, ids, constraints);

		// Add all indices of the parsed domain into the parameters
		org.polymodel.Domain exParam = EcoreUtil.copy(param.getPMdomain());
		for (int d = 0; d < dom.getNbIndices(); d++) {
			exParam.getDimensions().getIndices().add(mainDims.getDimension(d));
		}
		// take intersection
		return dom.intersection(exParam);
	}

	private static org.polymodel.Domain polymodelDomainUnion(ParameterDomain param, List<List<String>> ids, List<List<String>> constraints) {
		List<String> params = new ArrayList<String>();
		if (param != null) {
			params.addAll(param.getParamNames());
		}

		org.polymodel.Domain dom = polymodelDomainUnion(params, ids, constraints);

		// When parameter domain is given, take intersection
		if (param != null) {
			// Add all indices of the parsed domain into the parameters
			org.polymodel.Domain exParam = EcoreUtil.copy(param.getPMdomain());
			for (int d = 0; d < dom.getNbIndices(); d++) {
				exParam.getDimensions().getIndices().add(mainDims.getDimension(d));
			}
			return dom.intersection(exParam);
		} else {
			return dom;
		}
	}

	// public static IntConstraintSystem createIntConstraintSystem(List<String>
	// ids, List<String> constraints) {
	// List<Variable> vars = new ArrayList<Variable>(ids.size());
	// for (int i = 0; i < ids.size(); i++) {
	// vars.add(PolyhedralIRUserFactory.manager.getDimension(i, ids.get(0)));
	// }
	//
	// IntConstraintSystem system = IntExpressionBuilder.constraintSystem();
	// for (String c : constraints) {
	// system.getConstraints().add(parser.parseConstraint(c, vars));
	// }
	//
	// return system;
	// }

	public static ParameterDomain parseParameterDomain(String alphabetsSyntax) {
		List<List<List<String>>> parsed = parseAlphabetsDomain(alphabetsSyntax);

		List<List<String>> ids = parsed.get(0);
		List<List<String>> constraints = parsed.get(1);

		if (parsed.size() != 2)
			throw new RuntimeException("Invalid domain in alphabets syntax : " + alphabetsSyntax);

		// Create list of empty lists, for no indices
		List<List<String>> indices = new ArrayList<List<String>>(ids.size());
		for (int i = 0; i < ids.size(); i++) {
			indices.add(new ArrayList<String>(0));
		}

		return PolyhedralIRUserFactory.eINSTANCE.createParameterDomain(polymodelDomainUnion(ids.get(0), indices, constraints));
	}

	public static ParameterDomain parseParameterDomain(final List<String> ids, final List<String> constraints) {
		return parseParameterDomainUnion(new ArrayList<List<String>>() { {add(ids);} }, new ArrayList<List<String>>() { {add(constraints);} });
	}
	
	public static ParameterDomain parseParameterDomainUnion(List<List<String>> ids, List<List<String>> constraints) {

		// Create list of empty lists, for no indices
		List<List<String>> indices = new ArrayList<List<String>>(ids.size());
		for (int i = 0; i < ids.size(); i++) {
			indices.add(new ArrayList<String>(0));
		}

		return PolyhedralIRUserFactory.eINSTANCE.createParameterDomain(polymodelDomainUnion(ids.get(0), indices, constraints));
	}

	public static Domain parseDomain(String alphabetsSyntax) {
		return parseDomain((ParameterDomain) null, alphabetsSyntax);
	}

	/**
	 * Creates a domain in the context of given parameter domain, assuming the
	 * given String is a domain in alphabets syntax.
	 * 
	 * @param parameterDomain
	 * @param alphabetsSyntax
	 * @return
	 */
	public static Domain parseDomain(ParameterDomain parameterDomain, String alphabetsSyntax) {
		List<List<List<String>>> parsed = parseAlphabetsDomain(alphabetsSyntax);

		List<List<String>> ids = parsed.get(0);
		List<List<String>> constraints = parsed.get(1);

		if (parsed.size() != 2)
			throw new RuntimeException("Invalid domain in alphabets syntax : " + alphabetsSyntax);

		return PolyhedralIRUserFactory.eINSTANCE.createDomain(polymodelDomainUnion(parameterDomain, ids, constraints));
	}

	public static Domain parseDomain(List<String> params, String alphabetsSyntax) {
		List<List<List<String>>> parsed = parseAlphabetsDomain(alphabetsSyntax);

		List<List<String>> ids = parsed.get(0);
		List<List<String>> constraints = parsed.get(1);

		if (parsed.size() != 2)
			throw new RuntimeException("Invalid domain in alphabets syntax : " + alphabetsSyntax);

		return PolyhedralIRUserFactory.eINSTANCE.createDomain(polymodelDomainUnion(params, ids, constraints));
	}

	public static Domain parseDomainFromString(ParameterDomain parameterDomain, final List<String> indices, final List<String> constraintList) {
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(polymodelDomain(parameterDomain, indices, constraintList));
	}

	public static Domain parseDomainUnionFromString(ParameterDomain parameterDomain, List<List<String>> indices, List<List<String>> constraintList) {
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(polymodelDomainUnion(parameterDomain, indices, constraintList));
	}

	public static Domain parseDomain(List<Variable> params, List<Variable> indices, final List<String> constraintList) {
		return parseDomainUnion(params, indices, new ArrayList<List<String>>(1) {
			{
				add(constraintList);
			}
		});
	}

	public static Domain parseDomainFromString(List<String> params, final List<String> indices, final List<String> constraintList) {
		return parseDomainUnionFromString(params, new ArrayList<List<String>>(1) {
			{
				add(indices);
			}
		}, new ArrayList<List<String>>(1) {
			{
				add(constraintList);
			}
		});
	}

	public static Domain parseDomainUnionFromString(List<String> params, List<List<String>> indices, List<List<String>> constraintList) {
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(polymodelDomainUnion(params, indices, constraintList));
	}

	public static Domain parseDomainUnion(List<Variable> params, List<Variable> indices, List<List<String>> constraintList) {

		List<String> parameters = new ArrayList<String>(params.size());
		List<List<String>> ids = new ArrayList<List<String>>(constraintList.size());

		// Convert params and indices to Strings
		for (int i = 0; i < constraintList.size(); i++) {
			ids.add(new ArrayList<String>(indices.size()));
		}

		for (Variable p : params) {
			parameters.add(p.getName());
		}

		for (Variable v : indices) {
			for (int i = 0; i < constraintList.size(); i++) {
				ids.get(i).add(v.getName());
			}
		}
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(polymodelDomainUnion(parameters, ids, constraintList));
	}

	/**
	 * Helper function for handling domains in alphabets syntax. The output of
	 * this function is a list of List<List<String>>, index 0 is for ids and 1
	 * is for constraints, of unions of domains. It is List<List<String>>
	 * because each element of this double-list is set of ids/constraints for a
	 * polyhedron.
	 * 
	 * @param alphabetsSyntax
	 * @return
	 */
	private static List<List<List<String>>> parseAlphabetsDomain(String alphabetsSyntax) {
		alphabetsSyntax = alphabetsSyntax.replaceAll("\\s+", "");

		// Simple check with regex that it is not something that is definitely
		// not alphabets syntax. This check does not check for detailed syntax
		// error.
		// String lhs = "([\\w\\d\\-]+(,[\\w\\d\\-]+)*)?";
		// String rhs = "([\\w\\d\\&<>=,\\-\\(\\)]+)*";

		// if
		// (!alphabetsSyntax.matches("\\{"+lhs+"\\|"+rhs+"\\}(\\|\\|\\{"+lhs+"\\|"+rhs+"\\})*"))
		// {
		// throw new
		// RuntimeException("Not a valid domain in alphabets syntax."); TODO
		// }

		String[] unions = alphabetsSyntax.split("\\|\\|");

		List<List<String>> ids = new LinkedList<List<String>>();
		List<List<String>> constraints = new LinkedList<List<String>>();

		for (String dom : unions) {
			String[] sides = dom.split("\\|");
			if (sides.length != 2) {
				throw new RuntimeException(dom + " is not a valid alphabets domain.");
			}
			String[] id = sides[0].replaceAll("\\{", "").split(",");
			String[] constraint = sides[1].replaceAll("\\}", "").split("&&");

			// When there are no indices
			if (id[0].length() == 0 && id.length == 1) {
				ids.add(new Vector<String>());
			} else {
				ids.add(Arrays.asList(id));
			}

			// When there are no constraints
			if (constraint[0].length() == 0 && constraint.length == 1) {
				constraints.add(new Vector<String>());
			} else {
				constraints.add(Arrays.asList(constraint));
			}
		}

		List<List<List<String>>> res = new LinkedList<List<List<String>>>();

		res.add(ids);
		res.add(constraints);

		return res;
	}

	//
	// /**
	// * Creates a domain object, assuming this is the parameter domain.
	// *
	// * @param ids
	// * @param constraints
	// * @return
	// */
	// public ParameterDomain createParameterDomain(List<String> ids,
	// List<String> constraints) {
	// //Pre-process each constraint
	// List<String> ppconsts = new LinkedList<String>();
	// for (String constraint : constraints) {
	// for (String con : constraintPreProcessing(constraint)) {
	// ppconsts.add(con);
	// }
	// }
	//
	// ParameterDomain domain = fact.createParameterDomain();
	// domain.setPMdomain(PolyhedralIRUtility.polyhedralDomainFromString(ids,
	// ppconsts));
	// return domain;
	// }
	//
	//
	//
	// private org.polymodel.Domain parseDomain(List<String> params,
	// List<List<String>> ids, List<List<String>> constraints) {
	// //Check size consistency
	// if (ids.size() != constraints.size()) {
	// throw new
	// RuntimeException("Expecting the number of ids and constraints to be the same.");
	// }
	//
	// //Create one as a single domain
	// // ParameterDomain domain = createParameterDomain(ids.get(0),
	// constraints.get(0));
	//
	// //parameters
	// List<Variable> parameters = new ArrayList<Variable>(params.size());
	// for (int i = 0; i < params.size(); i++) {
	// parameters.add(manager.getParameter(i, params.get(i)));
	// }
	//
	// for (int i = 0; i < ids.size(); i++) {
	// List<Variable> indices = new ArrayList<Variable>(ids.get(i).size());
	// for (int d = 0; d < ids.get(i).size(); i++) {
	// indices.add(manager.getDimension(i,ids.get(i).get(d)));
	// }
	// // parse constraints
	// List<Variable> vars = new ArrayList<Variable>(parameters.size() +
	// indices.size());
	// vars.addAll(parameters); vars.addAll(indices);
	//
	// IntConstraintSystem system = IntExpressionBuilder.constraintSystem();
	// for (String constraint : constraints.get(i)) {
	// system.getConstraints().add(parser.parseConstraint(constraint, vars));
	// }
	// // parser.p
	// // DomainDimensions dim = polyFact.createDomainDimensions(dimensions,
	// parameters);
	// // parser.p
	// }
	//
	// // //Take union
	// // for (int i = 1; i < ids.size(); i++) {
	// //
	// //domain.getPMdomain().getPolyhedra().addAll(createParameterDomain(ids.get(i),
	// constraints.get(i)).getPMdomain().getPolyhedra());
	// //
	// domain.setPMdomain(domain.getPMdomain().union(createParameterDomain(ids.get(i),
	// constraints.get(i)).getPMdomain()));
	// // }
	//
	// return domain;
	// }

	//
	// /**
	// * @param pd
	// * @return
	// */
	// public Domain createDomain(org.polymodel.Domain pd) {
	// Domain domain = fact.createDomain();
	// domain.setPMdomain(pd);
	// return domain;
	// }
	//
	// /**
	// * Creates a domain object using the given constraints and the surrounding
	// domain.
	// * Dimensions of surrounding domains are added to the lower dimensions.
	// *
	// * @param parameterDomain
	// * @param newIds new indices introduced in this domain
	// * @param constraints
	// * @return
	// */
	// public Domain createDomain(ParameterDomain parameterDomain, List<String>
	// newIds, List<String> constraints) {
	//
	// List<List<String>> consts = new LinkedList<List<String>>();
	//
	// //Constraints on the parameter
	// if (parameterDomain != null) {
	// //Parameter domain may be union on its own
	// for (IntConstraintSystem ilcs :
	// parameterDomain.getPMdomain().getPolyhedra()) {
	// List<String> pconsts = new LinkedList<String>();
	// for (IntConstraint ilc : ilcs.getConstraints()) {
	// pconsts.add(AlgebraPrettyPrinter.print(ilc, OUTPUT_FORMAT.ALPHABETS));
	// }
	// consts.add(pconsts);
	// }
	// }
	// //Pre-process each constraint
	// List<String> ppconsts = new LinkedList<String>();
	// for (String constraint : constraints) {
	// for (String con : constraintPreProcessing(constraint)) {
	// ppconsts.add(con);
	// }
	// }
	//
	// //When parameter domain was not given
	// if (consts.size() == 0) {
	// consts.add(ppconsts);
	// } else {
	// //Add constrains for this domain to each polyhedron consisting the
	// parameter domain
	// for (List<String> pconsts : consts) {
	// pconsts.addAll(ppconsts);
	// }
	// }
	//
	// //Construct the full id-list
	// List<String> params = new LinkedList<String>();
	// if (parameterDomain != null) {
	// for (Variable p : parameterDomain.getParams()) {
	// params.add(p.toString());
	// }
	// }
	//
	// Domain domain = fact.createDomain();
	// org.polymodel.Domain pmDomain =
	// _polyFact.polyhedralDomainUnionFromString(params, newIds, consts);
	// domain.setPMdomain(pmDomain);
	//
	// return domain;
	// }
	//
	// /**
	// * Creates an polyhedra surrounded by outerDomain, and new indices and
	// constraints for each polyhedron given as a list of Strings
	// * This method calls createDomain for each polyhedron, and takes the union
	// in the end.
	// *
	// * @param outerDomain
	// * @param newIds
	// * @param constraints
	// * @return
	// */
	// public Domain createDomainUnion(ParameterDomain parameterDomain,
	// List<List<String>> newIds, List<List<String>> constraints) {
	//
	// //Check size consistency
	// if (newIds.size() != constraints.size()) {
	// throw new
	// RuntimeException("Expecting the number of ids and constraints to be the same.");
	// }
	// //Create one as a single domain
	// Domain domain = createDomain(parameterDomain, newIds.get(0),
	// constraints.get(0));
	//
	// //Take union
	// for (int i = 1; i < newIds.size(); i++) {
	// domain = domain.union(createDomain(parameterDomain, newIds.get(i),
	// constraints.get(i)));
	// }
	//
	// return domain;
	// }
	//

	/**
	 * Normalizes constraints given to a form that is accepted by polymodel
	 * factory.
	 * 
	 * @param constr
	 * @return
	 */
	private static List<String> constraintPreProcessing(String constr) {
		// Replace constraints such as (0<=(i,j)<N) with (0<=i<N && 0<=j<N)
		constr = constr.replaceAll("\\s*", "");
		if (constr.contains("!=")) {
			throw new RuntimeException("Expecting <,<=,>,>=,== for constraints.");
		}
		// First pass
		{
			Pattern pattern = Pattern.compile("([^\\(\\)]*)\\(((?:[^,]+)(?:,(?:[^,]+))+)\\)([^\\(\\)]*)");
			Matcher matcher = pattern.matcher(constr);
			if (matcher.matches()) {
				// Separate out the constraints for each middle indices
				String[] mis = matcher.group(2).split(",");
				// check if it is not (A)
				if (mis.length > 1) {
					// Create replacement string
					StringBuffer replacement = new StringBuffer();
					for (String mi : mis) {
						if (replacement.length() > 0) {
							replacement.append(" && ");
						}
						replacement.append("$1" + mi + "$3");
					}
					constr = matcher.replaceAll(replacement.toString());
				}
			}
			// Replace constraints such as (0<=i<N) with (0<=i && i<N)
			pattern = Pattern.compile("(.*)([^=<>\\s]+)(<|<=|>|>=|==)([^=<>\\s]+)(<|<=|>|>=|==)([^=<>\\s]+)(.*)");
			do {
				matcher = pattern.matcher(constr);
				constr = matcher.replaceAll("$1$2$3$4 && $4$5$6$7");
			} while (matcher.matches());
		}

		String[] newConstrs = constr.replaceAll("==", "=").split("\\s*&&\\s*");

		// Currently, the parser do not handle (a >= b); when the full
		// expression is surrounded by parenthesis
		List<String> processed = new ArrayList<String>();

		// Process again to remove the parenthesis
		for (String c : newConstrs) {
			processed.add(c);
			// Matcher matcherP = Pattern.compile("\\(([^()]+)\\)").matcher(c);
			// if (matcherP.matches()) {
			// processed.add(matcherP.group(1));
			// } else {
			// processed.add(c);
			// }
		}

		return processed;
	}

	public static Domain createEmptyDomain(List<Variable> params, List<Variable> indices) {
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(polyFact.createDomain(indices, params,
				IntExpressionBuilder.constraintSystem(constraint(affine(term(1)), affine(term(0)), ComparisonOperator.EQ))));
	}

	public static Domain createUniverseDomain(List<Variable> params, List<Variable> indices) {
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(polyFact.createDomain(indices, params, IntExpressionBuilder.constraintSystem()));
	}
	
	/**
	 * Converts matrix back to polyhedral constraints.
	 * 
	 * @param row
	 * @param params
	 * @param indices
	 */
	public static IntConstraint toConstraint(MatrixRow row, List<Variable> params, List<Variable> indices) {

		AffineExpression expr = IntExpressionBuilder.affine();
		for (int i = 1; i < row.getSize() - 1; i++) {
			if (i - 1 < params.size()) {
				expr.getTerms().add(IntExpressionBuilder.term(row.get(i), params.get(i - 1)));
			} else {
				expr.getTerms().add(IntExpressionBuilder.term(row.get(i), indices.get(i - 1 - params.size())));
			}
		}
		// constant
		expr.getTerms().add(IntExpressionBuilder.term(row.get(row.getSize() - 1)));

		// polylib format
		ComparisonOperator op = ComparisonOperator.GE;
		if (row.get(0) == 0)
			op = ComparisonOperator.EQ;
		
		return IntExpressionBuilder.constraint(expr, affine(term(0)), op);
	}

	/**
	 * Checks if a given string matches alphabets syntax for affine functions.
	 * The check is not complete, because it is sufficient to be able to
	 * distinguish between different syntax for expressing functions. (i.e., ISL
	 * format)
	 * 
	 * @param func
	 * @return
	 */
	private static boolean checkAlphabetsFunction(String func) {
		func = func.replaceAll("\\s+", "");
		// Simple check with regex that it is not something that is definitely
		// not alphabets syntax. This check does not check for detailed syntax
		// error.
		String lhs = "([\\w\\d]+(,[\\w\\d]+)*)?";
		String rhs = "([\\w\\d\\-\\+]+(,[\\w\\d\\-\\+]+)*)?";

		return func.matches("\\(" + lhs + "\\->" + rhs + "\\)");
	}

	/**
	 * Parses function in alphabets syntax, and returns two 1D-arrays as using a
	 * 2D-array. The first array is the list of indices, and the second array is
	 * the list of expressions.
	 * 
	 * @param func
	 * @return
	 */
	private static String[][] parseAlphabetsFunction(String func) {
		func = func.replaceAll("\\s+", "");

		String[] sides = func.replaceAll("\\(|\\)", "").split("\\->");

		String[] indices = new String[0];
		String[] exprs = new String[0];

		// Parse indices and expressions checking for some special cases (when
		// lhs/rhs is null)
		if (sides.length == 2) {
			indices = sides[0].split(",");
			exprs = sides[1].split(",");
		} else if (func.matches("\\(.+\\->\\)")) {
			indices = func.replaceAll("\\(|\\)|\\->", "").split(",");
		} else if (func.matches("\\(\\->.+\\)")) {
			exprs = func.replaceAll("\\(|\\)|\\->", "").split(",");
		} else if (!func.matches("\\(\\->\\)")) {
			throw new RuntimeException("Not a valid function in alphabets syntax : " + func);
		}

		if (indices.length == 1 && indices[0].length() == 0)
			indices = new String[0];

		return new String[][] { indices, exprs };
	}

	/**
	 * Creates and AffineFunction in the context of given parameter domain, by
	 * parsing the given String as alphabets syntax.
	 * 
	 * @param parameterDomain
	 * @param alphabetsSyntax
	 * @return
	 */
	public static AffineFunction parseAffineFunction(ParameterDomain parameterDomain, String alphabetsSyntax) {
		alphabetsSyntax = alphabetsSyntax.replaceAll("\\s+", "");

		// Simple check with regex that it is not something that is definitely
		// not alphabets syntax. This check does not check for detailed syntax
		// error.
		if (!checkAlphabetsFunction(alphabetsSyntax)) {
			throw new RuntimeException("Not a valid function in alphabets syntax : " + alphabetsSyntax);
		}

		String[][] parsed = parseAlphabetsFunction(alphabetsSyntax);
		String[] indices = parsed[0];
		String[] exprs = parsed[1];

		List<String> params = new LinkedList<String>();
		if (parameterDomain != null) {
			for (Variable p : parameterDomain.getParams()) {
				params.add(p.toString());
			}
		}

		return parseAffineFunction(parameterDomain, Arrays.asList(indices), Arrays.asList(exprs));

	}

	/**
	 * Creates an AffineFunction in the context of the given parameter domain,
	 * that uses the specified list of indices.
	 * 
	 * @param parameterDomain
	 * @param indices
	 * @param exprs
	 * @return
	 */
	public static AffineFunction parseAffineFunction(ParameterDomain parameterDomain, List<String> indices, List<String> exprs) {
		List<String> params = new LinkedList<String>();
		for (Variable p : parameterDomain.getParams()) {
			params.add(p.toString());
		}
		
		AffineFunction func = parseAffineFunctionFromString(params, indices, exprs);
		return func;
	}

	public static AffineFunction parseAffineFunctionFromString(List<String> params, List<String> indices, List<String> exprs) {
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(parseFunctionString(params, indices, exprs));
	}

	public static AffineFunction parseAffineFunction(List<Variable> params, List<Variable> indices, List<String> exprs) {
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(parseFunction(params, indices, exprs));
	}

	/**
	 * Creates an AffineFunction where the RHS is a list of expressions in
	 * String, using specified parameters and indices.
	 * 
	 * @param params
	 * @param indices
	 * @param exprs
	 * @return
	 */
	public static Function parseFunction(List<Variable> params, List<Variable> indices, List<String> exprs) {
		List<OutputDimension> outDims = new ArrayList<OutputDimension>(exprs.size());
		for (int i = 0; i < Math.min(exprs.size(), indices.size()); i++) {
			outDims.add(mainDims.getOutputDimension(indices.get(i)));
		}
		for (int i = indices.size(); i < exprs.size(); i++) {
			outDims.add(mainDims.getOutputDimension(mainDims.getDimension(i)));
		}
		
		List<IntExpression> intExprs = new ArrayList<IntExpression>(exprs.size());
		for (int i = 0 ; i < exprs.size(); i++) {
			intExprs.add(PolymodelRegexParser.parseAffineExpression(exprs.get(i), params, indices).simplify());
		}
		
		Function f =  polyFact.createFunction(indices, outDims, params, intExprs);
		return f;
	}

	/**
	 * When parsing functions from pure String, similar care as in
	 * parseConstraints must be taken for handling DimensionsManager.
	 * 
	 * @param params
	 * @param indices
	 * @param exprs
	 * @return
	 */
	private static Function parseFunctionString(List<String> params, List<String> indices, List<String> exprs) {
		List<Variable> parameters = new ArrayList<Variable>(params.size());
		for (int d = 0; d < params.size(); d++) {
			parameters.add(mainDims.getParameter(d, params.get(d)));
		}
		List<Variable> ids = new ArrayList<Variable>(indices.size());
		for (int d = 0; d < indices.size(); d++) {
			Variable vard = mainDims.getDimension(d, indices.get(d));
			vard.setName(indices.get(d));
			ids.add(vard);
		}
		
		return parseFunction(parameters, ids, exprs);
	}

	/**
	 * Creates an identity function from a domain, that maps all indices to the
	 * same space. Parameters are not used in the function.
	 * 
	 * @param domain
	 * @return
	 */
	public static AffineFunction createIdentityFunction(Domain domain) {
		List<String> exprs = new LinkedList<String>();
		for (Variable iv : domain.getIndices()) {
			exprs.add(iv.toString());
		}
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(parseFunction(domain.getParams(), domain.getIndices(), exprs));
	}

	/**
	 * Creates an identity function using the given indices. Indentity of the parameters are implicit.
	 * 
	 */
	public static AffineFunction createIdentityFunction(List<Variable> params, List<Variable> indices) {
		List<AffineExpression> exprs = new LinkedList<AffineExpression>();
		for (Variable iv : indices) {
			exprs.add(affine(term(iv)));
		}
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(params, indices, exprs);
	}
	

	public static AffineFunction createUniformFunction(List<Variable> params, List<Variable> indices, int[] constants) {
		if (indices.size() != constants.length) {
			throw new IllegalArgumentException("Number of indices do not match the constant part.");
		}
		
		List<AffineExpression> exprs = new ArrayList<AffineExpression>(constants.length);
		for (int i = 0; i < indices.size(); i++) {
			exprs.add(affine(term(indices.get(i)), term(constants[i])));
		}

		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(params, indices, exprs);
	}
	
	public static AffineFunction createUniformFunction(List<Variable> params, List<Variable> indices, long[] constants) {
		if (indices.size() != constants.length) {
			throw new IllegalArgumentException("Number of indices do not match the constant part.");
		}
		
		List<AffineExpression> exprs = new ArrayList<AffineExpression>(constants.length);
		for (int i = 0; i < indices.size(); i++) {
			exprs.add(affine(term(indices.get(i)), term(constants[i])));
		}

		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(params, indices, exprs);
	}

	public static AffineFunction createUniformFunction(Domain domain, int[] constants) {
		if (domain.getNIndices() != constants.length) {
			throw new RuntimeException("Size of given int vector does not match the number of indices.");
		}

		return createUniformFunction(domain.getParams(), domain.getIndices(), constants);
	}
	
	public static AffineFunction createUniformFunction(Domain domain, List<Long> constants) {
		return createUniformFunction(domain.getParams(), domain.getIndices(), constants);
	}

	public static AffineFunction createUniformFunction(List<Variable> params, List<Variable> indices, List<Long> constants) {
		long[] array = new long[constants.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = constants.get(i);
		}
		return createUniformFunction(params, indices, array);
	}

	public static AffineFunction createUniformFunction(Domain domain, String intVec) {
		intVec = intVec.trim();
		intVec = intVec.replaceAll("^\\(|\\)$|\t", "");
		String[] consts = intVec.split("\\s*,\\s*");
		int[] constants = new int[consts.length];

		for (int i = 0; i < consts.length; i++) {
			constants[i] = Integer.parseInt(consts[i]);
		}

		return createUniformFunction(domain, constants);
	}
	
	public static AffineFunction createProjection(Domain domain, List<Variable> projectionTargets) {
		List<AffineExpression> exprs = new ArrayList<AffineExpression>(projectionTargets.size());
		for (Variable v : projectionTargets) {
			assert(domain.getIndices().contains(v));
			
			exprs.add(affine(term(v)));
		}
		
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(domain.getParams(), domain.getIndices(), exprs);
	}
	
	public static WhileInfo createWhileInfo() {
		return PolyhedralIRFactory.eINSTANCE.createWhileInfo();
	}
	
	public static Boolean isReductionsWithScheduledBody(Equation eqn) {
	    if (eqn  instanceof StandardEquation) {
	      StandardEquation eq = (StandardEquation)eqn;
	      String varName = eq.getVariable().getName();
	      return eq.getContainerSystem().containsVariable(varName + "_Alpha_Init");
	    }
	    return false;
	  }
}
