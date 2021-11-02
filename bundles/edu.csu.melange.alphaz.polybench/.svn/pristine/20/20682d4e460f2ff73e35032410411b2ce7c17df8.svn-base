prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/solvers/trisolv/trisolv.ab");
system = "trisolv";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0,1,0,0,1)",  "(i,j -> i,j)");    # => _serx
Simplify(prog, system);

AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serx", "(i,j -> i, 0, j)");
setSpaceTimeMap(prog, system, "x",     "(i   -> i, 1, 0)");

setOrderingDimensions(prog, system, "1");



# Memory map
setMemorySpace(prog, system, "temp", "_serx");
setMemoryMap(prog, system, "_serx", "temp", "(i,j -> i)");

setMemorySpace(prog, system, "x", "x");
setMemoryMap(prog, system, "x", "x", "(i -> i)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

