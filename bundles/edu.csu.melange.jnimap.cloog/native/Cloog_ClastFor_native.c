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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1get_1iterator
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_for_iterator_getter) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getIterator");
	return (*env)->NewStringUTF(env, stPtr->iterator);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_for_1set_1iterator
	(JNIEnv *env, jclass class, jlong ptr, jstring value) {
	/* PROTECTED REGION ID(clast_for_iterator_setter) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setIterator");
	char* str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, value, NULL);
	strcpy(str_c, stPtr->iterator);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1test_1iterator
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_for_iterator_tester) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getIterator");
	return (GECOS_PTRSIZE stPtr->iterator) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1get_1LB
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_for_LB_getter) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLB");
	return (jlong) GECOS_PTRSIZE stPtr->LB;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_for_1set_1LB
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_for_LB_setter) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setLB");
	stPtr->LB= (struct clast_expr*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1test_1LB
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_for_LB_tester) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLB");
	return (GECOS_PTRSIZE stPtr->LB) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1get_1UB
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_for_UB_getter) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getUB");
	return (jlong) GECOS_PTRSIZE stPtr->UB;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_for_1set_1UB
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_for_UB_setter) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setUB");
	stPtr->UB= (struct clast_expr*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1test_1UB
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_for_UB_tester) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getUB");
	return (GECOS_PTRSIZE stPtr->UB) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1get_1body
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_for_body_getter) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getBody");
	return (jlong) GECOS_PTRSIZE stPtr->body;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_for_1set_1body
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_for_body_setter) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setBody");
	stPtr->body= (struct clast_stmt*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1test_1body
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_for_body_tester) DISABLED START */
	struct clast_for* stPtr = (struct clast_for *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getBody");
	return (GECOS_PTRSIZE stPtr->body) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1for
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_for\n");fflush(stdout);
#endif
	struct clast_stmt* stmt_c = (struct clast_stmt*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in is_clast_for for parameter stmt");
		goto error;
	}

	int res = (int) is_clast_for(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_for\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1get_1cloog_1domain
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering clast_for_get_cloog_domain\n");fflush(stdout);
#endif
	struct clast_for* stmt_c = (struct clast_for*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_for_get_cloog_domain for parameter stmt");
		goto error;
	}

	char * res = (char *) clast_for_get_cloog_domain(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving clast_for_get_cloog_domain\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1for_1get_1stride
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering clast_for_get_stride\n");fflush(stdout);
#endif
	struct clast_for* stmt_c = (struct clast_for*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in clast_for_get_stride for parameter stmt");
		goto error;
	}

	int res = (int) clast_for_get_stride(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving clast_for_get_stride\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


