#include "ISLUser_ast.h"

/*PROTECTED REGION ID(ISLUser_ast_local) ENABLED START*/
GET_AT_CALLBACK(isl_ast_node_list, ast_node);
NUMBER_OF_CALLBACK(isl_ast_node_list, ast_node);
/*PROTECTED REGION END*/	

int isl_ast_node_is_for(struct isl_ast_node* node) {
/*PROTECTED REGION ID(ISLUser_ast_isl_ast_node_is_for) ENABLED START*/
	if(node!=NULL) {
		return (isl_ast_node_get_type(node)==isl_ast_node_for);
	} else {
		return 0;
	}
/*PROTECTED REGION END*/	
}
int isl_ast_node_is_if(struct isl_ast_node* node) {
/*PROTECTED REGION ID(ISLUser_ast_isl_ast_node_is_if) ENABLED START*/
	if(node!=NULL) {
		return (isl_ast_node_get_type(node)==isl_ast_node_if);
	} else {
		return 0;
	}
/*PROTECTED REGION END*/	
}
int isl_ast_node_is_block(struct isl_ast_node* node) {
/*PROTECTED REGION ID(ISLUser_ast_isl_ast_node_is_block) ENABLED START*/
	if(node!=NULL) {
		return (isl_ast_node_get_type(node)==isl_ast_node_block);
	} else {
		return 0;
	}
/*PROTECTED REGION END*/	
}
int isl_ast_node_is_user(struct isl_ast_node* node) {
/*PROTECTED REGION ID(ISLUser_ast_isl_ast_node_is_user) ENABLED START*/
	if(node!=NULL) {
		return (isl_ast_node_get_type(node)==isl_ast_node_user);
	} else {
		return 0;
	}
/*PROTECTED REGION END*/	
}
int isl_ast_expr_is_id(struct isl_ast_expr* e) {
/*PROTECTED REGION ID(ISLUser_ast_isl_ast_expr_is_id) ENABLED START*/
	if(e!=NULL) {
		return (isl_ast_expr_get_type(e)==isl_ast_expr_id);
	} else {
		return 0;
	}
/*PROTECTED REGION END*/	
}
int isl_ast_expr_is_operation(struct isl_ast_expr* e) {
/*PROTECTED REGION ID(ISLUser_ast_isl_ast_expr_is_operation) ENABLED START*/
	if(e!=NULL) {
		return (isl_ast_expr_get_type(e)==isl_ast_expr_op);
	} else {
		return 0;
	}
/*PROTECTED REGION END*/	
}
int isl_ast_expr_is_literal(struct isl_ast_expr* e) {
/*PROTECTED REGION ID(ISLUser_ast_isl_ast_expr_is_literal) ENABLED START*/
	if(e!=NULL) {
		return (isl_ast_expr_get_type(e)==isl_ast_expr_int);
	} else {
		return 0;
	}
/*PROTECTED REGION END*/	
}
isl_union_map* isl_ast_node_user_get_schedule(struct isl_ast_node* node) {
	/* PROTECTED REGION ID(ISLUser_ast_isl_ast_node_user_get_schedule) ENABLED START */
	if (!isl_ast_node_is_unscanned(node)) {
		return NULL;
	}
	isl_id *ann = isl_ast_node_get_annotation(node);
	isl_union_map* schedule = (isl_union_map*)isl_id_get_user(ann);

	isl_id_free(ann);
	return schedule;
	/* PROTECTED REGION END */
}
int isl_ast_node_is_unscanned(struct isl_ast_node* node) {
	/* PROTECTED REGION ID(ISLUser_ast_isl_ast_node_is_unscanned) ENABLED START */
	isl_id *ann = isl_ast_node_get_annotation(node);
	if (ann == NULL) return 0;

        int res = (strcmp(isl_id_get_name(ann), "unscanned") == 0);
	isl_id_free(ann);
	return res;
	/* PROTECTED REGION END */
}
