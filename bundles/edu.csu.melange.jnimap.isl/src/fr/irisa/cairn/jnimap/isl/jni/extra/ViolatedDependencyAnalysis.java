package fr.irisa.cairn.jnimap.isl.jni.extra;

import java.util.List;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSpace;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

/**
 * Computes the violated dependency analysis on ISL objects.
 * 
 * @author amorvan
 *
 */
public class ViolatedDependencyAnalysis {

	public static boolean verbose = false;
	public static String PREFIX = "[VIOLATED DEP NALYSIS] ";
	
	/**
	 * Check if a dependency is legal on w.r.t. the given schedule, with given
	 * sequential/parallel dimensions.
	 * 
	 * @param validityDomain
	 *            JNIISLSet representing the validity domain of the dependency
	 *            in the original space.
	 * @param dep
	 *            JNIISLMap representing the dependency function in the original
	 *            space.
	 * @param scheduleUMap
	 *            JNIISLUnionMap containing the schedule for both source and
	 *            reference of the dependency.
	 * @param dimensions
	 *            List of boolean representing parallel dimensions of the
	 *            reference.
	 * @return Map of violated dependencies in the scheduled space.
	 * 
	 */
	public static JNIISLMap compute(JNIISLSet validityDomain, JNIISLMap dep,
			JNIISLUnionMap scheduleUMap, List<Boolean> parallelDimensions) {
		JNIISLMap dmap = dep.copy().intersectDomain(validityDomain.copy());
		return compute(dmap, scheduleUMap, parallelDimensions);
	}

	/**
	 * Check if a dependency is legal on w.r.t. the given schedule, with given
	 * sequential/parallel dimensions.
	 * 
	 * @param dep
	 *            JNIISLMap representing the dependency function in the original
	 *            space, intersected with its validity domain.
	 * @param scheduleUMap
	 *            JNIISLUnionMap containing the schedule for both source and
	 *            reference of the dependency.
	 * @param dimensions
	 *            List of boolean representing parallel dimensions of the
	 *            reference.
	 * @return Map of violated dependencies in the scheduled space.
	 * 
	 */
	public static JNIISLMap compute(JNIISLMap dep,
			JNIISLUnionMap scheduleUMap, List<Boolean> parallelDimensions) {
		
		if (!dep.isSingleValued()) {
			throw new IllegalArgumentException(dep+" is not a function (it is not single valued).");
		}
		
		if (dep.isEmpty()) {
			throw new IllegalArgumentException(dep+" is empty.");
		}
		
		// build ISL object representing the scheduled dependency with its
		// validity domain : schedDepMap
		JNIISLUnionMap dumap = dep.copy().toUnionMap();
		dumap = dumap.applyDomain(scheduleUMap.copy()).applyRange(scheduleUMap.copy()).coalesce();
		if (dumap.getNbMaps() != 1)
			throw new RuntimeException("Application of the schedule should not create multiple maps.");
		JNIISLMap schedDepMap = dumap.getMapAt(0);
		
		if (verbose) {
			System.out.println(PREFIX+"Computing violated dependency analysis on "+dep);
			System.out.println(PREFIX+"With schedule "+scheduleUMap);
			System.out.println(PREFIX+"And parallel dimensions : "+parallelDimensions);
		}
		
		// build basic map that will be used to test the lexicographic order of
		// the dependence at different levels : proxyEq
		JNIISLSpace space = schedDepMap.getSpace();
		JNIISLBasicMap proxyEq = JNIISLBasicMap.buildUniverse(space.copy());
		int i;
		for (i = 0; i < parallelDimensions.size(); i++) {
			boolean isParallel = parallelDimensions.get(i);
			
			if (isParallel) {
				// dimension is parallel
				// if != return false
				// if = continue
				JNIISLBasicMap t = proxyEq.copy().addConstraint(JNIISLConstraint.dimEqual(space.copy(), i));
				JNIISLMap tm = t.toMap();
				JNIISLMap intersect = schedDepMap.copy().intersect(tm);
				if (intersect.isEmpty()) {
					if (verbose) System.out.println(PREFIX+"     PAR : violated at depth "+i);
					return schedDepMap.copy();
				} else {
					if (verbose) System.out.println(PREFIX+"     PAR : weakly satisfied at depth "+i);
				}
			} else {
				// dimension is sequential
				// if < return false
				JNIISLBasicMap t = proxyEq.copy().addConstraint(JNIISLConstraint.dimLessThan(space.copy(), i));
				JNIISLMap tm = t.toMap();
				JNIISLMap intersect = schedDepMap.copy().intersect(tm);
				if (!intersect.isEmpty()) {
					if (verbose) System.out.println(PREFIX+"     SEQ : violated at "+i);
					return intersect;
				}

				// if > return true
				t = proxyEq.copy().addConstraint(JNIISLConstraint.dimGreaterThan(space.copy(), i));
				tm = t.toMap();
				intersect = schedDepMap.copy().intersect(tm);
				if (!intersect.isEmpty()) {
					if (verbose) System.out.println(PREFIX+"     SEQ : satisfied at depth "+i);
					return JNIISLMap.buildEmpty(space);
				}

				// if = continue
				if (verbose) System.out.println(PREFIX+"     SEQ : weakly satisfied at depth "+i);
			}
			// update proxyEq with equality on current dimension
			proxyEq = proxyEq.addConstraint(JNIISLConstraint.dimEqual(space.copy(), i));
		}
		
		//at that point, the dimension is not violated, but also
		//not carried by any of the scheduled dimensions.
		if (verbose) System.out.println(PREFIX+"   Dependency is not satisfied by any loop, thus violated everywhere.");
		return schedDepMap.copy();
	}
}
