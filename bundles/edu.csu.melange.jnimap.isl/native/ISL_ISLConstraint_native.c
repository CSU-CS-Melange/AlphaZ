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


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1map_1from_1constraint
(JNIEnv *env, jclass class, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_from_constraint\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_map_from_constraint for parameter constraint");
		goto error;
	}

	isl_basic_map* res = (isl_basic_map*) isl_basic_map_from_constraint(constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_from_constraint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1basic_1set_1from_1constraint
(JNIEnv *env, jclass class, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_from_constraint\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_basic_set_from_constraint for parameter constraint");
		goto error;
	}

	isl_basic_set* res = (isl_basic_set*) isl_basic_set_from_constraint(constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_from_constraint\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1equality_1alloc
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_equality_alloc\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_equality_alloc for parameter ls");
		goto error;
	}

	isl_constraint* res = (isl_constraint*) isl_equality_alloc(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_equality_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1inequality_1alloc
(JNIEnv *env, jclass class, jlong ls)
 {
#ifdef TRACE_ALL
	printf("Entering isl_inequality_alloc\n");fflush(stdout);
#endif
	isl_local_space* ls_c = (isl_local_space*) GECOS_PTRSIZE ls; 
	if(((void*)ls_c)==NULL) {
		throwException(env, "Null pointer in isl_inequality_alloc for parameter ls");
		goto error;
	}

	isl_constraint* res = (isl_constraint*) isl_inequality_alloc(ls_c);


#ifdef TRACE_ALL
	printf("Leaving isl_inequality_alloc\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1ctx
(JNIEnv *env, jclass class, jlong c)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_ctx\n");fflush(stdout);
#endif
	isl_constraint* c_c = (isl_constraint*) GECOS_PTRSIZE c; 
	if(((void*)c_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_ctx for parameter c");
		goto error;
	}

	isl_ctx* res = (isl_ctx*) isl_constraint_get_ctx(c_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_ctx\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1space
(JNIEnv *env, jclass class, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_space\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_space for parameter constraint");
		goto error;
	}

	isl_space* res = (isl_space*) isl_constraint_get_space(constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1local_1space
(JNIEnv *env, jclass class, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_local_space\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_local_space for parameter constraint");
		goto error;
	}

	isl_local_space* res = (isl_local_space*) isl_constraint_get_local_space(constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_local_space\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1copy
(JNIEnv *env, jclass class, jlong c)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_copy\n");fflush(stdout);
#endif
	isl_constraint* c_c = (isl_constraint*) GECOS_PTRSIZE c; 
	if(((void*)c_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_copy for parameter c");
		goto error;
	}

	isl_constraint* res = (isl_constraint*) isl_constraint_copy(c_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_copy\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1free
(JNIEnv *env, jclass class, jlong c)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_free\n");fflush(stdout);
#endif
	isl_constraint* c_c = (isl_constraint*) GECOS_PTRSIZE c; 
	if(((void*)c_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_free for parameter c");
		goto error;
	}

	 isl_constraint_free(c_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1set_1constant_1si
(JNIEnv *env, jclass class, jlong constraint, jint v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_set_constant_si\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_set_constant_si for parameter constraint");
		goto error;
	}
	int v_c = (int) v;

	isl_constraint* res = (isl_constraint*) isl_constraint_set_constant_si(constraint_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_set_constant_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1set_1constant_1val
(JNIEnv *env, jclass class, jlong constraint, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_set_constant_val\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_set_constant_val for parameter constraint");
		goto error;
	}
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_set_constant_val for parameter v");
		goto error;
	}

	isl_constraint* res = (isl_constraint*) isl_constraint_set_constant_val(constraint_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_set_constant_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1set_1coefficient_1si
(JNIEnv *env, jclass class, jlong constraint, jint type, jint pos, jint v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_set_coefficient_si\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_set_coefficient_si for parameter constraint");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;
	int v_c = (int) v;

	isl_constraint* res = (isl_constraint*) isl_constraint_set_coefficient_si(constraint_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_set_coefficient_si\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1set_1coefficient_1val
(JNIEnv *env, jclass class, jlong constraint, jint type, jint pos, jlong v)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_set_coefficient_val\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_set_coefficient_val for parameter constraint");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;
	isl_val* v_c = (isl_val*) GECOS_PTRSIZE v; 
	if(((void*)v_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_set_coefficient_val for parameter v");
		goto error;
	}

	isl_constraint* res = (isl_constraint*) isl_constraint_set_coefficient_val(constraint_c, type_c, pos_c, v_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_set_coefficient_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1is_1equal
(JNIEnv *env, jclass class, jlong constraint1, jlong constraint2)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_is_equal\n");fflush(stdout);
#endif
	isl_constraint* constraint1_c = (isl_constraint*) GECOS_PTRSIZE constraint1; 
	if(((void*)constraint1_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_is_equal for parameter constraint1");
		goto error;
	}
	isl_constraint* constraint2_c = (isl_constraint*) GECOS_PTRSIZE constraint2; 
	if(((void*)constraint2_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_is_equal for parameter constraint2");
		goto error;
	}

	int res = (int) isl_constraint_is_equal(constraint1_c, constraint2_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_is_equal\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1is_1equality
(JNIEnv *env, jclass class, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_is_equality\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_is_equality for parameter constraint");
		goto error;
	}

	int res = (int) isl_constraint_is_equality(constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_is_equality\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1is_1div_1constraint
(JNIEnv *env, jclass class, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_is_div_constraint\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_is_div_constraint for parameter constraint");
		goto error;
	}

	int res = (int) isl_constraint_is_div_constraint(constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_is_div_constraint\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1is_1lower_1bound
(JNIEnv *env, jclass class, jlong constraint, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_is_lower_bound\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_is_lower_bound for parameter constraint");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_constraint_is_lower_bound(constraint_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_is_lower_bound\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1is_1upper_1bound
(JNIEnv *env, jclass class, jlong constraint, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_is_upper_bound\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_is_upper_bound for parameter constraint");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	int res = (int) isl_constraint_is_upper_bound(constraint_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_is_upper_bound\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1constant_1val
(JNIEnv *env, jclass class, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_constant_val\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_constant_val for parameter constraint");
		goto error;
	}

	isl_val* res = (isl_val*) isl_constraint_get_constant_val(constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_constant_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1coefficient_1val
(JNIEnv *env, jclass class, jlong constraint, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_coefficient_val\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_coefficient_val for parameter constraint");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;

	isl_val* res = (isl_val*) isl_constraint_get_coefficient_val(constraint_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_coefficient_val\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1involves_1dims
(JNIEnv *env, jclass class, jlong constraint, jint type, jint first, jint n)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_involves_dims\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_involves_dims for parameter constraint");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int first_c = (unsigned int) first;
	unsigned int n_c = (unsigned int) n;

	int res = (int) isl_constraint_involves_dims(constraint_c, type_c, first_c, n_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_involves_dims\n");fflush(stdout);
#endif
	

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1div
(JNIEnv *env, jclass class, jlong constraint, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_div\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_div for parameter constraint");
		goto error;
	}
	int pos_c = (int) pos;

	isl_aff* res = (isl_aff*) isl_constraint_get_div(constraint_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_div\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1dim_1name
(JNIEnv *env, jclass class, jlong constraint, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_dim_name\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_dim_name for parameter constraint");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	unsigned int pos_c = (unsigned int) pos;

	char * res = (char *) isl_constraint_get_dim_name(constraint_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_dim_name\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1bound
(JNIEnv *env, jclass class, jlong constraint, jint type, jint pos)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_bound\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_bound for parameter constraint");
		goto error;
	}
	enum isl_dim_type type_c = (enum isl_dim_type) type;
	int pos_c = (int) pos;

	isl_aff* res = (isl_aff*) isl_constraint_get_bound(constraint_c, type_c, pos_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_bound\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1get_1aff
(JNIEnv *env, jclass class, jlong constraint)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_get_aff\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_get_aff for parameter constraint");
		goto error;
	}

	isl_aff* res = (isl_aff*) isl_constraint_get_aff(constraint_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_get_aff\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1constraint_1to_1string
(JNIEnv *env, jclass class, jlong constraint, jint format)
 {
#ifdef TRACE_ALL
	printf("Entering isl_constraint_to_string\n");fflush(stdout);
#endif
	isl_constraint* constraint_c = (isl_constraint*) GECOS_PTRSIZE constraint; 
	if(((void*)constraint_c)==NULL) {
		throwException(env, "Null pointer in isl_constraint_to_string for parameter constraint");
		goto error;
	}
	int format_c = (int) format;

	char * res = (char *) isl_constraint_to_string(constraint_c, format_c);


#ifdef TRACE_ALL
	printf("Leaving isl_constraint_to_string\n");fflush(stdout);
#endif
	

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}


