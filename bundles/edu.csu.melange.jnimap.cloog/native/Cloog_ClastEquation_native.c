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

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1equation_1get_1LHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_equation_LHS_getter) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLHS");
	return (jlong) GECOS_PTRSIZE stPtr->LHS;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_equation_1set_1LHS
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_equation_LHS_setter) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setLHS");
	stPtr->LHS= (struct clast_expr*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1equation_1test_1LHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_equation_LHS_tester) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLHS");
	return (GECOS_PTRSIZE stPtr->LHS) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1equation_1get_1RHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_equation_RHS_getter) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getRHS");
	return (jlong) GECOS_PTRSIZE stPtr->RHS;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_equation_1set_1RHS
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_equation_RHS_setter) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setRHS");
	stPtr->RHS= (struct clast_expr*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1equation_1test_1RHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_equation_RHS_tester) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getRHS");
	return (GECOS_PTRSIZE stPtr->RHS) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1equation_1get_1sign
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_equation_sign_getter) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSign");
	return (jint) GECOS_PTRSIZE stPtr->sign;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_equation_1set_1sign
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(clast_equation_sign_setter) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setSign");
	stPtr->sign= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1equation_1test_1sign
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_equation_sign_tester) DISABLED START */
	struct clast_equation* stPtr = (struct clast_equation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSign");
	return (GECOS_PTRSIZE stPtr->sign) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}




