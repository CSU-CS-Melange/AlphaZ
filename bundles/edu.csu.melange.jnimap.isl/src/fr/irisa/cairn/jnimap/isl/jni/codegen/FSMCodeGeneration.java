package fr.irisa.cairn.jnimap.isl.jni.codegen;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.isl.jni.ISLFactory;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMultiAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionSet;

public class FSMCodeGeneration {

	/**
	 * This methods build the activity domains of the Scop, where an activity is
	 * defined by a set of active statements and a corresponding polyhedral
	 * domain. It work recursively and starts from a list of statements and
	 * their domains.
	 * 
	 * @param depth
	 * @param currentDom
	 * @param stmts
	 * @param solution
	 */

	static boolean debug = false;
	
	public static class JNIFSM {
		JNIISLUnionSet states;
		JNIISLUnionMap transitions;
		JNIISLUnionMap commands;
		
		public JNIFSM(JNIISLUnionSet states, JNIISLUnionMap transitions, JNIISLUnionMap commands) {
			super();
			this.states = states;
			this.transitions = transitions;
			this.commands = commands;
		}

		public JNIISLUnionSet getStates() {
			return states;
		}

		public JNIISLUnionMap getTransitions() {
			return transitions;
		}

		public JNIISLUnionMap getCommands() {
			return commands;
		}
		
	}
	
	public static JNIFSM liveGuardOptimizations(JNIISLUnionSet stmts) {

		/** Building merged statement domain **/
		JNIISLSet mergedSet = stmts.mergeAsSingleSet();

		/** Building the variant/activity domains **/
		Entry<JNIISLUnionSet, JNIISLUnionMap> variantEntry = ActivityDomainBuilder.buildFromUnionSet(stmts);
		JNIISLUnionSet variantSet = variantEntry.getKey();
		JNIISLUnionMap variantMap = variantEntry.getValue();

		/** Building the next function following Boulet & Feautrier **/
		int nbDimensions = (int) mergedSet.getNbDims();
		JNIISLUnionMap next = mergedSet.getLexNextMap(nbDimensions).toUnionMap();
		
		
		/** Building the convexHull for enabling gisting later in the algorithm **/
		JNIISLBasicSet convexHull = mergedSet.copy().convexHull();

		if ( debug ) {
			System.out.println("#################################################################");
			System.out.println("Merged Statement Domain :\n\t-" + mergedSet.copy());
			System.out.println("#################################################################");
		}

		//showTransitions(next.getMapAt(0), convexHull.copy());

		JNIISLUnionMap variantNext = null;

		if ( debug ) {
			System.out.println("#### variantSet #############################################################");
			for (JNIISLSet _set : variantSet.getSets())
				System.out.println(_set);
			System.out.println("#### variantMap #############################################################");
			for (JNIISLMap _map : variantMap.getMaps())
				System.out.println(_map);
			System.out.println("#### next #############################################################");
			for (JNIISLMap _map : next.getMaps())
				System.out.println(_map);
		}
		
		
		Map<JNIISLSet, JNIISLMultiAff> nextClosedForm = next.getMapAt(0).getClosedFormRelation();
		if ( debug ) {
			System.out.println("ClosedForm Relation of next");
			for ( Entry<JNIISLSet, JNIISLMultiAff> m : nextClosedForm.entrySet() ) {
				System.out.println(m.getKey().getNbBasicSets() + "    " + m.getValue() + "  " + m.getKey());
			}
		}

		if ( debug ) {
			System.out.println("#################################################################");
			System.out.println("#### Activity/Variant lexicographic next UnionMap ##");
			System.out.println("#################################################################");
		}

		variantNext = buildVariantBasedFSM(variantSet, nextClosedForm);
		//next = next.copy().coalesce();
		//variantNext = buildVariantBasedFSM(variantSet, next);

		Entry<JNIISLUnionMap, JNIISLUnionMap> split = stateSplitting(variantNext);
		JNIISLUnionMap expansionMap = split.getValue();
		JNIISLUnionMap oldStateToNewStateMap = split.getKey().copy();
		/*if ( split.getKey() != null ) {
			variantMap = variantMap.applyDomain(split.getKey());
		}*/
		/* Make the regions that are not covered in the expansion map a new state. This
		 * new state should be the Lexmax. Since rest of the points are covered by the 
		 * Lexnext function. 
		 */
		JNIISLUnionMap id = variantSet.copy().subtract(expansionMap.copy().getDomain()).identity();
		expansionMap = expansionMap.copy().union(id.copy()).copy();
		variantSet = variantSet.apply(expansionMap.copy()).coalesce();
		
		/* Also update VariantMap with new state */
		for ( JNIISLMap map : id.getMaps() ) {
			String name = map.getInputTupleName();
			String newName = map.getOutputTupleName();
			JNIISLMap newVariantMap = ISLFactory.islMap("{ "+name+"[]-> "+newName+"[] }");
			oldStateToNewStateMap = oldStateToNewStateMap.addMap(newVariantMap);
		}
		variantMap = variantMap.applyDomain(oldStateToNewStateMap.copy());
		
		if ( debug  ) {
			System.out.println("\n##### Variant set After subtract");
			for (JNIISLSet map : variantSet.getSets()) {
				System.out.println(map);
			}
		
			System.out.println("\n##### expansion map ");
			for (JNIISLMap map : expansionMap.getMaps()) {
				System.out.println(map);
			}

			System.out.println("\n##### Variant statement map ");
			for (JNIISLMap map : variantMap.getMaps()) {
				System.out.println(map);
			}
		}
		
		JNIISLUnionMap result = transitionSplitting(variantNext, expansionMap);

		//showTransitions(next.getMapAt(0), convexHull.copy());
		
		if ( debug ) {
			System.out.println("#############################");
			System.out.println("## Final results  ##");
			System.out.println("#############################");

			System.out.println("\n##### Transition map ");
			for (JNIISLMap map : result.getMaps()) {
				showTransitions(map, convexHull.copy());
				System.out.println(map);
			}
				
			System.out.println("\n##### Variant set ");
			for (JNIISLSet map : variantSet.getSets()) {
				System.out.println(map);
			}
		
			System.out.println("\n##### expansion map ");
			for (JNIISLMap map : expansionMap.getMaps()) {
				System.out.println(map);
			}

		
			System.out.println("\n##### Variant statement map ");
			for (JNIISLMap map : variantMap.getMaps()) {
				System.out.println(map);
			}
			System.out.println("\n#");

			if ( split.getKey() != null ) {
				for (JNIISLMap map : split.getKey().getMaps()) {
					System.out.println(map);
				}
			}
		}
		
		return new JNIFSM(variantSet, result,variantMap);

	}

	/**
	 * This function update the transition system (variantNext) according to the
	 * state splitting transformation (expansionMap) derived at the previous
	 * step of the algorithm.
	 * 
	 * For each transitions of the system we first update/transforms transitions
	 * where the source state needs to be split, and obtain a new transition
	 * system. We then do the same for the transitions where the
	 * sink/destination state needs to be split.
	 * 
	 * The resulting system is returned as a result.
	 **/
	private static JNIISLUnionMap transitionSplitting(JNIISLUnionMap variantNext, JNIISLUnionMap expansionMap) {
		
		if ( debug )
			System.out.println("#### Expanding source states ##");

		/** expand sources */
		JNIISLUnionMap result = JNIISLUnionMap.buildEmpty(variantNext.copy().getSpace());
		for (JNIISLMap src : variantNext.copy().getMaps()) {
			String srcTupleName = src.getInputTupleName();
			System.out.println("\nTransition " + src);
			int expansionCount = 0;
			for (JNIISLMap expansion : expansionMap.copy().getMaps()) {
				if (expansion != null) {
					boolean wasExpanded = false;
					JNIISLMap res = src.copy();
					String expTupleName = expansion.copy().getInputTupleName();
					if (srcTupleName.equals(expTupleName)) {
					//	System.out.println("\t-Expanding source State " + res + "\n\t      with " + expansion + "\n");
						res = res.applyDomain(expansion.copy());
					//	System.out.println("\t\t-Expanding input as " + res);
						wasExpanded = true;
					}
					if (wasExpanded) {
						expansionCount++;
						if (!res.isEmpty()) {
							if ( debug )
								System.out.println("\n\t-Saving expanded " + res + "\n");
							result = result.addMap(res);
						} else {
							if ( debug )
								System.out.println("\n\t-Skipping empty expansion " + res + "\n");
						}
					}
				}
			}
			if (expansionCount == 0) {
				if ( debug )
					System.out.println("\n\t-Saving unexpanded transition " + src + "\n");
				result = result.addMap(src.copy());
			}

		}
		if ( debug )
			System.out.println("#### Expanding destination states ##");

		variantNext = result;
		result = JNIISLUnionMap.buildEmpty(variantNext.copy().getSpace());
		for (JNIISLMap src : variantNext.copy().getMaps()) {
			String dstTupleName = src.getOutputTupleName();
			if ( debug )
				System.out.println("\nTransition " + src);
			int expansionCount = 0;
			for (JNIISLMap expansion : expansionMap.getMaps()) {
				if (expansion != null) {
					boolean wasExpanded = false;
					JNIISLMap res = src.copy();
					dstTupleName = res.getOutputTupleName();
					if (res.isEmpty())
						break;
				//	System.out.println("\t-Expanding Destination State " + res + "\n\t      with " + expansion + "\n");
					String expTupleName = expansion.getInputTupleName();

					if (!res.isEmpty() && dstTupleName.equals(expTupleName)) {
						res = res.applyRange(expansion.copy());
						//System.out.println("\t\t-Expanding output as " + res);
						wasExpanded = true;
					}
					if (wasExpanded) {
						expansionCount++;
						if (!res.isEmpty()) {
							if ( debug )
								System.out.println("\n\t-Saving expanded " + res + "\n");
							result = result.addMap(res);
						} else {
							if ( debug )
								System.out.println("\n\t-Skipping empty expansion " + res + "\n");
						}
					}
				}
			}
			if (expansionCount == 0) {
				if ( debug )
					System.out.println("\n\t-Saving unexpanded " + src + "\n");
				result.addMap(src.copy());
			}

		}
		variantNext = result;
		return result;
	}

	/**
	 * This function analyzes the variant based next function to detect state
	 * pairs that are liked through more than one (n>1) transition. Whenever
	 * such situation is encountered, the source state is split into two n
	 * distinct state, where each state has a unique outgoing transition.
	 * 
	 * The result of the function is a union map that define the splitting
	 * function for each state that has to be split.
	 **/
	private static Entry<JNIISLUnionMap, JNIISLUnionMap> stateSplitting(JNIISLUnionMap variantNext) {
		
		int i = 0;
		JNIISLUnionMap variantMap = null;
		JNIISLUnionMap expansionMap = JNIISLUnionMap.buildEmpty(variantNext.getSpace());

		if ( debug ) {
			System.out.println("Expansion Map: ");
			for (JNIISLMap exp : expansionMap.getMaps()) {
				System.out.println(exp);
			}
		}
		
		for (JNIISLMap src : variantNext.getMaps()) {
			JNIISLMap srcCopy = src.copy();
			if ( debug )
				System.out.println("State splitting for : " + srcCopy);
			JNIISLMap srcCopyMap = src.copy();
			String name = srcCopyMap.getInputTupleName();
			//System.out.println("\t- Domain has " + srcCopy.getNumberOfBasicMap() + " basic maps => requires splitting");
			for (JNIISLBasicMap bmap : srcCopyMap.getBasicMaps()) {
				String newName = name + "_" + (i++);
				JNIISLMap newVariantMap = ISLFactory.islMap("{ "+name+"[]-> "+newName+"[] }");
			
				if(variantMap==null) {
					variantMap=newVariantMap.toUnionMap();
				} else {
					variantMap=variantMap.addMap(newVariantMap);
				}
				
				//System.out.println("\t- Expanding " + name + " as " + newName + " on " + bmap.getDomain() + " ");
				JNIISLSet splitDomain = bmap.copy().getDomain().toSet();
				//System.out.println("\t\t- split domain : " + splitDomain);
				JNIISLMap splittingTransform = JNIISLMap.buildIdentity(bmap.getSpace()).setOutputTupleName(newName);
				splittingTransform = splittingTransform.intersectDomain(splitDomain);
				//System.out.println("\t\t- splitting transform : " + splittingTransform);
				if (splittingTransform == null)
					throw new UnsupportedOperationException("Not yet Implemented");
				expansionMap = expansionMap.addMap(splittingTransform.copy());
			}
		}
		if ( debug ) {
			System.out.println("Expansion Map: \n" + expansionMap.toString());
			System.out.println("Expansion Map: ");
			for (JNIISLMap exp : expansionMap.getMaps()) {
				System.out.println(exp);
			}
		}

		return new AbstractMap.SimpleEntry<JNIISLUnionMap, JNIISLUnionMap>(variantMap, expansionMap);
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

	static final boolean buildVariantVerbose = false;

	private static JNIISLUnionMap buildVariantBasedFSM(JNIISLUnionSet variantSet, Map<JNIISLSet, JNIISLMultiAff> nextClosedForm) {
		JNIISLUnionMap variantNext = null;
		for ( Entry<JNIISLSet, JNIISLMultiAff> e : nextClosedForm.entrySet() ) {
			for (JNIISLSet variantSrc : variantSet.getSets()) {
				JNIISLSet dom = e.getKey();
				dom = dom.copy().setTupleName(variantSrc.getTupleName());
				dom = dom.copy().intersect(variantSrc.copy());
				dom = dom.copy().clearTupleName();
				if (!dom.isEmpty()) {
					if (buildVariantVerbose)
						System.out.println("Transition \n\t" + dom + "\n feasible on \n\t" + variantSrc+ "\n");
					for (JNIISLSet variantDst : variantSet.getSets()) {
						JNIISLMap map = e.getValue().copy().toBasicMap().toMap();
						map = map.clearInputTupleName().clearOutputTupleName();
						map = map.intersectDomain(dom.copy());
						System.out.println(map.copy().getRange());
						//JNIISLSet dom_dest = e.getKey();
						JNIISLSet dom_dest = map.copy().getRange();
						dom_dest = dom_dest.copy().setTupleName(variantDst.getTupleName());
						dom_dest = dom_dest.copy().intersect(variantDst.copy());
						if (!dom_dest.isEmpty()) {
							if (buildVariantVerbose)
								System.out.println("\tTransition \n\t\t" + dom_dest + "\n\tfeasible on \n\t\t"
										+ variantDst + "\n");
							JNIISLMap newTransition = e.getValue().copy().toBasicMap().toMap();
							newTransition = newTransition.clearInputTupleName().clearOutputTupleName();

							dom_dest = dom_dest.copy().clearTupleName();
							newTransition = newTransition.copy().intersectDomain(dom.copy());
							newTransition = newTransition.copy().intersectRange(dom_dest.copy());
							newTransition = newTransition.copy().setInputTupleName(variantSrc.getTupleName());
							newTransition = newTransition.copy().setOutputTupleName(variantDst.getTupleName());
							if ( debug )
								System.out.println("Adding Transition " + newTransition + "\n");
							if (variantNext == null)
								variantNext = newTransition.toUnionMap();
							else
								variantNext = variantNext.addMap(newTransition);
						} else {
							if (buildVariantVerbose) 
								System.out.println("\tTransition \n\t\t" + dom_dest + "\n\tinfeasible on \n\t\t"
										+ variantDst + "\n");
						}
						
					}
				} else {
					if (buildVariantVerbose)
						System.out.println("Transition \n\t" + dom + "\n unfeasible on \n\t" + variantSrc + "\n");
				}
			}
		}
		if (buildVariantVerbose)
			for (JNIISLMap map : variantNext.getMaps()) {
				for (JNIISLBasicMap bmap : map.getBasicMaps()) {
					System.out.println(bmap);
				}
			}

		return variantNext;
	}
	
	static JNIISLUnionMap buildVariantBasedFSM(JNIISLUnionSet variantSet, JNIISLUnionMap next) {
		JNIISLUnionMap variantNext = null;
		for (JNIISLSet variantSrc : variantSet.getSets()) {
			JNIISLMap dom = next.getMapAt(0).copy();
			JNIISLMap setInputTupleName = dom.setInputTupleName(variantSrc.copy().getTupleName());
			dom = setInputTupleName.copy().intersectDomain(variantSrc);
			if (!dom.isEmpty()) {
				if (buildVariantVerbose)
					System.out.println("Transition \n\t" + setInputTupleName + "\n feasible on \n\t" + variantSrc
							+ "\n");
				if (buildVariantVerbose)
					System.out.println("\tresult = " + dom + "\n");
				for (JNIISLSet variantDst : variantSet.getSets()) {
					JNIISLMap setOutputTupleName = dom.copy().setOutputTupleName(variantDst.getTupleName());
					if (buildVariantVerbose)
						System.out.println("\tTransition \n\t\t" + setOutputTupleName + "\n\tfeasible on \n\t\t"
								+ variantDst + "\n");
					JNIISLMap range = setOutputTupleName.intersectRange(variantDst.copy());
					if (buildVariantVerbose)
						System.out.println("\t\tresult = " + range + "\n");
					if (!range.isEmpty()) {
						if (variantNext == null)
							variantNext = range.toUnionMap();
						else
							variantNext.addMap(range);
					}
				}
			} else {
				if (buildVariantVerbose)
					System.out.println("Transition \n\t" + setInputTupleName + "\n unfeasible on \n\t" + variantSrc
							+ "\n");
			}
		}
		if (buildVariantVerbose)
			for (JNIISLMap map : variantNext.getMaps()) {
				for (JNIISLBasicMap bmap : map.getBasicMaps()) {
					System.out.println(bmap);
				}
			}

		return variantNext;
	}

	// public static JNIISLSet mergeAsSingleSet(JNIISLUnionSet stmts) {
	// JNIISLSpace space = stmts.getSpace();
	// JNIISLSet mergedSet = JNIISLSet.buildEmpty(space);
	// for (JNIISLSet aset : stmts.getSets()) {
	// JNIISLSet newSet = aset.copy().clearTupleName();
	// mergedSet = JNIISLSet.union(mergedSet, newSet);
	// }
	// mergedSet = mergedSet.coalesce();
	// return mergedSet;
	// }

	private static void showTransitions(JNIISLMap next, JNIISLBasicSet convexHull) {
		HashSet<String> set = new HashSet<String>();
		System.out.println("Next map (" + next.getNbBasicMaps() + " transitions)");

		/*
		 * In the first loop we print all transitions and their associated
		 * guards
		 */
		int i = 0; //, j = 0;
		JNIISLBasicSet currConvexHull = convexHull.copy();
		for (JNIISLBasicMap transition : next.getBasicMaps()) {
			JNIISLBasicSet srcDomain = transition.copy().getDomain();
			System.out.println("\t-Transition " + (i++) + " : " + transition.copy());
			// We know that since we are in context i, we can gist with the
			// domain of i
			JNIISLBasicSet gisted = srcDomain.copy().gist(currConvexHull.copy());
			if (!gisted.isEmpty())
				System.out.println("Something wrong here ? gist is empty !");
			for (JNIISLConstraint c : gisted.getConstraints()) {
				System.out.println("\t\t" + c);
				set.add(c.toString());
			}
			JNIISLSet convexSet = currConvexHull.copy().toSet();
			JNIISLSet srcDomainSet = srcDomain.copy().toSet();
			srcDomainSet = srcDomainSet.clearTupleName();
			convexSet = convexSet.subtract(srcDomainSet);
			currConvexHull = convexSet.convexHull();
		}
		System.out.println("Live constraint set :");
		for (String astr : set) {
			System.out.println("\t" + astr);
		}
		System.out.println("Total " + set.size() + " live contraints ");
	}

	// @Test
	// public static void test12() {
	// // floyd warshal + bubbles
	// String str =
	// "[k, n] -> { [l1, l2] : (l2 >= 0 and l2 <= -1 + n and l2 <= l1 and l2 >= 1 - n + l1 and k >= 0 and n >= 1 + k and n >= 3) or (l1 <= -2 + n and l1 >= 2 - k and l1 >= k and l2 <= 2 + l1 and l2 <= 4 and k >= 0 and l2 >= 1 + l1) or (l1 >= -4 + 2n and l1 <= -1 + k + n and n >= 2 + k and n >= 3 and l2 >= n and l2 <= 6 - n + l1) or (l1 >= k and n >= 3 and l1 <= 1 and k >= 0 and l2 >= 1 + l1 and l2 <= 4) or (l1 <= -1 + k + n and l2 >= n and n <= 4 + k and l1 >= -1 + n and l2 <= -3k + 2n + l1 and l1 <= -4 + 2n and 3l2 <= 1 - k + 4n and l2 <= 6 - n + l1); [4 + 2k, 5 + k] : n = 5 + k and k >= 0 }";
	// String str =
	// "[k, n] -> { [l1, l2] : (l1 <= -2 + n and l1 >= 2 - k and l1 >= k and l2 <= 2 + l1 and l2 <= 4 and k >= 0 and l2 >= 1 + l1) or (l1 >= -4 + 2n and l1 <= -1 + k + n and n >= 2 + k and n >= 3 and l2 >= n and l2 <= 6 - n + l1) or (l1 >= k and n >= 3 and l1 <= 1 and k >= 0 and l2 >= 1 + l1 and l2 <= 4) or (l1 <= -1 + k + n and l2 >= n and n <= 4 + k and l1 >= -1 + n and l2 <= -3k + 2n + l1 and l1 <= -4 + 2n and 3l2 <= 1 - k + 4n and l2 <= 6 - n + l1); [4 + 2k, 5 + k] : n = 5 + k and k >= 0 }";
	String str = "[N] -> { " + "[i,j] : 0 <= i < 8 && i <= j < N or 16 <= i < 32 && i <= j < N " + "}";

	public static void BFAdvanced() {
		String unionStr = "[N] -> { " + "S0[i,j] : 0 <= i < 8 && i <= 2j <= N or 16 <= i < 32 && i <= j < N; "
				+ "S1[i,j] : 0 <= i < 8 && i + j <= N or 16 <= i < 32 && i <= j < N " + "}";

		Entry<JNIISLUnionSet, JNIISLUnionMap> res = ActivityDomainBuilder.buildFromUnionSet(ISLFactory
				.islUnionSet(unionStr));
		System.out.println("##################################################################");

		System.out.println(res);

	}
}
