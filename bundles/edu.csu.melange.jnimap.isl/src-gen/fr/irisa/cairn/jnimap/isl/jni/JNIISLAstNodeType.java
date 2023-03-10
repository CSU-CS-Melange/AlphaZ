package fr.irisa.cairn.jnimap.isl.jni;

import java.util.HashMap;
import java.util.Map;

/*** PROTECTED REGION ID(ISLAstNodeType_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */

public class JNIISLAstNodeType  {

	int value;
	String name;

	/*** PROTECTED REGION ID(ISLAstNodeType_values) DISABLED START ***/
	public static final int ISL_AST_NODE_FOR = 1;
	public static final int ISL_AST_NODE_IF = 2;
	public static final int ISL_AST_NODE_BLOCK = 3;
	public static final int ISL_AST_NODE_USER = 4;
	/*** PROTECTED REGION END ***/
	
	public static JNIISLAstNodeType isl_ast_node_for = new JNIISLAstNodeType("isl_ast_node_for", ISL_AST_NODE_FOR);
	public static JNIISLAstNodeType isl_ast_node_if = new JNIISLAstNodeType("isl_ast_node_if", ISL_AST_NODE_IF);
	public static JNIISLAstNodeType isl_ast_node_block = new JNIISLAstNodeType("isl_ast_node_block", ISL_AST_NODE_BLOCK);
	public static JNIISLAstNodeType isl_ast_node_user = new JNIISLAstNodeType("isl_ast_node_user", ISL_AST_NODE_USER);
	
	public static JNIISLAstNodeType build(long value) {
		return getFromInt((int) value) ;
	}
	
	
	public static  JNIISLAstNodeType getFromInt(int value) {
		/*** PROTECTED REGION ID(ISLAstNodeType_getValues) DISABLED START ***/
		switch(value) {
			case ISL_AST_NODE_FOR:
			return isl_ast_node_for;
			case ISL_AST_NODE_IF:
			return isl_ast_node_if;
			case ISL_AST_NODE_BLOCK:
			return isl_ast_node_block;
			case ISL_AST_NODE_USER:
			return isl_ast_node_user;
				default :
					return null;
			}
		/*** PROTECTED REGION END ***/
	}

	private JNIISLAstNodeType(String name, int value) {
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
