# 1 "./ppout/stencils/seidel-2d/seidel-2d.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/stencils/seidel-2d/seidel-2d.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/stencils/seidel-2d/seidel-2d.c" 2
# 1 "./ppout/stencils/seidel-2d/seidel-2d.h" 1
# 3 "./ppout/stencils/seidel-2d/seidel-2d.c" 2

void kernel_seidel_2d(int tsteps,
        int n,
        double A[1000 + 0][1000 + 0])
{
  int t, i, j;

#pragma scop
  for (t = 0; t <= tsteps - 1; t++)
    for (i = 1; i<= n - 2; i++)
      for (j = 1; j <= n - 2; j++)
 A[i][j] = (A[i-1][j-1] + A[i-1][j] + A[i-1][j+1]
     + A[i][j-1] + A[i][j] + A[i][j+1]
     + A[i+1][j-1] + A[i+1][j] + A[i+1][j+1])/9.0;
#pragma endscop
}
