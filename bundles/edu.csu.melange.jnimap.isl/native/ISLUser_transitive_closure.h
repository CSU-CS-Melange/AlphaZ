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

/* PROTECTED REGION ID(ISLUser_transitive_closure_header) ENABLED START */
	 /* Custom includes for this module */
	 typedef struct isl_transitive_closure_result {
	int exact;
	struct isl_map *map;
	struct isl_basic_map *bmap;
	struct isl_union_map *umap;
} isl_transitive_closure_result ;
/* PROTECTED REGION END */

struct isl_transitive_closure_result* alloc_isl_transitive_closure_result();
void free_isl_transitive_closure_result(struct isl_transitive_closure_result* result);
struct isl_transitive_closure_result* isl_basic_map_transitive_closure_jnimap(isl_basic_map* map);
struct isl_transitive_closure_result* isl_map_transitive_closure_jnimap(isl_map* map);
struct isl_transitive_closure_result* isl_union_map_transitive_closure_jnimap(isl_union_map* map);
