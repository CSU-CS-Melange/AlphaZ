package org.polymodel.polyhedralIR.transformation.helper;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.transformation.PolyhedralIRTomTransformation;
import tom.library.sl.VisitFailure;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.polyhedralIR.util.ExpressionDomainCalculator;
import org.polymodel.polyhedralIR.util.ExpressionFinder;

public class AddLocal {
	
	private static PolyhedralIRUserFactory _polyIR;
	
	/**
	 * Create a new local variable (of name "name_Local" and domain "dom_Local") in an affine system ("syst"), corresponding to "expr"
	 * Also replace all the occurence of expr by a utilisation of the new local variable.
	 * 
	 * @param syst
	 * @param expr
	 * @param name_Local
	 * @param dom_Local
	 */
	public static void addLocal(AffineSystem syst, Expression expr, String name_Local, Domain dom_Local) {
		if (syst.containsVariable(name_Local))
			throw new RuntimeException("addLocal: the variable " + name_Local + " already exists in the system");
		_polyIR = PolyhedralIRUserFactory.eINSTANCE;
		
		// Create the VariableDeclaration of the new Local Variable
		Type type_Local = expr.getExpressionType();
		VariableDeclaration varDeclLoc = _polyIR.createVariableDeclaration(name_Local, type_Local, dom_Local);
		syst.getLocals().add(varDeclLoc);
		
		// Pattern-match on other expressions
		AddLocalTom.replace(syst, expr, _polyIR.createVariableExpression(varDeclLoc));
		
		// Adding the new equation to the system
		StandardEquation eqLocal = _polyIR.createStandardEquation(varDeclLoc , expr.copy());
		syst.getEquations().add(eqLocal);
		
		// Update the context/expression domain of the new system
		ContextDomainCalculator.computeContextDomain(syst);
	}

	/**
	 * Add a new local variable ("varDeclLoc" and domain "dom_Local") in an affine system ("syst"), corresponding to "expr"
	 * Also replace all the occurence of expr by a utilisation of the new local variable.
	 * 
	 * @param syst
	 * @param expr
	 * @param varDeclLoc
	 * @param dom_Local
	 */
	public static void addLocal(AffineSystem syst, Expression expr, VariableDeclaration varDeclLoc, Domain dom_Local) {
		String name_Local = varDeclLoc.getName();
		if (syst.containsVariable(name_Local))
			throw new RuntimeException("addLocal: the variable " + name_Local + " already exists in the system");
		_polyIR = PolyhedralIRUserFactory.eINSTANCE;

		syst.getLocals().add(varDeclLoc);

		// Pattern-match on other expressions
		AddLocalTom.replace(syst, expr, _polyIR.createVariableExpression(varDeclLoc));

		// Adding the new equation to the system
		StandardEquation eqLocal = _polyIR.createStandardEquation(varDeclLoc , expr.copy());
		syst.getEquations().add(eqLocal);

		// Update the context/expression domain of the new system
		ContextDomainCalculator.computeContextDomain(syst);
	}
	
	/**
	 * Create a new local variable (of name "name_Local" and domain "dom_Local") in an affine system ("syst"), corresponding to "expr"
	 *     Also replace all the occurence of expr by a utilisation of the new local variable.
	 * The domain of the new local variable is the ExpressionDomain of "expr"
	 * 
	 * @param syst
	 * @param expr
	 * @param name_Local
	 */
	public static void addLocal(AffineSystem syst, Expression expr, String name_Local) {
		ExpressionDomainCalculator.computeExpressionDomain(syst.getParameters(), expr);
		addLocal(syst, expr, name_Local, expr.getExpressionDomain());
	}
	
	/**
	 * addLocal where the name is not specified (we will use the following name: "_Local_[k]",
	 *			with [k] an integer big enough to avoid a name colision)
	**/
	public static void addLocal(AffineSystem syst, Expression expr, Domain dom_Local) {
		addLocal(syst, expr, findUniqueLocalName(syst), dom_Local);
	}
	
	/**
	 * Method to find a local name that was not used before
	 * 
	 * @param syst
	 * @return BaseLocalName
	 */
	private static String findUniqueLocalName(AffineSystem syst) {
		int k = 0;
		boolean exist = true;
		while (exist) {
			if (syst.containsVariable("_Local_" + k))
				k++;
			else
				exist = false;
		}
		
		return ("_Local_" + k);
	}
	
	/**
	 * addLocal where the expression is specified from a sub-expression of the same system (specified by nodeId)
	 *
	 * @param syst
	 * @param nodeId
	 * @param name_Local
	 */
	public static void addLocal(AffineSystem syst, int[] nodeId, String name_Local) {
		if (syst.containsVariable(name_Local))
			throw new RuntimeException("addLocal: the variable " + name_Local + " already exists in the system");
		
		Program prog = syst.getContainerProgram();
		
		if (!(prog.getSystems().get(nodeId[0]).equals(syst)))
			throw new RuntimeException("The specified subexpression belongs to the wrong AffineSystem.");
		
		Expression expr = ExpressionFinder.getExpression(prog, nodeId);
		Domain domExpr = expr.getContextDomain();
		addLocal(syst, expr, name_Local, domExpr);	// Do not do a copy of "expr", else you won't have a containing system anymore
	}
	
	/**
	 * addLocalUnique : Replace only the specified location by the local variable
	 * 		Do not pattern-match the whole system
	 * 
	 * @param syst
	 * @param nodeId
	 * @param name_Local
	 */
	public static void addLocalUnique(AffineSystem syst, int[] nodeId, String name_Local) {
		if (syst.containsVariable(name_Local))
			throw new RuntimeException("addLocalUnique: the variable " + name_Local + " already exists in the system");
		
		Program prog = syst.getContainerProgram();
		
		if (!(prog.getSystems().get(nodeId[0]).equals(syst)))
			throw new RuntimeException("The specified subexpression belongs to the wrong AffineSystem.");
		
		Expression expr = ExpressionFinder.getExpression(prog, nodeId);
		Domain domExpr = expr.getContextDomain();
		
		// Create the VariableDeclaration of the new Local Variable
		_polyIR = PolyhedralIRUserFactory.eINSTANCE;
		Type type_Local = expr.getExpressionType();
		VariableDeclaration varDeclLoc = _polyIR.createVariableDeclaration(name_Local, type_Local, domExpr);
		syst.getLocals().add(varDeclLoc);
		
		// Replacing only the specified location by the expression
		int k = expr.eContainer().eContents().indexOf(expr);
		ReplaceUniqueExpression.replace(syst, (Expression) expr.eContainer().eContents().get(k), _polyIR.createVariableExpression(varDeclLoc));
		
		// Adding the new equation to the system
		StandardEquation eqLocal = _polyIR.createStandardEquation(varDeclLoc, expr.copy());
		syst.getEquations().add(eqLocal);
		
		// Update the context/expression domain of the new system
		ContextDomainCalculator.computeContextDomain(syst);
	}
	
	/**
	 * Find the expressions of lexpr inside the equations of syst, replace them by new local variables
	 *  and returns these local variables, while adding them to syst.
	 * If an expression do not appear anywhere, we throw an exception.
	 * 
	 * @param syst
	 * @param lexpr
	 * @return lLocals, the list of Local Variable created.
	 */
	public static List<VariableDeclaration> addLocals(AffineSystem syst, List<Expression> lexpr) {
		AffineSystem origSyst = syst.copy();
		PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
		
		// Creating the VariableDeclarations that will replace the expressions we are detecting
		List<VariableDeclaration> lvarDecl = new BasicEList<VariableDeclaration>();
		String BasenameVar = findUniqueLocalName(syst);
		for (int k=0; k<lexpr.size(); k++) {
			String nameVar = BasenameVar + "_" + k;
			Type typeVar = lexpr.get(k).getExpressionType();
			Domain domVar = lexpr.get(k).getContextDomain().copy();
			
			VariableDeclaration nvarDecl = _polyIRFact.createVariableDeclaration(
					nameVar, typeVar, domVar);
			lvarDecl.add(nvarDecl);
		}
		
		// Add these new VariableDeclaration to the system
		syst.getLocals().addAll(lvarDecl);
		
		// ---- Pattern-match
		// Pattern-matching:
		//	- Replace the expressions with the locals VariableDeclaration
		//	- If an expression do not appear somewhere, raise an exception
		//	- To counter inclusion/equality cases, do the patern matching on the remaining expressions.
		//		=> In that way, only the biggest expression will be considered and pattern matched.
		for (int k=0; k<lexpr.size(); k++) {
			// Pattern match the system
			Expression corLocalVar = _polyIRFact.createVariableExpression(lvarDecl.get(k));
			try {
				AddLocalTom.replace(syst, lexpr.get(k), corLocalVar);
			} catch (RuntimeException e) {
				syst = origSyst;
				throw new RuntimeException("AddLocal: expression lexpr.(" + k +") do not appear anywhere in the system " + syst.getName());
			}
			
			// Update the other expressions
			for (int l=k+1; l<lexpr.size(); l++) {
				try {
					// Pattern matching inside one expression (attached to the system syst).
					AddLocalTom.replace(syst, lexpr.get(l), lexpr.get(k), corLocalVar);
				} catch (RuntimeException e) {
					// Do nothing
				}
			}
		}
		
		for (int k=0; k<lexpr.size(); k++) {
			StandardEquation nStdEq = _polyIRFact.createStandardEquation(lvarDecl.get(k), lexpr.get(k).copy());
			syst.getEquations().add(nStdEq);
		}
		
		return lvarDecl;
	}
	
	// TODO: Other implementations to do:
	// - Use a existing VariableDeclaration (need to check that it really corresponds)
	
	// **************************************** TOM SIDE !!!
	public static class AddLocalTom extends PolyhedralIRTomTransformation {
		protected final Expression _target;
		protected final Expression _replace;
		protected static boolean _foundAtLeastOnce;
		protected static boolean _expressionPatternMatch;	// = true if we are doing a pattern-match only on a expression
		
		// Replace for affine system
		public static void replace(AffineSystem syst, Expression target, Expression replace){
			_foundAtLeastOnce = false;
			_expressionPatternMatch = false;
			
			AddLocalTom al = new AddLocalTom(target, replace);
			al.transform(syst);
		//	if (!_foundAtLeastOnce)
		//		throw new RuntimeException("AddLocal: expression " + target.toString() + " not found.");
		}
		
		// Replace for expressions (the context of this expression begin given by hte AffineSystem)
		public static void replace(AffineSystem syst, Expression context, Expression target, Expression replace) {
			_foundAtLeastOnce = false;
			_expressionPatternMatch = true;
			
			AddLocalTom al = new AddLocalTom(target, replace);
			al.transform(context);
		//	if (!_foundAtLeastOnce)
		//		throw new RuntimeException("AddLocal: expression " + target.toString() + " not found.");
		}
		
		protected AddLocalTom(Expression target, Expression replace) {
			_target = target;
			_replace = replace;
		}
		
		@Override
		protected EObject apply(EObject o) throws VisitFailure {
			try{
				EObject t;
				if (_expressionPatternMatch)
					t =	`TopDown(ReplaceExpr(_target, _replace)).visitLight((Expression)o, tom.mapping.GenericIntrospector.INSTANCE);
				else
					t =	`TopDown(ReplaceExpr(_target, _replace)).visitLight((AffineSystem)o, tom.mapping.GenericIntrospector.INSTANCE);
				return t;
			} catch(ClassCastException e) {
				e.printStackTrace();				
				throw new IllegalArgumentException(o+ "isn't an Affine System");
			}
		}
		
		// TODO: do a patern matching on each type of expression, and unroll the matching ?
		// => Can manage the case "A@f1 + B@f2" <=> "A@f3 + B@f4" where (\exists f) f3 = f1 o f and f4 = f2 o f
		// => Possible to use part of normalise (to expose the maximum common "f") ?
		
		%include { sl.tom }
		%include { polyhedralIR.tom }
		
		%strategy ReplaceExpr(target : Expression, replace : Expression) extends Identity() {
			visit Expression {
				context@_ -> { if (target.equivalence(`context)) {
								_foundAtLeastOnce = true;
								return `replace.copy();
							}
						}
			}
		}
	}
}
