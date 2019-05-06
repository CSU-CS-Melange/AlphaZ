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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1from_1val_1list
(JNIEnv *env, jclass class, jlong space, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_from_val_list\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_from_val_list for parameter space");
		goto error;
	}
	isl_val_list* list_c = (isl_val_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_from_val_list for parameter list");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_from_val_list(space_c, list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_from_val_list\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1zero
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_zero\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_zero for parameter space");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_zero(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1get_1ctx
(JNIEnv *env, jclass class, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_get_ctx\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_get_ctx for parameter mv");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_multi_val_get_ctx(mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1get_1space
(JNIEnv *env, jclass class, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_get_space\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_get_space for parameter mv");
		goto error;
	}

	isl_space* res = (isl_space*) isl_multi_val_get_space(mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1copy
(JNIEnv *env, jclass class, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_copy\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_copy for parameter mv");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_copy(mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1free
(JNIEnv *env, jclass class, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_free\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_free for parameter mv");
		goto error;
	}

	 isl_multi_val_free(mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1dim
(JNIEnv *env, jclass class, jlong mv, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_dim\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_dim for parameter mv");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_multi_val_dim(mv_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1get_1val
(JNIEnv *env, jclass class, jlong mv, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_get_val\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_get_val for parameter mv");
		goto error;
	}
	int pos_c = (int) pos;

	isl_val* res = (isl_val*) isl_multi_val_get_val(mv_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_get_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1set_1val
(JNIEnv *env, jclass class, jlong mv, jint pos, jlong val)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_set_val\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_set_val for parameter mv");
		goto error;
	}
	int pos_c = (int) pos;
	isl_val* val_c = (isl_val*) GECOS_PTRSIZE val; 
	if(((void*)val_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_set_val for parameter val");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_set_val(mv_c, pos_c, val_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_set_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1set_1dim_1name
(JNIEnv *env, jclass class, jlong mv, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_set_dim_name\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_set_dim_name for parameter mv");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_multi_val_set_dim_name for parameter s");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_set_dim_name(mv_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1get_1tuple_1name
(JNIEnv *env, jclass class, jlong mv, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_get_tuple_name\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_get_tuple_name for parameter mv");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	char * res = (char *) isl_multi_val_get_tuple_name(mv_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_get_tuple_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1set_1tuple_1name
(JNIEnv *env, jclass class, jlong mv, jint type, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_set_tuple_name\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_set_tuple_name for parameter mv");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_multi_val_set_tuple_name for parameter s");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_set_tuple_name(mv_c, type_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_set_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1has_1tuple_1id
(JNIEnv *env, jclass class, jlong mv, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_has_tuple_id\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_has_tuple_id for parameter mv");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	int res = (int) isl_multi_val_has_tuple_id(mv_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_has_tuple_id\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1range_1is_1wrapping
(JNIEnv *env, jclass class, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_range_is_wrapping\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_range_is_wrapping for parameter mv");
		goto error;
	}

	int res = (int) isl_multi_val_range_is_wrapping(mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_range_is_wrapping\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1insert_1dims
(JNIEnv *env, jclass class, jlong mv, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_insert_dims\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_insert_dims for parameter mv");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_insert_dims(mv_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1add_1dims
(JNIEnv *env, jclass class, jlong mv, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_add_dims\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_add_dims for parameter mv");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_add_dims(mv_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1drop_1dims
(JNIEnv *env, jclass class, jlong mv, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_drop_dims\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_drop_dims for parameter mv");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_drop_dims(mv_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1align_1params
(JNIEnv *env, jclass class, jlong mv, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_align_params\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_align_params for parameter mv");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_align_params for parameter model");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_align_params(mv_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1from_1range
(JNIEnv *env, jclass class, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_from_range\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_from_range for parameter mv");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_from_range(mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_from_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1range_1splice
(JNIEnv *env, jclass class, jlong mv1, jint pos, jlong mv2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_range_splice\n");fflush(stdout);
#endif
	isl_multi_val* mv1_c = (isl_multi_val*) GECOS_PTRSIZE mv1; 
	if(((void*)mv1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_range_splice for parameter mv1");
		goto error;
	}
	unsigned int pos_c = (unsigned int) pos;
	isl_multi_val* mv2_c = (isl_multi_val*) GECOS_PTRSIZE mv2; 
	if(((void*)mv2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_range_splice for parameter mv2");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_range_splice(mv1_c, pos_c, mv2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_range_splice\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1range_1product
(JNIEnv *env, jclass class, jlong mv1, jlong mv2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_range_product\n");fflush(stdout);
#endif
	isl_multi_val* mv1_c = (isl_multi_val*) GECOS_PTRSIZE mv1; 
	if(((void*)mv1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_range_product for parameter mv1");
		goto error;
	}
	isl_multi_val* mv2_c = (isl_multi_val*) GECOS_PTRSIZE mv2; 
	if(((void*)mv2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_range_product for parameter mv2");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_range_product(mv1_c, mv2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_range_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1range_1factor_1domain
(JNIEnv *env, jclass class, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_range_factor_domain\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_range_factor_domain for parameter mv");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_range_factor_domain(mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_range_factor_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1range_1factor_1range
(JNIEnv *env, jclass class, jlong mv)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_range_factor_range\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_range_factor_range for parameter mv");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_range_factor_range(mv_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_range_factor_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1product
(JNIEnv *env, jclass class, jlong mv1, jlong mv2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_product\n");fflush(stdout);
#endif
	isl_multi_val* mv1_c = (isl_multi_val*) GECOS_PTRSIZE mv1; 
	if(((void*)mv1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_product for parameter mv1");
		goto error;
	}
	isl_multi_val* mv2_c = (isl_multi_val*) GECOS_PTRSIZE mv2; 
	if(((void*)mv2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_product for parameter mv2");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_product(mv1_c, mv2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1add_1val
(JNIEnv *env, jclass class, jlong mv, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_add_val\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_add_val for parameter mv");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_add_val for parameter v");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_add_val(mv_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_add_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1mod_1val
(JNIEnv *env, jclass class, jlong mv, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_mod_val\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_mod_val for parameter mv");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_mod_val for parameter v");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_mod_val(mv_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_mod_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1scale_1val
(JNIEnv *env, jclass class, jlong mv, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_scale_val\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_scale_val for parameter mv");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_scale_val for parameter v");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_scale_val(mv_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_scale_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1scale_1multi_1val
(JNIEnv *env, jclass class, jlong mv1, jlong mv2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_scale_multi_val\n");fflush(stdout);
#endif
	isl_multi_val* mv1_c = (isl_multi_val*) GECOS_PTRSIZE mv1; 
	if(((void*)mv1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_scale_multi_val for parameter mv1");
		goto error;
	}
	isl_multi_val* mv2_c = (isl_multi_val*) GECOS_PTRSIZE mv2; 
	if(((void*)mv2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_scale_multi_val for parameter mv2");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_scale_multi_val(mv1_c, mv2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_scale_multi_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1scale_1down_1multi_1val
(JNIEnv *env, jclass class, jlong mv1, jlong mv2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_scale_down_multi_val\n");fflush(stdout);
#endif
	isl_multi_val* mv1_c = (isl_multi_val*) GECOS_PTRSIZE mv1; 
	if(((void*)mv1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_scale_down_multi_val for parameter mv1");
		goto error;
	}
	isl_multi_val* mv2_c = (isl_multi_val*) GECOS_PTRSIZE mv2; 
	if(((void*)mv2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_scale_down_multi_val for parameter mv2");
		goto error;
	}

	isl_multi_val* res = (isl_multi_val*) isl_multi_val_scale_down_multi_val(mv1_c, mv2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_scale_down_multi_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1val_1to_1string
(JNIEnv *env, jclass class, jlong mv, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_val_to_string\n");fflush(stdout);
#endif
	isl_multi_val* mv_c = (isl_multi_val*) GECOS_PTRSIZE mv; 
	if(((void*)mv_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_val_to_string for parameter mv");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_multi_val_to_string(mv_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_val_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


