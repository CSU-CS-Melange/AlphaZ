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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1reduction_1get_1type
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_reduction_type_getter) DISABLED START */
	struct clast_reduction* stPtr = (struct clast_reduction *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getType");
	return (jint) GECOS_PTRSIZE stPtr->type;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_reduction_1set_1type
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(clast_reduction_type_setter) DISABLED START */
	struct clast_reduction* stPtr = (struct clast_reduction *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setType");
	stPtr->type= (enum clast_red_type) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1reduction_1test_1type
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_reduction_type_tester) DISABLED START */
	struct clast_reduction* stPtr = (struct clast_reduction *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getType");
	return (GECOS_PTRSIZE stPtr->type) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1reduction_1get_1n
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_reduction_n_getter) DISABLED START */
	struct clast_reduction* stPtr = (struct clast_reduction *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getN");
	return (jint) GECOS_PTRSIZE stPtr->n;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_reduction_1set_1n
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(clast_reduction_n_setter) DISABLED START */
	struct clast_reduction* stPtr = (struct clast_reduction *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setN");
	stPtr->n= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1reduction_1test_1n
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_reduction_n_tester) DISABLED START */
	struct clast_reduction* stPtr = (struct clast_reduction *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getN");
	return (GECOS_PTRSIZE stPtr->n) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1expr_1reduction
(JNIEnv *env, jclass class, jlong exp)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_expr_reduction\n");fflush(stdout);
#endif
	struct clast_expr* exp_c = (struct clast_expr*) GECOS_PTRSIZE exp; 
	if(((void*)exp_c)==NULL) {
		throwException(env, "Null pointer in is_clast_expr_reduction for parameter exp");
		goto error;
	}

	int res = (int) is_clast_expr_reduction(exp_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_expr_reduction\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1reduction_1get_1element
(JNIEnv *env, jclass class, jlong stmt, jint offset)
 {
#ifdef TRACE_ALL
	printf("Entering clast_reduction_get_element\n");fflush(stdout);
#endif
	struct clast_reduction* stmt_c = (struct clast_reduction*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_reduction_get_element for parameter stmt");
		goto error;
	}
	int offset_c = (int) offset;

	struct clast_expr* res = (struct clast_expr*) clast_reduction_get_element(stmt_c, offset_c);


#ifdef TRACE_ALL
	printf("Leaving clast_reduction_get_element\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1reduction_1get_1number_1of_1elements
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering clast_reduction_get_number_of_elements\n");fflush(stdout);
#endif
	struct clast_reduction* stmt_c = (struct clast_reduction*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_reduction_get_number_of_elements for parameter stmt");
		goto error;
	}

	int res = (int) clast_reduction_get_number_of_elements(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving clast_reduction_get_number_of_elements\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


