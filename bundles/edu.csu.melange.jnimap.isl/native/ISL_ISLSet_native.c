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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_set_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_set_read_from_str for parameter str");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_set_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1from_1set
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_from_set\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_from_set for parameter set");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_from_set(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_from_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1from_1params
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_from_params\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_from_params for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_from_params(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_from_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1from_1set
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_from_set\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_from_set for parameter set");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_from_set(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_from_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1list_1from_1set
(JNIEnv *env, jclass class, jlong el)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_list_from_set\n");fflush(stdout);
#endif
	isl_set* el_c = (isl_set*) GECOS_PTRSIZE el; 
	if(((void*)el_c)==NULL) {
		throwException(env, "Null pointer in isl_set_list_from_set for parameter el");
		goto error;
	}

	isl_set_list* res = (isl_set_list*) isl_set_list_from_set(el_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_list_from_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1empty
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_empty\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_set_empty for parameter space");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_empty(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1universe
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_universe\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_set_universe for parameter space");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_universe(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1nat_1universe
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_nat_universe\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_set_nat_universe for parameter space");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_nat_universe(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_nat_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1get_1ctx
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_get_ctx\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_get_ctx for parameter set");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_set_get_ctx(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1get_1space
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_get_space\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_get_space for parameter set");
		goto error;
	}

	isl_space* res = (isl_space*) isl_set_get_space(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1copy
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_copy\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_copy for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_copy(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1free
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_free\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_free for parameter set");
		goto error;
	}

	 isl_set_free(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1add_1constraint
(JNIEnv *env, jclass class, jlong set, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_add_constraint\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_add_constraint for parameter set");
		goto error;
	}
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_set_add_constraint for parameter constraint");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_add_constraint(set_c, constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_add_constraint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1n_1basic_1set
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_n_basic_set\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_n_basic_set for parameter set");
		goto error;
	}

	int res = (int) isl_set_n_basic_set(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_n_basic_set\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1make_1disjoint
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_make_disjoint\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_make_disjoint for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_make_disjoint(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_make_disjoint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1compute_1divs
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_compute_divs\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_compute_divs for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_compute_divs(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_compute_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1remove_1divs
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_remove_divs\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_remove_divs for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_remove_divs(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_remove_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1remove_1unknown_1divs
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_remove_unknown_divs\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_remove_unknown_divs for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_remove_unknown_divs(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_remove_unknown_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1remove_1divs_1involving_1dims
(JNIEnv *env, jclass class, jlong set, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_remove_divs_involving_dims\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_remove_divs_involving_dims for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_set* res = (isl_set*) isl_set_remove_divs_involving_dims(set_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_remove_divs_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1dim
(JNIEnv *env, jclass class, jlong set, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_dim\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_dim for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_set_dim(set_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1get_1tuple_1name
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_get_tuple_name\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_get_tuple_name for parameter set");
		goto error;
	}

	char * res = (char *) isl_set_get_tuple_name(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_get_tuple_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1set_1tuple_1name
(JNIEnv *env, jclass class, jlong set, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_set_tuple_name\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_set_tuple_name for parameter set");
		goto error;
	}
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_set_set_tuple_name for parameter s");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_set_tuple_name(set_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_set_set_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1get_1dim_1name
(JNIEnv *env, jclass class, jlong set, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_get_dim_name\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_get_dim_name for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_set_get_dim_name(set_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1set_1dim_1name
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_set_dim_name\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_set_dim_name for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_set_set_dim_name for parameter s");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_set_dim_name(set_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_set_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1has_1tuple_1name
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_has_tuple_name\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_has_tuple_name for parameter set");
		goto error;
	}

	int res = (int) isl_set_has_tuple_name(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_has_tuple_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1has_1dim_1name
(JNIEnv *env, jclass class, jlong set, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_has_dim_name\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_has_dim_name for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_set_has_dim_name(set_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_has_dim_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1find_1dim_1by_1name
(JNIEnv *env, jclass class, jlong set, jint type, jstring name)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_find_dim_by_name\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_find_dim_by_name for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	char* name_c;
	name_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, name, NULL);
	if (name_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_set_find_dim_by_name for parameter name");
		goto error;
	}

	int res = (int) isl_set_find_dim_by_name(set_c, type_c, name_c);

	(*env)->ReleaseStringUTFChars(env, name, name_c);

#ifdef TRACE_ALL
	printf("Leaving isl_set_find_dim_by_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1involves_1dims
(JNIEnv *env, jclass class, jlong set, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_involves_dims\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_involves_dims for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_set_involves_dims(set_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1get_1tuple_1id
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_get_tuple_id\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_get_tuple_id for parameter set");
		goto error;
	}

	isl_id* res = (isl_id*) isl_set_get_tuple_id(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_get_tuple_id\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1get_1dim_1id
(JNIEnv *env, jclass class, jlong set, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_get_dim_id\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_get_dim_id for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	isl_id* res = (isl_id*) isl_set_get_dim_id(set_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_get_dim_id\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1has_1tuple_1id
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_has_tuple_id\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_has_tuple_id for parameter set");
		goto error;
	}

	int res = (int) isl_set_has_tuple_id(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_has_tuple_id\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1has_1dim_1id
(JNIEnv *env, jclass class, jlong set, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_has_dim_id\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_has_dim_id for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_set_has_dim_id(set_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_has_dim_id\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1set_1tuple_1id
(JNIEnv *env, jclass class, jlong set, jlong id)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_set_tuple_id\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_set_tuple_id for parameter set");
		goto error;
	}
	isl_id* id_c = (isl_id*) GECOS_PTRSIZE id; 
	if(((void*)id_c)==NULL) {
		throwException(env, "Null pointer in isl_set_set_tuple_id for parameter id");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_set_tuple_id(set_c, id_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_set_tuple_id\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1set_1dim_1id
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jlong id)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_set_dim_id\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_set_dim_id for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	isl_id* id_c = (isl_id*) GECOS_PTRSIZE id; 
	if(((void*)id_c)==NULL) {
		throwException(env, "Null pointer in isl_set_set_dim_id for parameter id");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_set_dim_id(set_c, type_c, pos_c, id_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_set_dim_id\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1find_1dim_1by_1id
(JNIEnv *env, jclass class, jlong set, jint type, jlong id)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_find_dim_by_id\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_find_dim_by_id for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	isl_id* id_c = (isl_id*) GECOS_PTRSIZE id; 
	if(((void*)id_c)==NULL) {
		throwException(env, "Null pointer in isl_set_find_dim_by_id for parameter id");
		goto error;
	}

	int res = (int) isl_set_find_dim_by_id(set_c, type_c, id_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_find_dim_by_id\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1reset_1tuple_1id
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_reset_tuple_id\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_reset_tuple_id for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_reset_tuple_id(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_reset_tuple_id\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1dim_1has_1upper_1bound
(JNIEnv *env, jclass class, jlong set, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_dim_has_upper_bound\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_dim_has_upper_bound for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_set_dim_has_upper_bound(set_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_dim_has_upper_bound\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1dim_1has_1lower_1bound
(JNIEnv *env, jclass class, jlong set, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_dim_has_lower_bound\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_dim_has_lower_bound for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_set_dim_has_lower_bound(set_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_dim_has_lower_bound\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1dim_1has_1any_1upper_1bound
(JNIEnv *env, jclass class, jlong set, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_dim_has_any_upper_bound\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_dim_has_any_upper_bound for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_set_dim_has_any_upper_bound(set_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_dim_has_any_upper_bound\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1dim_1has_1any_1lower_1bound
(JNIEnv *env, jclass class, jlong set, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_dim_has_any_lower_bound\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_dim_has_any_lower_bound for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_set_dim_has_any_lower_bound(set_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_dim_has_any_lower_bound\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1plain_1is_1empty
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_plain_is_empty\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_plain_is_empty for parameter set");
		goto error;
	}

	int res = (int) isl_set_plain_is_empty(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_plain_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1is_1empty
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_is_empty\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_empty for parameter set");
		goto error;
	}

	int res = (int) isl_set_is_empty(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1plain_1is_1universe
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_plain_is_universe\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_plain_is_universe for parameter set");
		goto error;
	}

	int res = (int) isl_set_plain_is_universe(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_plain_is_universe\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1is_1singleton
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_is_singleton\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_singleton for parameter set");
		goto error;
	}

	int res = (int) isl_set_is_singleton(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_is_singleton\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1is_1params
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_is_params\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_params for parameter set");
		goto error;
	}

	int res = (int) isl_set_is_params(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_is_params\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1is_1wrapping
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_is_wrapping\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_wrapping for parameter set");
		goto error;
	}

	int res = (int) isl_set_is_wrapping(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_is_wrapping\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1sample_1point
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_sample_point\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_sample_point for parameter set");
		goto error;
	}

	isl_point* res = (isl_point*) isl_set_sample_point(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_sample_point\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_plain_is_equal\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_plain_is_equal for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_plain_is_equal for parameter set2");
		goto error;
	}

	int res = (int) isl_set_plain_is_equal(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1is_1equal
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_is_equal\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_equal for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_equal for parameter set2");
		goto error;
	}

	int res = (int) isl_set_is_equal(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1plain_1is_1disjoint
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_plain_is_disjoint\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_plain_is_disjoint for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_plain_is_disjoint for parameter set2");
		goto error;
	}

	int res = (int) isl_set_plain_is_disjoint(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_plain_is_disjoint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1is_1disjoint
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_is_disjoint\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_disjoint for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_disjoint for parameter set2");
		goto error;
	}

	int res = (int) isl_set_is_disjoint(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_is_disjoint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1is_1subset
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_is_subset\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_subset for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_subset for parameter set2");
		goto error;
	}

	int res = (int) isl_set_is_subset(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_is_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1is_1strict_1subset
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_is_strict_subset\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_strict_subset for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_is_strict_subset for parameter set2");
		goto error;
	}

	int res = (int) isl_set_is_strict_subset(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_is_strict_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1params
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_params\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_params for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_params(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1complement
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_complement\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_complement for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_complement(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_complement\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1project_1out
(JNIEnv *env, jclass class, jlong set, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_project_out\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_project_out for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_set* res = (isl_set*) isl_set_project_out(set_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_project_out\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1eliminate
(JNIEnv *env, jclass class, jlong set, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_eliminate\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_eliminate for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_set* res = (isl_set*) isl_set_eliminate(set_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_eliminate\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1fix_1si
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_fix_si\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_fix_si for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_set* res = (isl_set*) isl_set_fix_si(set_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_fix_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1fix_1val
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_fix_val\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_fix_val for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_set_fix_val for parameter v");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_fix_val(set_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_fix_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1lower_1bound_1si
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_lower_bound_si\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_lower_bound_si for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_set* res = (isl_set*) isl_set_lower_bound_si(set_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_lower_bound_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1lower_1bound_1val
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jlong value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_lower_bound_val\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_lower_bound_val for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	isl_val* value_c = (isl_val*) GECOS_PTRSIZE value; 
	if(((void*)value_c)==NULL) {
		throwException(env, "Null pointer in isl_set_lower_bound_val for parameter value");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_lower_bound_val(set_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_lower_bound_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1upper_1bound_1si
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_upper_bound_si\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_upper_bound_si for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_set* res = (isl_set*) isl_set_upper_bound_si(set_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_upper_bound_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1upper_1bound_1val
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jlong value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_upper_bound_val\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_upper_bound_val for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	isl_val* value_c = (isl_val*) GECOS_PTRSIZE value; 
	if(((void*)value_c)==NULL) {
		throwException(env, "Null pointer in isl_set_upper_bound_val for parameter value");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_upper_bound_val(set_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_upper_bound_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1equate
(JNIEnv *env, jclass class, jlong set, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_equate\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_equate for parameter set");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_set* res = (isl_set*) isl_set_equate(set_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_equate\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1identity
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_identity\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_identity for parameter set");
		goto error;
	}

	isl_map* res = (isl_map*) isl_set_identity(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_identity\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1coalesce
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_coalesce\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_coalesce for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_coalesce(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1detect_1equalities
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_detect_equalities\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_detect_equalities for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_detect_equalities(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_detect_equalities\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1remove_1redundancies
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_remove_redundancies\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_remove_redundancies for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_remove_redundancies(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_remove_redundancies\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1convex_1hull
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_convex_hull\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_convex_hull for parameter set");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_set_convex_hull(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_convex_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1affine_1hull
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_affine_hull\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_affine_hull for parameter set");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_set_affine_hull(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_affine_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1polyhedral_1hull
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_polyhedral_hull\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_polyhedral_hull for parameter set");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_set_polyhedral_hull(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_polyhedral_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1simple_1hull
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_simple_hull\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_simple_hull for parameter set");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_set_simple_hull(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_simple_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1unshifted_1simple_1hull
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_unshifted_simple_hull\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_unshifted_simple_hull for parameter set");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_set_unshifted_simple_hull(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_unshifted_simple_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1drop_1constraints_1involving_1dims
(JNIEnv *env, jclass class, jlong set, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_drop_constraints_involving_dims\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_drop_constraints_involving_dims for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_set* res = (isl_set*) isl_set_drop_constraints_involving_dims(set_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_drop_constraints_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1sample
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_sample\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_sample for parameter set");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_set_sample(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_sample\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1unwrap
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_unwrap\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_unwrap for parameter set");
		goto error;
	}

	isl_map* res = (isl_map*) isl_set_unwrap(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_unwrap\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1flatten
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_flatten\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_flatten for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_flatten(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_flatten\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1flatten_1map
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_flatten_map\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_flatten_map for parameter set");
		goto error;
	}

	isl_map* res = (isl_map*) isl_set_flatten_map(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_flatten_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1lift
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_lift\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_lift for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_lift(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_lift\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1align_1params
(JNIEnv *env, jclass class, jlong set, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_align_params\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_align_params for parameter set");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_set_align_params for parameter model");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_align_params(set_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1add_1dims
(JNIEnv *env, jclass class, jlong set, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_add_dims\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_add_dims for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_set* res = (isl_set*) isl_set_add_dims(set_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1insert_1dims
(JNIEnv *env, jclass class, jlong set, jint type, jint pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_insert_dims\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_insert_dims for parameter set");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	unsigned int n_c = (unsigned int) n;

	isl_set* res = (isl_set*) isl_set_insert_dims(set_c, type_c, pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1move_1dims
(JNIEnv *env, jclass class, jlong set, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_move_dims\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_move_dims for parameter set");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_set* res = (isl_set*) isl_set_move_dims(set_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1intersect_1params
(JNIEnv *env, jclass class, jlong set, jlong params)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_intersect_params\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_intersect_params for parameter set");
		goto error;
	}
	isl_set* params_c = (isl_set*) GECOS_PTRSIZE params; 
	if(((void*)params_c)==NULL) {
		throwException(env, "Null pointer in isl_set_intersect_params for parameter params");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_intersect_params(set_c, params_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1intersect
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_intersect\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_intersect for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_intersect for parameter set2");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_intersect(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_intersect\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1union
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_union\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_union for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_union for parameter set2");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_union(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_union\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1subtract
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_subtract\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_subtract for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_subtract for parameter set2");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_subtract(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_subtract\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1apply
(JNIEnv *env, jclass class, jlong set, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_apply\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_apply for parameter set");
		goto error;
	}
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_set_apply for parameter map");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_apply(set_c, map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_apply\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1preimage_1multi_1aff
(JNIEnv *env, jclass class, jlong set, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_preimage_multi_aff\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_preimage_multi_aff for parameter set");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_set_preimage_multi_aff for parameter ma");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_preimage_multi_aff(set_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_preimage_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1preimage_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong set, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_preimage_pw_multi_aff\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_preimage_pw_multi_aff for parameter set");
		goto error;
	}
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_set_preimage_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_preimage_pw_multi_aff(set_c, pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_preimage_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1preimage_1multi_1pw_1aff
(JNIEnv *env, jclass class, jlong set, jlong mpa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_preimage_multi_pw_aff\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_preimage_multi_pw_aff for parameter set");
		goto error;
	}
	isl_multi_pw_aff* mpa_c = (isl_multi_pw_aff*) GECOS_PTRSIZE mpa; 
	if(((void*)mpa_c)==NULL) {
		throwException(env, "Null pointer in isl_set_preimage_multi_pw_aff for parameter mpa");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_preimage_multi_pw_aff(set_c, mpa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_preimage_multi_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1product
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_product\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_product for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_product for parameter set2");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_product(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1flat_1product
(JNIEnv *env, jclass class, jlong set1, jlong set2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_flat_product\n");fflush(stdout);
#endif
	isl_set* set1_c = (isl_set*) GECOS_PTRSIZE set1; 
	if(((void*)set1_c)==NULL) {
		throwException(env, "Null pointer in isl_set_flat_product for parameter set1");
		goto error;
	}
	isl_set* set2_c = (isl_set*) GECOS_PTRSIZE set2; 
	if(((void*)set2_c)==NULL) {
		throwException(env, "Null pointer in isl_set_flat_product for parameter set2");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_flat_product(set1_c, set2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_flat_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1gist
(JNIEnv *env, jclass class, jlong set, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_gist\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_gist for parameter set");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_set_gist for parameter context");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_gist(set_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1gist_1params
(JNIEnv *env, jclass class, jlong set, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_gist_params\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_gist_params for parameter set");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_set_gist_params for parameter context");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_gist_params(set_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_gist_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1partial_1lexmin
(JNIEnv *env, jclass class, jlong set, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_partial_lexmin\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_partial_lexmin for parameter set");
		goto error;
	}
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_set_partial_lexmin for parameter dom");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_partial_lexmin(set_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_set_partial_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1partial_1lexmax
(JNIEnv *env, jclass class, jlong set, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_partial_lexmax\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_partial_lexmax for parameter set");
		goto error;
	}
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_set_partial_lexmax for parameter dom");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_partial_lexmax(set_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_set_partial_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1lexmin
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_lexmin\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_lexmin for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_lexmin(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1lexmax
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_lexmax\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_lexmax for parameter set");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_lexmax(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1lexmin_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_lexmin_pw_multi_aff for parameter set");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_set_lexmin_pw_multi_aff(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1lexmax_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_lexmax_pw_multi_aff\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_lexmax_pw_multi_aff for parameter set");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_set_lexmax_pw_multi_aff(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_lexmax_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1n_1dim
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_n_dim\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_n_dim for parameter set");
		goto error;
	}

	unsigned int res = (unsigned int) isl_set_n_dim(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_n_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1n_1param
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_n_param\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_n_param for parameter set");
		goto error;
	}

	unsigned int res = (unsigned int) isl_set_n_param(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_n_param\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1get_1basic_1set_1at
(JNIEnv *env, jclass class, jlong set, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_get_basic_set_at\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_get_basic_set_at for parameter set");
		goto error;
	}
	int pos_c = (int) pos;

	isl_basic_set* res = (isl_basic_set*) isl_set_get_basic_set_at(set_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_get_basic_set_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1numberof_1points
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_numberof_points\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_numberof_points for parameter set");
		goto error;
	}

	int res = (int) isl_set_numberof_points(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_numberof_points\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1get_1point_1at
(JNIEnv *env, jclass class, jlong set, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_get_point_at\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_get_point_at for parameter set");
		goto error;
	}
	int pos_c = (int) pos;

	isl_point* res = (isl_point*) isl_set_get_point_at(set_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_get_point_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1to_1string
(JNIEnv *env, jclass class, jlong set, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_to_string\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_set_to_string for parameter set");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_set_to_string(set_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_lex_1next
(JNIEnv *env, jclass class, jlong dom, jint nbInnerLoop)
 {
#ifdef TRACE_ALL
	printf("Entering lex_next\n");fflush(stdout);
#endif
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in lex_next for parameter dom");
		goto error;
	}
	int nbInnerLoop_c = (int) nbInnerLoop;

	isl_map* res = (isl_map*) lex_next(dom_c, nbInnerLoop_c);


#ifdef TRACE_ALL
	printf("Leaving lex_next\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_lex_1next_1power
(JNIEnv *env, jclass class, jlong dom, jint nbInnerLoop, jint power)
 {
#ifdef TRACE_ALL
	printf("Entering lex_next_power\n");fflush(stdout);
#endif
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in lex_next_power for parameter dom");
		goto error;
	}
	int nbInnerLoop_c = (int) nbInnerLoop;
	int power_c = (int) power;

	isl_map* res = (isl_map*) lex_next_power(dom_c, nbInnerLoop_c, power_c);


#ifdef TRACE_ALL
	printf("Leaving lex_next_power\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_lex_1pred
(JNIEnv *env, jclass class, jlong dom, jint nbInnerLoop)
 {
#ifdef TRACE_ALL
	printf("Entering lex_pred\n");fflush(stdout);
#endif
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in lex_pred for parameter dom");
		goto error;
	}
	int nbInnerLoop_c = (int) nbInnerLoop;

	isl_map* res = (isl_map*) lex_pred(dom_c, nbInnerLoop_c);


#ifdef TRACE_ALL
	printf("Leaving lex_pred\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_lex_1pred_1power
(JNIEnv *env, jclass class, jlong dom, jint nbInnerLoop, jint power)
 {
#ifdef TRACE_ALL
	printf("Entering lex_pred_power\n");fflush(stdout);
#endif
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in lex_pred_power for parameter dom");
		goto error;
	}
	int nbInnerLoop_c = (int) nbInnerLoop;
	int power_c = (int) power;

	isl_map* res = (isl_map*) lex_pred_power(dom_c, nbInnerLoop_c, power_c);


#ifdef TRACE_ALL
	printf("Leaving lex_pred_power\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_clear_1tuple_1name
(JNIEnv *env, jclass class, jlong m)
 {
#ifdef TRACE_ALL
	printf("Entering clear_tuple_name\n");fflush(stdout);
#endif
	isl_set* m_c = (isl_set*) GECOS_PTRSIZE m; 
	if(((void*)m_c)==NULL) {
		throwException(env, "Null pointer in clear_tuple_name for parameter m");
		goto error;
	}

	isl_set* res = (isl_set*) clear_tuple_name(m_c);


#ifdef TRACE_ALL
	printf("Leaving clear_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


