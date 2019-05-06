package fr.irisa.cairn.jnimap.isl.jni.extra;

import java.util.List;
import java.util.Map;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMultiAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

/**
 * 
 * XXX not tested
 * 
 * @author amorvan
 *
 */
public class ISLDetectTilableBand {
	
	public static class Band {
		public int from;
		public int to;
		public int number;
		public JNIISLUnionMap schedMap;
		public List<Integer> tileSizes;
		
		public Band(int f, int n) {
			this(f,n, null);
		}
		
		public Band(int f, int n, JNIISLUnionMap sched) {
			this(f, n, sched, null);
		}
		
		public Band(int f, int n, JNIISLUnionMap sched, List<Integer> tsize) {
			this.from = f;
			this.number = n;
			this.to = f+n-1;
			this.schedMap = sched;
			this.tileSizes = tsize;
		}
		
		public String toString() { return "["+from+".."+to+"] :" + schedMap; }
	}
	
	
	/**
	 * Compute the first tilable band (starting from the outermost dimension).
	 * If none is found, returns null.
	 * 
	 * @param prdg
	 * @param schedule
	 * @return
	 */
	public static Band detect(JNIISLUnionMap prdg, JNIISLUnionMap schedule) {
		JNIISLUnionMap schedulePRDGUMap = prdg.copy().applyRange(schedule.copy()).applyDomain(schedule.copy());
		if (schedulePRDGUMap.getNbMaps() == 0) {
			int first = findFirstNonOrderingDimension(schedule.copy());
			if ( first == Integer.MAX_VALUE ) {
				Band band = new Band(0,0);
				return band;
			}
			int first2 = findFirstOrderingDimension(first,schedule.copy());
			Band band = new Band(first,first2-first+1);
//			System.out.println("Band : "+band);
			return band;
		}
		if (schedulePRDGUMap.getNbMaps() != 1)
			throw new RuntimeException();
		
		JNIISLMap schedulePRDGMap = schedulePRDGUMap.copy().getMapAt(0);
		int nbScheduleDims = (int)schedulePRDGMap.copy().getNbOuts();
		
		//1 look for the first non-ordering dimension (i.e. that is not a scalar dimensions)
		int first = findFirstNonOrderingDimension(schedule.copy());
		if ( first == Integer.MAX_VALUE ) {
			Band band = new Band(0,0);
			return band;
		}
		int first2 = findFirstOrderingDimension(first,schedule.copy());
		
		//2 check all edges until tilability breaks
		int current = first;
		boolean con = true;
		while (current < nbScheduleDims && (current <= first2) && con) {
			con = isTilable(schedulePRDGMap.copy(),current) && nbScheduleDims > current;
			if ( con )
				current++;
		}
		Band band = new Band(first,current-first+1);
//		System.out.println("Band : "+band);
		return band;
	}

	private static boolean isTilable(JNIISLMap schedulePRDGMap, int dimension) {
		if (schedulePRDGMap.getNbIns()-1 < dimension) return false;
		JNIISLMap projectIn = schedulePRDGMap.copy().projectIn(JNIISLDimType.isl_dim_in, dimension);
		projectIn = projectIn.projectIn(JNIISLDimType.isl_dim_out, dimension);
		JNIISLMap lexLT = projectIn.copy().getSpace().lexLTfirst(1);
		JNIISLMap intersect = projectIn.copy().intersect(lexLT.copy());
		boolean empty = intersect.copy().isEmpty();
		return empty;
	}
	
	/**
	 * Find the first non scalar dimension in the scheduled space by iterating
	 * over schedule functions expressions, and checking if they are constants
	 * for all statements
	 * 
	 * @param schedulePRDGMap
	 * @return
	 */
	private static int findFirstNonOrderingDimension(JNIISLUnionMap schedulePRDGMap) {
		List<JNIISLMap> maps = schedulePRDGMap.copy().getMaps();
		int min = Integer.MAX_VALUE;
		for (JNIISLMap m : maps) {
			if (!m.copy().isSingleValued())
				throw new RuntimeException();
			Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = m.copy().getClosedFormRelation();
			if (closedFormRelation.size() != 1)
				throw new RuntimeException();
			JNIISLMultiAff scheduleExpression = closedFormRelation.values().iterator().next();
			List<JNIISLAff> Affs = scheduleExpression.copy().getAffs();
			int nbAff = Affs.size();
			affloop: for (int i = 0; i < nbAff; i++) {
				JNIISLAff aff = Affs.get(i);
				if (!aff.copy().isConstant()) {
					min = Math.min(min, i);
					break affloop;
				}	
			}
		}
		return min;
	}
	
	/**
	 * In the schedule, finds the first ordering (scalar) dimension that is after 'dim' 
	 * @param dim
	 * @param schedulePRDGMap
	 * @return
	 */
	private static int findFirstOrderingDimension(int dim, JNIISLUnionMap schedulePRDGMap) {
		List<JNIISLMap> maps = schedulePRDGMap.copy().getMaps();
		int min = dim+1;
		if ( min > maps.get(0).getNbOuts() )
			return min-1;
		boolean foundScalarDim = false;
		for (JNIISLMap m : maps) {
			Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = m.copy().getClosedFormRelation();
			JNIISLMultiAff scheduleExpression = closedFormRelation.values().iterator().next();
			List<JNIISLAff> Affs = scheduleExpression.copy().getAffs();
			int nbAff = Affs.size();
			
			affloop: for (int i = min; i < nbAff; i++) {
				JNIISLAff aff = Affs.get(i);
				if (aff.isConstant()) {
					min = i;
					foundScalarDim = true;
					break affloop;
				}	
			}
		}
		if ( !foundScalarDim )
			return maps.get(0).getNbOuts()-1;
		else
			return min-1;
	}
}
