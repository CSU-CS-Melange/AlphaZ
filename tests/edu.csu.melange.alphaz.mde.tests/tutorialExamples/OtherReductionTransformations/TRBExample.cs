#Transform Reduction Body
prog = ReadAlphabets("TRBExample.ab");
system = "TRBEx";

AShow(prog);

TransformReductionBody(prog, "0,0,0", "(i,j->i,i+j)");
Normalize(prog);

AShow(prog);