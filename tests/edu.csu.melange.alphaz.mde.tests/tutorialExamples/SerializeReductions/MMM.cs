prog = ReadAlphabets("MMM.ab");
system = "MMM";

AShow(prog);
SerializeReduction(prog, system, "C", "(i,j,k->i,j,k)");
Normalize(prog);

AShow(prog);