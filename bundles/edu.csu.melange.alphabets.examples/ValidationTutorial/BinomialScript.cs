prog = ReadAlphabets("../AlphabetsExamples/NewPascal/Binomial1DschedMem.1.ab");
system = "Binomial";
outDir = "../test-out/"+system;

AShow(prog);
CheckProgram(prog);
#PrintAST(prog);

generateWriteC(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
