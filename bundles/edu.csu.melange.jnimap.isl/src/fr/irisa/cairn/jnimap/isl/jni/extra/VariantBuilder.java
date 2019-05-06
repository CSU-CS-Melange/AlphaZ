package fr.irisa.cairn.jnimap.isl.jni.extra;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.isl.jni.ISLFactory;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionSet;


public class VariantBuilder {

	private static final boolean VERBOSE = false;
	private int solCount =0;
	private JNIISLUnionMap variantMap;
	private JNIISLUnionSet solution; 

	/**
	 * This methods build the activity domains of the Scop, where an variant is defined by a 
	 * set of active statements and a corresponding polyhedral domain. It work recursilvely and 
	 * starts from a list of statements and their domains. 
	 *   
	 * @param depth
	 * @param currentDom
	 * @param stmts
	 * @param solution
	 */

	public static Entry<JNIISLUnionSet,JNIISLUnionMap> buildFromUnionSet(JNIISLUnionSet input) {
		VariantBuilder instance = new VariantBuilder();
		instance.recursiveVariantBuilder(new ArrayList<String>(),0,input,null);
		return new AbstractMap.SimpleEntry<JNIISLUnionSet, JNIISLUnionMap>(instance.solution, instance.variantMap); 
	}

	private static void debug(int indent, String mess) {
		if (VERBOSE) {
			for( int i = 0; i < indent; ++i) {
			    System.out.print("    ");
		  }
		    System.out.println(mess);
		}

	}

	private void recursiveVariantBuilder(List<String> labels,  int depth, JNIISLUnionSet input, JNIISLSet currentDom) {
		JNIISLSet localTaken;
		JNIISLSet localNotTaken;
		debug(depth,"-> Depth =" + depth +", solution = "+ currentDom);
		
		/* Recursion termination */
		if (depth == input.getNbSets()) {
			if (currentDom.getTupleName().length()!=0) {

				/**
				 * Adding a solution to the solution pool
				 */
				solCount = solCount+1;
				if(labels.size()>0) {
					debug(depth," -> Creating new state "+"State"+solCount) ;
					currentDom.setTupleName("State"+solCount);
					for(String label : labels) {
						debug(depth,"   * with statement "+label) ;
						JNIISLMap newVariantMap = ISLFactory.islMap("{ State"+solCount+"[]-> "+label+"[] }");
						if(variantMap==null) {
							variantMap=newVariantMap.toUnionMap();
						} else {
							variantMap=variantMap.addMap(newVariantMap);
						}
						debug(depth,"-> variants "+variantMap) ;
						
					}
					if(solution==null) {
						solution=JNIISLUnionSet.fromSet(currentDom.copy());
					} else {
						solution=solution.addSet(currentDom.copy());
					}
					debug(depth,"-> Solution is " + solution+", now backtracking !");
				}
			}
		} else {

			JNIISLSet copy = input.getSetAt(depth).copy();
			
			JNIISLSet complement = copy.complement();
			//complement.setTupleName(copy.getTupleName());
			
			debug(depth,"-> Current solution ="+currentDom+"");
			String newName = input.getSetAt(depth).getTupleName();
			
			if (currentDom != null) {
				complement.setTupleName(currentDom.getTupleName());
				localNotTaken = complement.intersect(currentDom.copy());
				
				localTaken = copy.setTupleName(currentDom.getTupleName()).intersect(currentDom.copy());
			} else {
				localNotTaken = complement;
				localTaken = copy;
			}
			debug(depth,"-> Taking statement "+newName+" ");
			
			if (!localTaken.isEmpty()) {
				// explore the branch with stmt in the solution list
				String oldName = "";
				if(currentDom!=null) {
					oldName = currentDom.getTupleName();
				}
				labels.add(newName);
				localTaken.setTupleName(oldName+"_"+newName);
				debug(depth,"  -> Domain is not empty, branching with " + newName);
				recursiveVariantBuilder(labels,depth + 1, input,  localTaken);
				labels.remove(newName);
				
			} else {
				debug(depth,"   -> Domain is empty, stopping here");
			}
			debug(depth,"-> Skipping statement "+newName);

			if (!localNotTaken.isEmpty()) {
				debug(depth,"  -> Domain is not empty, branching without " + newName);
				recursiveVariantBuilder(labels,depth + 1, input,  localNotTaken);
			} else {
				debug(depth,"   -> Domain is empty, stopping here");
			}

		}
	}

}
