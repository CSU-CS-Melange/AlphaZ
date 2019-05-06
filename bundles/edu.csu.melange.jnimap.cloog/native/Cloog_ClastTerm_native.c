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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1term_1get_1var
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_term_var_getter) DISABLED START */
	struct clast_term* stPtr = (struct clast_term *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getVar");
	return (jlong) GECOS_PTRSIZE stPtr->var;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_term_1set_1var
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_term_var_setter) DISABLED START */
	struct clast_term* stPtr = (struct clast_term *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setVar");
	stPtr->var= (struct clast_expr*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1term_1test_1var
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_term_var_tester) DISABLED START */
	struct clast_term* stPtr = (struct clast_term *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getVar");
	return (GECOS_PTRSIZE stPtr->var) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1expr_1term
(JNIEnv *env, jclass class, jlong exp)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_expr_term\n");fflush(stdout);
#endif
	struct clast_expr* exp_c = (struct clast_expr*) GECOS_PTRSIZE exp; 
	if(((void*)exp_c)==NULL) {
		throwException(env, "Null pointer in is_clast_expr_term for parameter exp");
		goto error;
	}

	int res = (int) is_clast_expr_term(exp_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_expr_term\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1term_1get_1value
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering clast_term_get_value\n");fflush(stdout);
#endif
	struct clast_term* stmt_c = (struct clast_term*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_term_get_value for parameter stmt");
		goto error;
	}

	int res = (int) clast_term_get_value(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving clast_term_get_value\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


