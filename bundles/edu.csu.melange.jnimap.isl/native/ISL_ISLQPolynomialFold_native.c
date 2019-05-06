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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1get_1ctx
(JNIEnv *env, jclass class, jlong fold)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_get_ctx\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE fold; 
	if(((void*)fold_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_get_ctx for parameter fold");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_qpolynomial_fold_get_ctx(fold_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1get_1space
(JNIEnv *env, jclass class, jlong fold)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_get_space\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE fold; 
	if(((void*)fold_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_get_space for parameter fold");
		goto error;
	}

	isl_space* res = (isl_space*) isl_qpolynomial_fold_get_space(fold_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1copy
(JNIEnv *env, jclass class, jlong fold)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_copy\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE fold; 
	if(((void*)fold_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_copy for parameter fold");
		goto error;
	}

	isl_qpolynomial_fold* res = (isl_qpolynomial_fold*) isl_qpolynomial_fold_copy(fold_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1free
(JNIEnv *env, jclass class, jlong fold)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_free\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE fold; 
	if(((void*)fold_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_free for parameter fold");
		goto error;
	}

	 isl_qpolynomial_fold_free(fold_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1get_1type
(JNIEnv *env, jclass class, jlong fold)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_get_type\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE fold; 
	if(((void*)fold_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_get_type for parameter fold");
		goto error;
	}

	enum isl_fold res = (enum isl_fold) isl_qpolynomial_fold_get_type(fold_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_get_type\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return -1000;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1empty
(JNIEnv *env, jclass class, jint type, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_empty\n");fflush(stdout);
#endif
	enum isl_fold type_c = (enum isl_fold) type;
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_empty for parameter dim");
		goto error;
	}

	isl_qpolynomial_fold* res = (isl_qpolynomial_fold*) isl_qpolynomial_fold_empty(type_c, dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1gist
(JNIEnv *env, jclass class, jlong fold, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_gist\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE fold; 
	if(((void*)fold_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_gist for parameter fold");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_gist for parameter context");
		goto error;
	}

	isl_qpolynomial_fold* res = (isl_qpolynomial_fold*) isl_qpolynomial_fold_gist(fold_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1number_1of_1qpolynomial
(JNIEnv *env, jclass class, jlong fold)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_number_of_qpolynomial\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE fold; 
	if(((void*)fold_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_number_of_qpolynomial for parameter fold");
		goto error;
	}

	int res = (int) isl_qpolynomial_fold_number_of_qpolynomial(fold_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_number_of_qpolynomial\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1get_1qpolynomial_1at
(JNIEnv *env, jclass class, jlong fold, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_get_qpolynomial_at\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE fold; 
	if(((void*)fold_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_get_qpolynomial_at for parameter fold");
		goto error;
	}
	int pos_c = (int) pos;

	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_fold_get_qpolynomial_at(fold_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_get_qpolynomial_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1qpolynomial_1fold_1to_1string
(JNIEnv *env, jclass class, jlong qpf, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_fold_to_string\n");fflush(stdout);
#endif
	isl_qpolynomial_fold* qpf_c = (isl_qpolynomial_fold*) GECOS_PTRSIZE qpf; 
	if(((void*)qpf_c)==NULL) {
		throwException(env, "Null pointer in isl_qpolynomial_fold_to_string for parameter qpf");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_qpolynomial_fold_to_string(qpf_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_fold_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


