package fr.irisa.cairn.jnimap.cloog.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(CloogState_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNICloogState extends JNIObject {
	
	
	/* @generated */
	protected JNICloogState(long ptr) {
		/*** PROTECTED REGION ID(CloogState_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
	/* @generated */
	static JNICloogState build(long ptr) {
		{
			return new JNICloogState(ptr);
		}
	}
	
	
	
	
	/*** PROTECTED REGION ID(CloogState_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	/**
	 * cloog_state_malloc 
	 * 
	 * @generated
	**/
	 public static JNICloogState malloc() { 
		/*** PROTECTED REGION ID(static_cloog_state_malloc) DISABLED START ***/
		JNICloogState res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNICloogState.build(CloogNative.cloog_state_malloc());
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	
	public String toString() {
		/*** PROTECTED REGION ID(CloogState_toString) DISABLED START ***/
			return CloogPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
