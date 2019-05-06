#include "ISLUser_codegen.h"

/* PROTECTED REGION ID(ISLUser_codegen_local) ENABLED START */
	/* Protected region for methods used locally in this file */
static void free_unscanned(void *user) {
	isl_union_set_free(user);
}

static isl_stat map_wise_is_bijective(__isl_take isl_map *map, void *user) {
        isl_bool r = isl_map_is_bijective(map);
        if (!r) *((int*)user) = 0;

        isl_map_free(map);

        return isl_stat_ok;
}

static __isl_give isl_ast_node *create_leaf_withExNodes(__isl_take isl_ast_build *build,
        void *user)
{
	static int count = 0;
	int i;
	char* exName = (char*)user;

	isl_ctx* ctx = isl_ast_build_get_ctx(build);
	isl_union_map* schedule = isl_ast_build_get_schedule(build);

	int bijective = 1;
	isl_union_map_foreach_map(schedule, map_wise_is_bijective, &bijective);

	//if all the statement instances are already schedule to have distinct time stamps
	// then complete the codegen with 0-d schedule
	// this code fragment comes from isl_test.c
	if (bijective) {
		isl_ast_node *node;
		isl_union_map* extra = isl_union_map_copy(schedule);
		extra = isl_union_map_from_domain(isl_union_map_domain(extra));
		schedule = isl_union_map_range_product(schedule, extra);
                node = isl_ast_build_node_from_schedule_map(build, schedule);

		isl_ast_build_free(build);

		return node;
	}

	//otherwise, create a function call node that take the surrounding loop indices
	// then and isl_id with the schedule relation as the user object is attached as annotation
	isl_space* sch_space = isl_ast_build_get_schedule_space(build);
	int ndim = isl_space_dim(sch_space, isl_dim_set);

	isl_ast_expr_list* args;
	for (i = 0; i < ndim; i++) {
		isl_id* dim = isl_space_get_dim_id(sch_space, isl_dim_set, i); 
		isl_ast_expr* dim_expr = isl_ast_expr_from_id(dim);
		if (i == 0) {
			args = isl_ast_expr_list_from_ast_expr(dim_expr);
		} else {
			args = isl_ast_expr_list_add(args, dim_expr);
		}   
	}
	if (ndim==0) {
		args = isl_ast_expr_list_alloc(ctx, 0);
	}

	char name[128];
	sprintf(name, "%s%02d", exName, count);
	isl_id* fname = isl_id_alloc(ctx, name, NULL);
	isl_ast_expr* f = isl_ast_expr_from_id(fname);
	isl_ast_expr* expr = isl_ast_expr_call(f, args);
	isl_ast_node* uNode = isl_ast_node_alloc_user(expr);

	isl_id* unscanned = isl_id_alloc(ctx, "unscanned", schedule);
        isl_id_set_free_user(unscanned, &free_unscanned);
	isl_ast_node_set_annotation(uNode, unscanned);

	isl_space_free(sch_space);
	isl_ast_build_free(build);

	count++;

	return uNode;
}
/* PROTECTED REGION END */

struct isl_ast_node* isl_ast_build_node_from_schedule_map_EX(struct isl_ast_build* build, isl_union_map* schedule, char * exName) {
	/* PROTECTED REGION ID(ISLUser_codegen_isl_ast_build_node_from_schedule_map_EX) ENABLED START */
        //isl_options_set_ast_build_group_coscheduled(ctx, 1);
        build = isl_ast_build_set_create_leaf(build, &create_leaf_withExNodes, exName);
        return isl_ast_build_node_from_schedule_map(build, schedule);
	/* PROTECTED REGION END */
}
struct isl_ast_node* isl_ast_build_node_from_schedule_EX(struct isl_ast_build* build, isl_schedule* schedule, char * exName) {
	/* PROTECTED REGION ID(ISLUser_codegen_isl_ast_build_node_from_schedule_EX) ENABLED START */
        //isl_options_set_ast_build_group_coscheduled(ctx, 1);
        build = isl_ast_build_set_create_leaf(build, &create_leaf_withExNodes, exName);
        return isl_ast_build_node_from_schedule(build, schedule);
	/* PROTECTED REGION END */
}
