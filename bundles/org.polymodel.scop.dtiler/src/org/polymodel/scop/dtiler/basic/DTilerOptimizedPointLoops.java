package org.polymodel.scop.dtiler.basic;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.annotation.AnnotationFactory;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.dtiler.AbstractPointLoopGenerator;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.OptimizationOptions;
import org.polymodel.scop.dtiler.opt.LoopVectorization;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

/**
 * 
 * Generates optimized point loops. A group of statements is selected and
 * isolated in order to produce specialized points-loops for performance. The
 * three optimizations of Daegon Kim are implemented in a one single process.
 * 
 * @author antoine, yuki
 * 
 */
public class DTilerOptimizedPointLoops extends AbstractPointLoopGenerator {
	protected final OptimizationOptions _optOptions;
	
	public DTilerOptimizedPointLoops(DTilingOptions options) {
		super(options);
		_optOptions = null;
	}

	public DTilerOptimizedPointLoops(DTilingOptions options, OptimizationOptions optOptions){
		super(options);
		_optOptions = optOptions;
	}
	
	public AbstractScopNode generate(ScopFor fullyEmbeddedLoopNest) {
		return generate(fullyEmbeddedLoopNest, new DTilerPointLoops(options).generate(fullyEmbeddedLoopNest));
	}
	public AbstractScopNode generate(ScopBlock fullyEmbeddedLoopNests) {
		return generate(fullyEmbeddedLoopNests, new DTilerPointLoops(options).generate(fullyEmbeddedLoopNests));
	}

	protected AbstractScopNode generate(AbstractScopNode scop, AbstractScopNode genericPointLoop) {
		List<List<AbstractScopStatement>> fullTileStmts = new LinkedList<List<AbstractScopStatement>>();
	
		if(_optOptions != null && _optOptions.optimizedPointLoop != null && _optOptions.pointLoopStmts != null && _optOptions.pointLoopStmts.size() > 0){
			//post processing the generated optimial point loop for vectorization and register blocking
			LoopVectorization.generate(_optOptions.optimizedPointLoop, _optOptions);
			fullTileStmts.addAll(LoopNestExtractor.extract(scop, _optOptions.pointLoopStmts, _optOptions.numberOfTiledDimensions));
		}else if(options.statement_pattern != null && options.statement_pattern.size() > 0){	//if statement pattern is specified
			fullTileStmts.addAll(LoopNestExtractor.extract(scop, options.statement_pattern, options.numberOfTiledDimensions));
		}else{
			List<AbstractScopStatement> candidates = StatementsExtractor.extract(scop, false);
			AbstractScopStatement targetStatement = options.strategy.select(candidates);
			List<AbstractScopStatement> stmts = new LinkedList<AbstractScopStatement>();
			stmts.add(targetStatement);
			fullTileStmts.add(stmts);
		}
		
		ScopGuard optimizer = null;
		ScopGuard pre_optimizer = null;
		for(List<AbstractScopStatement> targetStmts: fullTileStmts){
			//List<AbstractScopStatement> targetStmts = fullTileStmts.get(i);
			//build full tile input from the surrounding loops of the target statements
			ScopFor fullTileInput = extractSurroundingLoopNest(targetStmts.get(0));
			//create full tile and its box loop for the current target loop nest
			ScopGuard fullTile = DTilerFullTile.build(EcoreUtil.copy(fullTileInput), options, _optOptions);
			
			//create guard to restrict all regions that overlaps with outsets of other loops
			IntConstraintSystem constraints = extractConditions(targetStmts.get(0));
			List<IntConstraintSystem> constraintsList = new ArrayList<IntConstraintSystem>(1);
			constraintsList.add(constraints);
			ScopGuard current_optimizer = ScopUserFactory.scopGuard(constraintsList, fullTile, genericPointLoop);
			if(optimizer == null && pre_optimizer == null){
				optimizer = pre_optimizer = current_optimizer;
			}else{
				pre_optimizer.setElseBody(current_optimizer);
				pre_optimizer = current_optimizer;
			}
		}

		DescriptionAnnotation annotation = AnnotationFactory.eINSTANCE.createDescriptionAnnotation();
		annotation.setDescription("guard that isolates selected statements for generic point loops");
		optimizer.getScopAnnotations().add(annotation);

		return optimizer;
	}
	
//	protected AbstractScopNode generate(AbstractScopNode scop, AbstractScopNode genericPointLoop) {
//		//if(options.statement_pattern == null || options.statement_pattern.size() == 0){
//		List<AbstractScopStatement> candidates = StatementsExtractor.extract(scop, false);
//		AbstractScopStatement targetStatement = options.strategy.select(candidates);
//		//}
//		//build full tile input from the surrounding loops of the target statement
//		ScopFor fullTileInput = extractSurroundingLoopNest(targetStatement);
//
//		//create full tile and its box loop
//		ScopGuard fullTile = DTilerFullTile.build(EcoreUtil.copy(fullTileInput), options, _optOptions);
//		
//		//create guard to restrict all regions that overlaps with outsets of other loops
//		IntConstraintSystem constraints = extractConditions(targetStatement);
//		List<IntConstraintSystem> constraintsList = new ArrayList<IntConstraintSystem>(1);
//		constraintsList.add(constraints);
//		
//		//optimization check for remove redudant checking
//		
//		ScopGuard optimizer = ScopUserFactory.scopGuard(constraintsList, fullTile, genericPointLoop);
//
//		DescriptionAnnotation annotation = AnnotationFactory.eINSTANCE.createDescriptionAnnotation();
//		annotation.setDescription("guard that isolates selected statements for generic point loops");
//		optimizer.getScopAnnotations().add(annotation);
//
//		return optimizer;
//	}
	
//	/**
//	 * Check whether constraints1 is a subset of constraints2
//	 * (constraints1 - constraints2) is empty
//	 * @param constraints1
//	 * @param constraints2
//	 * @return
//	 */
//	protected boolean isRedudantConstraints(List<IntConstraintSystem> constraints1, List<IntConstraintSystem> constraints2){
//		//contstruct constraint list -constraints2
//		for(IntConstraintSystem subSystem : constraints2){
//			List<IntConstraint> subCons = new LinkedList<IntConstraint>();
//			for(IntConstraint cons : subSystem.getConstraints()){
//				IntConstraint cons_op = cons.copy();
//				
//			}
//		}
//	
//		return false;
//	}
//	
//	protected ComparisonOperator getOppositOperator(ComparisonOperator op){
//		switch(op){
//		case ComparisonOperator.
//		}
//	}
	
	
	/**
	 * Extracts a copy of perfectly nested loops that surrounds the target statement.
	 * Because embedding is assumed, all statements in the innermost loop are split.
	 * 
	 * @param s
	 * @return
	 */
	private static ScopFor extractSurroundingLoopNest(AbstractScopStatement s) {
		ScopFor fullTileInput = null;
		ScopFor current = null;
		for (ScopFor loop : s.getSurroundingScopFors()) {
			if (current == null) {
				current = EcoreUtil.copy(loop);
				fullTileInput = current;
			} else {
				ScopFor copy = EcoreUtil.copy(loop);
				current.setBody(copy);
				current = copy;
			}
		}
		return fullTileInput;
	}
	
	private IntConstraintSystem extractConditions(AbstractScopStatement targetStatement) {
		List<IntConstraint> lbs = new LinkedList<IntConstraint>();
		List<IntConstraint> ubs = new LinkedList<IntConstraint>();
		
		List<ScopFor> surroundingLoops = targetStatement.getSurroundingScopFors();
		
		//for each surrounding loop, check if there are adjacent loops at the same level
		for (int i = 0; i < surroundingLoops.size(); i++) {
			ScopFor currentLoop = surroundingLoops.get(i);
			ScopFor precedingLoop = null;
			ScopFor succeedingLoop = null;
			//loops with other loops at the same depth are all surrounded by ScopBlock
			if (currentLoop.eContainer() != null && currentLoop.eContainer() instanceof ScopBlock) {
				ScopBlock parentBlock = (ScopBlock)currentLoop.eContainer();
				int nextLoopIndex = parentBlock.getStatements().indexOf(surroundingLoops.get(i));
				//get preceding and succeeding loops
				if (nextLoopIndex > 0) {
					precedingLoop = (ScopFor)parentBlock.getStatements().get(nextLoopIndex-1);
				}
				if (nextLoopIndex < parentBlock.getStatements().size()-1) {
					succeedingLoop = (ScopFor)parentBlock.getStatements().get(nextLoopIndex+1);
				}
			}
			//when there is a preceding loop at this level
			if (precedingLoop != null) {
				//shift up the upper bound to get the outset condition
				IntExpression lbc = Shift.up(precedingLoop.getUB(), precedingLoop.getIterator(), options);
				//rename indices to tile indices
				for (int d = 1; d <= i+1; d++) {
					lbc = lbc.substitute(surroundingLoops.get(d-1).getIterator(), options.getTileIndex(d));
				}
				//tile index must be greater than the computed condition
				lbs.add(constraint(lbc, affine(term(options.getTileIndex(i+1))), ComparisonOperator.LT));
			}
			//when there is a succeeding loop at this level
			if (succeedingLoop != null) {
				//shift down the lower bound to get the outset condition
				IntExpression ubc = Shift.down(succeedingLoop.getLB(), succeedingLoop.getIterator(), options);
				//rename indices to tile indices
				for (int d = 1; d <= i+1; d++) {
					ubc = ubc.substitute(surroundingLoops.get(d-1).getIterator(), options.getTileIndex(d));
				}
				//tile index must be smaller than the computed condition
				ubs.add(constraint(affine(term(options.getTileIndex(i+1))), ubc, ComparisonOperator.LT));
			}
		}
		
		IntConstraintSystem constraints = IntExpressionBuilder.constraintSystem(lbs);
		constraints.getConstraints().addAll(ubs);
		
		return constraints;
	}
	
	/*
	 * Extract the loop nest with given statement pattern at the innermost level
	 */
	private static class LoopNestExtractor extends ScopDepthFirstVisitorImpl {
		private final List<List<String>> statement_patterns;
		private final int depth;
		private List<List<AbstractScopStatement>> fullTileStmts = new LinkedList<List<AbstractScopStatement>>();
		
		protected LoopNestExtractor(List<List<String>> _statement_patterns, int _depth){
			statement_patterns = _statement_patterns;
			depth = _depth;
		}
		
		public static List<List<AbstractScopStatement>> extract(ScopVisitable visitable, List<List<String>> _statement_patterns, int _depth){
			LoopNestExtractor ex = new LoopNestExtractor(_statement_patterns, _depth);
			visitable.accept(ex);
			return ex.fullTileStmts;
		}
		
		@Override
		public void inScopFor(ScopFor s){
			if(s.getLoopDepth() == depth){
				List<AbstractScopStatement> stmts = StatementsExtractor.extract(s, true);
				if(stmts != null && stmts.size() > 0 && patternMatching(stmts)){
					fullTileStmts.add(stmts);
				}
			}
		}
		
		private boolean patternMatching(List<AbstractScopStatement> statements){
			for(List<String> pattern: statement_patterns){
				List<String> stmtNames = new ArrayList<String>();
				for(AbstractScopStatement stmt: statements){
					stmtNames.add(((ScopStatementMacro)stmt).getName());
				}
				Collections.sort(pattern);
				Collections.sort(stmtNames);
				if(pattern.size() != stmtNames.size())	continue;
				boolean matched = true;
				for(int i = 0; i < pattern.size(); i++){
					if(!pattern.get(i).contentEquals(stmtNames.get(i))){
						matched = false;
						break;
					}
				}
				
				if(matched)	return true;
			}
			
			return false;
		}
		
	}
	
	private static class StatementsExtractor extends ScopDepthFirstVisitorImpl  {
		private List<AbstractScopStatement> statements = new ArrayList<AbstractScopStatement>();
		private boolean ifCond = false;

		protected StatementsExtractor() {
		}

		public static List<AbstractScopStatement> extract(ScopVisitable visitable, boolean checkIfCond) {
			StatementsExtractor ex = new StatementsExtractor();
			visitable.accept(ex);
			if(checkIfCond && ex.ifCond){
				return null;
			}
			return ex.statements;
		}
		
		@Override 
		public void visitScopGuard(ScopGuard g){
			ifCond = true;
		}
		
		@Override
		public void visitScopStatementMacro(ScopStatementMacro s) {
			statements.add(s);
		}
	}
	
//	private static class StatementsExtractor extends ScopDepthFirstVisitorImpl  {
//		private List<AbstractScopStatement> statements = new ArrayList<AbstractScopStatement>();
//
//		protected StatementsExtractor() {
//		}
//
//		public static List<AbstractScopStatement> extract(ScopVisitable visitable) {
//			StatementsExtractor ex = new StatementsExtractor();
//			visitable.accept(ex);
//			return ex.statements;
//		}
//		
//		@Override
//		public void visitScopStatementMacro(ScopStatementMacro s) {
//			statements.add(s);
//		}
//	}
}
