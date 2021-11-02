prog = ReadAlphabets("../../../polybench-alpha-4.0/stencils/jacobi_1d/jacobi_1d.ab");
system = "jacobi_1d";
outDir = "../../../test-out/DTiler/"+system;

CheckProgram(prog);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "temp",   "(t,i -> 0, t, 2t+i)");
setSpaceTimeMap(prog, system, "Aout",   "(i   -> 1, i, 0)");

setOrderingDimensions(prog, system, "0");



# Memory map
setMemorySpace(prog, system, "temp", "temp");
setMemoryMap(prog, system, "temp", "temp", "(t,i -> t,i)", "2,0");

setMemorySpace(prog, system, "Aout", "Aout");
setMemoryMap(prog, system, "Aout", "Aout", "(i -> i)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

