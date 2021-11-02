#include <stdlib.h>
#include <stdio.h>

void kernel_atax(int m, int n, double** A, double* x, double* y, double* tmp) {
  int i, j;
//	printf("kernel_atax DONE!\n");
#pragma scop
  for (i = 0; i < n; i++)
    y[i] = 0;
  for (i = 0; i < m; i++)
	{
		tmp[i] = 0.0f;
		for (j = 0; j < n; j++)
			tmp[i] = tmp[i] + A[i][j] * x[j];
		for (j = 0; j < n; j++)
			y[j] = y[j] + A[i][j] * tmp[i];
	}
#pragma endscop
}


void atax_verify(long M, long N, double** A, double* x, double* y_verify) {
	double *tmp = (double *)malloc(sizeof(double)*M);
//	printf("M:%d,N:%d\n", M,N);
	
/*	for (int i=0; i<N; i++) {
		printf("A[0][%d]=%f\n", i,A[0][i]);
	}
*/
	
	kernel_atax(M, N, A, x, y_verify,tmp);

}
