#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <isl/aff.h>
#include <isl/aff_type.h>
#include <isl/arg.h>
#include <isl/ast_build.h>
#include <isl/ast.h>
#include <isl/ast_type.h>
#include <isl/constraint.h>
#include <isl/ctx.h>
#include <isl/flow.h>
#include <isl/hash.h>
#include <isl/id.h>
#include <isl/id_to_ast_expr.h>
#include <isl/id_to_pw_aff.h>
#include <isl/ilp.h>
#include <isl/list.h>
#include <isl/local_space.h>
#include <isl/lp.h>
#include <isl/map.h>
#include <isl/map_to_basic_set.h>
#include <isl/map_type.h>
#include <isl/mat.h>
#include <isl/multi.h>
#include <isl/obj.h>
#include <isl/options.h>
#include <isl/point.h>
#include <isl/polynomial.h>
#include <isl/polynomial_type.h>
#include <isl/printer.h>
#include <isl/schedule.h>
#include <isl/schedule_node.h>
#include <isl/schedule_type.h>
#include <isl/set.h>
#include <isl/set_type.h>
#include <isl/space.h>
#include <isl/stdint.h>
#include <isl/stream.h>
#include <isl/union_map.h>
#include <isl/union_map_type.h>
#include <isl/union_set.h>
#include <isl/union_set_type.h>
#include <isl/val_gmp.h>
#include <isl/val.h>
#include <isl/vec.h>
#include <isl/version.h>
#include <isl/vertices.h>

#include "ISLUser_vertices.h"
#include "ISLUser_ast.h"
#include "ISLUser_codegen.h"
#include "ISLUser_collections.h"
#include "ISLUser_scheduling.h"
#include "ISLUser_dataflow.h"
#include "ISLUser_tostring.h"
#include "ISLUser_lexnext.h"
#include "ISLUser_lexpred.h"
#include "ISLUser_misc.h"
#include "ISLUser_polynomial.h"
#include "ISLUser_stdio.h"

#include "fr_irisa_cairn_jnimap_isl_jni_ISLNative.h"

extern void throwException(JNIEnv * env, char* msg);
extern jobject createInteger(JNIEnv * env, int value);
extern jint getIntegerValue(JNIEnv * env, jobject obj);

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1piece_1get_1set
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_qpolynomial_fold_piece_set_getter) DISABLED START */
	struct isl_qpolynomial_fold_piece* stPtr = (struct isl_qpolynomial_fold_piece *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSet");
	return (jlong) GECOS_PTRSIZE isl_set_copy(stPtr->set);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_qpolynomial_fold_piece_1set_1set
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(isl_qpolynomial_fold_piece_set_setter) DISABLED START */
	struct isl_qpolynomial_fold_piece* stPtr = (struct isl_qpolynomial_fold_piece *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setSet");
	stPtr->set= (isl_set*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1piece_1test_1set
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_qpolynomial_fold_piece_set_tester) DISABLED START */
	struct isl_qpolynomial_fold_piece* stPtr = (struct isl_qpolynomial_fold_piece *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getSet");
	return (GECOS_PTRSIZE isl_set_copy(stPtr->set)) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1piece_1get_1fold
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_qpolynomial_fold_piece_fold_getter) DISABLED START */
	struct isl_qpolynomial_fold_piece* stPtr = (struct isl_qpolynomial_fold_piece *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getFold");
	return (jlong) GECOS_PTRSIZE isl_qpolynomial_fold_copy(stPtr->fold);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_qpolynomial_fold_piece_1set_1fold
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(isl_qpolynomial_fold_piece_fold_setter) DISABLED START */
	struct isl_qpolynomial_fold_piece* stPtr = (struct isl_qpolynomial_fold_piece *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setFold");
	stPtr->fold= (isl_qpolynomial_fold*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1piece_1test_1fold
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_qpolynomial_fold_piece_fold_tester) DISABLED START */
	struct isl_qpolynomial_fold_piece* stPtr = (struct isl_qpolynomial_fold_piece *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getFold");
	return (GECOS_PTRSIZE isl_qpolynomial_fold_copy(stPtr->fold)) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1piece_1free
(JNIEnv *env, jclass class, jlong piece)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_piece_free\n");fflush(stdout);
#endif
	struct isl_qpolynomial_fold_piece* piece_c = (struct isl_qpolynomial_fold_piece*) GECOS_PTRSIZE piece; 
	if(((void*)piece_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_piece_free for parameter piece");
		goto error;
	}

	 isl_qpolynomial_fold_piece_free(piece_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_piece_free\n");fflush(stdout);
#endif
	
error:
	return;
}


