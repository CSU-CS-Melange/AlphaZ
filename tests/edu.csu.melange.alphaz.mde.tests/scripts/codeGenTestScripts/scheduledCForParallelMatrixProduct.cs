prog = ReadAlphabets("../../testcases/matrix_product/matrix_product.ab");
system = "matrix_product";
outDir = "../../test-out/"+ system;
CheckProgram(prog);

#set the spacetimeMap for the subSystem first
setSpaceTimeMap(prog, system, "temp_C", "(i,j,k->0,i,j,k)");
setSpaceTimeMap(prog, system, "C", "(i,j,k->0,i,j,k)");
setOrderingDimensions(prog, system, 0);
setParallel(prog, system, "0", "1");
#setParallel(prog, system, "", "0,1");


generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
