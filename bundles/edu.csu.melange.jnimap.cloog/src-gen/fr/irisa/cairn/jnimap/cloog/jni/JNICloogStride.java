

package fr.irisa.cairn.jnimap.cloog.jni;

import java.util.HashMap;
import java.util.Map;

import fr.irisa.cairn.jnimap.runtime.JNIObject;

/***PROTECTED REGION ID(CloogStrideuserImport) ENABLED START***/
/*
	Put you custom import here ....
*/	
/***PROTECTED REGION END***/


/**
 *  Automatically generated by jnimap 
 * @generated
 */
 
public class JNICloogStride extends  JNIObject  {

	
	/* @generated */
	protected JNICloogStride(long ptr) {
	/***PROTECTED REGION ID(CloogStrideConstructor) ENABLED START***/
		super(ptr);
	/***PROTECTED REGION END***/
	}
	
	 

	/* @generated */
	static Map<Long,JNICloogStride> CloogStrideliveMap;

	/* @generated */
	public static JNICloogStride build(long ptr) {
	
		if(CloogStrideliveMap==null) {
			CloogStrideliveMap= new HashMap<Long,JNICloogStride>();
		} 
		
		if (!CloogStrideliveMap.containsKey((long) ptr)) {
		/***PROTECTED REGION ID(CloogStrideBuilder) ENABLED START***/
			JNICloogStride res = new JNICloogStride(ptr);
			CloogStrideliveMap.put(ptr,res);
			return res;
		/***PROTECTED REGION END***/
		} else {
			return CloogStrideliveMap.get((long) ptr);
		}
		
	}
	
	
	
	
		
	/***PROTECTED REGION ID(CloogStride-userCode) ENABLED START***/
	//	Put you user code here !
		
		
	/***PROTECTED REGION END***/

	
	
	
	/* 
	
		Constructors 
	
	*/ 
	
	
	
	/* 
	
		Finalizer 
	
	*/ 
	
	

	

	/* 
	
		Standard methods 
	
	*/ 
	
	
	
		
	public String toString() {
	/***PROTECTED REGION ID(CloogStridetoString) ENABLED START***/
			return CloogPrettyPrinter.asString(this);
	/***PROTECTED REGION END***/
	}
}
