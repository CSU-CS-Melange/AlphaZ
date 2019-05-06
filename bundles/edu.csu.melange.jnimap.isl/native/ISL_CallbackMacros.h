#ifndef ISL_CALLBACKS
#define ISL_CALLBACKS
struct res_t {
	int pos;
	void* ptr;
};

#define NUMBEROF(a,b,o)\
		struct res_t res;\
		res.ptr=(void *)NULL;\
		res.pos=0;\
		a##_foreach_##b(o, (int (*)(struct isl_##b *, void*)) a##_get_number_of_##b##_callback,&res);\
		return  res.pos;


#define GET_AT(a,b,c,o,p) \
	struct res_t res;\
	res.ptr=NULL;\
	res.pos=p;\
	a##_foreach_##b(o,(int (*)(isl_##b *, void*)) a##_get_##b##_at_callback, &res);\
	return (c *) res.ptr;

#define GET_AT_CALLBACK(a,b) \
int a##_get_##b##_at_callback(isl_##b * current, void* v) {\
   struct res_t* res = (struct res_t*) v;\
   if (res->pos > 0) {\
      (res->pos)--;\
      isl_##b##_free(current);\
   } else if (res->pos==0) {\
      if (res->ptr == NULL) {\
         res->ptr=current;\
      } else {\
        isl_##b##_free(current);\
      }\
   } else {\
     res->ptr=NULL;\
     isl_##b##_free(current);\
   }\
   return 0;\
}

#define NUMBER_OF_CALLBACK(a,b) \
int a##_get_number_of_##b##_callback(isl_##b * current, void* v) {\
   struct res_t* res = (struct res_t*) v;\
   (res->pos)++;\
   isl_##b##_free(current);\
   return res->pos;\
}

#endif


