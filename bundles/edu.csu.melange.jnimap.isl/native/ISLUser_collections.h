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

/* PROTECTED REGION ID(ISLUser_collections_header) ENABLED START */
	 /* Custom includes for this module */
#include "ISL_CallbackMacros.h"
struct isl_pw_multi_aff_piece {
	isl_set* set;
	isl_multi_aff* maff;
};

void isl_pw_multi_aff_piece_free(struct isl_pw_multi_aff_piece* pmap);
/* PROTECTED REGION END */

isl_constraint* isl_basic_set_get_constraint_at(isl_basic_set* bset, int pos);
isl_constraint* isl_basic_map_get_constraint_at(isl_basic_map* bmap, int pos);
isl_basic_set* isl_set_get_basic_set_at(isl_set* set, int pos);
isl_basic_map* isl_map_get_basic_map_at(isl_map* map, int pos);
isl_set* isl_union_set_get_set_at(isl_union_set* uset, int pos);
isl_map* isl_union_map_get_map_at(isl_union_map* umap, int pos);
int isl_basic_map_numberof_constraint(isl_basic_map* bmap);
int isl_map_numberof_basic_map(isl_map* map);
int isl_pw_multi_aff_numberof_piece(isl_pw_multi_aff* pma);
struct isl_pw_multi_aff_piece* isl_pw_multi_aff_get_piece_at(isl_pw_multi_aff* pma, int pos);
int isl_vertices_numberof_cell(isl_vertices* vertices);
isl_cell* isl_vertices_get_cell_at(isl_vertices* vertices, int pos);
int isl_union_set_numberof_points(isl_union_set* uset);
isl_point* isl_union_set_get_point_at(isl_union_set* uset, int pos);
int isl_set_numberof_points(isl_set* set);
isl_point* isl_set_get_point_at(isl_set* set, int pos);
