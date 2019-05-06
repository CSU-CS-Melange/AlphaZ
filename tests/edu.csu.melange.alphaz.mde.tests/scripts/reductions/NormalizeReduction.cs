prog = ReadAlphabets("../../alphabets/SRexamples/NRExample.ab");
AShow(prog);
NormalizeReduction(prog);
AShow(prog);

prog = ReadAlphabets("../../alphabets/SRexamples/NRExample.ab");
PrintAST(prog);
AShow(prog);
NormalizeReduction(prog, "0,0,0,1");
AShow(prog);
