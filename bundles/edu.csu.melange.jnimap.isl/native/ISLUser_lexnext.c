#include "ISLUser_lexnext.h"

/*PROTECTED REGION ID(ISLUser_lexnext_local) ENABLED START*/
/* Protected region for methods used locally in this file */

inline int log2_k_spec_next_pow_t_private(int l) {
	int i = 0;
	while ((l = l/2)>0) i++;
	return i;
}

struct res_t_spec_next_pow_t_private {
	int pos;
	void* ptr;
};

static int get_at_callback_spec_next_pow_t_private(struct isl_basic_map * current, void* v) {
	struct res_t_spec_next_pow_t_private* res = (struct res_t_spec_next_pow_t_private*) v;
	if(res->pos>0) {
		(res->pos)--;
		isl_basic_map_free(current);
	} else if(res->pos==0){
		if(res->ptr==NULL) {
			res->ptr=current;
		} else {
			isl_basic_map_free(current);
		}
	} else {
		res->ptr=NULL;
		isl_basic_map_free(current);
	}
	return res->pos;
}
static int number_of_callback_spec_next_pow_t_private(struct isl_basic_map * current, void* v) {
	struct res_t_spec_next_pow_t_private* res = (struct res_t_spec_next_pow_t_private*) v;
	isl_basic_map_free(current);
	(res->pos)++;
	return res->pos;
}
inline int isl_map_numberof_basic_map_spec_next_pow_t_private(struct isl_map* map) {
	struct res_t_spec_next_pow_t_private res;
	res.ptr=NULL;
	res.pos=0;
	isl_map_foreach_basic_map(map,number_of_callback_spec_next_pow_t_private,&res);
	return  res.pos;
}
inline struct isl_basic_map* isl_map_get_basic_map_at_spec_next_pow_t_private(struct isl_map* map, int pos) {
	struct res_t_spec_next_pow_t_private res;
	res.ptr=NULL;
	res.pos=pos;
	isl_map_foreach_basic_map(map,get_at_callback_spec_next_pow_t_private, &res);
	return (isl_basic_map *) res.ptr;
}

/*PROTECTED REGION END*/	

isl_map* lex_next(isl_set* dom, int nbInnerLoop) {
/*PROTECTED REGION ID(ISLUser_lexnext_lex_next) ENABLED START*/
	int nbDimOrigDomain = isl_set_n_dim(dom);
	if (nbInnerLoop > nbDimOrigDomain) nbInnerLoop = nbDimOrigDomain;
	isl_map* map = isl_map_from_domain_and_range(isl_set_copy(dom),isl_set_copy(dom));
	if (nbInnerLoop < 1) {
		//happen when dom has 0 dimensions.
		isl_map* res = isl_map_empty(isl_map_get_space(map));
		isl_map_free(map);
		return res;
	}

	isl_map* lt = isl_map_lex_lt(isl_set_get_space(dom));

	isl_map* nxt = NULL;
	int nb = isl_map_numberof_basic_map_spec_next_pow_t_private(lt);
	int i;
	for (i = nb-1; i >= nb-nbInnerLoop; i--) {
		isl_map* succs = isl_map_from_basic_map(isl_map_get_basic_map_at_spec_next_pow_t_private(lt,i));
		isl_map* lexMin = isl_map_lexmin(isl_map_make_disjoint(isl_map_intersect(map, succs)));
		if (nxt == NULL) {
			nxt = lexMin;
		} else {
			nxt = isl_map_union(nxt, lexMin);
		}
		isl_set* remain = isl_set_subtract(isl_set_copy(dom), isl_map_domain(isl_map_copy(nxt)));
		map = isl_map_from_domain_and_range(remain,isl_set_copy(dom));
	}
	isl_map_free(lt);
	isl_map_free(map);
	return nxt;
/*PROTECTED REGION END*/	
}
isl_map* lex_next_power(isl_set* dom, int nbInnerLoop, int power) {
/*PROTECTED REGION ID(ISLUser_lexnext_lex_next_power) ENABLED START*/
	int i;

	isl_map* current = lex_next(dom,nbInnerLoop);

	//return isl_map_fixed_power(current, power);

	int size = log2_k_spec_next_pow_t_private(power)+1;
	isl_map** ms = (isl_map**) malloc(sizeof(isl_map*)*size);
	for (i = 0; i < size; i++) {
		ms[i] = NULL;
	}
	ms[0] = isl_map_copy(current);

	int log = 2;
	while(log<=power) {
		isl_map* current_copy = isl_map_copy(current);
		current = isl_map_make_disjoint(isl_map_apply_range(current_copy, current));
		ms[log2_k_spec_next_pow_t_private(log)] = isl_map_copy(current);
		log=log*2;
	}

	log /= 2;
	int newpower = power - log;
	for (i = log2(log)-1; i >= 0 ; i--) {
		int p = newpower - (int)pow(2, i);
		if (p >= 0) {
			newpower = p;
			log += (i == 0)?1:(i*2);
			current = isl_map_apply_range(ms[i], current);
			ms[i] = NULL;
		}
	}
	current = isl_map_make_disjoint(isl_map_coalesce(current));

	for (i = 0; i < size; i++) {
		if (ms[i] != NULL)
			isl_map_free(ms[i]);
	}
	free(ms);
	return current;
/*PROTECTED REGION END*/	
}
