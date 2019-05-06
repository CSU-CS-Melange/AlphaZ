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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1from_1context
(JNIEnv *env, jclass class, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_from_context\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_from_context for parameter set");
		goto error;
	}

	struct isl_ast_build* res = (struct isl_ast_build*) isl_ast_build_from_context(set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_from_context\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1get_1ctx
(JNIEnv *env, jclass class, jlong build)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_get_ctx\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_get_ctx for parameter build");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_ast_build_get_ctx(build_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1copy
(JNIEnv *env, jclass class, jlong build)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_copy\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_copy for parameter build");
		goto error;
	}

	struct isl_ast_build* res = (struct isl_ast_build*) isl_ast_build_copy(build_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1free
(JNIEnv *env, jclass class, jlong build)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_free\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_free for parameter build");
		goto error;
	}

	 isl_ast_build_free(build_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1set_1options
(JNIEnv *env, jclass class, jlong control, jlong opts)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_set_options\n");fflush(stdout);
#endif
	struct isl_ast_build* control_c = (struct isl_ast_build*) GECOS_PTRSIZE control; 
	if(((void*)control_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_set_options for parameter control");
		goto error;
	}
	isl_union_map* opts_c = (isl_union_map*) GECOS_PTRSIZE opts; 
	if(((void*)opts_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_set_options for parameter opts");
		goto error;
	}

	struct isl_ast_build* res = (struct isl_ast_build*) isl_ast_build_set_options(control_c, opts_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_set_options\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1get_1schedule
(JNIEnv *env, jclass class, jlong build)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_get_schedule\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_get_schedule for parameter build");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_ast_build_get_schedule(build_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_get_schedule\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1get_1schedule_1space
(JNIEnv *env, jclass class, jlong build)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_get_schedule_space\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_get_schedule_space for parameter build");
		goto error;
	}

	isl_space* res = (isl_space*) isl_ast_build_get_schedule_space(build_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_get_schedule_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1restrict
(JNIEnv *env, jclass class, jlong build, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_restrict\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_restrict for parameter build");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_restrict for parameter set");
		goto error;
	}

	struct isl_ast_build* res = (struct isl_ast_build*) isl_ast_build_restrict(build_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_restrict\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1set_1iterators
(JNIEnv *env, jclass class, jlong control, jlong iterators)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_set_iterators\n");fflush(stdout);
#endif
	struct isl_ast_build* control_c = (struct isl_ast_build*) GECOS_PTRSIZE control; 
	if(((void*)control_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_set_iterators for parameter control");
		goto error;
	}
	isl_id_list* iterators_c = (isl_id_list*) GECOS_PTRSIZE iterators; 
	if(((void*)iterators_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_set_iterators for parameter iterators");
		goto error;
	}

	struct isl_ast_build* res = (struct isl_ast_build*) isl_ast_build_set_iterators(control_c, iterators_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_set_iterators\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1options_1set_1ast_1build_1exploit_1nested_1bounds
(JNIEnv *env, jclass class, jlong ctx, jint val)
 {
#ifdef TRACE_ALL
	printf("Entering isl_options_set_ast_build_exploit_nested_bounds\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_options_set_ast_build_exploit_nested_bounds for parameter ctx");
		goto error;
	}
	int val_c = (int) val;

	int res = (int) isl_options_set_ast_build_exploit_nested_bounds(ctx_c, val_c);


#ifdef TRACE_ALL
	printf("Leaving isl_options_set_ast_build_exploit_nested_bounds\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1options_1get_1ast_1build_1exploit_1nested_1bounds
(JNIEnv *env, jclass class, jlong ctx)
 {
#ifdef TRACE_ALL
	printf("Entering isl_options_get_ast_build_exploit_nested_bounds\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_options_get_ast_build_exploit_nested_bounds for parameter ctx");
		goto error;
	}

	int res = (int) isl_options_get_ast_build_exploit_nested_bounds(ctx_c);


#ifdef TRACE_ALL
	printf("Leaving isl_options_get_ast_build_exploit_nested_bounds\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1options_1set_1ast_1build_1atomic_1upper_1bound
(JNIEnv *env, jclass class, jlong ctx, jint val)
 {
#ifdef TRACE_ALL
	printf("Entering isl_options_set_ast_build_atomic_upper_bound\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_options_set_ast_build_atomic_upper_bound for parameter ctx");
		goto error;
	}
	int val_c = (int) val;

	int res = (int) isl_options_set_ast_build_atomic_upper_bound(ctx_c, val_c);


#ifdef TRACE_ALL
	printf("Leaving isl_options_set_ast_build_atomic_upper_bound\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1options_1get_1ast_1build_1atomic_1upper_1bound
(JNIEnv *env, jclass class, jlong ctx)
 {
#ifdef TRACE_ALL
	printf("Entering isl_options_get_ast_build_atomic_upper_bound\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_options_get_ast_build_atomic_upper_bound for parameter ctx");
		goto error;
	}

	int res = (int) isl_options_get_ast_build_atomic_upper_bound(ctx_c);


#ifdef TRACE_ALL
	printf("Leaving isl_options_get_ast_build_atomic_upper_bound\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1options_1set_1ast_1build_1separation_1bounds
(JNIEnv *env, jclass class, jlong ctx, jint val)
 {
#ifdef TRACE_ALL
	printf("Entering isl_options_set_ast_build_separation_bounds\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_options_set_ast_build_separation_bounds for parameter ctx");
		goto error;
	}
	int val_c = (int) val;

	int res = (int) isl_options_set_ast_build_separation_bounds(ctx_c, val_c);


#ifdef TRACE_ALL
	printf("Leaving isl_options_set_ast_build_separation_bounds\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1options_1get_1ast_1build_1separation_1bounds
(JNIEnv *env, jclass class, jlong ctx)
 {
#ifdef TRACE_ALL
	printf("Entering isl_options_get_ast_build_separation_bounds\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_options_get_ast_build_separation_bounds for parameter ctx");
		goto error;
	}

	int res = (int) isl_options_get_ast_build_separation_bounds(ctx_c);


#ifdef TRACE_ALL
	printf("Leaving isl_options_get_ast_build_separation_bounds\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1node_1from_1schedule_1map
(JNIEnv *env, jclass class, jlong build, jlong schedule)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_node_from_schedule_map\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_node_from_schedule_map for parameter build");
		goto error;
	}
	isl_union_map* schedule_c = (isl_union_map*) GECOS_PTRSIZE schedule; 
	if(((void*)schedule_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_node_from_schedule_map for parameter schedule");
		goto error;
	}

	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_build_node_from_schedule_map(build_c, schedule_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_node_from_schedule_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1node_1from_1schedule
(JNIEnv *env, jclass class, jlong build, jlong schedule)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_node_from_schedule\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_node_from_schedule for parameter build");
		goto error;
	}
	isl_schedule* schedule_c = (isl_schedule*) GECOS_PTRSIZE schedule; 
	if(((void*)schedule_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_node_from_schedule for parameter schedule");
		goto error;
	}

	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_build_node_from_schedule(build_c, schedule_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_node_from_schedule\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1node_1from_1schedule_1map_1EX
(JNIEnv *env, jclass class, jlong build, jlong schedule, jstring exName)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_node_from_schedule_map_EX\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_node_from_schedule_map_EX for parameter build");
		goto error;
	}
	isl_union_map* schedule_c = (isl_union_map*) GECOS_PTRSIZE schedule; 
	if(((void*)schedule_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_node_from_schedule_map_EX for parameter schedule");
		goto error;
	}
	char* exName_c;
	exName_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, exName, NULL);
	if (exName_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_ast_build_node_from_schedule_map_EX for parameter exName");
		goto error;
	}

	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_build_node_from_schedule_map_EX(build_c, schedule_c, exName_c);

	(*env)->ReleaseStringUTFChars(env, exName, exName_c);

#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_node_from_schedule_map_EX\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1ast_1build_1node_1from_1schedule_1EX
(JNIEnv *env, jclass class, jlong build, jlong schedule, jstring exName)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ast_build_node_from_schedule_EX\n");fflush(stdout);
#endif
	struct isl_ast_build* build_c = (struct isl_ast_build*) GECOS_PTRSIZE build; 
	if(((void*)build_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_node_from_schedule_EX for parameter build");
		goto error;
	}
	isl_schedule* schedule_c = (isl_schedule*) GECOS_PTRSIZE schedule; 
	if(((void*)schedule_c)==NULL) {
		throwException(env, "Null pointer in isl_ast_build_node_from_schedule_EX for parameter schedule");
		goto error;
	}
	char* exName_c;
	exName_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, exName, NULL);
	if (exName_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_ast_build_node_from_schedule_EX for parameter exName");
		goto error;
	}

	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_build_node_from_schedule_EX(build_c, schedule_c, exName_c);

	(*env)->ReleaseStringUTFChars(env, exName, exName_c);

#ifdef TRACE_ALL
	printf("Leaving isl_ast_build_node_from_schedule_EX\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


