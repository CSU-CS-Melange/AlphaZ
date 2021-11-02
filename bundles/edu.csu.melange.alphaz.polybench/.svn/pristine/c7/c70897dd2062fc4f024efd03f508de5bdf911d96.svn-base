prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/blas/gemm/gemm.ab");
system = "gemm";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0,0,1)", "(i,j,k-> i,j,k)");
Simplify(prog, system);

AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serCout", "(i,j,k -> i,k,j)");
setSpaceTimeMap(prog, system, "Cout", "(i,j   -> i,Q,j)");


# Memory map
setMemorySpace(prog, system, "Cout", "_serCout, Cout");
setMemoryMap(prog, system, "_serCout", "Cout", "(i,j,k->i,j)");
setMemoryMap(prog, system, "Cout", "Cout", "(i,j->i,j)");


options = createTiledCGOptionForScheduledC();

#tile the whole program
#setDefaultDTilerConfiguration(prog, system, "sequential");
#tile only a sub band
setDefaultDTilerConfiguration(prog, system, "sequential");



# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

