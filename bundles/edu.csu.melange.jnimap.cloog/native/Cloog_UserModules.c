#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <cloog/cloog.h>
#include <isl/ctx.h>

#include "fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h"
#include "fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h"



/**********************************
 ** addons
 **********************************/
#include "CloogUser_addons.h"

//addons . cloog_clast_from_union_map
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_cloog_1clast_1from_1union_1map
(JNIEnv *env, jclass clazz, jlong state, jlong opts, jstring context, jstring union_map_str)
 {
	struct cloogstate* state_c = (struct cloogstate*)GECOS_PTRSIZE state;
	struct cloogoptions* opts_c = (struct cloogoptions*)GECOS_PTRSIZE opts;
	char * context_c = (char *)(*env)->GetStringUTFChars(env,context,0);
	char * union_map_str_c = (char *)(*env)->GetStringUTFChars(env,union_map_str,0);
	
	struct clast_stmt* res = (struct clast_stmt*) cloog_clast_from_union_map(state_c, opts_c, context_c, union_map_str_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//addons . cloog_clast_from_set
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_cloog_1clast_1from_1set
(JNIEnv *env, jclass clazz, jlong state, jlong opts, jstring context, jstring set_str)
 {
	struct cloogstate* state_c = (struct cloogstate*)GECOS_PTRSIZE state;
	struct cloogoptions* opts_c = (struct cloogoptions*)GECOS_PTRSIZE opts;
	char * context_c = (char *)(*env)->GetStringUTFChars(env,context,0);
	char * set_str_c = (char *)(*env)->GetStringUTFChars(env,set_str,0);
	
	struct clast_stmt* res = (struct clast_stmt*) cloog_clast_from_set(state_c, opts_c, context_c, set_str_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//addons . cloog_input_read_from_isl_union_map_str
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_cloog_1input_1read_1from_1isl_1union_1map_1str
(JNIEnv *env, jclass clazz, jlong ctx, jlong state, jstring context, jstring union_map_str)
 {
	isl_ctx* ctx_c = (isl_ctx*)GECOS_PTRSIZE ctx;
	struct cloogstate* state_c = (struct cloogstate*)GECOS_PTRSIZE state;
	char * context_c = (char *)(*env)->GetStringUTFChars(env,context,0);
	char * union_map_str_c = (char *)(*env)->GetStringUTFChars(env,union_map_str,0);
	
	struct clooginput* res = (struct clooginput*) cloog_input_read_from_isl_union_map_str(ctx_c, state_c, context_c, union_map_str_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//addons . cloog_input_read_from_isl_set_str
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_cloog_1input_1read_1from_1isl_1set_1str
(JNIEnv *env, jclass clazz, jlong ctx, jlong state, jstring context, jstring set_str)
 {
	isl_ctx* ctx_c = (isl_ctx*)GECOS_PTRSIZE ctx;
	struct cloogstate* state_c = (struct cloogstate*)GECOS_PTRSIZE state;
	char * context_c = (char *)(*env)->GetStringUTFChars(env,context,0);
	char * set_str_c = (char *)(*env)->GetStringUTFChars(env,set_str,0);
	
	struct clooginput* res = (struct clooginput*) cloog_input_read_from_isl_set_str(ctx_c, state_c, context_c, set_str_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//addons . clast_print
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1print
(JNIEnv *env, jclass clazz, jlong stmt, jlong opts)
 {
	struct clast_stmt* stmt_c = (struct clast_stmt*)GECOS_PTRSIZE stmt;
	struct cloogoptions* opts_c = (struct cloogoptions*)GECOS_PTRSIZE opts;
	
	 clast_print(stmt_c, opts_c);
error:
	return;
}
//addons . clast_reduction_get_element
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1reduction_1get_1element
(JNIEnv *env, jclass clazz, jlong stmt, jint offset)
 {
	struct clast_reduction* stmt_c = (struct clast_reduction*)GECOS_PTRSIZE stmt;
	int offset_c = (int)offset;
	
	struct clast_expr* res = (struct clast_expr*) clast_reduction_get_element(stmt_c, offset_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//addons . clast_reduction_get_number_of_elements
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1reduction_1get_1number_1of_1elements
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_reduction* stmt_c = (struct clast_reduction*)GECOS_PTRSIZE stmt;
	
	int res = (int) clast_reduction_get_number_of_elements(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . clast_binary_get_value
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1binary_1get_1value
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_binary* stmt_c = (struct clast_binary*)GECOS_PTRSIZE stmt;
	
	int res = (int) clast_binary_get_value(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . clast_term_get_value
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1term_1get_1value
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_term* stmt_c = (struct clast_term*)GECOS_PTRSIZE stmt;
	
	int res = (int) clast_term_get_value(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . clast_user_stmt_get_cloog_domain
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1user_1stmt_1get_1cloog_1domain
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_user_stmt* stmt_c = (struct clast_user_stmt*)GECOS_PTRSIZE stmt;
	
	char * res = (char *) clast_user_stmt_get_cloog_domain(stmt_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//addons . clast_for_get_cloog_domain
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1for_1get_1cloog_1domain
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_for* stmt_c = (struct clast_for*)GECOS_PTRSIZE stmt;
	
	char * res = (char *) clast_for_get_cloog_domain(stmt_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//addons . clast_for_get_stride
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1for_1get_1stride
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_for* stmt_c = (struct clast_for*)GECOS_PTRSIZE stmt;
	
	int res = (int) clast_for_get_stride(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . clast_guard_get_equation
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1guard_1get_1equation
(JNIEnv *env, jclass clazz, jlong stmt, jint offset)
 {
	struct clast_guard* stmt_c = (struct clast_guard*)GECOS_PTRSIZE stmt;
	int offset_c = (int)offset;
	
	struct clast_equation* res = (struct clast_equation*) clast_guard_get_equation(stmt_c, offset_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//addons . clast_guard_get_n
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1guard_1get_1n
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_guard* stmt_c = (struct clast_guard*)GECOS_PTRSIZE stmt;
	
	int res = (int) clast_guard_get_n(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . get_scalar
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_get_1scalar
(JNIEnv *env, jclass clazz, jlong names, jint index)
 {
	struct cloognames* names_c = (struct cloognames*)GECOS_PTRSIZE names;
	int index_c = (int)index;
	
	char * res = (char *) get_scalar(names_c, index_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//addons . get_scattering
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_get_1scattering
(JNIEnv *env, jclass clazz, jlong names, jint index)
 {
	struct cloognames* names_c = (struct cloognames*)GECOS_PTRSIZE names;
	int index_c = (int)index;
	
	char * res = (char *) get_scattering(names_c, index_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//addons . get_parameter
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_get_1parameter
(JNIEnv *env, jclass clazz, jlong names, jint index)
 {
	struct cloognames* names_c = (struct cloognames*)GECOS_PTRSIZE names;
	int index_c = (int)index;
	
	char * res = (char *) get_parameter(names_c, index_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//addons . get_iterator
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_get_1iterator
(JNIEnv *env, jclass clazz, jlong names, jint index)
 {
	struct cloognames* names_c = (struct cloognames*)GECOS_PTRSIZE names;
	int index_c = (int)index;
	
	char * res = (char *) get_iterator(names_c, index_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//addons . is_clast_guard
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1guard
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_stmt* stmt_c = (struct clast_stmt*)GECOS_PTRSIZE stmt;
	
	int res = (int) is_clast_guard(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_for
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1for
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_stmt* stmt_c = (struct clast_stmt*)GECOS_PTRSIZE stmt;
	
	int res = (int) is_clast_for(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_assignment
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1assignment
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_stmt* stmt_c = (struct clast_stmt*)GECOS_PTRSIZE stmt;
	
	int res = (int) is_clast_assignment(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_user_stmt
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1user_1stmt
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_stmt* stmt_c = (struct clast_stmt*)GECOS_PTRSIZE stmt;
	
	int res = (int) is_clast_user_stmt(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_block
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1block
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_stmt* stmt_c = (struct clast_stmt*)GECOS_PTRSIZE stmt;
	
	int res = (int) is_clast_block(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_root
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1root
(JNIEnv *env, jclass clazz, jlong stmt)
 {
	struct clast_stmt* stmt_c = (struct clast_stmt*)GECOS_PTRSIZE stmt;
	
	int res = (int) is_clast_root(stmt_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_expr_binary
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1expr_1binary
(JNIEnv *env, jclass clazz, jlong expr)
 {
	struct clast_expr* expr_c = (struct clast_expr*)GECOS_PTRSIZE expr;
	
	int res = (int) is_clast_expr_binary(expr_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_expr_term
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1expr_1term
(JNIEnv *env, jclass clazz, jlong expr)
 {
	struct clast_expr* expr_c = (struct clast_expr*)GECOS_PTRSIZE expr;
	
	int res = (int) is_clast_expr_term(expr_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_expr_reduction
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1expr_1reduction
(JNIEnv *env, jclass clazz, jlong expr)
 {
	struct clast_expr* expr_c = (struct clast_expr*)GECOS_PTRSIZE expr;
	
	int res = (int) is_clast_expr_reduction(expr_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//addons . is_clast_expr_name
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1expr_1name
(JNIEnv *env, jclass clazz, jlong expr)
 {
	struct clast_expr* expr_c = (struct clast_expr*)GECOS_PTRSIZE expr;
	
	int res = (int) is_clast_expr_name(expr_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
