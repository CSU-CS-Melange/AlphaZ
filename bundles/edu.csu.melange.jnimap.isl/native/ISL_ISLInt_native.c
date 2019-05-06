#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <isl/int.h>
#include <isl/ctx.h>
#include <isl/ast.h>
#include <isl/ast_build.h>
#include <isl/id.h>
#include <isl/set.h>
#include <isl/map.h>
#include <isl/mat.h>
#include <isl/point.h>
#include <isl/vec.h>
#include <isl/space.h>
#include <isl/local_space.h>
#include <isl/constraint.h>
#include <isl/stream.h>
#include <isl/printer.h>
#include <isl/polynomial.h>
#include <isl/schedule.h>
#include <isl/band.h>
#include <isl/flow.h>
#include <isl/aff.h>
#include <isl/vertices.h>
#include <isl/options.h>

#include "ISLUser_isl_closed_form_relation.h"
#include "ISLUser_vertices.h"
#include "ISLUser_ast.h"
#include "ISLUser_collections.h"
#include "ISLUser_scheduling.h"
#include "ISLUser_dataflow.h"
#include "ISLUser_tostring.h"
#include "ISLUser_transitive_closure.h"
#include "ISLUser_lexnext.h"
#include "ISLUser_lexpred.h"
#include "ISLUser_misc.h"
#include "ISLUser_polynomial.h"

#include "fr_irisa_cairn_jnimap_isl_jni_ISLNative.h"

extern void throwException(JNIEnv * env, char* msg);
extern jobject createInteger(JNIEnv * env, int value);
extern jint getIntegerValue(JNIEnv * env, jobject obj);


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_init_1isl_1int
(JNIEnv *env, jclass class)
 {
#ifdef TRACE_ALL
	printf("Entering init_isl_int\n");fflush(stdout);
#endif

	isl_int* res = (isl_int*) init_isl_int();


#ifdef TRACE_ALL
	printf("Leaving init_isl_int\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_init_1set_1isl_1int
(JNIEnv *env, jclass class, jint v)
 {
#ifdef TRACE_ALL
	printf("Entering init_set_isl_int\n");fflush(stdout);
#endif
	int v_c = (int) v;

	isl_int* res = (isl_int*) init_set_isl_int(v_c);


#ifdef TRACE_ALL
	printf("Leaving init_set_isl_int\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_free_1isl_1int
(JNIEnv *env, jclass class, jlong i)
 {
#ifdef TRACE_ALL
	printf("Entering free_isl_int\n");fflush(stdout);
#endif
	isl_int* i_c = (isl_int*) GECOS_PTRSIZE i; 
	if(((void*)i_c)==NULL) {
		throwException(env, "Null pointer in free_isl_int for parameter i");
		goto error;
	}

	 free_isl_int(i_c);


#ifdef TRACE_ALL
	printf("Leaving free_isl_int\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1int_1to_1int
(JNIEnv *env, jclass class, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_int_to_int\n");fflush(stdout);
#endif
	isl_int* v_c = (isl_int*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_int_to_int for parameter v");
		goto error;
	}

	int res = (int) isl_int_to_int(v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_int_to_int\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_set_1isl_1int
(JNIEnv *env, jclass class, jlong i, jint v)
 {
#ifdef TRACE_ALL
	printf("Entering set_isl_int\n");fflush(stdout);
#endif
	isl_int* i_c = (isl_int*) GECOS_PTRSIZE i; 
	if(((void*)i_c)==NULL) {
		throwException(env, "Null pointer in set_isl_int for parameter i");
		goto error;
	}
	int v_c = (int) v;

	 set_isl_int(i_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving set_isl_int\n");fflush(stdout);
#endif
	
error:
	return;
}


