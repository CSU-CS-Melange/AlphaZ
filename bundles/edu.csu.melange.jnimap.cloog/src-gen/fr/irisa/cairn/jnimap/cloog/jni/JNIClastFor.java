package fr.irisa.cairn.jnimap.cloog.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ClastFor_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIClastFor extends JNIClastStmt {
	
	
	/* @generated */
	protected JNIClastFor(long ptr) {
		/*** PROTECTED REGION ID(ClastFor_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
		public Object accept(IClastStmtVisitor visitor, Object arg) {
			return visitor.visitJNIClastFor(this, arg);
		}
	
	
	/*** PROTECTED REGION ID(ClastFor_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/
	/*************************************************************
	 *	iterator : String
	 *************************************************************/
	public String getIterator() {
		return CloogNative.clast_for_get_iterator(getNativePtr(this));
	}
	/*************************************************************
	 *	iterator : String
	 *************************************************************/
	public void setIterator(String object) {
		CloogNative.clast_for_set_iterator(getNativePtr(this), object);
	}
	/*************************************************************
	 * Test if Titerator is NULL
	 *************************************************************/
	public boolean testIterator() {
		return CloogNative.clast_for_test_iterator(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	LB : JNIClastExpr
	 *************************************************************/
	public JNIClastExpr getLB() {
		return JNIClastExpr.build(CloogNative.clast_for_get_LB(getNativePtr(this)));
	}
	/*************************************************************
	 *	LB : JNIClastExpr
	 *************************************************************/
	public void setLB(JNIClastExpr object) {
		CloogNative.clast_for_set_LB(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if TLB is NULL
	 *************************************************************/
	public boolean testLB() {
		return CloogNative.clast_for_test_LB(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	UB : JNIClastExpr
	 *************************************************************/
	public JNIClastExpr getUB() {
		return JNIClastExpr.build(CloogNative.clast_for_get_UB(getNativePtr(this)));
	}
	/*************************************************************
	 *	UB : JNIClastExpr
	 *************************************************************/
	public void setUB(JNIClastExpr object) {
		CloogNative.clast_for_set_UB(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if TUB is NULL
	 *************************************************************/
	public boolean testUB() {
		return CloogNative.clast_for_test_UB(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	body : JNIClastStmt
	 *************************************************************/
	public JNIClastStmt getBody() {
		return JNIClastStmt.build(CloogNative.clast_for_get_body(getNativePtr(this)));
	}
	/*************************************************************
	 *	body : JNIClastStmt
	 *************************************************************/
	public void setBody(JNIClastStmt object) {
		CloogNative.clast_for_set_body(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if Tbody is NULL
	 *************************************************************/
	public boolean testBody() {
		return CloogNative.clast_for_test_body(getNativePtr(this)) != 0;
	}

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	/**
	 * clast_for_get_cloog_domain 
	 * 
	 * @generated
	**/
	public String getCloogDomain() {
		/*** PROTECTED REGION ID(clast_for_get_cloog_domain) DISABLED START ***/
		String res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = CloogNative.clast_for_get_cloog_domain(getNativePtr(this));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * clast_for_get_stride 
	 * 
	 * @generated
	**/
	public int getStride() {
		/*** PROTECTED REGION ID(clast_for_get_stride) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = CloogNative.clast_for_get_stride(getNativePtr(this));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ClastFor_toString) DISABLED START ***/
			return CloogPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
