package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLQPolynomialFoldPiece_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLQPolynomialFoldPiece extends JNIObject {
	
	
	/* @generated */
	protected JNIISLQPolynomialFoldPiece(long ptr) {
		/*** PROTECTED REGION ID(ISLQPolynomialFoldPiece_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
	/* @generated */
	static JNIISLQPolynomialFoldPiece build(long ptr) {
		{
			return new JNIISLQPolynomialFoldPiece(ptr);
		}
	}
	
	
	
	
	/*** PROTECTED REGION ID(ISLQPolynomialFoldPiece_userCode) ENABLED START ***/
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/
	/*************************************************************
	 *	set : JNIISLSet
	 *************************************************************/
	public JNIISLSet getSet() {
		return JNIISLSet.build(ISLNative.isl_qpolynomial_fold_piece_get_set(getNativePtr(this)));
	}
	/*************************************************************
	 *	set : JNIISLSet
	 *************************************************************/
	public void setSet(JNIISLSet object) {
		ISLNative.isl_qpolynomial_fold_piece_set_set(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if Tset is NULL
	 *************************************************************/
	public boolean testSet() {
		return ISLNative.isl_qpolynomial_fold_piece_test_set(getNativePtr(this)) != 0;
	}
	/*************************************************************
	 *	fold : JNIISLQPolynomialFold
	 *************************************************************/
	public JNIISLQPolynomialFold getFold() {
		return JNIISLQPolynomialFold.build(ISLNative.isl_qpolynomial_fold_piece_get_fold(getNativePtr(this)));
	}
	/*************************************************************
	 *	fold : JNIISLQPolynomialFold
	 *************************************************************/
	public void setFold(JNIISLQPolynomialFold object) {
		ISLNative.isl_qpolynomial_fold_piece_set_fold(getNativePtr(this), getNativePtr(object));
	}
	/*************************************************************
	 * Test if Tfold is NULL
	 *************************************************************/
	public boolean testFold() {
		return ISLNative.isl_qpolynomial_fold_piece_test_fold(getNativePtr(this)) != 0;
	}

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	/**
	 * isl_qpolynomial_fold_piece_free 
	 * 
	 * @take this
	 * @generated
	**/
	public void free() {
		/*** PROTECTED REGION ID(isl_qpolynomial_fold_piece_free) DISABLED START ***/
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				ISLNative.isl_qpolynomial_fold_piece_free(getNativePtr(this));
			} finally {
				taken(this);
			}
		}
		
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLQPolynomialFoldPiece_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}