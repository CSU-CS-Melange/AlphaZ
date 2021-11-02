# 1 "./ppout/linear-algebra/solvers/dynprog/dynprog.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/linear-algebra/solvers/dynprog/dynprog.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/linear-algebra/solvers/dynprog/dynprog.c" 2
# 1 "./ppout/linear-algebra/solvers/dynprog/dynprog.h" 1
# 3 "./ppout/linear-algebra/solvers/dynprog/dynprog.c" 2

void kernel_dynprog(int tsteps, int length,
      int c[50 + 0][50 + 0],
      int W[50 + 0][50 + 0],
      int sum_c[50 + 0][50 + 0][50 + 0],
      int *out)
{
  int iter, i, j, k;

  int out_l = 0;

#pragma scop
  for (iter = 0; iter < tsteps; iter++) {
     for (i = 0; i <= length - 1; i++)
        for (j = 0; j <= length - 1; j++)
           c[i][j] = 0;

     for (i = 0; i <= length - 2; i++) {
        for (j = i + 1; j <= length - 1; j++) {
           sum_c[i][j][i] = 0;
           for (k = i + 1; k <= j-1; k++)
              sum_c[i][j][k] = sum_c[i][j][k - 1] + c[i][k] + c[k][j];
           c[i][j] = sum_c[i][j][j-1] + W[i][j];
        }
     }
     out_l += c[0][length - 1];
  }
#pragma endscop
}
