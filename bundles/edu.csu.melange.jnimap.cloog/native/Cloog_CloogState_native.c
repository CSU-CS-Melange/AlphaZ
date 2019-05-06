#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <cloog/cloog.h>
#include <isl/ctx.h>

#include "CloogUser_addons.h"

#include "fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h"

extern void throwException(JNIEnv * env, char* msg);
extern jobject createInteger(JNIEnv * env, int value);
extern jint getIntegerValue(JNIEnv * env, jobject obj);


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloog_1state_1malloc
(JNIEnv *env, jclass class)
 {
#ifdef TRACE_ALL
	printf("Entering cloog_state_malloc\n");fflush(stdout);
#endif

	struct cloogstate* res = (struct cloogstate*) cloog_state_malloc();


#ifdef TRACE_ALL
	printf("Leaving cloog_state_malloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


