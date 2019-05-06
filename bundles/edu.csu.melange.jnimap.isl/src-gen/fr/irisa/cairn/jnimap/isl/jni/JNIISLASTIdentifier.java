package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLASTIdentifier_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLASTIdentifier extends JNIISLASTExpression {
	
	
	/* @generated */
	protected JNIISLASTIdentifier(long ptr) {
		/*** PROTECTED REGION ID(ISLASTIdentifier_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
		public Object accept(IISLASTExpressionVisitor visitor, Object arg) {
			return visitor.visitJNIISLASTIdentifier(this, arg);
		}
	
	
	/*** PROTECTED REGION ID(ISLASTIdentifier_userCode) ENABLED START ***/
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
	 * isl_ast_expr_get_id 
	 * 
	 * @generated
	**/
	public JNIISLIdentifier getID() {
		/*** PROTECTED REGION ID(isl_ast_expr_get_id) DISABLED START ***/
		JNIISLIdentifier res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLIdentifier.build(ISLNative.isl_ast_expr_get_id(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLASTIdentifier_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}