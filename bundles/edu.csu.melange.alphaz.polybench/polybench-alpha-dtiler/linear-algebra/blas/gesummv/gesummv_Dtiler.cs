prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/blas/gesummv/gesummv.ab");
system = "gesummv";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0,0,1)", "(i,j-> i,j)");   # => _sery
SerializeReduction(prog, "(0,0,0,1,1)", "(i,j-> i,j)");     # => __sery
Simplify(prog, system);

AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_sery",  "(i,j -> i, 0, j, 0)");
setSpaceTimeMap(prog, system, "__sery", "(i,j -> i, 0, j, 1)");
setSpaceTimeMap(prog, system, "y",      "(i   -> i, 1, 0, 0)");
setOrderingDimensions(prog, system, "1,3");


# Memory map
setMemorySpace(prog, system, "temp", "_sery");
setMemoryMap(prog, system, "_sery", "temp", "(i,j->i)");

setMemorySpace(prog, system, "y", "__sery, y");
setMemoryMap(prog, system, "__sery", "y", "(i,j->i)");
setMemoryMap(prog, system, "y", "y", "(i->i)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

