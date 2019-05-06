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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_aff_read_from_str for parameter str");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_aff_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1from_1aff
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_from_aff\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_from_aff for parameter aff");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_from_aff(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_from_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1equality_1from_1aff
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_equality_from_aff\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_equality_from_aff for parameter aff");
		goto error;
	}

	isl_constraint* res = (isl_constraint*) isl_equality_from_aff(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_equality_from_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1inequality_1from_1aff
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_inequality_from_aff\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_inequality_from_aff for parameter aff");
		goto error;
	}

	isl_constraint* res = (isl_constraint*) isl_inequality_from_aff(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_inequality_from_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1zero_1on_1domain
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_zero_on_domain\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_zero_on_domain for parameter ls");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_zero_on_domain(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_zero_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1ctx
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_ctx\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_ctx for parameter aff");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_aff_get_ctx(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1space
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_space\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_space for parameter aff");
		goto error;
	}

	isl_space* res = (isl_space*) isl_aff_get_space(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1local_1space
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_local_space\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_local_space for parameter aff");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_aff_get_local_space(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_local_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1copy
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_copy\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_copy for parameter aff");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_copy(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1free
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_free\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_free for parameter aff");
		goto error;
	}

	 isl_aff_free(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1domain_1space
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_domain_space\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_domain_space for parameter aff");
		goto error;
	}

	isl_space* res = (isl_space*) isl_aff_get_domain_space(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_domain_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1domain_1local_1space
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_domain_local_space\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_domain_local_space for parameter aff");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_aff_get_domain_local_space(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_domain_local_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1align_1params
(JNIEnv *env, jclass class, jlong aff, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_align_params\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_align_params for parameter aff");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_align_params for parameter model");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_align_params(aff_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1dim
(JNIEnv *env, jclass class, jlong aff, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_dim\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_dim for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	int res = (int) isl_aff_dim(aff_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1involves_1dims
(JNIEnv *env, jclass class, jlong aff, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_involves_dims\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_involves_dims for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_aff_involves_dims(aff_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1insert_1dims
(JNIEnv *env, jclass class, jlong aff, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_insert_dims\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_insert_dims for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_aff* res = (isl_aff*) isl_aff_insert_dims(aff_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1add_1dims
(JNIEnv *env, jclass class, jlong aff, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_add_dims\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_add_dims for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_aff* res = (isl_aff*) isl_aff_add_dims(aff_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1move_1dims
(JNIEnv *env, jclass class, jlong aff, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_move_dims\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_move_dims for parameter aff");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_aff* res = (isl_aff*) isl_aff_move_dims(aff_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1drop_1dims
(JNIEnv *env, jclass class, jlong aff, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_drop_dims\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_drop_dims for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_aff* res = (isl_aff*) isl_aff_drop_dims(aff_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1dim_1name
(JNIEnv *env, jclass class, jlong aff, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_dim_name\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_dim_name for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_aff_get_dim_name(aff_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1set_1dim_1name
(JNIEnv *env, jclass class, jlong aff, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_set_dim_name\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_set_dim_name for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_aff_set_dim_name for parameter s");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_set_dim_name(aff_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_aff_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1constant_1val
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_constant_val\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_constant_val for parameter aff");
		goto error;
	}

	isl_val* res = (isl_val*) isl_aff_get_constant_val(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_constant_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1coefficient_1val
(JNIEnv *env, jclass class, jlong aff, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_coefficient_val\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_coefficient_val for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;

	isl_val* res = (isl_val*) isl_aff_get_coefficient_val(aff_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_coefficient_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1denominator_1val
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_denominator_val\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_denominator_val for parameter aff");
		goto error;
	}

	isl_val* res = (isl_val*) isl_aff_get_denominator_val(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_denominator_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1set_1constant_1si
(JNIEnv *env, jclass class, jlong aff, jint v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_set_constant_si\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_set_constant_si for parameter aff");
		goto error;
	}
	int v_c = (int) v;

	isl_aff* res = (isl_aff*) isl_aff_set_constant_si(aff_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_set_constant_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1set_1constant_1val
(JNIEnv *env, jclass class, jlong aff, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_set_constant_val\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_set_constant_val for parameter aff");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_set_constant_val for parameter v");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_set_constant_val(aff_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_set_constant_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1set_1coefficient_1si
(JNIEnv *env, jclass class, jlong aff, jint type, jint pos, jint v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_set_coefficient_si\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_set_coefficient_si for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;
	int v_c = (int) v;

	isl_aff* res = (isl_aff*) isl_aff_set_coefficient_si(aff_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_set_coefficient_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1set_1coefficient_1val
(JNIEnv *env, jclass class, jlong aff, jint type, jint pos, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_set_coefficient_val\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_set_coefficient_val for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_set_coefficient_val for parameter v");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_set_coefficient_val(aff_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_set_coefficient_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1is_1cst
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_is_cst\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_is_cst for parameter aff");
		goto error;
	}

	int res = (int) isl_aff_is_cst(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_is_cst\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong aff1, jlong aff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_plain_is_equal\n");fflush(stdout);
#endif
	isl_aff* aff1_c = (isl_aff*) GECOS_PTRSIZE aff1; 
	if(((void*)aff1_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_plain_is_equal for parameter aff1");
		goto error;
	}
	isl_aff* aff2_c = (isl_aff*) GECOS_PTRSIZE aff2; 
	if(((void*)aff2_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_plain_is_equal for parameter aff2");
		goto error;
	}

	int res = (int) isl_aff_plain_is_equal(aff1_c, aff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1plain_1is_1zero
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_plain_is_zero\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_plain_is_zero for parameter aff");
		goto error;
	}

	int res = (int) isl_aff_plain_is_zero(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_plain_is_zero\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1is_1nan
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_is_nan\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_is_nan for parameter aff");
		goto error;
	}

	int res = (int) isl_aff_is_nan(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_is_nan\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1get_1div
(JNIEnv *env, jclass class, jlong aff, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_get_div\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_get_div for parameter aff");
		goto error;
	}
	int pos_c = (int) pos;

	isl_aff* res = (isl_aff*) isl_aff_get_div(aff_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_get_div\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1neg
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_neg\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_neg for parameter aff");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_neg(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_neg\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1ceil
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_ceil\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_ceil for parameter aff");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_ceil(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_ceil\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1floor
(JNIEnv *env, jclass class, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_floor\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_floor for parameter aff");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_floor(aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_floor\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1add
(JNIEnv *env, jclass class, jlong aff1, jlong aff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_add\n");fflush(stdout);
#endif
	isl_aff* aff1_c = (isl_aff*) GECOS_PTRSIZE aff1; 
	if(((void*)aff1_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_add for parameter aff1");
		goto error;
	}
	isl_aff* aff2_c = (isl_aff*) GECOS_PTRSIZE aff2; 
	if(((void*)aff2_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_add for parameter aff2");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_add(aff1_c, aff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1sub
(JNIEnv *env, jclass class, jlong aff1, jlong aff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_sub\n");fflush(stdout);
#endif
	isl_aff* aff1_c = (isl_aff*) GECOS_PTRSIZE aff1; 
	if(((void*)aff1_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_sub for parameter aff1");
		goto error;
	}
	isl_aff* aff2_c = (isl_aff*) GECOS_PTRSIZE aff2; 
	if(((void*)aff2_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_sub for parameter aff2");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_sub(aff1_c, aff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1mul
(JNIEnv *env, jclass class, jlong aff1, jlong aff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_mul\n");fflush(stdout);
#endif
	isl_aff* aff1_c = (isl_aff*) GECOS_PTRSIZE aff1; 
	if(((void*)aff1_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_mul for parameter aff1");
		goto error;
	}
	isl_aff* aff2_c = (isl_aff*) GECOS_PTRSIZE aff2; 
	if(((void*)aff2_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_mul for parameter aff2");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_mul(aff1_c, aff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_mul\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1div
(JNIEnv *env, jclass class, jlong aff1, jlong aff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_div\n");fflush(stdout);
#endif
	isl_aff* aff1_c = (isl_aff*) GECOS_PTRSIZE aff1; 
	if(((void*)aff1_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_div for parameter aff1");
		goto error;
	}
	isl_aff* aff2_c = (isl_aff*) GECOS_PTRSIZE aff2; 
	if(((void*)aff2_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_div for parameter aff2");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_div(aff1_c, aff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_div\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1scale_1val
(JNIEnv *env, jclass class, jlong aff, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_scale_val\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_scale_val for parameter aff");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_scale_val for parameter v");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_scale_val(aff_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_scale_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1mod_1val
(JNIEnv *env, jclass class, jlong aff, jlong mod)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_mod_val\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_mod_val for parameter aff");
		goto error;
	}
	isl_val* mod_c = (isl_val*) GECOS_PTRSIZE mod; 
	if(((void*)mod_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_mod_val for parameter mod");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_mod_val(aff_c, mod_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_mod_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1gist
(JNIEnv *env, jclass class, jlong aff, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_gist\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_gist for parameter aff");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_gist for parameter context");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_gist(aff_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1pullback_1aff
(JNIEnv *env, jclass class, jlong aff1, jlong aff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_pullback_aff\n");fflush(stdout);
#endif
	isl_aff* aff1_c = (isl_aff*) GECOS_PTRSIZE aff1; 
	if(((void*)aff1_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_pullback_aff for parameter aff1");
		goto error;
	}
	isl_aff* aff2_c = (isl_aff*) GECOS_PTRSIZE aff2; 
	if(((void*)aff2_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_pullback_aff for parameter aff2");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_pullback_aff(aff1_c, aff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_pullback_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1pullback_1multi_1aff
(JNIEnv *env, jclass class, jlong aff, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_pullback_multi_aff\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_pullback_multi_aff for parameter aff");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_pullback_multi_aff for parameter ma");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_aff_pullback_multi_aff(aff_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_pullback_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1to_1string
(JNIEnv *env, jclass class, jlong aff, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_to_string\n");fflush(stdout);
#endif
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_to_string for parameter aff");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_aff_to_string(aff_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


