package org.polymodel.polyhedralIR.convolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.xtext.xbase.lib.Pair;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.AlignVariables;
import org.polymodel.polyhedralIR.transformation.DistributeMultiplications;
import org.polymodel.polyhedralIR.transformation.ExtractMultiArgExpressions;
import org.polymodel.polyhedralIR.transformation.Inline;
import org.polymodel.polyhedralIR.transformation.InlineConstants;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.RemoveUnusedVariables;
import org.polymodel.polyhedralIR.transformation.Simplify;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.polyhedralIR.util.VariableComparator;

/**
 * Extracts system of convolutions from an AffineSystem. It is expected
 * that the entire system consists of convolutions and its combinations.
 * 
 * Procedure:
 *  1. Apply a bunch of pre-proessing (embedding, distributing multiplications,
 *  extracting n-ary additions, and so on)
 *  2. Find the "main" branch of each equation, where "main" is defined to
 *  be the branch of the case with least number of equalities.
 *  3. Attempt to match the main branch to convolution (and its generalizations).
 *  4. Build system of convolutions using the convolutions found, assuming
 *  all equations were found to be convolutions.
 * 
 * Limitations:
 *  - Requires the array of coefficients to be specified.
 *  - Cannot detect convolutions with parametric kernel size; it does
 *  not make too much sense for accuracy analysis, as the coefficients
 *  must be known constants at analysis-time.
 * 
 * @author tyuki
 *
 */
public class ConvolutionSystemDetection {

	private static final PolyhedralIRUserFactory polyFact = PolyhedralIRUserFactory.eINSTANCE;
	public static boolean DEBUG = true;
	
	private static void debug(Object content) {
		if (DEBUG) {
			System.out.println("[ConvSysDetect] " + content);
		}
	}
	
	public static ConvolutionSystem detect(AffineSystem system) {
		return detect(system, new String[]{});
	}
	
	public static ConvolutionSystem detect(AffineSystem system, String coefficients) {
		return detect(system, coefficients.split("\\s*,\\s*"));
	}
	
	public static ConvolutionSystem detect(AffineSystem system, String[] coefficients) {
		List<VariableDeclaration> vars = new ArrayList<>(coefficients.length); 
		for (String coef : coefficients) {
			vars.add(system.getVariableDeclaration(coef));
		}
		ConvolutionSystemDetection csd = new ConvolutionSystemDetection(system, vars);
		return csd.detect();
	}

	
	protected AffineSystem _system;
	protected List<VariableDeclaration> _coefficientArrays;
	
	protected ConvolutionSystemDetection(AffineSystem system, List<VariableDeclaration> coefficients) {
		_system = (system);
		_coefficientArrays = coefficients;
	}
	
	
	/**
	 * Apply sequence of preprocessing transformations.
	 * 
	 * - AlignVariable: Embeds all equations to a common space.
	 *   Some equations may be in a lower dimensional space due to boundary conditions.
	 * - InlineConstants, InlineCandidate Detection + Inline: 
	 *   Inlines constants and simple equations that are only copying or adding two values.
	 *   This works as shift cycle elimination.
	 * - DistributeMultiplication + ExtractMultiArgExpression: Simple tom-based rewriting to
	 *   find n-ary additions.
	 */
	private void preprocessing() {
		Simplify.simplify(_system);
		InlineConstants.apply(_system);
		AlignVariables.apply(_system);
		Normalize.normalize(_system);
		
		InlineCandidateDetection icd = new InlineCandidateDetection();
		_system.accept(icd);
		
		for (String inlineEq : icd.inlineList) {
			Inline.transformAll(_system, _system.getEquation(inlineEq), false);
		}
		Normalize.normalize(_system);
		RemoveUnusedVariables.apply(_system);
		Simplify.simplify(_system);
		DistributeMultiplications.apply(_system);
		ExtractMultiArgExpressions.apply(_system);

		
		debug(AShow.toSimplifiedString(_system));

	}
	
	/**
	 * Main entry point.
	 * 
	 */
	private ConvolutionSystem detect() {
		preprocessing();
		
		
		Comparator<StandardEquation> eqComparator = new Comparator<StandardEquation>() {
			@Override
			public int compare(StandardEquation o1, StandardEquation o2) {
				return o1.getVariable().getName().compareTo(o2.getVariable().getName());
			}};
		
			
		//Attempt to match each equation as convolutions
		//One equation may contain multiple convolutions, distinguished by the data variable
		//The inner-map keeps track of Convolution per target (data) variable
		Map<StandardEquation, Map<VariableDeclaration, Convolution>> eqToConv = new TreeMap<>(eqComparator);
		
		for (StandardEquation eq : _system.getEquations()) {
			debug("Inspecting equation: " + eq.getVariable().getName());
			
			Expression mainExpr = findMainExpression(eq);
			if (mainExpr == null) continue;
			
			debug(" mainBranch: " + PolyhedralIRToAlphabets.toSimplifiedString(mainExpr));
			
			Map<VariableDeclaration, Convolution> conv = checkForConvolution(eq, mainExpr.copy());
			if (conv != null)
				eqToConv.put(eq, conv);
			
			if (conv != null) {
				for (Convolution cv : conv.values())
					debug(cv);
			}
		}
		
		//Build a graph of convolutions
		return buildConvolutionSystem(eqToConv);
	}
	
	/**
	 * Construct the graph representing the connections between convolutions found.
	 * 
	 * @param eqToConv
	 * @return
	 */
	private ConvolutionSystem buildConvolutionSystem(Map<StandardEquation, Map<VariableDeclaration, Convolution>> eqToConv) {
		if (eqToConv.size() < _system.getEquations().size()) {
			System.err.println("[ConvSysDetect] Not all equations has been identified as convolutions.");
		}
		
		ConvolutionSystem convsys = new ConvolutionSystem();
		
		//register input nodes used in convolutions
		for (Map<VariableDeclaration, Convolution> convs : eqToConv.values()) {
			for (Convolution conv : convs.values()) {
				if (conv.getDataVariable().isInput()) {
					IConvolutionSystemNode inNode = new InputNode(conv.getDataVariable());
					convsys.addVertex(inNode);
					convsys.setPrimaryNode(conv.getDataVariable(), inNode);
				}
			}
		}
		
		//Register each convolution found, as well as "primary node"
		for (StandardEquation convEq : eqToConv.keySet()) {
			Map<VariableDeclaration, Convolution> convs = eqToConv.get(convEq);
			if (convs.size() > 1) {
				List<ConvolutionNode> mergedNodes = new ArrayList<>(convs.size());
				for (VariableDeclaration convTarget : convs.keySet()) {
					Convolution conv = convs.get(convTarget);
					ConvolutionNode convNode = new ConvolutionNode(conv);
					convsys.addVertex(convNode);
					mergedNodes.add(convNode);
				}
				MergeNode mergeNode = new MergeNode(convEq);
				convsys.addVertex(mergeNode);
				for (ConvolutionNode mergeSrc : mergedNodes) {
					convsys.addEdge(mergeSrc, mergeNode);
				}
				
				convsys.setPrimaryNode(convEq.getVariable(), mergeNode);
			} else {
				Convolution conv = convs.values().iterator().next();
				ConvolutionNode convNode = new ConvolutionNode(conv);
				convsys.addVertex(convNode);
				convsys.setPrimaryNode(convEq.getVariable(), convNode);
			}
		}
		
		//Connect each convolution 
		for (Map<VariableDeclaration, Convolution> convs : eqToConv.values()) {
			for (Convolution conv : convs.values()) {
				convsys.addEdge(convsys.getPrimaryNode(conv.getDataVariable()), new ConvolutionNode(conv));
			}
		}
		
		return convsys;
	}
	/**
	 * Inspects the body of the given equation for the main expression.
	 * The main expression is the main branch of the case in the body,
	 * assuming normalized program.
	 * 
	 * @param eq
	 * @return
	 */
	private static Expression findMainExpression(StandardEquation eq) {
		if (eq.getExpression() instanceof CaseExpression) {
			Expression mainCandidate = null;
			
			int minNbEq = 999;
			int repeatedNbEq = 999;
			
			for (Expression expr : ((CaseExpression)eq.getExpression()).getExprs()) {
				Domain affineHull = expr.getContextDomain().affineHull();
				int nbEq = affineHull.getPMdomain().getPolyhedra().get(0).getConstraints().size();
				if (nbEq < minNbEq) {
					mainCandidate = expr;
					minNbEq = nbEq;
				} else if (nbEq == minNbEq) {
					repeatedNbEq = nbEq;
				}
			}
			
			if (minNbEq == repeatedNbEq) {
				debug("  failed to find main branch; more than two branches without equalities.");
				return null;
			}
			
			if (mainCandidate == null) {
				debug("  failed to find main branch; all branches have equalities.");
				return null;
			}
			
			return mainCandidate;
		} else {
			return eq.getExpression();
		}
	}
	
	/**
	 * Switch to specialized checks depending on the type of expression. 
	 * 
	 * @param eq
	 * @param expr
	 * @return
	 */
	private Map<VariableDeclaration, Convolution> checkForConvolution(StandardEquation eq, Expression expr) {
		if (expr instanceof MultiArgExpression) {
			return checkForConvolution(eq, (MultiArgExpression)expr);
		} else if (expr instanceof BinaryExpression) {
			return checkForConvolution(eq, (BinaryExpression)expr);
		} else if (expr instanceof ReduceExpression) {
			return checkForConvolution(eq, (ReduceExpression)expr);
		} else if (expr instanceof RestrictExpression) {
			return checkForConvolution(eq, ((RestrictExpression) expr).getExpr());
		}
		
		debug("Unsupported type of main branch: " + expr.eClass().getName());
		return null;
	}
	
	/**
	 * Given a list of expression from n-ary addition, inspect each operand to see if
	 * it matches the pattern of convolution.
	 * 
	 * @param eq
	 * @param exprs
	 * @return
	 */
	private Map<VariableDeclaration, Convolution> checkForConvolution(StandardEquation eq, List<Expression> exprs) {
	Map<VariableDeclaration, Convolution> convolutions = new TreeMap<>(VariableComparator.INSTANCE);
		
		for (Expression expr : exprs) {
			Pair<Expression, Expression> convOp = checkForConvolutionOperand(expr);
			if (convOp != null) {
				VariableDeclaration dataVar = getDataVariable(convOp.getValue());
				
				final Convolution convolution;
				if (!convolutions.containsKey(dataVar)) {
					convolution = new Convolution(eq, dataVar);
					convolutions.put(dataVar, convolution);
				} else {
					convolution = convolutions.get(dataVar);
				}
				convolution.addOperand(convOp.getKey(), convOp.getValue());
			} else {
				return null;
			}
		}
		
		return convolutions;
	}

	
	private Map<VariableDeclaration, Convolution> checkForConvolution(StandardEquation eq, MultiArgExpression mainExpr) {
		if (mainExpr.getOperator() != OP.ADD)
			return null;
		
		return checkForConvolution(eq, mainExpr.getExprs());
	}
	
	private Map<VariableDeclaration, Convolution> checkForConvolution(StandardEquation eq, BinaryExpression mainExpr) {
		if (mainExpr.getOperator() != OP.ADD)
			return null;
		
		List<Expression> exprs = new ArrayList<Expression>(2);
		exprs.add(mainExpr.getLexp());
		exprs.add(mainExpr.getRexp());
		
		return checkForConvolution(eq, exprs);
	}

	/**
	 * Check if the given Expression is a binary multiplication where
	 * one is a constant and the other is some variable.
	 * 
	 * @param expr
	 * @return null if not a convolution operand.
	 */
	private Pair<Expression, Expression> checkForConvolutionOperand(Expression expr) {

		Expression coefExpr = null;
		Expression dataExpr;
		
		if (expr instanceof BinaryExpression) {
			coefExpr = ((BinaryExpression) expr).getLexp();
			dataExpr = ((BinaryExpression) expr).getRexp();
			
		} else {
			coefExpr = null;
			dataExpr = expr;
		}
		
		EXPRTYPE dataExprType = checkExpression(dataExpr);
		EXPRTYPE coefExprType = checkExpression(coefExpr);

		//swap if necessary
		if ((dataExprType == EXPRTYPE.COEFFICIENT_ARRAY || 
			dataExprType == EXPRTYPE.CONSTANT) && 
			coefExprType == EXPRTYPE.DATA_ACCESS) {
			
			Expression tmp = dataExpr;
			dataExpr = coefExpr;
			coefExpr = tmp;
			
			EXPRTYPE tmp2 = dataExprType;
			dataExprType = coefExprType;
			coefExprType = tmp2;
		}
		
		//check for validity
		if (!((coefExprType == EXPRTYPE.COEFFICIENT_ARRAY || 
				coefExprType == EXPRTYPE.CONSTANT) && 
				dataExprType == EXPRTYPE.DATA_ACCESS)) {
			debug("  not a convolution operand: " + PolyhedralIRToAlphabets.toSimplifiedString(expr));
			return null;
		}
		
		if (coefExpr == null) {
			coefExpr = polyFact.createIntegerExpression(1);
		}
		
		if (coefExpr instanceof DependenceExpression && coefExprType == EXPRTYPE.CONSTANT) {
			coefExpr = ((DependenceExpression)coefExpr).getExpr();
		}
		
		if (dataExpr instanceof UnaryExpression) {
			dataExpr = ((UnaryExpression) dataExpr).getExpr();
			coefExpr = polyFact.createUnaryExpression(OP.SUB, coefExpr.copy());
		}
		
		return new Pair<>(coefExpr, dataExpr);
	}
	
	
	private Map<VariableDeclaration, Convolution> checkForConvolution(StandardEquation eq, ReduceExpression expr) {
		throw new RuntimeException("[ConvSysDetection] Not supported yet.");
	}
	

	protected static VariableDeclaration getDataVariable(Expression expr) {
		if (expr instanceof DependenceExpression) {
			expr = ((DependenceExpression) expr).getExpr();
		}
		
		if (expr instanceof VariableExpression) {
			return ((VariableExpression) expr).getVarDecl();
		}
		
		throw new RuntimeException("[ConvSysDetection] Should not reach here: " + expr);
	}
	

	private enum EXPRTYPE {
		CONSTANT,
		COEFFICIENT_ARRAY,
		DATA_ACCESS,
		OTHER
	}
	
	/**
	 * Examines an expression and gives what kind of expression it is in terms of EXPRTYPE.
	 * 
	 * @param expr
	 * @return
	 */
	private EXPRTYPE checkExpression(Expression expr) {
		if (expr == null) return EXPRTYPE.CONSTANT;
		
		if (expr instanceof UnaryExpression && ((UnaryExpression) expr).getOperator() == OP.SUB)
			expr = ((UnaryExpression) expr).getExpr();
		
		if ((expr instanceof DependenceExpression))
			expr = ((DependenceExpression) expr).getExpr();

		if ((expr instanceof RealExpression) || (expr instanceof IntegerExpression))
			return EXPRTYPE.CONSTANT;
		
		if (expr instanceof VariableExpression) {
			if (_coefficientArrays.contains(((VariableExpression) expr).getVarDecl())){
				return EXPRTYPE.COEFFICIENT_ARRAY;
			} else {
				return EXPRTYPE.DATA_ACCESS;
			}
		}
		
		return EXPRTYPE.OTHER;
	}
	
	/**
	 * Finds candidate equations to be inlined as part of the preprocessing.
	 * 
	 * TODO: Made specifically to work with the small number of examples we
	 * have, may need further tuning.
	 * 
	 * @author tyuki
	 *
	 */
	private class InlineCandidateDetection extends PolyhedralIRDepthFirstVisitorImpl {

		private boolean isInputOnly = false;
		private boolean isAdditionOnly = false;
		private boolean isCopyOnly = false;
		private List<String> inlineList = new LinkedList<String>();
		
		@Override
		public void inStandardEquation(StandardEquation s) {
			isInputOnly = true;
			isAdditionOnly = true;
			isCopyOnly = true;
		}
		
		@Override
		public void outStandardEquation(StandardEquation s) {
			if (isInputOnly && isAdditionOnly || isCopyOnly) {
				inlineList.add(s.getVariable().getName());
			}
		}
		
		@Override
		public void inVariableExpression(VariableExpression v) {
			isInputOnly &= v.getVarDecl().isInput();
		}
		
		@Override
		public void inBinaryExpression(BinaryExpression b) {
			isCopyOnly = false;
			isAdditionOnly &= (b.getOperator() == OP.ADD || b.getOperator() == OP.SUB);
		}
		
		@Override
		public void inMultiArgExpression(MultiArgExpression m) {
			isCopyOnly = false;
			isAdditionOnly &= m.getOperator() == OP.ADD;
		}
		
		@Override
		public void inReduceExpression(ReduceExpression r) {
			isCopyOnly = false;
		}
	}
}
