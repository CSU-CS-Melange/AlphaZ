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
#define kernel(i,j) kernel[i][j]
#define padded_kernel(i,j) padded_kernel[i][j]
#define patch(i,j) patch[i][j]

void init(long _P, long _N0, long _N1, long _K0, long _K1, long _PK0, long _PK1, float** kernel, float** padded_kernel, float** patch){
	///Parameter checking
	if (!((_P >= 1 && _N0 >= 1 && _N1 >= 1 && _K0 >= 1 && _K1 >= 1 && _PK0 >= 1 && _PK1 >= 1))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	//Memory Allocation
	
	#define S0(i,j,i2) padded_kernel(j,i2) = kernel(-_PK0+j+_K0,-_PK1+i2+_K1)
	#define S1(i,j,i2) padded_kernel(j,i2) = 0.0
	#define S2(i,j,i2) patch(j,i2) = 1.0
	#define S3(i,j,i2) patch(j,i2) = 0.0
	{
		//Domain
		//{i,j,i2|i==0 && _K0+j>=_PK0 && _K0+_PK0>=j && _K1+i2>=_PK1 && _K1+_PK1>=i2 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK0>=1 && _PK1>=1 && 2_PK1>=i2 && i2>=0 && 2_PK0>=j && j>=0}
		//{i,j,i2|i==0 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK1>=1 && j>=_K0+_PK0+1 && 2_PK0>=j && i2>=0 && 2_PK1>=i2} || {i,j,i2|i==0 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK1>=1 && _PK0>=_K0+j+1 && j>=0 && i2>=0 && 2_PK1>=i2} || {i,j,i2|i==0 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK0>=1 && j>=0 && 2_PK0>=j && _PK1>=_K1+i2+1 && i2>=0} || {i,j,i2|i==0 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK0>=1 && j>=0 && 2_PK0>=j && i2>=_K1+_PK1+1 && 2_PK1>=i2}
		//{i,j,i2|i==1 && j>=_PK0 && _N0+_PK0>=j+1 && i2>=_PK1 && _N1+_PK1>=i2+1 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK0>=1 && _PK1>=1}
		//{i,j,i2|i==1 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK1>=1 && j>=_N0+_PK0 && _N0+2_PK0>=j+1 && i2>=0 && _N1+2_PK1>=i2+1} || {i,j,i2|i==1 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK1>=1 && j>=0 && _PK0>=j+1 && i2>=0 && _N1+2_PK1>=i2+1} || {i,j,i2|i==1 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK0>=1 && j>=0 && _N0+2_PK0>=j+1 && i2>=0 && _PK1>=i2+1} || {i,j,i2|i==1 && _P>=1 && _N0>=1 && _N1>=1 && _K0>=1 && _K1>=1 && _PK0>=1 && j>=0 && _N0+2_PK0>=j+1 && i2>=_N1+_PK1 && _N1+2_PK1>=i2+1}
		int c2,c3;
		for(c2=0;c2 <= -_K0+_PK0-1;c2+=1)
		 {
		 	for(c3=0;c3 <= 2*_PK1;c3+=1)
		 	 {
		 	 	S1((0),(c2),(c3));
		 	 }
		 }
		if ((_K1 <= _PK1-1)) {
			{
				for(c2=max(0,-_K0+_PK0);c2 <= min(2*_PK0,_K0+_PK0);c2+=1)
				 {
				 	for(c3=0;c3 <= -_K1+_PK1-1;c3+=1)
				 	 {
				 	 	S1((0),(c2),(c3));
				 	 }
				 	for(c3=-_K1+_PK1;c3 <= _K1+_PK1;c3+=1)
				 	 {
				 	 	S0((0),(c2),(c3));
				 	 }
				 	for(c3=_K1+_PK1+1;c3 <= 2*_PK1;c3+=1)
				 	 {
				 	 	S1((0),(c2),(c3));
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1)) {
			{
				for(c2=max(0,-_K0+_PK0);c2 <= min(2*_PK0,_K0+_PK0);c2+=1)
				 {
				 	for(c3=0;c3 <= 2*_PK1;c3+=1)
				 	 {
				 	 	S0((0),(c2),(c3));
				 	 }
				 }
			}
		}
		for(c2=_K0+_PK0+1;c2 <= 2*_PK0;c2+=1)
		 {
		 	for(c3=0;c3 <= 2*_PK1;c3+=1)
		 	 {
		 	 	S1((0),(c2),(c3));
		 	 }
		 }
		for(c2=0;c2 <= _PK0-1;c2+=1)
		 {
		 	for(c3=0;c3 <= _N1+2*_PK1-1;c3+=1)
		 	 {
		 	 	S3((1),(c2),(c3));
		 	 }
		 }
		for(c2=_PK0;c2 <= _N0+_PK0-1;c2+=1)
		 {
		 	for(c3=0;c3 <= _PK1-1;c3+=1)
		 	 {
		 	 	S3((1),(c2),(c3));
		 	 }
		 	for(c3=_PK1;c3 <= _N1+_PK1-1;c3+=1)
		 	 {
		 	 	S2((1),(c2),(c3));
		 	 }
		 	for(c3=_N1+_PK1;c3 <= _N1+2*_PK1-1;c3+=1)
		 	 {
		 	 	S3((1),(c2),(c3));
		 	 }
		 }
		for(c2=_N0+_PK0;c2 <= _N0+2*_PK0-1;c2+=1)
		 {
		 	for(c3=0;c3 <= _N1+2*_PK1-1;c3+=1)
		 	 {
		 	 	S3((1),(c2),(c3));
		 	 }
		 }
	}
	#undef S0
	#undef S1
	#undef S2
	#undef S3
	
	//Memory Free
}

//Memory Macros
#undef kernel
#undef padded_kernel
#undef patch


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
