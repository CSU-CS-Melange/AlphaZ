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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1alloc
(JNIEnv *env, jclass class, jlong ctx, jint nparam, jint n_in, jint n_out)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_alloc\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_space_alloc for parameter ctx");
		goto error;
	}
	unsigned int nparam_c = (unsigned int) nparam;
	unsigned int n_in_c = (unsigned int) n_in;
	unsigned int n_out_c = (unsigned int) n_out;

	isl_space* res = (isl_space*) isl_space_alloc(ctx_c, nparam_c, n_in_c, n_out_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1params_1alloc
(JNIEnv *env, jclass class, jlong ctx, jint nparam)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_params_alloc\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_space_params_alloc for parameter ctx");
		goto error;
	}
	unsigned int nparam_c = (unsigned int) nparam;

	isl_space* res = (isl_space*) isl_space_params_alloc(ctx_c, nparam_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_params_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1set_1alloc
(JNIEnv *env, jclass class, jlong ctx, jint nparam, jint dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_set_alloc\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_space_set_alloc for parameter ctx");
		goto error;
	}
	unsigned int nparam_c = (unsigned int) nparam;
	unsigned int dim_c = (unsigned int) dim;

	isl_space* res = (isl_space*) isl_space_set_alloc(ctx_c, nparam_c, dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_set_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1get_1ctx
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_get_ctx\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_space_get_ctx for parameter dim");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_space_get_ctx(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1copy
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_copy\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_copy for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_copy(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1free
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_free\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_free for parameter space");
		goto error;
	}

	 isl_space_free(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1dim
(JNIEnv *env, jclass class, jlong space, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_dim\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_dim for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_space_dim(space_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1is_1params
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_is_params\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_params for parameter space");
		goto error;
	}

	int res = (int) isl_space_is_params(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_is_params\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1is_1set
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_is_set\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_set for parameter space");
		goto error;
	}

	int res = (int) isl_space_is_set(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_is_set\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1is_1map
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_is_map\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_map for parameter space");
		goto error;
	}

	int res = (int) isl_space_is_map(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_is_map\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1is_1equal
(JNIEnv *env, jclass class, jlong space1, jlong space2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_is_equal\n");fflush(stdout);
#endif
	isl_space* space1_c = (isl_space*) GECOS_PTRSIZE space1; 
	if(((void*)space1_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_equal for parameter space1");
		goto error;
	}
	isl_space* space2_c = (isl_space*) GECOS_PTRSIZE space2; 
	if(((void*)space2_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_equal for parameter space2");
		goto error;
	}

	int res = (int) isl_space_is_equal(space1_c, space2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1is_1domain
(JNIEnv *env, jclass class, jlong space1, jlong space2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_is_domain\n");fflush(stdout);
#endif
	isl_space* space1_c = (isl_space*) GECOS_PTRSIZE space1; 
	if(((void*)space1_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_domain for parameter space1");
		goto error;
	}
	isl_space* space2_c = (isl_space*) GECOS_PTRSIZE space2; 
	if(((void*)space2_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_domain for parameter space2");
		goto error;
	}

	int res = (int) isl_space_is_domain(space1_c, space2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_is_domain\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1is_1range
(JNIEnv *env, jclass class, jlong space1, jlong space2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_is_range\n");fflush(stdout);
#endif
	isl_space* space1_c = (isl_space*) GECOS_PTRSIZE space1; 
	if(((void*)space1_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_range for parameter space1");
		goto error;
	}
	isl_space* space2_c = (isl_space*) GECOS_PTRSIZE space2; 
	if(((void*)space2_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_range for parameter space2");
		goto error;
	}

	int res = (int) isl_space_is_range(space1_c, space2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_is_range\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1set_1dim_1name
(JNIEnv *env, jclass class, jlong space, jint type, jint pos, jstring name)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_set_dim_name\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_set_dim_name for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* name_c;
	name_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, name, NULL);
	if (name_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_space_set_dim_name for parameter name");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_set_dim_name(space_c, type_c, pos_c, name_c);

	(*env)->ReleaseStringUTFChars(env, name, name_c);

#ifdef TRACE_ALL
	printf("Leaving isl_space_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1get_1dim_1name
(JNIEnv *env, jclass class, jlong space, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_get_dim_name\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_get_dim_name for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_space_get_dim_name(space_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1has_1dim_1name
(JNIEnv *env, jclass class, jlong space, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_has_dim_name\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_has_dim_name for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_space_has_dim_name(space_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_has_dim_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1find_1dim_1by_1name
(JNIEnv *env, jclass class, jlong space, jint type, jstring name)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_find_dim_by_name\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_find_dim_by_name for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	char* name_c;
	name_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, name, NULL);
	if (name_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_space_find_dim_by_name for parameter name");
		goto error;
	}

	int res = (int) isl_space_find_dim_by_name(space_c, type_c, name_c);

	(*env)->ReleaseStringUTFChars(env, name, name_c);

#ifdef TRACE_ALL
	printf("Leaving isl_space_find_dim_by_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1set_1tuple_1name
(JNIEnv *env, jclass class, jlong space, jint type, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_set_tuple_name\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_set_tuple_name for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_space_set_tuple_name for parameter s");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_set_tuple_name(space_c, type_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_space_set_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1get_1tuple_1name
(JNIEnv *env, jclass class, jlong space, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_get_tuple_name\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_get_tuple_name for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	char * res = (char *) isl_space_get_tuple_name(space_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_get_tuple_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1has_1tuple_1name
(JNIEnv *env, jclass class, jlong space, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_has_tuple_name\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_has_tuple_name for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	int res = (int) isl_space_has_tuple_name(space_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_has_tuple_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1is_1wrapping
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_is_wrapping\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_is_wrapping for parameter space");
		goto error;
	}

	int res = (int) isl_space_is_wrapping(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_is_wrapping\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1domain_1is_1wrapping
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_domain_is_wrapping\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_domain_is_wrapping for parameter space");
		goto error;
	}

	int res = (int) isl_space_domain_is_wrapping(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_domain_is_wrapping\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1range_1is_1wrapping
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_range_is_wrapping\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_range_is_wrapping for parameter space");
		goto error;
	}

	int res = (int) isl_space_range_is_wrapping(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_range_is_wrapping\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1domain
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_domain\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_domain for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_domain(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1from_1domain
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_from_domain\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_from_domain for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_from_domain(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_from_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1range
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_range\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_range for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_range(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1from_1range
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_from_range\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_from_range for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_from_range(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_from_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1domain_1map
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_domain_map\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_domain_map for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_domain_map(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_domain_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1range_1map
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_range_map\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_range_map for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_range_map(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_range_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1params
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_params\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_params for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_params(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1set_1from_1params
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_set_from_params\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_set_from_params for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_set_from_params(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_set_from_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1reverse
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_reverse\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_reverse for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_reverse(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_reverse\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1join
(JNIEnv *env, jclass class, jlong left, jlong right)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_join\n");fflush(stdout);
#endif
	isl_space* left_c = (isl_space*) GECOS_PTRSIZE left; 
	if(((void*)left_c)==NULL) {
		throwException(env, "Null pointer in isl_space_join for parameter left");
		goto error;
	}
	isl_space* right_c = (isl_space*) GECOS_PTRSIZE right; 
	if(((void*)right_c)==NULL) {
		throwException(env, "Null pointer in isl_space_join for parameter right");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_join(left_c, right_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_join\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1align_1params
(JNIEnv *env, jclass class, jlong space1, jlong space2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_align_params\n");fflush(stdout);
#endif
	isl_space* space1_c = (isl_space*) GECOS_PTRSIZE space1; 
	if(((void*)space1_c)==NULL) {
		throwException(env, "Null pointer in isl_space_align_params for parameter space1");
		goto error;
	}
	isl_space* space2_c = (isl_space*) GECOS_PTRSIZE space2; 
	if(((void*)space2_c)==NULL) {
		throwException(env, "Null pointer in isl_space_align_params for parameter space2");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_align_params(space1_c, space2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1insert_1dims
(JNIEnv *env, jclass class, jlong space, jint type, jint pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_insert_dims\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_insert_dims for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	unsigned int n_c = (unsigned int) n;

	isl_space* res = (isl_space*) isl_space_insert_dims(space_c, type_c, pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1add_1dims
(JNIEnv *env, jclass class, jlong space, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_add_dims\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_add_dims for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_space* res = (isl_space*) isl_space_add_dims(space_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1drop_1dims
(JNIEnv *env, jclass class, jlong space, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_drop_dims\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_drop_dims for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_space* res = (isl_space*) isl_space_drop_dims(space_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1move_1dims
(JNIEnv *env, jclass class, jlong space, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_move_dims\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_move_dims for parameter space");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_space* res = (isl_space*) isl_space_move_dims(space_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1map_1from_1set
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_map_from_set\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_map_from_set for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_map_from_set(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_map_from_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1map_1from_1domain_1and_1range
(JNIEnv *env, jclass class, jlong domain, jlong range)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_map_from_domain_and_range\n");fflush(stdout);
#endif
	isl_space* domain_c = (isl_space*) GECOS_PTRSIZE domain; 
	if(((void*)domain_c)==NULL) {
		throwException(env, "Null pointer in isl_space_map_from_domain_and_range for parameter domain");
		goto error;
	}
	isl_space* range_c = (isl_space*) GECOS_PTRSIZE range; 
	if(((void*)range_c)==NULL) {
		throwException(env, "Null pointer in isl_space_map_from_domain_and_range for parameter range");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_map_from_domain_and_range(domain_c, range_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_map_from_domain_and_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1wrap
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_wrap\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_wrap for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_wrap(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_wrap\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1unwrap
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_unwrap\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_space_unwrap for parameter space");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_unwrap(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_unwrap\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1space_1product
(JNIEnv *env, jclass class, jlong left, jlong right)
 {
#ifdef TRACE_ALL
	printf("Entering isl_space_product\n");fflush(stdout);
#endif
	isl_space* left_c = (isl_space*) GECOS_PTRSIZE left; 
	if(((void*)left_c)==NULL) {
		throwException(env, "Null pointer in isl_space_product for parameter left");
		goto error;
	}
	isl_space* right_c = (isl_space*) GECOS_PTRSIZE right; 
	if(((void*)right_c)==NULL) {
		throwException(env, "Null pointer in isl_space_product for parameter right");
		goto error;
	}

	isl_space* res = (isl_space*) isl_space_product(left_c, right_c);


#ifdef TRACE_ALL
	printf("Leaving isl_space_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lex_1lt
(JNIEnv *env, jclass class, jlong set_space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lex_lt\n");fflush(stdout);
#endif
	isl_space* set_space_c = (isl_space*) GECOS_PTRSIZE set_space; 
	if(((void*)set_space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lex_lt for parameter set_space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_lex_lt(set_space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lex_lt\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lex_1le
(JNIEnv *env, jclass class, jlong set_space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lex_le\n");fflush(stdout);
#endif
	isl_space* set_space_c = (isl_space*) GECOS_PTRSIZE set_space; 
	if(((void*)set_space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lex_le for parameter set_space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_lex_le(set_space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lex_le\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lex_1gt
(JNIEnv *env, jclass class, jlong set_space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lex_gt\n");fflush(stdout);
#endif
	isl_space* set_space_c = (isl_space*) GECOS_PTRSIZE set_space; 
	if(((void*)set_space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lex_gt for parameter set_space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_lex_gt(set_space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lex_gt\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lex_1ge
(JNIEnv *env, jclass class, jlong set_space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lex_ge\n");fflush(stdout);
#endif
	isl_space* set_space_c = (isl_space*) GECOS_PTRSIZE set_space; 
	if(((void*)set_space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lex_ge for parameter set_space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_lex_ge(set_space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lex_ge\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lex_1lt_1first
(JNIEnv *env, jclass class, jlong space, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lex_lt_first\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lex_lt_first for parameter space");
		goto error;
	}
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_lex_lt_first(space_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lex_lt_first\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lex_1le_1first
(JNIEnv *env, jclass class, jlong space, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lex_le_first\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lex_le_first for parameter space");
		goto error;
	}
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_lex_le_first(space_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lex_le_first\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lex_1gt_1first
(JNIEnv *env, jclass class, jlong space, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lex_gt_first\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lex_gt_first for parameter space");
		goto error;
	}
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_lex_gt_first(space_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lex_gt_first\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lex_1ge_1first
(JNIEnv *env, jclass class, jlong space, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lex_ge_first\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lex_ge_first for parameter space");
		goto error;
	}
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_lex_ge_first(space_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lex_ge_first\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


