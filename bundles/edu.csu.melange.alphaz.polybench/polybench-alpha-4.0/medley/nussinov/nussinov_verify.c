#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <math.h>



// To manage constants (coming from Polybench/C - nussinov.h)
#define match(b1, b2) (((b1)+(b2)) == 3 ? 1 : 0)
#define max_score(s1, s2) ((s1 >= s2) ? s1 : s2)

// ALSO: add this line to the generated wrapper (in the "//Compare outputs for verification" block - after undefining the macro of this block:
//				printf("Error Number = %i \n", _errors_);


// Function from the Polybench/C  (coming from nussinov.c)
void nussinov_verify_scoop(int n, int* seq,
			   int** table)
{
  int i, j, k;

// ADDED - problem parameters (coming from nussinov.h)
long _PB_N = n;
 // END ADDED

#pragma scop
 for (i = _PB_N-1; i >= 0; i--) {
  for (j=i+1; j<_PB_N; j++) {

   if (j-1>=0) 
      table[i][j] = max_score(table[i][j], table[i][j-1]);
   if (i+1<_PB_N) 
      table[i][j] = max_score(table[i][j], table[i+1][j]);

   if (j-1>=0 && i+1<_PB_N) {
     /* don't allow adjacent elements to bond */
     if (i<j-1) 
        table[i][j] = max_score(table[i][j], table[i+1][j-1]+match(seq[i], seq[j]));
     else 
        table[i][j] = max_score(table[i][j], table[i+1][j-1]);
   }

   for (k=i+1; k<j; k++) {
      table[i][j] = max_score(table[i][j], table[i][k] + table[k+1][j]);
   }
  }
 }
#pragma endscop

}
// Function which matched the alpha code generated function signature
void nussinov_verify(long N, int* seq, int** t){
      
	nussinov_verify_scoop(N,seq,t);

}
