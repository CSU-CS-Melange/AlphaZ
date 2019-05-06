package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLASTNode_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLASTNode extends JNIObject {
	
	
	/* @generated */
	protected JNIISLASTNode(long ptr) {
		/*** PROTECTED REGION ID(ISLASTNode_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
	/* @generated */
	static JNIISLASTNode build(long ptr) {
		if (isJNIISLASTBlockNode(ptr)) {
			return new JNIISLASTBlockNode(ptr);
		} else 
		if (isJNIISLASTForNode(ptr)) {
			return new JNIISLASTForNode(ptr);
		} else 
		if (isJNIISLASTIfNode(ptr)) {
			return new JNIISLASTIfNode(ptr);
		} else 
		if (isJNIISLASTUnscannedNode(ptr)) {
			return new JNIISLASTUnscannedNode(ptr);
		} else 
		if (isJNIISLASTUserNode(ptr)) {
			return new JNIISLASTUserNode(ptr);
		} else 
		{
			return new JNIISLASTNode(ptr);
		}
	}
	
	/* @generated */
	private static boolean isJNIISLASTBlockNode(long ptr) {
		if (ISLNative.isl_ast_node_is_block(ptr) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/* @generated */
	public boolean isJNIISLASTBlockNode() {
		return isJNIISLASTBlockNode(getNativePtr(this));
	}
	
	/* @generated */
	private static boolean isJNIISLASTForNode(long ptr) {
		if (ISLNative.isl_ast_node_is_for(ptr) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/* @generated */
	public boolean isJNIISLASTForNode() {
		return isJNIISLASTForNode(getNativePtr(this));
	}
	
	/* @generated */
	private static boolean isJNIISLASTIfNode(long ptr) {
		if (ISLNative.isl_ast_node_is_if(ptr) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/* @generated */
	public boolean isJNIISLASTIfNode() {
		return isJNIISLASTIfNode(getNativePtr(this));
	}
	
	/* @generated */
	private static boolean isJNIISLASTUnscannedNode(long ptr) {
		if (ISLNative.isl_ast_node_is_unscanned(ptr) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/* @generated */
	public boolean isJNIISLASTUnscannedNode() {
		return isJNIISLASTUnscannedNode(getNativePtr(this));
	}
	
	/* @generated */
	private static boolean isJNIISLASTUserNode(long ptr) {
		if (ISLNative.isl_ast_node_is_user(ptr) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/* @generated */
	public boolean isJNIISLASTUserNode() {
		return isJNIISLASTUserNode(getNativePtr(this));
	}
	
	
	public Object accept(IISLASTNodeVisitor visitor, Object arg) {
		return visitor.visitJNIISLASTNode(this, arg);
	}
	
	
	/*** PROTECTED REGION ID(ISLASTNode_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	/**
	 * isl_ast_build_ast_from_schedule 
	 * 
	@take schedule
	 * @generated
	**/
	 public static JNIISLASTNode buildFromSchedule(JNIISLASTBuild build, JNIISLUnionMap schedule) { 
		/*** PROTECTED REGION ID(static_isl_ast_build_ast_from_schedule) DISABLED START ***/
		JNIISLASTNode res;
		
		synchronized(LOCK) {
			checkParameters(schedule);
			try {
				res = JNIISLASTNode.build(ISLNative.isl_ast_build_ast_from_schedule(getNativePtr(build), getNativePtr(schedule)));
			} finally {
				taken(schedule);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_to_string 
	 * 
	 * @generated
	**/
	 public static String _toString(JNIISLASTNode node) { 
		/*** PROTECTED REGION ID(static_isl_ast_node_to_string) DISABLED START ***/
		String res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_ast_node_to_string(getNativePtr(node));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	/**
	 * isl_ast_node_get_ctx 
	 * 
	 * @generated
	**/
	public JNIISLContext getContext() {
		/*** PROTECTED REGION ID(isl_ast_node_get_ctx) DISABLED START ***/
		JNIISLContext res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLContext.build(ISLNative.isl_ast_node_get_ctx(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_copy 
	 * 
	 * @generated
	**/
	public JNIISLASTNode copy() {
		/*** PROTECTED REGION ID(isl_ast_node_copy) DISABLED START ***/
		JNIISLASTNode res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLASTNode.build(ISLNative.isl_ast_node_copy(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_free 
	 * 
	 * @take this
	 * @generated
	**/
	public void free() {
		/*** PROTECTED REGION ID(isl_ast_node_free) DISABLED START ***/
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				ISLNative.isl_ast_node_free(getNativePtr(this));
			} finally {
				taken(this);
			}
		}
		
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_get_type 
	 * 
	 * @generated
	**/
	public JNIISLAstNodeType getType() {
		/*** PROTECTED REGION ID(isl_ast_node_get_type) DISABLED START ***/
		JNIISLAstNodeType res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLAstNodeType.build(ISLNative.isl_ast_node_get_type(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_set_annotation 
	 * 
	 * @generated
	**/
	public JNIISLASTNode setAnnotation(JNIISLIdentifier annotation) {
		/*** PROTECTED REGION ID(isl_ast_node_set_annotation) DISABLED START ***/
		JNIISLASTNode res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLASTNode.build(ISLNative.isl_ast_node_set_annotation(getNativePtr(this), getNativePtr(annotation)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_node_get_annotation 
	 * 
	 * @generated
	**/
	public JNIISLIdentifier getAnnotation() {
		/*** PROTECTED REGION ID(isl_ast_node_get_annotation) DISABLED START ***/
		JNIISLIdentifier res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLIdentifier.build(ISLNative.isl_ast_node_get_annotation(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLASTNode_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}