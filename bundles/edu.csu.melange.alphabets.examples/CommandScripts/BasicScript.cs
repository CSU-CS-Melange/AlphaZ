prog = ReadAlphabets("../AlphabetsExamples/MatMult/MM.ab");
system = "MM";
outDir = "../test-out/"+system;

Show(prog);
AShow(prog);
PrintAST(prog);

generateWriteC(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
