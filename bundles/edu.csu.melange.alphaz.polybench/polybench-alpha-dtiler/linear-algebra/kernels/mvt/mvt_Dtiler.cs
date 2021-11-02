prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/kernels/mvt/mvt.ab");
system = "mvt";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0,1)", "(i,j -> i,j)");    # => _serx1out
SerializeReduction(prog, "(0,1,0,1)", "(i,j -> i,j)");    # => _serx2out
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serx1out", "(i,j -> 0, i, j)");
setSpaceTimeMap(prog, system, "x1out",     "(i   -> 0, i, N)");
setSpaceTimeMap(prog, system, "_serx2out", "(i,j -> 1, i, j)");
setSpaceTimeMap(prog, system, "x2out",     "(i   -> 1, i, N)");
setOrderingDimensions(prog, system, "0");


# Memory map
setMemorySpace(prog, system, "x1out", "_serx1out, x1out");
setMemoryMap(prog, system, "_serx1out", "x1out", "(i,j -> i)");
setMemoryMap(prog, system, "x1out", "x1out",     "(i-> i)");

setMemorySpace(prog, system, "x2out", "_serx2out, x2out");
setMemoryMap(prog, system, "_serx2out", "x2out", "(i,j -> i)");
setMemoryMap(prog, system, "x2out", "x2out",     "(i-> i)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

