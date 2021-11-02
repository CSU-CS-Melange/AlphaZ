prog = ReadAlphabets("../../../polybench-alpha-4.0/medley/deriche/deriche.ab");
system = "deriche";
outDir = "../../../test-out/DTiler/"+system;

CheckProgram(prog);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "alpha", "( -> 0, 0, 0)");
setSpaceTimeMap(prog, system, "k",     "( -> 1, 0, 0)");
setSpaceTimeMap(prog, system, "a1",    "( -> 2, 0, 0)");
setSpaceTimeMap(prog, system, "a5",    "( -> 3, 0, 0)");
setSpaceTimeMap(prog, system, "a2",    "( -> 4, 0, 0)");
setSpaceTimeMap(prog, system, "a6",    "( -> 5, 0, 0)");
setSpaceTimeMap(prog, system, "a3",    "( -> 6, 0, 0)");
setSpaceTimeMap(prog, system, "a7",    "( -> 7, 0, 0)");
setSpaceTimeMap(prog, system, "a4",    "( -> 8, 0, 0)");
setSpaceTimeMap(prog, system, "a8",    "( -> 9, 0, 0)");
setSpaceTimeMap(prog, system, "b1",    "( -> 10, 0, 0)");
setSpaceTimeMap(prog, system, "b2",    "( -> 11, 0, 0)");
setSpaceTimeMap(prog, system, "c1",    "( -> 12, 0, 0)");
setSpaceTimeMap(prog, system, "c2",    "( -> 13, 0, 0)");

setSpaceTimeMap(prog, system, "y1", "(i,j -> 14, i,j)");
setSpaceTimeMap(prog, system, "y2", "(i,j -> 15, i,j)");

setSpaceTimeMap(prog, system, "r", "(i,j -> 16, i,j)");

setSpaceTimeMap(prog, system, "z1", "(i,j -> 17, i,j)");
setSpaceTimeMap(prog, system, "z2", "(i,j -> 18, i,j)");

setSpaceTimeMap(prog, system, "Yout", "(i,j -> 19, i,j)");

setOrderingDimensions(prog, system, "0");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

