prog=ReadAlphabets("./ReductionOneDimArrayNotation.ab");
system = "oneDim";
outDir = "./out/"+system;

#Show(prog);
#AShow(prog);
####PrintAST(prog);
CheckProgram(prog);
generateWriteC(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
