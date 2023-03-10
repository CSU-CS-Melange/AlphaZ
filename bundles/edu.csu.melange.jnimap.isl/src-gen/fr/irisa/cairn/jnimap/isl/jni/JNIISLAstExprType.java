package fr.irisa.cairn.jnimap.isl.jni;

import java.util.HashMap;
import java.util.Map;

/*** PROTECTED REGION ID(ISLAstExprType_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */

public class JNIISLAstExprType  {

	int value;
	String name;

	/*** PROTECTED REGION ID(ISLAstExprType_values) DISABLED START ***/
	public static final int ISL_AST_EXPR_OP = 1;
	public static final int ISL_AST_EXPR_ID = 2;
	public static final int ISL_AST_EXPR_INT = 3;
	/*** PROTECTED REGION END ***/
	
	public static JNIISLAstExprType isl_ast_expr_op = new JNIISLAstExprType("isl_ast_expr_op", ISL_AST_EXPR_OP);
	public static JNIISLAstExprType isl_ast_expr_id = new JNIISLAstExprType("isl_ast_expr_id", ISL_AST_EXPR_ID);
	public static JNIISLAstExprType isl_ast_expr_int = new JNIISLAstExprType("isl_ast_expr_int", ISL_AST_EXPR_INT);
	
	public static JNIISLAstExprType build(long value) {
		return getFromInt((int) value) ;
	}
	
	
	public static  JNIISLAstExprType getFromInt(int value) {
		/*** PROTECTED REGION ID(ISLAstExprType_getValues) DISABLED START ***/
		switch(value) {
			case ISL_AST_EXPR_OP:
			return isl_ast_expr_op;
			case ISL_AST_EXPR_ID:
			return isl_ast_expr_id;
			case ISL_AST_EXPR_INT:
			return isl_ast_expr_int;
				default :
					return null;
			}
		/*** PROTECTED REGION END ***/
	}

	private JNIISLAstExprType(String name, int value) {
		this.value=value;
		this.name=name;
	}
	
	public int getValue() {
		return this.value;
	}

	public String getName() {
		return this.name;
	}
	
}
