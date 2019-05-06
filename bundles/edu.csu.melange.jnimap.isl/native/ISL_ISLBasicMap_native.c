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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_basic_map_read_from_str for parameter str");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1from_1basic_1map
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_from_basic_map\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_basic_map for parameter bmap");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_from_basic_map(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_from_basic_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1from_1basic_1map
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_from_basic_map\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_from_basic_map for parameter bmap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_from_basic_map(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_from_basic_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1empty
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_empty\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_empty for parameter space");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_empty(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1universe
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_universe\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_universe for parameter space");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_universe(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1nat_1universe
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_nat_universe\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_nat_universe for parameter space");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_nat_universe(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_nat_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1identity
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_identity\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_identity for parameter space");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_identity(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_identity\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1get_1ctx
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_get_ctx\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_get_ctx for parameter bmap");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_basic_map_get_ctx(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1get_1space
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_get_space\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_get_space for parameter bmap");
		goto error;
	}

	isl_space* res = (isl_space*) isl_basic_map_get_space(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1copy
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_copy\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_copy for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_copy(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1free
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_free\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_free for parameter bmap");
		goto error;
	}

	 isl_basic_map_free(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1add_1constraint
(JNIEnv *env, jclass class, jlong bmap, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_add_constraint\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_add_constraint for parameter bmap");
		goto error;
	}
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_add_constraint for parameter constraint");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_add_constraint(bmap_c, constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_add_constraint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1dim
(JNIEnv *env, jclass class, jlong bmap, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_dim\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_dim for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_basic_map_dim(bmap_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1get_1tuple_1name
(JNIEnv *env, jclass class, jlong bmap, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_get_tuple_name\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_get_tuple_name for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	char * res = (char *) isl_basic_map_get_tuple_name(bmap_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_get_tuple_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1set_1tuple_1name
(JNIEnv *env, jclass class, jlong bmap, jint type, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_set_tuple_name\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_set_tuple_name for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_basic_map_set_tuple_name for parameter s");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_set_tuple_name(bmap_c, type_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_set_tuple_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1get_1dim_1name
(JNIEnv *env, jclass class, jlong bmap, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_get_dim_name\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_get_dim_name for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_basic_map_get_dim_name(bmap_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1set_1dim_1name
(JNIEnv *env, jclass class, jlong bmap, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_set_dim_name\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_set_dim_name for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_basic_map_set_dim_name for parameter s");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_set_dim_name(bmap_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1involves_1dims
(JNIEnv *env, jclass class, jlong bmap, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_involves_dims\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_involves_dims for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_basic_map_involves_dims(bmap_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1has_1dim_1id
(JNIEnv *env, jclass class, jlong bmap, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_has_dim_id\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_has_dim_id for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_basic_map_has_dim_id(bmap_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_has_dim_id\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1remove_1divs
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_remove_divs\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_remove_divs for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_remove_divs(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_remove_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1remove_1divs_1involving_1dims
(JNIEnv *env, jclass class, jlong bmap, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_remove_divs_involving_dims\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_remove_divs_involving_dims for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_remove_divs_involving_dims(bmap_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_remove_divs_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1from_1constraint_1matrices
(JNIEnv *env, jclass class, jlong space, jlong eq, jlong ineq, jint c1, jint c2, jint c3, jint c4, jint c5)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_from_constraint_matrices\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_from_constraint_matrices for parameter space");
		goto error;
	}
	isl_mat* eq_c = (isl_mat*) GECOS_PTRSIZE eq; 
	if(((void*)eq_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_from_constraint_matrices for parameter eq");
		goto error;
	}
	isl_mat* ineq_c = (isl_mat*) GECOS_PTRSIZE ineq; 
	if(((void*)ineq_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_from_constraint_matrices for parameter ineq");
		goto error;
	}
	enum isl_dim_type c1_c = (enum isl_dim_type) c1;
	enum isl_dim_type c2_c = (enum isl_dim_type) c2;
	enum isl_dim_type c3_c = (enum isl_dim_type) c3;
	enum isl_dim_type c4_c = (enum isl_dim_type) c4;
	enum isl_dim_type c5_c = (enum isl_dim_type) c5;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_from_constraint_matrices(space_c, eq_c, ineq_c, c1_c, c2_c, c3_c, c4_c, c5_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_from_constraint_matrices\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1equalities_1matrix
(JNIEnv *env, jclass class, jlong bmap, jint c1, jint c2, jint c3, jint c4, jint c5)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_equalities_matrix\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_equalities_matrix for parameter bmap");
		goto error;
	}
	enum isl_dim_type c1_c = (enum isl_dim_type) c1;
	enum isl_dim_type c2_c = (enum isl_dim_type) c2;
	enum isl_dim_type c3_c = (enum isl_dim_type) c3;
	enum isl_dim_type c4_c = (enum isl_dim_type) c4;
	enum isl_dim_type c5_c = (enum isl_dim_type) c5;

	isl_mat* res = (isl_mat*) isl_basic_map_equalities_matrix(bmap_c, c1_c, c2_c, c3_c, c4_c, c5_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_equalities_matrix\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1inequalities_1matrix
(JNIEnv *env, jclass class, jlong bmap, jint c1, jint c2, jint c3, jint c4, jint c5)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_inequalities_matrix\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_inequalities_matrix for parameter bmap");
		goto error;
	}
	enum isl_dim_type c1_c = (enum isl_dim_type) c1;
	enum isl_dim_type c2_c = (enum isl_dim_type) c2;
	enum isl_dim_type c3_c = (enum isl_dim_type) c3;
	enum isl_dim_type c4_c = (enum isl_dim_type) c4;
	enum isl_dim_type c5_c = (enum isl_dim_type) c5;

	isl_mat* res = (isl_mat*) isl_basic_map_inequalities_matrix(bmap_c, c1_c, c2_c, c3_c, c4_c, c5_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_inequalities_matrix\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1plain_1is_1empty
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_plain_is_empty\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_plain_is_empty for parameter bmap");
		goto error;
	}

	int res = (int) isl_basic_map_plain_is_empty(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_plain_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1is_1empty
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_is_empty\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_empty for parameter bmap");
		goto error;
	}

	int res = (int) isl_basic_map_is_empty(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1is_1universe
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_is_universe\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_universe for parameter bmap");
		goto error;
	}

	int res = (int) isl_basic_map_is_universe(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_is_universe\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1is_1single_1valued
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_is_single_valued\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_single_valued for parameter bmap");
		goto error;
	}

	int res = (int) isl_basic_map_is_single_valued(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_is_single_valued\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1can_1curry
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_can_curry\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_can_curry for parameter bmap");
		goto error;
	}

	int res = (int) isl_basic_map_can_curry(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_can_curry\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1can_1uncurry
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_can_uncurry\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_can_uncurry for parameter bmap");
		goto error;
	}

	int res = (int) isl_basic_map_can_uncurry(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_can_uncurry\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1can_1zip
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_can_zip\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_can_zip for parameter bmap");
		goto error;
	}

	int res = (int) isl_basic_map_can_zip(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_can_zip\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1is_1equal
(JNIEnv *env, jclass class, jlong bmap1, jlong bmap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_is_equal\n");fflush(stdout);
#endif
	isl_basic_map* bmap1_c = (isl_basic_map*) GECOS_PTRSIZE bmap1; 
	if(((void*)bmap1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_equal for parameter bmap1");
		goto error;
	}
	isl_basic_map* bmap2_c = (isl_basic_map*) GECOS_PTRSIZE bmap2; 
	if(((void*)bmap2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_equal for parameter bmap2");
		goto error;
	}

	int res = (int) isl_basic_map_is_equal(bmap1_c, bmap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1is_1disjoint
(JNIEnv *env, jclass class, jlong bmap1, jlong bmap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_is_disjoint\n");fflush(stdout);
#endif
	isl_basic_map* bmap1_c = (isl_basic_map*) GECOS_PTRSIZE bmap1; 
	if(((void*)bmap1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_disjoint for parameter bmap1");
		goto error;
	}
	isl_basic_map* bmap2_c = (isl_basic_map*) GECOS_PTRSIZE bmap2; 
	if(((void*)bmap2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_disjoint for parameter bmap2");
		goto error;
	}

	int res = (int) isl_basic_map_is_disjoint(bmap1_c, bmap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_is_disjoint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1is_1subset
(JNIEnv *env, jclass class, jlong bmap1, jlong bmap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_is_subset\n");fflush(stdout);
#endif
	isl_basic_map* bmap1_c = (isl_basic_map*) GECOS_PTRSIZE bmap1; 
	if(((void*)bmap1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_subset for parameter bmap1");
		goto error;
	}
	isl_basic_map* bmap2_c = (isl_basic_map*) GECOS_PTRSIZE bmap2; 
	if(((void*)bmap2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_subset for parameter bmap2");
		goto error;
	}

	int res = (int) isl_basic_map_is_subset(bmap1_c, bmap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_is_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1is_1strict_1subset
(JNIEnv *env, jclass class, jlong bmap1, jlong bmap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_is_strict_subset\n");fflush(stdout);
#endif
	isl_basic_map* bmap1_c = (isl_basic_map*) GECOS_PTRSIZE bmap1; 
	if(((void*)bmap1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_strict_subset for parameter bmap1");
		goto error;
	}
	isl_basic_map* bmap2_c = (isl_basic_map*) GECOS_PTRSIZE bmap2; 
	if(((void*)bmap2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_is_strict_subset for parameter bmap2");
		goto error;
	}

	int res = (int) isl_basic_map_is_strict_subset(bmap1_c, bmap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_is_strict_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1reverse
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_reverse\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_reverse for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_reverse(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_reverse\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1project_1out
(JNIEnv *env, jclass class, jlong bmap, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_project_out\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_project_out for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_project_out(bmap_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_project_out\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1domain
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_domain\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_domain for parameter bmap");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_map_domain(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1range
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_range\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_range for parameter bmap");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_map_range(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1domain_1map
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_domain_map\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_domain_map for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_domain_map(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_domain_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1range_1map
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_range_map\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_range_map for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_range_map(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_range_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1eliminate
(JNIEnv *env, jclass class, jlong bmap, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_eliminate\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_eliminate for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_eliminate(bmap_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_eliminate\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1fix_1si
(JNIEnv *env, jclass class, jlong bmap, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_fix_si\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_fix_si for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_fix_si(bmap_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_fix_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1fix_1val
(JNIEnv *env, jclass class, jlong bmap, jint type, jint pos, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_fix_val\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_fix_val for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_fix_val for parameter v");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_fix_val(bmap_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_fix_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1lower_1bound_1si
(JNIEnv *env, jclass class, jlong bmap, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_lower_bound_si\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_lower_bound_si for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_lower_bound_si(bmap_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_lower_bound_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1upper_1bound_1si
(JNIEnv *env, jclass class, jlong bmap, jint type, jint pos, jint value)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_upper_bound_si\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_upper_bound_si for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	int value_c = (int) value;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_upper_bound_si(bmap_c, type_c, pos_c, value_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_upper_bound_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1equate
(JNIEnv *env, jclass class, jlong bmap, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_equate\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_equate for parameter bmap");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_equate(bmap_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_equate\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1order_1ge
(JNIEnv *env, jclass class, jlong bmap, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_order_ge\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_order_ge for parameter bmap");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_order_ge(bmap_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_order_ge\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1order_1gt
(JNIEnv *env, jclass class, jlong bmap, jint type1, jint pos1, jint type2, jint pos2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_order_gt\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_order_gt for parameter bmap");
		goto error;
	}
	enum isl_dim_type type1_c = (enum isl_dim_type) type1;
	int pos1_c = (int) pos1;
	enum isl_dim_type type2_c = (enum isl_dim_type) type2;
	int pos2_c = (int) pos2;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_order_gt(bmap_c, type1_c, pos1_c, type2_c, pos2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_order_gt\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1deltas
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_deltas\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_deltas for parameter bmap");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_map_deltas(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_deltas\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1deltas_1map
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_deltas_map\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_deltas_map for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_deltas_map(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_deltas_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1detect_1equalities
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_detect_equalities\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_detect_equalities for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_detect_equalities(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_detect_equalities\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1remove_1redundancies
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_remove_redundancies\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_remove_redundancies for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_remove_redundancies(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_remove_redundancies\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1affine_1hull
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_affine_hull\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_affine_hull for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_affine_hull(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_affine_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1drop_1constraints_1involving_1dims
(JNIEnv *env, jclass class, jlong bmap, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_drop_constraints_involving_dims\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_drop_constraints_involving_dims for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_drop_constraints_involving_dims(bmap_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_drop_constraints_involving_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1sample
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_sample\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_sample for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_sample(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_sample\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1wrap
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_wrap\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_wrap for parameter bmap");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_map_wrap(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_wrap\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1flatten
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_flatten\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_flatten for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_flatten(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_flatten\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1flatten_1domain
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_flatten_domain\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_flatten_domain for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_flatten_domain(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_flatten_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1flatten_1range
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_flatten_range\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_flatten_range for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_flatten_range(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_flatten_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1zip
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_zip\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_zip for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_zip(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_zip\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1curry
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_curry\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_curry for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_curry(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_curry\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1uncurry
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_uncurry\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_uncurry for parameter bmap");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_uncurry(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_uncurry\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1align_1params
(JNIEnv *env, jclass class, jlong bmap, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_align_params\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_align_params for parameter bmap");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_align_params for parameter model");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_align_params(bmap_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1insert_1dims
(JNIEnv *env, jclass class, jlong bmap, jint type, jint pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_insert_dims\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_insert_dims for parameter bmap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	unsigned int n_c = (unsigned int) n;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_insert_dims(bmap_c, type_c, pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1move_1dims
(JNIEnv *env, jclass class, jlong bmap, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_move_dims\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_move_dims for parameter bmap");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_move_dims(bmap_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1intersect_1domain
(JNIEnv *env, jclass class, jlong bmap, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_intersect_domain\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_intersect_domain for parameter bmap");
		goto error;
	}
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_intersect_domain for parameter bset");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_intersect_domain(bmap_c, bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1intersect_1range
(JNIEnv *env, jclass class, jlong bmap, jlong bset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_intersect_range\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_intersect_range for parameter bmap");
		goto error;
	}
	isl_basic_set* bset_c = (isl_basic_set*) GECOS_PTRSIZE bset; 
	if(((void*)bset_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_intersect_range for parameter bset");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_intersect_range(bmap_c, bset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_intersect_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1intersect
(JNIEnv *env, jclass class, jlong bmap1, jlong bmap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_intersect\n");fflush(stdout);
#endif
	isl_basic_map* bmap1_c = (isl_basic_map*) GECOS_PTRSIZE bmap1; 
	if(((void*)bmap1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_intersect for parameter bmap1");
		goto error;
	}
	isl_basic_map* bmap2_c = (isl_basic_map*) GECOS_PTRSIZE bmap2; 
	if(((void*)bmap2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_intersect for parameter bmap2");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_intersect(bmap1_c, bmap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_intersect\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1union
(JNIEnv *env, jclass class, jlong bmap1, jlong bmap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_union\n");fflush(stdout);
#endif
	isl_basic_map* bmap1_c = (isl_basic_map*) GECOS_PTRSIZE bmap1; 
	if(((void*)bmap1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_union for parameter bmap1");
		goto error;
	}
	isl_basic_map* bmap2_c = (isl_basic_map*) GECOS_PTRSIZE bmap2; 
	if(((void*)bmap2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_union for parameter bmap2");
		goto error;
	}

	isl_map* res = (isl_map*) isl_basic_map_union(bmap1_c, bmap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_union\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1apply_1domain
(JNIEnv *env, jclass class, jlong bmap1, jlong bmap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_apply_domain\n");fflush(stdout);
#endif
	isl_basic_map* bmap1_c = (isl_basic_map*) GECOS_PTRSIZE bmap1; 
	if(((void*)bmap1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_apply_domain for parameter bmap1");
		goto error;
	}
	isl_basic_map* bmap2_c = (isl_basic_map*) GECOS_PTRSIZE bmap2; 
	if(((void*)bmap2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_apply_domain for parameter bmap2");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_apply_domain(bmap1_c, bmap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_apply_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1apply_1range
(JNIEnv *env, jclass class, jlong bmap1, jlong bmap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_apply_range\n");fflush(stdout);
#endif
	isl_basic_map* bmap1_c = (isl_basic_map*) GECOS_PTRSIZE bmap1; 
	if(((void*)bmap1_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_apply_range for parameter bmap1");
		goto error;
	}
	isl_basic_map* bmap2_c = (isl_basic_map*) GECOS_PTRSIZE bmap2; 
	if(((void*)bmap2_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_apply_range for parameter bmap2");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_apply_range(bmap1_c, bmap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_apply_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1preimage_1domain_1multi_1aff
(JNIEnv *env, jclass class, jlong bmap, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_preimage_domain_multi_aff\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_preimage_domain_multi_aff for parameter bmap");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_preimage_domain_multi_aff for parameter ma");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_preimage_domain_multi_aff(bmap_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_preimage_domain_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1preimage_1range_1multi_1aff
(JNIEnv *env, jclass class, jlong bmap, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_preimage_range_multi_aff\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_preimage_range_multi_aff for parameter bmap");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_preimage_range_multi_aff for parameter ma");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_preimage_range_multi_aff(bmap_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_preimage_range_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1gist
(JNIEnv *env, jclass class, jlong bmap, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_gist\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_gist for parameter bmap");
		goto error;
	}
	isl_basic_map* context_c = (isl_basic_map*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_gist for parameter context");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_gist(bmap_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1partial_1lexmin
(JNIEnv *env, jclass class, jlong bmap, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_partial_lexmin\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_partial_lexmin for parameter bmap");
		goto error;
	}
	isl_basic_set* dom_c = (isl_basic_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_partial_lexmin for parameter dom");
		goto error;
	}

	isl_map* res = (isl_map*) isl_basic_map_partial_lexmin(bmap_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_partial_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1partial_1lexmax
(JNIEnv *env, jclass class, jlong bmap, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_partial_lexmax\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_partial_lexmax for parameter bmap");
		goto error;
	}
	isl_basic_set* dom_c = (isl_basic_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_partial_lexmax for parameter dom");
		goto error;
	}

	isl_map* res = (isl_map*) isl_basic_map_partial_lexmax(bmap_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_partial_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1lexmin
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_lexmin\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_lexmin for parameter bmap");
		goto error;
	}

	isl_map* res = (isl_map*) isl_basic_map_lexmin(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1lexmax
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_lexmax\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_lexmax for parameter bmap");
		goto error;
	}

	isl_map* res = (isl_map*) isl_basic_map_lexmax(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1lexmin_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_lexmin_pw_multi_aff for parameter bmap");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_basic_map_lexmin_pw_multi_aff(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1partial_1lexmin_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong bmap, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_partial_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_partial_lexmin_pw_multi_aff for parameter bmap");
		goto error;
	}
	isl_basic_set* dom_c = (isl_basic_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_partial_lexmin_pw_multi_aff for parameter dom");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_basic_map_partial_lexmin_pw_multi_aff(bmap_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_partial_lexmin_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1partial_1lexmax_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong bmap, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_partial_lexmax_pw_multi_aff\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_partial_lexmax_pw_multi_aff for parameter bmap");
		goto error;
	}
	isl_basic_set* dom_c = (isl_basic_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_partial_lexmax_pw_multi_aff for parameter dom");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_basic_map_partial_lexmax_pw_multi_aff(bmap_c, dom_c, NULL);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_partial_lexmax_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1numberof_1constraint
(JNIEnv *env, jclass class, jlong bmap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_numberof_constraint\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_numberof_constraint for parameter bmap");
		goto error;
	}

	int res = (int) isl_basic_map_numberof_constraint(bmap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_numberof_constraint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1get_1constraint_1at
(JNIEnv *env, jclass class, jlong bmap, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_get_constraint_at\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_get_constraint_at for parameter bmap");
		goto error;
	}
	int pos_c = (int) pos;

	isl_constraint* res = (isl_constraint*) isl_basic_map_get_constraint_at(bmap_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_get_constraint_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1to_1string
(JNIEnv *env, jclass class, jlong bmap, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_to_string\n");fflush(stdout);
#endif
	isl_basic_map* bmap_c = (isl_basic_map*) GECOS_PTRSIZE bmap; 
	if(((void*)bmap_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_to_string for parameter bmap");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_basic_map_to_string(bmap_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


