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

/* PROTECTED REGION ID(ISLUser_polynomial_header) ENABLED START */
#include "fr_irisa_cairn_jnimap_isl_jni_ISLNative.h"

struct res_spec_term {
	int pos;
	struct isl_term* term;
};
struct res_exp_query_term {
	int pos;
	int type;
	unsigned dim;
	int exp;
};



struct isl_qpolynomial_piece {
	struct isl_set* set;
	struct isl_qpolynomial *qp;
};

struct isl_qpolynomial_fold_piece {
	struct isl_set* set;
	struct isl_qpolynomial_fold *fold;
};

struct res_spec_polypieces {
	int pos;
	struct isl_qpolynomial_piece* piece;
};

struct res_spec_polyfoldpieces {
	int pos;
	struct isl_qpolynomial_fold_piece* piece;
};

struct res_spec_polyfold {
	int pos;
	struct isl_qpolynomial* qp;
};

void isl_qpolynomial_piece_free(struct isl_qpolynomial_piece* piece);
void isl_qpolynomial_fold_piece_free(struct isl_qpolynomial_fold_piece* piece);
/* PROTECTED REGION END */

int isl_qpolynomial_get_exp_at(isl_qpolynomial* qp, int termPos, enum isl_dim_type type, unsigned int dim);
int isl_qpolynomial_numberof_terms(isl_qpolynomial* qp);
isl_term* isl_qpolynomial_get_term_at(isl_qpolynomial* qp, int pos);
int isl_pw_qpolynomial_numberof_piece(isl_pw_qpolynomial* pwqp);
struct isl_qpolynomial_piece* isl_pw_qpolynomial_get_piece_at(isl_pw_qpolynomial* pwqp, int pos);
int isl_pw_qpolynomial_numberof_lifted_piece(isl_pw_qpolynomial* pwqp);
struct isl_qpolynomial_piece* isl_pw_qpolynomial_get_lifted_piece_at(isl_pw_qpolynomial* pwqp, int pos);
int isl_qpolynomial_fold_number_of_qpolynomial(isl_qpolynomial_fold* fold);
isl_qpolynomial* isl_qpolynomial_fold_get_qpolynomial_at(isl_qpolynomial_fold* fold, int pos);
int isl_pw_qpolynomial_fold_numberof_piece(isl_pw_qpolynomial_fold* pwf);
struct isl_qpolynomial_fold_piece* isl_pw_qpolynomial_fold_get_piece_at(isl_pw_qpolynomial_fold* pwf, int pos);
int isl_pw_qpolynomial_fold_numberof_lifted_piece(isl_pw_qpolynomial_fold* pwf);
struct isl_qpolynomial_fold_piece* isl_pw_qpolynomial_fold_get_lifted_piece_at(isl_pw_qpolynomial_fold* pwf, int pos);
