
#include<stdio.h>
#include<cloog/cloog.h>

struct clast_stmt *cloog_simple_wrapper(char* default_context, char* default_domain, int f, int l,int stop);

struct clast_stmt *root;

void main() {
	CloogState *state;
	CloogOptions * options;

	root= cloog_simple_wrapper(
			"[] -> { [] : }",
			"[] -> { "
				"S0[i, j] -> [i, i + j] : i >= 8 and i <= 15 and j >= 0 and j <= 16; "
				"Merged[c0, c1] -> Merged[c0, c1] : c0 <= 15 and c1 >= c0 and c1 <= 16 + c0 and c0 >= 0; "
				"S1[i, j] -> [i, i + j] : i >= 0 and i <= 7 and j >= 0 and j <= 16 "
			"}",-1,3,-1);

	state = cloog_state_malloc();
	options = cloog_options_malloc(state);
	clast_pprint(stdout, root, 0, options);
	fflush(stdout);
	cloog_options_free(options);
	cloog_state_free(state);

}
