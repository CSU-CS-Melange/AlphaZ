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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vertices_1get_1ctx
(JNIEnv *env, jclass class, jlong vertices)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vertices_get_ctx\n");fflush(stdout);
#endif
	isl_vertices* vertices_c = (isl_vertices*) GECOS_PTRSIZE vertices; 
	if(((void*)vertices_c)==NULL) {
		throwException(env, "Null pointer in isl_vertices_get_ctx for parameter vertices");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_vertices_get_ctx(vertices_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vertices_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vertices_1free
(JNIEnv *env, jclass class, jlong vertices)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vertices_free\n");fflush(stdout);
#endif
	isl_vertices* vertices_c = (isl_vertices*) GECOS_PTRSIZE vertices; 
	if(((void*)vertices_c)==NULL) {
		throwException(env, "Null pointer in isl_vertices_free for parameter vertices");
		goto error;
	}

	 isl_vertices_free(vertices_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vertices_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vertices_1get_1n_1vertices
(JNIEnv *env, jclass class, jlong vertices)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vertices_get_n_vertices\n");fflush(stdout);
#endif
	isl_vertices* vertices_c = (isl_vertices*) GECOS_PTRSIZE vertices; 
	if(((void*)vertices_c)==NULL) {
		throwException(env, "Null pointer in isl_vertices_get_n_vertices for parameter vertices");
		goto error;
	}

	int res = (int) isl_vertices_get_n_vertices(vertices_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vertices_get_n_vertices\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vertices_1numberof_1vertex
(JNIEnv *env, jclass class, jlong vertices)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vertices_numberof_vertex\n");fflush(stdout);
#endif
	isl_vertices* vertices_c = (isl_vertices*) GECOS_PTRSIZE vertices; 
	if(((void*)vertices_c)==NULL) {
		throwException(env, "Null pointer in isl_vertices_numberof_vertex for parameter vertices");
		goto error;
	}

	int res = (int) isl_vertices_numberof_vertex(vertices_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vertices_numberof_vertex\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vertices_1get_1vertex_1at
(JNIEnv *env, jclass class, jlong vertices, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vertices_get_vertex_at\n");fflush(stdout);
#endif
	isl_vertices* vertices_c = (isl_vertices*) GECOS_PTRSIZE vertices; 
	if(((void*)vertices_c)==NULL) {
		throwException(env, "Null pointer in isl_vertices_get_vertex_at for parameter vertices");
		goto error;
	}
	int pos_c = (int) pos;

	isl_vertex* res = (isl_vertex*) isl_vertices_get_vertex_at(vertices_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vertices_get_vertex_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vertices_1numberof_1cell
(JNIEnv *env, jclass class, jlong vertices)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vertices_numberof_cell\n");fflush(stdout);
#endif
	isl_vertices* vertices_c = (isl_vertices*) GECOS_PTRSIZE vertices; 
	if(((void*)vertices_c)==NULL) {
		throwException(env, "Null pointer in isl_vertices_numberof_cell for parameter vertices");
		goto error;
	}

	int res = (int) isl_vertices_numberof_cell(vertices_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vertices_numberof_cell\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1vertices_1get_1cell_1at
(JNIEnv *env, jclass class, jlong vertices, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_vertices_get_cell_at\n");fflush(stdout);
#endif
	isl_vertices* vertices_c = (isl_vertices*) GECOS_PTRSIZE vertices; 
	if(((void*)vertices_c)==NULL) {
		throwException(env, "Null pointer in isl_vertices_get_cell_at for parameter vertices");
		goto error;
	}
	int pos_c = (int) pos;

	isl_cell* res = (isl_cell*) isl_vertices_get_cell_at(vertices_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_vertices_get_cell_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


