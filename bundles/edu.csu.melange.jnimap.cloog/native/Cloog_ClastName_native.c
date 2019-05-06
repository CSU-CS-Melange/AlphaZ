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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1name_1get_1name
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_name_name_getter) DISABLED START */
	struct clast_name* stPtr = (struct clast_name *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getName");
	return (*env)->NewStringUTF(env, stPtr->name);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_name_1set_1name
	(JNIEnv *env, jclass class, jlong ptr, jstring value) {
	/* PROTECTED REGION ID(clast_name_name_setter) DISABLED START */
	struct clast_name* stPtr = (struct clast_name *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setName");
	char* str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, value, NULL);
	strcpy(str_c, stPtr->name);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1name_1test_1name
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_name_name_tester) DISABLED START */
	struct clast_name* stPtr = (struct clast_name *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getName");
	return (GECOS_PTRSIZE stPtr->name) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1expr_1name
(JNIEnv *env, jclass class, jlong exp)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_expr_name\n");fflush(stdout);
#endif
	struct clast_expr* exp_c = (struct clast_expr*) GECOS_PTRSIZE exp; 
	if(((void*)exp_c)==NULL) {
		throwException(env, "Null pointer in is_clast_expr_name for parameter exp");
		goto error;
	}

	int res = (int) is_clast_expr_name(exp_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_expr_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


