# TOMCATV Benchmark, Second Take, Fewer Variables (than even FewVars)
# Micah WALTER

# Load an alphabets program and store as 'program'
program = ReadAlphabets("./TilingWithReductionTest.ab");
# Define a variable 'system' to store the system name
system = "TilingWithReduction";
# Specify the output directory
outDir = "./test";
Show(program);

# Set the target mapping as described in the target mapping section
setSpaceTimeMap(program, system, "RX", "(i, j->i,j)");
#setSpaceTimeMap(program, system, "TR", "(i,j->i,j)");
setSpaceTimeMap(program, system, "Final", "(i-> i, N)");

# Set the statement ordering
setStatementOrdering(program, system, "RX", "Final");
#setStatementOrdering(program, system, "TR", "Final");

# Set tiling
setTiling(program, system, "omp");

# Verify the target mapping if needed (optional)
#VerifyTargetMapping(program, system , "MIN" );

toptions = createTiledCGOptionForScheduledC();
setTiledCGOptionOptimize(toptions, 1);

# Generate scheduled code according to the target mapping
generateScheduledCode(program, system, toptions, outDir);

# Generate the makefile
generateMakefile(program, system, outDir);

# Generate the wrapper to call the generated program
generateWrapper(program, system, toptions, outDir);