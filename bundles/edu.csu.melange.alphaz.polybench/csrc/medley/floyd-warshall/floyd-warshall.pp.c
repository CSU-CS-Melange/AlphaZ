# 1 "./ppout/medley/floyd-warshall/floyd-warshall.c"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "./ppout/medley/floyd-warshall/floyd-warshall.c"
# 1 "polybench-c-3.2-pp/polybench-s.h" 1
# 197 "polybench-c-3.2-pp/polybench-s.h"
extern void* polybench_alloc_data(unsigned long long int n, int elt_size);
# 2 "./ppout/medley/floyd-warshall/floyd-warshall.c" 2
# 1 "./ppout/medley/floyd-warshall/floyd-warshall.h" 1
# 3 "./ppout/medley/floyd-warshall/floyd-warshall.c" 2

void kernel_floyd_warshall(int n,
      double path[1024 + 0][1024 + 0])
{
  int i, j, k;

#pragma scop
  for (k = 0; k < n; k++)
    {
      for(i = 0; i < n; i++)
         for (j = 0; j < n; j++)
            path[i][j] = path[i][j] < path[i][k] + path[k][j] ? path[i][j] : path[i][k] + path[k][j];
    }
#pragma endscop
}
