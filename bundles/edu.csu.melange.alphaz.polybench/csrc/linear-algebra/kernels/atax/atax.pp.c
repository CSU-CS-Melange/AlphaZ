# 1 "./ppout/linear-algebra/kernels/atax/atax.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/atax/atax.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/atax/atax.c" 2
# 1 "./ppout/linear-algebra/kernels/atax/atax.h" 1
# 3 "./ppout/linear-algebra/kernels/atax/atax.c" 2

void kernel_atax(int nx, int ny,
   double A[4000 + 0][4000 + 0],
   double x[4000 + 0],
   double y[4000 + 0],
   double tmp[4000 + 0])
{
  int i, j;

#pragma scop
  for (i = 0; i < ny; i++)
    y[i] = 0;
  for (i = 0; i < nx; i++)
    {
      tmp[i] = 0;
      for (j = 0; j < ny; j++)
 tmp[i] = tmp[i] + A[i][j] * x[j];
      for (j = 0; j < ny; j++)
 y[j] = y[j] + A[i][j] * tmp[i];
    }
#pragma endscop
}
