#include "ISLUser_transitive_closure.h"

/*PROTECTED REGION ID(ISLUser_transitive_closure_local) ENABLED START*/
/* Protected region for methods used locally in this file */
/*PROTECTED REGION END*/	

struct isl_transitive_closure_result* alloc_isl_transitive_closure_result() {
/*PROTECTED REGION ID(ISLUser_transitive_closure_alloc_isl_transitive_closure_result) ENABLED START*/
	struct isl_transitive_closure_result* r =
			(struct isl_transitive_closure_result*) malloc (sizeof(struct isl_transitive_closure_result));
	r->exact=0;
	r->map=NULL;
	r->umap=NULL;
	return r;
/*PROTECTED REGION END*/	
}
void free_isl_transitive_closure_result(struct isl_transitive_closure_result* result) {
/*PROTECTED REGION ID(ISLUser_transitive_closure_free_isl_transitive_closure_result) ENABLED START*/
	free(result);
/*PROTECTED REGION END*/	
}
struct isl_transitive_closure_result* isl_basic_map_transitive_closure_jnimap(isl_basic_map* map) {
/*PROTECTED REGION ID(ISLUser_transitive_closure_isl_basic_map_transitive_closure_jnimap) ENABLED START*/
	return NULL;
/*PROTECTED REGION END*/	
}
struct isl_transitive_closure_result* isl_map_transitive_closure_jnimap(isl_map* map) {
/*PROTECTED REGION ID(ISLUser_transitive_closure_isl_map_transitive_closure_jnimap) ENABLED START*/
	printf("test_0\n");fflush(stdout);
	struct isl_transitive_closure_result* res = alloc_isl_transitive_closure_result();
	printf("test_1\n");fflush(stdout);
	isl_map *closure = isl_map_transitive_closure(map, &res->exact);
	printf("test_2\n");fflush(stdout);
	if(closure==NULL) {
		printf("No closure found\n");fflush(stdout);
	}
	printf("test_3\n");fflush(stdout);
	res->map = closure;
	printf("test_4\n");fflush(stdout);
	return res;
/*PROTECTED REGION END*/	
}
struct isl_transitive_closure_result* isl_union_map_transitive_closure_jnimap(isl_union_map* map) {
/*PROTECTED REGION ID(ISLUser_transitive_closure_isl_union_map_transitive_closure_jnimap) ENABLED START*/
	printf("test_0\n");fflush(stdout);
	struct isl_transitive_closure_result* res = alloc_isl_transitive_closure_result();
	printf("test_1\n");fflush(stdout);
	isl_union_map *closure = isl_union_map_transitive_closure(map, &res->exact);
	printf("test_2\n");fflush(stdout);
	if(closure==NULL) {
		printf("No closure found\n");fflush(stdout);
	}
	printf("test_3\n");fflush(stdout);
	res->umap = closure;
	printf("test_4\n");fflush(stdout);
	return res;
/*PROTECTED REGION END*/	
}
