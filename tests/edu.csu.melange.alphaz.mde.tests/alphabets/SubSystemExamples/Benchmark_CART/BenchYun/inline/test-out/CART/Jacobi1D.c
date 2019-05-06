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





//Memory Macros
#define A_bl(iBl,iLoc) A_bl[iBl][iLoc]
#define B_bl(iBl,iLoc) B_bl[iBl][iLoc]
#define TempSpace(iBl,tBl) TempSpace[iBl][tBl]

void Jacobi1D(long Nb, long Tb, long Nl, long Tl, long b, double** A_bl, double** B_bl){
	///Parameter checking
	if (!((Tl == 0 && Nl == 0 && Nb >= 1 && Tb >= 1 && b >= 3))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	//Memory Allocation
	int mz1, mz2;
	
	double* _lin_TempSpace = (double*)malloc(sizeof(double)*((max(Nb+Tb-1,max(Nb+Tb+0,Tb)) + 1) * (max(3*b-1,2*b-2) + 1)));
	mallocCheck(_lin_TempSpace, ((max(Nb+Tb-1,max(Nb+Tb+0,Tb)) + 1) * (max(3*b-1,2*b-2) + 1)), double);
	double** TempSpace = (double**)malloc(sizeof(double*)*(max(Nb+Tb-1,max(Nb+Tb+0,Tb)) + 1));
	mallocCheck(TempSpace, (max(Nb+Tb-1,max(Nb+Tb+0,Tb)) + 1), double*);
	for (mz1=0;mz1 < max(Nb+Tb-1,max(Nb+Tb+0,Tb)) + 1; mz1++) {
		TempSpace[mz1] = &_lin_TempSpace[(mz1*(max(3*b-1,2*b-2) + 1))];
	}
	#define S0(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = A_bl(iBl-2*tBl,-iLoc+tLoc)
	#define S1(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+b+1)
	#define S2(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+2*b+1)
	#define S3(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = TempSpace(iBl-2*tBl+Tb+1,-2*iLoc+tLoc+1)
	#define S4(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = TempSpace(iBl-2*tBl+Tb-1,-2*iLoc+tLoc+3*b+1)
	#define S5(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+2*b+1)
	#define S6(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = (((TempSpace(iBl-2*tBl+Tb-1,3*b-2*iLoc+tLoc))+(TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+2*b+1)))+(TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+2*b+2)))*(0.333333)
	#define S7(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = (((TempSpace(iBl-2*tBl+Tb-1,3*b-2*iLoc+tLoc))+(TempSpace(iBl-2*tBl+Tb-1,-2*iLoc+tLoc+3*b+1)))+(TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+2*b+2)))*(0.333333)
	#define S8(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = (((TempSpace(Tb+iBl-2*tBl,b-2*iLoc+tLoc))+(TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+b+1)))+(TempSpace(iBl-2*tBl+Tb+1,-2*iLoc+tLoc+2)))*(0.333333)
	#define S9(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = (((TempSpace(Tb+iBl-2*tBl,b-2*iLoc+tLoc))+(TempSpace(iBl-2*tBl+Tb+1,-2*iLoc+tLoc+1)))+(TempSpace(iBl-2*tBl+Tb+1,-2*iLoc+tLoc+2)))*(0.333333)
	#define S10(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = (((TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc))+(TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+2*b+1)))+(TempSpace(Tb+iBl-2*tBl,-2*iLoc+tLoc+2*b+2)))*(0.333333)
	#define S11(iBl,tBl,iLoc,tLoc) TempSpace(Tb+iBl-2*tBl,2*b-2*iLoc+tLoc) = (((TempSpace(iBl-2*tBl+Tb+1,-2*iLoc+tLoc))+(TempSpace(iBl-2*tBl+Tb+1,-2*iLoc+tLoc+1)))+(TempSpace(iBl-2*tBl+Tb+1,-2*iLoc+tLoc+2)))*(0.333333)
	#define S12(iBl,iLoc,i2,i3) B_bl(iBl-2*Tb,i3) = TempSpace(iBl-Tb,2*b+i3-Tl)
	{
		//Domain
		//{iBl,tBl,iLoc,tLoc|iLoc==0 && tBl==0 && Tl==0 && Nl==0 && Nb>=1 && tLoc>=0 && b>=tLoc+1 && b>=3 && Tb>=1 && iBl>=0 && Nb>=iBl+1}
		//{iBl,tBl,iLoc,tLoc|tLoc==0 && iLoc==0 && tBl==Tb && iBl==2Tb && Tl==0 && Nl==0 && Nb>=1 && Tb>=1 && b>=3} || {iBl,tBl,iLoc,tLoc|tLoc==0 && iLoc==0 && 2tBl==iBl && Tl==0 && Nl==0 && Nb>=1 && b>=3 && iBl>=2 && 2Tb>=iBl+2}
		//{iBl,tBl,iLoc,tLoc|tLoc==iLoc && tBl==0 && iBl==0 && Tl==0 && Nl==0 && Nb>=1 && Tb>=1 && b>=3 && iLoc>=1 && b>=iLoc+1} || {iBl,tBl,iLoc,tLoc|tLoc==iLoc && 2tBl==iBl && Tl==0 && Nl==0 && Nb>=1 && b>=3 && iBl>=2 && 2Tb>=iBl+2 && iLoc>=1 && b>=iLoc+1}
		//{iBl,tBl,iLoc,tLoc|tLoc==b-1 && iLoc==0 && Nb+2tBl==iBl+1 && Tl==0 && Nl==0 && Nb>=1 && b>=3 && iBl>=Nb+1 && Nb+2Tb>=iBl+3} || {iBl,tBl,iLoc,tLoc|tLoc==b-1 && iLoc==0 && tBl==Tb && iBl==Nb+2Tb-1 && Tl==0 && Nl==0 && Nb>=1 && Tb>=1 && b>=3}
		//{iBl,tBl,iLoc,tLoc|tLoc==0 && iLoc==1 && Nb+2tBl==iBl && Tl==0 && Nl==0 && Nb>=1 && b>=3 && iBl>=Nb && Nb+2Tb>=iBl+2}
		//{iBl,tBl,iLoc,tLoc|tLoc==iLoc-1 && Nb+2tBl==iBl && Tl==0 && Nl==0 && Nb>=1 && b>=3 && iBl>=Nb && Nb+2Tb>=iBl+2 && iLoc>=2 && b>=iLoc+1 && Tb>=1}
		//{iBl,tBl,iLoc,tLoc|tLoc==1 && Tl==0 && Nl==0 && b>=3 && tBl>=0 && iBl>=2tBl+1 && Tb>=tBl+1 && Nb+2tBl>=iBl+1 && iLoc>=1 && b>=iLoc+1} || {iBl,tBl,iLoc,tLoc|tLoc==1 && Nb+2tBl==iBl && Tl==0 && Nl==0 && Nb>=1 && iBl>=Nb && Nb+2Tb>=iBl+2 && iLoc>=3 && b>=iLoc+1}
		//{iBl,tBl,iLoc,tLoc|tLoc==0 && Tl==0 && Nl==0 && b>=3 && tBl>=0 && iBl>=2tBl+1 && Tb>=tBl+1 && iLoc>=1 && Nb+2tBl>=iBl && Nb+2tBl+iLoc>=iBl+2 && b>=iLoc+1}
		//{iBl,tBl,iLoc,tLoc|tLoc==0 && iLoc==0 && Tl==0 && Nl==0 && b>=3 && tBl>=1 && iBl>=2tBl+1 && Tb>=tBl && Nb+2tBl>=iBl+1}
		//{iBl,tBl,iLoc,tLoc|tLoc==1 && iLoc==0 && Tl==0 && Nl==0 && b>=3 && tBl>=1 && iBl>=2tBl && Tb>=tBl && Nb+2tBl>=iBl+1}
		//{iBl,tBl,iLoc,tLoc|Tl==0 && Nl==0 && tBl>=0 && iBl>=2tBl+1 && Tb>=tBl+1 && Nb+2tBl>=iBl+1 && iLoc>=1 && b>=iLoc+1 && tLoc>=2 && b>=tLoc+1} || {iBl,tBl,iLoc,tLoc|2tBl==iBl && Tl==0 && Nl==0 && Nb>=1 && iBl>=2 && 2Tb>=iBl+2 && iLoc>=1 && tLoc>=iLoc+1 && b>=tLoc+1} || {iBl,tBl,iLoc,tLoc|Nb+2tBl==iBl && Tl==0 && Nl==0 && Nb>=1 && iBl>=Nb && Nb+2Tb>=iBl+2 && b>=iLoc+1 && tLoc>=2 && iLoc>=tLoc+2} || {iBl,tBl,iLoc,tLoc|tBl==0 && iBl==0 && Tl==0 && Nl==0 && Nb>=1 && Tb>=1 && iLoc>=1 && tLoc>=iLoc+1 && b>=tLoc+1}
		//{iBl,tBl,iLoc,tLoc|iLoc==0 && Tl==0 && Nl==0 && tBl>=1 && iBl>=2tBl && Tb>=tBl && tLoc>=2 && b>=tLoc+1 && Nb+b+2tBl>=iBl+tLoc+3 && Nb+2tBl>=iBl+1}
		//{iBl,iLoc,i2,i3|i2==1 && iLoc==Tb && Tl==0 && Nl==0 && Tb>=1 && b>=3 && iBl>=2Tb && Nb+2Tb>=iBl+1 && i3>=0 && b>=i3+1 && Nb>=1}
		int c1,c2,c3,c4;
		for(c4=0;c4 <= b-1;c4+=1)
		 {
		 	S0((0),(0),(0),(c4));
		 }
		for(c3=1;c3 <= b-2;c3+=1)
		 {
		 	S2((0),(0),(c3),(c3));
		 	for(c4=c3+1;c4 <= b-1;c4+=1)
		 	 {
		 	 	S10((0),(0),(c3),(c4));
		 	 }
		 }
		S2((0),(0),(b-1),(b-1));
		if ((Nb == 1 && b >= 5)) {
			{
				S4((1),(0),(1),(0));
				S7((1),(0),(2),(0));
				S5((1),(0),(2),(1));
				S7((1),(0),(3),(0));
				S6((1),(0),(3),(1));
				S5((1),(0),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((1),(0),(c3),(0));
				 	S6((1),(0),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((1),(0),(c3),(c4));
				 	 }
				 	S5((1),(0),(c3),(c3-1));
				 }
			}
		}
		if ((Nb == 1 && b == 4)) {
			{
				S4((1),(0),(1),(0));
				S7((1),(0),(2),(0));
				S5((1),(0),(2),(1));
				S7((1),(0),(3),(0));
				S6((1),(0),(3),(1));
				S5((1),(0),(3),(2));
			}
		}
		if ((Nb == 1 && b == 3)) {
			{
				S4((1),(0),(1),(0));
				S7((1),(0),(2),(0));
				S5((1),(0),(2),(1));
			}
		}
		if ((Nb >= 2)) {
			{
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S0((1),(0),(0),(c4));
				 }
				for(c3=1;c3 <= b-1;c3+=1)
				 {
				 	S7((1),(0),(c3),(0));
				 	S6((1),(0),(c3),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((1),(0),(c3),(c4));
				 	 }
				 }
			}
		}
		if ((Nb == 2 && Tb == 1 && b >= 5)) {
			{
				S4((2),(0),(1),(0));
				S7((2),(0),(2),(0));
				S5((2),(0),(2),(1));
				S7((2),(0),(3),(0));
				S6((2),(0),(3),(1));
				S5((2),(0),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((2),(0),(c3),(0));
				 	S6((2),(0),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((2),(0),(c3),(c4));
				 	 }
				 	S5((2),(0),(c3),(c3-1));
				 }
				S1((2),(1),(0),(0));
				S9((2),(1),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((2),(1),(0),(c4));
				 }
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((2),(1),(1),(c4));
				 }
			}
		}
		if ((Nb == 2 && Tb == 1 && b == 4)) {
			{
				S4((2),(0),(1),(0));
				S7((2),(0),(2),(0));
				S5((2),(0),(2),(1));
				S7((2),(0),(3),(0));
				S6((2),(0),(3),(1));
				S5((2),(0),(3),(2));
				S1((2),(1),(0),(0));
				S9((2),(1),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((2),(1),(0),(c4));
				 }
				for(c4=0;c4 <= 3;c4+=1)
				 {
				 	S12((2),(1),(1),(c4));
				 }
			}
		}
		if ((Nb == 2 && Tb == 1 && b == 3)) {
			{
				S4((2),(0),(1),(0));
				S7((2),(0),(2),(0));
				S5((2),(0),(2),(1));
				S1((2),(1),(0),(0));
				S9((2),(1),(0),(1));
				S11((2),(1),(0),(2));
				for(c4=0;c4 <= 2;c4+=1)
				 {
				 	S12((2),(1),(1),(c4));
				 }
			}
		}
		if ((Nb >= 3 && Tb == 1)) {
			{
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S0((2),(0),(0),(c4));
				 }
				for(c3=1;c3 <= b-1;c3+=1)
				 {
				 	S7((2),(0),(c3),(0));
				 	S6((2),(0),(c3),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((2),(0),(c3),(c4));
				 	 }
				 }
				S1((2),(1),(0),(0));
				S9((2),(1),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((2),(1),(0),(c4));
				 }
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((2),(1),(1),(c4));
				 }
			}
		}
		if ((Nb == 1 && b >= 5)) {
			{
				for(c1=2;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			for(c4=2;c4 <= b-2;c4+=1)
				 			 {
				 			 	S11((c1),((c1) / 2),(0),(c4));
				 			 }
				 			S3((c1),((c1) / 2),(0),(b-1));
				 			for(c3=1;c3 <= b-2;c3+=1)
				 			 {
				 			 	S2((c1),((c1) / 2),(c3),(c3));
				 			 	for(c4=c3+1;c4 <= b-1;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 			S2((c1),((c1) / 2),(b-1),(b-1));
				 		}
				 	}
				 	if (((c1+1) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-1) / 2),(1),(0));
				 			S7((c1),((c1-1) / 2),(2),(0));
				 			S5((c1),((c1-1) / 2),(2),(1));
				 			S7((c1),((c1-1) / 2),(3),(0));
				 			S6((c1),((c1-1) / 2),(3),(1));
				 			S5((c1),((c1-1) / 2),(3),(2));
				 			for(c3=4;c3 <= b-1;c3+=1)
				 			 {
				 			 	S7((c1),((c1-1) / 2),(c3),(0));
				 			 	S6((c1),((c1-1) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= c3-2;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-1) / 2),(c3),(c4));
				 			 	 }
				 			 	S5((c1),((c1-1) / 2),(c3),(c3-1));
				 			 }
				 		}
				 	}
				 }
			}
		}
		if ((Nb == 1 && b == 4)) {
			{
				for(c1=2;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			S11((c1),((c1) / 2),(0),(2));
				 			S3((c1),((c1) / 2),(0),(3));
				 			for(c3=1;c3 <= 2;c3+=1)
				 			 {
				 			 	S2((c1),((c1) / 2),(c3),(c3));
				 			 	for(c4=c3+1;c4 <= 3;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 			S2((c1),((c1) / 2),(3),(3));
				 		}
				 	}
				 	if (((c1+1) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-1) / 2),(1),(0));
				 			S7((c1),((c1-1) / 2),(2),(0));
				 			S5((c1),((c1-1) / 2),(2),(1));
				 			S7((c1),((c1-1) / 2),(3),(0));
				 			S6((c1),((c1-1) / 2),(3),(1));
				 			S5((c1),((c1-1) / 2),(3),(2));
				 		}
				 	}
				 }
			}
		}
		if ((Nb == 1 && b == 3)) {
			{
				for(c1=2;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			S3((c1),((c1) / 2),(0),(2));
				 			S2((c1),((c1) / 2),(1),(1));
				 			S10((c1),((c1) / 2),(1),(2));
				 			S2((c1),((c1) / 2),(2),(2));
				 		}
				 	}
				 	if (((c1+1) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-1) / 2),(1),(0));
				 			S7((c1),((c1-1) / 2),(2),(0));
				 			S5((c1),((c1-1) / 2),(2),(1));
				 		}
				 	}
				 }
			}
		}
		if ((Nb == 2 && Tb >= 2)) {
			{
				S4((2),(0),(1),(0));
			}
		}
		if ((Nb == 2 && Tb >= 2 && b >= 5)) {
			{
				S7((2),(0),(2),(0));
				S5((2),(0),(2),(1));
				S7((2),(0),(3),(0));
				S6((2),(0),(3),(1));
				S5((2),(0),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((2),(0),(c3),(0));
				 	S6((2),(0),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((2),(0),(c3),(c4));
				 	 }
				 	S5((2),(0),(c3),(c3-1));
				 }
				S1((2),(1),(0),(0));
				S9((2),(1),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((2),(1),(0),(c4));
				 }
				for(c3=1;c3 <= b-2;c3+=1)
				 {
				 	S2((2),(1),(c3),(c3));
				 	for(c4=c3+1;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((2),(1),(c3),(c4));
				 	 }
				 }
				S2((2),(1),(b-1),(b-1));
			}
		}
		if ((Nb == 2 && Tb >= 2 && b == 4)) {
			{
				S7((2),(0),(2),(0));
				S5((2),(0),(2),(1));
				S7((2),(0),(3),(0));
				S6((2),(0),(3),(1));
				S5((2),(0),(3),(2));
				S1((2),(1),(0),(0));
				S9((2),(1),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((2),(1),(0),(c4));
				 }
				for(c3=1;c3 <= 2;c3+=1)
				 {
				 	S2((2),(1),(c3),(c3));
				 	for(c4=c3+1;c4 <= 3;c4+=1)
				 	 {
				 	 	S10((2),(1),(c3),(c4));
				 	 }
				 }
				S2((2),(1),(3),(3));
			}
		}
		if ((Nb == 2 && Tb >= 2 && b == 3)) {
			{
				S7((2),(0),(2),(0));
				S5((2),(0),(2),(1));
				S1((2),(1),(0),(0));
				S9((2),(1),(0),(1));
				S11((2),(1),(0),(2));
				S2((2),(1),(1),(1));
				S10((2),(1),(1),(2));
				S2((2),(1),(2),(2));
			}
		}
		if ((Nb >= 3 && Tb >= 2)) {
			{
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S0((2),(0),(0),(c4));
				 }
				for(c3=1;c3 <= b-1;c3+=1)
				 {
				 	S7((2),(0),(c3),(0));
				 	S6((2),(0),(c3),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((2),(0),(c3),(c4));
				 	 }
				 }
				S1((2),(1),(0),(0));
				S9((2),(1),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((2),(1),(0),(c4));
				 }
				for(c3=1;c3 <= b-2;c3+=1)
				 {
				 	S2((2),(1),(c3),(c3));
				 	for(c4=c3+1;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((2),(1),(c3),(c4));
				 	 }
				 }
				S2((2),(1),(b-1),(b-1));
			}
		}
		if ((Nb == 1 && Tb >= 2 && b >= 5)) {
			{
				S4((2*Tb-1),(Tb-1),(1),(0));
				S7((2*Tb-1),(Tb-1),(2),(0));
				S5((2*Tb-1),(Tb-1),(2),(1));
				S7((2*Tb-1),(Tb-1),(3),(0));
				S6((2*Tb-1),(Tb-1),(3),(1));
				S5((2*Tb-1),(Tb-1),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((2*Tb-1),(Tb-1),(c3),(0));
				 	S6((2*Tb-1),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((2*Tb-1),(Tb-1),(c3),(c4));
				 	 }
				 	S5((2*Tb-1),(Tb-1),(c3),(c3-1));
				 }
			}
		}
		if ((Nb == 1 && Tb >= 2 && b == 4)) {
			{
				S4((2*Tb-1),(Tb-1),(1),(0));
				S7((2*Tb-1),(Tb-1),(2),(0));
				S5((2*Tb-1),(Tb-1),(2),(1));
				S7((2*Tb-1),(Tb-1),(3),(0));
				S6((2*Tb-1),(Tb-1),(3),(1));
				S5((2*Tb-1),(Tb-1),(3),(2));
			}
		}
		if ((Nb == 1 && Tb >= 2 && b == 3)) {
			{
				S4((2*Tb-1),(Tb-1),(1),(0));
				S7((2*Tb-1),(Tb-1),(2),(0));
				S5((2*Tb-1),(Tb-1),(2),(1));
			}
		}
		if ((Nb == 1 && b >= 4)) {
			{
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				for(c4=2;c4 <= b-2;c4+=1)
				 {
				 	S11((2*Tb),(Tb),(0),(c4));
				 }
				S3((2*Tb),(Tb),(0),(b-1));
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((2*Tb),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb == 1 && b == 3)) {
			{
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				S3((2*Tb),(Tb),(0),(2));
				for(c4=0;c4 <= 2;c4+=1)
				 {
				 	S12((2*Tb),(Tb),(1),(c4));
				 }
			}
		}
		for(c1=3;c1 <= min(Nb-1,2*Tb-2);c1+=1)
		 {
		 	for(c4=0;c4 <= b-1;c4+=1)
		 	 {
		 	 	S0((c1),(0),(0),(c4));
		 	 }
		 	for(c3=1;c3 <= b-1;c3+=1)
		 	 {
		 	 	S7((c1),(0),(c3),(0));
		 	 	S6((c1),(0),(c3),(1));
		 	 	for(c4=2;c4 <= b-1;c4+=1)
		 	 	 {
		 	 	 	S10((c1),(0),(c3),(c4));
		 	 	 }
		 	 }
		 	#pragma omp parallel for private(c3,c4)
		 	for(c2=1;c2 <= (c1-1) / 2;c2+=1)
		 	 {
		 	 	S8((c1),(c2),(0),(0));
		 	 	S9((c1),(c2),(0),(1));
		 	 	for(c4=2;c4 <= b-1;c4+=1)
		 	 	 {
		 	 	 	S11((c1),(c2),(0),(c4));
		 	 	 }
		 	 	for(c3=1;c3 <= b-1;c3+=1)
		 	 	 {
		 	 	 	S7((c1),(c2),(c3),(0));
		 	 	 	S6((c1),(c2),(c3),(1));
		 	 	 	for(c4=2;c4 <= b-1;c4+=1)
		 	 	 	 {
		 	 	 	 	S10((c1),(c2),(c3),(c4));
		 	 	 	 }
		 	 	 }
		 	 }
		 	if (((c1) % 2 == 0)) {
		 		{
		 			S1((c1),((c1) / 2),(0),(0));
		 			S9((c1),((c1) / 2),(0),(1));
		 			for(c4=2;c4 <= b-1;c4+=1)
		 			 {
		 			 	S11((c1),((c1) / 2),(0),(c4));
		 			 }
		 			for(c3=1;c3 <= b-2;c3+=1)
		 			 {
		 			 	S2((c1),((c1) / 2),(c3),(c3));
		 			 	for(c4=c3+1;c4 <= b-1;c4+=1)
		 			 	 {
		 			 	 	S10((c1),((c1) / 2),(c3),(c4));
		 			 	 }
		 			 }
		 			S2((c1),((c1) / 2),(b-1),(b-1));
		 		}
		 	}
		 }
		if ((Nb == 2*Tb-1 && Nb >= 3)) {
			{
				S4((Nb),(0),(1),(0));
			}
		}
		if ((Nb == 2*Tb-1 && Nb >= 3 && b >= 5)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((Nb),(0),(c3),(0));
				 	S6((Nb),(0),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((Nb),(0),(c3),(c4));
				 	 }
				 	S5((Nb),(0),(c3),(c3-1));
				 }
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= (Nb-1) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((Nb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((Nb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((Nb == 2*Tb-1 && Nb >= 3 && b == 4)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= (Nb-1) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S11((Nb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= 3;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 {
				 	 	 	S10((Nb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((Nb == 2*Tb-1 && Nb >= 3 && b == 3)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				#pragma omp parallel for private(c3)
				for(c2=1;c2 <= (Nb-1) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	S11((Nb),(c2),(0),(2));
				 	for(c3=1;c3 <= 2;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	S10((Nb),(c2),(c3),(2));
				 	 }
				 }
			}
		}
		if ((Nb >= 2*Tb && Tb >= 2)) {
			{
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S0((2*Tb-1),(0),(0),(c4));
				 }
				for(c3=1;c3 <= b-1;c3+=1)
				 {
				 	S7((2*Tb-1),(0),(c3),(0));
				 	S6((2*Tb-1),(0),(c3),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((2*Tb-1),(0),(c3),(c4));
				 	 }
				 }
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= Tb-1;c2+=1)
				 {
				 	S8((2*Tb-1),(c2),(0),(0));
				 	S9((2*Tb-1),(c2),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((2*Tb-1),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((2*Tb-1),(c2),(c3),(0));
				 	 	S6((2*Tb-1),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((2*Tb-1),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-2)) {
			{
				S4((Nb),(0),(1),(0));
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-2 && b >= 5)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((Nb),(0),(c3),(0));
				 	S6((Nb),(0),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((Nb),(0),(c3),(c4));
				 	 }
				 	S5((Nb),(0),(c3),(c3-1));
				 }
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= (Nb-1) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((Nb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((Nb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				if (((Nb) % 2 == 0)) {
					{
						S1((Nb),((Nb) / 2),(0),(0));
						S9((Nb),((Nb) / 2),(0),(1));
						for(c4=2;c4 <= b-1;c4+=1)
						 {
						 	S11((Nb),((Nb) / 2),(0),(c4));
						 }
						for(c3=1;c3 <= b-2;c3+=1)
						 {
						 	S2((Nb),((Nb) / 2),(c3),(c3));
						 	for(c4=c3+1;c4 <= b-1;c4+=1)
						 	 {
						 	 	S10((Nb),((Nb) / 2),(c3),(c4));
						 	 }
						 }
						S2((Nb),((Nb) / 2),(b-1),(b-1));
					}
				}
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-2 && b == 4)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= (Nb-1) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S11((Nb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= 3;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 {
				 	 	 	S10((Nb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				if (((Nb) % 2 == 0)) {
					{
						S1((Nb),((Nb) / 2),(0),(0));
						S9((Nb),((Nb) / 2),(0),(1));
						for(c4=2;c4 <= 3;c4+=1)
						 {
						 	S11((Nb),((Nb) / 2),(0),(c4));
						 }
						for(c3=1;c3 <= 2;c3+=1)
						 {
						 	S2((Nb),((Nb) / 2),(c3),(c3));
						 	for(c4=c3+1;c4 <= 3;c4+=1)
						 	 {
						 	 	S10((Nb),((Nb) / 2),(c3),(c4));
						 	 }
						 }
						S2((Nb),((Nb) / 2),(3),(3));
					}
				}
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-2 && b == 3)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				#pragma omp parallel for private(c3)
				for(c2=1;c2 <= (Nb-1) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	S11((Nb),(c2),(0),(2));
				 	for(c3=1;c3 <= 2;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	S10((Nb),(c2),(c3),(2));
				 	 }
				 }
				if (((Nb) % 2 == 0)) {
					{
						S1((Nb),((Nb) / 2),(0),(0));
						S9((Nb),((Nb) / 2),(0),(1));
						S11((Nb),((Nb) / 2),(0),(2));
						S2((Nb),((Nb) / 2),(1),(1));
						S10((Nb),((Nb) / 2),(1),(2));
						S2((Nb),((Nb) / 2),(2),(2));
					}
				}
			}
		}
		if ((Nb >= 4 && Nb == 2*Tb)) {
			{
				S4((Nb),(0),(1),(0));
			}
		}
		if ((Nb >= 4 && Nb == 2*Tb && b >= 5)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((Nb),(0),(c3),(0));
				 	S6((Nb),(0),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((Nb),(0),(c3),(c4));
				 	 }
				 	S5((Nb),(0),(c3),(c3-1));
				 }
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= (Nb-2) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((Nb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((Nb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				if (((Nb) % 2 == 0)) {
					{
						S1((Nb),((Nb) / 2),(0),(0));
						S9((Nb),((Nb) / 2),(0),(1));
						for(c4=2;c4 <= b-1;c4+=1)
						 {
						 	S11((Nb),((Nb) / 2),(0),(c4));
						 }
					}
				}
			}
		}
		if ((Nb >= 4 && Nb == 2*Tb && b == 4)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= (Nb-2) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S11((Nb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= 3;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 {
				 	 	 	S10((Nb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				if (((Nb) % 2 == 0)) {
					{
						S1((Nb),((Nb) / 2),(0),(0));
						S9((Nb),((Nb) / 2),(0),(1));
						for(c4=2;c4 <= 3;c4+=1)
						 {
						 	S11((Nb),((Nb) / 2),(0),(c4));
						 }
					}
				}
			}
		}
		if ((Nb >= 4 && Nb == 2*Tb && b == 3)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				#pragma omp parallel for private(c3)
				for(c2=1;c2 <= (Nb-2) / 2;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	S11((Nb),(c2),(0),(2));
				 	for(c3=1;c3 <= 2;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	S10((Nb),(c2),(c3),(2));
				 	 }
				 }
				if (((Nb) % 2 == 0)) {
					{
						S1((Nb),((Nb) / 2),(0),(0));
						S9((Nb),((Nb) / 2),(0),(1));
						S11((Nb),((Nb) / 2),(0),(2));
					}
				}
			}
		}
		if ((Nb >= 4 && Nb == 2*Tb)) {
			{
				if (((Nb) % 2 == 0)) {
					{
						for(c4=0;c4 <= b-1;c4+=1)
						 {
						 	S12((Nb),((Nb) / 2),(1),(c4));
						 }
					}
				}
			}
		}
		if ((Nb >= 2*Tb+1 && Tb >= 2)) {
			{
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S0((2*Tb),(0),(0),(c4));
				 }
				for(c3=1;c3 <= b-1;c3+=1)
				 {
				 	S7((2*Tb),(0),(c3),(0));
				 	S6((2*Tb),(0),(c3),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((2*Tb),(0),(c3),(c4));
				 	 }
				 }
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= Tb-1;c2+=1)
				 {
				 	S8((2*Tb),(c2),(0),(0));
				 	S9((2*Tb),(c2),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((2*Tb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((2*Tb),(c2),(c3),(0));
				 	 	S6((2*Tb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((2*Tb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((2*Tb),(Tb),(0),(c4));
				 }
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((2*Tb),(Tb),(1),(c4));
				 }
			}
		}
		if ((Tb >= 2)) {
			{
				for(c1=2*Tb+1;c1 <= Nb-1;c1+=1)
				 {
				 	for(c4=0;c4 <= b-1;c4+=1)
				 	 {
				 	 	S0((c1),(0),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((c1),(0),(c3),(0));
				 	 	S6((c1),(0),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((c1),(0),(c3),(c4));
				 	 	 }
				 	 }
				 	#pragma omp parallel for private(c3,c4)
				 	for(c2=1;c2 <= Tb-1;c2+=1)
				 	 {
				 	 	S8((c1),(c2),(0),(0));
				 	 	S9((c1),(c2),(0),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S11((c1),(c2),(0),(c4));
				 	 	 }
				 	 	for(c3=1;c3 <= b-1;c3+=1)
				 	 	 {
				 	 	 	S7((c1),(c2),(c3),(0));
				 	 	 	S6((c1),(c2),(c3),(1));
				 	 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 	 {
				 	 	 	 	S10((c1),(c2),(c3),(c4));
				 	 	 	 }
				 	 	 }
				 	 }
				 	S8((c1),(Tb),(0),(0));
				 	S9((c1),(Tb),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((c1),(Tb),(0),(c4));
				 	 }
				 	for(c4=0;c4 <= b-1;c4+=1)
				 	 {
				 	 	S12((c1),(Tb),(1),(c4));
				 	 }
				 }
			}
		}
		if ((Tb == 1)) {
			{
				for(c1=3;c1 <= Nb-1;c1+=1)
				 {
				 	for(c4=0;c4 <= b-1;c4+=1)
				 	 {
				 	 	S0((c1),(0),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((c1),(0),(c3),(0));
				 	 	S6((c1),(0),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((c1),(0),(c3),(c4));
				 	 	 }
				 	 }
				 	S8((c1),(1),(0),(0));
				 	S9((c1),(1),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((c1),(1),(0),(c4));
				 	 }
				 	for(c4=0;c4 <= b-1;c4+=1)
				 	 {
				 	 	S12((c1),(1),(1),(c4));
				 	 }
				 }
			}
		}
		if ((Nb >= 3 && b >= 5)) {
			{
				for(c1=Nb+1;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1+Nb+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-Nb+1) / 2),(0),(0));
				 			S9((c1),((c1-Nb+1) / 2),(0),(1));
				 			for(c4=2;c4 <= b-2;c4+=1)
				 			 {
				 			 	S11((c1),((c1-Nb+1) / 2),(0),(c4));
				 			 }
				 			S3((c1),((c1-Nb+1) / 2),(0),(b-1));
				 			for(c3=1;c3 <= b-1;c3+=1)
				 			 {
				 			 	S7((c1),((c1-Nb+1) / 2),(c3),(0));
				 			 	S6((c1),((c1-Nb+1) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= b-1;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-Nb+1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 		}
				 	}
				 	if (((c1+Nb) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-Nb) / 2),(1),(0));
				 			S7((c1),((c1-Nb) / 2),(2),(0));
				 			S5((c1),((c1-Nb) / 2),(2),(1));
				 			S7((c1),((c1-Nb) / 2),(3),(0));
				 			S6((c1),((c1-Nb) / 2),(3),(1));
				 			S5((c1),((c1-Nb) / 2),(3),(2));
				 			for(c3=4;c3 <= b-1;c3+=1)
				 			 {
				 			 	S7((c1),((c1-Nb) / 2),(c3),(0));
				 			 	S6((c1),((c1-Nb) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= c3-2;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-Nb) / 2),(c3),(c4));
				 			 	 }
				 			 	S5((c1),((c1-Nb) / 2),(c3),(c3-1));
				 			 }
				 		}
				 	}
				 	#pragma omp parallel for private(c3,c4)
				 	for(c2=ceild(c1-Nb+2, 2);c2 <= (c1-1) / 2;c2+=1)
				 	 {
				 	 	S8((c1),(c2),(0),(0));
				 	 	S9((c1),(c2),(0),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S11((c1),(c2),(0),(c4));
				 	 	 }
				 	 	for(c3=1;c3 <= b-1;c3+=1)
				 	 	 {
				 	 	 	S7((c1),(c2),(c3),(0));
				 	 	 	S6((c1),(c2),(c3),(1));
				 	 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 	 {
				 	 	 	 	S10((c1),(c2),(c3),(c4));
				 	 	 	 }
				 	 	 }
				 	 }
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			for(c4=2;c4 <= b-1;c4+=1)
				 			 {
				 			 	S11((c1),((c1) / 2),(0),(c4));
				 			 }
				 			for(c3=1;c3 <= b-2;c3+=1)
				 			 {
				 			 	S2((c1),((c1) / 2),(c3),(c3));
				 			 	for(c4=c3+1;c4 <= b-1;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 			S2((c1),((c1) / 2),(b-1),(b-1));
				 		}
				 	}
				 }
			}
		}
		if ((Nb == 2 && b >= 5)) {
			{
				for(c1=3;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-1) / 2),(0),(0));
				 			S9((c1),((c1-1) / 2),(0),(1));
				 			for(c4=2;c4 <= b-2;c4+=1)
				 			 {
				 			 	S11((c1),((c1-1) / 2),(0),(c4));
				 			 }
				 			S3((c1),((c1-1) / 2),(0),(b-1));
				 			for(c3=1;c3 <= b-1;c3+=1)
				 			 {
				 			 	S7((c1),((c1-1) / 2),(c3),(0));
				 			 	S6((c1),((c1-1) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= b-1;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 		}
				 	}
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-2) / 2),(1),(0));
				 			S7((c1),((c1-2) / 2),(2),(0));
				 			S5((c1),((c1-2) / 2),(2),(1));
				 			S7((c1),((c1-2) / 2),(3),(0));
				 			S6((c1),((c1-2) / 2),(3),(1));
				 			S5((c1),((c1-2) / 2),(3),(2));
				 			for(c3=4;c3 <= b-1;c3+=1)
				 			 {
				 			 	S7((c1),((c1-2) / 2),(c3),(0));
				 			 	S6((c1),((c1-2) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= c3-2;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-2) / 2),(c3),(c4));
				 			 	 }
				 			 	S5((c1),((c1-2) / 2),(c3),(c3-1));
				 			 }
				 		}
				 	}
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			for(c4=2;c4 <= b-1;c4+=1)
				 			 {
				 			 	S11((c1),((c1) / 2),(0),(c4));
				 			 }
				 			for(c3=1;c3 <= b-2;c3+=1)
				 			 {
				 			 	S2((c1),((c1) / 2),(c3),(c3));
				 			 	for(c4=c3+1;c4 <= b-1;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 			S2((c1),((c1) / 2),(b-1),(b-1));
				 		}
				 	}
				 }
			}
		}
		if ((Nb >= 3 && b == 4)) {
			{
				for(c1=Nb+1;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1+Nb+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-Nb+1) / 2),(0),(0));
				 			S9((c1),((c1-Nb+1) / 2),(0),(1));
				 			S11((c1),((c1-Nb+1) / 2),(0),(2));
				 			S3((c1),((c1-Nb+1) / 2),(0),(3));
				 			for(c3=1;c3 <= 3;c3+=1)
				 			 {
				 			 	S7((c1),((c1-Nb+1) / 2),(c3),(0));
				 			 	S6((c1),((c1-Nb+1) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= 3;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-Nb+1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 		}
				 	}
				 	if (((c1+Nb) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-Nb) / 2),(1),(0));
				 			S7((c1),((c1-Nb) / 2),(2),(0));
				 			S5((c1),((c1-Nb) / 2),(2),(1));
				 			S7((c1),((c1-Nb) / 2),(3),(0));
				 			S6((c1),((c1-Nb) / 2),(3),(1));
				 			S5((c1),((c1-Nb) / 2),(3),(2));
				 		}
				 	}
				 	#pragma omp parallel for private(c3,c4)
				 	for(c2=ceild(c1-Nb+2, 2);c2 <= (c1-1) / 2;c2+=1)
				 	 {
				 	 	S8((c1),(c2),(0),(0));
				 	 	S9((c1),(c2),(0),(1));
				 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 {
				 	 	 	S11((c1),(c2),(0),(c4));
				 	 	 }
				 	 	for(c3=1;c3 <= 3;c3+=1)
				 	 	 {
				 	 	 	S7((c1),(c2),(c3),(0));
				 	 	 	S6((c1),(c2),(c3),(1));
				 	 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 	 {
				 	 	 	 	S10((c1),(c2),(c3),(c4));
				 	 	 	 }
				 	 	 }
				 	 }
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			for(c4=2;c4 <= 3;c4+=1)
				 			 {
				 			 	S11((c1),((c1) / 2),(0),(c4));
				 			 }
				 			for(c3=1;c3 <= 2;c3+=1)
				 			 {
				 			 	S2((c1),((c1) / 2),(c3),(c3));
				 			 	for(c4=c3+1;c4 <= 3;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 			S2((c1),((c1) / 2),(3),(3));
				 		}
				 	}
				 }
			}
		}
		if ((Nb == 2 && b == 4)) {
			{
				for(c1=3;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-1) / 2),(0),(0));
				 			S9((c1),((c1-1) / 2),(0),(1));
				 			S11((c1),((c1-1) / 2),(0),(2));
				 			S3((c1),((c1-1) / 2),(0),(3));
				 			for(c3=1;c3 <= 3;c3+=1)
				 			 {
				 			 	S7((c1),((c1-1) / 2),(c3),(0));
				 			 	S6((c1),((c1-1) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= 3;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 		}
				 	}
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-2) / 2),(1),(0));
				 			S7((c1),((c1-2) / 2),(2),(0));
				 			S5((c1),((c1-2) / 2),(2),(1));
				 			S7((c1),((c1-2) / 2),(3),(0));
				 			S6((c1),((c1-2) / 2),(3),(1));
				 			S5((c1),((c1-2) / 2),(3),(2));
				 		}
				 	}
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			for(c4=2;c4 <= 3;c4+=1)
				 			 {
				 			 	S11((c1),((c1) / 2),(0),(c4));
				 			 }
				 			for(c3=1;c3 <= 2;c3+=1)
				 			 {
				 			 	S2((c1),((c1) / 2),(c3),(c3));
				 			 	for(c4=c3+1;c4 <= 3;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 			S2((c1),((c1) / 2),(3),(3));
				 		}
				 	}
				 }
			}
		}
		if ((Nb >= 3 && b == 3)) {
			{
				for(c1=Nb+1;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1+Nb+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-Nb+1) / 2),(0),(0));
				 			S9((c1),((c1-Nb+1) / 2),(0),(1));
				 			S3((c1),((c1-Nb+1) / 2),(0),(2));
				 			for(c3=1;c3 <= 2;c3+=1)
				 			 {
				 			 	S7((c1),((c1-Nb+1) / 2),(c3),(0));
				 			 	S6((c1),((c1-Nb+1) / 2),(c3),(1));
				 			 	S10((c1),((c1-Nb+1) / 2),(c3),(2));
				 			 }
				 		}
				 	}
				 	if (((c1+Nb) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-Nb) / 2),(1),(0));
				 			S7((c1),((c1-Nb) / 2),(2),(0));
				 			S5((c1),((c1-Nb) / 2),(2),(1));
				 		}
				 	}
				 	#pragma omp parallel for private(c3)
				 	for(c2=ceild(c1-Nb+2, 2);c2 <= (c1-1) / 2;c2+=1)
				 	 {
				 	 	S8((c1),(c2),(0),(0));
				 	 	S9((c1),(c2),(0),(1));
				 	 	S11((c1),(c2),(0),(2));
				 	 	for(c3=1;c3 <= 2;c3+=1)
				 	 	 {
				 	 	 	S7((c1),(c2),(c3),(0));
				 	 	 	S6((c1),(c2),(c3),(1));
				 	 	 	S10((c1),(c2),(c3),(2));
				 	 	 }
				 	 }
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			S11((c1),((c1) / 2),(0),(2));
				 			S2((c1),((c1) / 2),(1),(1));
				 			S10((c1),((c1) / 2),(1),(2));
				 			S2((c1),((c1) / 2),(2),(2));
				 		}
				 	}
				 }
			}
		}
		if ((Nb == 2 && b == 3)) {
			{
				for(c1=3;c1 <= 2*Tb-2;c1+=1)
				 {
				 	if (((c1+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-1) / 2),(0),(0));
				 			S9((c1),((c1-1) / 2),(0),(1));
				 			S3((c1),((c1-1) / 2),(0),(2));
				 			for(c3=1;c3 <= 2;c3+=1)
				 			 {
				 			 	S7((c1),((c1-1) / 2),(c3),(0));
				 			 	S6((c1),((c1-1) / 2),(c3),(1));
				 			 	S10((c1),((c1-1) / 2),(c3),(2));
				 			 }
				 		}
				 	}
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-2) / 2),(1),(0));
				 			S7((c1),((c1-2) / 2),(2),(0));
				 			S5((c1),((c1-2) / 2),(2),(1));
				 		}
				 	}
				 	if (((c1) % 2 == 0)) {
				 		{
				 			S1((c1),((c1) / 2),(0),(0));
				 			S9((c1),((c1) / 2),(0),(1));
				 			S11((c1),((c1) / 2),(0),(2));
				 			S2((c1),((c1) / 2),(1),(1));
				 			S10((c1),((c1) / 2),(1),(2));
				 			S2((c1),((c1) / 2),(2),(2));
				 		}
				 	}
				 }
			}
		}
		if ((Nb >= 2*Tb+1 && Tb >= 2)) {
			{
				S4((Nb),(0),(1),(0));
			}
		}
		if ((Nb >= 2*Tb+1 && Tb >= 2 && b >= 5)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((Nb),(0),(c3),(0));
				 	S6((Nb),(0),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((Nb),(0),(c3),(c4));
				 	 }
				 	S5((Nb),(0),(c3),(c3-1));
				 }
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= Tb-1;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((Nb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((Nb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				S8((Nb),(Tb),(0),(0));
				S9((Nb),(Tb),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((Nb),(Tb),(0),(c4));
				 }
			}
		}
		if ((Nb >= 2*Tb+1 && Tb >= 2 && b == 4)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				#pragma omp parallel for private(c3,c4)
				for(c2=1;c2 <= Tb-1;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S11((Nb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= 3;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 {
				 	 	 	S10((Nb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				S8((Nb),(Tb),(0),(0));
				S9((Nb),(Tb),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((Nb),(Tb),(0),(c4));
				 }
			}
		}
		if ((Nb >= 2*Tb+1 && Tb >= 2 && b == 3)) {
			{
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				#pragma omp parallel for private(c3)
				for(c2=1;c2 <= Tb-1;c2+=1)
				 {
				 	S8((Nb),(c2),(0),(0));
				 	S9((Nb),(c2),(0),(1));
				 	S11((Nb),(c2),(0),(2));
				 	for(c3=1;c3 <= 2;c3+=1)
				 	 {
				 	 	S7((Nb),(c2),(c3),(0));
				 	 	S6((Nb),(c2),(c3),(1));
				 	 	S10((Nb),(c2),(c3),(2));
				 	 }
				 }
				S8((Nb),(Tb),(0),(0));
				S9((Nb),(Tb),(0),(1));
				S11((Nb),(Tb),(0),(2));
			}
		}
		if ((Nb >= 2*Tb+1 && Tb >= 2)) {
			{
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((Nb),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb >= 3 && Tb == 1 && b >= 5)) {
			{
				S4((Nb),(0),(1),(0));
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((Nb),(0),(c3),(0));
				 	S6((Nb),(0),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((Nb),(0),(c3),(c4));
				 	 }
				 	S5((Nb),(0),(c3),(c3-1));
				 }
				S8((Nb),(1),(0),(0));
				S9((Nb),(1),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((Nb),(1),(0),(c4));
				 }
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((Nb),(1),(1),(c4));
				 }
			}
		}
		if ((Nb >= 3 && Tb == 1 && b == 4)) {
			{
				S4((Nb),(0),(1),(0));
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S7((Nb),(0),(3),(0));
				S6((Nb),(0),(3),(1));
				S5((Nb),(0),(3),(2));
				S8((Nb),(1),(0),(0));
				S9((Nb),(1),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((Nb),(1),(0),(c4));
				 }
				for(c4=0;c4 <= 3;c4+=1)
				 {
				 	S12((Nb),(1),(1),(c4));
				 }
			}
		}
		if ((Nb >= 3 && Tb == 1 && b == 3)) {
			{
				S4((Nb),(0),(1),(0));
				S7((Nb),(0),(2),(0));
				S5((Nb),(0),(2),(1));
				S8((Nb),(1),(0),(0));
				S9((Nb),(1),(0),(1));
				S11((Nb),(1),(0),(2));
				for(c4=0;c4 <= 2;c4+=1)
				 {
				 	S12((Nb),(1),(1),(c4));
				 }
			}
		}
		if ((Nb >= 2 && Nb <= 2*Tb-2)) {
			{
				if (((Nb+1) % 2 == 0)) {
					{
						S4((2*Tb-1),((-Nb+2*Tb-1) / 2),(1),(0));
					}
				}
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-2 && b >= 5)) {
			{
				if (((Nb) % 2 == 0)) {
					{
						S8((2*Tb-1),((-Nb+2*Tb) / 2),(0),(0));
						S9((2*Tb-1),((-Nb+2*Tb) / 2),(0),(1));
						for(c4=2;c4 <= b-2;c4+=1)
						 {
						 	S11((2*Tb-1),((-Nb+2*Tb) / 2),(0),(c4));
						 }
						S3((2*Tb-1),((-Nb+2*Tb) / 2),(0),(b-1));
						for(c3=1;c3 <= b-1;c3+=1)
						 {
						 	S7((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(0));
						 	S6((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(1));
						 	for(c4=2;c4 <= b-1;c4+=1)
						 	 {
						 	 	S10((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(c4));
						 	 }
						 }
					}
				}
				if (((Nb+1) % 2 == 0)) {
					{
						S7((2*Tb-1),((-Nb+2*Tb-1) / 2),(2),(0));
						S5((2*Tb-1),((-Nb+2*Tb-1) / 2),(2),(1));
						S7((2*Tb-1),((-Nb+2*Tb-1) / 2),(3),(0));
						S6((2*Tb-1),((-Nb+2*Tb-1) / 2),(3),(1));
						S5((2*Tb-1),((-Nb+2*Tb-1) / 2),(3),(2));
						for(c3=4;c3 <= b-1;c3+=1)
						 {
						 	S7((2*Tb-1),((-Nb+2*Tb-1) / 2),(c3),(0));
						 	S6((2*Tb-1),((-Nb+2*Tb-1) / 2),(c3),(1));
						 	for(c4=2;c4 <= c3-2;c4+=1)
						 	 {
						 	 	S10((2*Tb-1),((-Nb+2*Tb-1) / 2),(c3),(c4));
						 	 }
						 	S5((2*Tb-1),((-Nb+2*Tb-1) / 2),(c3),(c3-1));
						 }
					}
				}
				#pragma omp parallel for private(c3,c4)
				for(c2=ceild(-Nb+2*Tb+1, 2);c2 <= Tb-1;c2+=1)
				 {
				 	S8((2*Tb-1),(c2),(0),(0));
				 	S9((2*Tb-1),(c2),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((2*Tb-1),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((2*Tb-1),(c2),(c3),(0));
				 	 	S6((2*Tb-1),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((2*Tb-1),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((Nb == 2 && Tb >= 2 && b >= 5)) {
			{
				S8((2*Tb-1),(Tb-1),(0),(0));
				S9((2*Tb-1),(Tb-1),(0),(1));
				for(c4=2;c4 <= b-2;c4+=1)
				 {
				 	S11((2*Tb-1),(Tb-1),(0),(c4));
				 }
				S3((2*Tb-1),(Tb-1),(0),(b-1));
				for(c3=1;c3 <= b-1;c3+=1)
				 {
				 	S7((2*Tb-1),(Tb-1),(c3),(0));
				 	S6((2*Tb-1),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((2*Tb-1),(Tb-1),(c3),(c4));
				 	 }
				 }
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-2 && b == 4)) {
			{
				if (((Nb) % 2 == 0)) {
					{
						S8((2*Tb-1),((-Nb+2*Tb) / 2),(0),(0));
						S9((2*Tb-1),((-Nb+2*Tb) / 2),(0),(1));
						S11((2*Tb-1),((-Nb+2*Tb) / 2),(0),(2));
						S3((2*Tb-1),((-Nb+2*Tb) / 2),(0),(3));
						for(c3=1;c3 <= 3;c3+=1)
						 {
						 	S7((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(0));
						 	S6((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(1));
						 	for(c4=2;c4 <= 3;c4+=1)
						 	 {
						 	 	S10((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(c4));
						 	 }
						 }
					}
				}
				if (((Nb+1) % 2 == 0)) {
					{
						S7((2*Tb-1),((-Nb+2*Tb-1) / 2),(2),(0));
						S5((2*Tb-1),((-Nb+2*Tb-1) / 2),(2),(1));
						S7((2*Tb-1),((-Nb+2*Tb-1) / 2),(3),(0));
						S6((2*Tb-1),((-Nb+2*Tb-1) / 2),(3),(1));
						S5((2*Tb-1),((-Nb+2*Tb-1) / 2),(3),(2));
					}
				}
				#pragma omp parallel for private(c3,c4)
				for(c2=ceild(-Nb+2*Tb+1, 2);c2 <= Tb-1;c2+=1)
				 {
				 	S8((2*Tb-1),(c2),(0),(0));
				 	S9((2*Tb-1),(c2),(0),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S11((2*Tb-1),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= 3;c3+=1)
				 	 {
				 	 	S7((2*Tb-1),(c2),(c3),(0));
				 	 	S6((2*Tb-1),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 {
				 	 	 	S10((2*Tb-1),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
			}
		}
		if ((Nb == 2 && Tb >= 2 && b == 4)) {
			{
				S8((2*Tb-1),(Tb-1),(0),(0));
				S9((2*Tb-1),(Tb-1),(0),(1));
				S11((2*Tb-1),(Tb-1),(0),(2));
				S3((2*Tb-1),(Tb-1),(0),(3));
				for(c3=1;c3 <= 3;c3+=1)
				 {
				 	S7((2*Tb-1),(Tb-1),(c3),(0));
				 	S6((2*Tb-1),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S10((2*Tb-1),(Tb-1),(c3),(c4));
				 	 }
				 }
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-2 && b == 3)) {
			{
				if (((Nb) % 2 == 0)) {
					{
						S8((2*Tb-1),((-Nb+2*Tb) / 2),(0),(0));
						S9((2*Tb-1),((-Nb+2*Tb) / 2),(0),(1));
						S3((2*Tb-1),((-Nb+2*Tb) / 2),(0),(2));
						for(c3=1;c3 <= 2;c3+=1)
						 {
						 	S7((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(0));
						 	S6((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(1));
						 	S10((2*Tb-1),((-Nb+2*Tb) / 2),(c3),(2));
						 }
					}
				}
				if (((Nb+1) % 2 == 0)) {
					{
						S7((2*Tb-1),((-Nb+2*Tb-1) / 2),(2),(0));
						S5((2*Tb-1),((-Nb+2*Tb-1) / 2),(2),(1));
					}
				}
				#pragma omp parallel for private(c3)
				for(c2=ceild(-Nb+2*Tb+1, 2);c2 <= Tb-1;c2+=1)
				 {
				 	S8((2*Tb-1),(c2),(0),(0));
				 	S9((2*Tb-1),(c2),(0),(1));
				 	S11((2*Tb-1),(c2),(0),(2));
				 	for(c3=1;c3 <= 2;c3+=1)
				 	 {
				 	 	S7((2*Tb-1),(c2),(c3),(0));
				 	 	S6((2*Tb-1),(c2),(c3),(1));
				 	 	S10((2*Tb-1),(c2),(c3),(2));
				 	 }
				 }
			}
		}
		if ((Nb == 2 && Tb >= 2 && b == 3)) {
			{
				S8((2*Tb-1),(Tb-1),(0),(0));
				S9((2*Tb-1),(Tb-1),(0),(1));
				S3((2*Tb-1),(Tb-1),(0),(2));
				for(c3=1;c3 <= 2;c3+=1)
				 {
				 	S7((2*Tb-1),(Tb-1),(c3),(0));
				 	S6((2*Tb-1),(Tb-1),(c3),(1));
				 	S10((2*Tb-1),(Tb-1),(c3),(2));
				 }
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-1)) {
			{
				if (((Nb) % 2 == 0)) {
					{
						S4((2*Tb),((-Nb+2*Tb) / 2),(1),(0));
					}
				}
			}
		}
		if ((Nb >= 4 && Nb <= 2*Tb-1 && b >= 5)) {
			{
				if (((Nb+1) % 2 == 0)) {
					{
						S8((2*Tb),((-Nb+2*Tb+1) / 2),(0),(0));
						S9((2*Tb),((-Nb+2*Tb+1) / 2),(0),(1));
						for(c4=2;c4 <= b-2;c4+=1)
						 {
						 	S11((2*Tb),((-Nb+2*Tb+1) / 2),(0),(c4));
						 }
						S3((2*Tb),((-Nb+2*Tb+1) / 2),(0),(b-1));
						for(c3=1;c3 <= b-1;c3+=1)
						 {
						 	S7((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(0));
						 	S6((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(1));
						 	for(c4=2;c4 <= b-1;c4+=1)
						 	 {
						 	 	S10((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(c4));
						 	 }
						 }
					}
				}
				if (((Nb) % 2 == 0)) {
					{
						S7((2*Tb),((-Nb+2*Tb) / 2),(2),(0));
						S5((2*Tb),((-Nb+2*Tb) / 2),(2),(1));
						S7((2*Tb),((-Nb+2*Tb) / 2),(3),(0));
						S6((2*Tb),((-Nb+2*Tb) / 2),(3),(1));
						S5((2*Tb),((-Nb+2*Tb) / 2),(3),(2));
						for(c3=4;c3 <= b-1;c3+=1)
						 {
						 	S7((2*Tb),((-Nb+2*Tb) / 2),(c3),(0));
						 	S6((2*Tb),((-Nb+2*Tb) / 2),(c3),(1));
						 	for(c4=2;c4 <= c3-2;c4+=1)
						 	 {
						 	 	S10((2*Tb),((-Nb+2*Tb) / 2),(c3),(c4));
						 	 }
						 	S5((2*Tb),((-Nb+2*Tb) / 2),(c3),(c3-1));
						 }
					}
				}
				#pragma omp parallel for private(c3,c4)
				for(c2=ceild(-Nb+2*Tb+2, 2);c2 <= Tb-1;c2+=1)
				 {
				 	S8((2*Tb),(c2),(0),(0));
				 	S9((2*Tb),(c2),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((2*Tb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= b-1;c3+=1)
				 	 {
				 	 	S7((2*Tb),(c2),(c3),(0));
				 	 	S6((2*Tb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S10((2*Tb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((2*Tb),(Tb),(0),(c4));
				 }
			}
		}
		if ((Nb == 3 && Tb >= 2 && b >= 5)) {
			{
				S8((2*Tb),(Tb-1),(0),(0));
				S9((2*Tb),(Tb-1),(0),(1));
				for(c4=2;c4 <= b-2;c4+=1)
				 {
				 	S11((2*Tb),(Tb-1),(0),(c4));
				 }
				S3((2*Tb),(Tb-1),(0),(b-1));
				for(c3=1;c3 <= b-1;c3+=1)
				 {
				 	S7((2*Tb),(Tb-1),(c3),(0));
				 	S6((2*Tb),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((2*Tb),(Tb-1),(c3),(c4));
				 	 }
				 }
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((2*Tb),(Tb),(0),(c4));
				 }
			}
		}
		if ((Nb >= 4 && Nb <= 2*Tb-1 && b == 4)) {
			{
				if (((Nb+1) % 2 == 0)) {
					{
						S8((2*Tb),((-Nb+2*Tb+1) / 2),(0),(0));
						S9((2*Tb),((-Nb+2*Tb+1) / 2),(0),(1));
						S11((2*Tb),((-Nb+2*Tb+1) / 2),(0),(2));
						S3((2*Tb),((-Nb+2*Tb+1) / 2),(0),(3));
						for(c3=1;c3 <= 3;c3+=1)
						 {
						 	S7((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(0));
						 	S6((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(1));
						 	for(c4=2;c4 <= 3;c4+=1)
						 	 {
						 	 	S10((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(c4));
						 	 }
						 }
					}
				}
				if (((Nb) % 2 == 0)) {
					{
						S7((2*Tb),((-Nb+2*Tb) / 2),(2),(0));
						S5((2*Tb),((-Nb+2*Tb) / 2),(2),(1));
						S7((2*Tb),((-Nb+2*Tb) / 2),(3),(0));
						S6((2*Tb),((-Nb+2*Tb) / 2),(3),(1));
						S5((2*Tb),((-Nb+2*Tb) / 2),(3),(2));
					}
				}
				#pragma omp parallel for private(c3,c4)
				for(c2=ceild(-Nb+2*Tb+2, 2);c2 <= Tb-1;c2+=1)
				 {
				 	S8((2*Tb),(c2),(0),(0));
				 	S9((2*Tb),(c2),(0),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S11((2*Tb),(c2),(0),(c4));
				 	 }
				 	for(c3=1;c3 <= 3;c3+=1)
				 	 {
				 	 	S7((2*Tb),(c2),(c3),(0));
				 	 	S6((2*Tb),(c2),(c3),(1));
				 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 {
				 	 	 	S10((2*Tb),(c2),(c3),(c4));
				 	 	 }
				 	 }
				 }
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((2*Tb),(Tb),(0),(c4));
				 }
			}
		}
		if ((Nb == 3 && Tb >= 2 && b == 4)) {
			{
				S8((2*Tb),(Tb-1),(0),(0));
				S9((2*Tb),(Tb-1),(0),(1));
				S11((2*Tb),(Tb-1),(0),(2));
				S3((2*Tb),(Tb-1),(0),(3));
				for(c3=1;c3 <= 3;c3+=1)
				 {
				 	S7((2*Tb),(Tb-1),(c3),(0));
				 	S6((2*Tb),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S10((2*Tb),(Tb-1),(c3),(c4));
				 	 }
				 }
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((2*Tb),(Tb),(0),(c4));
				 }
			}
		}
		if ((Nb >= 4 && Nb <= 2*Tb-1 && b == 3)) {
			{
				if (((Nb+1) % 2 == 0)) {
					{
						S8((2*Tb),((-Nb+2*Tb+1) / 2),(0),(0));
						S9((2*Tb),((-Nb+2*Tb+1) / 2),(0),(1));
						S3((2*Tb),((-Nb+2*Tb+1) / 2),(0),(2));
						for(c3=1;c3 <= 2;c3+=1)
						 {
						 	S7((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(0));
						 	S6((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(1));
						 	S10((2*Tb),((-Nb+2*Tb+1) / 2),(c3),(2));
						 }
					}
				}
				if (((Nb) % 2 == 0)) {
					{
						S7((2*Tb),((-Nb+2*Tb) / 2),(2),(0));
						S5((2*Tb),((-Nb+2*Tb) / 2),(2),(1));
					}
				}
				#pragma omp parallel for private(c3)
				for(c2=ceild(-Nb+2*Tb+2, 2);c2 <= Tb-1;c2+=1)
				 {
				 	S8((2*Tb),(c2),(0),(0));
				 	S9((2*Tb),(c2),(0),(1));
				 	S11((2*Tb),(c2),(0),(2));
				 	for(c3=1;c3 <= 2;c3+=1)
				 	 {
				 	 	S7((2*Tb),(c2),(c3),(0));
				 	 	S6((2*Tb),(c2),(c3),(1));
				 	 	S10((2*Tb),(c2),(c3),(2));
				 	 }
				 }
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				S11((2*Tb),(Tb),(0),(2));
			}
		}
		if ((Nb == 3 && Tb >= 2 && b == 3)) {
			{
				S8((2*Tb),(Tb-1),(0),(0));
				S9((2*Tb),(Tb-1),(0),(1));
				S3((2*Tb),(Tb-1),(0),(2));
				for(c3=1;c3 <= 2;c3+=1)
				 {
				 	S7((2*Tb),(Tb-1),(c3),(0));
				 	S6((2*Tb),(Tb-1),(c3),(1));
				 	S10((2*Tb),(Tb-1),(c3),(2));
				 }
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				S11((2*Tb),(Tb),(0),(2));
			}
		}
		if ((Nb >= 3 && Nb <= 2*Tb-1)) {
			{
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((2*Tb),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb == 2 && Tb >= 2 && b >= 5)) {
			{
				S4((2*Tb),(Tb-1),(1),(0));
				S7((2*Tb),(Tb-1),(2),(0));
				S5((2*Tb),(Tb-1),(2),(1));
				S7((2*Tb),(Tb-1),(3),(0));
				S6((2*Tb),(Tb-1),(3),(1));
				S5((2*Tb),(Tb-1),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((2*Tb),(Tb-1),(c3),(0));
				 	S6((2*Tb),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((2*Tb),(Tb-1),(c3),(c4));
				 	 }
				 	S5((2*Tb),(Tb-1),(c3),(c3-1));
				 }
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((2*Tb),(Tb),(0),(c4));
				 }
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((2*Tb),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb == 2 && Tb >= 2 && b == 4)) {
			{
				S4((2*Tb),(Tb-1),(1),(0));
				S7((2*Tb),(Tb-1),(2),(0));
				S5((2*Tb),(Tb-1),(2),(1));
				S7((2*Tb),(Tb-1),(3),(0));
				S6((2*Tb),(Tb-1),(3),(1));
				S5((2*Tb),(Tb-1),(3),(2));
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((2*Tb),(Tb),(0),(c4));
				 }
				for(c4=0;c4 <= 3;c4+=1)
				 {
				 	S12((2*Tb),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb == 2 && Tb >= 2 && b == 3)) {
			{
				S4((2*Tb),(Tb-1),(1),(0));
				S7((2*Tb),(Tb-1),(2),(0));
				S5((2*Tb),(Tb-1),(2),(1));
				S1((2*Tb),(Tb),(0),(0));
				S9((2*Tb),(Tb),(0),(1));
				S11((2*Tb),(Tb),(0),(2));
				for(c4=0;c4 <= 2;c4+=1)
				 {
				 	S12((2*Tb),(Tb),(1),(c4));
				 }
			}
		}
		if ((b >= 5)) {
			{
				for(c1=max(Nb+1,2*Tb+1);c1 <= Nb+2*Tb-4;c1+=1)
				 {
				 	if (((c1+Nb+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-Nb+1) / 2),(0),(0));
				 			S9((c1),((c1-Nb+1) / 2),(0),(1));
				 			for(c4=2;c4 <= b-2;c4+=1)
				 			 {
				 			 	S11((c1),((c1-Nb+1) / 2),(0),(c4));
				 			 }
				 			S3((c1),((c1-Nb+1) / 2),(0),(b-1));
				 			for(c3=1;c3 <= b-1;c3+=1)
				 			 {
				 			 	S7((c1),((c1-Nb+1) / 2),(c3),(0));
				 			 	S6((c1),((c1-Nb+1) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= b-1;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-Nb+1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 		}
				 	}
				 	if (((c1+Nb) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-Nb) / 2),(1),(0));
				 			S7((c1),((c1-Nb) / 2),(2),(0));
				 			S5((c1),((c1-Nb) / 2),(2),(1));
				 			S7((c1),((c1-Nb) / 2),(3),(0));
				 			S6((c1),((c1-Nb) / 2),(3),(1));
				 			S5((c1),((c1-Nb) / 2),(3),(2));
				 			for(c3=4;c3 <= b-1;c3+=1)
				 			 {
				 			 	S7((c1),((c1-Nb) / 2),(c3),(0));
				 			 	S6((c1),((c1-Nb) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= c3-2;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-Nb) / 2),(c3),(c4));
				 			 	 }
				 			 	S5((c1),((c1-Nb) / 2),(c3),(c3-1));
				 			 }
				 		}
				 	}
				 	#pragma omp parallel for private(c3,c4)
				 	for(c2=ceild(c1-Nb+2, 2);c2 <= Tb-1;c2+=1)
				 	 {
				 	 	S8((c1),(c2),(0),(0));
				 	 	S9((c1),(c2),(0),(1));
				 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 {
				 	 	 	S11((c1),(c2),(0),(c4));
				 	 	 }
				 	 	for(c3=1;c3 <= b-1;c3+=1)
				 	 	 {
				 	 	 	S7((c1),(c2),(c3),(0));
				 	 	 	S6((c1),(c2),(c3),(1));
				 	 	 	for(c4=2;c4 <= b-1;c4+=1)
				 	 	 	 {
				 	 	 	 	S10((c1),(c2),(c3),(c4));
				 	 	 	 }
				 	 	 }
				 	 }
				 	S8((c1),(Tb),(0),(0));
				 	S9((c1),(Tb),(0),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S11((c1),(Tb),(0),(c4));
				 	 }
				 	for(c4=0;c4 <= b-1;c4+=1)
				 	 {
				 	 	S12((c1),(Tb),(1),(c4));
				 	 }
				 }
			}
		}
		if ((Nb >= 4 && Tb >= 2 && b >= 5)) {
			{
				S8((Nb+2*Tb-3),(Tb-1),(0),(0));
				S9((Nb+2*Tb-3),(Tb-1),(0),(1));
				for(c4=2;c4 <= b-2;c4+=1)
				 {
				 	S11((Nb+2*Tb-3),(Tb-1),(0),(c4));
				 }
				S3((Nb+2*Tb-3),(Tb-1),(0),(b-1));
				for(c3=1;c3 <= b-1;c3+=1)
				 {
				 	S7((Nb+2*Tb-3),(Tb-1),(c3),(0));
				 	S6((Nb+2*Tb-3),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= b-1;c4+=1)
				 	 {
				 	 	S10((Nb+2*Tb-3),(Tb-1),(c3),(c4));
				 	 }
				 }
				S8((Nb+2*Tb-3),(Tb),(0),(0));
				S9((Nb+2*Tb-3),(Tb),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((Nb+2*Tb-3),(Tb),(0),(c4));
				 }
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((Nb+2*Tb-3),(Tb),(1),(c4));
				 }
			}
		}
		if ((b == 4)) {
			{
				for(c1=max(Nb+1,2*Tb+1);c1 <= Nb+2*Tb-4;c1+=1)
				 {
				 	if (((c1+Nb+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-Nb+1) / 2),(0),(0));
				 			S9((c1),((c1-Nb+1) / 2),(0),(1));
				 			S11((c1),((c1-Nb+1) / 2),(0),(2));
				 			S3((c1),((c1-Nb+1) / 2),(0),(3));
				 			for(c3=1;c3 <= 3;c3+=1)
				 			 {
				 			 	S7((c1),((c1-Nb+1) / 2),(c3),(0));
				 			 	S6((c1),((c1-Nb+1) / 2),(c3),(1));
				 			 	for(c4=2;c4 <= 3;c4+=1)
				 			 	 {
				 			 	 	S10((c1),((c1-Nb+1) / 2),(c3),(c4));
				 			 	 }
				 			 }
				 		}
				 	}
				 	if (((c1+Nb) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-Nb) / 2),(1),(0));
				 			S7((c1),((c1-Nb) / 2),(2),(0));
				 			S5((c1),((c1-Nb) / 2),(2),(1));
				 			S7((c1),((c1-Nb) / 2),(3),(0));
				 			S6((c1),((c1-Nb) / 2),(3),(1));
				 			S5((c1),((c1-Nb) / 2),(3),(2));
				 		}
				 	}
				 	#pragma omp parallel for private(c3,c4)
				 	for(c2=ceild(c1-Nb+2, 2);c2 <= Tb-1;c2+=1)
				 	 {
				 	 	S8((c1),(c2),(0),(0));
				 	 	S9((c1),(c2),(0),(1));
				 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 {
				 	 	 	S11((c1),(c2),(0),(c4));
				 	 	 }
				 	 	for(c3=1;c3 <= 3;c3+=1)
				 	 	 {
				 	 	 	S7((c1),(c2),(c3),(0));
				 	 	 	S6((c1),(c2),(c3),(1));
				 	 	 	for(c4=2;c4 <= 3;c4+=1)
				 	 	 	 {
				 	 	 	 	S10((c1),(c2),(c3),(c4));
				 	 	 	 }
				 	 	 }
				 	 }
				 	S8((c1),(Tb),(0),(0));
				 	S9((c1),(Tb),(0),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S11((c1),(Tb),(0),(c4));
				 	 }
				 	for(c4=0;c4 <= 3;c4+=1)
				 	 {
				 	 	S12((c1),(Tb),(1),(c4));
				 	 }
				 }
			}
		}
		if ((Nb >= 4 && Tb >= 2 && b == 4)) {
			{
				S8((Nb+2*Tb-3),(Tb-1),(0),(0));
				S9((Nb+2*Tb-3),(Tb-1),(0),(1));
				S11((Nb+2*Tb-3),(Tb-1),(0),(2));
				S3((Nb+2*Tb-3),(Tb-1),(0),(3));
				for(c3=1;c3 <= 3;c3+=1)
				 {
				 	S7((Nb+2*Tb-3),(Tb-1),(c3),(0));
				 	S6((Nb+2*Tb-3),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= 3;c4+=1)
				 	 {
				 	 	S10((Nb+2*Tb-3),(Tb-1),(c3),(c4));
				 	 }
				 }
				S8((Nb+2*Tb-3),(Tb),(0),(0));
				S9((Nb+2*Tb-3),(Tb),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((Nb+2*Tb-3),(Tb),(0),(c4));
				 }
				for(c4=0;c4 <= 3;c4+=1)
				 {
				 	S12((Nb+2*Tb-3),(Tb),(1),(c4));
				 }
			}
		}
		if ((b == 3)) {
			{
				for(c1=max(Nb+1,2*Tb+1);c1 <= Nb+2*Tb-4;c1+=1)
				 {
				 	if (((c1+Nb+1) % 2 == 0)) {
				 		{
				 			S8((c1),((c1-Nb+1) / 2),(0),(0));
				 			S9((c1),((c1-Nb+1) / 2),(0),(1));
				 			S3((c1),((c1-Nb+1) / 2),(0),(2));
				 			for(c3=1;c3 <= 2;c3+=1)
				 			 {
				 			 	S7((c1),((c1-Nb+1) / 2),(c3),(0));
				 			 	S6((c1),((c1-Nb+1) / 2),(c3),(1));
				 			 	S10((c1),((c1-Nb+1) / 2),(c3),(2));
				 			 }
				 		}
				 	}
				 	if (((c1+Nb) % 2 == 0)) {
				 		{
				 			S4((c1),((c1-Nb) / 2),(1),(0));
				 			S7((c1),((c1-Nb) / 2),(2),(0));
				 			S5((c1),((c1-Nb) / 2),(2),(1));
				 		}
				 	}
				 	#pragma omp parallel for private(c3)
				 	for(c2=ceild(c1-Nb+2, 2);c2 <= Tb-1;c2+=1)
				 	 {
				 	 	S8((c1),(c2),(0),(0));
				 	 	S9((c1),(c2),(0),(1));
				 	 	S11((c1),(c2),(0),(2));
				 	 	for(c3=1;c3 <= 2;c3+=1)
				 	 	 {
				 	 	 	S7((c1),(c2),(c3),(0));
				 	 	 	S6((c1),(c2),(c3),(1));
				 	 	 	S10((c1),(c2),(c3),(2));
				 	 	 }
				 	 }
				 	S8((c1),(Tb),(0),(0));
				 	S9((c1),(Tb),(0),(1));
				 	S11((c1),(Tb),(0),(2));
				 	for(c4=0;c4 <= 2;c4+=1)
				 	 {
				 	 	S12((c1),(Tb),(1),(c4));
				 	 }
				 }
			}
		}
		if ((Nb >= 4 && Tb >= 2 && b == 3)) {
			{
				S8((Nb+2*Tb-3),(Tb-1),(0),(0));
				S9((Nb+2*Tb-3),(Tb-1),(0),(1));
				S3((Nb+2*Tb-3),(Tb-1),(0),(2));
				for(c3=1;c3 <= 2;c3+=1)
				 {
				 	S7((Nb+2*Tb-3),(Tb-1),(c3),(0));
				 	S6((Nb+2*Tb-3),(Tb-1),(c3),(1));
				 	S10((Nb+2*Tb-3),(Tb-1),(c3),(2));
				 }
				S8((Nb+2*Tb-3),(Tb),(0),(0));
				S9((Nb+2*Tb-3),(Tb),(0),(1));
				S11((Nb+2*Tb-3),(Tb),(0),(2));
				for(c4=0;c4 <= 2;c4+=1)
				 {
				 	S12((Nb+2*Tb-3),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb >= 3 && Tb >= 2 && b >= 5)) {
			{
				S4((Nb+2*Tb-2),(Tb-1),(1),(0));
				S7((Nb+2*Tb-2),(Tb-1),(2),(0));
				S5((Nb+2*Tb-2),(Tb-1),(2),(1));
				S7((Nb+2*Tb-2),(Tb-1),(3),(0));
				S6((Nb+2*Tb-2),(Tb-1),(3),(1));
				S5((Nb+2*Tb-2),(Tb-1),(3),(2));
				for(c3=4;c3 <= b-1;c3+=1)
				 {
				 	S7((Nb+2*Tb-2),(Tb-1),(c3),(0));
				 	S6((Nb+2*Tb-2),(Tb-1),(c3),(1));
				 	for(c4=2;c4 <= c3-2;c4+=1)
				 	 {
				 	 	S10((Nb+2*Tb-2),(Tb-1),(c3),(c4));
				 	 }
				 	S5((Nb+2*Tb-2),(Tb-1),(c3),(c3-1));
				 }
				S8((Nb+2*Tb-2),(Tb),(0),(0));
				S9((Nb+2*Tb-2),(Tb),(0),(1));
				for(c4=2;c4 <= b-1;c4+=1)
				 {
				 	S11((Nb+2*Tb-2),(Tb),(0),(c4));
				 }
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((Nb+2*Tb-2),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb >= 3 && Tb >= 2 && b == 4)) {
			{
				S4((Nb+2*Tb-2),(Tb-1),(1),(0));
				S7((Nb+2*Tb-2),(Tb-1),(2),(0));
				S5((Nb+2*Tb-2),(Tb-1),(2),(1));
				S7((Nb+2*Tb-2),(Tb-1),(3),(0));
				S6((Nb+2*Tb-2),(Tb-1),(3),(1));
				S5((Nb+2*Tb-2),(Tb-1),(3),(2));
				S8((Nb+2*Tb-2),(Tb),(0),(0));
				S9((Nb+2*Tb-2),(Tb),(0),(1));
				for(c4=2;c4 <= 3;c4+=1)
				 {
				 	S11((Nb+2*Tb-2),(Tb),(0),(c4));
				 }
				for(c4=0;c4 <= 3;c4+=1)
				 {
				 	S12((Nb+2*Tb-2),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb >= 3 && Tb >= 2 && b == 3)) {
			{
				S4((Nb+2*Tb-2),(Tb-1),(1),(0));
				S7((Nb+2*Tb-2),(Tb-1),(2),(0));
				S5((Nb+2*Tb-2),(Tb-1),(2),(1));
				S8((Nb+2*Tb-2),(Tb),(0),(0));
				S9((Nb+2*Tb-2),(Tb),(0),(1));
				S11((Nb+2*Tb-2),(Tb),(0),(2));
				for(c4=0;c4 <= 2;c4+=1)
				 {
				 	S12((Nb+2*Tb-2),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb >= 2 && b >= 4)) {
			{
				S8((Nb+2*Tb-1),(Tb),(0),(0));
				S9((Nb+2*Tb-1),(Tb),(0),(1));
				for(c4=2;c4 <= b-2;c4+=1)
				 {
				 	S11((Nb+2*Tb-1),(Tb),(0),(c4));
				 }
				S3((Nb+2*Tb-1),(Tb),(0),(b-1));
				for(c4=0;c4 <= b-1;c4+=1)
				 {
				 	S12((Nb+2*Tb-1),(Tb),(1),(c4));
				 }
			}
		}
		if ((Nb >= 2 && b == 3)) {
			{
				S8((Nb+2*Tb-1),(Tb),(0),(0));
				S9((Nb+2*Tb-1),(Tb),(0),(1));
				S3((Nb+2*Tb-1),(Tb),(0),(2));
				for(c4=0;c4 <= 2;c4+=1)
				 {
				 	S12((Nb+2*Tb-1),(Tb),(1),(c4));
				 }
			}
		}
	}
	#undef S0
	#undef S1
	#undef S2
	#undef S3
	#undef S4
	#undef S5
	#undef S6
	#undef S7
	#undef S8
	#undef S9
	#undef S10
	#undef S11
	#undef S12
	
	//Memory Free
	free(_lin_TempSpace);
	free(TempSpace);
}

//Memory Macros
#undef A_bl
#undef B_bl
#undef TempSpace


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
