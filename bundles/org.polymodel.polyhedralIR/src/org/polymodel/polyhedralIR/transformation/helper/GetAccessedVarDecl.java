package org.polymodel.polyhedralIR.transformation.helper;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;

/**
 * Class with visitor, to get back all the variable of the program accessed by a list of equations
 * 
 * @author Guillaume I.
 */
public class GetAccessedVarDecl {
	
	public static List<VariableDeclaration> getAccessedVarDecl(Expression expr) {
		GetAccessedVarDeclVisitor visitor = new GetAccessedVarDeclVisitor();
		expr.accept(visitor);
		return visitor.getFoundVar();
	}
	
	public static List<VariableDeclaration> getAccessedVarDecl(List<Equation> leq) {
		GetAccessedVarDeclVisitor visitor = new GetAccessedVarDeclVisitor();
		for (Equation eq : leq)
			eq.accept(visitor);
		return visitor.getFoundVar();
	}
	
	public static List<VariableDeclaration> getAccessedVarDeclExpr(List<Expression> lexpr) {
		GetAccessedVarDeclVisitor visitor = new GetAccessedVarDeclVisitor();
		for (Expression expr : lexpr)
			expr.accept(visitor);
		return visitor.getFoundVar();
	}
	
	
	// ------------------------ Visitor on the current equation ------------------------
	private static class GetAccessedVarDeclVisitor extends PolyhedralIRDepthFirstVisitorImpl {
		
		// Get the list of all the VariableDeclaration of the accessed variables
		protected List<VariableDeclaration> _foundVar;
		
		public GetAccessedVarDeclVisitor() {
			this._foundVar = new BasicEList<VariableDeclaration>();
		}
		
		public List<VariableDeclaration> getFoundVar() {
			return this._foundVar;
		}
		
		@Override
		public void inVariableExpression(VariableExpression varExp) {
			if (!_foundVar.contains(varExp.getVarDecl()))
				_foundVar.add(varExp.getVarDecl());
		}
		
	} // GetAccessedVarDeclVisitor
	
	
} // GetAccessedVarDecl
