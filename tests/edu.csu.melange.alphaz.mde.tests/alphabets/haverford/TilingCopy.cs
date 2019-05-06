# One-Dimensional Jacobi Stencil
# Micah WALTER, YUKI Tomofumi, David WONNACOTT

# Load an alphabets program and store as 'program'
program = ReadAlphabets("./1d_2arrays.ab");
# Define a variable 'system' to store the system name
system = "oneD_copy";
# Specify the output directory
outDir = "./test";

# Set the target mapping as described in the target mapping section
setSpaceTimeMap(program, system, "A", "(t,i -> t,1,i+t)");
setDimensionType(program, system, "A", 1, "O");

# Set the target mapping as described in the target mapping section
setSpaceTimeMap(program, system, "new", "(t,i -> t,0,i+t)");
setDimensionType(program, system, "new", 1, "O");

# Set the target mapping as described in the target mapping section
setSpaceTimeMap(program, system, "Final", "(t,i -> t,1,i+t)");
setDimensionType(program, system, "Final", 1, "O");

# Set the statement ordering
setStatementOrdering(program, system, "new", "A");
setStatementOrdering(program, system, "new", "Final");
setStatementOrdering(program, system, "A", "Final");

# Set the memory map
setMemoryMap(program, system, "A", "A", "(t,i -> i)");
setMemoryMap(program, system, "new", "new",  "(t,i -> i)");
setMemoryMap(program, system, "Final", "Final",  "(t,i -> i)");

# Set tiling
setTiling(program, system, 0);
options = createTiledCGOptionForScheduledC();
setTiledCGOptionOptimize(options, 1);
#setTilingType(program, system, "omp");

# Verify the target mapping if needed (optional)
VerifyTargetMapping(program, system , "MIN" );

# Generate scheduled code according to the target mapping
generateScheduledCode(program, system, options, outDir);

# Generate the makefile
generateMakefile(program, system, outDir);

# Generate the wrapper to call the generated program
generateWrapper(program, system, outDir);
