prog = ReadAlphabets("OSPGKT_hand.ab");
CheckProgram(prog);
system = "OSPGKT_hand";
#outDir = "./src_gen/"+system+"/WriteC/";

prdg = BuildPRDG(prog, system);
schedules = PlutoScheduler(prdg);
#setSchedule(prog, system, schedules);
