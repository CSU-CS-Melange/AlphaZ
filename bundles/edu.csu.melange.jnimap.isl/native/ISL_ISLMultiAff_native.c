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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1from_1multi_1aff
(JNIEnv *env, jclass class, jlong maff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_from_multi_aff\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_from_multi_aff for parameter maff");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_from_multi_aff(maff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_from_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1from_1multi_1aff
(JNIEnv *env, jclass class, jlong maff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_from_multi_aff\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_multi_aff for parameter maff");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_from_multi_aff(maff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_from_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1pw_1aff_1from_1multi_1aff
(JNIEnv *env, jclass class, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_pw_aff_from_multi_aff\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_pw_aff_from_multi_aff for parameter ma");
		goto error;
	}

	isl_multi_pw_aff* res = (isl_multi_pw_aff*) isl_multi_pw_aff_from_multi_aff(ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_pw_aff_from_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1union_1pw_1aff_1from_1multi_1aff
(JNIEnv *env, jclass class, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_union_pw_aff_from_multi_aff\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_union_pw_aff_from_multi_aff for parameter ma");
		goto error;
	}

	isl_multi_union_pw_aff* res = (isl_multi_union_pw_aff*) isl_multi_union_pw_aff_from_multi_aff(ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_union_pw_aff_from_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1get_1ctx
(JNIEnv *env, jclass class, jlong maff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_get_ctx\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_get_ctx for parameter maff");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_multi_aff_get_ctx(maff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1get_1space
(JNIEnv *env, jclass class, jlong maff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_get_space\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_get_space for parameter maff");
		goto error;
	}

	isl_space* res = (isl_space*) isl_multi_aff_get_space(maff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1copy
(JNIEnv *env, jclass class, jlong maff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_copy\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_copy for parameter maff");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_copy(maff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1free
(JNIEnv *env, jclass class, jlong maff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_free\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_free for parameter maff");
		goto error;
	}

	 isl_multi_aff_free(maff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1get_1domain_1space
(JNIEnv *env, jclass class, jlong maff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_get_domain_space\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_get_domain_space for parameter maff");
		goto error;
	}

	isl_space* res = (isl_space*) isl_multi_aff_get_domain_space(maff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_get_domain_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1align_1params
(JNIEnv *env, jclass class, jlong multi, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_align_params\n");fflush(stdout);
#endif
	isl_multi_aff* multi_c = (isl_multi_aff*) GECOS_PTRSIZE multi; 
	if(((void*)multi_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_align_params for parameter multi");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_align_params for parameter model");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_align_params(multi_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_multi_aff_read_from_str for parameter str");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1zero
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_zero\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_zero for parameter space");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_zero(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1identity
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_identity\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_identity for parameter space");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_identity(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_identity\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1domain_1map
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_domain_map\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_domain_map for parameter space");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_domain_map(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_domain_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1range_1map
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_range_map\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_range_map for parameter space");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_range_map(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_range_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1project_1out_1map
(JNIEnv *env, jclass class, jlong space, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_project_out_map\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_project_out_map for parameter space");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_project_out_map(space_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_project_out_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1from_1aff_1list
(JNIEnv *env, jclass class, jlong space, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_from_aff_list\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_from_aff_list for parameter space");
		goto error;
	}
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_from_aff_list for parameter list");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_from_aff_list(space_c, list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_from_aff_list\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1dim
(JNIEnv *env, jclass class, jlong maff, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_dim\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_dim for parameter maff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_multi_aff_dim(maff_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1involves_1dims
(JNIEnv *env, jclass class, jlong ma, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_involves_dims\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_involves_dims for parameter ma");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_multi_aff_involves_dims(ma_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1insert_1dims
(JNIEnv *env, jclass class, jlong ma, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_insert_dims\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_insert_dims for parameter ma");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_insert_dims(ma_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1add_1dims
(JNIEnv *env, jclass class, jlong ma, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_add_dims\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_add_dims for parameter ma");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_add_dims(ma_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1drop_1dims
(JNIEnv *env, jclass class, jlong maff, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_drop_dims\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_drop_dims for parameter maff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_drop_dims(maff_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1move_1dims
(JNIEnv *env, jclass class, jlong ma, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_move_dims\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_move_dims for parameter ma");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_move_dims(ma_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1set_1dim_1name
(JNIEnv *env, jclass class, jlong aff, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_set_dim_name\n");fflush(stdout);
#endif
	isl_multi_aff* aff_c = (isl_multi_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_set_dim_name for parameter aff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_multi_aff_set_dim_name for parameter s");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_set_dim_name(aff_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1get_1aff
(JNIEnv *env, jclass class, jlong multi, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_get_aff\n");fflush(stdout);
#endif
	isl_multi_aff* multi_c = (isl_multi_aff*) GECOS_PTRSIZE multi; 
	if(((void*)multi_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_get_aff for parameter multi");
		goto error;
	}
	int pos_c = (int) pos;

	isl_aff* res = (isl_aff*) isl_multi_aff_get_aff(multi_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_get_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1set_1aff
(JNIEnv *env, jclass class, jlong multi, jint pos, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_set_aff\n");fflush(stdout);
#endif
	isl_multi_aff* multi_c = (isl_multi_aff*) GECOS_PTRSIZE multi; 
	if(((void*)multi_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_set_aff for parameter multi");
		goto error;
	}
	int pos_c = (int) pos;
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_set_aff for parameter aff");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_set_aff(multi_c, pos_c, aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_set_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong maff1, jlong maff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_plain_is_equal\n");fflush(stdout);
#endif
	isl_multi_aff* maff1_c = (isl_multi_aff*) GECOS_PTRSIZE maff1; 
	if(((void*)maff1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_plain_is_equal for parameter maff1");
		goto error;
	}
	isl_multi_aff* maff2_c = (isl_multi_aff*) GECOS_PTRSIZE maff2; 
	if(((void*)maff2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_plain_is_equal for parameter maff2");
		goto error;
	}

	int res = (int) isl_multi_aff_plain_is_equal(maff1_c, maff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1neg
(JNIEnv *env, jclass class, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_neg\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_neg for parameter ma");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_neg(ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_neg\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1floor
(JNIEnv *env, jclass class, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_floor\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_floor for parameter ma");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_floor(ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_floor\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1flatten_1domain
(JNIEnv *env, jclass class, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_flatten_domain\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_flatten_domain for parameter ma");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_flatten_domain(ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_flatten_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1flatten_1range
(JNIEnv *env, jclass class, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_flatten_range\n");fflush(stdout);
#endif
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_flatten_range for parameter ma");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_flatten_range(ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_flatten_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1add
(JNIEnv *env, jclass class, jlong maff1, jlong maff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_add\n");fflush(stdout);
#endif
	isl_multi_aff* maff1_c = (isl_multi_aff*) GECOS_PTRSIZE maff1; 
	if(((void*)maff1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_add for parameter maff1");
		goto error;
	}
	isl_multi_aff* maff2_c = (isl_multi_aff*) GECOS_PTRSIZE maff2; 
	if(((void*)maff2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_add for parameter maff2");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_add(maff1_c, maff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1sub
(JNIEnv *env, jclass class, jlong ma1, jlong ma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_sub\n");fflush(stdout);
#endif
	isl_multi_aff* ma1_c = (isl_multi_aff*) GECOS_PTRSIZE ma1; 
	if(((void*)ma1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_sub for parameter ma1");
		goto error;
	}
	isl_multi_aff* ma2_c = (isl_multi_aff*) GECOS_PTRSIZE ma2; 
	if(((void*)ma2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_sub for parameter ma2");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_sub(ma1_c, ma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1product
(JNIEnv *env, jclass class, jlong ma1, jlong ma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_product\n");fflush(stdout);
#endif
	isl_multi_aff* ma1_c = (isl_multi_aff*) GECOS_PTRSIZE ma1; 
	if(((void*)ma1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_product for parameter ma1");
		goto error;
	}
	isl_multi_aff* ma2_c = (isl_multi_aff*) GECOS_PTRSIZE ma2; 
	if(((void*)ma2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_product for parameter ma2");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_product(ma1_c, ma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1gist_1params
(JNIEnv *env, jclass class, jlong maff, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_gist_params\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_gist_params for parameter maff");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_gist_params for parameter context");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_gist_params(maff_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_gist_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1gist
(JNIEnv *env, jclass class, jlong maff, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_gist\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_gist for parameter maff");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_gist for parameter context");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_gist(maff_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1pullback_1multi_1aff
(JNIEnv *env, jclass class, jlong ma1, jlong ma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_pullback_multi_aff\n");fflush(stdout);
#endif
	isl_multi_aff* ma1_c = (isl_multi_aff*) GECOS_PTRSIZE ma1; 
	if(((void*)ma1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_pullback_multi_aff for parameter ma1");
		goto error;
	}
	isl_multi_aff* ma2_c = (isl_multi_aff*) GECOS_PTRSIZE ma2; 
	if(((void*)ma2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_pullback_multi_aff for parameter ma2");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_pullback_multi_aff(ma1_c, ma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_pullback_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1flat_1range_1product
(JNIEnv *env, jclass class, jlong ma1, jlong ma2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_flat_range_product\n");fflush(stdout);
#endif
	isl_multi_aff* ma1_c = (isl_multi_aff*) GECOS_PTRSIZE ma1; 
	if(((void*)ma1_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_flat_range_product for parameter ma1");
		goto error;
	}
	isl_multi_aff* ma2_c = (isl_multi_aff*) GECOS_PTRSIZE ma2; 
	if(((void*)ma2_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_flat_range_product for parameter ma2");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_flat_range_product(ma1_c, ma2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_flat_range_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1to_1string
(JNIEnv *env, jclass class, jlong maff, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_to_string\n");fflush(stdout);
#endif
	isl_multi_aff* maff_c = (isl_multi_aff*) GECOS_PTRSIZE maff; 
	if(((void*)maff_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_to_string for parameter maff");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_multi_aff_to_string(maff_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


