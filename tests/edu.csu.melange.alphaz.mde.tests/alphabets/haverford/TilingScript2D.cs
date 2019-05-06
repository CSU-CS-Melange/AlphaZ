# One-Dimensional Jacobi Stencil
# Micah WALTER, YUKI Tomofumi, David WONNACOTT

# Load an alphabets program and store as 'program'
program = ReadAlphabets("./2d_no_edges.ab");
# Define a variable 'system' to store the system name
system = "twoD";
# Specify the output directory
outDir = "./test";

# Set the target mapping as described in the target mapping section
setSpaceTimeMap(program, system, "Intermediate",  "(t,i,j -> t,t+i,t+j)");
setDimensionType(program, system, "Intermediate", 0, "S");
setDimensionType(program, system, "Intermediate", 1, "S");

# Set the target mapping as described in the target mapping section
setSpaceTimeMap(program, system, "Final",  "(t,i,j -> t,t+i,t+j)");
setDimensionType(program, system, "Final", 0, "S");
setDimensionType(program, system, "Final", 1, "S");

# Set the statement ordering
setStatementOrdering(program, system, "Intermediate", "Final");

# Set the memory map
setMemoryMap(program, system, "Intermediate", "Intermediate",  "(t,i,j -> t,i,j)", "2,0,0");
setMemoryMap(program, system, "Final", "Final",  "(t,i,j -> i,j)");

# Set tiling
setTiling(program, system, 0);
#setTilingType(program, system, "omp");

#options
toptions = createTiledCGOptionForScheduledC();
#setCGOptionFlattenArrays(toptions, 1);
#setTiledCGOptionOptimize(toptions, 0);

# Verify the target mapping if needed (optional)
VerifyTargetMapping(program, system , "MIN" );

# Generate scheduled code according to the target mapping
generateScheduledCode(program, system, toptions, outDir);

# Generate the makefile
generateMakefile(program, system, outDir);

# Generate the wrapper to call the generated program
generateWrapper(program, system, toptions, outDir);