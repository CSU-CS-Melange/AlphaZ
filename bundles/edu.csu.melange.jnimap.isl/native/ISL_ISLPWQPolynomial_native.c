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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_pw_qpolynomial_read_from_str for parameter str");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1get_1ctx
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_get_ctx\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_get_ctx for parameter pwqp");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_pw_qpolynomial_get_ctx(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1get_1space
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_get_space\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_get_space for parameter pwqp");
		goto error;
	}

	isl_space* res = (isl_space*) isl_pw_qpolynomial_get_space(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1get_1domain_1space
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_get_domain_space\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_get_domain_space for parameter pwqp");
		goto error;
	}

	isl_space* res = (isl_space*) isl_pw_qpolynomial_get_domain_space(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_get_domain_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1copy
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_copy\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_copy for parameter pwqp");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_copy(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1free
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_free\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_free for parameter pwqp");
		goto error;
	}

	 isl_pw_qpolynomial_free(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong pwqp1, jlong pwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_plain_is_equal\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp1_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp1; 
	if(((void*)pwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_plain_is_equal for parameter pwqp1");
		goto error;
	}
	isl_pw_qpolynomial* pwqp2_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp2; 
	if(((void*)pwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_plain_is_equal for parameter pwqp2");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_plain_is_equal(pwqp1_c, pwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1zero
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_zero\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_zero for parameter dim");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_zero(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1alloc
(JNIEnv *env, jclass class, jlong set, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_alloc\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_alloc for parameter set");
		goto error;
	}
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_alloc for parameter qp");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_alloc(set_c, qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1is_1zero
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_is_zero\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_is_zero for parameter pwqp");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_is_zero(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_is_zero\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1reset_1domain_1space
(JNIEnv *env, jclass class, jlong pwqp, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_reset_domain_space\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_reset_domain_space for parameter pwqp");
		goto error;
	}
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_reset_domain_space for parameter dim");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_reset_domain_space(pwqp_c, dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_reset_domain_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1dim
(JNIEnv *env, jclass class, jlong pwqp, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_dim\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_dim for parameter pwqp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_pw_qpolynomial_dim(pwqp_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1involves_1dims
(JNIEnv *env, jclass class, jlong pwqp, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_involves_dims\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_involves_dims for parameter pwqp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_pw_qpolynomial_involves_dims(pwqp_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1has_1equal_1space
(JNIEnv *env, jclass class, jlong pwqp1, jlong pwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_has_equal_space\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp1_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp1; 
	if(((void*)pwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_has_equal_space for parameter pwqp1");
		goto error;
	}
	isl_pw_qpolynomial* pwqp2_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp2; 
	if(((void*)pwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_has_equal_space for parameter pwqp2");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_has_equal_space(pwqp1_c, pwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_has_equal_space\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1set_1dim_1name
(JNIEnv *env, jclass class, jlong pwqp, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_set_dim_name\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_set_dim_name for parameter pwqp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_pw_qpolynomial_set_dim_name for parameter s");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_set_dim_name(pwqp_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1domain
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_domain\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_domain for parameter pwqp");
		goto error;
	}

	isl_set* res = (isl_set*) isl_pw_qpolynomial_domain(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1intersect_1domain
(JNIEnv *env, jclass class, jlong pwpq, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_intersect_domain\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwpq_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwpq; 
	if(((void*)pwpq_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_intersect_domain for parameter pwpq");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_intersect_domain for parameter set");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_intersect_domain(pwpq_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1intersect_1params
(JNIEnv *env, jclass class, jlong pwpq, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_intersect_params\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwpq_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwpq; 
	if(((void*)pwpq_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_intersect_params for parameter pwpq");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_intersect_params for parameter set");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_intersect_params(pwpq_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1project_1domain_1on_1params
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_project_domain_on_params\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_project_domain_on_params for parameter pwqp");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_project_domain_on_params(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_project_domain_on_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1drop_1dims
(JNIEnv *env, jclass class, jlong pwqp, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_drop_dims\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_drop_dims for parameter pwqp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_drop_dims(pwqp_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1split_1dims
(JNIEnv *env, jclass class, jlong pwqp, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_split_dims\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_split_dims for parameter pwqp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_split_dims(pwqp_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_split_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1add
(JNIEnv *env, jclass class, jlong pwqp1, jlong pwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_add\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp1_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp1; 
	if(((void*)pwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_add for parameter pwqp1");
		goto error;
	}
	isl_pw_qpolynomial* pwqp2_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp2; 
	if(((void*)pwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_add for parameter pwqp2");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_add(pwqp1_c, pwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1sub
(JNIEnv *env, jclass class, jlong pwqp1, jlong pwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_sub\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp1_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp1; 
	if(((void*)pwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_sub for parameter pwqp1");
		goto error;
	}
	isl_pw_qpolynomial* pwqp2_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp2; 
	if(((void*)pwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_sub for parameter pwqp2");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_sub(pwqp1_c, pwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1add_1disjoint
(JNIEnv *env, jclass class, jlong pwqp1, jlong pwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_add_disjoint\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp1_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp1; 
	if(((void*)pwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_add_disjoint for parameter pwqp1");
		goto error;
	}
	isl_pw_qpolynomial* pwqp2_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp2; 
	if(((void*)pwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_add_disjoint for parameter pwqp2");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_add_disjoint(pwqp1_c, pwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_add_disjoint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1neg
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_neg\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_neg for parameter pwqp");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_neg(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_neg\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1mul
(JNIEnv *env, jclass class, jlong pwqp1, jlong pwqp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_mul\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp1_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp1; 
	if(((void*)pwqp1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_mul for parameter pwqp1");
		goto error;
	}
	isl_pw_qpolynomial* pwqp2_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp2; 
	if(((void*)pwqp2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_mul for parameter pwqp2");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_mul(pwqp1_c, pwqp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_mul\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1scale_1val
(JNIEnv *env, jclass class, jlong pwqp, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_scale_val\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_scale_val for parameter pwqp");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_scale_val for parameter v");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_scale_val(pwqp_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_scale_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1pow
(JNIEnv *env, jclass class, jlong pwqp, jint exponent)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_pow\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_pow for parameter pwqp");
		goto error;
	}
	unsigned int exponent_c = (unsigned int) exponent;

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_pow(pwqp_c, exponent_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_pow\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1insert_1dims
(JNIEnv *env, jclass class, jlong pwqp, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_insert_dims\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_insert_dims for parameter pwqp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_insert_dims(pwqp_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1add_1dims
(JNIEnv *env, jclass class, jlong pwqp, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_add_dims\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_add_dims for parameter pwqp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_add_dims(pwqp_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1move_1dims
(JNIEnv *env, jclass class, jlong pwqp, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_move_dims\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_move_dims for parameter pwqp");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_move_dims(pwqp_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1eval
(JNIEnv *env, jclass class, jlong pwqp, jlong pnt)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_eval\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_eval for parameter pwqp");
		goto error;
	}
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_eval for parameter pnt");
		goto error;
	}

	isl_val* res = (isl_val*) isl_pw_qpolynomial_eval(pwqp_c, pnt_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_eval\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1max
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_max\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_max for parameter pwqp");
		goto error;
	}

	isl_val* res = (isl_val*) isl_pw_qpolynomial_max(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_max\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1min
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_min\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_min for parameter pwqp");
		goto error;
	}

	isl_val* res = (isl_val*) isl_pw_qpolynomial_min(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_min\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1bound
(JNIEnv *env, jclass class, jlong pwqp, jint type, jobject tight)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_bound\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_bound for parameter pwqp");
		goto error;
	}
	enum isl_fold type_c = (enum isl_fold) type;
	jclass tight_cls = (*env)->GetObjectClass(env, tight); 
	jfieldID tight_fid = (*env)->GetFieldID(env, tight_cls, "value", "Z");
	int tight_c = (int) (*env)->GetBooleanField(env, tight, tight_fid);

	isl_pw_qpolynomial_fold* res = (isl_pw_qpolynomial_fold*) isl_pw_qpolynomial_bound(pwqp_c, type_c, &tight_c);

	(*env)->SetBooleanField(env, tight, tight_fid, tight_c);

#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_bound\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1coalesce
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_coalesce\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_coalesce for parameter pwqp");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_coalesce(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1gist
(JNIEnv *env, jclass class, jlong pwqp, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_gist\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_gist for parameter pwqp");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_gist for parameter context");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_gist(pwqp_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1numberof_1piece
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_numberof_piece\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_numberof_piece for parameter pwqp");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_numberof_piece(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_numberof_piece\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1get_1piece_1at
(JNIEnv *env, jclass class, jlong pwqp, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_get_piece_at\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_get_piece_at for parameter pwqp");
		goto error;
	}
	int pos_c = (int) pos;

	struct isl_qpolynomial_piece* res = (struct isl_qpolynomial_piece*) isl_pw_qpolynomial_get_piece_at(pwqp_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_get_piece_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1numberof_1lifted_1piece
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_numberof_lifted_piece\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_numberof_lifted_piece for parameter pwqp");
		goto error;
	}

	int res = (int) isl_pw_qpolynomial_numberof_lifted_piece(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_numberof_lifted_piece\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1get_1lifted_1piece_1at
(JNIEnv *env, jclass class, jlong pwqp, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_get_lifted_piece_at\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_get_lifted_piece_at for parameter pwqp");
		goto error;
	}
	int pos_c = (int) pos;

	struct isl_qpolynomial_piece* res = (struct isl_qpolynomial_piece*) isl_pw_qpolynomial_get_lifted_piece_at(pwqp_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_get_lifted_piece_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1to_1string
(JNIEnv *env, jclass class, jlong pwqp, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_to_string\n");fflush(stdout);
#endif
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_to_string for parameter pwqp");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_pw_qpolynomial_to_string(pwqp_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


