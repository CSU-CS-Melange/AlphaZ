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

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1root_1get_1names
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_root_names_getter) DISABLED START */
	struct clast_root* stPtr = (struct clast_root *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNames");
	return (jlong) GECOS_PTRSIZE stPtr->names;
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_root_1set_1names
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(clast_root_names_setter) DISABLED START */
	struct clast_root* stPtr = (struct clast_root *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setNames");
	stPtr->names= (struct cloognames*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_clast_1root_1test_1names
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(clast_root_names_tester) DISABLED START */
	struct clast_root* stPtr = (struct clast_root *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getNames");
	return (GECOS_PTRSIZE stPtr->names) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloog_1clast_1from_1union_1map
(JNIEnv *env, jclass class, jlong state, jlong opts, jstring context, jstring union_map_str)
 {
#ifdef TRACE_ALL
	printf("Entering cloog_clast_from_union_map\n");fflush(stdout);
#endif
	struct cloogstate* state_c = (struct cloogstate*) GECOS_PTRSIZE state; 
	if(((void*)state_c)==NULL) {
		throwException(env, "Null pointer in cloog_clast_from_union_map for parameter state");
		goto error;
	}
	struct cloogoptions* opts_c = (struct cloogoptions*) GECOS_PTRSIZE opts; 
	if(((void*)opts_c)==NULL) {
		throwException(env, "Null pointer in cloog_clast_from_union_map for parameter opts");
		goto error;
	}
	char* context_c;
	context_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, context, NULL);
	if (context_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in cloog_clast_from_union_map for parameter context");
		goto error;
	}
	char* union_map_str_c;
	union_map_str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, union_map_str, NULL);
	if (union_map_str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in cloog_clast_from_union_map for parameter union_map_str");
		goto error;
	}

	struct clast_stmt* res = (struct clast_stmt*) cloog_clast_from_union_map(state_c, opts_c, context_c, union_map_str_c);

	(*env)->ReleaseStringUTFChars(env, context, context_c);
	(*env)->ReleaseStringUTFChars(env, union_map_str, union_map_str_c);

#ifdef TRACE_ALL
	printf("Leaving cloog_clast_from_union_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_cloog_1clast_1from_1set
(JNIEnv *env, jclass class, jlong state, jlong opts, jstring context, jstring set_str)
 {
#ifdef TRACE_ALL
	printf("Entering cloog_clast_from_set\n");fflush(stdout);
#endif
	struct cloogstate* state_c = (struct cloogstate*) GECOS_PTRSIZE state; 
	if(((void*)state_c)==NULL) {
		throwException(env, "Null pointer in cloog_clast_from_set for parameter state");
		goto error;
	}
	struct cloogoptions* opts_c = (struct cloogoptions*) GECOS_PTRSIZE opts; 
	if(((void*)opts_c)==NULL) {
		throwException(env, "Null pointer in cloog_clast_from_set for parameter opts");
		goto error;
	}
	char* context_c;
	context_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, context, NULL);
	if (context_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in cloog_clast_from_set for parameter context");
		goto error;
	}
	char* set_str_c;
	set_str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, set_str, NULL);
	if (set_str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in cloog_clast_from_set for parameter set_str");
		goto error;
	}

	struct clast_stmt* res = (struct clast_stmt*) cloog_clast_from_set(state_c, opts_c, context_c, set_str_c);

	(*env)->ReleaseStringUTFChars(env, context, context_c);
	(*env)->ReleaseStringUTFChars(env, set_str, set_str_c);

#ifdef TRACE_ALL
	printf("Leaving cloog_clast_from_set\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_is_1clast_1root
(JNIEnv *env, jclass class, jlong stmt)
 {
#ifdef TRACE_ALL
	printf("Entering is_clast_root\n");fflush(stdout);
#endif
	struct clast_stmt* stmt_c = (struct clast_stmt*) GECOS_PTRSIZE stmt; 
	if(((void*)stmt_c)==NULL) {
		throwException(env, "Null pointer in is_clast_root for parameter stmt");
		goto error;
	}

	int res = (int) is_clast_root(stmt_c);


#ifdef TRACE_ALL
	printf("Leaving is_clast_root\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


