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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1get_1ctx
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_get_ctx\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_get_ctx for parameter ls");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_local_space_get_ctx(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1get_1space
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_get_space\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_get_space for parameter ls");
		goto error;
	}

	isl_space* res = (isl_space*) isl_local_space_get_space(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1copy
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_copy\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_copy for parameter ls");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_copy(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1free
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_free\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_free for parameter ls");
		goto error;
	}

	 isl_local_space_free(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1is_1set
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_is_set\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_is_set for parameter ls");
		goto error;
	}

	int res = (int) isl_local_space_is_set(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_is_set\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1dim
(JNIEnv *env, jclass class, jlong ls, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_dim\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_dim for parameter ls");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	int res = (int) isl_local_space_dim(ls_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1has_1dim_1name
(JNIEnv *env, jclass class, jlong ls, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_has_dim_name\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_has_dim_name for parameter ls");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_local_space_has_dim_name(ls_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_has_dim_name\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1get_1dim_1name
(JNIEnv *env, jclass class, jlong ls, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_get_dim_name\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_get_dim_name for parameter ls");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_local_space_get_dim_name(ls_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1set_1dim_1name
(JNIEnv *env, jclass class, jlong ls, jint type, jint pos, jstring s)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_set_dim_name\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_set_dim_name for parameter ls");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;
	char* s_c;
	s_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, s, NULL);
	if (s_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_local_space_set_dim_name for parameter s");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_set_dim_name(ls_c, type_c, pos_c, s_c);

	(*env)->ReleaseStringUTFChars(env, s, s_c);

#ifdef TRACE_ALL
	printf("Leaving isl_local_space_set_dim_name\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1get_1div
(JNIEnv *env, jclass class, jlong ls, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_get_div\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_get_div for parameter ls");
		goto error;
	}
	int pos_c = (int) pos;

	isl_aff* res = (isl_aff*) isl_local_space_get_div(ls_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_get_div\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1is_1equal
(JNIEnv *env, jclass class, jlong ls1, jlong ls2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_is_equal\n");fflush(stdout);
#endif
	isl_local_space* ls1_c = (isl_local_space*) GECOS_PTRSIZE ls1; 
	if(((void*)ls1_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_is_equal for parameter ls1");
		goto error;
	}
	isl_local_space* ls2_c = (isl_local_space*) GECOS_PTRSIZE ls2; 
	if(((void*)ls2_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_is_equal for parameter ls2");
		goto error;
	}

	int res = (int) isl_local_space_is_equal(ls1_c, ls2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1domain
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_domain\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_domain for parameter ls");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_domain(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1range
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_range\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_range for parameter ls");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_range(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1from_1domain
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_from_domain\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_from_domain for parameter ls");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_from_domain(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_from_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1flatten_1domain
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_flatten_domain\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_flatten_domain for parameter ls");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_flatten_domain(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_flatten_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1flatten_1range
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_flatten_range\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_flatten_range for parameter ls");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_flatten_range(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_flatten_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1lifting
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_lifting\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_lifting for parameter ls");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_local_space_lifting(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_lifting\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1add_1dims
(JNIEnv *env, jclass class, jlong ls, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_add_dims\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_add_dims for parameter ls");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_local_space* res = (isl_local_space*) isl_local_space_add_dims(ls_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1insert_1dims
(JNIEnv *env, jclass class, jlong ls, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_insert_dims\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_insert_dims for parameter ls");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_local_space* res = (isl_local_space*) isl_local_space_insert_dims(ls_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1drop_1dims
(JNIEnv *env, jclass class, jlong ls, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_drop_dims\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_drop_dims for parameter ls");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_local_space* res = (isl_local_space*) isl_local_space_drop_dims(ls_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1intersect
(JNIEnv *env, jclass class, jlong ls1, jlong ls2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_intersect\n");fflush(stdout);
#endif
	isl_local_space* ls1_c = (isl_local_space*) GECOS_PTRSIZE ls1; 
	if(((void*)ls1_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_intersect for parameter ls1");
		goto error;
	}
	isl_local_space* ls2_c = (isl_local_space*) GECOS_PTRSIZE ls2; 
	if(((void*)ls2_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_intersect for parameter ls2");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_intersect(ls1_c, ls2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_intersect\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1local_1space_1from_1space
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_local_space_from_space\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_local_space_from_space for parameter dim");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_local_space_from_space(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_local_space_from_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


