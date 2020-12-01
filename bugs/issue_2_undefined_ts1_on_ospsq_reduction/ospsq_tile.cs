prog = ReadAlphabets("ospsq_float.ab");
system = "ospsq_float";
base_folder = "./../../src/progs/ospsq_max/";
CheckProgram(prog);

NormalizeReduction(prog, system, "FTable");
AShow(prog);

setSpaceTimeMap(prog, system, "FTable",       "(i1,j1,i2,j2       -> M-i1,   j1,   j1,     i2,      j2,    0)");
setSpaceTimeMap(prog, system, "NR_FTable",    "(i1,j1,i2,j2,k1,k2 -> M-i1,   j1,   k1,     i2,      k2,    j2)", 
											  "(i1,j1,i2,j2       -> M-i1,   j1,   i1-1,   i2,      i2-1,  j2)");

outDir = "test";
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, 3, 5, "sequential"); #
#setBandForTiling(prog, system, "double_summation", 1, "0", 5,7);
#setSubTilingWithinBand(prog, system, "double_summation", 1, "sequential");

generateScheduledCode(prog, system, options, outDir);


#generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);
generateVerificationCode(prog, system, outDir);											  