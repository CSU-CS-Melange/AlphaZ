package org.polymodel.scop.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

/**
 * Simplifies Scop by calling IntExpression.simplify at all leafs that are IntExpression or IntConstraintSystem.
 * 
 * @author yuki
 *
 */
public class ScopSimplify extends ScopDepthFirstVisitorImpl {
	
	/**
	 * Simplifies the entire SCoP.
	 * 
	 * @param root
	 * @return
	 */
	public static ScopRoot simplify(ScopRoot root) {
		ScopSimplify ss = new ScopSimplify();
		ScopRoot simplified = EcoreUtil.copy(root);
		
		simplified.accept(ss);
		
		return simplified;
	}
	
	/**
	 * Simplifies a ScopNode.
	 * 
	 * @param node
	 * @return
	 */
	public static AbstractScopNode simplify(AbstractScopNode node) {
		ScopSimplify ss = new ScopSimplify();
		AbstractScopNode simplified = EcoreUtil.copy(node);
		
		simplified.accept(ss);
		
		return simplified;
	}
	
	
	protected ScopSimplify() {}

	@Override
	public void inScopAssignment(ScopAssignment s) {
		s.setRHS(s.getRHS().simplify());
	}
	
	@Override
	public void inScopFor(ScopFor s) {
		s.setLB(s.getLB().simplify());
		s.setUB(s.getUB().simplify());
		s.setStride(s.getStride().simplify());
	}
	
	@Override
	public void inScopGuard(ScopGuard s) {
		EList<IntConstraintSystem> systems = s.getConstraintSystems();
		for(int i=0;i<systems.size();i++) {
			systems.set(i,systems.get(i).simplify());
		}
	}
	
	@Override
	public void inScopStatementMacro(ScopStatementMacro s) {
		List<IntExpression> newList = new ArrayList<IntExpression>(s.getMacroParams().size());
		
		for (IntExpression ie : s.getMacroParams()) {
			newList.add(ie.simplify());
		}

		s.getMacroParams().clear();
		s.getMacroParams().addAll(newList);
	}
}
