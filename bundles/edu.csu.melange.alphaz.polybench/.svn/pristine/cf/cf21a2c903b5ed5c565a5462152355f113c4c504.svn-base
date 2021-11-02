prog = ReadAlphabets("../../../polybench-alpha-4.0/stencils/fdtd_2d/fdtd_2d.ab");
system = "fdtd_2d";
outDir = "../../../test-out/DTiler/"+system;

CheckProgram(prog);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "Ex",   "(t,x,y  -> 0, t, 1, t+x, t+y)");
setSpaceTimeMap(prog, system, "Ey",   "(t,x,y  -> 0, t, 0, t+x, t+y)");
setSpaceTimeMap(prog, system, "Hz",   "(t,x,y  -> 0, t, 2, t+x, t+y)");

setSpaceTimeMap(prog, system, "Ex_out", "(x,y  -> 1, 0, 0, x, y)");
setSpaceTimeMap(prog, system, "Ey_out", "(x,y  -> 1, 0, 1, x, y)");
setSpaceTimeMap(prog, system, "Hz_out", "(x,y  -> 1, 0, 2, x, y)");

setOrderingDimensions(prog, system, "0,2");


# Memory map
setMemorySpace(prog, system, "Ex", "Ex, Ex_out");
setMemoryMap(prog, system, "Ex", "Ex",     "(t,x,y -> x,y)");
setMemoryMap(prog, system, "Ex_out", "Ex", "(x,y   -> x,y)");

setMemorySpace(prog, system, "Ey", "Ey, Ey_out");
setMemoryMap(prog, system, "Ey", "Ey",     "(t,x,y -> x,y)");
setMemoryMap(prog, system, "Ey_out", "Ey", "(x,y   -> x,y)");

setMemorySpace(prog, system, "Hz", "Hz, Hz_out");
setMemoryMap(prog, system, "Hz", "Hz",     "(t,x,y -> x,y)");
setMemoryMap(prog, system, "Hz_out", "Hz", "(x,y   -> x,y)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

