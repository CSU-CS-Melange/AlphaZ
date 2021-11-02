# 1 "./ppout/linear-algebra/kernels/trmm/trmm.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/trmm/trmm.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/trmm/trmm.c" 2
# 1 "./ppout/linear-algebra/kernels/trmm/trmm.h" 1
# 3 "./ppout/linear-algebra/kernels/trmm/trmm.c" 2

void kernel_trmm(int ni,
   double alpha,
   double A[1024 + 0][1024 + 0],
   double B[1024 + 0][1024 + 0])
{
  int i, j, k;

#pragma scop

  for (i = 1; i < ni; i++)
    for (j = 0; j < ni; j++)
      for (k = 0; k < i; k++)
        B[i][j] += alpha * A[i][k] * B[j][k];
#pragma endscop
}
