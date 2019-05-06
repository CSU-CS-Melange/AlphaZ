package org.polymodel.scop.dtiler.basic;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTilingOptions;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class SimplifyNestedBlocks   {


  %include { sl.tom }  
  %include { scop_common.tom }
  %include { algebra_terminals.tom }
 
  %include { scop_terminals.tom }
  %include { scop_nodes.tom }
  %include { dtiler.tom }


  protected SimplifyNestedBlocks() {
  }


  public static ScopRoot simplify(ScopRoot root){
	  try{
		  return `BottomUp(simplifyNB()).visitLight(root, tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);
	  }catch(VisitFailure ex){
		  throw new RuntimeException(ex);
      }
  }

  public static AbstractScopNode simplify(AbstractScopNode node){
	  try{
		  return `BottomUp(simplifyNB()).visitLight(node,tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);
	  }catch(VisitFailure ex){
		  throw new RuntimeException(ex);
      }
  }


  %strategy simplifyNB() extends Identity() {
    visit node {
    	block(nodes(block(body))) -> {
    			return `block(body);
    	}
    }
 
  }


}