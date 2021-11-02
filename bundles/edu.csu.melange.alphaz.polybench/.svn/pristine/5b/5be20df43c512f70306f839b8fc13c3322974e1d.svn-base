# 1 "./ppout/linear-algebra/kernels/trisolv/trisolv.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/trisolv/trisolv.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/trisolv/trisolv.c" 2
# 1 "./ppout/linear-algebra/kernels/trisolv/trisolv.h" 1
# 3 "./ppout/linear-algebra/kernels/trisolv/trisolv.c" 2

void kernel_trisolv(int n,
      double A[4000 + 0][4000 + 0],
      double x[4000 + 0],
      double c[4000 + 0])
{
  int i, j;

#pragma scop
  for (i = 0; i < n; i++)
    {
      x[i] = c[i];
      for (j = 0; j <= i - 1; j++)
        x[i] = x[i] - A[i][j] * x[j];
      x[i] = x[i] / A[i][i];
    }
#pragma endscop
}
