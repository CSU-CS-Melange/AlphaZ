#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <cloog/cloog.h>
#include <isl/ctx.h>

#include "fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h"

/**
 *  Automatically generated by jnimap 
 */

void throwException(JNIEnv * env, char* msg) {
	jclass newExcCls;
	(*env)->ExceptionDescribe(env);
	(*env)->ExceptionClear(env);
	newExcCls = (*env)->FindClass(env,"fr/irisa/cairn/jnimap/cloog/jni/CloogException");
	if (newExcCls == NULL) {
		/* Unable to find the exception class, give up. */
		return;
	}
	(*env)->ThrowNew(env, newExcCls, msg);
}

jobject createInteger(JNIEnv * env, int value) {
	// Create a object of type Integer
	jclass cls = (*env)->FindClass(env, "java/lang/Integer");
	jmethodID constructorId = (*env)->GetMethodID(env, cls, "<init>", "(I)V");
	jobject o = (*env)->NewObject(env, cls, constructorId, value);
	return o;
}

jint getIntegerValue(JNIEnv * env, jobject obj) {
	jclass cls = (*env)->FindClass(env, "java/lang/Integer");
	jmethodID intValueMethodId = (*env)->GetMethodID(env, cls, "intValue", "()I");
	long val = (*env)->CallIntMethod(env, obj, intValueMethodId);
	return (jint) val;
}

JNIEXPORT jboolean JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1null(JNIEnv * env, jlong ptr) {
	if(ptr==(GECOS_PTRSIZE NULL))
		return JNI_TRUE ;
	else
    	return JNI_FALSE;
}


JNIEXPORT jlong JNICALL
		Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_derefPointer(JNIEnv * env, jclass class, jlong ptr) {
		jlong* jniptr= (jlong*) GECOS_PTRSIZE ptr;
		if(jniptr==NULL) throwException(env, "NPE  in pointerDeref");
		return *jniptr;
}