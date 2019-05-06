#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <isl/int.h>
#include <isl/ctx.h>
#include <isl/ast.h>
#include <isl/ast_build.h>
#include <isl/id.h>
#include <isl/set.h>
#include <isl/map.h>
#include <isl/mat.h>
#include <isl/point.h>
#include <isl/vec.h>
#include <isl/space.h>
#include <isl/local_space.h>
#include <isl/constraint.h>
#include <isl/stream.h>
#include <isl/printer.h>
#include <isl/polynomial.h>
#include <isl/schedule.h>
#include <isl/band.h>
#include <isl/flow.h>
#include <isl/aff.h>
#include <isl/vertices.h>
#include <isl/options.h>

#include "ISLUser_isl_closed_form_relation.h"
#include "ISLUser_vertices.h"
#include "ISLUser_ast.h"
#include "ISLUser_collections.h"
#include "ISLUser_scheduling.h"
#include "ISLUser_dataflow.h"
#include "ISLUser_tostring.h"
#include "ISLUser_lexnext.h"
#include "ISLUser_lexpred.h"
#include "ISLUser_misc.h"
#include "ISLUser_polynomial.h"

#include "fr_irisa_cairn_jnimap_isl_jni_ISLNative.h"

extern void throwException(JNIEnv * env, char* msg);
extern jobject createInteger(JNIEnv * env, int value);
extern jint getIntegerValue(JNIEnv * env, jobject obj);

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1transitive_1closure_1result_1get_1exact
	(JNIEnv *env, jclass class, jlong ptr) {
	struct isl_transitive_closure_result* stPtr = (struct isl_transitive_closure_result *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getExact");
	return (jint) GECOS_PTRSIZE stPtr->exact;
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_transitive_closure_result_1set_1exact
	(JNIEnv *env, jclass class, jlong ptr, jint value) {
	struct isl_transitive_closure_result* stPtr = (struct isl_transitive_closure_result *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setExact");
	stPtr->exact= (int) GECOS_PTRSIZE value;
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1transitive_1closure_1result_1get_1map
	(JNIEnv *env, jclass class, jlong ptr) {
	struct isl_transitive_closure_result* stPtr = (struct isl_transitive_closure_result *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMap");
	return (jlong) GECOS_PTRSIZE stPtr->map;
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_transitive_closure_result_1set_1map
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	struct isl_transitive_closure_result* stPtr = (struct isl_transitive_closure_result *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setMap");
	stPtr->map= (isl_map*) GECOS_PTRSIZE value;
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1transitive_1closure_1result_1get_1bmap
	(JNIEnv *env, jclass class, jlong ptr) {
	struct isl_transitive_closure_result* stPtr = (struct isl_transitive_closure_result *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getBmap");
	return (jlong) GECOS_PTRSIZE stPtr->bmap;
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_transitive_closure_result_1set_1bmap
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	struct isl_transitive_closure_result* stPtr = (struct isl_transitive_closure_result *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setBmap");
	stPtr->bmap= (isl_basic_map*) GECOS_PTRSIZE value;
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1transitive_1closure_1result_1get_1umap
	(JNIEnv *env, jclass class, jlong ptr) {
	struct isl_transitive_closure_result* stPtr = (struct isl_transitive_closure_result *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getUmap");
	return (jlong) GECOS_PTRSIZE stPtr->umap;
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_transitive_closure_result_1set_1umap
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	struct isl_transitive_closure_result* stPtr = (struct isl_transitive_closure_result *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setUmap");
	stPtr->umap= (isl_union_map*) GECOS_PTRSIZE value;
}




