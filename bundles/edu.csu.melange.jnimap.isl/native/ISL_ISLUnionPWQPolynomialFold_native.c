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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1get_1ctx
(JNIEnv *env, jclass class, jlong upwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_get_ctx\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_get_ctx for parameter upwf");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_union_pw_qpolynomial_fold_get_ctx(upwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1get_1space
(JNIEnv *env, jclass class, jlong upwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_get_space\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_get_space for parameter upwf");
		goto error;
	}

	isl_space* res = (isl_space*) isl_union_pw_qpolynomial_fold_get_space(upwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1copy
(JNIEnv *env, jclass class, jlong upwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_copy\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_copy for parameter upwf");
		goto error;
	}

	isl_union_pw_qpolynomial_fold* res = (isl_union_pw_qpolynomial_fold*) isl_union_pw_qpolynomial_fold_copy(upwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1free
(JNIEnv *env, jclass class, jlong upwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_free\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_free for parameter upwf");
		goto error;
	}

	 isl_union_pw_qpolynomial_fold_free(upwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1gist
(JNIEnv *env, jclass class, jlong upwf, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_gist\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_gist for parameter upwf");
		goto error;
	}
	isl_union_set* context_c = (isl_union_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_gist for parameter context");
		goto error;
	}

	isl_union_pw_qpolynomial_fold* res = (isl_union_pw_qpolynomial_fold*) isl_union_pw_qpolynomial_fold_gist(upwf_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1coalesce
(JNIEnv *env, jclass class, jlong upwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_coalesce\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_coalesce for parameter upwf");
		goto error;
	}

	isl_union_pw_qpolynomial_fold* res = (isl_union_pw_qpolynomial_fold*) isl_union_pw_qpolynomial_fold_coalesce(upwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1domain
(JNIEnv *env, jclass class, jlong upwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_domain\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_domain for parameter upwf");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_pw_qpolynomial_fold_domain(upwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1intersect_1domain
(JNIEnv *env, jclass class, jlong upwf, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_intersect_domain\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_intersect_domain for parameter upwf");
		goto error;
	}
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_intersect_domain for parameter uset");
		goto error;
	}

	isl_union_pw_qpolynomial_fold* res = (isl_union_pw_qpolynomial_fold*) isl_union_pw_qpolynomial_fold_intersect_domain(upwf_c, uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1intersect_1params
(JNIEnv *env, jclass class, jlong upwf, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_intersect_params\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwf; 
	if(((void*)upwf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_intersect_params for parameter upwf");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_intersect_params for parameter set");
		goto error;
	}

	isl_union_pw_qpolynomial_fold* res = (isl_union_pw_qpolynomial_fold*) isl_union_pw_qpolynomial_fold_intersect_params(upwf_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1fold_1to_1string
(JNIEnv *env, jclass class, jlong upwqpf, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_fold_to_string\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial_fold* upwqpf_c = (isl_union_pw_qpolynomial_fold*) GECOS_PTRSIZE upwqpf; 
	if(((void*)upwqpf_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_fold_to_string for parameter upwqpf");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_union_pw_qpolynomial_fold_to_string(upwqpf_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_fold_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


