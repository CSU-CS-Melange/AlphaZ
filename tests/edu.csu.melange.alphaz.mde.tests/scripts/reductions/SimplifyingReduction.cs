prog = ReadAlphabets("../../alphabets/SRexamples/SRExample.ab");
AShow(prog);
system = "SREx";
SimplifyingReduction(prog,system, "Y", "-1,0,0");
AShow(prog);

#prog = ReadAlphabets("../../alphabets/SRexamples/SRExample.ab");
#PrintAST(prog);
#SimplifyingReduction(prog, "0,0,0", "-1,0,0");
#AShow(prog);
