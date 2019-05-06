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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1get_1ctx
(JNIEnv *env, jclass class, jlong upwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_get_ctx\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_get_ctx for parameter upwqp");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_union_pw_qpolynomial_get_ctx(upwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1get_1space
(JNIEnv *env, jclass class, jlong upwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_get_space\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_get_space for parameter upwqp");
		goto error;
	}

	isl_space* res = (isl_space*) isl_union_pw_qpolynomial_get_space(upwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1copy
(JNIEnv *env, jclass class, jlong upwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_copy\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_copy for parameter upwqp");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_copy(upwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1free
(JNIEnv *env, jclass class, jlong upwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_free\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_free for parameter upwqp");
		goto error;
	}

	 isl_union_pw_qpolynomial_free(upwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong upwqp1, jlong upwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_plain_is_equal\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp1_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp1; 
	if(((void*)upwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_plain_is_equal for parameter upwqp1");
		goto error;
	}
	isl_union_pw_qpolynomial* upwqp2_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp2; 
	if(((void*)upwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_plain_is_equal for parameter upwqp2");
		goto error;
	}

	int res = (int) isl_union_pw_qpolynomial_plain_is_equal(upwqp1_c, upwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1zero
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_zero\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_zero for parameter dim");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_zero(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1add_1pw_1qpolynomial
(JNIEnv *env, jclass class, jlong upwqp, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_add_pw_qpolynomial\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_add_pw_qpolynomial for parameter upwqp");
		goto error;
	}
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_add_pw_qpolynomial for parameter pwqp");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_add_pw_qpolynomial(upwqp_c, pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_add_pw_qpolynomial\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1add
(JNIEnv *env, jclass class, jlong upwqp1, jlong upwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_add\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp1_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp1; 
	if(((void*)upwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_add for parameter upwqp1");
		goto error;
	}
	isl_union_pw_qpolynomial* upwqp2_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp2; 
	if(((void*)upwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_add for parameter upwqp2");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_add(upwqp1_c, upwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1sub
(JNIEnv *env, jclass class, jlong upwqp1, jlong upwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_sub\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp1_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp1; 
	if(((void*)upwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_sub for parameter upwqp1");
		goto error;
	}
	isl_union_pw_qpolynomial* upwqp2_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp2; 
	if(((void*)upwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_sub for parameter upwqp2");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_sub(upwqp1_c, upwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1mul
(JNIEnv *env, jclass class, jlong upwqp1, jlong upwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_mul\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp1_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp1; 
	if(((void*)upwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_mul for parameter upwqp1");
		goto error;
	}
	isl_union_pw_qpolynomial* upwqp2_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp2; 
	if(((void*)upwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_mul for parameter upwqp2");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_mul(upwqp1_c, upwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_mul\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1scale_1val
(JNIEnv *env, jclass class, jlong upwqp, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_scale_val\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_scale_val for parameter upwqp");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_scale_val for parameter v");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_scale_val(upwqp_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_scale_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1domain
(JNIEnv *env, jclass class, jlong upwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_domain\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_domain for parameter upwqp");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_pw_qpolynomial_domain(upwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1intersect_1domain
(JNIEnv *env, jclass class, jlong upwpq, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_intersect_domain\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwpq_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwpq; 
	if(((void*)upwpq_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_intersect_domain for parameter upwpq");
		goto error;
	}
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_intersect_domain for parameter uset");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_intersect_domain(upwpq_c, uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1intersect_1params
(JNIEnv *env, jclass class, jlong upwpq, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_intersect_params\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwpq_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwpq; 
	if(((void*)upwpq_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_intersect_params for parameter upwpq");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_intersect_params for parameter set");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_intersect_params(upwpq_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1eval
(JNIEnv *env, jclass class, jlong upwqp, jlong pnt)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_eval\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_eval for parameter upwqp");
		goto error;
	}
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_eval for parameter pnt");
		goto error;
	}

	isl_val* res = (isl_val*) isl_union_pw_qpolynomial_eval(upwqp_c, pnt_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_eval\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1coalesce
(JNIEnv *env, jclass class, jlong upwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_coalesce\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_coalesce for parameter upwqp");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_coalesce(upwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1gist
(JNIEnv *env, jclass class, jlong upwqp, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_gist\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_gist for parameter upwqp");
		goto error;
	}
	isl_union_set* context_c = (isl_union_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_gist for parameter context");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_gist(upwqp_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1gist_1params
(JNIEnv *env, jclass class, jlong upwqp, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_gist_params\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_gist_params for parameter upwqp");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_gist_params for parameter context");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_gist_params(upwqp_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_gist_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1align_1params
(JNIEnv *env, jclass class, jlong upwqp, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_align_params\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_align_params for parameter upwqp");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_align_params for parameter model");
		goto error;
	}

	isl_union_pw_qpolynomial* res = (isl_union_pw_qpolynomial*) isl_union_pw_qpolynomial_align_params(upwqp_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1qpolynomial_1to_1string
(JNIEnv *env, jclass class, jlong upwqp, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_qpolynomial_to_string\n");fflush(stdout);
#endif
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*) GECOS_PTRSIZE upwqp; 
	if(((void*)upwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_qpolynomial_to_string for parameter upwqp");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_union_pw_qpolynomial_to_string(upwqp_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_qpolynomial_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


