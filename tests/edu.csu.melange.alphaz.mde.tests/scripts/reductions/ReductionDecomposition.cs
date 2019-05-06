prog = ReadAlphabets("../../alphabets/SRexamples/DecomposeExample.ab");
Show(prog);
ReductionDecomposition(prog, "(0,0,0)", "(j->)", "(i,j->j)");
Show(prog);

AShow(prog);
