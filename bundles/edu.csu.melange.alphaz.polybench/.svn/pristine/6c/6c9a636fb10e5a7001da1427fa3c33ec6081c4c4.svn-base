prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/blas/gemm/gemm_noRed.ab");
system = "gemm";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);


# Schedule
setSpaceTimeMap(prog, system, "temp", "(i,j,k -> i,k,j)");
setSpaceTimeMap(prog, system, "Cout", "(i,j   -> i,Q,j)");


# Memory map
setMemorySpace(prog, system, "Cout", "temp, Cout");
setMemoryMap(prog, system, "temp", "Cout", "(i,j,k->i,j)");
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

