package fr.irisa.cairn.jnimap.isl.jni;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class JNIISLTools {

	/**
	 * Wraps a block of code executing ISL operations with calls to recordStart and
	 * End. The record methods are used to capture ISL outputs to stderr. Calling
	 * ISL operations through this wrapper allows the exceptions to be thrown with
	 * meaningful error messages from ISL.
	 * 
	 * @param r
	 * @param f
	 * @throws ISLErrorException
	 */
	public static void recordError(Runnable r, Function<String, ISLErrorException> f) throws ISLErrorException {
		try {
			JNIISLContext.recordStderrStart();
			r.run();
		} catch (UnsatisfiedLinkError ule) {
			ule.printStackTrace();
			System.err.println("Use of JNIISLContext in finally clause fails due to LinkError");
			throw ule;
		} catch (RuntimeException re) {
			String err = JNIISLContext.recordStderrEnd();
			//If ISL did not output any error, then it could be some error in the Java side.
			if (err == null || err.length() == 0) throw re;
			throw f.apply(err);
		} finally {
			JNIISLContext.recordStderrEnd();
		}
	}

	public static void recordError(Runnable r) throws ISLErrorException {
		recordError(r, (err) -> new ISLErrorException(err.trim()));
	}

	/**
	 * Variant of recordError for operations that return a value in the end. (Supplier instead of Runnable)
	 * 
	 * @param r
	 * @param f
	 * @return
	 * @throws ISLErrorException
	 */
	public static <T> T recordError(Supplier<T> r, Function<String, ISLErrorException> f) throws ISLErrorException {
		try {
			JNIISLContext.recordStderrStart();
			T res = r.get();
			return res;
		} catch (UnsatisfiedLinkError ule) {
			ule.printStackTrace();
			System.err.println("Use of JNIISLContext in finally clause fails due to LinkError");
			throw ule;
		} catch (RuntimeException re) {
			String err = JNIISLContext.recordStderrEnd();
			//If ISL did not output any error, then it could be some error in the Java side.
			if (err == null || err.length() == 0) throw re;
			throw f.apply(err);
		} finally {
			JNIISLContext.recordStderrEnd();
		}
	}

	public static <T> T recordError(Supplier<T> r) throws ISLErrorException {
		return recordError(r, (err) -> new ISLErrorException(err.trim()));
	}

	public static void test(JNIISLSet x) {
		JNIISLTools.<JNIISLSet>recordError(() -> (x));
	}

	// public static JNIISLMap buildRenameMapString(List<String> newIndicesNames,
	// String tupleName, List<String> parametersNames,
	// List<String> indicesName) {
	// int size = indicesName.size();
	// JNIISLMap islMap;
	// if (size != newIndicesNames.size()) {
	// throw new UnsupportedOperationException("Not yet implemented");
	// } else {
	// String map_next_string = parametersNames + " -> { " + tupleName
	// + indicesName + " -> " + tupleName + newIndicesNames
	// + " : ";
	// for (int j = 0; j < size; j++) {
	// if (j > 0) {
	// map_next_string += " & ";
	// }
	// map_next_string += newIndicesNames.get(j) + " = "
	// + indicesName.get(j);
	// }
	// islMap = ISLFactory.islMap(map_next_string + " }");
	// }
	// return islMap;
	// }
	//
	// public static JNIISLMap renameDimensions(JNIISLMap map, JNIISLDimType type,
	// List<String> names) {
	// List<String> parametersNames = map.getParametersNames();
	// switch (type.getValue()) {
	// case JNIISLDimType.ISL_DIM_IN:
	// String tupleName = map.getTupleName(JNIISLDimType.isl_dim_in);
	//
	// List<String> indicesName = map.getDomainNames();
	// JNIISLMap buildRenameMapString = buildRenameMapString(names,
	// tupleName, parametersNames, indicesName);
	//
	// return JNIISLMap.applyDomain(map.copy(), buildRenameMapString);
	//
	// case JNIISLDimType.ISL_DIM_OUT:
	// tupleName = map.getTupleName(JNIISLDimType.isl_dim_out);
	//
	// indicesName = map.getRangeNames();
	// buildRenameMapString = buildRenameMapString(names, tupleName,
	// parametersNames, indicesName);
	// return JNIISLMap.applyRange(map.copy(), buildRenameMapString);
	// default:
	// throw new UnsupportedOperationException("Not yet implemented");
	//
	// }
	// }
	//
	// public static JNIISLSet renameDimensions(JNIISLSet set, List<String> names) {
	// List<String> parametersNames = set.getParametersNames();
	// String tupleName = set.getTupleName();
	//
	// List<String> indicesName = set.getIndicesNames();
	// JNIISLMap buildRenameMapString = buildRenameMapString(names, tupleName,
	// parametersNames, indicesName);
	// return set.copy().apply(buildRenameMapString);
	// }
	//
	// public static JNIISLMap identity(JNIISLMap map) {
	//
	// List<String> domainNames = map.getDomainNames();
	// int size = domainNames.size();
	// JNIISLMap islMap;
	// List<String> rangeNames = map.getRangeNames();
	// if (size != rangeNames.size()) {
	// throw new UnsupportedOperationException("Not yet implemented");
	// } else {
	// List<String> parametersNames = map.getParametersNames();
	// String inTupleName = map.getTupleName(JNIISLDimType.isl_dim_in);
	// String outTupleName = map.getTupleName(JNIISLDimType.isl_dim_out);
	// String map_next_string = parametersNames + " -> { " + inTupleName
	// + domainNames + " -> " + outTupleName + rangeNames + " : ";
	// for (int j = 0; j < size; j++) {
	// if (j > 0) {
	// map_next_string += " & ";
	// }
	// map_next_string += rangeNames.get(j) + " = "
	// + domainNames.get(j);
	// }
	// islMap = ISLFactory.islMap(map_next_string + " }");
	// }
	// return islMap;
	// }

	// public static JNIISLMap shift(JNIISLSet set, int dimId, int offset) {

	// JNIISLMap empty = JNIISLMap.fromDomainAndRange(set.copy(), set.copy());
	// dim.getNameList(JNIISLDimType.isl_dim_in);
	// for(String index : dim.getNameList(JNIISLDimType.isl_dim_in)) {
	//
	// }
	// return empty;
	// throw new UnsupportedOperationException();
	// }
	//
	// /**
	// * Simply add dimensions, without changing current ones.
	// *
	// * @param set
	// * @param dims
	// * @return
	// */
	// public static JNIISLSet extendDimsWith(JNIISLSet set, List<String> dims) {
	// if (dims.isEmpty())
	// return set.copy();
	// set = set.copy().makeDisjoint();
	// JNIISLSpace dimsOrig = set.getSpace();
	// JNIISLSet res = null;
	// int nbBset = set.getNumberOfBasicSet();
	// for (int i = 0; i < nbBset; i++) {
	// JNIISLBasicSet bs = set.getBasicSetAt(i);
	// String base = "[";
	// // params
	// List<String> parametersNames = bs.getParametersNames();
	// for (int k = 0; k < parametersNames.size(); k++) {
	// if (k > 0)
	// base += ",";
	// base += parametersNames.get(k);
	// }
	// String tupleName = set.getTupleName();
	// if (tupleName == null)
	// tupleName = "";
	// base += "] -> { " + tupleName + "[";
	// // domain's current dimensions
	// List<String> current = bs.getIndicesNames();
	// boolean first = true;
	//
	// for (int j = 0; j < dimsOrig.getSize(JNIISLDimType.isl_dim_set); j++) {
	// if (first)
	// first = false;
	// else
	// base += ",";
	// base += (current.get(j) == null) ? "i" + j : current.get(j);
	// }
	//
	// for (String s : dims) {
	// if (first)
	// first = false;
	// else
	// base += ",";
	// base += s;
	// }
	// base += "] : ";
	// String pa = bs.toString(ISL_FORMAT.ISL);
	// pa = pa.substring(pa.indexOf(":") + 1).replace("}", "").trim();
	// String bstring = base + pa + "}";
	//
	// JNIISLSet s = ISLFactory.islSet(bstring);
	// if (res == null)
	// res = s;
	// else
	// res = JNIISLSet.union(res, s);
	// }
	// return res;
	// }
	//
	// /**
	// * Simply add dimensions, without changing current ones.
	// *
	// * @param set
	// * @param dims
	// * @return
	// */
	// public static JNIISLSet renameIndices(JNIISLSet set, List<String> dims) {
	// set = set.copy().makeDisjoint();
	// JNIISLSpace dimsOrig = set.getSpace();
	//
	// List<String> origNames = dimsOrig
	// .getNameList(JNIISLDimType.isl_dim_set);
	//
	// if (origNames.size() != dims.size()) {
	// throw new RuntimeException();
	// }
	//
	// String base = "";
	// // params
	// base += set.getParametersNames().toString();
	//
	// String tupleName = set.getTupleName();
	// if (tupleName == null)
	// tupleName = "";
	// base += " -> { " + tupleName + "[";
	//
	// // domain's current dimensions
	// List<String> current = set.getIndicesNames();
	// boolean first = true;
	// List<String> dimIn = new ArrayList<String>();
	// for (int j = 0; j < dimsOrig.getSize(JNIISLDimType.isl_dim_set); j++) {
	// if (first)
	// first = false;
	// else
	// base += ",";
	// String varName = (current.get(j) == null) ? "i" + j : current
	// .get(j);
	// dimIn.add(varName);
	// base += varName;
	// }
	// base += "] -> " + tupleName + "[";
	// // new dimensions
	// first = true;
	// for (String s : dims) {
	// if (first)
	// first = false;
	// else
	// base += ",";
	// base += s;
	// }
	// base += "] : ";
	// first = true;
	// for (int i = 0; i < dimIn.size(); i++) {
	// if (first)
	// first = false;
	// else
	// base += " and ";
	// base += dimIn.get(i) + " = " + dims.get(i);
	// }
	// String bstring = base + "}";
	//
	// System.out.println(bstring);
	// JNIISLMap s = ISLFactory.islMap(bstring);
	//
	// JNIISLSet res = set.copy().apply(s);
	//
	// res = res.coalesce();
	// return res;
	// }

	/**
	 * This method infer the parameter context domain of a set, that is the
	 * parameter values that ensure that the set will contain at least one point.
	 * 
	 * @param set
	 * @return
	 */
	public static JNIISLSet inferParameterContextDomain(JNIISLSet set) {
		JNIISLSet contextSet = set.copy();

		int nDim = set.getNbDims();
		if (nDim > 0)
			contextSet = contextSet.projectOut(JNIISLDimType.isl_dim_set, 0, nDim);
		else {
			JNIISLMap identity = JNIISLMap.buildIdentity(contextSet.copy().getSpace()).reverse();
			contextSet = contextSet.apply(identity);
		}

		// JNIISLSet lexMin = set.copy().lexMin();
		// long nbDims = set.getDimensions().getSize(JNIISLDimType.isl_dim_set);
		// JNIISLSet contextSet =
		// lexMin.copy().projectOut(JNIISLDimType.isl_dim_set, 0,
		// nbDims).coalesce();
		// contextSet = contextSet.setTupleName(set.getTupleName());
		// contextSet = JNIISLTools.extendDimsWith(contextSet,
		// set.getIndicesNames());
		// contextSet = contextSet.projectOut(JNIISLDimType.isl_dim_set, 0,
		// contextSet.getNbDims());
		return contextSet;
	}

	public static JNIISLSet inferParameterContextDomain(JNIISLUnionSet uset) {
		JNIISLSet res = null;

		for (JNIISLSet set : uset.getSets()) {
			JNIISLSet paramCtx = inferParameterContextDomain(set);
			if (res == null)
				res = paramCtx;
			else
				res = res.union(paramCtx);
		}
		res = res.coalesce();
		return res;
	}

	/**
	 * This methods expands the dimension of input domain to match those of target
	 * domain, and then does return the intersection of the two "aligned domains".
	 * 
	 * @param input
	 * @param target
	 * @return
	 */
	public static JNIISLSet expandTo(JNIISLSet input, JNIISLSet target) {
		int nExtraDims = target.getNbDims() - input.getNbDims();
		JNIISLSet expandedSet = input.copy().insertDims(JNIISLDimType.isl_dim_set, input.getNbDims(), nExtraDims);
		JNIISLMap map = JNIISLMap.fromDomainAndRange(expandedSet.copy(), target.copy());
		map = JNIISLMap.buildIdentity(map.getSpace().copy());
		expandedSet = expandedSet.apply(map.copy());
		expandedSet = expandedSet.intersect(target.copy());
		return expandedSet;
	}

	public static JNIISLBasicSet expandTo(JNIISLBasicSet input, JNIISLBasicSet target) {
		JNIISLSet inputSet = input.toSet();
		JNIISLSet targetSet = target.toSet();
		JNIISLSet expandedSet = expandTo(inputSet, targetSet);
		if (expandedSet.getNbBasicSets() != 1)
			throw new RuntimeException();
		JNIISLBasicSet expanded = expandedSet.getBasicSetAt(0);
		return expanded;
	}

	public static JNIISLSet renameTo(JNIISLSet input, JNIISLSet target) {
		long nExtraDims = target.copy().getNbDims() - input.copy().getNbDims();
		if (nExtraDims != 0) {
			throw new UnsupportedOperationException("Not yet implemented");
		}
		JNIISLSet renamed = input.copy();
		JNIISLMap map = JNIISLMap.fromDomainAndRange(renamed.copy(), target.copy());
		map = JNIISLMap.buildIdentity(map.getSpace().copy());
		renamed = renamed.apply(map.copy());
		return renamed;
	}

	public static JNIISLMap renameRangeTo(JNIISLMap input, JNIISLSpace targetDim) {
		JNIISLSet target = JNIISLSet.buildEmpty(targetDim);
		JNIISLSet range = input.copy().getRange();
		long nExtraDims = target.copy().getNbDims() - range.copy().getNbDims();
		if (nExtraDims != 0) {
			throw new UnsupportedOperationException("Not yet implemented");
		}
		JNIISLMap map = JNIISLMap.fromDomainAndRange(range.copy(), target.copy());
		map = JNIISLMap.buildIdentity(map.getSpace().copy());
		map = input.copy().applyRange(map.copy());
		return map;
	}

	public static boolean allDisjointBasic(Collection<JNIISLBasicSet> sets) {
		Iterator<JNIISLBasicSet> iterator = sets.iterator();
		Collection<JNIISLSet> tmp = new ArrayList<JNIISLSet>(sets.size());
		while (iterator.hasNext()) {
			tmp.add(iterator.next().copy().toSet());
		}
		return allDisjoint(tmp);
	}

	public static boolean allDisjoint(Collection<JNIISLSet> sets) {
		Iterator<JNIISLSet> iterator = sets.iterator();
		if (!iterator.hasNext())
			return true;
		JNIISLSet init = iterator.next();
		JNIISLSet set = init.copy();
		boolean result = true;
		while (iterator.hasNext()) {
			JNIISLSet bset = iterator.next();
			if (!bset.getSpace().isCompatibleWith(set.getSpace())) {
				result = false;
				break;
			}
			JNIISLSet set2 = bset;
			JNIISLSet tmp = set.copy().intersect(set2.copy());
			if (!tmp.isEmpty()) {
				result = false;
				break;
			}
			set = set.union(set2);
		}
		return result;
	}

	/**
	 * this method returns this list of dimension's indices of the range for which
	 * the dimension is always a scalar, whatever the set (of the range).
	 * 
	 * @param umap
	 * @return
	 */
	public static List<Integer> scalarDims(JNIISLUnionMap umap) {
		throw new UnsupportedOperationException("To reimplement.");
		// if (umap.isEmpty()==0) {
		// JNIISLUnionSet scheduleRange = umap.copy().getRange().coalesce();
		// //all the statements should be scheduled in the same space
		// if (scheduleRange.getNbSet() != 1) throw new RuntimeException();
		// JNIISLSet scheduledDomain = scheduleRange.getSetAt(0);
		// int nbDims = (int) scheduledDomain.getNbDims();
		// //the number of potential scalar dimensions is not greater
		// //than the number of dimensions of the scheduled domain.
		// List<Integer> res = new ArrayList<Integer>(nbDims);
		// for (int i = 0; i < nbDims; i++) {
		// res.add(i);
		// }
		//
		// for (JNIISLMap map : umap.getMaps()) {
		// //the number of schedule per statement should be
		// //exactly one.
		// if (map.getNumberOfBasicMap() != 1) throw new RuntimeException();
		//
		// Map<JNIISLBasicSet, JNIISLAffList> m =
		// map.getBasicMapAt(0).lexmaxV2();
		// //schedule for one given statement should be bijective.
		// if (m.size() != 1) throw new RuntimeException();
		//
		// JNIISLAffList l = m.entrySet().iterator().next().getValue();
		// //schedule function should have the same number of dimensions
		// //as it's scheduled destination domain.
		// if (l.getSize() != nbDims) throw new RuntimeException();
		//
		// for (int i = 0; i < l.getSize(); i++) {
		// //if the current dimension is already known as non-
		// //scalar, skip it.
		// if (res.indexOf(i) == -1) continue;
		//
		// JNIISLAff aff = l.getAffAt(i);
		// if (!isConstant(aff)) res.remove(res.indexOf(i));
		// }
		// }
		//
		// return res;
		// } else {
		// return new ArrayList<Integer>(0);
		// }
	}

	/**
	 * This method returns true if the expression is a constant.
	 * 
	 * @param aff
	 * @return
	 */
	public static boolean isConstant(JNIISLAff aff) {
		JNIISLDimType dimType;

		dimType = JNIISLDimType.isl_dim_out;
		for (int i = 0; i < aff.getNbDims(dimType); i++) {

			if (aff.getCoefficientVal(dimType, i).asLong() != 0)
				return false;
		}

		dimType = JNIISLDimType.isl_dim_in;
		for (int i = 0; i < aff.getNbDims(dimType); i++) {
			if (aff.getCoefficientVal(dimType, i).asLong() != 0)
				return false;
		}

		dimType = JNIISLDimType.isl_dim_param;
		for (int i = 0; i < aff.getNbDims(dimType); i++) {
			if (aff.getCoefficientVal(dimType, i).asLong() != 0)
				return false;
		}

		// we assume that if a div is a constant, then it has been
		// simplified.
		// XXX : should we assume that?
		dimType = JNIISLDimType.isl_dim_div;
		for (int i = 0; i < aff.getNbDims(dimType); i++) {
			if (aff.getCoefficientVal(dimType, i).asLong() != 0)
				return false;
		}

		return true;
	}

	/**
	 * Build an ISL set with the variables of another set added at the end of its
	 * indices space.
	 * 
	 * @param set
	 *            domain to normalize
	 * @param other
	 *            another domain
	 * @return
	 */
	public static JNIISLSet normalize(JNIISLSet set, JNIISLSet other) {
		List<String> set1Indices = set.getIndicesNames();
		List<String> set2indices = other.getIndicesNames();

		Collection<String> normalizedIndices = new LinkedHashSet<String>();
		normalizedIndices.addAll(set1Indices);
		normalizedIndices.addAll(set2indices);

		return normalize(set, normalizedIndices);
	}

	/**
	 * Build the normalized intersection of two polyhedral domains. First dimensions
	 * are those coming from set1.
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static JNIISLSet normalizedIntersection(JNIISLSet set1, JNIISLSet set2) {
		Collection<String> normalizedIndices = new LinkedHashSet<String>();
		normalizedIndices.addAll(set1.getIndicesNames());
		normalizedIndices.addAll(set2.getIndicesNames());

		Collection<String> normalizedParameters = new LinkedHashSet<String>();
		normalizedParameters.addAll(set1.getParametersNames());
		normalizedParameters.addAll(set2.getParametersNames());

		JNIISLSet nset1 = normalize(set1, normalizedIndices, normalizedParameters);
		JNIISLSet nset2 = normalize(set2, normalizedIndices, normalizedParameters);
		// System.out.println("\nJNIISLTools.normalizedIntersection(): start");
		JNIISLSet result = nset1.intersect(nset2);
		// System.out.println("JNIISLTools.normalizedIntersection(): end");
		return result;
	}

	public static JNIISLSet normalize(JNIISLSet set, Collection<String> dimensions, Collection<String> parameters) {
		return normalize(set, dimensions, parameters.toArray(new String[parameters.size()]));
	}

	/**
	 * Normalize an ISL set to given ordered set of dimensions.
	 * 
	 * @param set
	 * @param dimensions
	 * @return
	 */
	public static JNIISLSet normalize(JNIISLSet set, Collection<String> dimensions, String... parameters) {
		String newVariablesDeclaration = formatVariables(dimensions, parameters);
		String currentVariablesDeclaration = formatVariables(set.getIndicesNames(),
				set.getParametersNames().toArray(new String[(int) set.getNbParams()]));

		JNIISLSet newSet = null;
		for (JNIISLBasicSet currentBset : set.getBasicSets()) {
			String bsetString = currentBset.toString(ISL_FORMAT.ISL).replace(currentVariablesDeclaration,
					newVariablesDeclaration);
			JNIISLBasicSet bset = ISLFactory.islBasicSet(bsetString);
			if (newSet == null) {
				newSet = bset.toSet();
			} else {
				newSet = newSet.union(bset.toSet());
			}
		}
		return newSet;
	}

	private static String formatVariables(Collection<String> indices, String... parameters) {
		StringBuffer sb = new StringBuffer("[");
		if (parameters.length > 0) {
			for (int i = 0; i < parameters.length - 1; i++) {
				sb.append(parameters[i]).append(", ");
			}
			if (parameters.length > 0) {
				sb.append(parameters[parameters.length - 1]);
			}
			sb.append("]->{ [");
		}
		boolean first = true;
		for (String s : indices) {
			if (first)
				first = false;
			else
				sb.append(", ");
			sb.append(s);
		}
		sb.append("]");
		return sb.toString();
	}
}
