# PCOT benchmark Guass - seidel 2D
benchmark = "GS2D";

# Read the alphabets system of equations
prog = ReadAlphabets("GS2D.ab");

# Check legality of input program
CheckProgram(prog);



# Give space time map for local and output variables
setSpaceTimeMap(prog, benchmark, "temp", "(t, i, j -> t, t+i, t+i+j)");
setSpaceTimeMap(prog, benchmark, "Aout", "(i, j -> T-1,T-1+i,T-1+i+j)");

# Specify statement ordering 
setStatementOrdering(prog, benchmark, "temp", "Aout");

# Provide Memory Map for memory allocation (this is %2 memory allocation)
setMemoryMap(prog, benchmark, "temp", "temp", "(t, i, j -> t, i, j)","2,0,0");




# Path to source code directory
sourceCodeDir = "./src_gen/"+benchmark+"/PCOT/parallel/0";

# Create code generation options and generate code
setDefaultDTilerConfiguration(prog, benchmark, "openmp");

options = createCGOptionsForPCOT();

generatePCOTCode(prog, benchmark, sourceCodeDir);
generateWrapper(prog, benchmark, options, sourceCodeDir);
generateMakefile(prog, benchmark, sourceCodeDir);

# print codegen message
print(benchmark + " code generated.");

