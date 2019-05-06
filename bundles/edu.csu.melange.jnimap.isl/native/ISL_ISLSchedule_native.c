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


JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1schedule_1free
(JNIEnv *env, jclass class, jlong sched)
 {
#ifdef TRACE_ALL
	printf("Entering isl_schedule_free\n");fflush(stdout);
#endif
	isl_schedule* sched_c = (isl_schedule*) GECOS_PTRSIZE sched; 
	if(((void*)sched_c)==NULL) {
		throwException(env, "Null pointer in isl_schedule_free for parameter sched");
		goto error;
	}

	 isl_schedule_free(sched_c);


#ifdef TRACE_ALL
	printf("Leaving isl_schedule_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1schedule_1get_1map
(JNIEnv *env, jclass class, jlong sched)
 {
#ifdef TRACE_ALL
	printf("Entering isl_schedule_get_map\n");fflush(stdout);
#endif
	isl_schedule* sched_c = (isl_schedule*) GECOS_PTRSIZE sched; 
	if(((void*)sched_c)==NULL) {
		throwException(env, "Null pointer in isl_schedule_get_map for parameter sched");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_schedule_get_map(sched_c);


#ifdef TRACE_ALL
	printf("Leaving isl_schedule_get_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1compute_1schedule
(JNIEnv *env, jclass class, jlong ctx, jlong domain, jlong validity, jlong proximity, jint max_coefficient, jint max_constant_term, jint fuse, jint maximize_band_depth, jint outer_coincidence, jint split_scaled, jint algorithm, jint separate_components)
 {
#ifdef TRACE_ALL
	printf("Entering isl_compute_schedule\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_compute_schedule for parameter ctx");
		goto error;
	}
	isl_union_set* domain_c = (isl_union_set*) GECOS_PTRSIZE domain; 
	if(((void*)domain_c)==NULL) {
		throwException(env, "Null pointer in isl_compute_schedule for parameter domain");
		goto error;
	}
	isl_union_map* validity_c = (isl_union_map*) GECOS_PTRSIZE validity; 
	if(((void*)validity_c)==NULL) {
		throwException(env, "Null pointer in isl_compute_schedule for parameter validity");
		goto error;
	}
	isl_union_map* proximity_c = (isl_union_map*) GECOS_PTRSIZE proximity; 
	if(((void*)proximity_c)==NULL) {
		throwException(env, "Null pointer in isl_compute_schedule for parameter proximity");
		goto error;
	}
	int max_coefficient_c = (int) max_coefficient;
	int max_constant_term_c = (int) max_constant_term;
	int fuse_c = (int) fuse;
	int maximize_band_depth_c = (int) maximize_band_depth;
	int outer_coincidence_c = (int) outer_coincidence;
	int split_scaled_c = (int) split_scaled;
	int algorithm_c = (int) algorithm;
	int separate_components_c = (int) separate_components;

	isl_schedule* res = (isl_schedule*) isl_compute_schedule(ctx_c, domain_c, validity_c, proximity_c, max_coefficient_c, max_constant_term_c, fuse_c, maximize_band_depth_c, outer_coincidence_c, split_scaled_c, algorithm_c, separate_components_c);


#ifdef TRACE_ALL
	printf("Leaving isl_compute_schedule\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1schedule_1to_1string
(JNIEnv *env, jclass class, jlong s, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_schedule_to_string\n");fflush(stdout);
#endif
	isl_schedule* s_c = (isl_schedule*) GECOS_PTRSIZE s; 
	if(((void*)s_c)==NULL) {
		throwException(env, "Null pointer in isl_schedule_to_string for parameter s");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_schedule_to_string(s_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_schedule_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


