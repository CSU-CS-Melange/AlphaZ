prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/kernels/bicg/bicg.ab");
system = "bicg";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0)", "(i,j-> i,j)");    # => _serq
SerializeReduction(prog, "(0,1,0)", "(j,i-> j,i)");    # => _sers
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serq", "(i,j -> i, 0, j, 0)");
setSpaceTimeMap(prog, system, "_sers", "(j,i -> j, 0, i, 1)");
setSpaceTimeMap(prog, system, "q",     "(i   -> i, 1, 0, 0)");
setSpaceTimeMap(prog, system, "s",     "(j   -> j, 1, 0, 0)");
setOrderingDimensions(prog, system, "1,3");


# Memory map
setMemorySpace(prog, system, "q", "_serq, q");
setMemoryMap(prog, system, "_serq", "q", "(i,j->i)");
setMemoryMap(prog, system, "q", "q", "(i->i)");

setMemorySpace(prog, system, "s", "_sers, s");
setMemoryMap(prog, system, "_sers", "s", "(j,i->j)");
setMemoryMap(prog, system, "s", "s", "(j->j)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

