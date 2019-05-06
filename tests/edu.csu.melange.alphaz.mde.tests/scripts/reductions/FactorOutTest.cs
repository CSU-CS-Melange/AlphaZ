prog = ReadAlphabets("../../alphabets/SRexamples/FactorizeExample.ab");
AShow(prog);
FactorOutFromReduction(prog, "0,0,0,0,0");
Normalize(prog);
AShow(prog);