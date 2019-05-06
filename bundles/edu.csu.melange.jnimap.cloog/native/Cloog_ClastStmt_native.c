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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1stmt_1get_1op
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_stmt_op_getter) DISABLED START */
	struct clast_stmt* stPtr = (struct clast_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getOp");
	return (jlong) GECOS_PTRSIZE stPtr->op;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_stmt_1set_1op
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_stmt_op_setter) DISABLED START */
	struct clast_stmt* stPtr = (struct clast_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setOp");
	stPtr->op= (struct clast_stmt_op*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1stmt_1test_1op
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_stmt_op_tester) DISABLED START */
	struct clast_stmt* stPtr = (struct clast_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getOp");
	return (GECOS_PTRSIZE stPtr->op) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1stmt_1get_1next
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_stmt_next_getter) DISABLED START */
	struct clast_stmt* stPtr = (struct clast_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNext");
	return (jlong) GECOS_PTRSIZE stPtr->next;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_stmt_1set_1next
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_stmt_next_setter) DISABLED START */
	struct clast_stmt* stPtr = (struct clast_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNext");
	stPtr->next= (struct clast_stmt*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1stmt_1test_1next
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_stmt_next_tester) DISABLED START */
	struct clast_stmt* stPtr = (struct clast_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNext");
	return (GECOS_PTRSIZE stPtr->next) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1print
(JNIEnv *env, jclass class, jlong stmt, jlong opts)
 {
#ifdef TRACE_ALL
	printf("Entering clast_print\n");fflush(stdout);
#endif
	struct clast_stmt* stmt_c = (struct clast_stmt*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_print for parameter stmt");
		goto error;
	}
	struct cloogoptions* opts_c = (struct cloogoptions*) GECOS_PTRSIZE opts; 
	if(((void*)opts_c)==NULL) {
		throwException(env, "Null pointer in clast_print for parameter opts");
		goto error;
	}

	 clast_print(stmt_c, opts_c);


#ifdef TRACE_ALL
	printf("Leaving clast_print\n");fflush(stdout);
#endif
	
error:
	return;
}


