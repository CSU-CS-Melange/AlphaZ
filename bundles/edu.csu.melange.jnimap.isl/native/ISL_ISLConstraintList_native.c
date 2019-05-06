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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1alloc
(JNIEnv *env, jclass class, jlong ctx, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_alloc\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_alloc for parameter ctx");
		goto error;
	}
	int n_c = (int) n;

	isl_constraint_list* res = (isl_constraint_list*) isl_constraint_list_alloc(ctx_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1get_1ctx
(JNIEnv *env, jclass class, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_get_ctx\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_get_ctx for parameter list");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_constraint_list_get_ctx(list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1copy
(JNIEnv *env, jclass class, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_copy\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_copy for parameter list");
		goto error;
	}

	isl_constraint_list* res = (isl_constraint_list*) isl_constraint_list_copy(list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1free
(JNIEnv *env, jclass class, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_free\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_free for parameter list");
		goto error;
	}

	 isl_constraint_list_free(list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1n_1constraint
(JNIEnv *env, jclass class, jlong list)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_n_constraint\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_n_constraint for parameter list");
		goto error;
	}

	int res = (int) isl_constraint_list_n_constraint(list_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_n_constraint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1get_1constraint
(JNIEnv *env, jclass class, jlong list, jint index)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_get_constraint\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_get_constraint for parameter list");
		goto error;
	}
	int index_c = (int) index;

	isl_constraint* res = (isl_constraint*) isl_constraint_list_get_constraint(list_c, index_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_get_constraint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1set_1constraint
(JNIEnv *env, jclass class, jlong list, jint index, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_set_constraint\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_set_constraint for parameter list");
		goto error;
	}
	int index_c = (int) index;
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_set_constraint for parameter constraint");
		goto error;
	}

	isl_constraint_list* res = (isl_constraint_list*) isl_constraint_list_set_constraint(list_c, index_c, constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_set_constraint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1insert
(JNIEnv *env, jclass class, jlong list, jint pos, jlong el)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_insert\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_insert for parameter list");
		goto error;
	}
	unsigned int pos_c = (unsigned int) pos;
	isl_constraint* el_c = (isl_constraint*) GECOS_PTRSIZE el; 
	if(((void*)el_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_insert for parameter el");
		goto error;
	}

	isl_constraint_list* res = (isl_constraint_list*) isl_constraint_list_insert(list_c, pos_c, el_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_insert\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1add
(JNIEnv *env, jclass class, jlong list, jlong el)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_add\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_add for parameter list");
		goto error;
	}
	isl_constraint* el_c = (isl_constraint*) GECOS_PTRSIZE el; 
	if(((void*)el_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_add for parameter el");
		goto error;
	}

	isl_constraint_list* res = (isl_constraint_list*) isl_constraint_list_add(list_c, el_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1drop
(JNIEnv *env, jclass class, jlong list, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_drop\n");fflush(stdout);
#endif
	isl_constraint_list* list_c = (isl_constraint_list*) GECOS_PTRSIZE list; 
	if(((void*)list_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_drop for parameter list");
		goto error;
	}
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_constraint_list* res = (isl_constraint_list*) isl_constraint_list_drop(list_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_drop\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1concat
(JNIEnv *env, jclass class, jlong list1, jlong list2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_concat\n");fflush(stdout);
#endif
	isl_constraint_list* list1_c = (isl_constraint_list*) GECOS_PTRSIZE list1; 
	if(((void*)list1_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_concat for parameter list1");
		goto error;
	}
	isl_constraint_list* list2_c = (isl_constraint_list*) GECOS_PTRSIZE list2; 
	if(((void*)list2_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_concat for parameter list2");
		goto error;
	}

	isl_constraint_list* res = (isl_constraint_list*) isl_constraint_list_concat(list1_c, list2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_concat\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1list_1to_1string
(JNIEnv *env, jclass class, jlong constraintlist, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_list_to_string\n");fflush(stdout);
#endif
	isl_constraint_list* constraintlist_c = (isl_constraint_list*) GECOS_PTRSIZE constraintlist; 
	if(((void*)constraintlist_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_list_to_string for parameter constraintlist");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_constraint_list_to_string(constraintlist_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_list_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


