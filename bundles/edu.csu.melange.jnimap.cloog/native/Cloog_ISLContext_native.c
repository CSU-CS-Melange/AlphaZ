#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <cloog/cloog.h>

#include "CloogUser_addons.h"

#include "fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h"

extern void throwException(JNIEnv * env, char* msg);
extern jobject createInteger(JNIEnv * env, int value);
extern jint getIntegerValue(JNIEnv * env, jobject obj);


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_isl_1ctx_1alloc
(JNIEnv *env, jclass class)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ctx_alloc\n");fflush(stdout);
#endif


	struct isl_ctx* res = (struct isl_ctx*) isl_ctx_alloc();


#ifdef TRACE_ALL
	printf("Leaving isl_ctx_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_isl_1ctx_1free
(JNIEnv *env, jclass class, jlong ctx)
 {
#ifdef TRACE_ALL
	printf("Entering isl_ctx_free\n");fflush(stdout);
#endif
	struct isl_ctx* ctx_c = (struct isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_ctx_free for parameter ctx");
		goto error;
	}


	 isl_ctx_free(ctx_c);


#ifdef TRACE_ALL
	printf("Leaving isl_ctx_free\n");fflush(stdout);
#endif
	
error:
	return;
}


