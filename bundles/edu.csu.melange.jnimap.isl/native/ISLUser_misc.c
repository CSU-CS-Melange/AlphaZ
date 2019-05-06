#include "ISLUser_misc.h"

/*PROTECTED REGION ID(ISLUser_misc_local) ENABLED START*/
/* Protected region for methods used locally in this file */

/*PROTECTED REGION END*/	

void init_isl_error_handler() {
/*PROTECTED REGION ID(ISLUser_misc_init_isl_error_handler) ENABLED START*/

/*PROTECTED REGION END*/	
}
isl_set* clear_tuple_name(isl_set* s) {
/*PROTECTED REGION ID(ISLUser_misc_clear_tuple_name) ENABLED START*/
	return isl_set_set_tuple_name(s,NULL);
/*PROTECTED REGION END*/	
}
isl_map* clear_in_tuple_name(isl_map* m) {
/*PROTECTED REGION ID(ISLUser_misc_clear_in_tuple_name) ENABLED START*/
	return isl_map_set_tuple_name(m,isl_dim_in,NULL);
/*PROTECTED REGION END*/	
}
isl_map* clear_out_tuple_name(isl_map* m) {
/*PROTECTED REGION ID(ISLUser_misc_clear_out_tuple_name) ENABLED START*/
	return isl_map_set_tuple_name(m,isl_dim_out,NULL);
/*PROTECTED REGION END*/	
}
