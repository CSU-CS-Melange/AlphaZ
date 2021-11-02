# 1 "./ppout/medley/reg_detect/reg_detect.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/medley/reg_detect/reg_detect.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/medley/reg_detect/reg_detect.c" 2
# 1 "./ppout/medley/reg_detect/reg_detect.h" 1
# 3 "./ppout/medley/reg_detect/reg_detect.c" 2

void kernel_reg_detect(int niter, int maxgrid, int length,
         int sum_tang[6 + 0][6 + 0],
         int mean[6 + 0][6 + 0],
         int path[6 + 0][6 + 0],
         int diff[6 + 0][6 + 0][64 + 0],
         int sum_diff[6 + 0][6 + 0][64 + 0])
{
  int t, i, j, cnt;

#pragma scop
  for (t = 0; t < niter; t++)
    {
      for (j = 0; j <= maxgrid - 1; j++)
 for (i = j; i <= maxgrid - 1; i++)
   for (cnt = 0; cnt <= length - 1; cnt++)
     diff[j][i][cnt] = sum_tang[j][i];

      for (j = 0; j <= maxgrid - 1; j++)
        {
   for (i = j; i <= maxgrid - 1; i++)
            {
       sum_diff[j][i][0] = diff[j][i][0];
       for (cnt = 1; cnt <= length - 1; cnt++)
  sum_diff[j][i][cnt] = sum_diff[j][i][cnt - 1] + diff[j][i][cnt];
       mean[j][i] = sum_diff[j][i][length - 1];
            }
        }

      for (i = 0; i <= maxgrid - 1; i++)
         path[0][i] = mean[0][i];

      for (j = 1; j <= maxgrid - 1; j++)
         for (i = j; i <= maxgrid - 1; i++)
            path[j][i] = path[j - 1][i - 1] + mean[j][i];
   }
#pragma endscop
}
