prog = ReadAlphabets("../../../polybench-alpha-4.0/stencils/heat_3d/heat_3d.ab");
system = "heat_3d";
outDir = "../../../test-out/DTiler/"+system;

CheckProgram(prog);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "temp",   "(t,i,j,k -> 0, t, 2t+i, 2t+j, 2t+k)");
setSpaceTimeMap(prog, system, "Aout",   "(i,j,k   -> 1, i, j, k, 0)");

setOrderingDimensions(prog, system, "0");



# Memory map
setMemorySpace(prog, system, "temp", "temp");
setMemoryMap(prog, system, "temp", "temp", "(t,i,j,k -> t,i,j,k)", "2,0,0,0");

setMemorySpace(prog, system, "Aout", "Aout");
setMemoryMap(prog, system, "Aout", "Aout", "(i,j,k -> i,j,k)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

