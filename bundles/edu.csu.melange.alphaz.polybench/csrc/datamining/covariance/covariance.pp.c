# 1 "./ppout/datamining/covariance/covariance.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/datamining/covariance/covariance.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/datamining/covariance/covariance.c" 2
# 1 "./ppout/datamining/covariance/covariance.h" 1
# 3 "./ppout/datamining/covariance/covariance.c" 2

void kernel_covariance(int m, int n,
         double float_n,
         double data[1000 + 0][1000 + 0],
         double symmat[1000 + 0][1000 + 0],
         double mean[1000 + 0])
{
  int i, j, j1, j2;

#pragma scop

  for (j = 0; j < m; j++)
    {
      mean[j] = 0.0;
      for (i = 0; i < n; i++)
        mean[j] += data[i][j];
      mean[j] /= float_n;
    }


  for (i = 0; i < n; i++)
    for (j = 0; j < m; j++)
      data[i][j] -= mean[j];


  for (j1 = 0; j1 < m; j1++)
    for (j2 = j1; j2 < m; j2++)
      {
        symmat[j1][j2] = 0.0;
        for (i = 0; i < n; i++)
   symmat[j1][j2] += data[i][j1] * data[i][j2];
        symmat[j2][j1] = symmat[j1][j2];
      }
#pragma endscop
}
