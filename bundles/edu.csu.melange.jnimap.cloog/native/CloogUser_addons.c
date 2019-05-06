#include "CloogUser_addons.h"

/* PROTECTED REGION ID(CloogUser_addons_local) ENABLED START */
	/* Protected region for methods used locally in this file */
isl_printer *printer=NULL;

void print_union_set(char* prefix,isl_union_set* set) {
	printer = isl_printer_print_union_set(printer,set);
	printf("%s=%s\n",prefix,isl_printer_get_str(printer));
	isl_printer_flush(printer);
}

void print_union_map(char* prefix,isl_union_map* map ) {
	printer = isl_printer_print_union_map(printer,map);
	printf("%s=%s\n",prefix,isl_printer_get_str(printer));
	isl_printer_flush(printer);

}

void print_set(char* prefix,isl_set* set) {
	printer = isl_printer_print_set(printer,set);
	printf("%s=%s\n",prefix,isl_printer_get_str(printer));
	isl_printer_flush(printer);
}

void print_map(char* prefix,isl_map* map ) {
	printer = isl_printer_print_map(printer,map);
	printf("%s=%s\n",prefix,isl_printer_get_str(printer));
	isl_printer_flush(printer);

}
/* PROTECTED REGION END */

struct clast_stmt* cloog_clast_from_union_map(struct cloogstate* state, struct cloogoptions* opts, char * context, char * union_map_str) {
	/* PROTECTED REGION ID(CloogUser_addons_cloog_clast_from_union_map) ENABLED START */
	struct isl_ctx *ctxt = isl_ctx_alloc();

	CloogInput* input = cloog_input_read_from_isl_union_map_str(ctxt, state, context, union_map_str);
	struct clast_stmt *root = cloog_clast_create_from_input(input, opts);

	isl_ctx_free(ctxt);

	return root;
	/* PROTECTED REGION END */
}
struct clast_stmt* cloog_clast_from_set(struct cloogstate* state, struct cloogoptions* opts, char * context, char * set_str) {
	/* PROTECTED REGION ID(CloogUser_addons_cloog_clast_from_set) ENABLED START */
	struct isl_ctx *ctxt = isl_ctx_alloc();

	CloogInput* input = cloog_input_read_from_isl_set_str(ctxt, state, context, set_str);
	struct clast_stmt *root = cloog_clast_create_from_input(input, opts);

	isl_ctx_free(ctxt);

	return root;
	/* PROTECTED REGION END */
}
struct clooginput* cloog_input_read_from_isl_union_map_str(isl_ctx* ctx, struct cloogstate* state, char * context, char * union_map_str) {
	/* PROTECTED REGION ID(CloogUser_addons_cloog_input_read_from_isl_union_map_str) ENABLED START */
	isl_set *set = isl_set_read_from_str(ctx, context);
	CloogDomain* cloog_context = cloog_domain_from_isl_set(set);
	isl_union_map *union_map = isl_union_map_read_from_str(ctx,union_map_str);

//	printer = isl_printer_to_str(ctxt);
//		printf("%s\n", union_domain);
//		print_set("set", set);
//		print_union_map("map", union_map);
//	isl_printer_free(printer);

	CloogUnionDomain* cloog_union_domain = cloog_union_domain_from_isl_union_map(union_map);

	CloogInput* input = cloog_input_alloc(cloog_context, cloog_union_domain);

	return input;
	/* PROTECTED REGION END */
}
struct clooginput* cloog_input_read_from_isl_set_str(isl_ctx* ctx, struct cloogstate* state, char * context, char * set_str) {
	/* PROTECTED REGION ID(CloogUser_addons_cloog_input_read_from_isl_set_str) ENABLED START */
	isl_set *c_set = isl_set_read_from_str(ctx, context);
	CloogDomain* cloog_context = cloog_domain_from_isl_set(c_set);

	isl_set *s_set = isl_set_read_from_str(ctx, set_str);
	CloogUnionDomain* cloog_union_domain = cloog_union_domain_from_isl_set(s_set);

//	printer = isl_printer_to_str(ctxt);
//		printf("%s\n", union_domain);
//		print_set("set", set);
//		print_union_map("map", union_map);
//	isl_printer_free(printer);


	CloogInput* input = cloog_input_alloc(cloog_context, cloog_union_domain);

	return input;
	/* PROTECTED REGION END */
}
void clast_print(struct clast_stmt* stmt, struct cloogoptions* opts) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_print) ENABLED START */
	clast_pprint(stdout, stmt, 0, opts);
	/* PROTECTED REGION END */
}
struct clast_expr* clast_reduction_get_element(struct clast_reduction* stmt, int offset) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_reduction_get_element) ENABLED START */
	return (stmt->elts)[offset];
	/* PROTECTED REGION END */
}
int clast_reduction_get_number_of_elements(struct clast_reduction* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_reduction_get_number_of_elements) ENABLED START */
	return stmt->n;
	/* PROTECTED REGION END */
}
int clast_binary_get_value(struct clast_binary* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_binary_get_value) ENABLED START */
	return mpz_get_si(stmt->RHS);
	/* PROTECTED REGION END */
}
int clast_term_get_value(struct clast_term* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_term_get_value) ENABLED START */
	return mpz_get_si(stmt->val);
	/* PROTECTED REGION END */
}
char * clast_user_stmt_get_cloog_domain(struct clast_user_stmt* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_user_stmt_get_cloog_domain) ENABLED START */
	struct cloogdomain *domain=stmt->domain;
	if(domain!=NULL) {
		struct isl_set *set = isl_set_from_cloog_domain(domain);
		if(set!=NULL) {
			struct isl_ctx *ctxt = isl_set_get_ctx(set);
			printer = isl_printer_to_str(ctxt);
			printer = isl_printer_print_set(printer,set);
			char* res= isl_printer_get_str(printer);
			isl_printer_free(printer);
			return res;
		}
	}
	return NULL;
	/* PROTECTED REGION END */
}
char * clast_for_get_cloog_domain(struct clast_for* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_for_get_cloog_domain) ENABLED START */
	struct cloogdomain *domain=stmt->domain;
	if(domain!=NULL) {
		struct isl_set *set = isl_set_from_cloog_domain(domain);
		if(set!=NULL) {
			struct isl_ctx *ctxt = isl_set_get_ctx(set);
			printer = isl_printer_to_str(ctxt);
			printer = isl_printer_print_set(printer,set);
			char* res= isl_printer_get_str(printer);
			return res;
		}
	}
	return NULL;
	/* PROTECTED REGION END */
}
int clast_for_get_stride(struct clast_for* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_for_get_stride) ENABLED START */
	return mpz_get_si(stmt->stride);
	/* PROTECTED REGION END */
}
struct clast_equation* clast_guard_get_equation(struct clast_guard* stmt, int offset) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_guard_get_equation) ENABLED START */
	return &(stmt->eq[offset]);
	/* PROTECTED REGION END */
}
int clast_guard_get_n(struct clast_guard* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_clast_guard_get_n) ENABLED START */
	return (stmt->n);
	/* PROTECTED REGION END */
}
char * get_scalar(struct cloognames* names, int index) {
	/* PROTECTED REGION ID(CloogUser_addons_get_scalar) ENABLED START */
	char* res= names->scalars[index];
	return res;
	/* PROTECTED REGION END */
}
char * get_scattering(struct cloognames* names, int index) {
	/* PROTECTED REGION ID(CloogUser_addons_get_scattering) ENABLED START */
	char* res= names->scattering[index];
	return res;
	/* PROTECTED REGION END */
}
char * get_parameter(struct cloognames* names, int index) {
	/* PROTECTED REGION ID(CloogUser_addons_get_parameter) ENABLED START */
	char* res= names->parameters[index];
	return res;
	/* PROTECTED REGION END */
}
char * get_iterator(struct cloognames* names, int index) {
	/* PROTECTED REGION ID(CloogUser_addons_get_iterator) ENABLED START */
	char* res= names->iterators[index];
	return res;
	/* PROTECTED REGION END */
}
int is_clast_guard(struct clast_stmt* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_guard) ENABLED START */
	return (stmt->op==&(stmt_guard));
	/* PROTECTED REGION END */
}
int is_clast_for(struct clast_stmt* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_for) ENABLED START */
	return (stmt->op==&(stmt_for));
	/* PROTECTED REGION END */
}
int is_clast_assignment(struct clast_stmt* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_assignment) ENABLED START */
	return (stmt->op==&(stmt_ass));
	/* PROTECTED REGION END */
}
int is_clast_user_stmt(struct clast_stmt* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_user_stmt) ENABLED START */
	return (stmt->op==&(stmt_user));
	/* PROTECTED REGION END */
}
int is_clast_block(struct clast_stmt* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_block) ENABLED START */
	return (stmt->op==&(stmt_block));
	/* PROTECTED REGION END */
}
int is_clast_root(struct clast_stmt* stmt) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_root) ENABLED START */
	return (stmt->op==&(stmt_root));
	/* PROTECTED REGION END */
}
int is_clast_expr_binary(struct clast_expr* expr) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_expr_binary) ENABLED START */
	return (expr->type==clast_expr_bin);
	/* PROTECTED REGION END */
}
int is_clast_expr_term(struct clast_expr* expr) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_expr_term) ENABLED START */
	return (expr->type==clast_expr_term);
	/* PROTECTED REGION END */
}
int is_clast_expr_reduction(struct clast_expr* expr) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_expr_reduction) ENABLED START */
	return (expr->type==clast_expr_red);
	/* PROTECTED REGION END */
}
int is_clast_expr_name(struct clast_expr* expr) {
	/* PROTECTED REGION ID(CloogUser_addons_is_clast_expr_name) ENABLED START */
	return (expr->type==clast_expr_name);
	/* PROTECTED REGION END */
}
