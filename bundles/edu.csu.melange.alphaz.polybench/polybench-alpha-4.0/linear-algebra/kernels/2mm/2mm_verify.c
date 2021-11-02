#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <math.h>


// To manage constants (coming from Polybench/C - 2mm.h)
#define SCALAR_VAL(x) x


// ALSO: add this line to the generated wrapper (in the "//Compare outputs for verification" block - after undefining the macro of this block:
//				printf("Error Number = %i \n", _errors_);


// Function from the Polybench/C  (coming from 2mm.c)
void mm2_verify_scop(long ni, long nj, long nk, long nl,
		double alpha,
		double beta,
		double** tmp,
		double** A,
		double** B,
		double** C,
		double** D)
{
  int i, j, k;
  
  // ADDED - problem parameters (coming from 2mm.h)
  long _PB_NI = ni;
  long _PB_NJ = nj;
  long _PB_NK = nk;
  long _PB_NL = nl;
  // END ADDED

#pragma scop
  /* D := alpha*A*B*C + beta*D */
  for (i = 0; i < _PB_NI; i++)
    for (j = 0; j < _PB_NJ; j++)
      {
	tmp[i][j] = SCALAR_VAL(0);
	for (k = 0; k < _PB_NK; ++k)
	  tmp[i][j] += alpha * A[i][k] * B[k][j];
      }
  for (i = 0; i < _PB_NI; i++)
    for (j = 0; j < _PB_NL; j++)
      {
	D[i][j] *= beta;
	for (k = 0; k < _PB_NJ; ++k)
	  D[i][j] += tmp[i][k] * C[k][j];
      }
#pragma endscop

}

// Function which matched the alpha code generated function signature
void _2mm_verify(long P, long Q, long R, long S, double* alpha, double* beta,
	double** A, double** B, double** C, double** D, double** E) {
		
		// Dealing with scalars (coming from the generated 2mm.c code)
		double nalpha = *alpha;
		double nbeta = *beta;
		
		// Dealing with temporary arrays (coming from the generated 2mm.c code)
		double* _lin_temp = (double*) malloc(sizeof(double)*((P) * (R)));
		double** temp = (double**) malloc(sizeof(double*)*(P));
		for (int k=0; k<P; k++)
			temp[k] = &_lin_temp[k*R];
		
		mm2_verify_scop(P,Q,R,S,nalpha,nbeta,temp,A,B,C,D);
		
		// Output: in the polybench/C code, D is overwritten => copy it to E
		for (int i=0; i<P; i++)
			for (int j=0; j<Q; j++)
				E[i][j] = D[i][j];
}

// *** FROM THE GENERATED WRAPPER:
// _2mm_verify(P, Q, R, S, &alpha, &beta, A, B, C, D, E_verify);
//void _2mm_verify(long, long, long, long, double*, double*, double**, double**, double**, double**, double**);
