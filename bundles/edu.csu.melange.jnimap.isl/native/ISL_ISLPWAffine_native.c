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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1multi_1pw_1aff_1from_1pw_1aff
(JNIEnv *env, jclass class, jlong pa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_multi_pw_aff_from_pw_aff\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_multi_pw_aff_from_pw_aff for parameter pa");
		goto error;
	}

	isl_multi_pw_aff* res = (isl_multi_pw_aff*) isl_multi_pw_aff_from_pw_aff(pa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_multi_pw_aff_from_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1multi_1aff_1from_1pw_1aff
(JNIEnv *env, jclass class, jlong pa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_multi_aff_from_pw_aff\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_multi_aff_from_pw_aff for parameter pa");
		goto error;
	}

	isl_pw_multi_aff* res = (isl_pw_multi_aff*) isl_pw_multi_aff_from_pw_aff(pa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_multi_aff_from_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1set_1from_1pw_1aff
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_set_from_pw_aff\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_set_from_pw_aff for parameter pwaff");
		goto error;
	}

	isl_set* res = (isl_set*) isl_set_from_pw_aff(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_set_from_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1from_1pw_1aff
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_from_pw_aff\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_pw_aff for parameter pwaff");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_from_pw_aff(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_from_pw_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1get_1ctx
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_get_ctx\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_get_ctx for parameter pwaff");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_pw_aff_get_ctx(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1copy
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_copy\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_copy for parameter pwaff");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_copy(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1free
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_free\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_free for parameter pwaff");
		goto error;
	}

	 isl_pw_aff_free(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1get_1domain_1space
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_get_domain_space\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_get_domain_space for parameter pwaff");
		goto error;
	}

	isl_space* res = (isl_space*) isl_pw_aff_get_domain_space(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_get_domain_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1get_1space
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_get_space\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_get_space for parameter pwaff");
		goto error;
	}

	isl_space* res = (isl_space*) isl_pw_aff_get_space(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_pw_aff_read_from_str for parameter str");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1alloc
(JNIEnv *env, jclass class, jlong set, jlong aff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_alloc\n");fflush(stdout);
#endif
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_alloc for parameter set");
		goto error;
	}
	isl_aff* aff_c = (isl_aff*) GECOS_PTRSIZE aff; 
	if(((void*)aff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_alloc for parameter aff");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_alloc(set_c, aff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1empty
(JNIEnv *env, jclass class, jlong dim)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_empty\n");fflush(stdout);
#endif
	isl_space* dim_c = (isl_space*) GECOS_PTRSIZE dim; 
	if(((void*)dim_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_empty for parameter dim");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_empty(dim_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1zero_1on_1domain
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_zero_on_domain\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_zero_on_domain for parameter ls");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_zero_on_domain(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_zero_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1var_1on_1domain
(JNIEnv *env, jclass class, jlong ls, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_var_on_domain\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_var_on_domain for parameter ls");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_var_on_domain(ls_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_var_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1nan_1on_1domain
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_nan_on_domain\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_nan_on_domain for parameter ls");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_nan_on_domain(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_nan_on_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1get_1dim_1name
(JNIEnv *env, jclass class, jlong pa, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_get_dim_name\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_get_dim_name for parameter pa");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_pw_aff_get_dim_name(pa_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1is_1empty
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_is_empty\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_is_empty for parameter pwaff");
		goto error;
	}

	int res = (int) isl_pw_aff_is_empty(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1involves_1nan
(JNIEnv *env, jclass class, jlong pa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_involves_nan\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_involves_nan for parameter pa");
		goto error;
	}

	int res = (int) isl_pw_aff_involves_nan(pa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_involves_nan\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1plain_1is_1equal
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_plain_is_equal\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_plain_is_equal for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_plain_is_equal for parameter pwaff2");
		goto error;
	}

	int res = (int) isl_pw_aff_plain_is_equal(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_plain_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1is_1equal
(JNIEnv *env, jclass class, jlong pa1, jlong pa2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_is_equal\n");fflush(stdout);
#endif
	isl_pw_aff* pa1_c = (isl_pw_aff*) GECOS_PTRSIZE pa1; 
	if(((void*)pa1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_is_equal for parameter pa1");
		goto error;
	}
	isl_pw_aff* pa2_c = (isl_pw_aff*) GECOS_PTRSIZE pa2; 
	if(((void*)pa2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_is_equal for parameter pa2");
		goto error;
	}

	int res = (int) isl_pw_aff_is_equal(pa1_c, pa2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1dim
(JNIEnv *env, jclass class, jlong pwaff, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_dim\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_dim for parameter pwaff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_pw_aff_dim(pwaff_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1involves_1dims
(JNIEnv *env, jclass class, jlong pwaff, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_involves_dims\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_involves_dims for parameter pwaff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_pw_aff_involves_dims(pwaff_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1is_1cst
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_is_cst\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_is_cst for parameter pwaff");
		goto error;
	}

	int res = (int) isl_pw_aff_is_cst(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_is_cst\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1align_1params
(JNIEnv *env, jclass class, jlong pwaff, jlong model)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_align_params\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_align_params for parameter pwaff");
		goto error;
	}
	isl_space* model_c = (isl_space*) GECOS_PTRSIZE model; 
	if(((void*)model_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_align_params for parameter model");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_align_params(pwaff_c, model_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_align_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1params
(JNIEnv *env, jclass class, jlong pwa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_params\n");fflush(stdout);
#endif
	isl_pw_aff* pwa_c = (isl_pw_aff*) GECOS_PTRSIZE pwa; 
	if(((void*)pwa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_params for parameter pwa");
		goto error;
	}

	isl_set* res = (isl_set*) isl_pw_aff_params(pwa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1domain
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_domain\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_domain for parameter pwaff");
		goto error;
	}

	isl_set* res = (isl_set*) isl_pw_aff_domain(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1from_1range
(JNIEnv *env, jclass class, jlong pwa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_from_range\n");fflush(stdout);
#endif
	isl_pw_aff* pwa_c = (isl_pw_aff*) GECOS_PTRSIZE pwa; 
	if(((void*)pwa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_from_range for parameter pwa");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_from_range(pwa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_from_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1min
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_min\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_min for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_min for parameter pwaff2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_min(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_min\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1max
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_max\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_max for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_max for parameter pwaff2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_max(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_max\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1mul
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_mul\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_mul for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_mul for parameter pwaff2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_mul(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_mul\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1div
(JNIEnv *env, jclass class, jlong pa1, jlong pa2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_div\n");fflush(stdout);
#endif
	isl_pw_aff* pa1_c = (isl_pw_aff*) GECOS_PTRSIZE pa1; 
	if(((void*)pa1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_div for parameter pa1");
		goto error;
	}
	isl_pw_aff* pa2_c = (isl_pw_aff*) GECOS_PTRSIZE pa2; 
	if(((void*)pa2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_div for parameter pa2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_div(pa1_c, pa2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_div\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1add
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_add\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_add for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_add for parameter pwaff2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_add(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1sub
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_sub\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_sub for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_sub for parameter pwaff2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_sub(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_sub\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1neg
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_neg\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_neg for parameter pwaff");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_neg(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_neg\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1ceil
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_ceil\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_ceil for parameter pwaff");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_ceil(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_ceil\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1floor
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_floor\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_floor for parameter pwaff");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_floor(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_floor\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1mod_1val
(JNIEnv *env, jclass class, jlong pa, jlong mod)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_mod_val\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_mod_val for parameter pa");
		goto error;
	}
	isl_val* mod_c = (isl_val*) GECOS_PTRSIZE mod; 
	if(((void*)mod_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_mod_val for parameter mod");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_mod_val(pa_c, mod_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_mod_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1union_1min
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_union_min\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_union_min for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_union_min for parameter pwaff2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_union_min(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_union_min\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1union_1max
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_union_max\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_union_max for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_union_max for parameter pwaff2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_union_max(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_union_max\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1union_1add
(JNIEnv *env, jclass class, jlong pwaff1, jlong pwaff2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_union_add\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff1_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff1; 
	if(((void*)pwaff1_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_union_add for parameter pwaff1");
		goto error;
	}
	isl_pw_aff* pwaff2_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff2; 
	if(((void*)pwaff2_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_union_add for parameter pwaff2");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_union_add(pwaff1_c, pwaff2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_union_add\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1intersect_1params
(JNIEnv *env, jclass class, jlong pa, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_intersect_params\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_intersect_params for parameter pa");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_intersect_params for parameter set");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_intersect_params(pa_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1intersect_1domain
(JNIEnv *env, jclass class, jlong pa, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_intersect_domain\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_intersect_domain for parameter pa");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_intersect_domain for parameter set");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_intersect_domain(pa_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1scale_1val
(JNIEnv *env, jclass class, jlong pa, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_scale_val\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_scale_val for parameter pa");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_scale_val for parameter v");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_scale_val(pa_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_scale_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1scale_1down_1val
(JNIEnv *env, jclass class, jlong pa, jlong f)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_scale_down_val\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_scale_down_val for parameter pa");
		goto error;
	}
	isl_val* f_c = (isl_val*) GECOS_PTRSIZE f; 
	if(((void*)f_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_scale_down_val for parameter f");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_scale_down_val(pa_c, f_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_scale_down_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1insert_1dims
(JNIEnv *env, jclass class, jlong pwaff, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_insert_dims\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_insert_dims for parameter pwaff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_insert_dims(pwaff_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_insert_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1add_1dims
(JNIEnv *env, jclass class, jlong pwaff, jint type, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_add_dims\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_add_dims for parameter pwaff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int n_c = (unsigned int) n;

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_add_dims(pwaff_c, type_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_add_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1move_1dims
(JNIEnv *env, jclass class, jlong pa, jint dst_type, jint dst_pos, jint src_type, jint src_pos, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_move_dims\n");fflush(stdout);
#endif
	isl_pw_aff* pa_c = (isl_pw_aff*) GECOS_PTRSIZE pa; 
	if(((void*)pa_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_move_dims for parameter pa");
		goto error;
	}
	enum isl_dim_type dst_type_c = (enum isl_dim_type) dst_type;
	unsigned int dst_pos_c = (unsigned int) dst_pos;
	enum isl_dim_type src_type_c = (enum isl_dim_type) src_type;
	unsigned int src_pos_c = (unsigned int) src_pos;
	unsigned int n_c = (unsigned int) n;

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_move_dims(pa_c, dst_type_c, dst_pos_c, src_type_c, src_pos_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_move_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1drop_1dims
(JNIEnv *env, jclass class, jlong pwaff, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_drop_dims\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_drop_dims for parameter pwaff");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_drop_dims(pwaff_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_drop_dims\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1coalesce
(JNIEnv *env, jclass class, jlong pwqp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_coalesce\n");fflush(stdout);
#endif
	isl_pw_aff* pwqp_c = (isl_pw_aff*) GECOS_PTRSIZE pwqp; 
	if(((void*)pwqp_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_coalesce for parameter pwqp");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_coalesce(pwqp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1gist
(JNIEnv *env, jclass class, jlong pwaff, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_gist\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_gist for parameter pwaff");
		goto error;
	}
	isl_set* context_c = (isl_set*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_gist for parameter context");
		goto error;
	}

	isl_pw_aff* res = (isl_pw_aff*) isl_pw_aff_gist(pwaff_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1pw_1aff_1n_1piece
(JNIEnv *env, jclass class, jlong pwaff)
 {
#ifdef TRACE_ALL
	printf("Entering isl_pw_aff_n_piece\n");fflush(stdout);
#endif
	isl_pw_aff* pwaff_c = (isl_pw_aff*) GECOS_PTRSIZE pwaff; 
	if(((void*)pwaff_c)==NULL) {
		throwException(env, "Null pointer in isl_pw_aff_n_piece for parameter pwaff");
		goto error;
	}

	int res = (int) isl_pw_aff_n_piece(pwaff_c);


#ifdef TRACE_ALL
	printf("Leaving isl_pw_aff_n_piece\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}


