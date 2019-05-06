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

# Path to source code directory
sourceCodeDir = "src_gen/"+benchmark+"/DTiler/parallel/0";
# Create code generation options and generate code
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, benchmark, 0, 2, "openmp");


#generateWriteC(prog,benchmark,sourceCodeDir);
#generatePCOTCode(prog, benchmark, sourceCodeDir);
generateScheduledCode(prog, benchmark,sourceCodeDir);
generateWrapper(prog, benchmark, sourceCodeDir);
generateMakefile(prog, benchmark, sourceCodeDir);

# print codegen message
print(benchmark + " code generated.");



