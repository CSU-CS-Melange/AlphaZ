prog = ReadAlphabets("bug.ab");
system = "FS";
outDir = "./out/"+system;
CheckProgram(prog);
setSpaceTimeMap(prog, system, "Acc",  "(i,j->i+j,j)");
setSpaceTimeMap(prog, system, "x",  "(i->2N,i)");
#setParallel(prog, system, "", "1");
 
generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);