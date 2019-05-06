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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vec_1alloc
(JNIEnv *env, jclass class, jlong ctx, jint size)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vec_alloc\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_alloc for parameter ctx");
		goto error;
	}
	unsigned int size_c = (unsigned int) size;

	isl_vec* res = (isl_vec*) isl_vec_alloc(ctx_c, size_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vec_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vec_1get_1ctx
(JNIEnv *env, jclass class, jlong vec)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vec_get_ctx\n");fflush(stdout);
#endif
	isl_vec* vec_c = (isl_vec*) GECOS_PTRSIZE vec; 
	if(((void*)vec_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_get_ctx for parameter vec");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_vec_get_ctx(vec_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vec_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vec_1copy
(JNIEnv *env, jclass class, jlong vec)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vec_copy\n");fflush(stdout);
#endif
	isl_vec* vec_c = (isl_vec*) GECOS_PTRSIZE vec; 
	if(((void*)vec_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_copy for parameter vec");
		goto error;
	}

	isl_vec* res = (isl_vec*) isl_vec_copy(vec_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vec_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vec_1free
(JNIEnv *env, jclass class, jlong vec)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vec_free\n");fflush(stdout);
#endif
	isl_vec* vec_c = (isl_vec*) GECOS_PTRSIZE vec; 
	if(((void*)vec_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_free for parameter vec");
		goto error;
	}

	 isl_vec_free(vec_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vec_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vec_1size
(JNIEnv *env, jclass class, jlong vec)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vec_size\n");fflush(stdout);
#endif
	isl_vec* vec_c = (isl_vec*) GECOS_PTRSIZE vec; 
	if(((void*)vec_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_size for parameter vec");
		goto error;
	}

	int res = (int) isl_vec_size(vec_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vec_size\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vec_1get_1element_1val
(JNIEnv *env, jclass class, jlong vec, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vec_get_element_val\n");fflush(stdout);
#endif
	isl_vec* vec_c = (isl_vec*) GECOS_PTRSIZE vec; 
	if(((void*)vec_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_get_element_val for parameter vec");
		goto error;
	}
	int pos_c = (int) pos;

	isl_val* res = (isl_val*) isl_vec_get_element_val(vec_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vec_get_element_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vec_1set_1element_1si
(JNIEnv *env, jclass class, jlong vec, jint pos, jint v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vec_set_element_si\n");fflush(stdout);
#endif
	isl_vec* vec_c = (isl_vec*) GECOS_PTRSIZE vec; 
	if(((void*)vec_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_set_element_si for parameter vec");
		goto error;
	}
	int pos_c = (int) pos;
	int v_c = (int) v;

	isl_vec* res = (isl_vec*) isl_vec_set_element_si(vec_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vec_set_element_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vec_1set_1element_1val
(JNIEnv *env, jclass class, jlong vec, jint pos, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vec_set_element_val\n");fflush(stdout);
#endif
	isl_vec* vec_c = (isl_vec*) GECOS_PTRSIZE vec; 
	if(((void*)vec_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_set_element_val for parameter vec");
		goto error;
	}
	int pos_c = (int) pos;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_vec_set_element_val for parameter v");
		goto error;
	}

	isl_vec* res = (isl_vec*) isl_vec_set_element_val(vec_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vec_set_element_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


