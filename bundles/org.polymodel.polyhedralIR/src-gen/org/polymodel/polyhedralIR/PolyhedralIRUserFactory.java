package org.polymodel.polyhedralIR;

import java.util.List;

import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExpressionFactory;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;

/* PROTECTED REGION ID(polyhedralIR_user_factory_imports) ENABLED START */
// protected imports, you should add here required imports
// that won't be removed after regeneration of the mapping code
/* PROTECTED REGION END */

/**
* User factory for polyhedralIR
* -- Generated by TOM mapping EMF generator --
*/

public class PolyhedralIRUserFactory {
	
	/* PROTECTED REGION ID(polyhedralIR_user_factory_members) ENABLED START */
	/* PROTECTED REGION END */

	// packageListBis
	public static PolyhedralIRFactory polyhedralIRFactory = PolyhedralIRFactory.eINSTANCE;
	public static ExpressionFactory expressionFactory = ExpressionFactory.eINSTANCE;
	
	// User operators
	// Operator program
	public static Program program(List<AffineSystem> _systems, List<ExternalFunctionDeclaration> _externalFunctionDeclarations) {
		Program o = polyhedralIRFactory.createProgram();
		for(int i = 0 ; i < _systems.size() ; ++i) {
			o.getSystems().add(_systems.get(i));
		}
		for(int i = 0 ; i < _externalFunctionDeclarations.size() ; ++i) {
			o.getExternalFunctionDeclarations().add(_externalFunctionDeclarations.get(i));
		}
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_program) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator system
	public static AffineSystem system(String _name, ParameterDomain _parameters, List<VariableDeclaration> _inputs, List<VariableDeclaration> _outputs, List<VariableDeclaration> _locals, List<StandardEquation> _equations, List<UseEquation> _useEquations) {
		AffineSystem o = polyhedralIRFactory.createAffineSystem();
		o.setName(_name);
		o.setParameters(_parameters);
		for(int i = 0 ; i < _inputs.size() ; ++i) {
			o.getInputs().add(_inputs.get(i));
		}
		for(int i = 0 ; i < _outputs.size() ; ++i) {
			o.getOutputs().add(_outputs.get(i));
		}
		for(int i = 0 ; i < _locals.size() ; ++i) {
			o.getLocals().add(_locals.get(i));
		}
		for(int i = 0 ; i < _equations.size() ; ++i) {
			o.getEquations().add(_equations.get(i));
		}
		for(int i = 0 ; i < _useEquations.size() ; ++i) {
			o.getUseEquations().add(_useEquations.get(i));
		}
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_system) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator varDecl
	public static VariableDeclaration varDecl(VariableIdentifier _varID, Domain _domain) {
		VariableDeclaration o = polyhedralIRFactory.createVariableDeclaration();
		o.setVarID(_varID);
		o.setDomain(_domain);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_varDecl) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator var
	public static VariableExpression var(VariableDeclaration _varDecl) {
		VariableExpression o = expressionFactory.createVariableExpression();
		o.setVarDecl(_varDecl);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_var) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator eq
	public static StandardEquation eq(VariableDeclaration _variable, Expression _expression) {
		StandardEquation o = polyhedralIRFactory.createStandardEquation();
		o.setVariable(_variable);
		o.setExpression(_expression);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_eq) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator ueq
	public static UseEquation ueq(Domain _extensionDomain, AffineFunction _parameters, AffineSystem _subSystem, List<Expression> _inputs, List<VariableDeclaration> _outputs, String _label) {
		UseEquation o = polyhedralIRFactory.createUseEquation();
		o.setExtensionDomain(_extensionDomain);
		o.setParameters(_parameters);
		o.setSubSystem(_subSystem);
		for(int i = 0 ; i < _inputs.size() ; ++i) {
			o.getInputs().add(_inputs.get(i));
		}
		for(int i = 0 ; i < _outputs.size() ; ++i) {
			o.getOutputs().add(_outputs.get(i));
		}
		o.setLabel(_label);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_ueq) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator boolConst
	public static BooleanExpression boolConst(boolean _value) {
		BooleanExpression o = expressionFactory.createBooleanExpression();
		o.setValue(_value);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_boolConst) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator intConst
	public static IntegerExpression intConst(long _value) {
		IntegerExpression o = expressionFactory.createIntegerExpression();
		o.setValue(_value);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_intConst) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator realConst
	public static RealExpression realConst(double _value) {
		RealExpression o = expressionFactory.createRealExpression();
		o.setValue(_value);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_realConst) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator reduce
	public static ReduceExpression reduce(OP _OP, AffineFunction _projection, Expression _expr) {
		ReduceExpression o = expressionFactory.createReduceExpression();
		o.setOP(_OP);
		o.setProjection(_projection);
		o.setExpr(_expr);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_reduce) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator caseExpr
	public static CaseExpression caseExpr(List<Expression> _exprs) {
		CaseExpression o = expressionFactory.createCaseExpression();
		for(int i = 0 ; i < _exprs.size() ; ++i) {
			o.getExprs().add(_exprs.get(i));
		}
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_caseExpr) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator ifExpr
	public static IfExpression ifExpr(Expression _cond, Expression _then, Expression _else) {
		IfExpression o = expressionFactory.createIfExpression();
		o.setCond(_cond);
		o.setThen(_then);
		o.setElse(_else);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_ifExpr) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator restrictExpr
	public static RestrictExpression restrictExpr(Domain _restrictDomain, Expression _expr) {
		RestrictExpression o = expressionFactory.createRestrictExpression();
		o.setRestrictDomain(_restrictDomain);
		o.setExpr(_expr);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_restrictExpr) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator depExpr
	public static DependenceExpression depExpr(AffineFunction _dep, Expression _expr) {
		DependenceExpression o = expressionFactory.createDependenceExpression();
		o.setDep(_dep);
		o.setExpr(_expr);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_depExpr) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator indexExpr
	public static IndexExpression indexExpr(AffineFunction _function) {
		IndexExpression o = expressionFactory.createIndexExpression();
		o.setFunction(_function);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_indexExpr) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator binOp
	public static BinaryExpression binOp(OP _operator, Expression _lexp, Expression _rexp) {
		BinaryExpression o = expressionFactory.createBinaryExpression();
		o.setOperator(_operator);
		o.setLexp(_lexp);
		o.setRexp(_rexp);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_binOp) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator binAdd
	public static BinaryExpression binAdd(Expression _lexp, Expression _rexp) {
		BinaryExpression o = expressionFactory.createBinaryExpression();
		o.setLexp(_lexp);
		o.setRexp(_rexp);
		o.setOperator(OP.ADD);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_binAdd) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator binSub
	public static BinaryExpression binSub(Expression _lexp, Expression _rexp) {
		BinaryExpression o = expressionFactory.createBinaryExpression();
		o.setLexp(_lexp);
		o.setRexp(_rexp);
		o.setOperator(OP.SUB);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_binSub) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator binMul
	public static BinaryExpression binMul(Expression _lexp, Expression _rexp) {
		BinaryExpression o = expressionFactory.createBinaryExpression();
		o.setLexp(_lexp);
		o.setRexp(_rexp);
		o.setOperator(OP.MUL);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_binMul) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator binEq
	public static BinaryExpression binEq(Expression _lexp, Expression _rexp) {
		BinaryExpression o = expressionFactory.createBinaryExpression();
		o.setLexp(_lexp);
		o.setRexp(_rexp);
		o.setOperator(OP.EQ);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_binEq) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator unaryOp
	public static UnaryExpression unaryOp(OP _operator, Expression _expr) {
		UnaryExpression o = expressionFactory.createUnaryExpression();
		o.setOperator(_operator);
		o.setExpr(_expr);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_unaryOp) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator unaryMinus
	public static UnaryExpression unaryMinus(Expression _expr) {
		UnaryExpression o = expressionFactory.createUnaryExpression();
		o.setExpr(_expr);
		o.setOperator(OP.SUB);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_unaryMinus) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator multOp
	public static MultiArgExpression multOp(OP _operator, List<Expression> _exprs) {
		MultiArgExpression o = expressionFactory.createMultiArgExpression();
		o.setOperator(_operator);
		for(int i = 0 ; i < _exprs.size() ; ++i) {
			o.getExprs().add(_exprs.get(i));
		}
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_multOp) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator externalCall
	public static ExternalFunctionCall externalCall(OP _operator, List<Expression> _exprs, ExternalFunctionDeclaration _exFunc) {
		ExternalFunctionCall o = expressionFactory.createExternalFunctionCall();
		o.setOperator(_operator);
		for(int i = 0 ; i < _exprs.size() ; ++i) {
			o.getExprs().add(_exprs.get(i));
		}
		o.setExFunc(_exFunc);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_externalCall) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
	// Operator val
	public static IndexExpression val(AffineFunction _function) {
		IndexExpression o = expressionFactory.createIndexExpression();
		o.setFunction(_function);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_class_op_val) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
		
		
	
	/*
	* Default TOM Operators for polyhedralIR mapping. Each class that has a terminal type has also a default factory function.
	*/
	
	public static ExternalFunctionDeclaration externalFunctionDeclaration(String _name) {
		ExternalFunctionDeclaration o = polyhedralIRFactory.createExternalFunctionDeclaration();
		o.setName(_name);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_default_op_ExternalFunctionDeclaration) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	public static VariableIdentifier variableIdentifier(String _name) {
		VariableIdentifier o = polyhedralIRFactory.createVariableIdentifier();
		o.setName(_name);
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_default_op_VariableIdentifier) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	public static Domain domain() {
		Domain o = polyhedralIRFactory.createDomain();
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_default_op_Domain) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	public static ParameterDomain parameterDomain() {
		ParameterDomain o = polyhedralIRFactory.createParameterDomain();
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_default_op_ParameterDomain) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	public static AffineFunction affineFunction() {
		AffineFunction o = polyhedralIRFactory.createAffineFunction();
		
		/* PROTECTED REGION ID(polyhedralIR_user_factory_default_op_AffineFunction) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	
	/* PROTECTED REGION ID(polyhedralIR_mapping_user_custom_methodspolyhedralIR) ENABLED START */
	
	/*
	* Custom factory functions that won't be removed at regeneration of mapping code
	*/
	
	/* PROTECTED REGION END */
}