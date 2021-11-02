prog = ReadAlphabets("../../../polybench-alpha-4.0/medley/floyd-warshall/floyd-warshall.ab");
system = "floyd-warshall";
outDir = "../../../test-out/DTiler/"+system;

CheckProgram(prog);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "paths",        "(k,i,j -> 0, k, i, j)");
setSpaceTimeMap(prog, system, "shortestPaths","(i,j   -> 1, i, j, 0)");

setOrderingDimensions(prog, system, "0");


# Memory map
setMemorySpace(prog, system, "paths", "paths, shortestPaths");
setMemoryMap(prog, system, "paths", "paths", "(k,i,j->i,j)");
setMemoryMap(prog, system, "shortestPaths", "paths", "(i,j->i,j)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

