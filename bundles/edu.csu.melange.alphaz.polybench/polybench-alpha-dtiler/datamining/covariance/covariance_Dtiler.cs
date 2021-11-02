prog = ReadAlphabets("../../../polybench-alpha-4.0/datamining/covariance/covariance.ab");
system = "covariance";
outDir = "../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0,0)", "(j,i   -> j,i)");    # => _sermean
SerializeReduction(prog, "(0,1,0,0)", "(x,y,k -> x,y,k)");  # => _sercov
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_sermean", "(j,i   -> 0, j, 0, 0, i)");
setSpaceTimeMap(prog, system, "mean",     "(j     -> 0, j, 0, 1, 0)");
setSpaceTimeMap(prog, system, "_sercov",  "(x,y,k -> 1, x, y, 0, k)");
setSpaceTimeMap(prog, system, "cov",      "(x,y   -> 1, x, y, 1, 0)");
setOrderingDimensions(prog, system, "0,3");


# Memory map
setMemorySpace(prog, system, "mean", "_sermean, mean");
setMemoryMap(prog, system, "_sermean", "mean", "(j,i -> j)");
setMemoryMap(prog, system, "mean", "mean",     "(j   -> j)");

setMemorySpace(prog, system, "cov", "_sercov, cov");
setMemoryMap(prog, system, "_sercov", "cov", "(x,y,k -> x,y)");
setMemoryMap(prog, system, "cov", "cov",     "(x,y   -> x,y)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

