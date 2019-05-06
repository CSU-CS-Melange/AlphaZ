#Split Reduction Body
prog = ReadAlphabets("SRBExample.ab");
system = "SRBEx";

AShow(prog);

SplitReductionBody(prog, "0,0,0", "{i,j,k|2k>=N}");
Normalize(prog);

AShow(prog);