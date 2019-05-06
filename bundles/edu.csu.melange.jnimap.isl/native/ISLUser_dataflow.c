#include "ISLUser_dataflow.h"

/*PROTECTED REGION ID(ISLUser_dataflow_local) ENABLED START*/
/* Protected region for methods used locally in this file */
void isl_dataflow_analysis_free(struct isl_dataflow_analysis *dfa) {
   isl_union_map_free(dfa->must_dep);
   isl_union_map_free(dfa->may_dep);
   isl_union_map_free(dfa->must_no_source);
   isl_union_map_free(dfa->may_no_source);
   free(dfa);
}
/*PROTECTED REGION END*/

isl_union_map* compute_ADA(isl_union_set* domains, isl_union_map* writes, isl_union_map* reads, isl_union_map* idSchedule, int memoryBased) {
/*PROTECTED REGION ID(ISLUser_dataflow_compute_ADA) ENABLED START*/
	isl_union_map *empty;

	isl_union_map *dep_raw,*dep_war,*dep_waw,*dep;

	writes = isl_union_map_intersect_domain(writes, isl_union_set_copy(domains));
	reads = isl_union_map_intersect_domain(reads, isl_union_set_copy(domains));

	empty = isl_union_map_empty(isl_union_map_get_space(idSchedule));
	isl_union_map_compute_flow(
			isl_union_map_copy(reads),
			isl_union_map_copy(writes),
			empty,
			isl_union_map_copy(idSchedule),
			&dep_raw, NULL, NULL, NULL);
	if (memoryBased) {
	isl_union_map_compute_flow(isl_union_map_copy(writes),
				   isl_union_map_copy(writes),
				   isl_union_map_copy(reads),
				   isl_union_map_copy(idSchedule),
				   &dep_waw, &dep_war, NULL, NULL);

		dep = isl_union_map_union(dep_waw, dep_war);
		dep = isl_union_map_union(dep, dep_raw);
		dep = isl_union_map_coalesce(dep);
	} else {
		dep = isl_union_map_coalesce(dep_raw);
	}

	isl_union_map_free(writes);
	isl_union_map_free(reads);
	isl_union_map_free(idSchedule);
	isl_union_set_free(domains);

	// isl computes dataflow prdg, therefore we have to reverse
	// it in order to have a real dependence graph
	dep = isl_union_map_reverse(dep);

	return dep;
/*PROTECTED REGION END*/	
}
isl_union_map* compute_ADA_custom(isl_union_set* domains, isl_union_map* writes, isl_union_map* reads, isl_union_map* idSchedule, int RAW, int WAW, int WAR) {
/*PROTECTED REGION ID(ISLUser_dataflow_compute_ADA_custom) ENABLED START*/
	isl_union_map *dep_raw,*dep_war,*dep_waw,*dep, *empty;

	writes = isl_union_map_intersect_domain(writes, isl_union_set_copy(domains));
	reads = isl_union_map_intersect_domain(reads, isl_union_set_copy(domains));

	dep = isl_union_map_empty(isl_union_map_get_space(idSchedule));
	empty = isl_union_map_empty(isl_union_map_get_space(idSchedule));
	if (RAW) {
        	isl_union_map_compute_flow(isl_union_map_copy(reads),
				   isl_union_map_copy(writes), empty,
				   isl_union_map_copy(idSchedule),
					   &dep_raw, NULL, NULL, NULL);
		dep = isl_union_map_union(dep, dep_raw);
        }
        if (WAW || WAR)  {
        	isl_union_map_compute_flow(isl_union_map_copy(writes),
				   isl_union_map_copy(writes),
				   isl_union_map_copy(reads),
				   isl_union_map_copy(idSchedule),
					   &dep_waw, &dep_war, NULL, NULL);
		if (WAW) {
			dep = isl_union_map_union(dep, dep_waw);
		}
		if (WAR) {
			dep = isl_union_map_union(dep, dep_war);
		}
	}


	dep = isl_union_map_coalesce(dep);

	isl_union_map_free(writes);
	isl_union_map_free(reads);
	isl_union_map_free(idSchedule);
	isl_union_set_free(domains);

	// isl computes dataflow prdg, therefore we have to reverse
	// it in order to have a real dependence graph
	dep = isl_union_map_reverse(dep);

	return dep;
/*PROTECTED REGION END*/	
}
isl_union_map* compute_ADA_custom_rar(isl_union_set* domains, isl_union_map* writes, isl_union_map* reads, isl_union_map* idSchedule, int RAW, int WAW, int WAR, int RAR) {
/*PROTECTED REGION ID(ISLUser_dataflow_compute_ADA_custom_rar) ENABLED START*/

	isl_union_map *dep_raw,*dep_war,*dep_waw, *dep_rar, *dep, *empty;

	writes = isl_union_map_intersect_domain(writes, isl_union_set_copy(domains));
	reads = isl_union_map_intersect_domain(reads, isl_union_set_copy(domains));

	dep = isl_union_map_empty(isl_union_map_get_space(idSchedule));
	empty = isl_union_map_empty(isl_union_map_get_space(idSchedule));
	if (RAW) {
	  	isl_union_map_compute_flow(isl_union_map_copy(reads),
	       isl_union_map_copy(writes), isl_union_map_copy(empty),
		   isl_union_map_copy(idSchedule), &dep_raw, NULL, NULL, NULL);
		dep = isl_union_map_union(dep, dep_raw);
	}
	if (WAW || WAR)  {
	  	isl_union_map_compute_flow(isl_union_map_copy(writes),
			   isl_union_map_copy(writes),
	     	   isl_union_map_copy(reads),
			   isl_union_map_copy(idSchedule),
			   &dep_waw, &dep_war, NULL, NULL);
		if (WAW) {
			dep = isl_union_map_union(dep, dep_waw);
		}
		if (WAR) {
			dep = isl_union_map_union(dep, dep_war);
		}
	}
	if ( RAR ) {
		isl_union_map_compute_flow(isl_union_map_copy(reads),
			       isl_union_map_copy(reads), isl_union_map_copy(empty),
				   isl_union_map_copy(idSchedule), &dep_rar, NULL, NULL, NULL);
		dep = isl_union_map_union(dep, dep_rar);
	}

	dep = isl_union_map_coalesce(dep);

	isl_union_map_free(writes);
	isl_union_map_free(reads);
	isl_union_map_free(idSchedule);
	isl_union_set_free(domains);



	// isl computes dataflow prdg, therefore we have to reverse
	// it in order to have a real dependence graph
	dep = isl_union_map_reverse(dep);

	return dep;
/*PROTECTED REGION END*/	
}
struct isl_dataflow_analysis* alloc_dataflow_analysis() {
/*PROTECTED REGION ID(ISLUser_dataflow_alloc_dataflow_analysis) ENABLED START*/
	return (struct isl_dataflow_analysis*) malloc (sizeof(struct isl_dataflow_analysis));
/*PROTECTED REGION END*/	
}
struct isl_dataflow_analysis* isl_array_dataflow_analysis(isl_union_map* sink, isl_union_map* must_source, isl_union_map* may_source, isl_union_map* schedule) {
/*PROTECTED REGION ID(ISLUser_dataflow_isl_array_dataflow_analysis) ENABLED START*/
	struct isl_dataflow_analysis* res = alloc_dataflow_analysis();

	isl_union_map_compute_flow(
			sink,
			must_source,
			may_source,
			schedule,
			&res->must_dep,
			&res->may_dep,
			(struct isl_union_map **)&res->must_no_source,
			(struct isl_union_map **)&res->may_no_source
		);

	return res;
/*PROTECTED REGION END*/	
}
