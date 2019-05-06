# Parse and check the program 
prog = ReadAlphabets("../../../Jacobi2D/Jacobi2D_original.ab");
system = "Jacobi2D";
outDir = "../test-out/J2DOri";
CheckProgram(prog);

# generate writeC
#generateWriteC(prog, system, outDir);

# Schedule
setSpaceTimeMap(prog, system, "temp", "(i, j, t-> t, t+i, t+j)");
setSpaceTimeMap(prog, system, "B", "(i,j-> T+1, i + T + 1, j+ T + 1)");

# Memory
setMemorySpace(prog, system, "temp", "temp");
setMemoryMap(prog, system,"temp","temp","(i, j, t -> i,j,t)", "0,0,2");

options = createTiledCGOptionForScheduledC();
#tile the whole program
setDefaultDTilerConfiguration(prog, system, "openmp");

# Code gen
generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
