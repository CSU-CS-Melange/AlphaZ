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
#include <isl/band.h>
#include <isl/constraint.h>
#include <isl/ctx.h>
#include <isl/flow.h>
#include <isl/hash.h>
#include <isl/id.h>
#include <isl/id_to_ast_expr.h>
#include <isl/id_to_id.h>
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
#include <isl/printer_type.h>
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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1get_1ctx
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_get_ctx\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_get_ctx for parameter band");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_band_get_ctx(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1copy
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_copy\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_copy for parameter band");
		goto error;
	}

	isl_band* res = (isl_band*) isl_band_copy(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1free
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_free\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_free for parameter band");
		goto error;
	}

	 isl_band_free(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1has_1children
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_has_children\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_has_children for parameter band");
		goto error;
	}

	int res = (int) isl_band_has_children(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_has_children\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1get_1children
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_get_children\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_get_children for parameter band");
		goto error;
	}

	isl_band_list* res = (isl_band_list*) isl_band_get_children(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_get_children\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1get_1prefix_1schedule
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_get_prefix_schedule\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_get_prefix_schedule for parameter band");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_band_get_prefix_schedule(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_get_prefix_schedule\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1get_1partial_1schedule
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_get_partial_schedule\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_get_partial_schedule for parameter band");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_band_get_partial_schedule(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_get_partial_schedule\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1get_1suffix_1schedule
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_get_suffix_schedule\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_get_suffix_schedule for parameter band");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_band_get_suffix_schedule(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_get_suffix_schedule\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1n_1member
(JNIEnv *env, jclass class, jlong band)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_n_member\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_n_member for parameter band");
		goto error;
	}

	int res = (int) isl_band_n_member(band_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_n_member\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1member_1is_1coincident
(JNIEnv *env, jclass class, jlong band, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_member_is_coincident\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_member_is_coincident for parameter band");
		goto error;
	}
	int pos_c = (int) pos;

	int res = (int) isl_band_member_is_coincident(band_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_member_is_coincident\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1tile
(JNIEnv *env, jclass class, jlong band, jlong sizes)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_tile\n");fflush(stdout);
#endif
	isl_band* band_c = (isl_band*) GECOS_PTRSIZE band; 
	if(((void*)band_c)==NULL) {
		throwException(env, "Null pointer in isl_band_tile for parameter band");
		goto error;
	}
	isl_vec* sizes_c = (isl_vec*) GECOS_PTRSIZE sizes; 
	if(((void*)sizes_c)==NULL) {
		throwException(env, "Null pointer in isl_band_tile for parameter sizes");
		goto error;
	}

	int res = (int) isl_band_tile(band_c, sizes_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_tile\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1band_1to_1string
(JNIEnv *env, jclass class, jlong b, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_band_to_string\n");fflush(stdout);
#endif
	isl_band* b_c = (isl_band*) GECOS_PTRSIZE b; 
	if(((void*)b_c)==NULL) {
		throwException(env, "Null pointer in isl_band_to_string for parameter b");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_band_to_string(b_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_band_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


