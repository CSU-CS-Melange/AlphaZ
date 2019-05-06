# PCOT benchmark Forward Substitution - serialized version
benchmark = "FS";

# Read the alphabets system of equations
prog = ReadAlphabets("FS.ab");

# Check legality of input program
CheckProgram(prog);



# Give space time map for local and output variables
setSpaceTimeMap(prog, benchmark, "Temp_X", "(i, j -> i, j)");
setSpaceTimeMap(prog, benchmark, "X", "(i -> i, i-1)");

# Specify statement ordering 
setStatementOrdering(prog, benchmark, "Temp_X", "X");

# Provide Memory Map for memory allocation
setMemoryMap(prog, benchmark, "Temp_X", "Temp_X", "(i, j -> i)");

# check for legality of the transformed program
CheckProgram(prog);



# Path to source code directory
sourceCodeDir = "src_gen/"+benchmark+"/PCOT/0";
# Create code generation options and generate code
#options = createTiledCGOptionForScheduledC();
options = createCGOptionsForPCOT();
generatePCOTCode(prog, benchmark, sourceCodeDir);
generateWrapper(prog, benchmark, sourceCodeDir);
generateMakefile(prog, benchmark, sourceCodeDir);

# print codegen message
#print(benchmark + " code generated.");

