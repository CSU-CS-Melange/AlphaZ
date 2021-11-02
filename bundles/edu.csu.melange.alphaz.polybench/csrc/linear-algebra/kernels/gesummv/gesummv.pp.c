# 1 "./ppout/linear-algebra/kernels/gesummv/gesummv.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/gesummv/gesummv.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/gesummv/gesummv.c" 2
# 1 "./ppout/linear-algebra/kernels/gesummv/gesummv.h" 1
# 3 "./ppout/linear-algebra/kernels/gesummv/gesummv.c" 2

void kernel_gesummv(int n,
      double alpha,
      double beta,
      double A[4000 + 0][4000 + 0],
      double B[4000 + 0][4000 + 0],
      double tmp[4000 + 0],
      double x[4000 + 0],
      double y[4000 + 0])
{
  int i, j;

#pragma scop
  for (i = 0; i < n; i++)
    {
      tmp[i] = 0;
      y[i] = 0;
      for (j = 0; j < n; j++)
 {
   tmp[i] = A[i][j] * x[j] + tmp[i];
   y[i] = B[i][j] * x[j] + y[i];
 }
      y[i] = alpha * tmp[i] + beta * y[i];
    }
#pragma endscop
}
