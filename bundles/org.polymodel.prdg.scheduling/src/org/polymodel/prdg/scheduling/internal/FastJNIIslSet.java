package org.polymodel.prdg.scheduling.internal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.isl.impl.ISLSetImpl;

import fr.irisa.cairn.jnimap.isl.jni.ISLFactory;
import fr.irisa.cairn.jnimap.isl.jni.ISL_FORMAT;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLTools;

/**
 * A fast implementation of {@link ISLSet} that doesn't build polymodel
 * constraints if not explicitly asked. It is using string representations of
 * {@link JNIISLSet}.
 * 
 * @author antoine
 * 
 */
public class FastJNIIslSet extends ISLSetImpl {
	private String content;
	private String[] bsets;

	private FastJNIIslSet(FastJNIIslSet domain) {
		this.content = domain.content;
		this.dimensions = domain.dimensions.copy();
		this.bsets = domain.bsets;
	}

	public static FastJNIIslSet buildFrom(Domain domain) {
		if (domain instanceof FastJNIIslSet) {
			return new FastJNIIslSet((FastJNIIslSet) domain);
		} else {
			ISLSetImpl dimp = PolymodelComponent.INSTANCE.getFactory(
					ISLPolymodelModule.INSTANCE).createDomain(domain);
			JNIISLSet jnIset = dimp.getJNIset();
			return new FastJNIIslSet(jnIset, domain.getDimensions());
		}
	}

	public FastJNIIslSet(JNIISLSet jniSet, DomainDimensions dimensions) {
		this.content = jniSet.toString(ISL_FORMAT.ISL);
		this.dimensions = dimensions.copy();
		this.bsets = new String[jniSet.getNbBasicSets()];
		for (int i = 0; i < bsets.length; i++) {
			JNIISLBasicSet basicSetAt = jniSet.getBasicSetAt(i);
			if (basicSetAt.getIndicesNames().size() != dimensions.getIndices()
					.size()) {
				throw new RuntimeException(
						"JNI basic set doesn't have the same number of indices than its polymodel dimensions");
			}
			ensureNaming(basicSetAt);
			this.bsets[i] = basicSetAt.toString(ISL_FORMAT.ISL);

		}
	}

	private void ensureNaming(JNIISLBasicSet bset) {
		EList<Variable> indices = dimensions.getIndices();
		for (int j = 0; j < indices.size(); j++) {
			bset.setDimName(JNIISLDimType.isl_dim_out, j, indices.get(j)
					.getName());
		}
		EList<Variable> parameters = dimensions.getParameters();
		for (int i = 0; i < parameters.size(); i++) {
			bset.setDimName(JNIISLDimType.isl_dim_param, i, parameters.get(i)
					.getName());
		}
	}

//	private String formatVariables(DomainDimensions dimensions) {
//		StringBuffer sb = new StringBuffer("[");
//		EList<Variable> indices = dimensions.getIndices();
//		for (int i = 0; i < indices.size() - 1; i++) {
//			Variable v = indices.get(i);
//			sb.append(v.getName()).append(", ");
//		}
//		if (indices.size() > 0) {
//			sb.append(indices.get(indices.size() - 1));
//		}
//		sb.append("]");
//		return sb.toString();
//	}

	/**
	 * Create a new domain using the given domain dimensions.
	 * 
	 * @param newDimensions
	 *            dimensions of the created domain
	 * @return
	 */
	public FastJNIIslSet normalize(DomainDimensions newDimensions) {
		List<String> indices = new UniqueEList<String>();
		for (Variable v : newDimensions.getIndices()) {
			indices.add(v.getName());
		}
		JNIISLSet normalized = JNIISLTools.normalize(getJNIset(), indices);
		return new FastJNIIslSet(normalized, newDimensions);
	}

	public FastJNIIslSet computeExistentialVariables() {
		JNIISLSet set = getJNIset();
		System.out
				.println("\nFastJNIIslSetProxy.computeExistentialVariables()");
		JNIISLSet cdivs = set.computeDivs();
		System.out
				.println("FastJNIIslSetProxy.computeExistentialVariables(): end");
		return new FastJNIIslSet(cdivs, getDimensions());
	}

	@Override
	public JNIISLSet getJNIset() {
		JNIISLSet newSet = null;
		for (String currentBset : bsets) {
			JNIISLBasicSet bset = ISLFactory.islBasicSet(currentBset);
			if (newSet == null) {
				newSet = bset.toSet();
			} else {
				newSet = newSet.union(bset.toSet());
			}
		}
		return newSet;
	}

	@Override
	public <T extends Domain> T intersection(Domain domain) {
		checkDimensions(domain);
		JNIISLSet jnIset = getJNIset();
		JNIISLSet jnIset2 = getJNIset(domain);
		JNIISLSet intersection = jnIset.intersect(jnIset2);
		if (intersection == null)
			throw new IllegalArgumentException("Unable to compute intersection");
		FastJNIIslSet res = new FastJNIIslSet(intersection, getDimensions());
		@SuppressWarnings("unchecked")
		T t = (T) res;
		return t;
	}

	public FastJNIIslSet normalizedIntersection(Domain d) {
		DomainDimensions normalizedDimensions = normalizeDimensionsWith(d
				.getDimensions());
		JNIISLSet set1 = getJNIset();
		JNIISLSet set2 = getJNIset(d);
		JNIISLSet intersection = JNIISLTools.normalizedIntersection(set1, set2);
		return new FastJNIIslSet(intersection, normalizedDimensions);
	}

//	public FastJNIIslSet removeRedundancies() {
//		return new FastJNIIslSet(getJNIset().removeRedundancies(),
//				getDimensions());
//	}

	@Override
	public boolean isEmpty() {
		return this.bsets.length == 0 || getJNIset().isEmpty();
	}
	
	/**
	 * Normalize the domain dimensions with another one. First dimensions are
	 * those coming from the current domain.
	 * 
	 * @param other
	 * @return
	 */
	private DomainDimensions normalizeDimensionsWith(DomainDimensions other) {
		List<Variable> indices = new UniqueEList<Variable>();
		for (Variable c : getDimensions().getIndices()) {
			indices.add(c);
		}
		for (Variable c : other.getIndices()) {
			indices.add(c);
		}
		List<Variable> parameters = new UniqueEList<Variable>();
		for (Variable c : getDimensions().getParameters()) {
			parameters.add(c);
		}
		for (Variable c : other.getParameters()) {
			parameters.add(c);
		}
		Set<String> variablesIdentifiers = new HashSet<String>();
		for (Variable i : indices) {
			if (variablesIdentifiers.contains(i.getName())) {
				throw new RuntimeException("Variable " + i.getName()
						+ " has the same name than another one (contained in "
						+ i.eContainer() + ")");
			} else {
				variablesIdentifiers.add(i.getName());
			}
		}
		return getFactory().createDomainDimensions(indices, parameters);
	}

	@Override
	public <T extends Domain> T union(Domain domain) {
		checkDimensions(domain);
		JNIISLSet jnIset = getJNIset();
		JNIISLSet other = getJNIset(domain);
		JNIISLSet union = jnIset.union(other);
		FastJNIIslSet res = new FastJNIIslSet(union, getDimensions());
		@SuppressWarnings("unchecked")
		T t = (T) res;
		return t;
	}

	@SuppressWarnings("unchecked")
	public FastJNIIslSet polyhedralHull() {
		JNIISLSet jnIset = getJNIset();
		JNIISLSet hull = jnIset.polyhedralHull().toSet();
		return new FastJNIIslSet(hull, getDimensions());
	}

	@Override
	protected JNIISLSet getJNIset(Domain domain) {
		FastJNIIslSet dproxy = buildFrom((ISLSet) domain);
		return dproxy.getJNIset();
	}

	@Override
	public void addConstraint(IntConstraint c) {
		throw new UnsupportedOperationException(
				"Unable to perform this operation");
	}

//	private String context(IntConstraint... constraints) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("{");
//		sb.append(formatVariables(dimensions)).append(":");
//		for (int i = 0; i < constraints.length - 1; i++) {
//			sb.append(
//					AlgebraPrettyPrinter.print(constraints[i],
//							OUTPUT_FORMAT.ISL)).append(" and ");
//		}
//		if (constraints.length > 0) {
//			sb.append(AlgebraPrettyPrinter.print(
//					constraints[constraints.length - 1], OUTPUT_FORMAT.ISL));
//		}
//		sb.append("}");
//		return sb.toString();
//	}

	@SuppressWarnings("unchecked")
	@Override
	public FastJNIIslSet lexMin() {
		JNIISLSet lexmin = getJNIset().lexMin();
		return new FastJNIIslSet(lexmin, getDimensions());
	}

	@Override
	public FastJNIIslSet project(int first, int n) {
		JNIISLSet jnIset = getJNIset();
		JNIISLSet projectOut = jnIset.projectOut(JNIISLDimType.isl_dim_set,
				first, n);

		DomainDimensions projectionDimensions = getDimensions().copy();
		for (Variable d : getDimensions().getIndices()) {
			int pos = getDimensions().getIndices().indexOf(d);
			if (pos >= first && pos <= first + n)
				projectionDimensions.getIndices().remove(d);
		}
		return new FastJNIIslSet(projectOut, projectionDimensions);
	}

	@Override
	public EList<IntConstraintSystem> getPolyhedra() {
		return buildPolymodelDomain().getPolyhedra();
	}

	public ISLSet buildPolymodelDomain() {

		return PolymodelComponent.INSTANCE.getFactory(
				ISLPolymodelModule.INSTANCE).createDomain(
				getDimensions().copy(), buildPolyhedra(getJNIset()));

	}

	@Override
	public <T extends Domain> T simplify() {
		JNIISLSet jnIset = getJNIset().coalesce();
		FastJNIIslSet res = new FastJNIIslSet(jnIset, getDimensions());
		@SuppressWarnings("unchecked")
		T t = (T) res;
		return t;
	}

	@Override
	public String toString() {
		return content;
	}
}
