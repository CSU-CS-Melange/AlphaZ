 package fr.irisa.cairn.jnimap.isl.jni.extra;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLLocalSpace;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSpace;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

public class JNIISLScheduleTiling {
	
	static final int waveFront = 1;
	static final int outerBlock = 2;
	public static boolean debug = false;
	//XXX under construction...
	@Deprecated
	public static JNIISLUnionMap tile(JNIISLUnionMap plutoSchedule, int tileSize){
		if ( debug ) {
			System.out.println("*****************************************************");
			System.out.println("(ORIGSC) "+plutoSchedule);
		}
		//check schedule
		int nbStmt = plutoSchedule.getNbMaps();
		if (nbStmt < 1) throw new RuntimeException();
		
		//init tiled schedule space
		JNIISLSpace scheduleSpace = plutoSchedule.getMapAt(0).getSpace();
		int nbScheduleDims = (int) scheduleSpace.getNbDims(JNIISLDimType.isl_dim_out);
		int nbParams = (int) scheduleSpace.getNbDims(JNIISLDimType.isl_dim_param);
		JNIISLSpace tiledScheduleSpace = JNIISLSpace.alloc(nbParams, nbScheduleDims, nbScheduleDims+1);
		String tupleName = scheduleSpace.getTupleName(JNIISLDimType.isl_dim_out);
		if (tupleName != null) {
			tiledScheduleSpace = tiledScheduleSpace.setTupleName(JNIISLDimType.isl_dim_in, tupleName);
			tiledScheduleSpace = tiledScheduleSpace.setTupleName(JNIISLDimType.isl_dim_out, tupleName);
		}
		for (int i = 0; i < nbParams; i++) {
			tiledScheduleSpace = tiledScheduleSpace.setName(JNIISLDimType.isl_dim_param, i, scheduleSpace.getName(JNIISLDimType.isl_dim_param, i));
		}
		if ( debug )
			System.out.println("(SPACES) "+scheduleSpace+" >> "+tiledScheduleSpace);
		
		//init tiling function
//		JNIISLBasicMap btf = JNIISLBasicMap.empty(tiledScheduleSpace);
		JNIISLMap lexEQFirst = JNIISLMap.lexEQFirst(tiledScheduleSpace.copy(), nbScheduleDims-1);
		if ( debug )
			System.out.println("(LEXEQ)  "+lexEQFirst);
		
		if (lexEQFirst.getNbBasicMaps() != 1) throw new RuntimeException();
		JNIISLBasicMap eq = lexEQFirst.getBasicMapAt(0);
		
		eq = eq.addConstraint(genConstraint1(tiledScheduleSpace, nbScheduleDims-1, nbScheduleDims-1, nbScheduleDims, tileSize));
		eq = eq.addConstraint(genConstraint2(tiledScheduleSpace, nbScheduleDims-1, nbScheduleDims-1, nbScheduleDims, tileSize));
		eq = eq.addConstraint(genConstraint3(tiledScheduleSpace, nbScheduleDims-1, nbScheduleDims-1, nbScheduleDims, tileSize));
		
		
		JNIISLMap tilingFunction = eq.toMap();
		if ( debug )
			System.out.println("Tiling Function : "+tilingFunction);
		
		//apply tiling function to schedule
		JNIISLUnionMap res = JNIISLMap.buildEmpty(plutoSchedule.getSpace().copy()).toUnionMap();
		for (JNIISLMap map : plutoSchedule.getMaps()) {
			if (map.getNbOuts() != nbScheduleDims) throw new RuntimeException();
			if (map.getNbParams() != nbParams) throw new RuntimeException();
			
			JNIISLMap tileScheduleFunction = JNIISLMap.applyRange(map, tilingFunction.copy());
			JNIISLUnionMap tmpUMap = tileScheduleFunction.toUnionMap();
			res = res.union(tmpUMap);
			
			
		}
		return res;
	}
	
	// generates [i] -> [i',ii] : i = 8*i' + ii
	static JNIISLConstraint genConstraint1(JNIISLSpace tiledSpace, int inPos, int outPos1, int outPos2, int tileSize) {
		JNIISLConstraint res = JNIISLConstraint.buildEquality(JNIISLLocalSpace.fromSpace(tiledSpace.copy()));
		res = res.setCoefficient(JNIISLDimType.isl_dim_in, inPos, -1);
		res = res.setCoefficient(JNIISLDimType.isl_dim_out, outPos1, tileSize);
		res = res.setCoefficient(JNIISLDimType.isl_dim_out, outPos2, 1);
		
		return res;
	}

	// generates [i] -> [i',ii] : 0 <= ii
	static JNIISLConstraint genConstraint2(JNIISLSpace tiledSpace, int inPos, int outPos1, int outPos2, int tileSize) {
		JNIISLConstraint res = JNIISLConstraint.buildInequality(JNIISLLocalSpace.fromSpace(tiledSpace.copy()));

		res = res.setCoefficient(JNIISLDimType.isl_dim_out, outPos2, 1);
		
		return res;
	}

	// generates [i] -> [i',ii] : ii < 8
	static JNIISLConstraint genConstraint3(JNIISLSpace tiledSpace, int inPos, int outPos1, int outPos2, int tileSize) {
		JNIISLConstraint res = JNIISLConstraint.buildInequality(JNIISLLocalSpace.fromSpace(tiledSpace.copy()));

		res = res.setCoefficient(JNIISLDimType.isl_dim_out, outPos2, -1);
		res = res.setConstant(tileSize-1);
		
		return res;
	}
	
	
	private static JNIISLSpace initScheduleSpace(JNIISLSpace scheduleSpace,
			int nbParams, int nbInDims, int nbOutDims) {
		JNIISLSpace newScheduleSpace = JNIISLSpace.alloc(nbParams, nbInDims, nbOutDims);
		String tupleName = scheduleSpace.getTupleName(JNIISLDimType.isl_dim_out);
		if (tupleName != null) {
			newScheduleSpace = newScheduleSpace.setTupleName(JNIISLDimType.isl_dim_in, tupleName);
			newScheduleSpace = newScheduleSpace.setTupleName(JNIISLDimType.isl_dim_out, tupleName);
		}
		for (int i = 0; i < nbParams; i++) {
			newScheduleSpace = newScheduleSpace.setName(JNIISLDimType.isl_dim_param, i, scheduleSpace.getName(JNIISLDimType.isl_dim_param, i));
		}
		if ( debug )
			System.out.println("(SPACES) "+scheduleSpace+" >> " + newScheduleSpace);
		return newScheduleSpace;
	}

	private static JNIISLConstraint generateEqualityConstraint(
			JNIISLSpace wrapSpace, int inDim, int outDim) {
		JNIISLConstraint res = JNIISLConstraint.buildEquality(JNIISLLocalSpace.fromSpace(wrapSpace.copy()));
		res = res.setCoefficient(JNIISLDimType.isl_dim_set, inDim, -1);
		res = res.setCoefficient(JNIISLDimType.isl_dim_set, outDim, 1);
		return res;
	}

	private static JNIISLConstraint generateEqualityConstraintOnMap(
			JNIISLSpace waveScheduleSpace, int i, int outDim) {
		JNIISLConstraint res = JNIISLConstraint.buildEquality(JNIISLLocalSpace.fromSpace(waveScheduleSpace.copy()));
		res = res.setCoefficient(JNIISLDimType.isl_dim_in, i, -1);
		res = res.setCoefficient(JNIISLDimType.isl_dim_out, outDim, 1);
		return res;
	}

	/* Generates schedule to stripmine the outermost tiled loop
	 * outerLevelBand - is starting level at which the tile band begins 
	 * innerLevelBand - is the inner level till which tiling is performed
	 * numProcessors - is the size of the tile
	 * scheduleSpace - is the space of the schedule 
	 * */
	private static JNIISLBasicMap generateOuterBlockSchedule(int outerLevelBand, int numProcessors, JNIISLSpace scheduleSpace ) {
		
		/* Initialize the new schedule space */
		JNIISLSpace waveScheduleSpace = initScheduleSpace(scheduleSpace, scheduleSpace.getNbDims(JNIISLDimType.isl_dim_param), 
				scheduleSpace.getNbDims(JNIISLDimType.isl_dim_out), scheduleSpace.getNbDims(JNIISLDimType.isl_dim_out)+1);
		JNIISLBasicMap wavefrontMap = JNIISLBasicMap.buildUniverse(waveScheduleSpace.copy());
		
		/* Add constraints for stripmining.  (i, j) -> (i, j', j'')*/
		/* j = j' * numProcessor + j'' */
		JNIISLConstraint pointOuter = JNIISLConstraint.buildEquality(JNIISLLocalSpace.fromSpace(waveScheduleSpace.copy()));
		pointOuter = pointOuter.setCoefficient(JNIISLDimType.isl_dim_out, outerLevelBand, numProcessors);
		pointOuter = pointOuter.setCoefficient(JNIISLDimType.isl_dim_out, outerLevelBand+1, 1);
		pointOuter = pointOuter.setCoefficient(JNIISLDimType.isl_dim_in, outerLevelBand, -1);
		wavefrontMap = wavefrontMap.addConstraint(pointOuter);
		/* j'' > 0 */
		JNIISLConstraint plb = JNIISLConstraint.buildInequality(JNIISLLocalSpace.fromSpace(waveScheduleSpace.copy()));
		plb = plb.setCoefficient(JNIISLDimType.isl_dim_out, outerLevelBand+1, 1);
		wavefrontMap = wavefrontMap.addConstraint(plb);
		/* j'' < numProcessors */
		JNIISLConstraint pub = JNIISLConstraint.buildInequality(JNIISLLocalSpace.fromSpace(waveScheduleSpace.copy()));
		pub = pub.setCoefficient(JNIISLDimType.isl_dim_out, outerLevelBand+1, -1);
		pub = pub.setConstant(numProcessors-1);
		wavefrontMap = wavefrontMap.addConstraint(pub);
		/* add equality constraint for other dimensions */
		for ( int i = 0; i < waveScheduleSpace.getNbDims(JNIISLDimType.isl_dim_in) ; i++ ) {
			if ( i == outerLevelBand )
				continue;
			int outDim = (i < outerLevelBand) ? i: i+1;
			JNIISLConstraint res = generateEqualityConstraintOnMap(waveScheduleSpace, i, outDim);
			wavefrontMap = wavefrontMap.addConstraint(res);
		}
		if ( debug )
			System.out.println("OuterBlockcyclic Transform " + wavefrontMap);
		
		waveScheduleSpace.free();
		return wavefrontMap;
	}

	/* Generates a schedule to scan tiles in a wavefront order 
	 * outerLevelBand, innerLevelBand are the outer and inner levels of the tile band
	 * ScheduleSpace is the space on which tiling has to be applied
	 */
	private static JNIISLBasicMap generateWavefrontSchedule(int outerLevelBand,
			int innerLevelBand, JNIISLSpace scheduleSpace) {
		
		int nbScheduleDims = (int) scheduleSpace.getNbDims(JNIISLDimType.isl_dim_out);
		int nbParams = (int) scheduleSpace.getNbDims(JNIISLDimType.isl_dim_param);
		int nbTileDims = (innerLevelBand - outerLevelBand + 1);
		
		/*Intialize the new schedule space */
		JNIISLSpace waveScheduleSpace = initScheduleSpace(scheduleSpace, nbParams, nbScheduleDims+nbTileDims, nbScheduleDims+nbTileDims);
		
		JNIISLBasicMap wavefrontMap = JNIISLBasicMap.buildUniverse(waveScheduleSpace.copy());
		
		/* Add the constraint to skew the outer loop for ex: [i, j, k] -> [i+j+k, j, k] */
		JNIISLConstraint skew = JNIISLConstraint.buildEquality(JNIISLLocalSpace.fromSpace(waveScheduleSpace.copy()));
		skew = skew.setCoefficient(JNIISLDimType.isl_dim_out, outerLevelBand, -1);
		for ( int i = outerLevelBand; i <= innerLevelBand; i++ ) {
			skew = skew.setCoefficient(JNIISLDimType.isl_dim_in, i, 1);
		}
		wavefrontMap = wavefrontMap.addConstraint(skew);
		for ( int i = 0; i < nbScheduleDims + nbTileDims; i++ ) {
			if ( i == outerLevelBand )
				continue;
			JNIISLConstraint res = generateEqualityConstraintOnMap(waveScheduleSpace, i, i);
			wavefrontMap = wavefrontMap.addConstraint(res);
		}
		if ( debug )
			System.out.println("Wavefront Transform " + wavefrontMap);
		
		waveScheduleSpace.free();
		return wavefrontMap;
	}

	/* getTileSchedule returns a Map that defines the schedule for tiling in the given schedule space 
	 * plutoSchedule - is the original schedule union map
	 * outerLevelBand - is starting level at which the tile band begins 
	 * innerLevelBand - is the inner level till which tiling is performed
	 * tileSize - array of tile sizes for each level from outerLevel to innerLevel. 
	 * tileSize[0] contains tiling for outerLevel
	 * scanOrder - specifies how the tiles should be scanned 
	 * 0 - generates simple tiled loop
	 * 1 - generates tiled loop such that tiles are visited in wavefront order
	 * 2 - block cyclic allocation on the outermost loop. Basically srtipmines the outerloop
	 * by the specified constant
	 * numProcessors - Only used when scanOrder is 2. specifies the constant to sripmine
	 * the outermost loop
	 * This function generates the schedule in the space: 
	 * 		{ [i...OuterLevel..innerLevel..j] -> 
	 *  		[i'...OuterTileLevel...innerTileLevel, OuterPointLevel...innerPointLevel...j'] }
	 *  Constraints:
	 *   	i' = i, j' = j, 
	 *  	OuterPointLevel = OuterLevel, OuterLevel * tileSize <= OuterPointLebel < (OuterLevel + 1) * tileSize
	 *  For example: 
	 *   (i, j, k) -> (i', j', k', j'', k'') : i = i' & j'' = j && k'' = k && 8*k' <= k'' < 8*(k'+1)  
	 */
	public static JNIISLMap getTileSchedule(JNIISLSpace scheduleSpace, int outerLevelBand, int innerLevelBand, int[] tileSize, int scanOrder, int numProcessors){
	
		//init tiled schedule space
		int nbScheduleDims = scheduleSpace.getNbDims(JNIISLDimType.isl_dim_out);
		int nbParams = scheduleSpace.getNbDims(JNIISLDimType.isl_dim_param);
		int nbTileDims = (innerLevelBand - outerLevelBand + 1);
		
		JNIISLSpace tiledScheduleSpace = initScheduleSpace(scheduleSpace,
				nbParams, nbScheduleDims, nbTileDims+nbScheduleDims);
		JNIISLSpace wrapSpace = tiledScheduleSpace.copy().wrap();
		
		JNIISLBasicSet tileSet = JNIISLBasicSet.buildUniverse(wrapSpace.copy());
		
		/* Add Identity schedule for all dimensions not in the band 
		 * [i,j] -> [i', j'] : i = i' 
		 * */
		for ( int i = 0; i < outerLevelBand; i++ ) {
			JNIISLConstraint res = generateEqualityConstraint(wrapSpace, i, nbScheduleDims + i);
			tileSet = tileSet.addConstraint(res);
		}
		for ( int i = innerLevelBand + 1; i < nbScheduleDims; i++ ) {
			JNIISLConstraint res = generateEqualityConstraint(wrapSpace, i, nbScheduleDims + nbTileDims + i);
			tileSet = tileSet.addConstraint(res);
		}
		
		/* Add tiled schedule for tile band */
		for ( int i = outerLevelBand; i <= innerLevelBand; i++) {
			/* [i, j] -> [i, j', j''] */
			/*j' >= 0 */
			JNIISLConstraint tlb = JNIISLConstraint.buildInequality(JNIISLLocalSpace.fromSpace(wrapSpace.copy()));
			tlb = tlb.setCoefficient(JNIISLDimType.isl_dim_set, i + nbScheduleDims, 1);
			tileSet = tileSet.addConstraint(tlb); 
			/* constraints for point loop */
			/* j'' >= 8 * j' */
			JNIISLConstraint plb = JNIISLConstraint.buildInequality(JNIISLLocalSpace.fromSpace(wrapSpace.copy()));
			plb = plb.setCoefficient(JNIISLDimType.isl_dim_set, i + nbScheduleDims + nbTileDims, 1);
			plb = plb.setCoefficient(JNIISLDimType.isl_dim_set, i + nbScheduleDims, -1 * tileSize[i-outerLevelBand]);
			tileSet = tileSet.addConstraint(plb);
			/* j'' <= 8 * j' + 7 */
			JNIISLConstraint pub = JNIISLConstraint.buildInequality(JNIISLLocalSpace.fromSpace(wrapSpace.copy()));
			pub = pub.setCoefficient(JNIISLDimType.isl_dim_set, i + nbScheduleDims + nbTileDims, -1);
			pub = pub.setCoefficient(JNIISLDimType.isl_dim_set, i + nbScheduleDims, tileSize[i-outerLevelBand]);
			pub = pub.setConstant(tileSize[i-outerLevelBand]-1);
			tileSet = tileSet.addConstraint(pub);
			/* j = j'' */
			JNIISLConstraint peq = generateEqualityConstraint(wrapSpace, i, nbScheduleDims + nbTileDims + i);
			tileSet = tileSet.addConstraint(peq); 
		}
		
		JNIISLBasicMap bmap = tileSet.unwrap();
		if ( debug )
			System.out.println("Tiling Function : "+bmap);
		
		/* Apply a schedule to visit the tiles in chosen order. In a wavefront schedule  the tiles
		 * are visited in a systolic wavefront order. In the outerBlock schedule The outermost loop
		 * is stripmined. This will help generating code for multi processor systems. 
		 */
		if ( scanOrder == waveFront ) {
			JNIISLBasicMap wavefrontMap = generateWavefrontSchedule(outerLevelBand, innerLevelBand, scheduleSpace);
			JNIISLBasicMap outerBlock = generateOuterBlockSchedule(outerLevelBand+1, numProcessors, tiledScheduleSpace);
			wavefrontMap = wavefrontMap.copy().applyRange(outerBlock.copy());
			bmap = bmap.applyRange(wavefrontMap);
		} else if ( scanOrder == outerBlock ) {
			JNIISLBasicMap wavefrontMap = generateOuterBlockSchedule(outerLevelBand, numProcessors, tiledScheduleSpace);
			bmap = bmap.applyRange(wavefrontMap);
		}
		JNIISLMap tilingFunction = bmap.toMap();
		if ( debug )
			System.out.println("Tiling Function : "+tilingFunction);
		
		return tilingFunction;
	}

	/* tileBand tiles a band of loops. 
	 * plutoSchedule - is the original schedule union map
	 * outerLevelBand - is starting level at which the tile band begins 
	 * innerLevelBand - is the inner level till which tiling is performed
	 * tileSize - array of tile sizes for each level from outerLevel to innerLevel. 
	 * tileSize[0] contains tiling for outerLevel
	 * scanOrder - specifies how the tiles should be scanned 
	 * 0 - generates simple tiled loop
	 * 1 - generates tiled loop such that tiles are visited in wavefront order
	 * 2 - block cyclic allocation on the outermost loop. Basically srtipmines the outerloop
	 * by the specified constant
	 * numProcessors - Only used when scanOrder is 2. specifies the constant to sripmine
	 * the outermost loop
	 */
	public static JNIISLUnionMap tileBand(JNIISLUnionMap plutoSchedule, int outerLevelBand, int innerLevelBand, int[] tileSize, int scanOrder, int numProcessors){
		JNIISLSpace scheduleSpace = plutoSchedule.getMapAt(0).getSpace();
		int nbScheduleDims = (int) scheduleSpace.getNbDims(JNIISLDimType.isl_dim_out);
		int nbParams = (int) scheduleSpace.getNbDims(JNIISLDimType.isl_dim_param);
		
		JNIISLMap tilingFunction = getTileSchedule(scheduleSpace, outerLevelBand, innerLevelBand, tileSize, scanOrder, numProcessors);

		//apply tiling function to schedule
		JNIISLUnionMap res = JNIISLMap.buildEmpty(plutoSchedule.getSpace()).toUnionMap();
		for (JNIISLMap map : plutoSchedule.getMaps()) {
			if (map.getNbOuts() != nbScheduleDims) throw new RuntimeException();
			if (map.getNbParams() != nbParams) throw new RuntimeException();
			String s = map.getOutputTupleName();
			if ( s == null ) {
				s = map.getInputTupleName();
			}
			JNIISLMap tileScheduleFunction = map.applyRange(tilingFunction.copy());
			if ( s != null ) 
				tileScheduleFunction = tileScheduleFunction.setOutputTupleName(s);
			JNIISLUnionMap tmpUMap = tileScheduleFunction.toUnionMap();
			res = res.union(tmpUMap);
		}
		tilingFunction.free();
		return res;
	}
	
	public static JNIISLMap stripmine(JNIISLMap map, int tileSize){

		//init tiled schedule space
		JNIISLSpace scheduleSpace = map.getSpace();
		int nbScheduleDims = (int) scheduleSpace.getNbDims(JNIISLDimType.isl_dim_out);
		int nbParams = (int) scheduleSpace.getNbDims(JNIISLDimType.isl_dim_param);
		JNIISLSpace tiledScheduleSpace = JNIISLSpace.alloc(nbParams, nbScheduleDims, nbScheduleDims+1);
		String tupleName = scheduleSpace.getTupleName(JNIISLDimType.isl_dim_out);
		if (tupleName != null) {
			tiledScheduleSpace = tiledScheduleSpace.setTupleName(JNIISLDimType.isl_dim_in, tupleName);
			tiledScheduleSpace = tiledScheduleSpace.setTupleName(JNIISLDimType.isl_dim_out, tupleName);
		}
		for (int i = 0; i < nbParams; i++) {
			tiledScheduleSpace = tiledScheduleSpace.setName(JNIISLDimType.isl_dim_param, i, scheduleSpace.getName(JNIISLDimType.isl_dim_param, i));
		}
				
		JNIISLMap lexEQFirst = JNIISLMap.lexEQFirst(tiledScheduleSpace, nbScheduleDims-1);
				
		if (lexEQFirst.getNbBasicMaps() != 1) throw new RuntimeException();
		JNIISLBasicMap eq = lexEQFirst.getBasicMapAt(0);
		
		eq = eq.addConstraint(genConstraint1(tiledScheduleSpace, nbScheduleDims-1, nbScheduleDims-1, nbScheduleDims, tileSize));
		eq = eq.addConstraint(genConstraint2(tiledScheduleSpace, nbScheduleDims-1, nbScheduleDims-1, nbScheduleDims, tileSize));
		eq = eq.addConstraint(genConstraint3(tiledScheduleSpace, nbScheduleDims-1, nbScheduleDims-1, nbScheduleDims, tileSize));
		
		JNIISLMap tilingFunction = eq.toMap();
				
		//apply tiling function to schedule
		JNIISLMap res = map.applyRange(tilingFunction.copy()); 
		return res;
	}
	
	
}



