package org.polymodel.scop.dtiler.distributed;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.max;
import static org.polymodel.algebra.factory.IntExpressionBuilder.sum;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
//import tom.mapping.introspectors.scop.ScopIntrospector;
import org.polymodel.scop.util.ScopAssignLoopIdentifiers;
import org.polymodel.scop.util.ScopLoopIdentifier;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class InsertStaggeredTilingPostambles   {

	
	%include { sl.tom }  
	%include { scop_common.tom }
	%include { algebra_terminals.tom }
 
	%include { scop_terminals.tom }
	%include { scop_nodes.tom }

  protected static List<ScopFor> targetLoops = new LinkedList<ScopFor>();
  protected static List<ScopFor> postambleLoops = new LinkedList<ScopFor>();
  protected static int statementDepth = -1;


  protected InsertStaggeredTilingPostambles() {
  }


  public static synchronized ScopRoot insert(ScopRoot root, String statementName, int factor, int numberOfDim, List<Integer> orderingDims){
	  try{
		  targetLoops.clear();
		  postambleLoops.clear();

		 ScopLoopIdentifier loopIds = ScopAssignLoopIdentifiers.assign(root);

		  //collect target loops
		 `BottomUp(findTargetLoops(statementName, factor, numberOfDim)).visitLight(root, tom.mapping.GenericIntrospector.INSTANCE);
		 // `BottomUp(findTargetLoops(statementName, factor, numberOfDim)).visitLight(root,new ScopIntrospector());

		  //nothing found
		  if (statementDepth == -1) return root;

		  //separate loops into those in common nestings
		  Map<String, List<ScopFor>> commonNests = new TreeMap<String, List<ScopFor>>();
		  for (ScopFor l : targetLoops) {
			  String IDstr = loopIds.toStringIDupToDepth(l, statementDepth-1);
			  if (!commonNests.containsKey(IDstr)) {
				  commonNests.put(IDstr, new LinkedList<ScopFor>());
			  }
			  commonNests.get(IDstr).add(l);
		  }

		  //for each common nesting, create the postamble
		  for (String id : commonNests.keySet()) {
			  //sort the loops in common nesting by its ordering within the nesting
			  Collections.sort(commonNests.get(id), loopIds);
			  
			  ScopFor firstLoop = commonNests.get(id).get(0);
			  ScopFor lastLoop = commonNests.get(id).get(commonNests.get(id).size()-1);

			  IntExpression UB = sum(lastLoop.getUB().copy(), affine(term(factor)));
			  IntExpression LB = max(firstLoop.getLB().copy(), sum(lastLoop.getUB().copy(), affine(term(1))));

			  //create the macro argument, basically collecting point loop iterators
			  List<IntExpression> params = new LinkedList<IntExpression>();
			  params.add(affine(term(firstLoop.getIterator())));
			  
			  List<ScopFor> loops = firstLoop.getSurroundingScopFors();
			  for (int i = loops.size()-1; i > loops.size()-numberOfDim; i--) {
				  params.add(affine(term(loops.get(i).getIterator())));
			  }
			  Collections.reverse(params);
			  //add ordering dimes
			  for (int od : orderingDims) {
				  params.add(od, affine(term(0)));
			  }

			  ScopStatementMacro stmt = ScopUserFactory.scopStatementMacro(statementName, params);
			  ScopFor postamble = (ScopFor)`loop(firstLoop.getIterator(), LB, UB, firstLoop.getStride().copy(), block(nodes(stmt)));
			  //target loop to insert is the last loop in the nesting
			  insertPostamble(postamble, lastLoop);
		  }
		  

		  return root;
	  }catch(VisitFailure ex){
		  throw new RuntimeException(ex);
      }
  }

  private static void insertPostamble(ScopFor postamble, ScopFor targetLoop) {
		  final EList<AbstractScopNode> list;
		  if (targetLoop.eContainer() instanceof ScopBlock) {
			  list = ((ScopBlock)targetLoop.eContainer()).getStatements();
		  } else if (targetLoop.eContainer() instanceof ScopFor) {
			  list = new BasicEList<AbstractScopNode>();
			  list.add(((ScopFor)targetLoop.eContainer()).getBody());
		  } else if (targetLoop.eContainer() instanceof ScopRoot) {
			  list = ((ScopRoot)targetLoop.eContainer()).getStatements();
		  } else {
			  throw new RuntimeException("Unexpected case");
		  }
		  int targetIndex = list.indexOf(targetLoop);
		  list.add(targetIndex+1, postamble);
  }



  %strategy findTargetLoops(stmtName : String, factor : int, numberOfDim : int) extends Identity() {
    visit node {
    	stmt@stmtMacro(name, _) -> {
    			if (`name.contentEquals(stmtName)) {
	    			EList<ScopFor> loops = ((ScopStatementMacro)`stmt).getSurroundingScopFors();
	    			if (loops.size()>0) {
	    				ScopFor targetLoop = loops.get(loops.size()-1);
	    				
	    				int depth = `stmt.getLoopDepth();
	    				if (statementDepth == -1) {
	    					statementDepth = depth;
	    				} else if (depth != statementDepth) {
	    					throw new RuntimeException("Depth of the target statements are expected to be same.");
	    				}
	    				
	    				//when the corresponding dimension of the statement macro is not a fixed constant
	    				//number of loops are 2N+1 because of tiling + time loop + partitioning loop - last tile loop
						//int dim = targetLoop.getLoopDepth() - 2 + 1 - numberOfDim -1; //another -1 because the loop depth starts from 1 not 0
	    				//if (AlgebraPrettyPrinter.print(((ScopStatementMacro)tom_stmt).getMacroParams().get(dim), OUTPUT_FORMAT.C).contentEquals(targetLoop.getIterator().getName())) {
	    					targetLoops.add(targetLoop);
		    			//}
	    			}
    			}
    			return `stmt;
    	}
    }
 
  }


}