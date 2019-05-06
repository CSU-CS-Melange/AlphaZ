prog = ReadAlphabets("MotivatingExample.ab");
system = "MotivatingExample";

AShow(prog);

ReductionDecomposition(prog, "0,0,0", "(i,x->i)", "(i,j,k->i,j+k)");
NormalizeReduction(prog);
RenameVariable(prog, system, "NR_Y", "Z");
SimplifyingReduction(prog, system, "Z", "1,0,0");
Simplify(prog);
Normalize(prog);

ASave(prog, system+".out.ab");
