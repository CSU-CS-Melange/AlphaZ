#include "ISLUser_collections.h"

/*PROTECTED REGION ID(ISLUser_collections_local) ENABLED START*/
/* Protected region for methods used locally in this file */


GET_AT_CALLBACK(isl_basic_set,constraint)
GET_AT_CALLBACK(isl_basic_map,constraint)
GET_AT_CALLBACK(isl_set,basic_set)
GET_AT_CALLBACK(isl_map,basic_map)
GET_AT_CALLBACK(isl_union_set,set)
GET_AT_CALLBACK(isl_union_map,map)
GET_AT_CALLBACK(isl_vertices,cell)
GET_AT_CALLBACK(isl_union_set,point)
GET_AT_CALLBACK(isl_set,point)

NUMBER_OF_CALLBACK(isl_basic_map,constraint)
NUMBER_OF_CALLBACK(isl_map,basic_map)
//NUMBER_OF_CALLBACK(isl_basic_set,constraint)
//NUMBER_OF_CALLBACK(isl_set,basic_set)
//NUMBER_OF_CALLBACK(isl_union_set,set)
//NUMBER_OF_CALLBACK(isl_union_map,map)
NUMBER_OF_CALLBACK(isl_vertices,cell)
NUMBER_OF_CALLBACK(isl_union_set,point)
NUMBER_OF_CALLBACK(isl_set,point)

//for PWMultiAff, it takes two args, and thus the macro cannot be used
int isl_pw_multi_aff_get_piece_at_callback(isl_set *set, isl_multi_aff *maff, void* v) {
   struct res_t* res = (struct res_t*) v;
   if (res->pos > 0) {
      (res->pos)--;
      isl_set_free(set);
      isl_multi_aff_free(maff);
   } else if (res->pos==0) {
      if (res->ptr == NULL) {
         struct isl_pw_multi_aff_piece* piece = (struct isl_pw_multi_aff_piece*) malloc(sizeof(struct isl_pw_multi_aff_piece));
         piece->set=set;
         piece->maff=maff;
         res->ptr=piece;

      } else {
         isl_set_free(set);
         isl_multi_aff_free(maff);
      }
   } else {
     res->ptr=NULL;
     isl_set_free(set);
     isl_multi_aff_free(maff);
   }
   return 0;
}

int isl_pw_multi_aff_get_number_of_piece_callback(isl_set *set, isl_multi_aff *maff, void* v) {
   struct res_t* res = (struct res_t*) v;
   (res->pos)++;
   isl_set_free(set);
   isl_multi_aff_free(maff);
   return res->pos;
}


void isl_pw_multi_aff_piece_free(struct isl_pw_multi_aff_piece* pmap) {
   isl_set_free(pmap->set);
   isl_multi_aff_free(pmap->maff);
   free(pmap);
}
/*PROTECTED REGION END*/	

isl_constraint* isl_basic_set_get_constraint_at(isl_basic_set* bset, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_basic_set_get_constraint_at) ENABLED START*/
	GET_AT(isl_basic_set,constraint,isl_constraint, bset,pos)
/*PROTECTED REGION END*/	
}
isl_constraint* isl_basic_map_get_constraint_at(isl_basic_map* bmap, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_basic_map_get_constraint_at) ENABLED START*/
	GET_AT(isl_basic_map,constraint,isl_constraint, bmap,pos)
/*PROTECTED REGION END*/	
}
isl_basic_set* isl_set_get_basic_set_at(isl_set* set, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_set_get_basic_set_at) ENABLED START*/
	GET_AT(isl_set,basic_set,isl_basic_set, set,pos)
/*PROTECTED REGION END*/	
}
isl_basic_map* isl_map_get_basic_map_at(isl_map* map, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_map_get_basic_map_at) ENABLED START*/
	GET_AT(isl_map,basic_map,isl_basic_map, map,pos)
/*PROTECTED REGION END*/	
}
isl_set* isl_union_set_get_set_at(isl_union_set* uset, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_union_set_get_set_at) ENABLED START*/
	GET_AT(isl_union_set,set,isl_set,uset,pos)
/*PROTECTED REGION END*/	
}
isl_map* isl_union_map_get_map_at(isl_union_map* umap, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_union_map_get_map_at) ENABLED START*/
	GET_AT(isl_union_map,map,isl_map,umap,pos)
/*PROTECTED REGION END*/	
}
int isl_basic_map_numberof_constraint(isl_basic_map* bmap) {
/*PROTECTED REGION ID(ISLUser_collections_isl_basic_map_numberof_constraint) ENABLED START*/
	NUMBEROF(isl_basic_map,constraint, bmap)
/*PROTECTED REGION END*/	
}
int isl_map_numberof_basic_map(isl_map* map) {
/*PROTECTED REGION ID(ISLUser_collections_isl_map_numberof_basic_map) ENABLED START*/
	NUMBEROF(isl_map,basic_map, map)
/*PROTECTED REGION END*/	
}
int isl_pw_multi_aff_numberof_piece(isl_pw_multi_aff* pma) {
	/* PROTECTED REGION ID(ISLUser_collections_isl_pw_multi_aff_numberof_piece) ENABLED START */
	struct res_t res;
	res.ptr=NULL;
	res.pos=0;
	isl_pw_multi_aff_foreach_piece(pma, isl_pw_multi_aff_get_number_of_piece_callback, &res);
	return res.pos;
	/* PROTECTED REGION END */
}
struct isl_pw_multi_aff_piece* isl_pw_multi_aff_get_piece_at(isl_pw_multi_aff* pma, int pos) {
	/* PROTECTED REGION ID(ISLUser_collections_isl_pw_multi_aff_get_piece_at) ENABLED START */
	struct res_t res;
	res.ptr=NULL;
	res.pos=pos;
	isl_pw_multi_aff_foreach_piece(pma, isl_pw_multi_aff_get_piece_at_callback, &res);
	return (struct isl_pw_multi_aff_piece *) res.ptr;
	/* PROTECTED REGION END */
}
int isl_vertices_numberof_cell(isl_vertices* vertices) {
/*PROTECTED REGION ID(ISLUser_collections_isl_vertices_numberof_cell) ENABLED START*/
	NUMBEROF(isl_vertices,cell,vertices)
/*PROTECTED REGION END*/	
}
isl_cell* isl_vertices_get_cell_at(isl_vertices* vertices, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_vertices_get_cell_at) ENABLED START*/
	GET_AT(isl_vertices,cell,isl_cell,vertices,pos)
/*PROTECTED REGION END*/	
}
int isl_union_set_numberof_points(isl_union_set* uset) {
/*PROTECTED REGION ID(ISLUser_collections_isl_union_set_numberof_points) ENABLED START*/
	NUMBEROF(isl_union_set,point,uset)
/*PROTECTED REGION END*/	
}
isl_point* isl_union_set_get_point_at(isl_union_set* uset, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_union_set_get_point_at) ENABLED START*/
	GET_AT(isl_union_set,point,isl_point,uset,pos)
/*PROTECTED REGION END*/	
}
int isl_set_numberof_points(isl_set* set) {
/*PROTECTED REGION ID(ISLUser_collections_isl_set_numberof_points) ENABLED START*/
	NUMBEROF(isl_set,point,set)
/*PROTECTED REGION END*/	
}
isl_point* isl_set_get_point_at(isl_set* set, int pos) {
/*PROTECTED REGION ID(ISLUser_collections_isl_set_get_point_at) ENABLED START*/
	GET_AT(isl_set,point,isl_point,set,pos)
/*PROTECTED REGION END*/	
}
