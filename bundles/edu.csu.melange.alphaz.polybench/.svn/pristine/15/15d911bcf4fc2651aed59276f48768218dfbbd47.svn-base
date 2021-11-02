# 1 "./ppout/linear-algebra/kernels/gemm/gemm.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/gemm/gemm.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/gemm/gemm.c" 2
# 1 "./ppout/linear-algebra/kernels/gemm/gemm.h" 1
# 3 "./ppout/linear-algebra/kernels/gemm/gemm.c" 2

void kernel_gemm(int ni, int nj, int nk,
   double alpha,
   double beta,
   double C[1024 + 0][1024 + 0],
   double A[1024 + 0][1024 + 0],
   double B[1024 + 0][1024 + 0])
{
  int i, j, k;

#pragma scop

  for (i = 0; i < ni; i++)
    for (j = 0; j < nj; j++)
      {
 C[i][j] *= beta;
 for (k = 0; k < nk; ++k)
   C[i][j] += alpha * A[i][k] * B[k][j];
      }
#pragma endscop
}
