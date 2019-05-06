#include "ISLUser_vertices.h"

/*PROTECTED REGION ID(ISLUser_vertices_local) ENABLED START*/
/* Protected region for methods used locally in this file */
#define NUMBEROF(a,b,o)\
		struct res_t_spec_vertices res;\
		res.ptr=(void *)NULL;\
		res.pos=0;\
		a##_foreach_##b(o, &number_of_callback_spec_vertices,&res);\
		return  res.pos;


#define GET_AT(a,b,c,o,p) \
	struct res_t_spec_vertices res;\
	res.ptr=NULL;\
	res.pos=p;\
	a##_foreach_##b(o, &get_at_callback_spec_vertices, &res);\
	return (c *) res.ptr;

int get_at_callback_spec_vertices(isl_vertex *current, void* v ) {
#ifdef DEBUG
	printf("In get_at_callback res->pos=%d,current=%08X\n",res->pos,current);fflush(stdout);
#endif
	struct res_t_spec_vertices* res = (struct res_t_spec_vertices*) v;
	if(res->pos>0) {
		(res->pos)--;
		isl_vertex_free(current);
	} else if(res->pos==0){
		if(res->ptr==NULL) {
			res->ptr=current;
#ifdef DEBUG
			printf("\tpos=0 returning current=%08X\n",current);fflush(stdout);
#endif
		} else {
			isl_vertex_free(current);
		}
	} else {
		res->ptr=NULL;
		isl_vertex_free(current);
	}
	return res->pos;
}


int number_of_callback_spec_vertices(isl_vertex *current, void* v ) {
	struct res_t_spec_vertices* res = (struct res_t_spec_vertices*) v;
	(res->pos)++;
	isl_vertex_free(current);
	return res->pos;
}

/*PROTECTED REGION END*/	

isl_vertex* isl_vertices_get_vertex_at(isl_vertices* vertices, int pos) {
/*PROTECTED REGION ID(ISLUser_vertices_isl_vertices_get_vertex_at) ENABLED START*/
	GET_AT(isl_vertices,vertex,isl_vertex,vertices,pos)

/*PROTECTED REGION END*/	
}
isl_vertex* isl_cell_get_vertex_at(isl_cell* cell, int pos) {
/*PROTECTED REGION ID(ISLUser_vertices_isl_cell_get_vertex_at) ENABLED START*/
	GET_AT(isl_cell,vertex,isl_vertex,cell,pos)
/*PROTECTED REGION END*/	
}
int isl_vertices_numberof_vertex(isl_vertices* vertices) {
/*PROTECTED REGION ID(ISLUser_vertices_isl_vertices_numberof_vertex) ENABLED START*/
	NUMBEROF(isl_vertices,vertex,vertices)
/*PROTECTED REGION END*/	
}
int isl_cell_numberof_vertex(isl_cell* cell) {
/*PROTECTED REGION ID(ISLUser_vertices_isl_cell_numberof_vertex) ENABLED START*/
	NUMBEROF(isl_cell,vertex,cell)
/*PROTECTED REGION END*/	
}
