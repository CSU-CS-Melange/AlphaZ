package org.polymodel.scop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

public class ScopLoopIteratorUtil {
	
	public static EList<Variable> getSurroundingIterators(AbstractScopNode node) {
		EList<Variable> list = new BasicEList<Variable>(); 
		EObject obj = node;
		while ((obj != null) && !(obj instanceof ScopRoot)) {
			if (obj instanceof ScopFor) {
				list.add(0,((ScopFor)obj).getIterator());
			}
			obj = obj.eContainer();
		}
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static int getLoopDepth(AbstractScopNode node) {
		int depth = 0;
		EObject obj = node;
		while ((obj != null) && !(obj instanceof ScopRoot)) {
			if (obj instanceof ScopFor) {
				depth++;
			}
			obj = obj.eContainer();
		}
		return depth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<ScopFor> getSurroundingScopFors(AbstractScopNode node) {
		EList<ScopFor> list = new BasicEList<ScopFor>(); 
		EObject obj = node;
		while ((obj != null) && !(obj instanceof ScopRoot)) {
			if (obj instanceof ScopFor) {
				list.add(0,(ScopFor)obj);
			}
			obj = obj.eContainer();
		}
		return list;
	}

	
	public static EList<ScopFor> getScopFors(ScopRoot root, List<Integer> orderingDims, List<Integer> prefix, List<Integer> dims){
		/*
		 * step 1: find the statement whose ordering prefix is orders
		 * step 2: find the dims dimensions that surrounding the statement and insert the parallel annotation in to it
		 */
		
		//STEP 1
		ScopForsWithPrefix scopWithPrefix = new ScopForsWithPrefix(orderingDims, prefix, dims);
		root.accept(scopWithPrefix);
		
		return scopWithPrefix.scops;
	}
	
	public static Set<String> getInnerScopInterationNames(AbstractScopNode node){
		ListIteratorNames instance = new ListIteratorNames();
		node.accept(instance);
		
		//if the outer most node is a for loop, remove the outermost iteration name
		Set<String> iterators = instance.iterators;
		if(node instanceof ScopFor){
			String it = ((ScopFor)node).getIterator().getName();
			iterators.remove(it);
		}
		
		return iterators;
	}
	
	public static List<String> iteratorNameList(ScopRoot root) {
		ListIteratorNames instance = new ListIteratorNames();
		root.accept(instance);
		
		List<String> iterators = new ArrayList<String>(instance.iterators.size());
		
		for (String it : instance.iterators) {
			iterators.add(it);
		}
		
		return iterators;
	}
	
	public static Set<String> iteratorNameSet(ScopRoot root) {
		ListIteratorNames instance = new ListIteratorNames();
		root.accept(instance);
		
		Set<String> iterators = new TreeSet<String>();
		
		for (String it : instance.iterators) {
			iterators.add(it);
		}
		
		return iterators;
	}
	
	public static void renameIterators(ScopRoot root, List<String> names) {
		List<String> orig = iteratorNameList(root);
		
		RenameIterators instance = new RenameIterators(orig, names);
		root.accept(instance);
	}
	
	/**
	 * Prevent an instance of this class to be created elsewhere.
	 * 
	 */
	protected ScopLoopIteratorUtil() {
		
	}
	
	private static class ListIteratorNames extends ScopDepthFirstVisitorImpl {

		private Set<String> iterators = new TreeSet<String>();
		
		
		@Override
		public void inScopFor(ScopFor s) {
			iterators.add(s.getIterator().getName());
		}
	}
	
	private static class RenameIterators extends ScopDepthFirstVisitorImpl {

		private final Map<String, String> renaming = new HashMap<String, String>();
		
		public RenameIterators(List<String> original, List<String> newNames) {
			for (int i = 0; i < Math.min(original.size(), newNames.size()); i++) {
				renaming.put(original.get(i), newNames.get(i));
			}
		}
		
		@Override
		public void inScopFor(ScopFor s) {
			if (renaming.containsKey(s.getIterator().getName())) {
				s.getIterator().setName(renaming.get(s.getIterator().getName()));
			}
		}
	}
	
	private static class ScopForsWithPrefix extends ScopDepthFirstVisitorImpl {
		private static boolean DEBUG = false;
		private final List<Integer> orderings = new LinkedList<Integer>();
		private final List<Integer> prefix = new LinkedList<Integer>();
		private final List<Integer> dims = new LinkedList<Integer>();
		private final EList<ScopFor> scops = new BasicEList<ScopFor>();
		
		public ScopForsWithPrefix(List<Integer> ordering, List<Integer> pre, List<Integer> dim){
			orderings.addAll(ordering);
			prefix.addAll(pre);
			dims.addAll(dim);
			
			if(DEBUG){
				System.out.println("ordering dimensions: " + orderings.toString());
				System.out.println("prefixs: " + prefix.toString());
				System.out.println("parallel dims: " + dims.toString());
			}
		}
		
		@Override
		public void inScopStatementMacro(ScopStatementMacro a) {
			//find the statement with the ordering prefix <prefix>
			if(DEBUG){
				System.out.println("check statement: " + a.getName() + ": " + a.getMacroParams());
			}
			boolean isPrefix = true;
			for(int i = 0; i < prefix.size(); i++){
				//create an IntExpression with the value of prefix
				IntExpression exp = IntExpressionBuilder.constant(prefix.get(i));
				if(!(a.getMacroParams().get(orderings.get(i)).isEquivalent(exp) == FuzzyBoolean.YES)){
					isPrefix = false;
					break;
				}
			}
			
			if(isPrefix){	//macro statement a have the ordering prefix that is specified
				//get the for loop names
				for(int i = 0; i < dims.size(); i++){
					AffineExpression affine = null;
					if(prefix.size() > 0){
						affine = a.getMacroParams().get(orderings.get(prefix.size() - 1) + dims.get(i) + 1).toAffine();
					}else{
						affine = a.getMacroParams().get(dims.get(i)).toAffine();
					}
					
					if((affine != null) && (affine.getTerms().size() == 1) && (affine.getTerms().get(0).getVariable() != null)){
						String name = affine.getTerms().get(0).getVariable().getName();
						if(DEBUG){
							System.out.println("find loop with iterator: " + name);
						}
						//back track from the current node until found the for loop
						EObject obj = a.eContainer();
						while ((obj != null) && !(obj instanceof ScopRoot)) {
							if (obj instanceof ScopFor) {
								if((((ScopFor) obj).getIterator().getName().contentEquals(name)) && (!scops.contains(obj))){
									scops.add((ScopFor)obj);
									break;
								}
							}
							obj = obj.eContainer();
						}
					}
				}
			}
		}
	}
	
}
