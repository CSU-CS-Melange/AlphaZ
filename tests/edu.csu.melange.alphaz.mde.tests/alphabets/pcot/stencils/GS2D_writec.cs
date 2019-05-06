# PCOT benchmark Guass - seidel 2D
benchmark = "GS2D";

# Read the alphabets system of equations
prog = ReadAlphabets("GS2D.ab");

# Check legality of input program
CheckProgram(prog);

# Path to source code directory
sourceCodeDir = "./src_gen/"+benchmark+"/WriteC";

generateWriteC(prog, benchmark, sourceCodeDir);
generateWrapper(prog, benchmark, sourceCodeDir);
generateMakefile(prog, benchmark, sourceCodeDir);

# print codegen message
print(benchmark + " code generated.");

