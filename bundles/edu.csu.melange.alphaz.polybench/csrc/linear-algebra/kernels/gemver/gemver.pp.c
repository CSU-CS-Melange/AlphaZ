# 1 "./ppout/linear-algebra/kernels/gemver/gemver.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/gemver/gemver.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/gemver/gemver.c" 2
# 1 "./ppout/linear-algebra/kernels/gemver/gemver.h" 1
# 3 "./ppout/linear-algebra/kernels/gemver/gemver.c" 2

void kernel_gemver(int n,
     double alpha,
     double beta,
     double A[4000 + 0][4000 + 0],
     double u1[4000 + 0],
     double v1[4000 + 0],
     double u2[4000 + 0],
     double v2[4000 + 0],
     double w[4000 + 0],
     double x[4000 + 0],
     double y[4000 + 0],
     double z[4000 + 0])
{
  int i, j;

#pragma scop

  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++)
      A[i][j] = A[i][j] + u1[i] * v1[j] + u2[i] * v2[j];

  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++)
      x[i] = x[i] + beta * A[j][i] * y[j];

  for (i = 0; i < n; i++)
    x[i] = x[i] + z[i];

  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++)
      w[i] = w[i] + alpha * A[i][j] * x[j];

#pragma endscop
}
