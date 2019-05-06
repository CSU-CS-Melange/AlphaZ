package org.polymodel.scop.dtiler.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.dtiler.DTiler.TilableBlock;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

public class DTilingTools {

	/**
	 * Returns the list of loop indices that are visible for this expression.
	 * The order is from outer most to inner most
	 * 
	 * @param expr
	 * @return
	 */
	public static EList<Variable> findSurroundingLoopIndices(IntExpression expr) {
		EList<Variable> vars = new BasicEList<Variable>();
		
		EObject obj = expr.eContainer();
		while (obj != null) {
			if (obj instanceof ScopFor) {
				vars.add(((ScopFor) obj).getIterator());
			}
			obj = obj.eContainer();
		}
		
		Collections.reverse(vars);
		
		return vars;
	}
	
	/**
	 * returns the ScopBlocks includes all the body within depth start
	 * @param root
	 * @param start
	 * @return
	 */
	public static List<ScopBlock> getScopBlockWithDepth(ScopRoot root, int start){
		List<ScopBlock> blocks = new LinkedList<ScopBlock>();
		
		if(start == 1){	//if tiling starts from the root
			ScopBlock spblock = ScopUserFactory.scopBlock(new ArrayList<AbstractScopNode>());
			spblock.getStatements().addAll(root.getStatements());
			root.getStatements().clear();
			root.getStatements().add(spblock);
			blocks.add(spblock);
			return blocks;
		}
		
		ScopForsWithDepth scopFors = new ScopForsWithDepth(start);
		root.accept(scopFors);
		List<ScopFor> fors = scopFors.fors;
		List<AbstractScopNode> containers = new LinkedList<AbstractScopNode>();
		//for every ScopFor create a scop block with the body of the for loop
		for(ScopFor scop :fors ){
			AbstractScopNode container = (AbstractScopNode)scop.eContainer();
			if(!containers.contains(container)){
				containers.add(container);
			}
//			if(scop.getBody() instanceof ScopBlock){
//				blocks.add((ScopBlock)scop.getBody());
//			}else{
//				ScopBlock spblock = ScopUserFactory.scopBlock(new ArrayList<AbstractScopNode>());
//				spblock.getStatements().add(scop.getBody());
//				scop.setBody(spblock);;
//				blocks.add(spblock);
//			}
		}
		
		for(int i = 0; i < containers.size(); i++){
			if(containers.get(i) instanceof ScopBlock){
				blocks.add((ScopBlock)containers.get(i));
			}else{
				ScopBlock spblock = ScopUserFactory.scopBlock(new ArrayList<AbstractScopNode>());
				spblock.getStatements().add(containers.get(i));
				blocks.add(spblock);
			}
		}
		
		return blocks;
	}
	/**
	 * Replace the special statement back with the original node
	 * @param root
	 * @param stmtBodyMap: The map of the special statement with the original node
	 */
	public static void replaceStatementWithBody(ScopRoot root, Map<String, AbstractScopNode> stmtBodyMap, String stmt_prefix){
		ReplaceStatementWithBody replace = new ReplaceStatementWithBody(stmtBodyMap, stmt_prefix);
		root.accept(replace);
	}
	
	public static void replaceStatementWithBody(TilableBlock block, Map<String, AbstractScopNode> stmtBodyMap, String stmt_prefix){
		ReplaceStatementWithBody replace = new ReplaceStatementWithBody(stmtBodyMap, stmt_prefix);
		for(ScopFor scop_for : block.loops){
			scop_for.accept(replace);
		}
	}
	
	public static void replaceStatementWithBody(AbstractScopNode start_for,  Map<String, AbstractScopNode> stmtBodyMap, String stmt_prefix){
		ReplaceStatementWithBody replace = new ReplaceStatementWithBody(stmtBodyMap, stmt_prefix);
		start_for.accept(replace);
	}
	
	/**
	 * 
	 * @author zou
	 *
	 */
	private static class ReplaceStatementWithBody extends ScopDepthFirstVisitorImpl {
		private final Map<String, AbstractScopNode> stmtBodyMap;
		private String prefix;
		
		public ReplaceStatementWithBody(Map<String, AbstractScopNode> _stmtBodyMap, String _prefix) {
			stmtBodyMap = _stmtBodyMap;
			prefix = _prefix;
		}
		
		@Override
		public void outScopStatementMacro(final ScopStatementMacro s) {
			if(s.getName().contains(prefix)){
				AbstractScopNode body = stmtBodyMap.get(s.getName());
				EcoreUtil.replace(s, body);
			}
		}
	}
	
	/**
	 * Replace the body of the for loop at depth with a special statement with prefix_i
	 * @param root
	 * @param depth
	 * @param stmt_prefix
	 * @return the map of the created statement and the original body
	 */
	public static Map<String, AbstractScopNode> replaceForBodyWithStatement(ScopRoot root, int depth, String stmt_prefix){
		ReplaceScopForBodyWithDepth replace = new ReplaceScopForBodyWithDepth(depth, stmt_prefix);
		root.accept(replace);
		
		return replace.stmtBodyMap;
	}
	
	public static Map<String, AbstractScopNode> replaceForBodyWithStatement(TilableBlock block, int depth, String stmt_prefix){
		Map<String, AbstractScopNode> forBodyMap = new HashMap<String, AbstractScopNode>();
		
		//for each for loop in the tilable Block, replace the body of the for loop
		int cur_count = 0;
		for(ScopFor scop_for: block.loops){
			ReplaceScopForBodyWithDepth replace = new ReplaceScopForBodyWithDepth(depth, stmt_prefix, cur_count);
			scop_for.accept(replace);
			forBodyMap.putAll(replace.stmtBodyMap);
			cur_count = replace.count;
		}
		return forBodyMap;
	}
	
	
	private static class ReplaceScopForBodyWithDepth extends ScopDepthFirstVisitorImpl {
		private Map<String, AbstractScopNode> stmtBodyMap;
		private final int depth; 
		private String prefix;
		private int count;
		
		public ReplaceScopForBodyWithDepth(int _depth, String _prefix, int _count){
			depth = _depth;
			prefix = _prefix;
			count = _count;
			stmtBodyMap = new HashMap<String, AbstractScopNode>();
		}
		
		public ReplaceScopForBodyWithDepth(int _depth, String _prefix) {
			depth = _depth;
			prefix = _prefix;
			count = 0;
			stmtBodyMap = new HashMap<String, AbstractScopNode>();
		}
		
		@Override
		public void inScopFor(ScopFor s) {
			if(s.getLoopDepth() == depth){
				count++;
				String name = prefix + count;
				ScopStatementMacro stmt = ScopUserFactory.scopStatementMacro(name, new LinkedList<IntExpression>());
				AbstractScopNode body = s.getBody();
				s.setBody(stmt);
				stmtBodyMap.put(name, body);
			}
		}

	}
	//////////////////////////////Needs to be cleaned
	public static Map<ScopFor, ScopBlock> createScopBlocksWithDepth(ScopRoot root, int start){
		Map<ScopFor, ScopBlock> blocks = new HashMap<ScopFor,ScopBlock>();
		
		
		ScopForsWithDepth scopFors = new ScopForsWithDepth(start - 1);
		root.accept(scopFors);
		List<ScopFor> fors = scopFors.fors;
			
		//for every ScopFor create a scop block with the body of the for loop
		for(ScopFor scop :fors ){
			if(scop.getBody() instanceof ScopBlock){
				blocks.put(scop, (ScopBlock)scop.getBody());
			}else{
				ScopBlock spblock = ScopUserFactory.scopBlock(new ArrayList<AbstractScopNode>());
				spblock.getStatements().add(scop.getBody());
				blocks.put(scop, spblock);
			}
		}
		
		return blocks;
	}
	
	private static class ScopForsWithDepth extends ScopDepthFirstVisitorImpl {

		private List<ScopFor> fors= null;
		private final int depth; 
		
		public ScopForsWithDepth(int _depth) {
			depth = _depth;
			fors = new LinkedList<ScopFor>();
		}
		
		@Override
		public void inScopFor(ScopFor s) {
			if(s.getLoopDepth() == depth){
				fors.add(s);
			}
		}
	}
	
	/**
	 * Extract only tiled loops from a perfectly nested loop
	 * Only extract loops whose stride is a variable or greater than one
	 * @param loopNest: each loop must have a loop body that is either a loop or a scopblock with a loop
	 * @return
	 */
	public static List<ScopFor> extractTiledLoops(ScopFor loopNest){
		//get list of loops
		List<ScopFor> loops = new LinkedList<ScopFor>();
		loops.add(loopNest);
		{
			ScopFor loop = loopNest;
			while (true) {
				if (!(loop.getBody() != null && (loop.getBody() instanceof ScopFor || loop.getBody() instanceof ScopBlock))) {
					break;
				}
				if (loop.getBody() instanceof ScopBlock) {
					boolean findLoop = false;
					for(AbstractScopNode stmt: ((ScopBlock)loop.getBody()).getStatements()){
						if(stmt instanceof ScopFor){
							findLoop = true;
							loop = (ScopFor)stmt;
							break;
						}
					}
					if(!findLoop)	break;
				} else {
					loop = (ScopFor)loop.getBody();
				}
				if(loop.getStride() instanceof AffineExpression){	//check whether the loop stride is constant for noew
					AffineExpression expr = (AffineExpression)loop.getStride();
					if(expr.getConstantTerm() != null && (expr.getTerms() == null || expr.getTerms().size() == 0)){
						break;
					}else{
						if(expr.getTerms().size() == 1 && expr.getTerms().get(0).getVariable() == null){
							break;
						}
					}
				}
				loops.add(loop);
			}
		}
		
		return loops;
	}
	
	/**
	 * Extract all the loops in a perfectly nested loops
	 * @param loopNest: each loop body must either be a loop or a scopblock with one loop
	 * @return a list of for loops in the perfectly nested loops
	 */
	public static List<ScopFor> extractLoops(ScopFor loopNest){
		//get list of loops
		List<ScopFor> loops = new LinkedList<ScopFor>();
		loops.add(loopNest);
		{
			ScopFor loop = loopNest;
			while (true) {
				if (!(loop.getBody() != null && (loop.getBody() instanceof ScopFor || loop.getBody() instanceof ScopBlock))) {
					break;
				}
				if (loop.getBody() instanceof ScopBlock) {
					boolean findLoop = false;
					for(AbstractScopNode stmt: ((ScopBlock)loop.getBody()).getStatements()){
						if(stmt instanceof ScopFor){
							findLoop = true;
							loop = (ScopFor)stmt;
							break;
						}
					}
					if(!findLoop)	break;
				} else {
					loop = (ScopFor)loop.getBody();
				}
				loops.add(loop);
			}
		}
				
		return loops;
	}
}