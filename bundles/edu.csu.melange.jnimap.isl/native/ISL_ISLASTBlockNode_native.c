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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1block_1get_1children
(JNIEnv *env, jclass class, jlong node)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_block_get_children\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_block_get_children for parameter node");
		goto error;
	}

	struct isl_ast_node_list* res = (struct isl_ast_node_list*) isl_ast_node_block_get_children(node_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_block_get_children\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1node_1is_1block
(JNIEnv *env, jclass class, jlong node)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_node_is_block\n");fflush(stdout);
#endif
	struct isl_ast_node* node_c = (struct isl_ast_node*) GECOS_PTRSIZE node; 
	if(((void*)node_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_node_is_block for parameter node");
		goto error;
	}

	int res = (int) isl_ast_node_is_block(node_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_node_is_block\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


