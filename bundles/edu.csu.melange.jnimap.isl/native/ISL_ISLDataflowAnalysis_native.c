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

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1get_1must_1dep
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_must_dep_getter) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMust_dep");
	return (jlong) GECOS_PTRSIZE isl_union_map_copy(stPtr->must_dep);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_dataflow_analysis_1set_1must_1dep
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_must_dep_setter) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setMust_dep");
	stPtr->must_dep= (isl_union_map*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1test_1must_1dep
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_must_dep_tester) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMust_dep");
	return (GECOS_PTRSIZE isl_union_map_copy(stPtr->must_dep)) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1get_1may_1dep
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_may_dep_getter) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMay_dep");
	return (jlong) GECOS_PTRSIZE isl_union_map_copy(stPtr->may_dep);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_dataflow_analysis_1set_1may_1dep
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_may_dep_setter) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setMay_dep");
	stPtr->may_dep= (isl_union_map*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1test_1may_1dep
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_may_dep_tester) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMay_dep");
	return (GECOS_PTRSIZE isl_union_map_copy(stPtr->may_dep)) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1get_1must_1no_1source
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_must_no_source_getter) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMust_no_source");
	return (jlong) GECOS_PTRSIZE isl_union_map_copy(stPtr->must_no_source);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_dataflow_analysis_1set_1must_1no_1source
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_must_no_source_setter) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setMust_no_source");
	stPtr->must_no_source= (isl_union_map*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1test_1must_1no_1source
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_must_no_source_tester) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMust_no_source");
	return (GECOS_PTRSIZE isl_union_map_copy(stPtr->must_no_source)) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}

JNIEXPORT jlong JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1get_1may_1no_1source
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_may_no_source_getter) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMay_no_source");
	return (jlong) GECOS_PTRSIZE isl_union_map_copy(stPtr->may_no_source);
	/* PROTECTED REGION END */
}

JNIEXPORT void JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_dataflow_analysis_1set_1may_1no_1source
	(JNIEnv *env, jclass class, jlong ptr, jlong value) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_may_no_source_setter) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in setMay_no_source");
	stPtr->may_no_source= (isl_union_map*) GECOS_PTRSIZE value;
	/* PROTECTED REGION END */
}

JNIEXPORT jint JNICALL
Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1test_1may_1no_1source
	(JNIEnv *env, jclass class, jlong ptr) {
	/* PROTECTED REGION ID(isl_dataflow_analysis_may_no_source_tester) DISABLED START */
	struct isl_dataflow_analysis* stPtr = (struct isl_dataflow_analysis *) GECOS_PTRSIZE ptr;
	if(stPtr==NULL)
		throwException(env, "Null Pointer in getMay_no_source");
	return (GECOS_PTRSIZE isl_union_map_copy(stPtr->may_no_source)) != (GECOS_PTRSIZE NULL);
	/* PROTECTED REGION END */
}


JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1array_1dataflow_1analysis
(JNIEnv *env, jclass class, jlong sink, jlong must_source, jlong may_source, jlong identity_schedule)
 {
#ifdef TRACE_ALL
	printf("Entering isl_array_dataflow_analysis\n");fflush(stdout);
#endif
	isl_union_map* sink_c = (isl_union_map*) GECOS_PTRSIZE sink; 
	if(((void*)sink_c)==NULL) {
		throwException(env, "Null pointer in isl_array_dataflow_analysis for parameter sink");
		goto error;
	}
	isl_union_map* must_source_c = (isl_union_map*) GECOS_PTRSIZE must_source; 
	if(((void*)must_source_c)==NULL) {
		throwException(env, "Null pointer in isl_array_dataflow_analysis for parameter must_source");
		goto error;
	}
	isl_union_map* may_source_c = (isl_union_map*) GECOS_PTRSIZE may_source; 
	if(((void*)may_source_c)==NULL) {
		throwException(env, "Null pointer in isl_array_dataflow_analysis for parameter may_source");
		goto error;
	}
	isl_union_map* identity_schedule_c = (isl_union_map*) GECOS_PTRSIZE identity_schedule; 
	if(((void*)identity_schedule_c)==NULL) {
		throwException(env, "Null pointer in isl_array_dataflow_analysis for parameter identity_schedule");
		goto error;
	}

	struct isl_dataflow_analysis* res = (struct isl_dataflow_analysis*) isl_array_dataflow_analysis(sink_c, must_source_c, may_source_c, identity_schedule_c);


#ifdef TRACE_ALL
	printf("Leaving isl_array_dataflow_analysis\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_isl_1dataflow_1analysis_1free
(JNIEnv *env, jclass class, jlong dfa)
 {
#ifdef TRACE_ALL
	printf("Entering isl_dataflow_analysis_free\n");fflush(stdout);
#endif
	struct isl_dataflow_analysis* dfa_c = (struct isl_dataflow_analysis*) GECOS_PTRSIZE dfa; 
	if(((void*)dfa_c)==NULL) {
		throwException(env, "Null pointer in isl_dataflow_analysis_free for parameter dfa");
		goto error;
	}

	 isl_dataflow_analysis_free(dfa_c);


#ifdef TRACE_ALL
	printf("Leaving isl_dataflow_analysis_free\n");fflush(stdout);
#endif
	
error:
	return;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_compute_1ADA
(JNIEnv *env, jclass class, jlong domains, jlong writes, jlong reads, jlong idSchedule, jint memoryBased)
 {
#ifdef TRACE_ALL
	printf("Entering compute_ADA\n");fflush(stdout);
#endif
	isl_union_set* domains_c = (isl_union_set*) GECOS_PTRSIZE domains; 
	if(((void*)domains_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA for parameter domains");
		goto error;
	}
	isl_union_map* writes_c = (isl_union_map*) GECOS_PTRSIZE writes; 
	if(((void*)writes_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA for parameter writes");
		goto error;
	}
	isl_union_map* reads_c = (isl_union_map*) GECOS_PTRSIZE reads; 
	if(((void*)reads_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA for parameter reads");
		goto error;
	}
	isl_union_map* idSchedule_c = (isl_union_map*) GECOS_PTRSIZE idSchedule; 
	if(((void*)idSchedule_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA for parameter idSchedule");
		goto error;
	}
	int memoryBased_c = (int) memoryBased;

	isl_union_map* res = (isl_union_map*) compute_ADA(domains_c, writes_c, reads_c, idSchedule_c, memoryBased_c);


#ifdef TRACE_ALL
	printf("Leaving compute_ADA\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_compute_1ADA_1custom
(JNIEnv *env, jclass class, jlong domains, jlong writes, jlong reads, jlong idSchedule, jint RAW, jint WAW, jint WAR)
 {
#ifdef TRACE_ALL
	printf("Entering compute_ADA_custom\n");fflush(stdout);
#endif
	isl_union_set* domains_c = (isl_union_set*) GECOS_PTRSIZE domains; 
	if(((void*)domains_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA_custom for parameter domains");
		goto error;
	}
	isl_union_map* writes_c = (isl_union_map*) GECOS_PTRSIZE writes; 
	if(((void*)writes_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA_custom for parameter writes");
		goto error;
	}
	isl_union_map* reads_c = (isl_union_map*) GECOS_PTRSIZE reads; 
	if(((void*)reads_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA_custom for parameter reads");
		goto error;
	}
	isl_union_map* idSchedule_c = (isl_union_map*) GECOS_PTRSIZE idSchedule; 
	if(((void*)idSchedule_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA_custom for parameter idSchedule");
		goto error;
	}
	int RAW_c = (int) RAW;
	int WAW_c = (int) WAW;
	int WAR_c = (int) WAR;

	isl_union_map* res = (isl_union_map*) compute_ADA_custom(domains_c, writes_c, reads_c, idSchedule_c, RAW_c, WAW_c, WAR_c);


#ifdef TRACE_ALL
	printf("Leaving compute_ADA_custom\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_compute_1ADA_1custom_1rar
(JNIEnv *env, jclass class, jlong domains, jlong writes, jlong reads, jlong idSchedule, jint RAW, jint WAW, jint WAR, jint RAR)
 {
#ifdef TRACE_ALL
	printf("Entering compute_ADA_custom_rar\n");fflush(stdout);
#endif
	isl_union_set* domains_c = (isl_union_set*) GECOS_PTRSIZE domains; 
	if(((void*)domains_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA_custom_rar for parameter domains");
		goto error;
	}
	isl_union_map* writes_c = (isl_union_map*) GECOS_PTRSIZE writes; 
	if(((void*)writes_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA_custom_rar for parameter writes");
		goto error;
	}
	isl_union_map* reads_c = (isl_union_map*) GECOS_PTRSIZE reads; 
	if(((void*)reads_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA_custom_rar for parameter reads");
		goto error;
	}
	isl_union_map* idSchedule_c = (isl_union_map*) GECOS_PTRSIZE idSchedule; 
	if(((void*)idSchedule_c)==NULL) {
		throwException(env, "Null pointer in compute_ADA_custom_rar for parameter idSchedule");
		goto error;
	}
	int RAW_c = (int) RAW;
	int WAW_c = (int) WAW;
	int WAR_c = (int) WAR;
	int RAR_c = (int) RAR;

	isl_union_map* res = (isl_union_map*) compute_ADA_custom_rar(domains_c, writes_c, reads_c, idSchedule_c, RAW_c, WAW_c, WAR_c, RAR_c);


#ifdef TRACE_ALL
	printf("Leaving compute_ADA_custom_rar\n");fflush(stdout);
#endif
	

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}


