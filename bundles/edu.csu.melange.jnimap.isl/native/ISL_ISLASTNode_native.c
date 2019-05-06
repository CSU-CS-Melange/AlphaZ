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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1ast_1from_1schedule
(JNIEnv *env, jclass class, jlong build, jlong schedule)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_ast_from_schedule\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_ast_from_schedule for parameter build");
		goto error;
	}
	isl_union_map* schedule_c = (isl_union_map*) GECOS_PTRSIZE schedule; 
	if(((void*)schedule_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_ast_from_schedule for parameter schedule");
		goto error;
	}

	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_build_ast_from_schedule(build_c, schedule_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_ast_from_schedule\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1get_1ctx
(JNIEnv *env, jclass class, jlong node)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_get_ctx\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_get_ctx for parameter node");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_ast_node_get_ctx(node_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1copy
(JNIEnv *env, jclass class, jlong node)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_copy\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_copy for parameter node");
		goto error;
	}

	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_node_copy(node_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1free
(JNIEnv *env, jclass class, jlong node)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_free\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_free for parameter node");
		goto error;
	}

	 isl_ast_node_free(node_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1get_1type
(JNIEnv *env, jclass class, jlong node)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_get_type\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_get_type for parameter node");
		goto error;
	}

	enum isl_ast_node_type res = (enum isl_ast_node_type) isl_ast_node_get_type(node_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_get_type\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return -1000;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1set_1annotation
(JNIEnv *env, jclass class, jlong node, jlong annotation)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_set_annotation\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_set_annotation for parameter node");
		goto error;
	}
	isl_id* annotation_c = (isl_id*) GECOS_PTRSIZE annotation; 
	if(((void*)annotation_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_set_annotation for parameter annotation");
		goto error;
	}

	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_node_set_annotation(node_c, annotation_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_set_annotation\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1get_1annotation
(JNIEnv *env, jclass class, jlong node)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_get_annotation\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_get_annotation for parameter node");
		goto error;
	}

	isl_id* res = (isl_id*) isl_ast_node_get_annotation(node_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_get_annotation\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1to_1string
(JNIEnv *env, jclass class, jlong node)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_to_string\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_to_string for parameter node");
		goto error;
	}

	char * res = (char *) isl_ast_node_to_string(node_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


