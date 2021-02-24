/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.javatuples.Triplet;
import org.polymodel.AbstractRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.InputDimension;
import org.polymodel.OutputDimension;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.impl.RelationImpl;
import org.polymodel.isl.ISLBasicMap;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.IslPackage;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMultiAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIPtrBoolean;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>ISL Map</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ISLMapImpl extends RelationImpl implements ISLMap {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ISLMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IslPackage.Literals.ISL_MAP;
	}

	@Override
	public String toString() {
		return PolymodelPrettyPrinter.print(this, OUTPUT_FORMAT.ISL);
	}

	@Override
	public PolymodelDefaultFactory getFactory() {
		return PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
	}

	public ISLMap union(ISLMap m) {
		JNIISLMap union = getJNImap().union(getJNImap(m));
		ISLMap islMap = ISLNativeBinder.islMap(union, dimensions.getInputs(),
				dimensions.getOutputs(), dimensions.getParameters());
		return islMap;
	}

	public ISLMap difference(ISLMap m) {
		JNIISLMap jniMap = getJNImap().subtract(getJNImap(m));
		return buildMap(jniMap, dimensions);
	}

	public ISLMap intersection(ISLMap m) {
		JNIISLMap jniMap = getJNImap().intersect(getJNImap(m));
		return buildMap(jniMap, dimensions);
	}

	public ISLMap product(ISLMap m) {
		JNIISLMap jniMap = getJNImap().product(getJNImap(m));
		return buildMap(jniMap, dimensions);
	}

	public ISLMap lexmin() {
		JNIISLMap jniMap = getJNImap().lexMin();
		return buildMap(jniMap, dimensions);
	}

	public ISLMap lexmax() {
		JNIISLMap jniMap = getJNImap().lexMax();
		return buildMap(jniMap, dimensions);
	}

	@Override
	public <T extends AbstractRelation> T reverse(DimensionsManager manager) {
		JNIISLMap jniMap = getJNImap().reverse();
		

		//Swap inputs and outputs
		List<Variable> inputs  = new ArrayList<Variable>(dimensions.getOutputs().size());
		for (OutputDimension outDim : dimensions.getOutputs()) {
			inputs.add(outDim.getDimension());
		}
		
		List<Variable> outputs = new ArrayList<Variable>(dimensions.getInputs().size());
		for (InputDimension inDim : dimensions.getInputs()) {
			outputs.add(inDim.getDimension());
		}
		
		final RelationDimensions rdims;
		
		//case for functions (->)
		if (inputs.size() == 0 && outputs.size() == 0) {
			rdims = getFactory().createRelationDimensions(new ArrayList<InputDimension>(0), new ArrayList<OutputDimension>(0), dimensions.getParameters());
		} else {
			rdims = getFactory().createRelationDimensions(
					manager.getInputsDimensionsFor(inputs),
					manager.getOutputsDimensionsFor(outputs), dimensions.getParameters());
		}
		
		return buildMap(jniMap, rdims);
	}

	public ISLMap projection(Variable... dims) {
		JNIISLMap jniMap = applyProjection(dims);
		//TODO probably dimensions is not OK here
		return buildMap(jniMap, dimensions);
	}

	protected JNIISLMap applyProjection(Variable dimensions[]) {
		JNIISLMap m = getJNImap();
		for (int i = 0; i < dimensions.length; i++) {
			Variable variable = dimensions[i];
			if (variable instanceof InputDimension) {
				int first = getDimensions().getInputs().indexOf(variable);
				m = m.projectOut(JNIISLDimType.isl_dim_in, first, 1);
			}
		}
		return m;
	}

	public ISLBasicMap affineHull() {
		JNIISLBasicMap jniMap = getJNImap().affineHull();
		ISLBasicMap islMap = ISLNativeBinder.islBasicMap(jniMap,
				dimensions.getInputs(), dimensions.getOutputs(),
				dimensions.getParameters(), dimensions.getExistential());
		return islMap;
	}

	public ISLBasicMap convexHull() {
		JNIISLBasicMap jniMap = getJNImap().convexHull();
		ISLBasicMap islMap = ISLNativeBinder.islBasicMap(jniMap,
				dimensions.getInputs(), dimensions.getOutputs(),
				dimensions.getParameters(), dimensions.getExistential());
		return islMap;
	}
	
	@Override
	public boolean isBijective() {
		JNIISLMap jnImap = getJNImap();
		return jnImap.isBijective();
	}
	
	@Override
	public boolean equivalence(AbstractRelation map) {
		JNIISLMap jnImap = ISLNativeBinder.jniIslMapNoString(map);
		return getJNImap().isEqual(jnImap);
	}

	@Override
	public boolean isSingleValued() {
		JNIISLMap jnImap = getJNImap();
		return jnImap.isSingleValued();
	}

	public boolean isSubset(ISLMap m) {
		JNIISLMap jnImap = getJNImap(m);
		return getJNImap().isSubset(jnImap);
	}

	protected JNIISLMap getJNImap() {
		JNIISLMap jniIslMapNoString = ISLNativeBinder.jniIslMapNoString(this);
		return jniIslMapNoString;
	}

	protected JNIISLMap getJNImap(ISLMap map) {
		ISLMapImpl libraryDomain = getLibraryRelation(map, ISLMapImpl.class);
		return libraryDomain.getJNImap();
	}

	@Override
	public <T extends AbstractRelation> T simplify() {
		JNIISLMap jniMap = getJNImap().coalesce();
		return buildMap(jniMap, dimensions);
	}

	/**
	 * RelationDimensions may be the original dimensions for most operations.
	 * However, when number of indices in input or output dimensions are modified,
	 * new RelationDimensions must be created and given.
	 * 
	 * @param map
	 * @param dims
	 * @return
	 */
	protected <T extends AbstractRelation> T buildMap(JNIISLMap map, RelationDimensions dims) {
		return ISLNativeBinder.islMap(map, dims.getInputs(),
				dims.getOutputs(), dims.getParameters());
	}

	@Override
	public boolean isEmpty() {
		if(getBasicRelations().size()==0)
			return true;
		return getJNImap().isEmpty();
	}
	

	@Override
	public <T extends AbstractRelation> T intersectDomain(Domain domain) {
		JNIISLSet islDom = ISLNativeBinder.jniIslSet(domain);
		JNIISLMap jniMap = getJNImap().intersectDomain(islDom);
		return buildMap(jniMap, dimensions);
	}
	

	@Override
	public <T extends AbstractRelation> T intersectRange(Domain range) {
		JNIISLSet islRng = ISLNativeBinder.jniIslSet(range);
		JNIISLMap jniMap = getJNImap().intersectRange(islRng);
		return buildMap(jniMap, dimensions);
	}

	public <T extends AbstractRelation> T intersection(AbstractRelation map) {
		JNIISLMap islMap = ISLNativeBinder.jniIslMap(map);
		JNIISLMap jniMap = getJNImap().intersect(islMap);
		return buildMap(jniMap, dimensions);
	}
	
	public <T extends AbstractRelation> T union(AbstractRelation map) {
		JNIISLMap islMap = ISLNativeBinder.jniIslMap(map);
		JNIISLMap jniMap = getJNImap().union(islMap);
		return buildMap(jniMap, dimensions);
	}
 
	@Override
	public <T extends AbstractRelation> T difference(AbstractRelation map) {
		JNIISLMap islMap = ISLNativeBinder.jniIslMap(map);
		JNIISLMap jniMap = getJNImap().subtract(islMap);
		return buildMap(jniMap, dimensions);
	}
	

	/**
	 * Builds a function from ISLMap
	 *  - input must be bijective
	 *  - all basic maps must be equivalent (in context)
	 */
	public <T extends Function> T buildFunction() {
		ISLMap map = this;
		
		//needs to be bijective
		if (map.isSingleValued()) {
			JNIISLMap jmap = ISLNativeBinder.jniIslMapNoString((ISLMap)map.simplify());
			
			List<Triplet<ISLSet, Domain, T>> pieces = new ArrayList<>(jmap.getNbBasicMaps());
			
			//For each basic map, construct its domain and function
			for (int b = 0; b < jmap.getNbBasicMaps(); b++) {
				JNIISLBasicMap bmap = jmap.getBasicMapAt(b);

				Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = bmap.getClosedFormRelation();
				if (closedFormRelation.size() != 1) throw new RuntimeException();
				
				//Dims
				List<Variable> vars = new ArrayList<Variable>(map.getDimensions().getInputs().size());
				for (InputDimension in : map.getDimensions().getInputs()) {
					vars.add(in.getDimension());
				}
				EList<Variable> params = map.getDimensions().getParameters();
				
				//Domain
				ISLSet dom = ISLNativeBinder.islSet(bmap.getDomain(), vars, params);
				
				//Function				
				JNIISLMultiAff maff = closedFormRelation.entrySet().iterator().next().getValue();
				int size = map.getDimensions().getOutputs().size();
				if (maff.getNbAff() != size) throw new RuntimeException();
				Map<OutputDimension,IntExpression> mapping = new LinkedHashMap<OutputDimension, IntExpression>(size);
				for (int i = 0; i < size; i++) {
					JNIISLAff aff = maff.getAff(i);
					OutputDimension out = map.getDimensions().getOutputs().get(i);
					
					IntExpression expr = ISLNativeBinder.aff(aff, vars, params).simplify();
					
					mapping.put(out, expr);
				}
				
				T f = getFactory().createFunction(vars, params, mapping);
				pieces.add(new Triplet<>(dom, dom.affineHull(), f));
			}
			
			//Find the most general function (argmax over affine hull)
			Domain largestHull = null;
			T mostGeneralFunc = null;
			int currentNumEqs = Integer.MAX_VALUE;
			for (Triplet<ISLSet, Domain, T> piece : pieces) {
				if (largestHull == null) {
					largestHull = piece.getValue1();
					mostGeneralFunc = piece.getValue2();
					currentNumEqs = largestHull.getPolyhedra().get(0).getConstraints().size();
				} else {
					Domain hull = piece.getValue1();
					int numEqs    = hull.getPolyhedra().get(0).getConstraints().size();
					
					if (numEqs < currentNumEqs) {
						largestHull = hull;
						currentNumEqs = numEqs;
						mostGeneralFunc = piece.getValue2();
					}
				}
			}
			
			//add code to check that smallest hull includes everything else
			for (Triplet<ISLSet, Domain, T> piece : pieces) {
				if (!piece.getValue1().intersection(largestHull).equivalence(piece.getValue1())) {
					throw new RuntimeException("Incompatible pieces: " + piece.getValue1() + " <> " + largestHull);
				}
			}
			
			JNIISLBasicMap jniMGF = ISLNativeBinder.jniIslBasicMapNoString(mostGeneralFunc);

			for (Triplet<ISLSet, Domain, T> piece : pieces) {
				//easy case
				if (piece.getValue2().equivalence(mostGeneralFunc))
					continue;
				
				JNIISLBasicMap restrictedMGF = jniMGF.copy().intersectDomain(ISLNativeBinder.jniIslBasicSetNoString(piece.getValue1()));
				JNIISLBasicMap jniFunc = ISLNativeBinder.jniIslBasicMapNoString(piece.getValue2());
				JNIISLBasicMap restrictedF = jniFunc.intersectDomain(ISLNativeBinder.jniIslBasicSetNoString(piece.getValue1()));
				
				//equivalence in context
				if (restrictedMGF.isEqual(restrictedF)) {
					continue;
				}

				//Check for equivalence in context
				throw new RuntimeException("All basic maps in a map must result in the same function: " + map);
			}
			//T func = pieces.get(0).getValue();
			return mostGeneralFunc;
		} else {
			throw new RuntimeException("The given map is not single valued / bijective : \n"+map);
		}
	}
	
	
	
	public <T extends Domain> T getDomain() {
		JNIISLMap jniMap = ISLNativeBinder.jniIslMapNoString(this);
		JNIISLSet islDom = jniMap.getDomain();
		EList<InputDimension> inputs = getDimensions().getInputs();
		EList<Variable> vars = new BasicEList<Variable>();
		for(InputDimension input : inputs) {
			vars.add(input.getDimension());
		}
		return ISLNativeBinder.islSet(islDom, vars, getDimensions().getParameters());
	}
	
	public <T extends Domain> T getRange() {
		JNIISLMap jniMap = ISLNativeBinder.jniIslMapNoString(this);
		JNIISLSet islDom = jniMap.getRange();
		EList<OutputDimension> outputs = getDimensions().getOutputs();
		EList<Variable> vars = new BasicEList<Variable>();
		for(OutputDimension output : outputs) {
			vars.add(output.getDimension());
		}
		return ISLNativeBinder.islSet(islDom, vars,getDimensions().getParameters());
	}

	@Override
	public <T extends AbstractRelation> T applyDomain(AbstractRelation map) {
		JNIISLMap islMap = ISLNativeBinder.jniIslMap(map);
		JNIISLMap jniMap = getJNImap().applyDomain(islMap);
		return buildMap(jniMap, dimensions);
	}

	@Override
	public <T extends AbstractRelation> T applyRange(AbstractRelation map) {
		JNIISLMap islMap = ISLNativeBinder.jniIslMap(map);
		JNIISLMap jniMap = getJNImap().applyRange(islMap);
		return buildMap(jniMap, dimensions);
	}
	
	
	public <T extends AbstractRelation> T transitiveClosure() {
		JNIISLMap jniMap = ISLNativeBinder.jniIslMapNoString(this);
		JNIPtrBoolean exact = new JNIPtrBoolean();
		JNIISLMap closure = jniMap.transitiveClosure(exact);
		
		return buildMap(closure, getDimensions());
	}

	public <T extends AbstractRelation> T exactTransitiveClosure() {
		JNIISLMap jniMap = ISLNativeBinder.jniIslMapNoString(this);
		JNIPtrBoolean exact = new JNIPtrBoolean();
		JNIISLMap closure = jniMap.transitiveClosure(exact);
		
		if (!exact.value) {
			throw new RuntimeException("Failed to compute exact closure.");
		}
		
		return buildMap(closure, getDimensions());
	}

} // ISLMapImpl
