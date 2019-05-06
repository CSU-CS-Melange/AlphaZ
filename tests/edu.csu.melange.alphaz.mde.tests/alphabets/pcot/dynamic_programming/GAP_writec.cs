system = "GAPSer";
outDir = "./src_gen/"+system+"/WriteC";

prog = ReadAlphabets("GAP.ab");
CheckProgram(prog);
generateWrapper(prog, system, outDir);
#generateMakefile(prog, system, outDir);
generateWriteC(prog, system, outDir);
