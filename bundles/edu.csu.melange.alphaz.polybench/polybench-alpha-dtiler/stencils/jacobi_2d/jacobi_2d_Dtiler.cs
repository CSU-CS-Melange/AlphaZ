prog = ReadAlphabets("../../../polybench-alpha-4.0/stencils/jacobi_2d/jacobi_2d.ab");
system = "jacobi_2d";
outDir = "../../../test-out/DTiler/"+system;

CheckProgram(prog);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "temp",   "(t,i,j -> 0, t, 2t+i, 2t+j)");
setSpaceTimeMap(prog, system, "Aout",   "(i,j   -> 1, i, j, 0)");

setOrderingDimensions(prog, system, "0");



# Memory map
setMemorySpace(prog, system, "temp", "temp");
setMemoryMap(prog, system, "temp", "temp", "(t,i,j -> t,i,j)", "2,0");

setMemorySpace(prog, system, "Aout", "Aout");
setMemoryMap(prog, system, "Aout", "Aout", "(i,j -> i,j)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

