package org.polymodel.polyhedralIR.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;

/**
 * Transformation that takes an alphabets program and creates a new program that 
 * DO NOT preserve the original semantics but computes the fastest possible schedule (free schedule).
 * 
 * TODO : add description of the basic algorithm here
 * 
 * Developed as a project in CS560
 * 
 * @author Alex Klein
 *
 */
public class FreeScheduler {

	private static final PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;
	
	private static final String FREE_SCHEDULE_VAR_PREFIX = "Free_";
	
	public static Program FreeScheduler(Program prog) {

		// create new program, add copy external function calls
		Program newProg = _fact.createProgram();
		for (ExternalFunctionDeclaration exFunc : prog.getExternalFunctionDeclarations()) {
			newProg.getExternalFunctionDeclarations().add(EcoreUtil.copy(exFunc));
		}

		// for each system in the original program, create a corresponding system that computes the free schedule
		for (AffineSystem system : prog.getSystems()) {
			AffineSystem newSystem = _fact.createAffineSystem(FREE_SCHEDULE_VAR_PREFIX + system.getName(), (ParameterDomain)system.getParameters().copy());
			newProg.getSystems().add(newSystem);

			Collection<StandardEquation> addList = new LinkedList<StandardEquation>();
			// move inputs to local
			for (VariableDeclaration dec : system.getInputs()) {
				VariableDeclaration newDecl = _fact.createVariableDeclaration(FREE_SCHEDULE_VAR_PREFIX + dec.getName(), _fact.createType(DATATYPE.INTEGER), dec.getDomain().copy());				
				newSystem.getLocals().add(newDecl);
				
				//Create an equation for each input (that are now local) to give -1 as the initial value
				IntegerExpression intexp = _fact.createIntegerExpression(-1);
				AffineFunction affineFunc = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), dec.getDomain().getIndexNames(), new ArrayList<String>());
				DependenceExpression dep = _fact.createDependenceExpression(affineFunc, intexp);
				//These equations are set aside so that later transformations on existing equations are not applied
				addList.add(_fact.createStandardEquation(newDecl, dep));
			}
			
			// move local to output
			for (VariableDeclaration dec : system.getLocals()) {
				VariableDeclaration newDecl = _fact.createVariableDeclaration(FREE_SCHEDULE_VAR_PREFIX + dec.getName(), _fact.createType(DATATYPE.INTEGER), dec.getDomain().copy());
				newSystem.getOutputs().add(newDecl);
			}
			
			// move output to output
			for (VariableDeclaration dec : system.getOutputs()) {
				VariableDeclaration newDecl = _fact.createVariableDeclaration(FREE_SCHEDULE_VAR_PREFIX + dec.getName(), _fact.createType(DATATYPE.INTEGER), dec.getDomain().copy());
				newSystem.getOutputs().add(newDecl);
			}
			
			// allow visitor for each equation and add 1 +
			for (StandardEquation eq : system.getEquations()) {
				IntegerExpression intexp = _fact.createIntegerExpression(1);
				AffineFunction affineFunc = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), eq.getVariable().getDomain().getIndexNames(), new ArrayList<String>());
				DependenceExpression dep = _fact.createDependenceExpression(affineFunc, intexp);
				
				StandardEquation newEq = _fact.createStandardEquation(
						newSystem.getVariableDeclaration(FREE_SCHEDULE_VAR_PREFIX + eq.getVariable().getName()), 
												eq.getExpression().copy());
				newSystem.getEquations().add(newEq);
				
				newEq.accept(FreeSchedulerVisitor.INSTANCE);
				BinaryExpression addOne = _fact.createBinaryExpression(OP.ADD,
						dep,
						newEq.getExpression().copy());
				
				newEq.setExpression(addOne);
			}
			// add the equations to initialize input variables
			newSystem.getEquations().addAll(addList);
		}
		
		return newProg;
	}
	// visitor: changes ops to max, removes external function declarations and replaces constant expressions
	private static class FreeSchedulerVisitor extends PolyhedralIRDepthFirstVisitorImpl {
		
		private static final PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;
		private static final FreeSchedulerVisitor INSTANCE = new FreeSchedulerVisitor();
	
	
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void outReduceExpression(ReduceExpression r) {
			r.setOP(OP.MAX);
			defaultIn(r);
		}
	
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void outBinaryExpression(BinaryExpression b) {
			b.setOperator(OP.MAX);
			defaultIn(b);
		}
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void outMultiArgExpression(MultiArgExpression m) {
			m.setOperator(OP.MAX);
			defaultIn(m);
		}
	
		public void inConstantExpression(ConstantExpression c) {
			IntegerExpression intexp = _fact.createIntegerExpression(-1);
			EcoreUtil.replace(c, intexp);
			defaultIn(c);
		}
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void outExternalFunctionCall(ExternalFunctionCall e) {
			EList<Expression> exprs = e.getExprs();
			if (exprs.size() == 0) {
				IntegerExpression intexp = _fact.createIntegerExpression(-1);
				EcoreUtil.replace(e,intexp);
			} else if (exprs.size() == 1) {
				EcoreUtil.replace(e, exprs.get(0));
			} else if (exprs.size() == 2) {
				EcoreUtil.replace(e, _fact.createBinaryExpression(OP.MAX, exprs.get(0).copy(), exprs.get(1).copy()));
			} else {
				EcoreUtil.replace(e, _fact.createMultiArgExpression(OP.MAX, exprs));
			}
			defaultOut(e);
		}
		
		public void outVariableExpression(VariableExpression v) {
			if (v.getContainerEquation() instanceof StandardEquation)
				v.setVarDecl(((StandardEquation) v.getContainerEquation()).getContainerSystem().getVariableDeclaration(FREE_SCHEDULE_VAR_PREFIX + v.getVarDecl().getName()));
			else
				v.setVarDecl(((UseEquation) v.getContainerEquation()).getContainerSystem().getVariableDeclaration(FREE_SCHEDULE_VAR_PREFIX + v.getVarDecl().getName()));
		}
	}
}
