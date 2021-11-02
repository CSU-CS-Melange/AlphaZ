# 1 "./ppout/linear-algebra/kernels/cholesky/cholesky.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/cholesky/cholesky.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/cholesky/cholesky.c" 2
# 1 "./ppout/linear-algebra/kernels/cholesky/cholesky.h" 1
# 3 "./ppout/linear-algebra/kernels/cholesky/cholesky.c" 2

#pragma GCS_PURE_FUNCTION
double sqrt(double);

void kernel_cholesky(int n,
       double p[1024 + 0],
       double A[1024 + 0][1024 + 0])
{
  int i, j, k;

  double x;

#pragma scop
for (i = 0; i < n; ++i)
  {
    x = A[i][i];
    for (j = 0; j <= i - 1; ++j)
      x = x - A[i][j] * A[i][j];
    p[i] = 1.0 / sqrt(x);
    for (j = i + 1; j < n; ++j)
      {
 x = A[i][j];
 for (k = 0; k <= i - 1; ++k)
   x = x - A[j][k] * A[i][k];
 A[j][i] = x * p[i];
      }
  }
#pragma endscop
}
