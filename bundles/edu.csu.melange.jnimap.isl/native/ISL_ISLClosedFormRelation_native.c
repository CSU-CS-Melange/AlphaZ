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

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1closed_1form_1relation_1get_1dom
	(JNIEnv *env, jclass class, jlong ptr) {
	struct isl_closed_form_relation* stPtr = (struct isl_closed_form_relation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getDom");
	return (jlong) GECOS_PTRSIZE stPtr->dom;
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_closed_form_relation_1set_1dom
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	struct isl_closed_form_relation* stPtr = (struct isl_closed_form_relation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setDom");
	stPtr->dom= (isl_set*) GECOS_PTRSIZE value;
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1closed_1form_1relation_1get_1multiAff
	(JNIEnv *env, jclass class, jlong ptr) {
	struct isl_closed_form_relation* stPtr = (struct isl_closed_form_relation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMultiAff");
	return (jlong) GECOS_PTRSIZE stPtr->multiAff;
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_closed_form_relation_1set_1multiAff
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	struct isl_closed_form_relation* stPtr = (struct isl_closed_form_relation *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setMultiAff");
	stPtr->multiAff= (isl_multi_aff*) GECOS_PTRSIZE value;
}




