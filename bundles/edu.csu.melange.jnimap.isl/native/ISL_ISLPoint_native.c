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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1get_1ctx
(JNIEnv *env, jclass class, jlong pnt)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_get_ctx\n");fflush(stdout);
#endif
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_point_get_ctx for parameter pnt");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_point_get_ctx(pnt_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1get_1space
(JNIEnv *env, jclass class, jlong pnt)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_get_space\n");fflush(stdout);
#endif
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_point_get_space for parameter pnt");
		goto error;
	}

	isl_space* res = (isl_space*) isl_point_get_space(pnt_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1copy
(JNIEnv *env, jclass class, jlong pnt)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_copy\n");fflush(stdout);
#endif
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_point_copy for parameter pnt");
		goto error;
	}

	isl_point* res = (isl_point*) isl_point_copy(pnt_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1free
(JNIEnv *env, jclass class, jlong pnt)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_free\n");fflush(stdout);
#endif
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_point_free for parameter pnt");
		goto error;
	}

	 isl_point_free(pnt_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1zero
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_zero\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_point_zero for parameter dim");
		goto error;
	}

	isl_point* res = (isl_point*) isl_point_zero(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1get_1coordinate_1val
(JNIEnv *env, jclass class, jlong pnt, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_get_coordinate_val\n");fflush(stdout);
#endif
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_point_get_coordinate_val for parameter pnt");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;

	isl_val* res = (isl_val*) isl_point_get_coordinate_val(pnt_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_get_coordinate_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1set_1coordinate_1val
(JNIEnv *env, jclass class, jlong pnt, jint type, jint pos, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_set_coordinate_val\n");fflush(stdout);
#endif
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_point_set_coordinate_val for parameter pnt");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_point_set_coordinate_val for parameter v");
		goto error;
	}

	isl_point* res = (isl_point*) isl_point_set_coordinate_val(pnt_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_set_coordinate_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1add_1ui
(JNIEnv *env, jclass class, jlong pnt, jint type, jint pos, jint val)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_add_ui\n");fflush(stdout);
#endif
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_point_add_ui for parameter pnt");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;
	unsigned int val_c = (unsigned int) val;

	isl_point* res = (isl_point*) isl_point_add_ui(pnt_c, type_c, pos_c, val_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_add_ui\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1point_1sub_1ui
(JNIEnv *env, jclass class, jlong pnt, jint type, jint pos, jint val)
 {
#ifdef TRACE_ALL
	printf("Entering isl_point_sub_ui\n");fflush(stdout);
#endif
	isl_point* pnt_c = (isl_point*) GECOS_PTRSIZE pnt; 
	if(((void*)pnt_c)==NULL) {
		throwException(env, "Null pointer in isl_point_sub_ui for parameter pnt");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;
	unsigned int val_c = (unsigned int) val;

	isl_point* res = (isl_point*) isl_point_sub_ui(pnt_c, type_c, pos_c, val_c);


#ifdef TRACE_ALL
	printf("Leaving isl_point_sub_ui\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


