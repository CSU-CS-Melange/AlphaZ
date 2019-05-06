// This file is generated from test alphabets program by code generator in alphaz
// To compile this code, use -lm option for math library.

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <limits.h>
#include <float.h>
#include <time.h>
#include <sys/time.h>
#include <sys/errno.h>


// Common Macros
#define MAX(x,y)    ((x)>(y) ? (x) : (y))
#define max(x,y)    ((x)>(y) ? (x) : (y))
#define MIN(x,y)    ((x)>(y) ? (y) : (x))
#define min(x,y)    ((x)>(y) ? (y) : (x))
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
#define A_bl(iBl,iLoc) A_bl[iBl][iLoc]
#define B_bl(iBl,iLoc) B_bl[iBl][iLoc]
#define TempSpace(iBl,tBl) TempSpace[iBl][tBl]

#define B_bl_verify(iBl,iLoc) B_bl_verify[iBl][iLoc]
#define var_B_bl(iBl,iLoc) B_bl(iBl,iLoc)
#define var_B_bl_verify(iBl,iLoc) B_bl_verify(iBl,iLoc)

//function prototypes
void Jacobi1DTimeSkewed(long, long, long, long, long, double**, double**);
void Jacobi1DTimeSkewed_verify(long, long, long, long, long, double**, double**);

//main
int main(int argc, char** argv) {
	//Check number of args
	if (argc <= 5) {
		printf("Number of argument is smaller than expected.\n");
		printf("Expecting Nb,Tb,Nl,Tl,b\n");
		exit(0);
	}
	
	char *end = 0;
	char *val = 0;
	//Read Parameters
	//Initialisation of Nb
	errno = 0;
	end = 0;
	val = argv[1];
	long Nb = strtol(val,&end,10);
	if ((errno == ERANGE && (Nb == LONG_MAX || Nb == LONG_MIN)) || (errno != 0 && Nb == 0)) {
		perror("strtol");
		exit(EXIT_FAILURE);
	}
	if (end == val) {
		fprintf(stderr, "No digits were found for Nb\n");
		exit(EXIT_FAILURE);
	}
	if (*end != '\0'){
		printf("For parameter Nb: Converted part: %ld, non-convertible part: %s\n", Nb, end);
		exit(EXIT_FAILURE);
	}
	
	//Initialisation of Tb
	errno = 0;
	end = 0;
	val = argv[2];
	long Tb = strtol(val,&end,10);
	if ((errno == ERANGE && (Tb == LONG_MAX || Tb == LONG_MIN)) || (errno != 0 && Tb == 0)) {
		perror("strtol");
		exit(EXIT_FAILURE);
	}
	if (end == val) {
		fprintf(stderr, "No digits were found for Tb\n");
		exit(EXIT_FAILURE);
	}
	if (*end != '\0'){
		printf("For parameter Tb: Converted part: %ld, non-convertible part: %s\n", Tb, end);
		exit(EXIT_FAILURE);
	}
	
	//Initialisation of Nl
	errno = 0;
	end = 0;
	val = argv[3];
	long Nl = strtol(val,&end,10);
	if ((errno == ERANGE && (Nl == LONG_MAX || Nl == LONG_MIN)) || (errno != 0 && Nl == 0)) {
		perror("strtol");
		exit(EXIT_FAILURE);
	}
	if (end == val) {
		fprintf(stderr, "No digits were found for Nl\n");
		exit(EXIT_FAILURE);
	}
	if (*end != '\0'){
		printf("For parameter Nl: Converted part: %ld, non-convertible part: %s\n", Nl, end);
		exit(EXIT_FAILURE);
	}
	
	//Initialisation of Tl
	errno = 0;
	end = 0;
	val = argv[4];
	long Tl = strtol(val,&end,10);
	if ((errno == ERANGE && (Tl == LONG_MAX || Tl == LONG_MIN)) || (errno != 0 && Tl == 0)) {
		perror("strtol");
		exit(EXIT_FAILURE);
	}
	if (end == val) {
		fprintf(stderr, "No digits were found for Tl\n");
		exit(EXIT_FAILURE);
	}
	if (*end != '\0'){
		printf("For parameter Tl: Converted part: %ld, non-convertible part: %s\n", Tl, end);
		exit(EXIT_FAILURE);
	}
	
	//Initialisation of b
	errno = 0;
	end = 0;
	val = argv[5];
	long b = strtol(val,&end,10);
	if ((errno == ERANGE && (b == LONG_MAX || b == LONG_MIN)) || (errno != 0 && b == 0)) {
		perror("strtol");
		exit(EXIT_FAILURE);
	}
	if (end == val) {
		fprintf(stderr, "No digits were found for b\n");
		exit(EXIT_FAILURE);
	}
	if (*end != '\0'){
		printf("For parameter b: Converted part: %ld, non-convertible part: %s\n", b, end);
		exit(EXIT_FAILURE);
	}
	
	
	///Parameter checking
	if (!((Tl == 0 && Nl == 0 && Nb >= 1 && b >= 3 && Tb >= 0))) {
		printf("The value of parameters are not valid.\n");
		exit(-1);
	}
	
	
	//Memory Allocation
	int mz1, mz2;
	double* _lin_A_bl = (double*)malloc(sizeof(double)*((Nb) * (b)));
	mallocCheck(_lin_A_bl, ((Nb) * (b)), double);
	double** A_bl = (double**)malloc(sizeof(double*)*(Nb));
	mallocCheck(A_bl, (Nb), double*);
	for (mz1=0;mz1 < Nb; mz1++) {
		A_bl[mz1] = &_lin_A_bl[(mz1*(b))];
	}
	double* _lin_B_bl = (double*)malloc(sizeof(double)*((Nb) * (b)));
	mallocCheck(_lin_B_bl, ((Nb) * (b)), double);
	double** B_bl = (double**)malloc(sizeof(double*)*(Nb));
	mallocCheck(B_bl, (Nb), double*);
	for (mz1=0;mz1 < Nb; mz1++) {
		B_bl[mz1] = &_lin_B_bl[(mz1*(b))];
	}
	#ifdef VERIFY
		double* _lin_B_bl_verify = (double*)malloc(sizeof(double)*((Nb) * (b)));
		mallocCheck(_lin_B_bl_verify, ((Nb) * (b)), double);
		double** B_bl = (double**)malloc(sizeof(double*)*(Nb));
		mallocCheck(B_bl, (Nb), double*);
		for (mz1=0;mz1 < Nb; mz1++) {
			B_bl[mz1] = &_lin_B_bl_verify[(mz1*(b))];
		}
	#endif

	//Initialization of rand
	srand((unsigned)time(NULL));
	 
	//Input Initialization
	{
		#if defined (RANDOM)
			#define S0(iBl,iLoc) (A_bl(iBl,iLoc) = rand()) 
		#elif defined (CHECKING) || defined (VERIFY)
			#ifdef NO_PROMPT
				#define S0(iBl,iLoc) scanf("%lf", &A_bl(iBl,iLoc))
			#else
				#define S0(iBl,iLoc) printf("A_bl(%ld,%ld)=",(long) iBl,(long) iLoc); scanf("%lf", &A_bl(iBl,iLoc))
			#endif
		#else
			#define S0(iBl,iLoc) (A_bl(iBl,iLoc) = 1)   //Default value
		#endif
		
		
		int c1,c2;
		for(c1=0;c1 <= Nb-1;c1+=1)
		 {
		 	for(c2=0;c2 <= b-1;c2+=1)
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
	
	Jacobi1DTimeSkewed(Nb, Tb, Nl, Tl, b, A_bl, B_bl);

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
		fprintf(fp, "%ld\t%ld\t%ld\t%ld\t%ld\t%lf\n",Nb,Tb,Nl,Tl,b,elapsed_time);
		fclose(fp);
	#endif
	
	//Verification Run
	#ifdef VERIFY
		#ifdef TIMING
			gettimeofday(&time, NULL);
			elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000);
		#endif
    	Jacobi1DTimeSkewed_verify(Nb, Tb, Nl, Tl, b, A_bl, B_bl_verify);
    	#ifdef TIMING
    		gettimeofday(&time, NULL);
			elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000) - elapsed_time;
			
			FILE * fp_verify = fopen( "trace_verify.dat","a+");
			if (fp == NULL) {
					printf("I couldn't open trace_verify.dat for writing.\n");
					exit(EXIT_FAILURE);
			}
			fprintf(fp, "%ld\t%ld\t%ld\t%ld\t%ld\t%lf\n",Nb,Tb,Nl,Tl,b,elapsed_time);
			fclose(fp_verify);
		#endif
	#endif
    	
	#ifdef CHECKING
    	//Print Outputs
		{
			#ifdef NO_PROMPT
				#define S0(iBl,iLoc) printf("%0.2lf\n",var_B_bl(iBl,iLoc))
			#else
				#define S0(iBl,iLoc) printf("B_bl(%ld,%ld)=",(long) iBl,(long) iLoc);printf("%0.2lf\n",var_B_bl(iBl,iLoc))
			#endif
			int c1,c2;
			for(c1=0;c1 <= Nb-1;c1+=1)
			 {
			 	for(c2=0;c2 <= b-1;c2+=1)
			 	 {
			 	 	S0((c1),(c2));
			 	 }
			 }
			#undef S0
		}
	#elif VERIFY
		//Compare outputs for verification
		{
			//Error Counter
			int _errors_ = 0;
			#define S0(iBl,iLoc) if (abs(var_B_bl(iBl,iLoc) - var_B_bl_verify(iBl,iLoc)) > EPSILON) _errors_++;
			int c1,c2;
			for(c1=0;c1 <= Nb-1;c1+=1)
			 {
			 	for(c2=0;c2 <= b-1;c2+=1)
			 	 {
			 	 	S0((c1),(c2));
			 	 }
			 }
			#undef S0
		}
    #endif
    
	//Memory Free
	free(_lin_A_bl);
	free(A_bl);
	free(_lin_B_bl);
	free(B_bl);
	#ifdef VERIFY
		free(_lin_B_bl_verify);
		free(B_bl);
	#endif
	
	return EXIT_SUCCESS;
}

//Memory Macros
#undef A_bl
#undef B_bl
#undef TempSpace


//Common Macro undefs
#undef MAX
#undef max
#undef MIN
#undef min
#undef CEILD
#undef ceild
#undef FLOORD
#undef floord
#undef CDIV
#undef FDIV
#undef LB_SHIFT
#undef MOD
#undef EPSILON
