package org.polymodel.polyhedralIR.polyIRCG.generator.C.PCOT;

import static org.polymodel.algebra.factory.IntExpressionBuilder.constant;
import static org.polymodel.algebra.factory.IntExpressionBuilder.sub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Pair;
import org.polymodel.DomainDimensions;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.ScopGenerator;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenUtilityForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.StatementVisitorForScheduledC;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.dtiler.DTiler;
import org.polymodel.scop.dtiler.DTiler.TilableBlock;
import org.polymodel.scop.dtiler.DTiler.TiledBlock;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.basic.DTilerWaveFrontTileLoops;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOptions;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOptions.HierarchyBandDTilingOptions;

import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;


/**
 * This StatementVisitor extends ScheduleC in a slightly unintended manner.
 * The mainLoop collecting the codegen info in the original scheduledC is 
 * first used to generate a loop nest (Scop). This loop nest goes through a
 * second phase of code generation, which is more than post-processing seen
 * for DTilers. The mainLoop is eventually discarded at the end of visiting
 * an AffineSystem, and replacement bodies are added.
 * 
 * @author tyuki
 *
 */
public class StatementVisitorForPCOTC extends StatementVisitorForScheduledC {
//	protected Function recursiveFunction;
//	protected Function baseFunction;
	
//	private static Boolean DEBUG = false;
	private final PolyIRCGUserFactory _CGfact = PolyIRCGUserFactory.INSTANCE;

	private final PolymodelDefaultFactory _PMfact = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
	
	//there is an optimization that separates out domains with less than the max.
	// number of dimensions out from PCOT target
	// this option should be exposed like other options later FIXME
	private static boolean SPLIT_OPT = true;
	
	protected List<TileSpecification> tilingSpecs;
	protected int maxTiledDims;
	protected int functionSetID  = 0;

	//following are created at createStructs method
	protected Struct paramStruct;
	protected AbstractVariable paramStructVar;
	protected Struct localStruct;
	protected AbstractVariable localStructVar;
	protected Struct recurStruct;
	protected AbstractVariable recurStructVar;


	private static final String PARAM_STRUCT_NAME = "struct param";
	private static final String LOCAL_STRUCT_NAME = "struct local";
	private static final String RECUR_STRUCT_NAME = "struct recur";
	
	protected StatementVisitorForPCOTC(CodeUnit unit, TargetMapping mapping, CodeGenOptions options) {
		super(unit, mapping, options);
	}
	
	@Override
	protected void inAffineMainLoopConstruction(AffineSystem a) {
		SpaceTimeLevel stlevel = targetMapping.getSpaceTimeLevel(0);

		tilingSpecs = new ArrayList<>(stlevel.getTilingSpecifications().size());
		maxTiledDims = 0;
		
		List<Integer> orderingDimensions = stlevel.getOrderingDimensions();
		//save the tiling informations for the loop
		for(TilingSpecification tile: stlevel.getTilingSpecifications()){
			List<Integer> orderingPrefix = tile.getOrderingPrefix();
			List<SubTileSpecification> subtiles = new LinkedList<SubTileSpecification>();
			int levels = tile.getLevels();
			for(int i = 1; i <= levels; i++){
				SubTilingSpecification subtile = tile.getSubTile(i);
				if(subtile == null){
					throw new RuntimeException("subtile at level " + i +" is not specified for tile band with prefix " + 
							tile.getOrderingPrefix().toString() + " [" + tile.getStartDim() + "," + tile.getEndDim() + "].");
				}
//				isParallel |= subtile.getTilingType().compareTo(TILING_TYPE.OMPWAVEFRONT) == 0;
				
				int start = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, tile.getStartDim(), true);
				int end = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, subtile.getEndDim(), false);
				subtiles.add(_fact.createSubTileSpecification(subtile.getLevel(), start, end, subtile.getTileSizes(), subtile.getTilingType()));
				maxTiledDims = Math.max(maxTiledDims, end-start+1);
			}
			int band_start = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, tile.getStartDim(), true);
			int band_end = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, tile.getEndDim(), false);
			tilingSpecs.add(_fact.createTileSpecification(levels, tile.getOrderingPrefix(), band_start, band_end, subtiles));
		}

		mainLoop = _fact.createCLoop(a.getParameters(), stlevel.getNumberOfOrderingDimensions());
	}
	
	/**
	 * Give the bounding box of a domain as a list of Pair<LB, UB> for each dimension.
	 * This function may have a wider use, and should probably be moved elsewhere.
	 *
	 * TODO
	 * 
	 * @param domain
	 * @return
	 */
	private List<Pair<IntExpression, IntExpression>> boundingBox(org.polymodel.Domain domain) {
		List<Pair<IntExpression, IntExpression>> bbox = new ArrayList<>(domain.getNbIndices());

		PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
		
		org.polymodel.Domain bbDomain = null;
		
		//since the bbox function in polymodel only looks at a single ICS, 
		// explicitly create one for each polyhedra and take the union of BBox in the end 
		for (IntConstraintSystem ics : domain.getPolyhedra()) {
			org.polymodel.Domain d = factory.createDomain(domain.getDimensions().copy(), ics.copy());
			if (bbDomain == null) {
				bbDomain = d.boundingBox();
			} else {
				bbDomain = bbDomain.union(d.boundingBox());
			}
		}

		domain = bbDomain;
		
		{
			for (int i = 0; i < domain.getNbIndices(); i++) {
				IntExpression lb = null;
				IntExpression ub = null;
				for (IntConstraintSystem ics : domain.getPolyhedra()) {
					if (lb == null) {
						lb = ics.getLB(domain.getIndices().get(i));
					} else {
						lb = IntExpressionBuilder.min(lb, ics.getLB(domain.getIndices().get(i)));
						lb = lb.simplify();
					}
					//minor opt. for max case to avoid max(X,0)
					// (assumes parameters are > 0)
					if (ub == null || ub.isZero() == FuzzyBoolean.YES) {
						ub = ics.getUB(domain.getIndices().get(i));
					} else {
						IntExpression t = ics.getUB(domain.getIndices().get(i));
						if (t.isZero() != FuzzyBoolean.YES) {
							ub = IntExpressionBuilder.max(ub, t);
							ub = ub.simplify();
						}
					}
				}
				
				bbox.add(new Pair<>(lb, ub));
			}
		}
		
		return bbox;
	}
	
	private void createStructs() {
		//Add function parmeter struct to ease the passing around of values
		{
//			unit.getP
			paramStruct = _CGfact.createStruct(PARAM_STRUCT_NAME,  entryFunction.getSignature().getParameters());
			unit.getHeaders().add(_CGfact.createDeclareStructs(paramStruct));
			paramStructVar = _CGfact.createBasicVariable("paramStruct", PARAM_STRUCT_NAME);
		}
		
		//Then a struct for passing local variables
		{
			localStruct = _CGfact.createStruct(LOCAL_STRUCT_NAME,  entryFunction.getLocals());
			unit.getHeaders().add(_CGfact.createDeclareStructs(localStruct));
			localStructVar = _CGfact.createBasicVariable("localStruct", LOCAL_STRUCT_NAME);
		}
		
		//Another struct for storing recursion info
		{
			recurStruct = _CGfact.createStruct(RECUR_STRUCT_NAME, new ArrayList<>(0));
			unit.getHeaders().add(_CGfact.createDeclareStructs(recurStruct));
			recurStructVar = _CGfact.createBasicVariable("recurStruct", RECUR_STRUCT_NAME);
			
			for (int i = 1; i <= maxTiledDims; i++) {
				recurStruct.getMembers().add(_CGfact.createBasicVariable(getTileIndex(i), "int"));
			}
			for (int i = 1; i <= maxTiledDims; i++) {
				recurStruct.getMembers().add(_CGfact.createBasicVariable(getTileWidth(i), "int"));
			}
		}
	}
	
	@Override
	public void outAffineSystem(AffineSystem a) {
		super.outAffineSystem(a);
		
		////First generate scheduledC loop nest 
		CloogOptionSpecifier cloogOptions = CloogOptionSpecifier.optionForFullyNestedLoop(mainLoop.getMaxDimension() - mainLoop.getNumConstantDimensions());
		ScopRoot sroot = ScopGenerator.generateScop(mainLoop.getParameterDomain(), mainLoop.getIteratorNames(), mainLoop.getStatements(), cloogOptions);
		
		//Split the resulting scop if specified by the option to separately treat for PCOT
		List<ScopRoot> scops;
		if (SPLIT_OPT) {
			scops = ScopGenerator.splitScop(sroot);
		} else {
			scops = new ArrayList<>();
			scops.add(sroot);
		}
		
		//create structs for passing around parameters
		createStructs();
		
		//Then we seek to generate new bodies to replace the mainLoop
		List<Body> bodies = new ArrayList<>(scops.size());
		
		PolymodelDefaultFactory fact = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
		
		//FIXME not parametric to ST level
		final int maxDim = targetMapping.getSpaceTimeLevel(0).getNumberOfDimensions() - targetMapping.getSpaceTimeLevel(0).getNumberOfOrderingDimensions();
		
		final Comparator<Variable> varComp =  new Comparator<Variable>() {
			@Override
			public int compare(Variable o1, Variable o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		//This loop retrieves code gen related info from the mainloop
		for (ScopRoot sr : scops) {
			List<? extends Variable> params = sr.getAllParameters();
			List<? extends Variable> iterators = sr.getAllIterators();
			List<? extends AbstractScopStatement> stmts = sr.getAllStatements();

			Collections.sort(iterators,varComp);
			DomainDimensions ddims = fact.createDomainDimensions(iterators, params);
			org.polymodel.Domain paramDom = retrieveParameterDomain(a, ddims);
			
			List<Statement> substmts = new ArrayList<>(stmts.size());
			
			org.polymodel.Domain fullDomain = null;
			for (AbstractScopStatement stmt : stmts) {
				org.polymodel.Domain dom = fact.createDomain(ddims, stmt.getDerivedConstraints());
				if (fullDomain == null) fullDomain = dom.copy(); 
				else fullDomain = fullDomain.union(dom.copy());
				
				//FIXME this code is quite ugly for its purpose of retrieving the original statement based on name
				if (stmt instanceof ScopStatementMacro) {
					String name = ((ScopStatementMacro) stmt).getName();
					for (Statement origStmt : mainLoop.getStatements()) {
						if (origStmt.getName().contentEquals(name))
							substmts.add(EcoreUtil.copy(origStmt));
					}
				} else {
					throw new RuntimeException("Expecting statements as macros @ PCOT code gen");
				}
			}
			fullDomain = fullDomain.intersection(paramDom);
			fullDomain = fullDomain.simplify();
			
			List<String> itNames = new ArrayList<>(iterators.size());
			for (Variable v : iterators) {
				itNames.add(v.getName());
			}
			

			ScopLoop loop;
			loop = _fact.createScopLoop(sr);
			loop.getStatements().addAll(substmts);
			loop.getIteratorNames().addAll(itNames);
			loop.setUseMacros(true);
			loop.setDeclareIterators(true);
			
			System.err.println(fullDomain.affineHull().toString(OUTPUT_FORMAT.ISL));
			
			//affine hull == equality in the domain
			// the statement is full dimensional if its AH has no constraints
			if (fullDomain.affineHull().isUniverse() && fullDomain.getNbIndices() == maxDim) {
				bodies.addAll(PCOTtransform(a, loop, fullDomain));
			} else {
				bodies.add(loop);
			}
		}
		
		int mlloc = entryFunction.getBodies().indexOf(mainLoop);
		entryFunction.getBodies().remove(mainLoop);
		entryFunction.getBodies().addAll(mlloc, bodies);
		entryFunction.getBodies().add(mlloc, _CGfact.createPackStruct(localStruct, localStructVar));
		entryFunction.getBodies().add(mlloc, _CGfact.createPackStruct(paramStruct, paramStructVar));
	}
	

	private Function createPCOTfunction(String fname) {

		Function f = _CGfact.createFunction(fname, "void");
		
		f.getParameters().add(paramStructVar);
		if (localStruct.getMembers().size() > 0)
			f.getParameters().add(localStructVar);
		f.getParameters().add(recurStructVar);

		f.setSignature(f.getDefaultFunctionSignature(false));

		return f;
	}

	//Body of base function; take the initial scop and get the point loop from DTiler
	private void generateBaseFunctionBody(ScopLoop sloop, HierarchyBandDTilingOptions band) {
		List<TilableBlock> tbs = DTiler.extractTilableBlock(sloop.getScopRoot());
		if (tbs.size() != 1)
			throw new RuntimeException("Assumes there is only one tilable block @ PCOTtransform");
		
			TilableBlock tb = tbs.get(0);
	
			DTilingOptions dtopt = new DTilingOptions(1, new ArrayList<>(0), band.getBandStart(), band.getBandEnd());
			dtopt.setTileIndexNameF((int dim, int level) -> { return "ti" + dim; } );
			dtopt.setTileSizeNameF((int dim, int level)  -> { return "tw" + dim; } );
			
			TiledBlock tiled = DTiler.tile(tb, dtopt);
			
			ScopRoot tiledSR = ScopUserFactory.scopRoot(tiled.pointLoopStart);
			sloop.setScopRoot(tiledSR);
	}
	
	private List<Body> generateRecursionEntry(String recurFunctionName, org.polymodel.Domain domain, boolean isParallel) {
		List<Body> bodies = new LinkedList<>();
		List<Pair<IntExpression, IntExpression>> bbox = boundingBox(domain);

		CustomPackStruct cpps = _CGfact.createCustomPackStruct(recurStruct, recurStructVar);
		
		//Initialization of the recur struct by the lex. min point and width of the bbox
		int i = 0;
		for (Pair<IntExpression, IntExpression> bounds : bbox) {
			IntExpression width = bounds.getValue().copy();
			width = sub(width, sub(bounds.getKey(), constant(1)));
			width = width.simplify();
			
			cpps.getInitValues().put(
					recurStruct.getMembers().get(i).getName(), 
					bounds.getKey().toString(OUTPUT_FORMAT.C));
			cpps.getInitValues().put(
					recurStruct.getMembers().get(i+maxTiledDims).getName(), 
					width.toString(OUTPUT_FORMAT.C));
			i++;
		}

		bodies.add(cpps);
		
		//The following may be better if moved to polyIRCG class
		StringBuffer fcall = new StringBuffer(recurFunctionName + "(");
		fcall.append(paramStructVar.getName());
		if (localStruct.getMembers().size() > 0)
			fcall.append(", " + localStructVar.getName());
		fcall.append(", " + recurStructVar.getName() +  ");");
		
		if (isParallel) {
			String ompstart = "#pragma omp parallel\n"
					+ "#pragma omp single\n"
					+ "{\n"
					+ "\t" + fcall + "\n"
					+ "}";
			
			bodies.add(_CGfact.createBody(ompstart));
		} else {
			bodies.add(_CGfact.createBody(fcall.toString()));
		}
		return bodies;
	}
	
	private List<Body> PCOTtransform(AffineSystem a, ScopLoop sloop, org.polymodel.Domain domain) {
		HierarchyDTilingOptions hierarchyDTilingOptions = initializeHierarchyDTilingOptions();
		List<HierarchyBandDTilingOptions> bands = hierarchyDTilingOptions.getHierarchyBandDTilingOptions();

		if (bands.size() > 1) {
			throw new UnsupportedOperationException("PCOT with multiple levels are not supported.");
			//This is not too hard to extend. You just have to make sure that the transformations are 
			// applied recursively on appropriate scop root. You simply need to modify the generation of 
			// point loops to not generate DTiled code, but generate new sets of functions.
			// (There will be some book keeping code that needs to be added w.r.t. the parameter structs.)
		}
		
		HierarchyBandDTilingOptions band = bands.get(0);
		
		//FIXME this is a very bad way to figure out if something is tiled
		boolean isParallel = band.getDTilingOption(band.getTilingLevel()).tileLoopGenerator instanceof DTilerWaveFrontTileLoops;
		
		functionSetID++;
		
		String recurFunctionName = "recur" + functionSetID;
		String baseFunctionName = "base" + functionSetID;
		
		Function baseFunction = createPCOTfunction(baseFunctionName);
		baseFunction.getBodies().add(_CGfact.createUnpackStruct(paramStruct, paramStructVar));
		baseFunction.getBodies().add(_CGfact.createUnpackStruct(localStruct, localStructVar));
		baseFunction.getBodies().add(_CGfact.createUnpackStruct(recurStruct, recurStructVar));
		
		Function recurFunction = createPCOTfunction(recurFunctionName);		
		recurFunction.getBodies().add(_CGfact.createUnpackStruct(paramStruct, paramStructVar));
		recurFunction.getBodies().add(_CGfact.createUnpackStruct(recurStruct, recurStructVar));
		
		unit.getFunctions().add(recurFunction);
		unit.getFunctions().add(baseFunction);		
		
		generateBaseFunctionBody(sloop, band);
		baseFunction.getBodies().add(sloop);
		
		//Body of recursion
		{
			RecursionBody rb = _CGfact.createPCOTRecursionBody(baseFunction, band.getBandStart(), band.getBandEnd());
			rb.setParallel(isParallel);
			
			rb.setParamStruct(paramStruct);
			rb.getRecurStructs().add(recurStruct);
			
			//tile sizes a bit complex due to how it is added to system parameters
			// (even more when multiple level are involved)
			// thus it is added explicitly here
			DTilingOptions dtopt = band.getDTilingOption(band.getTilingLevel());
			rb.getTileSizes().addAll(dtopt.tilingBand.tileSizeName);
			
			recurFunction.getBodies().add(rb);
		}
		
		return generateRecursionEntry(recurFunctionName, domain, isParallel);
	}
	
	private String getTileIndex(int dim) {
//		return CodeGenConstantsForTiling.tileIndexPrefix+dim+"_l"+1;//tiling level is always 1
		return CodeGenConstantsForTiling.tileIndexPrefix+dim;
	}	
	private String getTileWidth(int dim) {
//		return "cw"+dim+"_l"+1;//tiling level is always 1
		return "tw"+dim;
	}
	
	/**
	 * Use the TilingSpecifications that were set aside during mainLoop construction to
	 * initialize DTiler options.
	 * 
	 * @return
	 */
	private HierarchyDTilingOptions initializeHierarchyDTilingOptions(){
		HierarchyDTilingOptions hierarchy_dtiling_options = new HierarchyDTilingOptions();
		
		for(TileSpecification tilespec : tilingSpecs){
			Map<Integer, DTilingOptions> dtiling_options = new HashMap<Integer, DTilingOptions>();
			//create tiling options for each level in the band
			for(int i = 1; i <= tilespec.getSubTiles().size(); i++){
				SubTileSpecification subtile = tilespec.getSubTiles().get(i - 1);
				DTilingOptions options = new DTilingOptions(i, tilespec.getOrderingPrefix(), subtile.getStart(), subtile.getEnd());
				//copy all options into DTilerOptions
				((TiledCodeGenOptions)this.options).populateDTilingOptions(options);
				if(subtile.getTileType() == TILING_TYPE.OMPWAVEFRONT){
					options.tileLoopGenerator = new DTilerWaveFrontTileLoops(options);
				}
//				if (getNumConstantDimensions() > 0 && isOptimize()) {
//					System.err.println("Currently, point loops cannot be optimized when ordering dimensions are present in the STmap.");
//				} else 
//					if (isOptimize()) {
//					options.pointLoopGenerator = new DTilerOptimizedPointLoops(options);
//				}
				
				dtiling_options.put(i, options);
			}
			
			//create the hierarchy dtiling options for the current band 
			HierarchyBandDTilingOptions hierarchy_band_options = hierarchy_dtiling_options.createHierarchyBandDTilingOptions(
					tilespec.getLevels(), tilespec.getStartDim(), tilespec.getEndDim(), dtiling_options);
			
			hierarchy_dtiling_options.addHierarchyBandDTilingOptions(hierarchy_band_options);
		}
		 
		//optimize
				
		return hierarchy_dtiling_options;
	}
	
	/***
	 * The parameter domain is useful to have nicer bounding box. Since the variables used in the 
	 * constraints re-extracted from Scop is no longer in correspondence with the original domain,
	 * having a compatible parameter domain turned out to be more complex than it should be.
	 * 
	 * This method computes a map from original to new indices based on names 
	 *  (which is ok for parameters in the way we generate code) to partially 
	 *  reconstruct the parameter domain (only LB).
	 * 
	 * TODO 
	 * 
	 * @param a
	 * @param newDD
	 * @return
	 */
	private org.polymodel.Domain retrieveParameterDomain(AffineSystem a, DomainDimensions newDD) {


		Map<Variable, Variable> varMapOrigToDom = new HashMap<>();
		for (Variable orgV : a.getParameters().getPMdomain().getParams()) {
			for (Variable domV : newDD.getParameters() ) {
				if (domV.getName().contentEquals(orgV.getName())) {
					varMapOrigToDom.put(orgV, domV);
				}
			}
		}
		
		
		List<IntConstraint> constraints = new LinkedList<>();
		for (Variable origV : varMapOrigToDom.keySet()) {
			IntExpression lb = a.getParameters().getPMdomain().getPolyhedra().get(0).getLB(origV);
			if (lb.isConstant() == FuzzyBoolean.YES) {
				constraints.add(IntExpressionBuilder.ge(IntExpressionBuilder.affine(varMapOrigToDom.get(origV)), lb));
			} else {
				throw new RuntimeException("Unhandled case: parameter lowerbound is not a constant.");
			}
		}
		
		return _PMfact.createDomain(newDD.copy(), IntExpressionBuilder.constraintSystem(constraints));
	
	}
}
	