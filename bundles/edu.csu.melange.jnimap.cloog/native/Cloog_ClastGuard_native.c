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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1guard_1get_1then
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_guard_then_getter) DISABLED START */
	struct clast_guard* stPtr = (struct clast_guard *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getThen");
	return (jlong) GECOS_PTRSIZE stPtr->then;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_guard_1set_1then
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_guard_then_setter) DISABLED START */
	struct clast_guard* stPtr = (struct clast_guard *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setThen");
	stPtr->then= (struct clast_stmt*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1guard_1test_1then
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_guard_then_tester) DISABLED START */
	struct clast_guard* stPtr = (struct clast_guard *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getThen");
	return (GECOS_PTRSIZE stPtr->then) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1guard_1get_1n
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_guard_n_getter) DISABLED START */
	struct clast_guard* stPtr = (struct clast_guard *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getN");
	return (jint) GECOS_PTRSIZE stPtr->n;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_guard_1set_1n
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(clast_guard_n_setter) DISABLED START */
	struct clast_guard* stPtr = (struct clast_guard *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setN");
	stPtr->n= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1guard_1test_1n
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_guard_n_tester) DISABLED START */
	struct clast_guard* stPtr = (struct clast_guard *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getN");
	return (GECOS_PTRSIZE stPtr->n) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1guard
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_guard\n");fflush(stdout);
#endif
	struct clast_stmt* stmt_c = (struct clast_stmt*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in is_clast_guard for parameter stmt");
		goto error;
	}

	int res = (int) is_clast_guard(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_guard\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1guard_1get_1equation
(JNIEnv *env, jclass class, jlong stmt, jint offset)
 {
#ifdef TRACE_ALL
	printf("Entering clast_guard_get_equation\n");fflush(stdout);
#endif
	struct clast_guard* stmt_c = (struct clast_guard*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_guard_get_equation for parameter stmt");
		goto error;
	}
	int offset_c = (int) offset;

	struct clast_equation* res = (struct clast_equation*) clast_guard_get_equation(stmt_c, offset_c);


#ifdef TRACE_ALL
	printf("Leaving clast_guard_get_equation\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


