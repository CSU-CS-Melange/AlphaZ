package fr.irisa.cairn.jnimap.isl.jni.codegen;

import java.util.AbstractMap;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionSet;

public class BouletFeautrierScanning {

	/**
	 * This methods build the activity domains of the Scop, where an activity is
	 * defined by a set of active statements and a corresponding polyhedral
	 * domain. It work recursilvely and starts from a list of statements and
	 * their domains.
	 * 
	 * @param depth
	 * @param currentDom
	 * @param stmts
	 * @param solution
	 */

	public static JNIISLMap buildNextMap(JNIISLUnionSet stmts) {

		/** Building merged statement domain **/
		JNIISLSet mergedSet = stmts.mergeAsSingleSet().coalesce();
		System.out.println(mergedSet);
		/** Building the next function following Boulet & Feautrier **/
		int nbDimensions = (int) mergedSet.getNbDims();
		JNIISLMap next = mergedSet.getLexNextMap(nbDimensions);

		return next;
	}

	
	public static Entry<JNIISLUnionMap, JNIISLUnionMap> scanningActivityDomains(JNIISLUnionSet stmts) {

		/** Building the variant/activity domains **/
		Entry<JNIISLUnionSet, JNIISLUnionMap> variantEntry = ActivityDomainBuilder
				.buildFromUnionSet(stmts);
		JNIISLUnionSet variantSet = variantEntry.getKey();
		
		JNIISLUnionMap variantMap = variantEntry.getValue();

		JNIISLUnionMap next =buildNextMap(stmts).toUnionMap();
		
		JNIISLUnionMap nextVariant = next.intersectRange(variantSet);
		
		return new AbstractMap.SimpleEntry<JNIISLUnionMap, JNIISLUnionMap>(variantMap,nextVariant);
	}

	/**
	 * The goal of this step is to use the domain information of the
	 * variants/activity domain to specialize the transition function. This
	 * allows to eliminate some of the guards associated to statement
	 * activation/deactivation.
	 * 
	 * The algorithm iterates over each transition of the initial FSM, and see
	 * whether it is feasible (satisfiable) in the context of a given variant
	 * domain pair. This significantly increases the number of transitions, but
	 * the guards within each transition are much simpler, as gisting within the
	 * variant context help pruning many redundant constraints
	 * 
	 * This returns a transition system that take advantage of all
	 * variants/activity domain context information. However, this system is not
	 * optimal as there can be several transitions between two given states.
	 **/

	

}
