package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLASTLiteral_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLASTLiteral extends JNIISLASTExpression {
	
	
	/* @generated */
	protected JNIISLASTLiteral(long ptr) {
		/*** PROTECTED REGION ID(ISLASTLiteral_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
		public Object accept(IISLASTExpressionVisitor visitor, Object arg) {
			return visitor.visitJNIISLASTLiteral(this, arg);
		}
	
	
	/*** PROTECTED REGION ID(ISLASTLiteral_userCode) ENABLED START ***/
	public long getValue() {
		return getValueAsVal().asLong();
	}
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
	 * isl_ast_expr_get_val 
	 * 
	 * @generated
	**/
	public JNIISLVal getValueAsVal() {
		/*** PROTECTED REGION ID(isl_ast_expr_get_val) DISABLED START ***/
		JNIISLVal res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLVal.build(ISLNative.isl_ast_expr_get_val(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLASTLiteral_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
