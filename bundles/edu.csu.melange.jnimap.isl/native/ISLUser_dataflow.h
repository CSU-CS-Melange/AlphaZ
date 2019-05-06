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

/* PROTECTED REGION ID(ISLUser_dataflow_header) ENABLED START */
	 /* Custom includes for this module */
	 typedef struct isl_dataflow_analysis {
	struct isl_union_map *must_dep;
	struct isl_union_map *may_dep;
	struct isl_union_map *must_no_source;
	struct isl_union_map *may_no_source;
} isl_dataflow_analysis ;

void isl_dataflow_analysis_free(struct isl_dataflow_analysis *dfa);
/* PROTECTED REGION END */

isl_union_map* compute_ADA(isl_union_set* domains, isl_union_map* writes, isl_union_map* reads, isl_union_map* idSchedule, int memoryBased);
isl_union_map* compute_ADA_custom(isl_union_set* domains, isl_union_map* writes, isl_union_map* reads, isl_union_map* idSchedule, int RAW, int WAW, int WAR);
isl_union_map* compute_ADA_custom_rar(isl_union_set* domains, isl_union_map* writes, isl_union_map* reads, isl_union_map* idSchedule, int RAW, int WAW, int WAR, int RAR);
struct isl_dataflow_analysis* alloc_dataflow_analysis();
struct isl_dataflow_analysis* isl_array_dataflow_analysis(isl_union_map* sink, isl_union_map* must_source, isl_union_map* may_source, isl_union_map* schedule);
