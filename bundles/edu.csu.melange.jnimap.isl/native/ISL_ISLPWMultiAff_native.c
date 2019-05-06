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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1pw_1aff_1from_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_pw_aff_from_pw_multi_aff\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_pw_aff_from_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_multi_pw_aff* res = (isl_multi_pw_aff*) isl_multi_pw_aff_from_pw_multi_aff(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_pw_aff_from_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1from_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_from_pw_multi_aff\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_from_pw_multi_aff(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_from_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1from_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_from_pw_multi_aff\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_set_from_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_from_pw_multi_aff(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_from_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1get_1ctx
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_get_ctx\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_get_ctx for parameter pma");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_pw_multi_aff_get_ctx(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1get_1space
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_get_space\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_get_space for parameter pma");
		goto error;
	}

	isl_space* res = (isl_space*) isl_pw_multi_aff_get_space(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1get_1domain_1space
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_get_domain_space\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_get_domain_space for parameter pma");
		goto error;
	}

	isl_space* res = (isl_space*) isl_pw_multi_aff_get_domain_space(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_get_domain_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1copy
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_copy\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_copy for parameter pma");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_copy(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1free
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_free\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_free for parameter pma");
		goto error;
	}

	 isl_pw_multi_aff_free(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_pw_multi_aff_read_from_str for parameter str");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1alloc
(JNIEnv *env, jclass class, jlong set, jlong maff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_alloc\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_alloc for parameter set");
		goto error;
	}
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_alloc for parameter maff");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_alloc(set_c, maff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1zero
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_zero\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_zero for parameter space");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_zero(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1identity
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_identity\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_identity for parameter space");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_identity(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_identity\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1empty
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_empty\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_empty for parameter space");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_empty(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1from_1domain
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_from_domain\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_from_domain for parameter set");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_from_domain(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_from_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1dim
(JNIEnv *env, jclass class, jlong pma, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_dim\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_dim for parameter pma");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_pw_multi_aff_dim(pma_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1get_1pw_1aff
(JNIEnv *env, jclass class, jlong pma, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_get_pw_aff\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_get_pw_aff for parameter pma");
		goto error;
	}
	int pos_c = (int) pos;

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_multi_aff_get_pw_aff(pma_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_get_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1set_1pw_1aff
(JNIEnv *env, jclass class, jlong pma, jint pos, jlong pa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_set_pw_aff\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_set_pw_aff for parameter pma");
		goto error;
	}
	unsigned int pos_c = (unsigned int) pos;
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_set_pw_aff for parameter pa");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_set_pw_aff(pma_c, pos_c, pa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_set_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1has_1tuple_1name
(JNIEnv *env, jclass class, jlong pma, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_has_tuple_name\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_has_tuple_name for parameter pma");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	int res = (int) isl_pw_multi_aff_has_tuple_name(pma_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_has_tuple_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1get_1tuple_1name
(JNIEnv *env, jclass class, jlong pma, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_get_tuple_name\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_get_tuple_name for parameter pma");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	char * res = (char *) isl_pw_multi_aff_get_tuple_name(pma_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_get_tuple_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1get_1dim_1name
(JNIEnv *env, jclass class, jlong pma, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_get_dim_name\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_get_dim_name for parameter pma");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_pw_multi_aff_get_dim_name(pma_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1drop_1dims
(JNIEnv *env, jclass class, jlong pma, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_drop_dims\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_drop_dims for parameter pma");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_drop_dims(pma_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1domain
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_domain\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_domain for parameter pma");
		goto error;
	}

	isl_set* res = (isl_set*) isl_pw_multi_aff_domain(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_plain_is_equal\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_plain_is_equal for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_plain_is_equal for parameter pma2");
		goto error;
	}

	int res = (int) isl_pw_multi_aff_plain_is_equal(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1union_1add
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_union_add\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_union_add for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_union_add for parameter pma2");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_union_add(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_union_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1add
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_add\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_add for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_add for parameter pma2");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_add(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1sub
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_sub\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_sub for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_sub for parameter pma2");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_sub(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1scale_1val
(JNIEnv *env, jclass class, jlong pma, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_scale_val\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_scale_val for parameter pma");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_scale_val for parameter v");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_scale_val(pma_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_scale_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1scale_1multi_1val
(JNIEnv *env, jclass class, jlong pma, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_scale_multi_val\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_scale_multi_val for parameter pma");
		goto error;
	}
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_scale_multi_val for parameter mv");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_scale_multi_val(pma_c, mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_scale_multi_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1union_1lexmin
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_union_lexmin\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_union_lexmin for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_union_lexmin for parameter pma2");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_union_lexmin(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_union_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1union_1lexmax
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_union_lexmax\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_union_lexmax for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_union_lexmax for parameter pma2");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_union_lexmax(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_union_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1range_1product
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_range_product\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_range_product for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_range_product for parameter pma2");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_range_product(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_range_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1flat_1range_1product
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_flat_range_product\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_flat_range_product for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_flat_range_product for parameter pma2");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_flat_range_product(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_flat_range_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1product
(JNIEnv *env, jclass class, jlong pma1, jlong pma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_product\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma1_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma1; 
	if(((void*)pma1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_product for parameter pma1");
		goto error;
	}
	isl_pw_multi_aff* pma2_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma2; 
	if(((void*)pma2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_product for parameter pma2");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_product(pma1_c, pma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1intersect_1params
(JNIEnv *env, jclass class, jlong pma, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_intersect_params\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_intersect_params for parameter pma");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_intersect_params for parameter set");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_intersect_params(pma_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1intersect_1domain
(JNIEnv *env, jclass class, jlong pma, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_intersect_domain\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_intersect_domain for parameter pma");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_intersect_domain for parameter set");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_intersect_domain(pma_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1project_1domain_1on_1params
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_project_domain_on_params\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_project_domain_on_params for parameter pma");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_project_domain_on_params(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_project_domain_on_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1align_1params
(JNIEnv *env, jclass class, jlong pma, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_align_params\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_align_params for parameter pma");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_align_params for parameter model");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_align_params(pma_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1coalesce
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_coalesce\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_coalesce for parameter pma");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_coalesce(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1gist
(JNIEnv *env, jclass class, jlong pma, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_gist\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_gist for parameter pma");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_gist for parameter set");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_gist(pma_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1numberof_1piece
(JNIEnv *env, jclass class, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_numberof_piece\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_numberof_piece for parameter pma");
		goto error;
	}

	int res = (int) isl_pw_multi_aff_numberof_piece(pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_numberof_piece\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1get_1piece_1at
(JNIEnv *env, jclass class, jlong pma, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_get_piece_at\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_get_piece_at for parameter pma");
		goto error;
	}
	int pos_c = (int) pos;

	struct isl_pw_multi_aff_piece* res = (struct isl_pw_multi_aff_piece*) isl_pw_multi_aff_get_piece_at(pma_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_get_piece_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1to_1string
(JNIEnv *env, jclass class, jlong pma, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_to_string\n");fflush(stdout);
#endif
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_to_string for parameter pma");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_pw_multi_aff_to_string(pma_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


