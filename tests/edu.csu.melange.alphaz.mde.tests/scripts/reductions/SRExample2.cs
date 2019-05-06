prog = ReadAlphabets("../../alphabets/SRexamples/SRExample2.ab");
system = "SRExample2";
outDir = "../../test-out/"+system;

#PrintAST(prog);

AShow(prog);
ReductionDecomposition(prog, "0,0,0", "(i,j->i)", "(i,j,k->i,j)");
#PrintAST(prog);
FactorOutFromReduction(prog, "0,0,0,0,0,0,0,0");

Normalize(prog);
AShow(prog);

NormalizeReduction(prog, system, "Y");
SimplifyingReduction(prog, system, "NR_Y", "1,0,0");
Simplify(prog);
Normalize(prog);

AShow(prog);

generateWriteC(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
