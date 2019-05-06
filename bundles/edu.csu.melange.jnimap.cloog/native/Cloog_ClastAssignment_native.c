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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1assignment_1get_1LHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_assignment_LHS_getter) DISABLED START */
	struct clast_assignment* stPtr = (struct clast_assignment *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLHS");
	return (*env)->NewStringUTF(env, stPtr->LHS);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_assignment_1set_1LHS
	(JNIEnv *env, jclass class, jlong ptr, jstring value) {
	/* PROTECTED REGION ID(clast_assignment_LHS_setter) DISABLED START */
	struct clast_assignment* stPtr = (struct clast_assignment *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setLHS");
	char* str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, value, NULL);
	strcpy(str_c, stPtr->LHS);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1assignment_1test_1LHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_assignment_LHS_tester) DISABLED START */
	struct clast_assignment* stPtr = (struct clast_assignment *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLHS");
	return (GECOS_PTRSIZE stPtr->LHS) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1assignment_1get_1RHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_assignment_RHS_getter) DISABLED START */
	struct clast_assignment* stPtr = (struct clast_assignment *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getRHS");
	return (jlong) GECOS_PTRSIZE stPtr->RHS;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_assignment_1set_1RHS
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_assignment_RHS_setter) DISABLED START */
	struct clast_assignment* stPtr = (struct clast_assignment *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setRHS");
	stPtr->RHS= (struct clast_expr*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1assignment_1test_1RHS
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_assignment_RHS_tester) DISABLED START */
	struct clast_assignment* stPtr = (struct clast_assignment *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getRHS");
	return (GECOS_PTRSIZE stPtr->RHS) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1assignment
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_assignment\n");fflush(stdout);
#endif
	struct clast_stmt* stmt_c = (struct clast_stmt*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in is_clast_assignment for parameter stmt");
		goto error;
	}

	int res = (int) is_clast_assignment(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_assignment\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


