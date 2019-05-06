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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1qpolynomial_1from_1qpolynomial
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_from_qpolynomial\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_qpolynomial_from_qpolynomial for parameter qp");
		goto error;
	}

	isl_pw_qpolynomial* res = (isl_pw_qpolynomial*) isl_pw_qpolynomial_from_qpolynomial(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_from_qpolynomial\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1alloc
(JNIEnv *env, jclass class, jint type, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_alloc\n");fflush(stdout);
#endif
	enum isl_fold type_c = (enum isl_fold) type;
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_alloc for parameter qp");
		goto error;
	}

	isl_qpolynomial_fold* res = (isl_qpolynomial_fold*) isl_qpolynomial_fold_alloc(type_c, qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1get_1ctx
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_get_ctx\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_get_ctx for parameter qp");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_qpolynomial_get_ctx(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1get_1space
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_get_space\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_get_space for parameter qp");
		goto error;
	}

	isl_space* res = (isl_space*) isl_qpolynomial_get_space(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1get_1domain_1space
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_get_domain_space\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_get_domain_space for parameter qp");
		goto error;
	}

	isl_space* res = (isl_space*) isl_qpolynomial_get_domain_space(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_get_domain_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1copy
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_copy\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_copy for parameter qp");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_copy(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1free
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_free\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_free for parameter qp");
		goto error;
	}

	 isl_qpolynomial_free(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1dim
(JNIEnv *env, jclass class, jlong qp, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_dim\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_dim for parameter qp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_qpolynomial_dim(qp_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1involves_1dims
(JNIEnv *env, jclass class, jlong qp, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_involves_dims\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_involves_dims for parameter qp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_qpolynomial_involves_dims(qp_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1get_1constant_1val
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_get_constant_val\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_get_constant_val for parameter qp");
		goto error;
	}

	isl_val* res = (isl_val*) isl_qpolynomial_get_constant_val(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_get_constant_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1set_1dim_1name
(JNIEnv *env, jclass class, jlong qp, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_set_dim_name\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_set_dim_name for parameter qp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_qpolynomial_set_dim_name for parameter s");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_set_dim_name(qp_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1zero_1on_1domain
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_zero_on_domain\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_zero_on_domain for parameter dim");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_zero_on_domain(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_zero_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1one_1on_1domain
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_one_on_domain\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_one_on_domain for parameter dim");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_one_on_domain(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_one_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1infty_1on_1domain
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_infty_on_domain\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_infty_on_domain for parameter dim");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_infty_on_domain(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_infty_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1neginfty_1on_1domain
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_neginfty_on_domain\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_neginfty_on_domain for parameter dim");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_neginfty_on_domain(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_neginfty_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1nan_1on_1domain
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_nan_on_domain\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_nan_on_domain for parameter dim");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_nan_on_domain(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_nan_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1val_1on_1domain
(JNIEnv *env, jclass class, jlong dim, jlong val)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_val_on_domain\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_val_on_domain for parameter dim");
		goto error;
	}
	isl_val* val_c = (isl_val*) GECOS_PTRSIZE val; 
	if(((void*)val_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_val_on_domain for parameter val");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_val_on_domain(dim_c, val_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_val_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1from_1aff
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_from_aff\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_from_aff for parameter aff");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_from_aff(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_from_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1var_1on_1domain
(JNIEnv *env, jclass class, jlong dim, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_var_on_domain\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_var_on_domain for parameter dim");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_var_on_domain(dim_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_var_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong qp1, jlong qp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_plain_is_equal\n");fflush(stdout);
#endif
	isl_qpolynomial* qp1_c = (isl_qpolynomial*) GECOS_PTRSIZE qp1; 
	if(((void*)qp1_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_plain_is_equal for parameter qp1");
		goto error;
	}
	isl_qpolynomial* qp2_c = (isl_qpolynomial*) GECOS_PTRSIZE qp2; 
	if(((void*)qp2_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_plain_is_equal for parameter qp2");
		goto error;
	}

	int res = (int) isl_qpolynomial_plain_is_equal(qp1_c, qp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1is_1zero
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_is_zero\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_is_zero for parameter qp");
		goto error;
	}

	int res = (int) isl_qpolynomial_is_zero(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_is_zero\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1is_1nan
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_is_nan\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_is_nan for parameter qp");
		goto error;
	}

	int res = (int) isl_qpolynomial_is_nan(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_is_nan\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1is_1infty
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_is_infty\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_is_infty for parameter qp");
		goto error;
	}

	int res = (int) isl_qpolynomial_is_infty(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_is_infty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1is_1neginfty
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_is_neginfty\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_is_neginfty for parameter qp");
		goto error;
	}

	int res = (int) isl_qpolynomial_is_neginfty(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_is_neginfty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1sgn
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_sgn\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_sgn for parameter qp");
		goto error;
	}

	int res = (int) isl_qpolynomial_sgn(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_sgn\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1neg
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_neg\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_neg for parameter qp");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_neg(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_neg\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1add
(JNIEnv *env, jclass class, jlong qp1, jlong qp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_add\n");fflush(stdout);
#endif
	isl_qpolynomial* qp1_c = (isl_qpolynomial*) GECOS_PTRSIZE qp1; 
	if(((void*)qp1_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_add for parameter qp1");
		goto error;
	}
	isl_qpolynomial* qp2_c = (isl_qpolynomial*) GECOS_PTRSIZE qp2; 
	if(((void*)qp2_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_add for parameter qp2");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_add(qp1_c, qp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1sub
(JNIEnv *env, jclass class, jlong qp1, jlong qp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_sub\n");fflush(stdout);
#endif
	isl_qpolynomial* qp1_c = (isl_qpolynomial*) GECOS_PTRSIZE qp1; 
	if(((void*)qp1_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_sub for parameter qp1");
		goto error;
	}
	isl_qpolynomial* qp2_c = (isl_qpolynomial*) GECOS_PTRSIZE qp2; 
	if(((void*)qp2_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_sub for parameter qp2");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_sub(qp1_c, qp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1mul
(JNIEnv *env, jclass class, jlong qp1, jlong qp2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_mul\n");fflush(stdout);
#endif
	isl_qpolynomial* qp1_c = (isl_qpolynomial*) GECOS_PTRSIZE qp1; 
	if(((void*)qp1_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_mul for parameter qp1");
		goto error;
	}
	isl_qpolynomial* qp2_c = (isl_qpolynomial*) GECOS_PTRSIZE qp2; 
	if(((void*)qp2_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_mul for parameter qp2");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_mul(qp1_c, qp2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_mul\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1pow
(JNIEnv *env, jclass class, jlong qp, jint power)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_pow\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_pow for parameter qp");
		goto error;
	}
	unsigned int power_c = (unsigned int) power;

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_pow(qp_c, power_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_pow\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1scale_1val
(JNIEnv *env, jclass class, jlong qp, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_scale_val\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_scale_val for parameter qp");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_scale_val for parameter v");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_scale_val(qp_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_scale_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1insert_1dims
(JNIEnv *env, jclass class, jlong qp, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_insert_dims\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_insert_dims for parameter qp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_insert_dims(qp_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1add_1dims
(JNIEnv *env, jclass class, jlong qp, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_add_dims\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_add_dims for parameter qp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_add_dims(qp_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1move_1dims
(JNIEnv *env, jclass class, jlong qp, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_move_dims\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_move_dims for parameter qp");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_move_dims(qp_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1drop_1dims
(JNIEnv *env, jclass class, jlong qp, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_drop_dims\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_drop_dims for parameter qp");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_drop_dims(qp_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1align_1params
(JNIEnv *env, jclass class, jlong qp, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_align_params\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_align_params for parameter qp");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_align_params for parameter model");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_align_params(qp_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1gist
(JNIEnv *env, jclass class, jlong qp, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_gist\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_gist for parameter qp");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_gist for parameter context");
		goto error;
	}

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_gist(qp_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1get_1exp_1at
(JNIEnv *env, jclass class, jlong qp, jint termPos, jint type, jint dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_get_exp_at\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_get_exp_at for parameter qp");
		goto error;
	}
	int termPos_c = (int) termPos;
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int dim_c = (unsigned int) dim;

	int res = (int) isl_qpolynomial_get_exp_at(qp_c, termPos_c, type_c, dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_get_exp_at\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1numberof_1terms
(JNIEnv *env, jclass class, jlong qp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_numberof_terms\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_numberof_terms for parameter qp");
		goto error;
	}

	int res = (int) isl_qpolynomial_numberof_terms(qp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_numberof_terms\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1get_1term_1at
(JNIEnv *env, jclass class, jlong qp, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_get_term_at\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_get_term_at for parameter qp");
		goto error;
	}
	int pos_c = (int) pos;

	isl_term* res = (isl_term*) isl_qpolynomial_get_term_at(qp_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_get_term_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1to_1string
(JNIEnv *env, jclass class, jlong qp, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_to_string\n");fflush(stdout);
#endif
	isl_qpolynomial* qp_c = (isl_qpolynomial*) GECOS_PTRSIZE qp; 
	if(((void*)qp_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_to_string for parameter qp");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_qpolynomial_to_string(qp_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


