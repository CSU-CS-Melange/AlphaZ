/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules */

#ifndef _Included_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
#define _Included_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    cloog_clast_from_union_map
 * Signature: (JJLjava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_cloog_1clast_1from_1union_1map
  (JNIEnv *, jclass, jlong, jlong, jstring, jstring);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    cloog_clast_from_set
 * Signature: (JJLjava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_cloog_1clast_1from_1set
  (JNIEnv *, jclass, jlong, jlong, jstring, jstring);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    cloog_input_read_from_isl_union_map_str
 * Signature: (JJLjava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_cloog_1input_1read_1from_1isl_1union_1map_1str
  (JNIEnv *, jclass, jlong, jlong, jstring, jstring);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    cloog_input_read_from_isl_set_str
 * Signature: (JJLjava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_cloog_1input_1read_1from_1isl_1set_1str
  (JNIEnv *, jclass, jlong, jlong, jstring, jstring);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_print
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1print
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_reduction_get_element
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1reduction_1get_1element
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_reduction_get_number_of_elements
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1reduction_1get_1number_1of_1elements
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_binary_get_value
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1binary_1get_1value
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_term_get_value
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1term_1get_1value
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_user_stmt_get_cloog_domain
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1user_1stmt_1get_1cloog_1domain
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_for_get_cloog_domain
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1for_1get_1cloog_1domain
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_for_get_stride
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1for_1get_1stride
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_guard_get_equation
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1guard_1get_1equation
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    clast_guard_get_n
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_clast_1guard_1get_1n
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    get_scalar
 * Signature: (JI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_get_1scalar
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    get_scattering
 * Signature: (JI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_get_1scattering
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    get_parameter
 * Signature: (JI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_get_1parameter
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    get_iterator
 * Signature: (JI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_get_1iterator
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_guard
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1guard
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_for
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1for
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_assignment
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1assignment
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_user_stmt
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1user_1stmt
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_block
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1block
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_root
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1root
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_expr_binary
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1expr_1binary
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_expr_term
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1expr_1term
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_expr_reduction
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1expr_1reduction
  (JNIEnv *, jclass, jlong);

/*
 * Class:     fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules
 * Method:    is_clast_expr_name
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_cloog_jni_CloogNative_00024UserModules_is_1clast_1expr_1name
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
