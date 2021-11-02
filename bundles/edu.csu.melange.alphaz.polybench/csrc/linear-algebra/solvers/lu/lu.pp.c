# 1 "./ppout/linear-algebra/solvers/lu/lu.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/solvers/lu/lu.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/solvers/lu/lu.c" 2
# 1 "./ppout/linear-algebra/solvers/lu/lu.h" 1
# 3 "./ppout/linear-algebra/solvers/lu/lu.c" 2

void kernel_lu(int n,
        double A[1024 + 0][1024 + 0])
{
  int i, j, k;

#pragma scop
  for (k = 0; k < n; k++)
    {
      for (j = k + 1; j < n; j++)
 A[k][j] = A[k][j] / A[k][k];
      for(i = k + 1; i < n; i++)
 for (j = k + 1; j < n; j++)
   A[i][j] = A[i][j] - A[i][k] * A[k][j];
    }
#pragma endscop
}
