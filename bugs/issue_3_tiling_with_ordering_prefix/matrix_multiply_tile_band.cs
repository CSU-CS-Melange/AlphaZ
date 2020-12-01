prog = ReadAlphabets("./matrix_product.ab");
system = "matrix_product";
AShow(prog);
CheckProgram(prog);

AShow(prog);

outDir = "mm/i_k_j_tile_band";

setSpaceTimeMap(prog, system, "temp_C", "(i,j,k->0, i,k, j)");
setSpaceTimeMap(prog, system, "C",      "(i,j,k->1, i,k, j)");

setOrderingDimensions(prog,system, "0");

## Mark parallel using ordering dimension					   
#setParallel(prog, system, "", 4);
#generateScheduledCode(prog, system, outDir);


options = createTiledCGOptionForScheduledC();
##setDefaultDTilerConfiguration(prog, system,  "sequential"); #
setBandForTiling(prog, system,       "band1", 1, "0",  0, 2);
setSubTilingWithinBand(prog, system, "band1", 1,  0, 2, "sequential");

#setSubTilingWithinBand(prog, system, "band1", 2,  0, 2, "sequential");
generateScheduledCode(prog, system, options, outDir);

#generateScheduledCode(prog, system, outDir);
#generateWrapper(prog, system, outDir);
#generateMakefile(prog, system, outDir);
#generateVerificationCode(prog, system, outDir);
