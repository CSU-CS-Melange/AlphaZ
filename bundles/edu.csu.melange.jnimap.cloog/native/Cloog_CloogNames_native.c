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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1get_1nb_1scalars
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloognames_nb_scalars_getter) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNb_scalars");
	return (jint) GECOS_PTRSIZE stPtr->nb_scalars;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1set_1nb_1scalars
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloognames_nb_scalars_setter) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNb_scalars");
	stPtr->nb_scalars= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1test_1nb_1scalars
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloognames_nb_scalars_tester) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNb_scalars");
	return (GECOS_PTRSIZE stPtr->nb_scalars) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1get_1nb_1scattering
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloognames_nb_scattering_getter) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNb_scattering");
	return (jint) GECOS_PTRSIZE stPtr->nb_scattering;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1set_1nb_1scattering
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloognames_nb_scattering_setter) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNb_scattering");
	stPtr->nb_scattering= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1test_1nb_1scattering
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloognames_nb_scattering_tester) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNb_scattering");
	return (GECOS_PTRSIZE stPtr->nb_scattering) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1get_1nb_1iterators
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloognames_nb_iterators_getter) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNb_iterators");
	return (jint) GECOS_PTRSIZE stPtr->nb_iterators;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1set_1nb_1iterators
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloognames_nb_iterators_setter) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNb_iterators");
	stPtr->nb_iterators= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1test_1nb_1iterators
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloognames_nb_iterators_tester) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNb_iterators");
	return (GECOS_PTRSIZE stPtr->nb_iterators) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1get_1nb_1parameters
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloognames_nb_parameters_getter) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNb_parameters");
	return (jint) GECOS_PTRSIZE stPtr->nb_parameters;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1set_1nb_1parameters
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloognames_nb_parameters_setter) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNb_parameters");
	stPtr->nb_parameters= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloognames_1test_1nb_1parameters
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloognames_nb_parameters_tester) DISABLED START */
	struct cloognames* stPtr = (struct cloognames *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNb_parameters");
	return (GECOS_PTRSIZE stPtr->nb_parameters) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_get_1scalar
(JNIEnv *env, jclass class, jlong names, jint index)
 {
#ifdef TRACE_ALL
	printf("Entering get_scalar\n");fflush(stdout);
#endif
	struct cloognames* names_c = (struct cloognames*) GECOS_PTRSIZE names; 
	if(((void*)names_c)==NULL) {
		throwException(env, "Null pointer in get_scalar for parameter names");
		goto error;
	}
	int index_c = (int) index;

	char * res = (char *) get_scalar(names_c, index_c);


#ifdef TRACE_ALL
	printf("Leaving get_scalar\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_get_1scattering
(JNIEnv *env, jclass class, jlong names, jint index)
 {
#ifdef TRACE_ALL
	printf("Entering get_scattering\n");fflush(stdout);
#endif
	struct cloognames* names_c = (struct cloognames*) GECOS_PTRSIZE names; 
	if(((void*)names_c)==NULL) {
		throwException(env, "Null pointer in get_scattering for parameter names");
		goto error;
	}
	int index_c = (int) index;

	char * res = (char *) get_scattering(names_c, index_c);


#ifdef TRACE_ALL
	printf("Leaving get_scattering\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_get_1parameter
(JNIEnv *env, jclass class, jlong names, jint index)
 {
#ifdef TRACE_ALL
	printf("Entering get_parameter\n");fflush(stdout);
#endif
	struct cloognames* names_c = (struct cloognames*) GECOS_PTRSIZE names; 
	if(((void*)names_c)==NULL) {
		throwException(env, "Null pointer in get_parameter for parameter names");
		goto error;
	}
	int index_c = (int) index;

	char * res = (char *) get_parameter(names_c, index_c);


#ifdef TRACE_ALL
	printf("Leaving get_parameter\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_get_1iterator
(JNIEnv *env, jclass class, jlong names, jint index)
 {
#ifdef TRACE_ALL
	printf("Entering get_iterator\n");fflush(stdout);
#endif
	struct cloognames* names_c = (struct cloognames*) GECOS_PTRSIZE names; 
	if(((void*)names_c)==NULL) {
		throwException(env, "Null pointer in get_iterator for parameter names");
		goto error;
	}
	int index_c = (int) index;

	char * res = (char *) get_iterator(names_c, index_c);


#ifdef TRACE_ALL
	printf("Leaving get_iterator\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


