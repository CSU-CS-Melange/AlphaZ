#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <cloog/cloog.h>
#include <isl/ctx.h>

/* PROTECTED REGION ID(CloogUser_addons_header) ENABLED START */
	 /* Custom includes for this module */
#include<cloog/isl/backend.h>
#include<cloog/isl/cloog.h>
#include<cloog/isl/constraintset.h>
#include<cloog/isl/domain.h>
#include<isl/ctx.h>
#include<isl/set.h>
#include<isl/map.h>
#include<isl/flow.h>
#include<isl/union_set.h>
#include<isl/union_map.h>
#include<isl/vertices.h>
#include <gmp.h>
/* PROTECTED REGION END */

struct clast_stmt* cloog_clast_from_union_map(struct cloogstate* state, struct cloogoptions* opts, char * context, char * union_map_str);
struct clast_stmt* cloog_clast_from_set(struct cloogstate* state, struct cloogoptions* opts, char * context, char * set_str);
struct clooginput* cloog_input_read_from_isl_union_map_str(isl_ctx* ctx, struct cloogstate* state, char * context, char * union_map_str);
struct clooginput* cloog_input_read_from_isl_set_str(isl_ctx* ctx, struct cloogstate* state, char * context, char * set_str);
void clast_print(struct clast_stmt* stmt, struct cloogoptions* opts);
struct clast_expr* clast_reduction_get_element(struct clast_reduction* stmt, int offset);
int clast_reduction_get_number_of_elements(struct clast_reduction* stmt);
int clast_binary_get_value(struct clast_binary* stmt);
int clast_term_get_value(struct clast_term* stmt);
char * clast_user_stmt_get_cloog_domain(struct clast_user_stmt* stmt);
char * clast_for_get_cloog_domain(struct clast_for* stmt);
int clast_for_get_stride(struct clast_for* stmt);
struct clast_equation* clast_guard_get_equation(struct clast_guard* stmt, int offset);
int clast_guard_get_n(struct clast_guard* stmt);
char * get_scalar(struct cloognames* names, int index);
char * get_scattering(struct cloognames* names, int index);
char * get_parameter(struct cloognames* names, int index);
char * get_iterator(struct cloognames* names, int index);
int is_clast_guard(struct clast_stmt* stmt);
int is_clast_for(struct clast_stmt* stmt);
int is_clast_assignment(struct clast_stmt* stmt);
int is_clast_user_stmt(struct clast_stmt* stmt);
int is_clast_block(struct clast_stmt* stmt);
int is_clast_root(struct clast_stmt* stmt);
int is_clast_expr_binary(struct clast_expr* expr);
int is_clast_expr_term(struct clast_expr* expr);
int is_clast_expr_reduction(struct clast_expr* expr);
int is_clast_expr_name(struct clast_expr* expr);
