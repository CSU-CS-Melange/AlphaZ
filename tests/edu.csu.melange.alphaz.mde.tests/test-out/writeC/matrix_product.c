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
#include <omp.h>
#include <immintrin.h>
#include <malloc.h>


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
// Reduction Operators
#define RADD(x,y)    ((x)+=(y))
#define RMUL(x,y)    ((x)*=(y))
#define RMAX(x,y)    ((x)=MAX((x),(y)))
#define RMIN(x,y)    ((x)=MIN((x),(y)))

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






//Memory Macros
#define A(i,j) A[i][j]
#define B(k,j) B[k][j]
#define temp_C(i,j,k) temp_C[i][j][k]
#define C(i,j,k) C[i][j][k]

void matrix_product(long P, long Q, long R, float** A, float** B, float*** C){
	///Parameter checking
	if (!((P >= 2 && Q >= 2 && R >= 2))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	//Memory Allocation
	int mz1, mz2, mz3;
	
	float* _lin_temp_C = (float*)malloc(sizeof(float)*((P) * (R) * (Q+1)));
	mallocCheck(_lin_temp_C, ((P) * (R) * (Q+1)), float);
	float*** temp_C = (float***)malloc(sizeof(float**)*(P));
	mallocCheck(temp_C, (P), float**);
	for (mz1=0;mz1 < P; mz1++) {
		temp_C[mz1] = (float**)malloc(sizeof(float*)*(R));
		mallocCheck(temp_C[mz1], (R), float*);
		for (mz2=0;mz2 < R; mz2++) {
			temp_C[mz1][mz2] = &_lin_temp_C[(mz1*((R) * (Q+1))) + (mz2*(Q+1))];
		}
	}
	#define S0(i,j,k) temp_C(i,j,k) = (temp_C(i,j,k-1))+((A(k-1,i+k-1))*(B(k-1,j)))
	#define S1(i,j,k) temp_C(i,j,k) = 0
	#define S2(i,j,k) C(i,j,k) = temp_C(i,j,k-1)
	{
		//Domain
		//{i,j,k|P>=2 && Q>=2 && R>=2 && k>=1 && i>=0 && P>=i+1 && j>=0 && R>=j+1 && Q>=k}
		//{i,j,k|k==0 && P>=2 && Q>=2 && R>=2 && P>=i+1 && R>=j+1 && j>=0 && i>=0}
		//{i,j,k|k==Q+1 && i>=0 && P>=i+1 && j>=0 && R>=j+1 && Q>=2 && R>=2 && P>=2}
		int c1,c2,c3;
		for(c1=0;c1 <= P-1;c1+=1)
		 {
		 	for(c2=0;c2 <= R-1;c2+=1)
		 	 {
		 	 	S1((c1),(c2),(0));
		 	 	for(c3=1;c3 <= Q;c3+=1)
		 	 	 {
		 	 	 	S0((c1),(c2),(c3));
		 	 	 }
		 	 	S2((c1),(c2),(Q+1));
		 	 }
		 }
	}
	#undef S0
	#undef S1
	#undef S2
	
	//Memory Free
	free(_lin_temp_C);
	for (mz1=0;mz1 < P; mz1++) {
		free(temp_C[mz1]);
	}
	free(temp_C);
}

//Memory Macros
#undef A
#undef B
#undef temp_C
#undef C


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
#undef RADD
#undef RMUL
#undef RMAX
#undef RMIN
