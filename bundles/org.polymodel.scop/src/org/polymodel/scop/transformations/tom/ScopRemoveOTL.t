package org.polymodel.scop.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class ScopRemoveOTL {
	
	public static ScopRoot removeOTL(ScopRoot r, int start){
		ScopRemoveOTL s = new ScopRemoveOTL(start);
		return s.transform(r);
	}
 
	protected final int startLevel;
	protected static Map<String, String> equatedIndices = new HashMap<String, String>();

	protected ScopRemoveOTL(int start) {
		startLevel = start;
	}

	protected ScopRoot transform(ScopRoot root) {
		try {
			return `InnermostId(RemoveNestedBlocks()).visitLight(`BottomUp(RemoveOTL(startLevel)).visitLight(root.simplify(), tom.mapping.GenericIntrospector.INSTANCE), tom.mapping.GenericIntrospector.INSTANCE);
			//return `BottomUp(RemoveOTL()).visitLight(root,new ScopIntrospector());
		} catch (VisitFailure vf) {
			vf.printStackTrace();
			throw new RuntimeException("Visit Failure " + vf.getMessage());
		}
	}

	
	%include { sl.tom }  
	%include { scop_common.tom }
	%include { algebra_terminals.tom }
 
	%include { scop_terminals.tom }
	%include { scop_nodes.tom }

	%strategy RemoveOTL(start : int) extends Identity() {
		visit node {

		      l@loop(ite, lb, ub, _, block(nodes(body*))) -> {
		    	  if (((ScopFor)`l).getLoopDepth() >= start && `lb.isEquivalent(`ub) == FuzzyBoolean.YES) {
		    		  return `block(replaceList(ite, lb, body));
		    	  } else {
		    		  return `l;
		    	  }
		      }
		}  
	} 
 
	%strategy ReplaceIterator(var : V, expr : E) extends Identity() { 
		visit node {
			loop(ite, lb, ub, stride, body) -> {
				
				return `loop(ite, lb.substitute(var, expr), ub.substitute(var, expr), stride.substitute(var, expr), body);
			}

			guard(constraints, thenExpr, elseExpr) -> {
				EList<IntConstraintSystem> systems= `constraints;
				EList<IntConstraintSystem> newSystems =  new BasicEList<IntConstraintSystem>();
				for(IntConstraintSystem system : systems) {
					newSystems.add(system.substitute(var, expr));
				}
				return `guard(newSystems, thenExpr, elseExpr);
			}
			 
			stmtMacro(name, macroParams) -> {
				return `stmtMacro(name, replaceInExpressions(var, expr, macroParams));
			}
			
			//assignment(LHS, RHS) -> {
			//	return `assignment(LHS, RHS);
			//}
	
  		} 
	}

	%strategy RemoveNestedBlocks() extends Identity() {
		visit node {
			block(nodes(x1*, block(nodes(x2*)), x3*)) -> {
				return `block(nodes(x1*,x2*,x3*));
			}
			
			loop(ite, lb, ub, stride, block(nodes(x1*, block(nodes(x2*)), x3*))) -> {
				return `loop(ite, lb, ub, stride, block(nodes(x1*,x2*,x3*))); 
			}
		}

		visit ScopRoot {
			root(nodes(block(nodes(x1*, block(nodes(x2*)), x3*)))) -> {
				return `root(nodes(block(nodes(x1*,x2*,x3*))));
			}
		}
	}

	public static EList<AbstractScopNode> replaceList(Variable ite, IntExpression expr, EList<AbstractScopNode> list) throws VisitFailure {
		EList<AbstractScopNode> newList = new BasicEList<AbstractScopNode>();
		for (int i = 0; i < list.size(); i++) {
			newList.add(`BottomUp(ReplaceIterator(ite, expr)).visitLight(list.get(i), tom.mapping.GenericIntrospector.INSTANCE));
		}
		return newList;
	}

	public static EList<IntExpression> replaceInExpressions(Variable ite, IntExpression expr, EList<IntExpression> list) {
		EList<IntExpression> newList = new BasicEList<IntExpression>();
		for (int i = 0; i < list.size(); i++) {
			newList.add(list.get(i).substitute(ite, expr));
		}

		return newList;
	}
}
