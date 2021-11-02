# 1 "./ppout/linear-algebra/solvers/durbin/durbin.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/solvers/durbin/durbin.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/solvers/durbin/durbin.c" 2
# 1 "./ppout/linear-algebra/solvers/durbin/durbin.h" 1
# 3 "./ppout/linear-algebra/solvers/durbin/durbin.c" 2

void kernel_durbin(int n,
     double y[4000 + 0][4000 + 0],
     double sum[4000 + 0][4000 + 0],
     double alpha[4000 + 0],
     double beta[4000 + 0],
     double r[4000 + 0],
     double out[4000 + 0])
{
  int i, k;

#pragma scop
  y[0][0] = r[0];
  beta[0] = 1;
  alpha[0] = r[0];
  for (k = 1; k < n; k++)
    {
      beta[k] = beta[k-1] - alpha[k-1] * alpha[k-1] * beta[k-1];
      sum[0][k] = r[k];
      for (i = 0; i <= k - 1; i++)
 sum[i+1][k] = sum[i][k] + r[k-i-1] * y[i][k-1];
      alpha[k] = -sum[k][k] * beta[k];
      for (i = 0; i <= k-1; i++)
 y[i][k] = y[i][k-1] + alpha[k] * y[k-i-1][k-1];
      y[k][k] = alpha[k];
    }
  for (i = 0; i < n; i++)
    out[i] = y[i][n-1];
#pragma endscop
}
