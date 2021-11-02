# 1 "./ppout/linear-algebra/kernels/mvt/mvt.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/mvt/mvt.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/mvt/mvt.c" 2
# 1 "./ppout/linear-algebra/kernels/mvt/mvt.h" 1
# 3 "./ppout/linear-algebra/kernels/mvt/mvt.c" 2

void kernel_mvt(int n,
  double x1[4000 + 0],
  double x2[4000 + 0],
  double y_1[4000 + 0],
  double y_2[4000 + 0],
  double A[4000 + 0][4000 + 0])
{
  int i, j;

#pragma scop
  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++)
      x1[i] = x1[i] + A[i][j] * y_1[j];
  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++)
      x2[i] = x2[i] + A[j][i] * y_2[j];
#pragma endscop
}
