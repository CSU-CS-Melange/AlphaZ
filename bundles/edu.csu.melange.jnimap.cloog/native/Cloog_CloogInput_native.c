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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloog_1input_1read_1from_1isl_1union_1map_1str
(JNIEnv *env, jclass class, jlong ctx, jlong state, jstring context, jstring union_domain)
 {
#ifdef TRACE_ALL
	printf("Entering cloog_input_read_from_isl_union_map_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in cloog_input_read_from_isl_union_map_str for parameter ctx");
		goto error;
	}
	struct cloogstate* state_c = (struct cloogstate*) GECOS_PTRSIZE state; 
	if(((void*)state_c)==NULL) {
		throwException(env, "Null pointer in cloog_input_read_from_isl_union_map_str for parameter state");
		goto error;
	}
	char* context_c;
	context_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, context, NULL);
	if (context_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in cloog_input_read_from_isl_union_map_str for parameter context");
		goto error;
	}
	char* union_domain_c;
	union_domain_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, union_domain, NULL);
	if (union_domain_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in cloog_input_read_from_isl_union_map_str for parameter union_domain");
		goto error;
	}

	struct clooginput* res = (struct clooginput*) cloog_input_read_from_isl_union_map_str(ctx_c, state_c, context_c, union_domain_c);

	(*env)->ReleaseStringUTFChars(env, context, context_c);
	(*env)->ReleaseStringUTFChars(env, union_domain, union_domain_c);

#ifdef TRACE_ALL
	printf("Leaving cloog_input_read_from_isl_union_map_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloog_1input_1read_1from_1isl_1set_1str
(JNIEnv *env, jclass class, jlong ctx, jlong state, jstring context, jstring union_domain)
 {
#ifdef TRACE_ALL
	printf("Entering cloog_input_read_from_isl_set_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in cloog_input_read_from_isl_set_str for parameter ctx");
		goto error;
	}
	struct cloogstate* state_c = (struct cloogstate*) GECOS_PTRSIZE state; 
	if(((void*)state_c)==NULL) {
		throwException(env, "Null pointer in cloog_input_read_from_isl_set_str for parameter state");
		goto error;
	}
	char* context_c;
	context_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, context, NULL);
	if (context_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in cloog_input_read_from_isl_set_str for parameter context");
		goto error;
	}
	char* union_domain_c;
	union_domain_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, union_domain, NULL);
	if (union_domain_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in cloog_input_read_from_isl_set_str for parameter union_domain");
		goto error;
	}

	struct clooginput* res = (struct clooginput*) cloog_input_read_from_isl_set_str(ctx_c, state_c, context_c, union_domain_c);

	(*env)->ReleaseStringUTFChars(env, context, context_c);
	(*env)->ReleaseStringUTFChars(env, union_domain, union_domain_c);

#ifdef TRACE_ALL
	printf("Leaving cloog_input_read_from_isl_set_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloog_1clast_1create_1from_1input
(JNIEnv *env, jclass class, jlong input, jlong opts)
 {
#ifdef TRACE_ALL
	printf("Entering cloog_clast_create_from_input\n");fflush(stdout);
#endif
	struct clooginput* input_c = (struct clooginput*) GECOS_PTRSIZE input; 
	if(((void*)input_c)==NULL) {
		throwException(env, "Null pointer in cloog_clast_create_from_input for parameter input");
		goto error;
	}
	struct cloogoptions* opts_c = (struct cloogoptions*) GECOS_PTRSIZE opts; 
	if(((void*)opts_c)==NULL) {
		throwException(env, "Null pointer in cloog_clast_create_from_input for parameter opts");
		goto error;
	}

	struct clast_stmt* res = (struct clast_stmt*) cloog_clast_create_from_input(input_c, opts_c);


#ifdef TRACE_ALL
	printf("Leaving cloog_clast_create_from_input\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


