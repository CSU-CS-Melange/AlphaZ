# Parse and check the program 
prog = ReadAlphabets("../../../Jacobi1D/Jacobi1D_original.ab");
system = "Jacobi1D";
outDir = "../test-out/Ori/";
CheckProgram(prog);

# generate writeC
#generateWriteC(prog, system, outDir);

# Schedule
setSpaceTimeMap(prog, system, "temp", "(i, t-> t, t+i)");
setSpaceTimeMap(prog, system, "B", "(i-> T+1, i + T + 1)");

# Memory
setMemorySpace(prog, system, "temp", "temp");
setMemoryMap(prog,system,"temp","temp","(i, t -> i, t)", "0, 2");

options = createTiledCGOptionForScheduledC();
#tile the whole program
setDefaultDTilerConfiguration(prog, system, "openmp");

# Code gen
generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
