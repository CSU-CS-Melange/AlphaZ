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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1alloc
(JNIEnv *env, jclass class, jlong ctx, jint n_row, jint n_col)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_alloc\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_alloc for parameter ctx");
		goto error;
	}
	unsigned int n_row_c = (unsigned int) n_row;
	unsigned int n_col_c = (unsigned int) n_col;

	isl_mat* res = (isl_mat*) isl_mat_alloc(ctx_c, n_row_c, n_col_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1get_1ctx
(JNIEnv *env, jclass class, jlong mat)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_get_ctx\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_get_ctx for parameter mat");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_mat_get_ctx(mat_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1copy
(JNIEnv *env, jclass class, jlong mat)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_copy\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_copy for parameter mat");
		goto error;
	}

	isl_mat* res = (isl_mat*) isl_mat_copy(mat_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1free
(JNIEnv *env, jclass class, jlong mat)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_free\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_free for parameter mat");
		goto error;
	}

	 isl_mat_free(mat_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1rows
(JNIEnv *env, jclass class, jlong mat)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_rows\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_rows for parameter mat");
		goto error;
	}

	int res = (int) isl_mat_rows(mat_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_rows\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1cols
(JNIEnv *env, jclass class, jlong mat)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_cols\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_cols for parameter mat");
		goto error;
	}

	int res = (int) isl_mat_cols(mat_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_cols\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1get_1element_1val
(JNIEnv *env, jclass class, jlong mat, jint row, jint col)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_get_element_val\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_get_element_val for parameter mat");
		goto error;
	}
	int row_c = (int) row;
	int col_c = (int) col;

	isl_val* res = (isl_val*) isl_mat_get_element_val(mat_c, row_c, col_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_get_element_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1set_1element_1si
(JNIEnv *env, jclass class, jlong mat, jint row, jint col, jint v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_set_element_si\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_set_element_si for parameter mat");
		goto error;
	}
	int row_c = (int) row;
	int col_c = (int) col;
	int v_c = (int) v;

	isl_mat* res = (isl_mat*) isl_mat_set_element_si(mat_c, row_c, col_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_set_element_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1set_1element_1val
(JNIEnv *env, jclass class, jlong mat, jint row, jint col, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_set_element_val\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_set_element_val for parameter mat");
		goto error;
	}
	int row_c = (int) row;
	int col_c = (int) col;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_set_element_val for parameter v");
		goto error;
	}

	isl_mat* res = (isl_mat*) isl_mat_set_element_val(mat_c, row_c, col_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_set_element_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1right_1inverse
(JNIEnv *env, jclass class, jlong mat)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_right_inverse\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_right_inverse for parameter mat");
		goto error;
	}

	isl_mat* res = (isl_mat*) isl_mat_right_inverse(mat_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_right_inverse\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1mat_1right_1kernel
(JNIEnv *env, jclass class, jlong mat)
 {
#ifdef TRACE_ALL
	printf("Entering isl_mat_right_kernel\n");fflush(stdout);
#endif
	isl_mat* mat_c = (isl_mat*) GECOS_PTRSIZE mat; 
	if(((void*)mat_c)==NULL) {
		throwException(env, "Null pointer in isl_mat_right_kernel for parameter mat");
		goto error;
	}

	isl_mat* res = (isl_mat*) isl_mat_right_kernel(mat_c);


#ifdef TRACE_ALL
	printf("Leaving isl_mat_right_kernel\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


