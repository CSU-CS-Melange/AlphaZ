package fr.irisa.cairn.jnimap.cloog.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ClastName_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIClastName extends JNIClastExpr {
	
	
	/* @generated */
	protected JNIClastName(long ptr) {
		/*** PROTECTED REGION ID(ClastName_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
		public Object accept(IClastExprVisitor visitor, Object arg) {
			return visitor.visitJNIClastName(this, arg);
		}
	
	
	/*** PROTECTED REGION ID(ClastName_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/
	/*************************************************************
	 *	name : String
	 *************************************************************/
	public String getName() {
		return CloogNative.clast_name_get_name(getNativePtr(this));
	}
	/*************************************************************
	 *	name : String
	 *************************************************************/
	public void setName(String object) {
		CloogNative.clast_name_set_name(getNativePtr(this), object);
	}
	/*************************************************************
	 * Test if Tname is NULL
	 *************************************************************/
	public boolean testName() {
		return CloogNative.clast_name_test_name(getNativePtr(this)) != 0;
	}

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	
	public String toString() {
		/*** PROTECTED REGION ID(ClastName_toString) DISABLED START ***/
			return CloogPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
