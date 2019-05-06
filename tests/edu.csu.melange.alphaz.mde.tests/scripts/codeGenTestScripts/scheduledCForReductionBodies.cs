prog = ReadAlphabets("../../testcases/matrix_product_withReduce/matrix_product_withReduce.ab");
system = "matrix_product_withReduce";
outDir = "../../test-out/"+ system;
CheckProgram(prog);

AShow(prog);
#set the spacetimeMap for the subSystem first
setSpaceTimeMap(prog, system, "C", "(i,j,k->i,j,k)");
#setMemoryMap(prog, system, "C", "C", "(i,j->i,j)");

generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
