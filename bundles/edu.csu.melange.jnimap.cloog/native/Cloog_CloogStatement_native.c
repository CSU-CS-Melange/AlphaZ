#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <cloog/cloog.h>
#include <isl/ctx.h>

#include "CloogUser_addons.h"

#include "fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h"

extern void throwException(JNIEnv * env, char* msg);
extern jobject createInteger(JNIEnv * env, int value);
extern jint getIntegerValue(JNIEnv * env, jobject obj);

JNIEXPORT jstring JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogstatement_1get_1name
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogstatement_name_getter) DISABLED START */
	struct cloogstatement* stPtr = (struct cloogstatement *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getName");
	return (*env)->NewStringUTF(env, stPtr->name);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogstatement_1set_1name
	(JNIEnv *env, jclass class, jlong ptr, jstring value) {
	/* PROTECTED REGION ID(cloogstatement_name_setter) DISABLED START */
	struct cloogstatement* stPtr = (struct cloogstatement *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setName");
	char* str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, value, NULL);
	strcpy(str_c, stPtr->name);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogstatement_1test_1name
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogstatement_name_tester) DISABLED START */
	struct cloogstatement* stPtr = (struct cloogstatement *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getName");
	return (GECOS_PTRSIZE stPtr->name) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogstatement_1get_1number
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogstatement_number_getter) DISABLED START */
	struct cloogstatement* stPtr = (struct cloogstatement *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNumber");
	return (jint) GECOS_PTRSIZE stPtr->number;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogstatement_1set_1number
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogstatement_number_setter) DISABLED START */
	struct cloogstatement* stPtr = (struct cloogstatement *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNumber");
	stPtr->number= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogstatement_1test_1number
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogstatement_number_tester) DISABLED START */
	struct cloogstatement* stPtr = (struct cloogstatement *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNumber");
	return (GECOS_PTRSIZE stPtr->number) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}




