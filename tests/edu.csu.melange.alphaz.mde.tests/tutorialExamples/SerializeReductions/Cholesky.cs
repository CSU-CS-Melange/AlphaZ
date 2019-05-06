prog = ReadAlphabets("Cholesky.ab");
system = "Cholesky";

CheckProgram(prog);

AShow(prog);
SerializeReduction(prog, "0,0,0,1,0,0,1", "(i,j,k->i,j,k)");
SerializeReduction(prog, "0,0,0,3,0,0,1", "(i,j,k->i,j,k)");
Normalize(prog);

AShow(prog);


CheckProgram(prog);