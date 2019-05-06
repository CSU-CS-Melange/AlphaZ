# TOMCATV Benchmark, Second Take, Fewer Variables (than even FewVars)
# Micah WALTER

# Load an alphabets program and store as 'program'
program = ReadAlphabets("./tomcatv_fewer.ab");
# Define a variable 'system' to store the system name
system = "TOMCATV";
# Specify the output directory
outDir = "./test";
Show(program);

# Set the target mapping as described in the target mapping section
setSpaceTimeMap (program, system, "D", "(t,i,j -> t,i,j)");
setSpaceTimeMap (program, system, "RX", "(t,i,j -> t,i,j)");
setSpaceTimeMap (program, system, "RY", "(t,i,j -> t,i,j)");
setSpaceTimeMap (program, system, "X", "(t,i,j -> t,i,j)");
setSpaceTimeMap (program, system, "Y", "(t,i,j -> t,i,j)");
setSpaceTimeMap (program, system, "RXM", "(t -> t,N,N)");
setSpaceTimeMap (program, system, "RYM", "(t -> t,N,N)");

# Set the statement ordering
setStatementOrdering(program, system, "D", "RX");
setStatementOrdering(program, system, "D", "RY");
setStatementOrdering(program, system, "D", "X");
setStatementOrdering(program, system, "D", "Y");
setStatementOrdering(program, system, "D", "RXM");
setStatementOrdering(program, system, "D", "RYM");

setStatementOrdering(program, system, "RX", "RY");
setStatementOrdering(program, system, "RX", "X");
setStatementOrdering(program, system, "RX", "Y");
setStatementOrdering(program, system, "RX", "RXM");
setStatementOrdering(program, system, "RX", "RYM");

setStatementOrdering(program, system, "RY", "X");
setStatementOrdering(program, system, "RY", "Y");
setStatementOrdering(program, system, "RY", "RXM");
setStatementOrdering(program, system, "RY", "RYM");

setStatementOrdering(program, system, "X", "Y");
setStatementOrdering(program, system, "X", "RXM");
setStatementOrdering(program, system, "X", "RYM");

setStatementOrdering(program, system, "Y", "RXM");
setStatementOrdering(program, system, "Y", "RYM");

setStatementOrdering(program, system, "RXM", "RYM");

# Set the memory map
setMemoryMap(program, system, "D",   "D",   "(t,i,j -> t,i,j)", "1,0,0");
setMemoryMap(program, system, "RX",  "RX",  "(t,i,j -> t,i,j)", "1,0,0");
setMemoryMap(program, system, "RY",  "RY",  "(t,i,j -> t,i,j)", "1,0,0");
setMemoryMap(program, system, "X",   "X",   "(t,i,j -> t,i,j)", "1,0,0");
setMemoryMap(program, system, "Y",   "Y",   "(t,i,j -> t,i,j)", "1,0,0");
setMemoryMap(program, system, "RXM", "RXM", "(t     -> t,N,N)"         );
setMemoryMap(program, system, "RYM", "RYM", "(t     -> t,N,N)"         );

# Set tiling
setTiling(program, system, "omp");

# Verify the target mapping if needed (optional)
#VerifyTargetMapping(program, system , "MIN" );

# Generate scheduled code according to the target mapping
generateScheduledCode(program, system, outDir);

# Generate the makefile
generateMakefile(program, system, outDir);

# Generate the wrapper to call the generated program
generateWrapper(program, system, outDir);