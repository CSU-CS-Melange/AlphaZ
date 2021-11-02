# 1 "./ppout/linear-algebra/solvers/gramschmidt/gramschmidt.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/solvers/gramschmidt/gramschmidt.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/solvers/gramschmidt/gramschmidt.c" 2
# 1 "./ppout/linear-algebra/solvers/gramschmidt/gramschmidt.h" 1
# 3 "./ppout/linear-algebra/solvers/gramschmidt/gramschmidt.c" 2

#pragma GCS_PURE_FUNCTION
double sqrt(double);

void kernel_gramschmidt(int ni, int nj,
   double A[512 + 0][512 + 0],
   double R[512 + 0][512 + 0],
   double Q[512 + 0][512 + 0])
{
  int i, j, k;

  double nrm;

#pragma scop
  for (k = 0; k < nj; k++)
    {
      nrm = 0;
      for (i = 0; i < ni; i++)
        nrm += A[i][k] * A[i][k];
      R[k][k] = sqrt(nrm);
      for (i = 0; i < ni; i++)
        Q[i][k] = A[i][k] / R[k][k];
      for (j = k + 1; j < nj; j++)
 {
   R[k][j] = 0;
   for (i = 0; i < ni; i++)
     R[k][j] += Q[i][k] * A[i][j];
   for (i = 0; i < ni; i++)
     A[i][j] = A[i][j] - Q[i][k] * R[k][j];
 }
    }
#pragma endscop
}
