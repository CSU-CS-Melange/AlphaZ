prog = ReadAlphabets("bug.ab");
system = "FS";
outDir = "./out/"+system;
CheckProgram(prog);
#setSpaceTimeMap(prog, system, "X",  "(j->2j+3)");
setSpaceTimeMap(prog, system, "Y",  "(j->2j+1)");
#setParallel(prog, system, "", "1");
 
generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);

#[N] -> { [j] -> [2*j + 1] }
#{j|j>=0 && -j+N-1>=0 && N-2>=0}
#Matrice to inverse 
#1	0	0	
#0	2	1	
#
#snf computed
#1	0	
#0	2	
