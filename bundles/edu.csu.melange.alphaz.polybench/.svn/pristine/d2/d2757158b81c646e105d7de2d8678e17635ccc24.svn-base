prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/solvers/gramschmidt/gramschmidt_lessRed.ab");
system = "gramschmidt";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);


#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,1,0)", 	  "(k,x -> k,x)");        # => _sertemp
SerializeReduction(prog, "(0,2,0,1,0)",   "(k,j,a -> k,j,a)");    # => _serR

AddLocalUnique(prog, system, "Rloc", "(0,2,0)");

Split(prog, system, "Rloc", "RDiag", "{k,j|0<=k==j<N}");
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "Atemp",    "(k,i,j -> k, 0, i, j)");

setSpaceTimeMap(prog, system, "_sertemp", "(k,x   -> k, 1, x, 0)");
setSpaceTimeMap(prog, system, "temp",     "(k     -> k, 2, 0, 0)");
setSpaceTimeMap(prog, system, "RDiag",    "(k,j   -> k, 3, j, 0)");

setSpaceTimeMap(prog, system, "Q",        "(i,k   -> k, 4, i, 0)");

setSpaceTimeMap(prog, system, "_serR",    "(k,j,a -> k, 5, j, a)");
setSpaceTimeMap(prog, system, "Rloc",     "(k,j   -> k, 6, j, 0)");
setSpaceTimeMap(prog, system, "R",        "(k,j   -> k, 7, j, 0)");

setOrderingDimensions(prog, system, "1");

# Memory map
setMemorySpace(prog, system, "Atemp", "Atemp");
setMemoryMap(prog, system, "Atemp", "Atemp", "(k,i,j   -> i,j)");

setMemorySpace(prog, system, "R", "_sertemp, temp, RDiag, _serR, Rloc, R");
setMemoryMap(prog, system, "_sertemp", "R", "(k,x   -> k,k)");
setMemoryMap(prog, system, "temp", "R",     "(k     -> k,k)");
setMemoryMap(prog, system, "RDiag", "R",    "(k,j   -> k,k)");
setMemoryMap(prog, system, "_serR", "R",    "(k,j,a -> k,j)");
setMemoryMap(prog, system, "Rloc", "R",     "(k,j   -> k,j)");
setMemoryMap(prog, system, "R", "R",        "(k,j   -> k,j)");

setMemorySpace(prog, system, "Q", "Q");
setMemoryMap(prog, system, "Q", "Q", "(i,k -> i,k)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

