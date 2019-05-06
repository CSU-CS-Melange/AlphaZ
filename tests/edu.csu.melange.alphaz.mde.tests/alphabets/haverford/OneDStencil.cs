# Load an alphabets program and store as 'program'
program = ReadAlphabets("OneDStencil.ab");
# Define a variable 'system' to store the system name
system = "OneDStencil";
# Specify the output directory
outDir = "./test";

# Set the target mapping as described in the target mapping section[[Target Mapping]]
setSpaceTimeMap(program, system, "Intermediate",  "(i,t -> t,i)");
#setDimensionType(program, system, "Intermediate", 0, "S");
#setDimensionType(program, system, "Intermediate", 1, "S");

setSpaceTimeMap(program, system, "Final",  "(i,t -> t,i)");
#setDimensionType(program, system, "Final", 0, "S");
#setDimensionType(program, system, "Final", 1, "S");

# Set the statement ordering
setStatementOrdering(program, system, "Intermediate", "Final");

# Set the memory map
setMemoryMap(program, system, "Final", "(i,t -> i+1000)");
setMemoryMap(program, system, "Intermediate", "Intermediate",  "(i,t -> t,i)", "2,0");

# Tiling
#setTiling(program, system, 1, 0);
#setTilingType(program, system, "omp"); 

# Verify the target mapping if needed (optional)
VerifyTargetMapping(program, system , "MIN" );

# Generate scheduled code according to the target mapping
generateScheduledCode(program, system, outDir);

# Generate the makefile
generateMakefile(program, system, outDir);

# Generate the wrapper to call the generated program
generateWrapper(program, system, outDir);