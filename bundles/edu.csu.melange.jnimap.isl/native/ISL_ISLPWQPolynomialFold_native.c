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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1get_1ctx
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_get_ctx\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_get_ctx for parameter pwf");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_pw_qpolynomial_fold_get_ctx(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1get_1space
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_get_space\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_get_space for parameter pwf");
		goto error;
	}

	isl_space* res = (isl_space*) isl_pw_qpolynomial_fold_get_space(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1get_1domain_1space
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_get_domain_space\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_get_domain_space for parameter pwf");
		goto error;
	}

	isl_space* res = (isl_space*) isl_pw_qpolynomial_fold_get_domain_space(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_get_domain_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1copy
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_copy\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_copy for parameter pwf");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_copy(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1free
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_free\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_free for parameter pwf");
		goto error;
	}

	 isl_pw_qpolynomial_fold_free(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong pwf1, jlong pwf2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_plain_is_equal\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf1_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf1; 
	if(((void*)pwf1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_plain_is_equal for parameter pwf1");
		goto error;
	}
	isl_pw_qpolynomial_fold* pwf2_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf2; 
	if(((void*)pwf2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_plain_is_equal for parameter pwf2");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_fold_plain_is_equal(pwf1_c, pwf2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1is_1zero
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_is_zero\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_is_zero for parameter pwf");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_fold_is_zero(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_is_zero\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1reset_1space
(JNIEnv *env, jclass class, jlong pwf, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_reset_space\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_reset_space for parameter pwf");
		goto error;
	}
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_reset_space for parameter dim");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_reset_space(pwf_c, dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_reset_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1dim
(JNIEnv *env, jclass class, jlong pwf, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_dim\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_dim for parameter pwf");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_pw_qpolynomial_fold_dim(pwf_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1has_1equal_1space
(JNIEnv *env, jclass class, jlong pwf1, jlong pwf2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_has_equal_space\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf1_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf1; 
	if(((void*)pwf1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_has_equal_space for parameter pwf1");
		goto error;
	}
	isl_pw_qpolynomial_fold* pwf2_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf2; 
	if(((void*)pwf2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_has_equal_space for parameter pwf2");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_fold_has_equal_space(pwf1_c, pwf2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_has_equal_space\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1zero
(JNIEnv *env, jclass class, jlong dim, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_zero\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_zero for parameter dim");
		goto error;
	}
	enum isl_fold type_c = (enum isl_fold) type;

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_zero(dim_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1set_1dim_1name
(JNIEnv *env, jclass class, jlong pwf, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_set_dim_name\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_set_dim_name for parameter pwf");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_pw_qpolynomial_fold_set_dim_name for parameter s");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_set_dim_name(pwf_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1domain
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_domain\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_domain for parameter pwf");
		goto error;
	}

	isl_set* res = (isl_set*) isl_pw_qpolynomial_fold_domain(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1intersect_1domain
(JNIEnv *env, jclass class, jlong pwf, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_intersect_domain\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_intersect_domain for parameter pwf");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_intersect_domain for parameter set");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_intersect_domain(pwf_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1intersect_1params
(JNIEnv *env, jclass class, jlong pwf, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_intersect_params\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_intersect_params for parameter pwf");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_intersect_params for parameter set");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_intersect_params(pwf_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1add
(JNIEnv *env, jclass class, jlong pwf1, jlong pwf2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_add\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf1_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf1; 
	if(((void*)pwf1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_add for parameter pwf1");
		goto error;
	}
	isl_pw_qpolynomial_fold* pwf2_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf2; 
	if(((void*)pwf2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_add for parameter pwf2");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_add(pwf1_c, pwf2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1fold
(JNIEnv *env, jclass class, jlong pwf1, jlong pwf2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_fold\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf1_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf1; 
	if(((void*)pwf1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_fold for parameter pwf1");
		goto error;
	}
	isl_pw_qpolynomial_fold* pwf2_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf2; 
	if(((void*)pwf2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_fold for parameter pwf2");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_fold(pwf1_c, pwf2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_fold\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1add_1disjoint
(JNIEnv *env, jclass class, jlong pwf1, jlong pwf2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_add_disjoint\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf1_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf1; 
	if(((void*)pwf1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_add_disjoint for parameter pwf1");
		goto error;
	}
	isl_pw_qpolynomial_fold* pwf2_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf2; 
	if(((void*)pwf2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_add_disjoint for parameter pwf2");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_add_disjoint(pwf1_c, pwf2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_add_disjoint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1scale_1val
(JNIEnv *env, jclass class, jlong pwf, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_scale_val\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_scale_val for parameter pwf");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_scale_val for parameter v");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_scale_val(pwf_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_scale_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1project_1domain_1on_1params
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_project_domain_on_params\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_project_domain_on_params for parameter pwf");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_project_domain_on_params(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_project_domain_on_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1drop_1dims
(JNIEnv *env, jclass class, jlong pwf, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_drop_dims\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_drop_dims for parameter pwf");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_drop_dims(pwf_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1move_1dims
(JNIEnv *env, jclass class, jlong pwf, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_move_dims\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_move_dims for parameter pwf");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_move_dims(pwf_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1coalesce
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_coalesce\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_coalesce for parameter pwf");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_coalesce(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1gist
(JNIEnv *env, jclass class, jlong pwf, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_gist\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_gist for parameter pwf");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_gist for parameter context");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_gist(pwf_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1gist_1params
(JNIEnv *env, jclass class, jlong pwf, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_gist_params\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_gist_params for parameter pwf");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_gist_params for parameter context");
		goto error;
	}

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_fold_gist_params(pwf_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_gist_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1numberof_1piece
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_numberof_piece\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_numberof_piece for parameter pwf");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_fold_numberof_piece(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_numberof_piece\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1get_1piece_1at
(JNIEnv *env, jclass class, jlong pwf, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_get_piece_at\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_get_piece_at for parameter pwf");
		goto error;
	}
	int pos_c = (int) pos;

	struct isl_qpolynomial_fold_piece* res = (struct isl_qpolynomial_fold_piece*) isl_pw_qpolynomial_fold_get_piece_at(pwf_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_get_piece_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1numberof_1lifted_1piece
(JNIEnv *env, jclass class, jlong pwf)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_numberof_lifted_piece\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_numberof_lifted_piece for parameter pwf");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_fold_numberof_lifted_piece(pwf_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_numberof_lifted_piece\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1get_1lifted_1piece_1at
(JNIEnv *env, jclass class, jlong pwf, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_get_lifted_piece_at\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwf; 
	if(((void*)pwf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_get_lifted_piece_at for parameter pwf");
		goto error;
	}
	int pos_c = (int) pos;

	struct isl_qpolynomial_fold_piece* res = (struct isl_qpolynomial_fold_piece*) isl_pw_qpolynomial_fold_get_lifted_piece_at(pwf_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_get_lifted_piece_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1fold_1to_1string
(JNIEnv *env, jclass class, jlong pwqpf, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_fold_to_string\n");fflush(stdout);
#endif
	isl_pw_qpolynomial_fold* pwqpf_c = (isl_pw_qpolynomial_fold*) GECOS_PTRSIZE pwqpf; 
	if(((void*)pwqpf_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_fold_to_string for parameter pwqpf");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_pw_qpolynomial_fold_to_string(pwqpf_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_fold_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


