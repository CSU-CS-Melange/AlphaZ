package fr.irisa.cairn.jnimap.isl.jni.memorylayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javatuples.Pair;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMultiAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSpace;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionSet;

/**
 * 
 * @author amorvan
 * 
 */
public class ISLMemoryLayoutTools {

	public static boolean debug = true;
	private static String DEFAULT_PREFIX = "[MEM_ALLOC] ";
	private String PREFIX;
	public ISLMemoryLayoutTools() {PREFIX = DEFAULT_PREFIX;}
	public ISLMemoryLayoutTools(String p) {PREFIX = p+DEFAULT_PREFIX;}
	private void debug(Object o) {
		if (debug) {
			String string = PREFIX+o.toString().replace("\n","\n"+PREFIX);
			System.out.println(string);
		}
	}
	
	/**
	 * Cf. memory_allocation.pdf
	 * 
	 * @param arrayName
	 * @param domains
	 * @param writes
	 * @param reads
	 * @param prdg
	 * @param schedule
	 * @return
	 */
	public List<Map<JNIISLSet, JNIISLMultiAff>> contractSuccessiveModuloBasic(
			String arrayName, JNIISLSet context,JNIISLUnionSet domains, JNIISLUnionMap writes,
			JNIISLUnionMap reads, JNIISLUnionMap prdg, JNIISLUnionMap schedule
			) {
		int nbDims = schedule.getRange().getSetAt(0).getNbDims();
		List<Boolean> parallelDims = new ArrayList<Boolean>(nbDims);
		//by default : consider all dimensions are sequential
		for (int i = 0; i < nbDims; i++)
			parallelDims.add(false);
		return contractSuccessiveModuloBasic(arrayName, context, domains, writes, reads, prdg, schedule, parallelDims);
	}
	
	/**
	 * Cf. memory_allocation.pdf
	 * 
	 * @param arrayName
	 * @param domains
	 * @param writes
	 * @param reads
	 * @param prdg
	 * @param schedule
	 * @param parallelDimensions
	 * @return
	 */
	public List<Map<JNIISLSet, JNIISLMultiAff>> contractSuccessiveModuloBasic(
			String arrayName,
			JNIISLSet context,
			JNIISLUnionSet domains, 
			JNIISLUnionMap writes,
			JNIISLUnionMap reads,
			JNIISLUnionMap prdg,
			JNIISLUnionMap schedule,
			List<Boolean> parallelDimensions
			) {

		debug("/*****************************\n ** START Contracting array "+arrayName+"\n *****************************/\n");

		debug("input:");
		debug("  context =  "+context);
		debug("  domain =   "+domains);
		debug("  prdg =     "+prdg);
		debug("  schedule = "+schedule);
		debug("  // dims =  "+parallelDimensions);
		debug("  writes =   "+writes);
		debug("  reads =    "+reads);
		
		Pair<JNIISLMap, JNIISLSet> memoryBasedScheduledDependencies = selectAndScheduleForContraction(arrayName, domains, writes, reads, prdg, schedule);
		JNIISLMap deps = memoryBasedScheduledDependencies.getValue0();
		JNIISLSet scheduledWriteDomain = memoryBasedScheduledDependencies.getValue1();
		
		if (deps == null)
			throw new RuntimeException();
		JNIISLMap cs = buildCS(deps,scheduledWriteDomain,parallelDimensions);
		
		/**
		 * Move CS from the scheduled iteration space to the accessed array
		 * index space. Necessary for in-place contraction.
		 * 
		 * XXX
		 */
		List<JNIISLMap> writesMaps = writes.getMaps();
		JNIISLUnionMap arayWrites = null;
		for (JNIISLMap m : writesMaps) {
			if (m.getTupleName(JNIISLDimType.isl_dim_out).equals(arrayName))
				if (arayWrites == null) arayWrites = m.toUnionMap();
				else arayWrites = arayWrites.union(m.toUnionMap());
		}
		JNIISLUnionMap applyRange = schedule.copy().reverse().applyRange(arayWrites.copy());
		if (applyRange.getNbMaps() != 1)
			throw new RuntimeException();
		JNIISLMap scheduledWriteToArrayAccess = applyRange.getMapAt(0);
		cs = cs.applyDomain(scheduledWriteToArrayAccess.copy()).applyRange(scheduledWriteToArrayAccess.copy());
		debug("cs (in the array space) = "+cs);
		JNIISLSet ds = buildDS(context, cs);
		List<Map<JNIISLSet, JNIISLMultiAff>> successiveModuloBasic = successiveModuloBasic(ds);
		debug("\n/*****************************\n ** END Contracting array "+arrayName+"\n *****************************/");

		return successiveModuloBasic;
	}
	
	/**
	 * 
	 * @param ds
	 * @return
	 */
	List<Map<JNIISLSet, JNIISLMultiAff>> successiveModuloBasic(JNIISLSet ds) {

		long nbDims = ds.copy().getNbDims();
		List<Map<JNIISLSet, JNIISLMultiAff>> res = new ArrayList<Map<JNIISLSet, JNIISLMultiAff>>((int)nbDims);
		JNIISLSpace space = ds.getSpace();
		
		JNIISLMap map = JNIISLMap.lexEQ(space.copy());
		map = map.projectOut(JNIISLDimType.isl_dim_in, 0, map.getNbIns());
		map = map.intersectRange(ds.copy());
		
		space = map.getSpace();
		
		for (int i = 0; i < nbDims; i++) {
			debug("expansion degree #"+i+" : ");
			JNIISLMap workingCopyDS = map.copy();
			
			JNIISLBasicMap previousDimsToZero = JNIISLBasicMap.buildUniverse(space.copy());
			for (int j = 0; j < i; j++) {
				JNIISLConstraint c = JNIISLConstraint.buildEquality(space.copy());
				c = c.setConstant(0);
				c = c.setCoefficient(JNIISLDimType.isl_dim_out, j, 1);
				previousDimsToZero = previousDimsToZero.addConstraint(c);
			}
			workingCopyDS = workingCopyDS.intersect(previousDimsToZero.toMap());
			debug(" - projecting (on "+workingCopyDS+")");
			workingCopyDS = workingCopyDS.copy().projectIn(JNIISLDimType.isl_dim_out, i);
			
			debug(" - simple hull (on "+workingCopyDS+")");
			JNIISLMap tmpCopy = workingCopyDS.copy();
			workingCopyDS = workingCopyDS.intersectRange(tmpCopy.getRange().simpleHull().toSet());//.coalesce();
			
			// XXX if the schedule has less dimensions than the array, there
//			if (workingCopyDS.getNbBasicMaps() == 1) {
//				JNIISLBasicMap basicMapAt = workingCopyDS.copy().getBasicMapAt(0);
//				if (basicMapAt.projectOut(JNIISLDimType.isl_dim_param, 0, basicMapAt.getNbDims(JNIISLDimType.isl_dim_param)).isUniverse()) {
//					res.add(new LinkedHashMap<JNIISLSet, JNIISLMultiAff>());
//					continue;
//				}
//			}
			
			debug(" - computing lexmax (on "+workingCopyDS+")");
			workingCopyDS = workingCopyDS.lexMax().coalesce();
			debug("\t - lexmax = "+workingCopyDS);
	
			if (workingCopyDS.involvesDims(JNIISLDimType.isl_dim_param, 0, workingCopyDS.getNbParams())) {
				// Check is parameter space is bounded or not
				JNIISLMap noParamWorkingCopyDS = workingCopyDS.copy().projectOut(JNIISLDimType.isl_dim_param, 0, workingCopyDS.getNbParams()).removeDivs();
				debug("\t - after projecting parameters = "+noParamWorkingCopyDS);
				if (noParamWorkingCopyDS.copy().range().hasUpperBound(JNIISLDimType.isl_dim_set, 0)) {
					debug("\t - you are lucky ! there exist a constant array foldoing factor "+noParamWorkingCopyDS.copy().lexMax());
					noParamWorkingCopyDS = noParamWorkingCopyDS.copy().lexMax();
					noParamWorkingCopyDS = noParamWorkingCopyDS.alignParams(workingCopyDS.getSpace());
					debug("\t - aligned "+noParamWorkingCopyDS);
					workingCopyDS =  noParamWorkingCopyDS;
				}
				//if (noParamWorkingCopyDS.is)
			}

			debug(" - shifting +1  (on "+workingCopyDS+")");
			JNIISLMap shift = JNIISLBasicMap.shift(workingCopyDS.copy().getRange().getSpace(), 0, 1).toMap();
			workingCopyDS = workingCopyDS.applyRange(shift);
			
			Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = workingCopyDS.copy().getClosedFormRelation();
			/**
			 * various heuristics to reduce the number of pieces.
			 */
			debug(" - simplify "+closedFormRelation);
			closedFormRelation = new AllocationFunctionSimplification(PREFIX).simplify(closedFormRelation);

			debug("expansion #"+i+" : "+closedFormRelation);
			res.add(closedFormRelation);
		}
		
		return res;
	}
	
	/**
	 * For memory allocation : select the dependencies involved with statementID
	 * and move it to the scheduled space
	 */
	JNIISLMap selectAndScheduleForAllocation(
			String statementID, // the ID of the statement that has to be reallocated
			JNIISLUnionSet domains, 
			JNIISLUnionMap writes,
			JNIISLUnionMap reads,
			JNIISLUnionMap valueBasedPrdg,
			JNIISLUnionMap schedule
			) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	/**
	 * For array contraction : select the dependencies involved with arrayName
	 * and move them to the scheduled space
	 */
	Pair<JNIISLMap,JNIISLSet> selectAndScheduleForContraction(
			String arrayName, // the name of the array symbol that has to be reallocated
			JNIISLUnionSet domains, 
			JNIISLUnionMap writes,
			JNIISLUnionMap reads,
			JNIISLUnionMap valueBasedPrdg,
			JNIISLUnionMap schedule
			) {
		debug("Contracting array "+arrayName);
		//select statements writing into the selected array
		JNIISLSpace space1 = writes.getDomain().getSetAt(0).getSpace();
		JNIISLSet base = JNIISLSet.buildEmpty(space1.copy());
		JNIISLUnionSet stmtsAccessingTmp = base.toUnionSet();
		List<JNIISLMap> maps = writes.copy().getMaps();
		debug("statements writing "+arrayName+" : ");
		for (JNIISLMap map : maps)
			if (map.getTupleName(JNIISLDimType.isl_dim_out).equals(arrayName)) {
				stmtsAccessingTmp = stmtsAccessingTmp.union(map.getDomain().toUnionSet());
				debug("    "+map);
			}
		
		JNIISLUnionSet scheduledWriteDomain = domains.copy().intersect(stmtsAccessingTmp.copy()).apply(schedule.copy());
		if (scheduledWriteDomain.getNbSets() > 1)
			throw new RuntimeException();
		
		JNIISLUnionMap selectedPrdg = valueBasedPrdg.copy().intersectRange(stmtsAccessingTmp);
		//select statements reading from the selected array
		base = JNIISLSet.buildEmpty(space1);
		stmtsAccessingTmp = JNIISLUnionSet.fromSet(base);
		maps = reads.copy().getMaps();
		debug("statements reading "+arrayName+" : ");
		for (JNIISLMap map : maps)
			if (map.getTupleName(JNIISLDimType.isl_dim_out).equals(arrayName)) {
				stmtsAccessingTmp = stmtsAccessingTmp.union(map.getDomain().toUnionSet());
				debug("    "+map);
			}
		selectedPrdg = selectedPrdg.intersectDomain(stmtsAccessingTmp);
		
		//from here, we work in the scheduled space
		JNIISLUnionMap schedSelectedPrdg = selectedPrdg.applyDomain(schedule.copy()).applyRange(schedule.copy()).coalesce();
		debug("scheduled selected PRDG : "+schedSelectedPrdg);
		
		JNIISLMap res;
		if (schedSelectedPrdg.getNbMaps() == 0) 
			res = JNIISLMap.buildEmpty(JNIISLSpace.idMapDimFromSetDim(schedule.getRange().getSetAt(0).getSpace()));
		else if (schedSelectedPrdg.getNbMaps() == 1)
			res = schedSelectedPrdg.getMapAt(0);
		else
			throw new RuntimeException();
		
		return new Pair<JNIISLMap, JNIISLSet>(res, scheduledWriteDomain.getSetAt(0));
	}
	
	
	/**
	 * Build the conflict set from the selected dependencies.
	 * Instead of returning a set in Z^2n, returns a relation in
	 * Z^n <-> Z^n.
	 * @param parallelDimensions 
	 */
	JNIISLMap buildCS(JNIISLMap schedSelectedPrdgMap, JNIISLSet scheduledWriteDomain, List<Boolean> parallelDimensions) {
		JNIISLMap lastUse = schedSelectedPrdgMap.copy().reverse().lexMax().coalesce();
		debug("last use : "+lastUse);
		
		JNIISLSpace space = scheduledWriteDomain.copy().getSpace();
		JNIISLMap lexCmp = space.lexGE(); // original definition
		debug("lexGE : "+lexCmp);
		
		JNIISLMap predWrites = lexCmp.copy().intersectRange(schedSelectedPrdgMap.copy().getRange());
		debug("predWrites : "+predWrites);
		
		JNIISLMap part1 = lastUse.applyRange(predWrites).coalesce();
		debug("part1 : "+part1);
		
		JNIISLMap part2 = part1.copy().reverse();
		debug("part2 : "+part2);
		
		JNIISLMap cs = part1.intersect(part2).coalesce();
		
		/** 
		 * The following commented section is covered by 
		 * the // process parallel dimensions. 
		 **/
		// cs is symetric, therefore any writing iteration conflicts with itself
//		JNIISLMap idConflict = JNIISLMap.lexEQFirst(space.copy(),nbDims);
//		debug("id conflict = "+idConflict);
//		idConflict = idConflict.intersectDomain(scheduledWriteDomain.copy());
//		debug("id conflict = "+idConflict);
//		idConflict = idConflict.intersectRange(scheduledWriteDomain.copy());
//		debug("id conflict = "+idConflict);
//		cs = cs.union(idConflict);
		
		// process parallel dimensions
		debug("process parallel dimensions");
		JNIISLBasicMap bm = JNIISLBasicMap.buildUniverse(cs.getSpace().copy());
		for (int i = 0; i < parallelDimensions.size(); i++) {
			if (parallelDimensions.get(i)) {
				// the dimension is parallel, hence one operation conflicts with
				// all the others on that same dimension
				debug("  - dim "+i+" is parallel");
			} else {
				// the dimension is not parallel, hence one operation conflicts
				// with itself only on that same dimension
				debug("  - dim "+i+" is not parallel");
				JNIISLConstraint c = JNIISLConstraint.buildEquality(cs.getSpace());
				c = c.setConstant(0);
				c = c.setCoefficient(JNIISLDimType.isl_dim_in, i, 1);
				c = c.setCoefficient(JNIISLDimType.isl_dim_out, i, -1);
				bm = bm.addConstraint(c);
			}
		}
		JNIISLMap parallelConflicts = bm.toMap();
		debug("  - tomap : "+parallelConflicts);
		
		parallelConflicts = parallelConflicts.intersectDomain(scheduledWriteDomain.copy());
		parallelConflicts = parallelConflicts.intersectRange(scheduledWriteDomain.copy());
		
		cs = cs.union(parallelConflicts).coalesce();

		debug("cs = "+cs);
		return cs;
	}

	/**
	 * Construct the difference set from the conflict set.
	 * 
	 * @param cs
	 */
	JNIISLSet buildDS(JNIISLSet context, JNIISLMap cs) {
		int nbDims = cs.getNbDims(JNIISLDimType.isl_dim_in);
		JNIISLMap ds_tmp = cs.moveDims(JNIISLDimType.isl_dim_in, 0, JNIISLDimType.isl_dim_out, 0, nbDims);
		ds_tmp = ds_tmp.insertDims(JNIISLDimType.isl_dim_out, 0, nbDims);
		JNIISLBasicMap subtract = JNIISLBasicMap.buildUniverse(ds_tmp.getSpace());
		//insert constraint out = (in1-in2)
		for (int i = 0; i < nbDims; i++) {
			//out_i = in_i - in_(nbDim+i)
			JNIISLConstraint constraint = JNIISLConstraint.buildEquality(ds_tmp.getSpace());
			constraint = constraint.setConstant(0);
			constraint = constraint.setCoefficient(JNIISLDimType.isl_dim_in, i, 1);
			constraint = constraint.setCoefficient(JNIISLDimType.isl_dim_in, i+nbDims, -1);
			constraint = constraint.setCoefficient(JNIISLDimType.isl_dim_out, i, -1);
			subtract   = subtract.addConstraint(constraint);
		}
		
		ds_tmp = ds_tmp.intersect(subtract.toMap());
		debug("ds map = "+ds_tmp);
		JNIISLSet ds = ds_tmp.getRange().intersectParams(context).coalesce();
		
//		// cs is symetric, therefore ds is 0-symetric (and should contain \vec{0})
//		JNIISLSpace space = ds.getSpace();
//		JNIISLBasicSet bs = JNIISLBasicSet.universe(space.copy());
//		// build \vec{0}
//		for (int i = 0; i < nbDims; i++) {
//			JNIISLConstraint c = JNIISLConstraint.equality(space.copy());
//			c = c.setConstant(0);
//			c = c.setCoef(JNIISLDimType.isl_dim_set, i, 1);
//			bs = bs.addConstraint(c);
//		}
//		// check if DS contains \vec{0}
//		if (ds.copy().intersect(bs.toSet()).empty())
//			throw new RuntimeException();

		debug("ds = "+ds);
		return ds;
	}
	
	
	public static String printAlloc(List<Map<JNIISLSet, JNIISLMultiAff>> alloc) {
		String str = "";
		for (Map<JNIISLSet, JNIISLMultiAff> map : alloc) {
			String tmp="[";
			if (map.size() > 1)
				tmp+="max(";
			boolean first = true;
			for (JNIISLMultiAff maff : map.values()) {
				if (first) first = false;
				else tmp+=",";
				String string = maff.toString();

				string = string.substring(0,string.lastIndexOf("}")-3);
				string = string.substring(string.lastIndexOf(">")+4);
				
				tmp += string;
			}
			if (map.size() > 1)
				tmp += ")";
			tmp+="]";
			if (!tmp.equals("[1]"))
				str += tmp;
			else 
				str += "[]";
		}
//		if (str.contains("[]"))
//			throw new RuntimeException();
		return str;
	}
}
