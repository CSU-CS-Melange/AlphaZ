package org.polymodel.scop.transformations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class ScopNormalizeLoop {
	
	/**
		Converts all the loops so that the child of a loop is a scop block
	*/
	public static ScopRoot normalize(ScopRoot r){
		ScopNormalizeLoop s = new ScopNormalizeLoop();
		return s.transform(r);
	}
	public static AbstractScopNode normalize(AbstractScopNode r){
		ScopNormalizeLoop s = new ScopNormalizeLoop();
		return s.transform(r);
	}

	protected ScopRoot transform(ScopRoot root) {
		try {
			return `BottomUp(NormalizeLoop()).visitLight(root.simplify(), tom.mapping.GenericIntrospector.INSTANCE);
		} catch (VisitFailure vf) {
			vf.printStackTrace();
			throw new RuntimeException("Visit Failure " + vf.getMessage());
		}
	}
	protected AbstractScopNode transform(AbstractScopNode node) {
		try {
			return `BottomUp(NormalizeLoop()).visitLight(node.simplify(), tom.mapping.GenericIntrospector.INSTANCE);
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

	%strategy NormalizeLoop() extends Identity() {
		visit node {

		      l@loop(ite, lb, ub, stride, body) -> {
		    	  if (!((`body) instanceof ScopBlock)) {
		    		  if (`body == null) {
		    			  return `loop(ite, lb, ub, stride, block(nodes()));
		    		  } else {
		    			  return `loop(ite, lb, ub, stride, block(nodes(body)));
		    		  }
		    	  } else {
		    		  return `l;
		    	  }
		      }
		}  
	}
}
