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





//Local Function Declarations
float reduce_conv_out_1(long, long, long, long, long, long, int, int, int, float***, float***);

//Memory Macros
#define kernel(i,j,k) kernel[i][j][k]
#define arr(i,j,k) arr[i][j][k]
#define out(i,j,k) out[i][j][k]

void conv(long _K0, long _K1, long _K2, long _L0, long _L1, long _L2, float*** kernel, float*** arr, float*** out){
	///Parameter checking
	if (!((_K0 >= 1 && _L0 >= _K0 && _K1 >= 1 && _L1 >= _K1 && _K2 >= 1 && _L2 >= _K2))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	//Memory Allocation
	
	#define S0(i,j,k) out(i,j,k) = reduce_conv_out_1(_K0,_K1,_K2,_L0,_L1,_L2,i,j,k,arr,kernel)
	{
		//Domain
		//{i,j,k|_K0+i>=0 && _K2+_L2>=k+1 && _K1+j>=0 && _K1+_L1>=j+1 && _K2+k>=0 && _K0+_L0>=i+1 && _K0>=1 && _L0>=_K0 && _K1>=1 && _L1>=_K1 && _K2>=1 && _L2>=_K2 && i>=0 && _L0>=i+1 && j>=0 && _L1>=j+1 && k>=0 && _L2>=k+1}
		int c1,c2,c3;
		for(c1=0;c1 <= _L0-1;c1+=1)
		 {
		 	for(c2=0;c2 <= _L1-1;c2+=1)
		 	 {
		 	 	for(c3=0;c3 <= _L2-1;c3+=1)
		 	 	 {
		 	 	 	S0((c1),(c2),(c3));
		 	 	 }
		 	 }
		 }
	}
	#undef S0
	
	//Memory Free
}
float reduce_conv_out_1(long _K0, long _K1, long _K2, long _L0, long _L1, long _L2, int ip, int jp, int kp, float*** arr, float*** kernel){
	float reduceVar = 0;
	#define S1(i,j,k,p,q,r) reduceVar = (reduceVar)+((arr(i+p,j+q,k+r))*(kernel(-p+_K0,-q+_K1,-r+_K2)))
	{
		//Domain
		//{i,j,k,p,q,r|_K0+ip>=0 && _K2+_L2>=kp+1 && _K1+jp>=0 && _K1+_L1>=jp+1 && _K2+kp>=0 && _K0+_L0>=ip+1 && _K0>=1 && _L0>=_K0 && _K1>=1 && _L1>=_K1 && _K2>=1 && _L2>=_K2 && ip>=0 && _L0>=ip+1 && jp>=0 && _L1>=jp+1 && kp>=0 && _L2>=kp+1 && i+p>=0 && _L0>=i+p+1 && j+q>=0 && _L1>=j+q+1 && k+r>=0 && _L2>=k+r+1 && i>=0 && _L0>=i+1 && j>=0 && _L1>=j+1 && k>=0 && _L2>=k+1 && _K2+r>=0 && _K2>=r && _K1+q>=0 && _K1>=q && _K0+p>=0 && _K0>=p && _K0+i>=0 && _K2+_L2>=k+1 && _K1+j>=0 && _K1+_L1>=j+1 && _K2+k>=0 && _K0+_L0>=i+1 && ip==i && jp==j && kp==k}
		int c4,c5,c6;
		for(c4=max(-_K0,-ip);c4 <= min(_K0,_L0-ip-1);c4+=1)
		 {
		 	for(c5=max(-_K1,-jp);c5 <= min(_K1,_L1-jp-1);c5+=1)
		 	 {
		 	 	for(c6=max(-_K2,-kp);c6 <= min(_K2,_L2-kp-1);c6+=1)
		 	 	 {
		 	 	 	S1((ip),(jp),(kp),(c4),(c5),(c6));
		 	 	 }
		 	 }
		 }
	}
	#undef S1
	return reduceVar;
}

//Memory Macros
#undef kernel
#undef arr
#undef out


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
