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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_union_set_read_from_str for parameter str");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_union_set_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1from_1union_1set
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_from_union_set\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_set_from_union_set for parameter uset");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_from_union_set(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_from_union_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1from_1union_1set
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_from_union_set\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_from_union_set for parameter uset");
		goto error;
	}

	isl_union_pw_multi_aff* res = (isl_union_pw_multi_aff*) isl_union_pw_multi_aff_from_union_set(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_from_union_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1empty
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_empty\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_empty for parameter space");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_empty(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1universe
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_universe\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_universe for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_universe(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1from_1domain_1and_1range
(JNIEnv *env, jclass class, jlong domain, jlong range)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_from_domain_and_range\n");fflush(stdout);
#endif
	isl_union_set* domain_c = (isl_union_set*) GECOS_PTRSIZE domain; 
	if(((void*)domain_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_from_domain_and_range for parameter domain");
		goto error;
	}
	isl_union_set* range_c = (isl_union_set*) GECOS_PTRSIZE range; 
	if(((void*)range_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_from_domain_and_range for parameter range");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_from_domain_and_range(domain_c, range_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_from_domain_and_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1get_1ctx
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_get_ctx\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_get_ctx for parameter uset");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_union_set_get_ctx(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1get_1space
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_get_space\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_get_space for parameter uset");
		goto error;
	}

	isl_space* res = (isl_space*) isl_union_set_get_space(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1copy
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_copy\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_copy for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_copy(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1free
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_free\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_free for parameter uset");
		goto error;
	}

	 isl_union_set_free(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1n_1set
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_n_set\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_n_set for parameter uset");
		goto error;
	}

	int res = (int) isl_union_set_n_set(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_n_set\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1compute_1divs
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_compute_divs\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_compute_divs for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_compute_divs(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_compute_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1extract_1set
(JNIEnv *env, jclass class, jlong uset, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_extract_set\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_extract_set for parameter uset");
		goto error;
	}
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_extract_set for parameter space");
		goto error;
	}

	isl_set* res = (isl_set*) isl_union_set_extract_set(uset_c, space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_extract_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1is_1empty
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_is_empty\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_empty for parameter uset");
		goto error;
	}

	int res = (int) isl_union_set_is_empty(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1is_1params
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_is_params\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_params for parameter uset");
		goto error;
	}

	int res = (int) isl_union_set_is_params(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_is_params\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1is_1equal
(JNIEnv *env, jclass class, jlong uset1, jlong uset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_is_equal\n");fflush(stdout);
#endif
	isl_union_set* uset1_c = (isl_union_set*) GECOS_PTRSIZE uset1; 
	if(((void*)uset1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_equal for parameter uset1");
		goto error;
	}
	isl_union_set* uset2_c = (isl_union_set*) GECOS_PTRSIZE uset2; 
	if(((void*)uset2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_equal for parameter uset2");
		goto error;
	}

	int res = (int) isl_union_set_is_equal(uset1_c, uset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1is_1disjoint
(JNIEnv *env, jclass class, jlong uset1, jlong uset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_is_disjoint\n");fflush(stdout);
#endif
	isl_union_set* uset1_c = (isl_union_set*) GECOS_PTRSIZE uset1; 
	if(((void*)uset1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_disjoint for parameter uset1");
		goto error;
	}
	isl_union_set* uset2_c = (isl_union_set*) GECOS_PTRSIZE uset2; 
	if(((void*)uset2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_disjoint for parameter uset2");
		goto error;
	}

	int res = (int) isl_union_set_is_disjoint(uset1_c, uset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_is_disjoint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1is_1subset
(JNIEnv *env, jclass class, jlong uset1, jlong uset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_is_subset\n");fflush(stdout);
#endif
	isl_union_set* uset1_c = (isl_union_set*) GECOS_PTRSIZE uset1; 
	if(((void*)uset1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_subset for parameter uset1");
		goto error;
	}
	isl_union_set* uset2_c = (isl_union_set*) GECOS_PTRSIZE uset2; 
	if(((void*)uset2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_subset for parameter uset2");
		goto error;
	}

	int res = (int) isl_union_set_is_subset(uset1_c, uset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_is_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1is_1strict_1subset
(JNIEnv *env, jclass class, jlong uset1, jlong uset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_is_strict_subset\n");fflush(stdout);
#endif
	isl_union_set* uset1_c = (isl_union_set*) GECOS_PTRSIZE uset1; 
	if(((void*)uset1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_strict_subset for parameter uset1");
		goto error;
	}
	isl_union_set* uset2_c = (isl_union_set*) GECOS_PTRSIZE uset2; 
	if(((void*)uset2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_is_strict_subset for parameter uset2");
		goto error;
	}

	int res = (int) isl_union_set_is_strict_subset(uset1_c, uset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_is_strict_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1project_1out
(JNIEnv *env, jclass class, jlong uset, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_project_out\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_project_out for parameter uset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_union_set* res = (isl_union_set*) isl_union_set_project_out(uset_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_project_out\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1params
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_params\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_params for parameter uset");
		goto error;
	}

	isl_set* res = (isl_set*) isl_union_set_params(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1identity
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_identity\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_identity for parameter uset");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_set_identity(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_identity\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1coalesce
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_coalesce\n");fflush(stdout);
#endif
	isl_union_set* set_c = (isl_union_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_coalesce for parameter set");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_coalesce(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1detect_1equalities
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_detect_equalities\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_detect_equalities for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_detect_equalities(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_detect_equalities\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1remove_1redundancies
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_remove_redundancies\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_remove_redundancies for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_remove_redundancies(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_remove_redundancies\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1affine_1hull
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_affine_hull\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_affine_hull for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_affine_hull(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_affine_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1polyhedral_1hull
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_polyhedral_hull\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_polyhedral_hull for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_polyhedral_hull(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_polyhedral_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1unwrap
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_unwrap\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_unwrap for parameter uset");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_set_unwrap(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_unwrap\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1lift
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_lift\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_lift for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_lift(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_lift\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1add_1set
(JNIEnv *env, jclass class, jlong uset, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_add_set\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_add_set for parameter uset");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_add_set for parameter set");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_add_set(uset_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_add_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1intersect_1params
(JNIEnv *env, jclass class, jlong uset, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_intersect_params\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_intersect_params for parameter uset");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_intersect_params for parameter set");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_intersect_params(uset_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1intersect
(JNIEnv *env, jclass class, jlong uset1, jlong uset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_intersect\n");fflush(stdout);
#endif
	isl_union_set* uset1_c = (isl_union_set*) GECOS_PTRSIZE uset1; 
	if(((void*)uset1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_intersect for parameter uset1");
		goto error;
	}
	isl_union_set* uset2_c = (isl_union_set*) GECOS_PTRSIZE uset2; 
	if(((void*)uset2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_intersect for parameter uset2");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_intersect(uset1_c, uset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_intersect\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1union
(JNIEnv *env, jclass class, jlong uset1, jlong uset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_union\n");fflush(stdout);
#endif
	isl_union_set* uset1_c = (isl_union_set*) GECOS_PTRSIZE uset1; 
	if(((void*)uset1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_union for parameter uset1");
		goto error;
	}
	isl_union_set* uset2_c = (isl_union_set*) GECOS_PTRSIZE uset2; 
	if(((void*)uset2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_union for parameter uset2");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_union(uset1_c, uset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_union\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1subtract
(JNIEnv *env, jclass class, jlong uset1, jlong uset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_subtract\n");fflush(stdout);
#endif
	isl_union_set* uset1_c = (isl_union_set*) GECOS_PTRSIZE uset1; 
	if(((void*)uset1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_subtract for parameter uset1");
		goto error;
	}
	isl_union_set* uset2_c = (isl_union_set*) GECOS_PTRSIZE uset2; 
	if(((void*)uset2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_subtract for parameter uset2");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_subtract(uset1_c, uset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_subtract\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1apply
(JNIEnv *env, jclass class, jlong uset, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_apply\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_apply for parameter uset");
		goto error;
	}
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_apply for parameter umap");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_apply(uset_c, umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_apply\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1preimage_1multi_1aff
(JNIEnv *env, jclass class, jlong uset, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_preimage_multi_aff\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_preimage_multi_aff for parameter uset");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_preimage_multi_aff for parameter ma");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_preimage_multi_aff(uset_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_preimage_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1preimage_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong uset, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_preimage_pw_multi_aff\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_preimage_pw_multi_aff for parameter uset");
		goto error;
	}
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_preimage_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_preimage_pw_multi_aff(uset_c, pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_preimage_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1preimage_1union_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong uset, jlong upma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_preimage_union_pw_multi_aff\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_preimage_union_pw_multi_aff for parameter uset");
		goto error;
	}
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_preimage_union_pw_multi_aff for parameter upma");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_preimage_union_pw_multi_aff(uset_c, upma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_preimage_union_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1product
(JNIEnv *env, jclass class, jlong uset1, jlong uset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_product\n");fflush(stdout);
#endif
	isl_union_set* uset1_c = (isl_union_set*) GECOS_PTRSIZE uset1; 
	if(((void*)uset1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_product for parameter uset1");
		goto error;
	}
	isl_union_set* uset2_c = (isl_union_set*) GECOS_PTRSIZE uset2; 
	if(((void*)uset2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_product for parameter uset2");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_product(uset1_c, uset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1gist
(JNIEnv *env, jclass class, jlong uset, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_gist\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_gist for parameter uset");
		goto error;
	}
	isl_union_set* context_c = (isl_union_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_gist for parameter context");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_gist(uset_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1gist_1params
(JNIEnv *env, jclass class, jlong uset, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_gist_params\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_gist_params for parameter uset");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_gist_params for parameter set");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_gist_params(uset_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_gist_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1lexmin
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_lexmin\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_lexmin for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_lexmin(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1lexmax
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_lexmax\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_lexmax for parameter uset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_lexmax(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1to_1string
(JNIEnv *env, jclass class, jlong map, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_to_string\n");fflush(stdout);
#endif
	isl_union_set* map_c = (isl_union_set*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_to_string for parameter map");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_union_set_to_string(map_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1get_1set_1at
(JNIEnv *env, jclass class, jlong uset, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_get_set_at\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_get_set_at for parameter uset");
		goto error;
	}
	int pos_c = (int) pos;

	isl_set* res = (isl_set*) isl_union_set_get_set_at(uset_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_get_set_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


