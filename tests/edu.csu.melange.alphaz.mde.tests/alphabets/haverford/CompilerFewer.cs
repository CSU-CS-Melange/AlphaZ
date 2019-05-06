# TOMCATV Benchmark, Second Take
# Micah WALTER

# Load an alphabets program and store as 'program'
program = ReadAlphabets("tomcatv_fewer.ab");
CheckProgram(program);
# Define a variable 'system' to store the system name
system = "TOMCATV";
# Specify the output directory
outDir = "./test";

# Set the target mapping as described in the target mapping section
setSpaceTimeMap (program, system, "D", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "D", 0, "S");
setDimensionType(program, system, "D", 1, "S");
setDimensionType(program, system, "D", 2, "S");

setSpaceTimeMap (program, system, "RX", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "RX", 0, "S");
setDimensionType(program, system, "RX", 1, "S");
setDimensionType(program, system, "RX", 2, "S");

setSpaceTimeMap (program, system, "RY", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "RY", 0, "S");
setDimensionType(program, system, "RY", 1, "S");
setDimensionType(program, system, "RY", 2, "S");

setSpaceTimeMap (program, system, "X", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "X", 0, "S");
setDimensionType(program, system, "X", 1, "S");
setDimensionType(program, system, "X", 2, "S");

setSpaceTimeMap (program, system, "Y", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "Y", 0, "S");
setDimensionType(program, system, "Y", 1, "S");
setDimensionType(program, system, "Y", 2, "S");

setSpaceTimeMap (program, system, "RXM", "(t -> t,N,N)");
setDimensionType(program, system, "RXM", 0, "S");
setDimensionType(program, system, "RXM", 1, "S");
setDimensionType(program, system, "RXM", 2, "S");

setSpaceTimeMap (program, system, "RYM", "(t -> t,N,N)");
setDimensionType(program, system, "RYM", 0, "S");
setDimensionType(program, system, "RYM", 1, "S");
setDimensionType(program, system, "RYM", 2, "S");

# Set the statement ordering
setStatementOrdering(program, system, "D", "RX");
setStatementOrdering(program, system, "D", "RY");
setStatementOrdering(program, system, "RX", "X");
setStatementOrdering(program, system, "RY", "Y");

# Set the memory map
setMemoryMap(program, system, "D",   "D",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RX",  "RX",  "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RY",  "RY",  "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "X",   "X",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "Y",   "Y",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RXM", "RXM", "(t     -> t,N,N)"           );
setMemoryMap(program, system, "RYM", "RXM", "(t     -> t,N,N)"           );

AShow(program);

# Verify the target mapping if needed (optional)
VerifyTargetMapping(program, system , "MIN" );

# Generate scheduled code according to the target mapping
generateScheduledCode(program, system, outDir);

# Generate the makefile
generateMakefile(program, system, outDir);

# Generate the wrapper to call the generated program
generateWrapper(program, system, outDir);
