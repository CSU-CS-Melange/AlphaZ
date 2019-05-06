package fr.irisa.cairn.jnimap.isl.jni.memorylayout;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMultiAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

/**
 * 4 heuristics to eliminate pieces of the memory allocation function.
 * Example 1 : if the expansion degree is max(0,N-1), it can be 
 * simplified into N-1 only (degrees are all positive). 
 * Example 2 : max(N-1,N-2) >> N-1
 * 
 * @author amorvan
 *
 */
public class AllocationFunctionSimplification {

	/**
	 * Debug related functions
	 */
	private boolean debug = false;
	private static String DEFAULT_PREFIX = "[SIMPLIFY] ";
	private void debug() { debug(""); }
	private void debug(Object o) {
		if (debug) {
			String string = PREFIX+o.toString().replace("\n","\n"+PREFIX);
			System.out.println(string);
		}
	}
	
	private String PREFIX;
	public AllocationFunctionSimplification() {PREFIX = DEFAULT_PREFIX;}
	public AllocationFunctionSimplification(String p) {PREFIX = p+DEFAULT_PREFIX;}
	
	
	public Map<JNIISLSet, JNIISLMultiAff> simplify(Map<JNIISLSet, JNIISLMultiAff> closedFormRelation) {
		debug(" ***** START *****");
		long time = System.currentTimeMillis();
		debug();
		int initSize = closedFormRelation.size();
		debug(" 0) init solution: "+initSize+" pieces");
		for (Entry<JNIISLSet, JNIISLMultiAff> e : closedFormRelation.entrySet())
			debug("    "+e.getValue()+" : "+e.getKey());
		debug();
		
		List<Entry<JNIISLSet,JNIISLMultiAff>> csts = new ArrayList<>();
		List<Entry<JNIISLSet,JNIISLMultiAff>> exprs = new ArrayList<>();
		for (Entry<JNIISLSet,JNIISLMultiAff> e : closedFormRelation.entrySet()) {
			JNIISLMultiAff maff = e.getValue();
			//the Aff expression should be 1D (because of the projectIn)
			if (maff.getNbAff() > 1)
				throw new RuntimeException();
			//split in 2 lists : constant and parameter-dependent expressions
			JNIISLAff affAt = maff.copy().getAff(0);
			if (!affAt.isConstant()) exprs.add(e);
			else csts.add(e);
		}

		// 1. get the maximum constant (compute union of domains)
		debug(" 1) Compute max cst");
		Entry<JNIISLSet,JNIISLMultiAff> maxCst = maxConstant(csts);
		debug("    >> "+maxCst);
		debug();

		// 2. eliminate expressions whose max is lower than another on the same
		// domain (make union of domains)
		// [m-2] vs. [m-1] >> m-1 will me greater...
		// check with more complex cases (multi-variables)
		debug(" 2) Eliminate non constant exprs");
		PREFIX = PREFIX+"### ";
		exprs  = eliminateExprs(exprs);
		PREFIX = PREFIX.substring(0,PREFIX.length()-4);
		debug();

		// 3. eliminate 0 constant if there is at least one expression.
		debug(" 3) Eliminate 0 constant");
		if (exprs.size() > 0 && maxCst != null && maxCst.getValue().getAff(0).getConstant() == 0) {
			maxCst = null;
			debug("done.");
		} else debug("no");
		debug();
		
		// 4. eliminate constant if at least one expression lexmin covers the
		// constant on its domain
		// [m-1] : m >= 2;  [1] : m ==1 .....
		debug(" 4) Eliminate constant if exprs is always greater");
		maxCst  = eliminateCst(maxCst,exprs);
		debug();
		
		
		Map<JNIISLSet, JNIISLMultiAff> res = new LinkedHashMap<>(exprs.size()+(maxCst==null?0:1));
		if (maxCst != null)
			res.put(maxCst.getKey(), maxCst.getValue());
		for (Entry<JNIISLSet,JNIISLMultiAff> e : exprs)
			res.put(e.getKey(), e.getValue());
		
		debug(" *) Final solution : "+res.size()+" pieces, init was "+initSize);
		for (Entry<JNIISLSet, JNIISLMultiAff> e : res.entrySet())
			debug("    "+e.getValue()+" : "+e.getKey());
		debug();
		time = System.currentTimeMillis() - time;
		debug(" bounding time : "+time+" ms.");
		debug(" ***** END *****") ;
		return res;
	}

	private Entry<JNIISLSet, JNIISLMultiAff> maxConstant(List<Entry<JNIISLSet, JNIISLMultiAff>> csts) {
		Entry<JNIISLSet,JNIISLMultiAff> res = null;
		JNIISLSet union = null;
		long cstmax = Long.MIN_VALUE;
		for (Entry<JNIISLSet,JNIISLMultiAff> e : csts) {
			JNIISLMultiAff value = e.getValue().copy();
			JNIISLAff affAt = value.getAff(0);
			long constant = affAt.getConstant();
			cstmax = Math.max(cstmax, constant);
			if (cstmax == constant) res = e;
			if (union ==  null) union = e.getKey();
			else union = union.union(e.getKey());
		}
		if (res != null) {
			JNIISLMultiAff value = res.getValue();
			res = new AbstractMap.SimpleEntry<JNIISLSet, JNIISLMultiAff>(union.coalesce(), value);
		}
		return res;
	}
	
	private List<Entry<JNIISLSet, JNIISLMultiAff>> eliminateExprs(List<Entry<JNIISLSet, JNIISLMultiAff>> exprs) {
		if (exprs.size() < 2) {
			debug("only 1 expr.");
			return exprs;
		}
		debug("**********************");
		debug("orig exprs : ");
		for (Entry<JNIISLSet, JNIISLMultiAff> e : exprs)
			debug(" - "+e.getValue()+" : "+e.getKey());
		debug(" -- ");
main: 	for (int i = 0; i < exprs.size()-1; i++) {
			Entry<JNIISLSet, JNIISLMultiAff> expr1 = exprs.get(i);
			for (int j = i+1; j < exprs.size(); j++) {
				Entry<JNIISLSet, JNIISLMultiAff> expr2 = exprs.get(j);
				JNIISLSet union = expr1.getKey().copy().union(expr2.getKey().copy()).coalesce();
				
				JNIISLAff aff1 = expr1.getValue().copy().getAff(0);
				JNIISLAff aff2 = expr2.getValue().copy().getAff(0);
				
				JNIISLAff mAff2 = aff2.scale(-1);
				JNIISLAff add = aff1.add(mAff2);
				//add = aff1 - aff2
			
				if (add.isConstant()) {
					//(add >= 0) => (aff1 - aff2 >= 0) => (aff1 >= aff2)
					if (add.getConstant() >= 0) {
						//debug("keep : "+aff1);
						exprs.set(i, new AbstractMap.SimpleEntry<JNIISLSet, JNIISLMultiAff>(union,expr1.getValue()));
						exprs.remove(expr2);
						continue;	
					} else {
						//debug("keep : "+aff2);
						exprs.set(j, new AbstractMap.SimpleEntry<JNIISLSet, JNIISLMultiAff>(union,expr2.getValue()));
						exprs.remove(expr1);
						i--;
						continue main;
					}
				} else {
					//cannot do a thing if expression is not constant.
				}
			}
		}
		
		debug("final exprs = ");
		for (Entry<JNIISLSet, JNIISLMultiAff> e : exprs)
			debug(" - "+e.getValue()+" : "+e.getKey());
		debug("----------------------");

		List<Entry<JNIISLSet, JNIISLMultiAff>> res = new ArrayList<>();
		res = exprs;
		return res;
	}
	
	/**
	 * if the lexmin of at least one expression in exprs is always greater or
	 * equal than the maxCst, then the maxCst can be ignored.
	 */
	private Entry<JNIISLSet, JNIISLMultiAff> eliminateCst(
			Entry<JNIISLSet, JNIISLMultiAff> maxCst,
			List<Entry<JNIISLSet, JNIISLMultiAff>> exprs) {
		
		if (maxCst == null) return null;
		if (exprs.size() == 0) return maxCst;
		long cst = maxCst.getValue().copy().getAff(0).getConstant();
		
		JNIISLSet cstDomain = maxCst.getKey().copy();
		debug(" cst   = ## "+cst+" ## : "+cstDomain);
		
		// if at least one of the expression covers the constant on the
		// constant domain, then the constant can be ignored.
		for (Entry<JNIISLSet, JNIISLMultiAff> e : exprs) {
			debug(" expr1 = "+e.getValue()+" : "+e.getKey());
			// build map representing the expression on the domain of the
			// constant
			JNIISLMap m = (e.getValue().copy()).toBasicMap().toMap().intersectDomain((cstDomain.copy())).coalesce();
			
			// the expression covers the constant if adding the constraint
			// (expr >= cst) do not change the domain
			JNIISLBasicMap lb = JNIISLBasicMap.buildUniverse(m.getSpace().copy());
			JNIISLConstraint c = JNIISLConstraint.buildInequality(m.getSpace().copy());
			c = c.setConstant((int)(-cst));
			c = c.setCoefficient(JNIISLDimType.isl_dim_out, 0, 1);
			lb = lb.addConstraint(c);
			JNIISLMap intersect = m.copy().intersect(lb.toMap());
			boolean equivalence = intersect.equivalence(m);
			debug("@@@"+intersect);
			debug("@@@ equivalent : "+equivalence);
			if (equivalence) {
				// if it is covered, the constant is eliminated by returning
				// null.
				debug("constant is covered by expression "+e.getValue()+" on domain "+cstDomain);
				return null;
			}
		}
		
		return maxCst;
	}
}
