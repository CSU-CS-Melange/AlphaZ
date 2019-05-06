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
static double*** temp_B;
static double** B;
static char** _flag_B;
static char*** _flag_temp_B;


//Local Function Declarations
double eval_temp_B(long, long, long, int, int, int);
double eval_B(long, long, long, int, int);

//Memory Macros
#define temp_B(t,i,j) temp_B[t][i][j]
#define B(i,j) B[i][j]
#define _flag_B(i,j) _flag_B[i][j]
#define _flag_temp_B(t,i,j) _flag_temp_B[t][i][j]

void jacobi_2d_verify(long TSTEPS, long N, long M, long ts1, long ts2, long ts3, double** _local_B){
	///Parameter checking
	if (!((TSTEPS >= 3 && N >= 4 && M >= 4))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	//Copy to global
	B = _local_B;
	
	//Memory Allocation
	int mz1, mz2, mz3;
	
	double* _lin_temp_B = (double*)malloc(sizeof(double)*((TSTEPS) * (N) * (M)));
	mallocCheck(_lin_temp_B, ((TSTEPS) * (N) * (M)), double);
	temp_B = (double***)malloc(sizeof(double**)*(TSTEPS));
	mallocCheck(temp_B, (TSTEPS), double**);
	for (mz1=0;mz1 < TSTEPS; mz1++) {
		temp_B[mz1] = (double**)malloc(sizeof(double*)*(N));
		mallocCheck(temp_B[mz1], (N), double*);
		for (mz2=0;mz2 < N; mz2++) {
			temp_B[mz1][mz2] = &_lin_temp_B[(mz1*((N) * (M))) + (mz2*(M))];
		}
	}
	
	char* _lin__flag_B = (char*)malloc(sizeof(char)*((N) * (M)));
	mallocCheck(_lin__flag_B, ((N) * (M)), char);
	_flag_B = (char**)malloc(sizeof(char*)*(N));
	mallocCheck(_flag_B, (N), char*);
	for (mz1=0;mz1 < N; mz1++) {
		_flag_B[mz1] = &_lin__flag_B[(mz1*(M))];
	}
	memset(_lin__flag_B, 'N', ((N) * (M)));
	
	char* _lin__flag_temp_B = (char*)malloc(sizeof(char)*((TSTEPS) * (N) * (M)));
	mallocCheck(_lin__flag_temp_B, ((TSTEPS) * (N) * (M)), char);
	_flag_temp_B = (char***)malloc(sizeof(char**)*(TSTEPS));
	mallocCheck(_flag_temp_B, (TSTEPS), char**);
	for (mz1=0;mz1 < TSTEPS; mz1++) {
		_flag_temp_B[mz1] = (char**)malloc(sizeof(char*)*(N));
		mallocCheck(_flag_temp_B[mz1], (N), char*);
		for (mz2=0;mz2 < N; mz2++) {
			_flag_temp_B[mz1][mz2] = &_lin__flag_temp_B[(mz1*((N) * (M))) + (mz2*(M))];
		}
	}
	memset(_lin__flag_temp_B, 'N', ((TSTEPS) * (N) * (M)));
	#define S0(i,j) eval_B(TSTEPS,N,M,i,j)
	{
		//Domain
		//{i,j|i>=0 && N>=i+1 && j>=0 && M>=j+1 && TSTEPS>=3 && N>=4 && M>=4}
		int c1,c2;
		for(c1=0;c1 <= N-1;c1+=1)
		 {
		 	for(c2=0;c2 <= M-1;c2+=1)
		 	 {
		 	 	S0((c1),(c2));
		 	 }
		 }
	}
	#undef S0
	
	//Memory Free
	free(_lin_temp_B);
	for (mz1=0;mz1 < TSTEPS; mz1++) {
		free(temp_B[mz1]);
	}
	free(temp_B);
	
	free(_lin__flag_B);
	free(_flag_B);
	
	free(_lin__flag_temp_B);
	for (mz1=0;mz1 < TSTEPS; mz1++) {
		free(_flag_temp_B[mz1]);
	}
	free(_flag_temp_B);
}
double eval_temp_B(long TSTEPS, long N, long M, int t, int i, int j){
	if ( _flag_temp_B(t,i,j) == 'N' ) {
		_flag_temp_B(t,i,j) = 'I';
	//Body for temp_B
		temp_B(t,i,j) = (((t == 0))?((((i)*(i))*(j))*(j))/(1024):(((j >= 1 && N >= i+2 && t >= 1 && i >= 1 && M >= j+2))?(((((eval_temp_B(TSTEPS,N,M,t-1,i-1,j))+(eval_temp_B(TSTEPS,N,M,t-1,i,j-1)))+(eval_temp_B(TSTEPS,N,M,t-1,i,j)))+(eval_temp_B(TSTEPS,N,M,t-1,i,j+1)))+(eval_temp_B(TSTEPS,N,M,t-1,i+1,j)))*(0.2):(eval_temp_B(TSTEPS,N,M,t-1,i,j))));
		_flag_temp_B(t,i,j) = 'F';
	} else if ( _flag_temp_B(t,i,j) == 'I' ) {
		printf("There is a self dependence on temp_B at (%d,%d,%d) \n",t,i,j);
		exit(-1);
	}
	return temp_B(t,i,j);
}
double eval_B(long TSTEPS, long N, long M, int i, int j){
	if ( _flag_B(i,j) == 'N' ) {
		_flag_B(i,j) = 'I';
	//Body for B
		B(i,j) = eval_temp_B(TSTEPS,N,M,TSTEPS-1,i,j);
		_flag_B(i,j) = 'F';
	} else if ( _flag_B(i,j) == 'I' ) {
		printf("There is a self dependence on B at (%d,%d) \n",i,j);
		exit(-1);
	}
	return B(i,j);
}

//Memory Macros
#undef temp_B
#undef B
#undef _flag_B
#undef _flag_temp_B


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
