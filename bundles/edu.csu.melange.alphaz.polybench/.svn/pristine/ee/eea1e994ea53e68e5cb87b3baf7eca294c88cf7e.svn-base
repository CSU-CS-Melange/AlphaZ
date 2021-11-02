prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/blas/gemver/gemver.ab");
system = "gemver";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);


#PrintAST(prog, system);

AddLocal(prog, system, "x1", "(0,1,0,0)");
Simplify(prog, system);

#PrintAST(prog, system);


# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,3,0,1)", "(i,j-> i,j)");   # => _serx
SerializeReduction(prog, "(0,2,0,1)", "(i,j-> i,j)");     # => _serz
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "Aout", "(i,j -> 0, i,j)");
setSpaceTimeMap(prog, system, "_serx1", "(i,j -> 1,i,j)");
setSpaceTimeMap(prog, system, "x1", "(i -> 1,i,N)");
setSpaceTimeMap(prog, system, "x", "(i -> 2,i,0)");
setSpaceTimeMap(prog, system, "_serw", "(i,j -> 3,i,j)");
setSpaceTimeMap(prog, system, "w", "(i -> 3,i,N)");

setOrderingDimensions(prog, system, 0);

# Memory map
setMemorySpace(prog, system, "x", "_serx1, x, x1");
setMemoryMap(prog, system, "_serx1", "x", "(i,j->i)");
setMemoryMap(prog, system, "x", "x", "(i->i)");
setMemoryMap(prog, system, "x1", "x", "(i->i)");


setMemorySpace(prog, system, "w", "_serw, w");
setMemoryMap(prog, system, "_serw", "w", "(i,j->i)");
setMemoryMap(prog, system, "w", "w", "(i->i)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");



# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

