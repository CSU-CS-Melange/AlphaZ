// *******************************************************************************
// Copyright (C) 2008 Sanjay Rajopadhye. All rights reserved
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, If not, see 
// http://www.gnu.org/licenses/, or write to the Free Software 
// Foundation, Inc., 51 Franklin Street, Fifth Floor,
// Boston, MA  02110-1301, USA.
// *******************************************************************************

package org.polymodel.polyhedralIR.polyIRCG.generator.C;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.impl.AlgebraVisitorImpl;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.ScopGenerator;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.dtiler.AbstractPointLoopGenerator;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.basic.DTilerPointLoops;
import org.polymodel.scop.dtiler.basic.DTilerWaveFrontTileLoops;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOptions;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOptions.HierarchyBandDTilingOptions;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;
import org.polymodel.scop.util.ScopLoopIteratorUtil;

import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;


public class StatementVisitorForPCOTC extends StatementVisitorForScheduledC {
//	protected Function recursiveFunction;
//	protected Function baseFunction;
	private final PolyIRCGUserFactory _CGfact = PolyIRCGUserFactory.INSTANCE;
	
//	private static Boolean DEBUG = false;
	protected List<TileSpecification> tilingSpecs;
	protected int maxTiledDims;
	
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
	
		
	@Override
	public void outAffineSystem(AffineSystem a) {
		SpaceTimeLevel stlevel = targetMapping.getSpaceTimeLevel(0);
		//reflect the statement order
		final List<Equation> torder = targetMapping.getStatementTotalOrder();
		
		//add the statement to the main loop according to the order
		for(Equation eq: torder){
			mainLoop.getStatements().addAll(statementEquationMap.get(eq));
		}
		
		
		CloogOptionSpecifier cloogOptions = CloogOptionSpecifier.optionForFullyNestedLoop(mainLoop.getMaxDimension() - mainLoop.getNumConstantDimensions());
		ScopRoot sroot = ScopGenerator.generateScop(mainLoop.getParameterDomain(), mainLoop.getIteratorNames(), mainLoop.getStatements(), cloogOptions);  

		ScopLoop pcotcLoop = _CGfact.createScopLoop(sroot);
		pcotcLoop.setScopRoot(sroot);
		
		HierarchyDTilingOptions hierarchyDTilingOptions = initializeHierarchyDTilingOptions(pcotcLoop);
		
		List<HierarchyBandDTilingOptions> bands = hierarchyDTilingOptions.getHierarchyBandDTilingOptions();
		
		//Sorting the bands by band start dim
		Collections.sort(bands, new Comparator<HierarchyBandDTilingOptions>() {
			public int compare (HierarchyBandDTilingOptions b1, HierarchyBandDTilingOptions b2) {
				return b1.getBandStart() > b2.getBandStart() ? 1 : b1.getBandStart() == b2.getBandStart() ? 0 : -1;
			}
		});
		
		List<AbstractVariable> variables = new ArrayList<AbstractVariable>();
//		List<VariableDeclaration> variables = new ArrayList<VariableDeclaration>();
		variables.addAll(entryFunction.getInputs());
		variables.addAll(entryFunction.getOutputs());
		variables.addAll(entryFunction.getLocals());
		
		EList<IntExpression> params = new BasicEList<IntExpression>();
		EList<IntExpression> vars = new BasicEList<IntExpression>();
		
		for (String pname : a.getParameters().getParamNames()) {
			params.add(IntExpressionBuilder.affine(IntExpressionBuilder.var(pname)));
		}
		
		/*for (VariableDeclaration var : variables) {
			vars.add(IntExpressionBuilder.affine(IntExpressionBuilder.var(var.getName())));
		}*/
			
		Map<Integer, List<PCOTFunctionInfo>> recursiveFunctionMap = 
				new HashMap<Integer, List<PCOTFunctionInfo>>();
		for (int bandId = 0; bandId <= bands.size(); bandId++) {
			if (bandId <= 1) {
				// 
				vars.clear();
//				for (VariableDeclaration var : variables) {
//					CodeGenVariable cgv = unit.findVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName());
//					vars.add(IntExpressionBuilder
//							.affine(IntExpressionBuilder
//									.var((isScalar(cgv) && bandId == 0) ? 
//											"&"+var.getName() : var.getName())));
//				}
				for (AbstractVariable var : variables) {
//					CodeGenVariable cgv = unit.findVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName());
					vars.add(IntExpressionBuilder
							.affine(IntExpressionBuilder
									.var((isScalar(var) && bandId == 0) ? 
											"&"+var.getName() : var.getName())));
				}
			}
//			System.out.println("band : " + bandId);
			PCOTBand band;
			if (bandId == bands.size()) {
				band = new PCOTBand(stlevel.getNumberOfDimensions()+1, 
						stlevel.getNumberOfDimensions()+1, false);
			} else {				
				band = PCOTBand.getBand(bands.get(bandId));
			}
			
			PCOTScopVisitor.setBlockId(0);
			
			if (bandId == 0) { //create a function info object for the original sroot
				PCOTBand dummyBand = new PCOTBand(1, 0, false);
				
				Map<Integer, List<IntExpression>> bbmap = new HashMap<Integer, List<IntExpression>>();
				for (int d = 1; d <= stlevel.getNumberOfDimensions(); d++) {
					bbmap.put(d, new ArrayList<IntExpression>());
				}
				
				PCOTFunctionInfo pcotFInfo = new PCOTFunctionInfo(bbmap, 
						dummyBand, null, unit.getSystem().getName(), 0);
//						new PCOTFunctionInfo(
//								Collections.<Integer, List<IntExpression>>emptyMap(), 
//								null, 0);
				pcotFInfo.setScopRoot(sroot);
				List<PCOTFunctionInfo> fInfoes = new ArrayList<PCOTFunctionInfo>();
				fInfoes.add(pcotFInfo);
				recursiveFunctionMap.put(bandId, fInfoes);
			} 
			
			List<PCOTFunctionInfo> recFunctions = new ArrayList<PCOTFunctionInfo>();
			
			for (PCOTFunctionInfo fInfo : recursiveFunctionMap.get(bandId)) {
				PCOTBand old = fInfo.getCurrentBand();
				fInfo.setPreviousBand(old);
				fInfo.setCurrentBand(band);
				
				if (bandId < bands.size()) {
					recFunctions.addAll(PCOTScopVisitor.getBaseFunctionBody( 
							unit.getSystem().getName(), params, vars, fInfo));
				}
				
				if (bandId > 0) {//create new functions to generate base code
					//Adding the base function for the recursive function
					Function baseFunction = PolyIRCGUserFactory.INSTANCE.createFunction(
							fInfo.getBaseFunctionName(), "void");
					
					for (int dim =1; dim < fInfo.getPreviousBand().getBandStart(); dim++) {
						BasicVariable fp = _fact.createBasicVariable("c"+dim, "int"); //Since tile iterators are marked as int by default. Something to do with ICC compiler
						baseFunction.getParameters().add(fp);
					}
					
					for (String tileIndex : getTileIteratorsForBand(old)) {
						BasicVariable fp = _fact.createBasicVariable(tileIndex, "int"); //Since tile iterators are marked as int by default. Something to do with ICC compiler
						baseFunction.getParameters().add(fp);
					}
					baseFunction.getInputs().addAll(entryFunction.getInputs());
					baseFunction.getInputs().addAll(entryFunction.getOutputs());
					baseFunction.getInputs().addAll(entryFunction.getLocals());
					
					
					ScopStatementMacro ssm = ScopUserFactory.scopStatementMacro(baseFunction.getName(), Collections.<IntExpression>emptyList());
//					fInfo.getInner().setBody(ssm);
					
					for (ScopFor inner : fInfo.getInner()) {
						inner.setBody(EcoreUtil.copy(ssm));
					}
					
					ScopBlock sb = ScopUserFactory.block(fInfo.getScopRoot().getStatements());
					AbstractPointLoopGenerator aplg = new DTilerPointLoops(bands.get(bandId-1).getDTilingOption(1));
					
					if (fInfo.getCurrentBand().isParallel()) {
						sb.getScopAnnotations().add(ScopUserFactory.parallelBlockAnnotation(Collections.<String>emptyList()));
						sb.getScopAnnotations().add(ScopUserFactory.singleAnnotation());
					}
					
					AbstractScopNode asn = aplg.generate(sb);
					
					ReplaceStatementWithBody replaceStmt = 
							new ReplaceStatementWithBody(fInfo.getBody(), baseFunction.getName());
					asn.accept(replaceStmt);
					
					ScopBlock nsb = ScopUserFactory.scopBlock(asn);
					ScopRoot nsr = ScopUserFactory.scopRoot(nsb);
					ScopLoop pcotLp = _fact.createScopLoop(nsr);
					
//					pcotLp.setScopRoot(fInfo.getScopRoot());
					baseFunction.getBodies().add(pcotLp);
					unit.getFunctions().add(baseFunction);
					
					if (bandId == bands.size()) {
						//add stmt defs
						CollectStatementMacros collect = new CollectStatementMacros();
						asn.accept(collect);
//						List<Statement> stmts = new ArrayList<Statement>();
						for (String macroName : collect.getStmtMacros()) {
							for (Statement stmt : mainLoop.getStatements()) {
								if (macroName.equals(stmt.getName())) {
									pcotLp.getStatements().add(EcoreUtil.copy(stmt));
								}
							}
						}
					}
					
					// Add loop iterator declarations
					pcotLp.getIteratorNames().addAll(ScopLoopIteratorUtil.iteratorNameSet(nsr));
				}
			}
			
			if (bandId < bands.size()) {
				generateRecursiveFunctions(recFunctions);
				recursiveFunctionMap.put(bandId+1, recFunctions);
			}
			
			if (bandId == 0) {
				//add parallel block
				if (band.isParallel()) {
					ScopBlock newBlock = ScopUserFactory.block((List<AbstractScopNode>) EcoreUtil.copyAll(pcotcLoop.getScopRoot().getStatements()));
					newBlock.getScopAnnotations().add(ScopUserFactory.parallelBlockAnnotation(Collections.<String>emptyList()));
					newBlock.getScopAnnotations().add(ScopUserFactory.singleAnnotation());
					pcotcLoop.getScopRoot().getStatements().clear();
					pcotcLoop.getScopRoot().getStatements().add(newBlock);
				}
				// Add loop iterator declarations
				pcotcLoop.getIteratorNames().addAll(ScopLoopIteratorUtil.iteratorNameSet(sroot));
			}
		}
//		mainLoop.getStatements().clear();
		entryFunction.getBodies().add(entryFunction.getBodies().indexOf(mainLoop), pcotcLoop);
		entryFunction.getBodies().remove(mainLoop);
	}
	
	private static class ReplaceStatementWithBody extends ScopDepthFirstVisitorImpl {
		private final List<AbstractScopNode> node;
		private String prefix;
		private int count;
		
		public ReplaceStatementWithBody(List<AbstractScopNode> list, String _prefix) {
			node = list;
			prefix = _prefix;
			count = 0;
		}
		
		@Override
		public void outScopStatementMacro(final ScopStatementMacro s) {
			if(s.getName().contains(prefix)){
				EcoreUtil.replace(s, node.get(count));
				count++;
			}
		}
	}
	
	private static class CollectStatementMacros extends ScopDepthFirstVisitorImpl {
		private List<String> stmtMacros;
		
		public CollectStatementMacros() {
			stmtMacros = new ArrayList<String>();
		}
		
		@Override
		public void outScopStatementMacro(final ScopStatementMacro s) {
			stmtMacros.add(s.getName());
		}
		
		public List<String> getStmtMacros() {
			return stmtMacros;
		}
	}
	
	private void generateRecursiveFunctions(List<PCOTFunctionInfo> recFunctions) {
		for (PCOTFunctionInfo finfo : recFunctions) {
			Function recursiveFunction = 
					PolyIRCGUserFactory.INSTANCE.createFunction(
							finfo.getRecursiveFunctionName(), "void");
			recursiveFunction.getInputs().addAll(entryFunction.getInputs());
			recursiveFunction.getInputs().addAll(entryFunction.getOutputs());
			recursiveFunction.getInputs().addAll(entryFunction.getLocals());
			
			
			PCOTBand b = finfo.getCurrentBand();
			
			for (int dim = 1; dim < b.getBandStart(); dim++) {
				BasicVariable fp = _fact.createBasicVariable("c"+dim, "int"); //Since tile iterators are marked as int by default. Something to do with ICC compiler
				recursiveFunction.getParameters().add(fp);
			}
			
			for (String tileIndex : getTileIteratorsForBand(b)) {
//				String tileIndex = CodeGenConstantsForTiling.tileIndexPrefix+d+"_l"+b.getTilingLevel();
				BasicVariable fp = _fact.createBasicVariable(tileIndex, "int"); //Since tile iterators are marked as int by default. Something to do with ICC compiler
				recursiveFunction.getParameters().add(fp);
			}
			
			
			
			for (String tileWidth : getTileCurrentWidthsForBand(b)) {
//				String tileWidth = "cw"+d+"_l"+b.getTilingLevel();
				BasicVariable fp = _fact.createBasicVariable(tileWidth, "int"); //Since tile iterators are marked as int by default. Something to do with ICC compiler
				recursiveFunction.getParameters().add(fp);
			}
			
			if (finfo.getCurrentBand().isParallel()) {
				BasicVariable fp = _fact.createBasicVariable("recursion_depth", "int");
				recursiveFunction.getParameters().add(fp);
			}
			
			addRecursiveFunctionBody(finfo, recursiveFunction);
			
			unit.getFunctions().add(recursiveFunction);
			
			/**/
		}
		
	}

	private void addRecursiveFunctionBody(PCOTFunctionInfo finfo, 
			Function recursiveFunction) {
		PCOTBand band = finfo.getCurrentBand();
		// We assume only 1 level of tiling
		boolean isParallel = band.isParallel();
		
		// check width of at-least one dimension is zero and return
		recursiveFunction.getBodies().add(_fact.createBody(
				"//Return if width of the orthant is 0"));
		recursiveFunction.getBodies().add(
				_fact.createBody(getDimensionWidthCheck(finfo, 
						recursiveFunction.getInputs())));
		
		//check for empty boxes
		String emptinessCheck = getEmptyBoxCheck(finfo, 
				recursiveFunction.getInputs());
		if (emptinessCheck.length()>0) {
			recursiveFunction.getBodies().add(_fact.createBody(
					"//Return if the orthant is outside of original domain"));
			recursiveFunction.getBodies().add(
					_fact.createBody(emptinessCheck));
		}
		
		// base case check
		recursiveFunction.getBodies().add(_fact.createBody("//Call the base function"));
		recursiveFunction.getBodies().add(
				_fact.createBody(getBaseCaseConditionCheck(finfo, 
						recursiveFunction.getInputs())));
		// recursive calls to recursiveFunction
		
		
		int startDim = band.getBandStart();
		int endDim = band.getBandEnd();
		int numTiledDims = endDim - startDim + 1;
		int numRecursiveCalls = (int) Math.pow(2, numTiledDims);
		
		StringBuilder halftw = new StringBuilder();
		halftw.append("int ");
		
		List<String> halftwNames = new ArrayList<String>();
		List<String> halftwDef = new ArrayList<String>();
		for (String tileSize : getTileSizesForBand(band)) {
			String tileHalfWidthName = tileSize.replace(CodeGenConstantsForTiling.tileSizePrefix, "hcw");
			String tileWidthName = tileSize.replace(CodeGenConstantsForTiling.tileSizePrefix, "cw");
			
			halftwNames.add(tileHalfWidthName);
			StringBuilder def = new StringBuilder();
			def.append(tileHalfWidthName);
			def.append(" = ");
			def.append(tileWidthName).append(" > ").append(tileSize);
			def.append(" ? ").append(tileWidthName).append("/2");
			def.append(" : ").append(tileWidthName);
			def.append(";");
			
			halftwDef.add(def.toString());
			halftw.append(tileHalfWidthName);
			halftw.append(", ");
		}
		
		//remove extra ", "
		if (halftw.length()>4) {
			halftw.delete(halftw.length()-2, halftw.length());
			halftw.append(";");
			recursiveFunction.getBodies().add(
					_fact.createBody(halftw.toString()));
		}
		
		for (String def : halftwDef) {
			recursiveFunction.getBodies().add(
					_fact.createBody(def));
		}
		
		if (isParallel) { // Parallelize the recursive function calls by using omp tasks
			Map<Integer, List<String>> parallelWavefronts = 
					new HashMap<Integer, List<String>>();
			for (int fcall = 0; fcall < numRecursiveCalls; fcall++) {
				int wid = getWavefrontId(fcall, halftwNames.size());
				List<String> waveFront = parallelWavefronts.get(wid);
				if (waveFront == null) {
					waveFront = new ArrayList<String>();
					parallelWavefronts.put(wid, waveFront);
				}
				waveFront.add(getRecursiveFunctionCall(finfo, 
						fcall, halftwNames, recursiveFunction.getInputs()));
			}
			
			List<Integer> wids = new ArrayList<>(parallelWavefronts.keySet());
			Collections.sort(wids);
			
			for (int wid : wids) {
				List<String> wavefront = parallelWavefronts.get(wid);
				if (wavefront.size()>1) {
					StringBuilder parallelCalls = new StringBuilder();
					
//					for (String wf : wavefront) {
//						parallelCalls.append("#pragma omp task\n");
//						parallelCalls.append(wf);
//						parallelCalls.append("\n");
//					}
//					
					for (int w = 0; w<wavefront.size(); w++) {
						String wf = wavefront.get(w);
						if (w<wavefront.size()-1) { // the last task will always be done by the parent thread
							parallelCalls.append("#pragma omp task if (recursion_depth<rec_depth)\n");
						}
						parallelCalls.append(wf);
						parallelCalls.append("\n");
					}
					
					parallelCalls.append("#pragma omp taskwait");
					recursiveFunction.getBodies().add(
							_fact.createBody(parallelCalls.toString()));
				} else {
					recursiveFunction.getBodies().add(
							_fact.createBody(wavefront.get(0)));
				}
			}
			
		} else {
			for (int fcall = 0; fcall < numRecursiveCalls; fcall++) {
				recursiveFunction.getBodies().add(
						_fact.createBody(getRecursiveFunctionCall(finfo, 
								fcall, halftwNames, 
								recursiveFunction.getInputs())));
			}
		}
	}
	
	private String getEmptyBoxCheck(PCOTFunctionInfo finfo,
			EList<AbstractVariable> inputs) {
		List<List<IntConstraint>> constraints = new ArrayList<List<IntConstraint>>(); 
		
		List<String> loopIteratorsForBand = finfo.getCurrentBand().getLoopIterators();
		
		boolean isConstant = true;
		// Check whether all the bounds are constants. Then we do not need to 
		// check for emptiness as original domain bounds are along canonical axes
		// Or boundaries are not oblique
		for (List<IntExpression> value : finfo.getConvexHull().values()) {
			for (IntExpression ie : value) {
//				if (!ie.isConstant().equals(FuzzyBoolean.YES)) {
//					isConstant=false;
////					break;
//				}
				
				if (ContainsVariables.contains(ie, loopIteratorsForBand)) {
					isConstant = false;
					break;
				}
			}
			if (!isConstant) {
				break;
			}
		}
		
		if (isConstant) {
			return "";
		}
		
		for (Entry<Integer, List<IntExpression>> entry : finfo.getConvexHull().entrySet()) {
			List<IntExpression> bounds = entry.getValue();
			int dim = entry.getKey();
			
			String tileIdx = getTileIndex(dim);
			String tileWidth = getTileWidth(dim);
			
			IntExpression lb = bounds.get(0);
			IntExpression ub = bounds.get(1);
			//TODO
			List<IntConstraint> lbConstraint = new ArrayList<IntConstraint>();
			List<IntConstraint> ubConstraint = new ArrayList<IntConstraint>();
			
			//irrespective of the number of dimensions, along each dimension we 
			//have two distinct indices
//			String tileIdx1 = tileIdx;
//			String tileIdx2 = tileIdx + "+" + tileWidth;
			
//			if (!lb.isConstant().equals(FuzzyBoolean.YES)) {
				addConstraints(finfo, lb, tileIdx, tileWidth, lbConstraint, false);
				constraints.add(lbConstraint);
//			}
//			if (!ub.isConstant().equals(FuzzyBoolean.YES)) {
				addConstraints(finfo, ub, tileIdx, tileWidth, ubConstraint, true);
				constraints.add(ubConstraint);
//			}
			
//			if (!lb.isConstant().equals(FuzzyBoolean.YES)) {
//				//replace the outer loop indices by corresponding tile index
//				
//			}
		}
		
		if (constraints.isEmpty()) { //no checks needed
			return "";
		}
		
		StringBuilder emptynessCheck = new StringBuilder();
		emptynessCheck.append("if(");
		
		for (List<IntConstraint> constraint : constraints) {
			if (constraint.size()>0) {
				emptynessCheck.append("(");
			}
			
			for (IntConstraint ic : constraint) {
				emptynessCheck.append(ic.toString(OUTPUT_FORMAT.C));
				emptynessCheck.append("&&");
			}
			
			if (constraint.size()>0) {	
				//remove extra "&&"
				emptynessCheck.delete(emptynessCheck.length()-2, emptynessCheck.length());
				emptynessCheck.append(")");
			}
			
			emptynessCheck.append("||");
		}
		
		//remove extra "||"
		emptynessCheck.delete(emptynessCheck.length()-2, emptynessCheck.length());
//		emptynessCheck.append(")");
		
		emptynessCheck.append(") {");
		emptynessCheck.append("\n\treturn;\n");
		emptynessCheck.append("}\n");
		return emptynessCheck.toString();
	}

	private void addConstraints(PCOTFunctionInfo finfo, IntExpression lb,
			String tileIdx1, String tileIdx2, List<IntConstraint> constraint, boolean isUB) {
		int count = CountDistinctTilableLoopIndices.count(lb, 
				finfo.getLoopVars(), finfo.getCurrentBand().getBandStart());
		int numCombinations = (int) Math.pow(2, count);
		
		if (!lb.isConstant().equals(FuzzyBoolean.YES) && count > 0) {
		
			for (int combination=0; combination<numCombinations; combination++) {
				int bandWidth = finfo.getCurrentBand().getBandEnd() - 
						finfo.getCurrentBand().getBandStart() + 1;
				Map<String, List<AffineTerm>> loopToTileIdx = new HashMap<String, List<AffineTerm>>();
				for (int d=0; d<bandWidth; d++) {
					int bit = getBit(combination, d);
					int dimention = d+finfo.getCurrentBand().getBandStart();
					List<AffineTerm> terms = new ArrayList<AffineTerm>();
					
					AffineTerm at1 = IntExpressionBuilder.term(IntExpressionBuilder.var(getTileIndex(dimention)));
					terms.add(at1);
					if (bit == 1) {
						AffineTerm at2 = IntExpressionBuilder.term(IntExpressionBuilder.var(getTileWidth(dimention)));
						terms.add(at2);
					}
					loopToTileIdx.put("c"+dimention, terms);
				}
				
				IntExpression newLb = ReplaceLoopIndicesByCorrespondingTileIndices.updateBounds(lb.copy(), 
						finfo.getLoopVars(), loopToTileIdx, 
						finfo.getCurrentBand().getBandStart());
				
				AffineExpression tileIdxExp1 = IntExpressionBuilder
						.affine(IntExpressionBuilder.var(tileIdx1)); 
				IntConstraint ic1 = isUB 
						? IntExpressionBuilder.lt(newLb, tileIdxExp1) 
						: IntExpressionBuilder.gt(newLb, tileIdxExp1);
				constraint.add(ic1);
				IntExpression tileIdxExp2 = IntExpressionBuilder.sum(tileIdxExp1, 
						IntExpressionBuilder.affine(IntExpressionBuilder.var(tileIdx2))); 
				IntConstraint ic2 = isUB 
						? IntExpressionBuilder.lt(newLb, tileIdxExp2).simplify() 
						: IntExpressionBuilder.gt(newLb, tileIdxExp2).simplify();
				constraint.add(ic2);
			}
		
		} else {
			AffineExpression tileIdxExp1 = IntExpressionBuilder
					.affine(IntExpressionBuilder.var(tileIdx1)); 
			IntConstraint ic1 = isUB 
					? IntExpressionBuilder.lt(lb, tileIdxExp1) 
					: IntExpressionBuilder.gt(lb, tileIdxExp1);
			constraint.add(ic1);
			IntExpression tileIdxExp2 = IntExpressionBuilder.sum(tileIdxExp1, 
					IntExpressionBuilder.affine(IntExpressionBuilder.var(tileIdx2))); 
			IntConstraint ic2 = isUB 
					? IntExpressionBuilder.lt(lb, tileIdxExp2).simplify() 
					: IntExpressionBuilder.gt(lb, tileIdxExp2).simplify();
			constraint.add(ic2);
		}
	}
	
	private static class ReplaceLoopIndicesByCorrespondingTileIndices extends AlgebraVisitorImpl {
		Map<String, Integer> loopVarNames; // loop iterator name and the depth
		Map<String, List<AffineTerm>> loopToTileIdx;
		int startDim;
		
		List<AffineTerm> tobeRemoved;
		List<AffineTerm> tobeAdded;
		
		public ReplaceLoopIndicesByCorrespondingTileIndices(
				Map<String, Integer> loopVarNames, 
				Map<String, List<AffineTerm>> loopToTileIdx, int startDim) {
			this.loopVarNames = loopVarNames;
			this.loopToTileIdx = loopToTileIdx;
			this.startDim = startDim;
			this.tobeAdded = new ArrayList<AffineTerm>();
			this.tobeRemoved = new ArrayList<AffineTerm>();			
		}
		
		public static IntExpression updateBounds(IntExpression bound,
				Map<String, Integer> loopVarNames, Map<String, 
				List<AffineTerm>> loopToTileIdx, int startDim) {
			ReplaceLoopIndicesByCorrespondingTileIndices pcotExpVisitor = 
					new ReplaceLoopIndicesByCorrespondingTileIndices(loopVarNames,
							loopToTileIdx, startDim); 
			bound.accept(pcotExpVisitor);
			
			return bound;
		}
		

		@Override
		public void visitAffineExpression(final AffineExpression a) {
			tobeAdded.clear();
			tobeRemoved.clear();
			
			for(AffineTerm o: a.getTerms())
				 o.accept(this);
			
			a.getTerms().removeAll(tobeRemoved);
			a.getTerms().addAll(tobeAdded);
		}
		
		@Override
		public void visitAffineTerm(AffineTerm a) {
			if (a.getVariable() == null) {
				return;
			}
			
			String varName = a.getVariable().getName();
			Integer dim = loopVarNames.get(varName);
			if (dim == null) {
				return;
			}
			
			if (dim < startDim) { //this is not a tile index
				return;
			}
			
			if (a.getCoef()>=0) {
				tobeAdded.addAll(loopToTileIdx.get(varName));
			} else {
				for (AffineTerm at : loopToTileIdx.get(varName)) {
					tobeAdded.add(IntExpressionBuilder.neg(at));	
				}
			}
			
			tobeRemoved.add(a);
		}
	}

	
	private static class CountDistinctTilableLoopIndices extends AlgebraVisitorImpl {
		Map<String, Integer> loopVarNames; // loop iterator name and the depth
		
		Map<Integer, Boolean> found;
		int tileStartDim;
		
		
		public CountDistinctTilableLoopIndices(
				Map<String, Integer> loopVarNames, int tileStartDim) {
			this.loopVarNames = loopVarNames;
			this.found = new HashMap<Integer, Boolean>();
			this.tileStartDim = tileStartDim;
		}
	
	
		public static int count(IntExpression lb,
				Map<String, Integer> loopVarNames, int tileStartDim) {
			CountDistinctTilableLoopIndices pcotExpVisitor = 
					new CountDistinctTilableLoopIndices(loopVarNames, tileStartDim); 
			lb.accept(pcotExpVisitor);
			
			return pcotExpVisitor.found.size();
		}


		@Override
		public void visitVariable(Variable v) {
			if (v.getName() == null) {
				return;
			}
			Integer dim = loopVarNames.get(v.getName());
			if (dim == null) {
				return;
			}
			if (dim >= tileStartDim) {
				found.put(dim, true);
			}
		}
	}
	
	private static class ContainsVariables extends AlgebraVisitorImpl {
		List<String> loopVarNames; // loop iterator names
		
		boolean contains = false;
		
		
		public ContainsVariables(List<String> loopVarNames) {
			this.loopVarNames = loopVarNames;
		}
	
	
		public static boolean contains(IntExpression bound, List<String> loopVarNames) {
			ContainsVariables containVars = new ContainsVariables(loopVarNames); 
			bound.accept(containVars);
			
			return containVars.contains;
		}


		@Override
		public void visitVariable(Variable v) {
			if (contains) {
				return;
			}
			
			if (v.getName() == null) {
				return;
			}
			
			if (loopVarNames.contains(v.getName())) {
				contains = true;
			}
		}
	}
	
	private String getTileWidth(int dim) {
		return "cw"+dim+"_l"+1;//tiling level is always 1
	}

	private String getDimensionWidthCheck(PCOTFunctionInfo finfo,
			EList<AbstractVariable> inputs) {
		StringBuilder tileWidthCheck = new StringBuilder();
		tileWidthCheck.append("if(");
		
		for (String tileWidthName : getTileCurrentWidthsForBand(finfo.getCurrentBand())) {
			tileWidthCheck.append(tileWidthName).append("==0");
			tileWidthCheck.append("||");
		}
		
		//remove extra "||"
		if (tileWidthCheck.length()>3) {
			tileWidthCheck.delete(tileWidthCheck.length()-2, tileWidthCheck.length());
		}
		
		tileWidthCheck.append(") {");
		tileWidthCheck.append("\n\treturn;\n");
		tileWidthCheck.append("}\n");
		return tileWidthCheck.toString();
	}

	private String getRecursiveFunctionCall(PCOTFunctionInfo finfo, int fcall, 
			List<String> halftwNames, EList<AbstractVariable> vars) {
		StringBuilder fc = new StringBuilder();
		
		fc.append(finfo.getRecursiveFunctionName());
		fc.append("(");
		
		for (String param : unit.getSystem().getParameters().getParamNames()) {
			fc.append(param);
			fc.append(", ");
		}
		
		for (int dim=1; dim <finfo.getCurrentBand().getBandStart(); dim++) {
			fc.append("c").append(dim);
			fc.append(", ");
		}
		
		int numTiledDims = halftwNames.size();
		List<String> newTileWidths = new ArrayList<String>();
		for (int dim = 0; dim < numTiledDims; dim++) {
			int bit = getBit(fcall, dim);
			//half tile width
			String halftw = halftwNames.get(dim);
			// tile index
			String ti = halftw.replace("hcw", 
					CodeGenConstantsForTiling.tileIndexPrefix);
			StringBuilder width = new StringBuilder();
			if (bit == 0) {
				width.append(halftw);
				fc.append(ti);
			} else {
				width.append(halftw.replace("hcw", "cw"));
				width.append("-");
				width.append(halftw);
				
				fc.append(ti).append(" + ").append(halftw);
			}
			
			newTileWidths.add(width.toString());
			fc.append(", ");
		}
		
		for (String newTileWidth : newTileWidths) {
			fc.append(newTileWidth);
			fc.append(", ");
		}

		if (finfo.getCurrentBand().isParallel()) {
			fc.append("recursion_depth+1");
			fc.append(", ");
		}
		
		for (AbstractVariable cv : vars) {
			fc.append(cv.getName());
			fc.append(", ");
		}
		
		if (fc.length()>2) {
			fc.delete(fc.length()-2, fc.length());
		}
		
		fc.append(");");
		return fc.toString();
	}
	

	private int getWavefrontId(int tileId, int nDims) {
		int wid = 0;
		for (int d = 0; d<nDims; d++) {
			wid += getBit(tileId, d);
		}
		return wid;
	}
	
	private String getBaseCaseConditionCheck(PCOTFunctionInfo finfo, 
			EList<AbstractVariable> vars) {
		StringBuilder baseCaseCheck = new StringBuilder();
		baseCaseCheck.append("if(");
		
		for (String tileWidthName : getTileCurrentWidthsForBand(finfo.getCurrentBand())) {
			String tileSize = tileWidthName.replace("cw", 
					CodeGenConstantsForTiling.tileSizePrefix);
			//tileWidth <= tileSizeLimit
			baseCaseCheck.append(tileWidthName).append("<=").append(tileSize);
			baseCaseCheck.append("&&");
		}
		
		//remove extra "&&"
		if (baseCaseCheck.length()>3) {
			baseCaseCheck.delete(baseCaseCheck.length()-2, baseCaseCheck.length());
		}
		
		baseCaseCheck.append(") {\n\t");
		baseCaseCheck.append(getBaseFunctionCall(finfo, vars));
		baseCaseCheck.append("\n\treturn;\n");
		baseCaseCheck.append("}\n");
		return baseCaseCheck.toString();
	}
	
	private String getBaseFunctionCall(PCOTFunctionInfo finfo, 
			EList<AbstractVariable> vars) {
		StringBuilder fc = new StringBuilder();
		fc.append(finfo.getBaseFunctionNameForFunctionCall());
		fc.append("(");
		
		PCOTBand band = finfo.getCurrentBand();
		
		int startDim = band.getBandStart();
		int endDim = band.getBandEnd();
		String[] argList = new String[(endDim-startDim+1)];
		int dim = 0;
		
		for (String param : unit.getSystem().getParameters().getParamNames()) {
			if (param.startsWith(CodeGenConstantsForTiling.tileSizePrefix) 
					&& startDim <= getDim(param) && getDim(param) <= endDim) {
				String tileWidth = param.replace(CodeGenConstantsForTiling.tileSizePrefix, "cw");
				String tileOrigin = param.replace(CodeGenConstantsForTiling.tileSizePrefix, "ti");
				argList[dim] = tileOrigin;
//				argList[dim+endDim-startDim+1] = tileOrigin;
				dim++;
				fc.append(tileWidth);
				fc.append(", ");
				continue;
			}
			fc.append(param);
			fc.append(", ");
		}
		
		for (int d = 1; d < startDim; d++) {
			fc.append("c").append(d);
			fc.append(", ");
		}
		
		for (String arg : argList) {
			fc.append(arg);
			fc.append(", ");
		}
		
		for (AbstractVariable cv : vars) {
			fc.append(cv.getName());
			fc.append(", ");
		}
		if (fc.length()>finfo.getBaseFunctionName().length()+1) {
			fc.delete(fc.length()-2, fc.length());
		}
		
		fc.append(");");
		return fc.toString();
	}
	
	private int getDim(String tileSizeName) {
//		System.out.println("TSN: " + tileSizeName);
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(tileSizeName);
		
		String dim = null;
		if (m.find()) {
			dim = m.group();
		} else {
			throw new RuntimeException("Dimention cannot be infered by the tile "
					+ "size parameter name");
		}
		return Integer.parseInt(dim);
	}
	
	private List<String> getTileIteratorsForBand(PCOTBand b) {
		List<String> tileIndices = new ArrayList<String>();
		
		for (int d = b.getBandStart(); d <= b.getBandEnd(); d++) {
			String tileIndex = CodeGenConstantsForTiling.tileIndexPrefix+d+"_l"+1; //tiling level is always 1
			tileIndices.add(tileIndex);
		}
		
		return tileIndices;
	}
	
	private List<String> getTileSizesForBand(PCOTBand b) {
		List<String> tileIndices = new ArrayList<String>();
		
		for (int d = b.getBandStart(); d <= b.getBandEnd(); d++) {
			String tileIndex = CodeGenConstantsForTiling.tileSizePrefix+d+"_l"+1; //tiling level is always 1
			tileIndices.add(tileIndex);
		}
		
		return tileIndices;
	}
	
	private List<String> getTileCurrentWidthsForBand(PCOTBand b) {
		List<String> tileWidths = new ArrayList<String>();
		
		for (int d = b.getBandStart(); d <= b.getBandEnd(); d++) {
			String tileWidth = "cw"+d+"_l"+1;//tiling level is always 1
			tileWidths.add(tileWidth);
		}
		
		return tileWidths;
	}
	
	private String getTileIndex(int dim) {
		return CodeGenConstantsForTiling.tileIndexPrefix+dim+"_l"+1;//tiling level is always 1
	}	
	
	private int getBit(int n, int k) {
	    return (n >> k) & 1;
	}
	
	private HierarchyDTilingOptions initializeHierarchyDTilingOptions(ScopLoop pcotcLoop){
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
	
	
	
	
	/*private HierarchyDTilingOptions initializeHierarchyDTilingOptions(TiledCLoop tiledLoop){
		HierarchyDTilingOptions hierarchy_dtiling_options = new HierarchyDTilingOptions();
		
		for(TileSpecification tilespec : tiledLoop.getTiles()){
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
				if (tiledLoop.getNumConstantDimensions() > 0 && tiledLoop.isOptimize()) {
					System.err.println("Currently, point loops cannot be optimized when ordering dimensions are present in the STmap.");
				} else 
					if (tiledLoop.isOptimize()) {
					options.pointLoopGenerator = new DTilerOptimizedPointLoops(options);
				}
				
				dtiling_options.put(i, options);
			}
			
			//create the hierarchy dtiling options for the current band 
			HierarchyBandDTilingOptions hierarchy_band_options = hierarchy_dtiling_options.createHierarchyBandDTilingOptions(
					tilespec.getLevels(), tilespec.getStartDim(), tilespec.getEndDim(), dtiling_options);
			
			hierarchy_dtiling_options.addHierarchyBandDTilingOptions(hierarchy_band_options);
		}
		 
		//optimize
				
		return hierarchy_dtiling_options;
	}*/
	
	/*private String getRecursiveFunctionCall(SpaceTimeLevel stlevel, int fcall, 
			List<String> htwNames) {
		StringBuilder fc = new StringBuilder();
		
		for (String param : unit.getSystem().getParameters().getParamNames()) {
			fc.append(param);
			fc.append(", ");
		}
		
		
		
		int numTiledDims = htwNames.size();
		List<String> newTileWidths = new ArrayList<String>();
		for (int dim = 0; dim < numTiledDims; dim++) {
			int bit = getBit(fcall, dim);
			//half tile width
			String htw = htwNames.get(dim);
			// tile index
			String ti = htw.replace("hcw", 
					CodeGenConstantsForTiling.tileIndexPrefix);
			StringBuilder width = new StringBuilder();
			if (bit == 0) {
				width.append(htw);
				fc.append(ti);
			} else {
				width.append(htw.replace("hcw", "cw"));
				width.append("-");
				width.append(htw);
				
				fc.append(ti).append(" + ").append(htw);
			}
			
			newTileWidths.add(width.toString());
			fc.append(", ");
		}
		
		for (String newTileWidth : newTileWidths) {
			fc.append(newTileWidth);
			fc.append(", ");
		}

		for (CodeGenVariable cv : recursiveFunction.getInputs()) {
			fc.append(cv.getName());
			fc.append(", ");
		}
		
		if (fc.length()>recursiveFunction.getName().length()+1) {
			fc.delete(fc.length()-2, fc.length());
		}
		
		fc.append(");");
		return fc.toString();
	}
*/

	/*private void addRecursiveFunctionBody(AffineSystem a, SpaceTimeLevel stlevel, boolean isParallel) {
		// base case check
		recursiveFunction.getBodies().add(
				_fact.createBody(getBaseCaseConditionCheck(a, stlevel)));
		// recursive calls to recursiveFunction
		int startDim = stlevel.getTilingSpecifications().get(0).getStartDim(); // Assumed to have just one tiling spec
		int endDim = stlevel.getTilingSpecifications().get(0).getEndDim(); // Assumed to have just one tiling spec
		int numTiledDims = endDim - startDim + 1;
		int numRecursiveCalls = (int) Math.pow(2, numTiledDims);
		
		StringBuilder htw = new StringBuilder();
		htw.append("int ");
		
		List<String> htwNames = new ArrayList<String>();
		List<String> htwDef = new ArrayList<String>();
		for (String tileSize : CodeGeneratorTemplateForC.getTileSizesForDTiling(a)) {
			String tileHalfWidthName = tileSize.replace(CodeGenConstantsForTiling.tileSizePrefix, "hcw");
			String tileWidthName = tileSize.replace(CodeGenConstantsForTiling.tileSizePrefix, "cw");
			
			htwNames.add(tileHalfWidthName);
			StringBuilder def = new StringBuilder();
			def.append(tileHalfWidthName);
			def.append(" = ");
			def.append(tileWidthName).append(" > ").append(tileSize);
			def.append(" ? ").append(tileWidthName).append("/2");
			def.append(" : ").append(tileWidthName);
			def.append(";");
			
			htwDef.add(def.toString());
			htw.append(tileHalfWidthName);
			htw.append(", ");
		}
		
		//remove extra ", "
		if (htw.length()>4) {
			htw.delete(htw.length()-2, htw.length());
			htw.append(";");
			recursiveFunction.getBodies().add(
					_fact.createBody(htw.toString()));
		}
		
		for (String def : htwDef) {
			recursiveFunction.getBodies().add(
					_fact.createBody(def));
		}
		
		if (isParallel) { // Parallelize the recursive function calls by using omp tasks
			Map<Integer, List<String>> parallelWavefronts = 
					new HashMap<Integer, List<String>>();
			for (int fcall = 0; fcall < numRecursiveCalls; fcall++) {
				int wid = getWavefrontId(fcall, htwNames.size());
				List<String> waveFront = parallelWavefronts.get(wid);
				if (waveFront == null) {
					waveFront = new ArrayList<String>();
					parallelWavefronts.put(wid, waveFront);
				}
				waveFront.add(getRecursiveFunctionCall(stlevel, 
						fcall, htwNames));
			}
			
			List<Integer> wids = new ArrayList<>(parallelWavefronts.keySet());
			Collections.sort(wids);
			
			for (int wid : wids) {
				List<String> wavefront = parallelWavefronts.get(wid);
				if (wavefront.size()>1) {
					StringBuilder parallelCalls = new StringBuilder();
					
					for (String wf : wavefront) {
						parallelCalls.append("#pragma omp task\n");
						parallelCalls.append(wf);
						parallelCalls.append("\n");
					}
					parallelCalls.append("#pragma omp taskwait");
					recursiveFunction.getBodies().add(
							_fact.createBody(parallelCalls.toString()));
				} else {
					recursiveFunction.getBodies().add(
							_fact.createBody(wavefront.get(0)));
				}
			}
			
		} else {
			for (int fcall = 0; fcall < numRecursiveCalls; fcall++) {
				recursiveFunction.getBodies().add(
						_fact.createBody(getRecursiveFunctionCall(stlevel, 
								fcall, htwNames)));
			}
		}
	}

	private int getWavefrontId(int tileId, int nDims) {
		int wid = 0;
		for (int d = 0; d<nDims; d++) {
			wid += getBit(tileId, d);
		}
		return wid;
	}

	private String getRecursiveFunctionCall(SpaceTimeLevel stlevel, int fcall, 
			List<String> htwNames) {
		StringBuilder fc = new StringBuilder();
		fc.append(recursiveFunction.getName());
		fc.append("(");
		for (String param : unit.getSystem().getParameters().getParamNames()) {
			fc.append(param);
			fc.append(", ");
		}
		
		int numTiledDims = htwNames.size();
		List<String> newTileWidths = new ArrayList<String>();
		for (int dim = 0; dim < numTiledDims; dim++) {
			int bit = getBit(fcall, dim);
			//half tile width
			String htw = htwNames.get(dim);
			// tile index
			String ti = htw.replace("hcw", 
					CodeGenConstantsForTiling.tileIndexPrefix);
			StringBuilder width = new StringBuilder();
			if (bit == 0) {
				width.append(htw);
				fc.append(ti);
			} else {
				width.append(htw.replace("hcw", "cw"));
				width.append("-");
				width.append(htw);
				
				fc.append(ti).append(" + ").append(htw);
			}
			
			newTileWidths.add(width.toString());
			fc.append(", ");
		}
		
		for (String newTileWidth : newTileWidths) {
			fc.append(newTileWidth);
			fc.append(", ");
		}

		for (CodeGenVariable cv : recursiveFunction.getInputs()) {
			fc.append(cv.getName());
			fc.append(", ");
		}
		
		if (fc.length()>recursiveFunction.getName().length()+1) {
			fc.delete(fc.length()-2, fc.length());
		}
		
		fc.append(");");
		return fc.toString();
	}

	
	 * Return the k th bit of n
	 
	private int getBit(int n, int k) {
	    return (n >> k) & 1;
	}
	
	private String getBaseCaseConditionCheck(AffineSystem a,
			SpaceTimeLevel stlevel) {
		StringBuilder baseCaseCheck = new StringBuilder();
		baseCaseCheck.append("if(");
		
		for (String tileSize : CodeGeneratorTemplateForC.getTileSizesForDTiling(a)) {
			String tileWidthName = tileSize.replace(CodeGenConstantsForTiling.tileSizePrefix, "cw");
			//tileWidth <= tileSizeLimit
			baseCaseCheck.append(tileWidthName).append("<=").append(tileSize);
			baseCaseCheck.append("&&");
		}
		
		//remove extra "&&"
		if (baseCaseCheck.length()>3) {
			baseCaseCheck.delete(baseCaseCheck.length()-2, baseCaseCheck.length());
		}
		
		baseCaseCheck.append(") {\n\t");
		baseCaseCheck.append(getBaseFunctionCall(stlevel));
		baseCaseCheck.append("\n\treturn;\n");
		baseCaseCheck.append("}\n");
		return baseCaseCheck.toString();
	}

	private String getBaseFunctionCall(SpaceTimeLevel stlevel) {
		StringBuilder fc = new StringBuilder();
		fc.append(baseFunction.getName());
		fc.append("(");
		
		int startDim = stlevel.getTilingSpecifications().get(0).getStartDim(); // Assumed to have just one tiling spec
		int endDim = stlevel.getTilingSpecifications().get(0).getEndDim(); // Assumed to have just one tiling spec
		String[] argList = new String[2*(endDim-startDim+1)];
		int dim = 0;
		
		for (String param : unit.getSystem().getParameters().getParamNames()) {
			if (param.startsWith(CodeGenConstantsForTiling.tileSizePrefix)) {
				String tileWidth = param.replace(CodeGenConstantsForTiling.tileSizePrefix, "cw");
				String tileOrigin = param.replace(CodeGenConstantsForTiling.tileSizePrefix, "ti");
				argList[dim] = tileWidth;
				argList[dim+endDim-startDim+1] = tileOrigin;
				dim++;
				continue;
			}
			fc.append(param);
			fc.append(", ");
		}
		
		for (String arg : argList) {
			fc.append(arg);
			fc.append(", ");
		}
		
		for (CodeGenVariable cv : recursiveFunction.getInputs()) {
			fc.append(cv.getName());
			fc.append(", ");
		}
		if (fc.length()>recursiveFunction.getName().length()+1) {
			fc.delete(fc.length()-2, fc.length());
		}
		
		fc.append(");");
		return fc.toString();
	}
	
	private String getRecursiveFunctionCall(SpaceTimeLevel stlevel, boolean isParallel) {
		StringBuilder fc = new StringBuilder();
		
		if (isParallel) {
			//initiate openmp pallel block
			fc.append("\n#pragma omp parallel\n");
			fc.append("#pragma omp single\n");
		}
		
		fc.append(recursiveFunction.getName());
		fc.append("(");
		for (String param : unit.getSystem().getParameters().getParamNames()) {
			fc.append(param);
			fc.append(", ");
		}
		int startDim = stlevel.getTilingSpecifications().get(0).getStartDim(); // Assumed to have just one tiling spec
		int endDim = stlevel.getTilingSpecifications().get(0).getEndDim(); // Assumed to have just one tiling spec
		String[] argList = new String[2*(endDim-startDim+1)];
		Domain bb = getBoundingBox(unit.getSystem());
		for (int dim = startDim; dim <= endDim; dim ++) {
			List<IntExpression> bounds = bb.getBounds(dim);
			AffineExpression lb = bounds.get(0).toAffine();
			lb.simplify();
			AffineExpression diff = IntExpressionBuilder.add(IntExpressionBuilder.sub(bounds.get(1), bounds.get(0)), 1).simplify().toAffine();
			diff.simplify();
			argList[dim-startDim] = lb.toString(OUTPUT_FORMAT.C);
			argList[dim-2*startDim+endDim+1] = diff.toString(OUTPUT_FORMAT.C);
//			argList[dim-startDim] = bounds.get(0).toString(OUTPUT_FORMAT.C);
//			argList[dim-2*startDim+endDim+1] = IntExpressionBuilder.sub(bounds.get(1), bounds.get(0)).toString(OUTPUT_FORMAT.C);
		}
		
		for (String arg : argList) {
			fc.append(arg);
			fc.append(", ");
		}
		
		for (CodeGenVariable cv : recursiveFunction.getInputs()) {
			if (isScalar(cv)) {
				fc.append("&");
			} 
			
			fc.append(cv.getName());
			fc.append(", ");
		}
		if (fc.length()>recursiveFunction.getName().length()+1) {
			fc.delete(fc.length()-2, fc.length());
		}
		
		fc.append(");");
		return fc.toString();
	}*/
	
	public static boolean isScalar(AbstractVariable v) {
		if (v instanceof CodeGenVariable) {
			CodeGenVariable cgv = (CodeGenVariable)v;
			return cgv.getDomain().getNIndices() == 0;
		}
		return true;
	}
	
	static Domain getBoundingBox(AffineSystem system) {
		Domain union = null;
		List<VariableDeclaration> vars = new ArrayList<VariableDeclaration>();

		vars.addAll(system.getLocals());
		vars.addAll(system.getOutputs());
		
		boolean isFirst = true;
		
		for (VariableDeclaration v : vars) {
			if (isFirst) {
				union = PolyhedralIRUtility.createEmptyDomain(v.getDomain().getParams(), v.getDomain().getIndices());
				isFirst = false;
			}
			union = union.union(v.getDomain());
		}		
//		Domain ah = union.affineHull();
//		Domain ph = union.polyhedralHull();
//		Domain bb = union.boundingBox();
//		return ph.boundingBox();
		return union.boundingBox();
	}
}
	