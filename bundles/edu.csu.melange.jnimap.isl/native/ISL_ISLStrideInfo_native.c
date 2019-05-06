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
#include <isl/fixed_box.h>
#include <isl/stride_info.h>

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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1stride_1info_1get_1ctx
(JNIEnv *env, jclass class, jlong si)
 {
#ifdef TRACE_ALL
	printf("Entering isl_stride_info_get_ctx\n");fflush(stdout);
#endif
	isl_stride_info* si_c = (isl_stride_info*) GECOS_PTRSIZE si; 
	if(((void*)si_c)==NULL) {
		throwException(env, "Null pointer in isl_stride_info_get_ctx for parameter si");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_stride_info_get_ctx(si_c);


#ifdef TRACE_ALL
	printf("Leaving isl_stride_info_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1stride_1info_1get_1stride
(JNIEnv *env, jclass class, jlong si)
 {
#ifdef TRACE_ALL
	printf("Entering isl_stride_info_get_stride\n");fflush(stdout);
#endif
	isl_stride_info* si_c = (isl_stride_info*) GECOS_PTRSIZE si; 
	if(((void*)si_c)==NULL) {
		throwException(env, "Null pointer in isl_stride_info_get_stride for parameter si");
		goto error;
	}

	isl_val* res = (isl_val*) isl_stride_info_get_stride(si_c);


#ifdef TRACE_ALL
	printf("Leaving isl_stride_info_get_stride\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1stride_1info_1get_1offset
(JNIEnv *env, jclass class, jlong si)
 {
#ifdef TRACE_ALL
	printf("Entering isl_stride_info_get_offset\n");fflush(stdout);
#endif
	isl_stride_info* si_c = (isl_stride_info*) GECOS_PTRSIZE si; 
	if(((void*)si_c)==NULL) {
		throwException(env, "Null pointer in isl_stride_info_get_offset for parameter si");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_stride_info_get_offset(si_c);


#ifdef TRACE_ALL
	printf("Leaving isl_stride_info_get_offset\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1stride_1info_1copy
(JNIEnv *env, jclass class, jlong si)
 {
#ifdef TRACE_ALL
	printf("Entering isl_stride_info_copy\n");fflush(stdout);
#endif
	isl_stride_info* si_c = (isl_stride_info*) GECOS_PTRSIZE si; 
	if(((void*)si_c)==NULL) {
		throwException(env, "Null pointer in isl_stride_info_copy for parameter si");
		goto error;
	}

	isl_stride_info* res = (isl_stride_info*) isl_stride_info_copy(si_c);


#ifdef TRACE_ALL
	printf("Leaving isl_stride_info_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1stride_1info_1free
(JNIEnv *env, jclass class, jlong si)
 {
#ifdef TRACE_ALL
	printf("Entering isl_stride_info_free\n");fflush(stdout);
#endif
	isl_stride_info* si_c = (isl_stride_info*) GECOS_PTRSIZE si; 
	if(((void*)si_c)==NULL) {
		throwException(env, "Null pointer in isl_stride_info_free for parameter si");
		goto error;
	}

	 isl_stride_info_free(si_c);


#ifdef TRACE_ALL
	printf("Leaving isl_stride_info_free\n");fflush(stdout);
#endif
	
error:
	return;
}


