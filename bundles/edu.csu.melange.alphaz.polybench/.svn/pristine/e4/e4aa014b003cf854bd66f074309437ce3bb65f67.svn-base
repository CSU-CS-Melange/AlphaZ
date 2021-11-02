prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/kernels/doitgen/doitgen.ab");
system = "doitgen";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0)", "(r, q, p, s -> r, q, p, s)");    # => _serAout
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serAout", "(r,q,p,s -> r, q, 0, p, s)");
setSpaceTimeMap(prog, system, "Aout",     "(r,q,p   -> r, q, 1, p, 0)");
setOrderingDimensions(prog, system, "2");


# Memory map
setMemorySpace(prog, system, "Aout", "_serAout, Aout");
setMemoryMap(prog, system, "_serAout", "Aout", "(r, q, p, s -> r, q, p)");
setMemoryMap(prog, system, "Aout", "Aout",     "(r, q, p    -> r, q, p)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

