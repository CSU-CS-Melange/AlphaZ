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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1read_1from_1str
(JNIEnv *env, jclass class, jlong ctx, jstring str)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_read_from_str\n");fflush(stdout);
#endif
	isl_ctx* ctx_c = (isl_ctx*) GECOS_PTRSIZE ctx; 
	if(((void*)ctx_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_read_from_str for parameter ctx");
		goto error;
	}
	char* str_c;
	str_c = (char*) (const jbyte*)(*env)->GetStringUTFChars(env, str, NULL);
	if (str_c==NULL) {
		throwException(env, "GetStringUTFChars Failed  in isl_union_map_read_from_str for parameter str");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_read_from_str(ctx_c, str_c);

	(*env)->ReleaseStringUTFChars(env, str, str_c);

#ifdef TRACE_ALL
	printf("Leaving isl_union_map_read_from_str\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1map_1from_1union_1map
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_map_from_union_map\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_map_from_union_map for parameter umap");
		goto error;
	}

	isl_map* res = (isl_map*) isl_map_from_union_map(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_map_from_union_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1empty
(JNIEnv *env, jclass class, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_empty\n");fflush(stdout);
#endif
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_empty for parameter space");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_empty(space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_empty\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1universe
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_universe\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_universe for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_universe(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_universe\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1get_1ctx
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_get_ctx\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_get_ctx for parameter umap");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_union_map_get_ctx(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1get_1space
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_get_space\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_get_space for parameter umap");
		goto error;
	}

	isl_space* res = (isl_space*) isl_union_map_get_space(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1copy
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_copy\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_copy for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_copy(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1free
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_free\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_free for parameter umap");
		goto error;
	}

	 isl_union_map_free(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1n_1map
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_n_map\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_n_map for parameter umap");
		goto error;
	}

	int res = (int) isl_union_map_n_map(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_n_map\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1compute_1divs
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_compute_divs\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_compute_divs for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_compute_divs(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_compute_divs\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1extract_1map
(JNIEnv *env, jclass class, jlong umap, jlong space)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_extract_map\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_extract_map for parameter umap");
		goto error;
	}
	isl_space* space_c = (isl_space*) GECOS_PTRSIZE space; 
	if(((void*)space_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_extract_map for parameter space");
		goto error;
	}

	isl_map* res = (isl_map*) isl_union_map_extract_map(umap_c, space_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_extract_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1dim
(JNIEnv *env, jclass class, jlong umap, jint type)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_dim\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_dim for parameter umap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;

	unsigned int res = (unsigned int) isl_union_map_dim(umap_c, type_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_dim\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1is_1empty
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_is_empty\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_empty for parameter umap");
		goto error;
	}

	int res = (int) isl_union_map_is_empty(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_is_empty\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1is_1bijective
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_is_bijective\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_bijective for parameter umap");
		goto error;
	}

	int res = (int) isl_union_map_is_bijective(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_is_bijective\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1is_1injective
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_is_injective\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_injective for parameter umap");
		goto error;
	}

	int res = (int) isl_union_map_is_injective(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_is_injective\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1is_1single_1valued
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_is_single_valued\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_single_valued for parameter umap");
		goto error;
	}

	int res = (int) isl_union_map_is_single_valued(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_is_single_valued\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1is_1equal
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_is_equal\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_equal for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_equal for parameter umap2");
		goto error;
	}

	int res = (int) isl_union_map_is_equal(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1is_1subset
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_is_subset\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_subset for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_subset for parameter umap2");
		goto error;
	}

	int res = (int) isl_union_map_is_subset(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_is_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1is_1strict_1subset
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_is_strict_subset\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_strict_subset for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_is_strict_subset for parameter umap2");
		goto error;
	}

	int res = (int) isl_union_map_is_strict_subset(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_is_strict_subset\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1params
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_params\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_params for parameter umap");
		goto error;
	}

	isl_set* res = (isl_set*) isl_union_map_params(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1reverse
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_reverse\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_reverse for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_reverse(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_reverse\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1project_1out
(JNIEnv *env, jclass class, jlong umap, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_project_out\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_project_out for parameter umap");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	isl_union_map* res = (isl_union_map*) isl_union_map_project_out(umap_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_project_out\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1domain
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_domain\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_domain for parameter umap");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_map_domain(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1range
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_range\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_range for parameter umap");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_map_range(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1domain_1map
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_domain_map\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_domain_map for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_domain_map(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_domain_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1range_1map
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_range_map\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_range_map for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_range_map(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_range_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1deltas
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_deltas\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_deltas for parameter umap");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_map_deltas(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_deltas\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1deltas_1map
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_deltas_map\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_deltas_map for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_deltas_map(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_deltas_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1coalesce
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_coalesce\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_coalesce for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_coalesce(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_coalesce\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1detect_1equalities
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_detect_equalities\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_detect_equalities for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_detect_equalities(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_detect_equalities\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1affine_1hull
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_affine_hull\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_affine_hull for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_affine_hull(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_affine_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1polyhedral_1hull
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_polyhedral_hull\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_polyhedral_hull for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_polyhedral_hull(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_polyhedral_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1simple_1hull
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_simple_hull\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_simple_hull for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_simple_hull(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_simple_hull\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1power
(JNIEnv *env, jclass class, jlong umap, jobject exact)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_power\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_power for parameter umap");
		goto error;
	}
	jclass exact_cls = (*env)->GetObjectClass(env, exact); 
	jfieldID exact_fid = (*env)->GetFieldID(env, exact_cls, "value", "Z");
	int exact_c = (int) (*env)->GetBooleanField(env, exact, exact_fid);

	isl_union_map* res = (isl_union_map*) isl_union_map_power(umap_c, &exact_c);

	(*env)->SetBooleanField(env, exact, exact_fid, exact_c);

#ifdef TRACE_ALL
	printf("Leaving isl_union_map_power\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1fixed_1power_1val
(JNIEnv *env, jclass class, jlong umap, jlong exp)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_fixed_power_val\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_fixed_power_val for parameter umap");
		goto error;
	}
	isl_val* exp_c = (isl_val*) GECOS_PTRSIZE exp; 
	if(((void*)exp_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_fixed_power_val for parameter exp");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_fixed_power_val(umap_c, exp_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_fixed_power_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1transitive_1closure
(JNIEnv *env, jclass class, jlong umap, jobject exact)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_transitive_closure\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_transitive_closure for parameter umap");
		goto error;
	}
	jclass exact_cls = (*env)->GetObjectClass(env, exact); 
	jfieldID exact_fid = (*env)->GetFieldID(env, exact_cls, "value", "Z");
	int exact_c = (int) (*env)->GetBooleanField(env, exact, exact_fid);

	isl_union_map* res = (isl_union_map*) isl_union_map_transitive_closure(umap_c, &exact_c);

	(*env)->SetBooleanField(env, exact, exact_fid, exact_c);

#ifdef TRACE_ALL
	printf("Leaving isl_union_map_transitive_closure\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1wrap
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_wrap\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_wrap for parameter umap");
		goto error;
	}

	isl_union_set* res = (isl_union_set*) isl_union_map_wrap(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_wrap\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1zip
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_zip\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_zip for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_zip(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_zip\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1curry
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_curry\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_curry for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_curry(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_curry\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1uncurry
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_uncurry\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_uncurry for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_uncurry(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_uncurry\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1add_1map
(JNIEnv *env, jclass class, jlong umap, jlong map)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_add_map\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_add_map for parameter umap");
		goto error;
	}
	isl_map* map_c = (isl_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_add_map for parameter map");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_add_map(umap_c, map_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_add_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1intersect_1params
(JNIEnv *env, jclass class, jlong umap, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_intersect_params\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_intersect_params for parameter umap");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_intersect_params for parameter set");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_intersect_params(umap_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_intersect_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1intersect_1domain
(JNIEnv *env, jclass class, jlong umap, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_intersect_domain\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_intersect_domain for parameter umap");
		goto error;
	}
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_intersect_domain for parameter uset");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_intersect_domain(umap_c, uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_intersect_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1intersect_1range
(JNIEnv *env, jclass class, jlong umap, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_intersect_range\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_intersect_range for parameter umap");
		goto error;
	}
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_intersect_range for parameter uset");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_intersect_range(umap_c, uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_intersect_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1intersect
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_intersect\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_intersect for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_intersect for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_intersect(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_intersect\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1union
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_union\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_union for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_union for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_union(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_union\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1subtract
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_subtract\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_subtract for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_subtract for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_subtract(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_subtract\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1subtract_1domain
(JNIEnv *env, jclass class, jlong umap, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_subtract_domain\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_subtract_domain for parameter umap");
		goto error;
	}
	isl_union_set* dom_c = (isl_union_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_subtract_domain for parameter dom");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_subtract_domain(umap_c, dom_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_subtract_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1subtract_1range
(JNIEnv *env, jclass class, jlong umap, jlong dom)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_subtract_range\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_subtract_range for parameter umap");
		goto error;
	}
	isl_union_set* dom_c = (isl_union_set*) GECOS_PTRSIZE dom; 
	if(((void*)dom_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_subtract_range for parameter dom");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_subtract_range(umap_c, dom_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_subtract_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1apply_1domain
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_apply_domain\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_apply_domain for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_apply_domain for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_apply_domain(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_apply_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1apply_1range
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_apply_range\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_apply_range for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_apply_range for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_apply_range(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_apply_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1preimage_1domain_1multi_1aff
(JNIEnv *env, jclass class, jlong umap, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_preimage_domain_multi_aff\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_domain_multi_aff for parameter umap");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_domain_multi_aff for parameter ma");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_preimage_domain_multi_aff(umap_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_preimage_domain_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1preimage_1domain_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong umap, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_preimage_domain_pw_multi_aff\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_domain_pw_multi_aff for parameter umap");
		goto error;
	}
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_domain_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_preimage_domain_pw_multi_aff(umap_c, pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_preimage_domain_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1preimage_1domain_1union_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong umap, jlong upma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_preimage_domain_union_pw_multi_aff\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_domain_union_pw_multi_aff for parameter umap");
		goto error;
	}
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_domain_union_pw_multi_aff for parameter upma");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_preimage_domain_union_pw_multi_aff(umap_c, upma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_preimage_domain_union_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1preimage_1range_1multi_1aff
(JNIEnv *env, jclass class, jlong umap, jlong ma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_preimage_range_multi_aff\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_range_multi_aff for parameter umap");
		goto error;
	}
	isl_multi_aff* ma_c = (isl_multi_aff*) GECOS_PTRSIZE ma; 
	if(((void*)ma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_range_multi_aff for parameter ma");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_preimage_range_multi_aff(umap_c, ma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_preimage_range_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1preimage_1range_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong umap, jlong pma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_preimage_range_pw_multi_aff\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_range_pw_multi_aff for parameter umap");
		goto error;
	}
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*) GECOS_PTRSIZE pma; 
	if(((void*)pma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_range_pw_multi_aff for parameter pma");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_preimage_range_pw_multi_aff(umap_c, pma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_preimage_range_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1preimage_1range_1union_1pw_1multi_1aff
(JNIEnv *env, jclass class, jlong umap, jlong upma)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_preimage_range_union_pw_multi_aff\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_range_union_pw_multi_aff for parameter umap");
		goto error;
	}
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*) GECOS_PTRSIZE upma; 
	if(((void*)upma_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_preimage_range_union_pw_multi_aff for parameter upma");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_preimage_range_union_pw_multi_aff(umap_c, upma_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_preimage_range_union_pw_multi_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1gist
(JNIEnv *env, jclass class, jlong umap, jlong context)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_gist\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_gist for parameter umap");
		goto error;
	}
	isl_union_map* context_c = (isl_union_map*) GECOS_PTRSIZE context; 
	if(((void*)context_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_gist for parameter context");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_gist(umap_c, context_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_gist\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1gist_1params
(JNIEnv *env, jclass class, jlong umap, jlong set)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_gist_params\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_gist_params for parameter umap");
		goto error;
	}
	isl_set* set_c = (isl_set*) GECOS_PTRSIZE set; 
	if(((void*)set_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_gist_params for parameter set");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_gist_params(umap_c, set_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_gist_params\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1gist_1domain
(JNIEnv *env, jclass class, jlong umap, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_gist_domain\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_gist_domain for parameter umap");
		goto error;
	}
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_gist_domain for parameter uset");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_gist_domain(umap_c, uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_gist_domain\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1gist_1range
(JNIEnv *env, jclass class, jlong umap, jlong uset)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_gist_range\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_gist_range for parameter umap");
		goto error;
	}
	isl_union_set* uset_c = (isl_union_set*) GECOS_PTRSIZE uset; 
	if(((void*)uset_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_gist_range for parameter uset");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_gist_range(umap_c, uset_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_gist_range\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1lexmin
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_lexmin\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lexmin for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_lexmin(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_lexmin\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1lexmax
(JNIEnv *env, jclass class, jlong umap)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_lexmax\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lexmax for parameter umap");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_lexmax(umap_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_lexmax\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1lex_1lt_1union_1map
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_lex_lt_union_map\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lex_lt_union_map for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lex_lt_union_map for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_lex_lt_union_map(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_lex_lt_union_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1lex_1le_1union_1map
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_lex_le_union_map\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lex_le_union_map for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lex_le_union_map for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_lex_le_union_map(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_lex_le_union_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1lex_1gt_1union_1map
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_lex_gt_union_map\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lex_gt_union_map for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lex_gt_union_map for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_lex_gt_union_map(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_lex_gt_union_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1lex_1ge_1union_1map
(JNIEnv *env, jclass class, jlong umap1, jlong umap2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_lex_ge_union_map\n");fflush(stdout);
#endif
	isl_union_map* umap1_c = (isl_union_map*) GECOS_PTRSIZE umap1; 
	if(((void*)umap1_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lex_ge_union_map for parameter umap1");
		goto error;
	}
	isl_union_map* umap2_c = (isl_union_map*) GECOS_PTRSIZE umap2; 
	if(((void*)umap2_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_lex_ge_union_map for parameter umap2");
		goto error;
	}

	isl_union_map* res = (isl_union_map*) isl_union_map_lex_ge_union_map(umap1_c, umap2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_lex_ge_union_map\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1to_1string
(JNIEnv *env, jclass class, jlong map, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_to_string\n");fflush(stdout);
#endif
	isl_union_map* map_c = (isl_union_map*) GECOS_PTRSIZE map; 
	if(((void*)map_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_to_string for parameter map");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_union_map_to_string(map_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1union_1map_1get_1map_1at
(JNIEnv *env, jclass class, jlong umap, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_union_map_get_map_at\n");fflush(stdout);
#endif
	isl_union_map* umap_c = (isl_union_map*) GECOS_PTRSIZE umap; 
	if(((void*)umap_c)==NULL) {
		throwException(env, "Null pointer in isl_union_map_get_map_at for parameter umap");
		goto error;
	}
	int pos_c = (int) pos;

	isl_map* res = (isl_map*) isl_union_map_get_map_at(umap_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_union_map_get_map_at\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


