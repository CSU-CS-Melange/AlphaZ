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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1term_1get_1ctx
(JNIEnv *env, jclass class, jlong term)
 {
#ifdef TRACE_ALL
	printf("Entering isl_term_get_ctx\n");fflush(stdout);
#endif
	isl_term* term_c = (isl_term*) GECOS_PTRSIZE term; 
	if(((void*)term_c)==NULL) {
		throwException(env, "Null pointer in isl_term_get_ctx for parameter term");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_term_get_ctx(term_c);


#ifdef TRACE_ALL
	printf("Leaving isl_term_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1term_1copy
(JNIEnv *env, jclass class, jlong term)
 {
#ifdef TRACE_ALL
	printf("Entering isl_term_copy\n");fflush(stdout);
#endif
	isl_term* term_c = (isl_term*) GECOS_PTRSIZE term; 
	if(((void*)term_c)==NULL) {
		throwException(env, "Null pointer in isl_term_copy for parameter term");
		goto error;
	}

	isl_term* res = (isl_term*) isl_term_copy(term_c);


#ifdef TRACE_ALL
	printf("Leaving isl_term_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1term_1free
(JNIEnv *env, jclass class, jlong term)
 {
#ifdef TRACE_ALL
	printf("Entering isl_term_free\n");fflush(stdout);
#endif
	isl_term* term_c = (isl_term*) GECOS_PTRSIZE term; 
	if(((void*)term_c)==NULL) {
		throwException(env, "Null pointer in isl_term_free for parameter term");
		goto error;
	}

	 isl_term_free(term_c);


#ifdef TRACE_ALL
	printf("Leaving isl_term_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1term_1dim
(JNIEnv *env, jclass class, jlong term, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_term_dim\n");fflush(stdout);
#endif
	isl_term* term_c = (isl_term*) GECOS_PTRSIZE term; 
	if(((void*)term_c)==NULL) {
		throwException(env, "Null pointer in isl_term_dim for parameter term");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_term_dim(term_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_term_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1term_1get_1coefficient_1val
(JNIEnv *env, jclass class, jlong term)
 {
#ifdef TRACE_ALL
	printf("Entering isl_term_get_coefficient_val\n");fflush(stdout);
#endif
	isl_term* term_c = (isl_term*) GECOS_PTRSIZE term; 
	if(((void*)term_c)==NULL) {
		throwException(env, "Null pointer in isl_term_get_coefficient_val for parameter term");
		goto error;
	}

	isl_val* res = (isl_val*) isl_term_get_coefficient_val(term_c);


#ifdef TRACE_ALL
	printf("Leaving isl_term_get_coefficient_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1term_1get_1exp
(JNIEnv *env, jclass class, jlong term, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_term_get_exp\n");fflush(stdout);
#endif
	isl_term* term_c = (isl_term*) GECOS_PTRSIZE term; 
	if(((void*)term_c)==NULL) {
		throwException(env, "Null pointer in isl_term_get_exp for parameter term");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_term_get_exp(term_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_term_get_exp\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1term_1get_1div
(JNIEnv *env, jclass class, jlong term, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_term_get_div\n");fflush(stdout);
#endif
	isl_term* term_c = (isl_term*) GECOS_PTRSIZE term; 
	if(((void*)term_c)==NULL) {
		throwException(env, "Null pointer in isl_term_get_div for parameter term");
		goto error;
	}
	unsigned int pos_c = (unsigned int) pos;

	isl_aff* res = (isl_aff*) isl_term_get_div(term_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_term_get_div\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


