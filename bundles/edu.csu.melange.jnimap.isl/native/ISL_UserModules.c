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

#include "fr_irisa_cairn_jnimap_isl_jni_ISLNative.h"
#include "fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h"



/**********************************
 ** vertices
 **********************************/
#include "ISLUser_vertices.h"

//vertices . isl_vertices_get_vertex_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1vertices_1get_1vertex_1at
(JNIEnv *env, jclass clazz, jlong vertices, jint pos)
 {
	isl_vertices* vertices_c = (isl_vertices*)GECOS_PTRSIZE vertices;
	int pos_c = (int)pos;
	
	isl_vertex* res = (isl_vertex*) isl_vertices_get_vertex_at(vertices_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//vertices . isl_cell_get_vertex_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1cell_1get_1vertex_1at
(JNIEnv *env, jclass clazz, jlong cell, jint pos)
 {
	isl_cell* cell_c = (isl_cell*)GECOS_PTRSIZE cell;
	int pos_c = (int)pos;
	
	isl_vertex* res = (isl_vertex*) isl_cell_get_vertex_at(cell_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//vertices . isl_vertices_numberof_vertex
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1vertices_1numberof_1vertex
(JNIEnv *env, jclass clazz, jlong vertices)
 {
	isl_vertices* vertices_c = (isl_vertices*)GECOS_PTRSIZE vertices;
	
	int res = (int) isl_vertices_numberof_vertex(vertices_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//vertices . isl_cell_numberof_vertex
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1cell_1numberof_1vertex
(JNIEnv *env, jclass clazz, jlong cell)
 {
	isl_cell* cell_c = (isl_cell*)GECOS_PTRSIZE cell;
	
	int res = (int) isl_cell_numberof_vertex(cell_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
/**********************************
 ** ast
 **********************************/
#include "ISLUser_ast.h"

//ast . isl_ast_node_is_for
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1node_1is_1for
(JNIEnv *env, jclass clazz, jlong node)
 {
	struct isl_ast_node* node_c = (struct isl_ast_node*)GECOS_PTRSIZE node;
	
	int res = (int) isl_ast_node_is_for(node_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//ast . isl_ast_node_is_if
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1node_1is_1if
(JNIEnv *env, jclass clazz, jlong node)
 {
	struct isl_ast_node* node_c = (struct isl_ast_node*)GECOS_PTRSIZE node;
	
	int res = (int) isl_ast_node_is_if(node_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//ast . isl_ast_node_is_block
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1node_1is_1block
(JNIEnv *env, jclass clazz, jlong node)
 {
	struct isl_ast_node* node_c = (struct isl_ast_node*)GECOS_PTRSIZE node;
	
	int res = (int) isl_ast_node_is_block(node_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//ast . isl_ast_node_is_user
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1node_1is_1user
(JNIEnv *env, jclass clazz, jlong node)
 {
	struct isl_ast_node* node_c = (struct isl_ast_node*)GECOS_PTRSIZE node;
	
	int res = (int) isl_ast_node_is_user(node_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//ast . isl_ast_expr_is_id
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1expr_1is_1id
(JNIEnv *env, jclass clazz, jlong e)
 {
	struct isl_ast_expr* e_c = (struct isl_ast_expr*)GECOS_PTRSIZE e;
	
	int res = (int) isl_ast_expr_is_id(e_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//ast . isl_ast_expr_is_operation
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1expr_1is_1operation
(JNIEnv *env, jclass clazz, jlong e)
 {
	struct isl_ast_expr* e_c = (struct isl_ast_expr*)GECOS_PTRSIZE e;
	
	int res = (int) isl_ast_expr_is_operation(e_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//ast . isl_ast_expr_is_literal
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1expr_1is_1literal
(JNIEnv *env, jclass clazz, jlong e)
 {
	struct isl_ast_expr* e_c = (struct isl_ast_expr*)GECOS_PTRSIZE e;
	
	int res = (int) isl_ast_expr_is_literal(e_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//ast . isl_ast_node_user_get_schedule
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1node_1user_1get_1schedule
(JNIEnv *env, jclass clazz, jlong node)
 {
	struct isl_ast_node* node_c = (struct isl_ast_node*)GECOS_PTRSIZE node;
	
	isl_union_map* res = (isl_union_map*) isl_ast_node_user_get_schedule(node_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//ast . isl_ast_node_is_unscanned
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1node_1is_1unscanned
(JNIEnv *env, jclass clazz, jlong node)
 {
	struct isl_ast_node* node_c = (struct isl_ast_node*)GECOS_PTRSIZE node;
	
	int res = (int) isl_ast_node_is_unscanned(node_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
/**********************************
 ** codegen
 **********************************/
#include "ISLUser_codegen.h"

//codegen . isl_ast_build_node_from_schedule_map_EX
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1build_1node_1from_1schedule_1map_1EX
(JNIEnv *env, jclass clazz, jlong build, jlong schedule, jstring exName)
 {
	struct isl_ast_build* build_c = (struct isl_ast_build*)GECOS_PTRSIZE build;
	isl_union_map* schedule_c = (isl_union_map*)GECOS_PTRSIZE schedule;
	char * exName_c = (char *)(*env)->GetStringUTFChars(env,exName,0);
	
	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_build_node_from_schedule_map_EX(build_c, schedule_c, exName_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//codegen . isl_ast_build_node_from_schedule_EX
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1build_1node_1from_1schedule_1EX
(JNIEnv *env, jclass clazz, jlong build, jlong schedule, jstring exName)
 {
	struct isl_ast_build* build_c = (struct isl_ast_build*)GECOS_PTRSIZE build;
	isl_schedule* schedule_c = (isl_schedule*)GECOS_PTRSIZE schedule;
	char * exName_c = (char *)(*env)->GetStringUTFChars(env,exName,0);
	
	struct isl_ast_node* res = (struct isl_ast_node*) isl_ast_build_node_from_schedule_EX(build_c, schedule_c, exName_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
/**********************************
 ** collections
 **********************************/
#include "ISLUser_collections.h"

//collections . isl_basic_set_get_constraint_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1basic_1set_1get_1constraint_1at
(JNIEnv *env, jclass clazz, jlong bset, jint pos)
 {
	isl_basic_set* bset_c = (isl_basic_set*)GECOS_PTRSIZE bset;
	int pos_c = (int)pos;
	
	isl_constraint* res = (isl_constraint*) isl_basic_set_get_constraint_at(bset_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_basic_map_get_constraint_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1basic_1map_1get_1constraint_1at
(JNIEnv *env, jclass clazz, jlong bmap, jint pos)
 {
	isl_basic_map* bmap_c = (isl_basic_map*)GECOS_PTRSIZE bmap;
	int pos_c = (int)pos;
	
	isl_constraint* res = (isl_constraint*) isl_basic_map_get_constraint_at(bmap_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_set_get_basic_set_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1set_1get_1basic_1set_1at
(JNIEnv *env, jclass clazz, jlong set, jint pos)
 {
	isl_set* set_c = (isl_set*)GECOS_PTRSIZE set;
	int pos_c = (int)pos;
	
	isl_basic_set* res = (isl_basic_set*) isl_set_get_basic_set_at(set_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_map_get_basic_map_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1map_1get_1basic_1map_1at
(JNIEnv *env, jclass clazz, jlong map, jint pos)
 {
	isl_map* map_c = (isl_map*)GECOS_PTRSIZE map;
	int pos_c = (int)pos;
	
	isl_basic_map* res = (isl_basic_map*) isl_map_get_basic_map_at(map_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_union_set_get_set_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1set_1get_1set_1at
(JNIEnv *env, jclass clazz, jlong uset, jint pos)
 {
	isl_union_set* uset_c = (isl_union_set*)GECOS_PTRSIZE uset;
	int pos_c = (int)pos;
	
	isl_set* res = (isl_set*) isl_union_set_get_set_at(uset_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_union_map_get_map_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1map_1get_1map_1at
(JNIEnv *env, jclass clazz, jlong umap, jint pos)
 {
	isl_union_map* umap_c = (isl_union_map*)GECOS_PTRSIZE umap;
	int pos_c = (int)pos;
	
	isl_map* res = (isl_map*) isl_union_map_get_map_at(umap_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_basic_map_numberof_constraint
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1basic_1map_1numberof_1constraint
(JNIEnv *env, jclass clazz, jlong bmap)
 {
	isl_basic_map* bmap_c = (isl_basic_map*)GECOS_PTRSIZE bmap;
	
	int res = (int) isl_basic_map_numberof_constraint(bmap_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//collections . isl_map_numberof_basic_map
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1map_1numberof_1basic_1map
(JNIEnv *env, jclass clazz, jlong map)
 {
	isl_map* map_c = (isl_map*)GECOS_PTRSIZE map;
	
	int res = (int) isl_map_numberof_basic_map(map_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//collections . isl_pw_multi_aff_numberof_piece
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1multi_1aff_1numberof_1piece
(JNIEnv *env, jclass clazz, jlong pma)
 {
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*)GECOS_PTRSIZE pma;
	
	int res = (int) isl_pw_multi_aff_numberof_piece(pma_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//collections . isl_pw_multi_aff_get_piece_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1multi_1aff_1get_1piece_1at
(JNIEnv *env, jclass clazz, jlong pma, jint pos)
 {
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*)GECOS_PTRSIZE pma;
	int pos_c = (int)pos;
	
	struct isl_pw_multi_aff_piece* res = (struct isl_pw_multi_aff_piece*) isl_pw_multi_aff_get_piece_at(pma_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_vertices_numberof_cell
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1vertices_1numberof_1cell
(JNIEnv *env, jclass clazz, jlong vertices)
 {
	isl_vertices* vertices_c = (isl_vertices*)GECOS_PTRSIZE vertices;
	
	int res = (int) isl_vertices_numberof_cell(vertices_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//collections . isl_vertices_get_cell_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1vertices_1get_1cell_1at
(JNIEnv *env, jclass clazz, jlong vertices, jint pos)
 {
	isl_vertices* vertices_c = (isl_vertices*)GECOS_PTRSIZE vertices;
	int pos_c = (int)pos;
	
	isl_cell* res = (isl_cell*) isl_vertices_get_cell_at(vertices_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_union_set_numberof_points
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1set_1numberof_1points
(JNIEnv *env, jclass clazz, jlong uset)
 {
	isl_union_set* uset_c = (isl_union_set*)GECOS_PTRSIZE uset;
	
	int res = (int) isl_union_set_numberof_points(uset_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//collections . isl_union_set_get_point_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1set_1get_1point_1at
(JNIEnv *env, jclass clazz, jlong uset, jint pos)
 {
	isl_union_set* uset_c = (isl_union_set*)GECOS_PTRSIZE uset;
	int pos_c = (int)pos;
	
	isl_point* res = (isl_point*) isl_union_set_get_point_at(uset_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//collections . isl_set_numberof_points
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1set_1numberof_1points
(JNIEnv *env, jclass clazz, jlong set)
 {
	isl_set* set_c = (isl_set*)GECOS_PTRSIZE set;
	
	int res = (int) isl_set_numberof_points(set_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//collections . isl_set_get_point_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1set_1get_1point_1at
(JNIEnv *env, jclass clazz, jlong set, jint pos)
 {
	isl_set* set_c = (isl_set*)GECOS_PTRSIZE set;
	int pos_c = (int)pos;
	
	isl_point* res = (isl_point*) isl_set_get_point_at(set_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
/**********************************
 ** scheduling
 **********************************/
#include "ISLUser_scheduling.h"

//scheduling . isl_compute_schedule
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1compute_1schedule
(JNIEnv *env, jclass clazz, jlong ctx, jlong domain, jlong validity, jlong proximity, jint max_coefficient, jint max_constant_term, jint fuse, jint maximize_band_depth, jint outer_coincidence, jint split_scaled, jint algorithm, jint separate_components)
 {
	isl_ctx* ctx_c = (isl_ctx*)GECOS_PTRSIZE ctx;
	isl_union_set* domain_c = (isl_union_set*)GECOS_PTRSIZE domain;
	isl_union_map* validity_c = (isl_union_map*)GECOS_PTRSIZE validity;
	isl_union_map* proximity_c = (isl_union_map*)GECOS_PTRSIZE proximity;
	int max_coefficient_c = (int)max_coefficient;
	int max_constant_term_c = (int)max_constant_term;
	int fuse_c = (int)fuse;
	int maximize_band_depth_c = (int)maximize_band_depth;
	int outer_coincidence_c = (int)outer_coincidence;
	int split_scaled_c = (int)split_scaled;
	int algorithm_c = (int)algorithm;
	int separate_components_c = (int)separate_components;
	
	isl_schedule* res = (isl_schedule*) isl_compute_schedule(ctx_c, domain_c, validity_c, proximity_c, max_coefficient_c, max_constant_term_c, fuse_c, maximize_band_depth_c, outer_coincidence_c, split_scaled_c, algorithm_c, separate_components_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
/**********************************
 ** dataflow
 **********************************/
#include "ISLUser_dataflow.h"

//dataflow . compute_ADA
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_compute_1ADA
(JNIEnv *env, jclass clazz, jlong domains, jlong writes, jlong reads, jlong idSchedule, jint memoryBased)
 {
	isl_union_set* domains_c = (isl_union_set*)GECOS_PTRSIZE domains;
	isl_union_map* writes_c = (isl_union_map*)GECOS_PTRSIZE writes;
	isl_union_map* reads_c = (isl_union_map*)GECOS_PTRSIZE reads;
	isl_union_map* idSchedule_c = (isl_union_map*)GECOS_PTRSIZE idSchedule;
	int memoryBased_c = (int)memoryBased;
	
	isl_union_map* res = (isl_union_map*) compute_ADA(domains_c, writes_c, reads_c, idSchedule_c, memoryBased_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//dataflow . compute_ADA_custom
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_compute_1ADA_1custom
(JNIEnv *env, jclass clazz, jlong domains, jlong writes, jlong reads, jlong idSchedule, jint RAW, jint WAW, jint WAR)
 {
	isl_union_set* domains_c = (isl_union_set*)GECOS_PTRSIZE domains;
	isl_union_map* writes_c = (isl_union_map*)GECOS_PTRSIZE writes;
	isl_union_map* reads_c = (isl_union_map*)GECOS_PTRSIZE reads;
	isl_union_map* idSchedule_c = (isl_union_map*)GECOS_PTRSIZE idSchedule;
	int RAW_c = (int)RAW;
	int WAW_c = (int)WAW;
	int WAR_c = (int)WAR;
	
	isl_union_map* res = (isl_union_map*) compute_ADA_custom(domains_c, writes_c, reads_c, idSchedule_c, RAW_c, WAW_c, WAR_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//dataflow . compute_ADA_custom_rar
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_compute_1ADA_1custom_1rar
(JNIEnv *env, jclass clazz, jlong domains, jlong writes, jlong reads, jlong idSchedule, jint RAW, jint WAW, jint WAR, jint RAR)
 {
	isl_union_set* domains_c = (isl_union_set*)GECOS_PTRSIZE domains;
	isl_union_map* writes_c = (isl_union_map*)GECOS_PTRSIZE writes;
	isl_union_map* reads_c = (isl_union_map*)GECOS_PTRSIZE reads;
	isl_union_map* idSchedule_c = (isl_union_map*)GECOS_PTRSIZE idSchedule;
	int RAW_c = (int)RAW;
	int WAW_c = (int)WAW;
	int WAR_c = (int)WAR;
	int RAR_c = (int)RAR;
	
	isl_union_map* res = (isl_union_map*) compute_ADA_custom_rar(domains_c, writes_c, reads_c, idSchedule_c, RAW_c, WAW_c, WAR_c, RAR_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//dataflow . alloc_dataflow_analysis
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_alloc_1dataflow_1analysis
(JNIEnv *env, jclass clazz)
 {
	
	struct isl_dataflow_analysis* res = (struct isl_dataflow_analysis*) alloc_dataflow_analysis();

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//dataflow . isl_array_dataflow_analysis
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1array_1dataflow_1analysis
(JNIEnv *env, jclass clazz, jlong sink, jlong must_source, jlong may_source, jlong schedule)
 {
	isl_union_map* sink_c = (isl_union_map*)GECOS_PTRSIZE sink;
	isl_union_map* must_source_c = (isl_union_map*)GECOS_PTRSIZE must_source;
	isl_union_map* may_source_c = (isl_union_map*)GECOS_PTRSIZE may_source;
	isl_union_map* schedule_c = (isl_union_map*)GECOS_PTRSIZE schedule;
	
	struct isl_dataflow_analysis* res = (struct isl_dataflow_analysis*) isl_array_dataflow_analysis(sink_c, must_source_c, may_source_c, schedule_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
/**********************************
 ** tostring
 **********************************/
#include "ISLUser_tostring.h"

//tostring . isl_val_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1val_1to_1string
(JNIEnv *env, jclass clazz, jlong val, jint format)
 {
	isl_val* val_c = (isl_val*)GECOS_PTRSIZE val;
	int format_c = (int)format;
	
	char * res = (char *) isl_val_to_string(val_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_multi_val_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1multi_1val_1to_1string
(JNIEnv *env, jclass clazz, jlong mv, jint format)
 {
	isl_multi_val* mv_c = (isl_multi_val*)GECOS_PTRSIZE mv;
	int format_c = (int)format;
	
	char * res = (char *) isl_multi_val_to_string(mv_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_val_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1val_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong vlist, jint format)
 {
	isl_val_list* vlist_c = (isl_val_list*)GECOS_PTRSIZE vlist;
	int format_c = (int)format;
	
	char * res = (char *) isl_val_list_to_string(vlist_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_id_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1id_1to_1string
(JNIEnv *env, jclass clazz, jlong id, jint format)
 {
	isl_id* id_c = (isl_id*)GECOS_PTRSIZE id;
	int format_c = (int)format;
	
	char * res = (char *) isl_id_to_string(id_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_id_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1id_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong idlist, jint format)
 {
	isl_id_list* idlist_c = (isl_id_list*)GECOS_PTRSIZE idlist;
	int format_c = (int)format;
	
	char * res = (char *) isl_id_list_to_string(idlist_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_basic_set_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1basic_1set_1to_1string
(JNIEnv *env, jclass clazz, jlong bset, jint format)
 {
	isl_basic_set* bset_c = (isl_basic_set*)GECOS_PTRSIZE bset;
	int format_c = (int)format;
	
	char * res = (char *) isl_basic_set_to_string(bset_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_set_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1set_1to_1string
(JNIEnv *env, jclass clazz, jlong set, jint format)
 {
	isl_set* set_c = (isl_set*)GECOS_PTRSIZE set;
	int format_c = (int)format;
	
	char * res = (char *) isl_set_to_string(set_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_union_set_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1set_1to_1string
(JNIEnv *env, jclass clazz, jlong set, jint format)
 {
	isl_union_set* set_c = (isl_union_set*)GECOS_PTRSIZE set;
	int format_c = (int)format;
	
	char * res = (char *) isl_union_set_to_string(set_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_basic_set_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1basic_1set_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong bsetlist, jint format)
 {
	isl_basic_set_list* bsetlist_c = (isl_basic_set_list*)GECOS_PTRSIZE bsetlist;
	int format_c = (int)format;
	
	char * res = (char *) isl_basic_set_list_to_string(bsetlist_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_set_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1set_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong setlist, jint format)
 {
	isl_set_list* setlist_c = (isl_set_list*)GECOS_PTRSIZE setlist;
	int format_c = (int)format;
	
	char * res = (char *) isl_set_list_to_string(setlist_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_basic_map_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1basic_1map_1to_1string
(JNIEnv *env, jclass clazz, jlong map, jint format)
 {
	isl_basic_map* map_c = (isl_basic_map*)GECOS_PTRSIZE map;
	int format_c = (int)format;
	
	char * res = (char *) isl_basic_map_to_string(map_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_map_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1map_1to_1string
(JNIEnv *env, jclass clazz, jlong map, jint format)
 {
	isl_map* map_c = (isl_map*)GECOS_PTRSIZE map;
	int format_c = (int)format;
	
	char * res = (char *) isl_map_to_string(map_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_union_map_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1map_1to_1string
(JNIEnv *env, jclass clazz, jlong map, jint format)
 {
	isl_union_map* map_c = (isl_union_map*)GECOS_PTRSIZE map;
	int format_c = (int)format;
	
	char * res = (char *) isl_union_map_to_string(map_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_aff_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1aff_1to_1string
(JNIEnv *env, jclass clazz, jlong aff, jint format)
 {
	isl_aff* aff_c = (isl_aff*)GECOS_PTRSIZE aff;
	int format_c = (int)format;
	
	char * res = (char *) isl_aff_to_string(aff_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_aff_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1aff_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong afflist, jint format)
 {
	isl_aff_list* afflist_c = (isl_aff_list*)GECOS_PTRSIZE afflist;
	int format_c = (int)format;
	
	char * res = (char *) isl_aff_list_to_string(afflist_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_multi_aff_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1multi_1aff_1to_1string
(JNIEnv *env, jclass clazz, jlong maff, jint format)
 {
	isl_multi_aff* maff_c = (isl_multi_aff*)GECOS_PTRSIZE maff;
	int format_c = (int)format;
	
	char * res = (char *) isl_multi_aff_to_string(maff_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_pw_aff_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1aff_1to_1string
(JNIEnv *env, jclass clazz, jlong pwa, jint format)
 {
	isl_pw_aff* pwa_c = (isl_pw_aff*)GECOS_PTRSIZE pwa;
	int format_c = (int)format;
	
	char * res = (char *) isl_pw_aff_to_string(pwa_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_pw_aff_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1aff_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong pwalist, jint format)
 {
	isl_pw_aff_list* pwalist_c = (isl_pw_aff_list*)GECOS_PTRSIZE pwalist;
	int format_c = (int)format;
	
	char * res = (char *) isl_pw_aff_list_to_string(pwalist_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_multi_pw_aff_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1multi_1pw_1aff_1to_1string
(JNIEnv *env, jclass clazz, jlong mpa, jint format)
 {
	isl_multi_pw_aff* mpa_c = (isl_multi_pw_aff*)GECOS_PTRSIZE mpa;
	int format_c = (int)format;
	
	char * res = (char *) isl_multi_pw_aff_to_string(mpa_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_pw_multi_aff_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1multi_1aff_1to_1string
(JNIEnv *env, jclass clazz, jlong pma, jint format)
 {
	isl_pw_multi_aff* pma_c = (isl_pw_multi_aff*)GECOS_PTRSIZE pma;
	int format_c = (int)format;
	
	char * res = (char *) isl_pw_multi_aff_to_string(pma_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_union_pw_multi_aff_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1pw_1multi_1aff_1to_1string
(JNIEnv *env, jclass clazz, jlong upma, jint format)
 {
	isl_union_pw_multi_aff* upma_c = (isl_union_pw_multi_aff*)GECOS_PTRSIZE upma;
	int format_c = (int)format;
	
	char * res = (char *) isl_union_pw_multi_aff_to_string(upma_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_constraint_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1constraint_1to_1string
(JNIEnv *env, jclass clazz, jlong constraint, jint format)
 {
	isl_constraint* constraint_c = (isl_constraint*)GECOS_PTRSIZE constraint;
	int format_c = (int)format;
	
	char * res = (char *) isl_constraint_to_string(constraint_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_constraint_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1constraint_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong constraintlist, jint format)
 {
	isl_constraint_list* constraintlist_c = (isl_constraint_list*)GECOS_PTRSIZE constraintlist;
	int format_c = (int)format;
	
	char * res = (char *) isl_constraint_list_to_string(constraintlist_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_ast_node_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1node_1to_1string
(JNIEnv *env, jclass clazz, jlong node)
 {
	struct isl_ast_node* node_c = (struct isl_ast_node*)GECOS_PTRSIZE node;
	
	char * res = (char *) isl_ast_node_to_string(node_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_ast_expr_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1expr_1to_1string
(JNIEnv *env, jclass clazz, jlong expr)
 {
	struct isl_ast_expr* expr_c = (struct isl_ast_expr*)GECOS_PTRSIZE expr;
	
	char * res = (char *) isl_ast_expr_to_string(expr_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_ast_node_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1node_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong node)
 {
	struct isl_ast_node_list* node_c = (struct isl_ast_node_list*)GECOS_PTRSIZE node;
	
	char * res = (char *) isl_ast_node_list_to_string(node_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_ast_expr_list_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1ast_1expr_1list_1to_1string
(JNIEnv *env, jclass clazz, jlong expr)
 {
	struct isl_ast_expr_list* expr_c = (struct isl_ast_expr_list*)GECOS_PTRSIZE expr;
	
	char * res = (char *) isl_ast_expr_list_to_string(expr_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_qpolynomial_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1qpolynomial_1to_1string
(JNIEnv *env, jclass clazz, jlong qp, jint format)
 {
	isl_qpolynomial* qp_c = (isl_qpolynomial*)GECOS_PTRSIZE qp;
	int format_c = (int)format;
	
	char * res = (char *) isl_qpolynomial_to_string(qp_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_qpolynomial_fold_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1qpolynomial_1fold_1to_1string
(JNIEnv *env, jclass clazz, jlong qpf, jint format)
 {
	isl_qpolynomial_fold* qpf_c = (isl_qpolynomial_fold*)GECOS_PTRSIZE qpf;
	int format_c = (int)format;
	
	char * res = (char *) isl_qpolynomial_fold_to_string(qpf_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_pw_qpolynomial_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1to_1string
(JNIEnv *env, jclass clazz, jlong set, jint format)
 {
	isl_pw_qpolynomial* set_c = (isl_pw_qpolynomial*)GECOS_PTRSIZE set;
	int format_c = (int)format;
	
	char * res = (char *) isl_pw_qpolynomial_to_string(set_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_pw_qpolynomial_fold_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1fold_1to_1string
(JNIEnv *env, jclass clazz, jlong pwqpf, jint format)
 {
	isl_pw_qpolynomial_fold* pwqpf_c = (isl_pw_qpolynomial_fold*)GECOS_PTRSIZE pwqpf;
	int format_c = (int)format;
	
	char * res = (char *) isl_pw_qpolynomial_fold_to_string(pwqpf_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_union_pw_qpolynomial_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1pw_1qpolynomial_1to_1string
(JNIEnv *env, jclass clazz, jlong upwqp, jint format)
 {
	isl_union_pw_qpolynomial* upwqp_c = (isl_union_pw_qpolynomial*)GECOS_PTRSIZE upwqp;
	int format_c = (int)format;
	
	char * res = (char *) isl_union_pw_qpolynomial_to_string(upwqp_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_union_pw_qpolynomial_fold_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1union_1pw_1qpolynomial_1fold_1to_1string
(JNIEnv *env, jclass clazz, jlong upwqpf, jint format)
 {
	isl_union_pw_qpolynomial_fold* upwqpf_c = (isl_union_pw_qpolynomial_fold*)GECOS_PTRSIZE upwqpf;
	int format_c = (int)format;
	
	char * res = (char *) isl_union_pw_qpolynomial_fold_to_string(upwqpf_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//tostring . isl_schedule_to_string
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1schedule_1to_1string
(JNIEnv *env, jclass clazz, jlong s, jint format)
 {
	isl_schedule* s_c = (isl_schedule*)GECOS_PTRSIZE s;
	int format_c = (int)format;
	
	char * res = (char *) isl_schedule_to_string(s_c, format_c);

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
/**********************************
 ** lexnext
 **********************************/
#include "ISLUser_lexnext.h"

//lexnext . lex_next
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_lex_1next
(JNIEnv *env, jclass clazz, jlong dom, jint nbInnerLoop)
 {
	isl_set* dom_c = (isl_set*)GECOS_PTRSIZE dom;
	int nbInnerLoop_c = (int)nbInnerLoop;
	
	isl_map* res = (isl_map*) lex_next(dom_c, nbInnerLoop_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//lexnext . lex_next_power
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_lex_1next_1power
(JNIEnv *env, jclass clazz, jlong dom, jint nbInnerLoop, jint power)
 {
	isl_set* dom_c = (isl_set*)GECOS_PTRSIZE dom;
	int nbInnerLoop_c = (int)nbInnerLoop;
	int power_c = (int)power;
	
	isl_map* res = (isl_map*) lex_next_power(dom_c, nbInnerLoop_c, power_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
/**********************************
 ** lexpred
 **********************************/
#include "ISLUser_lexpred.h"

//lexpred . lex_pred
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_lex_1pred
(JNIEnv *env, jclass clazz, jlong dom, jint nbInnerLoop)
 {
	isl_set* dom_c = (isl_set*)GECOS_PTRSIZE dom;
	int nbInnerLoop_c = (int)nbInnerLoop;
	
	isl_map* res = (isl_map*) lex_pred(dom_c, nbInnerLoop_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//lexpred . lex_pred_power
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_lex_1pred_1power
(JNIEnv *env, jclass clazz, jlong dom, jint nbInnerLoop, jint power)
 {
	isl_set* dom_c = (isl_set*)GECOS_PTRSIZE dom;
	int nbInnerLoop_c = (int)nbInnerLoop;
	int power_c = (int)power;
	
	isl_map* res = (isl_map*) lex_pred_power(dom_c, nbInnerLoop_c, power_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
/**********************************
 ** misc
 **********************************/
#include "ISLUser_misc.h"

//misc . init_isl_error_handler
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_init_1isl_1error_1handler
(JNIEnv *env, jclass clazz)
 {
	
	 init_isl_error_handler();
error:
	return;
}
//misc . clear_tuple_name
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_clear_1tuple_1name
(JNIEnv *env, jclass clazz, jlong s)
 {
	isl_set* s_c = (isl_set*)GECOS_PTRSIZE s;
	
	isl_set* res = (isl_set*) clear_tuple_name(s_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//misc . clear_in_tuple_name
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_clear_1in_1tuple_1name
(JNIEnv *env, jclass clazz, jlong m)
 {
	isl_map* m_c = (isl_map*)GECOS_PTRSIZE m;
	
	isl_map* res = (isl_map*) clear_in_tuple_name(m_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//misc . clear_out_tuple_name
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_clear_1out_1tuple_1name
(JNIEnv *env, jclass clazz, jlong m)
 {
	isl_map* m_c = (isl_map*)GECOS_PTRSIZE m;
	
	isl_map* res = (isl_map*) clear_out_tuple_name(m_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
/**********************************
 ** polynomial
 **********************************/
#include "ISLUser_polynomial.h"

//polynomial . isl_qpolynomial_get_exp_at
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1qpolynomial_1get_1exp_1at
(JNIEnv *env, jclass clazz, jlong qp, jint termPos, jint type, jint dim)
 {
	isl_qpolynomial* qp_c = (isl_qpolynomial*)GECOS_PTRSIZE qp;
	int termPos_c = (int)termPos;
	enum isl_dim_type type_c = (enum isl_dim_type)type;
	unsigned int dim_c = (unsigned int)dim;
	
	int res = (int) isl_qpolynomial_get_exp_at(qp_c, termPos_c, type_c, dim_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//polynomial . isl_qpolynomial_numberof_terms
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1qpolynomial_1numberof_1terms
(JNIEnv *env, jclass clazz, jlong qp)
 {
	isl_qpolynomial* qp_c = (isl_qpolynomial*)GECOS_PTRSIZE qp;
	
	int res = (int) isl_qpolynomial_numberof_terms(qp_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//polynomial . isl_qpolynomial_get_term_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1qpolynomial_1get_1term_1at
(JNIEnv *env, jclass clazz, jlong qp, jint pos)
 {
	isl_qpolynomial* qp_c = (isl_qpolynomial*)GECOS_PTRSIZE qp;
	int pos_c = (int)pos;
	
	isl_term* res = (isl_term*) isl_qpolynomial_get_term_at(qp_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//polynomial . isl_pw_qpolynomial_numberof_piece
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1numberof_1piece
(JNIEnv *env, jclass clazz, jlong pwqp)
 {
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*)GECOS_PTRSIZE pwqp;
	
	int res = (int) isl_pw_qpolynomial_numberof_piece(pwqp_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//polynomial . isl_pw_qpolynomial_get_piece_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1get_1piece_1at
(JNIEnv *env, jclass clazz, jlong pwqp, jint pos)
 {
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*)GECOS_PTRSIZE pwqp;
	int pos_c = (int)pos;
	
	struct isl_qpolynomial_piece* res = (struct isl_qpolynomial_piece*) isl_pw_qpolynomial_get_piece_at(pwqp_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//polynomial . isl_pw_qpolynomial_numberof_lifted_piece
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1numberof_1lifted_1piece
(JNIEnv *env, jclass clazz, jlong pwqp)
 {
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*)GECOS_PTRSIZE pwqp;
	
	int res = (int) isl_pw_qpolynomial_numberof_lifted_piece(pwqp_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//polynomial . isl_pw_qpolynomial_get_lifted_piece_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1get_1lifted_1piece_1at
(JNIEnv *env, jclass clazz, jlong pwqp, jint pos)
 {
	isl_pw_qpolynomial* pwqp_c = (isl_pw_qpolynomial*)GECOS_PTRSIZE pwqp;
	int pos_c = (int)pos;
	
	struct isl_qpolynomial_piece* res = (struct isl_qpolynomial_piece*) isl_pw_qpolynomial_get_lifted_piece_at(pwqp_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//polynomial . isl_qpolynomial_fold_number_of_qpolynomial
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1qpolynomial_1fold_1number_1of_1qpolynomial
(JNIEnv *env, jclass clazz, jlong fold)
 {
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*)GECOS_PTRSIZE fold;
	
	int res = (int) isl_qpolynomial_fold_number_of_qpolynomial(fold_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//polynomial . isl_qpolynomial_fold_get_qpolynomial_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1qpolynomial_1fold_1get_1qpolynomial_1at
(JNIEnv *env, jclass clazz, jlong fold, jint pos)
 {
	isl_qpolynomial_fold* fold_c = (isl_qpolynomial_fold*)GECOS_PTRSIZE fold;
	int pos_c = (int)pos;
	
	isl_qpolynomial* res = (isl_qpolynomial*) isl_qpolynomial_fold_get_qpolynomial_at(fold_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//polynomial . isl_pw_qpolynomial_fold_numberof_piece
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1fold_1numberof_1piece
(JNIEnv *env, jclass clazz, jlong pwf)
 {
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*)GECOS_PTRSIZE pwf;
	
	int res = (int) isl_pw_qpolynomial_fold_numberof_piece(pwf_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//polynomial . isl_pw_qpolynomial_fold_get_piece_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1fold_1get_1piece_1at
(JNIEnv *env, jclass clazz, jlong pwf, jint pos)
 {
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*)GECOS_PTRSIZE pwf;
	int pos_c = (int)pos;
	
	struct isl_qpolynomial_fold_piece* res = (struct isl_qpolynomial_fold_piece*) isl_pw_qpolynomial_fold_get_piece_at(pwf_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
//polynomial . isl_pw_qpolynomial_fold_numberof_lifted_piece
JNIEXPORT jint JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1fold_1numberof_1lifted_1piece
(JNIEnv *env, jclass clazz, jlong pwf)
 {
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*)GECOS_PTRSIZE pwf;
	
	int res = (int) isl_pw_qpolynomial_fold_numberof_lifted_piece(pwf_c);

	return (jint)  res;
error:
	return  (jint) GECOS_PTRSIZE NULL;
}
//polynomial . isl_pw_qpolynomial_fold_get_lifted_piece_at
JNIEXPORT jlong JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_isl_1pw_1qpolynomial_1fold_1get_1lifted_1piece_1at
(JNIEnv *env, jclass clazz, jlong pwf, jint pos)
 {
	isl_pw_qpolynomial_fold* pwf_c = (isl_pw_qpolynomial_fold*)GECOS_PTRSIZE pwf;
	int pos_c = (int)pos;
	
	struct isl_qpolynomial_fold_piece* res = (struct isl_qpolynomial_fold_piece*) isl_pw_qpolynomial_fold_get_lifted_piece_at(pwf_c, pos_c);

	return (jlong) GECOS_PTRSIZE res;
error:
	return  (jlong) GECOS_PTRSIZE NULL;
}
/**********************************
 ** stdio
 **********************************/
#include "ISLUser_stdio.h"

//stdio . record_stdout_start
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_record_1stdout_1start
(JNIEnv *env, jclass clazz)
 {
	
	 record_stdout_start();
error:
	return;
}
//stdio . record_stdout_end
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_record_1stdout_1end
(JNIEnv *env, jclass clazz)
 {
	
	char * res = (char *) record_stdout_end();

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
//stdio . record_stderr_start
JNIEXPORT void JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_record_1stderr_1start
(JNIEnv *env, jclass clazz)
 {
	
	 record_stderr_start();
error:
	return;
}
//stdio . record_stderr_end
JNIEXPORT jstring JNICALL Java_fr_irisa_cairn_jnimap_isl_jni_ISLNative_00024UserModules_record_1stderr_1end
(JNIEnv *env, jclass clazz)
 {
	
	char * res = (char *) record_stderr_end();

	return (*env)->NewStringUTF(env, res);

error:
	return (jstring) GECOS_PTRSIZE NULL;
}
