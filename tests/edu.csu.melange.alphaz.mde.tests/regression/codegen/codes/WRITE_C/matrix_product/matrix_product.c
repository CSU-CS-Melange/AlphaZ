// This file is generated from test alphabets program by code generator in alphaz
// To compile this code, use -lm option for math library.

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>
#include <limits.h>
#include <float.h>


// Common Macros
#define max(x, y)   ((x)>(y) ? (x) : (y))
#define MAX(x, y)	((x)>(y) ? (x) : (y))
#define min(x, y)   ((x)>(y) ? (y) : (x))
#define MIN(x, y)	((x)>(y) ? (y) : (x))
#define CEILD(n,d)  (int)ceil(((double)(n))/((double)(d)))
#define ceild(n,d)  (int)ceil(((double)(n))/((double)(d)))
#define FLOORD(n,d) (int)floor(((double)(n))/((double)(d)))
#define floord(n,d) (int)floor(((double)(n))/((double)(d)))
#define CDIV(x,y)    CEILD((x),(y))
#define div(x,y)    CDIV((x),(y))
#define FDIV(x,y)    FLOORD((x),(y))
#define LB_SHIFT(b,s)  ((int)ceild(b,s) * s)
#define MOD(i,j)   ((i)%(j))
#define mallocCheck(v,s,d) if ((v) == NULL) { printf("Failed to allocate memory for %s : size=%lu\n", "sizeof(d)*(s)", sizeof(d)*(s)); exit(-1); }

// Common functions for min and max
//functions for integer max
inline int __max_int(int x, int y){
	return ((x)>(y) ? (x) : (y));
}

inline short __max_short(short x, short y){
	return ((x)>(y) ? (x) : (y));
}

inline long __max_long(long x, long y){
	return ((x)>(y) ? (x) : (y));
}

inline unsigned int __max_unsigned_int(unsigned int x, unsigned int y){
	return ((x)>(y) ? (x) : (y));
}

inline unsigned short __max_unsigned_short(unsigned short x, unsigned short y){
	return ((x)>(y) ? (x) : (y));
}

//function for float max
inline float __max_float(float x, float y){
	return ((x)>(y) ? (x) : (y));
}

//function for double max
inline double __max_double(double x, double y){
	return ((x)>(y) ? (x) : (y));
}

//function for integer min
inline int __min_int(int x, int y){
	return ((x)>(y) ? (y) : (x));
}

inline short __min_short(short x, short y){
	return ((x)>(y) ? (y) : (x));
}

inline long __min_long(long x, long y){
	return ((x)>(y) ? (y) : (x));
}

inline unsigned int __min_unsigned_int(unsigned int x, unsigned int y){
	return ((x)>(y) ? (y) : (x));
}

inline unsigned short __min_unsigned_short(unsigned short x, unsigned short y){
	return ((x)>(y) ? (y) : (x));
}

inline unsigned long __min_unsigned_long(unsigned long x, unsigned long y){
	return ((x)>(y) ? (y) : (x));
}

inline float __min_float(float x, float y){
	return ((x)>(y) ? (y) : (x));
}

inline double __min_double(double x, double y){
	return ((x)>(y) ? (y) : (x));
}



///Global Variables
static float** A;
static float** B;
static float*** temp_C;
static float** Cspace;
static char** _flag_Cspace;
static char*** _flag_temp_C;


//Local Function Declarations
float eval_temp_C(long, long, long, int, int, int);
float eval_C(long, long, long, int, int, int);

//Memory Macros
#define A(i,k) A[i][k]
#define B(k,j) B[k][j]
#define temp_C(i,j,k) temp_C[i][j][k]
#define Cspace(i,j) Cspace[i][j]
#define _flag_Cspace(i,j) _flag_Cspace[i][j]
#define _flag_temp_C(i,j,k) _flag_temp_C[i][j][k]

void matrix_product(long P, long Q, long R, float** _local_A, float** _local_B, float** _local_Cspace){
	///Parameter checking
	if (!((P >= 2 && Q >= 2 && R >= 2))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	//Copy to global
	A = _local_A;
	B = _local_B;
	Cspace = _local_Cspace;
	
	//Memory Allocation
	int mz1, mz2, mz3;
	
	float* _lin_temp_C = (float*)malloc(sizeof(float)*((P) * (R) * (Q+1)));
	mallocCheck(_lin_temp_C, ((P) * (R) * (Q+1)), float);
	temp_C = (float***)malloc(sizeof(float**)*(P));
	mallocCheck(temp_C, (P), float**);
	for (mz1=0;mz1 < P; mz1++) {
		temp_C[mz1] = (float**)malloc(sizeof(float*)*(R));
		mallocCheck(temp_C[mz1], (R), float*);
		for (mz2=0;mz2 < R; mz2++) {
			temp_C[mz1][mz2] = &_lin_temp_C[(mz1*((R) * (Q+1))) + (mz2*(Q+1))];
		}
	}
	
	char* _lin__flag_Cspace = (char*)malloc(sizeof(char)*((P) * (R)));
	mallocCheck(_lin__flag_Cspace, ((P) * (R)), char);
	_flag_Cspace = (char**)malloc(sizeof(char*)*(P));
	mallocCheck(_flag_Cspace, (P), char*);
	for (mz1=0;mz1 < P; mz1++) {
		_flag_Cspace[mz1] = &_lin__flag_Cspace[(mz1*(R))];
	}
	memset(_lin__flag_Cspace, 'N', ((P) * (R)));
	
	char* _lin__flag_temp_C = (char*)malloc(sizeof(char)*((P) * (R) * (Q+1)));
	mallocCheck(_lin__flag_temp_C, ((P) * (R) * (Q+1)), char);
	_flag_temp_C = (char***)malloc(sizeof(char**)*(P));
	mallocCheck(_flag_temp_C, (P), char**);
	for (mz1=0;mz1 < P; mz1++) {
		_flag_temp_C[mz1] = (char**)malloc(sizeof(char*)*(R));
		mallocCheck(_flag_temp_C[mz1], (R), char*);
		for (mz2=0;mz2 < R; mz2++) {
			_flag_temp_C[mz1][mz2] = &_lin__flag_temp_C[(mz1*((R) * (Q+1))) + (mz2*(Q+1))];
		}
	}
	memset(_lin__flag_temp_C, 'N', ((P) * (R) * (Q+1)));
	#define S0(i,j,k) eval_C(P,Q,R,i,j,k)
	{
		//Domain
		//{i,j,k|k==Q+1 && i>=0 && P>=i+1 && j>=0 && R>=j+1 && P>=2 && Q>=2 && R>=2}
		int c1,c2;
		for(c1=0;c1 <= P-1;c1+=1)
		 {
		 	for(c2=0;c2 <= R-1;c2+=1)
		 	 {
		 	 	S0((c1),(c2),(Q+1));
		 	 }
		 }
	}
	#undef S0
	
	//Memory Free
	free(_lin_temp_C);
	for (mz1=0;mz1 < P; mz1++) {
		free(temp_C[mz1]);
	}
	free(temp_C);
	
	free(_lin__flag_Cspace);
	free(_flag_Cspace);
	
	free(_lin__flag_temp_C);
	for (mz1=0;mz1 < P; mz1++) {
		free(_flag_temp_C[mz1]);
	}
	free(_flag_temp_C);
}
float eval_temp_C(long P, long Q, long R, int i, int j, int k){
	if ( _flag_temp_C(i,j,k) == 'N' ) {
		_flag_temp_C(i,j,k) = 'I';
	//Body for temp_C
		temp_C(i,j,k) = (((k >= 1))?(eval_temp_C(P,Q,R,i,j,k-1))+((A(i,k-1))*(B(k-1,j))):(0));
		_flag_temp_C(i,j,k) = 'F';
	} else if ( _flag_temp_C(i,j,k) == 'I' ) {
		printf("There is a self dependence on temp_C at (%d,%d,%d) \n",i,j,k);
		exit(-1);
	}
	return temp_C(i,j,k);
}
float eval_C(long P, long Q, long R, int i, int j, int k){
	if ( _flag_Cspace(i,j) == 'N' ) {
		_flag_Cspace(i,j) = 'I';
	//Body for C
		Cspace(i,j) = eval_temp_C(P,Q,R,i,j,k-1);
		_flag_Cspace(i,j) = 'F';
	} else if ( _flag_Cspace(i,j) == 'I' ) {
		printf("There is a self dependence on C at (%d,%d,%d) \n",i,j,k);
		exit(-1);
	}
	return Cspace(i,j);
}

//Memory Macros
#undef A
#undef B
#undef temp_C
#undef Cspace
#undef _flag_Cspace
#undef _flag_temp_C


//Common Macro undefs
#undef max
#undef MAX
#undef min
#undef MIN
#undef CEILD
#undef ceild
#undef FLOORD
#undef floord
#undef CDIV
#undef FDIV
#undef LB_SHIFT
#undef MOD
