# One-Dimensional Jacobi Stencil
# Micah WALTER, YUKI Tomofumi, David WONNACOTT

# Load an alphabets program and store as 'program'
program = ReadAlphabets("1d.ab");
CheckProgram(program);
# Define a variable 'system' to store the system name
system = "OneD";
# Specify the output directory
outDir = "./test";

# Set the target mapping as described in the target mapping section
setSpaceTimeMap(program, system, "Intermediate",  "(t,i -> t,i)");
setDimensionType(program, system, "Intermediate", 0, "S");
setDimensionType(program, system, "Intermediate", 1, "S");

setSpaceTimeMap(program, system, "Final",  "(t,i -> t,i)");
setDimensionType(program, system, "Final", 0, "S");
setDimensionType(program, system, "Final", 1, "S");


# Set the statement ordering
setStatementOrdering(program, system, "Intermediate", "Final");

# Set the memory map
setMemoryMap(program, system, "Final", "(t,i -> i)");
setMemoryMap(program, system, "Intermediate", "Intermediate",  "(t,i -> t,i)", "2,0");

# Verify the target mapping if needed (optional)
#VerifyTargetMapping(program, system , "MIN" );

setTiling(program, system, "omp");

#options
toptions = createTiledCGOptionForScheduledC();
setTiledCGOptionOptimize(toptions, 1);

# Verify the target mapping if needed (optional)
#VerifyTargetMapping(program, system, "MIN");

# Generate scheduled code according to the target mapping
generateScheduledCode(program, system, toptions, outDir);

# Generate the makefile
generateMakefile(program, system, outDir);

# Generate the wrapper to call the generated program
generateWrapper(program, system, toptions, outDir);