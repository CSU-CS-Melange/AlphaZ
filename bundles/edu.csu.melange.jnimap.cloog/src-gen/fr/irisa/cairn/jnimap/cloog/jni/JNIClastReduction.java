package fr.irisa.cairn.jnimap.cloog.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ClastReduction_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIClastReduction extends JNIClastExpr {
	
	
	/* @generated */
	protected JNIClastReduction(long ptr) {
		/*** PROTECTED REGION ID(ClastReduction_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
		public Object accept(IClastExprVisitor visitor, Object arg) {
			return visitor.visitJNIClastReduction(this, arg);
		}
	
	
	/*** PROTECTED REGION ID(ClastReduction_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/
	/*************************************************************
	 *	type : JNIClastRedType
	 *************************************************************/
	public JNIClastRedType getType() {
		return JNIClastRedType.getFromInt(CloogNative.clast_reduction_get_type(getNativePtr(this)));
	}
	/*************************************************************
	 *	type : JNIClastRedType
	 *************************************************************/
	public void setType(JNIClastRedType object) {
		CloogNative.clast_reduction_set_type(getNativePtr(this), object.getValue());
	}
	/*************************************************************
	 * Test if Ttype is NULL
	 *************************************************************/
	public boolean testType() {
		return CloogNative.clast_reduction_test_type(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	n : int
	 *************************************************************/
	public int getN() {
		return CloogNative.clast_reduction_get_n(getNativePtr(this));
	}
	/*************************************************************
	 *	n : int
	 *************************************************************/
	public void setN(int object) {
		CloogNative.clast_reduction_set_n(getNativePtr(this), object);
	}
	/*************************************************************
	 * Test if Tn is NULL
	 *************************************************************/
	public boolean testN() {
		return CloogNative.clast_reduction_test_n(getNativePtr(this)) != 0;
	}

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	/**
	 * clast_reduction_get_element 
	 * 
	 * @generated
	**/
	public JNIClastExpr getElement(int offset) {
		/*** PROTECTED REGION ID(clast_reduction_get_element) DISABLED START ***/
		JNIClastExpr res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIClastExpr.build(CloogNative.clast_reduction_get_element(getNativePtr(this), offset));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * clast_reduction_get_number_of_elements 
	 * 
	 * @generated
	**/
	public int getNumberOfElement() {
		/*** PROTECTED REGION ID(clast_reduction_get_number_of_elements) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = CloogNative.clast_reduction_get_number_of_elements(getNativePtr(this));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ClastReduction_toString) DISABLED START ***/
			return CloogPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
