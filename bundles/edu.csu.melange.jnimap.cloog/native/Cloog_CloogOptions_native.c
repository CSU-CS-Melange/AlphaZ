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
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1l
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_l_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getL");
	return (jint) GECOS_PTRSIZE stPtr->l;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1l
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_l_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setL");
	stPtr->l= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1l
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_l_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getL");
	return (GECOS_PTRSIZE stPtr->l) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1f
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_f_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getF");
	return (jint) GECOS_PTRSIZE stPtr->f;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1f
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_f_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setF");
	stPtr->f= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1f
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_f_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getF");
	return (GECOS_PTRSIZE stPtr->f) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1stop
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_stop_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getStop");
	return (jint) GECOS_PTRSIZE stPtr->stop;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1stop
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_stop_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setStop");
	stPtr->stop= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1stop
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_stop_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getStop");
	return (GECOS_PTRSIZE stPtr->stop) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1strides
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_strides_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getStrides");
	return (jint) GECOS_PTRSIZE stPtr->strides;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1strides
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_strides_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setStrides");
	stPtr->strides= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1strides
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_strides_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getStrides");
	return (GECOS_PTRSIZE stPtr->strides) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1sh
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_sh_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSh");
	return (jint) GECOS_PTRSIZE stPtr->sh;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1sh
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_sh_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setSh");
	stPtr->sh= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1sh
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_sh_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSh");
	return (GECOS_PTRSIZE stPtr->sh) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1esp
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_esp_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getEsp");
	return (jint) GECOS_PTRSIZE stPtr->esp;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1esp
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_esp_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setEsp");
	stPtr->esp= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1esp
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_esp_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getEsp");
	return (GECOS_PTRSIZE stPtr->esp) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1fsp
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_fsp_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getFsp");
	return (jint) GECOS_PTRSIZE stPtr->fsp;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1fsp
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_fsp_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setFsp");
	stPtr->fsp= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1fsp
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_fsp_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getFsp");
	return (GECOS_PTRSIZE stPtr->fsp) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1otl
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_otl_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getOtl");
	return (jint) GECOS_PTRSIZE stPtr->otl;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1otl
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_otl_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setOtl");
	stPtr->otl= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1otl
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_otl_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getOtl");
	return (GECOS_PTRSIZE stPtr->otl) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1block
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_block_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getBlock");
	return (jint) GECOS_PTRSIZE stPtr->block;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1block
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_block_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setBlock");
	stPtr->block= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1block
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_block_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getBlock");
	return (GECOS_PTRSIZE stPtr->block) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1compilable
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_compilable_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getCompilable");
	return (jint) GECOS_PTRSIZE stPtr->compilable;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1compilable
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_compilable_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setCompilable");
	stPtr->compilable= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1compilable
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_compilable_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getCompilable");
	return (GECOS_PTRSIZE stPtr->compilable) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1callable
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_callable_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getCallable");
	return (jint) GECOS_PTRSIZE stPtr->callable;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1callable
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_callable_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setCallable");
	stPtr->callable= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1callable
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_callable_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getCallable");
	return (GECOS_PTRSIZE stPtr->callable) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1language
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_language_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLanguage");
	return (jint) GECOS_PTRSIZE stPtr->language;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1language
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_language_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setLanguage");
	stPtr->language= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1language
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_language_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLanguage");
	return (GECOS_PTRSIZE stPtr->language) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1save_1domains
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_save_domains_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSave_domains");
	return (jint) GECOS_PTRSIZE stPtr->save_domains;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1save_1domains
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_save_domains_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setSave_domains");
	stPtr->save_domains= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1save_1domains
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_save_domains_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSave_domains");
	return (GECOS_PTRSIZE stPtr->save_domains) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1quiet
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_quiet_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getQuiet");
	return (jint) GECOS_PTRSIZE stPtr->quiet;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1quiet
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_quiet_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setQuiet");
	stPtr->quiet= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1quiet
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_quiet_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getQuiet");
	return (GECOS_PTRSIZE stPtr->quiet) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1leaks
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_leaks_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLeaks");
	return (jint) GECOS_PTRSIZE stPtr->leaks;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1leaks
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_leaks_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setLeaks");
	stPtr->leaks= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1leaks
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_leaks_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getLeaks");
	return (GECOS_PTRSIZE stPtr->leaks) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1backtrack
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_backtrack_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getBacktrack");
	return (jint) GECOS_PTRSIZE stPtr->backtrack;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1backtrack
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_backtrack_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setBacktrack");
	stPtr->backtrack= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1backtrack
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_backtrack_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getBacktrack");
	return (GECOS_PTRSIZE stPtr->backtrack) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1override
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_override_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getOverride");
	return (jint) GECOS_PTRSIZE stPtr->override;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1override
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_override_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setOverride");
	stPtr->override= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1override
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_override_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getOverride");
	return (GECOS_PTRSIZE stPtr->override) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1structure
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_structure_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getStructure");
	return (jint) GECOS_PTRSIZE stPtr->structure;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1structure
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_structure_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setStructure");
	stPtr->structure= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1structure
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_structure_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getStructure");
	return (GECOS_PTRSIZE stPtr->structure) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1noblocks
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_noblocks_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNoblocks");
	return (jint) GECOS_PTRSIZE stPtr->noblocks;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1noblocks
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_noblocks_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNoblocks");
	stPtr->noblocks= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1noblocks
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_noblocks_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNoblocks");
	return (GECOS_PTRSIZE stPtr->noblocks) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1noscalars
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_noscalars_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNoscalars");
	return (jint) GECOS_PTRSIZE stPtr->noscalars;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1noscalars
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_noscalars_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNoscalars");
	stPtr->noscalars= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1noscalars
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_noscalars_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNoscalars");
	return (GECOS_PTRSIZE stPtr->noscalars) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1get_1nosimplify
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_nosimplify_getter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNosimplify");
	return (jint) GECOS_PTRSIZE stPtr->nosimplify;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1set_1nosimplify
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	/* PROTECTED REGION ID(cloogoptions_nosimplify_setter) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNosimplify");
	stPtr->nosimplify= (int) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloogoptions_1test_1nosimplify
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(cloogoptions_nosimplify_tester) DISABLED START */
	struct cloogoptions* stPtr = (struct cloogoptions *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNosimplify");
	return (GECOS_PTRSIZE stPtr->nosimplify) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloog_1options_1malloc
(JNIEnv *env, jclass class, jlong state)
 {
#ifdef TRACE_ALL
	printf("Entering cloog_options_malloc\n");fflush(stdout);
#endif
	struct cloogstate* state_c = (struct cloogstate*) GECOS_PTRSIZE state; 
	if(((void*)state_c)==NULL) {
		throwException(env, "Null pointer in cloog_options_malloc for parameter state");
		goto error;
	}

	struct cloogoptions* res = (struct cloogoptions*) cloog_options_malloc(state_c);


#ifdef TRACE_ALL
	printf("Leaving cloog_options_malloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


