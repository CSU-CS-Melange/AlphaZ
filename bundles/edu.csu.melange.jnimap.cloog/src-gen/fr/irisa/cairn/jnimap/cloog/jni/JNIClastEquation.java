package fr.irisa.cairn.jnimap.cloog.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ClastEquation_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIClastEquation extends JNIObject {
	
	
	/* @generated */
	protected JNIClastEquation(long ptr) {
		/*** PROTECTED REGION ID(ClastEquation_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
	/* @generated */
	static JNIClastEquation build(long ptr) {
		{
			return new JNIClastEquation(ptr);
		}
	}
	
	
	
	
	/*** PROTECTED REGION ID(ClastEquation_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/
	/*************************************************************
	 *	LHS : JNIClastExpr
	 *************************************************************/
	public JNIClastExpr getLHS() {
		return JNIClastExpr.build(CloogNative.clast_equation_get_LHS(getNativePtr(this)));
	}
	/*************************************************************
	 *	LHS : JNIClastExpr
	 *************************************************************/
	public void setLHS(JNIClastExpr object) {
		CloogNative.clast_equation_set_LHS(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if TLHS is NULL
	 *************************************************************/
	public boolean testLHS() {
		return CloogNative.clast_equation_test_LHS(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	RHS : JNIClastExpr
	 *************************************************************/
	public JNIClastExpr getRHS() {
		return JNIClastExpr.build(CloogNative.clast_equation_get_RHS(getNativePtr(this)));
	}
	/*************************************************************
	 *	RHS : JNIClastExpr
	 *************************************************************/
	public void setRHS(JNIClastExpr object) {
		CloogNative.clast_equation_set_RHS(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if TRHS is NULL
	 *************************************************************/
	public boolean testRHS() {
		return CloogNative.clast_equation_test_RHS(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	sign : int
	 *************************************************************/
	public int getSign() {
		return CloogNative.clast_equation_get_sign(getNativePtr(this));
	}
	/*************************************************************
	 *	sign : int
	 *************************************************************/
	public void setSign(int object) {
		CloogNative.clast_equation_set_sign(getNativePtr(this), object);
	}
	/*************************************************************
	 * Test if Tsign is NULL
	 *************************************************************/
	public boolean testSign() {
		return CloogNative.clast_equation_test_sign(getNativePtr(this)) != 0;
	}

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	
	public String toString() {
		/*** PROTECTED REGION ID(ClastEquation_toString) DISABLED START ***/
			return CloogPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
