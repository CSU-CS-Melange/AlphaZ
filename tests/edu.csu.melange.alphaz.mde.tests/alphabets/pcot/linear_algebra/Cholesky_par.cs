# PCOT benchmark Cholesky - serialized version
benchmark = "cholesky";

# Read the alphabets system of equations
prog = ReadAlphabets("cholesky.ab");

CheckProgram(prog);
#AShow(prog);

# Give space time map for local and output variables
setSpaceTimeMap(prog, benchmark, "Lacc", "(i, j, k -> i, j, k)");
setSpaceTimeMap(prog, benchmark, "L", "(i, j -> i, j, j)");

# Specify statement ordering 

# Provide Memory Map for memory allocation
setMemoryMap(prog, benchmark, "Lacc", "L", "(i,j,k->i,j)");
#setMemoryMap(prog, benchmark, "L", "L", "(i,j->i,j)");


# Create code generation options and generate code
options = createCGOptionsForPCOT();
#options = addRecursionDepthForPCOT(options);
setDefaultDTilerConfiguration(prog, benchmark, 0, 2, "openmp");

# Path to source code directory
sourceCodeDir = "src_gen/"+benchmark+"/PCOT/parallel/0";


#generateWriteC(prog,benchmark,sourceCodeDir);
#generatePCOTCode(prog, benchmark, sourceCodeDir);
generatePCOTCode(prog, benchmark, options, sourceCodeDir);
generateWrapper(prog, benchmark, options, sourceCodeDir);
generateMakefile(prog, benchmark, sourceCodeDir);

# print codegen message
print(benchmark + " code generated.");



