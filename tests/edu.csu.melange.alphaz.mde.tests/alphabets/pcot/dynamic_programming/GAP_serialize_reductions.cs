system = "GAP";
outDir = "./src_gen/"+system+"/WriteC";


prog = ReadAlphabets("GAP.ab");
CheckProgram(prog);

SerializeReduction(prog, system,"E","(i,j,q->i,j,q)");
SerializeReduction(prog, system,"F","(i,j,p->i,j,p)");

Normalize(prog);

AShow(prog, system);