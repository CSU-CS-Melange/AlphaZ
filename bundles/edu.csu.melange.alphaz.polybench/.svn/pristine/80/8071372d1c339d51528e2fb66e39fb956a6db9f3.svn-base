# 1 "./ppout/linear-algebra/kernels/bicg/bicg.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/bicg/bicg.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/bicg/bicg.c" 2
# 1 "./ppout/linear-algebra/kernels/bicg/bicg.h" 1
# 3 "./ppout/linear-algebra/kernels/bicg/bicg.c" 2

void kernel_bicg(int nx, int ny,
   double A[4000 + 0][4000 + 0],
   double s[4000 + 0],
   double q[4000 + 0],
   double p[4000 + 0],
   double r[4000 + 0])
{
  int i, j;

#pragma scop
  for (i = 0; i < ny; i++)
    s[i] = 0;
  for (i = 0; i < nx; i++)
    {
      q[i] = 0;
      for (j = 0; j < ny; j++)
 {
   s[j] = s[j] + r[i] * A[i][j];
   q[i] = q[i] + A[i][j] * p[j];
 }
    }
#pragma endscop
}
