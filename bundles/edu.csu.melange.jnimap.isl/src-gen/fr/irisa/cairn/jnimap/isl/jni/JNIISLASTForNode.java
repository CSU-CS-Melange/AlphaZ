package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLASTForNode_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLASTForNode extends JNIISLASTNode {
	
	
	/* @generated */
	protected JNIISLASTForNode(long ptr) {
		/*** PROTECTED REGION ID(ISLASTForNode_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
		public Object accept(IISLASTNodeVisitor visitor, Object arg) {
			return visitor.visitJNIISLASTForNode(this, arg);
		}
	
	
	/*** PROTECTED REGION ID(ISLASTForNode_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	/**
	 * isl_ast_node_for_get_iterator 
	 * 
	 * @generated
	**/
	public JNIISLASTExpression getIterator() {
		/*** PROTECTED REGION ID(isl_ast_node_for_get_iterator) DISABLED START ***/
		JNIISLASTExpression res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLASTExpression.build(ISLNative.isl_ast_node_for_get_iterator(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_for_get_init 
	 * 
	 * @generated
	**/
	public JNIISLASTExpression getInit() {
		/*** PROTECTED REGION ID(isl_ast_node_for_get_init) DISABLED START ***/
		JNIISLASTExpression res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLASTExpression.build(ISLNative.isl_ast_node_for_get_init(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_for_get_cond 
	 * 
	 * @generated
	**/
	public JNIISLASTExpression getCond() {
		/*** PROTECTED REGION ID(isl_ast_node_for_get_cond) DISABLED START ***/
		JNIISLASTExpression res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLASTExpression.build(ISLNative.isl_ast_node_for_get_cond(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_for_get_inc 
	 * 
	 * @generated
	**/
	public JNIISLASTExpression getInc() {
		/*** PROTECTED REGION ID(isl_ast_node_for_get_inc) DISABLED START ***/
		JNIISLASTExpression res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLASTExpression.build(ISLNative.isl_ast_node_for_get_inc(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_for_get_body 
	 * 
	 * @generated
	**/
	public JNIISLASTNode getBody() {
		/*** PROTECTED REGION ID(isl_ast_node_for_get_body) DISABLED START ***/
		JNIISLASTNode res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLASTNode.build(ISLNative.isl_ast_node_for_get_body(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_for_is_degenerate 
	 * 
	 * @generated
	**/
	public boolean isDegenerate() {
		/*** PROTECTED REGION ID(isl_ast_node_for_is_degenerate) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_ast_node_for_is_degenerate(getNativePtr(this)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLASTForNode_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
