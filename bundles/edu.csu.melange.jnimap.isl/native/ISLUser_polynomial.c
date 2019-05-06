#include "ISLUser_polynomial.h"

/*PROTECTED REGION ID(ISLUser_polynomial_local) ENABLED START*/
/* Protected region for methods used locally in this file */
void isl_qpolynomial_piece_free(struct isl_qpolynomial_piece* piece) {
   isl_set_free(piece->set);
   isl_qpolynomial_free(piece->qp);
   free(piece);
}

void isl_qpolynomial_fold_piece_free(struct isl_qpolynomial_fold_piece* piece) {
   isl_set_free(piece->set);
   isl_qpolynomial_fold_free(piece->fold);
   free(piece);

}

int qp_get_exp_at_term_callback(struct isl_term* term, void* user) {
	struct res_exp_query_term* res = (struct res_exp_query_term*)user;

	if (res->pos == 0) {
		res->exp = isl_term_get_exp(term, res->type, res->dim);
	}

	(res->pos)--;
	isl_term_free(term);

	return 0;
}

int qp_get_at_callback_terms(struct isl_term * term, void* user) {
	struct res_spec_term* res = (struct res_spec_term*)user;
	if(res->pos>0) {
		(res->pos)--;
		isl_term_free(term);
	} else if(res->pos==0){
		if(res->term==NULL) {
			res->term = term;
		} else {
			isl_term_free(term);
		}
	} else {
		res->term=NULL;
		isl_term_free(term);
	}
	return res->pos;
}


int qp_numberof_terms(struct isl_term * term, void* user) {
	(*((int*)user))++;
	isl_term_free(term);
	return 0;
}

int pwqp_get_at_callback_pieces(struct isl_set * bset, struct isl_qpolynomial * qp, void* user) {
	struct res_spec_polypieces* res = (struct res_spec_polypieces*) user;
	if(res->pos>0) {
		(res->pos)--;
		isl_set_free(bset);
		isl_qpolynomial_free(qp);
	} else if(res->pos==0){
		if(res->piece==NULL) {
			struct isl_qpolynomial_piece* opt = (struct isl_qpolynomial_piece*) malloc (sizeof(struct isl_qpolynomial_piece));
			opt->set = bset;
			opt->qp = qp;
			res->piece=opt;
		} else {
			isl_set_free(bset);
			isl_qpolynomial_free(qp);
		}
	} else {
		res->piece=NULL;
		isl_set_free(bset);
		isl_qpolynomial_free(qp);
	}
	return res->pos;
}

int pwqp_numberof_pieces(struct isl_set * bset, struct isl_qpolynomial *qp, void* user) {
	(*((int*)user))++;
	isl_set_free(bset);
	isl_qpolynomial_free(qp);
	return 0;
}

int pwqp_fold_get_at_callback_pieces(struct isl_set * bset, struct isl_qpolynomial_fold * qp, void* user) {
	struct res_spec_polyfoldpieces* res = (struct res_spec_polyfoldpieces*) user;
	if(res->pos>0) {
		(res->pos)--;
		isl_set_free(bset);
		isl_qpolynomial_fold_free(qp);
	} else if(res->pos==0){
		if(res->piece==NULL) {
			struct isl_qpolynomial_fold_piece* opt = (struct isl_qpolynomial_fold_piece*) malloc (sizeof(struct isl_qpolynomial_fold_piece));
			opt->set = bset;
			opt->fold = qp;
			res->piece=opt;
		} else {
			isl_set_free(bset);
			isl_qpolynomial_fold_free(qp);
		}
	} else {
		res->piece=NULL;
		isl_set_free(bset);
		isl_qpolynomial_fold_free(qp);
	}
	return res->pos;
}

int pwqp_fold_numberof_pieces(struct isl_set * bset, struct isl_qpolynomial_fold *qp, void* user) {
	(*((int*)user))++;
	isl_set_free(bset);
	isl_qpolynomial_fold_free(qp);
	return 0;
}


int qp_fold_get_at_callback_pieces(struct isl_qpolynomial * qp, void* user) {
	struct res_spec_polyfold* res = (struct res_spec_polyfold*) user;
	if(res->pos>0) {
		(res->pos)--;
		isl_qpolynomial_free(qp);
	} else if(res->pos==0){
		if(res->qp==NULL) {
			res->qp = qp;
		} else {
			isl_qpolynomial_free(qp);
		}
	} else {
		res->qp=NULL;
		isl_qpolynomial_free(qp);
	}
	return res->pos;
}

int qp_fold_numberof_pieces(struct isl_qpolynomial *qp, void* user) {
	(*((int*)user))++;
	isl_qpolynomial_free(qp);
	return 0;
}
/*PROTECTED REGION END*/	

int isl_qpolynomial_get_exp_at(isl_qpolynomial* qp, int termPos, enum isl_dim_type type, unsigned int dim) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_qpolynomial_get_exp_at) ENABLED START*/
	struct res_exp_query_term res;
	res.exp = 0;
	res.pos=termPos;
	res.type=type;
	res.dim=dim;
	if (isl_qpolynomial_foreach_term(qp, &qp_get_exp_at_term_callback, &res)) {
		fprintf(stderr,"error\n");
		return (int) GECOS_PTRSIZE NULL;
	}
	return res.exp;
/*PROTECTED REGION END*/	
}
int isl_qpolynomial_numberof_terms(isl_qpolynomial* qp) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_qpolynomial_numberof_terms) ENABLED START*/
	int res = 0;
	if (isl_qpolynomial_foreach_term(qp, &qp_numberof_terms, &res)) {
		fprintf(stderr,"error\n");
		return -1;
	}
	return res;
/*PROTECTED REGION END*/	
}
isl_term* isl_qpolynomial_get_term_at(isl_qpolynomial* qp, int pos) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_qpolynomial_get_term_at) ENABLED START*/
	struct res_spec_term res;
	res.term=NULL;
	res.pos=pos;
	if (isl_qpolynomial_foreach_term(qp, &qp_get_at_callback_terms, &res)) {
		fprintf(stderr,"error\n");
		return NULL;
	}
	return res.term;
/*PROTECTED REGION END*/	
}
int isl_pw_qpolynomial_numberof_piece(isl_pw_qpolynomial* pwqp) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_pw_qpolynomial_numberof_piece) ENABLED START*/
	int res = 0;
	if (isl_pw_qpolynomial_foreach_piece(pwqp,&pwqp_numberof_pieces, &res)) {
		fprintf(stderr,"error\n");
		return -1;
	}
	return res;
/*PROTECTED REGION END*/	
}
struct isl_qpolynomial_piece* isl_pw_qpolynomial_get_piece_at(isl_pw_qpolynomial* pwqp, int pos) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_pw_qpolynomial_get_piece_at) ENABLED START*/
	struct res_spec_polypieces res;
	res.piece=NULL;
	res.pos=pos;
	if (isl_pw_qpolynomial_foreach_piece(pwqp,&pwqp_get_at_callback_pieces, &res)) {
		fprintf(stderr,"error\n");
		return NULL;
	}
	return res.piece;
/*PROTECTED REGION END*/	
}
int isl_pw_qpolynomial_numberof_lifted_piece(isl_pw_qpolynomial* pwqp) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_pw_qpolynomial_numberof_lifted_piece) ENABLED START*/
	int res = 0;
	if (isl_pw_qpolynomial_foreach_lifted_piece(pwqp,&pwqp_numberof_pieces, &res)) {
		fprintf(stderr,"error\n");
		return -1;
	}
	return res;
/*PROTECTED REGION END*/	
}
struct isl_qpolynomial_piece* isl_pw_qpolynomial_get_lifted_piece_at(isl_pw_qpolynomial* pwqp, int pos) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_pw_qpolynomial_get_lifted_piece_at) ENABLED START*/
	struct res_spec_polypieces res;
	res.piece=NULL;
	res.pos=pos;
	if (isl_pw_qpolynomial_foreach_lifted_piece(pwqp,&pwqp_get_at_callback_pieces, &res)) {
		fprintf(stderr,"error\n");
		return NULL;
	}
	return res.piece;
/*PROTECTED REGION END*/	
}
int isl_qpolynomial_fold_number_of_qpolynomial(isl_qpolynomial_fold* fold) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_qpolynomial_fold_number_of_qpolynomial) ENABLED START*/
	int res = 0;
	if (isl_qpolynomial_fold_foreach_qpolynomial(fold,&qp_fold_numberof_pieces, &res)) {
		fprintf(stderr,"error\n");
		return -1;
	}
	return res;
/*PROTECTED REGION END*/	
}
isl_qpolynomial* isl_qpolynomial_fold_get_qpolynomial_at(isl_qpolynomial_fold* fold, int pos) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_qpolynomial_fold_get_qpolynomial_at) ENABLED START*/
	struct res_spec_polyfold res;
	res.qp=NULL;
	res.pos=pos;
	if (isl_qpolynomial_fold_foreach_qpolynomial(fold,&qp_fold_get_at_callback_pieces, &res)) {
		fprintf(stderr,"error\n");
		return NULL;
	}
	return res.qp;
/*PROTECTED REGION END*/	
}
int isl_pw_qpolynomial_fold_numberof_piece(isl_pw_qpolynomial_fold* pwf) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_pw_qpolynomial_fold_numberof_piece) ENABLED START*/
	int res = 0;
	if (isl_pw_qpolynomial_fold_foreach_piece(pwf,&pwqp_fold_numberof_pieces, &res)) {
		fprintf(stderr,"error\n");
		return -1;
	}
	return res;
/*PROTECTED REGION END*/	
}
struct isl_qpolynomial_fold_piece* isl_pw_qpolynomial_fold_get_piece_at(isl_pw_qpolynomial_fold* pwf, int pos) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_pw_qpolynomial_fold_get_piece_at) ENABLED START*/
	struct res_spec_polyfoldpieces res;
	res.piece=NULL;
	res.pos=pos;
	if (isl_pw_qpolynomial_fold_foreach_piece(pwf,&pwqp_fold_get_at_callback_pieces, &res)) {
		fprintf(stderr,"error\n");
		return NULL;
	}
	return res.piece;
/*PROTECTED REGION END*/	
}
int isl_pw_qpolynomial_fold_numberof_lifted_piece(isl_pw_qpolynomial_fold* pwf) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_pw_qpolynomial_fold_numberof_lifted_piece) ENABLED START*/
	int res = 0;
	if (isl_pw_qpolynomial_fold_foreach_lifted_piece(pwf,&pwqp_fold_numberof_pieces, &res)) {
		fprintf(stderr,"error\n");
		return -1;
	}
	return res;
/*PROTECTED REGION END*/	
}
struct isl_qpolynomial_fold_piece* isl_pw_qpolynomial_fold_get_lifted_piece_at(isl_pw_qpolynomial_fold* pwf, int pos) {
/*PROTECTED REGION ID(ISLUser_polynomial_isl_pw_qpolynomial_fold_get_lifted_piece_at) ENABLED START*/
	struct res_spec_polyfoldpieces res;
	res.piece=NULL;
	res.pos=pos;
	if (isl_pw_qpolynomial_fold_foreach_lifted_piece(pwf,&pwqp_fold_get_at_callback_pieces, &res)) {
		fprintf(stderr,"error\n");
		return NULL;
	}
	return res.piece;
/*PROTECTED REGION END*/	
}
