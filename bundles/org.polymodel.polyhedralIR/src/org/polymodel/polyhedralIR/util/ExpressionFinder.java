package org.polymodel.polyhedralIR.util;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;


/**
 * This class is visitor that locates the node specified as nodeId when printAST is called.
 * Used to specify expressions from the script interface.
 * 
 * @author yuki
 *
 */
public class ExpressionFinder extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	
	private int depth;
	private int[] targetId;
	private Expression target = null;

	public static Expression getExpression(Program program, int[] id) {
		ExpressionFinder finder = new ExpressionFinder(id);
		program.accept(finder);
		return finder.target;
	}
	
	public static Expression getExpression(Program program, String id) {
		id = id.trim();
		id = id.replaceAll("^\\(|\\)$|\\t", "");
		String[] ids = id.split("\\s*,\\s*");
		int[] target = new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			target[i] = Integer.parseInt(ids[i]);
		}
		return getExpression(program, target);
	}
	
	protected ExpressionFinder(int[] id) {
		targetId = id;
		if (id.length < 3) {
			throw new RuntimeException("nodeID must have length of at least 3 for it to point to an Expression.");
		}
		
	}
	
	@Override
	public void visitProgram(Program p) {
		//short cut the first two depth
		depth = 1;
		if (targetId[0] < p.getSystems().size()) {
			AffineSystem system = p.getSystems().get(targetId[0]);
			
			if (targetId.length == 2)
				throw new RuntimeException("2 dimensional Id cannot be an expression ID");
			
			// StandardEquation case: we get the equation from getEquations();
			if (targetId[1] < system.getEquations().size()) {
				StandardEquation seq = system.getEquations().get(targetId[1]);
				
				if (targetId.length == 3) { // Equation only has one branch
					if (targetId[2] != 0)
						throw new RuntimeException("3rd element of the nodeID must be 0.");
					target = seq.getExpression();
				} else
					seq.accept(this);
				
			} else {
				int realIndex = targetId[1]-system.getEquations().size();
				if (realIndex < system.getUseEquations().size() ) {
					// UseEquation case
					UseEquation ueq = system.getUseEquations().get(realIndex);
					
					if (targetId.length==3) {
						target = ueq.getInputs().get(targetId[2]);
					} else
						ueq.getInputs().get(targetId[2]).accept(this);
				} else
					throw new RuntimeException("Id starting from" + targetId[0] + "," + targetId[1] +
							" but there is only " + system.getEquations().size() + " equations and "
							+ system.getUseEquations().size() + " use equation in the system.");
			}
		} else
			throw new RuntimeException("Id starting from " + targetId[0] + " but there is only " + p.getSystems().size() + " systems in the program.");
	}
	
	@Override
	public void inExpression(Expression e) {
		//check if its already found
		if (target != null) return;
		depth++;
		int count = -1;
		boolean found = false;
		for (EObject obj : e.eContents()) {
			if (obj instanceof Expression) {
				count++;
				//visit if it matches the prefix for this depth
				if (targetId[depth+1] == count) {
					//at the target expression
					if (targetId.length == depth+2) {
						target = (Expression)obj;
					//traverse further if the id is longer
					} else if (targetId.length > depth+1) { 
						((Expression)obj).accept(this);
					} 
					found = true;
					break;
				}
			}
		}
		
		if (!found) {
			throw new RuntimeException("Failed to find Expression id " + targetId[depth] + " at depth " + (depth+1));
		}
	}
}
