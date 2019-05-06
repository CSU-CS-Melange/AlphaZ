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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1aff_1from_1aff_1list
(JNIEnv *env, jclass class, jlong space, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_aff_from_aff_list\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_from_aff_list for parameter space");
		goto error;
	}
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_aff_from_aff_list for parameter list");
		goto error;
	}

	isl_multi_aff* res = (isl_multi_aff*) isl_multi_aff_from_aff_list(space_c, list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_aff_from_aff_list\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1alloc
(JNIEnv *env, jclass class, jlong ctx, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_alloc\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_alloc for parameter ctx");
		goto error;
	}
	int n_c = (int) n;

	isl_aff_list* res = (isl_aff_list*) isl_aff_list_alloc(ctx_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1get_1ctx
(JNIEnv *env, jclass class, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_get_ctx\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_get_ctx for parameter list");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_aff_list_get_ctx(list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1copy
(JNIEnv *env, jclass class, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_copy\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_copy for parameter list");
		goto error;
	}

	isl_aff_list* res = (isl_aff_list*) isl_aff_list_copy(list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1free
(JNIEnv *env, jclass class, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_free\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_free for parameter list");
		goto error;
	}

	 isl_aff_list_free(list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1n_1aff
(JNIEnv *env, jclass class, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_n_aff\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_n_aff for parameter list");
		goto error;
	}

	int res = (int) isl_aff_list_n_aff(list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_n_aff\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1get_1aff
(JNIEnv *env, jclass class, jlong list, jint index)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_get_aff\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_get_aff for parameter list");
		goto error;
	}
	int index_c = (int) index;

	isl_aff* res = (isl_aff*) isl_aff_list_get_aff(list_c, index_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_get_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1set_1aff
(JNIEnv *env, jclass class, jlong list, jint index, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_set_aff\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_set_aff for parameter list");
		goto error;
	}
	int index_c = (int) index;
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_set_aff for parameter aff");
		goto error;
	}

	isl_aff_list* res = (isl_aff_list*) isl_aff_list_set_aff(list_c, index_c, aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_set_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1insert
(JNIEnv *env, jclass class, jlong list, jint pos, jlong el)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_insert\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_insert for parameter list");
		goto error;
	}
	unsigned int pos_c = (unsigned int) pos;
	isl_aff* el_c = (isl_aff*) GECOS_PTRSIZE el; 
	if(((void*)el_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_insert for parameter el");
		goto error;
	}

	isl_aff_list* res = (isl_aff_list*) isl_aff_list_insert(list_c, pos_c, el_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_insert\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1add
(JNIEnv *env, jclass class, jlong list, jlong el)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_add\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_add for parameter list");
		goto error;
	}
	isl_aff* el_c = (isl_aff*) GECOS_PTRSIZE el; 
	if(((void*)el_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_add for parameter el");
		goto error;
	}

	isl_aff_list* res = (isl_aff_list*) isl_aff_list_add(list_c, el_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1drop
(JNIEnv *env, jclass class, jlong list, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_drop\n");fflush(stdout);
#endif
	isl_aff_list* list_c = (isl_aff_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_drop for parameter list");
		goto error;
	}
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_aff_list* res = (isl_aff_list*) isl_aff_list_drop(list_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_drop\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1concat
(JNIEnv *env, jclass class, jlong list1, jlong list2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_concat\n");fflush(stdout);
#endif
	isl_aff_list* list1_c = (isl_aff_list*) GECOS_PTRSIZE list1; 
	if(((void*)list1_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_concat for parameter list1");
		goto error;
	}
	isl_aff_list* list2_c = (isl_aff_list*) GECOS_PTRSIZE list2; 
	if(((void*)list2_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_concat for parameter list2");
		goto error;
	}

	isl_aff_list* res = (isl_aff_list*) isl_aff_list_concat(list1_c, list2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_concat\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1aff_1list_1to_1string
(JNIEnv *env, jclass class, jlong afflist, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_aff_list_to_string\n");fflush(stdout);
#endif
	isl_aff_list* afflist_c = (isl_aff_list*) GECOS_PTRSIZE afflist; 
	if(((void*)afflist_c)==NULL) {
		throwException(env, "Null pointer in isl_aff_list_to_string for parameter afflist");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_aff_list_to_string(afflist_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_aff_list_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


