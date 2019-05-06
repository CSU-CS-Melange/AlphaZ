# Two-Dimensional Jacobi Stencil
# Micah WALTER, YUKI Tomofumi, David WONNACOTT

# Load an alphabets program and store as 'program'
program = ReadAlphabets("./tomcatv_obvious.ab");
# Define a variable 'system' to store the system name
system = "TOMCATV";
# Specify the output directory
outDir = "./"+system;

CheckProgram(program);

# Set the target mapping as described in the target mapping section
setSpaceTimeMap(program, system, "XX", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "XX", 0, "S");
setDimensionType(program, system, "XX", 1, "S");
setDimensionType(program, system, "XX", 2, "S");

setSpaceTimeMap(program, system, "YX", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "YX", 0, "S");
setDimensionType(program, system, "YX", 1, "S");
setDimensionType(program, system, "YX", 2, "S");

setSpaceTimeMap(program, system, "XY", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "XY", 0, "S");
setDimensionType(program, system, "XY", 1, "S");
setDimensionType(program, system, "XY", 2, "S");

setSpaceTimeMap(program, system, "YY", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "YY", 0, "S");
setDimensionType(program, system, "YY", 1, "S");
setDimensionType(program, system, "YY", 2, "S");

setSpaceTimeMap(program, system, "A", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "A", 0, "S");
setDimensionType(program, system, "A", 1, "S");
setDimensionType(program, system, "A", 2, "S");

setSpaceTimeMap(program, system, "B", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "B", 0, "S");
setDimensionType(program, system, "B", 1, "S");
setDimensionType(program, system, "B", 2, "S");

setSpaceTimeMap(program, system, "C", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "C", 0, "S");
setDimensionType(program, system, "C", 1, "S");
setDimensionType(program, system, "C", 2, "S");

setSpaceTimeMap(program, system, "D", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "D", 0, "S");
setDimensionType(program, system, "D", 1, "S");
setDimensionType(program, system, "D", 2, "S");

setSpaceTimeMap(program, system, "AA", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "AA", 0, "S");
setDimensionType(program, system, "AA", 1, "S");
setDimensionType(program, system, "AA", 2, "S");

setSpaceTimeMap(program, system, "DD", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "DD", 0, "S");
setDimensionType(program, system, "DD", 1, "S");
setDimensionType(program, system, "DD", 2, "S");

setSpaceTimeMap(program, system, "PXX", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "PXX", 0, "S");
setDimensionType(program, system, "PXX", 1, "S");
setDimensionType(program, system, "PXX", 2, "S");

setSpaceTimeMap(program, system, "QXX", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "QXX", 0, "S");
setDimensionType(program, system, "QXX", 1, "S");
setDimensionType(program, system, "QXX", 2, "S");

setSpaceTimeMap(program, system, "PYY", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "PYY", 0, "S");
setDimensionType(program, system, "PYY", 1, "S");
setDimensionType(program, system, "PYY", 2, "S");

setSpaceTimeMap(program, system, "QYY", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "QYY", 0, "S");
setDimensionType(program, system, "QYY", 1, "S");
setDimensionType(program, system, "QYY", 2, "S");

setSpaceTimeMap(program, system, "PXY", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "PXY", 0, "S");
setDimensionType(program, system, "PXY", 1, "S");
setDimensionType(program, system, "PXY", 2, "S");

setSpaceTimeMap(program, system, "QXY", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "QXY", 0, "S");
setDimensionType(program, system, "QXY", 1, "S");
setDimensionType(program, system, "QXY", 2, "S");

setSpaceTimeMap(program, system, "RX0", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "RX0", 0, "S");
setDimensionType(program, system, "RX0", 1, "S");
setDimensionType(program, system, "RX0", 2, "S");

setSpaceTimeMap(program, system, "RY0", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "RY0", 0, "S");
setDimensionType(program, system, "RY0", 1, "S");
setDimensionType(program, system, "RY0", 2, "S");

setSpaceTimeMap(program, system, "R", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "R", 0, "S");
setDimensionType(program, system, "R", 1, "S");
setDimensionType(program, system, "R", 2, "S");

setSpaceTimeMap(program, system, "D", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "D", 0, "S");
setDimensionType(program, system, "D", 1, "S");
setDimensionType(program, system, "D", 2, "S");

setSpaceTimeMap(program, system, "RX1", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "RX1", 0, "S");
setDimensionType(program, system, "RX1", 1, "S");
setDimensionType(program, system, "RX1", 2, "S");

setSpaceTimeMap(program, system, "RY1", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "RY1", 0, "S");
setDimensionType(program, system, "RY1", 1, "S");
setDimensionType(program, system, "RY1", 2, "S");

setSpaceTimeMap(program, system, "RX2", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "RX2", 0, "S");
setDimensionType(program, system, "RX2", 1, "S");
setDimensionType(program, system, "RX2", 2, "S");

setSpaceTimeMap(program, system, "RY2", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "RY2", 0, "S");
setDimensionType(program, system, "RY2", 1, "S");
setDimensionType(program, system, "RY2", 2, "S");

setSpaceTimeMap(program, system, "X", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "X", 0, "S");
setDimensionType(program, system, "X", 1, "S");
setDimensionType(program, system, "X", 2, "S");

setSpaceTimeMap(program, system, "Y", "(t,i,j -> t,i,j)");
setDimensionType(program, system, "Y", 0, "S");
setDimensionType(program, system, "Y", 1, "S");
setDimensionType(program, system, "Y", 2, "S");

setSpaceTimeMap(program, system, "RXM", "(t -> t,N,N)");
setDimensionType(program, system, "RXM", 0, "S");

setSpaceTimeMap(program, system, "RYM", "(t -> t,N,N)");
setDimensionType(program, system, "RYM", 0, "S");

# Set the statement ordering
#setStatementOrdering(program, system, "X, Y, XX, YX, XY, YY, A, B, C, AA, DD, PXX, QXX, PYY, QYY, PXY, QXY, RX0, RY0, R, D, RX1, RY1, RX2, RY2, RXM, RYM");

# Set the memory map
setMemoryMap(program, system, "XX",  "XX",  "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "YX",  "YX",  "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "XY",  "XY",  "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "YY",  "YY",  "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "A",   "A",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "B",   "B",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "C",   "C",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "AA",  "AA",  "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "DD",  "DD",  "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "PXX", "PXX", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "QXX", "QXX", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "PYY", "PYY", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "QYY", "QYY", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "PXY", "PXY", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "QXY", "QXY", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RX0", "RX0", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RY0", "RY0", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "R",   "R",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "D",   "D",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RX1", "RX1", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RY1", "RY1", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RX2", "RX2", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RY2", "RY2", "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "X",   "X",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "Y",   "Y",   "(t,i,j -> t,i,j)", "(2,0,0)");
setMemoryMap(program, system, "RXM", "RXM", "(t     -> t,N,N)"           );
setMemoryMap(program, system, "RYM", "RXM", "(t     -> t,N,N)"           );


# Verify the target mapping if needed (optional)
VerifyTargetMapping(program, system , "MIN" );

# Generate scheduled code according to the target mapping
#generateScheduledCode(program, system, outDir);

# Generate the makefile
#generateMakefile(program, system, outDir);

# Generate the wrapper to call the generated program
#generateWrapper(program, system, outDir);
