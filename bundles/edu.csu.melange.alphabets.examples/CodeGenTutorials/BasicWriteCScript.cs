prog = ReadAlphabets("../AlphabetsExamples/MatMult/MM.ab");
system = "MM";
#prog = ReadAlphabets("../AlphabetsExamples/MatMult/matrix_product.ab");
#system = "matrix_product";
outDir = "../test-out/WriteC/"+system;
CheckProgram(prog);

Show(prog);
AShow(prog);
PrintAST(prog);

generateWriteC(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
