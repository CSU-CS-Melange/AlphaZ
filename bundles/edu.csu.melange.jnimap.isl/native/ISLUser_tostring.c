#include "ISLUser_tostring.h"

/*PROTECTED REGION ID(ISLUser_tostring_local) ENABLED START*/
/* Protected region for methods used locally in this file */


//static char res[0x100000];


//char* isl_constraint_to_string(struct isl_ctx *ctx, struct isl_constraint *cstr, int format) {
//	isl_printer * pr = isl_printer_to_str(ctx);
//	isl_printer * printer = isl_printer_set_output_format(pr, format);
//	isl_printer_print_constraint(printer,cstr);
//	char *buffer = isl_printer_get_str(printer);
//	char *res = malloc(strlen(buffer));
//	strcpy(res,buffer);
//	isl_printer_free(printer);
//	return buffer;
//}

char* print_term(long value, const char *name, char *buffer,int *first) {
	switch(value) {
		case 0:
			break;
		case -1:
			buffer+=sprintf(buffer,"-%s ",name);
			*first=0;
			break;
		case 1:
			if(!*first) {
				buffer+=sprintf(buffer,"+%s ",name);
				*first=0;
			} else {
				buffer+=sprintf(buffer,"%s ",name);
				*first=0;
			}
			break;
		default:
			if(value<0 || *first) {
				*first=0;
				buffer+=sprintf(buffer,"%ld%s ",value,name);
			} else {
				*first=1;
				buffer+=sprintf(buffer,"+%ld%s ",value,name);
			}
	}
	return buffer;
}

/*PROTECTED REGION END*/	

char * isl_val_to_string(isl_val* val, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_val_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_val_get_ctx(val));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_val(pr, val);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_multi_val_to_string(isl_multi_val* mv, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_multi_val_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_multi_val_get_ctx(mv));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_multi_val(pr, mv);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_val_list_to_string(isl_val_list* vlist, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_val_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_val_list_get_ctx(vlist));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_val_list(pr, vlist);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_id_to_string(isl_id* id, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_id_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_id_get_ctx(id));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_id(pr, id);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_id_list_to_string(isl_id_list* idlist, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_id_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_id_list_get_ctx(idlist));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_id_list(pr, idlist);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_basic_set_to_string(isl_basic_set* bset, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_basic_set_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_basic_set_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_basic_set_get_ctx(bset));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_basic_set(pr,bset);
	char *buffer = isl_printer_get_str(pr);
//	strcpy(res,buffer);
	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_basic_set_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_set_to_string(isl_set* set, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_set_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_set_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_set_get_ctx(set));

	pr = isl_printer_set_output_format(pr, format);

#ifdef TRACE_ALL
	printf("isl print is about to start\n");fflush(stdout);
#endif
	isl_printer_print_set(pr,set);
#ifdef TRACE_ALL
	printf("isl get string from printer\n");fflush(stdout);
#endif
	char *buffer = isl_printer_get_str(pr);
#ifdef TRACE_ALL
	printf("isl print succeeded\n");fflush(stdout);
#endif

	isl_printer_flush(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_set_to_string\n");fflush(stdout);
#endif

	isl_printer_free(pr);

	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_union_set_to_string(isl_union_set* set, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_union_set_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_union_set_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_union_set_get_ctx(set));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_union_set(pr,set);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_union_set_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_basic_set_list_to_string(isl_basic_set_list* bsetlist, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_basic_set_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_basic_set_list_get_ctx(bsetlist));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_basic_set_list(pr, bsetlist);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	
	/* PROTECTED REGION END */
}
char * isl_set_list_to_string(isl_set_list* setlist, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_set_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_set_list_get_ctx(setlist));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_set_list(pr, setlist);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_basic_map_to_string(isl_basic_map* map, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_basic_map_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_basic_map_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_basic_map_get_ctx(map));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_basic_map(pr,map);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_basic_map_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_map_to_string(isl_map* map, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_map_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_map_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_map_get_ctx(map));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_map(pr,map);
	char *buffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_map_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_union_map_to_string(isl_union_map* map, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_union_map_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_union_map_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_union_map_get_ctx(map));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_union_map(pr,map);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_union_map_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_aff_to_string(isl_aff* aff, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_aff_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_aff_to_string\n");fflush(stdout);
#endif

	struct isl_printer *pr = isl_printer_to_str(isl_aff_get_ctx(aff));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_aff(pr,aff);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_aff_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_aff_list_to_string(isl_aff_list* afflist, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_aff_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_aff_list_get_ctx(afflist));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_aff_list(pr,afflist);
	char *buffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_multi_aff_to_string(isl_multi_aff* maff, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_multi_aff_to_string) ENABLED START*/
	struct isl_printer *pr = isl_printer_to_str(isl_multi_aff_get_ctx(maff));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_multi_aff(pr,maff);
	char *buffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_pw_aff_to_string(isl_pw_aff* pwa, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_pw_aff_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_pw_aff_get_ctx(pwa));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_pw_aff(pr, pwa);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_pw_aff_list_to_string(isl_pw_aff_list* pwalist, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_pw_aff_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_pw_aff_list_get_ctx(pwalist));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_pw_aff_list(pr,pwalist);
	char *buffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_multi_pw_aff_to_string(isl_multi_pw_aff* mpa, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_multi_pw_aff_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_multi_pw_aff_get_ctx(mpa));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_multi_pw_aff(pr, mpa);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_pw_multi_aff_to_string(isl_pw_multi_aff* pma, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_pw_multi_aff_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_pw_multi_aff_get_ctx(pma));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_pw_multi_aff(pr, pma);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_union_pw_multi_aff_to_string(isl_union_pw_multi_aff* upma, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_union_pw_multi_aff_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_union_pw_multi_aff_get_ctx(upma));
	pr = isl_printer_set_output_format(pr, format);
	pr = isl_printer_print_union_pw_multi_aff(pr, upma);
	char *buffer = isl_printer_get_str(pr);
	pr = isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_constraint_to_string(isl_constraint* constraint, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_constraint_to_string) ENABLED START*/

	struct isl_printer *pr = isl_printer_to_str(isl_constraint_get_ctx(constraint));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_constraint(pr,constraint);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_constraint_list_to_string(isl_constraint_list* constraintlist, int format) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_constraint_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_constraint_list_get_ctx(constraintlist));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_constraint_list(pr,constraintlist);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_ast_node_to_string(struct isl_ast_node* node) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_ast_node_to_string) ENABLED START*/
	struct isl_printer *pr = isl_printer_to_str(isl_ast_node_get_ctx(node));
		pr = isl_printer_set_output_format(pr, ISL_FORMAT_C);
		isl_printer_print_ast_node(pr,node);
		char *buffer = isl_printer_get_str(pr);
		isl_printer_flush(pr);
		isl_printer_free(pr);
		return buffer;
/*PROTECTED REGION END*/	
}
char * isl_ast_expr_to_string(struct isl_ast_expr* expr) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_ast_expr_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_ast_expr_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_ast_expr_get_ctx(expr));
	pr = isl_printer_set_output_format(pr, ISL_FORMAT_C);
	isl_printer_print_ast_expr(pr,expr);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_ast_expr_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_ast_node_list_to_string(struct isl_ast_node_list* node) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_ast_node_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_ast_node_list_get_ctx(node));
	pr = isl_printer_set_output_format(pr, ISL_FORMAT_C);
	isl_printer_print_ast_node_list(pr,node);
	char *buffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_ast_expr_list_to_string(struct isl_ast_expr_list* expr) {
	/* PROTECTED REGION ID(ISLUser_tostring_isl_ast_expr_list_to_string) ENABLED START */
	struct isl_printer *pr = isl_printer_to_str(isl_ast_expr_list_get_ctx(expr));
	pr = isl_printer_set_output_format(pr, ISL_FORMAT_C);
	isl_printer_print_ast_expr_list(pr,expr);
	char *buffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
	/* PROTECTED REGION END */
}
char * isl_qpolynomial_to_string(isl_qpolynomial* qp, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_qpolynomial_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_qpolynomial_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_qpolynomial_get_ctx(qp));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_qpolynomial(pr,qp);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_qpolynomial_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_qpolynomial_fold_to_string(isl_qpolynomial_fold* qpf, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_qpolynomial_fold_to_string) ENABLED START*/

	struct isl_printer *pr = isl_printer_to_str(isl_qpolynomial_fold_get_ctx(qpf));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_qpolynomial_fold(pr,qpf);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_pw_qpolynomial_to_string(isl_pw_qpolynomial* set, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_pw_qpolynomial_to_string) ENABLED START*/
#ifdef TRACE_ALL
	printf("Entering isl_pw_qpolynomial_to_string\n");fflush(stdout);
#endif
	struct isl_printer *pr = isl_printer_to_str(isl_pw_qpolynomial_get_ctx(set));
	pr = isl_printer_set_output_format(pr, format);
	isl_printer_print_pw_qpolynomial(pr,set);
	char *buffer = isl_printer_get_str(pr);

	isl_printer_flush(pr);
	isl_printer_free(pr);
#ifdef TRACE_ALL
	printf("Leaving isl_pw_qpolynomial_to_string\n");fflush(stdout);
#endif
	return buffer;
/*PROTECTED REGION END*/	
}
char * isl_pw_qpolynomial_fold_to_string(isl_pw_qpolynomial_fold* pwqpf, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_pw_qpolynomial_fold_to_string) ENABLED START*/
	struct isl_printer *pr = isl_printer_to_str(isl_pw_qpolynomial_fold_get_ctx(pwqpf));
		pr = isl_printer_set_output_format(pr, format);
		isl_printer_print_pw_qpolynomial_fold(pr,pwqpf);
		char *buffer = isl_printer_get_str(pr);
		isl_printer_flush(pr);
		isl_printer_free(pr);
		return buffer;
/*PROTECTED REGION END*/	
}
char * isl_union_pw_qpolynomial_to_string(isl_union_pw_qpolynomial* upwqp, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_union_pw_qpolynomial_to_string) ENABLED START*/
	struct isl_printer *pr = isl_printer_to_str(isl_union_pw_qpolynomial_get_ctx(upwqp));
		pr = isl_printer_set_output_format(pr, format);
		isl_printer_print_union_pw_qpolynomial(pr,upwqp);
		char *buffer = isl_printer_get_str(pr);
		isl_printer_flush(pr);
		isl_printer_free(pr);
		return buffer;
/*PROTECTED REGION END*/	
}
char * isl_union_pw_qpolynomial_fold_to_string(isl_union_pw_qpolynomial_fold* upwqpf, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_union_pw_qpolynomial_fold_to_string) ENABLED START*/
	struct isl_printer *pr = isl_printer_to_str(isl_union_pw_qpolynomial_fold_get_ctx(upwqpf));
		pr = isl_printer_set_output_format(pr, format);
		isl_printer_print_union_pw_qpolynomial_fold(pr,upwqpf);
		char *buffer = isl_printer_get_str(pr);
		isl_printer_flush(pr);
		isl_printer_free(pr);
		return buffer;
/*PROTECTED REGION END*/	
}
char * isl_schedule_to_string(isl_schedule* s, int format) {
/*PROTECTED REGION ID(ISLUser_tostring_isl_schedule_to_string) ENABLED START*/
	struct isl_printer *pr = isl_printer_to_str(isl_schedule_get_ctx(s));
		pr = isl_printer_set_output_format(pr, format);
		isl_printer_print_schedule(pr,s);
		char *buffer = isl_printer_get_str(pr);
		isl_printer_flush(pr);
		isl_printer_free(pr);
		return buffer;
/*PROTECTED REGION END*/	
}
