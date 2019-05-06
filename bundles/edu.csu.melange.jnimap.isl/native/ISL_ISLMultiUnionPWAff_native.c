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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_multi_union_pw_aff_read_from_str for parameter str");
		goto error;
	}

	isl_multi_union_pw_aff* res = (isl_multi_union_pw_aff*) isl_multi_union_pw_aff_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1zero
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_zero\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_zero for parameter space");
		goto error;
	}

	isl_multi_union_pw_aff* res = (isl_multi_union_pw_aff*) isl_multi_union_pw_aff_zero(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1multi_1val_1on_1domain
(JNIEnv *env, jclass class, jlong domain, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_multi_val_on_domain\n");fflush(stdout);
#endif
	isl_union_set* domain_c = (isl_union_set*) GECOS_PTRSIZE domain; 
	if(((void*)domain_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_multi_val_on_domain for parameter domain");
		goto error;
	}
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_multi_val_on_domain for parameter mv");
		goto error;
	}

	isl_multi_union_pw_aff* res = (isl_multi_union_pw_aff*) isl_multi_union_pw_aff_multi_val_on_domain(domain_c, mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_multi_val_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1multi_1aff_1on_1domain
(JNIEnv *env, jclass class, jlong domain, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_multi_aff_on_domain\n");fflush(stdout);
#endif
	isl_union_set* domain_c = (isl_union_set*) GECOS_PTRSIZE domain; 
	if(((void*)domain_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_multi_aff_on_domain for parameter domain");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_multi_aff_on_domain for parameter ma");
		goto error;
	}

	isl_multi_union_pw_aff* res = (isl_multi_union_pw_aff*) isl_multi_union_pw_aff_multi_aff_on_domain(domain_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_multi_aff_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1from_1union_1pw_1aff_1list
(JNIEnv *env, jclass class, jlong space, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_from_union_pw_aff_list\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_from_union_pw_aff_list for parameter space");
		goto error;
	}
	isl_union_pw_aff_list* list_c = (isl_union_pw_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_from_union_pw_aff_list for parameter list");
		goto error;
	}

	isl_multi_union_pw_aff* res = (isl_multi_union_pw_aff*) isl_multi_union_pw_aff_from_union_pw_aff_list(space_c, list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_from_union_pw_aff_list\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1get_1ctx
(JNIEnv *env, jclass class, jlong mupa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_get_ctx\n");fflush(stdout);
#endif
	isl_multi_union_pw_aff* mupa_c = (isl_multi_union_pw_aff*) GECOS_PTRSIZE mupa; 
	if(((void*)mupa_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_get_ctx for parameter mupa");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_multi_union_pw_aff_get_ctx(mupa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1get_1space
(JNIEnv *env, jclass class, jlong mupa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_get_space\n");fflush(stdout);
#endif
	isl_multi_union_pw_aff* mupa_c = (isl_multi_union_pw_aff*) GECOS_PTRSIZE mupa; 
	if(((void*)mupa_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_get_space for parameter mupa");
		goto error;
	}

	isl_space* res = (isl_space*) isl_multi_union_pw_aff_get_space(mupa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1copy
(JNIEnv *env, jclass class, jlong mupa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_copy\n");fflush(stdout);
#endif
	isl_multi_union_pw_aff* mupa_c = (isl_multi_union_pw_aff*) GECOS_PTRSIZE mupa; 
	if(((void*)mupa_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_copy for parameter mupa");
		goto error;
	}

	isl_multi_union_pw_aff* res = (isl_multi_union_pw_aff*) isl_multi_union_pw_aff_copy(mupa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1free
(JNIEnv *env, jclass class, jlong mupa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_free\n");fflush(stdout);
#endif
	isl_multi_union_pw_aff* mupa_c = (isl_multi_union_pw_aff*) GECOS_PTRSIZE mupa; 
	if(((void*)mupa_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_free for parameter mupa");
		goto error;
	}

	 isl_multi_union_pw_aff_free(mupa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_free\n");fflush(stdout);
#endif
	
error:
	return;
}


