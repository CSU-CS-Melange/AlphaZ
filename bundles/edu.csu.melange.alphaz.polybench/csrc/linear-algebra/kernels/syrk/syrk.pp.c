# 1 "./ppout/linear-algebra/kernels/syrk/syrk.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/syrk/syrk.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/syrk/syrk.c" 2
# 1 "./ppout/linear-algebra/kernels/syrk/syrk.h" 1
# 3 "./ppout/linear-algebra/kernels/syrk/syrk.c" 2

void kernel_syrk(int ni, int nj,
   double alpha,
   double beta,
   double C[1024 + 0][1024 + 0],
   double A[1024 + 0][1024 + 0])
{
  int i, j, k;

#pragma scop

  for (i = 0; i < ni; i++)
    for (j = 0; j < ni; j++)
      C[i][j] *= beta;
  for (i = 0; i < ni; i++)
    for (j = 0; j < ni; j++)
      for (k = 0; k < nj; k++)
   C[i][j] += alpha * A[i][k] * A[j][k];
#pragma endscop
}
