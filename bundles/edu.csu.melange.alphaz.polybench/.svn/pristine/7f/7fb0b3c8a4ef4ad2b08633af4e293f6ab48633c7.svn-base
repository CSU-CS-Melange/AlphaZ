# 1 "./ppout/linear-algebra/kernels/doitgen/doitgen.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/kernels/doitgen/doitgen.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/kernels/doitgen/doitgen.c" 2
# 1 "./ppout/linear-algebra/kernels/doitgen/doitgen.h" 1
# 3 "./ppout/linear-algebra/kernels/doitgen/doitgen.c" 2

void kernel_doitgen(int nr, int nq, int np,
      double A[128 + 0][128 + 0][128 + 0],
      double C4[128 + 0][128 + 0],
      double sum[128 + 0][128 + 0][128 + 0])
{
  int r, q, p, s;

#pragma scop
  for (r = 0; r < nr; r++)
    for (q = 0; q < nq; q++) {
      for (p = 0; p < np; p++) {
 sum[r][q][p] = 0;
 for (s = 0; s < np; s++)
   sum[r][q][p] = sum[r][q][p] + A[r][q][s] * C4[s][p];
      }
      for (p = 0; p < nr; p++)
 A[r][q][p] = sum[r][q][p];
    }
#pragma endscop
}
