prog=ReadAlphabets("./reduction_bug.ab");
sys="fillMatrices1_unafold";
outDir="./code";

#Normalize(prog);

CheckProgram(prog);

generateWriteC(prog,sys,outDir);
#generateMakefile(prog,sys,outDir);
#generateWrapper(prog,sys,outDir);
