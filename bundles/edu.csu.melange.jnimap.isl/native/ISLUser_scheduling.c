#include "ISLUser_scheduling.h"

/*PROTECTED REGION ID(ISLUser_scheduling_local) ENABLED START*/
/* Protected region for methods used locally in this file */

/*PROTECTED REGION END*/	

isl_schedule* isl_compute_schedule(isl_ctx* ctx, isl_union_set* domain, isl_union_map* validity, isl_union_map* proximity, int max_coefficient, int max_constant_term, int fuse, int maximize_band_depth, int outer_coincidence, int split_scaled, int algorithm, int separate_components) {
/*PROTECTED REGION ID(ISLUser_scheduling_isl_compute_schedule) ENABLED START*/
	//ignore proximity argument

	//set options
//    isl_options_set_schedule_max_coefficient(ctx, max_coefficient);
//	isl_options_set_schedule_max_constant_term(ctx, max_constant_term);
//	isl_options_set_schedule_fuse(ctx, fuse);
//    isl_options_set_schedule_maximize_band_depth(ctx, maximize_band_depth);
//    isl_options_set_schedule_outer_coincidence(ctx, outer_coincidence);
//    isl_options_set_schedule_split_scaled(ctx, split_scaled);
//    isl_options_set_schedule_algorithm(ctx, algorithm);
//	isl_options_set_schedule_separate_components(ctx, separate_components);



	//TODO remove 'fuse' from parameters and add the following: maximize_coincidence, treat_coalescing, serialize_sccs, whole_component
//	int maximize_coincidence = 0;
//	int treat_coalescing = 0;
//	int serialize_sccs = 0;
//	int whole_component = 0;

	isl_options_set_schedule_algorithm			 (ctx, algorithm		   );
	isl_options_set_schedule_max_coefficient     (ctx, max_coefficient     );
	isl_options_set_schedule_max_constant_term   (ctx, max_constant_term   );
	isl_options_set_schedule_maximize_band_depth (ctx, maximize_band_depth );
//	isl_options_set_schedule_maximize_coincidence(ctx, maximize_coincidence); //NEW
	isl_options_set_schedule_outer_coincidence   (ctx, outer_coincidence   );
	isl_options_set_schedule_split_scaled        (ctx, split_scaled        );
//	isl_options_set_schedule_treat_coalescing    (ctx, treat_coalescing    ); //NEW
	isl_options_set_schedule_separate_components (ctx, separate_components );
//	isl_options_set_schedule_serialize_sccs      (ctx, serialize_sccs      ); //NEW
//	isl_options_set_schedule_whole_component     (ctx, whole_component     ); //NEW


    //reverse prdg : isl needs a dataflow graph, not a dependence one
    validity = isl_union_map_reverse(validity);
    proximity = isl_union_map_reverse(proximity);

    //****** used for debug ****
	//prints domains
	struct isl_printer *pr = isl_printer_to_str(ctx);
	pr = isl_printer_set_output_format(pr, 0);
	isl_printer_print_union_set(pr,domain);
	char *domBuffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);
	//prints prdg
	pr = isl_printer_to_str(ctx);
	pr = isl_printer_set_output_format(pr, 0);
	isl_printer_print_union_map(pr,validity);
	char *prdgBuffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);
	//prints proximity
	pr = isl_printer_to_str(ctx);
	pr = isl_printer_set_output_format(pr, 0);
	isl_printer_print_union_map(pr,proximity);
	char *proxBuffer = isl_printer_get_str(pr);
	isl_printer_flush(pr);
	isl_printer_free(pr);


    //compute schedule & return
	isl_schedule_constraints * constraints = isl_schedule_constraints_on_domain(domain);
	constraints = isl_schedule_constraints_set_validity(constraints,validity);
	//constraints = isl_schedule_constraints_set_proximity(constraints,proximity);
	isl_schedule* result = isl_schedule_constraints_compute_schedule(constraints);

	/*
    int dump = (result == NULL);
    if (dump) {
    	//prints test C program
        printf("//******** TEST PROGRAM *********\n");
    	printf("#include <stdio.h>\n");
    	printf("#include <isl/ctx.h>\n");
    	printf("#include <isl/version.h>\n");
    	printf("#include <isl/set.h>\n");
    	printf("#include <isl/schedule.h>\n");
    	printf("#include <isl/options.h>\n");
    	printf("\n");
    	printf("int main() {\n");
    	printf("\tprintf(\"Start.\\n\");\n");
    	printf("\tprintf(\"isl version = %%s\\n\",isl_version());\n");
        printf("\tisl_ctx* ctx = isl_ctx_alloc();\n\n");
        printf("\tisl_options_set_schedule_max_coefficient(ctx, %d);\n",max_coefficient);
        printf("\tisl_options_set_schedule_max_constant_term(ctx, %d);\n",max_constant_term);
        printf("\tisl_options_set_schedule_fuse(ctx, %d);\n",fuse);
        printf("\tisl_options_set_schedule_maximize_band_depth(ctx, %d);\n",maximize_band_depth);
        printf("\tisl_options_set_schedule_outer_coincidence(ctx, %d);\n",outer_coincidence);
        printf("\tisl_options_set_schedule_split_scaled(ctx, %d);\n",split_scaled);
        printf("\tisl_options_set_schedule_algorithm(ctx, %s);\n",(algorithm==1)?("ISL_SCHEDULE_ALGORITHM_FEAUTRIER"):("ISL_SCHEDULE_ALGORITHM_ISL"));
        printf("\tisl_options_set_schedule_separate_components(ctx, %d);\n",separate_components);
        printf("\tchar* strDomains = \"%s\";\n",domBuffer);
        printf("\tchar* strPrdg = \"%s\";\n",prdgBuffer);
        printf("\tchar* strProximity = \"%s\";\n",proxBuffer);
        printf("\n");
        printf("\tisl_union_set* domain = isl_union_set_read_from_str(ctx,strDomains);\n");
        printf("\tisl_union_map* validity = isl_union_map_read_from_str(ctx,strPrdg);\n");
        printf("\tisl_union_map* proximity = isl_union_map_read_from_str(ctx,strProximity);\n");
        printf("\n");
        printf("\tprintf(\"input domains:\\n\");\n");
        printf("\tisl_union_set_dump(domain);\n");
        printf("\tprintf(\"input dependences (validity):\\n\");\n");
        printf("\tisl_union_map_dump(validity);\n");
        printf("\tprintf(\"input dependences (proximity):\\n\");\n");
        printf("\tisl_union_map_dump(proximity);\n");
        printf("\n");
        printf("\tisl_schedule_constraints * constraints = isl_schedule_constraints_on_domain(domain);\n");
        printf("\tconstraints = isl_schedule_constraints_set_validity(constraints,validity);\n");
        printf("\tconstraints = isl_schedule_constraints_set_proximity(constraints,proximity);\n");
        printf("\tisl_schedule* result = isl_schedule_constraints_compute_schedule(constraints);\n");
        printf("\n");
    	printf("\tprintf(\"\\nresult schedule:\\n\");\n");
        printf("\tisl_schedule_dump(result);\n");
        printf("\tisl_schedule_free(result);\n");
        printf("\n");
        printf("\tisl_ctx_free(ctx);\n");
        printf("\tprintf(\"Done.\\n\");\n");
        printf("\treturn 0;\n");
        printf("}\n");
        printf("//******** END OF TEST *********\n");
        printf("\n");
        fflush(stdout);
    }
	//*/
	return result;
/*PROTECTED REGION END*/	
}
