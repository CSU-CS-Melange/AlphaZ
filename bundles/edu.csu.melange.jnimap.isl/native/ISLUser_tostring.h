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

/* PROTECTED REGION ID(ISLUser_tostring_header) ENABLED START */
	 /* Custom includes for this module */
/* PROTECTED REGION END */

char * isl_val_to_string(isl_val* val, int format);
char * isl_multi_val_to_string(isl_multi_val* mv, int format);
char * isl_val_list_to_string(isl_val_list* vlist, int format);
char * isl_id_to_string(isl_id* id, int format);
char * isl_id_list_to_string(isl_id_list* idlist, int format);
char * isl_basic_set_to_string(isl_basic_set* bset, int format);
char * isl_set_to_string(isl_set* set, int format);
char * isl_union_set_to_string(isl_union_set* set, int format);
char * isl_basic_set_list_to_string(isl_basic_set_list* bsetlist, int format);
char * isl_set_list_to_string(isl_set_list* setlist, int format);
char * isl_basic_map_to_string(isl_basic_map* map, int format);
char * isl_map_to_string(isl_map* map, int format);
char * isl_union_map_to_string(isl_union_map* map, int format);
char * isl_aff_to_string(isl_aff* aff, int format);
char * isl_aff_list_to_string(isl_aff_list* afflist, int format);
char * isl_multi_aff_to_string(isl_multi_aff* maff, int format);
char * isl_pw_aff_to_string(isl_pw_aff* pwa, int format);
char * isl_pw_aff_list_to_string(isl_pw_aff_list* pwalist, int format);
char * isl_multi_pw_aff_to_string(isl_multi_pw_aff* mpa, int format);
char * isl_pw_multi_aff_to_string(isl_pw_multi_aff* pma, int format);
char * isl_union_pw_multi_aff_to_string(isl_union_pw_multi_aff* upma, int format);
char * isl_constraint_to_string(isl_constraint* constraint, int format);
char * isl_constraint_list_to_string(isl_constraint_list* constraintlist, int format);
char * isl_ast_node_to_string(struct isl_ast_node* node);
char * isl_ast_expr_to_string(struct isl_ast_expr* expr);
char * isl_ast_node_list_to_string(struct isl_ast_node_list* node);
char * isl_ast_expr_list_to_string(struct isl_ast_expr_list* expr);
char * isl_qpolynomial_to_string(isl_qpolynomial* qp, int format);
char * isl_qpolynomial_fold_to_string(isl_qpolynomial_fold* qpf, int format);
char * isl_pw_qpolynomial_to_string(isl_pw_qpolynomial* set, int format);
char * isl_pw_qpolynomial_fold_to_string(isl_pw_qpolynomial_fold* pwqpf, int format);
char * isl_union_pw_qpolynomial_to_string(isl_union_pw_qpolynomial* upwqp, int format);
char * isl_union_pw_qpolynomial_fold_to_string(isl_union_pw_qpolynomial_fold* upwqpf, int format);
char * isl_schedule_to_string(isl_schedule* s, int format);
