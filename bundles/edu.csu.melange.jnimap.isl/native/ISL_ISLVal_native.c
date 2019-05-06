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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1zero
(JNIEnv *env, jclass class, jlong ctx)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_zero\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_val_zero for parameter ctx");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_zero(ctx_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_zero\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1int_1from_1si
(JNIEnv *env, jclass class, jlong ctx, jlong i)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_int_from_si\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_val_int_from_si for parameter ctx");
		goto error;
	}
	long i_c = (long) i;

	isl_val* res = (isl_val*) isl_val_int_from_si(ctx_c, i_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_int_from_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_val_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_val_read_from_str for parameter str");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_read_from_str(ctx_c, str_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1get_1ctx
(JNIEnv *env, jclass class, jlong val)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_get_ctx\n");fflush(stdout);
#endif
	isl_val* val_c = (isl_val*) GECOS_PTRSIZE val; 
	if(((void*)val_c)==NULL) {
		throwException(env, "Null pointer in isl_val_get_ctx for parameter val");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_val_get_ctx(val_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1copy
(JNIEnv *env, jclass class, jlong i)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_copy\n");fflush(stdout);
#endif
	isl_val* i_c = (isl_val*) GECOS_PTRSIZE i; 
	if(((void*)i_c)==NULL) {
		throwException(env, "Null pointer in isl_val_copy for parameter i");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_copy(i_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1free
(JNIEnv *env, jclass class, jlong i)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_free\n");fflush(stdout);
#endif
	isl_val* i_c = (isl_val*) GECOS_PTRSIZE i; 
	if(((void*)i_c)==NULL) {
		throwException(env, "Null pointer in isl_val_free for parameter i");
		goto error;
	}

	 isl_val_free(i_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1set_1si
(JNIEnv *env, jclass class, jlong v, jlong i)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_set_si\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_set_si for parameter v");
		goto error;
	}
	long i_c = (long) i;

	isl_val* res = (isl_val*) isl_val_set_si(v_c, i_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_set_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1get_1num_1si
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_get_num_si\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_get_num_si for parameter v");
		goto error;
	}

	long res = (long) isl_val_get_num_si(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_get_num_si\n");fflush(stdout);
#endif
	

	return (jlong)  res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1get_1den_1si
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_get_den_si\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_get_den_si for parameter v");
		goto error;
	}

	long res = (long) isl_val_get_den_si(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_get_den_si\n");fflush(stdout);
#endif
	

	return (jlong)  res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jdouble JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1get_1d
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_get_d\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_get_d for parameter v");
		goto error;
	}

	double res = (double) isl_val_get_d(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_get_d\n");fflush(stdout);
#endif
	

	return (jdouble)  res;
error:
	return  (jdouble) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1sgn
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_sgn\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_sgn for parameter v");
		goto error;
	}

	int res = (int) isl_val_sgn(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_sgn\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1zero
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_zero\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_zero for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_zero(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_zero\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1one
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_one\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_one for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_one(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_one\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1negone
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_negone\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_negone for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_negone(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_negone\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1nonneg
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_nonneg\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_nonneg for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_nonneg(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_nonneg\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1nonpos
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_nonpos\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_nonpos for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_nonpos(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_nonpos\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1pos
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_pos\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_pos for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_pos(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_pos\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1neg
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_neg\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_neg for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_neg(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_neg\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1int
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_int\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_int for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_int(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_int\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1rat
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_rat\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_rat for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_rat(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_rat\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1nan
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_nan\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_nan for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_nan(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_nan\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1infty
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_infty\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_infty for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_infty(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_infty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1neginfty
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_neginfty\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_neginfty for parameter v");
		goto error;
	}

	int res = (int) isl_val_is_neginfty(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_neginfty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1lt
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_lt\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_lt for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_lt for parameter v2");
		goto error;
	}

	int res = (int) isl_val_lt(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_lt\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1le
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_le\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_le for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_le for parameter v2");
		goto error;
	}

	int res = (int) isl_val_le(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_le\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1gt
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_gt\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_gt for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_gt for parameter v2");
		goto error;
	}

	int res = (int) isl_val_gt(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_gt\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1ge
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_ge\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_ge for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_ge for parameter v2");
		goto error;
	}

	int res = (int) isl_val_ge(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_ge\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1eq
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_eq\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_eq for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_eq for parameter v2");
		goto error;
	}

	int res = (int) isl_val_eq(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_eq\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1ne
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_ne\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_ne for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_ne for parameter v2");
		goto error;
	}

	int res = (int) isl_val_ne(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_ne\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1is_1divisible_1by
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_is_divisible_by\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_divisible_by for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_is_divisible_by for parameter v2");
		goto error;
	}

	int res = (int) isl_val_is_divisible_by(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_is_divisible_by\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1cmp_1si
(JNIEnv *env, jclass class, jlong v, jlong i)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_cmp_si\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_cmp_si for parameter v");
		goto error;
	}
	long i_c = (long) i;

	int res = (int) isl_val_cmp_si(v_c, i_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_cmp_si\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1abs
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_abs\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_abs for parameter v");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_abs(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_abs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1neg
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_neg\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_neg for parameter v");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_neg(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_neg\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1floor
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_floor\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_floor for parameter v");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_floor(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_floor\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1ceil
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_ceil\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_ceil for parameter v");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_ceil(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_ceil\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1trunc
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_trunc\n");fflush(stdout);
#endif
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_val_trunc for parameter v");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_trunc(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_trunc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1min
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_min\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_min for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_min for parameter v2");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_min(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_min\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1max
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_max\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_max for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_max for parameter v2");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_max(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_max\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1add
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_add\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_add for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_add for parameter v2");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_add(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1sub
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_sub\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_sub for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_sub for parameter v2");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_sub(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1mul
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_mul\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_mul for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_mul for parameter v2");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_mul(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_mul\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1div
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_div\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_div for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_div for parameter v2");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_div(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_div\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1mod
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_mod\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_mod for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_mod for parameter v2");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_mod(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_mod\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1gcd
(JNIEnv *env, jclass class, jlong v1, jlong v2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_gcd\n");fflush(stdout);
#endif
	isl_val* v1_c = (isl_val*) GECOS_PTRSIZE v1; 
	if(((void*)v1_c)==NULL) {
		throwException(env, "Null pointer in isl_val_gcd for parameter v1");
		goto error;
	}
	isl_val* v2_c = (isl_val*) GECOS_PTRSIZE v2; 
	if(((void*)v2_c)==NULL) {
		throwException(env, "Null pointer in isl_val_gcd for parameter v2");
		goto error;
	}

	isl_val* res = (isl_val*) isl_val_gcd(v1_c, v2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_gcd\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1val_1to_1string
(JNIEnv *env, jclass class, jlong val, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_val_to_string\n");fflush(stdout);
#endif
	isl_val* val_c = (isl_val*) GECOS_PTRSIZE val; 
	if(((void*)val_c)==NULL) {
		throwException(env, "Null pointer in isl_val_to_string for parameter val");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_val_to_string(val_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_val_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


