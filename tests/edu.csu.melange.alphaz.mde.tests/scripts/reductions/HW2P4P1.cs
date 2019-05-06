prog = ReadAlphabets("../../alphabets/SRexamples/HW2P4P1.ab");
system = "HW2P4P1";
AShow(prog);
CheckProgram(prog);
NormalizeReduction(prog);
AShow(prog);

SimplifyingReduction(prog, system, "NR_m", "-1,0,0");


Normalize(prog);
AShow(prog);
CheckProgram(prog);