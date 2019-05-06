system = "pfunc8";
program = ReadAlphabets("../../alphabets/others/"+system + ".ab");
outDir = "./" + system + "P1";

AShow(program);
Normalize(program);
AShow(program);

CheckProgram(program);

#generateMakefile(program, system, outDir);
#generateWrapper(program, system, outDir);
#generateWriteC(program, system, outDir);