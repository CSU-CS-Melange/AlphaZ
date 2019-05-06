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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_union_pw_multi_aff_read_from_str for parameter str");
		goto error;
	}

	isl_union_pw_multi_aff* res = (isl_union_pw_multi_aff*) isl_union_pw_multi_aff_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1from_1union_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong upma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_from_union_pw_multi_aff\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_from_union_pw_multi_aff for parameter upma");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_from_union_pw_multi_aff(upma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_from_union_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1get_1ctx
(JNIEnv *env, jclass class, jlong upma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_get_ctx\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_get_ctx for parameter upma");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_union_pw_multi_aff_get_ctx(upma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1get_1space
(JNIEnv *env, jclass class, jlong upma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_get_space\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_get_space for parameter upma");
		goto error;
	}

	isl_space* res = (isl_space*) isl_union_pw_multi_aff_get_space(upma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1copy
(JNIEnv *env, jclass class, jlong upma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_copy\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_copy for parameter upma");
		goto error;
	}

	isl_union_pw_multi_aff* res = (isl_union_pw_multi_aff*) isl_union_pw_multi_aff_copy(upma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1free
(JNIEnv *env, jclass class, jlong upma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_free\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_free for parameter upma");
		goto error;
	}

	 isl_union_pw_multi_aff_free(upma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1empty
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_empty\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_empty for parameter space");
		goto error;
	}

	isl_union_pw_multi_aff* res = (isl_union_pw_multi_aff*) isl_union_pw_multi_aff_empty(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1from_1domain
(JNIEnv *env, jclass class, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_from_domain\n");fflush(stdout);
#endif
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_from_domain for parameter uset");
		goto error;
	}

	isl_union_pw_multi_aff* res = (isl_union_pw_multi_aff*) isl_union_pw_multi_aff_from_domain(uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_from_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1add_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong upma, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_add_pw_multi_aff\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_add_pw_multi_aff for parameter upma");
		goto error;
	}
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_add_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_union_pw_multi_aff* res = (isl_union_pw_multi_aff*) isl_union_pw_multi_aff_add_pw_multi_aff(upma_c, pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_add_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1add
(JNIEnv *env, jclass class, jlong upma1, jlong upma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_add\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma1_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma1; 
	if(((void*)upma1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_add for parameter upma1");
		goto error;
	}
	isl_union_pw_multi_aff* upma2_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma2; 
	if(((void*)upma2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_add for parameter upma2");
		goto error;
	}

	isl_union_pw_multi_aff* res = (isl_union_pw_multi_aff*) isl_union_pw_multi_aff_add(upma1_c, upma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1sub
(JNIEnv *env, jclass class, jlong upma1, jlong upma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_sub\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma1_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma1; 
	if(((void*)upma1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_sub for parameter upma1");
		goto error;
	}
	isl_union_pw_multi_aff* upma2_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma2; 
	if(((void*)upma2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_sub for parameter upma2");
		goto error;
	}

	isl_union_pw_multi_aff* res = (isl_union_pw_multi_aff*) isl_union_pw_multi_aff_sub(upma1_c, upma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1pw_1multi_1aff_1to_1string
(JNIEnv *env, jclass class, jlong upma, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_pw_multi_aff_to_string\n");fflush(stdout);
#endif
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_pw_multi_aff_to_string for parameter upma");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_union_pw_multi_aff_to_string(upma_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_pw_multi_aff_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


