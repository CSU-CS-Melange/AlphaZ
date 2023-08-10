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
#define kernel(i,j,k) kernel[i][j][k]
#define padded_kernel(i,j,k) padded_kernel[i][j][k]
#define patch(i,j,k) patch[i][j][k]

void init(long _P, long _N0, long _N1, long _N2, long _K0, long _K1, long _K2, long _PK0, long _PK1, long _PK2, double*** kernel, double*** padded_kernel, double*** patch){
	///Parameter checking
	if (!((_P >= 1 && _N0 >= 1 && _N1 >= 1 && _N2 >= 1 && _K0 >= 1 && _K1 >= 1 && _K2 >= 1 && _PK0 >= 1 && _PK1 >= 1 && _PK2 >= 1))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	//Memory Allocation
	
	#define S0(i,j,k) padded_kernel(i,j,k) = kernel(-_PK0+i+_K0,-_PK1+j+_K1,-_PK2+k+_K2)
	#define S1(i,j,k) padded_kernel(i,j,k) = 0.0
	#define S2(i,j,k) patch(i,j,k) = 1.0
	#define S3(i,j,k) patch(i,j,k) = 0.0
	{
		//Domain
		//{i,j,k|_K0+i>=_PK0 && _K0+_PK0>=i && _K1+j>=_PK1 && _K1+_PK1>=j && _K2+k>=_PK2 && _K2+_PK2>=k && _P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK1>=1 && _PK2>=1 && 2_PK2>=k && k>=0 && 2_PK1>=j && j>=0 && 2_PK0>=i && i>=0}
		//{i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK1>=1 && _PK2>=1 && i>=_K0+_PK0+1 && 2_PK0>=i && j>=0 && 2_PK1>=j && k>=0 && 2_PK2>=k} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK1>=1 && _PK2>=1 && _PK0>=_K0+i+1 && i>=0 && j>=0 && 2_PK1>=j && k>=0 && 2_PK2>=k} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK2>=1 && i>=0 && 2_PK0>=i && j>=_K1+_PK1+1 && 2_PK1>=j && k>=0 && 2_PK2>=k} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK2>=1 && i>=0 && 2_PK0>=i && _PK1>=_K1+j+1 && j>=0 && k>=0 && 2_PK2>=k} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK1>=1 && i>=0 && 2_PK0>=i && j>=0 && 2_PK1>=j && _PK2>=_K2+k+1 && k>=0} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK1>=1 && i>=0 && 2_PK0>=i && j>=0 && 2_PK1>=j && k>=_K2+_PK2+1 && 2_PK2>=k}
		//{i,j,k|i>=_PK0 && _N0+_PK0>=i+1 && j>=_PK1 && _N1+_PK1>=j+1 && k>=_PK2 && _N2+_PK2>=k+1 && _P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK1>=1 && _PK2>=1}
		//{i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK1>=1 && _PK2>=1 && i>=_N0+_PK0 && _N0+2_PK0>=i+1 && j>=0 && _N1+2_PK1>=j+1 && k>=0 && _N2+2_PK2>=k+1} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK1>=1 && _PK2>=1 && i>=0 && _PK0>=i+1 && j>=0 && _N1+2_PK1>=j+1 && k>=0 && _N2+2_PK2>=k+1} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK2>=1 && i>=0 && _N0+2_PK0>=i+1 && j>=_N1+_PK1 && _N1+2_PK1>=j+1 && k>=0 && _N2+2_PK2>=k+1} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK2>=1 && i>=0 && _N0+2_PK0>=i+1 && j>=0 && _PK1>=j+1 && k>=0 && _N2+2_PK2>=k+1} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK1>=1 && i>=0 && _N0+2_PK0>=i+1 && j>=0 && _N1+2_PK1>=j+1 && k>=0 && _PK2>=k+1} || {i,j,k|_P>=1 && _N0>=1 && _N1>=1 && _N2>=1 && _K0>=1 && _K1>=1 && _K2>=1 && _PK0>=1 && _PK1>=1 && i>=0 && _N0+2_PK0>=i+1 && j>=0 && _N1+2_PK1>=j+1 && k>=_N2+_PK2 && _N2+2_PK2>=k+1}
		int c1,c2,c3;
		if ((_N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=0;c1 <= -_K0+_PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == 1 && _N2 >= 2)) {
			{
				for(c1=0;c1 <= -_K0+_PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= 2 && _N2 == 1)) {
			{
				for(c1=0;c1 <= -_K0+_PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == 1 && _N2 == 1)) {
			{
				for(c1=0;c1 <= -_K0+_PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 >= 2)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 == 1 && _N2 >= 2)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= 2 && _N2 == 1)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= 2 && _N2 == 1)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 >= 2)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= 2 && _N2 == 1)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 == 1 && _N2 >= 2)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= 2 && _N2 == 1)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=max(0,-_K0+_PK0);c1 <= _PK0-1;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= 2 && _N1 <= _K1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 <= _PK1 && _N1 >= _K1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= _PK1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _PK1+1 && _N1 >= _K1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _K1+1 && _N1 <= _PK1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 >= 2 && _N1 <= _K1 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 == 1 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 <= _PK1 && _N1 >= _K1+2 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 >= _PK1+2 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N1 >= _K1+2 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _K1+1 && _N1 <= _PK1 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 >= 2 && _N1 <= _K1 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 == 1 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 <= _PK1 && _N1 >= _K1+2 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 >= _PK1+2 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N1 >= _K1+2 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _K1+1 && _N1 <= _PK1 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= 2 && _N1 <= _K1 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 <= _PK1 && _N1 >= _K1+2 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= _PK1+2 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _PK1+1 && _N1 >= _K1+2 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _K1+1 && _N1 <= _PK1 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 >= 2 && _N1 <= _K1 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 == 1 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 <= _PK1 && _N1 >= _K1+2 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 >= _PK1+2 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N1 >= _K1+2 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _K1+1 && _N1 <= _PK1 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= 2 && _N1 <= _K1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 == 1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 <= _PK1 && _N1 >= _K1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= _PK1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _PK1+1 && _N1 >= _K1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _K1+1 && _N1 <= _PK1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= 2 && _N1 <= _K1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 == 1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 <= _PK1 && _N1 >= _K1+2 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= _PK1+2 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _PK1+1 && _N1 >= _K1+2 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _K1+1 && _N1 <= _PK1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 >= 2 && _N1 <= _K1 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 == 1 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 <= _PK1 && _N1 >= _K1+2 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _N1 >= _PK1+2 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N1 >= _K1+2 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _K1+1 && _N1 <= _PK1 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= 2 && _N1 <= _K1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	S0((c1),(_PK1),(_PK2));
				 	S2((c1),(_PK1),(_PK2));
				 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 <= _PK1 && _N1 >= _K1+2 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= _PK1+2 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _PK1+1 && _N1 >= _K1+2 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _K1+1 && _N1 <= _PK1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= 2 && _N1 <= _K1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	S0((c1),(_PK1),(_PK2));
				 	S2((c1),(_PK1),(_PK2));
				 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 <= _PK1 && _N1 >= _K1+2 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= _PK1+2 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _PK1+1 && _N1 >= _K1+2 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-_K1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-_K1-1;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= _N1+_K1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_K1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _K1+1 && _N1 <= _PK1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= -_N1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_N1+_PK1+1;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 >= 2)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 == 1 && _N2 >= 2)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 >= 2 && _N2 == 1)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 >= 2 && _N2 == 1)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 <= _PK1-1 && _K2 >= _PK2 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= -_K1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=-_K1+_PK1;c2 <= _K1+_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_K1+_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= 2 && _N1 <= _PK1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= _PK1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _PK1+1 && _N1 <= _K1+1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 >= 2 && _N1 <= _PK1 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 == 1 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 >= _PK1+2 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N1 <= _K1+1 && _N2 <= _PK2 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 >= 2 && _N1 <= _PK1 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 == 1 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 >= _PK1+2 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N1 <= _K1+1 && _N2 == _PK2+1 && _N2 >= _K2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-_K2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-_K2-1;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= _N2+_K2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_K2;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= 2 && _N1 <= _PK1 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= _PK1+2 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _PK1+1 && _N1 <= _K1+1 && _N2 >= 2 && _N2 <= _K2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 >= 2 && _N1 <= _PK1 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 == 1 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 >= _PK1+2 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N1 <= _K1+1 && _N2 == _K2+1 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_N2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_N2+_PK2+1;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= 2 && _N1 <= _PK1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	S0((c1),(_PK1),(_PK2));
				 	S2((c1),(_PK1),(_PK2));
				 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= _PK1+2 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 <= _PK2-1 && _N1 == _PK1+1 && _N1 <= _K1+1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 >= 2)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 >= 2 && _N2 == 1)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 <= _PK2-1 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= -_K2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=-_K2+_PK2;c3 <= _K2+_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_K2+_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= 2 && _N1 <= _PK1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 == 1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= _PK1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _PK1+1 && _N1 <= _K1+1 && _N2 >= _PK2+2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= 2 && _N1 <= _PK1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 == 1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= _PK1+2 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _PK1+1 && _N1 <= _K1+1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 >= 2 && _N1 <= _PK1 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 == 1 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _N1 >= _PK1+2 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N1 <= _K1+1 && _N2 == _PK2+1 && _N2 <= _K2+1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= 2 && _N1 <= _PK1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	S0((c1),(_PK1),(_PK2));
				 	S2((c1),(_PK1),(_PK2));
				 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S0((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= _PK1+2 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K2 >= _PK2 && _N1 == _PK1+1 && _N1 <= _K1+1 && _N2 == 1)) {
			{
				for(c1=_PK0;c1 <= min(2*_PK0,min(_K0+_PK0,_N0+_PK0-1));c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S0((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 == 1 && _N2 >= 2)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 >= 2 && _N2 == 1)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_K1 >= _PK1 && _K2 >= _PK2 && _N1 == 1 && _N2 == 1)) {
			{
				for(c1=_N0+_PK0;c1 <= min(2*_PK0,_K0+_PK0);c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S0((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= 2 && _N1 <= _PK1 && _N2 >= _PK2+2)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == 1 && _N2 >= _PK2+2)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= _PK1+2 && _N2 >= _PK2+2)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N2 >= _PK2+2)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= 2 && _N1 <= _PK1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == 1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= _PK1+2 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N2 >= 2 && _N2 <= _PK2)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2+_PK2;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= 2 && _N1 <= _PK1 && _N2 == _PK2+1)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == 1 && _N2 == _PK2+1)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S2((c1),(_PK1),(c3));
				 	 }
				 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 {
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= _PK1+2 && _N2 == _PK2+1)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N2 == _PK2+1)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=_N2-1;c3 <= 2*_N2-2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S2((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_N2-1;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 3*_N2-3;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= 2 && _N1 <= _PK1 && _N2 == 1)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == 1 && _N2 == 1)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	S1((c1),(_PK1),(_PK2));
				 	S2((c1),(_PK1),(_PK2));
				 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 {
				 	 	S1((c1),(_PK1),(c3));
				 	 	S3((c1),(_PK1),(c3));
				 	 }
				 	for(c2=_PK1+1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= _PK1+2 && _N2 == 1)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_PK1;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == _PK1+1 && _N2 == 1)) {
			{
				for(c1=_K0+_PK0+1;c1 <= min(2*_PK0,_N0+_PK0-1);c1+=1)
				 {
				 	for(c2=0;c2 <= _N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=_N1-1;c2 <= 2*_N1-2;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	S1((c1),(c2),(_PK2));
				 	 	S2((c1),(c2),(_PK2));
				 	 	for(c3=_PK2+1;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_N1-1;c2 <= 3*_N1-3;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= 2 && _N2 >= 2)) {
			{
				for(c1=max(_N0+_PK0,_K0+_PK0+1);c1 <= 2*_PK0;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == 1 && _N2 >= 2)) {
			{
				for(c1=max(_N0+_PK0,_K0+_PK0+1);c1 <= 2*_PK0;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 	for(c3=2*_PK2+1;c3 <= _N2+2*_PK2-1;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 >= 2 && _N2 == 1)) {
			{
				for(c1=max(_N0+_PK0,_K0+_PK0+1);c1 <= 2*_PK0;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 	for(c2=2*_PK1+1;c2 <= _N1+2*_PK1-1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((_N1 == 1 && _N2 == 1)) {
			{
				for(c1=max(_N0+_PK0,_K0+_PK0+1);c1 <= 2*_PK0;c1+=1)
				 {
				 	for(c2=0;c2 <= 2*_PK1;c2+=1)
				 	 {
				 	 	for(c3=0;c3 <= 2*_PK2;c3+=1)
				 	 	 {
				 	 	 	S1((c1),(c2),(c3));
				 	 	 	S3((c1),(c2),(c3));
				 	 	 }
				 	 }
				 }
			}
		}
		for(c1=2*_PK0+1;c1 <= _N0+_PK0-1;c1+=1)
		 {
		 	for(c2=0;c2 <= _PK1-1;c2+=1)
		 	 {
		 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
		 	 	 {
		 	 	 	S3((c1),(c2),(c3));
		 	 	 }
		 	 }
		 	for(c2=_PK1;c2 <= _N1+_PK1-1;c2+=1)
		 	 {
		 	 	for(c3=0;c3 <= _PK2-1;c3+=1)
		 	 	 {
		 	 	 	S3((c1),(c2),(c3));
		 	 	 }
		 	 	for(c3=_PK2;c3 <= _N2+_PK2-1;c3+=1)
		 	 	 {
		 	 	 	S2((c1),(c2),(c3));
		 	 	 }
		 	 	for(c3=_N2+_PK2;c3 <= _N2+2*_PK2-1;c3+=1)
		 	 	 {
		 	 	 	S3((c1),(c2),(c3));
		 	 	 }
		 	 }
		 	for(c2=_N1+_PK1;c2 <= _N1+2*_PK1-1;c2+=1)
		 	 {
		 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
		 	 	 {
		 	 	 	S3((c1),(c2),(c3));
		 	 	 }
		 	 }
		 }
		for(c1=max(_N0+_PK0,2*_PK0+1);c1 <= _N0+2*_PK0-1;c1+=1)
		 {
		 	for(c2=0;c2 <= _N1+2*_PK1-1;c2+=1)
		 	 {
		 	 	for(c3=0;c3 <= _N2+2*_PK2-1;c3+=1)
		 	 	 {
		 	 	 	S3((c1),(c2),(c3));
		 	 	 }
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
