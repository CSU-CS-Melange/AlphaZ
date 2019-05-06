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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_basic_set_read_from_str for parameter str");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1from_1basic_1set
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_from_basic_set\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_set_from_basic_set for parameter bset");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_from_basic_set(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_from_basic_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1set_1from_1basic_1set
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_set_from_basic_set\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_set_from_basic_set for parameter bset");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_set_from_basic_set(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_set_from_basic_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1from_1params
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_from_params\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_from_params for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_from_params(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_from_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1list_1from_1basic_1set
(JNIEnv *env, jclass class, jlong el)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_list_from_basic_set\n");fflush(stdout);
#endif
	isl_basic_set* el_c = (isl_basic_set*) GECOS_PTRSIZE el; 
	if(((void*)el_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_list_from_basic_set for parameter el");
		goto error;
	}

	isl_basic_set_list* res = (isl_basic_set_list*) isl_basic_set_list_from_basic_set(el_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_list_from_basic_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1empty
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_empty\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_empty for parameter space");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_empty(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1universe
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_universe\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_universe for parameter space");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_universe(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1nat_1universe
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_nat_universe\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_nat_universe for parameter space");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_nat_universe(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_nat_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1get_1ctx
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_get_ctx\n");fflush(stdout);
#endif
	isl_basic_set* set_c = (isl_basic_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_get_ctx for parameter set");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_basic_set_get_ctx(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1get_1space
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_get_space\n");fflush(stdout);
#endif
	isl_basic_set* set_c = (isl_basic_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_get_space for parameter set");
		goto error;
	}

	isl_space* res = (isl_space*) isl_basic_set_get_space(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1get_1local_1space
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_get_local_space\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_get_local_space for parameter bset");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_basic_set_get_local_space(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_get_local_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1copy
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_copy\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_copy for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_copy(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1free
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_free\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_free for parameter bset");
		goto error;
	}

	 isl_basic_set_free(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1add_1constraint
(JNIEnv *env, jclass class, jlong bset, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_add_constraint\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_add_constraint for parameter bset");
		goto error;
	}
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_add_constraint for parameter constraint");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_add_constraint(bset_c, constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_add_constraint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1n_1constraint
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_n_constraint\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_n_constraint for parameter bset");
		goto error;
	}

	int res = (int) isl_basic_set_n_constraint(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_n_constraint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1dim
(JNIEnv *env, jclass class, jlong bset, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_dim\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_dim for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_basic_set_dim(bset_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1set_1dim_1name
(JNIEnv *env, jclass class, jlong bset, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_set_dim_name\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_set_dim_name for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_basic_set_set_dim_name for parameter s");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_set_dim_name(bset_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1set_1tuple_1id
(JNIEnv *env, jclass class, jlong bset, jlong id)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_set_tuple_id\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_set_tuple_id for parameter bset");
		goto error;
	}
	isl_id* id_c = (isl_id*) GECOS_PTRSIZE id; 
	if(((void*)id_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_set_tuple_id for parameter id");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_set_tuple_id(bset_c, id_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_set_tuple_id\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1set_1tuple_1name
(JNIEnv *env, jclass class, jlong set, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_set_tuple_name\n");fflush(stdout);
#endif
	isl_basic_set* set_c = (isl_basic_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_set_tuple_name for parameter set");
		goto error;
	}
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_basic_set_set_tuple_name for parameter s");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_set_tuple_name(set_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_set_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1involves_1dims
(JNIEnv *env, jclass class, jlong bset, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_involves_dims\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_involves_dims for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_basic_set_involves_dims(bset_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1get_1dim_1id
(JNIEnv *env, jclass class, jlong bset, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_get_dim_id\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_get_dim_id for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	isl_id* res = (isl_id*) isl_basic_set_get_dim_id(bset_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_get_dim_id\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1get_1dim_1name
(JNIEnv *env, jclass class, jlong bset, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_get_dim_name\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_get_dim_name for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_basic_set_get_dim_name(bset_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1get_1tuple_1name
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_get_tuple_name\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_get_tuple_name for parameter bset");
		goto error;
	}

	char * res = (char *) isl_basic_set_get_tuple_name(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_get_tuple_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1remove_1divs
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_remove_divs\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_remove_divs for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_remove_divs(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_remove_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1remove_1unknown_1divs
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_remove_unknown_divs\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_remove_unknown_divs for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_remove_unknown_divs(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_remove_unknown_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1remove_1divs_1involving_1dims
(JNIEnv *env, jclass class, jlong bset, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_remove_divs_involving_dims\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_remove_divs_involving_dims for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_remove_divs_involving_dims(bset_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_remove_divs_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1from_1constraint_1matrices
(JNIEnv *env, jclass class, jlong space, jlong eq, jlong ineq, jint c1, jint c2, jint c3, jint c4)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_from_constraint_matrices\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_from_constraint_matrices for parameter space");
		goto error;
	}
	isl_mat* eq_c = (isl_mat*) GECOS_PTRSIZE eq; 
	if(((void*)eq_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_from_constraint_matrices for parameter eq");
		goto error;
	}
	isl_mat* ineq_c = (isl_mat*) GECOS_PTRSIZE ineq; 
	if(((void*)ineq_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_from_constraint_matrices for parameter ineq");
		goto error;
	}
	enum isl_dim_type c1_c = (enum isl_dim_type) c1;
	enum isl_dim_type c2_c = (enum isl_dim_type) c2;
	enum isl_dim_type c3_c = (enum isl_dim_type) c3;
	enum isl_dim_type c4_c = (enum isl_dim_type) c4;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_from_constraint_matrices(space_c, eq_c, ineq_c, c1_c, c2_c, c3_c, c4_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_from_constraint_matrices\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1equalities_1matrix
(JNIEnv *env, jclass class, jlong bset, jint c1, jint c2, jint c3, jint c4)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_equalities_matrix\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_equalities_matrix for parameter bset");
		goto error;
	}
	enum isl_dim_type c1_c = (enum isl_dim_type) c1;
	enum isl_dim_type c2_c = (enum isl_dim_type) c2;
	enum isl_dim_type c3_c = (enum isl_dim_type) c3;
	enum isl_dim_type c4_c = (enum isl_dim_type) c4;

	isl_mat* res = (isl_mat*) isl_basic_set_equalities_matrix(bset_c, c1_c, c2_c, c3_c, c4_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_equalities_matrix\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1inequalities_1matrix
(JNIEnv *env, jclass class, jlong bset, jint c1, jint c2, jint c3, jint c4)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_inequalities_matrix\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_inequalities_matrix for parameter bset");
		goto error;
	}
	enum isl_dim_type c1_c = (enum isl_dim_type) c1;
	enum isl_dim_type c2_c = (enum isl_dim_type) c2;
	enum isl_dim_type c3_c = (enum isl_dim_type) c3;
	enum isl_dim_type c4_c = (enum isl_dim_type) c4;

	isl_mat* res = (isl_mat*) isl_basic_set_inequalities_matrix(bset_c, c1_c, c2_c, c3_c, c4_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_inequalities_matrix\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1plain_1is_1empty
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_plain_is_empty\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_plain_is_empty for parameter bset");
		goto error;
	}

	int res = (int) isl_basic_set_plain_is_empty(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_plain_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1is_1empty
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_is_empty\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_empty for parameter bset");
		goto error;
	}

	int res = (int) isl_basic_set_is_empty(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1is_1universe
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_is_universe\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_universe for parameter bset");
		goto error;
	}

	int res = (int) isl_basic_set_is_universe(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_is_universe\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1is_1wrapping
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_is_wrapping\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_wrapping for parameter bset");
		goto error;
	}

	int res = (int) isl_basic_set_is_wrapping(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_is_wrapping\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1sample_1point
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_sample_point\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_sample_point for parameter bset");
		goto error;
	}

	isl_point* res = (isl_point*) isl_basic_set_sample_point(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_sample_point\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong bset1, jlong bset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_plain_is_equal\n");fflush(stdout);
#endif
	isl_basic_set* bset1_c = (isl_basic_set*) GECOS_PTRSIZE bset1; 
	if(((void*)bset1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_plain_is_equal for parameter bset1");
		goto error;
	}
	isl_basic_set* bset2_c = (isl_basic_set*) GECOS_PTRSIZE bset2; 
	if(((void*)bset2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_plain_is_equal for parameter bset2");
		goto error;
	}

	int res = (int) isl_basic_set_plain_is_equal(bset1_c, bset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1is_1equal
(JNIEnv *env, jclass class, jlong bset1, jlong bset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_is_equal\n");fflush(stdout);
#endif
	isl_basic_set* bset1_c = (isl_basic_set*) GECOS_PTRSIZE bset1; 
	if(((void*)bset1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_equal for parameter bset1");
		goto error;
	}
	isl_basic_set* bset2_c = (isl_basic_set*) GECOS_PTRSIZE bset2; 
	if(((void*)bset2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_equal for parameter bset2");
		goto error;
	}

	int res = (int) isl_basic_set_is_equal(bset1_c, bset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1is_1disjoint
(JNIEnv *env, jclass class, jlong bset1, jlong bset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_is_disjoint\n");fflush(stdout);
#endif
	isl_basic_set* bset1_c = (isl_basic_set*) GECOS_PTRSIZE bset1; 
	if(((void*)bset1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_disjoint for parameter bset1");
		goto error;
	}
	isl_basic_set* bset2_c = (isl_basic_set*) GECOS_PTRSIZE bset2; 
	if(((void*)bset2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_disjoint for parameter bset2");
		goto error;
	}

	int res = (int) isl_basic_set_is_disjoint(bset1_c, bset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_is_disjoint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1is_1subset
(JNIEnv *env, jclass class, jlong bset1, jlong bset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_is_subset\n");fflush(stdout);
#endif
	isl_basic_set* bset1_c = (isl_basic_set*) GECOS_PTRSIZE bset1; 
	if(((void*)bset1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_subset for parameter bset1");
		goto error;
	}
	isl_basic_set* bset2_c = (isl_basic_set*) GECOS_PTRSIZE bset2; 
	if(((void*)bset2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_is_subset for parameter bset2");
		goto error;
	}

	int res = (int) isl_basic_set_is_subset(bset1_c, bset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_is_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1params
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_params\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_params for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_params(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1project_1out
(JNIEnv *env, jclass class, jlong bset, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_project_out\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_project_out for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_project_out(bset_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_project_out\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1eliminate
(JNIEnv *env, jclass class, jlong bset, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_eliminate\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_eliminate for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_eliminate(bset_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_eliminate\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1fix_1si
(JNIEnv *env, jclass class, jlong bset, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_fix_si\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_fix_si for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_fix_si(bset_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_fix_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1fix_1val
(JNIEnv *env, jclass class, jlong bset, jint type, jint pos, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_fix_val\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_fix_val for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_fix_val for parameter v");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_fix_val(bset_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_fix_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1detect_1equalities
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_detect_equalities\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_detect_equalities for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_detect_equalities(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_detect_equalities\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1remove_1redundancies
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_remove_redundancies\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_remove_redundancies for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_remove_redundancies(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_remove_redundancies\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1affine_1hull
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_affine_hull\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_affine_hull for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_affine_hull(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_affine_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1coefficients
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_coefficients\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_coefficients for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_coefficients(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_coefficients\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1drop_1constraints_1involving_1dims
(JNIEnv *env, jclass class, jlong bset, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_drop_constraints_involving_dims\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_drop_constraints_involving_dims for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_drop_constraints_involving_dims(bset_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_drop_constraints_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1drop_1constraints_1not_1involving_1dims
(JNIEnv *env, jclass class, jlong bset, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_drop_constraints_not_involving_dims\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_drop_constraints_not_involving_dims for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_drop_constraints_not_involving_dims(bset_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_drop_constraints_not_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1sample
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_sample\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_sample for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_sample(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_sample\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1unwrap
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_unwrap\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_unwrap for parameter bset");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_set_unwrap(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_unwrap\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1flatten
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_flatten\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_flatten for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_flatten(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_flatten\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1lift
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_lift\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_lift for parameter bset");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_lift(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_lift\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1align_1params
(JNIEnv *env, jclass class, jlong bset, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_align_params\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_align_params for parameter bset");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_align_params for parameter model");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_align_params(bset_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1add_1dims
(JNIEnv *env, jclass class, jlong bset, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_add_dims\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_add_dims for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_add_dims(bset_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1insert_1dims
(JNIEnv *env, jclass class, jlong bset, jint type, jint pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_insert_dims\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_insert_dims for parameter bset");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	unsigned int n_c = (unsigned int) n;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_insert_dims(bset_c, type_c, pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1move_1dims
(JNIEnv *env, jclass class, jlong bset, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_move_dims\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_move_dims for parameter bset");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_move_dims(bset_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1intersect_1params
(JNIEnv *env, jclass class, jlong bset1, jlong bset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_intersect_params\n");fflush(stdout);
#endif
	isl_basic_set* bset1_c = (isl_basic_set*) GECOS_PTRSIZE bset1; 
	if(((void*)bset1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_intersect_params for parameter bset1");
		goto error;
	}
	isl_basic_set* bset2_c = (isl_basic_set*) GECOS_PTRSIZE bset2; 
	if(((void*)bset2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_intersect_params for parameter bset2");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_intersect_params(bset1_c, bset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1intersect
(JNIEnv *env, jclass class, jlong bset1, jlong bset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_intersect\n");fflush(stdout);
#endif
	isl_basic_set* bset1_c = (isl_basic_set*) GECOS_PTRSIZE bset1; 
	if(((void*)bset1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_intersect for parameter bset1");
		goto error;
	}
	isl_basic_set* bset2_c = (isl_basic_set*) GECOS_PTRSIZE bset2; 
	if(((void*)bset2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_intersect for parameter bset2");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_intersect(bset1_c, bset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_intersect\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1union
(JNIEnv *env, jclass class, jlong bset1, jlong bset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_union\n");fflush(stdout);
#endif
	isl_basic_set* bset1_c = (isl_basic_set*) GECOS_PTRSIZE bset1; 
	if(((void*)bset1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_union for parameter bset1");
		goto error;
	}
	isl_basic_set* bset2_c = (isl_basic_set*) GECOS_PTRSIZE bset2; 
	if(((void*)bset2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_union for parameter bset2");
		goto error;
	}

	isl_set* res = (isl_set*) isl_basic_set_union(bset1_c, bset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_union\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1apply
(JNIEnv *env, jclass class, jlong bset, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_apply\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_apply for parameter bset");
		goto error;
	}
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_apply for parameter bmap");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_apply(bset_c, bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_apply\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1preimage_1multi_1aff
(JNIEnv *env, jclass class, jlong bset, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_preimage_multi_aff\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_preimage_multi_aff for parameter bset");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_preimage_multi_aff for parameter ma");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_preimage_multi_aff(bset_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_preimage_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1flat_1product
(JNIEnv *env, jclass class, jlong bset1, jlong bset2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_flat_product\n");fflush(stdout);
#endif
	isl_basic_set* bset1_c = (isl_basic_set*) GECOS_PTRSIZE bset1; 
	if(((void*)bset1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_flat_product for parameter bset1");
		goto error;
	}
	isl_basic_set* bset2_c = (isl_basic_set*) GECOS_PTRSIZE bset2; 
	if(((void*)bset2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_flat_product for parameter bset2");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_flat_product(bset1_c, bset2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_flat_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1gist
(JNIEnv *env, jclass class, jlong bset, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_gist\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_gist for parameter bset");
		goto error;
	}
	isl_basic_set* context_c = (isl_basic_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_gist for parameter context");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_gist(bset_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1partial_1lexmin
(JNIEnv *env, jclass class, jlong bset, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_partial_lexmin\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_partial_lexmin for parameter bset");
		goto error;
	}
	isl_basic_set* dom_c = (isl_basic_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_partial_lexmin for parameter dom");
		goto error;
	}

	isl_set* res = (isl_set*) isl_basic_set_partial_lexmin(bset_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_partial_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1partial_1lexmax
(JNIEnv *env, jclass class, jlong bset, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_partial_lexmax\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_partial_lexmax for parameter bset");
		goto error;
	}
	isl_basic_set* dom_c = (isl_basic_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_partial_lexmax for parameter dom");
		goto error;
	}

	isl_set* res = (isl_set*) isl_basic_set_partial_lexmax(bset_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_partial_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1lexmin
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_lexmin\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_lexmin for parameter bset");
		goto error;
	}

	isl_set* res = (isl_set*) isl_basic_set_lexmin(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1lexmax
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_lexmax\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_lexmax for parameter bset");
		goto error;
	}

	isl_set* res = (isl_set*) isl_basic_set_lexmax(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1partial_1lexmin_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong bset, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_partial_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_partial_lexmin_pw_multi_aff for parameter bset");
		goto error;
	}
	isl_basic_set* dom_c = (isl_basic_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_partial_lexmin_pw_multi_aff for parameter dom");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_basic_set_partial_lexmin_pw_multi_aff(bset_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_partial_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1partial_1lexmax_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong bset, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_partial_lexmax_pw_multi_aff\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_partial_lexmax_pw_multi_aff for parameter bset");
		goto error;
	}
	isl_basic_set* dom_c = (isl_basic_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_partial_lexmax_pw_multi_aff for parameter dom");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_basic_set_partial_lexmax_pw_multi_aff(bset_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_partial_lexmax_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1compute_1vertices
(JNIEnv *env, jclass class, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_compute_vertices\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_compute_vertices for parameter bset");
		goto error;
	}

	isl_vertices* res = (isl_vertices*) isl_basic_set_compute_vertices(bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_compute_vertices\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1to_1string
(JNIEnv *env, jclass class, jlong bset, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_to_string\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_to_string for parameter bset");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_basic_set_to_string(bset_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1get_1constraint_1at
(JNIEnv *env, jclass class, jlong bset, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_get_constraint_at\n");fflush(stdout);
#endif
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_get_constraint_at for parameter bset");
		goto error;
	}
	int pos_c = (int) pos;

	isl_constraint* res = (isl_constraint*) isl_basic_set_get_constraint_at(bset_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_get_constraint_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


