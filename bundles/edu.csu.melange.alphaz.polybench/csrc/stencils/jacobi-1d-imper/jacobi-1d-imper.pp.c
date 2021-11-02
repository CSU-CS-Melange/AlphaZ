# 1 "./ppout/stencils/jacobi-1d-imper/jacobi-1d-imper.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/stencils/jacobi-1d-imper/jacobi-1d-imper.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/stencils/jacobi-1d-imper/jacobi-1d-imper.c" 2
# 1 "./ppout/stencils/jacobi-1d-imper/jacobi-1d-imper.h" 1
# 3 "./ppout/stencils/jacobi-1d-imper/jacobi-1d-imper.c" 2

void kernel_jacobi_1d_imper(int tsteps,
       int n,
       double A[10000 + 0],
       double B[10000 + 0])
{
  int t, i, j;

#pragma scop
  for (t = 0; t < tsteps; t++)
    {
      for (i = 1; i < n - 1; i++)
 B[i] = 0.33333 * (A[i-1] + A[i] + A[i + 1]);
      for (j = 1; j < n - 1; j++)
 A[j] = B[j];
    }
#pragma endscop
}
