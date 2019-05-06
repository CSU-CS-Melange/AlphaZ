package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLPWMultiAffPiece_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLPWMultiAffPiece extends JNIObject {
	
	
	/* @generated */
	protected JNIISLPWMultiAffPiece(long ptr) {
		/*** PROTECTED REGION ID(ISLPWMultiAffPiece_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
	/* @generated */
	static JNIISLPWMultiAffPiece build(long ptr) {
		{
			return new JNIISLPWMultiAffPiece(ptr);
		}
	}
	
	
	
	
	/*** PROTECTED REGION ID(ISLPWMultiAffPiece_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/
	/*************************************************************
	 *	set : JNIISLSet
	 *************************************************************/
	public JNIISLSet getSet() {
		return JNIISLSet.build(ISLNative.isl_pw_multi_aff_piece_get_set(getNativePtr(this)));
	}
	/*************************************************************
	 *	set : JNIISLSet
	 *************************************************************/
	public void setSet(JNIISLSet object) {
		ISLNative.isl_pw_multi_aff_piece_set_set(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if Tset is NULL
	 *************************************************************/
	public boolean testSet() {
		return ISLNative.isl_pw_multi_aff_piece_test_set(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	maff : JNIISLMultiAff
	 *************************************************************/
	public JNIISLMultiAff getMaff() {
		return JNIISLMultiAff.build(ISLNative.isl_pw_multi_aff_piece_get_maff(getNativePtr(this)));
	}
	/*************************************************************
	 *	maff : JNIISLMultiAff
	 *************************************************************/
	public void setMaff(JNIISLMultiAff object) {
		ISLNative.isl_pw_multi_aff_piece_set_maff(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if Tmaff is NULL
	 *************************************************************/
	public boolean testMaff() {
		return ISLNative.isl_pw_multi_aff_piece_test_maff(getNativePtr(this)) != 0;
	}

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	/**
	 * isl_pw_multi_aff_piece_free 
	 * 
	 * @take this
	 * @generated
	**/
	public void free() {
		/*** PROTECTED REGION ID(isl_pw_multi_aff_piece_free) DISABLED START ***/
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				ISLNative.isl_pw_multi_aff_piece_free(getNativePtr(this));
			} finally {
				taken(this);
			}
		}
		
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLPWMultiAffPiece_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
