prog = ReadAlphabets("../AlphabetsExamples/nussinov.ab");
CheckProgram(prog);
system = "nussinov";
outDir = "../test-out/"+system;

Show(prog);
AShow(prog);
PrintAST(prog);

generateWriteC(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
