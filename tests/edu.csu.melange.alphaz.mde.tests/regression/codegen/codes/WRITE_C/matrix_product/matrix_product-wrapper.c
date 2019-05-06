// This file is generated from test alphabets program by code generator in alphaz
// To compile this code, use -lm option for math library.

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>
#include <limits.h>
#include <float.h>
#include <time.h>
#include <sys/time.h>
#include <sys/errno.h>
#include <omp.h>


// Common Macros
#define max(x, y)   ((x)>(y) ? (x) : (y))
#define MAX(x, y)	((x)>(y) ? (x) : (y))
#define min(x, y)   ((x)>(y) ? (y) : (x))
#define MIN(x, y)	((x)>(y) ? (y) : (x))
#define CEILD(n,d)  (int)ceil(((double)(n))/((double)(d)))
#define ceild(n,d)  (int)ceil(((double)(n))/((double)(d)))
#define FLOORD(n,d) (int)floor(((double)(n))/((double)(d)))
#define floord(n,d) (int)floor(((double)(n))/((double)(d)))
#define CDIV(x,y)    CEILD((x),(y))
#define div(x,y)    CDIV((x),(y))
#define FDIV(x,y)    FLOORD((x),(y))
#define LB_SHIFT(b,s)  ((int)ceild(b,s) * s)
#define MOD(i,j)   ((i)%(j))
#define mallocCheck(v,s,d) if ((v) == NULL) { printf("Failed to allocate memory for %s : size=%lu\n", "sizeof(d)*(s)", sizeof(d)*(s)); exit(-1); }
#define EPSILON 1.0E-9







//Memory Macros
#define A(i,k) A[i][k]
#define B(k,j) B[k][j]
#define temp_C(i,j,k) temp_C[i][j][k]
#define Cspace(i,j) Cspace[i][j]

#define Cspace_verify(i,j) Cspace_verify[i][j]
#define var_C(i,j) Cspace(i,j)
#define var_C_verify(i,j) Cspace_verify(i,j)

//function prototypes
void matrix_product(long, long, long, float**, float**, float**);
void matrix_product_verify(long, long, long, float**, float**, float**);

//main
int main(int argc, char** argv) {
	//Check number of args
	if (argc <= 3) {
		printf("Number of argument is smaller than expected.\n");
		printf("Expecting P,Q,R\n");
		exit(0);
	}
	
	char *end = 0;
	char *val = 0;
	//Read Parameters
	//Initialisation of P
	errno = 0;
	end = 0;
	val = argv[1];
	long P = strtol(val,&end,10);
	if ((errno == ERANGE && (P == LONG_MAX || P == LONG_MIN)) || (errno != 0 && P == 0)) {
		perror("strtol");
		exit(EXIT_FAILURE);
	}
	if (end == val) {
		fprintf(stderr, "No digits were found for P\n");
		exit(EXIT_FAILURE);
	}
	if (*end != '\0'){
		printf("For parameter P: Converted part: %ld, non-convertible part: %s\n", P, end);
		exit(EXIT_FAILURE);
	}
	
	//Initialisation of Q
	errno = 0;
	end = 0;
	val = argv[2];
	long Q = strtol(val,&end,10);
	if ((errno == ERANGE && (Q == LONG_MAX || Q == LONG_MIN)) || (errno != 0 && Q == 0)) {
		perror("strtol");
		exit(EXIT_FAILURE);
	}
	if (end == val) {
		fprintf(stderr, "No digits were found for Q\n");
		exit(EXIT_FAILURE);
	}
	if (*end != '\0'){
		printf("For parameter Q: Converted part: %ld, non-convertible part: %s\n", Q, end);
		exit(EXIT_FAILURE);
	}
	
	//Initialisation of R
	errno = 0;
	end = 0;
	val = argv[3];
	long R = strtol(val,&end,10);
	if ((errno == ERANGE && (R == LONG_MAX || R == LONG_MIN)) || (errno != 0 && R == 0)) {
		perror("strtol");
		exit(EXIT_FAILURE);
	}
	if (end == val) {
		fprintf(stderr, "No digits were found for R\n");
		exit(EXIT_FAILURE);
	}
	if (*end != '\0'){
		printf("For parameter R: Converted part: %ld, non-convertible part: %s\n", R, end);
		exit(EXIT_FAILURE);
	}
	
	
	///Parameter checking
	if (!((P >= 2 && Q >= 2 && R >= 2))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	
	
	//Memory Allocation
	int mz1, mz2, mz3;
	float* _lin_A = (float*)malloc(sizeof(float)*((P) * (Q)));
	mallocCheck(_lin_A, ((P) * (Q)), float);
	float** A = (float**)malloc(sizeof(float*)*(P));
	mallocCheck(A, (P), float*);
	for (mz1=0;mz1 < P; mz1++) {
		A[mz1] = &_lin_A[(mz1*(Q))];
	}
	float* _lin_B = (float*)malloc(sizeof(float)*((Q) * (R)));
	mallocCheck(_lin_B, ((Q) * (R)), float);
	float** B = (float**)malloc(sizeof(float*)*(Q));
	mallocCheck(B, (Q), float*);
	for (mz1=0;mz1 < Q; mz1++) {
		B[mz1] = &_lin_B[(mz1*(R))];
	}
	float* _lin_Cspace = (float*)malloc(sizeof(float)*((P) * (R)));
	mallocCheck(_lin_Cspace, ((P) * (R)), float);
	float** Cspace = (float**)malloc(sizeof(float*)*(P));
	mallocCheck(Cspace, (P), float*);
	for (mz1=0;mz1 < P; mz1++) {
		Cspace[mz1] = &_lin_Cspace[(mz1*(R))];
	}
	#ifdef VERIFY
		float* _lin_Cspace_verify = (float*)malloc(sizeof(float)*((P) * (R)));
		mallocCheck(_lin_Cspace_verify, ((P) * (R)), float);
		float** Cspace_verify = (float**)malloc(sizeof(float*)*(P));
		mallocCheck(Cspace_verify, (P), float*);
		for (mz1=0;mz1 < P; mz1++) {
			Cspace_verify[mz1] = &_lin_Cspace_verify[(mz1*(R))];
		}
	#endif

	//Initialization of rand
	srand((unsigned)time(NULL));
	 
	//Input Initialization
	{
		#if defined (RANDOM)
			#define S0(i,k) (A(i,k) = rand()) 
		#elif defined (CHECKING) || defined (VERIFY)
			#ifdef NO_PROMPT
				#define S0(i,k) scanf("%f", &A(i,k))
			#else
				#define S0(i,k) printf("A(%ld,%ld)=",(long) i,(long) k); scanf("%f", &A(i,k))
			#endif
		#else
			#define S0(i,k) (A(i,k) = 1)   //Default value
		#endif
		
		
		int c1,c2;
		for(c1=0;c1 <= P-1;c1+=1)
		 {
		 	for(c2=0;c2 <= Q-1;c2+=1)
		 	 {
		 	 	S0((c1),(c2));
		 	 }
		 }
		#undef S0
	}
	{
		#if defined (RANDOM)
			#define S0(k,j) (B(k,j) = rand()) 
		#elif defined (CHECKING) || defined (VERIFY)
			#ifdef NO_PROMPT
				#define S0(k,j) scanf("%f", &B(k,j))
			#else
				#define S0(k,j) printf("B(%ld,%ld)=",(long) k,(long) j); scanf("%f", &B(k,j))
			#endif
		#else
			#define S0(k,j) (B(k,j) = 1)   //Default value
		#endif
		
		
		int c1,c2;
		for(c1=0;c1 <= Q-1;c1+=1)
		 {
		 	for(c2=0;c2 <= R-1;c2+=1)
		 	 {
		 	 	S0((c1),(c2));
		 	 }
		 }
		#undef S0
	}
	
	//Timing
	struct timeval time;
	double elapsed_time;
	
	//Call the main computation
	gettimeofday(&time, NULL);
	elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000);
	
	matrix_product(P, Q, R, A, B, Cspace);

	gettimeofday(&time, NULL);
	elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000) - elapsed_time;

	// timing information
	printf("Execution time : %lf sec.\n", elapsed_time);
	
	#ifdef TIMING
		FILE * fp = fopen( "trace.dat","a+");
		if (fp == NULL) {
				printf("I couldn't open trace.dat for writing.\n");
				exit(EXIT_FAILURE);
		}
		fprintf(fp, "%ld\t%ld\t%ld\t%lf\n",P,Q,R,elapsed_time);
		fclose(fp);
	#endif
	
	//Verification Run
	#ifdef VERIFY
		#ifdef TIMING
			gettimeofday(&time, NULL);
			elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000);
		#endif
    	matrix_product_verify(P, Q, R, A, B, Cspace_verify);
    	#ifdef TIMING
    		gettimeofday(&time, NULL);
			elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000) - elapsed_time;
			
			FILE * fp_verify = fopen( "trace_verify.dat","a+");
			if (fp == NULL) {
					printf("I couldn't open trace_verify.dat for writing.\n");
					exit(EXIT_FAILURE);
			}
			fprintf(fp, "%ld\t%ld\t%ld\t%lf\n",P,Q,R,elapsed_time);
			fclose(fp_verify);
		#endif
	#endif
    	
	#ifdef CHECKING
    	//Print Outputs
		
		{
			#ifdef NO_PROMPT
				#define S0(i,j,k) printf("%0.2f\n",var_C(i,j))
			#else
				#define S0(i,j,k) printf("C(%ld,%ld,%ld)=",(long) i,(long) j,(long) k);printf("%0.2f\n",var_C(i,j))
			#endif
			int c1,c2;
			for(c1=0;c1 <= P-1;c1+=1)
			 {
			 	for(c2=0;c2 <= R-1;c2+=1)
			 	 {
			 	 	S0((c1),(c2),(Q+1));
			 	 }
			 }
			#undef S0
		}
	#elif VERIFY
		//Compare outputs for verification
		{
			//Error Counter
			int _errors_ = 0;
			#define S0(i,j,k) if (fabsf(1.0f - var_C_verify(i,j)/var_C(i,j)) > EPSILON) _errors_++;
			int c1,c2;
			for(c1=0;c1 <= P-1;c1+=1)
			 {
			 	for(c2=0;c2 <= R-1;c2+=1)
			 	 {
			 	 	S0((c1),(c2),(Q+1));
			 	 }
			 }
			#undef S0
			if(_errors_ == 0){
				printf("TEST for C PASSED\n");
			}else{
				printf("TEST for C FAILED. #Errors: %d\n", _errors_);
			}
		}
    #endif
    
	//Memory Free
	free(_lin_A);
	free(A);
	free(_lin_B);
	free(B);
	free(_lin_Cspace);
	free(Cspace);
	#ifdef VERIFY
		free(_lin_Cspace_verify);
		free(Cspace_verify);
	#endif
	
	return EXIT_SUCCESS;
}

//Memory Macros
#undef A
#undef B
#undef temp_C
#undef Cspace


//Common Macro undefs
#undef max
#undef MAX
#undef min
#undef MIN
#undef CEILD
#undef ceild
#undef FLOORD
#undef floord
#undef CDIV
#undef FDIV
#undef LB_SHIFT
#undef MOD
#undef EPSILON
