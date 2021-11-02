prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/kernels/atax/atax.ab");
system = "atax";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0)", "(i,j-> i,j)");    # => _sertemp
SerializeReduction(prog, "(0,1,0)", "(k,i-> k,i)");    # => _sery
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_sertemp", "(i,j -> i, 0, j)");
setSpaceTimeMap(prog, system, "temp",     "(i   -> i, 1, 0)");
setSpaceTimeMap(prog, system, "_sery",    "(k,i -> k, 2, i)");
setSpaceTimeMap(prog, system, "y",        "(k   -> k, 3, 0)");
setOrderingDimensions(prog, system, "1");


# Memory map
setMemorySpace(prog, system, "temp", "_sertemp, temp");
setMemoryMap(prog, system, "_sertemp", "temp", "(i,j->i)");
setMemoryMap(prog, system, "temp", "temp", "(i->i)");

setMemorySpace(prog, system, "y", "_sery, y");
setMemoryMap(prog, system, "_sery", "y", "(k,i->k)");
setMemoryMap(prog, system, "y", "y", "(k->k)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

