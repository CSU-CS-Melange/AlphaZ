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

/* PROTECTED REGION ID(ISLUser_isl_closed_form_relation_header) ENABLED START */
	 /* Custom includes for this module */
	 struct isl_closed_form_relation {
	struct isl_set* dom;
	struct isl_multi_aff* multiAff;
};
/* PROTECTED REGION END */

int isl_basic_map_numberof_lexmin(isl_basic_map* bmap);
struct isl_closed_form_relation* isl_basic_map_get_lexmin_at(isl_basic_map* bmap, int pos);
