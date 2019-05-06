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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_map_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_map_read_from_str for parameter str");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_map_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1from_1map
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_from_map\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_from_map for parameter map");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_from_map(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_from_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1from_1map
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_from_map\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_from_map for parameter map");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_from_map(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_from_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1empty
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_empty\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_empty for parameter space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_empty(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1universe
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_universe\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_universe for parameter space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_universe(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1nat_1universe
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_nat_universe\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_nat_universe for parameter space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_nat_universe(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_nat_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1identity
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_identity\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_map_identity for parameter space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_identity(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_identity\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1get_1ctx
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_get_ctx\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_get_ctx for parameter map");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_map_get_ctx(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1get_1space
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_get_space\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_get_space for parameter map");
		goto error;
	}

	isl_space* res = (isl_space*) isl_map_get_space(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1copy
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_copy\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_copy for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_copy(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1free
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_free\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_free for parameter map");
		goto error;
	}

	 isl_map_free(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1add_1constraint
(JNIEnv *env, jclass class, jlong map, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_add_constraint\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_add_constraint for parameter map");
		goto error;
	}
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_map_add_constraint for parameter constraint");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_add_constraint(map_c, constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_add_constraint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1make_1disjoint
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_make_disjoint\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_make_disjoint for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_make_disjoint(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_make_disjoint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1compute_1divs
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_compute_divs\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_compute_divs for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_compute_divs(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_compute_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1remove_1divs
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_remove_divs\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_remove_divs for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_remove_divs(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_remove_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1remove_1unknown_1divs
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_remove_unknown_divs\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_remove_unknown_divs for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_remove_unknown_divs(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_remove_unknown_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1remove_1divs_1involving_1dims
(JNIEnv *env, jclass class, jlong map, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_remove_divs_involving_dims\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_remove_divs_involving_dims for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_remove_divs_involving_dims(map_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_remove_divs_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1dim
(JNIEnv *env, jclass class, jlong map, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_dim\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_dim for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_map_dim(map_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1get_1tuple_1name
(JNIEnv *env, jclass class, jlong map, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_get_tuple_name\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_get_tuple_name for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	char * res = (char *) isl_map_get_tuple_name(map_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_get_tuple_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1set_1tuple_1name
(JNIEnv *env, jclass class, jlong map, jint type, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_set_tuple_name\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_set_tuple_name for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_map_set_tuple_name for parameter s");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_set_tuple_name(map_c, type_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_map_set_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1get_1dim_1name
(JNIEnv *env, jclass class, jlong map, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_get_dim_name\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_get_dim_name for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_map_get_dim_name(map_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1set_1dim_1name
(JNIEnv *env, jclass class, jlong map, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_set_dim_name\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_set_dim_name for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_map_set_dim_name for parameter s");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_set_dim_name(map_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_map_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1has_1tuple_1name
(JNIEnv *env, jclass class, jlong map, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_has_tuple_name\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_has_tuple_name for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	int res = (int) isl_map_has_tuple_name(map_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_has_tuple_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1has_1dim_1name
(JNIEnv *env, jclass class, jlong map, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_has_dim_name\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_has_dim_name for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_map_has_dim_name(map_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_has_dim_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1find_1dim_1by_1name
(JNIEnv *env, jclass class, jlong map, jint type, jstring name)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_find_dim_by_name\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_find_dim_by_name for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	char* name_c;
	name_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, name, NULL);
	if (name_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_map_find_dim_by_name for parameter name");
		goto error;
	}

	int res = (int) isl_map_find_dim_by_name(map_c, type_c, name_c);

	(*env)->ReleaseStringUTFChars(env, name, name_c);

#ifdef TRACE_ALL
	printf("Leaving isl_map_find_dim_by_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1involves_1dims
(JNIEnv *env, jclass class, jlong map, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_involves_dims\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_involves_dims for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_map_involves_dims(map_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1is_1empty
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_is_empty\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_empty for parameter map");
		goto error;
	}

	int res = (int) isl_map_is_empty(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1is_1bijective
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_is_bijective\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_bijective for parameter map");
		goto error;
	}

	int res = (int) isl_map_is_bijective(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_is_bijective\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1is_1injective
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_is_injective\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_injective for parameter map");
		goto error;
	}

	int res = (int) isl_map_is_injective(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_is_injective\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1is_1single_1valued
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_is_single_valued\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_single_valued for parameter map");
		goto error;
	}

	int res = (int) isl_map_is_single_valued(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_is_single_valued\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1domain_1is_1wrapping
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_domain_is_wrapping\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_domain_is_wrapping for parameter map");
		goto error;
	}

	int res = (int) isl_map_domain_is_wrapping(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_domain_is_wrapping\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1range_1is_1wrapping
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_range_is_wrapping\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_range_is_wrapping for parameter map");
		goto error;
	}

	int res = (int) isl_map_range_is_wrapping(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_range_is_wrapping\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1can_1curry
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_can_curry\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_can_curry for parameter map");
		goto error;
	}

	int res = (int) isl_map_can_curry(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_can_curry\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1can_1uncurry
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_can_uncurry\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_can_uncurry for parameter map");
		goto error;
	}

	int res = (int) isl_map_can_uncurry(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_can_uncurry\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1can_1zip
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_can_zip\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_can_zip for parameter map");
		goto error;
	}

	int res = (int) isl_map_can_zip(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_can_zip\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1plain_1is_1empty
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_plain_is_empty\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_plain_is_empty for parameter map");
		goto error;
	}

	int res = (int) isl_map_plain_is_empty(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_plain_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1plain_1is_1injective
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_plain_is_injective\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_plain_is_injective for parameter map");
		goto error;
	}

	int res = (int) isl_map_plain_is_injective(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_plain_is_injective\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1plain_1is_1single_1valued
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_plain_is_single_valued\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_plain_is_single_valued for parameter map");
		goto error;
	}

	int res = (int) isl_map_plain_is_single_valued(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_plain_is_single_valued\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1is_1equal
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_is_equal\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_equal for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_equal for parameter map2");
		goto error;
	}

	int res = (int) isl_map_is_equal(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1is_1disjoint
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_is_disjoint\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_disjoint for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_disjoint for parameter map2");
		goto error;
	}

	int res = (int) isl_map_is_disjoint(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_is_disjoint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1is_1subset
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_is_subset\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_subset for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_subset for parameter map2");
		goto error;
	}

	int res = (int) isl_map_is_subset(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_is_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1is_1strict_1subset
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_is_strict_subset\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_strict_subset for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_is_strict_subset for parameter map2");
		goto error;
	}

	int res = (int) isl_map_is_strict_subset(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_is_strict_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_plain_is_equal\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_plain_is_equal for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_plain_is_equal for parameter map2");
		goto error;
	}

	int res = (int) isl_map_plain_is_equal(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1from_1domain
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_from_domain\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_domain for parameter set");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_from_domain(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_from_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1from_1range
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_from_range\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_range for parameter set");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_from_range(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_from_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1from_1domain_1and_1range
(JNIEnv *env, jclass class, jlong domain, jlong range)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_from_domain_and_range\n");fflush(stdout);
#endif
	isl_set* domain_c = (isl_set*) GECOS_PTRSIZE domain; 
	if(((void*)domain_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_domain_and_range for parameter domain");
		goto error;
	}
	isl_set* range_c = (isl_set*) GECOS_PTRSIZE range; 
	if(((void*)range_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_domain_and_range for parameter range");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_from_domain_and_range(domain_c, range_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_from_domain_and_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1params
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_params\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_params for parameter map");
		goto error;
	}

	isl_set* res = (isl_set*) isl_map_params(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1complement
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_complement\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_complement for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_complement(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_complement\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1reverse
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_reverse\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_reverse for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_reverse(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_reverse\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1project_1out
(JNIEnv *env, jclass class, jlong map, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_project_out\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_project_out for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_project_out(map_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_project_out\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1domain
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_domain\n");fflush(stdout);
#endif
	isl_map* bmap_c = (isl_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_map_domain for parameter bmap");
		goto error;
	}

	isl_set* res = (isl_set*) isl_map_domain(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1range
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_range\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_range for parameter map");
		goto error;
	}

	isl_set* res = (isl_set*) isl_map_range(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1domain_1map
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_domain_map\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_domain_map for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_domain_map(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_domain_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1range_1map
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_range_map\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_range_map for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_range_map(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_range_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1eliminate
(JNIEnv *env, jclass class, jlong map, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_eliminate\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_eliminate for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_eliminate(map_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_eliminate\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1fix_1si
(JNIEnv *env, jclass class, jlong map, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_fix_si\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_fix_si for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_map* res = (isl_map*) isl_map_fix_si(map_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_fix_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1fix_1val
(JNIEnv *env, jclass class, jlong map, jint type, jint pos, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_fix_val\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_fix_val for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_map_fix_val for parameter v");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_fix_val(map_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_fix_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lower_1bound_1si
(JNIEnv *env, jclass class, jlong map, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lower_bound_si\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lower_bound_si for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_map* res = (isl_map*) isl_map_lower_bound_si(map_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lower_bound_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1upper_1bound_1si
(JNIEnv *env, jclass class, jlong map, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_upper_bound_si\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_upper_bound_si for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_map* res = (isl_map*) isl_map_upper_bound_si(map_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_upper_bound_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1equate
(JNIEnv *env, jclass class, jlong map, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_equate\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_equate for parameter map");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_map* res = (isl_map*) isl_map_equate(map_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_equate\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1oppose
(JNIEnv *env, jclass class, jlong map, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_oppose\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_oppose for parameter map");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_map* res = (isl_map*) isl_map_oppose(map_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_oppose\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1order_1ge
(JNIEnv *env, jclass class, jlong map, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_order_ge\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_order_ge for parameter map");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_map* res = (isl_map*) isl_map_order_ge(map_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_order_ge\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1order_1gt
(JNIEnv *env, jclass class, jlong map, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_order_gt\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_order_gt for parameter map");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_map* res = (isl_map*) isl_map_order_gt(map_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_order_gt\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1order_1le
(JNIEnv *env, jclass class, jlong map, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_order_le\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_order_le for parameter map");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_map* res = (isl_map*) isl_map_order_le(map_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_order_le\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1order_1lt
(JNIEnv *env, jclass class, jlong map, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_order_lt\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_order_lt for parameter map");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_map* res = (isl_map*) isl_map_order_lt(map_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_order_lt\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1deltas
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_deltas\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_deltas for parameter map");
		goto error;
	}

	isl_set* res = (isl_set*) isl_map_deltas(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_deltas\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1deltas_1map
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_deltas_map\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_deltas_map for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_deltas_map(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_deltas_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1coalesce
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_coalesce\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_coalesce for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_coalesce(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1detect_1equalities
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_detect_equalities\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_detect_equalities for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_detect_equalities(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_detect_equalities\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1remove_1redundancies
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_remove_redundancies\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_remove_redundancies for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_remove_redundancies(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_remove_redundancies\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1convex_1hull
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_convex_hull\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_convex_hull for parameter map");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_map_convex_hull(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_convex_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1affine_1hull
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_affine_hull\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_affine_hull for parameter map");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_map_affine_hull(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_affine_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1polyhedral_1hull
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_polyhedral_hull\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_polyhedral_hull for parameter map");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_map_polyhedral_hull(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_polyhedral_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1simple_1hull
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_simple_hull\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_simple_hull for parameter map");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_map_simple_hull(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_simple_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1unshifted_1simple_1hull
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_unshifted_simple_hull\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_unshifted_simple_hull for parameter map");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_map_unshifted_simple_hull(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_unshifted_simple_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1drop_1constraints_1involving_1dims
(JNIEnv *env, jclass class, jlong map, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_drop_constraints_involving_dims\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_drop_constraints_involving_dims for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_drop_constraints_involving_dims(map_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_drop_constraints_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1sample
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_sample\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_sample for parameter map");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_map_sample(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_sample\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1fixed_1power_1val
(JNIEnv *env, jclass class, jlong map, jlong exp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_fixed_power_val\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_fixed_power_val for parameter map");
		goto error;
	}
	isl_val* exp_c = (isl_val*) GECOS_PTRSIZE exp; 
	if(((void*)exp_c)==NULL) {
		throwException(env, "Null pointer in isl_map_fixed_power_val for parameter exp");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_fixed_power_val(map_c, exp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_fixed_power_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1power
(JNIEnv *env, jclass class, jlong map, jobject exact)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_power\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_power for parameter map");
		goto error;
	}
	jclass exact_cls = (*env)->GetObjectClass(env, exact); 
	jfieldID exact_fid = (*env)->GetFieldID(env, exact_cls, "value", "Z");
	int exact_c = (int) (*env)->GetBooleanField(env, exact, exact_fid);

	isl_map* res = (isl_map*) isl_map_power(map_c, &exact_c);

	(*env)->SetBooleanField(env, exact, exact_fid, exact_c);

#ifdef TRACE_ALL
	printf("Leaving isl_map_power\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1transitive_1closure
(JNIEnv *env, jclass class, jlong map, jobject exact)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_transitive_closure\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_transitive_closure for parameter map");
		goto error;
	}
	jclass exact_cls = (*env)->GetObjectClass(env, exact); 
	jfieldID exact_fid = (*env)->GetFieldID(env, exact_cls, "value", "Z");
	int exact_c = (int) (*env)->GetBooleanField(env, exact, exact_fid);

	isl_map* res = (isl_map*) isl_map_transitive_closure(map_c, &exact_c);

	(*env)->SetBooleanField(env, exact, exact_fid, exact_c);

#ifdef TRACE_ALL
	printf("Leaving isl_map_transitive_closure\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1reaching_1path_1lengths
(JNIEnv *env, jclass class, jlong map, jobject exact)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_reaching_path_lengths\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_reaching_path_lengths for parameter map");
		goto error;
	}
	jclass exact_cls = (*env)->GetObjectClass(env, exact); 
	jfieldID exact_fid = (*env)->GetFieldID(env, exact_cls, "value", "Z");
	int exact_c = (int) (*env)->GetBooleanField(env, exact, exact_fid);

	isl_map* res = (isl_map*) isl_map_reaching_path_lengths(map_c, &exact_c);

	(*env)->SetBooleanField(env, exact, exact_fid, exact_c);

#ifdef TRACE_ALL
	printf("Leaving isl_map_reaching_path_lengths\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1wrap
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_wrap\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_wrap for parameter map");
		goto error;
	}

	isl_set* res = (isl_set*) isl_map_wrap(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_wrap\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1flatten
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_flatten\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_flatten for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_flatten(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_flatten\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1flatten_1domain
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_flatten_domain\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_flatten_domain for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_flatten_domain(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_flatten_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1flatten_1range
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_flatten_range\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_flatten_range for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_flatten_range(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_flatten_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1zip
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_zip\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_zip for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_zip(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_zip\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1curry
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_curry\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_curry for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_curry(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_curry\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1uncurry
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_uncurry\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_uncurry for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_uncurry(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_uncurry\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1align_1params
(JNIEnv *env, jclass class, jlong map, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_align_params\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_align_params for parameter map");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_map_align_params for parameter model");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_align_params(map_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1add_1dims
(JNIEnv *env, jclass class, jlong map, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_add_dims\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_add_dims for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_add_dims(map_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1insert_1dims
(JNIEnv *env, jclass class, jlong map, jint type, jint pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_insert_dims\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_insert_dims for parameter map");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_insert_dims(map_c, type_c, pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1move_1dims
(JNIEnv *env, jclass class, jlong map, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_move_dims\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_move_dims for parameter map");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_map* res = (isl_map*) isl_map_move_dims(map_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1intersect_1params
(JNIEnv *env, jclass class, jlong map, jlong params)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_intersect_params\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_intersect_params for parameter map");
		goto error;
	}
	isl_set* params_c = (isl_set*) GECOS_PTRSIZE params; 
	if(((void*)params_c)==NULL) {
		throwException(env, "Null pointer in isl_map_intersect_params for parameter params");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_intersect_params(map_c, params_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1intersect_1domain
(JNIEnv *env, jclass class, jlong map, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_intersect_domain\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_intersect_domain for parameter map");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_map_intersect_domain for parameter set");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_intersect_domain(map_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1intersect_1range
(JNIEnv *env, jclass class, jlong map, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_intersect_range\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_intersect_range for parameter map");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_map_intersect_range for parameter set");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_intersect_range(map_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_intersect_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1intersect
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_intersect\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_intersect for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_intersect for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_intersect(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_intersect\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1union
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_union\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_union for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_union for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_union(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_union\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1subtract
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_subtract\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_subtract for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_subtract for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_subtract(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_subtract\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1subtract_1domain
(JNIEnv *env, jclass class, jlong map, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_subtract_domain\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_subtract_domain for parameter map");
		goto error;
	}
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_map_subtract_domain for parameter dom");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_subtract_domain(map_c, dom_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_subtract_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1subtract_1range
(JNIEnv *env, jclass class, jlong map, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_subtract_range\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_subtract_range for parameter map");
		goto error;
	}
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_map_subtract_range for parameter dom");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_subtract_range(map_c, dom_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_subtract_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1apply_1domain
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_apply_domain\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_apply_domain for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_apply_domain for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_apply_domain(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_apply_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1apply_1range
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_apply_range\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_apply_range for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_apply_range for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_apply_range(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_apply_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1preimage_1domain_1multi_1aff
(JNIEnv *env, jclass class, jlong map, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_preimage_domain_multi_aff\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_domain_multi_aff for parameter map");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_domain_multi_aff for parameter ma");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_preimage_domain_multi_aff(map_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_preimage_domain_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1preimage_1domain_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong map, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_preimage_domain_pw_multi_aff\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_domain_pw_multi_aff for parameter map");
		goto error;
	}
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_domain_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_preimage_domain_pw_multi_aff(map_c, pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_preimage_domain_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1preimage_1domain_1multi_1pw_1aff
(JNIEnv *env, jclass class, jlong map, jlong mpa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_preimage_domain_multi_pw_aff\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_domain_multi_pw_aff for parameter map");
		goto error;
	}
	isl_multi_pw_aff* mpa_c = (isl_multi_pw_aff*) GECOS_PTRSIZE mpa; 
	if(((void*)mpa_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_domain_multi_pw_aff for parameter mpa");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_preimage_domain_multi_pw_aff(map_c, mpa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_preimage_domain_multi_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1preimage_1range_1multi_1aff
(JNIEnv *env, jclass class, jlong map, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_preimage_range_multi_aff\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_range_multi_aff for parameter map");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_range_multi_aff for parameter ma");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_preimage_range_multi_aff(map_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_preimage_range_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1preimage_1range_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong map, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_preimage_range_pw_multi_aff\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_range_pw_multi_aff for parameter map");
		goto error;
	}
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_map_preimage_range_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_preimage_range_pw_multi_aff(map_c, pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_preimage_range_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1product
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_product\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_product for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_product for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_product(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1domain_1product
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_domain_product\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_domain_product for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_domain_product for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_domain_product(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_domain_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1range_1product
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_range_product\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_range_product for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_range_product for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_range_product(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_range_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1flat_1product
(JNIEnv *env, jclass class, jlong map1, jlong map2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_flat_product\n");fflush(stdout);
#endif
	isl_map* map1_c = (isl_map*) GECOS_PTRSIZE map1; 
	if(((void*)map1_c)==NULL) {
		throwException(env, "Null pointer in isl_map_flat_product for parameter map1");
		goto error;
	}
	isl_map* map2_c = (isl_map*) GECOS_PTRSIZE map2; 
	if(((void*)map2_c)==NULL) {
		throwException(env, "Null pointer in isl_map_flat_product for parameter map2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_flat_product(map1_c, map2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_flat_product\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1gist
(JNIEnv *env, jclass class, jlong map, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_gist\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_gist for parameter map");
		goto error;
	}
	isl_map* context_c = (isl_map*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_map_gist for parameter context");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_gist(map_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1gist_1params
(JNIEnv *env, jclass class, jlong map, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_gist_params\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_gist_params for parameter map");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_map_gist_params for parameter context");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_gist_params(map_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_gist_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1gist_1domain
(JNIEnv *env, jclass class, jlong map, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_gist_domain\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_gist_domain for parameter map");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_map_gist_domain for parameter context");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_gist_domain(map_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_gist_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1gist_1range
(JNIEnv *env, jclass class, jlong map, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_gist_range\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_gist_range for parameter map");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_map_gist_range for parameter context");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_gist_range(map_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_gist_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1partial_1lexmin
(JNIEnv *env, jclass class, jlong map, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_partial_lexmin\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_partial_lexmin for parameter map");
		goto error;
	}
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_map_partial_lexmin for parameter dom");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_partial_lexmin(map_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_map_partial_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1partial_1lexmax
(JNIEnv *env, jclass class, jlong map, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_partial_lexmax\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_partial_lexmax for parameter map");
		goto error;
	}
	isl_set* dom_c = (isl_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_map_partial_lexmax for parameter dom");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_partial_lexmax(map_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_map_partial_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lexmin
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lexmin\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lexmin for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_lexmin(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lexmax
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lexmax\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lexmax for parameter map");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_lexmax(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lexmin_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lexmin_pw_multi_aff for parameter map");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_map_lexmin_pw_multi_aff(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1lexmax_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_lexmax_pw_multi_aff\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_lexmax_pw_multi_aff for parameter map");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_map_lexmax_pw_multi_aff(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_lexmax_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1get_1basic_1map_1at
(JNIEnv *env, jclass class, jlong map, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_get_basic_map_at\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_get_basic_map_at for parameter map");
		goto error;
	}
	int pos_c = (int) pos;

	isl_basic_map* res = (isl_basic_map*) isl_map_get_basic_map_at(map_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_get_basic_map_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1numberof_1basic_1map
(JNIEnv *env, jclass class, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_numberof_basic_map\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_numberof_basic_map for parameter map");
		goto error;
	}

	int res = (int) isl_map_numberof_basic_map(map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_numberof_basic_map\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1to_1string
(JNIEnv *env, jclass class, jlong map, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_to_string\n");fflush(stdout);
#endif
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_map_to_string for parameter map");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_map_to_string(map_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_clear_1in_1tuple_1name
(JNIEnv *env, jclass class, jlong m)
 {
#ifdef TRACE_ALL
	printf("Entering clear_in_tuple_name\n");fflush(stdout);
#endif
	isl_map* m_c = (isl_map*) GECOS_PTRSIZE m; 
	if(((void*)m_c)==NULL) {
		throwException(env, "Null pointer in clear_in_tuple_name for parameter m");
		goto error;
	}

	isl_map* res = (isl_map*) clear_in_tuple_name(m_c);


#ifdef TRACE_ALL
	printf("Leaving clear_in_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_clear_1out_1tuple_1name
(JNIEnv *env, jclass class, jlong m)
 {
#ifdef TRACE_ALL
	printf("Entering clear_out_tuple_name\n");fflush(stdout);
#endif
	isl_map* m_c = (isl_map*) GECOS_PTRSIZE m; 
	if(((void*)m_c)==NULL) {
		throwException(env, "Null pointer in clear_out_tuple_name for parameter m");
		goto error;
	}

	isl_map* res = (isl_map*) clear_out_tuple_name(m_c);


#ifdef TRACE_ALL
	printf("Leaving clear_out_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


