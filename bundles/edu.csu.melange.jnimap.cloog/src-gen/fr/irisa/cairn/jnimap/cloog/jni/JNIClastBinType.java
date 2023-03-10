package fr.irisa.cairn.jnimap.cloog.jni;

import java.util.HashMap;
import java.util.Map;

/*** PROTECTED REGION ID(ClastBinType_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */

public class JNIClastBinType  {

	int value;
	String name;

	/*** PROTECTED REGION ID(ClastBinType_values) DISABLED START ***/
	public static final int CLAST_BIN_FDIV = 0;
	public static final int CLAST_BIN_CDIV = 1;
	public static final int CLAST_BIN_DIV = 2;
	public static final int CLAST_BIN_MOD = 3;
	/*** PROTECTED REGION END ***/
	
	public static JNIClastBinType clast_bin_fdiv = new JNIClastBinType("clast_bin_fdiv", CLAST_BIN_FDIV);
	public static JNIClastBinType clast_bin_cdiv = new JNIClastBinType("clast_bin_cdiv", CLAST_BIN_CDIV);
	public static JNIClastBinType clast_bin_div = new JNIClastBinType("clast_bin_div", CLAST_BIN_DIV);
	public static JNIClastBinType clast_bin_mod = new JNIClastBinType("clast_bin_mod", CLAST_BIN_MOD);
	
	public static JNIClastBinType build(long value) {
		return getFromInt((int) value) ;
	}
	
	
	public static  JNIClastBinType getFromInt(int value) {
		/*** PROTECTED REGION ID(ClastBinType_getValues) DISABLED START ***/
		switch(value) {
			case CLAST_BIN_FDIV:
			return clast_bin_fdiv;
			case CLAST_BIN_CDIV:
			return clast_bin_cdiv;
			case CLAST_BIN_DIV:
			return clast_bin_div;
			case CLAST_BIN_MOD:
			return clast_bin_mod;
				default :
					return null;
			}
		/*** PROTECTED REGION END ***/
	}

	private JNIClastBinType(String name, int value) {
		this.value=value;
		this.name=name;
	}
	
	public int getValue() {
		return this.value;
	}

	public String getName() {
		return this.name;
	}
	
}
