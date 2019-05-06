prog = ReadAlphabets("OSPGKT_hand.ab");
CheckProgram(prog);
system = "OSPGKT_hand";
outDir = "./src_gen/"+system+"/WriteC/";

generateWriteC(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
