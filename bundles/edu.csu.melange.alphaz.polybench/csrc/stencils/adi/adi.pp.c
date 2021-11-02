# 1 "./ppout/stencils/adi/adi.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/stencils/adi/adi.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/stencils/adi/adi.c" 2
# 1 "./ppout/stencils/adi/adi.h" 1
# 3 "./ppout/stencils/adi/adi.c" 2

void kernel_adi(int tsteps,
  int n,
  double X[1024 + 0][1024 + 0],
  double A[1024 + 0][1024 + 0],
  double B[1024 + 0][1024 + 0])
{
  int t, i1, i2;

#pragma scop
  for (t = 0; t < tsteps; t++)
    {
      for (i1 = 0; i1 < n; i1++)
 for (i2 = 1; i2 < n; i2++)
   {
     X[i1][i2] = X[i1][i2] - X[i1][i2-1] * A[i1][i2] / B[i1][i2-1];
     B[i1][i2] = B[i1][i2] - A[i1][i2] * A[i1][i2] / B[i1][i2-1];
   }

      for (i1 = 0; i1 < n; i1++)
 X[i1][n-1] = X[i1][n-1] / B[i1][n-1];

      for (i1 = 0; i1 < n; i1++)
 for (i2 = 0; i2 < n-2; i2++)
   X[i1][n-i2-2] = (X[i1][n-2-i2] - X[i1][n-2-i2-1] * A[i1][n-i2-3]) / B[i1][n-3-i2];

      for (i1 = 1; i1 < n; i1++)
 for (i2 = 0; i2 < n; i2++) {
   X[i1][i2] = X[i1][i2] - X[i1-1][i2] * A[i1][i2] / B[i1-1][i2];
   B[i1][i2] = B[i1][i2] - A[i1][i2] * A[i1][i2] / B[i1-1][i2];
 }

      for (i2 = 0; i2 < n; i2++)
 X[n-1][i2] = X[n-1][i2] / B[n-1][i2];

      for (i1 = 0; i1 < n-2; i1++)
 for (i2 = 0; i2 < n; i2++)
   X[n-2-i1][i2] = (X[n-2-i1][i2] - X[n-i1-3][i2] * A[n-3-i1][i2]) / B[n-2-i1][i2];
    }
#pragma endscop
}
