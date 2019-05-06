#prog = ReadAlphabets("../AlphabetsExamples/RNA/osph.ab");
prog = ReadAlphabets("osp.ab");
system = "osp";
CheckProgram(prog);
#system = "osph";
#system2= "osphs";
system2= "osps";
outDir = "test-out/"+system2;

#NormalizeReduction(prog);
#AShow(prog);
#P = BuildPRDG(prog,system,1);
#L = PlutoScheduler(P);
#setSchedule(prog,system,L);
#listSpaceTimeMaps(prog, system);
#setSpaceTimeMap(prog, system, "C", "(i, j -> i, j, 0)");
#setSpaceTimeMap(prog, system, "Cacc", "(i,j,k->i+N, j+N, - k+N)");

setSpaceTimeMap(prog, system, "FTable", "(i, j -> -i, j, 0, 3)");
#setSpaceTimeMap(prog, system, "NR_FTable", "(i,j->0,i,j,2)");
setSpaceTimeMap(prog, system, "NR_FTable", "(i,j,k->i,j,k)");
#setSpaceTimeMap(prog, system, "NR_FTable_reduce1_result", "(i,j->0,i,j,3)");

#generateWriteC(prog, system, outDir);
generateScheduledCode(prog, system, outDir);
#generateWrapper(prog, system, outDir);
#generateMakefile(prog, system, outDir);