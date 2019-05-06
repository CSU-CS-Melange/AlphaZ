prog = ReadAlphabets("PrefixSum.ab");
system = "PrefixSum";

AShow(prog);

SimplifyingReduction(prog, system, "X", "-1, 0");
Simplify(prog);
Normalize(prog);

ASave(prog, system+".out.ab");
