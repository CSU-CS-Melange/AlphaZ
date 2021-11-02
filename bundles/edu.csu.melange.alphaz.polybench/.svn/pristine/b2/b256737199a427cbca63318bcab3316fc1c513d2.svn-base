prog = ReadAlphabets("../../../polybench-alpha-4.0/stencils/seidel_2d/seidel_2d.ab");
system = "seidel_2d";
outDir = "../../../test-out/DTiler/"+system;

CheckProgram(prog);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "temp",   "(t,i,j -> 0, t, t+i, 2t+i+j)");
setSpaceTimeMap(prog, system, "Aout",   "(i,j   -> 1, i, j, 0)");

setOrderingDimensions(prog, system, "0");



# Memory map
setMemorySpace(prog, system, "temp", "temp");
setMemoryMap(prog, system, "temp", "temp", "(t,i,j -> t,i,j)");

setMemorySpace(prog, system, "Aout", "Aout");
setMemoryMap(prog, system, "Aout", "Aout", "(i,j -> i,j)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

