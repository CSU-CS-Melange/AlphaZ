# 1 "./ppout/linear-algebra/kernels/symm/symm.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/symm/symm.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/symm/symm.c" 2
# 1 "./ppout/linear-algebra/kernels/symm/symm.h" 1
# 3 "./ppout/linear-algebra/kernels/symm/symm.c" 2

void kernel_symm(int ni, int nj,
   double alpha,
   double beta,
   double C[1024 + 0][1024 + 0],
   double A[1024 + 0][1024 + 0],
   double B[1024 + 0][1024 + 0])
{
  int i, j, k;
  double acc;

#pragma scop

  for (i = 0; i < ni; i++)
    for (j = 0; j < nj; j++)
      {
 acc = 0;
 for (k = 0; k < j - 1; k++)
   {
     C[k][j] += alpha * A[k][i] * B[i][j];
     acc += B[k][j] * A[k][i];
   }
 C[i][j] = beta * C[i][j] + alpha * A[i][i] * B[i][j] + alpha * acc;
      }
#pragma endscop
}
