#Merge Reductions
prog = ReadAlphabets("MRExample.ab");
system = "MREx";

AShow(prog);

MergeReductions(prog, "0,0,0");
Normalize(prog);

AShow(prog);