/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.eq;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.AbstractRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.ExistentialVariable;
import org.polymodel.InputDimension;
import org.polymodel.OutputDimension;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.impl.DomainImpl;
import org.polymodel.isl.ISLFunction;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.ISLPoint;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.IslPackage;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

import fr.irisa.cairn.jnimap.isl.jni.ISL_FORMAT;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMultiAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLPoint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.extra.ISLLexShiftTools;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>ISL Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ISLSetImpl extends DomainImpl implements ISLSet {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ISLSetImpl() {
		super();
	}

	@Override
	public PolymodelDefaultFactory getFactory() {
		return PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IslPackage.Literals.ISL_SET;
	}

	@Override
	public boolean isEmpty() {
		return getJNIset().isEmpty();
	}

	@Override
	public boolean equivalence(Domain domain) {
		if (!hasCompatibleDimensions(domain)) {
			return false;
		}
		JNIISLSet d1 = getJNIset();
		JNIISLSet d2 = getJNIset(domain);
		return d1.isEqual(d2);
	}

	@Override
	public IntConstraintSystem[] applySimplify() {
		JNIISLSet jnIset = getJNIset();
		JNIISLSet set = jnIset.coalesce();
		IntConstraintSystem[] polyhedra = buildPolyhedra(set);
		return polyhedra;
	}
	
	@Override
	public <T extends Domain> T simplify(Domain context) {
		checkDimensions(context);
		JNIISLSet set = getJNIset();
		JNIISLSet other = getJNIset(context);
		JNIISLSet gist = set.gist(other);
		IntConstraintSystem[] buildPolyhedra = buildPolyhedra(gist);
		return getFactory().createDomain(dimensions.copy(),buildPolyhedra);
	}

	protected IntConstraintSystem[] buildPolyhedra(JNIISLSet set) {
		List<JNIISLBasicSet> basicSets = set.getBasicSets();
		IntConstraintSystem polyhedra[] = new IntConstraintSystem[basicSets.size()];

		if (set.isEmpty()) {
			polyhedra = new IntConstraintSystem[1];
			polyhedra[0] = constraintSystem(eq(affine(term(1)), affine(term(0))));
		} else {
			for (int j = 0; j < basicSets.size(); j++) {
				IntConstraintSystem buildPolyhedron = buildPolyhedron(basicSets.get(j));
				polyhedra[j] = buildPolyhedron;
			}
		}
		return polyhedra;
	}

	private IntConstraintSystem buildPolyhedron(JNIISLBasicSet set) {
		EList<Variable> indices = getDimensions().getIndices();
		EList<Variable> parameters = getDimensions().getParameters();
		EList<ExistentialVariable> existential = getDimensions().getExistential();
		return ISLNativeBinder.intConstraintSystem(set,
				indices, parameters, existential);
	}

	@Override
	protected IntConstraintSystem[] applyIntersection(Domain domain) {
		JNIISLSet set = getJNIset();
		JNIISLSet other = getJNIset(domain);
		JNIISLSet intersection = set.intersect(other);
		return buildPolyhedra(intersection);
	}

	@Override
	protected IntConstraintSystem[] applyDifference(Domain domain) {
		JNIISLSet set = getJNIset();
		JNIISLSet other = getJNIset(domain);
		JNIISLSet difference = set.subtract(other);
		return buildPolyhedra(difference);
	}

	@Override
	protected IntConstraintSystem[] applyUnion(Domain domain) {
		JNIISLSet set = getJNIset();
		JNIISLSet other = getJNIset(domain);
		JNIISLSet union = set.union(other);
		return buildPolyhedra(union);
	}

	@Override
	protected IntConstraintSystem[] applyProjection(Variable dimensions[]) {
		JNIISLSet set = getJNIset();
		List<Variable> indices = new ArrayList<Variable>(getDimensions().getIndices());
		for (Variable d : dimensions) {
			int pos = indices.indexOf(d);
			set = set.projectOut(JNIISLDimType.isl_dim_out, pos, 1);
			indices.remove(d);
		}
		List<JNIISLBasicSet> basicSets = set.getBasicSets();
		IntConstraintSystem polyhedra[] = new IntConstraintSystem[basicSets
				.size()];

		for (int j = 0; j < basicSets.size(); j++) {
			JNIISLBasicSet jniislBasicSet = basicSets.get(j);
			polyhedra[j] = ISLNativeBinder.intConstraintSystem(jniislBasicSet,
					indices, getDimensions().getParameters(), getDimensions().getExistential());
		}
		return polyhedra;
	}

	@Override
	protected IntConstraintSystem[] applyImage(DomainDimensions dims, AbstractRelation relation) {
		JNIISLSet set = getJNIset();
		JNIISLMap map = ISLNativeBinder.jniIslMapNoString(relation);
		JNIISLSet image = set.apply(map);
		//code below is specialized version of buildPolyhedra for operations involving relations
		List<JNIISLBasicSet> basicSets = image.getBasicSets();
		IntConstraintSystem polyhedra[] = new IntConstraintSystem[basicSets.size()];

		if (image.isEmpty()) {
			polyhedra = new IntConstraintSystem[1];
			polyhedra[0] = constraintSystem(eq(affine(term(1)), affine(term(0))));

		} else {
			for (int j = 0; j < basicSets.size(); j++) {
				polyhedra[j] = ISLNativeBinder.intConstraintSystem(basicSets.get(j),
						dims.getIndices(), dims.getParameters(), dims.getExistential());
			}

		}
		
		
		return polyhedra;
	}

	public JNIISLSet getJNIset() {
		return ISLNativeBinder.jniIslSet(this);
	}

	protected JNIISLSet getJNIset(Domain domain) {
		ISLSetImpl libraryDomain = getLibraryDomain(domain, ISLSetImpl.class);
		return libraryDomain.getJNIset();
	}

	@Override
	public String toString() {
		return PolymodelPrettyPrinter.print(this, OUTPUT_FORMAT.ISL);
	}

	@Override
	public <T extends Domain> T complement() {
		JNIISLSet complement = getJNIset().complement();
		return getFactory().createDomain(dimensions.copy(),
				buildPolyhedra(complement));
	}

	public Map<ISLSet,ISLFunction> lexminFunction(DimensionsManager manager) {
		return lexminFunction(this.getNbIndices(), manager);
	}
	public Map<ISLSet,ISLFunction> lexminFunction(int i, DimensionsManager manager) {
		JNIISLSet jniIslSet = ISLNativeBinder.jniIslSet(this);
		if (jniIslSet == null) throw new RuntimeException("Could not build JNI object.");
		JNIISLMap map = jniIslSet.lexFirstMap(i);
		if (map == null) throw new RuntimeException("Could compute lex first map over the "+i+" innermost loops of "+jniIslSet+" (build from "+this.toString()+")");
		PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(getIndices());
		String label = null;
		if (this.getLabel() != null)
			label = this.getLabel().getName();
		Map<ISLFunction,JNIISLSet> res1 = new LinkedHashMap<ISLFunction,JNIISLSet>();
		for (JNIISLBasicMap bmap : map.getBasicMaps()) {
			Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = bmap.getClosedFormRelation();
			out: for (Entry<JNIISLSet, JNIISLMultiAff> e : closedFormRelation.entrySet()) {
				List<IntExpression> exprList = ISLNativeBinder.exprList(e.getValue(), getIndices(), getParams());
				ISLFunction partialNext = factory.createFunction(getIndices(),outputs, getParams(), exprList, label, label);
				JNIISLSet validityDomain = e.getKey();
				for (ISLFunction f : res1.keySet()) {
					if (f.equivalence(partialNext)) {
						JNIISLSet union = validityDomain.union(res1.get(f));
						res1.put(f, union);
						continue out;
					}
				}
				res1.put(partialNext, validityDomain);
			}
		}
		Map<ISLSet,ISLFunction> res = new LinkedHashMap<ISLSet,ISLFunction>();
		for (Entry<ISLFunction,JNIISLSet> e : res1.entrySet()) {
			JNIISLSet set = e.getValue().simplify(); //.gist(jniIslSet.copy()).coalesce();
			ISLSet islSet = ISLNativeBinder.islSet(set, getIndices(), getParams());
			ISLFunction function = e.getKey();
			res.put(islSet, function);
		}
		return res;
	}

//	public ISLSet lexmin() {
//		JNIISLSet lexmin = getJNIset().lexMin();
//		return getFactory().createDomain(dimensions.copy(),
//				buildPolyhedra(lexmin));
//	}
//
//	public ISLSet lexmax() {
//		JNIISLSet lexmax = getJNIset().lexMax();
//		return getFactory().createDomain(dimensions.copy(),
//				buildPolyhedra(lexmax));
//	}

	@Override
	public ISLSet  cartesianProduct(Domain domain) {		JNIISLSet product = getJNIset().copy().product(getJNIset(domain));
		DomainDimensions projectionDimensions = getDimensions().copy();
		//manager
		for (Variable d : domain.getDimensions().getIndices()) {
			if(projectionDimensions.getIndices().contains(d)) {
				Variable copy = EcoreUtil.copy(d);
				copy.setName(d.getName()+"'");
				projectionDimensions.getIndices().add(copy);
			} else {
				projectionDimensions.getIndices().add(d);
			}
		}
		for (Variable d : domain.getParams()) {
			projectionDimensions.getParameters().add(d);
		}
		
		IntConstraintSystem[] buildPolyhedra = new IntConstraintSystem[product.getBasicSets().size()];
		int i=0;
		for (JNIISLBasicSet bs : product.getBasicSets()) {
			buildPolyhedra[i++]= ISLNativeBinder.intConstraintSystem(bs, projectionDimensions.getIndices(), projectionDimensions.getParameters(), projectionDimensions.getExistential());
			
		}
		ISLSet createDomain = getFactory().createDomain(projectionDimensions,buildPolyhedra);
		return createDomain;

	}

	/**
	 * used for code generation à la Boulet&Feautrier.
	 * @param i
	 * @param manager
	 * @return
	 * TODO : rename
	 */
	public Map<ISLSet,ISLFunction> glexmin(DimensionsManager manager) {
		return glexmin(this.getNbIndices(), manager);
	}
	public Map<ISLSet,ISLFunction> glexmin(int i, DimensionsManager manager) {

		JNIISLSet jniIslSet = ISLNativeBinder.jniIslSet(this);
		if (jniIslSet == null) throw new RuntimeException("Could not build JNI object.");

		String lbl = null;
		if (this.getLabel() != null)
			lbl = this.getLabel().getName();
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(getIndices());
		PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);

		//use LinkedHashMap to keep order on key set.
		Map<ISLSet,ISLFunction> res = new LinkedHashMap<ISLSet,ISLFunction>();
		Map<JNIISLSet, JNIISLMultiAff> min = jniIslSet.lexFirstMap(i).getClosedFormRelation();
		
		for (Entry<JNIISLSet, JNIISLMultiAff> e : min.entrySet()) {
			List<IntExpression> exprList = ISLNativeBinder.exprList(e.getValue(), getIndices(), getParams());
			ISLFunction partialNext = factory.createFunction(getIndices(),outputs, getParams(), exprList, lbl, lbl);
			ISLSet islSet = ISLNativeBinder.islSet(e.getKey(), getIndices(), getParams());
			res.put(islSet, partialNext);
		}
		return res;
	}
	
	/**
	 * Computes the immediate successor in the set, where the validity
	 * domains have been gisted.
	 * 
	 * Main purpose : guard-less code generation.
	 * 
	 * @param nbInnerLoop
	 *            number of innermost loops to stick to (limit complexity)
	 * @return Map that represents piece-wise affine function pointing to the (lexicographically) next iteration of the set.
	 *  The keys are ordered such that ISLSet of entry n is the intersection of ISLSet(n) and ISLSet(i) for all i < n.
	 *  This is due to the domains being simplified by gist, so that the domains can be directly used in "if ... else if ..." style of code generation.
	 */
	public Map<ISLSet,ISLFunction> gnext(int nbInnerLoop, DimensionsManager manager) {

		JNIISLSet jniIslSet = ISLNativeBinder.jniIslSet(this);
		if (jniIslSet == null) throw new RuntimeException("Could not build JNI object.");

		String lbl = null;
		if (this.getLabel() != null)
			lbl = this.getLabel().getName();
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(getIndices());
		PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);

		//use LinkedHashMap to keep order on key set.
		Map<ISLSet,ISLFunction> res = new LinkedHashMap<ISLSet,ISLFunction>();
		List<Map<JNIISLSet, JNIISLMultiAff>> orderedLexNext = ISLLexShiftTools.gistedOrderedLexNext(jniIslSet, nbInnerLoop);
		
		for (Map<JNIISLSet, JNIISLMultiAff> m : orderedLexNext)  {
			for (Entry<JNIISLSet, JNIISLMultiAff> e : m.entrySet()) {
//				System.out.println(e.getValue()+" : "+e.getKey());
				List<IntExpression> exprList = ISLNativeBinder.exprList(e.getValue(), getIndices(), getParams());
				ISLFunction partialNext = factory.createFunction(getIndices(),outputs, getParams(), exprList, lbl, lbl);
				ISLSet islSet = ISLNativeBinder.islSet(e.getKey(), getIndices(), getParams());
				res.put(islSet, partialNext);
			}
		}
		return res;
	}
	
	public Map<ISLSet,ISLFunction> gnext(int nbInnerLoop, int power, DimensionsManager manager) {
		throw new UnsupportedOperationException();
		
//		return next(nbInnerLoop, power, manager);
		
//		JNIISLSet jniIslSet = ISLNativeBinder.jniIslSet(this);
//		if (jniIslSet == null) throw new RuntimeException("Could not build JNI object.");
//
//		String lbl = null;
//		if (this.getLabel() != null)
//			lbl = this.getLabel().getName();
//		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(getIndices());
//		PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
//
//		//use LinkedHashMap to keep order on key set.
//		Map<ISLSet,ISLFunction> res = new LinkedHashMap<ISLSet,ISLFunction>();
//		List<Map<JNIISLSet, JNIISLMultiAff>> orderedLexNext = ISLLexShiftTools.gistedOrderedLexNext(jniIslSet, nbInnerLoop, power);
//		
//		for (Map<JNIISLSet, JNIISLMultiAff> m : orderedLexNext)  {
//			for (Entry<JNIISLSet, JNIISLMultiAff> e : m.entrySet()) {
////				System.out.println(e.getValue()+" : "+e.getKey());
//				List<IntExpression> exprList = ISLNativeBinder.exprList(e.getValue(), getIndices(), getParams());
//				ISLFunction partialNext = factory.createFunction(getIndices(),outputs, getParams(), exprList, lbl, lbl);
//				ISLSet islSet = ISLNativeBinder.islSet(e.getKey(), getIndices(), getParams());
//				res.put(islSet, partialNext);
//			}
//		}
//		return res;
	}
	
	@Override
	public ISLMap nextRelation(int depth, DimensionsManager manager) {
		JNIISLSet jniIslSet = ISLNativeBinder.jniIslSet(this);
		if (jniIslSet == null) throw new RuntimeException("Could not build JNI object.");
		JNIISLMap map = jniIslSet.getLexNextMap(depth);
		if (map == null) throw new RuntimeException("Could compute next map over the "+depth+" innermost loops of "+jniIslSet+" (build from "+this.toString()+")");
		
		List<InputDimension> inputs = manager.getInputsDimensionsFor(getIndices());
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(getIndices());
		
		return ISLNativeBinder.islMap(map, inputs, outputs, getParams());
	}

	@Override
	public ISLMap nextRelation(int depth, int power, DimensionsManager manager) {
		JNIISLSet jniIslSet = ISLNativeBinder.jniIslSet(this);
		if (jniIslSet == null) throw new RuntimeException("Could not build JNI object.");
		JNIISLMap map = jniIslSet.getLexNextPowerMap(depth, power);
		if (map == null) throw new RuntimeException("Could compute next map over the "+depth+" innermost loops of "+jniIslSet+" (build from "+this.toString()+")");
		
		List<InputDimension> inputs = manager.getInputsDimensionsFor(getIndices());
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(getIndices());
		
		return ISLNativeBinder.islMap(map, inputs, outputs, getParams());
	}

	@Override
	public Map<ISLSet,ISLFunction> next(int depth, DimensionsManager manager) {
		JNIISLSet jniIslSet = ISLNativeBinder.jniIslSet(this);
		if (jniIslSet == null) throw new RuntimeException("Could not build JNI object.");
		JNIISLMap map = jniIslSet.getLexNextMap(depth);
		if (map == null) throw new RuntimeException("Could compute next map over the "+depth+" innermost loops of "+jniIslSet+" (build from "+this.toString()+")");

		return constructNextMap(map, jniIslSet, manager);		
	}
	
	@Override
	public Map<ISLSet,ISLFunction> next(int depth, int power, DimensionsManager manager) {
		JNIISLSet jniIslSet = ISLNativeBinder.jniIslSet(this);
		
		if (jniIslSet == null) throw new RuntimeException("Could not build JNI object.");
		JNIISLMap map = jniIslSet.copy().simplify().getLexNextPowerMap(depth, power);
		if (map == null) throw new RuntimeException("Could compute next map over the "+depth+" innermost loops of "+jniIslSet+" (build from "+this.toString()+")");
		
		return constructNextMap(map.simplify(), jniIslSet, manager);
	}
	
	
	private Map<ISLSet, ISLFunction> constructNextMap(JNIISLMap map, JNIISLSet jniIslSet, DimensionsManager manager) {
		PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(getIndices());
		String label = null;
		if (this.getLabel() != null)
			label = this.getLabel().getName();
		
		Map<ISLFunction,JNIISLSet> res1 = new LinkedHashMap<ISLFunction,JNIISLSet>();
		for (Entry<JNIISLSet, JNIISLMultiAff> e : map.getClosedFormRelation().entrySet()) {
			List<IntExpression> exprList = ISLNativeBinder.exprList(e.getValue(), getIndices(), getParams());
			ISLFunction partialNext = factory.createFunction(getIndices(),outputs, getParams(), exprList, label, label);
			JNIISLSet validityDomain = e.getKey();
			
			boolean merged = false;
			for (ISLFunction f : res1.keySet()) {
				if (f.equivalence(partialNext)) {
					JNIISLSet union = validityDomain.union(res1.get(f));
					res1.put(f, union);
					merged = true;
					break;
				}
			}
			if (!merged)
				res1.put(partialNext, validityDomain);
		}
		
//		Map<ISLFunction,JNIISLSet> res1 = new LinkedHashMap<ISLFunction,JNIISLSet>();
//		for (JNIISLBasicMap bmap : map.getBasicMaps()) {
//			Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = bmap.getClosedFormRelation();
//			out: for (Entry<JNIISLSet, JNIISLMultiAff> e : closedFormRelation.entrySet()) {
//				List<IntExpression> exprList = ISLNativeBinder.exprList(e.getValue(), getIndices(), getParams());
//				ISLFunction partialNext = factory.createFunction(getIndices(),outputs, getParams(), exprList, label, label);
//				JNIISLSet validityDomain = e.getKey();
//				for (ISLFunction f : res1.keySet()) {
//					if (f.equivalence(partialNext)) {
//						JNIISLSet union = JNIISLSet.union(validityDomain, res1.get(f));
//						res1.put(f, union);
//						continue out;
//					}
//				}
//				res1.put(partialNext, validityDomain);
//			}
//		}
		Map<ISLSet,ISLFunction> res = new LinkedHashMap<ISLSet,ISLFunction>();
		for (Entry<ISLFunction,JNIISLSet> e : res1.entrySet()) {
			JNIISLSet set = e.getValue().gist(jniIslSet.copy()).simplify();
			ISLSet islSet = ISLNativeBinder.islSet(set, getIndices(), getParams());
			ISLFunction function = e.getKey();
			res.put(islSet, function);
		}
		return res;
	}

	

	public ISLSet lift() {
		return getFactory().createDomain(dimensions.copy(),
				buildPolyhedra(getJNIset().lift()));
	}

	@Override
	public <T extends Domain> T affineHull() {
		return getFactory().createDomain(dimensions.copy(),
				buildPolyhedron(getJNIset().affineHull()));
	}
	
	@Override
	public <T extends Domain> T polyhedralHull() {
		return getFactory().createDomain(dimensions.copy(),
				buildPolyhedron(getJNIset().polyhedralHull()));
	}

	public ISLSet boundedSimpleHull() {
		return getFactory().createDomain(dimensions.copy(),
				buildPolyhedron(getJNIset().simpleHull()));
	}

	public ISLSet convexHull() {
		return getFactory().createDomain(dimensions.copy(),
				buildPolyhedron(getJNIset().convexHull()));
	}

	public int getNumberOfPoints() {
		return getJNIset().getNbPoints();
	}

	public List<ISLPoint> getPoints() {
		List<ISLPoint> points = new ArrayList<ISLPoint>();
		for (JNIISLPoint p : getJNIset().getPoints()) {
			points.add(ISLNativeBinder.point(p));
		}
		return points;
	}

	public ISLSet project(int first, int n) {
		DomainDimensions projectionDimensions = getDimensions().copy();
		JNIISLSet projectOut = getJNIset().projectOut(
				JNIISLDimType.isl_dim_out, first, n);
		for (Variable d : getDimensions().getIndices()) {
			int pos = getDimensions().getIndices().indexOf(d);
			if (pos >= first && pos <= first + n)
				projectionDimensions.getIndices().remove(d);
		}
		return getFactory().createDomain(projectionDimensions,
				buildPolyhedra(projectOut));
	}

	public String toString(ISL_FORMAT format) {
		JNIISLSet jnIset = getJNIset();
		return jnIset.toString(format);
	}

	public ISLSet gist(ISLSet context) {
		JNIISLSet set = getJNIset();
		JNIISLSet other = getJNIset(context);
		JNIISLSet gist = set.gist(other);
		IntConstraintSystem[] buildPolyhedra = buildPolyhedra(gist);
		return getFactory().createDomain(dimensions.copy(),buildPolyhedra);
	}

	public ISLMap getMapFromDomain(DimensionsManager manager) {
		JNIISLSet set = ISLNativeBinder.jniIslSet(this);
		JNIISLMap map =  JNIISLMap.fromDomain(set);
		List<InputDimension> inDimFor = manager.getInputsDimensionsFor(this.getDimensions().getIndices());
		List<OutputDimension> outDimFor = new ArrayList<OutputDimension>(0);
				//manager.getOutputsDimensionsFor(this.getDimensions().getIndices());
		ISLMap res = ISLNativeBinder.islMap(map, inDimFor,outDimFor, this.getDimensions().getParameters());
		return res;
	}

	public ISLMap getMapFromRange(DimensionsManager manager) {
		JNIISLSet set = ISLNativeBinder.jniIslSet(this);
		JNIISLMap map =  JNIISLMap.fromRange(set);
		List<InputDimension> inDimFor = new ArrayList<InputDimension>(0);
			//manager.getInputsDimensionsFor(this.getDimensions().getIndices());
		List<OutputDimension> outDimFor = manager.getOutputsDimensionsFor(this.getDimensions().getIndices());
		ISLMap res = ISLNativeBinder.islMap(map, inDimFor,outDimFor, this.getDimensions().getParameters());
		return res;
	}

	public ISLSet coalesce() {
		JNIISLSet set = ISLNativeBinder.jniIslSet(this).coalesce();
		ISLSet res = ISLNativeBinder.islSet(set, this.getDimensions().getIndices(),this.getDimensions().getParameters());
		return res;
	}

	
	@Override
	public <T extends Domain> T lexMax() {
		JNIISLSet set = ISLNativeBinder.jniIslSet(this).lexMax();
		T res = ISLNativeBinder.islSet(set, this.getDimensions().getIndices(),this.getDimensions().getParameters());
		return res;
	}

	@Override
	public <T extends Domain> T lexMin() {
		JNIISLSet set = ISLNativeBinder.jniIslSet(this).lexMin();
		T res = ISLNativeBinder.islSet(set, this.getDimensions().getIndices(),this.getDimensions().getParameters());
		return res;
	}
	
	@Override
	public <T extends Domain> T detectEqualities() {
		JNIISLSet set = ISLNativeBinder.jniIslSet(this).detectEqualities();
		T res = ISLNativeBinder.islSet(set, this.getDimensions().getIndices(),this.getDimensions().getParameters());
		return res;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public <T extends Domain> T union(Domain domain) {
		checkDimensions(domain);
		T createDomain = getFactory().createDomain(dimensions.copy(), applyUnion(domain));
		return createDomain;
	}
	
	@Override
	public boolean isUniverse() {
		JNIISLSet d1 = getJNIset();
		return d1.plainIsUniverse();
	}



} // ISLSetImpl
