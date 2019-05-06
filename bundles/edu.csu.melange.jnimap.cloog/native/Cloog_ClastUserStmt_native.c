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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1user_1stmt_1get_1statement
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_user_stmt_statement_getter) DISABLED START */
	struct clast_user_stmt* stPtr = (struct clast_user_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getStatement");
	return (jlong) GECOS_PTRSIZE stPtr->statement;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_user_stmt_1set_1statement
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_user_stmt_statement_setter) DISABLED START */
	struct clast_user_stmt* stPtr = (struct clast_user_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setStatement");
	stPtr->statement= (struct cloogstatement*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1user_1stmt_1test_1statement
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_user_stmt_statement_tester) DISABLED START */
	struct clast_user_stmt* stPtr = (struct clast_user_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getStatement");
	return (GECOS_PTRSIZE stPtr->statement) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1user_1stmt_1get_1substitutions
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_user_stmt_substitutions_getter) DISABLED START */
	struct clast_user_stmt* stPtr = (struct clast_user_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSubstitutions");
	return (jlong) GECOS_PTRSIZE stPtr->substitutions;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_user_stmt_1set_1substitutions
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_user_stmt_substitutions_setter) DISABLED START */
	struct clast_user_stmt* stPtr = (struct clast_user_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setSubstitutions");
	stPtr->substitutions= (struct clast_stmt*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1user_1stmt_1test_1substitutions
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_user_stmt_substitutions_tester) DISABLED START */
	struct clast_user_stmt* stPtr = (struct clast_user_stmt *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSubstitutions");
	return (GECOS_PTRSIZE stPtr->substitutions) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1user_1stmt
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_user_stmt\n");fflush(stdout);
#endif
	struct clast_stmt* stmt_c = (struct clast_stmt*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in is_clast_user_stmt for parameter stmt");
		goto error;
	}

	int res = (int) is_clast_user_stmt(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_user_stmt\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1user_1stmt_1get_1cloog_1domain
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering clast_user_stmt_get_cloog_domain\n");fflush(stdout);
#endif
	struct clast_user_stmt* stmt_c = (struct clast_user_stmt*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_user_stmt_get_cloog_domain for parameter stmt");
		goto error;
	}

	char * res = (char *) clast_user_stmt_get_cloog_domain(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving clast_user_stmt_get_cloog_domain\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


