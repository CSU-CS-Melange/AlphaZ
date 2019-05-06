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

/* PROTECTED REGION ID(ISLUser_scheduling_header) ENABLED START */
 /* Custom includes for this module */
 struct isl_scheduling_options {
	//XXX before isl-0.15
//	int max_coefficient;
//	int max_constant_term;
//	int fuse;
//	int maximize_band_depth;
//	int outer_zero_distance;
//	int split_scaled;
//	int algorithm;
//	int separate_components;

	 // starting from isl-0.15
	int max_coefficient     ;
	int max_constant_term   ;
	int maximize_band_depth ;
	int maximize_coincidence;
	int outer_coincidence   ;
	int split_scaled        ;
	int treat_coalescing    ;
	int separate_components ;
	int serialize_sccs      ;
	int whole_component     ;
};
/* PROTECTED REGION END */

isl_schedule* isl_compute_schedule(isl_ctx* ctx, isl_union_set* domain, isl_union_map* validity, isl_union_map* proximity, int max_coefficient, int max_constant_term, int fuse, int maximize_band_depth, int outer_coincidence, int split_scaled, int algorithm, int separate_components);
