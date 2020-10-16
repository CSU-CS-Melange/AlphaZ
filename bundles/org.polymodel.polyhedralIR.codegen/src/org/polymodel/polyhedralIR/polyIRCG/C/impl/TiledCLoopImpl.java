/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.C.CFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen;
import org.polymodel.polyhedralIR.polyIRCG.generator.ScopGenerator;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MultiPass.MultiPassDTiler;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MultiPass.MultiPassDTilerOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MultiPass.MultiPassWavefrontDTiler;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTiler;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.OptimizationOptions;
import org.polymodel.scop.dtiler.basic.DTilerOptimizedPointLoops;
import org.polymodel.scop.dtiler.basic.DTilerTileLoops;
import org.polymodel.scop.dtiler.basic.DTilerWaveFrontTileLoops;
import org.polymodel.scop.dtiler.distributed.DTilerForMPICTileLoops;
import org.polymodel.scop.dtiler.distributed.DTilerPGASTileLoops;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTiler;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOptions;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOptions.HierarchyBandDTilingOptions;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOutput;
import org.polymodel.scop.util.ScopLoopIteratorUtil;

import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tiled CLoop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl#isOptimize <em>Optimize</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl#getOrderingDimensions <em>Ordering Dimensions</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl#getOptimizedPointLoop <em>Optimized Point Loop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TiledCLoopImpl extends CLoopImpl implements TiledCLoop {
	/**
	 * The default value of the '{@link #isOptimize() <em>Optimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptimize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIMIZE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptimize() <em>Optimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptimize()
	 * @generated
	 * @ordered
	 */
	protected boolean optimize = OPTIMIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTiles() <em>Tiles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiles()
	 * @generated
	 * @ordered
	 */
	protected EList<TileSpecification> tiles;

	/**
	 * The cached value of the '{@link #getOrderingDimensions() <em>Ordering Dimensions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderingDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> orderingDimensions;

	/**
	 * The cached value of the '{@link #getOptimizedPointLoop() <em>Optimized Point Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizedPointLoop()
	 * @generated
	 * @ordered
	 */
	protected CLoop optimizedPointLoop;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TiledCLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.TILED_CLOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptimize() {
		return optimize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimize(boolean newOptimize) {
		boolean oldOptimize = optimize;
		optimize = newOptimize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.TILED_CLOOP__OPTIMIZE, oldOptimize, optimize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TileSpecification> getTiles() {
		if (tiles == null) {
			tiles = new EObjectContainmentEList<TileSpecification>(TileSpecification.class, this, CPackage.TILED_CLOOP__TILES);
		}
		return tiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getOrderingDimensions() {
		if (orderingDimensions == null) {
			orderingDimensions = new EDataTypeUniqueEList<Integer>(Integer.class, this, CPackage.TILED_CLOOP__ORDERING_DIMENSIONS);
		}
		return orderingDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop getOptimizedPointLoop() {
		if (optimizedPointLoop != null && optimizedPointLoop.eIsProxy()) {
			InternalEObject oldOptimizedPointLoop = (InternalEObject)optimizedPointLoop;
			optimizedPointLoop = (CLoop)eResolveProxy(oldOptimizedPointLoop);
			if (optimizedPointLoop != oldOptimizedPointLoop) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.TILED_CLOOP__OPTIMIZED_POINT_LOOP, oldOptimizedPointLoop, optimizedPointLoop));
			}
		}
		return optimizedPointLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CLoop basicGetOptimizedPointLoop() {
		return optimizedPointLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimizedPointLoop(CLoop newOptimizedPointLoop) {
		CLoop oldOptimizedPointLoop = optimizedPointLoop;
		optimizedPointLoop = newOptimizedPointLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.TILED_CLOOP__OPTIMIZED_POINT_LOOP, oldOptimizedPointLoop, optimizedPointLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<String> getTileIndices() {
		EList<String> indices = new BasicEList<String>();
		List<Integer> orderingDimensions = getOrderingDimensions();	//ordering dimension starts from 0
		for(TileSpecification tilespec : getTiles()){
			List<Integer> orderingPrefix = tilespec.getOrderingPrefix();
			int len = orderingPrefix.size();
			for(int i = 1; i <= tilespec.getSubTiles().size(); i++){
				SubTileSpecification subtile = tilespec.getSubTiles().get(i-1);
				int start = subtile.getStart();
				int end = subtile.getEnd();
				
				if(len > 0){
					start = start + orderingDimensions.get(len - 1) + 1 -len;
					end = end + orderingDimensions.get(len - 1) + 1 - len;
				}
				for(int j = start; j <= end; j++){
					String varName = subtile.getTileIndexPrefix()+j+"_l"+i;
					if(orderingPrefix.size() > 0){
						varName += "_o";
						for(int k = 0; k < orderingPrefix.size(); k++){
							varName += orderingPrefix.get(i);
						}
					}
					indices.add(varName);
				}
			}
		}
		return indices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DTiledLoop generateDTiledLoop() {
		CloogOptionSpecifier cloogOptions = CloogOptionSpecifier.optionForFullyNestedLoop(getMaxDimension() - getNumConstantDimensions());
		ScopRoot sroot = ScopGenerator.generateScop(getParameterDomain(), getIteratorNames(), getStatements(), cloogOptions);  
		DTiledLoop dtloop = CFactory.eINSTANCE.createDTiledLoop();
		
		getIteratorNames().clear();
		
		OptimizationOptions opt_options = initializeOptimizationOptions();
		if(((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).multiPassSequential){
			MultiPassDTilerOptions multiPassOptions = initializeMultiPassDTilingOptions();
			if(opt_options.optimizedPointLoop != null){
				dtloop.setScop(MultiPassDTiler.generateScop(sroot, getParameterDomain(), multiPassOptions, opt_options));
			}else{
				dtloop.setScop(MultiPassDTiler.generateScop(sroot, getParameterDomain(), multiPassOptions));
			}
			dtloop.setGeneratorLoop(this);
			
			//add addtitional indices
			getIteratorNames().addAll(multiPassOptions.getTileIndicesForMultiPass());
			getIteratorNames().addAll(multiPassOptions.getAddtitionalIndicesForMultiPass());
			getIteratorNames().addAll(multiPassOptions.getAdditionalVariableForMultiPass());
		}else if(((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).multiPassWavefront){
			MultiPassDTilerOptions multiPassOptions = initializeMultiPassDTilingOptions();
			if(opt_options.optimizedPointLoop != null){
				dtloop.setScop(MultiPassWavefrontDTiler.generateSope(sroot, getParameterDomain(), multiPassOptions, opt_options));
			}else{
				dtloop.setScop(MultiPassWavefrontDTiler.generateSope(sroot, getParameterDomain(), multiPassOptions));
			}
			dtloop.setGeneratorLoop(this);
			
			//add addtitional indices
			getIteratorNames().addAll(multiPassOptions.getTileIndicesForMultiPass());
			getIteratorNames().addAll(multiPassOptions.getAddtitionalIndicesForMultiPass());
			getIteratorNames().addAll(multiPassOptions.getAdditionalVariableForMultiPass());
			getIteratorNames().addAll(multiPassOptions.getAdditionalWavefrontVariables());
		}else{
			//check whether only DTiler needs to be called, this is separated due the MPI and PAGS code generator
			//TODO: This should be eventually be merged to hierarchy dtiler
			boolean isDTiler = false;
			if(getTiles().size() == 1){
				TileSpecification tile = getTiles().get(0);
				if(tile.getOrderingPrefix().size() == 0 && tile.getLevels() == 1 && tile.getStartDim() == 0 && tile.getEndDim() >= getMaxDimension()-1){
					isDTiler = true;
				}
			}
			
			if(isDTiler){
				DTilingOptions options = initializeDTilingOptions();
				
				if(opt_options.optimizedPointLoop != null){
					options.pointLoopGenerator = new DTilerOptimizedPointLoops(options, opt_options);
				}
				if(options.tileLoopGenerator instanceof DTilerWaveFrontTileLoops && opt_options.specialVariables.size() > 0){
					((DTilerWaveFrontTileLoops)options.tileLoopGenerator).setSpecialPrivates(opt_options.specialVariables);
				}
				
				//ScopRoot root = MultiPassDTiler.tileDTiling(sroot, getParameterDomain(), options, opt_options);
				
				//ScopRoot root = MultiPassDTiler.tileDTiling(sroot, getParameterDomain(), options);
				ScopRoot root = DTiler.tile(sroot, options);
				dtloop.setScop(root);
				
				getIteratorNames().addAll(options.getTileIndexToDeclare());
				getIteratorNames().addAll(options.getAddtitionalIndicesToDeclare());
			}else{
				HierarchyDTilingOptions hierarchy_dtiling_options = initializeHierarchyDTilingOptions();
				HierarchyDTilingOutput dtilingOutput = HierarchyDTiler.hierarchyTileWithHierarchyDTilingOutput(sroot, hierarchy_dtiling_options);
				dtloop.setScop(dtilingOutput.tiledScop);

				getIteratorNames().addAll(hierarchy_dtiling_options.getAllTileIndexToDeclare());
				getIteratorNames().addAll(hierarchy_dtiling_options.getAllAddtitionalIndicesToDeclare());
			}
			
		}
		dtloop.setGeneratorLoop(this);
		
		//match iterator names
		getIteratorNames().addAll(ScopLoopIteratorUtil.iteratorNameSet(dtloop.getScop()));
		
		return dtloop;
	}
	
	
	/*public DTiledLoop generateDTiledLoop() {
		CloogOptionSpecifier cloogOptions = CloogOptionSpecifier.optionForFullyNestedLoop(getMaxDimension() - getNumConstantDimensions());
		ScopRoot sroot = ScopGenerator.generateScop(getParameterDomain(), getIteratorNames(), getStatements(), cloogOptions);
		
		ScopRoot permuted_sroot = null;
		if(getPermutedLoop() != null){
			//create the permuted scop
			permuted_sroot = ScopGenerator.generateScop(getPermutedLoop().getParameterDomain(), getPermutedLoop().getIteratorNames(), 
																getPermutedLoop().getStatements(), cloogOptions);
		}else{
			permuted_sroot = EcoreUtil.copy(sroot);
		}
		
		DTilingOptions options = initializeDTilingOptions();
		
		DTiledLoop dtloop = CFactory.eINSTANCE.createDTiledLoop();
		dtloop.setDtilingOptions(options);
		
		if(options.specs.size() == 0){
			//tile
			DTilingOutput dtilingOutput = DTiler.tileWithDTilingOutput(sroot, options);
			
			dtloop.setScop(dtilingOutput.tiledScop);
			
			for (TiledBlock tiledBlock : dtilingOutput.tilingBlocks.values()) {
				DTiledBlock dtiledBlock = CFactory.eINSTANCE.createDTiledBlock();
				dtiledBlock.setBlockStart(tiledBlock.tiledLoopStart);
				dtiledBlock.setTileLoopStart(tiledBlock.tiledLoopStart);
				dtiledBlock.setPointLoopStart(tiledBlock.pointLoopStart);
				dtiledBlock.setPerfectLoopNest((ScopFor)tiledBlock.perfectNest);
				
				dtloop.getTiledBlocks().add(dtiledBlock);
				dtloop.setGeneratorLoop(this);
			}
		}else{
			ScopRoot root = DTiler.tileWithScopRootOutput(sroot, permuted_sroot, options);
			dtloop.setScop(root);
		}
		
		//match iterator names
		getIteratorNames().clear();
		getIteratorNames().addAll(ScopLoopIteratorUtil.iteratorNameSet(dtloop.getScop()));
		if(options.specs.size() > 0){
			for(TilingSpecification spec : options.specs){
				for(int i = 1; i <= spec.getTilingLevel(); i++){
					for(int j = spec.getTilingBands().get(i-1).start; j <= spec.getTilingBands().get(i-1).end; j++){
						getIteratorNames().add(options.getTileIndex(j,i).getName());
					}
				}
			}
		}else{
		
			//tile indices
			for(int i = 1; i <= options.level; i++){
				for (int j = 1; j <= getMaxDimension(); j++) {
					getIteratorNames().add(options.getTileIndex(j, i).getName());
				}
			}
		}
		//special indices in the parallel case
		getIteratorNames().addAll(options.getAdditionalIndicesToDeclare());
		
		
		return dtloop;
	}*/

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CPackage.TILED_CLOOP__TILES:
				return ((InternalEList<?>)getTiles()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CPackage.TILED_CLOOP__OPTIMIZE:
				return isOptimize();
			case CPackage.TILED_CLOOP__TILES:
				return getTiles();
			case CPackage.TILED_CLOOP__ORDERING_DIMENSIONS:
				return getOrderingDimensions();
			case CPackage.TILED_CLOOP__OPTIMIZED_POINT_LOOP:
				if (resolve) return getOptimizedPointLoop();
				return basicGetOptimizedPointLoop();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CPackage.TILED_CLOOP__OPTIMIZE:
				setOptimize((Boolean)newValue);
				return;
			case CPackage.TILED_CLOOP__TILES:
				getTiles().clear();
				getTiles().addAll((Collection<? extends TileSpecification>)newValue);
				return;
			case CPackage.TILED_CLOOP__ORDERING_DIMENSIONS:
				getOrderingDimensions().clear();
				getOrderingDimensions().addAll((Collection<? extends Integer>)newValue);
				return;
			case CPackage.TILED_CLOOP__OPTIMIZED_POINT_LOOP:
				setOptimizedPointLoop((CLoop)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CPackage.TILED_CLOOP__OPTIMIZE:
				setOptimize(OPTIMIZE_EDEFAULT);
				return;
			case CPackage.TILED_CLOOP__TILES:
				getTiles().clear();
				return;
			case CPackage.TILED_CLOOP__ORDERING_DIMENSIONS:
				getOrderingDimensions().clear();
				return;
			case CPackage.TILED_CLOOP__OPTIMIZED_POINT_LOOP:
				setOptimizedPointLoop((CLoop)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CPackage.TILED_CLOOP__OPTIMIZE:
				return optimize != OPTIMIZE_EDEFAULT;
			case CPackage.TILED_CLOOP__TILES:
				return tiles != null && !tiles.isEmpty();
			case CPackage.TILED_CLOOP__ORDERING_DIMENSIONS:
				return orderingDimensions != null && !orderingDimensions.isEmpty();
			case CPackage.TILED_CLOOP__OPTIMIZED_POINT_LOOP:
				return optimizedPointLoop != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (optimize: ");
		result.append(optimize);
		result.append(", orderingDimensions: ");
		result.append(orderingDimensions);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public ScopRoot generateScop() {
		return generateDTiledLoop().getScop();
	}
	
	protected MultiPassDTilerOptions initializeMultiPassDTilingOptions(){
		MultiPassDTilerOptions multiPassOptions = new MultiPassDTilerOptions(getMaxDimension() - getNumConstantDimensions());
		multiPassOptions.vectorizable = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).vectorizable;
		
		return multiPassOptions;
	}
	
	/**
	 * When only dtiler is called, the whole program is tiled
	 * @return
	 */
	protected DTilingOptions initializeDTilingOptions(){
		TileSpecification tile = getTiles().get(0);
		SubTileSpecification subtile = tile.getSubTiles().get(0);
		
		//initial DTiling band from 1 to the number of dimensions
		DTilingOptions options = new DTilingOptions(1, tile.getOrderingPrefix(), 0, getMaxDimension() - getNumConstantDimensions()-1);
		((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).populateDTilingOptions(options);
		
		options.vectorizable = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).vectorizable;
		options.numberOfTiledDimensions = getMaxDimension() - getNumConstantDimensions();
		options.statement_pattern = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).fullTileStmtPattern;
		
		//parallel
		switch (subtile.getTileType()) {
		case SEQUENTIAL:
			options.tileLoopGenerator = new DTilerTileLoops(options);
			break;
		case OMPWAVEFRONT:
			options.tileLoopGenerator = new DTilerWaveFrontTileLoops(options);
			break;
		case PGAS:
			options.tileLoopGenerator = new DTilerPGASTileLoops(options);
			break;
		case MPIC:
			options.tileLoopGenerator = new DTilerForMPICTileLoops(options);
			break;
		default:
			throw new RuntimeException("Unexpected tiling type : " + subtile.getTileType());
		}
		
		if (getNumConstantDimensions() > 0 && isOptimize()) {
			System.err.println("Currently, point loops cannot be optimized when ordering dimensions are present in the STmap.");
		} else 
			if (isOptimize()) {
			options.pointLoopGenerator = new DTilerOptimizedPointLoops(options);
		}
		
		return options;
		
	}
	protected HierarchyDTilingOptions initializeHierarchyDTilingOptions(){
		HierarchyDTilingOptions hierarchy_dtiling_options = new HierarchyDTilingOptions();
		
		for(TileSpecification tilespec : getTiles()){
			Map<Integer, DTilingOptions> dtiling_options = new HashMap<Integer, DTilingOptions>();
			//create tiling options for each level in the band
			for(int i = 1; i <= tilespec.getSubTiles().size(); i++){
				SubTileSpecification subtile = tilespec.getSubTiles().get(i - 1);
				DTilingOptions options = new DTilingOptions(i, tilespec.getOrderingPrefix(), subtile.getStart(), subtile.getEnd());
				//copy all options into DTilerOptions
				((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).populateDTilingOptions(options);
				if(subtile.getTileType() == TILING_TYPE.OMPWAVEFRONT){
					options.tileLoopGenerator = new DTilerWaveFrontTileLoops(options);
				}
				if (getNumConstantDimensions() > 0 && isOptimize()) {
					System.err.println("Currently, point loops cannot be optimized when ordering dimensions are present in the STmap.");
				} else 
					if (isOptimize()) {
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
	}
	
	protected OptimizationOptions initializeOptimizationOptions(){
		OptimizationOptions opt_options = new OptimizationOptions();
		
		opt_options.numberOfTiledDimensions = getMaxDimension() - getNumConstantDimensions();
		List<String> specialVariables = new LinkedList<String>();
		opt_options.unrollAndJam = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).unrollAndJam;
		if(opt_options.unrollAndJam){
			int[] unrollDims = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).unrollDims;
			int[] unrollFactors = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).unrollFactors;
			for(int i = 0; i < unrollDims.length; i++){
				opt_options.addLoopUnrollOptions(unrollDims[i], unrollFactors[i]);
			}
		}
		opt_options.vectorization = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).vec;
		if(opt_options.vectorization){
			opt_options.setDataType(((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).dataType);
			opt_options.setVecStrategy(((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).strategy);
			opt_options.setSIMDSet(((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).simdSet);
		}
		
		opt_options.buffering = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).buffering;
		if(opt_options.buffering || (opt_options.vectorization && ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).optimized)){
			//generate the scop for point loop
			CLoop point = getOptimizedPointLoop();
			CloogOptionSpecifier cloogOptions = CloogOptionSpecifier.getDefault();
			ScopRoot point_sroot = ScopGenerator.generateScop(point.getParameterDomain(), point.getIteratorNames(), point.getStatements(), cloogOptions);  
			//System.out.println("finish generating the optimized loop");
			opt_options.optimizedPointLoop = point_sroot;
			specialVariables.addAll(ScopLoopIteratorUtil.iteratorNameSet(point_sroot));
			//record the selected full tile statement for the optimized point loop
			if(((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).optimalPointLoopStmts != null && ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).optimalPointLoopStmts.size() > 0){
				opt_options.pointLoopStmts = ((TiledCodeGenOptions)PolyIRCodeGen.getCodeGenOptions()).optimalPointLoopStmts;
			}
		}
		
		{
			Function f = getFunction();
			for(CodeGenVariable v : f.getSpecialLocals()){
				specialVariables.add(v.getName());
			}
			
			if (f instanceof SIMDFunction) {
				for(VRegister vr : ((SIMDFunction)f).getLocalsimdRegs()){
					specialVariables.add(vr.getName());
				}
			}
		}
		opt_options.specialVariables.addAll(specialVariables);
		return opt_options;
	}

} //TiledCLoopImpl
