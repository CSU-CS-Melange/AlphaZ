
package fr.irisa.cairn.jnimap.isl.jni.extra;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMultiAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSpace;

public class ISLLexShiftTools {
		
	public static JNIISLMap lexNextPower(JNIISLSet dom, int depth, int power) {
		return lexShiftPower(dom,depth,power,false,false);	
	}
	
	public static JNIISLMap lexPredPower(JNIISLSet dom, int depth, int power) {
		return lexShiftPower(dom,depth,power,true,false);	
	}
	
	public static JNIISLMap lexShiftPower(JNIISLSet dom, int depth, int power, boolean pred, boolean verbose) {
		if (verbose) System.out.println("[LexShiftPower] ***** Start *****");
		if (verbose) System.out.println("[LexShiftPower] Computing "+(pred?"Pred":"Next")+" on "+depth+" innermost dimensions of");
		if (verbose) System.out.println("[LexShiftPower] "+dom);
		
		//compute next
		JNIISLMap current = pred?lexPred(dom,depth):lexNext(dom,depth);
		
		if (verbose) System.out.println("[LexShiftPower] "+(pred?"Pred":"Next")+" = "+current);
		
		return current.power(power);
	}
	
	public static JNIISLMap lexNext(JNIISLSet dom, int nbInnerLoop) {

		int nb = dom.getNbDims();
		if (nbInnerLoop > nb) nbInnerLoop = nb;
		if (nbInnerLoop < 1) {
			//happen when dom has 0 dimensions.
			return JNIISLMap.buildEmpty(JNIISLSpace.idMapDimFromSetDim(dom.getSpace()));
		}
		JNIISLMap map = JNIISLMap.fromDomainAndRange(dom.copy(), dom.copy());
//		JNIISLMap lt = JNIISLMap.lexLT(dom.getSpace().copy());
		
		JNIISLMap nxt = null;
//		int nb = lt.getNumberOfBasicMap();
		int i;
		for (i = nb-1; i >= nb-nbInnerLoop; i--) {
//			JNIISLMap succs = JNIISLMap.fromBasicMap(lt.getBasicMapAt(i));
			JNIISLMap succs = dom.getSpace().lexLTAt(i);
			JNIISLMap lexMin = map.intersect(succs).makeDisjoint().lexMin();
			if (nxt == null) {
				nxt = lexMin;
			} else {
				nxt = nxt.union(lexMin);
			}
			/*
			 * Complement + intersect is more efficient in terms guard count.
			 * Mainly due to isl behavior.
			 */
//			JNIISLSet remain = JNIISLSet.substract(dom.copy(),nxt.copy().getDomain());
			JNIISLSet remain = nxt.getDomain().complement().intersect(dom.copy());
			map = JNIISLMap.fromDomainAndRange(remain, dom.copy());
		}

		return nxt.coalesce();
	}
	
	/**
	 * Computes the immediate successor in a given domain, where the validity
	 * domains have been gisted.
	 * 
	 * Main purpose : guard-less code generation.
	 * 
	 * @param dom
	 *            domain to scan
	 * @param nbInnerLoop
	 *            number of innermost loops to stick to (limit complexity)
	 * @return a list containing the expression of the immediate successor in
	 *         dom, XXX ordered by dimensions, from innermost to outermost
	 *         dimensions. Entries are also ordered within the Maps (because of
	 *         the gist operation).
	 */
	public static List<Map<JNIISLSet,JNIISLMultiAff>> gistedOrderedLexNext(JNIISLSet dom, int nbInnerLoop) {
		int nDim = (int) dom.getNbDims();
		if (nbInnerLoop > nDim) nbInnerLoop = nDim;
		if (nbInnerLoop < 1) {
			//happen when dom has 0 dimensions.
			return new ArrayList<Map<JNIISLSet,JNIISLMultiAff>>(0);
		}
		
		List<Map<JNIISLSet,JNIISLMultiAff>> res = new ArrayList<Map<JNIISLSet,JNIISLMultiAff>>(nbInnerLoop);
		
		int i;
		for (i = nDim-1; i >= nDim-nbInnerLoop; i--) {
			JNIISLMap lexLTi = dom.getSpace().lexLTAt(i);
			JNIISLSet from = dom.copy().eliminateDims(i+1,nDim-i-1).simplify();
			JNIISLMap start = JNIISLMap.fromDomainAndRange(from, dom.copy());
			JNIISLMap succi = start.intersect(lexLTi);
			JNIISLMap tmpnexti = succi.lexMin().simplify();
			Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = tmpnexti.getClosedFormRelation();
			
			// use LinkedHashMap to keep the order on the key set.
			Map<JNIISLSet, JNIISLMultiAff> tmp = new LinkedHashMap<JNIISLSet, JNIISLMultiAff>();
			for (Entry<JNIISLSet, JNIISLMultiAff> e : closedFormRelation.entrySet()) {
				JNIISLSet valid = e.getKey();
				JNIISLMultiAff func = e.getValue();
				JNIISLSet gistedValid = valid.gist(dom.copy()).simplify();
				if (!gistedValid.isEmpty()) {
					tmp.put(gistedValid, func);
				}
				
			}
			res.add(tmp);
		}
		return res;
	}

	/**
	 * @deprecated doesnt seem to be doing what it should do...
	 */
	@Deprecated
	static List<Map<JNIISLSet,JNIISLMultiAff>> gistedOrderedLexNext(JNIISLSet dom, int nbInnerLoop, int power) {
		int nDim = (int) dom.getNbDims();
		if (nbInnerLoop > nDim) nbInnerLoop = nDim;
		if (nbInnerLoop < 1) {
			//happen when dom has 0 dimensions.
			return new ArrayList<Map<JNIISLSet,JNIISLMultiAff>>(0);
		}
		
		List<Map<JNIISLSet,JNIISLMultiAff>> res = new ArrayList<Map<JNIISLSet,JNIISLMultiAff>>(nbInnerLoop);
		
		JNIISLSet history = null;
		//Innermost dimension
		{
			//find the case when next^power is within the innermost loop
			int dim = nDim-1;
			JNIISLMap lexLTi = dom.getSpace().copy().lexLTAt(dim);
			JNIISLSet from = dom.copy().eliminateDims(dim+1,nDim-dim-1).simplify();
			JNIISLMap start = JNIISLMap.fromDomainAndRange(from, dom.copy());
			JNIISLMap succi = start.copy().intersect(lexLTi.copy());
			System.err.println("succi: "+succi);
			JNIISLMap tmpnexti = succi.copy().lexMin().simplify();
			System.err.println("tmpnexti: "+tmpnexti);
			
			history = tmpnexti.copy().getDomain();
			
			res.add(getClosedForm(tmpnexti, dom));
		}
		
		// shifting in innermost loop only
		// innermost + 1 = shift in the innermost for (power-1) and then find next
		// innermost + 2 = shift in the innermost for (power-2), find next and then shift by 1
		//   ...
		// innermost + power-1
		
		// innermost loop only
		// outer(1) + shift
		// outer(2) + shift
		// outer(...) + shift
		//  -- assume the shift wont cross another boundary 
		
		{
			int dim = nDim-1;
			JNIISLMap lexLTi = dom.getSpace().copy().lexLTAt(dim-1);
			JNIISLSet from = dom.copy().eliminateDims(dim+1,nDim-dim-1).simplify();
			from = from.subtract(history);
			JNIISLMap start = JNIISLMap.fromDomainAndRange(from, dom.copy());
			JNIISLMap succi = start.copy().intersect(lexLTi.copy());
			System.err.println("succi: "+succi);
			JNIISLMap tmpnexti = succi.copy().lexMin().simplify();
			System.err.println("tmpnexti: "+tmpnexti);
			res.add(getClosedForm(tmpnexti, dom));
		}
		
		{
			int dim = nDim-1;
			JNIISLMap lexLTi = dom.getSpace().copy().lexLTAt(dim-1);
			JNIISLSet from = dom.copy().eliminateDims(dim+1,nDim-dim-1).simplify();
			from = from.subtract(history);
			JNIISLMap start = JNIISLMap.fromDomainAndRange(from, dom.copy());
			JNIISLMap succi = start.copy().intersect(lexLTi.copy());
			System.err.println("succi: "+succi);
			JNIISLMap tmpnexti = succi.copy().lexMin().simplify();
			System.err.println("tmpnexti: "+tmpnexti);
			res.add(getClosedForm(tmpnexti, dom));
//			history = tmpnexti.copy().getDomain();
//			tmpnexti.
//			System.err.println(lexNextPower(dom.substract(history), nbInnerLoop, power));
			
//			//find the case when next^power is within the innermost loop
//			int dim = nDim-2;
//			JNIISLMap lexLTi = lexLTi(dom.getSpace().copy(),dim);
//			JNIISLSet from = dom.copy().eliminateDims(dim+1,nDim-dim-1).simplify();
//			System.err.println(history);
//			from = from.substract(history);
//			System.err.println(from);
//			JNIISLMap start = JNIISLMap.fromDomainAndRange(from, dom.copy());
//			JNIISLMap succi = start.copy().intersect(lexLTi.copy());
//			System.err.println("succi: "+succi);
//			JNIISLMap tmpnexti = succi.copy().lexMin().simplify();
//			System.err.println("tmpnexti: "+succi);
//			
//			res.add(getClosedForm(tmpnexti, dom));
		}
		
//		for (int dim = nDim-2; dim >= nDim-nbInnerLoop; dim--) {
//			//lexLTi : in << out @ dim i
//			//from   : dom - dimensions(i+1..nDim)
//			//start  : [from] -> [dom]
//			//succi  : start intersect lexLTi
//			//tempnexti : succi.lexMin
//			for (int p = 1; p <= power; p++) {
//				if (dim==nDim-1 && p > 1)
//					continue;
//
//				JNIISLMap lexLTi;
//				//if its the inner most dimension, 
//				if (dim==nDim-1) {
//					lexLTi = lexLTi(dom.getSpace().copy(),dim, power);
//				} else {
//					lexLTi = lexLTi(dom.getSpace().copy(),dim);
//				}
//				System.err.println(dim);
//				System.err.println("lexLTi: "+lexLTi);
//				JNIISLSet from = dom.copy().eliminateDims(dim+1,nDim-dim-1).simplify();
//				
//				System.err.println("from: "+from);
//				JNIISLMap start = JNIISLMap.fromDomainAndRange(from, dom.copy());
//				
//				System.err.println("start: "+start);
//				JNIISLMap succi = start.copy().intersect(lexLTi.copy());
//				
//				System.err.println("succi: "+succi);
//				JNIISLMap tmpnexti = succi.copy().lexMin().simplify();
//				
//				System.err.println("tmpnexti: "+tmpnexti);
//				
//				Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = tmpnexti.getClosedFormRelation();
//				System.err.println("closedFormRelation: "+closedFormRelation);
//				
//				// use LinkedHashMap to keep the order on the key set.
//				Map<JNIISLSet, JNIISLMultiAff> tmp = new LinkedHashMap<JNIISLSet, JNIISLMultiAff>();
//				for (Entry<JNIISLSet, JNIISLMultiAff> e : closedFormRelation.entrySet()) {
//					JNIISLSet valid = e.getKey();
//					JNIISLMultiAff func = e.getValue();
//					JNIISLSet gistedValid = valid.copy().gist(dom.copy()).simplify();
//					if (!gistedValid.empty())
//						tmp.put(gistedValid, func);
//				}
//				res.add(tmp);
//			}
//			
//			
//			
//		}
		return res;
	}
	
	private static Map<JNIISLSet, JNIISLMultiAff> getClosedForm(JNIISLMap map, JNIISLSet dom) {
		Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = map.getClosedFormRelation();
		
		// use LinkedHashMap to keep the order on the key set.
		Map<JNIISLSet, JNIISLMultiAff> tmp = new LinkedHashMap<JNIISLSet, JNIISLMultiAff>();
		for (Entry<JNIISLSet, JNIISLMultiAff> e : closedFormRelation.entrySet()) {
			JNIISLSet valid = e.getKey();
			JNIISLMultiAff func = e.getValue();
			JNIISLSet gistedValid = valid.copy().gist(dom.copy()).simplify();
			if (!gistedValid.isEmpty())
				tmp.put(gistedValid, func);
		}
		
		return tmp;
	}
	
	public static JNIISLMap lexPred(JNIISLSet dom, int nbInnerLoop) {

		int nDim = dom.getNbDims();
		if (nbInnerLoop > nDim) nbInnerLoop = nDim;
		if (nbInnerLoop < 1) {
			//happen when dom has 0 dimensions.
			return JNIISLMap.buildEmpty(JNIISLSpace.idMapDimFromSetDim(dom.getSpace()));
		}
		
		JNIISLMap map = JNIISLMap.fromDomainAndRange(dom.copy(), dom.copy());
		JNIISLMap gt = dom.getSpace().copy().lexGT();
		
		JNIISLMap prd = null;
		int nb = gt.getNbBasicMaps();
		int i;
		for (i = nb-1; i >= nb-nbInnerLoop; i--) {
			JNIISLMap preds = gt.getBasicMapAt(i).toMap();
			JNIISLMap lexMax = map.intersect(preds).makeDisjoint().lexMax();
			if (prd == null) {
				prd = lexMax;
			} else {
				prd = prd.union(lexMax);
			}
			JNIISLSet remain = dom.copy().subtract(prd.copy().getDomain());
			map = JNIISLMap.fromDomainAndRange(remain,dom.copy());
		}
		return prd.coalesce();
	}
}