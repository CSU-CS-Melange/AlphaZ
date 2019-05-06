prog = ReadAlphabets("MMLikeExample.ab");
system = "MMLikeExample";

AShow(prog);

ReductionDecomposition(prog, "0,0,0", "(i,k->i)", "(i,j,k->i,k)");
FactorOutFromReduction(prog, "0,0,0,0,0,0,0");
NormalizeReduction(prog);
RenameVariable(prog, system, "NR_Y", "Z");

SimplifyingReduction(prog, system, "Z", "-1, 0, 0");
Simplify(prog);
Normalize(prog);

ASave(prog, system+".out.ab");
