package fr.irisa.cairn.jnimap.cloog.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(CloogStatement_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNICloogStatement extends JNIObject {
	
	
	/* @generated */
	protected JNICloogStatement(long ptr) {
		/*** PROTECTED REGION ID(CloogStatement_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
	/* @generated */
	static JNICloogStatement build(long ptr) {
		{
			return new JNICloogStatement(ptr);
		}
	}
	
	
	
	
	/*** PROTECTED REGION ID(CloogStatement_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/
	/*************************************************************
	 *	name : String
	 *************************************************************/
	public String getName() {
		return CloogNative.cloogstatement_get_name(getNativePtr(this));
	}
	/*************************************************************
	 *	name : String
	 *************************************************************/
	public void setName(String object) {
		CloogNative.cloogstatement_set_name(getNativePtr(this), object);
	}
	/*************************************************************
	 * Test if Tname is NULL
	 *************************************************************/
	public boolean testName() {
		return CloogNative.cloogstatement_test_name(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	number : int
	 *************************************************************/
	public int getNumber() {
		return CloogNative.cloogstatement_get_number(getNativePtr(this));
	}
	/*************************************************************
	 *	number : int
	 *************************************************************/
	public void setNumber(int object) {
		CloogNative.cloogstatement_set_number(getNativePtr(this), object);
	}
	/*************************************************************
	 * Test if Tnumber is NULL
	 *************************************************************/
	public boolean testNumber() {
		return CloogNative.cloogstatement_test_number(getNativePtr(this)) != 0;
	}

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	
	public String toString() {
		/*** PROTECTED REGION ID(CloogStatement_toString) DISABLED START ***/
			return CloogPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
