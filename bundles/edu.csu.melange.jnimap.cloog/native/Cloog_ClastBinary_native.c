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

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1binary_1get_1type
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_binary_type_getter) DISABLED START */
	struct clast_binary* stPtr = (struct clast_binary *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getType");
	return (jint) GECOS_PTRSIZE stPtr->type;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_binary_1set_1type
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(clast_binary_type_setter) DISABLED START */
	struct clast_binary* stPtr = (struct clast_binary *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setType");
	stPtr->type= (enum clast_bin_type) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1binary_1test_1type
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_binary_type_tester) DISABLED START */
	struct clast_binary* stPtr = (struct clast_binary *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getType");
	return (GECOS_PTRSIZE stPtr->type) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1binary_1get_1LHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_binary_LHS_getter) DISABLED START */
	struct clast_binary* stPtr = (struct clast_binary *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLHS");
	return (jlong) GECOS_PTRSIZE stPtr->LHS;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_binary_1set_1LHS
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_binary_LHS_setter) DISABLED START */
	struct clast_binary* stPtr = (struct clast_binary *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setLHS");
	stPtr->LHS= (struct clast_expr*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1binary_1test_1LHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_binary_LHS_tester) DISABLED START */
	struct clast_binary* stPtr = (struct clast_binary *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLHS");
	return (GECOS_PTRSIZE stPtr->LHS) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1expr_1binary
(JNIEnv *env, jclass class, jlong exp)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_expr_binary\n");fflush(stdout);
#endif
	struct clast_expr* exp_c = (struct clast_expr*) GECOS_PTRSIZE exp; 
	if(((void*)exp_c)==NULL) {
		throwException(env, "Null pointer in is_clast_expr_binary for parameter exp");
		goto error;
	}

	int res = (int) is_clast_expr_binary(exp_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_expr_binary\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1binary_1get_1value
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering clast_binary_get_value\n");fflush(stdout);
#endif
	struct clast_binary* stmt_c = (struct clast_binary*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_binary_get_value for parameter stmt");
		goto error;
	}

	int res = (int) clast_binary_get_value(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving clast_binary_get_value\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


