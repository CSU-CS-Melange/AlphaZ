#include "ISLUser_isl_closed_form_relation.h"

/* PROTECTED REGION ID(ISLUser_isl_closed_form_relation_local) ENABLED START */
	/* Protected region for methods used locally in this file */
	
/*
struct res_t_aff {
	int pos;
	struct isl_aff * ptr;
};*/
struct res_t_lexopt {
	int pos;
	struct isl_closed_form_relation * ptr;
};

int get_at_callback_lexopt(struct isl_set * bset, struct isl_multi_aff * list, void* user) {
	struct res_t_lexopt* res = (struct res_t_lexopt*) user;
	if(res->pos>0) {
		(res->pos)--;
		isl_set_free(bset);
		isl_multi_aff_free(list);
	} else if(res->pos==0){
		if(res->ptr==NULL) {
			struct isl_closed_form_relation* opt = (struct isl_closed_form_relation*) malloc (sizeof(struct isl_closed_form_relation));
			opt->dom = bset;
			opt->multiAff = list;
			res->ptr=opt;
		} else {
			isl_set_free(bset);
			isl_multi_aff_free(list);
		}
	} else {
		res->ptr=NULL;
		isl_set_free(bset);
		isl_multi_aff_free(list);
	}
	return res->pos;
}

/*
int get_at_callback_afflist(struct isl_aff * aff, void* user) {
	struct res_t_aff* res = (struct res_t_aff*) user;
	if(res->pos>0) {
		(res->pos)--;
		isl_aff_free(aff);
	} else if(res->pos==0){
		if(res->ptr==NULL) {
			res->ptr=aff;
		} else {
			isl_aff_free(aff);
		}
	} else {
		res->ptr=NULL;
		isl_aff_free(aff);
	}
	return res->pos;
}//*/

int numberof_lexopt(struct isl_set * bset, struct isl_multi_aff * list, void* user) {
	(*((int*)user))++;
	isl_set_free(bset);
	isl_multi_aff_free(list);
	return 0;
}
/* PROTECTED REGION END */

int isl_basic_map_numberof_lexmin(isl_basic_map* bmap) {
	/* PROTECTED REGION ID(ISLUser_isl_closed_form_relation_isl_basic_map_numberof_lexmin) ENABLED START */
	isl_pw_multi_aff * pwma = isl_basic_map_lexmin_pw_multi_aff(isl_basic_map_copy(bmap));
	int res = 0;
	if (isl_pw_multi_aff_foreach_piece(pwma,&numberof_lexopt, &res)) {
		fprintf(stderr,"error\n");
		return -1;
	}//*/
	isl_pw_multi_aff_free(pwma);
	return res;
	/* PROTECTED REGION END */
}
struct isl_closed_form_relation* isl_basic_map_get_lexmin_at(isl_basic_map* bmap, int pos) {
	/* PROTECTED REGION ID(ISLUser_isl_closed_form_relation_isl_basic_map_get_lexmin_at) ENABLED START */
	isl_pw_multi_aff * pwma = isl_basic_map_lexmin_pw_multi_aff(isl_basic_map_copy(bmap));

	struct res_t_lexopt res;
	res.ptr=NULL;
	res.pos=pos;

	if (isl_pw_multi_aff_foreach_piece(pwma,&get_at_callback_lexopt, &res)) {
		fprintf(stderr,"error\n");
		return NULL;
	}//*/

	isl_pw_multi_aff_free(pwma);
	return res.ptr;
	/* PROTECTED REGION END */
}
