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
#include "ISLUser_lexnext.h"
#include "ISLUser_lexpred.h"
#include "ISLUser_misc.h"
#include "ISLUser_polynomial.h"

#include "fr_irisa_cairn_jnimap_isl_jni_ISLNative.h"

extern void throwException(JNIEnv * env, char* msg);
extern jobject createInteger(JNIEnv * env, int value);
extern jint getIntegerValue(JNIEnv * env, jobject obj);


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1from_1multi_1pw_1aff
(JNIEnv *env, jclass class, jlong mpa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_from_multi_pw_aff\n");fflush(stdout);
#endif
	isl_multi_pw_aff* mpa_c = (isl_multi_pw_aff*) GECOS_PTRSIZE mpa; 
	if(((void*)mpa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_from_multi_pw_aff for parameter mpa");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_from_multi_pw_aff(mpa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_from_multi_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


